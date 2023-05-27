package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Users;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import com.ParkManagement.ParkManagement.repositories.users_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class users_service implements users_repo {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertUsers(Users user) {
        // TO-DO query sequence to set Id
        int id = 6;
        user.setId(id);
        String sql = "INSERT INTO users Values(?,?,?,?)";
        int result = jdbcTemplate.update(sql,user.getId(),user.getName(),user.getE_mail(),user.getRole());
        return result;
    }

    @Override
    public int updateUsers(String update, String reference, Object[] params) {
        String sql = "UPDATE users SET "+update+"= ? WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public int deleteUsers(String reference, Object[] params) {
        String sql = "DELETE FROM users WHERE "+reference+"= ?";
        int result = jdbcTemplate.update(sql,params);
        return result;
    }

    @Override
    public List<Users> selectUsers(String reference, Object[] params) {
        String sql = "SELECT * From users WHERE "+reference+" =  "+ Arrays.stream(params).findFirst().toString();
        List<Users> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Users.class));
        return users;
    }
    public List<Users> selectAllUsers() {
        String sql = "SELECT * From users";
        List<Users> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Users.class));
        return users;
    }
}
