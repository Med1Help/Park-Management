package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Sequence;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class manager_service implements manager_repo{
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int getId(){
        String sql = "select manager_id_seq.nextval from dual";
        Sequence seq = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Sequence.class));
        System.out.println(seq.getNextVal());
        return seq.getNextVal();
    }
    @Override
    public int insertManager(Manager manager,String sec) {
        // TO-DO query sequence to set Id
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return 0;
        int id = this.getId();
        String sql = "INSERT INTO manager"+sec+" Values(?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,id,manager.getName(),manager.getE_mail(),manager.getLead_id(),manager.getSecteur(),manager.getPhone_number());
        return result;
    }

    @Override
    public int updateManager(String update, String reference, Object[] params,String sec) {
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return 0;
        String sql = "UPDATE manager"+sec+" SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteManager(String reference, Object[] params,String sec) {
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return 0;
        String sql = "DELETE FROM manager"+sec+" WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Manager> selectManager(String reference, Object[] params,String sec) {
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return new ArrayList<>();
        String sql = "SELECT * From manager"+sec+" WHERE "+reference+" =  '"+ params[0].toString()+"'";
        List<Manager> manager = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Manager.class));
        return manager;
    }

    public List<Manager> selectAllManager(String sec) {
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return new ArrayList<>();
        String sql = "SELECT * From manager"+sec;
        List<Manager> managers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Manager.class));
        return managers;
    }
}
