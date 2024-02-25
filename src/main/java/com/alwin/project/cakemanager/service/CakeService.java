/**
 * 
 */
package com.alwin.project.cakemanager.service;

import java.util.List;

import com.alwin.project.cakemanager.dto.CakeDTO;
import com.alwin.project.cakemanager.model.Cake;
import com.alwin.project.cakemanager.model.UserInfo;


/**
 * 
 */


public interface CakeService {
	
	Cake addCake(Cake cake);

    List<Cake> getAllCakes();

    Cake getCake(Long id);

    void deleteCake(Long id);

	Cake updateCakeById(Long id, Cake updatedCake);

	void updateCaketitle(Long id, CakeDTO cakeDTO);
	
	//public String addUser(UserInfo userInfo);
}