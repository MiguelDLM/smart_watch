package com.sma.smartv3.ui.status.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.WeightMeasureDataKt;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppUserUpdate;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.NetWorkUtils$upload$$inlined$upload$1;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.WeightPickerPopup;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.status.BodyFatScaleActivity;
import com.sma.smartv3.ui.status.base.BaseDetailsFragment;
import com.sma.smartv3.util.HeathReportsUtils;
import com.sma.smartv3.util.O00XxXI;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeightRecordsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightRecordsFragment.kt\ncom/sma/smartv3/ui/status/fragment/WeightRecordsFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 8 View.kt\nandroidx/core/view/ViewKt\n+ 9 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 10 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,484:1\n19#2:485\n15#2:486\n83#3,7:487\n98#3:517\n106#4,23:494\n1477#5:518\n1502#5,3:519\n1505#5,3:529\n372#6,7:522\n215#7,2:532\n254#8:534\n254#8:544\n78#9,3:535\n81#9,5:539\n1#10:538\n*S KotlinDebug\n*F\n+ 1 WeightRecordsFragment.kt\ncom/sma/smartv3/ui/status/fragment/WeightRecordsFragment\n*L\n76#1:485\n76#1:486\n229#1:487,7\n229#1:517\n229#1:494,23\n328#1:518\n328#1:519,3\n328#1:529,3\n328#1:522,7\n329#1:532,2\n104#1:534\n113#1:544\n110#1:535,3\n110#1:539,5\n110#1:538\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightRecordsFragment extends BaseDetailsFragment<Weight> {

    @OXOo.OOXIXo
    private final X0IIOO healthBtn$delegate;

    @OXOo.OOXIXo
    private final X0IIOO healthLayout$delegate;

    @OXOo.OOXIXo
    private final X0IIOO healthQuestions$delegate;

    @OXOo.OOXIXo
    private final X0IIOO healthTipLayout$delegate;

    @OXOo.OOXIXo
    private final X0IIOO healthTv$delegate;
    private boolean isImperial;

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO mDeleteWeightPopup$delegate;

    @OXOo.OOXIXo
    private final X0IIOO mSetWeightPopup$delegate;

    @OXOo.OOXIXo
    private final TimePeriod mTimePeriod;

    @OXOo.OOXIXo
    private final WeightDao mWeightDao;
    private int nowSelectX;
    public LineDataSet setValue;
    private SimpleDateFormat timeFormat;

    @OXOo.OOXIXo
    private List<O00XxXI> weekDay;

    @OXOo.OOXIXo
    private final X0IIOO lineChart$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$lineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (LineChart) mView.findViewById(R.id.lineChart);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO changeBt$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$changeBt$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (ImageButton) mView.findViewById(R.id.changeBt);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bodyFatScaleBt$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$bodyFatScaleBt$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (ImageButton) mView.findViewById(R.id.bodyFatScaleBt);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO deleteBt$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$deleteBt$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (ImageButton) mView.findViewById(R.id.deleteBt);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bmiValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$bmiValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.bmiValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bmiEvaluation$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$bmiEvaluation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.bmiEvaluation);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mSbvBmi$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CircleThumbSegmentedBarView>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$mSbvBmi$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CircleThumbSegmentedBarView invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (CircleThumbSegmentedBarView) mView.findViewById(R.id.sbv_bmi);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO weightUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$weightUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.weightUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightRecordsFragment.this.getMView();
            return mView.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final List<Entry> values = new ArrayList();

    @OXOo.OOXIXo
    private final List<Weight> tmpData = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements ooOx.oIX0oI {
        public II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void II0xO0() {
        }

        @Override // ooOx.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo Entry e, @OXOo.OOXIXo XI0oooXX.oxoX h) {
            IIX0o.x0xO0oo(e, "e");
            IIX0o.x0xO0oo(h, "h");
            if (!WeightRecordsFragment.this.getMActivity().isFinishing()) {
                WeightRecordsFragment.this.updateItemData(e);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ox.x0xO0oo {
        public oIX0oI() {
        }

        @Override // ox.x0xO0oo
        @OXOo.OOXIXo
        public String II0XooXoX(float f) {
            if (f == 0.0f) {
                return String.valueOf((int) f);
            }
            if (WeightRecordsFragment.this.isImperial) {
                return ((int) f) + WeightRecordsFragment.this.getMActivity().getString(R.string.lbs);
            }
            return ((int) f) + WeightRecordsFragment.this.getMActivity().getString(R.string.kg);
        }
    }

    public WeightRecordsFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mWeightDao = MyDb.INSTANCE.getMDatabase().weightDao();
        this.weekDay = com.sma.smartv3.util.xoIox.XI0IXoo(getMCalendar().getTimeInMillis());
        this.healthLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$healthLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LinearLayout invoke() {
                View mView;
                mView = WeightRecordsFragment.this.getMView();
                return (LinearLayout) mView.findViewById(R.id.item_health_btn_layout);
            }
        });
        this.healthBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$healthBtn$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final Button invoke() {
                View mView;
                mView = WeightRecordsFragment.this.getMView();
                return (Button) mView.findViewById(R.id.btn_common_heathy);
            }
        });
        this.healthTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$healthTv$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final PFMedium invoke() {
                View mView;
                mView = WeightRecordsFragment.this.getMView();
                return (PFMedium) mView.findViewById(R.id.tv_common_heathy);
            }
        });
        this.healthTipLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$healthTipLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LinearLayout invoke() {
                View mView;
                mView = WeightRecordsFragment.this.getMView();
                return (LinearLayout) mView.findViewById(R.id.questions_healthy_tip_layout);
            }
        });
        this.healthQuestions$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$healthQuestions$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final PFMedium invoke() {
                View mView;
                mView = WeightRecordsFragment.this.getMView();
                return (PFMedium) mView.findViewById(R.id.tv_common_healthy_questions);
            }
        });
        this.mSetWeightPopup$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WeightPickerPopup>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$mSetWeightPopup$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final WeightPickerPopup invoke() {
                AppUser appUser2;
                List list;
                List list2;
                List list3;
                WeightPickerPopup weightPickerPopup = new WeightPickerPopup(WeightRecordsFragment.this.getMActivity());
                final WeightRecordsFragment weightRecordsFragment = WeightRecordsFragment.this;
                weightPickerPopup.ooXIXxIX(R.string.remember_weight);
                appUser2 = weightRecordsFragment.mAppUser;
                weightPickerPopup.xI(appUser2.getUnit());
                list = weightRecordsFragment.tmpData;
                if (list.size() > 0) {
                    list2 = weightRecordsFragment.tmpData;
                    list3 = weightRecordsFragment.tmpData;
                    weightPickerPopup.oo0xXOI0I(((Weight) list2.get(list3.size() - 1)).getMWeight());
                } else {
                    weightPickerPopup.oo0xXOI0I(20.0f);
                }
                weightPickerPopup.IIX0o(new Oox.oOoXoXO<Float, Boolean>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$mSetWeightPopup$2$1$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(float f) {
                        AppUser appUser3;
                        AppUser appUser4;
                        WeightDao weightDao;
                        ArrayList arrayList = new ArrayList();
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("WeightRecordsFragment " + f);
                        if (f >= 20.0f) {
                            appUser3 = WeightRecordsFragment.this.mAppUser;
                            appUser3.setWeight(f);
                            SPUtils XO3 = Xo0.f24349oIX0oI.XO();
                            appUser4 = WeightRecordsFragment.this.mAppUser;
                            XO3.put(AppUser.class.getName(), new Gson().toJson(appUser4));
                            Weight weight = new Weight(0, 0L, null, 0.0f, 0, 0, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, 0, 0, 0, -1, 2097151, null);
                            weight.setMTime(com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null)[0]);
                            String millis2String = TimeUtils.millis2String(System.currentTimeMillis(), com.sma.smartv3.util.xoIox.I0Io());
                            IIX0o.oO(millis2String, "millis2String(...)");
                            weight.setMLocalTime(millis2String);
                            weight.setMWeight(f);
                            arrayList.add(weight);
                            weightDao = WeightRecordsFragment.this.mWeightDao;
                            weightDao.insert(arrayList);
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24612XO, null, 2, null);
                            WeightRecordsFragment weightRecordsFragment2 = WeightRecordsFragment.this;
                            weightRecordsFragment2.update(weightRecordsFragment2.getMCalendar(), 0, WeightRecordsFragment.this.getMTimePeriod());
                            WeightRecordsFragment.this.uploadAppUserUpdate();
                        } else {
                            ToastUtils.showLong(R.string.weight_set_error);
                        }
                        return Boolean.TRUE;
                    }
                });
                return weightPickerPopup;
            }
        });
        this.mDeleteWeightPopup$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<XoI0Ixx0>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$mDeleteWeightPopup$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final XoI0Ixx0 invoke() {
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(WeightRecordsFragment.this.getMActivity(), 0, 2, null);
                final WeightRecordsFragment weightRecordsFragment = WeightRecordsFragment.this;
                xoI0Ixx0.IoOoX(R.string.delete_record_remind);
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$mDeleteWeightPopup$2$1$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.delete, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$mDeleteWeightPopup$2$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        PFMedium bmiValue;
                        PFMedium bmiEvaluation;
                        List list;
                        int i;
                        WeightDao weightDao;
                        List list2;
                        int i2;
                        WeightRecordsFragment.this.getNowValue().setText(R.string.data_none);
                        bmiValue = WeightRecordsFragment.this.getBmiValue();
                        bmiValue.setText(R.string.data_none);
                        bmiEvaluation = WeightRecordsFragment.this.getBmiEvaluation();
                        bmiEvaluation.setText(R.string.data_none);
                        list = WeightRecordsFragment.this.tmpData;
                        i = WeightRecordsFragment.this.nowSelectX;
                        Weight weight = (Weight) list.get(i);
                        weight.setMIsSync(0);
                        weight.setMIsDelete(1);
                        weightDao = WeightRecordsFragment.this.mWeightDao;
                        weightDao.update(CollectionsKt__CollectionsKt.XOxIOxOx(weight));
                        list2 = WeightRecordsFragment.this.tmpData;
                        i2 = WeightRecordsFragment.this.nowSelectX;
                        list2.remove(i2);
                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24612XO, null, 2, null);
                        WeightRecordsFragment.this.setBmi(XIXIX.OOXIXo.f3760XO);
                        WeightRecordsFragment weightRecordsFragment2 = WeightRecordsFragment.this;
                        weightRecordsFragment2.update(weightRecordsFragment2.getMCalendar(), 0, WeightRecordsFragment.this.getMTimePeriod());
                        return Boolean.TRUE;
                    }
                });
                return xoI0Ixx0;
            }
        });
        this.mTimePeriod = TimePeriod.DAY;
    }

    private final void filterData(List<Weight> list) {
        float mWeight;
        this.values.clear();
        this.tmpData.clear();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String format = com.sma.smartv3.util.xoIox.xoIxX().format(Long.valueOf(((Weight) obj).getMTime()));
            Object obj2 = linkedHashMap.get(format);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(format, obj2);
            }
            ((List) obj2).add(obj);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            this.tmpData.addAll(CollectionsKt___CollectionsKt.oxXIOXO((List) ((Map.Entry) it.next()).getValue(), 1));
        }
        int i = 0;
        int i2 = 0;
        for (Weight weight : this.tmpData) {
            int i3 = i2 + 1;
            if (this.isImperial) {
                mWeight = Xx000oIo.XO.I0Io(weight.getMWeight());
            } else {
                mWeight = weight.getMWeight();
            }
            if (i < weight.getMWeight()) {
                i = (int) mWeight;
            }
            this.values.add(new Entry(i2, Float.parseFloat(TextConvertKt.oo0xXOI0I(mWeight, true))));
            i2 = i3;
        }
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        YAxis axisLeft = getLineChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getLineChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.oxoX(axisLeft, axisRight, i);
        setXAxis();
        updateChartData(this.values);
        if (!list.isEmpty()) {
            Weight weight2 = (Weight) CollectionsKt___CollectionsKt.O0O0Io00X(list);
            if (weight2.getMWeight() == 0.0f) {
                Button healthBtn = getHealthBtn();
                if (healthBtn != null) {
                    healthBtn.setEnabled(false);
                    return;
                }
                return;
            }
            String str = weight2.getMWeight() + getString(R.string.kg) + ',' + getString(R.string.bmi) + ':' + TextConvertKt.Oxx0IOOO(weight2.getMWeight(), this.mAppUser.getHeight());
            HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
            long mTime = weight2.getMTime();
            Button healthBtn2 = getHealthBtn();
            IIX0o.oO(healthBtn2, "<get-healthBtn>(...)");
            PFMedium healthTv = getHealthTv();
            IIX0o.oO(healthTv, "<get-healthTv>(...)");
            LinearLayout healthTipLayout = getHealthTipLayout();
            IIX0o.oO(healthTipLayout, "<get-healthTipLayout>(...)");
            PFMedium healthQuestions = getHealthQuestions();
            IIX0o.oO(healthQuestions, "<get-healthQuestions>(...)");
            heathReportsUtils.Io("weight", mTime, healthBtn2, healthTv, healthTipLayout, healthQuestions, getMActivity());
            LinearLayout healthLayout = getHealthLayout();
            IIX0o.oO(healthLayout, "<get-healthLayout>(...)");
            Button healthBtn3 = getHealthBtn();
            IIX0o.oO(healthBtn3, "<get-healthBtn>(...)");
            PFMedium healthTv2 = getHealthTv();
            IIX0o.oO(healthTv2, "<get-healthTv>(...)");
            heathReportsUtils.x0o(healthLayout, healthBtn3, healthTv2, getMActivity(), "weight", str, weight2.getMTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getBmiEvaluation() {
        return (PFMedium) this.bmiEvaluation$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMedium getBmiValue() {
        return (PFMedium) this.bmiValue$delegate.getValue();
    }

    private final ImageButton getBodyFatScaleBt() {
        return (ImageButton) this.bodyFatScaleBt$delegate.getValue();
    }

    private final ImageButton getChangeBt() {
        return (ImageButton) this.changeBt$delegate.getValue();
    }

    private final ImageButton getDeleteBt() {
        return (ImageButton) this.deleteBt$delegate.getValue();
    }

    private final Button getHealthBtn() {
        return (Button) this.healthBtn$delegate.getValue();
    }

    private final LinearLayout getHealthLayout() {
        return (LinearLayout) this.healthLayout$delegate.getValue();
    }

    private final PFMedium getHealthQuestions() {
        return (PFMedium) this.healthQuestions$delegate.getValue();
    }

    private final LinearLayout getHealthTipLayout() {
        return (LinearLayout) this.healthTipLayout$delegate.getValue();
    }

    private final PFMedium getHealthTv() {
        return (PFMedium) this.healthTv$delegate.getValue();
    }

    private final LineChart getLineChart() {
        return (LineChart) this.lineChart$delegate.getValue();
    }

    private final XoI0Ixx0 getMDeleteWeightPopup() {
        return (XoI0Ixx0) this.mDeleteWeightPopup$delegate.getValue();
    }

    private final CircleThumbSegmentedBarView getMSbvBmi() {
        return (CircleThumbSegmentedBarView) this.mSbvBmi$delegate.getValue();
    }

    private final WeightPickerPopup getMSetWeightPopup() {
        return (WeightPickerPopup) this.mSetWeightPopup$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final PFMedium getWeightUnit() {
        return (PFMedium) this.weightUnit$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(WeightRecordsFragment this$0, View view) {
        float weight;
        IIX0o.x0xO0oo(this$0, "this$0");
        RelativeLayout loading = this$0.getLoading();
        IIX0o.oO(loading, "<get-loading>(...)");
        if (loading.getVisibility() != 0) {
            WeightPickerPopup mSetWeightPopup = this$0.getMSetWeightPopup();
            ImageButton changeBt = this$0.getChangeBt();
            IIX0o.oO(changeBt, "<get-changeBt>(...)");
            mSetWeightPopup.OxxIIOOXO(changeBt);
            WeightPickerPopup mSetWeightPopup2 = this$0.getMSetWeightPopup();
            if (this$0.mAppUser.getWeight() == 0.0f) {
                weight = 65.0f;
            } else {
                weight = this$0.mAppUser.getWeight();
            }
            mSetWeightPopup2.oo0xXOI0I(weight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(WeightRecordsFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) BodyFatScaleActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(WeightRecordsFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        RelativeLayout loading = this$0.getLoading();
        IIX0o.oO(loading, "<get-loading>(...)");
        if (loading.getVisibility() != 0 && this$0.tmpData.size() > 0) {
            XoI0Ixx0 mDeleteWeightPopup = this$0.getMDeleteWeightPopup();
            ImageButton deleteBt = this$0.getDeleteBt();
            IIX0o.oO(deleteBt, "<get-deleteBt>(...)");
            mDeleteWeightPopup.OxxIIOOXO(deleteBt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBmi(double d) {
        try {
            CircleThumbSegmentedBarView mSbvBmi = getMSbvBmi();
            IIX0o.oO(mSbvBmi, "<get-mSbvBmi>(...)");
            List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(Double.valueOf(XIXIX.OOXIXo.f3760XO), Double.valueOf(18.4d), Double.valueOf(24.9d), Double.valueOf(29.9d), Double.valueOf(34.9d));
            String[] stringArray = getResources().getStringArray(R.array.level_range_4_2_bmi);
            IIX0o.oO(stringArray, "getStringArray(...)");
            int[] intArray = getResources().getIntArray(R.array.level_color_4_2);
            IIX0o.oO(intArray, "getIntArray(...)");
            WeightMeasureDataKt.setBarView$default(mSbvBmi, d, X00IoxXI2, stringArray, intArray, false, 32, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setXAxis() {
        XAxis xAxis = getLineChart().getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        ArrayList arrayList = new ArrayList();
        Iterator<Weight> it = this.tmpData.iterator();
        while (it.hasNext()) {
            long mTime = it.next().getMTime();
            SimpleDateFormat simpleDateFormat = this.timeFormat;
            if (simpleDateFormat == null) {
                IIX0o.XOxIOxOx("timeFormat");
                simpleDateFormat = null;
            }
            String millis2String = TimeUtils.millis2String(mTime, simpleDateFormat);
            IIX0o.oO(millis2String, "millis2String(...)");
            arrayList.add(millis2String);
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        xAxis.OO(1.0f);
        xAxis.I0X0x0oIo(-0.05f);
        xAxis.xXOx(this.tmpData.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateChartData(List<Entry> list) {
        long j;
        if (getLineChart().getData() != 0 && ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).ooOOo0oXI() > 0) {
            T OOXIXo2 = ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).OOXIXo(0);
            IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
            setSetValue((LineDataSet) OOXIXo2);
            getSetValue().oX0ooo0I0(list);
            getSetValue().I0xX0();
            ((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).XxX0x0xxx();
            getLineChart().X00IoxXI();
            j = 200;
        } else {
            setSetValue(new LineDataSet(list, "Weight Data"));
            getSetValue().OX(ContextCompat.getColor(getMActivity(), R.color.weight_show_1));
            getSetValue().X0ooXIooI(ContextCompat.getColor(getMActivity(), R.color.weight_show_1));
            getSetValue().oXxx000(1.5f);
            getSetValue().xIXIOX(3.5f);
            getSetValue().XOxoX(2.0f);
            getSetValue().x0oxIIIX(ContextCompat.getColor(getMActivity(), R.color.weight_show_0));
            getSetValue().X0IOOI(true);
            getSetValue().ooOOo0oXI(false);
            o0xxxXXxX.ooOOo0oXI ooooo0oxi = new o0xxxXXxX.ooOOo0oXI(getSetValue());
            ooooo0oxi.oo0xXOI0I(false);
            getLineChart().setData(ooooo0oxi);
            getLineChart().IoIOOxIIo(list.size() / 3.0f, 1.0f, 0.0f, 0.0f);
            j = 1000;
        }
        getLineChart().invalidate();
        getLineChart().II0XooXoX((int) j);
        getLineChart().xX0IIXIx0(((o0xxxXXxX.ooOOo0oXI) getLineChart().getData()).IXxxXO());
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.status.fragment.oO
            @Override // java.lang.Runnable
            public final void run() {
                WeightRecordsFragment.updateChartData$lambda$6(WeightRecordsFragment.this);
            }
        }, j + 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateChartData$lambda$6(WeightRecordsFragment this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getLineChart().XIxXXX0x0(((o0xxxXXxX.ooOOo0oXI) this$0.getLineChart().getData()).IXxxXO(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadAppUserUpdate() {
        if (Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24363IO, true) && this.mAppUser.getIdentity().length() > 0) {
            if (this.mAppUser.getHeight() == 0.0f && this.mAppUser.getWeight() == 0.0f) {
                ToastUtils.showLong(R.string.user_does_not_exist);
                return;
            }
            this.mAppUser.setThirdPlatform(null);
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            File II0XooXoX2 = com.sma.smartv3.initializer.IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI);
            AppUser appUser = this.mAppUser;
            final xxxI.II0xO0<AppUser> iI0xO0 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$uploadAppUserUpdate$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                }
            };
            final Activity mActivity = getMActivity();
            final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(mActivity, getRootView());
            NetWork netWork = NetWork.f19682oIX0oI;
            String str = Api.INSTANCE.getBASE_URL() + AppUserUpdate.URL;
            final xxxI.II0xO0<Response<AppUser>> iI0xO02 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$uploadAppUserUpdate$$inlined$upload$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                    NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                    Activity activity = mActivity;
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
            upload.addMultipartParameter(appUser).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE).getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.ui.status.fragment.WeightRecordsFragment$uploadAppUserUpdate$$inlined$upload$2
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
        }
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    @OXOo.OOXIXo
    public TimePeriod getMTimePeriod() {
        return this.mTimePeriod;
    }

    @OXOo.OOXIXo
    public final LineDataSet getSetValue() {
        LineDataSet lineDataSet = this.setValue;
        if (lineDataSet != null) {
            return lineDataSet;
        }
        IIX0o.XOxIOxOx("setValue");
        return null;
    }

    @OXOo.OOXIXo
    public final List<Entry> getValues() {
        return this.values;
    }

    @OXOo.OOXIXo
    public final List<O00XxXI> getWeekDay() {
        return this.weekDay;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        boolean z;
        View findViewById = getMView().findViewById(R.id.ll_bottom_tool);
        if (ProjectManager.f19822oIX0oI.IOoo()) {
            i = 8;
        } else {
            i = 0;
        }
        findViewById.setVisibility(i);
        getMSbvBmi().setVisibility(0);
        setBmi(XIXIX.OOXIXo.f3760XO);
        if (this.mAppUser.getUnit() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isImperial = z;
        getWeightUnit().setText(TextConvertKt.xxX(this.mAppUser.getUnit()));
        getChangeBt().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.x0xO0oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightRecordsFragment.initView$lambda$0(WeightRecordsFragment.this, view);
            }
        });
        getBodyFatScaleBt().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.IXxxXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightRecordsFragment.initView$lambda$1(WeightRecordsFragment.this, view);
            }
        });
        getDeleteBt().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.Oxx0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightRecordsFragment.initView$lambda$2(WeightRecordsFragment.this, view);
            }
        });
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        LineChart lineChart = getLineChart();
        IIX0o.oO(lineChart, "<get-lineChart>(...)");
        oix0oi.II0xO0(lineChart);
        YAxis axisLeft = getLineChart().getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        YAxis axisRight = getLineChart().getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.Oxx0IOOO(axisLeft, axisRight, 0.0f, 30.0f, ContextCompat.getColor(getMActivity(), R.color.line_color));
        LineChart lineChart2 = getLineChart();
        lineChart2.setDragEnabled(true);
        lineChart2.getDescription().Oxx0IOOO(false);
        lineChart2.getLegend().Oxx0IOOO(false);
        lineChart2.setScaleEnabled(false);
        getLineChart().setExtraLeftOffset(20.0f);
        XAxis xAxis = getLineChart().getXAxis();
        IIX0o.x0XOIxOo(xAxis, "null cannot be cast to non-null type com.github.mikephil.charting.components.XAxis");
        oix0oi.X0o0xo(xAxis, false, getMActivity());
        getLineChart().getAxisRight().o0xxxXXxX(new oIX0oI());
        xxx00.I0Io i0Io = new xxx00.I0Io(getLineChart(), getLineChart().getAnimator(), getLineChart().getViewPortHandler());
        i0Io.xxX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        getLineChart().setRenderer(i0Io);
        getLineChart().setOnChartValueSelectedListener(new II0xO0());
        this.timeFormat = com.sma.smartv3.util.xoIox.xI();
        super.initView();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_weight_record;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<? extends Weight> data) {
        IIX0o.x0xO0oo(data, "data");
        filterData(data);
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Weight> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        return this.mWeightDao.getWeights();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24612XO)
    public final void onWeightChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onWeightChanged");
        getNowValue().setText(R.string.data_none);
        getBmiValue().setText(R.string.data_none);
        getBmiEvaluation().setText(R.string.data_none);
        update(getMCalendar(), 0, getMTimePeriod());
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "weight day Data";
    }

    public final void setSetValue(@OXOo.OOXIXo LineDataSet lineDataSet) {
        IIX0o.x0xO0oo(lineDataSet, "<set-?>");
        this.setValue = lineDataSet;
    }

    public final void setWeekDay(@OXOo.OOXIXo List<O00XxXI> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.weekDay = list;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseStatusFragment
    public void share() {
        if (this.tmpData.size() > 0) {
            super.share();
        } else {
            ToastUtils.showLong(R.string.weight_shape_tip);
        }
    }

    public final void updateItemData(@OXOo.OOXIXo Entry e) {
        double mBmi;
        int i;
        IIX0o.x0xO0oo(e, "e");
        this.nowSelectX = (int) e.xxIXOIIO();
        getNowValue().setText(String.valueOf(e.I0Io()));
        getLineChart().xXOx(e.xxIXOIIO(), e.I0Io(), YAxis.AxisDependency.RIGHT, 500L);
        Weight weight = this.tmpData.get(this.nowSelectX);
        DINCondBold nowTimeDetails = getNowTimeDetails();
        long mTime = weight.getMTime();
        SimpleDateFormat simpleDateFormat = this.timeFormat;
        if (simpleDateFormat == null) {
            IIX0o.XOxIOxOx("timeFormat");
            simpleDateFormat = null;
        }
        nowTimeDetails.setText(TimeUtils.millis2String(mTime, simpleDateFormat));
        if (weight.getMBmi() == XIXIX.OOXIXo.f3760XO) {
            mBmi = Double.parseDouble(TextConvertKt.Oxx0IOOO(weight.getMWeight(), this.mAppUser.getHeight()));
        } else {
            mBmi = weight.getMBmi();
        }
        getBmiValue().setText(TextConvertKt.oo((float) mBmi, false, 2, null));
        PFMedium bmiEvaluation = getBmiEvaluation();
        if (mBmi <= 16.4d) {
            i = R.string.very_thin;
        } else if (mBmi <= 18.4d) {
            i = R.string.thin;
        } else if (mBmi <= 24.9d) {
            i = R.string.normal;
        } else if (mBmi <= 29.9d) {
            i = R.string.too_heavy;
        } else if (mBmi <= 34.9d) {
            i = R.string.class_1_obesity;
        } else if (mBmi <= 39.0d) {
            i = R.string.class_2_obesity;
        } else {
            i = R.string.class_3_obesity;
        }
        bmiEvaluation.setText(i);
        if (weight.getMWeight() == 0.0f) {
            setBmi(XIXIX.OOXIXo.f3760XO);
        } else {
            getMSbvBmi().setVisibility(0);
            setBmi(mBmi);
        }
    }
}
