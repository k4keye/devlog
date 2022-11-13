package com.main.server.common.response.result;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LinksResult {
    private String rel;
    private String href;

}
