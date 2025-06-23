package com.sma.smartv3.ui.sport.coach.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.github.appintro.SlideSelectionListener;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppUserUpdate;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.NetWorkUtils$upload$$inlined$upload$1;
import com.sma.smartv3.pop.DatePickerPopup;
import com.sma.smartv3.pop.HeightPickerPopup;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.WeightPickerPopup;
import com.sma.smartv3.pop.xoO0xx0;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.io.File;
import kotlin.Triple;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nPersonalInformationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersonalInformationFragment.kt\ncom/sma/smartv3/ui/sport/coach/guide/PersonalInformationFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,256:1\n19#2:257\n15#2:258\n74#3,16:259\n98#3:298\n106#4,23:275\n*S KotlinDebug\n*F\n+ 1 PersonalInformationFragment.kt\ncom/sma/smartv3/ui/sport/coach/guide/PersonalInformationFragment\n*L\n66#1:257\n66#1:258\n229#1:259,16\n229#1:298\n229#1:275,23\n*E\n"})
/* loaded from: classes12.dex */
public final class PersonalInformationFragment extends BaseFragment implements SlideSelectionListener {

    @OOXIXo
    private final AppUser mAppUser;

    @oOoXoXO
    private DatePickerPopup mBirthdayPopup;
    protected Activity mContext;

    @oOoXoXO
    private xoO0xx0 mGenderPopup;

    @oOoXoXO
    private HeightPickerPopup mHeightPopup;

    @oOoXoXO
    private WeightPickerPopup mWeightPopup;

