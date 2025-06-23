package com.iflytek.sparkchain.plugins.mail.ifla;

import com.iflytek.sparkchain.plugins.base.BaseModel;

/* loaded from: classes10.dex */
public class a extends BaseModel {

    /* renamed from: a, reason: collision with root package name */
    private String f17489a = "{\"to\":[\"收件人\"],\"from\":[\"发件人\"],\"subject\":\"邮件标题\",\"body\":\"邮件正文\",\"time\":\"时间信息\",\"unseen\":[\"未读\"],\"seen\":[\"已读\"],\"answered\":[\"已回复\"]}";

    @Override // com.iflytek.sparkchain.plugins.base.BaseModel
    public String toString() {
        return this.f17489a;
    }
}
