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
public class PhoneResponseDto {
	
	private Integer number; 
	private Integer cityCode;
	private Integer countryCode;
	private UUID userId;
	private Date creationDate;

}
