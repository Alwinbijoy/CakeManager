/**
 * 
 */
package com.alwin.project.cakemanager.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.alwin.project.cakemanager.dto.CakeDTO;
import com.alwin.project.cakemanager.model.Cake;
import com.alwin.project.cakemanager.model.UserInfo;
import com.alwin.project.cakemanager.service.CakeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public ResponseEntity<Cake> getCakeById(@RequestParam Long id) {
    	Cake cake = cakeService.getCake(id);
        if (cake != null) {
            return ResponseEntity.ok(cake);
        }
        return ResponseEntity.notFound().build();

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
    

    /**
     * delete cake title by id
     */

	 @DeleteMapping("/delete/{id}")
	 @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> deleteCake(@PathVariable Long id) {
	        Cake cake = cakeService.getCake(id);
	        if (cake != null) {
	            cakeService.deleteCake(id);
	            return ResponseEntity.ok("Cake with ID " + id + " deleted successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cake with ID " + id + " not found");
	        }
	    }

    /**
     * update cake title by id
     */

    @PatchMapping("/updatetitle/{id}")
    public ResponseEntity<Void> updateCakeTitle(@PathVariable Long id, @RequestBody CakeDTO cakeDTO){
    	cakeService.updateCaketitle(id, cakeDTO);
        return ResponseEntity.noContent().build();
    }
    
    
   
    @PostMapping("/add-from-url")
    public ResponseEntity<String> addCakesFromUrl() {
        try {
            // Fetch JSON data from the URL
            RestTemplate restTemplate = new RestTemplate();
            String jsonDataUrl = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json";
            String jsonString = restTemplate.getForObject(jsonDataUrl, String.class);

            // Parse JSON string to list of CakeDTO objects
            ObjectMapper objectMapper = new ObjectMapper();
            List<CakeDTO> cakesList = objectMapper.readValue(jsonString, new TypeReference<List<CakeDTO>>() {});

            // Convert CakeDTOs to Cake entities and add them to the database
            for (CakeDTO cakeDTO : cakesList) {
                Cake cake = new Cake();
                cake.setTitle(cakeDTO.getTitle());
                cake.setDescription(cakeDTO.getDescription());
                cake.setImage(cakeDTO.getImage());
                cakeService.addCake(cake);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Cakes added successfully from URL");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add cakes from URL: " + e.getMessage());
        }
    }


	
}
