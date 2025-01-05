package com.prapp.examplesecurityjwt.expose.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse {
    private String token;
    private boolean isActive;
}
