/**
 * 
 */
package com.alwin.project.cakemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.alwin.project.cakemanager.dto.CakeDTO;
import com.alwin.project.cakemanager.model.Cake;
import com.alwin.project.cakemanager.model.UserInfo;
import com.alwin.project.cakemanager.service.CakeService;

/**
 * 
 */
@RestController
@RequestMapping("/cakes")
public class CakeController {

	
	@Autowired
    private CakeService cakeService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "This Page is Secured";
	}
	
	
	/*
	 * @PostMapping("/new") public String addNewUser(@RequestBody UserInfo
	 * userInfo){ return cakeService.addUser(userInfo); }
	 */
	/** add cake **/
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCake(@RequestBody Cake cake) {
        cakeService.addCake(cake);
        return "Sccess Added a Cake";
    }
	
	
	/**get cake by id */

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Cake getUser(@RequestParam Long id) {
        return cakeService.getCake(id);
    }

    /**get all cake details*/

    
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Cake> getAllCakes() {
        return cakeService.getAllCakes();
    }
	
	/**update cake by id*/

    @PutMapping("/update/{id}")
    public ResponseEntity<Cake> updatedCakeById(@PathVariable Long id, @RequestBody Cake updatedCake) {
    	Cake cake = cakeService.updateCakeById(id, updatedCake);
        if (cake != null) {
            return ResponseEntity.ok(cake);
        }
        return ResponseEntity.notFound().build();
    }
    

    /** delete cake by id*/
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCake(@PathVariable Long id) {
        cakeService.deleteCake(id);
       return "Sccessully deleted a Cake";
    }

    /**
     * update cake title by id
     */

    @PatchMapping("/updatetitle/{id}")
    public ResponseEntity<Void> updateCakeTitle(@PathVariable Long id, @RequestBody CakeDTO cakeDTO){
    	cakeService.updateCaketitle(id, cakeDTO);
        return ResponseEntity.noContent().build();
    }
    
    
    
	
}
