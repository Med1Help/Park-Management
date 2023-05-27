package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class manager_service implements manager_repo{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertManager(Manager manager) {
        // TO-DO query sequence to set Id
        int id = 6;
        manager.setId(id);
        String sql = "INSERT INTO managers Values(?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,manager.getId(),manager.getName(),manager.getE_mail(),manager.getLead_id(),manager.getSecteur(),manager.getPhone_number());
        return result;
    }

    @Override
    public int updateManager(String update, String reference, Object[] params) {
        String sql = "UPDATE managers SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteManager(String reference, Object[] params) {
        String sql = "DELETE FROM managers WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Lead_manager> selectManager(String reference, Object[] params) {
        String sql = "SELECT * From managers WHERE "+reference+" =  "+ Arrays.stream(params).findFirst().toString();
        List<Lead_manager> leadManagers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lead_manager.class));
        return leadManagers;
    }

    public List<Manager> selectAllManager() {
        String sql = "SELECT * From managers";
        List<Manager> managers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Manager.class));
        return managers;
    }
}
