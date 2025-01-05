package com.prapp.examplesecurityjwt.business;


import com.prapp.examplesecurityjwt.expose.dto.UserDto;

public interface UserService {

    UserDto.Response register(UserDto.Request request);

}
