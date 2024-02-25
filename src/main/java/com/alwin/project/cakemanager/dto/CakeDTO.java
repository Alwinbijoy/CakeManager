/**
 * 
 */
package com.alwin.project.cakemanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
/**
 * 
 */
@Data
public class CakeDTO {
	    
		@JsonProperty("title")
	    private String title;
	    
	    @JsonProperty("desc")
	    private String description;
	    
	    @JsonProperty("image")
	    private String image;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
	    
	    
	}

