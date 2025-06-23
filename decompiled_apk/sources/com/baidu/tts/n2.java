package com.baidu.tts;

import com.iflytek.sparkchain.utils.DataUtil;

/* loaded from: classes8.dex */
public enum n2 {
    GB18030("gb18030", "0"),
    BIG5("big5", "1"),
    UTF8("utf-8", "2"),
    GBK("gbk", "4"),
    UNICODE(DataUtil.UNICODE, "5");


    /* renamed from: a, reason: collision with root package name */
    public final String f10138a;
    public final String b;

    n2(String str, String str2) {
        this.f10138a = str;
        this.b = str2;
    }
}
