package com.fomo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class SocialMedia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int socialMediaId; 
	@Column(name="SOCIAL_MEDIA_NAME", length=30)
	@NotNull
	private String socialMediaName; 
	@Column(name="POINTS", length=4)
	private int points;
	public SocialMedia() {
		super();
	}
	/**
	 * @return the socialMediaId
	 */
	public final int getSocialMediaId() {
		return socialMediaId;
	}
	/**
	 * @param socialMediaId the socialMediaId to set
	 */
	public final void setSocialMediaId(int socialMediaId) {
		this.socialMediaId = socialMediaId;
	}
	/**
	 * @return the socialMediaName
	 */
	public final String getSocialMediaName() {
		return socialMediaName;
	}
	/**
	 * @param socialMediaName the socialMediaName to set
	 */
	public final void setSocialMediaName(String socialMediaName) {
		this.socialMediaName = socialMediaName;
	}
	/**
	 * @return the points
	 */
	public final int getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public final void setPoints(int points) {
		this.points = points;
	} 
	
	
}
