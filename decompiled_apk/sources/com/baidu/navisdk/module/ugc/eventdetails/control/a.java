package com.baidu.navisdk.module.ugc.eventdetails.control;

/* loaded from: classes7.dex */
public final class a {
    public static String a(int i) {
        switch (i) {
            case 1:
                return "导航中";
            case 2:
                return "雷达页";
            case 3:
                return "路线结果页";
            case 4:
                return "首页";
            case 5:
                return "未来出行页";
            case 6:
                return "通勤路线结果页";
            case 7:
                return "通勤导航中";
            case 8:
                return "货车查看周边";
            default:
                return "诡异的页面";
        }
    }

    public static String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "诡异的面板" : "货车 ugc 面板" : "红绿灯详情面板" : "拥堵详情面板" : "虚拟事件面板" : "ugc事件面板";
    }
}
