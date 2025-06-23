package com.baidu.navisdk.module.dynamicui.bubble;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.g;
import com.github.appintro.AppIntroBaseFragmentKt;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d extends com.baidu.navisdk.module.dynamicui.i.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7156a = true;
    private String b = null;
    private int c = 0;
    private int d = 1;
    private int e = -1;
    private int f = 0;

    public boolean a() {
        int i;
        int i2;
        return !TextUtils.isEmpty(this.b) && (i = this.c) >= 1 && i <= 8 && (i2 = this.d) >= 1 && i2 <= 63;
    }

    public String toString() {
        return "BubbleStyleParams{anchorTag=" + this.b + ", direction=" + this.c + ", align=" + this.d + ", cancelOnTouchOusSide=" + this.f7156a + ", countDown=" + this.e + ", bgColor=" + this.f + '}';
    }

    public d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.getString("anchor_tag");
            this.c = jSONObject.optInt("direction", 0);
            this.d = jSONObject.optInt("align", 1);
            this.f7156a = jSONObject.optBoolean("cancelOnTouchOutSide", true);
            this.e = jSONObject.optInt("countdown", -1);
            String optString = jSONObject.optString(AppIntroBaseFragmentKt.ARG_BG_COLOR, null);
            if (!TextUtils.isEmpty(optString)) {
                this.f = Color.parseColor(optString);
            }
        } catch (Exception e) {
            g.DYNA_DATA.d("dyna bubble params err:" + e.getLocalizedMessage());
        }
        return this;
    }
}
