package com.sma.smartv3.ui.sport.coach.item;

import OXOo.OOXIXo;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.util.UtilsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public class PlanContentItem extends BaseDslItem {
    private ImageView currentImg;
    private TextView currentName;
    private TextView currentTitle;
    private View exerciseLayout;
    private TextView exerciseNull;
    private TextView exerciseTime;
    private final boolean isReachedTarget;

    @OOXIXo
    private final AICoachManage.VitalityDayLesson mVitalityDayLesson;

    public PlanContentItem(@OOXIXo AICoachManage.VitalityDayLesson mVitalityDayLesson, boolean z) {
        IIX0o.x0xO0oo(mVitalityDayLesson, "mVitalityDayLesson");
        this.mVitalityDayLesson = mVitalityDayLesson;
        this.isReachedTarget = z;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.coach_content_title);
        IIX0o.ooOOo0oXI(v);
        this.currentTitle = (TextView) v;
        View v2 = itemHolder.v(R.id.coach_content_name);
        IIX0o.ooOOo0oXI(v2);
        this.currentName = (TextView) v2;
        View v3 = itemHolder.v(R.id.coach_content_time);
        IIX0o.ooOOo0oXI(v3);
        this.exerciseTime = (TextView) v3;
        View v4 = itemHolder.v(R.id.coach_content_iv);
        IIX0o.ooOOo0oXI(v4);
        this.currentImg = (ImageView) v4;
        View v5 = itemHolder.v(R.id.coach_content_no_title);
        IIX0o.ooOOo0oXI(v5);
        this.exerciseNull = (TextView) v5;
        View v6 = itemHolder.v(R.id.content_lesson_layout);
        IIX0o.ooOOo0oXI(v6);
        this.exerciseLayout = v6;
    }

    @OOXIXo
    public final AICoachManage.VitalityDayLesson getMVitalityDayLesson() {
        return this.mVitalityDayLesson;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        TextView textView = null;
        if (this.mVitalityDayLesson.getLessonName().length() == 0) {
            TextView textView2 = this.exerciseNull;
            if (textView2 == null) {
                IIX0o.XOxIOxOx("exerciseNull");
                textView2 = null;
            }
            textView2.setVisibility(0);
            View view = this.exerciseLayout;
            if (view == null) {
                IIX0o.XOxIOxOx("exerciseLayout");
                view = null;
            }
            view.setVisibility(4);
            if (this.isReachedTarget) {
                TextView textView3 = this.exerciseNull;
                if (textView3 == null) {
                    IIX0o.XOxIOxOx("exerciseNull");
                    textView3 = null;
                }
                TextView textView4 = this.exerciseNull;
                if (textView4 == null) {
                    IIX0o.XOxIOxOx("exerciseNull");
                    textView4 = null;
                }
                textView3.setTextColor(oIxOXo.oxoX.I0Io(textView4.getContext(), R.color.order_text_orange));
                TextView textView5 = this.exerciseNull;
                if (textView5 == null) {
                    IIX0o.XOxIOxOx("exerciseNull");
                } else {
                    textView = textView5;
                }
                textView.setText(UtilsKt.oI0IIXIo(R.string.abh_reached_day));
                return;
            }
            TextView textView6 = this.exerciseNull;
            if (textView6 == null) {
                IIX0o.XOxIOxOx("exerciseNull");
                textView6 = null;
            }
            TextView textView7 = this.exerciseNull;
            if (textView7 == null) {
                IIX0o.XOxIOxOx("exerciseNull");
                textView7 = null;
            }
            textView6.setTextColor(oIxOXo.oxoX.I0Io(textView7.getContext(), R.color.line_color));
            TextView textView8 = this.exerciseNull;
            if (textView8 == null) {
                IIX0o.XOxIOxOx("exerciseNull");
            } else {
                textView = textView8;
            }
            textView.setText(UtilsKt.oI0IIXIo(R.string.abh_rest_day));
            return;
        }
        TextView textView9 = this.exerciseNull;
        if (textView9 == null) {
            IIX0o.XOxIOxOx("exerciseNull");
            textView9 = null;
        }
        textView9.setVisibility(4);
        View view2 = this.exerciseLayout;
        if (view2 == null) {
            IIX0o.XOxIOxOx("exerciseLayout");
            view2 = null;
        }
        view2.setVisibility(0);
        TextView textView10 = this.currentName;
        if (textView10 == null) {
            IIX0o.XOxIOxOx("currentName");
            textView10 = null;
        }
        textView10.setText(this.mVitalityDayLesson.getLessonName());
        ImageView imageView = this.currentImg;
        if (imageView == null) {
            IIX0o.XOxIOxOx("currentImg");
            imageView = null;
        }
        RequestBuilder<Drawable> load = Glide.with(imageView.getContext()).load(Integer.valueOf(AICoachManage.f23905XO.oIX0oI().x0XOIxOo(this.mVitalityDayLesson.getLessonCode())));
        ImageView imageView2 = this.currentImg;
        if (imageView2 == null) {
            IIX0o.XOxIOxOx("currentImg");
            imageView2 = null;
        }
        load.into(imageView2);
        TextView textView11 = this.currentTitle;
        if (textView11 == null) {
            IIX0o.XOxIOxOx("currentTitle");
            textView11 = null;
        }
        textView11.setText(this.mVitalityDayLesson.getLessonTitle());
        TextView textView12 = this.exerciseTime;
        if (textView12 == null) {
            IIX0o.XOxIOxOx("exerciseTime");
        } else {
            textView = textView12;
        }
        textView.setText(this.mVitalityDayLesson.getLessonTime() + TokenParser.SP + UtilsKt.oI0IIXIo(R.string.min));
    }

    public final boolean isReachedTarget() {
        return this.isReachedTarget;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.coach_item_content_plan;
    }

    public /* synthetic */ PlanContentItem(AICoachManage.VitalityDayLesson vitalityDayLesson, boolean z, int i, IIXOooo iIXOooo) {
        this(vitalityDayLesson, (i & 2) != 0 ? false : z);
    }
}
