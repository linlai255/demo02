package com.cll.common;

/**
 * 通用返回对象
 * Created by commerce on 2019/4/19.
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

public static <T> CommonResult<T> failed(String message){
        return new CommonResult<>(ResultCode.FAILED.getCode(),message,null);
}
    public static <T> CommonResult<T> success(String message){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),message,null);
    }
    public static <T> CommonResult<T> loginFailed(){
        return new CommonResult<>(ResultCode.ERROR_MSG.getCode(),ResultCode.ERROR_MSG.getMessage(), null);
    }
    public static <T> CommonResult<T> success(String message , T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),message,data);
    }
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
