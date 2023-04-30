package com.bci.api.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="phone")
public class PhoneEntity {
	
	@Id
	@Column(name = "phone_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phone_id;
	
	@Column(name= "number", nullable = false)
	@NotNull(message = "campo obligatorio")
	private Integer number;
	
	@Column(name= "city_code", nullable = false)
	@NotNull(message = "campo obligatorio")
	private Integer city_code;
	
	@Column(name= "country_code", nullable = false)
	@NotNull(message = "campo obligatorio")
	private Integer country_code;
	
	@Column(name= "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	
	@Column(name = "user_id", columnDefinition = "VARCHAR(36)")
	private UUID user_id;
	
	@PrePersist
	public void prePersist() {
		creation_date = new Date();		
	}
	
}
