package com.fomo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long interestId;; 
	private String interestName;
	public Interest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the interestId
	 */
	public final long getInterestId() {
		return interestId;
	}
	/**
	 * @param interestId the interestId to set
	 */
	public final void setInterestId(long interestId) {
		this.interestId = interestId;
	}
	/**
	 * @return the interestName
	 */
	public final String getInterestName() {
		return interestName;
	}
	/**
	 * @param interestName the interestName to set
	 */
	public final void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	
	
}
