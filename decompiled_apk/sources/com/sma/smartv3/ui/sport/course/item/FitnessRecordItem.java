package com.sma.smartv3.ui.sport.course.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.LinearLayout;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.course.AllCourseActivity;
import com.sma.smartv3.ui.sport.course.CourseSearchActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class FitnessRecordItem extends BaseDslItem {
    private LinearLayout mCardView;
    public Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(FitnessRecordItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) CourseSearchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(FitnessRecordItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) AllCourseActivity.class));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.search_item);
        IIX0o.ooOOo0oXI(v);
        LinearLayout linearLayout = (LinearLayout) v;
        this.mCardView = linearLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("mCardView");
            linearLayout = null;
        }
        Context context = linearLayout.getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
        LinearLayout linearLayout3 = this.mCardView;
        if (linearLayout3 == null) {
            IIX0o.XOxIOxOx("mCardView");
        } else {
            linearLayout2 = linearLayout3;
        }
        UtilsKt.x0o(linearLayout2, 20.0f);
        itemHolder.click(R.id.search_item, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.item.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitnessRecordItem.bindView$lambda$0(FitnessRecordItem.this, view);
            }
        });
        itemHolder.click(R.id.fitness_item_all_course, new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.item.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitnessRecordItem.bindView$lambda$1(FitnessRecordItem.this, view);
            }
        });
    }

    @OOXIXo
    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        LinearLayout linearLayout = this.mCardView;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("mCardView");
            linearLayout = null;
        }
        linearLayout.setBackgroundTintList(ColorStateList.valueOf(oIxOXo.oxoX.I0Io(getMContext(), R.color.white)));
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.fitness_item_top;
    }

    @XO0.XO(tag = x0xO0oo.f24635oX)
    public final void onThemeChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onThemeChange");
        initView();
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }
}
