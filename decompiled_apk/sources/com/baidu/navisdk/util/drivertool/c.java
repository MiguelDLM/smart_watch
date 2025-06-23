package com.baidu.navisdk.util.drivertool;

import java.text.SimpleDateFormat;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f9276a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String b = com.baidu.navisdk.util.http.b.d().a() + "appnavi.baidu.com/naviServerAdmin/getdttasklist";
    public static final String c = com.baidu.navisdk.util.http.b.d().a() + "appnavi.baidu.com/naviServerAdmin/getdtrouteid";
    public static final String d = com.baidu.navisdk.util.http.b.d().a() + "appnavi.baidu.com/naviServerAdmin/getdtproblemid";
    public static final String e = com.baidu.navisdk.util.http.b.d().a() + "appnavi.baidu.com/naviServerAdmin/getdttaskdetailconfig";
    public static final String f = com.baidu.navisdk.util.http.b.d().a() + "appnavi.baidu.com/naviServerAdmin/submitdtrouteproblem";
    public static final String[] g = {"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -", "客户端", "路线", "路况", "图像", "数据", "定位", "诱导"};
    public static final String[] h = {"-  -  -  -  -  -  -  -  -  -  -  -  -  -  -", "发现问题", "解决中", "延期", "非问题", "暂时无法解决", "已解决"};
}
