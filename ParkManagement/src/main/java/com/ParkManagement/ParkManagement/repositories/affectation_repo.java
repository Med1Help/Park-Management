package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Affectation;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;

import java.util.List;

public interface affectation_repo {

    int insertAffectation(Affectation affectation);
    int updateAffectation(String update , String reference , Object[] params);
    int deleteAffectation(String reference,Object[] params);
    List<Affectation> selectAffectation(String reference, Object[] params);

}
