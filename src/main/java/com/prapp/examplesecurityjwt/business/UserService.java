package com.prapp.examplesecurityjwt.business;


import com.prapp.examplesecurityjwt.expose.dto.JsonResponse;
import com.prapp.examplesecurityjwt.expose.dto.UserDto;

public interface UserService {

    JsonResponse login(UserDto.LoginRequest request);
    UserDto.Response register(UserDto.Request request);

}
