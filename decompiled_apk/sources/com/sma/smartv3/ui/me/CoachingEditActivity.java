package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.FontEditText;
import com.sma.smartv3.view.text.FontTextView;
import com.szabh.smable3.entity.BleCoaching;
import java.util.ArrayList;

@kotlin.jvm.internal.XX({"SMAP\nCoachingEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoachingEditActivity.kt\ncom/sma/smartv3/ui/me/CoachingEditActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,134:1\n18#2,2:135\n15#2:137\n18#2,2:138\n15#2:140\n11#2,2:180\n65#3,16:141\n93#3,3:157\n65#3,16:160\n93#3,3:176\n1#4:179\n1#4:187\n140#5,5:182\n145#5,5:188\n*S KotlinDebug\n*F\n+ 1 CoachingEditActivity.kt\ncom/sma/smartv3/ui/me/CoachingEditActivity\n*L\n45#1:135,2\n45#1:137\n46#1:138,2\n46#1:140\n103#1:180,2\n66#1:141,16\n66#1:157,3\n67#1:160,16\n67#1:176,3\n132#1:187\n132#1:182,5\n132#1:188,5\n*E\n"})
/* loaded from: classes11.dex */
public final class CoachingEditActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final BleCoaching mCoaching;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDiscardChangesPopup;

    @OXOo.OOXIXo
    private final BleCoaching mOriginCoaching;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.OX00O0xII mRepeatPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO titleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$titleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CoachingEditActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontEditText>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$edtName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontEditText invoke() {
            return (FontEditText) CoachingEditActivity.this.findViewById(R.id.edt_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvRepeat$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontTextView>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$tvRepeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontTextView invoke() {
            return (FontTextView) CoachingEditActivity.this.findViewById(R.id.tv_repeat);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO edtDescription$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FontEditText>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$edtDescription$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FontEditText invoke() {
            return (FontEditText) CoachingEditActivity.this.findViewById(R.id.edt_description);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$btnBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return CoachingEditActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final Oox.oOoXoXO<Editable, kotlin.oXIO0o0XI> mTitleTextWatcher = new Oox.oOoXoXO<Editable, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$mTitleTextWatcher$1
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
            BleCoaching bleCoaching;
            String str;
            bleCoaching = CoachingEditActivity.this.mCoaching;
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            bleCoaching.setMTitle(str);
            CoachingEditActivity.this.checkFields();
        }
    };

    @OXOo.OOXIXo
    private final Oox.oOoXoXO<Editable, kotlin.oXIO0o0XI> mDescriptionTextWatcher = new Oox.oOoXoXO<Editable, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$mDescriptionTextWatcher$1
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
            BleCoaching bleCoaching;
            String str;
            bleCoaching = CoachingEditActivity.this.mCoaching;
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            bleCoaching.setMDescription(str);
        }
    };

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class II0xO0 implements TextWatcher {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO f23115XO;

        public II0xO0(Oox.oOoXoXO oooxoxo) {
            this.f23115XO = oooxoxo;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            this.f23115XO.invoke(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class oIX0oI implements TextWatcher {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO f23116XO;

        public oIX0oI(Oox.oOoXoXO oooxoxo) {
            this.f23116XO = oooxoxo;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            this.f23116XO.invoke(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public CoachingEditActivity() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        Object fromJson = new Gson().fromJson(xo0.oxoX().getString(BleCoaching.class.getName()), (Class<Object>) BleCoaching.class);
        this.mCoaching = (BleCoaching) (fromJson == null ? BleCoaching.class.newInstance() : fromJson);
        Object fromJson2 = new Gson().fromJson(xo0.oxoX().getString(BleCoaching.class.getName()), (Class<Object>) BleCoaching.class);
        this.mOriginCoaching = (BleCoaching) (fromJson2 == null ? BleCoaching.class.newInstance() : fromJson2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFields() {
        getBtnBottom().setEnabled(!TextUtils.isEmpty(this.mCoaching.getMTitle()));
        getTitleRight().setEnabled(getBtnBottom().isEnabled());
    }

    private final View getBtnBottom() {
        return (View) this.btnBottom$delegate.getValue();
    }

    private final FontEditText getEdtDescription() {
        return (FontEditText) this.edtDescription$delegate.getValue();
    }

    private final FontEditText getEdtName() {
        return (FontEditText) this.edtName$delegate.getValue();
    }

    private final ImageView getTitleRight() {
        return (ImageView) this.titleRight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FontTextView getTvRepeat() {
        return (FontTextView) this.tvRepeat$delegate.getValue();
    }

    private final void save() {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(BleCoaching.class.getName(), new Gson().toJson(this.mCoaching));
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
        ImageView titleRight = getTitleRight();
        titleRight.setVisibility(0);
        titleRight.setImageResource(R.drawable.ic_confirm);
        getEdtName().setText(this.mCoaching.getMTitle());
        getTvRepeat().setText(String.valueOf(this.mCoaching.getMRepeat()));
        getEdtDescription().setText(this.mCoaching.getMDescription());
        FontEditText edtName = getEdtName();
        kotlin.jvm.internal.IIX0o.oO(edtName, "<get-edtName>(...)");
        edtName.addTextChangedListener(new oIX0oI(this.mTitleTextWatcher));
        FontEditText edtDescription = getEdtDescription();
        kotlin.jvm.internal.IIX0o.oO(edtDescription, "<get-edtDescription>(...)");
        edtDescription.addTextChangedListener(new II0xO0(this.mDescriptionTextWatcher));
        checkFields();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_coaching_edit;
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
        save();
        startActivityForResult(new Intent(this, (Class<?>) CoachingSegmentsActivity.class), 0);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.mCoaching, this.mOriginCoaching)) {
            finish();
            return;
        }
        if (this.mDiscardChangesPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.discard_change_to_exercise_tip);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$onTitleLeftClick$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    CoachingEditActivity.this.finish();
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

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        save();
        setResult(-1);
        finish();
    }

    public final void setRepeat(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mRepeatPopup == null) {
            ArrayList arrayList = new ArrayList(20);
            int i = 0;
            while (i < 20) {
                i++;
                arrayList.add(String.valueOf(i));
            }
            com.sma.smartv3.pop.OX00O0xII oX00O0xII = new com.sma.smartv3.pop.OX00O0xII(this, arrayList);
            oX00O0xII.oo(R.string.repeat_times);
            oX00O0xII.IoOoX(R.string.times);
            oX00O0xII.oo0xXOI0I(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingEditActivity$setRepeat$2$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2) {
                    FontTextView tvRepeat;
                    BleCoaching bleCoaching;
                    tvRepeat = CoachingEditActivity.this.getTvRepeat();
                    int i3 = i2 + 1;
                    tvRepeat.setText(String.valueOf(i3));
                    bleCoaching = CoachingEditActivity.this.mCoaching;
                    bleCoaching.setMRepeat(i3);
                    return Boolean.TRUE;
                }
            });
            this.mRepeatPopup = oX00O0xII;
        }
        com.sma.smartv3.pop.OX00O0xII oX00O0xII2 = this.mRepeatPopup;
        if (oX00O0xII2 != null) {
            oX00O0xII2.oOXoIIIo(this.mCoaching.getMRepeat() - 1);
            oX00O0xII2.IIXOooo();
        }
    }
}
