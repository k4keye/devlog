//package com.main.server.config.advice;
//
//
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//@RestControllerAdvice
//public class ResponseAdvice implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        System.out.println("body = " + body);
//        System.out.println("returnType = " + returnType);
//        System.out.println("selectedContentType = " + selectedContentType);
//        System.out.println("selectedConverterType = " + selectedConverterType);
//        System.out.println("request = " + request);
//        System.out.println("response = " + response);
//
//
//        return null;
//
//    }
//}
