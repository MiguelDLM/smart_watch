package com.baidu.navisdk.yellowbannerui.controller;

import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f9443a;
    private static final int[] b;

    static {
        int i = R.drawable.nsdk_yellow_banner_moren_icon;
        b = new int[]{i, R.drawable.nsdk_yellow_banner_green, R.drawable.nsdk_yellow_banner_xian, R.drawable.nsdk_yellow_banner_jtgz, R.drawable.nsdk_yellow_banner_fl, R.drawable.nsdk_yellow_banner_dlsg, R.drawable.nsdk_yellow_banner_dlxq, R.drawable.nsdk_yellow_banner_dlqw, R.drawable.nsdk_yellow_banner_dljb, R.drawable.nsdk_yellow_banner_dljs, i, R.drawable.nsdk_yellow_banner_jj, R.drawable.nsdk_yellow_banner_lxld, R.drawable.nsdk_yellow_banner_jtyd, R.drawable.nsdk_yellow_banner_eltq, R.drawable.nsdk_yellow_banner_fwq, i, R.drawable.nsdk_yellow_banner_sg, R.drawable.nsdk_yellow_banner_xiaolaba, R.drawable.nsdk_yellow_banner_shijian, R.drawable.nsdk_yellow_banner_daolufengbi_wu, R.drawable.nsdk_yellow_banner_daolushigong, R.drawable.nsdk_yellow_banner_daoluxianqing, R.drawable.nsdk_yellow_banner_jiaotongguanzhi, R.drawable.nsdk_yellow_banner_jiebing, R.drawable.nsdk_yellow_banner_jishui, R.drawable.nsdk_yellow_banner_fenglu, R.drawable.nsdk_yellow_banner_yongdu_1, R.drawable.nsdk_yellow_banner_guanfangshijian, R.drawable.nsdk_yellow_banner_elietianqi, R.drawable.nsdk_yellow_banner_bendihuayiguibi, R.drawable.nsdk_yellow_banner_shigong, R.drawable.nsdk_yellow_banner_acci, R.drawable.nsdk_yellow_banner_lundutishi, R.drawable.nsdk_yellow_banner_xianqing, R.drawable.nsdk_yellow_banner_buzougaosu_yellow, R.drawable.nsdk_yellow_banner_buzougaosu, R.drawable.nsdk_yellow_banner_gaosuyouxian_yellow, R.drawable.nsdk_yellow_banner_gaosuyouxian, R.drawable.nsdk_yellow_banner_shijian_white, R.drawable.nsdk_yellow_banner_weilaichuxing, R.drawable.nsdk_yellow_banner_du, R.drawable.nsdk_yellow_banner_tingchechang, R.drawable.nsdk_yellow_banner_luxianshoucang, R.drawable.nsdk_yellow_banner_lukuangyuce, R.drawable.nsdk_yellow_banner_jiduantianqi, i, i, R.drawable.nsdk_yellow_banner_xianxing_1, i, i, R.drawable.nsdk_yellow_banner_xianxing_red, R.drawable.nsdk_yellow_banner_xiangao, R.drawable.nsdk_yellow_banner_xiankuan, R.drawable.nsdk_yellow_banner_xianzhong, R.drawable.nsdk_yellow_banner_jinxing, R.drawable.nsdk_yellow_banner_jiancha};
    }

    public static a c() {
        if (f9443a == null) {
            f9443a = new a();
        }
        return f9443a;
    }

    public int a(int i) {
        if (i < 0) {
            return -1;
        }
        if (i >= 256) {
            switch (i) {
                case 258:
                    return R.drawable.nsdk_yellow_banner_lxld;
                case 259:
                    return R.drawable.nsdk_yellow_banner_elietianqi;
                case 260:
                    return R.drawable.nsdk_yellow_banner_fwq;
                default:
                    return -1;
            }
        }
        int[] iArr = b;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    public int b() {
        if (com.baidu.navisdk.yellowtipdata.model.a.c().f9455a > 0) {
            return com.baidu.navisdk.yellowtipdata.model.a.c().f9455a;
        }
        return 10;
    }

    public int[] a() {
        return b;
    }
}
