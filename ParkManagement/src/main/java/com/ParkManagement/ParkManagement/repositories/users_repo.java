package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Car;
import com.ParkManagement.ParkManagement.models.Users;

import java.util.List;

public interface users_repo {
    int insertUsers(Users user);
    int updateUsers(String update , String reference , Object[] params);
    int deleteUsers(String reference,Object[] params);
    List<Users> selectUsers(String reference, Object[] params);
}
