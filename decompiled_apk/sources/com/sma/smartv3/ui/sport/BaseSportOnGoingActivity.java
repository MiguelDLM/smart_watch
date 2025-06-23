package com.sma.smartv3.ui.sport;

import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.LibExKt;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.VibrateUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.SportData;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$mSportCallback$2;
import com.sma.smartv3.ui.sport.SportManager;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.view.AnchorBottomSheetBehavior;
import com.sma.smartv3.view.CustomGoogleMapView;
import com.sma.smartv3.view.CustomNestedScollView;
import com.sma.smartv3.view.SlideLockView;
import com.sma.smartv3.view.SportEndProgress;
import com.sma.smartv3.view.bubbleview.ArrowDirection;
import com.sma.smartv3.view.bubbleview.BubbleLayout;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.entity.BleAppSportState;
import com.szabh.smable3.entity.BleDeviceSportData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nBaseSportOnGoingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSportOnGoingActivity.kt\ncom/sma/smartv3/ui/sport/BaseSportOnGoingActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,768:1\n19#2:769\n15#2:770\n94#2:771\n90#2:772\n94#2:773\n90#2:774\n173#3,7:775\n180#3,3:783\n143#3,7:786\n183#3:793\n173#3,7:794\n180#3,3:802\n143#3,7:805\n183#3:812\n173#3,7:813\n180#3,3:821\n143#3,7:824\n183#3:831\n173#3,7:832\n180#3,3:840\n143#3,7:843\n183#3:850\n69#3,3:851\n72#3,5:855\n1#4:782\n1#4:801\n1#4:820\n1#4:839\n1#4:854\n*S KotlinDebug\n*F\n+ 1 BaseSportOnGoingActivity.kt\ncom/sma/smartv3/ui/sport/BaseSportOnGoingActivity\n*L\n105#1:769\n105#1:770\n169#1:771\n169#1:772\n685#1:773\n685#1:774\n694#1:775,7\n694#1:783,3\n694#1:786,7\n694#1:793\n698#1:794,7\n698#1:802,3\n698#1:805,7\n698#1:812\n702#1:813,7\n702#1:821,3\n702#1:824,7\n702#1:831\n706#1:832,7\n706#1:840,3\n706#1:843,7\n706#1:850\n710#1:851,3\n710#1:855,5\n694#1:782\n698#1:801\n702#1:820\n706#1:839\n710#1:854\n*E\n"})
/* loaded from: classes12.dex */
public abstract class BaseSportOnGoingActivity extends BaseActivity {
    private AnchorBottomSheetBehavior<CustomNestedScollView> behavior;
    private int cardPanelSubMinHeight;

    @OXOo.OOXIXo
    private int[] goals;
    private final boolean isInChinaMainland;
    private boolean isShowMap;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mBMapView$delegate;
    private BaiduMap mBaiDuMap;

    @OXOo.oOoXoXO
    private Overlay mBaiduLine;

    @OXOo.oOoXoXO
    private Overlay mBaiduLineEnd;

    @OXOo.oOoXoXO
    private Overlay mBaiduLineStart;

    @OXOo.OOXIXo
    private final List<LatLng> mBaiduPoints;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGMapView$delegate;

    @OXOo.oOoXoXO
    private Polyline mGoogleLine;

    @OXOo.oOoXoXO
    private Marker mGoogleLineEnd;

    @OXOo.oOoXoXO
    private Marker mGoogleLineStart;
    private GoogleMap mGoogleMap;

    @OXOo.OOXIXo
    private final List<com.google.android.gms.maps.model.LatLng> mGooglePoints;

