package com.sma.smartv3.ui.sport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.ar.auth.FeatureCodes;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.dao.SportDataDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.db.entity.SportData;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.text.DINCondBold;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.random.Random;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailChartFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailChartFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailChartFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1194:1\n19#2:1195\n15#2:1196\n19#2:1205\n15#2:1206\n1855#3:1197\n1855#3,2:1198\n1856#3:1200\n1855#3,2:1201\n1864#3,2:1203\n1866#3:1207\n1855#3,2:1208\n1855#3,2:1210\n1855#3,2:1212\n1855#3,2:1214\n1864#3,3:1216\n215#4,2:1219\n*S KotlinDebug\n*F\n+ 1 SportDetailChartFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailChartFragment\n*L\n66#1:1195\n66#1:1196\n418#1:1205\n418#1:1206\n284#1:1197\n305#1:1198,2\n284#1:1200\n343#1:1201,2\n406#1:1203,2\n406#1:1207\n692#1:1208,2\n770#1:1210,2\n836#1:1212,2\n920#1:1214,2\n1041#1:1216,3\n1056#1:1219,2\n*E\n"})
/* loaded from: classes12.dex */
public class SportDetailChartFragment extends BaseFragment {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO altitudeLineChart$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO altitudePanel$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO hrLineChart$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO hrPanel$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO hrPieChart$delegate;
    private boolean isLocationEmpty;
    private boolean leftAxisGridDashedLine;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llHeartRateRange$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mActivityDao$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mChartXStartIndex$delegate;
    private long mEndTime;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mHeartRateDao$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLocationDao$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mPressureDao$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportDataDao$delegate;
    private long mStartTime;
    public Workout mWorkout;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO paceLineChart$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pacePanel$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pressureLineChart$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pressurePanel$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO speedLineChart$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO speedPanel$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO spmLineChart$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO spmPanel$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAltitudeUnit$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgBmpValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPaceValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPressureValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgSpeedValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgSpeedValueTitle$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgSpmValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvFastSpeedValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvHeartRateRange$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMaxAltitudeValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMaxBmpValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMaxPressureValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMaxSpmValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMinAltitudeValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvMinPaceValue$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSportAerobic$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSportAnaerobic$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSportFatBurning$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSportStrenuous$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSportWarmUp$delegate;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final String TAG = "SportDetailChartFragment";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            View mView;
            mView = SportDetailChartFragment.this.getMView();
            return (NestedScrollView) mView.findViewById(R.id.root_view);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ox.oOoXoXO {
        public oIX0oI() {
        }

        @Override // ox.oOoXoXO, ox.x0xO0oo
        @OXOo.OOXIXo
        public String II0XooXoX(float f) {
            return TextConvertKt.OI0((int) f, SportDetailChartFragment.this.getUserProfile().getUnit());
        }
    }

