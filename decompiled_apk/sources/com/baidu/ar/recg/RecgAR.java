package com.baidu.ar.recg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.camera.CameraManager;
import com.baidu.ar.d;
import com.baidu.ar.dc;
import com.baidu.ar.df;
import com.baidu.ar.dk;
import com.baidu.ar.gx;
import com.baidu.ar.gy;
import com.baidu.ar.hb;
import com.baidu.ar.he;
import com.baidu.ar.hf;
import com.baidu.ar.kf;
import com.baidu.ar.km;
import com.baidu.ar.kq;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public class RecgAR extends d implements IOnDeviceIR {
    private ImageRecognitionManager vB;
    private hb vD;
    private df vE;
    private IOnDeviceIRStateChangedListener vF;
    private ExecutorService ns = Executors.newSingleThreadExecutor();
    private int vC = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i) {
        this.vC = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gx aY(String str) {
        gx gxVar = new gx();
        gxVar.nB = false;
        gxVar.nC = str;
        return gxVar;
    }

    public void initRecognition(Context context) {
        if (kq.p(context)) {
            this.vB.initRecognition(context, new ImageRecognitionCallback() { // from class: com.baidu.ar.recg.RecgAR.2
                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onFeatureDBInit(boolean z) {
                    ArrayList<File> i;
                    if (!z) {
                        if (RecgAR.this.vF != null) {
                            RecgAR.this.vF.onStateChanged(OnDeviceIRState.ERROR, RecgAR.this.aY("特征库初始化失败"));
                        }
                        kf.b("bdar", "fea library init fail!");
                        return;
                    }
                    if (RecgAR.this.vF != null) {
                        RecgAR.this.vF.onStateChanged(OnDeviceIRState.START, null);
                    }
                    RecgAR.this.G(0);
                    if (TextUtils.isEmpty(ARConfig.sFeaPointsDir)) {
                        return;
                    }
                    File file = new File(ARConfig.sFeaPointsDir);
                    if (!file.exists() || !file.isDirectory() || (i = km.i(file)) == null || i.size() <= 0) {
                        return;
                    }
                    he heVar = new he();
                    heVar.H(1280);
                    heVar.I(CameraManager.DEFAULTHEIGHT);
                    heVar.a(km.a(i));
                    RecgAR.this.vD.b(heVar);
                    RecgAR recgAR = RecgAR.this;
                    recgAR.a(recgAR.vD, RecgAR.this.vE);
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onFeatureDownloadStart() {
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onRecognizeResult(boolean z, String str, String str2) {
                    RecgAR recgAR;
                    int i;
                    if (RecgAR.this.vC == 4) {
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        recgAR = RecgAR.this;
                        i = 0;
                    } else {
                        recgAR = RecgAR.this;
                        i = 3;
                    }
                    recgAR.G(i);
                    if (!z || TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (RecgAR.this.vB != null) {
                        RecgAR.this.vB.stopRecognition();
                    }
                    if (RecgAR.this.vF != null) {
                        gx gxVar = new gx();
                        gxVar.nB = true;
                        gxVar.arKey = str;
                        gxVar.arType = Integer.parseInt(str2);
                        StatisticApi.onEvent(StatisticConstants.DEVICE_SEARCH_SUCCESS);
                        RecgAR.this.vF.onStateChanged(OnDeviceIRState.SUCCESS, gxVar);
                    }
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onResourceDownload(boolean z) {
                    if (!z) {
                        if (RecgAR.this.vF != null) {
                            RecgAR.this.vF.onStateChanged(OnDeviceIRState.ERROR, RecgAR.this.aY("特征库下载失败"));
                        }
                        kf.b("bdar", "fea library download fail!");
                    } else {
                        if (RecgAR.this.vB != null) {
                            RecgAR.this.vB.startRecognition();
                        }
                        if (RecgAR.this.vF != null) {
                            RecgAR.this.vF.onStateChanged(OnDeviceIRState.START, null);
                        }
                    }
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onResourceRequest(boolean z, int i, String str) {
                    if (z) {
                        return;
                    }
                    if (RecgAR.this.vF != null) {
                        RecgAR.this.vF.onStateChanged(OnDeviceIRState.ERROR, RecgAR.this.aY(str));
                    }
                    kf.b("bdar", "request fail!");
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onSoLoadDownloadStart() {
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onSoLoadState(boolean z) {
                }
            });
            return;
        }
        kf.b("bdar", "network disconnect！");
        IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener = this.vF;
        if (iOnDeviceIRStateChangedListener != null) {
            iOnDeviceIRStateChangedListener.onStateChanged(OnDeviceIRState.NO_NETWORK, null);
        }
    }

    @Override // com.baidu.ar.d
    public void onCaseCreate(String str) {
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void pause() {
        super.pause();
        if (this.vC != 3) {
            G(4);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.vF = null;
        ImageRecognitionManager imageRecognitionManager = this.vB;
        if (imageRecognitionManager != null) {
            imageRecognitionManager.release();
        }
        hb hbVar = this.vD;
        if (hbVar != null) {
            a(hbVar);
            this.vD = null;
        }
        super.release();
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void resume() {
        super.resume();
        if (this.vC == 4) {
            G(0);
        }
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        initRecognition(getContext());
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        this.vF = iOnDeviceIRStateChangedListener;
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.vB = new ImageRecognitionManager();
        this.vD = new hb();
        this.vE = new df() { // from class: com.baidu.ar.recg.RecgAR.1
            private int vG = 0;

            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (dcVar == null || !(dcVar instanceof hf)) {
                    return;
                }
                gy gyVar = new gy();
                gyVar.b(dcVar);
                RecgAR.this.vB.onDetected(gyVar);
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                this.vG = 0;
            }
        };
        initRecognition(getContext());
    }
}
