package com.sma.smartv3.ui.status.bg;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.biz.BGEMManager;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.model.BGEMMeasurementData;
import com.sma.smartv3.model.BGEMRangeAnalysisResult;
import com.sma.smartv3.model.BGEMResponse;
import com.sma.smartv3.util.x0xO0oo;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodGlucoseMeasurementActivity$analysis$2 implements xxxI.II0xO0<BGEMResponse<BGEMMeasurementData>> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ BloodGlucoseMeasurementActivity f24052oIX0oI;

    public BloodGlucoseMeasurementActivity$analysis$2(BloodGlucoseMeasurementActivity bloodGlucoseMeasurementActivity) {
        this.f24052oIX0oI = bloodGlucoseMeasurementActivity;
    }

    public static final void I0Io(String str, final BloodGlucoseMeasurementActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        BGEMManager bGEMManager = BGEMManager.f19913oIX0oI;
        IIX0o.ooOOo0oXI(str);
        bGEMManager.X0o0xo(str, new xxxI.II0xO0<BGEMRangeAnalysisResult>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseMeasurementActivity$analysis$2$handleResponse$1$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                BloodGlucoseMeasurementActivity.this.dismissLoading();
                BloodGlucoseMeasurementActivity.this.showMessureFailedPopup();
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO BGEMRangeAnalysisResult bGEMRangeAnalysisResult) {
                BloodGlucose2 bloodGlucose2;
                BloodGlucoseMeasurementActivity.this.dismissLoading();
                if (bGEMRangeAnalysisResult != null) {
                    bloodGlucose2 = bGEMRangeAnalysisResult.toBloodGlucose2();
                } else {
                    bloodGlucose2 = null;
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("measurementById handleResponse -> " + bloodGlucose2);
                if (bloodGlucose2 == null) {
                    BloodGlucoseMeasurementActivity.this.showMessureFailedPopup();
                    ToastUtils.showLong("Failed to get measurement results", new Object[0]);
                    return;
                }
                MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao().insert(CollectionsKt__CollectionsKt.Oxx0xo(bloodGlucose2));
                x0xO0oo.II0xO0(x0xO0oo.f24648x0XOIxOo, null, 2, null);
                BloodGlucoseMeasurementActivity bloodGlucoseMeasurementActivity = BloodGlucoseMeasurementActivity.this;
                bloodGlucoseMeasurementActivity.startActivity(new Intent(bloodGlucoseMeasurementActivity, (Class<?>) BloodGlucoseMeasurementDetailActivity.class));
                BloodGlucoseMeasurementActivity.this.finish();
            }
        });
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@oOoXoXO BGEMResponse<BGEMMeasurementData> bGEMResponse) {
        final String str;
        BGEMMeasurementData data;
        if (bGEMResponse != null && (data = bGEMResponse.getData()) != null) {
            str = data.getMeasurement_id();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("measurementById handleResponse -> The measurement is complete and the results are waiting");
            Handler handler = new Handler();
            final BloodGlucoseMeasurementActivity bloodGlucoseMeasurementActivity = this.f24052oIX0oI;
            handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.status.bg.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    BloodGlucoseMeasurementActivity$analysis$2.I0Io(str, bloodGlucoseMeasurementActivity);
                }
            }, TimeUnit.SECONDS.toMillis(20L));
        }
    }

    @Override // xxxI.II0xO0
    public void handleError(@OOXIXo String error) {
        IIX0o.x0xO0oo(error, "error");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("analysis handleError -> " + error);
        this.f24052oIX0oI.dismissLoading();
        this.f24052oIX0oI.showMessureFailedPopup();
        ToastUtils.showLong(error, new Object[0]);
    }
}
