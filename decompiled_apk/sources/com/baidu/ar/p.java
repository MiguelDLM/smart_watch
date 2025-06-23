package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.callback.ICallbackWith;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class p {
    private static final String TAG = "p";
    private JSONObject eI;
    private JSONObject eJ;
    private t eK;
    private String eL;
    private ICallbackWith<String> eM;
    private Context mContext;

    public p(Context context) {
        this.eL = "default";
        if (context != null) {
            this.mContext = context.getApplicationContext();
            o a2 = s.a(context);
            if (a2 != null) {
                this.eI = a2.eH;
                this.eL = a2.eG;
            }
        }
    }

    private int as() {
        int ar = q.ar();
        if (ar != 1) {
            return ar != 2 ? 4999 : 8001;
        }
        return 5001;
    }

    public JSONObject aq() {
        if (this.eJ == null) {
            kf.c(TAG, "use inner config: " + this.eI);
            return this.eI;
        }
        kf.c(TAG, "use outter config: " + this.eJ);
        return this.eJ;
    }

    public int ar() {
        return q.ar();
    }

    public void c(JSONObject jSONObject) {
        this.eJ = jSONObject;
    }

    public Map<String, Object> getGradingInfo() {
        JSONObject aq;
        HashMap hashMap = new HashMap();
        if (aq() == null || (aq = aq()) == null || !aq.has("common")) {
            hashMap.put("cpu_score", Integer.valueOf(as()));
            return hashMap;
        }
        try {
            JSONObject jSONObject = aq.getJSONObject("common");
            hashMap.put("cpu_score", jSONObject.has("cpu_score") ? Integer.valueOf(jSONObject.getInt("cpu_score")) : Integer.valueOf(as()));
        } catch (JSONException e) {
            e.printStackTrace();
            hashMap.put("cpu_score", Integer.valueOf(as()));
        }
        return hashMap;
    }

    public void release() {
        this.eM = null;
        t tVar = this.eK;
        if (tVar != null) {
            tVar.cancel();
            this.eK = null;
        }
        this.mContext = null;
    }

    public void a(ICallbackWith<String> iCallbackWith) {
        this.eM = iCallbackWith;
    }

    public void b(final ICallbackWith<JSONObject> iCallbackWith) {
        t tVar = new t();
        this.eK = tVar;
        tVar.c(new ICallbackWith<String>() { // from class: com.baidu.ar.p.1
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public void run(String str) {
                if (p.this.eM != null) {
                    p.this.eM.run(str);
                }
            }
        });
        this.eK.a(this.mContext, this.eL, new ICallbackWith<o>() { // from class: com.baidu.ar.p.2
            @Override // com.baidu.ar.callback.ICallbackWith
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void run(o oVar) {
                p.this.eK = null;
                p.this.a(oVar);
                ICallbackWith iCallbackWith2 = iCallbackWith;
                if (iCallbackWith2 == null || oVar == null) {
                    return;
                }
                iCallbackWith2.run(oVar.eH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        Context context;
        if (oVar == null || (context = this.mContext) == null) {
            return;
        }
        this.eL = oVar.eG;
        this.eI = oVar.eH;
        s.a(context, oVar);
    }
}
