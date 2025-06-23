package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.facebook.share.internal.ShareConstants;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.entity.Languages;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public final class BGEMKt {
    @OOXIXo
    public static final String getInsights(@OOXIXo BloodGlucose2 data) {
        IIX0o.x0xO0oo(data, "data");
        try {
            JSONObject jSONObject = new JSONObject(data.getMLocaleInsights());
            String string = jSONObject.getString(Languages.DEFAULT_LANGUAGE);
            jSONObject.getString("id");
            String string2 = jSONObject.getString(Languages.DEFAULT_LANGUAGE_ZH);
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            if (UtilsKt.IO(app)) {
                IIX0o.ooOOo0oXI(string2);
                return string2;
            }
            IIX0o.ooOOo0oXI(string);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return data.getMInsights();
        }
    }

    @OOXIXo
    public static final String getInsightsTip(@OOXIXo BloodGlucose2 data) {
        IIX0o.x0xO0oo(data, "data");
        try {
            JSONObject jSONObject = new JSONObject(data.getMLocaleTips());
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            if (UtilsKt.IO(app)) {
                JSONArray jSONArray = jSONObject.getJSONArray(Languages.DEFAULT_LANGUAGE_ZH);
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    jSONObject2.getInt("id");
                    String string = jSONObject2.getString(ShareConstants.FEED_CAPTION_PARAM);
                    IIX0o.ooOOo0oXI(string);
                    return string;
                }
            } else {
                JSONArray jSONArray2 = jSONObject.getJSONArray(Languages.DEFAULT_LANGUAGE);
                if (jSONArray2.length() > 0) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(0);
                    jSONObject3.getInt("id");
                    String string2 = jSONObject3.getString(ShareConstants.FEED_CAPTION_PARAM);
                    IIX0o.ooOOo0oXI(string2);
                    return string2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.getMTips();
    }
}
