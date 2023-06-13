package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Car;
import com.ParkManagement.ParkManagement.models.User;

import java.util.List;

public interface users_repo {
    int insertUsers(User user);
    int updateUsers(String update , String reference , Object[] params);
    int deleteUsers(String reference,Object[] params);
    User selectUsers(String reference, Object[] params);
}
