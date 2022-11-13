package com.main.server.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
public class JoinRequest {
    @NotBlank(message = "파라미터가 비워져있다.")
    private String id;
    @NotBlank
    private String pwd;

    @NotBlank
    private String email;

    private String city;
    private String street;
    private String zipcode;
}
