package com.baidu.ar.recg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.gy;
import com.baidu.ar.hh;
import com.baidu.ar.hj;
import com.baidu.ar.hl;
import com.baidu.ar.hm;
import com.baidu.ar.kf;
import com.baidu.ar.kg;
import com.baidu.ar.km;
import com.baidu.ar.ks;
import com.baidu.ar.kw;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ImageRecognitionManager implements hl {
    private static final String TAG = "ImageRecognitionManager";
    private static volatile boolean vs = false;
    private Context mContext;
    private hm vq = new hm();
    private ImageRecognitionCallback vr;
    private String vt;
    private String vu;
    private String vv;
    private hj vw;
    private String vx;

    private static void B(boolean z) {
        vs = z;
    }

    public void initRecognition(Context context, ImageRecognitionCallback imageRecognitionCallback) {
        this.mContext = context;
        this.vr = imageRecognitionCallback;
        this.vx = km.o(context);
        hm hmVar = this.vq;
        if (hmVar != null) {
            hmVar.a(this);
            HashMap<String, Object> hashMap = new HashMap<>();
            ks.a(context, hashMap);
            hashMap.put(HttpConstants.HTTP_ENGINE_VERSION, String.valueOf(kg.getVersionCode()));
            hashMap.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
            this.vq.b(kw.hr(), hashMap);
        }
    }

    public void onDetected(gy gyVar) {
        this.vq.onDetected(gyVar);
    }

    @Override // com.baidu.ar.hl
    public void onFeatureFilesInit(boolean z) {
        B(z);
        ImageRecognitionCallback imageRecognitionCallback = this.vr;
        if (imageRecognitionCallback != null) {
            imageRecognitionCallback.onFeatureDBInit(z);
        }
    }

    @Override // com.baidu.ar.hl
    public void onFeatureFilesUnzip(boolean z) {
        if (!z) {
            kf.cj("unzip failed");
            return;
        }
        hm hmVar = this.vq;
        if (hmVar != null) {
            hmVar.q(this.vu, this.vv);
        }
    }

    @Override // com.baidu.ar.hl
    public void onFeatureJsonParse(boolean z) {
    }

    @Override // com.baidu.ar.hl
    public void onFeaturesClear(boolean z) {
        B(!z);
    }

    @Override // com.baidu.ar.hl
    public void onResourceDownload(boolean z, String str) {
        if (z) {
            new hh(this.mContext).aZ(str);
        }
        ImageRecognitionCallback imageRecognitionCallback = this.vr;
        if (imageRecognitionCallback != null) {
            imageRecognitionCallback.onResourceDownload(z);
        }
    }

    @Override // com.baidu.ar.hl
    public void onResourceRequest(hj hjVar) {
        ImageRecognitionCallback imageRecognitionCallback;
        if (hjVar == null || this.mContext == null || (imageRecognitionCallback = this.vr) == null) {
            kf.cl("onResourceRequest error!!! response == null");
            return;
        }
        try {
            this.vw = hjVar;
            imageRecognitionCallback.onSoLoadDownloadStart();
            if (this.vw.isSuccess()) {
                String eX = new hh(this.mContext).eX();
                String fa = this.vw.fc().fa();
                String substring = this.vw.fc().eZ().substring(this.vw.fc().eZ().lastIndexOf("/"));
                this.vt = this.vx + "/feature";
                this.vu = this.vt + "/fea.json";
                String str = this.vt + "/fea";
                this.vv = str;
                ARConfig.sFeaPointsDir = str;
                File file = new File(this.vt + "/" + substring);
                if (this.vq != null) {
                    if (!TextUtils.isEmpty(eX) && eX.equals(fa) && file.exists()) {
                        this.vq.b(this.vw.fc(), this.vt);
                    }
                    ImageRecognitionCallback imageRecognitionCallback2 = this.vr;
                    if (imageRecognitionCallback2 != null) {
                        imageRecognitionCallback2.onFeatureDownloadStart();
                    }
                    this.vq.a(this.vw.fc(), this.vt);
                }
            }
            ImageRecognitionCallback imageRecognitionCallback3 = this.vr;
            if (imageRecognitionCallback3 != null) {
                imageRecognitionCallback3.onResourceRequest(this.vw.isSuccess(), this.vw.getErrorCode(), this.vw.fb());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.hl
    public void onThreadQuit() {
    }

    @Override // com.baidu.ar.hl
    public void onYuvImageSearch(boolean z, String str, String str2) {
        ImageRecognitionCallback imageRecognitionCallback = this.vr;
        if (imageRecognitionCallback != null) {
            imageRecognitionCallback.onRecognizeResult(z, str, str2);
        }
    }

    public void recognizeFrame(int i, int i2, byte[] bArr) {
        hm hmVar;
        if (!vs || (hmVar = this.vq) == null) {
            return;
        }
        hmVar.a(i, i2, bArr);
    }

    public void release() {
        this.mContext = null;
        this.vr = null;
    }

    public void startRecognition() {
        hm hmVar;
        if (TextUtils.isEmpty(this.vu) || TextUtils.isEmpty(this.vv) || (hmVar = this.vq) == null) {
            return;
        }
        hmVar.a(this);
        this.vq.q(this.vu, this.vv);
    }

    public void stopRecognition() {
        hm hmVar = this.vq;
        if (hmVar != null) {
            hmVar.fe();
            this.vq.quit();
        }
    }
}
