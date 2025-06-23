package com.sma.smartv3.ui.status.bg;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0.XO;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.model.BloodGlucose2DataKt;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView2;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodGlucoseMeasurementDetailActivity extends BaseActivity {

    @OOXIXo
    private final X0IIOO barView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SegmentedBarView2>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseMeasurementDetailActivity$barView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SegmentedBarView2 invoke() {
            return (SegmentedBarView2) BloodGlucoseMeasurementDetailActivity.this.findViewById(R.id.bar_view);
        }
    });

    @OOXIXo
    private final X0IIOO tvMeasureDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseMeasurementDetailActivity$tvMeasureDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucoseMeasurementDetailActivity.this.findViewById(R.id.tv_measure_date);
        }
    });

    @OOXIXo
    private List<BloodGlucose2> mBloodGlucoseList = new ArrayList();

    private final SegmentedBarView2 getBarView() {
        return (SegmentedBarView2) this.barView$delegate.getValue();
    }

    private final TextView getTvMeasureDate() {
        return (TextView) this.tvMeasureDate$delegate.getValue();
    }

    private final String getValueText(float f) {
        return f + "<br><small>mmol/L</small>";
    }

    private final void initBarView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o0Xo.oIX0oI(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(3.4f, 0.0f, 2, null), BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.1f, 0.0f, 2, null), getResources().getColor(R.color.bg_level_color_normal_bg), getResources().getColor(R.color.bg_level_color_normal)));
        arrayList.add(new o0Xo.oIX0oI(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.1f, 0.0f, 2, null), BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.9f, 0.0f, 2, null), getResources().getColor(R.color.bg_level_color_prediabetes_bg), getResources().getColor(R.color.bg_level_color_prediabetes)));
        arrayList.add(new o0Xo.oIX0oI(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.9f, 0.0f, 2, null), BloodGlucose2DataKt.getBloodGlucoseBarValue$default(8.1f, 0.0f, 2, null), getResources().getColor(R.color.bg_level_color_diabetes_bg), getResources().getColor(R.color.bg_level_color_diabetes)));
        getBarView().setSegments(arrayList);
    }

    private final void setBarValue(float f, float f2) {
        getBarView().x0XOIxOo(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(f, 0.0f, 2, null), getValueText(f));
        getBarView().oO(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(f2, 0.0f, 2, null), getValueText(f2));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.blood_glucose_range);
        initBarView();
        showData(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_blood_glucose_m_detail;
    }

    public final void onHelp(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ProjectManager.f19822oIX0oI.Oxo00O(this);
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @XO(tag = x0xO0oo.f24648x0XOIxOo)
    public final void showData(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        this.mBloodGlucoseList.clear();
        this.mBloodGlucoseList.addAll(MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao().getList());
        if (!this.mBloodGlucoseList.isEmpty()) {
            BloodGlucose2 bloodGlucose2 = (BloodGlucose2) CollectionsKt___CollectionsKt.O0O0Io00X(this.mBloodGlucoseList);
            setBarValue((float) bloodGlucose2.getMLowerBound(), (float) bloodGlucose2.getMUpperBound());
            getTvMeasureDate().setText(xoIox.oxxXoxO(false, false, 3, null).format(Long.valueOf(bloodGlucose2.getMTime())));
        }
    }
}
