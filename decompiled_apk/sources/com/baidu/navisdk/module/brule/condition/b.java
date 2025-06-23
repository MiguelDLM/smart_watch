package com.baidu.navisdk.module.brule.condition;

import com.baidu.navisdk.behavrules.condition.f;
import com.baidu.navisdk.behavrules.condition.j;
import com.baidu.navisdk.behavrules.condition.k;
import com.baidu.navisdk.behavrules.d;
import com.baidu.navisdk.behavrules.scene.c;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b extends f {
    protected int d;
    private long e;
    private int f;

    /* loaded from: classes7.dex */
    public static class a implements k {
        @Override // com.baidu.navisdk.behavrules.condition.k
        public j a(String str, c cVar) {
            try {
                b bVar = new b(cVar);
                JSONObject jSONObject = new JSONObject(str);
                bVar.d = jSONObject.getInt("priority");
                bVar.f = jSONObject.optInt("overtime") * 1000;
                return bVar;
            } catch (JSONException e) {
                g gVar = g.ASR;
                if (gVar.e()) {
                    gVar.g("behavRulesBNAsrProrityStratgy", "parse(), json = " + str + " scene = " + cVar);
                }
                e.printStackTrace();
                return null;
            }
        }
    }

    public b(c cVar) {
        super(cVar);
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public d l() {
        int i = this.d;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return d.ERROR_STOP;
                    }
                    if (!TTSPlayerControl.getTTSPlayStatus() && com.baidu.navisdk.module.brule.business.util.c.b() >= 10) {
                        return d.SUCCESS;
                    }
                    return d.ERROR_RESETVALUE;
                }
                if (!TTSPlayerControl.getTTSPlayStatus() && com.baidu.navisdk.module.brule.business.util.c.b() >= 10) {
                    return d.SUCCESS;
                }
                g gVar = g.ASR;
                if (gVar.d()) {
                    gVar.e("behavRulesBNAsrProrityStratgy", "isAllMatched(), 下个诱导播报时间短, 添加到TTS监听");
                }
                if (com.baidu.navisdk.module.brule.business.util.c.a().a(this)) {
                    this.e = System.currentTimeMillis();
                }
                return d.ERROR_WAIT;
            }
            if (TTSPlayerControl.getTTSPlayStatus()) {
                g gVar2 = g.ASR;
                if (gVar2.d()) {
                    gVar2.e("behavRulesBNAsrProrityStratgy", "isAllMatched(), 添加到TTS监听");
                }
                com.baidu.navisdk.module.brule.business.util.c.a().b(this);
                return d.ERROR_WAIT;
            }
            return d.SUCCESS;
        }
        return d.SUCCESS;
    }

    @Override // com.baidu.navisdk.behavrules.condition.f
    public void o() {
    }

    @Override // com.baidu.navisdk.behavrules.condition.f
    public void p() {
        com.baidu.navisdk.module.brule.business.util.c.a().c(this);
        com.baidu.navisdk.module.brule.business.util.c.a().d(this);
    }

    public boolean q() {
        if (System.currentTimeMillis() - this.e >= this.f) {
            return true;
        }
        return false;
    }

    public void r() {
        c cVar = this.f6639a;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void s() {
        c cVar = this.f6639a;
        if (cVar != null && cVar.k()) {
            this.f6639a.run();
        }
    }
}
