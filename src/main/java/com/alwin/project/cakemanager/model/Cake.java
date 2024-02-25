/**
 * 
 */
package com.alwin.project.cakemanager.model;


import jakarta.persistence.*;

/**
 * 
 */
@Entity
@Table(name = "cakes")
public class Cake {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="image")
	private String image;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
