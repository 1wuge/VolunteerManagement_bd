package com.example.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    /**
     * 1，响应码
     * 2，数据
     * 3，返回前端消息
     */

    private int code;
    private Object data;
    private String message;
}
