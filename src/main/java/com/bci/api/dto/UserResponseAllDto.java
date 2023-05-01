package com.bci.api.dto;

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

	private UUID user_id;
	private String name;
	private String email;
	private String creation_date;
	private String last_update;
	private String last_login;	
	private String is_active;
}
