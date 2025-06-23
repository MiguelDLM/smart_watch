package com.sma.smartv3.ui.status.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.model.BPDataParse;
import com.sma.smartv3.model.BPHourData;
import com.sma.smartv3.pop.CalibrationPopup;
import com.sma.smartv3.ui.status.RealTimeMeasurementActivity;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.HeathReportsUtils;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleBloodPressureCalibration;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBloodPressureDayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodPressureDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/BloodPressureDayFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,339:1\n1855#2,2:340\n*S KotlinDebug\n*F\n+ 1 BloodPressureDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/BloodPressureDayFragment\n*L\n294#1:340,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodPressureDayFragment extends BaseDetailDaysFragment<BloodPressure> {
    private float highlight;

    @OXOo.oOoXoXO
    private CalibrationPopup mCalibrationPopup;
    public o0xxxXXxX.II0xO0 setValue;

    @OXOo.OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BarChart>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$barChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BarChart invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (BarChart) mView.findViewById(R.id.barChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sbpValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$sbpValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.sbpValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO dbpValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$dbpValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.dbpValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sbpAvgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$sbpAvgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.sbpAvgValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO dbpAvgValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$dbpAvgValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.dbpAvgValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO measurePanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$measurePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return mView.findViewById(R.id.measure_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnMeasure$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$btnMeasure$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return mView.findViewById(R.id.btn_measure);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO calibrationPanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$calibrationPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return mView.findViewById(R.id.calibration_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnCalibration$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$btnCalibration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return mView.findViewById(R.id.btn_calibration);
        }
    });

    @OXOo.OOXIXo
    private final List<BarEntry> values = new ArrayList();

    @OXOo.OOXIXo
    private LinkedHashMap<Long, BPHourData> filterDataMap = new LinkedHashMap<>();

    @OXOo.OOXIXo
    private final List<BPHourData> hourData = new ArrayList();

    @OXOo.OOXIXo
    private final BloodPressureDao mBloodPressureDao = MyDb.INSTANCE.getMDatabase().bloodPressureDao();

    @OXOo.OOXIXo
    private final X0IIOO healthLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$healthLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.item_health_btn_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$healthBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$healthTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_heathy);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthTipLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$healthTipLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.questions_healthy_tip_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO healthQuestions$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$healthQuestions$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = BloodPressureDayFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_common_healthy_questions);
        }
    });
    private int mSystolic = 115;
    private int mDiastolic = 75;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ SimpleDateFormat f24067II0xO0;

        public oIX0oI(SimpleDateFormat simpleDateFormat) {
            this.f24067II0xO0 = simpleDateFormat;
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo Entry e, @OXOo.OOXIXo XI0oooXX.oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            BloodPressureDayFragment.this.updateItemData(e);
            BloodPressureDayFragment.this.getMCalendar().set(11, (int) e.xxIXOIIO());
            DINCondBold nowTimeDetails = BloodPressureDayFragment.this.getNowTimeDetails();
            BloodPressureDayFragment bloodPressureDayFragment = BloodPressureDayFragment.this;
            nowTimeDetails.setText(bloodPressureDayFragment.getString(R.string.time_range, TimeUtils.millis2String(bloodPressureDayFragment.getMCalendar().getTimeInMillis() - 3600000, this.f24067II0xO0), TimeUtils.millis2String(BloodPressureDayFragment.this.getMCalendar().getTimeInMillis(), this.f24067II0xO0)));
        }
    }

    private final void filterData(List<BloodPressure> list) {
        this.values.clear();
        BPDataParse.INSTANCE.filterHourData(getRange(), list, this.hourData, this.values);
        updateChartData(this.values);
        if (!list.isEmpty()) {
            BloodPressure bloodPressure = (BloodPressure) CollectionsKt___CollectionsKt.O0O0Io00X(list);
            if (bloodPressure.getMSystolic() == 0) {
                Button healthBtn = getHealthBtn();
                if (healthBtn != null) {
                    healthBtn.setEnabled(false);
                    return;
                }
                return;
            }
            String str = getString(R.string.systolic_pressure) + ':' + bloodPressure.getMSystolic() + ',' + getString(R.string.diastolic_pressure) + ':' + bloodPressure.getMDiastolic();
            HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
            long mTime = bloodPressure.getMTime();
            Button healthBtn2 = getHealthBtn();
            IIX0o.oO(healthBtn2, "<get-healthBtn>(...)");
            PFMedium healthTv = getHealthTv();
            IIX0o.oO(healthTv, "<get-healthTv>(...)");
            LinearLayout healthTipLayout = getHealthTipLayout();
            IIX0o.oO(healthTipLayout, "<get-healthTipLayout>(...)");
            PFMedium healthQuestions = getHealthQuestions();
            IIX0o.oO(healthQuestions, "<get-healthQuestions>(...)");
            heathReportsUtils.Io(ProductManager.xxI0XIO, mTime, healthBtn2, healthTv, healthTipLayout, healthQuestions, getMActivity());
            LinearLayout healthLayout = getHealthLayout();
            IIX0o.oO(healthLayout, "<get-healthLayout>(...)");
            Button healthBtn3 = getHealthBtn();
            IIX0o.oO(healthBtn3, "<get-healthBtn>(...)");
            PFMedium healthTv2 = getHealthTv();
            IIX0o.oO(healthTv2, "<get-healthTv>(...)");
            heathReportsUtils.x0o(healthLayout, healthBtn3, healthTv2, getMActivity(), ProductManager.xxI0XIO, str, bloodPressure.getMTime());
        }
    }

    private final BarChart getBarChart() {
        return (BarChart) this.barChart$delegate.getValue();
    }

    private final View getBtnCalibration() {
        return (View) this.btnCalibration$delegate.getValue();
    }

    private final View getBtnMeasure() {
        return (View) this.btnMeasure$delegate.getValue();
    }

    private final View getCalibrationPanel() {
        return (View) this.calibrationPanel$delegate.getValue();
    }

    private final DINCondBold getDbpAvgValue() {
        return (DINCondBold) this.dbpAvgValue$delegate.getValue();
    }

    private final DINCondBold getDbpValue() {
        return (DINCondBold) this.dbpValue$delegate.getValue();
    }

    private final Button getHealthBtn() {
        return (Button) this.healthBtn$delegate.getValue();
    }

    private final LinearLayout getHealthLayout() {
        return (LinearLayout) this.healthLayout$delegate.getValue();
    }

    private final PFMedium getHealthQuestions() {
        return (PFMedium) this.healthQuestions$delegate.getValue();
    }

    private final LinearLayout getHealthTipLayout() {
        return (LinearLayout) this.healthTipLayout$delegate.getValue();
    }

    private final PFMedium getHealthTv() {
        return (PFMedium) this.healthTv$delegate.getValue();
    }

    private final View getMeasurePanel() {
        return (View) this.measurePanel$delegate.getValue();
    }

    private final DINCondBold getSbpAvgValue() {
        return (DINCondBold) this.sbpAvgValue$delegate.getValue();
    }

    private final DINCondBold getSbpValue() {
        return (DINCondBold) this.sbpValue$delegate.getValue();
    }

    private final void manualCalibration() {
        View findViewById;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.ooO0oXxI()) {
            if (productManager.oOIXoIXXI() && (findViewById = getMView().findViewById(R.id.measure_view)) != null) {
                findViewById.setVisibility(8);
            }
            View calibrationPanel = getCalibrationPanel();
            if (calibrationPanel != null) {
                calibrationPanel.setVisibility(0);
            }
            getMView().setFocusableInTouchMode(true);
            getMView().requestFocus();
            getMView().setOnKeyListener(new View.OnKeyListener() { // from class: com.sma.smartv3.ui.status.fragment.oxoX
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean manualCalibration$lambda$1;
                    manualCalibration$lambda$1 = BloodPressureDayFragment.manualCalibration$lambda$1(BloodPressureDayFragment.this, view, i, keyEvent);
                    return manualCalibration$lambda$1;
                }
            });
            View btnCalibration = getBtnCalibration();
            if (btnCalibration != null) {
                btnCalibration.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.X0o0xo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BloodPressureDayFragment.manualCalibration$lambda$2(BloodPressureDayFragment.this, view);
                    }
                });
                return;
            }
            return;
        }
        View calibrationPanel2 = getCalibrationPanel();
        if (calibrationPanel2 != null) {
            calibrationPanel2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean manualCalibration$lambda$1(BloodPressureDayFragment this$0, View view, int i, KeyEvent keyEvent) {
        CalibrationPopup calibrationPopup;
        IIX0o.x0xO0oo(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4 || (calibrationPopup = this$0.mCalibrationPopup) == null || !calibrationPopup.isShowing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void manualCalibration$lambda$2(BloodPressureDayFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.calibrationPopup();
    }

    private final void realTimeMeasurement() {
        if (ProductManager.f20544oIX0oI.oOIXoIXXI()) {
            View measurePanel = getMeasurePanel();
            if (measurePanel != null) {
                measurePanel.setVisibility(0);
            }
            View btnMeasure = getBtnMeasure();
            if (btnMeasure != null) {
                btnMeasure.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.I0Io
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BloodPressureDayFragment.realTimeMeasurement$lambda$0(BloodPressureDayFragment.this, view);
                    }
                });
                return;
            }
            return;
        }
        View measurePanel2 = getMeasurePanel();
        if (measurePanel2 != null) {
            measurePanel2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void realTimeMeasurement$lambda$0(final BloodPressureDayFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.XO("start measure");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$realTimeMeasurement$1$1
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
                BloodPressureDayFragment bloodPressureDayFragment = BloodPressureDayFragment.this;
                Bundle bundle = new Bundle();
                bundle.putString("mArg0", null);
                bundle.putInt("mArg1", 1);
                bundle.putParcelable("mArg2", null);
                bundle.putSerializable("mArg3", null);
                Intent intent = new Intent(bloodPressureDayFragment.getActivity(), (Class<?>) RealTimeMeasurementActivity.class);
                intent.putExtras(bundle);
                bloodPressureDayFragment.startActivity(intent);
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<BarEntry> list) {
        if (getBarChart().getData() != 0 && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.oIX0oI) getBarChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
            setSetValue((o0xxxXXxX.II0xO0) OOXIXo2);
            getSetValue().oX0ooo0I0(list);
            getSetValue().I0xX0();
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).XxX0x0xxx();
            getBarChart().X00IoxXI();
        } else {
            setSetValue(new o0xxxXXxX.II0xO0(list, setDataLabel()));
            o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(getSetValue());
            oix0oi.oo0xXOI0I(false);
            getBarChart().setData(oix0oi);
        }
        getBarChart().II0XooXoX(1000);
        getBarChart().invalidate();
        for (BarEntry barEntry : list) {
            if (barEntry.I0Io() > 0.0f) {
                this.highlight = barEntry.xxIXOIIO();
            }
        }
        getBarChart().XIxXXX0x0(this.highlight, 0);
    }

    public final void calibrationPopup() {
        if (this.mCalibrationPopup == null) {
            CalibrationPopup calibrationPopup = new CalibrationPopup(getMActivity());
            calibrationPopup.oo0xXOI0I(R.string.manual_alibration);
            calibrationPopup.xI(new Oox.x0xO0oo<Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.status.fragment.BloodPressureDayFragment$calibrationPopup$1$1
                {
                    super(2);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2) {
                    return invoke(num.intValue(), num2.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i, int i2) {
                    BloodPressureDayFragment.this.setMSystolic(i);
                    BloodPressureDayFragment.this.setMDiastolic(i2);
                    Xo0 xo0 = Xo0.f24349oIX0oI;
                    xo0.XO().put(XoI0Ixx0.f24471x0OxxIOxX, BloodPressureDayFragment.this.getMSystolic());
                    xo0.XO().put(XoI0Ixx0.f24468x0, BloodPressureDayFragment.this.getMDiastolic());
                    BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.BLOOD_PRESSURE_CALIBRATION, BleKeyFlag.UPDATE, new BleBloodPressureCalibration(BloodPressureDayFragment.this.getMSystolic(), BloodPressureDayFragment.this.getMDiastolic()), false, false, 24, null);
                    return Boolean.TRUE;
                }
            });
            this.mCalibrationPopup = calibrationPopup;
        }
        CalibrationPopup calibrationPopup2 = this.mCalibrationPopup;
        if (calibrationPopup2 != null) {
            calibrationPopup2.ooXIXxIX(this.mSystolic, this.mDiastolic);
            calibrationPopup2.IIXOooo();
        }
    }

    public final float getHighlight() {
        return this.highlight;
    }

    public final int getMDiastolic() {
        return this.mDiastolic;
    }

    public final int getMSystolic() {
        return this.mSystolic;
    }

    @OXOo.OOXIXo
    public final o0xxxXXxX.II0xO0 getSetValue() {
        o0xxxXXxX.II0xO0 iI0xO0 = this.setValue;
        if (iI0xO0 != null) {
            return iI0xO0;
        }
        IIX0o.XOxIOxOx("setValue");
        return null;
    }

    @OXOo.OOXIXo
    public final List<BarEntry> getValues() {
        return this.values;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        super.init(bundle);
        Xo0 xo0 = Xo0.f24349oIX0oI;
        this.mSystolic = xo0.XO().getInt(XoI0Ixx0.f24471x0OxxIOxX, 115);
        this.mDiastolic = xo0.XO().getInt(XoI0Ixx0.f24468x0, 75);
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        realTimeMeasurement();
        manualCalibration();
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        BarChart barChart = getBarChart();
        IIX0o.oO(barChart, "<get-barChart>(...)");
        oix0oi.oIX0oI(barChart);
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 0.0f, 50.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        BarChart barChart2 = getBarChart();
        barChart2.getDescription().Oxx0IOOO(false);
        barChart2.getLegend().Oxx0IOOO(false);
        barChart2.setDrawValueAboveBar(false);
        barChart2.setScaleEnabled(false);
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getBarChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        setRange(com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null));
        xAxis.OO(1.0f);
        xAxis.XIo0oOXIx(7);
        xAxis.xXOx(25.0f);
        SimpleDateFormat xXOx2 = com.sma.smartv3.util.xoIox.xXOx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 25; i++) {
            String millis2String = TimeUtils.millis2String(getRange()[0] + (i * 3600 * 1000), xXOx2);
            if (arrayList.size() > 12 && IIX0o.Oxx0IOOO(millis2String, "0")) {
                millis2String = com.tencent.connect.common.II0xO0.f26868oxOXxoXII;
            }
            IIX0o.ooOOo0oXI(millis2String);
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        iI0xO0.o00(oIxOXo.oxoX.I0Io(getMActivity(), R.color.bp_line_color));
        iI0xO0.O0xOxO(new int[]{ContextCompat.getColor(getMActivity(), R.color.bp_color), ContextCompat.getColor(getMActivity(), R.color.bp_secondary_color)});
        iI0xO0.oI0IIXIo(2);
        getBarChart().setRenderer(iI0xO0);
        getBarChart().setOnChartValueSelectedListener(new oIX0oI(com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null)));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_bp_day;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24562I0Io)
    public final void onBloodPressureChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.XO("onBloodPressureChanged! refresh");
        setMOffset(0);
        update(getMCalendar(), getMOffset(), getMTimePeriod());
        String IIXOooo2 = com.sma.smartv3.util.xoIox.IIXOooo(getMCalendar(), getMOffset(), getMTimePeriod());
        if (TimePeriod.DAY == getMTimePeriod()) {
            if (IIX0o.Oxx0IOOO(com.sma.smartv3.util.xoIox.oo0xXOI0I().format(new Date()), IIXOooo2)) {
                getTvCurrent().setText(R.string.today);
            } else {
                getTvCurrent().setText(IIXOooo2);
            }
        }
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<BloodPressure> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<BloodPressure> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        return this.mBloodPressureDao.getBloodPressures(getRange()[0], getRange()[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "BP day Data";
    }

    public final void setHighlight(float f) {
        this.highlight = f;
    }

    public final void setMDiastolic(int i) {
        this.mDiastolic = i;
    }

    public final void setMSystolic(int i) {
        this.mSystolic = i;
    }

    public final void setSetValue(@OXOo.OOXIXo o0xxxXXxX.II0xO0 iI0xO0) {
        IIX0o.x0xO0oo(iI0xO0, "<set-?>");
        this.setValue = iI0xO0;
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        String format;
        String format2;
        String str;
        IIX0o.x0xO0oo(e, "e");
        BPHourData bPHourData = this.hourData.get((int) e.xxIXOIIO());
        DINCondBold sbpValue = getSbpValue();
        int sbpMin = bPHourData.getSbpMin();
        String str2 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        if (sbpMin == 0 && bPHourData.getSbpMax() == 0) {
            format = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        } else {
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            format = String.format("%d-%d", Arrays.copyOf(new Object[]{Integer.valueOf(bPHourData.getSbpMin()), Integer.valueOf(bPHourData.getSbpMax())}, 2));
            IIX0o.oO(format, "format(...)");
        }
        sbpValue.setText(format);
        DINCondBold dbpValue = getDbpValue();
        if (bPHourData.getDbpMin() == 0 && bPHourData.getDbpMax() == 0) {
            format2 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        } else {
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            format2 = String.format("%d-%d", Arrays.copyOf(new Object[]{Integer.valueOf(bPHourData.getDbpMin()), Integer.valueOf(bPHourData.getDbpMax())}, 2));
            IIX0o.oO(format2, "format(...)");
        }
        dbpValue.setText(format2);
        DINCondBold sbpAvgValue = getSbpAvgValue();
        if (bPHourData.getSbpTotal() != 0 && bPHourData.getSbpNum() != 0) {
            str = String.valueOf(bPHourData.getSbpTotal() / bPHourData.getSbpNum());
        } else {
            str = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        sbpAvgValue.setText(str);
        DINCondBold dbpAvgValue = getDbpAvgValue();
        if (bPHourData.getDbpTotal() != 0 && bPHourData.getDbpNum() != 0) {
            str2 = String.valueOf(bPHourData.getDbpTotal() / bPHourData.getDbpNum());
        }
        dbpAvgValue.setText(str2);
    }
}
