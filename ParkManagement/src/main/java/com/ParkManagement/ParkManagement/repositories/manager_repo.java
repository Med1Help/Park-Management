package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;

import java.util.List;

public interface manager_repo {
    int insertManager(Manager manager);
    int updateManager(String update , String reference , Object[] params);
    int deleteManager(String reference,Object[] params);
    List<Lead_manager> selectManager(String reference,Object[] params);
}
