/**
 * 
 */
package com.alwin.project.cakemanager.repository;

/**
 * 
 */
import com.alwin.project.cakemanager.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake, Long> {
}
