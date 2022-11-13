package com.main.server.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class PatchRequest {
    private String op; // 오퍼레이션 (replace, add, remove)
    private String path; // 대상
    private String value; // 값

}
