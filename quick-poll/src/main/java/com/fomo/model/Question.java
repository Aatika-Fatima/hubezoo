package com.fomo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Question extends ResourceSupport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long qid;
	@Column(name = "QUESTION_TEXT")
	@NotNull
	private String qText;

	@NotNull
	@Column(name = "OPTION_A" )
	private String optA;
	@NotNull
	@Column(name = "OPTION_B" )
	private String optB;
	@NotNull
	@Column(name = "OPTION_C" )
	private String optC;
	@NotNull
	@Column(name = "OPTION_D" )
	private String optD;

	@Column(name = "ANSWER", length = 1)
	private String answer;
	@NotNull
	private String notes;

	@NotNull
	private String link;

	@NotNull
	private int points;

	@ManyToOne
	@JoinColumn(name = "INTEREST_ID")
	Interest interest;

	public Question() {
		super();
	}

	/**
	 * @return the qid
	 */
	public final long getQid() {
		return qid;
	}

	/**
	 * @param qid
	 *            the qid to set
	 */
	public final void setQid(long qid) {
		this.qid = qid;
	}

	/**
	 * @return the qText
	 */
	public final String getqText() {
		return qText;
	}

	/**
	 * @param qText
	 *            the qText to set
	 */
	public final void setqText(String qText) {
		this.qText = qText;
	}

	/**
	 * @return the optA
	 */
	public final String getOptA() {
		return optA;
	}

	/**
	 * @param optA
	 *            the optA to set
	 */
	public final void setOptA(String optA) {
		this.optA = optA;
	}

	/**
	 * @return the optB
	 */
	public final String getOptB() {
		return optB;
	}

	/**
	 * @param optB
	 *            the optB to set
	 */
	public final void setOptB(String optB) {
		this.optB = optB;
	}

	/**
	 * @return the optC
	 */
	public final String getOptC() {
		return optC;
	}

	/**
	 * @param optC
	 *            the optC to set
	 */
	public final void setOptC(String optC) {
		this.optC = optC;
	}

	/**
	 * @return the optD
	 */
	public final String getOptD() {
		return optD;
	}

	/**
	 * @param optD
	 *            the optD to set
	 */
	public final void setOptD(String optD) {
		this.optD = optD;
	}

	/**
	 * @return the answer
	 */
	public final String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public final void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the notes
	 */
	public final String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public final void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the link
	 */
	public final String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public final void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the points
	 */
	public final int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public final void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the interest
	 */
	public final Interest getInterest() {
		return interest;
	}

	/**
	 * @param interest
	 *            the interest to set
	 */
	public final void setInterest(Interest interest) {
		this.interest = interest;
	}

}
