package com.crud.controller;

import com.crud.dto.RegisterDto;
import com.crud.dto.ResponseDto;
import com.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    @PostMapping("/create/multiple")
    public ResponseEntity<List<ResponseDto>> createUsers(@RequestBody List<RegisterDto> registerDtos) {

        return ResponseEntity.ok(userService.createUsers(registerDtos));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseDto>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUsers());
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResponseDto>> usersList(@RequestParam(required = false, defaultValue = "1") int pageNo, @RequestParam(required = false, defaultValue = "5") int pageSize){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.userList(PageRequest .of(pageNo-1,pageSize)));
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
