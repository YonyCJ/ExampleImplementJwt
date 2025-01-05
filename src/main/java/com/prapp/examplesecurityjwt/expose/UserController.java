package com.prapp.examplesecurityjwt.expose;

import com.prapp.examplesecurityjwt.expose.dto.UserDto;
import com.prapp.examplesecurityjwt.business.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto.Response> register(@Valid @RequestBody UserDto.Request request) {
        UserDto.Response dto = userService.register(request);
        return ResponseEntity.ok(dto);
    }

}
