package com.lfm.wms.ret;

/**
 * @author lfm
 * @date 2019/11/19 - 10:50
 */
public class RetResult<T> {

    public int code;

    private String msg;

    private T data;

    private Long count;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public RetResult<T> setCount(Long count) {
        this.count = count;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}

