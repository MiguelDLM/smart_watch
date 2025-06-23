package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.callback.IError;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.steploading.IStepLoading;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class jf implements ft, IStepLoading {
    private jc Aa;
    private String Ab;
    private boolean Ac;
    private Context mContext;
    private ICallbackWith<IStepLoading> mErrorCallback;
    private ARCaseBundleInfo zZ;

    public jf(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private ICancellable a(String str, ICallback iCallback, IError iError, IProgressCallback iProgressCallback) {
        return gu.b(new jg(this.mContext, this.zZ, this.Aa), str).d(new je(this.zZ, str, this.Aa, iProgressCallback)).d(new jd(iCallback, iError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request_id", str);
        hashMap.put("ret", Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5003, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request_id", str);
        hashMap.put("progress", Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5002, hashMap);
    }

    public void b(fs fsVar) {
        fsVar.c(this);
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void cancel() {
        if (!this.Ac || TextUtils.isEmpty(this.Ab)) {
            return;
        }
        this.Ac = false;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 3021);
        hashMap.put("if_download", 0);
        hashMap.put("download_batchid", this.Ab);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    @Override // com.baidu.ar.ft
    public List<Integer> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5001);
        arrayList.add(1901);
        return arrayList;
    }

    public void release() {
        this.Ac = false;
        this.Ab = null;
        this.mErrorCallback = null;
        this.mContext = null;
        this.zZ = null;
        this.Aa = null;
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void retry() {
        if (!this.Ac || TextUtils.isEmpty(this.Ab)) {
            return;
        }
        this.Ac = false;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 3021);
        hashMap.put("if_download", 1);
        hashMap.put("download_batchid", this.Ab);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void setLoadErrorListener(ICallbackWith<IStepLoading> iCallbackWith) {
        this.mErrorCallback = iCallbackWith;
    }

    public void switchCase(String str) {
        ARCaseBundleInfo aRCaseBundleInfo = new ARCaseBundleInfo();
        this.zZ = aRCaseBundleInfo;
        aRCaseBundleInfo.caseDir = str;
        aRCaseBundleInfo.arKey = ARConfig.getARKey();
        this.Aa = new jc(this.zZ.caseDir);
    }

    private void q(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("res_path");
        final String str2 = (String) hashMap.get("request_id");
        final boolean z = ((Integer) hashMap.get("need_progress")).intValue() != 0;
        this.Ab = str;
        a(str, new ICallback() { // from class: com.baidu.ar.jf.1
            @Override // com.baidu.ar.callback.ICallback
            public void run() {
                if (z) {
                    jf.d(str2, 100);
                }
                jf.c(str2, 0);
            }
        }, new IError() { // from class: com.baidu.ar.jf.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str3, Exception exc) {
                jf.c(str2, -1);
            }
        }, new IProgressCallback() { // from class: com.baidu.ar.jf.3
            @Override // com.baidu.ar.ihttp.IProgressCallback
            public void onProgress(int i, int i2) {
                if (!z || i2 <= 0) {
                    return;
                }
                jf.d(str2, (int) (((i * 90) * 1.0f) / i2));
            }
        });
    }

    @Override // com.baidu.ar.ft
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 5001) {
            if (hashMap != null) {
                this.Ac = false;
                q(hashMap);
                return;
            }
            return;
        }
        if (i == 1901 && as.a(hashMap.get("id"), -1) == 3010) {
            this.Ac = true;
            ICallbackWith<IStepLoading> iCallbackWith = this.mErrorCallback;
            if (iCallbackWith != null) {
                iCallbackWith.run(this);
            } else {
                cancel();
            }
        }
    }
}
