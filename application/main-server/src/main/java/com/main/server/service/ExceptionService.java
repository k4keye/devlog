package com.main.server.service;

import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public void BasicException() throws Exception {
        throw new Exception("basic  throw new Exception");
    }
    public void BasicRuntimeException() {
        throw new RuntimeException("basic throw new RuntimeException");
    }
    public void BasicIllegalStateException() {
        throw new IllegalStateException("basic throw new IllegalStateException");
    }
    public void BasicIllegalAccessException() throws IllegalAccessException {
        throw new IllegalAccessException("basic throw new IllegalAccessException");
    }
}
