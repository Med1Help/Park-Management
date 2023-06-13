package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Car;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Sequence;
import com.ParkManagement.ParkManagement.repositories.car_repo;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class car_service implements car_repo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int getId(){
        String sql = "select car_id_seq.nextval from dual";
        Sequence seq = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Sequence.class));
        System.out.println(seq.getNextVal());
        return seq.getNextVal();
    }
    @Override
    public int insertCar(Car car,String sec) {
        // TO-DO query sequence to set Id
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return 0;
        int id = this.getId();
        car.setId(id);
        String sql = "INSERT INTO car"+sec+" Values(?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,id,car.getMatricule(),car.getPermition(),car.getVisite(),car.getAssurance(),car.getVignette(),car.getSecteur());
        return result;
    }

    @Override
    public int updateCar(String update, String reference, Object[] params) {
        String sql = "UPDATE cars SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteCar(String reference, Object[] params) {
        String sql = "DELETE FROM cars WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Car> selectCar(String reference, Object[] params) {
        String sql = "SELECT * From cars WHERE "+reference+" =  "+ Arrays.stream(params).findFirst().toString();
        List<Car> cars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
        return cars;
    }

    public List<Car> selectAllCar(String sec) {
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return new ArrayList<>();
        String sql = "SELECT * From car"+sec;
        List<Car> cars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
        return cars;
    }
}
