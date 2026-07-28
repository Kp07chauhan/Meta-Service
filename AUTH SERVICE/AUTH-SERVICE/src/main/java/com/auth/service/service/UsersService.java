package com.auth.service.service;

import com.auth.service.DTOs.LoginDto;
import com.auth.service.DTOs.RegisterDto;
import com.auth.service.DTOs.ResponseDto;
import com.auth.service.entity.Role;
import com.auth.service.entity.Users;
import com.auth.service.jwt.JwtUtil;
import com.auth.service.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public ResponseDto userRegister(RegisterDto registerDto){

        if (usersRepository.existsByEmail(registerDto.getEmail())){
            throw new RuntimeException("User already Exists!");
        }

        Users user = new Users();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(Role.USER);
        Users saved = usersRepository.save(user);

        return new ResponseDto(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail(),
                saved.getRole()
        );
    }

    public String userLogin(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        Users user = usersRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtUtil.generateToken(user.getEmail()); // was user.getUsername()
    }

}
