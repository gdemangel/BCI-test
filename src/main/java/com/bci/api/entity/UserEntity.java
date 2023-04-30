package com.bci.api.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID user_id;
	
	@Column (name="name")
	private String name;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column (name="password")
	private String password;
	
	@Column(name= "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	
	@Column(name= "last_update")
	@Temporal(TemporalType.DATE)
	private Date last_update;
	
	@Column(name= "last_login")
	@Temporal(TemporalType.DATE)
	private Date last_login;
	
	@Column (name="is_active")
	private Integer is_active;	
	
	
	@PrePersist
	public void prePersist() {
		creation_date = new Date();
		last_update = new Date();
		last_login = new Date();
		is_active = 0;
	}

}
