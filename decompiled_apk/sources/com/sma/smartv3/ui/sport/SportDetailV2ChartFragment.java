package com.sma.smartv3.ui.sport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.utils.DistanceUtil;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.model.RecordActivityData;
import com.sma.smartv3.model.RecordDetailSpeedData;
import com.sma.smartv3.model.SportRecordDataKt;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.ui.sport.course.model.SportDetailViewModel;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.MyPieChart;
import com.sma.smartv3.view.PaceProgressBarV2;
import com.sma.smartv3.view.SportGoalProgressBar;
import com.sma.smartv3.view.segmentedbar.SegmentedBarView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailV2ChartFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailV2ChartFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailV2ChartFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1509:1\n1864#2,3:1510\n1864#2,3:1513\n99#3,7:1516\n106#3,3:1524\n79#3,7:1527\n109#3:1534\n99#3,7:1535\n106#3,3:1543\n79#3,7:1546\n109#3:1553\n1#4:1523\n1#4:1542\n*S KotlinDebug\n*F\n+ 1 SportDetailV2ChartFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailV2ChartFragment\n*L\n622#1:1510,3\n1438#1:1513,3\n297#1:1516,7\n297#1:1524,3\n297#1:1527,7\n297#1:1534\n1012#1:1535,7\n1012#1:1543,3\n1012#1:1546,7\n1012#1:1553\n297#1:1523\n1012#1:1542\n*E\n"})
/* loaded from: classes12.dex */
public final class SportDetailV2ChartFragment extends SportDetailChartFragment {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int ONE_KM = 1000;

    @OXOo.OOXIXo
    private final List<Integer> colorsList;
    private boolean isInChinaMainland;
    private boolean isWorkImage;

