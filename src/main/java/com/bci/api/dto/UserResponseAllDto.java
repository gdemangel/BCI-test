package com.bci.api.dto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseAllDto {

	private UUID userId;
	private String name;
	private String email;
	private Date creationDate;
	private Date lastUpdate;
	private Date lastLogin;	
	private Integer isActive;
}
