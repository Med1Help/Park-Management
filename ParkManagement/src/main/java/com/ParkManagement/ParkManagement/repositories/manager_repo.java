package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;

import java.util.List;

public interface manager_repo {
    int insertManager(Manager manager,String sec);
    int updateManager(String update , String reference , Object[] params,String sec);
    int deleteManager(String reference,Object[] params,String sec);
    List<Manager> selectManager(String reference,Object[] params,String sec);
}
