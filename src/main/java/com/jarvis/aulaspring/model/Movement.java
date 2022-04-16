package com.jarvis.aulaspring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Movement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	private Double value;
	private String numberCard;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT-3")
	private Date movementDate;

	public Movement() {
	}

	public Movement(Double value, String numberCard, Date movementDate) {
		this.value = value;
		this.numberCard = numberCard;
		this.movementDate = movementDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public Date getMovementDate() {
		return movementDate;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

}
