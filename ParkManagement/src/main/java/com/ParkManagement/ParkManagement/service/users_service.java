package com.ParkManagement.ParkManagement.service;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.User;
import com.ParkManagement.ParkManagement.repositories.manager_repo;
import com.ParkManagement.ParkManagement.repositories.users_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
@Service
public class users_service implements users_repo{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @Override
    public int insertUsers(User user) {
        // TO-DO query sequence to set Id
        String sql = "INSERT INTO users Values(?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,user.getId(),user.getName(),user.getE_mail(),user.getRole(),user.getPassword(),user.getSecteur());
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
    public User selectUsers(String reference, Object[] params) {
        String sql = "SELECT * From users WHERE "+reference+" =  '"+ params[0]+"'";
        User user = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class)).get(0);
        return user;
    }
    public List<User> selectAllUsers() {
        String sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        return users;
    }

    public String authenticate(User user) throws Exception{
        System.out.println("authentication ... ");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getE_mail(),user.getPassword(),user.getAuthorities()
                )
        );
        User authenticated = this.selectUsers("e_mail",new Object[]{user.getE_mail()});
        System.out.println(authenticated);
        String jwtoken = jwtService.genToken(new HashMap<>(),authenticated);
        return jwtoken;
    }

}
