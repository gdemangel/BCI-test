package com.bci.api.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phone")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phoneId")
	private Long phoneId;
	
	@Column(name= "number", nullable = false)
	@NotNull(message = "campo obligatorio")
	private Integer number;
	
	@Column(name= "cityCode", nullable = false)
	@NotNull(message = "campo obligatorio")
	private Integer cityCode;
	
	@Column(name= "countryCode", nullable = false)
	@NotNull(message = "campo obligatorio")
	private Integer countryCode;
	
	@Column(name= "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(name = "userId", columnDefinition = "VARCHAR(36)")
	private UUID userId;
	
	@PrePersist
	public void prePersist() {
		creationDate = new Date();
	}
	
}
