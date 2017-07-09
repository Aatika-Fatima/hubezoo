/**
 * 
 */
package com.hubezoo.hubezooback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author ebinezer
 *
 */

@Entity
class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATE_SEQ")
	@SequenceGenerator(sequenceName = "category_seq", allocationSize = 1, name = "CATE_SEQ")
	private Long catId;
	private String categoryName;

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
