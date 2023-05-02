package com.bci.api.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {	
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "creationDate")
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(name = "lastUpdate")
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;

	@Column(name = "lastLogin")
	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	@Column(name = "isActive")
	private Integer isActive;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<PhoneEntity> phone = new ArrayList<>();	
	
	@Column(name = "acces_token")
	private UUID accesToken;

	@PrePersist
	public void prePersist() {

		accesToken = UUID.randomUUID();
		creationDate = new Date();
		lastUpdate = new Date();
		lastLogin = new Date();
		isActive = 0;
		
	}	

}
