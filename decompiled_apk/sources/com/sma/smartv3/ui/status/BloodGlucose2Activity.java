package com.sma.smartv3.ui.status;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.BGEMManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.model.BGEMKt;
import com.sma.smartv3.model.BGEMRangeAnalysisResult;
import com.sma.smartv3.model.BGEMUser;
import com.sma.smartv3.model.BloodGlucose2DataKt;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.status.bg.BloodGlucoseMeasurementActivity;
import com.sma.smartv3.ui.status.bg.BloodGlucoseTrendActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView2;
import com.szabh.smable3.component.BleConnector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBloodGlucose2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodGlucose2Activity.kt\ncom/sma/smartv3/ui/status/BloodGlucose2Activity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,287:1\n15#2:288\n69#3,3:289\n72#3,5:293\n1#4:292\n*S KotlinDebug\n*F\n+ 1 BloodGlucose2Activity.kt\ncom/sma/smartv3/ui/status/BloodGlucose2Activity\n*L\n75#1:288\n279#1:289,3\n279#1:293,5\n279#1:292\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodGlucose2Activity extends BaseActivity {

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BloodGlucose2Activity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llNoMeasurement$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$llNoMeasurement$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BloodGlucose2Activity.this.findViewById(R.id.ll_no_measurement);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO barView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SegmentedBarView2>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$barView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SegmentedBarView2 invoke() {
            return (SegmentedBarView2) BloodGlucose2Activity.this.findViewById(R.id.bar_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnMeasure$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$btnMeasure$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.btn_measure);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvMeasureDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$tvMeasureDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.tv_measure_date);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvNoRecord$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$tvNoRecord$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.tv_no_record);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivRiskLevel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$ivRiskLevel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BloodGlucose2Activity.this.findViewById(R.id.iv_risk_level);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnRiskLevel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$btnRiskLevel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.btn_risk_level);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvRiskRangeDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$tvRiskRangeDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.tv_risk_range_date);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rvRiskLevel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$rvRiskLevel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) BloodGlucose2Activity.this.findViewById(R.id.rv_risk_level);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llDiabeticRiskInsight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$llDiabeticRiskInsight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BloodGlucose2Activity.this.findViewById(R.id.ll_diabetic_risk_insight);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvDiabeticRiskInsight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$tvDiabeticRiskInsight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.tv_diabetic_risk_insight);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvRiskDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$tvRiskDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.tv_risk_date);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvDiabeticRiskTips$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$tvDiabeticRiskTips$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) BloodGlucose2Activity.this.findViewById(R.id.tv_diabetic_risk_tips);
        }
    });

    @OXOo.OOXIXo
    private List<BloodGlucose2> mBloodGlucoseList = new ArrayList();

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final SegmentedBarView2 getBarView() {
        return (SegmentedBarView2) this.barView$delegate.getValue();
    }

    private final TextView getBtnMeasure() {
        return (TextView) this.btnMeasure$delegate.getValue();
    }

    private final TextView getBtnRiskLevel() {
        return (TextView) this.btnRiskLevel$delegate.getValue();
    }

    private final ImageView getIvRiskLevel() {
        return (ImageView) this.ivRiskLevel$delegate.getValue();
    }

    private final LinearLayout getLlDiabeticRiskInsight() {
        return (LinearLayout) this.llDiabeticRiskInsight$delegate.getValue();
    }

    private final LinearLayout getLlNoMeasurement() {
        return (LinearLayout) this.llNoMeasurement$delegate.getValue();
    }

    private final RecyclerView getRvRiskLevel() {
        return (RecyclerView) this.rvRiskLevel$delegate.getValue();
    }

    private final TextView getTvDiabeticRiskInsight() {
        return (TextView) this.tvDiabeticRiskInsight$delegate.getValue();
    }

    private final TextView getTvDiabeticRiskTips() {
        return (TextView) this.tvDiabeticRiskTips$delegate.getValue();
    }

    private final TextView getTvMeasureDate() {
        return (TextView) this.tvMeasureDate$delegate.getValue();
    }

    private final TextView getTvNoRecord() {
        return (TextView) this.tvNoRecord$delegate.getValue();
    }

    private final TextView getTvRiskDate() {
        return (TextView) this.tvRiskDate$delegate.getValue();
    }

    private final TextView getTvRiskRangeDate() {
        return (TextView) this.tvRiskRangeDate$delegate.getValue();
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

    private final void initRange() {
        getBtnMeasure().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BloodGlucose2Activity.initRange$lambda$0(BloodGlucose2Activity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRange$lambda$0(final BloodGlucose2Activity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$initRange$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                IIX0o.x0xO0oo(it, "it");
                if (!MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao().getTodayList().isEmpty()) {
                    XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(BloodGlucose2Activity.this, 0, 2, null);
                    final BloodGlucose2Activity bloodGlucose2Activity = BloodGlucose2Activity.this;
                    xoI0Ixx0.xI(Integer.valueOf(R.string.bg_measurement_record_used_tip));
                    xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$initRange$1$1$1$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$initRange$1$1$1$2
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            BloodGlucose2Activity bloodGlucose2Activity2 = BloodGlucose2Activity.this;
                            bloodGlucose2Activity2.startActivity(new Intent(bloodGlucose2Activity2, (Class<?>) BloodGlucoseMeasurementActivity.class));
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.IIXOooo();
                    return;
                }
                BloodGlucose2Activity bloodGlucose2Activity2 = BloodGlucose2Activity.this;
                bloodGlucose2Activity2.startActivity(new Intent(bloodGlucose2Activity2, (Class<?>) BloodGlucoseMeasurementActivity.class));
            }
        }, 1, null);
    }

    private final void setBarValue(float f, float f2) {
        getBarView().x0XOIxOo(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(f, 0.0f, 2, null), getValueText(f));
        getBarView().oO(BloodGlucose2DataKt.getBloodGlucoseBarValue$default(f2, 0.0f, 2, null), getValueText(f2));
    }

    private final void syncData() {
        long[] Oxx0xo2 = com.sma.smartv3.util.xoIox.Oxx0xo(50);
        BGEMManager bGEMManager = BGEMManager.f19913oIX0oI;
        String format = com.sma.smartv3.util.xoIox.OO0x0xX().format(Long.valueOf(Oxx0xo2[0]));
        IIX0o.oO(format, "format(...)");
        String format2 = com.sma.smartv3.util.xoIox.OO0x0xX().format(Long.valueOf(Oxx0xo2[1]));
        IIX0o.oO(format2, "format(...)");
        bGEMManager.I0Io(format, format2, new xxxI.II0xO0<BGEMRangeAnalysisResult[]>() { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$syncData$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BGEMRangeAnalysisResult[] bGEMRangeAnalysisResultArr) {
                if (bGEMRangeAnalysisResultArr != null) {
                    for (BGEMRangeAnalysisResult bGEMRangeAnalysisResult : bGEMRangeAnalysisResultArr) {
                        BloodGlucose2 bloodGlucose2 = bGEMRangeAnalysisResult.toBloodGlucose2();
                        if (bloodGlucose2 != null) {
                            MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao().insert(CollectionsKt__CollectionsKt.Oxx0xo(bloodGlucose2));
                        }
                    }
                }
                BloodGlucose2Activity.this.showData(new Object());
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        if (((BGEMUser) new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(BGEMUser.class.getName()), BGEMUser.class)) == null) {
            BGEMManager.II0XooXoX(BGEMManager.f19913oIX0oI, null, 1, null);
        } else {
            BGEMManager.xoIox(BGEMManager.f19913oIX0oI, null, 1, null);
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.blood_glucose);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_blood_glucose_trend);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        initRange();
        initBarView();
        showData(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_blood_glucose2;
    }

    public final void onHelp(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ProjectManager.f19822oIX0oI.Oxo00O(this);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) BloodGlucoseTrendActivity.class));
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24648x0XOIxOo)
    public final void showData(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        this.mBloodGlucoseList.clear();
        this.mBloodGlucoseList.addAll(MyDb.INSTANCE.getMDatabase().bloodGlucose2Dao().getListForDay());
        long[] Oxx0xo2 = com.sma.smartv3.util.xoIox.Oxx0xo(6);
        getTvRiskRangeDate().setText(com.sma.smartv3.util.xoIox.oo0xXOI0I().format(Long.valueOf(Oxx0xo2[0])) + " - " + com.sma.smartv3.util.xoIox.oo0xXOI0I().format(Long.valueOf(Oxx0xo2[1])));
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showData -> " + ((Object) getTvRiskRangeDate().getText()) + ", " + this.mBloodGlucoseList.size());
        if (!this.mBloodGlucoseList.isEmpty()) {
            BloodGlucose2 bloodGlucose2 = (BloodGlucose2) CollectionsKt___CollectionsKt.O0O0Io00X(this.mBloodGlucoseList);
            setBarValue((float) bloodGlucose2.getMLowerBound(), (float) bloodGlucose2.getMUpperBound());
            getLlNoMeasurement().setVisibility(8);
            getTvMeasureDate().setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(Long.valueOf(bloodGlucose2.getMTime())));
            int mCurrentLevel = bloodGlucose2.getMCurrentLevel();
            if (mCurrentLevel > 0) {
                getIvRiskLevel().setVisibility(0);
                getTvNoRecord().setVisibility(8);
            } else {
                getIvRiskLevel().setVisibility(8);
                getTvNoRecord().setVisibility(0);
            }
            if (mCurrentLevel != 0) {
                if (mCurrentLevel != 1) {
                    if (mCurrentLevel != 2) {
                        if (mCurrentLevel != 3) {
                            if (mCurrentLevel == 4) {
                                getIvRiskLevel().setImageResource(R.drawable.ic_bg_risk_high);
                                getBtnRiskLevel().setText(R.string.diabetic_risk_level_4);
                                getBtnRiskLevel().setBackgroundTintList(getResources().getColorStateList(R.color.bg_risk_4));
                            }
                        } else {
                            getIvRiskLevel().setImageResource(R.drawable.ic_bg_risk_moderate);
                            getBtnRiskLevel().setText(R.string.diabetic_risk_level_3);
                            getBtnRiskLevel().setBackgroundTintList(getResources().getColorStateList(R.color.bg_risk_3));
                        }
                    } else {
                        getIvRiskLevel().setImageResource(R.drawable.ic_bg_risk_marginal);
                        getBtnRiskLevel().setText(R.string.diabetic_risk_level_2);
                        getBtnRiskLevel().setBackgroundTintList(getResources().getColorStateList(R.color.bg_risk_2));
                    }
                } else {
                    getIvRiskLevel().setImageResource(R.drawable.ic_bg_risk_low);
                    getBtnRiskLevel().setText(R.string.diabetic_risk_level_1);
                    getBtnRiskLevel().setBackgroundTintList(getResources().getColorStateList(R.color.bg_risk_1));
                }
            } else {
                getBtnRiskLevel().setText(R.string.diabetic_risk_level_0);
                getBtnRiskLevel().setBackgroundTintList(getResources().getColorStateList(R.color.bg_risk_0));
            }
            if (!TextUtils.isEmpty(bloodGlucose2.getMInsights())) {
                getLlDiabeticRiskInsight().setVisibility(0);
                getTvRiskDate().setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(Long.valueOf(bloodGlucose2.getMTime())));
                getTvDiabeticRiskInsight().setText(Html.fromHtml(BGEMKt.getInsights(bloodGlucose2)));
                getTvDiabeticRiskTips().setText(Html.fromHtml(BGEMKt.getInsightsTip(bloodGlucose2)));
            } else {
                getLlDiabeticRiskInsight().setVisibility(8);
            }
        }
        getRvRiskLevel().setLayoutManager(new GridLayoutManager(this, 7));
        final List IxoOxx = CollectionsKt___CollectionsKt.IxoOxx(X0.IIXOooo.xIXX(new X0.oO(Oxx0xo2[0], Oxx0xo2[1]), TimeUnit.DAYS.toMillis(1L)));
        getRvRiskLevel().setAdapter(new CommonAdapter<Long>(IxoOxx) { // from class: com.sma.smartv3.ui.status.BloodGlucose2Activity$showData$1
            final /* synthetic */ List<Long> $days;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(BloodGlucose2Activity.this, R.layout.item_bg_risk_level, IxoOxx);
                this.$days = IxoOxx;
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public /* bridge */ /* synthetic */ void convert(ViewHolder viewHolder, Long l, int i) {
                convert(viewHolder, l.longValue(), i);
            }

            public void convert(@OXOo.OOXIXo ViewHolder holder, long j, int i) {
                ColorStateList colorStateList;
                List list;
                Object obj;
                IIX0o.x0xO0oo(holder, "holder");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j);
                String displayName = calendar.getDisplayName(7, 1, Locale.getDefault());
                if (displayName == null) {
                    IIX0o.ooOOo0oXI(calendar);
                    displayName = String.valueOf(oOXoIIIo.II0xO0.II0xO0(calendar) + 1);
                }
                ((TextView) holder.getView(R.id.tv_title)).setText(displayName);
                View view = holder.getView(R.id.fl_bg_select);
                if (i == this.$days.size() - 1) {
                    colorStateList = BloodGlucose2Activity.this.getResources().getColorStateList(R.color.black);
                } else {
                    colorStateList = BloodGlucose2Activity.this.getResources().getColorStateList(R.color.transparent);
                }
                view.setBackgroundTintList(colorStateList);
                list = BloodGlucose2Activity.this.mBloodGlucoseList;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (IIX0o.Oxx0IOOO(com.sma.smartv3.util.xoIox.xoIxX().format(Long.valueOf(((BloodGlucose2) obj).getMTime())), com.sma.smartv3.util.xoIox.xoIxX().format(Long.valueOf(j)))) {
                            break;
                        }
                    }
                }
                BloodGlucose2 bloodGlucose22 = (BloodGlucose2) obj;
                int i2 = 0;
                if (bloodGlucose22 != null) {
                    holder.getView(R.id.iv_risk_level_icon).setVisibility(0);
                    i2 = bloodGlucose22.getMCurrentLevel();
                } else {
                    holder.getView(R.id.iv_risk_level_icon).setVisibility(8);
                }
                holder.getView(R.id.fl_bg).setBackgroundTintList(BloodGlucose2Activity.this.getResources().getColorStateList(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? R.color.bg_risk_0 : R.color.bg_risk_4 : R.color.bg_risk_3 : R.color.bg_risk_2 : R.color.bg_risk_1));
            }
        });
    }
}
