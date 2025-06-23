package com.sma.smartv3.ui.sport.coach.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.ui.sport.coach.CreatePlanActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAICoachGeneratePlan;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public class PlanDetailItem extends BaseDslItem {
    private TextView cumulativeCalories;
    private TextView cumulativeMETS;
    private TextView cumulativeTime;
    private TextView currentCompleted;
    private TextView currentDay;
    private ProgressBar currentProgress;

    @oOoXoXO
    private PopupWindow mPopupWindow;
    private ImageView planArrowIv;

    private final int differenceTime(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("planDetail differenceTime time=" + j + "  , currentTimeMillis = " + System.currentTimeMillis());
        if (j > System.currentTimeMillis()) {
            return 1;
        }
        return ((int) (currentTimeMillis / 86400000)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(final PlanDetailItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        ImageView imageView = this$0.planArrowIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            IIX0o.XOxIOxOx("planArrowIv");
            imageView = null;
        }
        Object systemService = imageView.getContext().getSystemService("layout_inflater");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.popup_plan_layout, (ViewGroup) null);
        IIX0o.oO(inflate, "inflate(...)");
        PopupWindow popupWindow = this$0.mPopupWindow;
        if (popupWindow == null) {
            this$0.mPopupWindow = new PopupWindow(inflate, -2, -2);
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = this$0.mPopupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setFocusable(true);
        }
        int[] iArr = new int[2];
        ImageView imageView3 = this$0.planArrowIv;
        if (imageView3 == null) {
            IIX0o.XOxIOxOx("planArrowIv");
            imageView3 = null;
        }
        imageView3.getLocationOnScreen(iArr);
        int i = iArr[0];
        ImageView imageView4 = this$0.planArrowIv;
        if (imageView4 == null) {
            IIX0o.XOxIOxOx("planArrowIv");
            imageView4 = null;
        }
        int width = i + (i - imageView4.getWidth());
        ImageView imageView5 = this$0.planArrowIv;
        if (imageView5 == null) {
            IIX0o.XOxIOxOx("planArrowIv");
            imageView5 = null;
        }
        int II0xO02 = width + oI00o.II0xO0.II0xO0(imageView5.getContext(), 20.0f);
        int i2 = iArr[1];
        ImageView imageView6 = this$0.planArrowIv;
        if (imageView6 == null) {
            IIX0o.XOxIOxOx("planArrowIv");
            imageView6 = null;
        }
        int height = i2 + imageView6.getHeight();
        PopupWindow popupWindow3 = this$0.mPopupWindow;
        if (popupWindow3 != null) {
            ImageView imageView7 = this$0.planArrowIv;
            if (imageView7 == null) {
                IIX0o.XOxIOxOx("planArrowIv");
            } else {
                imageView2 = imageView7;
            }
            popupWindow3.showAtLocation(imageView2, 0, II0xO02 - 10, height);
        }
        final View findViewById = inflate.findViewById(R.id.popup_make_plans_again);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.item.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlanDetailItem.initView$lambda$2$lambda$0(PlanDetailItem.this, findViewById, view2);
            }
        });
        inflate.findViewById(R.id.popup_terminate_plan).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.item.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlanDetailItem.initView$lambda$2$lambda$1(PlanDetailItem.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(PlanDetailItem this$0, final View view, View view2) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (ProjectManager.f19822oIX0oI.xIOXX()) {
            com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.item.PlanDetailItem$initView$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                    invoke2(bleConnector);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo BleConnector it) {
                    IIX0o.x0xO0oo(it, "it");
                    Intent intent = new Intent(view.getContext(), (Class<?>) CreatePlanActivity.class);
                    intent.putExtra("type", 1);
                    view.getContext().startActivity(intent);
                }
            }, 1, null);
        } else {
            ToastUtils.showLong(R.string.abh_login_tip);
        }
        PopupWindow popupWindow = this$0.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(PlanDetailItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        x0xO0oo.II0xO0(x0xO0oo.f24617XXoOx0, null, 2, null);
        PopupWindow popupWindow = this$0.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private final void setCompletedTime(int i, int i2) {
        String str;
        TextView textView = this.currentDay;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("currentDay");
            textView = null;
        }
        TextView textView3 = this.currentDay;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("currentDay");
        } else {
            textView2 = textView3;
        }
        Context context = textView2.getContext();
        IIX0o.oO(context, "getContext(...)");
        if (UtilsKt.X00IoxXI(context)) {
            str = i + IOUtils.DIR_SEPARATOR_UNIX + i2 + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.days);
        } else {
            str = UtilsKt.oI0IIXIo(R.string.days) + TokenParser.SP + i + IOUtils.DIR_SEPARATOR_UNIX + i2;
        }
        textView.setText(str);
    }

    public static /* synthetic */ void setCompletedTime$default(PlanDetailItem planDetailItem, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 1;
            }
            if ((i3 & 2) != 0) {
                i2 = 28;
            }
            planDetailItem.setCompletedTime(i, i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCompletedTime");
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.plan_detail_day_tv);
        IIX0o.ooOOo0oXI(v);
        this.currentDay = (TextView) v;
        View v2 = itemHolder.v(R.id.plan_detail_completed_tv);
        IIX0o.ooOOo0oXI(v2);
        this.currentCompleted = (TextView) v2;
        View v3 = itemHolder.v(R.id.plan_detail_progress);
        IIX0o.ooOOo0oXI(v3);
        this.currentProgress = (ProgressBar) v3;
        View v4 = itemHolder.v(R.id.plan_cumulative_exercise_time_tv);
        IIX0o.ooOOo0oXI(v4);
        this.cumulativeTime = (TextView) v4;
        View v5 = itemHolder.v(R.id.plan_cumulative_mets_tv);
        IIX0o.ooOOo0oXI(v5);
        this.cumulativeMETS = (TextView) v5;
        View v6 = itemHolder.v(R.id.plan_cumulative_calories_tv);
        IIX0o.ooOOo0oXI(v6);
        this.cumulativeCalories = (TextView) v6;
        View v7 = itemHolder.v(R.id.plan_detail_arrow_iv);
        IIX0o.ooOOo0oXI(v7);
        this.planArrowIv = (ImageView) v7;
    }

    @oOoXoXO
    public final PopupWindow getMPopupWindow() {
        return this.mPopupWindow;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ImageView imageView = null;
        setCompletedTime$default(this, 0, 0, 3, null);
        TextView textView = this.currentCompleted;
        if (textView == null) {
            IIX0o.XOxIOxOx("currentCompleted");
            textView = null;
        }
        StringBuilder sb = new StringBuilder();
        AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
        sb.append(oix0oi.oIX0oI().oI0IIXIo().getMProgress());
        sb.append("% ");
        sb.append(UtilsKt.oI0IIXIo(R.string.coach_plan_complete));
        textView.setText(sb.toString());
        ProgressBar progressBar = this.currentProgress;
        if (progressBar == null) {
            IIX0o.XOxIOxOx("currentProgress");
            progressBar = null;
        }
        progressBar.setMax(100);
        ProgressBar progressBar2 = this.currentProgress;
        if (progressBar2 == null) {
            IIX0o.XOxIOxOx("currentProgress");
            progressBar2 = null;
        }
        progressBar2.setProgress(oix0oi.oIX0oI().oI0IIXIo().getMProgress());
        TextView textView2 = this.cumulativeTime;
        if (textView2 == null) {
            IIX0o.XOxIOxOx("cumulativeTime");
            textView2 = null;
        }
        textView2.setText(oix0oi.oIX0oI().oI0IIXIo().getMAllExerciseTime() + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.min));
        TextView textView3 = this.cumulativeMETS;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("cumulativeMETS");
            textView3 = null;
        }
        textView3.setText(((int) oix0oi.oIX0oI().oI0IIXIo().getMAll_METS()) + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.abh_mets_unit));
        TextView textView4 = this.cumulativeCalories;
        if (textView4 == null) {
            IIX0o.XOxIOxOx("cumulativeCalories");
            textView4 = null;
        }
        textView4.setText(oix0oi.oIX0oI().oI0IIXIo().getMAllCalorie() + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.kcal));
        if (oix0oi.oIX0oI().x0xO0oo() != null) {
            int differenceTime = differenceTime(oix0oi.oIX0oI().oI0IIXIo().getStartTime());
            BleAICoachGeneratePlan x0xO0oo2 = oix0oi.oIX0oI().x0xO0oo();
            if (x0xO0oo2 != null) {
                i = x0xO0oo2.getMProgress();
            } else {
                i = 0;
            }
            BleAICoachGeneratePlan x0xO0oo3 = oix0oi.oIX0oI().x0xO0oo();
            if (x0xO0oo3 != null) {
                i2 = x0xO0oo3.getMProgress();
            } else {
                i2 = 0;
            }
            BleAICoachGeneratePlan x0xO0oo4 = oix0oi.oIX0oI().x0xO0oo();
            if (x0xO0oo4 != null) {
                i3 = x0xO0oo4.getMAllExerciseTime();
            } else {
                i3 = 0;
            }
            BleAICoachGeneratePlan x0xO0oo5 = oix0oi.oIX0oI().x0xO0oo();
            if (x0xO0oo5 != null) {
                i4 = (int) x0xO0oo5.getMAll_METS();
            } else {
                i4 = 0;
            }
            BleAICoachGeneratePlan x0xO0oo6 = oix0oi.oIX0oI().x0xO0oo();
            if (x0xO0oo6 != null) {
                i5 = x0xO0oo6.getMAllCalorie();
            } else {
                i5 = 0;
            }
            setPlanDetail(differenceTime, 28, i, i2, i3, i4, i5);
        }
        ImageView imageView2 = this.planArrowIv;
        if (imageView2 == null) {
            IIX0o.XOxIOxOx("planArrowIv");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.item.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlanDetailItem.initView$lambda$2(PlanDetailItem.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.coach_item_plan_detail;
    }

    public final void setMPopupWindow(@oOoXoXO PopupWindow popupWindow) {
        this.mPopupWindow = popupWindow;
    }

    public final void setPlanDetail(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        setCompletedTime(i, i2);
        TextView textView = this.currentCompleted;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("currentCompleted");
            textView = null;
        }
        textView.setText(i3 + "% " + UtilsKt.oI0IIXIo(R.string.coach_plan_complete));
        ProgressBar progressBar = this.currentProgress;
        if (progressBar == null) {
            IIX0o.XOxIOxOx("currentProgress");
            progressBar = null;
        }
        progressBar.setMax(100);
        ProgressBar progressBar2 = this.currentProgress;
        if (progressBar2 == null) {
            IIX0o.XOxIOxOx("currentProgress");
            progressBar2 = null;
        }
        progressBar2.setProgress(i4);
        TextView textView3 = this.cumulativeTime;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("cumulativeTime");
            textView3 = null;
        }
        textView3.setText(i5 + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.min));
        TextView textView4 = this.cumulativeMETS;
        if (textView4 == null) {
            IIX0o.XOxIOxOx("cumulativeMETS");
            textView4 = null;
        }
        textView4.setText(i6 + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.abh_mets_unit));
        TextView textView5 = this.cumulativeCalories;
        if (textView5 == null) {
            IIX0o.XOxIOxOx("cumulativeCalories");
        } else {
            textView2 = textView5;
        }
        textView2.setText(i7 + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.kcal));
    }
}
