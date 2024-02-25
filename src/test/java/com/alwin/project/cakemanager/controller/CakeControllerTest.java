/**
 * 
 */
package com.alwin.project.cakemanager.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alwin.project.cakemanager.dto.CakeDTO;
import com.alwin.project.cakemanager.model.Cake;
import com.alwin.project.cakemanager.service.CakeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
@ExtendWith(MockitoExtension.class)
public class CakeControllerTest {

	@Mock
	private CakeService cakeService;
	
	@InjectMocks
	private CakeController cakeController;
	
	@Test
    void testAddCake() {
        Cake cake = new Cake();
        when(cakeService.addCake(any(Cake.class))).thenReturn(cake);
        String result = cakeController.addCake(cake);
        assertEquals("Sccess Added a Cake", result);
        verify(cakeService, times(1)).addCake(cake);
    }

	@Test
    void testGetCakeById() {
        Long id = (long) 5;
        Cake cake = new Cake();
        when(cakeService.getCake(id)).thenReturn(cake);
        ResponseEntity<Cake> responseEntity = cakeController.getCakeById(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cake, responseEntity.getBody());
        verify(cakeService, times(1)).getCake(id);
    }
	
	@Test
    void testGetAllCakes() {
        List<Cake> cakes = new ArrayList<>();
        when(cakeService.getAllCakes()).thenReturn(cakes);
        List<Cake> result = cakeController.getAllCakes();
        assertEquals(cakes, result);
        verify(cakeService, times(1)).getAllCakes();
    }
	
	@Test
    void testUpdateCakeById() {
        Long id = 1L;
        Cake updatedCake = new Cake();
        when(cakeService.updateCakeById(id, updatedCake)).thenReturn(updatedCake);
        ResponseEntity<Cake> responseEntity = cakeController.updatedCakeById(id, updatedCake);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedCake, responseEntity.getBody());
        verify(cakeService, times(1)).updateCakeById(id, updatedCake);
    }

	@Test
    void testDeleteCake() {
        Long id = 1L;
        when(cakeService.getCake(id)).thenReturn(new Cake());
        ResponseEntity<String> result = cakeController.deleteCake(id);
        verify(cakeService).deleteCake(id);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Cake with ID " + id + " deleted successfully", result.getBody());
    }

	    @Test
	    void testUpdateCakeTitle() {
	        Long id = 1L;
	        CakeDTO cakeDTO = new CakeDTO();
	        ResponseEntity<Void> responseEntity = cakeController.updateCakeTitle(id, cakeDTO);
	        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	        verify(cakeService, times(1)).updateCaketitle(id, cakeDTO);
	    }
}
