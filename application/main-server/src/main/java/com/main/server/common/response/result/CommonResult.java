package com.main.server.common.response.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommonResult {
    @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 번호 : > 0 정상, < 0 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;

    @ApiModelProperty(value = "HATEOAS")
    private List<LinksResult> links = new ArrayList<>();

    public CommonResult() {
    }

    public CommonResult(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
    public CommonResult(boolean success, int code, String msg, List<LinksResult> links) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.links = links;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}