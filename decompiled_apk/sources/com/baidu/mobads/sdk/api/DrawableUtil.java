package com.baidu.mobads.sdk.api;

import com.baidu.mobads.proxy.R;

/* loaded from: classes7.dex */
public class DrawableUtil {
    public static Integer getDrawableId(String str) {
        if ("blur_bg_white".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if ("rsp_small_red_heart".equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if ("rsp_big_red_heart".equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        if ("cpu_drama_video".equals(str)) {
            return Integer.valueOf(R.drawable.cpu_drama_video);
        }
        return null;
    }
}
