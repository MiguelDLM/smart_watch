package com.baidu.ar;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class fv {
    private fs F;
    private ft sB;
    private LuaMsgListener tK;
    private DefinedLuaListener tL;

    public fv(fs fsVar) {
        if (fsVar == null) {
            return;
        }
        this.F = fsVar;
        ej();
        if (this.tK == null) {
            this.tK = new LuaMsgListener() { // from class: com.baidu.ar.fv.1
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    return Arrays.asList("id", "event_name");
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (fv.this.tL == null || fv.this.j(hashMap)) {
                        return;
                    }
                    fv.this.k(hashMap);
                }
            };
        }
        if (fsVar.ei() != null) {
            fsVar.ei().addLuaMsgListener(this.tK);
        }
    }

    private void ej() {
        ft ftVar = new ft() { // from class: com.baidu.ar.fv.2
            @Override // com.baidu.ar.ft
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i != 1301 || fv.this.tL == null) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                fv.this.tL.onOpenUrl((String) hashMap.get("url"), intValue, hashMap);
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                return Arrays.asList(1301);
            }
        };
        this.sB = ftVar;
        this.F.c(ftVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("event_name");
        if (TextUtils.isEmpty(str) || !"camera_switch".equals(str)) {
            return false;
        }
        String str2 = (String) hashMap.get("camera_action");
        Log.d("LuaMsgHelper", "swichCameraByEvent cameraFace = " + str2);
        if ("front".equals(str2)) {
            this.tL.onRequireSwitchCamera(1);
        } else if ("back".equals(str2)) {
            this.tL.onRequireSwitchCamera(0);
        } else {
            this.tL.onRequireSwitchCamera(-1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(HashMap<String, Object> hashMap) {
        int a2 = as.a(hashMap.get("id"), -1);
        Log.d("LuaMsgHelper", "switchCameraById id = " + a2);
        if (a2 != 10202) {
            return false;
        }
        this.tL.onRequireSwitchCamera(-1);
        return true;
    }

    public void release() {
        fs fsVar = this.F;
        if (fsVar != null) {
            if (this.tK != null) {
                fsVar.ei().removeLuaMsgListener(this.tK);
                this.tK = null;
            }
            ft ftVar = this.sB;
            if (ftVar != null) {
                this.F.d(ftVar);
                this.sB = null;
            }
            this.F = null;
        }
        this.tL = null;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.tL = definedLuaListener;
    }
}
