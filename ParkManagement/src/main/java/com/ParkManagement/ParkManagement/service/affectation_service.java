package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Affectation;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Sequence;
import com.ParkManagement.ParkManagement.repositories.affectation_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class affectation_service implements affectation_repo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int getId(){
        String sql = "select affect_id_seq.nextval from dual";
        Sequence seq = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Sequence.class));
        System.out.println(seq.getNextVal());
        return seq.getNextVal();
    }
    @Override
    public int insertAffectation(Affectation affect) {
        // TO-DO query sequence to set Id
        int id = this.getId();
        String sql = "INSERT INTO affectation Values(?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,id,affect.getId_car(),affect.getId_rider(),affect.getDate_debut(),affect.getDate_fin(),affect.getSecteur());
        return result;
    }

    @Override
    public int updateAffectation(String update, String reference, Object[] params) {
        String sql = "UPDATE affectation SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteAffectation(String reference, Object[] params) {
        String sql = "DELETE FROM affectation WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Affectation> selectAffectation(String reference, Object[] params) {
        String sql = "SELECT * From affectation WHERE "+reference+" = ? ";
        List<Affectation> affectations= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Affectation.class),params);
        return affectations;
    }

    public List<Affectation> selectAllAffectation(String sec) {
        String sql = "select * from affectation where secteur='sec"+sec+"'";
        List<Affectation> affectations = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Affectation.class));
        System.out.print("affectations of "+sec+" : "+affectations);
        return affectations;
    }
    public boolean checkAffectationValidity(int idAffect){
        Object[] params     = {idAffect};
        Boolean response    = false;
        Affectation affect  = this.selectAffectation("id",params).get(0);
        if(affect.getDate_debut().before(new Date()) && affect.getDate_fin().after(new Date())) response = true;
        return response;
    }
}