    public SportDetailChartFragment() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.hrLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$hrLineChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LineChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (LineChart) mView.findViewById(R.id.hrLineChart);
            }
        });
        this.tvAvgBmpValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAvgBmpValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_avg_bpm_value);
            }
        });
        this.tvMaxBmpValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvMaxBmpValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_max_bpm_value);
            }
        });
        this.tvSportStrenuous$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvSportStrenuous$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final DINCondBold invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (DINCondBold) mView.findViewById(R.id.sportRecordStrenuous);
            }
        });
        this.tvSportAnaerobic$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvSportAnaerobic$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final DINCondBold invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (DINCondBold) mView.findViewById(R.id.sportRecordAnaerobic);
            }
        });
        this.tvSportAerobic$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvSportAerobic$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final DINCondBold invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (DINCondBold) mView.findViewById(R.id.sportRecordAerobic);
            }
        });
        this.tvSportFatBurning$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvSportFatBurning$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final DINCondBold invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (DINCondBold) mView.findViewById(R.id.sportRecordFatBurning);
            }
        });
        this.tvSportWarmUp$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvSportWarmUp$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final DINCondBold invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (DINCondBold) mView.findViewById(R.id.sportRecordWarmUp);
            }
        });
        this.hrPieChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PieChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$hrPieChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final PieChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (PieChart) mView.findViewById(R.id.hrPieChart);
            }
        });
        this.hrPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$hrPanel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.hr_panel);
            }
        });
        this.tvHeartRateRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvHeartRateRange$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.tv_heart_rate_range);
            }
        });
        this.llHeartRateRange$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$llHeartRateRange$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.ll_heart_rate_range);
            }
        });
        this.paceLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$paceLineChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LineChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (LineChart) mView.findViewById(R.id.paceLineChart);
            }
        });
        this.tvAvgPaceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAvgPaceValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_avg_pace_value);
            }
        });
        this.tvMinPaceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvMinPaceValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_min_pace_value);
            }
        });
        this.pacePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$pacePanel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.pace_panel);
            }
        });
        this.spmLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$spmLineChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LineChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (LineChart) mView.findViewById(R.id.spmLineChart);
            }
        });
        this.tvAvgSpmValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAvgSpmValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_avg_spm_value);
            }
        });
        this.tvMaxSpmValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvMaxSpmValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_max_spm_value);
            }
        });
        this.spmPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$spmPanel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.spm_panel);
            }
        });
        this.speedLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$speedLineChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LineChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (LineChart) mView.findViewById(R.id.speedLineChart);
            }
        });
        this.tvAvgSpeedValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAvgSpeedValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_avg_speed_value);
            }
        });
        this.tvFastSpeedValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvFastSpeedValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_fast_speed_value);
            }
        });
        this.speedPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$speedPanel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.speed_panel);
            }
        });
        this.tvAvgSpeedValueTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAvgSpeedValueTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_avg_speed_title);
            }
        });
        this.altitudeLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$altitudeLineChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LineChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (LineChart) mView.findViewById(R.id.altitudeLineChart);
            }
        });
        this.tvMinAltitudeValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvMinAltitudeValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_min_altitude_value);
            }
        });
        this.tvMaxAltitudeValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvMaxAltitudeValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_max_altitude_value);
            }
        });
        this.altitudePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$altitudePanel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.altitude_panel);
            }
        });
        this.tvAltitudeUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAltitudeUnit$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.altitude_unit_tv);
            }
        });
        this.pressureLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$pressureLineChart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LineChart invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (LineChart) mView.findViewById(R.id.pressureLineChart);
            }
        });
        this.tvAvgPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvAvgPressureValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_avg_pressure_value);
            }
        });
        this.tvMaxPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$tvMaxPressureValue$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return (TextView) mView.findViewById(R.id.tv_max_pressure_value);
            }
        });
        this.pressurePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$pressurePanel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final View invoke() {
                View mView;
                mView = SportDetailChartFragment.this.getMView();
                return mView.findViewById(R.id.pressure_panel);
            }
        });
        this.mSportDataDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SportDataDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$mSportDataDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final SportDataDao invoke() {
                return MyDb.INSTANCE.getMDatabase().sportDataDao();
            }
        });
        this.mLocationDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$mLocationDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final LocationDao invoke() {
                return MyDb.INSTANCE.getMDatabase().locationDao();
            }
        });
        this.mHeartRateDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HeartRateDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$mHeartRateDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final HeartRateDao invoke() {
                return MyDb.INSTANCE.getMDatabase().heartRateDao();
            }
        });
        this.mActivityDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ActivityDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$mActivityDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final ActivityDao invoke() {
                return MyDb.INSTANCE.getMDatabase().activityDao();
            }
        });
        this.mPressureDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PressureDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$mPressureDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final PressureDao invoke() {
                return MyDb.INSTANCE.getMDatabase().pressureDao();
            }
        });
        this.isLocationEmpty = true;
        this.mChartXStartIndex$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Float>() { // from class: com.sma.smartv3.ui.sport.SportDetailChartFragment$mChartXStartIndex$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Float invoke() {
                SportDetailChartFragment.this.getLeftAxisGridDashedLine();
                return Float.valueOf(0.0f);
            }
        });
    }

    private final void addColors(List<Integer> list, int i, float f) {
        if (f > 0.0f) {
            list.add(Integer.valueOf(getResources().getColor(i)));
        }
    }

    private final void addPieEntry(List<PieEntry> list, float f) {
        LogUtils.i("addPieEntry " + f);
        if (f <= 0.0f) {
            f = 1.0f;
        }
        list.add(new PieEntry(f));
    }

    private final int calculateAge(String str) {
        Triple<Integer, Integer, Integer> XO2 = TextConvertKt.XO(str);
        int intValue = XO2.component1().intValue();
        XO2.component2().intValue();
        XO2.component3().intValue();
        return X0.IIXOooo.OxxIIOOXO(Calendar.getInstance().get(1) - intValue, 0);
    }

    private final void configChart(LineChart lineChart, int i, int i2, int i3) {
        long j = 1000;
        long j2 = 60;
        long j3 = ((this.mEndTime - this.mStartTime) / j) / j2;
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        oix0oi.II0xO0(lineChart);
        lineChart.setTouchEnabled(false);
        lineChart.getDescription().Oxx0IOOO(false);
        lineChart.getLegend().Oxx0IOOO(false);
        lineChart.getAxisLeft().Xo0(false);
        lineChart.getAxisLeft().xXOx(i2);
        lineChart.getAxisLeft().I0X0x0oIo(i);
        lineChart.getAxisLeft().oxxXoxO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        lineChart.getAxisLeft().II0XooXoX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        lineChart.getAxisLeft().Ox0O(true);
        lineChart.getAxisRight().I0oOIX(false);
        lineChart.getAxisRight().Xo0(false);
        lineChart.getAxisRight().XoI0Ixx0(false);
        XAxis xAxis = lineChart.getXAxis();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(xAxis);
        Context context = lineChart.getContext();
        kotlin.jvm.internal.IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.I0X0x0oIo(0.0f);
        xAxis.OO(1.0f);
        xAxis.xXOx((float) j3);
        SimpleDateFormat O0Xx2 = com.sma.smartv3.util.xoIox.O0Xx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        if (0 <= j3) {
            while (true) {
                if (this.leftAxisGridDashedLine) {
                    arrayList.add(String.valueOf(j4));
                } else {
                    String millis2String = TimeUtils.millis2String(this.mStartTime + (j4 * j2 * j), O0Xx2);
                    kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
                    arrayList.add(millis2String);
                }
                if (j4 == j3) {
                    break;
                } else {
                    j4++;
                }
            }
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
    }

    public static /* synthetic */ void configChart$default(SportDetailChartFragment sportDetailChartFragment, LineChart lineChart, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 8) != 0) {
                i3 = 0;
            }
            sportDetailChartFragment.configChart(lineChart, i, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configChart");
    }

    private final int getAge(String str) {
        int calculateAge = calculateAge(str);
        if (calculateAge < 16) {
            return 16;
        }
        if (calculateAge > 60) {
            return 60;
        }
        return calculateAge;
    }

    private final float getAvg(float f, float f2, float f3) {
        float f4;
        if (f > 0.0f) {
            f4 = f;
        } else {
            f4 = 0.0f;
        }
        if (X0.OxxIIOOXO.II0XooXoX(1.0f, f).contains(Float.valueOf(f3))) {
            return f3;
        }
        if (f2 <= 0.0f || f >= f2) {
            return f4;
        }
        return f2;
    }

    private final ActivityDao getMActivityDao() {
        return (ActivityDao) this.mActivityDao$delegate.getValue();
    }

    private final HeartRateDao getMHeartRateDao() {
        return (HeartRateDao) this.mHeartRateDao$delegate.getValue();
    }

    private final PressureDao getMPressureDao() {
        return (PressureDao) this.mPressureDao$delegate.getValue();
    }

    private final SportDataDao getMSportDataDao() {
        return (SportDataDao) this.mSportDataDao$delegate.getValue();
    }

    private final List<SportData> getNewSportDataList(List<Location> list, List<Activity> list2) {
        boolean z;
        Object obj;
        int i = 0;
        if (!list.isEmpty() && list.size() >= 2) {
            z = false;
        } else {
            z = true;
        }
        this.isLocationEmpty = z;
        LogUtils.i("getSportDataList isLocationEmpty " + this.isLocationEmpty);
        ArrayList arrayList = new ArrayList();
        if (!list2.isEmpty()) {
            obj = CollectionsKt___CollectionsKt.O0OOX0IIx(list2);
        } else {
            obj = null;
        }
        for (Activity activity : list2) {
            if (i != 0) {
                int mStep = activity.getMStep();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(obj);
                Activity activity2 = (Activity) obj;
                int mStep2 = mStep - activity2.getMStep();
                int mTime = ((int) (activity.getMTime() - activity2.getMTime())) / 1000;
                int mDistance = (activity.getMDistance() - activity2.getMDistance()) / 10000;
                SportData sportData = new SportData(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
                sportData.setMStep(mStep2);
                sportData.setMDistance(mDistance);
                String millis2String = TimeUtils.millis2String(activity.getMTime(), com.sma.smartv3.util.xoIox.I0Io());
                kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
                sportData.setMLocalTime(millis2String);
                sportData.setMDuration(mTime);
                XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
                sportData.setMSpm(xIo0oOXIx.II0XooXoX(sportData.getMStep(), sportData.getMDuration()));
                sportData.setMPace(xIo0oOXIx.II0xO0(sportData.getMDuration(), sportData.getMDistance()));
                sportData.setMSpeed(xIo0oOXIx.I0Io(sportData.getMDistance(), sportData.getMDuration()));
                if (sportData.getMDuration() > 0 && sportData.getMDistance() > 0) {
                    arrayList.add(sportData);
                }
                OI0.oIX0oI.f1507oIX0oI.oxoX("getSportDataList sportData " + sportData);
            }
            i++;
            obj = activity;
        }
        OI0.oIX0oI.f1507oIX0oI.oxoX("getSportDataList sportDataList2 " + arrayList);
        return arrayList;
    }

    private final float getRandom(float f, float f2) {
        if (f2 != 0.0f && f != 0.0f && f2 < 10000.0f) {
            float f3 = (f2 + f) / 2;
            float f4 = (f2 - f) / 3;
            try {
                float f5 = 1;
                return Random.Default.nextInt((int) ((f3 - f4) - f5), (int) (f3 + f4 + f5));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0.0f;
    }

    private final List<SportData> getSportDataList(List<Location> list, List<Activity> list2) {
        boolean z;
        Object obj;
        ArrayList arrayList;
        ArrayList arrayList2;
        List<Activity> list3 = list2;
        int i = 0;
        if (!list.isEmpty() && list.size() >= 2) {
            z = false;
        } else {
            z = true;
        }
        this.isLocationEmpty = z;
        LogUtils.i("getSportDataList isLocationEmpty " + this.isLocationEmpty);
        ArrayList arrayList3 = new ArrayList();
        if (!list3.isEmpty()) {
            obj = CollectionsKt___CollectionsKt.O0OOX0IIx(list2);
        } else {
            obj = null;
        }
        OI0.oIX0oI.f1507oIX0oI.oxoX("getSportDataList Activity " + list3);
        long mStart = getMWorkout().getMStart();
        long j = (long) 60000;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(mStart, getMWorkout().getMEnd() + j, 60000L);
        if (mStart <= oxoX2) {
            while (true) {
                for (Activity activity : list3) {
                    long j2 = 1 + mStart;
                    long j3 = mStart + j;
                    long mTime = activity.getMTime();
                    if (j2 <= mTime && mTime <= j3) {
                        if (i != 0) {
                            int mStep = activity.getMStep();
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(obj);
                            Activity activity2 = (Activity) obj;
                            int mStep2 = mStep - activity2.getMStep();
                            ArrayList arrayList4 = arrayList3;
                            int mTime2 = ((int) (activity.getMTime() - activity2.getMTime())) / 1000;
                            int mDistance = (activity.getMDistance() - activity2.getMDistance()) / 10000;
                            SportData sportData = new SportData(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
                            sportData.setMStep(mStep2);
                            sportData.setMTime(mStart);
                            sportData.setMDistance(mDistance);
                            String millis2String = TimeUtils.millis2String(activity.getMTime(), com.sma.smartv3.util.xoIox.I0Io());
                            kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
                            sportData.setMLocalTime(millis2String);
                            sportData.setMDuration(mTime2);
                            XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
                            sportData.setMSpm(xIo0oOXIx.II0XooXoX(sportData.getMStep(), sportData.getMDuration()));
                            sportData.setMPace(xIo0oOXIx.II0xO0(sportData.getMDuration(), sportData.getMDistance()));
                            sportData.setMSpeed(xIo0oOXIx.I0Io(sportData.getMDistance(), sportData.getMDuration()));
                            arrayList2 = arrayList4;
                            arrayList2.add(sportData);
                            for (Location location : list) {
                                long mTime3 = location.getMTime();
                                if (j2 <= mTime3 && mTime3 <= j3) {
                                    sportData.setMAltitude(location.getMAltitude());
                                }
                            }
                            OI0.oIX0oI.f1507oIX0oI.oxoX("getSportDataList sportData " + sportData);
                        } else {
                            arrayList2 = arrayList3;
                        }
                        i++;
                        obj = activity;
                    } else {
                        arrayList2 = arrayList3;
                    }
                    arrayList3 = arrayList2;
                }
                arrayList = arrayList3;
                if (mStart == oxoX2) {
                    break;
                }
                mStart += 60000;
                list3 = list2;
                arrayList3 = arrayList;
            }
        } else {
            arrayList = arrayList3;
        }
        OI0.oIX0oI.f1507oIX0oI.oxoX("getSportDataList sportDataList " + arrayList);
        return arrayList;
    }

    private final boolean isSupportStep() {
        com.sma.smartv3.util.XX0xXo xX0xXo = com.sma.smartv3.util.XX0xXo.f24343oIX0oI;
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            return xX0xXo.X0o0xo(getMWorkout().getMMode());
        }
        return ProductManager.f20544oIX0oI.IOooo0o(getMWorkout().getMMode());
    }

    private final void oldDrawChart() {
        List<HeartRate> heartRates = getMHeartRateDao().getHeartRates(getMWorkout().getMStart(), getMWorkout().getMEnd());
        List<Location> location = getMLocationDao().getLocation(getMWorkout().getMStart(), getMWorkout().getMEnd());
        List<Activity> listASC = getMActivityDao().getListASC(getMWorkout().getMStart(), getMWorkout().getMEnd());
        List<SportData> sportDataASC = getMSportDataDao().getSportDataASC(getMWorkout().getMStart(), getMWorkout().getMEnd());
        List<Pressure> pressures = getMPressureDao().getPressures(getMWorkout().getMStart(), getMWorkout().getMEnd());
        LogUtils.i("sportDataList" + sportDataASC);
        if (sportDataASC.isEmpty()) {
            sportDataASC = getSportDataList(location, listASC);
            LogUtils.i("sportDataList" + sportDataASC.size());
        }
        if (getMWorkout().getMSource() == 1 && getMWorkout().getMAvgBpm() == 0) {
            showHr(new ArrayList());
        } else {
            showHr(heartRates);
        }
        if (isSupportStep()) {
            showSpm(sportDataASC);
        } else {
            getSpmPanel().setVisibility(8);
        }
        if (!location.isEmpty() && getMWorkout().getMMode() == 10) {
            sportDataASC = TextConvertKt.xoXoI(location, 0, 2, null);
        }
        LogUtils.i("sportDataList2" + sportDataASC.size());
        com.sma.smartv3.util.XX0xXo xX0xXo = com.sma.smartv3.util.XX0xXo.f24343oIX0oI;
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            if (xX0xXo.oIX0oI(getMWorkout().getMMode()) && ProjectManager.f19822oIX0oI.oo00()) {
                showPace(sportDataASC);
            } else {
                getPacePanel().setVisibility(8);
            }
        } else if (ProductManager.f20544oIX0oI.OIxI0O(getMWorkout().getMMode(), !this.isLocationEmpty) && ProjectManager.f19822oIX0oI.oo00()) {
            showPace(sportDataASC);
        } else {
            getPacePanel().setVisibility(8);
        }
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            if (ProductManager.f20544oIX0oI.OxO(getMWorkout().getMMode())) {
                showSpeed(sportDataASC);
            } else {
                getSpeedPanel().setVisibility(8);
            }
        } else if (ProductManager.f20544oIX0oI.OIxI0O(getMWorkout().getMMode(), !this.isLocationEmpty)) {
            showSpeed(sportDataASC);
        } else {
            getSpeedPanel().setVisibility(8);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isSupportAltitude ");
        sb.append(getMWorkout().getMMode());
        sb.append(TokenParser.SP);
        sb.append(!this.isLocationEmpty);
        sb.append(TokenParser.SP);
        sb.append(location.size());
        LogUtils.i(sb.toString());
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            if (ProductManager.f20544oIX0oI.X0O0I0(getMWorkout().getMMode())) {
                showAltitude(location);
            } else {
                getAltitudePanel().setVisibility(8);
            }
        } else if (ProductManager.f20544oIX0oI.OooO0XOx(getMWorkout().getMMode(), !this.isLocationEmpty)) {
            showAltitude(location);
        } else {
            getAltitudePanel().setVisibility(8);
        }
        LogUtils.i("isSupportPressure pressureList" + pressures.size());
        if (ProductManager.f20544oIX0oI.xx(getMWorkout().getMMode())) {
            showPressure(pressures);
        } else {
            getPressurePanel().setVisibility(8);
        }
    }

    private final Pair<List<Entry>, Integer> optimizationInterfaceData(List<Entry> list, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        if (1 <= i && i < i3) {
            int i4 = i3 - i;
            for (Entry entry : list) {
                float I0Io2 = entry.I0Io() - i4;
                if (I0Io2 > 0.0f) {
                    arrayList.add(new Entry(entry.xxIXOIIO(), I0Io2));
                } else {
                    arrayList.add(new Entry(entry.xxIXOIIO(), 0.0f));
                }
            }
            if (i2 < i4) {
                return new Pair<>(arrayList, 0);
            }
            return new Pair<>(arrayList, Integer.valueOf(i2 - i4));
        }
        return new Pair<>(arrayList, Integer.valueOf(i2));
    }

    public static /* synthetic */ void setSportText$default(SportDetailChartFragment sportDetailChartFragment, long j, long j2, long j3, long j4, long j5, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = 0;
            }
            if ((i & 4) != 0) {
                j3 = 0;
            }
            if ((i & 8) != 0) {
                j4 = 0;
            }
            if ((i & 16) != 0) {
                j5 = 0;
            }
            sportDetailChartFragment.setSportText(j, j2, j3, j4, j5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSportText");
    }

    private final void showAltitude(List<Location> list) {
        String string;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.mStartTime;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, this.mEndTime, 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new XI0IXoo(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        for (Location location : list) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    XI0IXoo xI0IXoo = (XI0IXoo) entry.getValue();
                    if (XIo0oOXIx.f23889oIX0oI.xxIXOIIO(location.getMTime()) <= longValue) {
                        xI0IXoo.II0XooXoX(xI0IXoo.XO() + location.getMAltitude());
                        xI0IXoo.Oxx0IOOO(xI0IXoo.X0o0xo() + 1);
                        break;
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        Iterator it2 = linkedHashMap.entrySet().iterator();
        int i = 0;
        float f = -1.0f;
        int i2 = 0;
        float f2 = -1.0f;
        while (it2.hasNext()) {
            XI0IXoo xI0IXoo2 = (XI0IXoo) ((Map.Entry) it2.next()).getValue();
            if (xI0IXoo2.X0o0xo() != 0 && xI0IXoo2.XO() != 0) {
                int XO2 = xI0IXoo2.XO() / xI0IXoo2.X0o0xo();
                arrayList.add(new Entry(mChartXStartIndex, XO2));
                if (i < XO2) {
                    f += 1.0f;
                    i = XO2;
                }
                if (i2 == 0 || i2 > XO2) {
                    f2 += 1.0f;
                    i2 = XO2;
                }
            }
            mChartXStartIndex += 1.0f;
        }
        OI0.oIX0oI.f1507oIX0oI.oxoX("showAltitude" + arrayList);
        try {
            if (getMWorkout().getMMaxAltitude() > i && f > -1.0f) {
                arrayList.get((int) f).XO(getMWorkout().getMMaxAltitude());
            }
            if (getMWorkout().getMMinAltitude() < i2 && f2 > -1.0f) {
                arrayList.get((int) f2).XO(getMWorkout().getMMinAltitude());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LineChart altitudeLineChart = getAltitudeLineChart();
        kotlin.jvm.internal.IIX0o.oO(altitudeLineChart, "<get-altitudeLineChart>(...)");
        configChart$default(this, altitudeLineChart, Math.min(i2, getMWorkout().getMMinAltitude()), Math.max(i, getMWorkout().getMMaxAltitude()) + 5, 0, 8, null);
        LineChart altitudeLineChart2 = getAltitudeLineChart();
        kotlin.jvm.internal.IIX0o.oO(altitudeLineChart2, "<get-altitudeLineChart>(...)");
        updateChartData(altitudeLineChart2, arrayList, R.color.altitude_color, R.drawable.shape_altitude);
        LogUtils.i("showAltitude2" + getMWorkout().getMMaxAltitude() + " //" + getMWorkout().getMMinAltitude() + TokenParser.SP);
        TextView tvAltitudeUnit = getTvAltitudeUnit();
        if (this.userProfile.getUnit() == 0) {
            string = getString(R.string.altitude_unit);
        } else {
            string = getString(R.string.yd);
        }
        tvAltitudeUnit.setText(string);
        getTvMaxAltitudeValue().setText(TextConvertKt.IO(getMWorkout().getMMaxAltitude(), this.userProfile.getUnit()));
        getTvMinAltitudeValue().setText(TextConvertKt.IO(getMWorkout().getMMinAltitude(), this.userProfile.getUnit()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c9, code lost:
    
        if (r3 <= 1.0d) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01fd, code lost:
    
        if (r4.getMBpm() >= 80) goto L164;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showHr(java.util.List<com.sma.smartv3.db.entity.HeartRate> r56) {
        /*
            Method dump skipped, instructions count: 996
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.SportDetailChartFragment.showHr(java.util.List):void");
    }

    private final void showPace(List<SportData> list) {
        boolean z;
        boolean z2;
        float f;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.mStartTime;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, this.mEndTime, 60000L);
        int i = 0;
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new XI0IXoo(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        float mMaxPace = getMWorkout().getMMaxPace();
        float mMinPace = getMWorkout().getMMinPace();
        ArrayList<Entry> arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        if (1.0f > mMaxPace || mMaxPace > 3000.0f) {
            mMaxPace = 0.0f;
        }
        if (1.0f > mMinPace || mMinPace > 3000.0f) {
            mMinPace = 0.0f;
        }
        int i2 = 1;
        if (mMaxPace == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (mMinPace == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        float f2 = 0.0f;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (i < list.size() - i2) {
                f = list.get(i).getMPace();
            } else {
                f = 0.0f;
            }
            OI0.oIX0oI.f1507oIX0oI.oxoX("showPace  " + f);
            float avg = getAvg(f, mMinPace, mMaxPace);
            if (avg == f2 || avg == mMinPace || avg == mMaxPace) {
                float random = getRandom(mMinPace, mMaxPace);
                if (random != 0.0f) {
                    f2 = random;
                    arrayList.add(new Entry(mChartXStartIndex, f2));
                    mChartXStartIndex += 1.0f;
                    i++;
                    i2 = 1;
                }
            }
            f2 = avg;
            arrayList.add(new Entry(mChartXStartIndex, f2));
            mChartXStartIndex += 1.0f;
            i++;
            i2 = 1;
        }
        if (z2) {
            mMinPace = 100.0f;
        }
        for (Entry entry2 : arrayList) {
            if (z && entry2.I0Io() > mMaxPace) {
                mMaxPace = entry2.I0Io();
            }
            if (z2 && entry2.I0Io() < mMinPace && entry2.I0Io() > 0.0f) {
                mMinPace = entry2.I0Io();
            }
        }
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oxoX("showPace  " + arrayList);
        LineChart paceLineChart = getPaceLineChart();
        kotlin.jvm.internal.IIX0o.oO(paceLineChart, "<get-paceLineChart>(...)");
        int i3 = (int) mMinPace;
        int i4 = (int) mMaxPace;
        configChart$default(this, paceLineChart, i3 - 10, i4 + 10, 0, 8, null);
        getPaceLineChart().getAxisLeft().o0xxxXXxX(new oIX0oI());
        getTvAvgPaceValue().setText(TextConvertKt.OI0(i4, this.userProfile.getUnit()));
        getTvMinPaceValue().setText(TextConvertKt.OI0(i3, this.userProfile.getUnit()));
        oix0oi.oxoX("showPace max== " + getMWorkout().getMMaxPace() + TokenParser.SP + getMWorkout().getMMinPace());
        LineChart paceLineChart2 = getPaceLineChart();
        kotlin.jvm.internal.IIX0o.oO(paceLineChart2, "<get-paceLineChart>(...)");
        updateChartData(paceLineChart2, arrayList, R.color.pace_color, R.drawable.shape_pace);
    }

    private final void showPieChart(PieChart pieChart, List<? extends PieEntry> list, List<Integer> list2) {
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().Oxx0IOOO(false);
        pieChart.Io(5.0f, 5.0f, 5.0f, 5.0f);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setRotationAngle(0.0f);
        pieChart.getLegend().Oxx0IOOO(false);
        pieChart.setRotationEnabled(true);
        pieChart.x0XOIxOo(FeatureCodes.POSE, Ioxxx.II0xO0.f916X0o0xo);
        PieDataSet pieDataSet = new PieDataSet(list, "");
        pieDataSet.ooOOo0oXI(false);
        pieDataSet.O0xOxO(false);
        pieDataSet.X0O0I0(0.0f);
        pieDataSet.o0IXXIx(list2);
        pieChart.setData(new o0xxxXXxX.x0xO0oo(pieDataSet));
        pieChart.IIX0o(null);
        pieChart.invalidate();
    }

    private final void showPressure(List<Pressure> list) {
        int i;
        float f;
        int XO2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.mStartTime;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, this.mEndTime, 60000L);
        int i2 = 0;
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new XI0IXoo(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        LogUtils.i("filterDataMap " + linkedHashMap.size());
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            Pressure pressure = (Pressure) obj;
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    XI0IXoo xI0IXoo = (XI0IXoo) entry.getValue();
                    if (XIo0oOXIx.f23889oIX0oI.xxIXOIIO(pressure.getMTime()) <= longValue) {
                        xI0IXoo.II0XooXoX(xI0IXoo.XO() + pressure.getMValue());
                        xI0IXoo.Oxx0IOOO(xI0IXoo.X0o0xo() + 1);
                        break;
                    }
                }
            }
            i3 = i4;
        }
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        if (com.sma.smartv3.util.XX0xXo.f24343oIX0oI.Oxx0xo(getMWorkout().getMPlatform())) {
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (!list.isEmpty()) {
                    arrayList.add(new Entry(mChartXStartIndex, list.get(0).getMValue()));
                    mChartXStartIndex += 1.0f;
                }
            }
            i = 0;
            f = -1.0f;
        } else {
            Iterator it2 = linkedHashMap.entrySet().iterator();
            int i5 = 0;
            i = 0;
            f = -1.0f;
            while (it2.hasNext()) {
                XI0IXoo xI0IXoo2 = (XI0IXoo) ((Map.Entry) it2.next()).getValue();
                if (xI0IXoo2.X0o0xo() != 0 && xI0IXoo2.XO() != 0) {
                    int size = list.size();
                    if (1 <= size && size < 3) {
                        XO2 = list.get(0).getMValue();
                    } else {
                        XO2 = xI0IXoo2.XO() / xI0IXoo2.X0o0xo();
                    }
                    arrayList.add(new Entry(mChartXStartIndex, XO2 + (XO2 / 5)));
                    if (i < XO2) {
                        f += 1.0f;
                        i = XO2;
                    }
                    i5 += XO2;
                }
                mChartXStartIndex += 1.0f;
            }
            i2 = i5;
        }
        if (arrayList.size() != 0) {
            i2 /= arrayList.size();
        }
        if (getMWorkout().getMMaxStress() > 0 && getMWorkout().getMMaxStress() > i && f > -1.0f) {
            arrayList.get((int) f).XO(getMWorkout().getMMaxStress());
        }
        LineChart pressureLineChart = getPressureLineChart();
        kotlin.jvm.internal.IIX0o.oO(pressureLineChart, "<get-pressureLineChart>(...)");
        configChart$default(this, pressureLineChart, 0, Math.max(i, getMWorkout().getMMaxStress()) + 5, 0, 8, null);
        LineChart pressureLineChart2 = getPressureLineChart();
        kotlin.jvm.internal.IIX0o.oO(pressureLineChart2, "<get-pressureLineChart>(...)");
        updateChartData(pressureLineChart2, arrayList, R.color.hr_color, R.drawable.shape_hr);
        TextView tvAvgPressureValue = getTvAvgPressureValue();
        if (getMWorkout().getMAvgStress() > 0) {
            i2 = getMWorkout().getMAvgStress();
        }
        tvAvgPressureValue.setText(String.valueOf(i2));
        TextView tvMaxPressureValue = getTvMaxPressureValue();
        if (getMWorkout().getMMaxStress() > 0) {
            i = getMWorkout().getMMaxStress();
        }
        tvMaxPressureValue.setText(String.valueOf(i));
    }

    private final void showSpeed(List<SportData> list) {
        boolean z;
        boolean z2;
        float f;
        int i = 1;
        LogUtils.i("showSpeed====" + list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.mStartTime;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, this.mEndTime, 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new XI0IXoo(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        float mMaxSpeed = getMWorkout().getMMaxSpeed() / 1000.0f;
        float mMinSpeed = getMWorkout().getMMinSpeed() / 1000.0f;
        if (1.0f > mMaxSpeed || mMaxSpeed > 99.0f) {
            mMaxSpeed = 0.0f;
        }
        if (0.1f > mMinSpeed || mMinSpeed > 99.0f) {
            mMinSpeed = 0.0f;
        }
        if (mMaxSpeed == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (mMinSpeed == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        ArrayList<Entry> arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        int i2 = 0;
        float f2 = 0.0f;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (i2 < list.size() - i) {
                f = list.get(i2).getMSpeed();
            } else {
                f = 0.0f;
            }
            OI0.oIX0oI.f1507oIX0oI.oxoX("showSpeed" + f2);
            float avg = getAvg(f, mMinSpeed, mMaxSpeed);
            if (avg == f2 || avg == mMinSpeed || avg == mMaxSpeed) {
                float random = getRandom(mMinSpeed, mMaxSpeed);
                if (random != 0.0f) {
                    f2 = random;
                    arrayList.add(new Entry(mChartXStartIndex, f2));
                    mChartXStartIndex += 1.0f;
                    i = 1;
                    i2++;
                }
            }
            f2 = avg;
            arrayList.add(new Entry(mChartXStartIndex, f2));
            mChartXStartIndex += 1.0f;
            i = 1;
            i2++;
        }
        if (z2) {
            mMinSpeed = 100.0f;
        }
        float f3 = mMaxSpeed;
        float f4 = mMinSpeed;
        for (Entry entry2 : arrayList) {
            if (z && entry2.I0Io() > f3 && entry2.I0Io() > 0.0f) {
                f3 = entry2.I0Io();
            }
            if (z2 && entry2.I0Io() < f4 && entry2.I0Io() > 0.0f) {
                f4 = entry2.I0Io();
            }
        }
        if (!list.isEmpty()) {
            list.size();
        }
        OI0.oIX0oI.f1507oIX0oI.oxoX("showSpeed  " + arrayList);
        LineChart speedLineChart = getSpeedLineChart();
        kotlin.jvm.internal.IIX0o.oO(speedLineChart, "<get-speedLineChart>(...)");
        configChart$default(this, speedLineChart, ((int) f4) + (-1), ((int) f3) + 5, 0, 8, null);
        getTvAvgSpeedValueTitle().setText(getString(R.string.min_speed));
        getTvAvgSpeedValue().setText(TextConvertKt.I0X0x0oIo(f4, this.userProfile.getUnit()));
        getTvFastSpeedValue().setText(TextConvertKt.I0X0x0oIo(f3, this.userProfile.getUnit()));
        LineChart speedLineChart2 = getSpeedLineChart();
        kotlin.jvm.internal.IIX0o.oO(speedLineChart2, "<get-speedLineChart>(...)");
        updateChartData(speedLineChart2, arrayList, R.color.speed_color, R.drawable.shape_speed);
        LogUtils.i(" minSpeed" + f4 + "  maxSpeed" + f3 + TokenParser.SP);
    }

    @SuppressLint({"SetTextI18n"})
    private final void showSpm(List<SportData> list) {
        boolean z;
        boolean z2;
        float f;
        int i = 0;
        LogUtils.i("showSpm" + list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.mStartTime;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, this.mEndTime, 60000L);
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new XI0IXoo(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        float mMaxSpm = getMWorkout().getMMaxSpm();
        float mMinSpm = getMWorkout().getMMinSpm();
        ArrayList<Entry> arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        float f2 = 0.0f;
        if (1.0f > mMaxSpm || mMaxSpm > 1000.0f) {
            mMaxSpm = 0.0f;
        }
        if (1.0f > mMinSpm || mMinSpm > 1000.0f) {
            mMinSpm = 0.0f;
        }
        if (mMaxSpm == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (mMinSpm == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        float f3 = 0.0f;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (i < list.size() - 1) {
                f = list.get(i).getMStep();
            } else {
                f = 0.0f;
            }
            float avg = getAvg(f, mMinSpm, mMaxSpm);
            if (avg == f3 || avg == mMinSpm || avg == mMaxSpm) {
                f3 = getRandom(mMinSpm, mMaxSpm);
                if (f3 != f2) {
                    OI0.oIX0oI.f1507oIX0oI.oxoX("showSpm" + f3);
                    arrayList.add(new Entry(mChartXStartIndex, f3));
                    mChartXStartIndex += 1.0f;
                    i++;
                    f2 = 0.0f;
                }
            }
            f3 = avg;
            OI0.oIX0oI.f1507oIX0oI.oxoX("showSpm" + f3);
            arrayList.add(new Entry(mChartXStartIndex, f3));
            mChartXStartIndex += 1.0f;
            i++;
            f2 = 0.0f;
        }
        if (z2) {
            mMinSpm = 100.0f;
        }
        for (Entry entry2 : arrayList) {
            entry2.I0Io();
            if (z && entry2.I0Io() > mMaxSpm) {
                mMaxSpm = entry2.I0Io();
            }
            if (z2 && entry2.I0Io() < mMinSpm) {
                if (entry2.I0Io() > 0.0f) {
                    mMinSpm = entry2.I0Io();
                }
            }
        }
        OI0.oIX0oI.f1507oIX0oI.oxoX("showSpm  " + arrayList);
        LineChart spmLineChart = getSpmLineChart();
        kotlin.jvm.internal.IIX0o.oO(spmLineChart, "<get-spmLineChart>(...)");
        int i2 = (int) mMaxSpm;
        configChart$default(this, spmLineChart, ((int) mMinSpm) - 5, i2 + 5, 0, 8, null);
        getTvAvgSpmValue().setText(String.valueOf(getMWorkout().getMSpm()));
        getTvMaxSpmValue().setText(String.valueOf(i2));
        LineChart spmLineChart2 = getSpmLineChart();
        kotlin.jvm.internal.IIX0o.oO(spmLineChart2, "<get-spmLineChart>(...)");
        updateChartData(spmLineChart2, arrayList, R.color.spm_color, R.drawable.shape_spm);
    }

    public final LineChart getAltitudeLineChart() {
        return (LineChart) this.altitudeLineChart$delegate.getValue();
    }

    public final View getAltitudePanel() {
        return (View) this.altitudePanel$delegate.getValue();
    }

    public final LineChart getHrLineChart() {
        return (LineChart) this.hrLineChart$delegate.getValue();
    }

    public final View getHrPanel() {
        return (View) this.hrPanel$delegate.getValue();
    }

    public final PieChart getHrPieChart() {
        return (PieChart) this.hrPieChart$delegate.getValue();
    }

    public final boolean getLeftAxisGridDashedLine() {
        return this.leftAxisGridDashedLine;
    }

    public final View getLlHeartRateRange() {
        return (View) this.llHeartRateRange$delegate.getValue();
    }

    public final float getMChartXStartIndex() {
        return ((Number) this.mChartXStartIndex$delegate.getValue()).floatValue();
    }

    public final long getMEndTime() {
        return this.mEndTime;
    }

    @OXOo.OOXIXo
    public final LocationDao getMLocationDao() {
        return (LocationDao) this.mLocationDao$delegate.getValue();
    }

    public final long getMStartTime() {
        return this.mStartTime;
    }

    @OXOo.OOXIXo
    public final Workout getMWorkout() {
        Workout workout = this.mWorkout;
        if (workout != null) {
            return workout;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
        return null;
    }

    public final LineChart getPaceLineChart() {
        return (LineChart) this.paceLineChart$delegate.getValue();
    }

    public final View getPacePanel() {
        return (View) this.pacePanel$delegate.getValue();
    }

    public final LineChart getPressureLineChart() {
        return (LineChart) this.pressureLineChart$delegate.getValue();
    }

    public final View getPressurePanel() {
        return (View) this.pressurePanel$delegate.getValue();
    }

    public final NestedScrollView getRootView() {
        return (NestedScrollView) this.rootView$delegate.getValue();
    }

    public final LineChart getSpeedLineChart() {
        return (LineChart) this.speedLineChart$delegate.getValue();
    }

    public final View getSpeedPanel() {
        return (View) this.speedPanel$delegate.getValue();
    }

    public final LineChart getSpmLineChart() {
        return (LineChart) this.spmLineChart$delegate.getValue();
    }

    public final View getSpmPanel() {
        return (View) this.spmPanel$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getTAG() {
        return this.TAG;
    }

    public final TextView getTvAltitudeUnit() {
        return (TextView) this.tvAltitudeUnit$delegate.getValue();
    }

    public final TextView getTvAvgBmpValue() {
        return (TextView) this.tvAvgBmpValue$delegate.getValue();
    }

    public final TextView getTvAvgPaceValue() {
        return (TextView) this.tvAvgPaceValue$delegate.getValue();
    }

    public final TextView getTvAvgPressureValue() {
        return (TextView) this.tvAvgPressureValue$delegate.getValue();
    }

    public final TextView getTvAvgSpeedValue() {
        return (TextView) this.tvAvgSpeedValue$delegate.getValue();
    }

    public final TextView getTvAvgSpeedValueTitle() {
        return (TextView) this.tvAvgSpeedValueTitle$delegate.getValue();
    }

    public final TextView getTvAvgSpmValue() {
        return (TextView) this.tvAvgSpmValue$delegate.getValue();
    }

    public final TextView getTvFastSpeedValue() {
        return (TextView) this.tvFastSpeedValue$delegate.getValue();
    }

    public final View getTvHeartRateRange() {
        return (View) this.tvHeartRateRange$delegate.getValue();
    }

    public final TextView getTvMaxAltitudeValue() {
        return (TextView) this.tvMaxAltitudeValue$delegate.getValue();
    }

    public final TextView getTvMaxBmpValue() {
        return (TextView) this.tvMaxBmpValue$delegate.getValue();
    }

    public final TextView getTvMaxPressureValue() {
        return (TextView) this.tvMaxPressureValue$delegate.getValue();
    }

    public final TextView getTvMaxSpmValue() {
        return (TextView) this.tvMaxSpmValue$delegate.getValue();
    }

    public final TextView getTvMinAltitudeValue() {
        return (TextView) this.tvMinAltitudeValue$delegate.getValue();
    }

    public final TextView getTvMinPaceValue() {
        return (TextView) this.tvMinPaceValue$delegate.getValue();
    }

    public final DINCondBold getTvSportAerobic() {
        return (DINCondBold) this.tvSportAerobic$delegate.getValue();
    }

    public final DINCondBold getTvSportAnaerobic() {
        return (DINCondBold) this.tvSportAnaerobic$delegate.getValue();
    }

    public final DINCondBold getTvSportFatBurning() {
        return (DINCondBold) this.tvSportFatBurning$delegate.getValue();
    }

    public final DINCondBold getTvSportStrenuous() {
        return (DINCondBold) this.tvSportStrenuous$delegate.getValue();
    }

    public final DINCondBold getTvSportWarmUp() {
        return (DINCondBold) this.tvSportWarmUp$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AppUser getUserProfile() {
        return this.userProfile;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        LogUtils.i(this.TAG + " initView");
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Workout");
        setMWorkout((Workout) mArg3);
        LogUtils.i("mWorkout" + getMWorkout());
        XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
        this.mStartTime = xIo0oOXIx.xxIXOIIO(getMWorkout().getMStart());
        this.mEndTime = xIo0oOXIx.xxIXOIIO(getMWorkout().getMEnd()) + ((long) 60000);
        if (getMWorkout().getMType() == 1) {
            newDrawChart();
        } else {
            oldDrawChart();
        }
    }

    public final boolean isLocationEmpty() {
        return this.isLocationEmpty;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_chart;
    }

    public void newDrawChart() {
    }

    public final void setLeftAxisGridDashedLine(boolean z) {
        this.leftAxisGridDashedLine = z;
    }

    public final void setLocationEmpty(boolean z) {
        this.isLocationEmpty = z;
    }

    public final void setMEndTime(long j) {
        this.mEndTime = j;
    }

    public final void setMStartTime(long j) {
        this.mStartTime = j;
    }

    public final void setMWorkout(@OXOo.OOXIXo Workout workout) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(workout, "<set-?>");
        this.mWorkout = workout;
    }

    public void setSportText(long j, long j2, long j3, long j4, long j5) {
        long j6 = 1000;
        long j7 = 60;
        long j8 = (j / j6) / j7;
        long j9 = (j2 / j6) / j7;
        long j10 = (j3 / j6) / j7;
        long j11 = (j4 / j6) / j7;
        long j12 = (j5 / j6) / j7;
        getTvSportStrenuous().setText(String.valueOf(j8));
        getTvSportAnaerobic().setText(String.valueOf(j9));
        getTvSportAerobic().setText(String.valueOf(j10));
        getTvSportFatBurning().setText(String.valueOf(j11));
        getTvSportWarmUp().setText(String.valueOf(j12));
        ArrayList arrayList = new ArrayList();
        if (j8 == 0 && j9 == 0 && j10 == 0 && j11 == 0 && j12 == 0) {
            arrayList.add(new PieEntry(1.0f));
            arrayList.add(new PieEntry(1.0f));
            arrayList.add(new PieEntry(1.0f));
            arrayList.add(new PieEntry(1.0f));
            arrayList.add(new PieEntry(1.0f));
        } else {
            addPieEntry(arrayList, (float) j8);
            addPieEntry(arrayList, (float) j9);
            addPieEntry(arrayList, (float) j10);
            addPieEntry(arrayList, (float) j11);
            addPieEntry(arrayList, (float) j12);
        }
        ArrayList arrayList2 = new ArrayList();
        addColors(arrayList2, R.color.hr_scope_color_5, (float) j8);
        addColors(arrayList2, R.color.hr_scope_color_4, (float) j9);
        addColors(arrayList2, R.color.hr_scope_color_3, (float) j10);
        addColors(arrayList2, R.color.hr_scope_color_2, (float) j11);
        addColors(arrayList2, R.color.hr_scope_color_1, (float) j12);
        PieChart hrPieChart = getHrPieChart();
        kotlin.jvm.internal.IIX0o.oO(hrPieChart, "<get-hrPieChart>(...)");
        showPieChart(hrPieChart, arrayList, arrayList2);
    }

    public final void share() {
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        NestedScrollView rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        ImageUtils.save(oxx0IOOO.I0Io(rootView), com.sma.smartv3.initializer.IXxxXO.oxXx0IX(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.PNG);
    }

    public final void updateChartData(@OXOo.OOXIXo LineChart lineChart, @OXOo.OOXIXo List<Entry> values, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lineChart, "lineChart");
        kotlin.jvm.internal.IIX0o.x0xO0oo(values, "values");
        LineDataSet lineDataSet = new LineDataSet(values, "");
        lineDataSet.OX(ContextCompat.getColor(getMActivity(), i));
        lineDataSet.X0ooXIooI(ContextCompat.getColor(getMActivity(), i));
        lineDataSet.oXxx000(2.0f);
        lineDataSet.xIXIOX(1.0f);
        lineDataSet.X0IOOI(false);
        lineDataSet.ooOOo0oXI(false);
        lineDataSet.oI(true);
        lineDataSet.xox(LineDataSet.Mode.CUBIC_BEZIER);
        Drawable drawable = ContextCompat.getDrawable(getMActivity(), i2);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
        lineDataSet.xIx0XO(drawable);
        o0xxxXXxX.ooOOo0oXI ooooo0oxi = new o0xxxXXxX.ooOOo0oXI(lineDataSet);
        ooooo0oxi.oo0xXOI0I(false);
        lineChart.setData(ooooo0oxi);
        if (this.leftAxisGridDashedLine) {
            YAxis axisLeft = lineChart.getAxisLeft();
            axisLeft.IXxxXO(10.0f, 10.0f, 0.0f);
            axisLeft.O0(false);
        }
        lineChart.II0XooXoX(1000);
        lineChart.invalidate();
    }
}
