package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BloodGlucose2DataKt;
import com.sma.smartv3.model.TodayData;
import com.sma.smartv3.model.WeightMeasureDataKt;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class HeathAIAnalyzeItem extends BaseDslItem {

    @OXOo.oOoXoXO
    private SegmentedBarView2 barView;

    @OXOo.oOoXoXO
    private LinearLayout barViewTipLayout;

    @OXOo.OOXIXo
    private final TodayData item;

    @OXOo.oOoXoXO
    private TextView mAiAnalysisResult;

    @OXOo.oOoXoXO
    private TextView mAiAnalysisTitle;

    @OXOo.oOoXoXO
    private AppCompatImageView mBadIv;

    @OXOo.oOoXoXO
    private TextView mBadTv;

    @OXOo.oOoXoXO
    private TextView mCommonBtn;
    private Context mContext;

    @OXOo.oOoXoXO
    private AppCompatImageView mGoodIv;

    @OXOo.oOoXoXO
    private TextView mGoodTv;

    @OXOo.oOoXoXO
    private AppCompatImageView mHighestIv;

    @OXOo.oOoXoXO
    private TextView mHighestTv;

    @OXOo.oOoXoXO
    private AppCompatImageView mMediumIv;

    @OXOo.oOoXoXO
    private TextView mMediumTv;

    @OXOo.oOoXoXO
    private CircleThumbSegmentedBarView mSbvBmi;

    @OXOo.oOoXoXO
    private TextView mValueFront;

    @OXOo.oOoXoXO
    private TextView mValueState;

    @OXOo.oOoXoXO
    private TextView mValueTime;

    @OXOo.oOoXoXO
    private TextView mValueTitle;

    @OXOo.oOoXoXO
    private TextView mValueTv;

    /* JADX WARN: Multi-variable type inference failed */
    public HeathAIAnalyzeItem() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void initBarView() {
        ArrayList arrayList = new ArrayList();
        Context context = null;
        float bloodGlucoseBarValue$default = BloodGlucose2DataKt.getBloodGlucoseBarValue$default(3.4f, 0.0f, 2, null);
        float bloodGlucoseBarValue$default2 = BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.1f, 0.0f, 2, null);
        Context context2 = this.mContext;
        if (context2 == null) {
            IIX0o.XOxIOxOx("mContext");
            context2 = null;
        }
        int color = context2.getResources().getColor(R.color.bg_level_color_normal_bg);
        Context context3 = this.mContext;
        if (context3 == null) {
            IIX0o.XOxIOxOx("mContext");
            context3 = null;
        }
        arrayList.add(new o0Xo.oIX0oI(bloodGlucoseBarValue$default, bloodGlucoseBarValue$default2, color, context3.getResources().getColor(R.color.bg_level_color_normal)));
        float bloodGlucoseBarValue$default3 = BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.1f, 0.0f, 2, null);
        float bloodGlucoseBarValue$default4 = BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.9f, 0.0f, 2, null);
        Context context4 = this.mContext;
        if (context4 == null) {
            IIX0o.XOxIOxOx("mContext");
            context4 = null;
        }
        int color2 = context4.getResources().getColor(R.color.bg_level_color_prediabetes_bg);
        Context context5 = this.mContext;
        if (context5 == null) {
            IIX0o.XOxIOxOx("mContext");
            context5 = null;
        }
        arrayList.add(new o0Xo.oIX0oI(bloodGlucoseBarValue$default3, bloodGlucoseBarValue$default4, color2, context5.getResources().getColor(R.color.bg_level_color_prediabetes)));
        float bloodGlucoseBarValue$default5 = BloodGlucose2DataKt.getBloodGlucoseBarValue$default(6.9f, 0.0f, 2, null);
        float bloodGlucoseBarValue$default6 = BloodGlucose2DataKt.getBloodGlucoseBarValue$default(8.1f, 0.0f, 2, null);
        Context context6 = this.mContext;
        if (context6 == null) {
            IIX0o.XOxIOxOx("mContext");
            context6 = null;
        }
        int color3 = context6.getResources().getColor(R.color.bg_level_color_diabetes_bg);
        Context context7 = this.mContext;
        if (context7 == null) {
            IIX0o.XOxIOxOx("mContext");
        } else {
            context = context7;
        }
        arrayList.add(new o0Xo.oIX0oI(bloodGlucoseBarValue$default5, bloodGlucoseBarValue$default6, color3, context.getResources().getColor(R.color.bg_level_color_diabetes)));
        SegmentedBarView2 segmentedBarView2 = this.barView;
        if (segmentedBarView2 != null) {
            segmentedBarView2.setSegments(arrayList);
        }
        SegmentedBarView2 segmentedBarView22 = this.barView;
        if (segmentedBarView22 != null) {
            LibExKt.x0OIX00oO(segmentedBarView22, true);
        }
        LinearLayout linearLayout = this.barViewTipLayout;
        if (linearLayout != null) {
            LibExKt.x0OIX00oO(linearLayout, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HeathAIAnalyzeItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Context context = this$0.mContext;
        Context context2 = null;
        if (context == null) {
            IIX0o.XOxIOxOx("mContext");
            context = null;
        }
        Context context3 = this$0.mContext;
        if (context3 == null) {
            IIX0o.XOxIOxOx("mContext");
        } else {
            context2 = context3;
        }
        context.startActivity(new Intent(context2, (Class<?>) MainActivity.class));
    }

    private final void setBmi(double d, List<Double> list, String[] strArr, int[] iArr) {
        CircleThumbSegmentedBarView circleThumbSegmentedBarView = this.mSbvBmi;
        IIX0o.ooOOo0oXI(circleThumbSegmentedBarView);
        WeightMeasureDataKt.setBarView$default(circleThumbSegmentedBarView, d, list, strArr, iArr, false, 32, null);
        CircleThumbSegmentedBarView circleThumbSegmentedBarView2 = this.mSbvBmi;
        if (circleThumbSegmentedBarView2 != null) {
            LibExKt.x0OIX00oO(circleThumbSegmentedBarView2, true);
        }
    }

    public static /* synthetic */ void setViewHidden$default(HeathAIAnalyzeItem heathAIAnalyzeItem, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        heathAIAnalyzeItem.setViewHidden(i, z);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        Context context = itemHolder.getContext();
        IIX0o.oO(context, "<get-context>(...)");
        this.mContext = context;
        View view = itemHolder.view(R.id.tv_heart_rate);
        IIX0o.x0XOIxOo(view, "null cannot be cast to non-null type android.widget.TextView");
        this.mValueTitle = (TextView) view;
        View view2 = itemHolder.view(R.id.tv_hr_zone);
        IIX0o.x0XOIxOo(view2, "null cannot be cast to non-null type android.widget.TextView");
        this.mValueState = (TextView) view2;
        View view3 = itemHolder.view(R.id.tv_heart_rate_value);
        IIX0o.x0XOIxOo(view3, "null cannot be cast to non-null type android.widget.TextView");
        this.mValueTime = (TextView) view3;
        View view4 = itemHolder.view(R.id.tv_ave_value);
        IIX0o.x0XOIxOo(view4, "null cannot be cast to non-null type android.widget.TextView");
        this.mValueFront = (TextView) view4;
        View view5 = itemHolder.view(R.id.sbv_bmi);
        IIX0o.x0XOIxOo(view5, "null cannot be cast to non-null type com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView");
        CircleThumbSegmentedBarView circleThumbSegmentedBarView = (CircleThumbSegmentedBarView) view5;
        this.mSbvBmi = circleThumbSegmentedBarView;
        if (circleThumbSegmentedBarView != null) {
            circleThumbSegmentedBarView.setVisibility(8);
        }
        View view6 = itemHolder.view(R.id.bar_view);
        IIX0o.x0XOIxOo(view6, "null cannot be cast to non-null type com.sma.smartv3.view.segmentedbar.SegmentedBarView2");
        SegmentedBarView2 segmentedBarView2 = (SegmentedBarView2) view6;
        this.barView = segmentedBarView2;
        if (segmentedBarView2 != null) {
            segmentedBarView2.setVisibility(8);
        }
        View view7 = itemHolder.view(R.id.ll_bar_view);
        IIX0o.x0XOIxOo(view7, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view7;
        this.barViewTipLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view8 = itemHolder.view(R.id.iv_bad);
        IIX0o.x0XOIxOo(view8, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        this.mBadIv = (AppCompatImageView) view8;
        View view9 = itemHolder.view(R.id.tv_bad);
        IIX0o.x0XOIxOo(view9, "null cannot be cast to non-null type android.widget.TextView");
        this.mBadTv = (TextView) view9;
        View view10 = itemHolder.view(R.id.iv_general);
        IIX0o.x0XOIxOo(view10, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        this.mMediumIv = (AppCompatImageView) view10;
        View view11 = itemHolder.view(R.id.tv_general);
        IIX0o.x0XOIxOo(view11, "null cannot be cast to non-null type android.widget.TextView");
        this.mMediumTv = (TextView) view11;
        View view12 = itemHolder.view(R.id.iv_good);
        IIX0o.x0XOIxOo(view12, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        this.mGoodIv = (AppCompatImageView) view12;
        View view13 = itemHolder.view(R.id.tv_good);
        IIX0o.x0XOIxOo(view13, "null cannot be cast to non-null type android.widget.TextView");
        this.mGoodTv = (TextView) view13;
        View view14 = itemHolder.view(R.id.iv_highest);
        IIX0o.x0XOIxOo(view14, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        this.mHighestIv = (AppCompatImageView) view14;
        View view15 = itemHolder.view(R.id.tv_highest);
        IIX0o.x0XOIxOo(view15, "null cannot be cast to non-null type android.widget.TextView");
        this.mHighestTv = (TextView) view15;
        setViewHidden$default(this, 0, false, 3, null);
        View view16 = itemHolder.view(R.id.tv_ai_analysis);
        IIX0o.x0XOIxOo(view16, "null cannot be cast to non-null type android.widget.TextView");
        this.mAiAnalysisTitle = (TextView) view16;
        View view17 = itemHolder.view(R.id.tv_ai_analysis_content);
        IIX0o.x0XOIxOo(view17, "null cannot be cast to non-null type android.widget.TextView");
        this.mAiAnalysisResult = (TextView) view17;
        View view18 = itemHolder.view(R.id.tv_avg_bpm_value);
        IIX0o.x0XOIxOo(view18, "null cannot be cast to non-null type android.widget.TextView");
        this.mValueTv = (TextView) view18;
        View view19 = itemHolder.view(R.id.tv_generate_report);
        IIX0o.x0XOIxOo(view19, "null cannot be cast to non-null type android.widget.TextView");
        this.mCommonBtn = (TextView) view19;
    }

    @OXOo.OOXIXo
    public final TodayData getItem() {
        return this.item;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x01f1  */
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView() {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.item.HeathAIAnalyzeItem.initView():void");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.v2_status_item_heart_rate_heath;
    }

    public final void setViewHidden(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppCompatImageView appCompatImageView = this.mBadIv;
        int i9 = 8;
        if (appCompatImageView != null) {
            if (i == 0) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            appCompatImageView.setVisibility(i8);
        }
        AppCompatImageView appCompatImageView2 = this.mMediumIv;
        if (appCompatImageView2 != null) {
            if (i == 1) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            appCompatImageView2.setVisibility(i7);
        }
        AppCompatImageView appCompatImageView3 = this.mGoodIv;
        if (appCompatImageView3 != null) {
            if (i == 2) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            appCompatImageView3.setVisibility(i6);
        }
        AppCompatImageView appCompatImageView4 = this.mHighestIv;
        if (appCompatImageView4 != null) {
            if (i == 3) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            appCompatImageView4.setVisibility(i5);
        }
        TextView textView = this.mBadTv;
        if (textView != null) {
            if (i > -1) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            textView.setVisibility(i4);
        }
        TextView textView2 = this.mMediumTv;
        if (textView2 != null) {
            if (i > -1) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView2.setVisibility(i3);
        }
        TextView textView3 = this.mGoodTv;
        if (textView3 != null) {
            if (i > -1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView3.setVisibility(i2);
        }
        TextView textView4 = this.mHighestTv;
        if (textView4 != null) {
            if (z && i > -1) {
                i9 = 0;
            }
            textView4.setVisibility(i9);
        }
    }

    public HeathAIAnalyzeItem(@OXOo.OOXIXo TodayData item) {
        IIX0o.x0xO0oo(item, "item");
        this.item = item;
    }

    public /* synthetic */ HeathAIAnalyzeItem(TodayData todayData, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new TodayData(0L, null, null, null, 0, null, 0, null, 0.0f, 0.0f, 1023, null) : todayData);
    }
}
