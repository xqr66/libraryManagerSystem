package com.itheima.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String message;

    public R(Boolean flag){
        this.flag = flag;
    }
    public R(Boolean flag, String message){
        this.flag= flag;
        this.message = message;
    }
    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }
}
