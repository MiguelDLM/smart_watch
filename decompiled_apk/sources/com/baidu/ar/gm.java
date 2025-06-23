package com.baidu.ar;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.obr.OBRConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpHead;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class gm {
    private final fs F;
    private String mBaseUrl;
    private Context mContext;
    private String mDirectory;
    ft sB;
    private OBRConfig uZ;
    private int vb = 0;
    private long vc = 0;
    private HashMap<String, Long> vd = new HashMap<>();
    private gi ve = new gi() { // from class: com.baidu.ar.gm.2
        @Override // com.baidu.ar.gi
        public void aP(String str) {
            String str2 = gm.this.mDirectory + gm.this.aU(str);
            gm.this.aT("OBRDownloader download success result : " + str);
            if (gm.this.va != null) {
                gm.this.va.aN(str);
            }
            if (gm.this.vd.get(str) != null) {
                gm.this.vd.put(str, Long.valueOf(System.currentTimeMillis() - ((Long) gm.this.vd.get(str)).longValue()));
            }
            gm.this.a("response_obr_path", "obr_path", str2, str);
        }

        @Override // com.baidu.ar.gi
        public void aQ(String str) {
            String str2 = gm.this.mDirectory + gm.this.aU(str);
            gm.this.aT("OBRDownloader download failed result : " + str);
            gm.this.a("response_obr_failure", "obr_failure", str2, str);
        }
    };
    private gh uY = gl.eJ();
    private gg va = gl.eK();

    public gm(Context context, fs fsVar, OBRConfig oBRConfig) {
        this.mBaseUrl = null;
        this.mContext = context;
        this.F = fsVar;
        eM();
        if (oBRConfig != null) {
            this.uZ = oBRConfig;
            this.mBaseUrl = oBRConfig.getBaseUrl();
            this.mDirectory = oBRConfig.getDirectory();
            gh ghVar = this.uY;
            if (ghVar != null) {
                ghVar.h(context);
                if (oBRConfig.isLogEnable()) {
                    kf.c("OBRModule", "OBRDownloader open Success");
                }
                try {
                    this.va.a(oBRConfig.getBaseUrl(), oBRConfig.getDirectory(), oBRConfig.getMaxSize());
                    if (oBRConfig.isLogEnable()) {
                        kf.c("OBRModule", "OBRCache open Success");
                        this.uY.setDebug(true);
                        this.va.setDebug(true);
                    }
                } catch (Exception e) {
                    if (oBRConfig.isLogEnable()) {
                        kf.c("OBRModule", "OBRCache open failed : " + e.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(String str) {
        OBRConfig oBRConfig = this.uZ;
        if (oBRConfig == null || !oBRConfig.isLogEnable()) {
            return;
        }
        kf.c("OBRModule", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aU(String str) {
        Uri parse = Uri.parse(str);
        parse.getScheme();
        parse.getAuthority();
        return parse.getPath();
    }

    private boolean aV(String str) {
        if (this.va.aM(str)) {
            String aW = aW(str);
            if (!TextUtils.isEmpty(aW)) {
                return p(aW, str);
            }
        }
        return false;
    }

    private String aW(String str) {
        if (this.uZ == null || this.mBaseUrl == null) {
            return str;
        }
        return this.mBaseUrl + str;
    }

    private void eM() {
        ft ftVar = new ft() { // from class: com.baidu.ar.gm.1
            @Override // com.baidu.ar.ft
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i == 8200) {
                    gm.this.aT("OBRModule receive msg : 8200");
                    gm.this.l(hashMap);
                }
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                return Arrays.asList(Integer.valueOf(ARPMessageType.MSG_TYPE_OBR_TO_SDK));
            }
        };
        this.sB = ftVar;
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.c(ftVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get("event_name");
            aT("OBRModule receive msg : " + str);
            HashMap hashMap2 = (HashMap) hashMap.get("event_data");
            if (hashMap2 != null) {
                if (!TextUtils.equals(str, "engine_request_download")) {
                    TextUtils.equals(str, "engine_request_json");
                    return;
                }
                String str2 = (String) hashMap2.get("url");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    aT("obr empty url received form engine");
                    return;
                }
                if (str2.startsWith(com.huawei.openalliance.ad.constant.x.cD)) {
                    return;
                }
                aT("OBRModule receive download msg : " + str2);
                if (this.vd.keySet().size() == 0) {
                    this.vc = System.currentTimeMillis();
                }
                this.vd.put(str2, Long.valueOf(System.currentTimeMillis()));
                a(str2, this.ve);
            }
        }
    }

    private boolean p(String str, String str2) {
        try {
            IHttpRequest newRequest = HttpFactory.newRequest();
            if (newRequest == null) {
                return false;
            }
            return this.va.o(newRequest.setUrl(str).setMethod(HttpHead.METHOD_NAME).execute().getHeader("Last-Modified"), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void eL() {
        HashMap hashMap = new HashMap();
        hashMap.put("gesture_scroll", "interaction_obr_move");
        hashMap.put("gesture_two_finger_scroll", "interaction_obr_rotate");
        hashMap.put("gesture_two_finger_rotate", "interaction_obr_rotate");
        hashMap.put("gesture_two_finger_pinch", "interaction_obr_scale_down");
        hashMap.put("gesture_two_finger_unpinch", "interaction_obr_scale_up");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("continuous_mapping", hashMap);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap2);
    }

    public void pause() {
        gh ghVar = this.uY;
        if (ghVar != null) {
            ghVar.pause();
        }
    }

    public void release() {
        gl.release();
        this.uZ = null;
        this.uY = null;
        this.va = null;
        this.mContext = null;
    }

    public void resume() {
        gh ghVar = this.uY;
        if (ghVar != null) {
            ghVar.resume();
        }
    }

    public void setDownloadComplete() {
        int i = 0;
        long j = 0;
        for (String str : this.vd.keySet()) {
            i++;
            long longValue = this.vd.get(str).longValue();
            j += longValue;
            long j2 = longValue / 1000;
            aT("下载（" + str + "）所需时间：" + ((int) ((j2 / 60) % 60)) + ":" + ((int) (j2 % 60)) + FileUtils.FILE_EXTENSION_SEPARATOR + (longValue % 1000));
        }
        long j3 = j / i;
        long j4 = j3 / 1000;
        aT("下载（" + i + "）个模型所需平均时间：" + ((int) ((j4 / 60) % 60)) + ":" + ((int) (j4 % 60)) + FileUtils.FILE_EXTENSION_SEPARATOR + (j3 % 1000));
        if (this.vc != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.vc;
            long j5 = currentTimeMillis / 1000;
            aT("下载（" + i + "）个模型总共需要时间：" + ((int) ((j5 / 60) % 60)) + ":" + ((int) (j5 % 60)) + FileUtils.FILE_EXTENSION_SEPARATOR + (currentTimeMillis % 1000));
        }
    }

    public void a(String str, gi giVar) {
        gh ghVar;
        StringBuilder sb;
        String aU = aU(str);
        gg ggVar = this.va;
        if (ggVar == null || this.uY == null) {
            return;
        }
        if (ggVar.aL(aU)) {
            aT("OBRModule download check file exist");
            if (!aV(str)) {
                aT("OBRModule download check file is fresh");
                giVar.aP(str);
                return;
            } else {
                aT("OBRModule download check file is expired");
                this.va.aO(str);
                ghVar = this.uY;
                sb = new StringBuilder();
            }
        } else {
            ghVar = this.uY;
            sb = new StringBuilder();
        }
        sb.append(this.mDirectory);
        sb.append(aU);
        ghVar.a(str, sb.toString(), giVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str2, str3);
        hashMap2.put("url", aW(str4));
        hashMap.put("event_data", hashMap2);
        aT("OBRModule send message to engine : " + hashMap.toString());
        this.F.b(ARPMessageType.MSG_TYPE_SDK_TO_OBR, hashMap);
    }
}
