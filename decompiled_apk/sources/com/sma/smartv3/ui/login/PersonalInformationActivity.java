package com.sma.smartv3.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.UploadInfoManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppUserUpdate;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.NetWorkUtils$upload$$inlined$upload$1;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.xx0X0;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.util.OxxIIOOXO;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.WheelView.WheelView;
import com.sma.smartv3.view.picker.DatePicker;
import com.sma.smartv3.view.picker.HeightPicker;
import com.sma.smartv3.view.picker.WeightPicker;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import java.io.File;
import kotlin.Triple;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPersonalInformationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersonalInformationActivity.kt\ncom/sma/smartv3/ui/login/PersonalInformationActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,400:1\n19#2:401\n15#2:402\n27#2,2:434\n11#2,2:445\n83#3,7:403\n98#3:433\n106#4,23:410\n69#5,3:436\n72#5,5:440\n1#6:439\n*S KotlinDebug\n*F\n+ 1 PersonalInformationActivity.kt\ncom/sma/smartv3/ui/login/PersonalInformationActivity\n*L\n71#1:401\n71#1:402\n262#1:434,2\n277#1:445,2\n224#1:403,7\n224#1:433\n224#1:410,23\n266#1:436,3\n266#1:440,5\n266#1:439\n*E\n"})
/* loaded from: classes12.dex */
public final class PersonalInformationActivity extends BaseActivity {

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO mCrop$delegate;

    @OXOo.oOoXoXO
    private xx0X0 mSelectAvatarPopup;

