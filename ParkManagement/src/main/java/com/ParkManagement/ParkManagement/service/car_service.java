package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Car;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.repositories.car_repo;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class car_service implements car_repo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertCar(Car car) {
        // TO-DO query sequence to set Id
        int id = 6;
        car.setId(id);
        String sql = "INSERT INTO cars Values(?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,car.getId(),car.getMatricule(),car.getPermition(),car.getVisite(),car.getAssurance(),car.getVignette(),car.getSecteur());
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

    public List<Car> selectAllCar() {
        String sql = "SELECT * From cars";
        List<Car> cars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
        return cars;
    }
}
