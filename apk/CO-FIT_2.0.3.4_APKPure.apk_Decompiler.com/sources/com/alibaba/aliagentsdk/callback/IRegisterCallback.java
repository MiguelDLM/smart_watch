package com.alibaba.aliagentsdk.callback;

public interface IRegisterCallback {
    void onRegisterFailed(String str, int i);

    void onRegisterSuccess(String str, String str2, String str3, String str4, String str5);
}
