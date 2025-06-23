package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.g;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.y;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a extends d implements g {
    private String LY;
    private long LZ;
    private String Ma;
    private Context mContext;

    private void ai(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auc)) {
                jSONObject.put("64_level", 1);
            }
            KWEGIDDFP.handlePolicy(jSONObject);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.f.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                c.d("initGId onSuccess", "deviceInfo：" + str2);
                a.this.oU();
                a.this.ak(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(String str) {
        if (this.mContext != null && !bh.isNullString(str) && !bh.isEquals(oZ(), str)) {
            this.Ma = str;
            y.ag(this.mContext, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU() {
        String co = y.co(this.mContext);
        String NI = bj.NI();
        if (TextUtils.isEmpty(co)) {
            y.Y(this.mContext, NI);
            return;
        }
        if (!TextUtils.equals(co, NI)) {
            this.LY = "";
            this.LZ = 0L;
            this.Ma = "";
            y.X(this.mContext, "");
            y.d(this.mContext, this.LZ);
            y.ag(this.mContext, this.Ma);
            y.Y(this.mContext, NI);
        }
    }

    private String oX() {
        if (TextUtils.isEmpty(this.LY)) {
            this.LY = y.cl(this.mContext);
        }
        return this.LY;
    }

    private long oY() {
        if (this.LZ == 0) {
            this.LZ = y.cm(this.mContext);
        }
        return this.LZ;
    }

    private String oZ() {
        if (TextUtils.isEmpty(this.Ma)) {
            this.Ma = y.cr(this.mContext);
        }
        return this.Ma;
    }

    @Override // com.kwad.sdk.components.g
    public final void al(String str) {
        if (this.mContext != null && !bh.isNullString(str) && !bh.isEquals(oX(), str)) {
            try {
                this.LY = str;
                y.X(this.mContext, str);
                KWEGIDDFP.instance().setEgid(this.mContext, str);
            } catch (Throwable th) {
                c.e("EncryptComponentsImpl", "setEGid error : " + th);
            }
        }
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
        try {
            this.mContext = context;
            ai(context);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.g
    public final String oV() {
        if (!com.kwad.sdk.core.config.d.CG() && System.currentTimeMillis() < oY() && !TextUtils.isEmpty(oX())) {
            return "";
        }
        return oZ();
    }

    @Override // com.kwad.sdk.components.g
    public final com.kwad.sdk.core.a.g oW() {
        return new com.kwad.sdk.core.a.a();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.components.g
    public final void x(long j) {
        if (this.mContext != null && j > 0 && j != oY()) {
            this.LZ = j;
            y.d(this.mContext, j);
        }
    }
}
