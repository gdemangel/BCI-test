package com.bci.api.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ApiResponseErrorDto {
	
	private String message;
	private List<String> errors;
}
