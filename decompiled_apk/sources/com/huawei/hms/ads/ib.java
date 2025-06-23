package com.huawei.hms.ads;

import android.content.Context;
import android.os.CountDownTimer;
import com.huawei.hms.ads.km;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;

/* loaded from: classes10.dex */
public abstract class ib<V extends km> extends fu<V> implements ir<V> {
    private CountDownTimer B;
    protected Context V;
    private boolean Z = false;
    private boolean C = false;

    public ib(Context context, V v) {
        this.V = context.getApplicationContext();
        Code((ib<V>) v);
    }

    private void I(String str) {
        if (this.Z) {
            fb.V("PPSBaseViewPresenter", str);
            return;
        }
        this.Z = true;
        S();
        Code();
    }

    public void Code() {
        fb.V("PPSBaseViewPresenter", "cancelDisplayDurationCountTask");
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.B = null;
        }
    }

    @Override // com.huawei.hms.ads.ir
    public void S() {
        if (this.C) {
            fb.V("PPSBaseViewPresenter", "already reset");
        }
        this.C = true;
        if (I() != 0) {
            ((km) I()).destroyView();
        }
    }

    @Override // com.huawei.hms.ads.ir
    public void V() {
        fb.V("PPSBaseViewPresenter", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        S();
        fn adMediator = ((km) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.j();
        }
    }

    public abstract void V(String str);

    @Override // com.huawei.hms.ads.ir
    public void Code(int i) {
        fb.V("PPSBaseViewPresenter", "startDisplayDurationCountTask duration: %d", Integer.valueOf(i));
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i, 500L) { // from class: com.huawei.hms.ads.ib.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((km) ib.this.I()).I(1);
                ib.this.V();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                int max = Math.max(1, (int) Math.ceil((((float) j) * 1.0f) / 1000.0f));
                fb.Code("PPSBaseViewPresenter", "count down time: %d seconds: %d", Long.valueOf(j), Integer.valueOf(max));
                ((km) ib.this.I()).I(max);
            }
        };
        this.B = countDownTimer2;
        countDownTimer2.start();
    }

    public void V(AdContentData adContentData) {
        fn adMediator = ((km) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.Z(adContentData);
        }
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(int i, int i2, AdContentData adContentData, Long l, MaterialClickInfo materialClickInfo, int i3) {
        fb.V("PPSBaseViewPresenter", "onTouch");
        fn adMediator = ((km) I()).getAdMediator();
        if (adMediator == null || !adMediator.Code(i, i2, adContentData, l, materialClickInfo, i3)) {
            return;
        }
        if (this.Z) {
            fb.V("PPSBaseViewPresenter", "onDoActionSucc hasShowFinish");
            return;
        }
        this.Z = true;
        S();
        Code();
    }

    @Override // com.huawei.hms.ads.ir
    public void V(Long l) {
        I("feedback hasShowFinish");
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(int i, int i2, Long l) {
        fb.V("PPSBaseViewPresenter", "skip ad - hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        S();
        Code();
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(AdContentData adContentData) {
        this.Code = adContentData;
        Code(com.huawei.openalliance.ad.utils.ay.Code(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code())));
        if (adContentData == null) {
            fb.I("PPSBaseViewPresenter", "loadAdMaterial contentRecord is null");
            ((km) I()).Code(-7);
        } else {
            fb.V("PPSBaseViewPresenter", "loadAdMaterial");
            V(adContentData.h());
            com.huawei.openalliance.ad.utils.e.Code(this.V, adContentData);
        }
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(AdContentData adContentData, long j, int i) {
        fn adMediator = ((km) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.Code(adContentData, j, i);
        }
    }

    @Override // com.huawei.hms.ads.ir
    public void Code(Long l) {
        I("onWhyThisAd hasShowFinish");
    }
}
