package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Rider;

import java.util.List;

public interface rider_repo {

    int insertRider(Rider rider,String sec);
    int updateRider(String update , String reference , Object[] params);
    int deleteRider(String reference,Object[] params);
    List<Rider> selectRider(String reference, Object[] params);
}
