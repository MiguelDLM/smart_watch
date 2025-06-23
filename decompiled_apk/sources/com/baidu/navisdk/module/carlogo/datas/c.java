package com.baidu.navisdk.module.carlogo.datas;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.s;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class c extends d {
    public int n;
    public String o;
    public int p = 2;
    public int q = 0;

    public boolean a(JSONObject jSONObject, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "handleData: " + jSONObject + ", isRecommend:" + z);
        }
        if (jSONObject == null) {
            return false;
        }
        boolean a2 = a(jSONObject);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "handleData: " + a2);
        }
        if (!a2) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "handleData: " + super.toString());
        }
        if (!d()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("ThreeDModel", "handleData !isValid() ");
            }
            return false;
        }
        if (z) {
            this.f = true;
        }
        String c = com.baidu.navisdk.module.carlogo.a.c(this.i, "");
        if (TextUtils.isEmpty(c)) {
            this.p = 2;
            this.o = null;
        } else {
            this.p = 1;
            this.o = c;
            j();
        }
        this.n = a();
        return true;
    }

    @Nullable
    public String e() {
        a[] aVarArr = this.m;
        String str = null;
        if (aVarArr != null && aVarArr.length != 0) {
            for (a aVar : aVarArr) {
                if (aVar != null && aVar.c == this.n) {
                    str = aVar.e;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("ThreeDModel", "getClickedConfigName: " + str);
            }
            return str;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "getClickedConfigName gifArrays == null ");
        }
        return null;
    }

    public String f() {
        return a(this.n);
    }

    public boolean g() {
        if (this.p == 1) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.p == 3) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f && (!c() || b() == this.n)) {
            return true;
        }
        return false;
    }

    public void j() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "updateDownloadedGifPath: " + this.m);
        }
        a[] aVarArr = this.m;
        if (aVarArr == null) {
            return;
        }
        for (a aVar : aVarArr) {
            if (aVar != null) {
                if (aVar.f7075a.contains(this.o)) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("ThreeDModel", "updateDownloadedGifPath gifPath had contains unzipFilePath");
                        return;
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.o);
                String str = File.separator;
                sb.append(str);
                sb.append(aVar.f7075a);
                aVar.f7075a = sb.toString();
                aVar.b = this.o + str + aVar.b;
            }
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.datas.d
    public String toString() {
        return "ThreeDModel{originalModel=" + super.toString() + ", userClickedColorValue=" + this.n + ", unzipFilePath='" + this.o + "', downloadStatus=" + this.p + ", downloadProgress=" + this.q + '}';
    }

    @Nullable
    public String a(boolean z) {
        a[] aVarArr;
        a aVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "getCurrentGifUrl isDay: " + z);
        }
        if (TextUtils.isEmpty(this.o) || this.p != 1 || (aVarArr = this.m) == null || aVarArr.length == 0) {
            return z ? this.k : this.l;
        }
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                aVar = null;
                break;
            }
            aVar = aVarArr[i];
            if (aVar != null && aVar.c == this.n) {
                break;
            }
            i++;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ThreeDModel", "getCurrentGifUrl: " + aVar);
        }
        if (aVar == null) {
            return z ? this.k : this.l;
        }
        if (z) {
            return aVar.f7075a;
        }
        if (!TextUtils.isEmpty(aVar.b) && s.d(aVar.b)) {
            return aVar.b;
        }
        return aVar.f7075a;
    }
}
