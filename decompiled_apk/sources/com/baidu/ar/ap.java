package com.baidu.ar;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.av;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ap implements ARPMessage.MessageHandler {
    private ARPDataInteraction.c hX = new ARPDataInteraction.c() { // from class: com.baidu.ar.ap.1
        @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.c
        public void a(String str, int i, String str2, String str3) {
            SurfaceTexture D = ae.aK().D(str);
            if (D != null) {
                try {
                    if (ae.aK().C(str) != i) {
                        ae.aK().a(str, i);
                    }
                    D.updateTexImage();
                } catch (RuntimeException unused) {
                    ae.aK().a(str, i);
                }
            }
        }
    };
    private Context mContext;

    public ap(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        at.c(applicationContext);
        be();
    }

    private void G(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", str);
        handleMessage(1801, 0, hashMap);
    }

    private void a(ah ahVar) {
        G("phone_call");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + ahVar.getNumber()));
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            this.mContext.startActivity(intent);
        }
    }

    private void b(HashMap<String, Object> hashMap, int i) {
        if (hashMap == null) {
            return;
        }
        aj ajVar = new aj();
        if (hashMap.get("url") != null) {
            ajVar.setUrl(as.a(hashMap.get("url"), (String) null));
        }
        if (hashMap.get("id") != null) {
            ajVar.setId(as.a(hashMap.get("id"), (String) null));
        }
        if (hashMap.get("texture_id") != null) {
            ajVar.h(as.a(hashMap.get("texture_id"), -1));
        }
        if (hashMap.get("loop") != null) {
            int a2 = as.a(hashMap.get("loop"), 0);
            ajVar.f(as.a(hashMap.get("loop"), 0));
            if (a2 <= 0) {
                ajVar.k(true);
            }
        }
        if (hashMap.get("target") != null) {
            ajVar.E(as.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            ajVar.b(as.a(hashMap.get("from_time"), 0));
            Log.e("VideoTest", "bean fromTime: " + ajVar.aN());
        }
        if (i == 1021) {
            ae.aK().a(ajVar, hashMap);
            return;
        }
        if (i == 1023) {
            ae.aK().b(ajVar, hashMap);
        } else if (i == 1025) {
            ae.aK().c(ajVar, hashMap);
        } else {
            if (i != 1027) {
                return;
            }
            ae.aK().d(ajVar, hashMap);
        }
    }

    private void be() {
        ARPEngine.getInstance().setVideoUpdateCallback(this.hX);
    }

    private void e(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String a2 = as.a(hashMap.get("event_name"), "");
        av.a aVar = new av.a();
        if ("load_webview".equals(a2)) {
            aVar.gb = as.a(hashMap.get("texture_id"), 0);
            aVar.width = as.a(hashMap.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY), 0);
            aVar.height = as.a(hashMap.get("height"), 0);
            aVar.url = as.a(hashMap.get("url"), (String) null);
            aVar.f5562io = as.a(hashMap.get("is_remote"), 0) == 1;
            aw.bi().c(aVar);
            return;
        }
        if ("update_webview_js".equals(a2)) {
            aVar.gb = as.a(hashMap.get("texture_id"), 0);
            aVar.ip = as.a(hashMap.get("js_code"), (String) null);
            aw.bi().e(aVar);
        } else if ("load_native_webview".equals(a2)) {
            aVar.url = as.a(hashMap.get("url"), (String) null);
            aVar.f5562io = as.a(hashMap.get("is_remote"), 0) == 1;
            aw.bi().d(aVar);
        }
    }

    private void f(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        ai aiVar = new ai();
        if (hashMap.get("type") != null) {
            aiVar.setType(as.a(hashMap.get("type"), 0));
        }
        if (hashMap.get("interval") != null) {
            aiVar.g(as.a(hashMap.get("interval"), 0));
        }
        if (hashMap.get("pattern") != null) {
            aiVar.setPattern(as.a(hashMap.get("pattern"), (String) null));
        }
        a(aiVar);
    }

    private void g(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        ah ahVar = new ah();
        Object obj = hashMap.get("number");
        if (obj != null) {
            ahVar.F((String) obj);
        }
        a(ahVar);
    }

    public void bd() {
        ARPMessage.getInstance().registerMessageHandler(0, this);
        ARPEngine.getInstance().initDataStore(this.mContext.getSharedPreferences("baiduar_lua_data_store", 0));
    }

    @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 0:
                if (i2 == -2) {
                    ae.aK().aB();
                    aa.aA().aB();
                    return;
                }
                return;
            case 8:
                ARPEngine.getInstance().onCaseLoadCompleted(hashMap);
                return;
            case 9:
                ARPEngine.getInstance().onCaseUnloadCompleted();
                return;
            case 1001:
            case 1003:
            case 1005:
            case 1007:
            case 1012:
                a(hashMap, i);
                return;
            case 1021:
            case 1023:
            case 1025:
            case 1027:
                b(hashMap, i);
                return;
            case 1401:
                g(hashMap);
                return;
            case 1501:
                f(hashMap);
                return;
            case 1901:
                e(hashMap);
                return;
            default:
                return;
        }
    }

    private void a(ai aiVar) {
        G("vibrate");
        int type = aiVar.getType();
        if (type == 0) {
            ad.b(this.mContext).a(aiVar.getInterval());
            return;
        }
        if (type != 1) {
            return;
        }
        long[] jArr = null;
        String[] split = aiVar.getPattern() != null ? aiVar.getPattern().split(",") : null;
        if (split != null && split.length > 0) {
            int length = split.length;
            jArr = new long[length];
            for (int i = 0; i < length; i++) {
                try {
                    jArr[i] = Long.parseLong(split[i]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        ad.b(this.mContext).a(jArr);
    }

    private void a(HashMap<String, Object> hashMap, int i) {
        if (hashMap == null) {
            return;
        }
        af afVar = new af();
        if (hashMap.get("url") != null) {
            afVar.setUrl(as.a(hashMap.get("url"), (String) null));
        }
        if (hashMap.get("delay") != null) {
            afVar.setDelay(((Float) hashMap.get("delay")).floatValue());
        }
        if (hashMap.get("id") != null) {
            afVar.setId(as.a(hashMap.get("id"), (String) null));
        }
        if (hashMap.get("loop") != null) {
            int intValue = ((Integer) hashMap.get("loop")).intValue();
            afVar.f(intValue);
            if (intValue <= 0) {
                afVar.k(true);
            }
        }
        if (hashMap.get("target") != null) {
            afVar.E(as.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            afVar.b(as.a(hashMap.get("from_time"), 0));
        }
        if (i == 1001) {
            aa.aA().a(afVar, hashMap);
            return;
        }
        if (i == 1003) {
            aa.aA().b(afVar, hashMap);
            return;
        }
        if (i == 1005) {
            aa.aA().c(afVar, hashMap);
        } else if (i == 1007) {
            aa.aA().d(afVar, hashMap);
        } else {
            if (i != 1012) {
                return;
            }
            aa.aA().e(afVar, hashMap);
        }
    }
}
