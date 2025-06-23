package com.baidu.navisdk.module.dynamicui.dialog;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d extends com.baidu.navisdk.module.dynamicui.i.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7159a = true;
    private int b = -1;
    private int c = -1;
    private int d = -1;

    public d a(String str) {
        String[] split;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f7159a = jSONObject.optBoolean("cancelOnTouchOutSide", true);
            this.d = jSONObject.optInt("countdown", -1) * 1000;
            String optString = jSONObject.optString(RequestParameters.POSITION);
            if (!TextUtils.isEmpty(optString) && (split = optString.split(HelpFormatter.DEFAULT_OPT_PREFIX)) != null && split.length == 2) {
                this.b = Integer.valueOf(split[0]).intValue();
                this.c = Integer.valueOf(split[1]).intValue();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String toString() {
        return "DynaUIDialogParams{cancaelOnTouchOusSide=" + this.f7159a + ", positionX=" + this.b + ", positionY=" + this.c + ", countDown=" + this.d + '}';
    }
}
