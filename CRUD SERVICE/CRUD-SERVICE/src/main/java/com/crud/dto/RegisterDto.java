package com.crud.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@Builder
public class RegisterDto {

    private String name;
    private String motherName;
    private String fatherName;
    private String email;
    private String college;

}
