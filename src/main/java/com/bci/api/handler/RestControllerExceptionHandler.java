package com.bci.api.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bci.api.dto.ApiResponseErrorDto;

import jakarta.validation.ConstraintViolationException;




@RestControllerAdvice
public class RestControllerExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiResponseErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(
						createApiResponseErrorDto("Erro de validaciones en request", exception.getBindingResult().getFieldErrors().stream()
								.map( error -> error.getField()+" "+error.getDefaultMessage())
								.collect(Collectors.toList()))
						);
	}
	
		
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiResponseErrorDto> httpMessageNotReadableException(HttpMessageNotReadableException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(
						createApiResponseErrorDto("Error en request ", Arrays.asList(exception.getMessage()))
						);

	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ApiResponseErrorDto> dataIntegrityViolationException(DataIntegrityViolationException exception){
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(
						createApiResponseErrorDto("Correo ya existe en la base de datos", Arrays.asList(exception.getMessage()))
						);

	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ApiResponseErrorDto> constraintViolationException(ConstraintViolationException exception){
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(
						createApiResponseErrorDto("Faltan parametros ", Arrays.asList(exception.getMessage()))
						);

	}
	
	private ApiResponseErrorDto createApiResponseErrorDto(String message,List<String> errors) {
		return ApiResponseErrorDto.builder()				
				.message(message)
				.errors(errors)
				.build();
	}
	
	
	
}

