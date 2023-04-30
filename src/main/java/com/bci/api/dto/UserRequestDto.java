package com.bci.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.bci.api.entity.PhoneEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
public class UserRequestDto {
	
	
	@NotBlank(message = "campo obligatorio")
	private String name;
	
	@NotBlank(message = "campo obligatorio")
	@Pattern(regexp = "^(.+)@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$", message = "correo debe tener la estructura aaaaa@dominio.cl" )
	private String email;
	
	@NotBlank(message = "campo obligatorio")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{6,10}$", message = "La clave debe ser de 6 a 10 caracteres, debe incluir mayuscula, minuscula, numeros y caracteres especiales, sin espacios" )
	private String password;
	
	@NotEmpty(message = "campo obligatorio")
	private List<PhoneEntity> phone = new ArrayList<>();

}
