package com.bci.api.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.bci.api.dto.ApiResponseErrorDto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;




@RestControllerAdvice
public class RestControllerExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiResponseErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(
						createApiResponseErrorDto("Error de validaciones en request", exception.getBindingResult().getFieldErrors().stream()
								.map( error -> error.getField()+" "+error.getDefaultMessage())
								.collect(Collectors.toList()))
						);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ApiResponseErrorDto> entityNotFoundException(EntityNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(
						createApiResponseErrorDto("No encontrado" ,Arrays.asList(exception.getMessage()))
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
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiResponseErrorDto> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(
						createApiResponseErrorDto("UUID no corresponde", Arrays.asList(exception.getMessage()))
						);

	}
	
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	public ResponseEntity<ApiResponseErrorDto> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception){
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
				.body(
						createApiResponseErrorDto("Error en json de entrada", Arrays.asList(exception.getMessage()))
						);

	}
	
	
	
		
	
	private ApiResponseErrorDto createApiResponseErrorDto(String message,List<String> errors) {
		return ApiResponseErrorDto.builder()				
				.message(message)
				.errors(errors)
				.build();
	}
	
	
	
}

