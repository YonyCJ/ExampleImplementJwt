package com.prapp.examplesecurityjwt.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse {
    private String message;
    private String username;
    private String token;
}
