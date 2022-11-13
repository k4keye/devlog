package com.main.server.common.response.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Getter
@Setter
@ToString
public class CollectionResult<T> extends CommonResult{
    private Collection<T> data;
}