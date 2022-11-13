package com.main.server.common.response.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T data;

    public SingleResult() {

    }
    public SingleResult(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingleResult{" +
                "data=" + data +
                '}';
    }
}

