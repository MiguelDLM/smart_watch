package com.tenmeter.smlibrary.entity;

/* loaded from: classes13.dex */
public class BaseBean<T> {
    private int code;
    private T data;
    private String msg;
    private long tm;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getTm() {
        return this.tm;
    }

    public boolean isOk() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setTm(long j) {
        this.tm = j;
    }

    public String toString() {
        return "BaseBean{code=" + this.code + ", message='" + this.msg + "', data=" + this.data + '}';
    }
}