    @OXOo.oOoXoXO
    private PopupWindow mLongPressPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportCallback$delegate;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mSportShortPopup;
    private XIxXXX0x0 sportDataOrder;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO countdownRl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$countdownRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) BaseSportOnGoingActivity.this.findViewById(R.id.countdownRl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO countdownTv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$countdownTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) BaseSportOnGoingActivity.this.findViewById(R.id.countdownTv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportProcess$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomNestedScollView>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportProcess$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomNestedScollView invoke() {
            return (CustomNestedScollView) BaseSportOnGoingActivity.this.findViewById(R.id.sportProcess);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportSet$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportSet$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            return (ImageButton) BaseSportOnGoingActivity.this.findViewById(R.id.sportSet);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportPause$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageButton>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportPause$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageButton invoke() {
            return (ImageButton) BaseSportOnGoingActivity.this.findViewById(R.id.sportPause);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportOneShowValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportOneShowValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) BaseSportOnGoingActivity.this.findViewById(R.id.sportOneShowValue);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportTwoShowValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportTwoShowValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) BaseSportOnGoingActivity.this.findViewById(R.id.sportTwoShowValue);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportThreeShowValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportThreeShowValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) BaseSportOnGoingActivity.this.findViewById(R.id.sportThreeShowValue);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportFourShowValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportFourShowValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) BaseSportOnGoingActivity.this.findViewById(R.id.sportFourShowValue);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportOneShowValueDesc$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportOneShowValueDesc$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BaseSportOnGoingActivity.this.findViewById(R.id.sportOneShowValueDesc);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportTwoShowValueDesc$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportTwoShowValueDesc$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BaseSportOnGoingActivity.this.findViewById(R.id.sportTwoShowValueDesc);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportThreeShowValueDesc$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportThreeShowValueDesc$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BaseSportOnGoingActivity.this.findViewById(R.id.sportThreeShowValueDesc);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportFourShowValueDesc$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportFourShowValueDesc$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BaseSportOnGoingActivity.this.findViewById(R.id.sportFourShowValueDesc);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportEndProgress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SportEndProgress>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportEndProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SportEndProgress invoke() {
            return (SportEndProgress) BaseSportOnGoingActivity.this.findViewById(R.id.sportEndProgress);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mapPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$mapPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.fl_map);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportRunPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportRunPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.sportRunPanel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportPausePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportPausePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.sportPausePanel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO screenLockRl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$screenLockRl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) BaseSportOnGoingActivity.this.findViewById(R.id.screenLockRl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO slideLockView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SlideLockView>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$slideLockView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SlideLockView invoke() {
            return (SlideLockView) BaseSportOnGoingActivity.this.findViewById(R.id.slideLockView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportDataLL$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportDataLL$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.sportDataLl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportOnGoingFl$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportOnGoingFl$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.sportOnGoingFl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cardPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CardView>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$cardPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CardView invoke() {
            return (CardView) BaseSportOnGoingActivity.this.findViewById(R.id.cardPanel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cardPanelSub$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$cardPanelSub$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) BaseSportOnGoingActivity.this.findViewById(R.id.cardPanelSub);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO handleView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$handleView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.fl_handle);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO statuesPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$statuesPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) BaseSportOnGoingActivity.this.findViewById(R.id.status_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivGpsSignal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$ivGpsSignal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BaseSportOnGoingActivity.this.findViewById(R.id.ivGpsSignal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportModelName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$sportModelName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) BaseSportOnGoingActivity.this.findViewById(R.id.sportModelName);
        }
    });

    /* loaded from: classes12.dex */
    public static final class I0Io implements SportEndProgress.oIX0oI {
        public I0Io() {
        }

        @Override // com.sma.smartv3.view.SportEndProgress.oIX0oI
        public void end() {
            BaseSportOnGoingActivity.this.stopSport(true);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0XooXoX extends CountDownTimer {
        public II0XooXoX() {
            super(4000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            VibrateUtils.vibrate(200L);
            BaseSportOnGoingActivity.this.startSport();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String str;
            if (BaseSportOnGoingActivity.this.getCountdownTv().isShown()) {
                long j2 = j / 1000;
                DINCondBold countdownTv = BaseSportOnGoingActivity.this.getCountdownTv();
                if (j2 > 0) {
                    str = String.valueOf(j2);
                } else {
                    SportManager.Xo0(SportManager.f23843oIX0oI, BaseSportOnGoingActivity.this.getMArg1(), false, BaseSportOnGoingActivity.this.goals[0], BaseSportOnGoingActivity.this.goals[1], BaseSportOnGoingActivity.this.goals[2], 2, null);
                    str = "GO";
                }
                countdownTv.setText(str);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements SportEndProgress.II0xO0 {
        public II0xO0() {
        }

        @Override // com.sma.smartv3.view.SportEndProgress.II0xO0
        public void start(boolean z) {
            if (z) {
                BaseSportOnGoingActivity.this.showLongPressTip();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class Oxx0IOOO implements CustomGoogleMapView.oIX0oI {
        public Oxx0IOOO() {
        }

        @Override // com.sma.smartv3.view.CustomGoogleMapView.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo MotionEvent motionEvent) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(motionEvent, "motionEvent");
            if (motionEvent.getAction() == 1) {
                BaseSportOnGoingActivity.this.getSportProcess().requestDisallowInterceptTouchEvent(false);
            } else {
                BaseSportOnGoingActivity.this.getSportProcess().requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo extends AnchorBottomSheetBehavior.II0xO0 {
        public X0o0xo() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        
            if (r3 != 5) goto L11;
         */
        @Override // com.sma.smartv3.view.AnchorBottomSheetBehavior.II0xO0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void II0xO0(@OXOo.OOXIXo android.view.View r2, int r3) {
            /*
                r1 = this;
                java.lang.String r0 = "bottomSheet"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                r2 = 3
                r0 = 1
                if (r3 == r2) goto L35
                r2 = 4
                if (r3 == r2) goto L10
                r2 = 5
                if (r3 == r2) goto L35
                goto L5b
            L10:
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                androidx.cardview.widget.CardView r2 = r2.getCardPanel()
                r3 = 0
                int r3 = com.blankj.utilcode.util.SizeUtils.dp2px(r3)
                float r3 = (float) r3
                r2.setRadius(r3)
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                android.view.ViewGroup r2 = r2.getStatuesPanel()
                r3 = 0
                r2.setVisibility(r3)
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                com.sma.smartv3.view.text.DINCondBold r2 = r2.getSportOneShowValue()
                r3 = 1116471296(0x428c0000, float:70.0)
                r2.setTextSize(r0, r3)
                goto L5b
            L35:
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                androidx.cardview.widget.CardView r2 = r2.getCardPanel()
                r3 = 1101004800(0x41a00000, float:20.0)
                int r3 = com.blankj.utilcode.util.SizeUtils.dp2px(r3)
                float r3 = (float) r3
                r2.setRadius(r3)
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                android.view.ViewGroup r2 = r2.getStatuesPanel()
                r3 = 8
                r2.setVisibility(r3)
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                com.sma.smartv3.view.text.DINCondBold r2 = r2.getSportOneShowValue()
                r3 = 1113325568(0x425c0000, float:55.0)
                r2.setTextSize(r0, r3)
            L5b:
                com.sma.smartv3.ui.sport.BaseSportOnGoingActivity r2 = com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.this
                com.sma.smartv3.view.CustomNestedScollView r2 = r2.getSportProcess()
                r2.requestLayout()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity.X0o0xo.II0xO0(android.view.View, int):void");
        }

        @Override // com.sma.smartv3.view.AnchorBottomSheetBehavior.II0xO0
        public void oIX0oI(@OXOo.OOXIXo View bottomSheet, float f) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(bottomSheet, "bottomSheet");
            AnchorBottomSheetBehavior anchorBottomSheetBehavior = BaseSportOnGoingActivity.this.behavior;
            AnchorBottomSheetBehavior anchorBottomSheetBehavior2 = null;
            if (anchorBottomSheetBehavior == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
                anchorBottomSheetBehavior = null;
            }
            float peekHeight = anchorBottomSheetBehavior.getPeekHeight();
            int height = BaseSportOnGoingActivity.this.getRootView().getHeight();
            AnchorBottomSheetBehavior anchorBottomSheetBehavior3 = BaseSportOnGoingActivity.this.behavior;
            if (anchorBottomSheetBehavior3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
            } else {
                anchorBottomSheetBehavior2 = anchorBottomSheetBehavior3;
            }
            float peekHeight2 = peekHeight + ((height - anchorBottomSheetBehavior2.getPeekHeight()) * f);
            if (peekHeight2 > BaseSportOnGoingActivity.this.cardPanelSubMinHeight) {
                RelativeLayout cardPanelSub = BaseSportOnGoingActivity.this.getCardPanelSub();
                kotlin.jvm.internal.IIX0o.oO(cardPanelSub, "<get-cardPanelSub>(...)");
                LibExKt.oOo(cardPanelSub, (int) peekHeight2);
            } else {
                RelativeLayout cardPanelSub2 = BaseSportOnGoingActivity.this.getCardPanelSub();
                kotlin.jvm.internal.IIX0o.oO(cardPanelSub2, "<get-cardPanelSub>(...)");
                LibExKt.oOo(cardPanelSub2, BaseSportOnGoingActivity.this.cardPanelSubMinHeight);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class XO implements OnMapReadyCallback {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ BaseSportOnGoingActivity f23764II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ CustomGoogleMapView f23765oIX0oI;

        public XO(CustomGoogleMapView customGoogleMapView, BaseSportOnGoingActivity baseSportOnGoingActivity) {
            this.f23765oIX0oI = customGoogleMapView;
            this.f23764II0xO0 = baseSportOnGoingActivity;
        }

        @Override // com.google.android.gms.maps.OnMapReadyCallback
        public void onMapReady(@OXOo.OOXIXo GoogleMap googleMap) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(googleMap, "googleMap");
            MapsInitializer.initialize(this.f23765oIX0oI.getContext());
            this.f23764II0xO0.mGoogleMap = googleMap;
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23767oIX0oI;

        static {
            int[] iArr = new int[SportDataType.values().length];
            try {
                iArr[SportDataType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SportDataType.DISTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SportDataType.PACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SportDataType.CALORIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SportDataType.STEP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SportDataType.SPM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SportDataType.ALTITUDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SportDataType.HEARTRATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SportDataType.SPEED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f23767oIX0oI = iArr;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements SlideLockView.I0Io {
        public oxoX() {
        }

        @Override // com.sma.smartv3.view.SlideLockView.I0Io
        public void oIX0oI() {
            BaseSportOnGoingActivity.this.getSlideLockView().xoXoI();
            BaseSportOnGoingActivity.this.getSportRunPanel().setVisibility(0);
            BaseSportOnGoingActivity.this.getScreenLockRl().setVisibility(4);
            if (SportManager.f23843oIX0oI.XIxXXX0x0() != 3) {
                BaseSportOnGoingActivity.this.enableBottomSheet();
            }
        }
    }

    public BaseSportOnGoingActivity() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mGMapView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomGoogleMapView>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$mGMapView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final CustomGoogleMapView invoke() {
                return (CustomGoogleMapView) BaseSportOnGoingActivity.this.findViewById(R.id.gMapView);
            }
        });
        this.mBMapView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextureMapView>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$mBMapView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextureMapView invoke() {
                return (TextureMapView) BaseSportOnGoingActivity.this.findViewById(R.id.bMapView);
            }
        });
        this.isInChinaMainland = xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO, false);
        this.mBaiduPoints = new ArrayList();
        this.mGooglePoints = new ArrayList();
        this.goals = new int[3];
        this.mSportCallback$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BaseSportOnGoingActivity$mSportCallback$2.oIX0oI>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$mSportCallback$2

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements SportManager.oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ BaseSportOnGoingActivity f23766oIX0oI;

                public oIX0oI(BaseSportOnGoingActivity baseSportOnGoingActivity) {
                    this.f23766oIX0oI = baseSportOnGoingActivity;
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void I0Io(boolean z) {
                    SportManager.oIX0oI.C0990oIX0oI.oIX0oI(this, z);
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void II0xO0(@OXOo.OOXIXo BleAppSportState sportState) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(sportState, "sportState");
                    this.f23766oIX0oI.handleSportState(sportState.getMState());
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void X0o0xo(@OXOo.OOXIXo SportData sportData) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(sportData, "sportData");
                    this.f23766oIX0oI.updateShowData(sportData);
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void oIX0oI(int i) {
                    try {
                        this.f23766oIX0oI.showGoalDoneDialog(i);
                    } catch (Exception e) {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BaseSportOnGoingActivity  onGoalDone  showGoalDoneDialog try Exception = " + e);
                    }
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void oxoX(@OXOo.OOXIXo Location location) {
                    boolean z;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
                    BaseSportOnGoingActivity baseSportOnGoingActivity = this.f23766oIX0oI;
                    z = baseSportOnGoingActivity.isInChinaMainland;
                    baseSportOnGoingActivity.updateMap(z, location);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final oIX0oI invoke() {
                return new oIX0oI(BaseSportOnGoingActivity.this);
            }
        });
    }

    private final Overlay createBaiduIcon(int i, LatLng latLng, boolean z) {
        BaiduMap baiduMap = this.mBaiDuMap;
        if (baiduMap == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mBaiDuMap");
            baiduMap = null;
        }
        MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(i)).draggable(false).flat(true).zIndex(9);
        if (z) {
            zIndex.anchor(0.5f, 0.5f);
        }
        Overlay addOverlay = baiduMap.addOverlay(zIndex);
        kotlin.jvm.internal.IIX0o.oO(addOverlay, "addOverlay(...)");
        return addOverlay;
    }

    public static /* synthetic */ Overlay createBaiduIcon$default(BaseSportOnGoingActivity baseSportOnGoingActivity, int i, LatLng latLng, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return baseSportOnGoingActivity.createBaiduIcon(i, latLng, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBaiduIcon");
    }

    private final void disableBottomSheet() {
        getSportProcess().setNestedScrollingEnabled(false);
        getSportProcess().disableNestedInterceptTouchEvent(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableBottomSheet() {
        if (ProductManager.f20544oIX0oI.IXxOIOO(getMArg1())) {
            getSportProcess().setNestedScrollingEnabled(true);
            getSportProcess().disableNestedInterceptTouchEvent(false);
        } else {
            disableBottomSheet();
        }
    }

    private final TextureMapView getMBMapView() {
        return (TextureMapView) this.mBMapView$delegate.getValue();
    }

    private final CustomGoogleMapView getMGMapView() {
        return (CustomGoogleMapView) this.mGMapView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseSportOnGoingActivity$mSportCallback$2.oIX0oI getMSportCallback() {
        return (BaseSportOnGoingActivity$mSportCallback$2.oIX0oI) this.mSportCallback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSportState(int i) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("handleSportState -> " + i);
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i == 4) {
                    stopSport(false);
                    return;
                }
                return;
            } else {
                getSportPause().setVisibility(4);
                getSportPausePanel().setVisibility(0);
                disableBottomSheet();
                return;
            }
        }
        getSportPause().setVisibility(0);
        getSportPausePanel().setVisibility(4);
        enableBottomSheet();
        PopupWindow popupWindow = this.mLongPressPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BaseSportOnGoingActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        SportManager sportManager = SportManager.f23843oIX0oI;
        int mArg1 = this$0.getMArg1();
        int[] iArr = this$0.goals;
        SportManager.Xo0(sportManager, mArg1, false, iArr[0], iArr[1], iArr[2], 2, null);
        this$0.startSport();
    }

    private final void showBaiDuMap() {
        getMBMapView().setVisibility(0);
        TextureMapView mBMapView = getMBMapView();
        mBMapView.showZoomControls(false);
        mBMapView.showScaleControl(false);
        BaiduMap map = getMBMapView().getMap();
        map.setCompassEnable(false);
        kotlin.jvm.internal.IIX0o.oO(map, "apply(...)");
        this.mBaiDuMap = map;
        map.setOnMapTouchListener(new BaiduMap.OnMapTouchListener() { // from class: com.sma.smartv3.ui.sport.ooOOo0oXI
            @Override // com.baidu.mapapi.map.BaiduMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                BaseSportOnGoingActivity.showBaiDuMap$lambda$8(BaseSportOnGoingActivity.this, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaiDuMap$lambda$8(BaseSportOnGoingActivity this$0, MotionEvent motionEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            CustomNestedScollView sportProcess = this$0.getSportProcess();
            if (sportProcess != null) {
                sportProcess.requestDisallowInterceptTouchEvent(false);
                return;
            }
            return;
        }
        CustomNestedScollView sportProcess2 = this$0.getSportProcess();
        if (sportProcess2 != null) {
            sportProcess2.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGoalDoneDialog(int i) {
        int i2;
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_goal_done_dg, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_goal_done);
        SportManager sportManager = SportManager.f23843oIX0oI;
        if (i == sportManager.Oxx0xo()) {
            i2 = R.drawable.time_done_img;
        } else if (i == sportManager.Oo()) {
            i2 = R.drawable.calories_done_img;
        } else {
            i2 = R.drawable.distance_done_img;
        }
        imageView.setImageResource(i2);
        Dialog dialog = new Dialog(this, R.style.AppDialogTheme);
        dialog.setContentView(inflate);
        dialog.show();
    }

    private final void showGoogleMap() {
        CustomGoogleMapView mGMapView = getMGMapView();
        mGMapView.setVisibility(0);
        mGMapView.onCreate(null);
        mGMapView.getMapAsync(new XO(mGMapView, this));
        mGMapView.setOnMapTouchListener(new Oxx0IOOO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLongPressTip() {
        PopupWindow popupWindow = this.mLongPressPopup;
        if (popupWindow != null && popupWindow.isShowing()) {
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_bubble, (ViewGroup) null);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(inflate, "null cannot be cast to non-null type com.sma.smartv3.view.bubbleview.BubbleLayout");
        BubbleLayout bubbleLayout = (BubbleLayout) inflate;
        bubbleLayout.measure(0, 0);
        ((TextView) bubbleLayout.findViewById(R.id.tv)).setText(R.string.long_press_end);
        bubbleLayout.requestLayout();
        this.mLongPressPopup = OxO.II0xO0.oIX0oI(getMContext(), bubbleLayout);
        bubbleLayout.X0o0xo(ArrowDirection.BOTTOM);
        PopupWindow popupWindow2 = this.mLongPressPopup;
        if (popupWindow2 != null) {
            popupWindow2.setOutsideTouchable(false);
        }
        int measuredWidth = (getSportEndProgress().getMeasuredWidth() - bubbleLayout.getMeasuredWidth()) / 2;
        int i = -(getSportEndProgress().getMeasuredHeight() + bubbleLayout.getMeasuredHeight() + SizeUtils.dp2px(4.0f));
        bubbleLayout.Oxx0IOOO((bubbleLayout.getMeasuredWidth() - bubbleLayout.getArrowWidth()) / 2.0f);
        PopupWindow popupWindow3 = this.mLongPressPopup;
        if (popupWindow3 != null) {
            popupWindow3.showAsDropDown(getSportEndProgress(), measuredWidth, i);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                BaseSportOnGoingActivity.showLongPressTip$lambda$10(BaseSportOnGoingActivity.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLongPressTip$lambda$10(BaseSportOnGoingActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        PopupWindow popupWindow = this$0.mLongPressPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private final void showMapContent(boolean z) {
        this.isShowMap = true;
        if (z) {
            showBaiDuMap();
        } else {
            showGoogleMap();
        }
    }

    private final Pair<String, String> showOneContent(SportDataType sportDataType, SportData sportData) {
        String str;
        switch (oIX0oI.f23767oIX0oI[sportDataType.ordinal()]) {
            case 1:
                return new Pair<>(com.sma.smartv3.util.xoIox.IoOoX(sportData.getMDuration() * 1000), getString(R.string.time));
            case 2:
                String valueOf = String.valueOf(TextConvertKt.ooOOo0oXI(sportData.getMDistance(), this.userProfile.getUnit(), false, 4, null));
                if (this.userProfile.getUnit() == 0) {
                    str = getString(R.string.distance) + HexStringBuilder.COMMENT_BEGIN_CHAR + getString(R.string.km) + HexStringBuilder.COMMENT_END_CHAR;
                } else {
                    str = getString(R.string.distance) + HexStringBuilder.COMMENT_BEGIN_CHAR + getString(R.string.mi) + HexStringBuilder.COMMENT_END_CHAR;
                }
                return new Pair<>(valueOf, str);
            case 3:
                return new Pair<>(TextConvertKt.OI0(sportData.getMPace(), this.userProfile.getUnit()), getString(R.string.pace));
            case 4:
                return new Pair<>(String.valueOf(sportData.getMCalorie()), getString(R.string.calories));
            case 5:
                return new Pair<>(String.valueOf(sportData.getMStep()), getString(R.string.steps));
            case 6:
                return new Pair<>(String.valueOf(sportData.getMSpm()), getString(R.string.spm));
            case 7:
                return new Pair<>(String.valueOf(sportData.getMAltitude()), getString(R.string.altitude));
            case 8:
                return new Pair<>(String.valueOf(SportManager.f23843oIX0oI.IIXOooo()), getString(R.string.heart_rate));
            case 9:
                return new Pair<>(String.valueOf(sportData.getMSpeed()), getString(R.string.speed));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void startCountDown() {
        getCountdownRl().setVisibility(0);
        getSportProcess().setVisibility(4);
        new II0XooXoX().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSport() {
        getCountdownRl().setVisibility(8);
        getScreenLockRl().setVisibility(4);
        getSportProcess().setVisibility(0);
        handleSportState(SportManager.f23843oIX0oI.XIxXXX0x0());
        if (ProductManager.f20544oIX0oI.IXxOIOO(getMArg1())) {
            this.cardPanelSubMinHeight = getHandleView().getHeight() + getSportDataLL().getHeight() + getSportOnGoingFl().getHeight();
            AnchorBottomSheetBehavior<CustomNestedScollView> anchorBottomSheetBehavior = this.behavior;
            AnchorBottomSheetBehavior<CustomNestedScollView> anchorBottomSheetBehavior2 = null;
            if (anchorBottomSheetBehavior == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
                anchorBottomSheetBehavior = null;
            }
            anchorBottomSheetBehavior.setAnchorPoint(getRootView().getHeight() - this.cardPanelSubMinHeight);
            AnchorBottomSheetBehavior<CustomNestedScollView> anchorBottomSheetBehavior3 = this.behavior;
            if (anchorBottomSheetBehavior3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
            } else {
                anchorBottomSheetBehavior2 = anchorBottomSheetBehavior3;
            }
            anchorBottomSheetBehavior2.setPeekHeight(this.cardPanelSubMinHeight - getSportOnGoingFl().getHeight());
            RelativeLayout cardPanelSub = getCardPanelSub();
            kotlin.jvm.internal.IIX0o.oO(cardPanelSub, "<get-cardPanelSub>(...)");
            LibExKt.oOo(cardPanelSub, this.cardPanelSubMinHeight);
            ViewGroup.LayoutParams layoutParams = getMapPanel().getLayoutParams();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) layoutParams)).bottomMargin = (getHandleView().getHeight() + getSportDataLL().getHeight()) - SizeUtils.dp2px(20.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSport(boolean z) {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("结束运动 " + z);
        PopupWindow popupWindow = this.mLongPressPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (z && !SportManager.f23843oIX0oI.ooOOo0oXI()) {
            if (this.mSportShortPopup == null) {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
                xoI0Ixx0.IoOoX(R.string.sport_very_short);
                xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.keep_moving), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$stopSport$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        SportManager sportManager = SportManager.f23843oIX0oI;
                        SportManager.OI0(sportManager, false, 1, null);
                        BaseSportOnGoingActivity.this.handleSportState(sportManager.XIxXXX0x0());
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.x0o(R.string.end_exercise, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.BaseSportOnGoingActivity$stopSport$1$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        BaseSportOnGoingActivity$mSportCallback$2.oIX0oI mSportCallback;
                        SportManager sportManager = SportManager.f23843oIX0oI;
                        SportManager.x0xO0oo(sportManager, false, 1, null);
                        mSportCallback = BaseSportOnGoingActivity.this.getMSportCallback();
                        sportManager.x0o(mSportCallback);
                        sportManager.x0XOIxOo();
                        BaseSportOnGoingActivity.this.finish();
                        return Boolean.TRUE;
                    }
                });
                this.mSportShortPopup = xoI0Ixx0;
            }
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mSportShortPopup;
            if (xoI0Ixx02 != null) {
                ViewGroup rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx02.OxxIIOOXO(rootView);
                return;
            }
            return;
        }
        SportManager sportManager = SportManager.f23843oIX0oI;
        SportManager.x0xO0oo(sportManager, false, 1, null);
        if (sportManager.ooOOo0oXI()) {
            sportManager.Io();
        }
        sportManager.x0o(getMSportCallback());
        sportManager.x0XOIxOo();
        oix0oi.oIX0oI("finish SportActivity");
        finish();
    }

    private final void updateBaiduMap() {
        if (SportManager.f23843oIX0oI.o00().isEmpty()) {
            return;
        }
        if (this.mBaiDuMap == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mBaiDuMap");
        }
        LatLng latLng = (LatLng) CollectionsKt___CollectionsKt.O0O0Io00X(this.mBaiduPoints);
        BaiduMap baiduMap = this.mBaiDuMap;
        BaiduMap baiduMap2 = null;
        if (baiduMap == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mBaiDuMap");
            baiduMap = null;
        }
        baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        Overlay overlay = this.mBaiduLineEnd;
        if (overlay != null) {
            overlay.remove();
        }
        this.mBaiduLineEnd = createBaiduIcon(R.drawable.icon_sport_map_end, latLng, true);
        BaiduMap baiduMap3 = this.mBaiDuMap;
        if (baiduMap3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mBaiDuMap");
            baiduMap3 = null;
        }
        baiduMap3.setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
        if (this.mBaiduPoints.size() > 1) {
            Overlay overlay2 = this.mBaiduLine;
            if (overlay2 != null) {
                overlay2.remove();
            }
            PolylineOptions points = new PolylineOptions().width(14).color(ContextCompat.getColor(getMContext(), R.color.colorAccent)).points(this.mBaiduPoints);
            kotlin.jvm.internal.IIX0o.oO(points, "points(...)");
            BaiduMap baiduMap4 = this.mBaiDuMap;
            if (baiduMap4 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mBaiDuMap");
            } else {
                baiduMap2 = baiduMap4;
            }
            this.mBaiduLine = baiduMap2.addOverlay(points);
            Overlay overlay3 = this.mBaiduLineStart;
            if (overlay3 != null) {
                overlay3.remove();
            }
            this.mBaiduLineStart = createBaiduIcon$default(this, R.drawable.icon_sport_map_start, (LatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(this.mBaiduPoints), false, 4, null);
        }
        getMBMapView().setLogoPosition(LogoPosition.logoPostionRightTop);
    }

    private final void updateGoogleMap() {
        GoogleMap googleMap = this.mGoogleMap;
        if (googleMap == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mGoogleMap");
            googleMap = null;
        }
        if (SportManager.f23843oIX0oI.o00().isEmpty()) {
            return;
        }
        com.google.android.gms.maps.model.LatLng latLng = (com.google.android.gms.maps.model.LatLng) CollectionsKt___CollectionsKt.O0O0Io00X(this.mGooglePoints);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
        Marker marker = this.mGoogleLineEnd;
        if (marker != null) {
            marker.remove();
        }
        this.mGoogleLineEnd = googleMap.addMarker(new com.google.android.gms.maps.model.MarkerOptions().position(latLng).anchor(0.5f, 0.5f).icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(R.drawable.icon_sport_map_end)));
        if (this.mGooglePoints.size() > 1) {
            Polyline polyline = this.mGoogleLine;
            if (polyline != null) {
                polyline.remove();
            }
            com.google.android.gms.maps.model.PolylineOptions polylineOptions = new com.google.android.gms.maps.model.PolylineOptions();
            polylineOptions.addAll(this.mGooglePoints);
            polylineOptions.width(14.0f);
            polylineOptions.color(ContextCompat.getColor(getMContext(), R.color.map_track_color));
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            this.mGoogleLine = googleMap.addPolyline(polylineOptions);
            Marker marker2 = this.mGoogleLineStart;
            if (marker2 != null) {
                marker2.remove();
            }
            this.mGoogleLineStart = googleMap.addMarker(new com.google.android.gms.maps.model.MarkerOptions().position((com.google.android.gms.maps.model.LatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(this.mGooglePoints)).icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(R.drawable.icon_sport_map_start)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMap(boolean z, Location location) {
        if (SportManager.f23843oIX0oI.o00().size() == 1) {
            this.mBaiduPoints.clear();
            this.mGooglePoints.clear();
        }
        if (z) {
            this.mBaiduPoints.add(new LatLng(location.getMLatitude(), location.getMLongitude()));
            updateBaiduMap();
            return;
        }
        this.mGooglePoints.add(new com.google.android.gms.maps.model.LatLng(location.getMLatitude(), location.getMLongitude()));
        try {
            updateGoogleMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateShowData(SportData sportData) {
        XIxXXX0x0 xIxXXX0x0 = this.sportDataOrder;
        if (xIxXXX0x0 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
            xIxXXX0x0 = null;
        }
        for (Map.Entry<SportDataType, Integer> entry : xIxXXX0x0.oxoX().entrySet()) {
            SportDataType key = entry.getKey();
            int intValue = entry.getValue().intValue();
            Pair<String, String> showOneContent = showOneContent(key, sportData);
            String component1 = showOneContent.component1();
            String component2 = showOneContent.component2();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue == 4) {
                            getSportFourShowValue().setText(component1);
                            getSportFourShowValueDesc().setText(component2);
                        }
                    } else {
                        getSportThreeShowValue().setText(component1);
                        getSportThreeShowValueDesc().setText(component2);
                    }
                } else {
                    getSportTwoShowValue().setText(component1);
                    getSportTwoShowValueDesc().setText(component2);
                }
            } else {
                getSportOneShowValue().setText(component1);
                getSportOneShowValueDesc().setText(component2);
            }
        }
    }

    public static /* synthetic */ void updateShowData$default(BaseSportOnGoingActivity baseSportOnGoingActivity, SportData sportData, int i, Object obj) {
        BaseSportOnGoingActivity baseSportOnGoingActivity2;
        SportData sportData2;
        if (obj == null) {
            if ((i & 1) != 0) {
                sportData2 = new SportData(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
                baseSportOnGoingActivity2 = baseSportOnGoingActivity;
            } else {
                baseSportOnGoingActivity2 = baseSportOnGoingActivity;
                sportData2 = sportData;
            }
            baseSportOnGoingActivity2.updateShowData(sportData2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateShowData");
    }

    public final void dataFourClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 4);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) SportShowDataSelectActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, x0XOIxOo.f24009oIX0oI);
    }

    public final void dataOneClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) SportShowDataSelectActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, x0XOIxOo.f24009oIX0oI);
    }

    public final void dataThreeClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 3);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) SportShowDataSelectActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, x0XOIxOo.f24009oIX0oI);
    }

    public final void dataTwoClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) SportShowDataSelectActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, x0XOIxOo.f24009oIX0oI);
    }

    public final CardView getCardPanel() {
        return (CardView) this.cardPanel$delegate.getValue();
    }

    public final RelativeLayout getCardPanelSub() {
        return (RelativeLayout) this.cardPanelSub$delegate.getValue();
    }

    public final LinearLayout getCountdownRl() {
        return (LinearLayout) this.countdownRl$delegate.getValue();
    }

    public final DINCondBold getCountdownTv() {
        return (DINCondBold) this.countdownTv$delegate.getValue();
    }

    public final ViewGroup getHandleView() {
        return (ViewGroup) this.handleView$delegate.getValue();
    }

    public final ImageView getIvGpsSignal() {
        return (ImageView) this.ivGpsSignal$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.XoI0Ixx0 getMSportShortPopup() {
        return this.mSportShortPopup;
    }

    public final ViewGroup getMapPanel() {
        return (ViewGroup) this.mapPanel$delegate.getValue();
    }

    public final ViewGroup getRootView() {
        return (ViewGroup) this.rootView$delegate.getValue();
    }

    public final RelativeLayout getScreenLockRl() {
        return (RelativeLayout) this.screenLockRl$delegate.getValue();
    }

    public final SlideLockView getSlideLockView() {
        return (SlideLockView) this.slideLockView$delegate.getValue();
    }

    public final ViewGroup getSportDataLL() {
        return (ViewGroup) this.sportDataLL$delegate.getValue();
    }

    public final SportEndProgress getSportEndProgress() {
        return (SportEndProgress) this.sportEndProgress$delegate.getValue();
    }

    public final DINCondBold getSportFourShowValue() {
        return (DINCondBold) this.sportFourShowValue$delegate.getValue();
    }

    public final PFMedium getSportFourShowValueDesc() {
        return (PFMedium) this.sportFourShowValueDesc$delegate.getValue();
    }

    public final PFMedium getSportModelName() {
        return (PFMedium) this.sportModelName$delegate.getValue();
    }

    public final ViewGroup getSportOnGoingFl() {
        return (ViewGroup) this.sportOnGoingFl$delegate.getValue();
    }

    public final DINCondBold getSportOneShowValue() {
        return (DINCondBold) this.sportOneShowValue$delegate.getValue();
    }

    public final PFMedium getSportOneShowValueDesc() {
        return (PFMedium) this.sportOneShowValueDesc$delegate.getValue();
    }

    public final ImageButton getSportPause() {
        return (ImageButton) this.sportPause$delegate.getValue();
    }

    public final ViewGroup getSportPausePanel() {
        return (ViewGroup) this.sportPausePanel$delegate.getValue();
    }

    public final CustomNestedScollView getSportProcess() {
        return (CustomNestedScollView) this.sportProcess$delegate.getValue();
    }

    public final ViewGroup getSportRunPanel() {
        return (ViewGroup) this.sportRunPanel$delegate.getValue();
    }

    public final ImageButton getSportSet() {
        return (ImageButton) this.sportSet$delegate.getValue();
    }

    public final DINCondBold getSportThreeShowValue() {
        return (DINCondBold) this.sportThreeShowValue$delegate.getValue();
    }

    public final PFMedium getSportThreeShowValueDesc() {
        return (PFMedium) this.sportThreeShowValueDesc$delegate.getValue();
    }

    public final DINCondBold getSportTwoShowValue() {
        return (DINCondBold) this.sportTwoShowValue$delegate.getValue();
    }

    public final PFMedium getSportTwoShowValueDesc() {
        return (PFMedium) this.sportTwoShowValueDesc$delegate.getValue();
    }

    public final ViewGroup getStatuesPanel() {
        return (ViewGroup) this.statuesPanel$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("initView -> mArg3: " + getMArg3());
        SportManager sportManager = SportManager.f23843oIX0oI;
        sportManager.I0X0x0oIo((getMArg3() instanceof BleDeviceSportData) ^ true);
        if (getMArg3() instanceof int[]) {
            Object mArg3 = getMArg3();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type kotlin.IntArray");
            this.goals = (int[]) mArg3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initView -> goals: ");
        String arrays = Arrays.toString(this.goals);
        kotlin.jvm.internal.IIX0o.oO(arrays, "toString(...)");
        sb.append(arrays);
        sb.append(", isStartFromApp: ");
        sb.append(sportManager.IoOoX());
        oix0oi.oIX0oI(sb.toString());
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        String valueOf = String.valueOf(getMArg1());
        Object xIxXXX0x0 = new XIxXXX0x0(null, 1, null);
        Object fromJson = new Gson().fromJson(XO2.getString(valueOf + '_' + XIxXXX0x0.class.getName()), (Class<Object>) XIxXXX0x0.class);
        if (fromJson != null) {
            xIxXXX0x0 = fromJson;
        }
        this.sportDataOrder = (XIxXXX0x0) xIxXXX0x0;
        getRootView().setKeepScreenOn(xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24388OO));
        getSportEndProgress().XO(new II0xO0());
        getSportEndProgress().I0Io(new I0Io());
        getSlideLockView().Oo(new oxoX());
        AnchorBottomSheetBehavior<CustomNestedScollView> from = AnchorBottomSheetBehavior.from(getSportProcess());
        kotlin.jvm.internal.IIX0o.oO(from, "from(...)");
        this.behavior = from;
        if (from == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
            from = null;
        }
        from.setHideable(false);
        AnchorBottomSheetBehavior<CustomNestedScollView> anchorBottomSheetBehavior = this.behavior;
        if (anchorBottomSheetBehavior == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
            anchorBottomSheetBehavior = null;
        }
        anchorBottomSheetBehavior.addBottomSheetCallback(new X0o0xo());
        PFMedium sportModelName = getSportModelName();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sportModelName.setText(productManager.xIXX(getMArg1()));
        if (productManager.IXxOIOO(getMArg1())) {
            AnchorBottomSheetBehavior<CustomNestedScollView> anchorBottomSheetBehavior2 = this.behavior;
            if (anchorBottomSheetBehavior2 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
                anchorBottomSheetBehavior2 = null;
            }
            anchorBottomSheetBehavior2.setState(3);
            showMapContent(this.isInChinaMainland);
            com.sma.smartv3.location.oIX0oI ooOOo0oXI2 = UtilsKt.ooOOo0oXI();
            if (ooOOo0oXI2.oIX0oI() != XIXIX.OOXIXo.f3760XO && ooOOo0oXI2.I0Io() != XIXIX.OOXIXo.f3760XO) {
                updateMap(this.isInChinaMainland, new Location(0, 0L, null, 0, 0, (float) ooOOo0oXI2.I0Io(), (float) ooOOo0oXI2.II0xO0(), 0, 0, 0, 927, null));
            }
        } else {
            getHandleView().setVisibility(4);
            getStatuesPanel().setVisibility(0);
            getSportOneShowValue().setTextSize(1, 100.0f);
            AnchorBottomSheetBehavior<CustomNestedScollView> anchorBottomSheetBehavior3 = this.behavior;
            if (anchorBottomSheetBehavior3 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("behavior");
                anchorBottomSheetBehavior3 = null;
            }
            anchorBottomSheetBehavior3.setState(4);
            getCardPanel().setRadius(SizeUtils.dp2px(0.0f));
            disableBottomSheet();
        }
        OOXIXo.oxoX.xxIXOIIO(this).ooOOo0oXI();
        if (sportManager.IoOoX()) {
            startCountDown();
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.oOoXoXO
                @Override // java.lang.Runnable
                public final void run() {
                    BaseSportOnGoingActivity.initView$lambda$1(BaseSportOnGoingActivity.this);
                }
            }, 500L);
        }
        updateShowData$default(this, null, 1, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_on_going;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtils.d(Integer.valueOf(i));
        if (8564 == i) {
            SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
            String valueOf = String.valueOf(getMArg1());
            XIxXXX0x0 xIxXXX0x0 = null;
            Object xIxXXX0x02 = new XIxXXX0x0(null, 1, null);
            Object fromJson = new Gson().fromJson(XO2.getString(valueOf + '_' + XIxXXX0x0.class.getName()), (Class<Object>) XIxXXX0x0.class);
            if (fromJson != null) {
                xIxXXX0x02 = fromJson;
            }
            XIxXXX0x0 xIxXXX0x03 = (XIxXXX0x0) xIxXXX0x02;
            XIxXXX0x0 xIxXXX0x04 = this.sportDataOrder;
            if (xIxXXX0x04 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
            } else {
                xIxXXX0x0 = xIxXXX0x04;
            }
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(xIxXXX0x0, xIxXXX0x03)) {
                this.sportDataOrder = xIxXXX0x03;
                updateShowData(SportManager.f23843oIX0oI.O0xOxO());
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getScreenLockRl().getVisibility() != 0) {
            SportManager sportManager = SportManager.f23843oIX0oI;
            if (sportManager.oo()) {
                SportManager.xII(sportManager, false, 1, null);
                handleSportState(sportManager.XIxXXX0x0());
            } else if (sportManager.XIxXXX0x0() == 3) {
                showLongPressTip();
            }
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        SportManager sportManager = SportManager.f23843oIX0oI;
        Application application = getApplication();
        kotlin.jvm.internal.IIX0o.oO(application, "getApplication(...)");
        sportManager.IIX0o(application);
        sportManager.oOoXoXO(getMSportCallback());
        sportManager.XX0(true);
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SportManager.f23843oIX0oI.XX0(false);
        if (this.isShowMap) {
            if (this.isInChinaMainland) {
                getMBMapView().onDestroy();
            } else {
                getMGMapView().onDestroy();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.isShowMap) {
            if (this.isInChinaMainland) {
                getMBMapView().onPause();
            } else {
                getMGMapView().onPause();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isShowMap) {
            if (this.isInChinaMainland) {
                getMBMapView().onResume();
            } else {
                getMGMapView().onResume();
            }
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24388OO)
    public final void onScreenOnChanged(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onScreenOnChanged");
        getRootView().setKeepScreenOn(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24388OO));
    }

    public final void setMSportShortPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0) {
        this.mSportShortPopup = xoI0Ixx0;
    }

    public final void sportEndClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
    }

    public final void sportLockClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        disableBottomSheet();
        getSlideLockView().xoXoI();
        getSportRunPanel().setVisibility(4);
        getScreenLockRl().setVisibility(0);
        PopupWindow popupWindow = this.mLongPressPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void sportPauseClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        SportManager sportManager = SportManager.f23843oIX0oI;
        SportManager.xII(sportManager, false, 1, null);
        handleSportState(sportManager.XIxXXX0x0());
    }

    public final void sportResumeClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        SportManager sportManager = SportManager.f23843oIX0oI;
        SportManager.OI0(sportManager, false, 1, null);
        handleSportState(sportManager.XIxXXX0x0());
    }

    public final void sportSetClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) SportSettingActivity.class));
    }
}
