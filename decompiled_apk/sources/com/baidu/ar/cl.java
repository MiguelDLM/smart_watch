package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.camera.CameraManager;
import com.baidu.ar.cloud.CloudCallback;
import com.baidu.ar.cloud.CloudRecognitionManager;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class cl extends di implements CloudCallback {
    private Context mContext;
    private CloudRecognitionManager np;
    private CloudCallback nq;
    private int nr = -1;
    private ExecutorService ns = Executors.newSingleThreadExecutor();

    public cl(Context context) {
        this.mContext = context;
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.oW = pixelReadParams;
        pixelReadParams.setOutputWidth(1280);
        this.oW.setOutputHeight(CameraManager.DEFAULTHEIGHT);
    }

    @Override // com.baidu.ar.di
    public void cB() {
        CloudRecognitionManager cloudRecognitionManager = new CloudRecognitionManager();
        this.np = cloudRecognitionManager;
        cloudRecognitionManager.initCloudRecognition(this.mContext, this);
    }

    @Override // com.baidu.ar.di
    public void cC() {
        cD();
    }

    public void cD() {
        CloudRecognitionManager cloudRecognitionManager = this.np;
        if (cloudRecognitionManager != null) {
            cloudRecognitionManager.release();
        }
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return "CloudDetector";
    }

    public void onPause() {
        CloudRecognitionManager cloudRecognitionManager = this.np;
        if (cloudRecognitionManager != null) {
            cloudRecognitionManager.release();
        }
        this.nr = 2;
    }

    @Override // com.baidu.ar.cloud.CloudCallback
    public void onRecognizeResult(final int i, final String str, final String str2, final String str3) {
        if (i == 0) {
            this.nr = 0;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.cl.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ar_key", str2);
                        jSONObject.put("ar_type", str3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (cl.this.nq != null) {
                        cl.this.nq.onRecognizeResult(i, str, str2, str3);
                    }
                }
            });
            return;
        }
        if (i == 1054 || i == 1057) {
            this.nr = -1;
        } else {
            this.nr = 2;
            kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.cl.3
                @Override // java.lang.Runnable
                public void run() {
                    TextUtils.isEmpty(str);
                    if (cl.this.nq != null) {
                        cl.this.nq.onRecognizeResult(i, str, "", "");
                    }
                }
            });
        }
    }

    public void onResume() {
        this.np.initCloudRecognition(this.mContext, this);
        this.nr = -1;
    }

    @Override // com.baidu.ar.cloud.CloudCallback
    public void onStart() {
        CloudCallback cloudCallback = this.nq;
        if (cloudCallback != null) {
            cloudCallback.onStart();
        }
    }

    public void setProcessFlag(int i) {
        this.nr = i;
    }

    public void a(CloudCallback cloudCallback) {
        this.nq = cloudCallback;
    }

    @Override // com.baidu.ar.di
    public boolean a(FramePixels framePixels) {
        CloudCallback cloudCallback;
        ByteBuffer pixelsAddress = framePixels.getPixelsAddress();
        int remaining = pixelsAddress.remaining();
        final byte[] bArr = new byte[remaining];
        pixelsAddress.get(bArr);
        if (remaining <= 0 || this.nr != -1) {
            return true;
        }
        if (TextUtils.isEmpty(ARConfig.getARKey()) && (cloudCallback = this.nq) != null) {
            cloudCallback.onStart();
        }
        this.nr = 2;
        this.ns.execute(new Runnable() { // from class: com.baidu.ar.cl.1
            @Override // java.lang.Runnable
            public void run() {
                if (cl.this.np != null) {
                    cl.this.np.setYUVFile(bArr, cl.this.oW.getOutputWidth(), cl.this.oW.getOutputHeight());
                }
            }
        });
        return true;
    }
}
