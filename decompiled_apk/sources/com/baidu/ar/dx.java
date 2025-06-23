package com.baidu.ar;

import com.baidu.ar.dp;
import com.baidu.ar.dr;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dx {
    private dt pU = new dw();
    private boolean pV;
    private dv pn;

    public dx(dv dvVar) {
        this.pn = dvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(String str) {
        char c;
        String str2;
        try {
            dq ai = dq.ai(str);
            if (ai == null) {
                return;
            }
            String action = ai.getAction();
            switch (action.hashCode()) {
                case -1072073501:
                    if (action.equals("AUDIO_QUERY_INTERRUPT")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -619950265:
                    if (action.equals("THREEJS")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 291286536:
                    if (action.equals("DOWN_CLIENT")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1669334218:
                    if (action.equals("CONNECT")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2079549205:
                    if (action.equals("DOWN_SUBTITLE")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c == 1) {
                    if (this.pV) {
                        return;
                    }
                    dr.b g = ai.isSuccess() ? dr.b.g(new JSONObject(ai.getBody())) : null;
                    dv dvVar = this.pn;
                    if (dvVar != null) {
                        dvVar.a(g);
                        return;
                    }
                    return;
                }
                if (c == 2) {
                    if (ai.isSuccess()) {
                        dv dvVar2 = this.pn;
                        if (dvVar2 != null) {
                            dvVar2.a(ai);
                            return;
                        }
                        return;
                    }
                    dv dvVar3 = this.pn;
                    if (dvVar3 != null) {
                        dvVar3.a((dq) null);
                        return;
                    }
                    return;
                }
                if (c == 3) {
                    dr.a f = ai.isSuccess() ? dr.a.f(new JSONObject(ai.getBody())) : null;
                    dv dvVar4 = this.pn;
                    if (dvVar4 != null) {
                        dvVar4.a(f);
                        return;
                    }
                    return;
                }
                if (c != 4) {
                    return;
                } else {
                    str2 = "record stop";
                }
            } else {
                str2 = "socket is connected";
            }
            kf.c("DIGITAL_STATE", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2) {
        dp.a aVar = new dp.a();
        aVar.setAppId(str);
        aVar.ad(str2);
        dp.b bVar = new dp.b();
        bVar.af("CONNECT");
        bVar.ag("arkit");
        bVar.ae("conn" + System.currentTimeMillis());
        bVar.ah(aVar.cZ().toString());
        dt dtVar = this.pU;
        if (dtVar != null) {
            dtVar.an(bVar.cZ().toString());
        }
    }

    public void c(String str, final String str2, final String str3) {
        this.pU.am(str);
        this.pU.b(new du() { // from class: com.baidu.ar.dx.1
            @Override // com.baidu.ar.du
            public void a(int i, String str4, boolean z) {
            }

            @Override // com.baidu.ar.du
            public void al(String str4) {
                dx.this.ao(str4);
            }

            @Override // com.baidu.ar.du
            public void onError(int i, String str4) {
                kf.cj(str4);
                if (dx.this.pn != null) {
                    dx.this.pn.b(i, str4);
                }
            }

            @Override // com.baidu.ar.du
            public void onOpen() {
                dx.this.h(str2, str3);
                if (dx.this.pn != null) {
                    dx.this.pn.u(true);
                }
            }
        });
        this.pU.di();
    }

    public void dn() {
        String str = "msg" + System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(com.huawei.openalliance.ad.constant.aw.S, str);
        hashMap.put("action", "AUDIO_QUERY_INTERRUPT");
        String jSONObject = new JSONObject(hashMap).toString();
        dt dtVar = this.pU;
        if (dtVar != null) {
            dtVar.an(jSONObject);
        }
    }

    public void i(String str, String str2) {
        this.pV = false;
        String ap = ea.ds().ap(str);
        dp.b bVar = new dp.b();
        bVar.ae("msg" + System.currentTimeMillis());
        bVar.af(str2);
        bVar.ag("arkit");
        bVar.ah(ap);
        String jSONObject = bVar.cZ().toString();
        this.pU.an(jSONObject);
        dv dvVar = this.pn;
        if (dvVar != null) {
            dvVar.ab(jSONObject);
        }
    }

    public void pause() {
        dt dtVar = this.pU;
        if (dtVar != null) {
            dtVar.onPause();
        }
    }

    public void release() {
        dt dtVar = this.pU;
        if (dtVar != null) {
            dtVar.release();
        }
    }

    public void resume() {
        dt dtVar = this.pU;
        if (dtVar != null) {
            dtVar.onResume();
        }
    }

    public void h(byte[] bArr) {
        dt dtVar = this.pU;
        if (dtVar != null) {
            if (bArr != null) {
                this.pV = true;
                dtVar.g(bArr);
            } else {
                dn();
                this.pV = false;
            }
        }
    }
}
