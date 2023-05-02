package com.bci.api.test.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bci.api.BciApiApplication;
import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseDto;
import com.bci.api.entity.UserEntity;
import com.bci.api.repository.IUserRepository;
import com.bci.api.test.util.UserUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = BciApiApplication.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private UserUtil userUtil = new UserUtil();

	@Test
	public void test_Create_Should_CreatUser_When_Invoke() throws JsonProcessingException, Exception {
		UserRequestDto userRequestDto = userUtil.createUserRequestDto();

		ResultActions res = mockMvc
				.perform(MockMvcRequestBuilders.post("/v1/api/create").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(userRequestDto)).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpectAll(MockMvcResultMatchers.status().isCreated()

				);
		
		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		UserResponseDto userResponseDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), UserResponseDto.class);
		Assertions.assertNotNull(userResponseDto.getUserId());
		
		UserEntity user = userRepository.findById(userResponseDto.getUserId()).orElseThrow();
				
		Assertions.assertNotNull(user);
		Assertions.assertTrue(user.getAccesToken().equals(userResponseDto.getAccesToken()));
		userRepository.deleteById(userResponseDto.getUserId());

	}
	
	@Test
	public void test_Delete_Should_DeletePet_When_Invoked() throws JsonProcessingException, Exception {
		UserEntity user = userUtil.createUser();
		user.setUserId(null);
		userRepository.save(user);
		
		mockMvc.perform(
	            MockMvcRequestBuilders.delete("/v1/api/deleteUser/"+user.getUserId())
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
		
	            .andDo(MockMvcResultHandlers.print())
	            .andExpectAll(
	                    MockMvcResultMatchers.status().isOk()
	                
	            );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
