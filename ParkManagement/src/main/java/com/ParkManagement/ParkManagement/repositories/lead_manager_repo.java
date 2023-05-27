package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Lead_manager;

import java.util.List;

public interface lead_manager_repo {
    int insertLead(Lead_manager leadManager);
    int updateLead(String update , String reference , Object[] params);
    int deleteLead(String reference,Object[] params);
    List<Lead_manager> selectLead(String reference,Object[] params);
}
