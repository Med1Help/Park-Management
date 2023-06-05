package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Rider;
import com.ParkManagement.ParkManagement.models.Sequence;
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
    public int getId(){
        String sql = "select rider_id_seq.nextval from dual";
        Sequence seq = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Sequence.class));
        System.out.println(seq.getNextVal());
        return seq.getNextVal();
    }
    @Override
    public int insertRider(Rider rider,String sec) {
        // TO-DO query sequence to set Id
        if(!(sec.equals("1")|sec.equals("2")|sec.equals("3")))return 0;
        int id = this.getId();
        rider.setId(id);
        String sql = "INSERT INTO rider"+sec+" Values(?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,id,rider.getName(),rider.getE_mail(),rider.getManager_id(),rider.getSecteur(),rider.getPermis(),rider.getPoints(),rider.getPhone_number());
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

    public List<Rider> selectAllRider(String sec) {
        String sql = "SELECT * From rider"+sec;
        List<Rider> riders = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rider.class));
        return riders;
    }
}
