package com.baidu.ar.cloud;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.DuMixController;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.cp;
import com.baidu.ar.cq;
import com.baidu.ar.fn;
import com.baidu.ar.ke;
import com.baidu.ar.kf;
import com.baidu.ar.kk;
import com.baidu.ar.kr;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.recognition.CloudAlgoController;
import com.baidu.ar.recognition.CloudRecognitionClient;
import com.baidu.ar.recognition.RecognitionAssembleCallback;
import com.baidu.ar.recognition.RequestRecognitionMode;
import com.baidu.ar.remoteres.DuMixResManager;
import com.baidu.ar.remoteres.IDuMixResProcessor;
import java.io.File;
import java.util.UUID;

/* loaded from: classes7.dex */
public class CloudRecognitionManager implements cq.a, RecognitionAssembleCallback {
    public static final int CLOUD_RECOGNITION_NO_TARGET = 1057;
    public static final int COMMON_ERROR_CODE = -1;
    private Context mContext;
    private cq nD;
    private CloudRecognitionClient nE;
    private RequestRecognitionMode nG;
    private DuMixResManager nI;
    private boolean nJ;
    private CloudCallback nq;
    private float[] nF = {1200.0f, 0.0f, 640.0f, 0.0f, 1200.0f, 360.0f, 0.0f, 0.0f, 1.0f};
    private float[] nH = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    private void g(Context context) {
        Object a2 = kr.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{null, getSoDownLoadDir(context)});
        if (a2 != null) {
            fn.a((ILibLoader) a2);
        }
    }

    public static String getSoDownLoadDir(Context context) {
        if (context == null) {
            kf.b("CloudRecognitionManager", "get so download dir error");
            return null;
        }
        File file = new File(context.getFilesDir(), "arlibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public boolean cloudAlgoIsReady() {
        return this.nJ;
    }

    public void initCloudRecognition(Context context, CloudCallback cloudCallback) {
        this.mContext = context.getApplicationContext();
        this.nq = cloudCallback;
        if (this.nD == null) {
            this.nD = new cq();
        }
        CloudAlgoController cloudAlgoController = new CloudAlgoController();
        this.nD.a(this);
        cloudAlgoController.setRecognitionAssembleCallback(this);
        this.nD.cH();
        if (this.nI == null) {
            this.nI = new DuMixResManager(this.mContext.getApplicationContext());
        }
        this.nI.downloadARRes(ARType.CLOUD_IR, new ICallback() { // from class: com.baidu.ar.cloud.CloudRecognitionManager.1
            @Override // com.baidu.ar.callback.ICallback
            public void run() {
                DuMixResManager duMixResManager = CloudRecognitionManager.this.nI;
                ARType aRType = ARType.CLOUD_IR;
                if (duMixResManager.isARResReady(aRType)) {
                    String modelRoot = CloudRecognitionManager.this.nI.getModelRoot();
                    String libRoot = CloudRecognitionManager.this.nI.getLibRoot();
                    IDuMixResProcessor resProcessor = CloudRecognitionManager.this.nI.getResProcessor(aRType);
                    File file = new File(modelRoot);
                    File file2 = new File(libRoot);
                    CloudRecognitionManager.this.nJ = resProcessor.load(null, file2, file);
                    if (CloudRecognitionManager.this.nE == null) {
                        CloudRecognitionManager.this.nE = new CloudRecognitionClient();
                    }
                }
            }
        });
    }

    @Override // com.baidu.ar.recognition.RecognitionAssembleCallback
    public void onAssembleResult(byte[] bArr) {
        cq cqVar = this.nD;
        if (cqVar != null) {
            cqVar.d(bArr);
        }
    }

    @Override // com.baidu.ar.recognition.RecognitionAssembleCallback
    public void onProtobufParseResult(int i, String str, String str2, String str3) {
        CloudCallback cloudCallback = this.nq;
        if (cloudCallback != null) {
            cloudCallback.onRecognizeResult(i, str, str2, str3);
        }
    }

    @Override // com.baidu.ar.cq.a
    public void onRequestLibraryResult(String str) {
    }

    @Override // com.baidu.ar.cq.a
    public void onResourceRequest(cp cpVar) {
        CloudCallback cloudCallback = this.nq;
        if (cloudCallback != null) {
            if (cpVar == null) {
                cloudCallback.onRecognizeResult(-1, "未知错误", "", "");
            } else if (cpVar.cF() != null) {
                this.nq.onRecognizeResult(cpVar.cE(), cpVar.getMessage(), cpVar.cF().getArKey(), cpVar.cF().cJ());
            } else {
                this.nq.onRecognizeResult(cpVar.cE(), cpVar.getMessage(), "", "");
            }
        }
    }

    @Override // com.baidu.ar.cq.a
    public void onResourceResponse(byte[] bArr) {
        if (bArr == null) {
            CloudCallback cloudCallback = this.nq;
            if (cloudCallback != null) {
                cloudCallback.onRecognizeResult(-1, "error", "", "");
                return;
            }
            return;
        }
        try {
            CloudRecognitionClient cloudRecognitionClient = this.nE;
            if (cloudRecognitionClient != null) {
                cloudRecognitionClient.onServerReceiver(bArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void release() {
        cq cqVar = this.nD;
        if (cqVar != null) {
            cqVar.release();
            this.nD = null;
        }
        this.nJ = false;
    }

    public void setYUVFile(byte[] bArr, int i, int i2) {
        if (bArr != null || this.nJ) {
            try {
                CloudRecognitionClient cloudRecognitionClient = this.nE;
                if (cloudRecognitionClient != null) {
                    cloudRecognitionClient.recognition(a(bArr, i, i2, 40.019558f, 116.31966f));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private RequestRecognitionMode a(byte[] bArr, int i, int i2, float f, float f2) {
        if (this.nG == null) {
            this.nG = new RequestRecognitionMode();
        }
        this.nG.setImage(bArr);
        Object[] signatureAndTime = ARConfig.getSignatureAndTime();
        this.nG.setSign((String) signatureAndTime[0]);
        this.nG.setTimestamp(((Long) signatureAndTime[1]).longValue());
        this.nG.setWidth(i);
        this.nG.setHeight(i2);
        this.nG.setIsAip("3");
        this.nG.setAppId(ke.getPackageName());
        this.nG.setAipAppId(DuMixARConfig.getAipAppId());
        this.nG.setPolicy(0);
        this.nG.setAppId(this.mContext.getPackageName());
        this.nG.setCameraDistort(this.nH);
        this.nG.setGps(new float[]{f, f2, 0.0f});
        UUID hg = new kk(this.mContext).hg();
        if (hg != null) {
            this.nG.setCuid(hg.toString());
        } else {
            this.nG.setCuid(ARConfig.getCUID());
        }
        this.nG.setFrameChannels(1);
        this.nG.setCameraIntrinsics(this.nF);
        return this.nG;
    }

    public void initCloudRecognition(Context context, CloudCallback cloudCallback, boolean z) {
        if (z) {
            g(context);
        }
        initCloudRecognition(context, cloudCallback);
    }

    public void setYUVFile(byte[] bArr, int i, int i2, float f, float f2) {
        if (bArr != null || this.nJ) {
            try {
                CloudRecognitionClient cloudRecognitionClient = this.nE;
                if (cloudRecognitionClient != null) {
                    cloudRecognitionClient.recognition(a(bArr, i, i2, f, f2));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
