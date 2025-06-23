package com.sma.smartv3.ui.status;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.utils.DistanceUtil;
import com.baidu.mobads.sdk.internal.cn;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.model.HRMinuteData;
import com.sma.smartv3.model.RecordActivityData;
import com.sma.smartv3.model.RecordDetailHeartRateData;
import com.sma.smartv3.model.SportRecordData;
import com.sma.smartv3.model.SportRecordDataKt;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.sma.smartv3.view.text.PFRegular;
import com.szabh.smable3.component.BleCache;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSportRecordsDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportRecordsDetailActivity.kt\ncom/sma/smartv3/ui/status/SportRecordsDetailActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1093:1\n19#2:1094\n15#2:1095\n254#3:1096\n254#3:1097\n254#3:1098\n254#3:1099\n80#4,9:1100\n89#4,3:1110\n75#4,3:1113\n80#4,9:1116\n89#4,3:1126\n75#4,3:1129\n1#5:1109\n1#5:1125\n*S KotlinDebug\n*F\n+ 1 SportRecordsDetailActivity.kt\ncom/sma/smartv3/ui/status/SportRecordsDetailActivity\n*L\n171#1:1094\n171#1:1095\n368#1:1096\n372#1:1097\n376#1:1098\n385#1:1099\n556#1:1100,9\n556#1:1110,3\n556#1:1113,3\n563#1:1116,9\n563#1:1126,3\n563#1:1129,3\n556#1:1109\n563#1:1125\n*E\n"})
/* loaded from: classes12.dex */
public final class SportRecordsDetailActivity extends BaseActivity {

    @OXOo.OOXIXo
    private RecordActivityData activityData;
    private boolean isInChinaMainland;
    private LineChart lineChart;

    @OXOo.OOXIXo
    private ArrayList<CustomLatLng> locationSmoothAlgorithm;

    @OXOo.oOoXoXO
    private BaiDuMapSportRecordFragment mBaiDuMapFragment;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mDeletePopup;

    @OXOo.oOoXoXO
    private GoogleMapSportRecordFragment mGoogleMapFragment;

    @OXOo.OOXIXo
    private final HeartRateDao mHeartRateDao;

