package com.auth.service.controller;

import com.auth.service.DTOs.LoginDto;
import com.auth.service.DTOs.RegisterDto;
import com.auth.service.DTOs.ResponseDto;
import com.auth.service.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> userRegister(@RequestBody RegisterDto registerDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usersService.userRegister(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usersService.userLogin(loginDto));
    }
}
