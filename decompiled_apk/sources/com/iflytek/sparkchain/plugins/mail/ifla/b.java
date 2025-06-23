package com.iflytek.sparkchain.plugins.mail.ifla;

import com.iflytek.sparkchain.plugins.base.BaseModel;

/* loaded from: classes10.dex */
public class b extends BaseModel {

    /* renamed from: a, reason: collision with root package name */
    private String f17490a = "{\"to\":[\"收件人\"],\"cc\":[\"抄送人\"],\"bcc\":[\"密抄送人\"],\"subject\":\"邮件主题\",\"body\":\"邮件内容，基于Question生成\"}";

    @Override // com.iflytek.sparkchain.plugins.base.BaseModel
    public String toString() {
        return this.f17490a;
    }
}
