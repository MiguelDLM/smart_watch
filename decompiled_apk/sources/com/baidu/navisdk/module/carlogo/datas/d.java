package com.baidu.navisdk.module.carlogo.datas;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.openalliance.ad.constant.x;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f7077a;
    public String b;
    public String c;
    public String d;
    public int e = 1;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public a[] m;

    public boolean a(JSONObject jSONObject) {
        int length;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDOriginalModel", "parseJson: " + jSONObject);
        }
        if (jSONObject == null) {
            return false;
        }
        this.f7077a = jSONObject.optInt("id", -1);
        this.b = jSONObject.optString("title", "");
        this.c = jSONObject.optString(x.cD, "");
        this.d = jSONObject.optString("desc", "");
        this.f = jSONObject.optInt("used", 0) == 1;
        this.e = jSONObject.optInt("type", -1);
        this.g = jSONObject.optString("used_color_id", null);
        JSONObject optJSONObject = jSONObject.optJSONObject("extra");
        if (optJSONObject == null) {
            return false;
        }
        this.h = optJSONObject.optString("default_color_id", null);
        this.i = optJSONObject.optString("3d_zip", null);
        this.j = optJSONObject.optString(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, null);
        this.k = optJSONObject.optString("3d_gif", null);
        String optString = optJSONObject.optString("3d_night_gif", null);
        this.l = optString;
        if (TextUtils.isEmpty(optString)) {
            this.l = this.k;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("color_list");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return false;
        }
        this.m = new a[length];
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
            if (optJSONObject2 != null) {
                a aVar = new a();
                this.m[i] = aVar;
                String optString2 = optJSONObject2.optString("color_id", null);
                aVar.d = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    aVar.d = aVar.d.trim();
                }
                aVar.f7075a = aVar.d + ".gif";
                aVar.b = aVar.d + "_night.gif";
                aVar.e = aVar.d + ".mtl";
                String optString3 = optJSONObject2.optString("color_value", null);
                if (!TextUtils.isEmpty(optString3)) {
                    try {
                        aVar.c = Color.parseColor(optString3.trim());
                    } catch (Throwable th) {
                        LogUtil.e("ThreeDOriginalModel", th.getMessage());
                    }
                }
            }
        }
        return true;
    }

    public int b() {
        a[] aVarArr;
        if (this.f && !TextUtils.isEmpty(this.g) && (aVarArr = this.m) != null) {
            for (a aVar : aVarArr) {
                if (aVar != null && this.g.equals(aVar.d)) {
                    return aVar.c;
                }
            }
        }
        return -1;
    }

    public boolean c() {
        a[] aVarArr = this.m;
        if (aVarArr != null && aVarArr.length > 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        a[] aVarArr;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDOriginalModel", "isValid: " + toString());
        }
        if (this.f7077a >= 0 && !TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.k) && (aVarArr = this.m) != null && aVarArr.length > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ThreeDOriginalModel{id=" + this.f7077a + ", title='" + this.b + "', iconUrl='" + this.c + "', desc='" + this.d + "', type=" + this.e + ", isUsed=" + this.f + ", usedColorId='" + this.g + "', defaultShowColorId='" + this.h + "', zipUrl='" + this.i + "', zipSize='" + this.j + "', default3DGifUrl='" + this.k + "', default3DNightGifUrl='" + this.l + "', gifArrays=" + Arrays.toString(this.m) + '}';
    }

    public int a() {
        int i;
        a[] aVarArr = this.m;
        if (aVarArr == null || aVarArr.length <= 0) {
            return -1;
        }
        String str = this.h;
        if (this.f && !TextUtils.isEmpty(this.g)) {
            str = this.g;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDOriginalModel", "getCurrentColorValue currentColor: " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : this.m) {
                if (aVar != null && str.equals(aVar.d)) {
                    i = aVar.c;
                    break;
                }
            }
        }
        i = -1;
        return i == -1 ? this.m[0].c : i;
    }

    public String a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDOriginalModel", "getColorIdByValue: " + i);
        }
        a[] aVarArr = this.m;
        if (aVarArr == null || aVarArr.length <= 0) {
            return null;
        }
        for (a aVar : aVarArr) {
            if (aVar != null && aVar.c == i) {
                return aVar.d;
            }
        }
        return null;
    }
}
