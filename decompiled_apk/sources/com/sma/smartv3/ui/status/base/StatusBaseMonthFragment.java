package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import XI0oooXX.oxoX;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.xoIox;
import com.sma.smartv3.view.CustomBarChartView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import o0xxxXXxX.II0xO0;
import ox.oOoXoXO;

@XX({"SMAP\nStatusBaseMonthFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatusBaseMonthFragment.kt\ncom/sma/smartv3/ui/status/base/StatusBaseMonthFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n1855#2,2:158\n*S KotlinDebug\n*F\n+ 1 StatusBaseMonthFragment.kt\ncom/sma/smartv3/ui/status/base/StatusBaseMonthFragment\n*L\n145#1:158,2\n*E\n"})
/* loaded from: classes12.dex */
public abstract class StatusBaseMonthFragment<T> extends BaseDetailsMonthFragment<T> {
    private float axisMinimum;
    private float highlight;
    private float maxHeight;
    public List<String> monthDays;
    private II0xO0 setValue;

    @OOXIXo
    private final X0IIOO barChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomBarChartView>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$barChart$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomBarChartView invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (CustomBarChartView) mView.findViewById(R.id.barChart);
        }
    });

    @OOXIXo
    private final X0IIOO oneValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$oneValue$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (DINCondBold) mView.findViewById(R.id.oneValue);
        }
    });

    @OOXIXo
    private final X0IIOO twoValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$twoValue$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (DINCondBold) mView.findViewById(R.id.twoValue);
        }
    });

    @OOXIXo
    private final X0IIOO oneTV$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$oneTV$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (PFMedium) mView.findViewById(R.id.oneTV);
        }
    });

    @OOXIXo
    private final X0IIOO oneUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$oneUnit$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (PFMedium) mView.findViewById(R.id.oneUnit);
        }
    });

    @OOXIXo
    private final X0IIOO twoTV$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$twoTV$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (PFMedium) mView.findViewById(R.id.twoTV);
        }
    });

    @OOXIXo
    private final X0IIOO twoUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$twoUnit$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (PFMedium) mView.findViewById(R.id.twoUnit);
        }
    });

    @OOXIXo
    private final X0IIOO oneLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>(this) { // from class: com.sma.smartv3.ui.status.base.StatusBaseMonthFragment$oneLl$2
        final /* synthetic */ StatusBaseMonthFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = this.this$0.getMView();
            return (LinearLayout) mView.findViewById(R.id.oneLl);
        }
    });

    @OOXIXo
    private final List<BarEntry> values = new ArrayList();

    @OOXIXo
    private final LinkedHashMap<Long, ArrayList<T>> monthData = new LinkedHashMap<>();

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements ooOx.oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ StatusBaseMonthFragment<T> f24049oIX0oI;

        public oIX0oI(StatusBaseMonthFragment<T> statusBaseMonthFragment) {
            this.f24049oIX0oI = statusBaseMonthFragment;
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OOXIXo Entry e, @OOXIXo oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            this.f24049oIX0oI.updateItemData(e);
            this.f24049oIX0oI.getNowTimeDetails().setText(this.f24049oIX0oI.getMonthDays().get((int) e.xxIXOIIO()));
        }
    }

    public final void clearCache(long j) {
        this.monthData.clear();
        int size = getMonthDays().size();
        int i = 1;
        if (1 > size) {
            return;
        }
        while (true) {
            this.monthData.put(Long.valueOf((86400 * i * 1000) + j), new ArrayList<>());
            if (i != size) {
                i++;
            } else {
                return;
            }
        }
    }

    @CallSuper
    public void filterData(@OOXIXo List<? extends T> data) {
        IIX0o.x0xO0oo(data, "data");
        this.values.clear();
    }

    public final float getAxisMinimum() {
        return this.axisMinimum;
    }

    public final CustomBarChartView getBarChart() {
        return (CustomBarChartView) this.barChart$delegate.getValue();
    }

    public final float getHighlight() {
        return this.highlight;
    }

    public final float getMaxHeight() {
        return this.maxHeight;
    }

    @OOXIXo
    public final LinkedHashMap<Long, ArrayList<T>> getMonthData() {
        return this.monthData;
    }

    @OOXIXo
    public final List<String> getMonthDays() {
        List<String> list = this.monthDays;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("monthDays");
        return null;
    }

    public final LinearLayout getOneLl() {
        return (LinearLayout) this.oneLl$delegate.getValue();
    }

    public final PFMedium getOneTV() {
        return (PFMedium) this.oneTV$delegate.getValue();
    }

    public final PFMedium getOneUnit() {
        return (PFMedium) this.oneUnit$delegate.getValue();
    }

    public final DINCondBold getOneValue() {
        return (DINCondBold) this.oneValue$delegate.getValue();
    }

    public final PFMedium getTwoTV() {
        return (PFMedium) this.twoTV$delegate.getValue();
    }

    public final PFMedium getTwoUnit() {
        return (PFMedium) this.twoUnit$delegate.getValue();
    }

    public final DINCondBold getTwoValue() {
        return (DINCondBold) this.twoValue$delegate.getValue();
    }

    @OOXIXo
    public final List<BarEntry> getValues() {
        return this.values;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void initView() {
        setMonthDays(xoIox.Oo(getMCalendar().getTimeInMillis()));
        getTvCurrent().setText(xoIox.xII().format(new Date()));
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        CustomBarChartView barChart = getBarChart();
        IIX0o.oO(barChart, "<get-barChart>(...)");
        oix0oi.oIX0oI(barChart);
        YAxis axisLeft = getBarChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getBarChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, this.maxHeight, this.axisMinimum, ContextCompat.getColor(getMActivity(), R.color.line_color));
        CustomBarChartView barChart2 = getBarChart();
        int i = 0;
        barChart2.setDrawValueAboveBar(false);
        barChart2.setScaleEnabled(false);
        barChart2.getDescription().Oxx0IOOO(false);
        barChart2.getLegend().Oxx0IOOO(false);
        XAxis xAxis = getBarChart().getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        Context context = getBarChart().getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.OO(1.0f);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = getMonthDays().iterator();
        while (it.hasNext()) {
            i++;
            it.next();
            arrayList.add(String.valueOf(i));
        }
        xAxis.o0xxxXXxX(new oOoXoXO(arrayList));
        setChartRenderer();
        getBarChart().setOnChartValueSelectedListener(new oIX0oI(this));
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_month;
    }

    public final void setAxisMinimum(float f) {
        this.axisMinimum = f;
    }

    public void setChartRenderer() {
        xxx00.II0xO0 iI0xO0 = new xxx00.II0xO0(getBarChart(), getBarChart().getAnimator(), getBarChart().getViewPortHandler());
        iI0xO0.X0IIOO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getBarChart().setRenderer(iI0xO0);
    }

    public abstract void setColor(@OOXIXo II0xO0 iI0xO0);

    @OOXIXo
    public abstract String setDataLabel();

    public final void setHighlight(float f) {
        this.highlight = f;
    }

    public final void setMaxHeight(float f) {
        this.maxHeight = f;
    }

    public final void setMonthDays(@OOXIXo List<String> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.monthDays = list;
    }

    public final void updateChartData(@OOXIXo List<BarEntry> values) {
        IIX0o.x0xO0oo(values, "values");
        II0xO0 iI0xO0 = null;
        if (getBarChart().getData() != null && ((o0xxxXXxX.oIX0oI) getBarChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.oIX0oI) getBarChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
            II0xO0 iI0xO02 = (II0xO0) OOXIXo2;
            this.setValue = iI0xO02;
            if (iI0xO02 == null) {
                IIX0o.XOxIOxOx("setValue");
                iI0xO02 = null;
            }
            iI0xO02.oX0ooo0I0(values);
            II0xO0 iI0xO03 = this.setValue;
            if (iI0xO03 == null) {
                IIX0o.XOxIOxOx("setValue");
            } else {
                iI0xO0 = iI0xO03;
            }
            iI0xO0.I0xX0();
            ((o0xxxXXxX.oIX0oI) getBarChart().getData()).XxX0x0xxx();
            getBarChart().X00IoxXI();
        } else {
            II0xO0 iI0xO04 = new II0xO0(values, setDataLabel());
            this.setValue = iI0xO04;
            setColor(iI0xO04);
            II0xO0 iI0xO05 = this.setValue;
            if (iI0xO05 == null) {
                IIX0o.XOxIOxOx("setValue");
            } else {
                iI0xO0 = iI0xO05;
            }
            o0xxxXXxX.oIX0oI oix0oi = new o0xxxXXxX.oIX0oI(iI0xO0);
            oix0oi.oo0xXOI0I(false);
            getBarChart().setData(oix0oi);
        }
        getBarChart().II0XooXoX(1000);
        getBarChart().invalidate();
        this.highlight = values.size() / 2;
        for (BarEntry barEntry : values) {
            if (barEntry.I0Io() > 0.0f) {
                this.highlight = barEntry.xxIXOIIO();
            }
        }
        getBarChart().XIxXXX0x0(this.highlight, 0);
    }

    public abstract void updateItemData(@OOXIXo Entry entry);
}
