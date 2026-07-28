package com.crud.controller;

import com.crud.dto.RegisterDto;
import com.crud.dto.ResponseDto;
import com.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")     //  /user/create
    public ResponseEntity<ResponseDto> create(@RequestBody RegisterDto registerDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(registerDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseDto>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUsers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.deleteById(id));
    }

}
