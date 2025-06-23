package com.baidu.navisdk.module.newguide.settings;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f7273a = {"沿途搜索", "组队出行", "分享位置", "问题上报", "自定义导航", "个性语音包", "个性车标", "车辆管理"};
    private static final String[] b = {"yantu_search", "zudui", "share", "problem_upload", "diy_navi", "diy_voice", "diy_carIcon", "vehicle_manage"};

    private static int a(String str, JSONObject jSONObject) {
        int i = 0;
        while (true) {
            String[] strArr = f7273a;
            if (i >= strArr.length) {
                return 0;
            }
            if (str.equals(strArr[i])) {
                return jSONObject.optInt(b[i], 0);
            }
            i++;
        }
    }

    public static void a(String str, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        JSONObject jSONObject = com.baidu.navisdk.module.cloudconfig.f.c().c.b0;
        int a2 = (TextUtils.isEmpty(str) || jSONObject == null) ? 0 : a(str, jSONObject);
        if (a2 == 0) {
            imageView.setVisibility(8);
            return;
        }
        if (a2 == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.bn_bg_bubble_new);
            imageView.getLayoutParams().width = ScreenUtil.getInstance().dip2px(41);
        } else {
            if (a2 != 2) {
                return;
            }
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.bn_bg_bubble_update);
            imageView.getLayoutParams().width = ScreenUtil.getInstance().dip2px(32);
        }
    }
}
