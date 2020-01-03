package com.custom.demo.common.pojo;

import java.io.Serializable;

public class RM implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int code;
    
    private String message;
    
    private Object data;
    
    public RM() {
        super();
    }
    
    public RM(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static RM codeMessage(int code, String message){
        return new RM(code, message, null);
    }
    public static RM codeData(int code, Object data){
        String message = null;
        if(code == 1)
            message = "成功";
        if(code != 1)
            message = "失败";
        return new RM(code, message, data);
    }
    public static RM success(Object data){
        return new RM(0, "成功", data);
    }
    public static RM success(){
        return new RM(0, "成功", null);
    }
    public static RM fail(Object data){
        return new RM(1, "失败", data);
    }
    public static RM fail(){
        return new RM(1, "失败", null);
    }
    public static RM rm(int code, String message, Object data){
        return new RM(code, message, data);
    }
    
}
