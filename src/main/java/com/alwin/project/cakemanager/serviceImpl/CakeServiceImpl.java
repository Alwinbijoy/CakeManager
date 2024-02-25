/**
 * 
 */
package com.alwin.project.cakemanager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.alwin.project.cakemanager.dto.CakeDTO;
import com.alwin.project.cakemanager.model.Cake;
import com.alwin.project.cakemanager.model.UserInfo;
import com.alwin.project.cakemanager.repository.CakeRepository;
import com.alwin.project.cakemanager.service.CakeService;


/**
 * 
 */
@Service
public class CakeServiceImpl implements CakeService {
	
	@Autowired
	private CakeRepository cakeRepository;
	
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public Cake addCake(Cake cake) {
		return cakeRepository.save(cake);
	}

	@Override
	public List<Cake> getAllCakes() {
		return cakeRepository.findAll();
	}

	@Override
	public Cake getCake(Long id) {
		/* checking CAKE is in database or not */
	        Cake cake = cakeRepository
	                .findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid CAKE Id:" + id));
	        return cake;
	}

	

	@Override
	public Cake updateCakeById(Long id, Cake updatedCake) {
		/*checking the CAKE is in database or not*/
		Cake existingCake = cakeRepository.findById(id).orElse(null);
        if (existingCake != null) {
            existingCake.setTitle(updatedCake.getTitle());
            existingCake.setDescription(updatedCake.getDescription());
            existingCake.setImage(updatedCake.getImage());
            return cakeRepository.save(existingCake);
        }
        return null;
	}

	@Override
	public void updateCaketitle(Long id, CakeDTO cakeDTO) {
//      check weather the Cake is in database or not
      Cake cake = cakeRepository
              .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid CAKE Id:" + id));

      cake.setTitle(cakeDTO.getTitle());
      cakeRepository.save(cake);
		
	}
	
	@Override
	public void deleteCake(Long id) {
		Cake cake = cakeRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid CAKE Id:" + id));
		cakeRepository.delete(cake);
	}

	

	
}
