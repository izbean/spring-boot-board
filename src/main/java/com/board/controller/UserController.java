package com.board.controller;

import com.board.domain.user.UserRole;
import com.board.domain.user.dto.UserRequestDto;
import com.board.domain.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.board.domain.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@Secured({UserRole.Role.ADMIN, UserRole.Role.USER})
	@GetMapping("/{id}")
	public UserResponseDto getUser(@PathVariable("id") String userId) {
		return userService.getUser(userId);
	}

	@GetMapping("/check/{id}")
	public ResponseEntity<Object> duplicationCheckByUserId(@PathVariable("id") String userId) {
		return new ResponseEntity<>(userService.existsById(userId), HttpStatus.OK);
	}

	@PostMapping
	public UserResponseDto createUser(@Valid UserRequestDto userRequestDto) {
		return userService.createUser(userRequestDto);
	}

	@PutMapping
	public UserResponseDto updateUser(UserRequestDto userRequestDto) {
		return null;
	}
	
}
