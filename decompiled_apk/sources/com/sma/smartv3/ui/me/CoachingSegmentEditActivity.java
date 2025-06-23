package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ConvertUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.DurationPickerPopup;
import com.sma.smartv3.ui.me.CoachingSegmentEditActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.text.FontEditText;
import com.sma.smartv3.view.text.FontTextView;
import com.szabh.smable3.entity.BleCoachingSegment;
import com.szabh.smable3.entity.CompletionCondition;
import com.szabh.smable3.entity.HrZone;
import com.szabh.smable3.entity.SegmentActivity;
import com.szabh.smable3.entity.Stage;
import java.util.ArrayList;

@kotlin.jvm.internal.XX({"SMAP\nCoachingSegmentEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoachingSegmentEditActivity.kt\ncom/sma/smartv3/ui/me/CoachingSegmentEditActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n18#2,2:346\n15#2:348\n11#2,2:399\n65#3,16:349\n93#3,3:365\n11065#4:368\n11400#4,3:369\n1627#4,6:372\n11065#4:378\n11400#4,3:379\n1627#4,6:382\n11065#4:389\n11400#4,3:390\n1627#4,6:393\n1#5:388\n*S KotlinDebug\n*F\n+ 1 CoachingSegmentEditActivity.kt\ncom/sma/smartv3/ui/me/CoachingSegmentEditActivity\n*L\n68#1:346,2\n68#1:348\n336#1:399,2\n83#1:349,16\n83#1:365,3\n170#1:368\n170#1:369,3\n183#1:372,6\n224#1:378\n224#1:379,3\n252#1:382,6\n278#1:389\n278#1:390,3\n290#1:393,6\n*E\n"})
/* loaded from: classes11.dex */
public final class CoachingSegmentEditActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int HR_MAX = 220;
    public static final int HR_MIN = 40;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.Xx000oIo mActivityPop;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mBpmPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mCompletionConditionPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDiscardChangesPopup;

    @OXOo.oOoXoXO
    private DurationPickerPopup mDurationPickerPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mHrZonePopup;

    @OXOo.OOXIXo
    private final BleCoachingSegment mOriginSegment;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mRepeatPopup;

    @OXOo.OOXIXo
    private final BleCoachingSegment mSegment;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mStagePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontEditText>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$edtName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontEditText invoke() {
            return (FontEditText) CoachingSegmentEditActivity.this.findViewById(R.id.edt_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvStage$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tvStage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_stage);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvActivity$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tvActivity$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_activity);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv12$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tv12$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_1_2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv21$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tv21$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_2_1);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv22$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tv22$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_2_2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv31$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tv31$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_3_1);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv32$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$tv32$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingSegmentEditActivity.this.findViewById(R.id.tv_3_2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$btnBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return CoachingSegmentEditActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final Oox.oOoXoXO<Editable, kotlin.oXIO0o0XI> mTextWatcher = new Oox.oOoXoXO<Editable, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$mTextWatcher$1
        {
            super(1);
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Editable editable) {
            invoke2(editable);
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.oOoXoXO Editable editable) {
            String str;
            BleCoachingSegment bleCoachingSegment = CoachingSegmentEditActivity.this.mSegment;
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            bleCoachingSegment.setMName(str);
            CoachingSegmentEditActivity.this.checkFields();
        }
    };

    @OXOo.OOXIXo
    private final Stage[] mStages = Stage.values();

    @OXOo.OOXIXo
    private final SegmentActivity[] mActivities = SegmentActivity.values();
    private final int mGridItemPadding = ConvertUtils.dp2px(12.0f);

    @OXOo.OOXIXo
    private final CompletionCondition[] mConditions = CompletionCondition.values();

    @OXOo.OOXIXo
    private HrZone[] mHrZones = HrZone.values();

    /* loaded from: classes11.dex */
    public static final class I0Io extends BaseAdapter {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ com.sma.smartv3.pop.Xx000oIo f23117Oo;

        public I0Io(com.sma.smartv3.pop.Xx000oIo xx000oIo) {
            this.f23117Oo = xx000oIo;
        }

        public static final void II0xO0(CoachingSegmentEditActivity this$0, int i, com.sma.smartv3.pop.Xx000oIo this_apply, View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(this_apply, "$this_apply");
            this$0.mSegment.setMActivity(this$0.mActivities[i].getActivity());
            this$0.updateActivity();
            this_apply.dismiss();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CoachingSegmentEditActivity.this.mActivities.length;
        }

        @Override // android.widget.Adapter
        @OXOo.oOoXoXO
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @OXOo.OOXIXo
        public View getView(final int i, @OXOo.oOoXoXO View view, @OXOo.oOoXoXO ViewGroup viewGroup) {
            ImageView imageView = new ImageView(CoachingSegmentEditActivity.this.getMContext());
            final CoachingSegmentEditActivity coachingSegmentEditActivity = CoachingSegmentEditActivity.this;
            final com.sma.smartv3.pop.Xx000oIo xx000oIo = this.f23117Oo;
            imageView.setPadding(0, coachingSegmentEditActivity.mGridItemPadding, 0, coachingSegmentEditActivity.mGridItemPadding);
            imageView.setColorFilter(R.color.text_color, PorterDuff.Mode.DST);
            imageView.setImageResource(oOXoIIIo.oIX0oI.oIX0oI(coachingSegmentEditActivity, "ic_segment_activity" + coachingSegmentEditActivity.mActivities[i].getActivity(), "drawable", R.drawable.ic_segment_activity0));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.Oxx0xo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CoachingSegmentEditActivity.I0Io.II0xO0(CoachingSegmentEditActivity.this, i, xx000oIo, view2);
                }
            });
            return imageView;
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class II0xO0 implements TextWatcher {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO f23119XO;

        public II0xO0(Oox.oOoXoXO oooxoxo) {
            this.f23119XO = oooxoxo;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            this.f23119XO.invoke(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes11.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public CoachingSegmentEditActivity() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(BleCoachingSegment.class.getName()), (Class<Object>) BleCoachingSegment.class);
        BleCoachingSegment bleCoachingSegment = (BleCoachingSegment) (fromJson == null ? BleCoachingSegment.class.newInstance() : fromJson);
        this.mSegment = bleCoachingSegment;
        this.mOriginSegment = BleCoachingSegment.copy$default(bleCoachingSegment, 0, null, 0, 0, 0, 0, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFields() {
        getBtnBottom().setEnabled(!TextUtils.isEmpty(this.mSegment.getMName()));
    }

    private final View getBtnBottom() {
        return (View) this.btnBottom$delegate.getValue();
    }

    private final FontEditText getEdtName() {
        return (FontEditText) this.edtName$delegate.getValue();
    }

    private final FontTextView getTv12() {
        return (FontTextView) this.tv12$delegate.getValue();
    }

    private final FontTextView getTv21() {
        return (FontTextView) this.tv21$delegate.getValue();
    }

    private final FontTextView getTv22() {
        return (FontTextView) this.tv22$delegate.getValue();
    }

    private final FontTextView getTv31() {
        return (FontTextView) this.tv31$delegate.getValue();
    }

    private final FontTextView getTv32() {
        return (FontTextView) this.tv32$delegate.getValue();
    }

    private final FontTextView getTvActivity() {
        return (FontTextView) this.tvActivity$delegate.getValue();
    }

    private final FontTextView getTvStage() {
        return (FontTextView) this.tvStage$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateActivity() {
        getTvActivity().setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getMContext(), oOXoIIIo.oIX0oI.oIX0oI(this, "ic_segment_activity" + this.mSegment.getMActivity(), "drawable", R.drawable.ic_segment_activity0)), (Drawable) null, (Drawable) null, (Drawable) null);
        getTvActivity().setText(oOXoIIIo.oIX0oI.oIX0oI(this, "segment_activity" + this.mSegment.getMActivity(), TypedValues.Custom.S_STRING, R.string.segment_activity0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCompleteCondition() {
        getTv12().setText(oOXoIIIo.oIX0oI.oIX0oI(this, "completion_condition" + this.mSegment.getMCompletionCondition(), TypedValues.Custom.S_STRING, R.string.completion_condition0));
        updateCompletionValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCompletionValue() {
        int mCompletionCondition = this.mSegment.getMCompletionCondition();
        if (mCompletionCondition == CompletionCondition.DURATION.getCondition()) {
            FontTextView tv21 = getTv21();
            kotlin.jvm.internal.IIX0o.oO(tv21, "<get-tv21>(...)");
            oOXoIIIo.I0Io.oIX0oI(tv21).setVisibility(8);
            getTv31().setText(R.string.duration);
            getTv32().setText(TextConvertKt.XoX(this.mSegment.getMCompletionValue()));
            return;
        }
        if (mCompletionCondition == CompletionCondition.MANUAL.getCondition()) {
            FontTextView tv212 = getTv21();
            kotlin.jvm.internal.IIX0o.oO(tv212, "<get-tv21>(...)");
            oOXoIIIo.I0Io.oIX0oI(tv212).setVisibility(0);
            getTv21().setText(R.string.repeat);
            getTv22().setText(String.valueOf(this.mSegment.getMCompletionValue()));
            getTv31().setText(R.string.duration);
            getTv32().setText(R.string.util_button_pressed);
            return;
        }
        if (mCompletionCondition == CompletionCondition.DURATION_IN_HR_ZONE.getCondition()) {
            FontTextView tv213 = getTv21();
            kotlin.jvm.internal.IIX0o.oO(tv213, "<get-tv21>(...)");
            oOXoIIIo.I0Io.oIX0oI(tv213).setVisibility(0);
            getTv21().setText(R.string.hr_zone);
            getTv22().setText(oOXoIIIo.oIX0oI.oIX0oI(this, "hr_zone" + this.mSegment.getMHrZone(), TypedValues.Custom.S_STRING, R.string.hr_zone1));
            getTv31().setText(R.string.duration);
            getTv32().setText(TextConvertKt.XoX(this.mSegment.getMCompletionValue()));
            return;
        }
        if (mCompletionCondition == CompletionCondition.HR_ABOVE.getCondition() || mCompletionCondition == CompletionCondition.HR_BELOW.getCondition()) {
            FontTextView tv22 = getTv22();
            kotlin.jvm.internal.IIX0o.oO(tv22, "<get-tv22>(...)");
            oOXoIIIo.I0Io.oIX0oI(tv22).setVisibility(8);
            getTv31().setText(R.string.value);
            getTv32().setText(getString(R.string.d_bpm, Integer.valueOf(this.mSegment.getMCompletionValue())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStage() {
        getTvStage().setText(oOXoIIIo.oIX0oI.oIX0oI(getMContext(), "segment_stage" + this.mSegment.getMStage(), TypedValues.Custom.S_STRING, R.string.segment_stage255));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (getMArg1() < 0) {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.add);
        } else {
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.edit);
        }
        getEdtName().setText(this.mSegment.getMName());
        FontEditText edtName = getEdtName();
        kotlin.jvm.internal.IIX0o.oO(edtName, "<get-edtName>(...)");
        edtName.addTextChangedListener(new II0xO0(this.mTextWatcher));
        updateStage();
        updateActivity();
        updateCompleteCondition();
        checkFields();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_coaching_segment_edit;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(BleCoachingSegment.class.getName(), new Gson().toJson(this.mSegment));
        setResult(-1);
        finish();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.mSegment, this.mOriginSegment)) {
            finish();
            return;
        }
        if (this.mDiscardChangesPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.discard_change_to_segment_tip);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$onTitleLeftClick$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    CoachingSegmentEditActivity.this.finish();
                    return Boolean.TRUE;
                }
            });
            this.mDiscardChangesPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mDiscardChangesPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    public final void setActivity(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mActivityPop == null) {
            com.sma.smartv3.pop.Xx000oIo xx000oIo = new com.sma.smartv3.pop.Xx000oIo(getMContext());
            xx000oIo.XIxXXX0x0(R.string.segment_activity);
            xx000oIo.XI0IXoo(new I0Io(xx000oIo));
            this.mActivityPop = xx000oIo;
        }
        com.sma.smartv3.pop.Xx000oIo xx000oIo2 = this.mActivityPop;
        if (xx000oIo2 != null) {
            xx000oIo2.IIXOooo();
        }
    }

    public final void setCompletionCondition(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int i = 0;
        if (this.mCompletionConditionPopup == null) {
            CompletionCondition[] completionConditionArr = this.mConditions;
            ArrayList arrayList = new ArrayList(completionConditionArr.length);
            for (CompletionCondition completionCondition : completionConditionArr) {
                String string = getString(oOXoIIIo.oIX0oI.oIX0oI(getMContext(), "completion_condition" + completionCondition.getCondition(), TypedValues.Custom.S_STRING, R.string.completion_condition0));
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                arrayList.add(string);
            }
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, arrayList, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.set_to);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$setCompletionCondition$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2) {
                    CompletionCondition[] completionConditionArr2;
                    BleCoachingSegment bleCoachingSegment = CoachingSegmentEditActivity.this.mSegment;
                    completionConditionArr2 = CoachingSegmentEditActivity.this.mConditions;
                    bleCoachingSegment.setMCompletionCondition(completionConditionArr2[i2].getCondition());
                    int mCompletionCondition = CoachingSegmentEditActivity.this.mSegment.getMCompletionCondition();
                    if (mCompletionCondition == CompletionCondition.DURATION.getCondition()) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(30);
                    } else if (mCompletionCondition == CompletionCondition.MANUAL.getCondition()) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(10);
                    } else if (mCompletionCondition == CompletionCondition.DURATION_IN_HR_ZONE.getCondition()) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(30);
                        CoachingSegmentEditActivity.this.mSegment.setMHrZone(HrZone.MODERATE.getZone());
                    } else if (mCompletionCondition == CompletionCondition.HR_ABOVE.getCondition() || mCompletionCondition == CompletionCondition.HR_BELOW.getCondition()) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(100);
                    }
                    CoachingSegmentEditActivity.this.updateCompleteCondition();
                    return Boolean.TRUE;
                }
            });
            this.mCompletionConditionPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mCompletionConditionPopup;
        if (xxoxoooix2 != null) {
            CompletionCondition[] completionConditionArr2 = this.mConditions;
            int length = completionConditionArr2.length;
            while (true) {
                if (i < length) {
                    if (completionConditionArr2[i].getCondition() == this.mSegment.getMCompletionCondition()) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            xxoxoooix2.IIX0o(i);
            xxoxoooix2.IIXOooo();
        }
    }

    public final void setCondition2(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int mCompletionCondition = this.mSegment.getMCompletionCondition();
        int i = 0;
        if (mCompletionCondition == CompletionCondition.MANUAL.getCondition()) {
            if (this.mRepeatPopup == null) {
                Activity mContext = getMContext();
                ArrayList arrayList = new ArrayList(100);
                while (i < 100) {
                    i++;
                    arrayList.add(String.valueOf(i));
                }
                com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(mContext, arrayList);
                oX00O0xII.oo(R.string.repeat);
                oX00O0xII.IoOoX(R.string.times);
                oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$setCondition2$2$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i2) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(i2 + 1);
                        CoachingSegmentEditActivity.this.updateCompletionValue();
                        return Boolean.TRUE;
                    }
                });
                this.mRepeatPopup = oX00O0xII;
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mRepeatPopup;
            if (oX00O0xII2 != null) {
                oX00O0xII2.oOXoIIIo(this.mSegment.getMCompletionValue() - 1);
                oX00O0xII2.IIXOooo();
                return;
            }
            return;
        }
        if (mCompletionCondition == CompletionCondition.DURATION_IN_HR_ZONE.getCondition()) {
            if (this.mHrZonePopup == null) {
                HrZone[] hrZoneArr = this.mHrZones;
                ArrayList arrayList2 = new ArrayList(hrZoneArr.length);
                for (HrZone hrZone : hrZoneArr) {
                    String string = getString(oOXoIIIo.oIX0oI.oIX0oI(this, "hr_zone" + hrZone.getZone(), TypedValues.Custom.S_STRING, R.string.hr_zone1));
                    kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                    arrayList2.add(string);
                }
                com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, arrayList2, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                xxoxoooix.xI(R.string.hr_zone);
                xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$setCondition2$5$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i2) {
                        HrZone[] hrZoneArr2;
                        BleCoachingSegment bleCoachingSegment = CoachingSegmentEditActivity.this.mSegment;
                        hrZoneArr2 = CoachingSegmentEditActivity.this.mHrZones;
                        bleCoachingSegment.setMHrZone(hrZoneArr2[i2].getZone());
                        CoachingSegmentEditActivity.this.updateCompletionValue();
                        return Boolean.TRUE;
                    }
                });
                this.mHrZonePopup = xxoxoooix;
            }
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mHrZonePopup;
            if (xxoxoooix2 != null) {
                HrZone[] hrZoneArr2 = this.mHrZones;
                int length = hrZoneArr2.length;
                while (true) {
                    if (i < length) {
                        if (hrZoneArr2[i].getZone() == this.mSegment.getMHrZone()) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                xxoxoooix2.IIX0o(i);
                xxoxoooix2.IIXOooo();
            }
        }
    }

    public final void setCondition3(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int mCompletionCondition = this.mSegment.getMCompletionCondition();
        if (mCompletionCondition == CompletionCondition.DURATION.getCondition() || mCompletionCondition == CompletionCondition.DURATION_IN_HR_ZONE.getCondition()) {
            if (this.mDurationPickerPopup == null) {
                DurationPickerPopup durationPickerPopup = new DurationPickerPopup(getMContext());
                durationPickerPopup.oo0xXOI0I(R.string.duration);
                durationPickerPopup.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$setCondition3$1$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(i);
                        CoachingSegmentEditActivity.this.updateCompletionValue();
                        return Boolean.TRUE;
                    }
                });
                this.mDurationPickerPopup = durationPickerPopup;
            }
            DurationPickerPopup durationPickerPopup2 = this.mDurationPickerPopup;
            if (durationPickerPopup2 != null) {
                durationPickerPopup2.ooXIXxIX(this.mSegment.getMCompletionValue());
                durationPickerPopup2.IIXOooo();
                return;
            }
            return;
        }
        if (mCompletionCondition == CompletionCondition.HR_ABOVE.getCondition() || mCompletionCondition == CompletionCondition.HR_BELOW.getCondition()) {
            if (this.mBpmPopup == null) {
                Activity mContext = getMContext();
                ArrayList arrayList = new ArrayList(180);
                for (int i = 0; i < 180; i++) {
                    arrayList.add(String.valueOf(i + 40));
                }
                com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(mContext, arrayList);
                oX00O0xII.oo(R.string.value);
                oX00O0xII.IoOoX(R.string.bpm);
                oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$setCondition3$4$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(int i2) {
                        CoachingSegmentEditActivity.this.mSegment.setMCompletionValue(i2 + 40);
                        CoachingSegmentEditActivity.this.updateCompletionValue();
                        return Boolean.TRUE;
                    }
                });
                this.mBpmPopup = oX00O0xII;
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mBpmPopup;
            if (oX00O0xII2 != null) {
                oX00O0xII2.oOXoIIIo(this.mSegment.getMCompletionValue() - 40);
                oX00O0xII2.IIXOooo();
            }
        }
    }

    public final void setStage(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int i = 0;
        if (this.mStagePopup == null) {
            Stage[] stageArr = this.mStages;
            ArrayList arrayList = new ArrayList(stageArr.length);
            for (Stage stage : stageArr) {
                String string = getString(oOXoIIIo.oIX0oI.oIX0oI(getMContext(), "segment_stage" + stage.getStage(), TypedValues.Custom.S_STRING, R.string.segment_stage255));
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                arrayList.add(string);
            }
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, arrayList, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.xI(R.string.segment_type);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentEditActivity$setStage$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2) {
                    Stage[] stageArr2;
                    BleCoachingSegment bleCoachingSegment = CoachingSegmentEditActivity.this.mSegment;
                    stageArr2 = CoachingSegmentEditActivity.this.mStages;
                    bleCoachingSegment.setMStage(stageArr2[i2].getStage());
                    CoachingSegmentEditActivity.this.updateStage();
                    return Boolean.TRUE;
                }
            });
            this.mStagePopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mStagePopup;
        if (xxoxoooix2 != null) {
            Stage[] stageArr2 = this.mStages;
            int length = stageArr2.length;
            while (true) {
                if (i < length) {
                    if (stageArr2[i].getStage() == this.mSegment.getMStage()) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            xxoxoooix2.IIX0o(i);
            xxoxoooix2.IIXOooo();
        }
    }
}
