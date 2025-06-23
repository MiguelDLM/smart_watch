package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.BGEMManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppUserUpdate;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.NetWorkUtils$upload$$inlined$upload$1;
import com.sma.smartv3.pop.DatePickerPopup;
import com.sma.smartv3.pop.HeightPickerPopup;
import com.sma.smartv3.pop.WeightPickerPopup;
import com.sma.smartv3.ui.login.EmailBindActivity;
import com.sma.smartv3.ui.login.PhoneBindActivity;
import com.sma.smartv3.ui.login.ReceivePhoneBindActivity;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleGirlCareSettings;
import java.io.File;
import java.util.ArrayList;
import kotlin.Triple;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nUserInfoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserInfoActivity.kt\ncom/sma/smartv3/ui/me/UserInfoActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 6 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,559:1\n19#2:560\n15#2:561\n90#2:562\n90#2:563\n90#2:642\n90#2:643\n11#2,2:644\n19#2:646\n15#2:647\n19#2:648\n15#2:649\n19#2:650\n15#2:651\n87#3,7:564\n94#3,3:572\n70#3,7:575\n97#3:582\n69#3,3:583\n72#3,5:587\n87#3,7:592\n94#3,3:600\n70#3,7:603\n97#3:610\n1#4:571\n1#4:586\n1#4:599\n83#5,7:611\n98#5:641\n106#6,23:618\n*S KotlinDebug\n*F\n+ 1 UserInfoActivity.kt\ncom/sma/smartv3/ui/me/UserInfoActivity\n*L\n81#1:560\n81#1:561\n139#1:562\n141#1:563\n497#1:642\n509#1:643\n533#1:644,2\n542#1:646\n542#1:647\n549#1:648\n549#1:649\n556#1:650\n556#1:651\n403#1:564,7\n403#1:572,3\n403#1:575,7\n403#1:582\n407#1:583,3\n407#1:587,5\n411#1:592,7\n411#1:600,3\n411#1:603,7\n411#1:610\n403#1:571\n407#1:586\n411#1:599\n429#1:611,7\n429#1:641\n429#1:618,23\n*E\n"})
/* loaded from: classes11.dex */
public final class UserInfoActivity extends BaseActivity {
    private boolean isGetFreePoint;

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.oOoXoXO
    private DatePickerPopup mBirthdayPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCrop$delegate;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.IIX0o mEditPop;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.x0xO0oo mFreePointPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xoO0xx0 mGenderPopup;

    @OXOo.oOoXoXO
    private HeightPickerPopup mHeightPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mSavePopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xx0X0 mSelectAvatarPopup;