    @OOXIXo
    private final X0IIOO mGenderLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mGenderLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.personal_ll_gender_layout);
        }
    });

    @OOXIXo
    private final X0IIOO mDateBirthLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mDateBirthLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.personal_ll_date_birth_layout);
        }
    });

    @OOXIXo
    private final X0IIOO mHeightLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mHeightLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.personal_ll_height_layout);
        }
    });

    @OOXIXo
    private final X0IIOO mWeightLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mWeightLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.personal_ll_weight_layout);
        }
    });

    @OOXIXo
    private final X0IIOO mGenderTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mGenderTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.personal_ll_gender_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mBirthdayTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mBirthdayTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.personal_ll_date_birth_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mHeightTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mHeightTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.personal_ll_height_tv);
        }
    });

    @OOXIXo
    private final X0IIOO mWeightTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$mWeightTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.personal_ll_weight_tv);
        }
    });

    @OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = PersonalInformationFragment.this.getMView();
            return mView.findViewById(R.id.root_view);
        }
    });

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23932oIX0oI;

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
            f23932oIX0oI = iArr;
        }
    }

    public PersonalInformationFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
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
    public static final void initView$lambda$0(PersonalInformationFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectGender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PersonalInformationFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectBirthday();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(PersonalInformationFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(PersonalInformationFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectWeight();
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
        TextView mBirthdayTv = getMBirthdayTv();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OoO()) {
            int i = oIX0oI.f23932oIX0oI[projectManager.x0XOIxOo().ordinal()];
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
        mBirthdayTv.setText(str);
    }

    private final void setupGender() {
        int i;
        TextView mGenderTv = getMGenderTv();
        if (this.mAppUser.getGender() == 1) {
            i = R.string.male;
        } else {
            i = R.string.female;
        }
        mGenderTv.setText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupHeight() {
        if (this.mAppUser.getUnit() == 0) {
            getMHeightTv().setText(getString(R.string.f_cm, Float.valueOf(this.mAppUser.getHeight())));
        } else {
            int[] oIX0oI2 = Xx000oIo.XO.oIX0oI(this.mAppUser.getHeight());
            getMHeightTv().setText(getString(R.string.d_feet_d_inch, Integer.valueOf(oIX0oI2[0]), Integer.valueOf(oIX0oI2[1])));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupWeight() {
        if (this.mAppUser.getUnit() == 0) {
            getMWeightTv().setText(getString(R.string.f_kg, Float.valueOf(this.mAppUser.getWeight())));
        } else {
            getMWeightTv().setText(getString(R.string.f_lbs, Float.valueOf(Float.parseFloat(TextConvertKt.oo0xXOI0I(Xx000oIo.XO.I0Io(this.mAppUser.getWeight()), true)))));
        }
    }

    public final TextView getMBirthdayTv() {
        return (TextView) this.mBirthdayTv$delegate.getValue();
    }

    @OOXIXo
    public final Activity getMContext() {
        Activity activity = this.mContext;
        if (activity != null) {
            return activity;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    public final RelativeLayout getMDateBirthLayout() {
        return (RelativeLayout) this.mDateBirthLayout$delegate.getValue();
    }

    public final RelativeLayout getMGenderLayout() {
        return (RelativeLayout) this.mGenderLayout$delegate.getValue();
    }

    public final TextView getMGenderTv() {
        return (TextView) this.mGenderTv$delegate.getValue();
    }

    public final RelativeLayout getMHeightLayout() {
        return (RelativeLayout) this.mHeightLayout$delegate.getValue();
    }

    public final TextView getMHeightTv() {
        return (TextView) this.mHeightTv$delegate.getValue();
    }

    public final RelativeLayout getMWeightLayout() {
        return (RelativeLayout) this.mWeightLayout$delegate.getValue();
    }

    public final TextView getMWeightTv() {
        return (TextView) this.mWeightTv$delegate.getValue();
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        FragmentActivity activity = getActivity();
        IIX0o.x0XOIxOo(activity, "null cannot be cast to non-null type android.app.Activity");
        setMContext(activity);
        setupGender();
        setupBirthday();
        setupHeight();
        setupWeight();
        getMGenderLayout().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.guide.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalInformationFragment.initView$lambda$0(PersonalInformationFragment.this, view);
            }
        });
        getMDateBirthLayout().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.guide.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalInformationFragment.initView$lambda$1(PersonalInformationFragment.this, view);
            }
        });
        getMHeightLayout().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.guide.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalInformationFragment.initView$lambda$2(PersonalInformationFragment.this, view);
            }
        });
        getMWeightLayout().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.guide.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalInformationFragment.initView$lambda$3(PersonalInformationFragment.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_personal_information;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        this.mAppUser.setThirdPlatform(null);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        File II0XooXoX2 = IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI);
        AppUser appUser = this.mAppUser;
        final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$onSlideDeselected$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                AppUser appUser2;
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.II0xO0("PersonalInformationActivity doneClick  handleError ");
                Xo0 xo0 = Xo0.f24349oIX0oI;
                xo0.XO().put(XoI0Ixx0.f24478xII, true);
                SPUtils XO2 = xo0.XO();
                appUser2 = PersonalInformationFragment.this.mAppUser;
                XO2.put(AppUser.class.getName(), new Gson().toJson(appUser2));
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO AppUser appUser2) {
                AppUser appUser3;
                SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                appUser3 = PersonalInformationFragment.this.mAppUser;
                XO2.put(AppUser.class.getName(), new Gson().toJson(appUser3));
            }
        };
        final FragmentActivity requireActivity = requireActivity();
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(requireActivity, null);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = Api.INSTANCE.getBASE_URL() + AppUserUpdate.URL;
        final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$onSlideDeselected$$inlined$upload$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@oOoXoXO Response<AppUser> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity = requireActivity;
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
        upload.addMultipartParameter(appUser).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE).getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$onSlideDeselected$$inlined$upload$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OOXIXo Response<AppUser> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
        AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
        AICoachManage.O0xOxO(oix0oi.oIX0oI(), oix0oi.oIX0oI().XO(this.mAppUser.getBirthday()), this.mAppUser.getGender(), this.mAppUser.getHeight(), this.mAppUser.getWeight(), 0, 0, 0.0f, 0.0f, null, null, 1008, null);
        oix0oi.oIX0oI().Oxx0IOOO();
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
    }

    public final void selectBirthday() {
        if (this.mBirthdayPopup == null) {
            DatePickerPopup datePickerPopup = new DatePickerPopup(getMContext());
            datePickerPopup.oo(R.string.birthday);
            datePickerPopup.oo0xXOI0I(new Oox.IXxxXO<Integer, Integer, Integer, Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$selectBirthday$1$1
                {
                    super(3);
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
                    return invoke(num.intValue(), num2.intValue(), num3.intValue());
                }

                @OOXIXo
                public final Boolean invoke(int i, int i2, int i3) {
                    AppUser appUser;
                    appUser = PersonalInformationFragment.this.mAppUser;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(i3);
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(i);
                    appUser.setBirthday(sb.toString());
                    PersonalInformationFragment.this.setupBirthday();
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
            IIX0o.oO(rootView, "<get-rootView>(...)");
            datePickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void selectGender() {
        if (this.mGenderPopup == null) {
            xoO0xx0 xoo0xx0 = new xoO0xx0(getMContext(), R.array.genders);
            xoo0xx0.oo(true);
            xoo0xx0.oo0xXOI0I(R.string.gender);
            xoo0xx0.xI(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$selectGender$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OOXIXo
                public final Boolean invoke(int i) {
                    AppUser appUser;
                    appUser = PersonalInformationFragment.this.mAppUser;
                    appUser.setGender(i == 0 ? 1 : 0);
                    PersonalInformationFragment.this.getMGenderTv().setText(i == 0 ? R.string.male : R.string.female);
                    return Boolean.TRUE;
                }
            });
            this.mGenderPopup = xoo0xx0;
        }
        xoO0xx0 xoo0xx02 = this.mGenderPopup;
        if (xoo0xx02 != null) {
            CharSequence text = getMGenderTv().getText();
            IIX0o.oO(text, "getText(...)");
            CharSequence oIoIXxIO = StringsKt__StringsKt.oIoIXxIO(text);
            String string = getString(R.string.male);
            IIX0o.oO(string, "getString(...)");
            xoo0xx02.IoOoX(1 ^ (IIX0o.Oxx0IOOO(oIoIXxIO, StringsKt__StringsKt.oIoIXxIO(string).toString()) ? 1 : 0));
            View rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoo0xx02.OxxIIOOXO(rootView);
        }
    }

    public final void selectHeight() {
        float height;
        if (this.mHeightPopup == null) {
            HeightPickerPopup heightPickerPopup = new HeightPickerPopup(getMContext());
            heightPickerPopup.xI(R.string.height);
            heightPickerPopup.oo0xXOI0I(this.mAppUser.getUnit());
            heightPickerPopup.ooXIXxIX(new Oox.oOoXoXO<Float, Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$selectHeight$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                    return invoke(f.floatValue());
                }

                @OOXIXo
                public final Boolean invoke(float f) {
                    AppUser appUser;
                    appUser = PersonalInformationFragment.this.mAppUser;
                    appUser.setHeight(f);
                    PersonalInformationFragment.this.setupHeight();
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
            IIX0o.oO(rootView, "<get-rootView>(...)");
            heightPickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void selectWeight() {
        float weight;
        if (this.mWeightPopup == null) {
            WeightPickerPopup weightPickerPopup = new WeightPickerPopup(getMContext());
            weightPickerPopup.ooXIXxIX(R.string.weight);
            weightPickerPopup.xI(this.mAppUser.getUnit());
            weightPickerPopup.IIX0o(new Oox.oOoXoXO<Float, Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment$selectWeight$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                    return invoke(f.floatValue());
                }

                @OOXIXo
                public final Boolean invoke(float f) {
                    AppUser appUser;
                    appUser = PersonalInformationFragment.this.mAppUser;
                    appUser.setWeight(f);
                    PersonalInformationFragment.this.setupWeight();
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
            IIX0o.oO(rootView, "<get-rootView>(...)");
            weightPickerPopup2.OxxIIOOXO(rootView);
        }
    }

    public final void setMContext(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "<set-?>");
        this.mContext = activity;
    }
}
