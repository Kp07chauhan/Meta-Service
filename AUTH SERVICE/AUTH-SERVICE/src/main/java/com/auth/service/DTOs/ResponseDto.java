package com.auth.service.DTOs;

import com.auth.service.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter@Setter
public class ResponseDto {

    private Long id;
    private String username;
    private String email;
    private Role role;

}
