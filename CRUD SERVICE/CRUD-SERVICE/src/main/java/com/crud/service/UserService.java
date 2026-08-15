package com.crud.service;

import com.crud.dto.RegisterDto;
import com.crud.dto.ResponseDto;
import com.crud.entity.User;
import com.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseDto createUser(RegisterDto registerDto){
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new RuntimeException("User already exists !");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setMotherName(registerDto.getMotherName());
        user.setFatherName(registerDto.getFatherName());
        user.setEmail(registerDto.getEmail());
        user.setCollege(registerDto.getCollege());

        User savedUser = userRepository.save(user);

        return new ResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getMotherName(),
                savedUser.getFatherName(),
                savedUser.getEmail(),
                savedUser.getCollege()
        );
    }

    public List<ResponseDto> createUsers(List<RegisterDto> registerDtos) {

        List<ResponseDto> responseList = new ArrayList<>();

        for (RegisterDto registerDto : registerDtos) {

            if (userRepository.existsByEmail(registerDto.getEmail())) {
                throw new RuntimeException(
                        "User already exists with email: " + registerDto.getEmail()
                );
            }

            User user = new User();
            user.setName(registerDto.getName());
            user.setMotherName(registerDto.getMotherName());
            user.setFatherName(registerDto.getFatherName());
            user.setEmail(registerDto.getEmail());
            user.setCollege(registerDto.getCollege());

            User savedUser = userRepository.save(user);

            ResponseDto responseDto = new ResponseDto(
                    savedUser.getId(),
                    savedUser.getName(),
                    savedUser.getMotherName(),
                    savedUser.getFatherName(),
                    savedUser.getEmail(),
                    savedUser.getCollege()
            );

            responseList.add(responseDto);
        }

        return responseList;
    }

    public List<ResponseDto> getUsers(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> ResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .motherName(user.getMotherName())
                        .fatherName(user.getFatherName())
                        .email(user.getEmail())
                        .college(user.getCollege())
                        .build())
                .toList();
    }

    public ResponseDto getById(Long id){

        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found !"));

        return new ResponseDto(
                user.getId(),
                user.getName(),
                user.getMotherName(),
                user.getFatherName(),
                user.getEmail(),
                user.getCollege()
        );
    }

    public String deleteById(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found !"));

        userRepository.deleteById(id);
        return "User delete successfully, id is : "+id;
    }


    public ResponseDto updateUser(Long id, RegisterDto registerDto){

        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found !"));

        user.setName(registerDto.getName());
        user.setMotherName(registerDto.getMotherName());
        user.setFatherName(registerDto.getFatherName());
        user.setEmail(registerDto.getEmail());
        user.setCollege(registerDto.getCollege());

        User updatedUser = userRepository.save(user);

        return ResponseDto.builder()
                .id(updatedUser.getId())
                .name(updatedUser.getName())
                .motherName(updatedUser.getMotherName())
                .fatherName(updatedUser.getFatherName())
                .email(updatedUser.getEmail())
                .college(updatedUser.getCollege())
                .build();
    }

    public List<ResponseDto> userList(String search, Pageable pageable) {

        List<User> users = new ArrayList<>();

        if (search == null || search.isBlank()) {

            users = userRepository.findAll(pageable).getContent();

        } else {

            users = userRepository
                    .findByName(search,pageable)
                    .getContent();
        }

        return users.stream()
                .map(user -> ResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .motherName(user.getMotherName())
                        .fatherName(user.getFatherName())
                        .email(user.getEmail())
                        .college(user.getCollege())
                        .build())
                .toList();
    }
}
