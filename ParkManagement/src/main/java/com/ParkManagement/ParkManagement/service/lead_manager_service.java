package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.repositories.lead_manager_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class lead_manager_service implements lead_manager_repo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertLead(Lead_manager leadManager) {
        // TO-DO query sequence to set Id
        int id = 6;
        leadManager.setId(id);
        String sql = "INSERT INTO lead_manager Values(?,?,?,?)";
        int result = jdbcTemplate.update(sql,leadManager.getId(),leadManager.getName(),leadManager.getE_mail(),leadManager.getSecteur());
        return result;
    }

    @Override
    public int updateLead(String update, String reference, Object[] params) {
        String sql = "UPDATE lead_manager SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteLead(String reference, Object[] params) {
        String sql = "DELETE FROM lead_manager WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Lead_manager> selectLead(String reference, Object[] params) {
        String sql = "SELECT * From lead_manager WHERE "+reference+" =  "+Arrays.stream(params).findFirst().toString();
        List<Lead_manager> leadManagers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lead_manager.class));
        return leadManagers;
    }

    public List<Lead_manager> selectAllLeads() {
        String sql = "SELECT * From lead_manager";
        List<Lead_manager> leadManagers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lead_manager.class));
        return leadManagers;
    }
}