    @OXOo.OOXIXo
    private PersonalInfo nowLl;
    private int stepGoalValue;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PersonalInformationActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llNameAndGender$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$llNameAndGender$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) PersonalInformationActivity.this.findViewById(R.id.llNameAndGender);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llBirthdayAndUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$llBirthdayAndUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) PersonalInformationActivity.this.findViewById(R.id.llBirthdayAndUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llHeightAndWeight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$llHeightAndWeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) PersonalInformationActivity.this.findViewById(R.id.llHeightAndWeight);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llMovingTarget$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$llMovingTarget$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) PersonalInformationActivity.this.findViewById(R.id.llMovingTarget);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivAvatar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) PersonalInformationActivity.this.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO edtNickname$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextInputEditText>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$edtNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextInputEditText invoke() {
            return (TextInputEditText) PersonalInformationActivity.this.findViewById(R.id.edtNickname);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rbMale$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RadioButton>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$rbMale$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RadioButton invoke() {
            return (RadioButton) PersonalInformationActivity.this.findViewById(R.id.rbMale);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rbFemale$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RadioButton>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$rbFemale$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RadioButton invoke() {
            return (RadioButton) PersonalInformationActivity.this.findViewById(R.id.rbFemale);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rbMetric$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RadioButton>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$rbMetric$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RadioButton invoke() {
            return (RadioButton) PersonalInformationActivity.this.findViewById(R.id.rbMetric);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rbImperial$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RadioButton>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$rbImperial$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RadioButton invoke() {
            return (RadioButton) PersonalInformationActivity.this.findViewById(R.id.rbImperial);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO datePicker$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DatePicker>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$datePicker$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DatePicker invoke() {
            return (DatePicker) PersonalInformationActivity.this.findViewById(R.id.datePicker);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO heightPicker$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HeightPicker>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$heightPicker$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final HeightPicker invoke() {
            return (HeightPicker) PersonalInformationActivity.this.findViewById(R.id.heightPicker);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO weightPicker$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WeightPicker>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$weightPicker$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WeightPicker invoke() {
            return (WeightPicker) PersonalInformationActivity.this.findViewById(R.id.weightPicker);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO wv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WheelView>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$wv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WheelView invoke() {
            return (WheelView) PersonalInformationActivity.this.findViewById(R.id.wv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO distanceGoal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$distanceGoal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) PersonalInformationActivity.this.findViewById(R.id.distanceGoal);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO caloriesGoal$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$caloriesGoal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) PersonalInformationActivity.this.findViewById(R.id.caloriesGoal);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO distanceUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$distanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PersonalInformationActivity.this.findViewById(R.id.nowGoalUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO titleLeft$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$titleLeft$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) PersonalInformationActivity.this.findViewById(R.id.abh_title_left);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO nickNameLine$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$nickNameLine$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return PersonalInformationActivity.this.findViewById(R.id.nickNameLine);
        }
    });

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23034oIX0oI;

        static {
            int[] iArr = new int[PersonalInfo.values().length];
            try {
                iArr[PersonalInfo.BIRTHDAY_UNIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PersonalInfo.HEIGHT_WEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PersonalInfo.MOVING_TARGET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PersonalInfo.NAME_GENDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f23034oIX0oI = iArr;
        }
    }

    public PersonalInformationActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.nowLl = PersonalInfo.NAME_GENDER;
        this.mCrop$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$mCrop$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Xx000oIo.oxoX invoke() {
                Activity mContext;
                xx0X0 xx0x0;
                ImageViewRound ivAvatar;
                mContext = PersonalInformationActivity.this.getMContext();
                xx0x0 = PersonalInformationActivity.this.mSelectAvatarPopup;
                ivAvatar = PersonalInformationActivity.this.getIvAvatar();
                IIX0o.oO(ivAvatar, "access$getIvAvatar(...)");
                return com.sma.smartv3.util.II0xO0.II0xO0(mContext, xx0x0, ivAvatar);
            }
        });
    }

    private final void countGoal(String str) {
        this.stepGoalValue = Integer.parseInt(str);
        getDistanceGoal().setText(TextConvertKt.O0Xx(this.mAppUser.getHeight(), this.stepGoalValue, this.mAppUser.getUnit()));
        getCaloriesGoal().setText(TextConvertKt.XoI0Ixx0(this.mAppUser.getGender(), this.mAppUser.getWeight(), this.stepGoalValue));
    }

    private final DINCondBold getCaloriesGoal() {
        return (DINCondBold) this.caloriesGoal$delegate.getValue();
    }

    private final DatePicker getDatePicker() {
        return (DatePicker) this.datePicker$delegate.getValue();
    }

    private final DINCondBold getDistanceGoal() {
        return (DINCondBold) this.distanceGoal$delegate.getValue();
    }

    private final PFMedium getDistanceUnit() {
        return (PFMedium) this.distanceUnit$delegate.getValue();
    }

    private final TextInputEditText getEdtNickname() {
        return (TextInputEditText) this.edtNickname$delegate.getValue();
    }

    private final HeightPicker getHeightPicker() {
        return (HeightPicker) this.heightPicker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageViewRound getIvAvatar() {
        return (ImageViewRound) this.ivAvatar$delegate.getValue();
    }

    private final RelativeLayout getLlBirthdayAndUnit() {
        return (RelativeLayout) this.llBirthdayAndUnit$delegate.getValue();
    }

    private final RelativeLayout getLlHeightAndWeight() {
        return (RelativeLayout) this.llHeightAndWeight$delegate.getValue();
    }

    private final RelativeLayout getLlMovingTarget() {
        return (RelativeLayout) this.llMovingTarget$delegate.getValue();
    }

    private final RelativeLayout getLlNameAndGender() {
        return (RelativeLayout) this.llNameAndGender$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    private final View getNickNameLine() {
        return (View) this.nickNameLine$delegate.getValue();
    }

    private final RadioButton getRbFemale() {
        return (RadioButton) this.rbFemale$delegate.getValue();
    }

    private final RadioButton getRbImperial() {
        return (RadioButton) this.rbImperial$delegate.getValue();
    }

    private final RadioButton getRbMale() {
        return (RadioButton) this.rbMale$delegate.getValue();
    }

    private final RadioButton getRbMetric() {
        return (RadioButton) this.rbMetric$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final ImageView getTitleLeft() {
        return (ImageView) this.titleLeft$delegate.getValue();
    }

    private final WeightPicker getWeightPicker() {
        return (WeightPicker) this.weightPicker$delegate.getValue();
    }

    private final WheelView getWv() {
        return (WheelView) this.wv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void heightAndWeightClick$lambda$2$lambda$1(PersonalInformationActivity this$0, int i) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.countGoal(OxxIIOOXO.oIX0oI().get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PersonalInformationActivity this$0, View view, boolean z) {
        int i;
        IIX0o.x0xO0oo(this$0, "this$0");
        View nickNameLine = this$0.getNickNameLine();
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        nickNameLine.setVisibility(i);
    }

    private final void saveUser(AppUser appUser) {
        x0xO0oo.II0xO0(x0xO0oo.f24578IoOoo, null, 2, null);
        x0xO0oo.oIX0oI(x0xO0oo.f24637oo, this.mAppUser.getNickname());
        if (IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI).exists()) {
            x0xO0oo.II0xO0(x0xO0oo.f24652xI, null, 2, null);
        }
        Xo0.f24349oIX0oI.XO().put(AppUser.class.getName(), new Gson().toJson(appUser));
    }

    private final void setBirthday() {
        DatePicker datePicker = getDatePicker();
        datePicker.setVisibleCount(3);
        datePicker.setMListener(new Oox.IXxxXO<Integer, Integer, Integer, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$setBirthday$1$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2, Integer num3) {
                invoke(num.intValue(), num2.intValue(), num3.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2, int i3) {
                AppUser appUser;
                appUser = PersonalInformationActivity.this.mAppUser;
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append(i3);
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append(i);
                appUser.setBirthday(sb.toString());
            }
        });
        if (this.mAppUser.getBirthday().length() == 0) {
            this.mAppUser.setBirthday("01/01/2000");
        }
        Triple<Integer, Integer, Integer> XO2 = TextConvertKt.XO(this.mAppUser.getBirthday());
        getDatePicker().xoIox(XO2.component1().intValue(), XO2.component2().intValue(), XO2.component3().intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDone(AppUser appUser) {
        saveUser(appUser);
        BleCache.putInt$default(BleCache.INSTANCE, BleKey.STEP_GOAL, this.stepGoalValue, null, 4, null);
        Xo0.f24349oIX0oI.oxoX().remove(AppUser.class.getName());
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    private final void setHeight() {
        HeightPicker heightPicker = getHeightPicker();
        heightPicker.setVisibleCount(3);
        heightPicker.setMListener(new Oox.oOoXoXO<Float, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$setHeight$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Float f) {
                invoke(f.floatValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(float f) {
                AppUser appUser;
                appUser = PersonalInformationActivity.this.mAppUser;
                appUser.setHeight(f);
            }
        });
        getHeightPicker().setHeight(this.mAppUser.getHeight());
        getHeightPicker().setUnit(this.mAppUser.getUnit());
    }

    private final void setWeight() {
        WeightPicker weightPicker = getWeightPicker();
        weightPicker.setVisibleCount(3);
        weightPicker.setMListener(new Oox.oOoXoXO<Float, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$setWeight$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Float f) {
                invoke(f.floatValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(float f) {
                AppUser appUser;
                appUser = PersonalInformationActivity.this.mAppUser;
                appUser.setWeight(f);
            }
        });
        getWeightPicker().setWeight(this.mAppUser.getWeight());
        getWeightPicker().setUnit(this.mAppUser.getUnit());
    }

    private final void showContent(PersonalInfo personalInfo) {
        int i = oIX0oI.f23034oIX0oI[personalInfo.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        finish();
                        return;
                    }
                    getLlNameAndGender().setVisibility(0);
                    getLlBirthdayAndUnit().setVisibility(8);
                    getLlHeightAndWeight().setVisibility(8);
                    getLlMovingTarget().setVisibility(8);
                    getTitleLeft().setVisibility(4);
                    this.nowLl = PersonalInfo.NAME_GENDER;
                    return;
                }
                getLlNameAndGender().setVisibility(8);
                getLlBirthdayAndUnit().setVisibility(8);
                getLlHeightAndWeight().setVisibility(8);
                getLlMovingTarget().setVisibility(0);
                getTitleLeft().setVisibility(0);
                this.nowLl = PersonalInfo.MOVING_TARGET;
                return;
            }
            getLlNameAndGender().setVisibility(8);
            getLlBirthdayAndUnit().setVisibility(8);
            getLlHeightAndWeight().setVisibility(0);
            getLlMovingTarget().setVisibility(8);
            getTitleLeft().setVisibility(0);
            this.nowLl = PersonalInfo.HEIGHT_WEIGHT;
            return;
        }
        getLlNameAndGender().setVisibility(8);
        getLlBirthdayAndUnit().setVisibility(0);
        getLlHeightAndWeight().setVisibility(8);
        getLlMovingTarget().setVisibility(8);
        getTitleLeft().setVisibility(0);
        this.nowLl = PersonalInfo.BIRTHDAY_UNIT;
    }

    public final void birthdayAndUnitClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        this.mAppUser.setUnit(!getRbMetric().isChecked() ? 1 : 0);
        LogUtils.d(this.mAppUser.toString());
        setHeight();
        setWeight();
        showContent(PersonalInfo.HEIGHT_WEIGHT);
    }

    public final void doneClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mAppUser.getHeight() == 0.0f && this.mAppUser.getWeight() == 0.0f) {
            ToastUtils.showLong(R.string.user_does_not_exist);
            return;
        }
        UploadInfoManager uploadInfoManager = UploadInfoManager.f20222oIX0oI;
        uploadInfoManager.X0o0xo(this.mAppUser);
        if (Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24363IO, true)) {
            this.mAppUser.setThirdPlatform(null);
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            File II0XooXoX2 = IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI);
            AppUser appUser = this.mAppUser;
            final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$doneClick$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    AppUser appUser2;
                    IIX0o.x0xO0oo(error, "error");
                    OI0.oIX0oI.f1507oIX0oI.II0xO0("PersonalInformationActivity doneClick  handleError ");
                    Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24478xII, true);
                    PersonalInformationActivity personalInformationActivity = PersonalInformationActivity.this;
                    appUser2 = personalInformationActivity.mAppUser;
                    personalInformationActivity.setDone(appUser2);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                    PersonalInformationActivity.this.setDone(appUser2);
                }
            };
            final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRootView());
            NetWork netWork = NetWork.f19682oIX0oI;
            String str = Api.INSTANCE.getBASE_URL() + AppUserUpdate.URL;
            final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$doneClick$$inlined$upload$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                    NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                    Activity activity = this;
                    xxxI.II0xO0 iI0xO03 = iI0xO0;
                    I0X0x0oIo i0X0x0oIo = loadPopup;
                    LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                    if (response == null) {
                        response = new Response<>();
                        response.setCode(-1000);
                    }
                    netWorkUtils2.responseWhenCheck(activity, response, iI0xO03);
                    if (i0X0x0oIo != null) {
                        i0X0x0oIo.dismiss();
                    }
                }
            };
            ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(str);
            if (II0XooXoX2.exists()) {
                upload.addMultipartFile("avatar", II0XooXoX2);
            }
            upload.addMultipartParameter(appUser).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE).getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$doneClick$$inlined$upload$2
                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                    IIX0o.x0xO0oo(response, "response");
                    xxxI.II0xO0.this.handleResponse(response);
                }

                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                public void onError(@OXOo.oOoXoXO ANError aNError) {
                    xxxI.II0xO0.this.handleError(String.valueOf(aNError));
                }
            });
            return;
        }
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        FileUtils.copy(IXxxXO.II0XooXoX(oix0oi), IXxxXO.xxIXOIIO(oix0oi));
        setDone(this.mAppUser);
        try {
            uploadInfoManager.oOoXoXO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void heightAndWeightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mAppUser.getHeight() <= ProjectManager.f19822oIX0oI.XI0IXoo()) {
            ToastUtils.showLong(R.string.height_set_error);
            return;
        }
        if (this.mAppUser.getWeight() <= 20.0f) {
            ToastUtils.showLong(R.string.weight_set_error);
            return;
        }
        getDistanceUnit().setText(TextConvertKt.oI0IIXIo(this.mAppUser.getUnit()));
        WheelView wv = getWv();
        IIX0o.oO(wv, "<get-wv>(...)");
        OxxIIOOXO.II0xO0(wv, 5);
        countGoal(OxxIIOOXO.oIX0oI().get(5));
        getWv().setListener(new X0O0I0.I0Io() { // from class: com.sma.smartv3.ui.login.XO
            @Override // X0O0I0.I0Io
            public final void onItemSelected(int i) {
                PersonalInformationActivity.heightAndWeightClick$lambda$2$lambda$1(PersonalInformationActivity.this, i);
            }
        });
        LogUtils.d(this.mAppUser.toString());
        showContent(PersonalInfo.MOVING_TARGET);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.personal_information);
        Xx000oIo.oxoX.oO(getMCrop(), this, null, 2, null);
        showContent(PersonalInfo.NAME_GENDER);
        getRbMale().setChecked(true);
        if (ProjectManager.f19822oIX0oI.oX000x()) {
            getRbMetric().setChecked(true);
            getRbImperial().setChecked(false);
        } else {
            getRbMetric().setChecked(false);
            getRbImperial().setChecked(true);
        }
        getIvAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        if (this.mAppUser.getAvatarUrl().length() > 0) {
            NetWorkUtils.INSTANCE.getImage(this.mAppUser.getAvatarUrl(), IXxxXO.xxIXOIIO(X00IoxXI.oIX0oI.f3233oIX0oI), new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$initView$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str) {
                    ImageViewRound ivAvatar;
                    x0xO0oo.II0xO0(x0xO0oo.f24638oo0xXOI0I, null, 2, null);
                    ivAvatar = PersonalInformationActivity.this.getIvAvatar();
                    ivAvatar.setImageURI(Uri.fromFile(IXxxXO.xxIXOIIO(X00IoxXI.oIX0oI.f3233oIX0oI)));
                }
            });
        } else {
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            if (IXxxXO.xxIXOIIO(oix0oi).exists()) {
                getIvAvatar().setImageURI(Uri.fromFile(IXxxXO.xxIXOIIO(oix0oi)));
            }
        }
        getEdtNickname().setText(this.mAppUser.getNickname());
        getEdtNickname().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.sma.smartv3.ui.login.Oxx0IOOO
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PersonalInformationActivity.initView$lambda$0(PersonalInformationActivity.this, view, z);
            }
        });
        if (this.mAppUser.getWeight() == 0.0f) {
            this.mAppUser.setWeight(65.0f);
        }
        if (this.mAppUser.getHeight() == 0.0f) {
            this.mAppUser.setHeight(175.0f);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_personal_info;
    }

    public final void nameAndGenderClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (String.valueOf(getEdtNickname().getText()).length() == 0) {
            ToastUtils.showLong(R.string.please_input_nick_name);
            return;
        }
        this.mAppUser.setNickname(String.valueOf(getEdtNickname().getText()));
        this.mAppUser.setGender(!getRbFemale().isChecked() ? 1 : 0);
        setBirthday();
        LogUtils.d(this.mAppUser.toString());
        showContent(PersonalInfo.BIRTHDAY_UNIT);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        xx0X0 xx0x0;
        super.onActivityResult(i, i2, intent);
        Xx000oIo.oxoX.II0XooXoX(getMCrop(), i, i2, intent, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, 0, 120, null);
        xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null && xx0x02.isShowing() && (xx0x0 = this.mSelectAvatarPopup) != null) {
            xx0x0.dismiss();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        View rootView = getRootView();
        IIX0o.oO(rootView, "<get-rootView>(...)");
        onTitleLeftClick(rootView);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        int i = oIX0oI.f23034oIX0oI[this.nowLl.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    showContent(PersonalInfo.HEIGHT_WEIGHT);
                    return;
                }
                return;
            }
            showContent(PersonalInfo.BIRTHDAY_UNIT);
            return;
        }
        showContent(PersonalInfo.NAME_GENDER);
    }

    public final void selectAvatar(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mSelectAvatarPopup == null) {
            xx0X0 xx0x0 = new xx0X0(getMContext());
            xx0x0.xI(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$selectAvatar$1$1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity mContext;
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    mContext = PersonalInformationActivity.this.getMContext();
                    final PersonalInformationActivity personalInformationActivity = PersonalInformationActivity.this;
                    permissionHelper.X0o0xo(mContext, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$selectAvatar$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            if (z) {
                                mCrop = PersonalInformationActivity.this.getMCrop();
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$selectAvatar$1$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity mContext;
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    mContext = PersonalInformationActivity.this.getMContext();
                    final PersonalInformationActivity personalInformationActivity = PersonalInformationActivity.this;
                    permissionHelper.II0xO0(mContext, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.login.PersonalInformationActivity$selectAvatar$1$2.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            if (z) {
                                mCrop = PersonalInformationActivity.this.getMCrop();
                                mCrop.OOXIXo();
                            }
                        }
                    });
                }
            });
            this.mSelectAvatarPopup = xx0x0;
        }
        xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null) {
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xx0x02.OxxIIOOXO(rootView);
        }
    }
}
