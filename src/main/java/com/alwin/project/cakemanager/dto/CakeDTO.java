/**
 * 
 */
package com.alwin.project.cakemanager.dto;

import lombok.Data;
/**
 * 
 */
@Data
public class CakeDTO {
	    private String title;
	    private String description;
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
	    
	    
	}