    @OXOo.OOXIXo
    private final LocationDao mLocationDao;
    private LineDataSet setValue;
    private SportRecordData sportRecordData;
    private int threshold;
    private int thresholdMax;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final X0IIOO rootView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.rootView);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mapViewFrameLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FrameLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$mapViewFrameLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FrameLayout invoke() {
            return (FrameLayout) SportRecordsDetailActivity.this.findViewById(R.id.mapViewFrameLayout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mapPbRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$mapPbRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.mapPbRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO nestedScrollView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$nestedScrollView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            return (NestedScrollView) SportRecordsDetailActivity.this.findViewById(R.id.nestedScrollView);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO otherDataLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$otherDataLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SportRecordsDetailActivity.this.findViewById(R.id.otherDataLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bottomView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$bottomView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SportRecordsDetailActivity.this.findViewById(R.id.bottomView);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO downloadGpxIb$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$downloadGpxIb$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SportRecordsDetailActivity.this.findViewById(R.id.downloadGpxIb);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportTime);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportName);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportStartTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportStartTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportStartTime);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO activityDataLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$activityDataLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SportRecordsDetailActivity.this.findViewById(R.id.activityDataLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordPauseTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordPauseTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordPauseTime);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordPauseTimeLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordPauseTimeLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordPauseTimeLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordStep$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordStep$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordStep);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordStepLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordStepLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordStepLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCadence$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCadence$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCadence);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCadenceLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCadenceLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCadenceLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordDistance$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordDistance$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordDistance);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordDistanceLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordDistanceLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordDistanceLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCalories$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCalories$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCalories);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCaloriesLl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCaloriesLl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCaloriesLl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordDistanceUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordDistanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordDistanceUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivAvatar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) SportRecordsDetailActivity.this.findViewById(R.id.ivAvatar);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO nickName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$nickName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.nickName);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rootViewHeartRate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$rootViewHeartRate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SportRecordsDetailActivity.this.findViewById(R.id.rootViewHeartRate);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordMaxHR$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordMaxHR$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordMaxHR);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgHR$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgHR$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgHR);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordStrenuous$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordStrenuous$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordStrenuous);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAnaerobic$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAnaerobic$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAnaerobic);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAerobic$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAerobic$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAerobic);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFatBurning$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFatBurning$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFatBurning);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordWarmUp$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordWarmUp$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordWarmUp);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rootViewSpeed$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$rootViewSpeed$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SportRecordsDetailActivity.this.findViewById(R.id.rootViewSpeed);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO speedPf$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFRegular>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$speedPf$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFRegular invoke() {
            return (PFRegular) SportRecordsDetailActivity.this.findViewById(R.id.speedPf);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgSpeed$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgSpeed$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgSpeed);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgSpeedRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgSpeedRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgSpeedRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFastestSpeedRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFastestSpeedRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFastestSpeedRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFastestSpeed$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFastestSpeed$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFastestSpeed);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO pacePF$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFRegular>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$pacePF$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFRegular invoke() {
            return (PFRegular) SportRecordsDetailActivity.this.findViewById(R.id.pacePF);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgPaceRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgPaceRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgPaceRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFastestPaceRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFastestPaceRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFastestPaceRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgPace$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgPace$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgPace);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFastestPace$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFastestPace$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFastestPace);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgSpeedUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgSpeedUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgSpeedUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFastestSpeedUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFastestSpeedUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFastestSpeedUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAvgPaceUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAvgPaceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAvgPaceUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordFastestPaceUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordFastestPaceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordFastestPaceUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) SportRecordsDetailActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordPaceChartRl$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordPaceChartRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordPaceChartRl);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rootViewAltitude$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$rootViewAltitude$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) SportRecordsDetailActivity.this.findViewById(R.id.rootViewAltitude);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAltitude$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAltitude$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAltitude);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCR$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCR$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCR);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCD$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCD$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCD);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordAltitudeUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordAltitudeUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordAltitudeUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCRUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCRUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCRUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO sportRecordCDUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$sportRecordCDUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportRecordsDetailActivity.this.findViewById(R.id.sportRecordCDUnit);
        }
    });

    public SportRecordsDetailActivity() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.activityData = new RecordActivityData();
        MyDb myDb = MyDb.INSTANCE;
        this.mLocationDao = myDb.getMDatabase().locationDao();
        this.mHeartRateDao = myDb.getMDatabase().heartRateDao();
        this.threshold = 5;
        this.thresholdMax = 11;
        this.locationSmoothAlgorithm = new ArrayList<>();
    }

    private final LinearLayout getActivityDataLl() {
        return (LinearLayout) this.activityDataLl$delegate.getValue();
    }

    private final View getBottomView() {
        return (View) this.bottomView$delegate.getValue();
    }

    private final View getDownloadGpxIb() {
        return (View) this.downloadGpxIb$delegate.getValue();
    }

    private final ImageViewRound getIvAvatar() {
        return (ImageViewRound) this.ivAvatar$delegate.getValue();
    }

    private final RelativeLayout getMapPbRl() {
        return (RelativeLayout) this.mapPbRl$delegate.getValue();
    }

    private final FrameLayout getMapViewFrameLayout() {
        return (FrameLayout) this.mapViewFrameLayout$delegate.getValue();
    }

    private final NestedScrollView getNestedScrollView() {
        return (NestedScrollView) this.nestedScrollView$delegate.getValue();
    }

    private final PFMedium getNickName() {
        return (PFMedium) this.nickName$delegate.getValue();
    }

    private final LinearLayout getOtherDataLl() {
        return (LinearLayout) this.otherDataLl$delegate.getValue();
    }

    private final PFRegular getPacePF() {
        return (PFRegular) this.pacePF$delegate.getValue();
    }

    private final int getPaceUnit() {
        if (this.userProfile.getUnit() == 0) {
            return R.string.pace_km;
        }
        return R.string.pace_mi;
    }

    private final RelativeLayout getRootView() {
        return (RelativeLayout) this.rootView$delegate.getValue();
    }

    private final LinearLayout getRootViewAltitude() {
        return (LinearLayout) this.rootViewAltitude$delegate.getValue();
    }

    private final LinearLayout getRootViewHeartRate() {
        return (LinearLayout) this.rootViewHeartRate$delegate.getValue();
    }

    private final LinearLayout getRootViewSpeed() {
        return (LinearLayout) this.rootViewSpeed$delegate.getValue();
    }

    private final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    private final PFRegular getSpeedPf() {
        return (PFRegular) this.speedPf$delegate.getValue();
    }

    private final int getSpeedUnit() {
        if (this.userProfile.getUnit() == 0) {
            return R.string.km_h;
        }
        return R.string.mi_h;
    }

    private final PFMedium getSportName() {
        return (PFMedium) this.sportName$delegate.getValue();
    }

    private final DINCondBold getSportRecordAerobic() {
        return (DINCondBold) this.sportRecordAerobic$delegate.getValue();
    }

    private final DINCondBold getSportRecordAltitude() {
        return (DINCondBold) this.sportRecordAltitude$delegate.getValue();
    }

    private final PFMedium getSportRecordAltitudeUnit() {
        return (PFMedium) this.sportRecordAltitudeUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordAnaerobic() {
        return (DINCondBold) this.sportRecordAnaerobic$delegate.getValue();
    }

    private final DINCondBold getSportRecordAvgHR() {
        return (DINCondBold) this.sportRecordAvgHR$delegate.getValue();
    }

    private final DINCondBold getSportRecordAvgPace() {
        return (DINCondBold) this.sportRecordAvgPace$delegate.getValue();
    }

    private final RelativeLayout getSportRecordAvgPaceRl() {
        return (RelativeLayout) this.sportRecordAvgPaceRl$delegate.getValue();
    }

    private final PFMedium getSportRecordAvgPaceUnit() {
        return (PFMedium) this.sportRecordAvgPaceUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordAvgSpeed() {
        return (DINCondBold) this.sportRecordAvgSpeed$delegate.getValue();
    }

    private final RelativeLayout getSportRecordAvgSpeedRl() {
        return (RelativeLayout) this.sportRecordAvgSpeedRl$delegate.getValue();
    }

    private final PFMedium getSportRecordAvgSpeedUnit() {
        return (PFMedium) this.sportRecordAvgSpeedUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordCD() {
        return (DINCondBold) this.sportRecordCD$delegate.getValue();
    }

    private final PFMedium getSportRecordCDUnit() {
        return (PFMedium) this.sportRecordCDUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordCR() {
        return (DINCondBold) this.sportRecordCR$delegate.getValue();
    }

    private final PFMedium getSportRecordCRUnit() {
        return (PFMedium) this.sportRecordCRUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordCadence() {
        return (DINCondBold) this.sportRecordCadence$delegate.getValue();
    }

    private final RelativeLayout getSportRecordCadenceLl() {
        return (RelativeLayout) this.sportRecordCadenceLl$delegate.getValue();
    }

    private final DINCondBold getSportRecordCalories() {
        return (DINCondBold) this.sportRecordCalories$delegate.getValue();
    }

    private final RelativeLayout getSportRecordCaloriesLl() {
        return (RelativeLayout) this.sportRecordCaloriesLl$delegate.getValue();
    }

    private final DINCondBold getSportRecordDistance() {
        return (DINCondBold) this.sportRecordDistance$delegate.getValue();
    }

    private final RelativeLayout getSportRecordDistanceLl() {
        return (RelativeLayout) this.sportRecordDistanceLl$delegate.getValue();
    }

    private final PFMedium getSportRecordDistanceUnit() {
        return (PFMedium) this.sportRecordDistanceUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordFastestPace() {
        return (DINCondBold) this.sportRecordFastestPace$delegate.getValue();
    }

    private final RelativeLayout getSportRecordFastestPaceRl() {
        return (RelativeLayout) this.sportRecordFastestPaceRl$delegate.getValue();
    }

    private final PFMedium getSportRecordFastestPaceUnit() {
        return (PFMedium) this.sportRecordFastestPaceUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordFastestSpeed() {
        return (DINCondBold) this.sportRecordFastestSpeed$delegate.getValue();
    }

    private final RelativeLayout getSportRecordFastestSpeedRl() {
        return (RelativeLayout) this.sportRecordFastestSpeedRl$delegate.getValue();
    }

    private final PFMedium getSportRecordFastestSpeedUnit() {
        return (PFMedium) this.sportRecordFastestSpeedUnit$delegate.getValue();
    }

    private final DINCondBold getSportRecordFatBurning() {
        return (DINCondBold) this.sportRecordFatBurning$delegate.getValue();
    }

    private final DINCondBold getSportRecordMaxHR() {
        return (DINCondBold) this.sportRecordMaxHR$delegate.getValue();
    }

    private final LinearLayout getSportRecordPaceChartRl() {
        return (LinearLayout) this.sportRecordPaceChartRl$delegate.getValue();
    }

    private final DINCondBold getSportRecordPauseTime() {
        return (DINCondBold) this.sportRecordPauseTime$delegate.getValue();
    }

    private final RelativeLayout getSportRecordPauseTimeLl() {
        return (RelativeLayout) this.sportRecordPauseTimeLl$delegate.getValue();
    }

    private final DINCondBold getSportRecordStep() {
        return (DINCondBold) this.sportRecordStep$delegate.getValue();
    }

    private final RelativeLayout getSportRecordStepLl() {
        return (RelativeLayout) this.sportRecordStepLl$delegate.getValue();
    }

    private final DINCondBold getSportRecordStrenuous() {
        return (DINCondBold) this.sportRecordStrenuous$delegate.getValue();
    }

    private final DINCondBold getSportRecordWarmUp() {
        return (DINCondBold) this.sportRecordWarmUp$delegate.getValue();
    }

    private final DINCondBold getSportStartTime() {
        return (DINCondBold) this.sportStartTime$delegate.getValue();
    }

    private final DINCondBold getSportTime() {
        return (DINCondBold) this.sportTime$delegate.getValue();
    }

    private final void localFindLocation(ArrayList<CustomLatLng> arrayList) {
        boolean z;
        LocationDao locationDao = this.mLocationDao;
        SportRecordData sportRecordData = this.sportRecordData;
        SportRecordData sportRecordData2 = null;
        if (sportRecordData == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData = null;
        }
        long mStartTime = sportRecordData.getMStartTime();
        SportRecordData sportRecordData3 = this.sportRecordData;
        if (sportRecordData3 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
        } else {
            sportRecordData2 = sportRecordData3;
        }
        List<Location> location = locationDao.getLocation(mStartTime, sportRecordData2.getMEndTime());
        if (!location.isEmpty() && location.size() >= 2) {
            Iterator<Location> it = location.iterator();
            while (true) {
                z = true;
                if (it.hasNext()) {
                    if (it.next().getMSource() == 1) {
                        z = false;
                        break;
                    }
                } else {
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
        this.locationSmoothAlgorithm.addAll(locationSmoothAlgorithm(arrayList));
        showMapContent(this.locationSmoothAlgorithm);
    }

    private final ArrayList<CustomLatLng> locationSmoothAlgorithm(ArrayList<CustomLatLng> arrayList) {
        ArrayList<CustomLatLng> arrayList2 = new ArrayList<>();
        CustomLatLng customLatLng = new CustomLatLng(arrayList.get(0).getLatitude(), arrayList.get(0).getLongitude(), arrayList.get(0).getTime(), arrayList.get(0).getAltitude(), 0, 16, null);
        CustomLatLng customLatLng2 = new CustomLatLng(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0L, 0, 0, 16, null);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            CustomLatLng customLatLng3 = arrayList.get(i);
            IIX0o.oO(customLatLng3, "get(...)");
            CustomLatLng customLatLng4 = customLatLng3;
            if (customLatLng4.getLatitude() == customLatLng2.getLatitude() && customLatLng4.getLongitude() == customLatLng2.getLongitude()) {
                customLatLng4.setLongitude(customLatLng.getLongitude());
                customLatLng4.setLatitude(customLatLng.getLatitude());
            } else {
                float IIX02 = oOIx.oxoX.IIX0(DistanceUtil.getDistance(new LatLng(customLatLng.getLatitude(), customLatLng.getLongitude()), new LatLng(customLatLng4.getLatitude(), customLatLng4.getLongitude())) * 100) / 100.0f;
                float abs = IIX02 / ((float) (Math.abs(customLatLng4.getTime() - customLatLng.getTime()) / 1000));
                LogUtils.d("secondSpeed = " + abs + TokenParser.SP + this.threshold + (char) 65292 + this.thresholdMax + (char) 65292 + IIX02 + " ---> " + customLatLng4.getLatitude() + ',' + customLatLng4.getLongitude() + " --- " + customLatLng.getLatitude() + ',' + customLatLng.getLongitude());
                if (abs >= this.threshold) {
                    LogUtils.d("secondSpeed process");
                    if (abs >= this.thresholdMax) {
                        LogUtils.d("give up " + abs + TokenParser.SP + this.thresholdMax + " longitude=" + customLatLng4.getLongitude() + ",latitude=" + customLatLng4.getLatitude() + ",time=" + customLatLng4.getTime());
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
                    LogUtils.d("secondSpeed No process");
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void share$lambda$1(Ref.IntRef finalBitmapAllHeight, SportRecordsDetailActivity this$0, int i, Bitmap activityViewBitmap, Ref.ObjectRef heartRateViewBitmap, Ref.ObjectRef speedViewBitmap, Bitmap bottomViewBitmap, Ref.ObjectRef altitudeViewBitmap, Bitmap bitmap) {
        IIX0o.x0xO0oo(finalBitmapAllHeight, "$finalBitmapAllHeight");
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(activityViewBitmap, "$activityViewBitmap");
        IIX0o.x0xO0oo(heartRateViewBitmap, "$heartRateViewBitmap");
        IIX0o.x0xO0oo(speedViewBitmap, "$speedViewBitmap");
        IIX0o.x0xO0oo(bottomViewBitmap, "$bottomViewBitmap");
        IIX0o.x0xO0oo(altitudeViewBitmap, "$altitudeViewBitmap");
        int height = finalBitmapAllHeight.element + bitmap.getHeight();
        finalBitmapAllHeight.element = height;
        this$0.spliceBitmapAndShare(i, height, activityViewBitmap, (Bitmap) heartRateViewBitmap.element, (Bitmap) speedViewBitmap.element, bottomViewBitmap, (Bitmap) altitudeViewBitmap.element, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void share$lambda$2(Ref.IntRef finalBitmapAllHeight, SportRecordsDetailActivity this$0, int i, Bitmap activityViewBitmap, Ref.ObjectRef heartRateViewBitmap, Ref.ObjectRef speedViewBitmap, Bitmap bottomViewBitmap, Ref.ObjectRef altitudeViewBitmap, Bitmap bitmap) {
        int i2;
        IIX0o.x0xO0oo(finalBitmapAllHeight, "$finalBitmapAllHeight");
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(activityViewBitmap, "$activityViewBitmap");
        IIX0o.x0xO0oo(heartRateViewBitmap, "$heartRateViewBitmap");
        IIX0o.x0xO0oo(speedViewBitmap, "$speedViewBitmap");
        IIX0o.x0xO0oo(bottomViewBitmap, "$bottomViewBitmap");
        IIX0o.x0xO0oo(altitudeViewBitmap, "$altitudeViewBitmap");
        int i3 = finalBitmapAllHeight.element;
        if (bitmap != null) {
            i2 = bitmap.getHeight();
        } else {
            i2 = 0;
        }
        int i4 = i3 + i2;
        finalBitmapAllHeight.element = i4;
        this$0.spliceBitmapAndShare(i, i4, activityViewBitmap, (Bitmap) heartRateViewBitmap.element, (Bitmap) speedViewBitmap.element, bottomViewBitmap, (Bitmap) altitudeViewBitmap.element, bitmap);
    }

    private final void showActivityData() {
        RecordActivityData sportRecordWorkout;
        SportRecordData sportRecordData = this.sportRecordData;
        SportRecordData sportRecordData2 = null;
        if (sportRecordData == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData = null;
        }
        if (sportRecordData.getMSource() == 0) {
            SportRecordData sportRecordData3 = this.sportRecordData;
            if (sportRecordData3 == null) {
                IIX0o.XOxIOxOx("sportRecordData");
                sportRecordData3 = null;
            }
            long mStartTime = sportRecordData3.getMStartTime();
            SportRecordData sportRecordData4 = this.sportRecordData;
            if (sportRecordData4 == null) {
                IIX0o.XOxIOxOx("sportRecordData");
                sportRecordData4 = null;
            }
            sportRecordWorkout = SportRecordDataKt.sportRecordActivity(mStartTime, sportRecordData4.getMEndTime(), this.userProfile.getUnit());
        } else {
            SportRecordData sportRecordData5 = this.sportRecordData;
            if (sportRecordData5 == null) {
                IIX0o.XOxIOxOx("sportRecordData");
                sportRecordData5 = null;
            }
            long mStartTime2 = sportRecordData5.getMStartTime();
            SportRecordData sportRecordData6 = this.sportRecordData;
            if (sportRecordData6 == null) {
                IIX0o.XOxIOxOx("sportRecordData");
                sportRecordData6 = null;
            }
            sportRecordWorkout = SportRecordDataKt.sportRecordWorkout(mStartTime2, sportRecordData6.getMEndTime(), this.userProfile.getUnit());
        }
        this.activityData = sportRecordWorkout;
        getSportTime().setText(this.activityData.getMSportTimeStr());
        PFMedium sportName = getSportName();
        Activity mContext = getMContext();
        SportRecordData sportRecordData7 = this.sportRecordData;
        if (sportRecordData7 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData7 = null;
        }
        sportName.setText(SportRecordDataKt.getWorkoutName(mContext, sportRecordData7));
        DINCondBold sportStartTime = getSportStartTime();
        SportRecordData sportRecordData8 = this.sportRecordData;
        if (sportRecordData8 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
        } else {
            sportRecordData2 = sportRecordData8;
        }
        sportStartTime.setText(SportRecordDataKt.getSportStartTime(sportRecordData2));
        if (IIX0o.Oxx0IOOO(this.activityData.getMPauseTimeTotal(), "00:00:00")) {
            getSportRecordPauseTimeLl().setVisibility(8);
        } else {
            getSportRecordPauseTime().setText(this.activityData.getMPauseTimeTotal());
        }
        if (this.activityData.getMStepTotal() <= 0) {
            getSportRecordStep().setText("0");
        } else {
            getSportRecordStep().setText(String.valueOf(this.activityData.getMStepTotal()));
        }
        if (this.activityData.getMDistanceTotal() <= XIXIX.OOXIXo.f3760XO) {
            getSportRecordDistance().setText(cn.d);
        } else {
            getSportRecordDistance().setText(String.valueOf(this.activityData.getMDistanceTotal()));
        }
        getSportRecordDistanceUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
        if (this.activityData.getMCalorieTotal() <= 0) {
            getSportRecordCalories().setText("0");
        } else {
            getSportRecordCalories().setText(String.valueOf(this.activityData.getMCalorieTotal()));
        }
        if (this.activityData.getMSpm() <= 0) {
            getSportRecordCadence().setText("0");
        } else {
            getSportRecordCadence().setText(String.valueOf(this.activityData.getMSpm()));
        }
        getNickName().setText(this.userProfile.getNickname());
        File xxIXOIIO2 = com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(X00IoxXI.oIX0oI.f3233oIX0oI);
        if (xxIXOIIO2.exists()) {
            getIvAvatar().setImageURI(Uri.fromFile(xxIXOIIO2));
        } else {
            getIvAvatar().setVisibility(4);
        }
    }

    private final void showAltitudeData() {
        int i;
        LocationDao locationDao = this.mLocationDao;
        SportRecordData sportRecordData = this.sportRecordData;
        SportRecordData sportRecordData2 = null;
        if (sportRecordData == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData = null;
        }
        long mStartTime = sportRecordData.getMStartTime();
        SportRecordData sportRecordData3 = this.sportRecordData;
        if (sportRecordData3 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData3 = null;
        }
        List<Location> location = locationDao.getLocation(mStartTime, sportRecordData3.getMEndTime());
        int i2 = 8;
        if (!location.isEmpty() && location.size() >= 2) {
            LinearLayout rootViewAltitude = getRootViewAltitude();
            SportRecordData sportRecordData4 = this.sportRecordData;
            if (sportRecordData4 == null) {
                IIX0o.XOxIOxOx("sportRecordData");
            } else {
                sportRecordData2 = sportRecordData4;
            }
            int mMode = sportRecordData2.getMMode();
            if (mMode == 10 || mMode == 13 || mMode == 19) {
                i2 = 0;
            }
            rootViewAltitude.setVisibility(i2);
        } else {
            getRootViewAltitude().setVisibility(8);
        }
        int size = location.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Location location2 = location.get(i7);
            if (i7 == 0) {
                i3 = location2.getMAltitude();
            } else {
                if (i3 < location2.getMAltitude()) {
                    i3 = location2.getMAltitude();
                }
                if (i6 < location2.getMAltitude()) {
                    i4 += location2.getMAltitude() - i6;
                } else if (i6 > location2.getMAltitude()) {
                    i5 += i6 - location2.getMAltitude();
                }
            }
            i6 = location2.getMAltitude();
        }
        DINCondBold sportRecordAltitude = getSportRecordAltitude();
        if (this.activityData.getMAltitude() > 0) {
            i3 = this.activityData.getMAltitude();
        }
        sportRecordAltitude.setText(TextConvertKt.X00IoxXI(i3, this.userProfile.getUnit()));
        getSportRecordCR().setText(TextConvertKt.X00IoxXI(i4, this.userProfile.getUnit()));
        getSportRecordCD().setText(TextConvertKt.X00IoxXI(i5, this.userProfile.getUnit()));
        if (this.userProfile.getUnit() == 0) {
            i = R.string.m;
        } else {
            i = R.string.yd;
        }
        getSportRecordAltitudeUnit().setText(i);
        getSportRecordCRUnit().setText(i);
        getSportRecordCDUnit().setText(i);
    }

    private final void showBaiDuMap(ArrayList<CustomLatLng> arrayList) {
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", arrayList);
        BaseFragment baseFragment = (BaseFragment) BaiDuMapSportRecordFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        BaiDuMapSportRecordFragment baiDuMapSportRecordFragment = (BaiDuMapSportRecordFragment) baseFragment;
        this.mBaiDuMapFragment = baiDuMapSportRecordFragment;
        IIX0o.ooOOo0oXI(baiDuMapSportRecordFragment);
        NestedScrollView nestedScrollView = getNestedScrollView();
        IIX0o.oO(nestedScrollView, "<get-nestedScrollView>(...)");
        baiDuMapSportRecordFragment.setOnMapTouchListener(nestedScrollView);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BaiDuMapSportRecordFragment baiDuMapSportRecordFragment2 = this.mBaiDuMapFragment;
        IIX0o.ooOOo0oXI(baiDuMapSportRecordFragment2);
        beginTransaction.add(R.id.mapViewFrameLayout, baiDuMapSportRecordFragment2).commit();
    }

    private final void showGoogleMap(ArrayList<CustomLatLng> arrayList) {
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", arrayList);
        BaseFragment baseFragment = (BaseFragment) GoogleMapSportRecordFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        GoogleMapSportRecordFragment googleMapSportRecordFragment = (GoogleMapSportRecordFragment) baseFragment;
        this.mGoogleMapFragment = googleMapSportRecordFragment;
        IIX0o.ooOOo0oXI(googleMapSportRecordFragment);
        NestedScrollView nestedScrollView = getNestedScrollView();
        IIX0o.oO(nestedScrollView, "<get-nestedScrollView>(...)");
        googleMapSportRecordFragment.setOnMapTouchListener(nestedScrollView);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        GoogleMapSportRecordFragment googleMapSportRecordFragment2 = this.mGoogleMapFragment;
        IIX0o.ooOOo0oXI(googleMapSportRecordFragment2);
        beginTransaction.add(R.id.mapViewFrameLayout, googleMapSportRecordFragment2).commit();
    }

    private final void showHeartRateData() {
        int mAvgHR;
        int mMaxHR;
        RecordDetailHeartRateData sportRecordHeartRateDetail = SportRecordDataKt.sportRecordHeartRateDetail(this.mHeartRateDao, this.activityData.getMTimeList());
        SportRecordData sportRecordData = this.sportRecordData;
        if (sportRecordData == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData = null;
        }
        long mEndTime = sportRecordData.getMEndTime();
        SportRecordData sportRecordData2 = this.sportRecordData;
        if (sportRecordData2 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData2 = null;
        }
        long j = 1000;
        long j2 = 60;
        long mStartTime = (((mEndTime - sportRecordData2.getMStartTime()) / j) / j2) + 1;
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        LineChart lineChart = this.lineChart;
        if (lineChart == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart = null;
        }
        oix0oi.II0xO0(lineChart);
        LineChart lineChart2 = this.lineChart;
        if (lineChart2 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart2 = null;
        }
        YAxis axisLeft = lineChart2.getAxisLeft();
        IIX0o.oO(axisLeft, "getAxisLeft(...)");
        LineChart lineChart3 = this.lineChart;
        if (lineChart3 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart3 = null;
        }
        YAxis axisRight = lineChart3.getAxisRight();
        IIX0o.oO(axisRight, "getAxisRight(...)");
        oix0oi.XO(axisLeft, axisRight, sportRecordHeartRateDetail.getMMaxHR() + 5.0f, sportRecordHeartRateDetail.getMMinHR() - 5.0f);
        LineChart lineChart4 = this.lineChart;
        if (lineChart4 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart4 = null;
        }
        lineChart4.setTouchEnabled(false);
        lineChart4.getDescription().Oxx0IOOO(false);
        lineChart4.getLegend().Oxx0IOOO(false);
        LineChart lineChart5 = this.lineChart;
        if (lineChart5 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart5 = null;
        }
        XAxis xAxis = lineChart5.getXAxis();
        IIX0o.ooOOo0oXI(xAxis);
        LineChart lineChart6 = this.lineChart;
        if (lineChart6 == null) {
            IIX0o.XOxIOxOx("lineChart");
            lineChart6 = null;
        }
        Context context = lineChart6.getContext();
        IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.I0X0x0oIo(0.0f);
        xAxis.OO(1.0f);
        xAxis.xXOx((float) mStartTime);
        SportRecordData sportRecordData3 = null;
        SimpleDateFormat O0Xx2 = com.sma.smartv3.util.xoIox.O0Xx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        if (0 <= mStartTime) {
            while (true) {
                SportRecordData sportRecordData4 = this.sportRecordData;
                if (sportRecordData4 == null) {
                    IIX0o.XOxIOxOx("sportRecordData");
                    sportRecordData4 = sportRecordData3;
                }
                long j4 = j3;
                String millis2String = TimeUtils.millis2String(sportRecordData4.getMStartTime() + (j3 * j2 * j), O0Xx2);
                IIX0o.oO(millis2String, "millis2String(...)");
                arrayList.add(millis2String);
                if (j4 == mStartTime) {
                    break;
                }
                j3 = j4 + 1;
                sportRecordData3 = null;
            }
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
        DINCondBold sportRecordAvgHR = getSportRecordAvgHR();
        if (this.activityData.getMAvgBpm() > 0) {
            mAvgHR = this.activityData.getMAvgBpm();
        } else {
            mAvgHR = sportRecordHeartRateDetail.getMAvgHR();
        }
        sportRecordAvgHR.setText(String.valueOf(mAvgHR));
        DINCondBold sportRecordMaxHR = getSportRecordMaxHR();
        if (this.activityData.getMMaxBpm() > 0) {
            mMaxHR = this.activityData.getMMaxBpm();
        } else {
            mMaxHR = sportRecordHeartRateDetail.getMMaxHR();
        }
        sportRecordMaxHR.setText(String.valueOf(mMaxHR));
        showHeartRateFilterData(sportRecordHeartRateDetail.getMHeartRateList());
        getSportRecordStrenuous().setText(String.valueOf(sportRecordHeartRateDetail.getMStrenuous()));
        getSportRecordAnaerobic().setText(String.valueOf(sportRecordHeartRateDetail.getMAnaerobic()));
        getSportRecordAerobic().setText(String.valueOf(sportRecordHeartRateDetail.getMAerobic()));
        getSportRecordFatBurning().setText(String.valueOf(sportRecordHeartRateDetail.getMFatBurning()));
        getSportRecordWarmUp().setText(String.valueOf(sportRecordHeartRateDetail.getMWarmUp()));
    }

    private final void showHeartRateFilterData(List<HeartRate> list) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SportRecordData sportRecordData = this.sportRecordData;
        SportRecordData sportRecordData2 = null;
        if (sportRecordData == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData = null;
        }
        long mStartTime = sportRecordData.getMStartTime();
        SportRecordData sportRecordData3 = this.sportRecordData;
        if (sportRecordData3 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
        } else {
            sportRecordData2 = sportRecordData3;
        }
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(mStartTime, sportRecordData2.getMEndTime(), 60000L);
        int i = 0;
        if (mStartTime <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(mStartTime), new HRMinuteData(0, 0));
                if (mStartTime == oxoX2) {
                    break;
                } else {
                    mStartTime += 60000;
                }
            }
        }
        for (HeartRate heartRate : list) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    HRMinuteData hRMinuteData = (HRMinuteData) entry.getValue();
                    if (heartRate.getMTime() <= longValue) {
                        hRMinuteData.setTotal(hRMinuteData.getTotal() + heartRate.getMBpm());
                        hRMinuteData.setNum(hRMinuteData.getNum() + 1);
                        break;
                    }
                }
            }
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        float f = 0.0f;
        int i2 = 0;
        while (it2.hasNext()) {
            HRMinuteData hRMinuteData2 = (HRMinuteData) ((Map.Entry) it2.next()).getValue();
            if (hRMinuteData2.getNum() != 0 && hRMinuteData2.getTotal() != 0) {
                int total = hRMinuteData2.getTotal() / hRMinuteData2.getNum();
                arrayList.add(new Entry(f, total));
                if (i < total) {
                    i = total;
                }
                if (i2 == 0) {
                    i2 = total;
                }
                if (1 <= total && total < i2) {
                    i2 = total;
                }
            }
            f += 1.0f;
        }
        showHeartRateUpdateChartData(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showHeartRateUpdateChartData(java.util.List<com.github.mikephil.charting.data.Entry> r8) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.SportRecordsDetailActivity.showHeartRateUpdateChartData(java.util.List):void");
    }

    private final void showLocation() {
        localFindLocation(new ArrayList<>());
    }

    private final void showMapContent(ArrayList<CustomLatLng> arrayList) {
        if (arrayList != null && !arrayList.isEmpty() && arrayList.size() >= 2) {
            if (this.isInChinaMainland) {
                showBaiDuMap(arrayList);
            } else {
                showGoogleMap(arrayList);
            }
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.status.OOXIXo
                @Override // java.lang.Runnable
                public final void run() {
                    SportRecordsDetailActivity.showMapContent$lambda$3(SportRecordsDetailActivity.this);
                }
            }, 1000L);
            return;
        }
        getMapPbRl().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMapContent$lambda$3(SportRecordsDetailActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMapViewFrameLayout().setVisibility(0);
        this$0.getMapPbRl().setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showSpeedData() {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.SportRecordsDetailActivity.showSpeedData():void");
    }

    private final void spliceBitmapAndShare(int i, int i2, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        float f;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), i2, Bitmap.Config.ARGB_8888);
        IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        if (bitmap6 != null) {
            canvas.drawBitmap(bitmap6, 0.0f, 0.0f, (Paint) null);
            f = (bitmap6.getHeight() - SizeUtils.dp2px(30.0f)) + 0.0f;
            canvas.drawBitmap(bitmap, 0.0f, f, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            f = 0.0f;
        }
        float height = f + bitmap.getHeight() + i;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, height, (Paint) null);
            height += bitmap2.getHeight() + i;
        }
        if (bitmap3 != null) {
            canvas.drawBitmap(bitmap3, 0.0f, height, (Paint) null);
            height += bitmap3.getHeight() + i;
        }
        if (bitmap5 != null) {
            canvas.drawBitmap(bitmap5, 0.0f, height, (Paint) null);
            height += bitmap5.getHeight() + i;
        }
        canvas.drawBitmap(bitmap4, 0.0f, height, (Paint) null);
        com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI.oxoX(getMContext(), createBitmap);
    }

    public static /* synthetic */ void spliceBitmapAndShare$default(SportRecordsDetailActivity sportRecordsDetailActivity, int i, int i2, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, int i3, Object obj) {
        Bitmap bitmap7;
        if ((i3 & 128) != 0) {
            bitmap7 = null;
        } else {
            bitmap7 = bitmap6;
        }
        sportRecordsDetailActivity.spliceBitmapAndShare(i, i2, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap7);
    }

    public final void delete(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mDeletePopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            String string = getString(R.string.delete_record_remind);
            IIX0o.oO(string, "getString(...)");
            xoI0Ixx0.Xx000oIo(string);
            XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.status.SportRecordsDetailActivity$delete$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    SportRecordData sportRecordData;
                    sportRecordData = SportRecordsDetailActivity.this.sportRecordData;
                    if (sportRecordData == null) {
                        IIX0o.XOxIOxOx("sportRecordData");
                        sportRecordData = null;
                    }
                    SportRecordDataKt.deleteSportRecord(sportRecordData);
                    SportRecordsDetailActivity.this.finish();
                    return Boolean.TRUE;
                }
            });
            this.mDeletePopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mDeletePopup;
        if (xoI0Ixx02 != null) {
            RelativeLayout rootView = getRootView();
            IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void downloadGpx(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.locationSmoothAlgorithm.size() > 0) {
            SimpleDateFormat xoIox2 = com.sma.smartv3.util.xoIox.xoIox();
            int rawOffset = TimeZone.getDefault().getRawOffset();
            StringBuilder sb = new StringBuilder();
            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><gpx creator='");
            sb.append(this.userProfile.getNickname());
            sb.append("' version=\"1.1\" xmlns='http://www.topografix.com/GPX/1/1'><metadata><time>");
            SportRecordData sportRecordData = this.sportRecordData;
            if (sportRecordData == null) {
                IIX0o.XOxIOxOx("sportRecordData");
                sportRecordData = null;
            }
            long j = rawOffset;
            sb.append(xoIox2.format(Long.valueOf(sportRecordData.getMStartTime() - j)));
            sb.append("</time></metadata>");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<trk><name>");
            sb2.append(getSportName().getText());
            sb2.append("</name><desc>");
            sb2.append(getString(R.string.app_name));
            sb2.append("</desc><trkseg>");
            int size = this.locationSmoothAlgorithm.size();
            int i = 0;
            while (i < size) {
                CustomLatLng customLatLng = this.locationSmoothAlgorithm.get(i);
                IIX0o.oO(customLatLng, "get(...)");
                CustomLatLng customLatLng2 = customLatLng;
                sb.append("<wpt lat='");
                sb.append(customLatLng2.getLatitude());
                sb.append("' lon='");
                sb.append(customLatLng2.getLongitude());
                sb.append("'><name>\"");
                i++;
                sb.append(i);
                sb.append("\"</name><ele>");
                sb.append(customLatLng2.getAltitude());
                sb.append("</ele><time>");
                sb.append(xoIox2.format(Long.valueOf(customLatLng2.getTime() - j)));
                sb.append("</time></wpt>");
                sb2.append("<trkpt lat='");
                sb2.append(customLatLng2.getLatitude());
                sb2.append("' lon='");
                sb2.append(customLatLng2.getLongitude());
                sb2.append("'><ele>");
                sb2.append(customLatLng2.getAltitude());
                sb2.append("</ele><time>");
                sb2.append(xoIox2.format(Long.valueOf(customLatLng2.getTime() - j)));
                sb2.append("</time></trkpt>");
            }
            sb2.append("</trkseg></trk>");
            sb.append(sb2.toString());
            sb.append("</gpx>");
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            FileIOUtils.writeFileFromString(com.sma.smartv3.initializer.IXxxXO.ooXIXxIX(oix0oi), sb.toString());
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", getString(R.string.share_gpx_file));
            intent.putExtra("android.intent.extra.STREAM", oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.ooXIXxIX(oix0oi)));
            intent.setType("application/gpx");
            startActivity(Intent.createChooser(intent, getString(R.string.share_gpx_file)));
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        Parcelable mArg2 = getMArg2();
        IIX0o.x0XOIxOo(mArg2, "null cannot be cast to non-null type com.sma.smartv3.model.SportRecordData");
        this.sportRecordData = (SportRecordData) mArg2;
        View findViewById = findViewById(R.id.sportRecordLineChartHR);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.lineChart = (LineChart) findViewById;
        SportRecordData sportRecordData = this.sportRecordData;
        SportRecordData sportRecordData2 = null;
        if (sportRecordData == null) {
            IIX0o.XOxIOxOx("sportRecordData");
            sportRecordData = null;
        }
        switch (sportRecordData.getMMode()) {
            case 7:
            case 8:
            case 9:
            case 12:
            case 13:
            case 19:
                this.threshold = 5;
                this.thresholdMax = 100;
                break;
            case 10:
                this.threshold = 10;
                this.thresholdMax = 100;
                getSportRecordStepLl().setVisibility(8);
                getSportRecordCadenceLl().setVisibility(8);
                if (BleCache.INSTANCE.getMAGpsType() == 0 && !ProductManager.f20544oIX0oI.o0oIxOo()) {
                    getSportRecordDistanceLl().setVisibility(8);
                    getRootViewSpeed().setVisibility(8);
                    getRootViewAltitude().setVisibility(8);
                    break;
                }
                break;
            case 11:
            case 14:
            case 15:
            case 21:
                getSportRecordStepLl().setVisibility(8);
                getSportRecordDistanceLl().setVisibility(8);
                getSportRecordCadenceLl().setVisibility(8);
                getRootViewSpeed().setVisibility(8);
                getRootViewAltitude().setVisibility(8);
                break;
            case 16:
            case 17:
            case 18:
            case 25:
            case 26:
            case 27:
            case 33:
            case 34:
            case 35:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                getSportRecordDistanceLl().setVisibility(8);
                getSportRecordCadenceLl().setVisibility(8);
                getRootViewSpeed().setVisibility(8);
                getRootViewAltitude().setVisibility(8);
                break;
        }
        ViewGroup.LayoutParams layoutParams = getActivityDataLl().getLayoutParams();
        IIX0o.x0XOIxOo(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        SportRecordData sportRecordData3 = this.sportRecordData;
        if (sportRecordData3 == null) {
            IIX0o.XOxIOxOx("sportRecordData");
        } else {
            sportRecordData2 = sportRecordData3;
        }
        if (sportRecordData2.getMIsLocationEmpty()) {
            getMapPbRl().setVisibility(8);
            getDownloadGpxIb().setVisibility(8);
            layoutParams2.topMargin = SizeUtils.dp2px(70.0f);
            getNestedScrollView().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_main_bg));
        } else {
            getMapPbRl().setVisibility(0);
            getDownloadGpxIb().setVisibility(0);
            this.isInChinaMainland = Xo0.f24349oIX0oI.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO, false);
            layoutParams2.topMargin = SizeUtils.dp2px(370.0f);
            getNestedScrollView().setBackgroundResource(R.color.text_color);
            showLocation();
        }
        showActivityData();
        showHeartRateData();
        showSpeedData();
        showAltitudeData();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_records_detail;
    }

    public final void onBack(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v22, types: [T, android.graphics.Bitmap] */
    public final void share(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        LinearLayout activityDataLl = getActivityDataLl();
        IIX0o.oO(activityDataLl, "<get-activityDataLl>(...)");
        final Bitmap II0xO02 = oxx0IOOO.II0xO0(activityDataLl);
        intRef.element += II0xO02.getHeight();
        LinearLayout rootViewHeartRate = getRootViewHeartRate();
        IIX0o.oO(rootViewHeartRate, "<get-rootViewHeartRate>(...)");
        if (rootViewHeartRate.getVisibility() == 0) {
            LinearLayout rootViewHeartRate2 = getRootViewHeartRate();
            IIX0o.oO(rootViewHeartRate2, "<get-rootViewHeartRate>(...)");
            ?? II0xO03 = oxx0IOOO.II0xO0(rootViewHeartRate2);
            objectRef2.element = II0xO03;
            intRef.element += II0xO03.getHeight();
        }
        LinearLayout rootViewSpeed = getRootViewSpeed();
        IIX0o.oO(rootViewSpeed, "<get-rootViewSpeed>(...)");
        if (rootViewSpeed.getVisibility() == 0) {
            LinearLayout rootViewSpeed2 = getRootViewSpeed();
            IIX0o.oO(rootViewSpeed2, "<get-rootViewSpeed>(...)");
            ?? II0xO04 = oxx0IOOO.II0xO0(rootViewSpeed2);
            objectRef3.element = II0xO04;
            intRef.element += II0xO04.getHeight();
        }
        LinearLayout rootViewAltitude = getRootViewAltitude();
        IIX0o.oO(rootViewAltitude, "<get-rootViewAltitude>(...)");
        if (rootViewAltitude.getVisibility() == 0) {
            LinearLayout rootViewAltitude2 = getRootViewAltitude();
            IIX0o.oO(rootViewAltitude2, "<get-rootViewAltitude>(...)");
            ?? II0xO05 = oxx0IOOO.II0xO0(rootViewAltitude2);
            objectRef.element = II0xO05;
            intRef.element += II0xO05.getHeight();
        }
        View bottomView = getBottomView();
        IIX0o.oO(bottomView, "<get-bottomView>(...)");
        final Bitmap II0xO06 = oxx0IOOO.II0xO0(bottomView);
        intRef.element += II0xO06.getHeight();
        final int dp2px = SizeUtils.dp2px(8.0f);
        FrameLayout mapViewFrameLayout = getMapViewFrameLayout();
        IIX0o.oO(mapViewFrameLayout, "<get-mapViewFrameLayout>(...)");
        if (mapViewFrameLayout.getVisibility() == 0) {
            if (this.mBaiDuMapFragment != null) {
                BaiduMap.SnapshotReadyCallback snapshotReadyCallback = new BaiduMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.status.oOoXoXO
                    @Override // com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback
                    public final void onSnapshotReady(Bitmap bitmap) {
                        SportRecordsDetailActivity.share$lambda$1(Ref.IntRef.this, this, dp2px, II0xO02, objectRef2, objectRef3, II0xO06, objectRef, bitmap);
                    }
                };
                BaiDuMapSportRecordFragment baiDuMapSportRecordFragment = this.mBaiDuMapFragment;
                IIX0o.ooOOo0oXI(baiDuMapSportRecordFragment);
                baiDuMapSportRecordFragment.getBaiDuMap().snapshot(snapshotReadyCallback);
                return;
            }
            if (this.mGoogleMapFragment != null) {
                GoogleMap.SnapshotReadyCallback snapshotReadyCallback2 = new GoogleMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.status.ooOOo0oXI
                    @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                    public final void onSnapshotReady(Bitmap bitmap) {
                        SportRecordsDetailActivity.share$lambda$2(Ref.IntRef.this, this, dp2px, II0xO02, objectRef2, objectRef3, II0xO06, objectRef, bitmap);
                    }
                };
                GoogleMapSportRecordFragment googleMapSportRecordFragment = this.mGoogleMapFragment;
                IIX0o.ooOOo0oXI(googleMapSportRecordFragment);
                googleMapSportRecordFragment.getGoogleMap().snapshot(snapshotReadyCallback2);
                return;
            }
            return;
        }
        spliceBitmapAndShare$default(this, dp2px, intRef.element, II0xO02, (Bitmap) objectRef2.element, (Bitmap) objectRef3.element, II0xO06, (Bitmap) objectRef.element, null, 128, null);
    }
}
