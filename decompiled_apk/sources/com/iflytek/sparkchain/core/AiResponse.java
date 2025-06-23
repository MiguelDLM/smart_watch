package com.iflytek.sparkchain.core;

import java.util.Arrays;

/* loaded from: classes10.dex */
public class AiResponse {
    private String key;
    private int len;
    private int status;
    private c type;
    private byte[] value;
    private VarType varType;

    private byte[] cut(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static AiResponse gen(String str, String str2) {
        return gen(str, str2.getBytes(), c.TEXT, VarType.STRING);
    }

    public String getKey() {
        return this.key;
    }

    public int getLen() {
        return this.len;
    }

    public int getStatus() {
        return this.status;
    }

    public c getType() {
        return this.type;
    }

    public byte[] getValue() {
        return this.value;
    }

    public VarType getVarType() {
        return this.varType;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLen(int i) {
        this.len = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(int i) {
        this.type = c.a(i);
    }

    public void setValue(byte[] bArr) {
        this.value = bArr;
    }

    public void setVarType(VarType varType) {
        this.varType = varType;
    }

    public String toString() {
        return "AiOutput{key='" + this.key + "', value=" + Arrays.toString(this.value) + ", len=" + this.len + ", type=" + this.type + ", status=" + this.status + ", varType=" + this.varType + '}';
    }

    public static AiResponse gen(String str, byte[] bArr, c cVar, VarType varType) {
        AiResponse aiResponse = new AiResponse();
        aiResponse.setKey(str);
        aiResponse.setValue(bArr);
        aiResponse.setLen(bArr.length);
        aiResponse.setType(cVar);
        aiResponse.setVarType(varType);
        return aiResponse;
    }

    public void setKey(byte[] bArr, int i, int i2) {
        this.key = new String(cut(bArr, i, i2));
    }

    public void setType(c cVar) {
        this.type = cVar;
    }

    public void setValue(byte[] bArr, int i, int i2) {
        this.value = cut(bArr, i, i2);
    }
}
