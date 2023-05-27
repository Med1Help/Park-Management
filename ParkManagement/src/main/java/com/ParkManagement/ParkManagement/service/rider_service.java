package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Rider;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import com.ParkManagement.ParkManagement.repositories.rider_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class rider_service implements rider_repo{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertRider(Rider rider) {
        // TO-DO query sequence to set Id
        int id = 6;
        rider.setId(id);
        String sql = "INSERT INTO riders Values(?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,rider.getId(),rider.getName(),rider.getE_mail(),rider.getManager_id(),rider.getSecteur(),rider.getPermis(),rider.getPoints(),rider.getPhone_number());
        return result;
    }

    @Override
    public int updateRider(String update, String reference, Object[] params) {
        String sql = "UPDATE riders SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteRider(String reference, Object[] params) {
        String sql = "DELETE FROM riders WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Rider> selectRider(String reference, Object[] params) {
        String sql = "SELECT * From riders WHERE "+reference+" =  "+ Arrays.stream(params).findFirst().toString();
        List<Rider> riders = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rider.class));
        return riders;
    }

    public List<Rider> selectAllRider() {
        String sql = "SELECT * From riders";
        List<Rider> riders = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rider.class));
        return riders;
    }
}