    @OXOo.oOoXoXO
    private WeightPickerPopup mWeightPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return UserInfoActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivAvatar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) UserInfoActivity.this.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNickname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) UserInfoActivity.this.findViewById(R.id.tv_nickname);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvGender$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvGender$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_gender);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvBirthday$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvBirthday$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_birthday);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvHeight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvHeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_height);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvWeight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvWeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_weight);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvEmail$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvEmail$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_email);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llEmailItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$llEmailItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) UserInfoActivity.this.findViewById(R.id.ll_email_item);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvReceivePhone$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvReceivePhone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_receive_phone);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llReceivePhoneItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$llReceivePhoneItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) UserInfoActivity.this.findViewById(R.id.ll_receive_phone_item);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvPhone$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvPhone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.tv_phone);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llPhoneItem$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$llPhoneItem$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) UserInfoActivity.this.findViewById(R.id.ll_phone_item);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvGetFreePointTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$tvGetFreePointTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) UserInfoActivity.this.findViewById(R.id.user_info_getFreePoint_tip);
        }
    });

    /* loaded from: classes11.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23468oIX0oI;

        static {
            int[] iArr = new int[DateTimeFormat.values().length];
            try {
                iArr[DateTimeFormat.ddMMyyyy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DateTimeFormat.yyyyMMdd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f23468oIX0oI = iArr;
        }
    }

    public UserInfoActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mCrop$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$mCrop$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Xx000oIo.oxoX invoke() {
                Activity mContext;
                com.sma.smartv3.pop.xx0X0 xx0x0;
                ImageView ivAvatar;
                mContext = UserInfoActivity.this.getMContext();
                xx0x0 = UserInfoActivity.this.mSelectAvatarPopup;
                ivAvatar = UserInfoActivity.this.getIvAvatar();
                kotlin.jvm.internal.IIX0o.oO(ivAvatar, "access$getIvAvatar(...)");
                return com.sma.smartv3.util.II0xO0.II0xO0(mContext, xx0x0, ivAvatar);
            }
        });
    }

    private final String birthDataFormat(int i) {
        if (i < 9) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(i);
            return sb.toString();
        }
        return String.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getIvAvatar() {
        return (ImageView) this.ivAvatar$delegate.getValue();
    }

    private final LinearLayout getLlEmailItem() {
        return (LinearLayout) this.llEmailItem$delegate.getValue();
    }

    private final LinearLayout getLlPhoneItem() {
        return (LinearLayout) this.llPhoneItem$delegate.getValue();
    }

    private final LinearLayout getLlReceivePhoneItem() {
        return (LinearLayout) this.llReceivePhoneItem$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final TextView getTvBirthday() {
        return (TextView) this.tvBirthday$delegate.getValue();
    }

    private final TextView getTvEmail() {
        return (TextView) this.tvEmail$delegate.getValue();
    }

    private final TextView getTvGender() {
        return (TextView) this.tvGender$delegate.getValue();
    }

    private final TextView getTvGetFreePointTip() {
        return (TextView) this.tvGetFreePointTip$delegate.getValue();
    }

    private final TextView getTvHeight() {
        return (TextView) this.tvHeight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getTvNickname() {
        return (PFMedium) this.tvNickname$delegate.getValue();
    }

    private final TextView getTvPhone() {
        return (TextView) this.tvPhone$delegate.getValue();
    }

    private final TextView getTvReceivePhone() {
        return (TextView) this.tvReceivePhone$delegate.getValue();
    }

    private final TextView getTvWeight() {
        return (TextView) this.tvWeight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveDone(AppUser appUser) {
        saveUser(appUser);
        if (this.isGetFreePoint) {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.XooIO0oo0() && appUser != null && appUser.getEmail() != null && appUser.getEmail().length() > 0) {
                if (projectManager.oIIxXoo()) {
                    OrderManager.f20130oIX0oI.oOoXoXO(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$saveDone$1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke2(bool);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.oOoXoXO Boolean bool) {
                            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bool, Boolean.TRUE)) {
                                UserInfoActivity.this.onGetFreePoints();
                            }
                        }
                    });
                } else {
                    OrderManager.f20130oIX0oI.ooOOo0oXI(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$saveDone$2
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke2(bool);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.oOoXoXO Boolean bool) {
                            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bool, Boolean.TRUE)) {
                                UserInfoActivity.this.onGetFreePoints();
                            }
                        }
                    });
                }
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24621Xx000oIo, null, 2, null);
            }
        }
        finish();
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24621Xx000oIo, null, 2, null);
    }

    private final void saveUser(AppUser appUser) {
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24637oo, this.mAppUser.getNickname());
        if (com.sma.smartv3.initializer.IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI).exists()) {
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24652xI, null, 2, null);
        }
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(AppUser.class.getName(), new Gson().toJson(appUser));
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24572IO, Boolean.FALSE);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("saveUser " + this.mAppUser.getNickname());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupBirthday() {
        String str;
        if (this.mAppUser.getBirthday().length() == 0) {
            this.mAppUser.setBirthday("01/01/2000");
        }
        Triple<Integer, Integer, Integer> XO2 = TextConvertKt.XO(this.mAppUser.getBirthday());
        int intValue = XO2.component1().intValue();
        int intValue2 = XO2.component2().intValue();
        int intValue3 = XO2.component3().intValue();
        TextView tvBirthday = getTvBirthday();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OoO()) {
            int i = oIX0oI.f23468oIX0oI[projectManager.x0XOIxOo().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    str = birthDataFormat(intValue2) + IOUtils.DIR_SEPARATOR_UNIX + birthDataFormat(intValue3) + IOUtils.DIR_SEPARATOR_UNIX + intValue;
                } else {
                    str = intValue + IOUtils.DIR_SEPARATOR_UNIX + birthDataFormat(intValue2) + IOUtils.DIR_SEPARATOR_UNIX + birthDataFormat(intValue3);
                }
            } else {
                str = birthDataFormat(intValue3) + IOUtils.DIR_SEPARATOR_UNIX + birthDataFormat(intValue2) + IOUtils.DIR_SEPARATOR_UNIX + intValue;
            }
        } else {
            str = birthDataFormat(intValue3) + '.' + birthDataFormat(intValue2) + '.' + intValue;
        }
        tvBirthday.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupGender() {
        int i;
        TextView tvGender = getTvGender();
        if (this.mAppUser.getGender() == 0) {
            i = R.string.female;
        } else {
            i = R.string.male;
        }
        tvGender.setText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupHeight() {
        if (this.mAppUser.getUnit() == 0) {
            getTvHeight().setText(getString(R.string.f_cm, Float.valueOf(this.mAppUser.getHeight())));
        } else {
            int[] oIX0oI2 = Xx000oIo.XO.oIX0oI(this.mAppUser.getHeight());
            getTvHeight().setText(getString(R.string.d_feet_d_inch, Integer.valueOf(oIX0oI2[0]), Integer.valueOf(oIX0oI2[1])));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupWeight() {
        if (this.mAppUser.getUnit() == 0) {
            getTvWeight().setText(getString(R.string.f_kg, Float.valueOf(this.mAppUser.getWeight())));
        } else {
            getTvWeight().setText(getString(R.string.f_lbs, Float.valueOf(Float.parseFloat(TextConvertKt.oo0xXOI0I(Xx000oIo.XO.I0Io(this.mAppUser.getWeight()), true)))));
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x01b0, code lost:
    
        if (r8.mAppUser.getEmail().length() == 0) goto L47;
     */
    @Override // com.bestmafen.androidbase.base.oIX0oI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.me.UserInfoActivity.initView():void");
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_user_info;
    }

    public final void modifyNickName(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        getTvNickname().setText(this.mAppUser.getNickname());
        if (this.mEditPop == null) {
            com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(getMContext(), 0, 2, null);
            iIX0o.xXxxox0I().setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
            iIX0o.xII(R.string.nickname);
            iIX0o.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$modifyNickName$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo String text) {
                    AppUser appUser;
                    PFMedium tvNickname;
                    AppUser appUser2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                    appUser = UserInfoActivity.this.mAppUser;
                    appUser.setNickname(text);
                    tvNickname = UserInfoActivity.this.getTvNickname();
                    appUser2 = UserInfoActivity.this.mAppUser;
                    tvNickname.setText(appUser2.getNickname());
                    return Boolean.TRUE;
                }
            });
            this.mEditPop = iIX0o;
        }
        com.sma.smartv3.pop.IIX0o iIX0o2 = this.mEditPop;
        if (iIX0o2 != null) {
            iIX0o2.xXxxox0I().setText(this.mAppUser.getNickname());
            iIX0o2.xXxxox0I().setTextColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.line_color));
            PFMedium tvNickname = getTvNickname();
            kotlin.jvm.internal.IIX0o.oO(tvNickname, "<get-tvNickname>(...)");
            iIX0o2.OxxIIOOXO(tvNickname);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        com.sma.smartv3.pop.xx0X0 xx0x0;
        super.onActivityResult(i, i2, intent);
        Xx000oIo.oxoX.II0XooXoX(getMCrop(), i, i2, intent, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, 0, 120, null);
        com.sma.smartv3.pop.xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null && xx0x02.isShowing() && (xx0x0 = this.mSelectAvatarPopup) != null) {
            xx0x0.dismiss();
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mAppUser.getNickname().length() == 0) {
            ToastUtils.showLong(R.string.please_input_nick_name);
            return;
        }
        if (this.mAppUser.getHeight() <= ProjectManager.f19822oIX0oI.XI0IXoo()) {
            ToastUtils.showLong(R.string.height_set_error);
            return;
        }
        if (this.mAppUser.getWeight() <= 20.0f) {
            ToastUtils.showLong(R.string.weight_set_error);
            return;
        }
        if (com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true) && this.mAppUser.getIdentity().length() > 0) {
            this.mAppUser.setThirdPlatform(null);
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            File II0XooXoX2 = com.sma.smartv3.initializer.IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI);
            AppUser appUser = this.mAppUser;
            final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$onBottomClick$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                    UserInfoActivity.this.saveDone(appUser2);
                    if (ProductManager.f20544oIX0oI.X00IxOx()) {
                        BGEMManager.xoIox(BGEMManager.f19913oIX0oI, null, 1, null);
                    }
                }
            };
            final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(this, getRootView());
            NetWork netWork = NetWork.f19682oIX0oI;
            String str = Api.INSTANCE.getBASE_URL() + AppUserUpdate.URL;
            final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$onBottomClick$$inlined$upload$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                    NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                    Activity activity = this;
                    xxxI.II0xO0 iI0xO03 = iI0xO0;
                    com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
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
            upload.addMultipartParameter(appUser).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE).getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$onBottomClick$$inlined$upload$2
                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                    xxxI.II0xO0.this.handleResponse(response);
                }

                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                public void onError(@OXOo.oOoXoXO ANError aNError) {
                    xxxI.II0xO0.this.handleError(String.valueOf(aNError));
                }
            });
        } else {
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            FileUtils.copy(com.sma.smartv3.initializer.IXxxXO.II0XooXoX(oix0oi), com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi));
            saveDone(this.mAppUser);
        }
        ArrayList arrayList = new ArrayList();
        Weight weight = new Weight(0, 0L, null, 0.0f, 0, 0, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, 0, 0, 0, -1, 2097151, null);
        weight.setMTime(com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null)[0]);
        String millis2String = TimeUtils.millis2String(weight.getMTime(), com.sma.smartv3.util.xoIox.I0Io());
        kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
        weight.setMLocalTime(millis2String);
        weight.setMWeight(this.mAppUser.getWeight());
        arrayList.add(weight);
        MyDb.INSTANCE.getMDatabase().weightDao().insert(arrayList);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24612XO, null, 2, null);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24587O0Xx)
    public final void onEmailUpdate(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onEmailUpdate");
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        this.mAppUser = (AppUser) appUser;
        getTvEmail().setText(this.mAppUser.getEmail());
    }

    public final void onGetFreePoints() {
        LogUtils.d("onGetFreePoints");
        if (this.mFreePointPopup == null) {
            this.isGetFreePoint = false;
            getTvGetFreePointTip().setVisibility(4);
            com.sma.smartv3.pop.x0xO0oo x0xo0oo = new com.sma.smartv3.pop.x0xO0oo(this, R.layout.pop_center_prompt_free_point);
            ColorStateList valueOf = ColorStateList.valueOf(getResources().getColor(R.color.order_text_orange));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
            if (ProjectManager.f19822oIX0oI.oIIxXoo()) {
                SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                String str = (String) new Gson().fromJson(XO2.getString(com.sma.smartv3.util.XoI0Ixx0.f24375IxIX0I + '_' + String.class.getName()), String.class);
                if (str == null) {
                    str = "0";
                }
                String string = getString(R.string.ai_privileges_giveaway_tip, Integer.valueOf(Integer.parseInt(str)));
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                x0xo0oo.oOXoIIIo(R.string.ai_privileges_delivered);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                String str2 = str;
                spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, oI00o.II0xO0.II0xO0(getMContext(), 16.0f), valueOf, null), StringsKt__StringsKt.O0O0Io00X(string, str2, 0, false, 6, null), StringsKt__StringsKt.O0O0Io00X(string, str2, 0, false, 6, null) + 1, 34);
                x0xo0oo.oo(spannableStringBuilder);
            } else {
                SPUtils XO3 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                String str3 = (String) new Gson().fromJson(XO3.getString(com.sma.smartv3.util.x0xO0oo.f24598Ox0O + '_' + String.class.getName()), String.class);
                if (str3 == null) {
                    str3 = "0";
                }
                String string2 = getString(R.string.free_points_arrived_tip, Integer.valueOf(Integer.parseInt(str3)));
                kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
                x0xo0oo.oOXoIIIo(R.string.free_points_arrived);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string2);
                String str4 = str3;
                spannableStringBuilder2.setSpan(new TextAppearanceSpan(null, 0, oI00o.II0xO0.II0xO0(getMContext(), 16.0f), valueOf, null), StringsKt__StringsKt.O0O0Io00X(string2, str4, 0, false, 6, null), StringsKt__StringsKt.O0O0Io00X(string2, str4, 0, false, 6, null) + 1, 34);
                x0xo0oo.oo(spannableStringBuilder2);
            }
            this.mFreePointPopup = x0xo0oo;
        }
        com.sma.smartv3.pop.x0xO0oo x0xo0oo2 = this.mFreePointPopup;
        if (x0xo0oo2 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            x0xo0oo2.xoXoI(rootView);
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24564I0oOIX)
    public final void onPhoneUpdate(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onPhoneUpdate");
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        this.mAppUser = (AppUser) appUser;
        getTvPhone().setText(this.mAppUser.getPhone());
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24666xoxXI)
    public final void onReceivePhoneUpdate(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onReceivePhoneUpdate");
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        this.mAppUser = (AppUser) appUser;
        getTvReceivePhone().setText(this.mAppUser.getReceivePhone());
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo final View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (FileUtils.isFileExists(com.sma.smartv3.initializer.IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI))) {
            if (this.mSavePopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.whether_to_save_change);
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$onTitleLeftClick$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        UserInfoActivity.this.finish();
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.save, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$onTitleLeftClick$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        UserInfoActivity.this.onBottomClick(view);
                        return Boolean.TRUE;
                    }
                });
                this.mSavePopup = xoI0Ixx0;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mSavePopup;
            if (xoI0Ixx02 != null) {
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        finish();
    }

    public final void selectAvatar(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mSelectAvatarPopup == null) {
            com.sma.smartv3.pop.xx0X0 xx0x0 = new com.sma.smartv3.pop.xx0X0(getMContext());
            xx0x0.xI(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectAvatar$1$1
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity mContext;
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    mContext = UserInfoActivity.this.getMContext();
                    final UserInfoActivity userInfoActivity = UserInfoActivity.this;
                    permissionHelper.X0o0xo(mContext, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectAvatar$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            if (z) {
                                mCrop = UserInfoActivity.this.getMCrop();
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectAvatar$1$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                    invoke2();
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity mContext;
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    mContext = UserInfoActivity.this.getMContext();
                    final UserInfoActivity userInfoActivity = UserInfoActivity.this;
                    permissionHelper.II0xO0(mContext, new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectAvatar$1$2.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            if (z) {
                                mCrop = UserInfoActivity.this.getMCrop();
                                mCrop.OOXIXo();
                            }
                        }
                    });
                }
            });
            this.mSelectAvatarPopup = xx0x0;
        }
        com.sma.smartv3.pop.xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xx0x02.OxxIIOOXO(rootView);
        }
    }

    public final void selectBirthday(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mBirthdayPopup == null) {
            DatePickerPopup datePickerPopup = new DatePickerPopup(this);
            datePickerPopup.oo(R.string.birthday);
            datePickerPopup.oo0xXOI0I(new Oox.IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectBirthday$1$1
                {
                    super(3);
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i, int i2, int i3) {
                    AppUser appUser;
                    appUser = UserInfoActivity.this.mAppUser;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(i3);
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(i);
                    appUser.setBirthday(sb.toString());
                    UserInfoActivity.this.setupBirthday();
                    return Boolean.TRUE;
                }
            });
            this.mBirthdayPopup = datePickerPopup;
        }
        DatePickerPopup datePickerPopup2 = this.mBirthdayPopup;
        if (datePickerPopup2 != null) {
            Triple<Integer, Integer, Integer> XO2 = TextConvertKt.XO(this.mAppUser.getBirthday());
            datePickerPopup2.xI(XO2.component1().intValue(), XO2.component2().intValue(), XO2.component3().intValue());
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            datePickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void selectGender(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int i = 1;
        if (this.mGenderPopup == null) {
            com.sma.smartv3.pop.xoO0xx0 xoo0xx0 = new com.sma.smartv3.pop.xoO0xx0(getMContext(), R.array.genders);
            xoo0xx0.oo(true);
            xoo0xx0.oo0xXOI0I(R.string.gender);
            xoo0xx0.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectGender$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2) {
                    AppUser appUser;
                    appUser = UserInfoActivity.this.mAppUser;
                    appUser.setGender(i2 == 0 ? 1 : 0);
                    UserInfoActivity.this.setupGender();
                    UserInfoActivity.this.sendBleConnector();
                    return Boolean.TRUE;
                }
            });
            this.mGenderPopup = xoo0xx0;
        }
        com.sma.smartv3.pop.xoO0xx0 xoo0xx02 = this.mGenderPopup;
        if (xoo0xx02 != null) {
            if (this.mAppUser.getGender() != 0) {
                i = 0;
            }
            xoo0xx02.IoOoX(i);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoo0xx02.OxxIIOOXO(rootView);
        }
    }

    public final void selectHeight(@OXOo.OOXIXo View view) {
        float height;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mHeightPopup == null) {
            HeightPickerPopup heightPickerPopup = new HeightPickerPopup(getMContext());
            heightPickerPopup.xI(R.string.height);
            heightPickerPopup.oo0xXOI0I(this.mAppUser.getUnit());
            heightPickerPopup.ooXIXxIX(new Oox.oOoXoXO<Float, Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectHeight$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                    return invoke(f.floatValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(float f) {
                    AppUser appUser;
                    appUser = UserInfoActivity.this.mAppUser;
                    appUser.setHeight(f);
                    UserInfoActivity.this.setupHeight();
                    return Boolean.TRUE;
                }
            });
            this.mHeightPopup = heightPickerPopup;
        }
        HeightPickerPopup heightPickerPopup2 = this.mHeightPopup;
        if (heightPickerPopup2 != null) {
            if (this.mAppUser.getHeight() == 0.0f) {
                height = 175.0f;
            } else {
                height = this.mAppUser.getHeight();
            }
            heightPickerPopup2.IIX0o(height);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            heightPickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void selectWeight(@OXOo.OOXIXo View view) {
        float weight;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mWeightPopup == null) {
            WeightPickerPopup weightPickerPopup = new WeightPickerPopup(getMContext());
            weightPickerPopup.ooXIXxIX(R.string.weight);
            weightPickerPopup.xI(this.mAppUser.getUnit());
            weightPickerPopup.IIX0o(new Oox.oOoXoXO<Float, Boolean>() { // from class: com.sma.smartv3.ui.me.UserInfoActivity$selectWeight$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                    return invoke(f.floatValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(float f) {
                    AppUser appUser;
                    appUser = UserInfoActivity.this.mAppUser;
                    appUser.setWeight(f);
                    UserInfoActivity.this.setupWeight();
                    return Boolean.TRUE;
                }
            });
            this.mWeightPopup = weightPickerPopup;
        }
        WeightPickerPopup weightPickerPopup2 = this.mWeightPopup;
        if (weightPickerPopup2 != null) {
            if (this.mAppUser.getWeight() == 0.0f) {
                weight = 65.0f;
            } else {
                weight = this.mAppUser.getWeight();
            }
            weightPickerPopup2.oo0xXOI0I(weight);
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            weightPickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void sendBleConnector() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (bleConnector.isBound()) {
            if (ProjectManager.f19822oIX0oI.I0oOIX()) {
                BleKey bleKey = BleKey.GIRL_CARE;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                BleGirlCareSettings bleGirlCareSettings = (BleGirlCareSettings) BleCache.getObject$default(BleCache.INSTANCE, bleKey, BleGirlCareSettings.class, null, 4, null);
                if (bleGirlCareSettings == null) {
                    bleGirlCareSettings = new BleGirlCareSettings(0, 0, 10, 0, 2, 3, 0, 0, 0, 5, 28, 451, null);
                }
                BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, bleGirlCareSettings, false, false, 24, null);
                return;
            }
            if (ProductManager.f20544oIX0oI.IXxxXO()) {
                BleConnector.sendObject$default(bleConnector, BleKey.GIRL_CARE, BleKeyFlag.UPDATE, new BleGirlCareSettings(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null), false, false, 24, null);
            }
        }
    }

    public final void setEmail(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 0);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) EmailBindActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void setPhone(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 0);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) PhoneBindActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void setReceivePhone(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) ReceivePhoneBindActivity.class));
    }
}