    @OXOo.oOoXoXO
    private SportDetailV2Activity sportDetailV2Activity;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingPerformance$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingPerformance$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.training_performance_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mAteLevel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SegmentedBarView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mAteLevel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SegmentedBarView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (SegmentedBarView) mView.findViewById(R.id.ateLevel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportMaxV02$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSportMaxV02$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sport_maxvO2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportMaxV02Level$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSportMaxV02Level$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sport_maxvO2_level);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportTrainingLoad$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSportTrainingLoad$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sport_trainingLoad);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportGoalProgressBar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SportGoalProgressBar>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSportGoalProgressBar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SportGoalProgressBar invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (SportGoalProgressBar) mView.findViewById(R.id.sport_goal_progressBar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportRecoveryTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSportRecoveryTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sport_recoveryTime);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportRecoveryTimeEstimate$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSportRecoveryTimeEstimate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.sport_recoveryTime_estimate);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mPieChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MyPieChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mPieChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final MyPieChart invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (MyPieChart) mView.findViewById(R.id.myPieChart);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSpeedPerKilometer$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSpeedPerKilometer$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.speed_per_kilometer_ll);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSpeedRecyclerTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSpeedRecyclerTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.speed_per_kilometer_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSpeedRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSpeedRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.speed_per_kilometer_rl);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<CustomLatLng> locationSmoothAlgorithm = new ArrayList<>();

    @OXOo.OOXIXo
    private RecordActivityData activityData = new RecordActivityData();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSpeedRecyclerUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSpeedRecyclerUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.speed_per_kilometer_ll_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mPacePanelUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mPacePanelUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.pace_panel_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSpeedPanelUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSpeedPanelUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.speed_panel_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCadenceTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mCadenceTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.cadence_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCadenceTitleUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mCadenceTitleUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.cadence_max_title_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCadenceAvgTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mCadenceAvgTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.cadence_avg_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCadenceMaxTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mCadenceMaxTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.cadence_max_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperience$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperience$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceSelect$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceSelect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_select);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceSelect1$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceSelect1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_1);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceSelect2$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceSelect2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceSelect3$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceSelect3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_3);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceSelect4$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceSelect4$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_4);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceSelect5$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceSelect5$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_5);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceResult$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceResult$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.training_experience_layout_result);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceResultImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceResultImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.training_experience_img_result);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTrainingExperienceResultTv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mTrainingExperienceResultTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.training_experience_tv_result);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDateSourcesTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mDateSourcesTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return mView.findViewById(R.id.device_sport_detail_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceSources$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mDeviceSources$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.device_sources);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mDeviceImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.device_img);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mDeviceName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.device_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceQRCode$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mDeviceQRCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.device_qr_code);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceQRCodeLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mDeviceQRCodeLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.device_qr_code_ll);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSegmentationDetailsLL$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSegmentationDetailsLL$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (LinearLayout) mView.findViewById(R.id.segmentation_detail_ll);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSegmentationRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mSegmentationRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.segmentation_detail_rl);
        }
    });
    private int threshold = 5;
    private int thresholdMax = 11;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCadenceUnderstandSituation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment$mCadenceUnderstandSituation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = SportDetailV2ChartFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.understand_situation_cadence);
        }
    });

    /* loaded from: classes12.dex */
    public static final class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23808I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23809II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f23810oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23811oxoX;

        public I0Io() {
            this(null, null, null, null, 15, null);
        }

        @OXOo.OOXIXo
        public final String I0Io() {
            return this.f23809II0xO0;
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f23808I0Io;
        }

        public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23809II0xO0 = str;
        }

        public final void X0o0xo(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23811oxoX = str;
        }

        public final void XO(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23808I0Io = str;
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            return this.f23811oxoX;
        }

        @OXOo.OOXIXo
        public final String oxoX() {
            return this.f23810oIX0oI;
        }

        public I0Io(@OXOo.OOXIXo String number, @OXOo.OOXIXo String duration, @OXOo.OOXIXo String distance, @OXOo.OOXIXo String avgPace) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(number, "number");
            kotlin.jvm.internal.IIX0o.x0xO0oo(duration, "duration");
            kotlin.jvm.internal.IIX0o.x0xO0oo(distance, "distance");
            kotlin.jvm.internal.IIX0o.x0xO0oo(avgPace, "avgPace");
            this.f23810oIX0oI = number;
            this.f23809II0xO0 = duration;
            this.f23808I0Io = distance;
            this.f23811oxoX = avgPace;
        }

        public /* synthetic */ I0Io(String str, String str2, String str3, String str4, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public float f23812I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23813II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f23814oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23815oxoX;

        public II0xO0(@OXOo.OOXIXo String number, @OXOo.OOXIXo String tmpPace, float f, @OXOo.OOXIXo String pace) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(number, "number");
            kotlin.jvm.internal.IIX0o.x0xO0oo(tmpPace, "tmpPace");
            kotlin.jvm.internal.IIX0o.x0xO0oo(pace, "pace");
            this.f23814oIX0oI = number;
            this.f23813II0xO0 = tmpPace;
            this.f23812I0Io = f;
            this.f23815oxoX = pace;
        }

        public final float I0Io() {
            return this.f23812I0Io;
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f23815oxoX;
        }

        public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23813II0xO0 = str;
        }

        public final void X0o0xo(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23815oxoX = str;
        }

        public final void XO(float f) {
            this.f23812I0Io = f;
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            return this.f23814oIX0oI;
        }

        @OXOo.OOXIXo
        public final String oxoX() {
            return this.f23813II0xO0;
        }
    }

    /* loaded from: classes12.dex */
    public static final class SportRecordDetailSpeedV2Adapter extends RecyclerView.Adapter<SportRecordDetailSpeedV2ViewHolder> {

        @OXOo.OOXIXo
        private final Context context;

        @OXOo.OOXIXo
        private final ArrayList<II0xO0> items;

        public SportRecordDetailSpeedV2Adapter(@OXOo.OOXIXo ArrayList<II0xO0> items, @OXOo.OOXIXo Context context) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(items, "items");
            kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
            this.items = items;
            this.context = context;
        }

        @OXOo.OOXIXo
        public final Context getContext() {
            return this.context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @SuppressLint({"SetTextI18n"})
        public void onBindViewHolder(@OXOo.OOXIXo SportRecordDetailSpeedV2ViewHolder holder, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
            II0xO0 iI0xO0 = this.items.get(i);
            kotlin.jvm.internal.IIX0o.oO(iI0xO0, "get(...)");
            II0xO0 iI0xO02 = iI0xO0;
            holder.getNumber().setText(iI0xO02.oIX0oI());
            DINCondBold tvPace = holder.getTvPace();
            int i2 = 8;
            if (iI0xO02.I0Io() > 0.0f) {
                holder.getPb().I0Io(iI0xO02.I0Io(), iI0xO02.oxoX(), i);
                holder.getNumber().setVisibility(0);
            } else {
                holder.getTvPace().setText(SportDetailV2ChartFragment.Companion.oIX0oI() + "  " + iI0xO02.oxoX());
                holder.getNumber().setVisibility(8);
                i2 = 0;
            }
            tvPace.setVisibility(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @OXOo.OOXIXo
        public SportRecordDetailSpeedV2ViewHolder onCreateViewHolder(@OXOo.OOXIXo ViewGroup parent, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_sport_record_detail_pace_content_v2, parent, false);
            kotlin.jvm.internal.IIX0o.oO(inflate, "inflate(...)");
            return new SportRecordDetailSpeedV2ViewHolder(inflate);
        }
    }

    /* loaded from: classes12.dex */
    public static final class SportRecordDetailSpeedV2ViewHolder extends RecyclerView.ViewHolder {

        @OXOo.OOXIXo
        private final DINCondBold number;

        @OXOo.OOXIXo
        private final PaceProgressBarV2 pb;

        @OXOo.OOXIXo
        private final DINCondBold tvPace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SportRecordDetailSpeedV2ViewHolder(@OXOo.OOXIXo View view) {
            super(view);
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            View findViewById = view.findViewById(R.id.number);
            kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
            this.number = (DINCondBold) findViewById;
            View findViewById2 = view.findViewById(R.id.pb);
            kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
            this.pb = (PaceProgressBarV2) findViewById2;
            View findViewById3 = view.findViewById(R.id.tvPace);
            kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
            this.tvPace = (DINCondBold) findViewById3;
        }

        @OXOo.OOXIXo
        public final DINCondBold getNumber() {
            return this.number;
        }

        @OXOo.OOXIXo
        public final PaceProgressBarV2 getPb() {
            return this.pb;
        }

        @OXOo.OOXIXo
        public final DINCondBold getTvPace() {
            return this.tvPace;
        }
    }

    /* loaded from: classes12.dex */
    public static final class SportRecordSegmentationAdapter extends RecyclerView.Adapter<SportRecordSegmentationViewHolder> {

        @OXOo.OOXIXo
        private final Context context;

        @OXOo.OOXIXo
        private final ArrayList<I0Io> items;

        public SportRecordSegmentationAdapter(@OXOo.OOXIXo ArrayList<I0Io> items, @OXOo.OOXIXo Context context) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(items, "items");
            kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
            this.items = items;
            this.context = context;
        }

        @OXOo.OOXIXo
        public final Context getContext() {
            return this.context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@OXOo.OOXIXo SportRecordSegmentationViewHolder holder, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
            I0Io i0Io = this.items.get(i);
            kotlin.jvm.internal.IIX0o.oO(i0Io, "get(...)");
            I0Io i0Io2 = i0Io;
            if (i0Io2.I0Io().length() <= 0 || i0Io2.II0xO0().length() <= 0) {
                return;
            }
            holder.getNumber().setText(i0Io2.oxoX());
            holder.getDuration().setText(i0Io2.I0Io());
            holder.getDistance().setText(i0Io2.II0xO0());
            holder.getAvgPace().setText(i0Io2.oIX0oI());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @OXOo.OOXIXo
        public SportRecordSegmentationViewHolder onCreateViewHolder(@OXOo.OOXIXo ViewGroup parent, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_sport_record_segmentation, parent, false);
            kotlin.jvm.internal.IIX0o.oO(inflate, "inflate(...)");
            return new SportRecordSegmentationViewHolder(inflate);
        }
    }

    /* loaded from: classes12.dex */
    public static final class SportRecordSegmentationViewHolder extends RecyclerView.ViewHolder {

        @OXOo.OOXIXo
        private final DINCondBold avgPace;

        @OXOo.OOXIXo
        private final DINCondBold distance;

        @OXOo.OOXIXo
        private final DINCondBold duration;

        @OXOo.OOXIXo
        private final DINCondBold number;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SportRecordSegmentationViewHolder(@OXOo.OOXIXo View view) {
            super(view);
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            View findViewById = view.findViewById(R.id.segmentation_item_number);
            kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
            this.number = (DINCondBold) findViewById;
            View findViewById2 = view.findViewById(R.id.segmentation_item_duration);
            kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
            this.duration = (DINCondBold) findViewById2;
            View findViewById3 = view.findViewById(R.id.segmentation_item_distance);
            kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
            this.distance = (DINCondBold) findViewById3;
            View findViewById4 = view.findViewById(R.id.segmentation_item_avgPace);
            kotlin.jvm.internal.IIX0o.oO(findViewById4, "findViewById(...)");
            this.avgPace = (DINCondBold) findViewById4;
        }

        @OXOo.OOXIXo
        public final DINCondBold getAvgPace() {
            return this.avgPace;
        }

        @OXOo.OOXIXo
        public final DINCondBold getDistance() {
            return this.distance;
        }

        @OXOo.OOXIXo
        public final DINCondBold getDuration() {
            return this.duration;
        }

        @OXOo.OOXIXo
        public final DINCondBold getNumber() {
            return this.number;
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSportDetailV2ChartFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailV2ChartFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailV2ChartFragment$Companion\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,1509:1\n19#2:1510\n15#2:1511\n*S KotlinDebug\n*F\n+ 1 SportDetailV2ChartFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailV2ChartFragment$Companion\n*L\n104#1:1510\n104#1:1511\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            if (((AppUser) appUser).getUnit() == 1) {
                return UtilsKt.oI0IIXIo(R.string.less_than_mile);
            }
            return UtilsKt.oI0IIXIo(R.string.less_than_kilometer);
        }

        public oIX0oI() {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX extends ox.oOoXoXO {
        public oxoX() {
        }

        @Override // ox.oOoXoXO, ox.x0xO0oo
        @OXOo.OOXIXo
        public String II0XooXoX(float f) {
            return TextConvertKt.OI0((int) f, SportDetailV2ChartFragment.this.getUserProfile().getUnit());
        }
    }

    public SportDetailV2ChartFragment() {
        setLeftAxisGridDashedLine(true);
        LogUtils.i("SportDetailV2ChartFragment");
        this.colorsList = CollectionsKt__CollectionsKt.X00IoxXI(Integer.valueOf(R.color.sport_detail_bg_endColor), Integer.valueOf(R.color.bp_level_color_high), Integer.valueOf(R.color.p_level_color_high), Integer.valueOf(R.color.sport_detail_bg_centerColor), Integer.valueOf(R.color.bp_level_color_standard), Integer.valueOf(R.color.bp_level_color_low));
    }

    private final void addMyPieChart(Long l, int i, ArrayList<MyPieChart.oIX0oI> arrayList) {
        long j;
        LogUtils.i("addMyPieChart " + l);
        if (l != null) {
            j = l.longValue();
        } else {
            j = 1;
        }
        arrayList.add(new MyPieChart.oIX0oI(j, getResources().getColor(i), 0.0f, 0.0f, 12, null));
    }

    private final void ateList(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        o0Xo.oIX0oI oix0oi = new o0Xo.oIX0oI(0.0f, 10.0f, "", getMActivity().getResources().getColor(this.colorsList.get(0).intValue()));
        if (i != 5) {
            str = "";
        } else {
            str = getString(R.string.very_Poor_key);
        }
        o0Xo.oIX0oI x0XOIxOo2 = oix0oi.x0XOIxOo(str);
        o0Xo.oIX0oI oix0oi2 = new o0Xo.oIX0oI(10.0f, 25.0f, "", getMActivity().getResources().getColor(this.colorsList.get(1).intValue()));
        if (i != 4) {
            str2 = "";
        } else {
            str2 = getString(R.string.poor_key);
        }
        o0Xo.oIX0oI x0XOIxOo3 = oix0oi2.x0XOIxOo(str2);
        o0Xo.oIX0oI oix0oi3 = new o0Xo.oIX0oI(25.0f, 50.0f, "", getMActivity().getResources().getColor(this.colorsList.get(2).intValue()));
        if (i != 3) {
            str3 = "";
        } else {
            str3 = getString(R.string.average_key);
        }
        o0Xo.oIX0oI x0XOIxOo4 = oix0oi3.x0XOIxOo(str3);
        o0Xo.oIX0oI oix0oi4 = new o0Xo.oIX0oI(50.0f, 75.0f, "", getMActivity().getResources().getColor(this.colorsList.get(3).intValue()));
        if (i != 2) {
            str4 = "";
        } else {
            str4 = getString(R.string.good_key);
        }
        o0Xo.oIX0oI x0XOIxOo5 = oix0oi4.x0XOIxOo(str4);
        o0Xo.oIX0oI oix0oi5 = new o0Xo.oIX0oI(75.0f, 95.0f, "", getMActivity().getResources().getColor(this.colorsList.get(4).intValue()));
        if (i != 1) {
            str5 = "";
        } else {
            str5 = getString(R.string.excellent_key);
        }
        o0Xo.oIX0oI x0XOIxOo6 = oix0oi5.x0XOIxOo(str5);
        o0Xo.oIX0oI oix0oi6 = new o0Xo.oIX0oI(95.0f, 100.0f, "", getMActivity().getResources().getColor(this.colorsList.get(5).intValue()));
        if (i == 0) {
            str6 = getString(R.string.top_key);
        }
        List<o0Xo.oIX0oI> XOxIOxOx2 = CollectionsKt__CollectionsKt.XOxIOxOx(x0XOIxOo2, x0XOIxOo3, x0XOIxOo4, x0XOIxOo5, x0XOIxOo6, oix0oi6.x0XOIxOo(str6));
        getMAteLevel().setSegmentSideRule(1);
        getMAteLevel().setShowDescriptionText(true);
        getMAteLevel().setSegments(XOxIOxOx2);
        getMAteLevel().setDescriptionTextColor(oIxOXo.oxoX.I0Io(getMAteLevel().getContext(), R.color.text_color));
        getMAteLevel().setDescriptionTopTextColor(oIxOXo.oxoX.I0Io(getMAteLevel().getContext(), this.colorsList.get(5 - i).intValue()));
    }

    private final void configChartV2(LineChart lineChart, int i, int i2, long j) {
        String valueOf;
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        oix0oi.II0xO0(lineChart);
        int i3 = 0;
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
        float f = (float) j;
        xAxis.OO(f / 2.0f);
        xAxis.xXOx(f);
        ArrayList arrayList = new ArrayList();
        int mDuration = getMWorkout().getMDuration() * 1000;
        int mDuration2 = (int) ((getMWorkout().getMDuration() * 1000) / j);
        if (mDuration2 > 0) {
            int I0Io2 = xx0o0O.x0XOIxOo.I0Io(0, mDuration, mDuration2);
            if (I0Io2 >= 0) {
                while (true) {
                    int Xx000oIo2 = com.sma.smartv3.util.xoIox.Xx000oIo(i3);
                    if (Xx000oIo2 == 0) {
                        valueOf = "0";
                    } else {
                        valueOf = String.valueOf(Xx000oIo2 + 1);
                    }
                    arrayList.add(valueOf);
                    if (i3 == I0Io2) {
                        break;
                    } else {
                        i3 += mDuration2;
                    }
                }
            }
            xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + mDuration2 + '.');
    }

    private final SegmentedBarView getMAteLevel() {
        return (SegmentedBarView) this.mAteLevel$delegate.getValue();
    }

    private final PFMedium getMCadenceAvgTitle() {
        return (PFMedium) this.mCadenceAvgTitle$delegate.getValue();
    }

    private final PFMedium getMCadenceMaxTitle() {
        return (PFMedium) this.mCadenceMaxTitle$delegate.getValue();
    }

    private final PFMedium getMCadenceTitle() {
        return (PFMedium) this.mCadenceTitle$delegate.getValue();
    }

    private final PFMedium getMCadenceTitleUnit() {
        return (PFMedium) this.mCadenceTitleUnit$delegate.getValue();
    }

    private final ImageView getMCadenceUnderstandSituation() {
        return (ImageView) this.mCadenceUnderstandSituation$delegate.getValue();
    }

    private final View getMDateSourcesTip() {
        return (View) this.mDateSourcesTip$delegate.getValue();
    }

    private final ImageView getMDeviceImg() {
        return (ImageView) this.mDeviceImg$delegate.getValue();
    }

    private final TextView getMDeviceName() {
        return (TextView) this.mDeviceName$delegate.getValue();
    }

    private final ImageView getMDeviceQRCode() {
        return (ImageView) this.mDeviceQRCode$delegate.getValue();
    }

    private final LinearLayout getMDeviceQRCodeLayout() {
        return (LinearLayout) this.mDeviceQRCodeLayout$delegate.getValue();
    }

    private final LinearLayout getMDeviceSources() {
        return (LinearLayout) this.mDeviceSources$delegate.getValue();
    }

    private final TextView getMPacePanelUnit() {
        return (TextView) this.mPacePanelUnit$delegate.getValue();
    }

    private final MyPieChart getMPieChart() {
        return (MyPieChart) this.mPieChart$delegate.getValue();
    }

    private final LinearLayout getMSegmentationDetailsLL() {
        return (LinearLayout) this.mSegmentationDetailsLL$delegate.getValue();
    }

    private final RecyclerView getMSegmentationRecyclerView() {
        return (RecyclerView) this.mSegmentationRecyclerView$delegate.getValue();
    }

    private final TextView getMSpeedPanelUnit() {
        return (TextView) this.mSpeedPanelUnit$delegate.getValue();
    }

    private final LinearLayout getMSpeedPerKilometer() {
        return (LinearLayout) this.mSpeedPerKilometer$delegate.getValue();
    }

    private final TextView getMSpeedRecyclerTitle() {
        return (TextView) this.mSpeedRecyclerTitle$delegate.getValue();
    }

    private final TextView getMSpeedRecyclerUnit() {
        return (TextView) this.mSpeedRecyclerUnit$delegate.getValue();
    }

    private final RecyclerView getMSpeedRecyclerView() {
        return (RecyclerView) this.mSpeedRecyclerView$delegate.getValue();
    }

    private final SportGoalProgressBar getMSportGoalProgressBar() {
        return (SportGoalProgressBar) this.mSportGoalProgressBar$delegate.getValue();
    }

    private final PFMedium getMSportMaxV02() {
        return (PFMedium) this.mSportMaxV02$delegate.getValue();
    }

    private final PFMedium getMSportMaxV02Level() {
        return (PFMedium) this.mSportMaxV02Level$delegate.getValue();
    }

    private final PFMedium getMSportRecoveryTime() {
        return (PFMedium) this.mSportRecoveryTime$delegate.getValue();
    }

    private final PFMedium getMSportRecoveryTimeEstimate() {
        return (PFMedium) this.mSportRecoveryTimeEstimate$delegate.getValue();
    }

    private final PFMedium getMSportTrainingLoad() {
        return (PFMedium) this.mSportTrainingLoad$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperience() {
        return (LinearLayout) this.mTrainingExperience$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceResult() {
        return (LinearLayout) this.mTrainingExperienceResult$delegate.getValue();
    }

    private final ImageView getMTrainingExperienceResultImg() {
        return (ImageView) this.mTrainingExperienceResultImg$delegate.getValue();
    }

    private final TextView getMTrainingExperienceResultTv() {
        return (TextView) this.mTrainingExperienceResultTv$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect() {
        return (LinearLayout) this.mTrainingExperienceSelect$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect1() {
        return (LinearLayout) this.mTrainingExperienceSelect1$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect2() {
        return (LinearLayout) this.mTrainingExperienceSelect2$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect3() {
        return (LinearLayout) this.mTrainingExperienceSelect3$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect4() {
        return (LinearLayout) this.mTrainingExperienceSelect4$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect5() {
        return (LinearLayout) this.mTrainingExperienceSelect5$delegate.getValue();
    }

    private final RelativeLayout getMTrainingPerformance() {
        return (RelativeLayout) this.mTrainingPerformance$delegate.getValue();
    }

    private final void getSportDetailActivity() {
        if (getActivity() instanceof SportDetailV2Activity) {
            FragmentActivity activity = getActivity();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(activity, "null cannot be cast to non-null type com.sma.smartv3.ui.sport.SportDetailV2Activity");
            this.sportDetailV2Activity = (SportDetailV2Activity) activity;
        }
    }

    private final String getTodayTime(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getMEndTime());
        calendar.add(13, i);
        String format = new SimpleDateFormat("M/dEEEEHH:mm", Locale.getDefault()).format(calendar.getTime());
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    private final Pair<Integer, String> getV02Level(int i) {
        if (95 <= i && i < 101) {
            String string = getString(R.string.top_key);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            return new Pair<>(0, string);
        }
        if (75 <= i && i < 95) {
            String string2 = getString(R.string.excellent_key);
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            return new Pair<>(1, string2);
        }
        if (50 <= i && i < 75) {
            String string3 = getString(R.string.good_key);
            kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
            return new Pair<>(2, string3);
        }
        if (25 <= i && i < 50) {
            String string4 = getString(R.string.average_key);
            kotlin.jvm.internal.IIX0o.oO(string4, "getString(...)");
            return new Pair<>(3, string4);
        }
        if (10 <= i && i < 25) {
            String string5 = getString(R.string.poor_key);
            kotlin.jvm.internal.IIX0o.oO(string5, "getString(...)");
            return new Pair<>(4, string5);
        }
        String string6 = getString(R.string.very_Poor_key);
        kotlin.jvm.internal.IIX0o.oO(string6, "getString(...)");
        return new Pair<>(5, string6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(SportDetailV2ChartFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMAteLevel().setValueSegment(Integer.valueOf(5 - this$0.getV02Level(this$0.getMWorkout().getMMaxVO2() / 10).getFirst().intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(SportDetailV2ChartFragment this$0, View view) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.getMWorkout().getMMode() == 52) {
            i = 5;
        } else {
            i = 2;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/gomer_help.html?type=" + i);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    private final void locationList() {
        ArrayList<CustomLatLng> arrayList = new ArrayList<>();
        boolean z = false;
        this.isInChinaMainland = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO, false);
        List<Location> location = getMLocationDao().getLocation(getMWorkout().getMStart(), getMWorkout().getMEnd());
        LogUtils.i("locationList " + location);
        if (!location.isEmpty() && location.size() >= 2) {
            Iterator<Location> it = location.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getMSource() == 1) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (this.isInChinaMainland && z) {
                CoordinateConverter from = new CoordinateConverter().from(CoordinateConverter.CoordType.GPS);
                for (Location location2 : location) {
                    LatLng convert = from.coord(new LatLng(location2.getMLatitude(), location2.getMLongitude())).convert();
                    arrayList.add(new CustomLatLng(convert.latitude, convert.longitude, location2.getMTime(), location2.getMAltitude(), 0, 16, null));
                }
            } else {
                for (Location location3 : location) {
                    arrayList.add(new CustomLatLng(location3.getMLatitude(), location3.getMLongitude(), location3.getMTime(), location3.getMAltitude(), 0, 16, null));
                }
            }
        }
        if (!arrayList.isEmpty() && arrayList.size() > 2) {
            this.locationSmoothAlgorithm.addAll(locationSmoothAlgorithm(arrayList));
        }
    }

    private final ArrayList<CustomLatLng> locationSmoothAlgorithm(ArrayList<CustomLatLng> arrayList) {
        ArrayList<CustomLatLng> arrayList2 = new ArrayList<>();
        CustomLatLng customLatLng = new CustomLatLng(arrayList.get(0).getLatitude(), arrayList.get(0).getLongitude(), arrayList.get(0).getTime(), arrayList.get(0).getAltitude(), 0, 16, null);
        CustomLatLng customLatLng2 = new CustomLatLng(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0L, 0, 0, 16, null);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            CustomLatLng customLatLng3 = arrayList.get(i);
            kotlin.jvm.internal.IIX0o.oO(customLatLng3, "get(...)");
            CustomLatLng customLatLng4 = customLatLng3;
            if (customLatLng4.getLatitude() == customLatLng2.getLatitude() && customLatLng4.getLongitude() == customLatLng2.getLongitude()) {
                customLatLng4.setLongitude(customLatLng.getLongitude());
                customLatLng4.setLatitude(customLatLng.getLatitude());
            } else {
                float IIX02 = (oOIx.oxoX.IIX0(DistanceUtil.getDistance(new LatLng(customLatLng.getLatitude(), customLatLng.getLongitude()), new LatLng(customLatLng4.getLatitude(), customLatLng4.getLongitude())) * 100) / 100.0f) / ((float) (Math.abs(customLatLng4.getTime() - customLatLng.getTime()) / 1000));
                if (IIX02 >= this.threshold) {
                    if (IIX02 >= this.thresholdMax) {
                        customLatLng4.setLongitude(customLatLng.getLongitude());
                        customLatLng4.setLatitude(customLatLng.getLatitude());
                    } else {
                        customLatLng2.setLatitude(customLatLng4.getLatitude());
                        customLatLng2.setLongitude(customLatLng4.getLongitude());
                        customLatLng2.setTime(customLatLng4.getTime());
                        customLatLng2.setAltitude(customLatLng4.getAltitude());
                        double d = 2;
                        customLatLng4.setLongitude((customLatLng.getLongitude() + customLatLng4.getLongitude()) / d);
                        customLatLng4.setLatitude((customLatLng.getLatitude() + customLatLng4.getLatitude()) / d);
                    }
                } else {
                    customLatLng2.setLatitude(XIXIX.OOXIXo.f3760XO);
                    customLatLng2.setLongitude(XIXIX.OOXIXo.f3760XO);
                    customLatLng2.setTime(0L);
                    customLatLng2.setAltitude(0);
                }
            }
            customLatLng.setLatitude(customLatLng4.getLatitude());
            customLatLng.setLongitude(customLatLng4.getLongitude());
            customLatLng.setTime(customLatLng4.getTime());
            customLatLng.setAltitude(customLatLng4.getAltitude());
            arrayList2.add(new CustomLatLng(customLatLng4.getLatitude(), customLatLng4.getLongitude(), customLatLng4.getTime(), customLatLng4.getAltitude(), 0, 16, null));
        }
        return arrayList2;
    }

    private final Pair<Long, LinkedHashMap<Long, XI0IXoo>> reviseData(List<Integer> list, int i) {
        long j;
        if (list != null && (!list.isEmpty()) && i != 0) {
            j = (getMEndTime() - getMStartTime()) / list.size();
        } else {
            j = 60000;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long mStartTime = getMStartTime();
        long mEndTime = getMEndTime();
        if (j > 0) {
            long oxoX2 = xx0o0O.x0XOIxOo.oxoX(mStartTime, mEndTime, j);
            int i2 = 0;
            if (mStartTime <= oxoX2) {
                while (true) {
                    linkedHashMap.put(Long.valueOf(mStartTime), new XI0IXoo(0, 0));
                    if (mStartTime == oxoX2) {
                        break;
                    }
                    mStartTime += j;
                }
            }
            if (list != null) {
                for (Object obj : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    int intValue = ((Number) obj).intValue();
                    Iterator it = linkedHashMap.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            XI0IXoo xI0IXoo = (XI0IXoo) ((Map.Entry) it.next()).getValue();
                            if (xI0IXoo.X0o0xo() == 0) {
                                xI0IXoo.II0XooXoX(xI0IXoo.XO() + intValue);
                                xI0IXoo.Oxx0IOOO(xI0IXoo.X0o0xo() + 1);
                                break;
                            }
                        }
                    }
                    i2 = i3;
                }
            }
            return new Pair<>(Long.valueOf(j), linkedHashMap);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + j + '.');
    }

    private final void setDeviceSource() {
        Drawable drawable;
        int i = 0;
        LogUtils.d("setDeviceSource ---> " + getMWorkout().getMMaxPace() + "  " + getMWorkout().getMMinPace() + TokenParser.SP + getMWorkout().getMPrototype() + "  " + getMWorkout().getMFirmwareFlag() + "  " + getMWorkout().getMBleName() + TokenParser.SP);
        LinearLayout mDeviceSources = getMDeviceSources();
        if (getMWorkout().getMBleName().length() == 0 || kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMWorkout().getMBleName(), "0")) {
            i = 8;
        } else {
            File I0oOIX2 = com.sma.smartv3.initializer.IXxxXO.I0oOIX(X00IoxXI.oIX0oI.f3233oIX0oI, getMWorkout().getMBleName(), getMWorkout().getMFirmwareFlag());
            int x0XOIxOo2 = ProductManager.f20544oIX0oI.x0XOIxOo(new BleDeviceInfo(0, null, getMWorkout().getMBleName(), null, null, null, getMWorkout().getMPrototype(), getMWorkout().getMFirmwareFlag(), 0, 0L, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -197, -1, -1, oI00o.XO.f31358oIX0oI, null));
            ImageView mDeviceImg = getMDeviceImg();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                drawable = activity.getDrawable(x0XOIxOo2);
            } else {
                drawable = null;
            }
            mDeviceImg.setImageDrawable(drawable);
            if (FileUtils.isFileExists(I0oOIX2)) {
                getMDeviceImg().setImageBitmap(ImageUtils.getBitmap(I0oOIX2));
            } else {
                this.isWorkImage = true;
                DeviceInfoChecker.f19983oIX0oI.xoIox(getMWorkout().getMBleName(), getMWorkout().getMFirmwareFlag());
            }
            getMDeviceName().setText(getMWorkout().getMBleName());
        }
        mDeviceSources.setVisibility(i);
        showSourcesTip();
    }

    private final void setTrainingExperience(int i) {
        getMView().findViewById(R.id.training_experience_hint_tv).setVisibility(8);
        getMTrainingExperienceSelect().setVisibility(8);
        getMTrainingExperienceResult().setVisibility(0);
        getMTrainingExperienceResultImg().setImageResource(getTrainingExperienceImage(getMActivity(), i));
        getMTrainingExperienceResultTv().setText(getString(getTrainingExperienceName(getMActivity(), i)));
        getMTrainingExperience().setBackgroundResource(R.drawable.ripple_training_experience_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTrainingPerformance$lambda$18(SportDetailV2ChartFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/gomer_help.html?type=1");
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    private final void showAltitudeV2(List<Integer> list) {
        String string;
        String IO2;
        String IO3;
        Pair<Long, LinkedHashMap<Long, XI0IXoo>> reviseData = reviseData(list, getMWorkout().getMAltitudePathCount());
        reviseData.component1().longValue();
        LinkedHashMap<Long, XI0IXoo> component2 = reviseData.component2();
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        Iterator<Map.Entry<Long, XI0IXoo>> it = component2.entrySet().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            XI0IXoo value = it.next().getValue();
            if (value.X0o0xo() != 0) {
                int XO2 = value.XO() / value.X0o0xo();
                arrayList.add(new Entry(mChartXStartIndex, XO2));
                if (i2 < XO2) {
                    i2 = XO2;
                }
                if (i == 0 || i > XO2) {
                    i = XO2;
                }
            }
            mChartXStartIndex += 1.0f;
        }
        LineChart altitudeLineChart = getAltitudeLineChart();
        kotlin.jvm.internal.IIX0o.oO(altitudeLineChart, "<get-altitudeLineChart>(...)");
        configChartV2(altitudeLineChart, i - 5, i2 + 5, component2.size());
        LineChart altitudeLineChart2 = getAltitudeLineChart();
        kotlin.jvm.internal.IIX0o.oO(altitudeLineChart2, "<get-altitudeLineChart>(...)");
        updateChartData(altitudeLineChart2, arrayList, R.color.altitude_color, R.drawable.shape_altitude);
        TextView tvAltitudeUnit = getTvAltitudeUnit();
        if (getUserProfile().getUnit() == 0) {
            string = getString(R.string.altitude_unit);
        } else {
            string = getString(R.string.yd);
        }
        tvAltitudeUnit.setText(string);
        TextView tvMaxAltitudeValue = getTvMaxAltitudeValue();
        if (getMWorkout().getMMaxAltitude() <= 10000 && getMWorkout().getMMaxAltitude() >= -10000) {
            IO2 = TextConvertKt.IO(getMWorkout().getMMaxAltitude(), getUserProfile().getUnit());
        } else {
            IO2 = TextConvertKt.IO(i2, getUserProfile().getUnit());
        }
        tvMaxAltitudeValue.setText(IO2);
        TextView tvMinAltitudeValue = getTvMinAltitudeValue();
        if (getMWorkout().getMMaxAltitude() <= 10000 && getMWorkout().getMMaxAltitude() >= -10000) {
            IO3 = TextConvertKt.IO(getMWorkout().getMMinAltitude(), getUserProfile().getUnit());
        } else {
            IO3 = TextConvertKt.IO(i, getUserProfile().getUnit());
        }
        tvMinAltitudeValue.setText(IO3);
    }

    private final void showHrV2(List<Integer> list) {
        Pair<Long, LinkedHashMap<Long, XI0IXoo>> reviseData = reviseData(list, getMWorkout().getMHrPathSampleInterval());
        reviseData.component1().longValue();
        LinkedHashMap<Long, XI0IXoo> component2 = reviseData.component2();
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        Iterator<Map.Entry<Long, XI0IXoo>> it = component2.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().X0o0xo() != 0) {
                arrayList.add(new Entry(mChartXStartIndex, r3.XO() / r3.X0o0xo()));
            }
            mChartXStartIndex += 1.0f;
        }
        LineChart hrLineChart = getHrLineChart();
        kotlin.jvm.internal.IIX0o.oO(hrLineChart, "<get-hrLineChart>(...)");
        configChartV2(hrLineChart, 40, getMWorkout().getMMaxBpm() + 10, component2.size());
        LineChart hrLineChart2 = getHrLineChart();
        kotlin.jvm.internal.IIX0o.oO(hrLineChart2, "<get-hrLineChart>(...)");
        updateChartData(hrLineChart2, arrayList, R.color.hr_color, R.drawable.shape_hr);
        getTvAvgBmpValue().setText(String.valueOf(getMWorkout().getMMinBpm()));
        getTvMaxBmpValue().setText(String.valueOf(getMWorkout().getMMaxBpm()));
        if (ProjectManager.f19822oIX0oI.X0xII0I()) {
            if (getMWorkout().getMMode() == 7) {
                SportDetailChartFragment.setSportText$default(this, 0L, 0L, 0L, 0L, 0L, 31, null);
                return;
            } else {
                if (getTvHeartRateRange() != null) {
                    getTvHeartRateRange().setVisibility(8);
                    getLlHeartRateRange().setVisibility(8);
                    return;
                }
                return;
            }
        }
        SportDetailChartFragment.setSportText$default(this, 0L, 0L, 0L, 0L, 0L, 31, null);
    }

    private final void showPaceV2(List<Integer> list) {
        String OI02;
        String OI03;
        int XO2;
        Pair<Long, LinkedHashMap<Long, XI0IXoo>> reviseData = reviseData(list, getMWorkout().getMPacePathCount());
        reviseData.component1().longValue();
        LinkedHashMap<Long, XI0IXoo> component2 = reviseData.component2();
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        int i = 0;
        int i2 = 0;
        for (Map.Entry<Long, XI0IXoo> entry : component2.entrySet()) {
            entry.getKey().longValue();
            XI0IXoo value = entry.getValue();
            if (value.X0o0xo() != 0) {
                if (getUserProfile().getUnit() == 1) {
                    XO2 = (int) (value.XO() / 0.6213712f);
                } else {
                    XO2 = value.XO();
                }
                int X0o0xo2 = XO2 / value.X0o0xo();
                if (i2 < X0o0xo2) {
                    i2 = X0o0xo2;
                }
                if (i == 0 || i > X0o0xo2) {
                    i = X0o0xo2;
                }
                arrayList.add(new Entry(mChartXStartIndex, X0o0xo2));
            }
            mChartXStartIndex += 1.0f;
        }
        LineChart paceLineChart = getPaceLineChart();
        kotlin.jvm.internal.IIX0o.oO(paceLineChart, "<get-paceLineChart>(...)");
        configChartV2(paceLineChart, i, i2 + 10, component2.size());
        LineChart paceLineChart2 = getPaceLineChart();
        kotlin.jvm.internal.IIX0o.oO(paceLineChart2, "<get-paceLineChart>(...)");
        updateChartData(paceLineChart2, arrayList, R.color.pace_color, R.drawable.shape_pace);
        getPaceLineChart().getAxisLeft().o0xxxXXxX(new oxoX());
        TextView tvAvgPaceValue = getTvAvgPaceValue();
        if (getMWorkout().getMMaxPace() > 0) {
            OI02 = TextConvertKt.OI0(getMWorkout().getMMaxPace(), getUserProfile().getUnit());
        } else {
            OI02 = TextConvertKt.OI0(i2, getUserProfile().getUnit());
        }
        tvAvgPaceValue.setText(OI02);
        TextView tvMinPaceValue = getTvMinPaceValue();
        if (getMWorkout().getMMinPace() > 0) {
            OI03 = TextConvertKt.OI0(getMWorkout().getMMinPace(), getUserProfile().getUnit());
        } else {
            OI03 = TextConvertKt.OI0(i, getUserProfile().getUnit());
        }
        tvMinPaceValue.setText(OI03);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showQCCode$lambda$0(Oox.oOoXoXO post) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(post, "$post");
        post.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showQCCode$lambda$1(Oox.oOoXoXO post) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(post, "$post");
        post.invoke(Boolean.TRUE);
    }

    private final void showSegmentation() {
        int i;
        RecyclerView mSegmentationRecyclerView = getMSegmentationRecyclerView();
        mSegmentationRecyclerView.setLayoutManager(new LinearLayoutManager(mSegmentationRecyclerView.getContext()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new I0Io(null, null, null, null, 15, null));
        arrayList.add(new I0Io("1", "0:10", "0.5", "9"));
        arrayList.add(new I0Io("1", "0:10", "0.5", "9"));
        LinearLayout mSegmentationDetailsLL = getMSegmentationDetailsLL();
        if (arrayList.size() > 1) {
            i = 0;
        } else {
            i = 8;
        }
        mSegmentationDetailsLL.setVisibility(i);
        Context context = mSegmentationRecyclerView.getContext();
        kotlin.jvm.internal.IIX0o.oO(context, "getContext(...)");
        mSegmentationRecyclerView.setAdapter(new SportRecordSegmentationAdapter(arrayList, context));
    }

    private final void showSourcesTip() {
        int i = 0;
        LogUtils.d("mWorkout.mAGpsType ---> " + getMWorkout().getMAGpsType() + TokenParser.SP);
        View mDateSourcesTip = getMDateSourcesTip();
        if (getMWorkout().getMSource() != 1 && getMWorkout().getMAGpsType() != 0) {
            i = 8;
        }
        mDateSourcesTip.setVisibility(i);
    }

    private final void showSpeedData() {
        RecordDetailSpeedData sportRecordWorkoutDetailSpeed;
        boolean z;
        String string;
        String string2;
        ArrayList<CustomLatLng> arrayList;
        Integer num;
        int i;
        String XOxIOxOx2;
        SportDetailViewModel mSportViewModel;
        int i2 = 1;
        if (getMWorkout().getMSource() == 0) {
            sportRecordWorkoutDetailSpeed = SportRecordDataKt.sportRecordActivityDetailSpeed(this.activityData.getMTimeList(), getMWorkout().getMMode(), getUserProfile().getUnit());
        } else {
            locationList();
            sportRecordWorkoutDetailSpeed = SportRecordDataKt.sportRecordWorkoutDetailSpeed(this.activityData.getMTimeList(), getMWorkout().getMMode(), getUserProfile().getUnit(), this.locationSmoothAlgorithm);
        }
        ArrayList<Integer> mPaceList = sportRecordWorkoutDetailSpeed.getMPaceList();
        int size = mPaceList.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Integer num2 = mPaceList.get(i5);
            kotlin.jvm.internal.IIX0o.oO(num2, "get(...)");
            int intValue = num2.intValue();
            if (intValue > 30000) {
                mPaceList.set(i5, Integer.valueOf(this.activityData.getMPace()));
                intValue = this.activityData.getMPace();
            }
            if (i5 == 0) {
                i3 = intValue;
                i4 = i3;
            }
            if (i3 > intValue) {
                i3 = intValue;
            }
            if (i4 < intValue) {
                i4 = intValue;
            }
        }
        if (getMWorkout().getMSource() == 1 && this.activityData.getMPace() > 0 && i3 == 0 && mPaceList.size() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (mPaceList.size() == 0) {
            if (this.activityData.getMDistanceTotal() > 0.0f) {
                i4 = this.activityData.getMPace() * 2;
                int mDistanceTotal = (int) this.activityData.getMDistanceTotal();
                if (mDistanceTotal >= 0) {
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        if (i6 < this.activityData.getMPace()) {
                            i6 = this.activityData.getMPace();
                        }
                        mPaceList.add(Integer.valueOf(this.activityData.getMPace()));
                        if (i7 == mDistanceTotal) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
            } else {
                mPaceList.add(Integer.valueOf(this.activityData.getMPace()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i8 = 1000;
        if (ProjectManager.f19822oIX0oI.OxXXx0X()) {
            SportDetailV2Activity sportDetailV2Activity = this.sportDetailV2Activity;
            if (sportDetailV2Activity != null && (mSportViewModel = sportDetailV2Activity.getMSportViewModel()) != null) {
                arrayList = mSportViewModel.getCustomLatLng();
            } else {
                arrayList = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("locationList ");
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            sb.append(num);
            char c = TokenParser.SP;
            sb.append(TokenParser.SP);
            LogUtils.i(sb.toString());
            if (arrayList != null) {
                CustomLatLng customLatLng = null;
                int i9 = 0;
                for (Object obj : arrayList) {
                    int i10 = i9 + 1;
                    if (i9 < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    CustomLatLng customLatLng2 = (CustomLatLng) obj;
                    if (customLatLng != null) {
                        int i11 = i4;
                        int time = (int) ((customLatLng2.getTime() - customLatLng.getTime()) / i8);
                        Object[] objArr = new Object[i2];
                        objArr[0] = "locationList " + i9 + c + time;
                        LogUtils.i(objArr);
                        String valueOf = String.valueOf(i9);
                        String OI02 = TextConvertKt.OI0(time, getUserProfile().getUnit());
                        i = i11;
                        float f = ((float) time) / ((float) i);
                        if (z) {
                            XOxIOxOx2 = TextConvertKt.OI0(time, getUserProfile().getUnit());
                        } else {
                            XOxIOxOx2 = TextConvertKt.XOxIOxOx(time);
                        }
                        arrayList2.add(new II0xO0(valueOf, OI02, f, XOxIOxOx2));
                    } else {
                        i = i4;
                    }
                    i4 = i;
                    customLatLng = customLatLng2;
                    i9 = i10;
                    i2 = 1;
                    i8 = 1000;
                    c = TokenParser.SP;
                }
            }
        }
        float ooOOo0oXI2 = TextConvertKt.ooOOo0oXI(getMWorkout().getMDistance(), getUserProfile().getUnit(), false, 4, null);
        if (TextConvertKt.ooOOo0oXI(1000, getUserProfile().getUnit(), false, 4, null) - ooOOo0oXI2 > 0.0f || ooOOo0oXI2 % 1000.0f != 0.0f) {
            arrayList2.add(new II0xO0("", TextConvertKt.OI0(getMWorkout().getMPace(), getUserProfile().getUnit()), 0.0f, ""));
        }
        LogUtils.i("tmpPaceList " + arrayList2.size() + "  " + getMWorkout().getMDistance());
        TextView mSpeedRecyclerTitle = getMSpeedRecyclerTitle();
        if (getUserProfile().getUnit() == 1) {
            string = getString(R.string.speed_per_mile);
        } else {
            string = getString(R.string.speed_per_kilometer);
        }
        mSpeedRecyclerTitle.setText(string);
        TextView mSpeedPanelUnit = getMSpeedPanelUnit();
        if (getUserProfile().getUnit() == 1) {
            string2 = getString(R.string.min_unit);
        } else {
            string2 = getString(R.string.speed_unit);
        }
        mSpeedPanelUnit.setText(string2);
        getMSpeedRecyclerUnit().setText(getString(TextConvertKt.oI0IIXIo(getUserProfile().getUnit())));
        getMPacePanelUnit().setText(getString(TextConvertKt.oI0IIXIo(getUserProfile().getUnit())));
        RecyclerView mSpeedRecyclerView = getMSpeedRecyclerView();
        mSpeedRecyclerView.setLayoutManager(new LinearLayoutManager(mSpeedRecyclerView.getContext()));
        Context context = mSpeedRecyclerView.getContext();
        kotlin.jvm.internal.IIX0o.oO(context, "getContext(...)");
        mSpeedRecyclerView.setAdapter(new SportRecordDetailSpeedV2Adapter(arrayList2, context));
    }

    private final void showSpeedV2(List<Integer> list) {
        int i;
        int XO2;
        Pair<Long, LinkedHashMap<Long, XI0IXoo>> reviseData = reviseData(list, getMWorkout().getMSpeedPathCount());
        reviseData.component1().longValue();
        LinkedHashMap<Long, XI0IXoo> component2 = reviseData.component2();
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        Iterator<Map.Entry<Long, XI0IXoo>> it = component2.entrySet().iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            XI0IXoo value = it.next().getValue();
            if (value.X0o0xo() != 0) {
                if (getUserProfile().getUnit() == 1) {
                    XO2 = (int) (value.XO() / 0.6213712f);
                } else {
                    XO2 = value.XO();
                }
                int X0o0xo2 = (XO2 / 1000) / value.X0o0xo();
                arrayList.add(new Entry(mChartXStartIndex, X0o0xo2));
                if (i3 < X0o0xo2) {
                    i3 = X0o0xo2;
                }
                if (i2 == 0 || i2 > X0o0xo2) {
                    i2 = X0o0xo2;
                }
                i4 += X0o0xo2;
            }
            mChartXStartIndex += 1.0f;
        }
        LineChart speedLineChart = getSpeedLineChart();
        kotlin.jvm.internal.IIX0o.oO(speedLineChart, "<get-speedLineChart>(...)");
        if (i2 == 0) {
            i = 0;
        } else {
            i = i2 - 1;
        }
        configChartV2(speedLineChart, i, i3 + 5, component2.size());
        LineChart speedLineChart2 = getSpeedLineChart();
        kotlin.jvm.internal.IIX0o.oO(speedLineChart2, "<get-speedLineChart>(...)");
        updateChartData(speedLineChart2, arrayList, R.color.speed_color, R.drawable.shape_speed);
        getTvAvgSpeedValue().setText(String.valueOf(TextConvertKt.xo0x(i2, getUserProfile().getUnit())));
        getTvFastSpeedValue().setText(String.valueOf(TextConvertKt.xo0x(getMWorkout().getMMaxSpeed() / 1000, getUserProfile().getUnit())));
        LogUtils.i(getTAG() + " mMaxSpeed" + getMWorkout().getMMaxSpeed() + " minSpeed" + i2 + "  maxSpeed" + i3 + " avgSpeed" + i4);
    }

    private final void showSpmV2(List<Integer> list) {
        int i;
        Pair<Long, LinkedHashMap<Long, XI0IXoo>> reviseData = reviseData(list, getMWorkout().getMCadencePathCount());
        reviseData.component1().longValue();
        LinkedHashMap<Long, XI0IXoo> component2 = reviseData.component2();
        ArrayList arrayList = new ArrayList();
        float mChartXStartIndex = getMChartXStartIndex();
        Iterator<Map.Entry<Long, XI0IXoo>> it = component2.entrySet().iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            XI0IXoo value = it.next().getValue();
            if (value.X0o0xo() != 0) {
                int XO2 = value.XO() / value.X0o0xo();
                arrayList.add(new Entry(mChartXStartIndex, XO2));
                if (i3 < XO2) {
                    i3 = XO2;
                }
                if (i2 == 0 || i2 > XO2) {
                    i2 = XO2;
                }
            }
            mChartXStartIndex += 1.0f;
        }
        LineChart spmLineChart = getSpmLineChart();
        kotlin.jvm.internal.IIX0o.oO(spmLineChart, "<get-spmLineChart>(...)");
        if (i2 > 10) {
            i = i2 - 10;
        } else {
            i = 0;
        }
        configChartV2(spmLineChart, i, i3 + 10, component2.size());
        LineChart spmLineChart2 = getSpmLineChart();
        kotlin.jvm.internal.IIX0o.oO(spmLineChart2, "<get-spmLineChart>(...)");
        updateChartData(spmLineChart2, arrayList, R.color.spm_color, R.drawable.shape_spm);
        if (getMWorkout().getMMode() == 52) {
            getTvAvgSpmValue().setText(String.valueOf(getMWorkout().getMCadence()));
            getTvMaxSpmValue().setText(String.valueOf(getMWorkout().getMMaxCadence()));
        } else {
            getTvAvgSpmValue().setText(String.valueOf(getMWorkout().getMSpm()));
            getTvMaxSpmValue().setText(String.valueOf(getMWorkout().getMMaxCadence()));
        }
    }

    private final void trainingExperienceSelect() {
        if (getMWorkout().getMFeel() > 0) {
            setTrainingExperience(getMWorkout().getMFeel());
            return;
        }
        getMTrainingExperienceSelect().setVisibility(0);
        getMTrainingExperienceResult().setVisibility(8);
        getMTrainingExperienceSelect1().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.X00IoxXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailV2ChartFragment.trainingExperienceSelect$lambda$5(SportDetailV2ChartFragment.this, view);
            }
        });
        getMTrainingExperienceSelect2().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.IO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailV2ChartFragment.trainingExperienceSelect$lambda$6(SportDetailV2ChartFragment.this, view);
            }
        });
        getMTrainingExperienceSelect3().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.xII
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailV2ChartFragment.trainingExperienceSelect$lambda$7(SportDetailV2ChartFragment.this, view);
            }
        });
        getMTrainingExperienceSelect4().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.x0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailV2ChartFragment.trainingExperienceSelect$lambda$8(SportDetailV2ChartFragment.this, view);
            }
        });
        getMTrainingExperienceSelect5().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.XOxIOxOx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailV2ChartFragment.trainingExperienceSelect$lambda$9(SportDetailV2ChartFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$5(SportDetailV2ChartFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$6(SportDetailV2ChartFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$7(SportDetailV2ChartFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$8(SportDetailV2ChartFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$9(SportDetailV2ChartFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(5);
    }

    private final void trainingSelectListener(int i) {
        setTrainingExperience(i);
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24607XI0oooXX, Integer.valueOf(i));
    }

    @OXOo.OOXIXo
    public final Bitmap getBitmap() {
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        NestedScrollView rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        Bitmap I0Io2 = oxx0IOOO.I0Io(rootView);
        getMDeviceQRCodeLayout().setVisibility(8);
        getMTrainingExperience().setVisibility(0);
        showSourcesTip();
        return I0Io2;
    }

    @OXOo.OOXIXo
    public final List<Integer> getColorsList() {
        return this.colorsList;
    }

    public final int getTrainingExperienceImage(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("icon_training_experience_" + i, "drawable", mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.icon_training_experience_1;
        }
    }

    public final int getTrainingExperienceName(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("training_experience_" + i, TypedValues.Custom.S_STRING, mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.string.training_experience_1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0150  */
    @Override // com.sma.smartv3.ui.sport.SportDetailChartFragment, com.bestmafen.androidbase.base.oIX0oI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.SportDetailV2ChartFragment.initView():void");
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailChartFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_chart_v2;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailChartFragment
    public void newDrawChart() {
        super.newDrawChart();
        if (getMWorkout().getMSource() == 1 && getMWorkout().getMAvgBpm() == 0) {
            showHrV2(new ArrayList());
        } else {
            showHrV2(getMWorkout().getMHrPathPoints());
        }
        getPressurePanel().setVisibility(8);
        com.sma.smartv3.util.XX0xXo xX0xXo = com.sma.smartv3.util.XX0xXo.f24343oIX0oI;
        if (xX0xXo.Oo(getMWorkout().getMMode())) {
            showSpmV2(getMWorkout().getMCadencePathPoints());
        } else {
            getSpmPanel().setVisibility(8);
        }
        if (xX0xXo.x0XOIxOo(getMWorkout().getMMode())) {
            showPaceV2(getMWorkout().getMPacePathPoints());
        } else {
            getPacePanel().setVisibility(8);
        }
        if (xX0xXo.oO(getMWorkout().getMMode())) {
            showSpeedV2(getMWorkout().getMSpeedPathPoints());
        } else {
            getSpeedPanel().setVisibility(8);
        }
        LogUtils.i("GoMore" + xX0xXo.oOoXoXO(getMWorkout().getMMode()));
        if (xX0xXo.oOoXoXO(getMWorkout().getMMode())) {
            showAltitudeV2(getMWorkout().getMAltitudePathPoints());
        } else {
            getAltitudePanel().setVisibility(8);
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24577IoOoX)
    public final void onPairImageChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        File I0oOIX2 = com.sma.smartv3.initializer.IXxxXO.I0oOIX(X00IoxXI.oIX0oI.f3233oIX0oI, getMWorkout().getMBleName(), getMWorkout().getMFirmwareFlag());
        LogUtils.d("onPairImageChange " + FileUtils.isFileExists(I0oOIX2) + "  " + this.isWorkImage + TokenParser.SP);
        if (FileUtils.isFileExists(I0oOIX2) && this.isWorkImage) {
            getMDeviceImg().setImageBitmap(ImageUtils.getBitmap(I0oOIX2));
            this.isWorkImage = false;
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailChartFragment
    public void setSportText(long j, long j2, long j3, long j4, long j5) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        ArrayList<MyPieChart.oIX0oI> arrayList = new ArrayList<>();
        if (getMWorkout().getMType() == 1) {
            if (getMWorkout().getMBpmZoneCount() != null) {
                int[] mBpmZoneCount = getMWorkout().getMBpmZoneCount();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mBpmZoneCount);
                if (mBpmZoneCount.length >= 5) {
                    getHrPieChart().setVisibility(8);
                    DINCondBold tvSportStrenuous = getTvSportStrenuous();
                    int[] mBpmZoneCount2 = getMWorkout().getMBpmZoneCount();
                    Long l5 = null;
                    if (mBpmZoneCount2 != null) {
                        str = com.sma.smartv3.util.xoIox.Io(mBpmZoneCount2[4]);
                    } else {
                        str = null;
                    }
                    tvSportStrenuous.setText(str);
                    DINCondBold tvSportAnaerobic = getTvSportAnaerobic();
                    int[] mBpmZoneCount3 = getMWorkout().getMBpmZoneCount();
                    if (mBpmZoneCount3 != null) {
                        str2 = com.sma.smartv3.util.xoIox.Io(mBpmZoneCount3[3]);
                    } else {
                        str2 = null;
                    }
                    tvSportAnaerobic.setText(str2);
                    DINCondBold tvSportAerobic = getTvSportAerobic();
                    int[] mBpmZoneCount4 = getMWorkout().getMBpmZoneCount();
                    if (mBpmZoneCount4 != null) {
                        str3 = com.sma.smartv3.util.xoIox.Io(mBpmZoneCount4[2]);
                    } else {
                        str3 = null;
                    }
                    tvSportAerobic.setText(str3);
                    DINCondBold tvSportFatBurning = getTvSportFatBurning();
                    int[] mBpmZoneCount5 = getMWorkout().getMBpmZoneCount();
                    if (mBpmZoneCount5 != null) {
                        str4 = com.sma.smartv3.util.xoIox.Io(mBpmZoneCount5[1]);
                    } else {
                        str4 = null;
                    }
                    tvSportFatBurning.setText(str4);
                    DINCondBold tvSportWarmUp = getTvSportWarmUp();
                    int[] mBpmZoneCount6 = getMWorkout().getMBpmZoneCount();
                    if (mBpmZoneCount6 != null) {
                        str5 = com.sma.smartv3.util.xoIox.Io(mBpmZoneCount6[0]);
                    } else {
                        str5 = null;
                    }
                    tvSportWarmUp.setText(str5);
                    if (getMWorkout().getMBpmZoneCount() != null) {
                        l = Long.valueOf(r3[4]);
                    } else {
                        l = null;
                    }
                    addMyPieChart(l, R.color.hr_scope_color_5, arrayList);
                    if (getMWorkout().getMBpmZoneCount() != null) {
                        l2 = Long.valueOf(r3[3]);
                    } else {
                        l2 = null;
                    }
                    addMyPieChart(l2, R.color.hr_scope_color_4, arrayList);
                    if (getMWorkout().getMBpmZoneCount() != null) {
                        l3 = Long.valueOf(r3[2]);
                    } else {
                        l3 = null;
                    }
                    addMyPieChart(l3, R.color.hr_scope_color_3, arrayList);
                    if (getMWorkout().getMBpmZoneCount() != null) {
                        l4 = Long.valueOf(r3[1]);
                    } else {
                        l4 = null;
                    }
                    addMyPieChart(l4, R.color.hr_scope_color_2, arrayList);
                    if (getMWorkout().getMBpmZoneCount() != null) {
                        l5 = Long.valueOf(r3[0]);
                    }
                    addMyPieChart(l5, R.color.hr_scope_color_1, arrayList);
                }
            }
        } else {
            getHrPieChart().setVisibility(8);
            long j6 = 1000;
            getTvSportStrenuous().setText(com.sma.smartv3.util.xoIox.Io((int) (j / j6)));
            getTvSportAnaerobic().setText(com.sma.smartv3.util.xoIox.Io((int) (j2 / j6)));
            getTvSportAerobic().setText(com.sma.smartv3.util.xoIox.Io((int) (j3 / j6)));
            getTvSportFatBurning().setText(com.sma.smartv3.util.xoIox.Io((int) (j4 / j6)));
            getTvSportWarmUp().setText(com.sma.smartv3.util.xoIox.Io((int) (j5 / j6)));
            addMyPieChart(Long.valueOf(j5), R.color.hr_scope_color_5, arrayList);
            addMyPieChart(Long.valueOf(j4), R.color.hr_scope_color_4, arrayList);
            addMyPieChart(Long.valueOf(j3), R.color.hr_scope_color_3, arrayList);
            addMyPieChart(Long.valueOf(j2), R.color.hr_scope_color_2, arrayList);
            addMyPieChart(Long.valueOf(j), R.color.hr_scope_color_1, arrayList);
        }
        getMPieChart().oIX0oI(arrayList);
        LogUtils.i("addMyPieChart " + arrayList.size() + " //" + getMWorkout().getMType() + TokenParser.SP);
        StringBuilder sb = new StringBuilder();
        sb.append("mBpmZoneCount ");
        sb.append(getMWorkout().getMBpmZoneCount());
        sb.append(TokenParser.SP);
        LogUtils.i(sb.toString());
    }

    public final void setTrainingPerformance() {
        String valueOf;
        trainingPerformanceVisibility(8);
        com.sma.smartv3.util.XX0xXo xX0xXo = com.sma.smartv3.util.XX0xXo.f24343oIX0oI;
        if (xX0xXo.XO(getMWorkout().getMMode())) {
            getMSportMaxV02().setVisibility(0);
        } else if (xX0xXo.Oxx0IOOO(getMWorkout().getMMode())) {
            getMSportRecoveryTime().setVisibility(0);
            getMSportRecoveryTimeEstimate().setVisibility(0);
        } else {
            trainingPerformanceVisibility(0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.vo2max_key));
        sb.append(": ");
        if (getMWorkout().getMMaxVO2() == 0) {
            valueOf = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        } else {
            valueOf = String.valueOf(getMWorkout().getMMaxVO2() / 10);
        }
        sb.append(valueOf);
        sb.append(getString(R.string.vo2_unit));
        String sb2 = sb.toString();
        PFMedium mSportMaxV02 = getMSportMaxV02();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ViewCompat.MEASURED_STATE_MASK), getString(R.string.vo2max_key).length() + 1, sb2.length(), 33);
        mSportMaxV02.setText(spannableStringBuilder);
        Pair<Integer, String> v02Level = getV02Level(getMWorkout().getMMaxVO2() / 10);
        String str = getString(R.string.vo2max_level) + ": " + v02Level.getSecond();
        PFMedium mSportMaxV02Level = getMSportMaxV02Level();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getMActivity().getResources().getColor(this.colorsList.get(5 - v02Level.getFirst().intValue()).intValue())), getString(R.string.vo2max_level).length() + 1, str.length(), 33);
        mSportMaxV02Level.setText(spannableStringBuilder2);
        getMSportTrainingLoad().setText(getString(R.string.training_performance_training_load, Integer.valueOf(getMWorkout().getMTrainingLoad())));
        getMSportGoalProgressBar().I0Io(getMWorkout().getMAerobic(), 6.0f);
        getMSportGoalProgressBar().oxoX(getMWorkout().getMAnaerobic(), 6.0f);
        ateList(v02Level.getFirst().intValue());
        if ((XIo0oOXIx.f23889oIX0oI.xxIXOIIO(getMWorkout().getMEnd()) + (getMWorkout().getMRecoveryTime() * 1000)) - System.currentTimeMillis() > 0) {
            Pair<Integer, Integer> oo2 = com.sma.smartv3.util.xoIox.oo(getMWorkout().getMRecoveryTime() * 1000);
            String str2 = getString(R.string.recovery_time) + ": " + oo2.getFirst().intValue() + 'H' + oo2.getSecond().intValue() + 'M';
            PFMedium mSportRecoveryTime = getMSportRecoveryTime();
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(str2);
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ViewCompat.MEASURED_STATE_MASK), getString(R.string.recovery_time).length() + 1, str2.length(), 33);
            mSportRecoveryTime.setText(spannableStringBuilder3);
            getMSportRecoveryTimeEstimate().setText(getString(R.string.training_performance_recovery_time_detail, getTodayTime(getMWorkout().getMRecoveryTime())));
        } else {
            getMSportRecoveryTime().setVisibility(8);
            getMSportRecoveryTimeEstimate().setText(getString(R.string.fully_recovered_tip));
        }
        getMView().findViewById(R.id.tv_training_performance_explanation).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.XX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailV2ChartFragment.setTrainingPerformance$lambda$18(SportDetailV2ChartFragment.this, view);
            }
        });
    }

    public final void showQCCode(@OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> post) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(post, "post");
        if (getMWorkout().getMFeel() == 0) {
            getMTrainingExperience().setVisibility(8);
        }
        if (getMWorkout().getMSource() == 1) {
            getMDateSourcesTip().setVisibility(8);
        }
        if (ProjectManager.f19822oIX0oI.ooOOo0oXI().length() > 0) {
            getMDeviceQRCodeLayout().setVisibility(0);
            getMDeviceQRCodeLayout().post(new Runnable() { // from class: com.sma.smartv3.ui.sport.OI0
                @Override // java.lang.Runnable
                public final void run() {
                    SportDetailV2ChartFragment.showQCCode$lambda$0(Oox.oOoXoXO.this);
                }
            });
        } else if (getMWorkout().getMFeel() == 0) {
            getMTrainingExperience().post(new Runnable() { // from class: com.sma.smartv3.ui.sport.o0
                @Override // java.lang.Runnable
                public final void run() {
                    SportDetailV2ChartFragment.showQCCode$lambda$1(Oox.oOoXoXO.this);
                }
            });
        } else {
            post.invoke(Boolean.TRUE);
        }
    }

    public final void trainingPerformanceVisibility(int i) {
        getMAteLevel().setVisibility(i);
        getMSportMaxV02().setVisibility(i);
        getMSportMaxV02Level().setVisibility(i);
        getMSportTrainingLoad().setVisibility(i);
        getMSportGoalProgressBar().setVisibility(i);
        getMSportRecoveryTime().setVisibility(i);
        getMSportRecoveryTimeEstimate().setVisibility(i);
    }
}
