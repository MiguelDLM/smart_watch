package com.baidu.ar.cloud;

import com.baidu.ar.cl;
import com.baidu.ar.co;
import com.baidu.ar.d;
import com.baidu.ar.df;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class CloudAR extends d implements CloudCallback, ICloudIR {
    private cl nn;

    /* renamed from: no, reason: collision with root package name */
    private ICloudIRStateChangedListener f5564no;

    @Override // com.baidu.ar.cloud.CloudCallback
    public void onRecognizeResult(int i, String str, String str2, String str3) {
        ICloudIRStateChangedListener iCloudIRStateChangedListener;
        CloudIRState cloudIRState;
        if (this.f5564no != null) {
            co coVar = new co();
            coVar.nB = i == 0;
            if (i == 0) {
                StatisticApi.onEvent(StatisticConstants.CLOUD_SEARCH_SUCCESS);
                coVar.arKey = str2;
                coVar.arType = Integer.parseInt(str3);
                iCloudIRStateChangedListener = this.f5564no;
                cloudIRState = CloudIRState.SUCCESS;
            } else {
                coVar.nC = str;
                iCloudIRStateChangedListener = this.f5564no;
                cloudIRState = CloudIRState.ERROR;
            }
            iCloudIRStateChangedListener.onStateChanged(cloudIRState, coVar);
        }
    }

    @Override // com.baidu.ar.cloud.CloudCallback
    public void onStart() {
        ICloudIRStateChangedListener iCloudIRStateChangedListener = this.f5564no;
        if (iCloudIRStateChangedListener != null) {
            iCloudIRStateChangedListener.onStateChanged(CloudIRState.START, null);
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void pause() {
        super.pause();
        cl clVar = this.nn;
        if (clVar != null) {
            clVar.onPause();
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        this.f5564no = null;
        cl clVar = this.nn;
        if (clVar != null) {
            clVar.cD();
            a(this.nn);
        }
        super.release();
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void resume() {
        super.resume();
        cl clVar = this.nn;
        if (clVar != null) {
            clVar.onResume();
        }
    }

    public void setProcessFlag(int i) {
        cl clVar = this.nn;
        if (clVar != null) {
            clVar.setProcessFlag(i);
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        this.f5564no = iCloudIRStateChangedListener;
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        cl clVar = new cl(getContext());
        this.nn = clVar;
        clVar.a(this);
        a(this.nn, (df) null);
    }
}
