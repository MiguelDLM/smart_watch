package com.sma.smartv3.ui.sport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.HeatMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineDottedLineType;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.StyleSpan;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.gson.Gson;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.model.LocationData;
import com.sma.smartv3.ui.sport.TrackPlay;
import com.sma.smartv3.ui.sport.course.model.SportDetailViewModel;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.CustomGoogleMapView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailMapFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailMapFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailMapFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,991:1\n19#2:992\n15#2:993\n1864#3,3:994\n1864#3,3:997\n1855#3,2:1000\n1855#3,2:1002\n1855#3,2:1004\n1549#3:1006\n1620#3,3:1007\n1855#3,2:1010\n1855#3,2:1012\n1855#3,2:1014\n*S KotlinDebug\n*F\n+ 1 SportDetailMapFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailMapFragment\n*L\n104#1:992\n104#1:993\n193#1:994,3\n216#1:997,3\n357#1:1000,2\n360#1:1002,2\n465#1:1004,2\n664#1:1006\n664#1:1007,3\n742#1:1010,2\n788#1:1012,2\n801#1:1014,2\n*E\n"})
/* loaded from: classes12.dex */
public class SportDetailMapFragment extends BaseFragment {
    private boolean isGradient;
    private final boolean isInChinaMainland;
    private boolean isLocationEmpty;
    private boolean isShowLineMarker;
    private boolean isShowMap;
    protected BaiduMap mBaiDuMap;

    @OXOo.oOoXoXO
    private Polyline mBaiduDottedLine;

    @OXOo.oOoXoXO
    private HeatMap mBaiduHeatMap;

    @OXOo.oOoXoXO
    private Polyline mBaiduLine;

    @OXOo.oOoXoXO
    private Marker mBaiduLineEnd;

    @OXOo.oOoXoXO
    private Marker mBaiduLineStart;

    @OXOo.OOXIXo
    private ArrayList<Integer> mColorList;
    private int mCurrentIcon;

    @OXOo.OOXIXo
    private ArrayList<CustomLatLng> mFinalOriginalLocationList;

    @OXOo.oOoXoXO
    private TileOverlay mGoogleHeatMapOverlay;

    @OXOo.oOoXoXO
    private HeatmapTileProvider mGoogleHeatMapProvider;

    @OXOo.oOoXoXO
    private com.google.android.gms.maps.model.Polyline mGoogleLine;

    @OXOo.oOoXoXO
    private com.google.android.gms.maps.model.Marker mGoogleLineEnd;

    @OXOo.oOoXoXO
    private com.google.android.gms.maps.model.Marker mGoogleLineStart;
    protected GoogleMap mGoogleMap;

    @OXOo.oOoXoXO
    private ArrayList<LatLng> mInitialPoints;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLocationDao$delegate;
    private int mMapLineColor;

    @OXOo.OOXIXo
    private ArrayList<CustomLatLng> mSmoothLocationList;
    private int mStartIcon;

    @OXOo.OOXIXo
    private TrackPlay mTrackPlay;
    public Workout mWorkout;
    private int speedRangeFast;
    private int speedRangeSlow;

    @OXOo.oOoXoXO
    private SportDetailV2Activity sportDetailV2Activity;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDateTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$tvDateTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_dateTime);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDuration$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$tvDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_duration);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgBpmValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$tvAvgBpmValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_avg_bpm_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$tvDistanceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_distance_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$tvDistanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_distance_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCaloriesValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$tvCaloriesValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_calories_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnMapHot$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$btnMapHot$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (CheckBox) mView.findViewById(R.id.btn_map_hot);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnMap3D$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$btnMap3D$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (CheckBox) mView.findViewById(R.id.btn_map_3d);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnMapMark$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$btnMapMark$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (CheckBox) mView.findViewById(R.id.btn_map_mark);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnDownloadGpx$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$btnDownloadGpx$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (CheckBox) mView.findViewById(R.id.downloadGpxIb);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnTrackPlay$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$btnTrackPlay$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_track_play);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGMapView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomGoogleMapView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$mGMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomGoogleMapView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (CustomGoogleMapView) mView.findViewById(R.id.gMapView);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<com.google.android.gms.maps.model.Marker> mGoogleMarkers = new ArrayList<>();

    @OXOo.OOXIXo
    private final ArrayList<com.google.android.gms.maps.model.LatLng> mGooglePoints = new ArrayList<>();

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mBMapView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextureMapView>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$mBMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextureMapView invoke() {
            View mView;
            mView = SportDetailMapFragment.this.getMView();
            return (TextureMapView) mView.findViewById(R.id.bMapView);
        }
    });

    @OXOo.OOXIXo
    private ArrayList<Marker> mBaiduMarkers = new ArrayList<>();

    @OXOo.OOXIXo
    private final ArrayList<LatLng> mBaiduPoints = new ArrayList<>();
    private boolean endMarkerAnchorCenter = true;

    @OXOo.OOXIXo
    private final ArrayList<Integer> mLineColors = new ArrayList<>();

    @OXOo.OOXIXo
    private final List<StyleSpan> mGoogleLineColors = new ArrayList();
    private int mBaiDuMapLineWidth = SizeUtils.dp2px(4.5f);

    @OXOo.OOXIXo
    private final ArrayList<LatLng> mBaiduDottedPoints = new ArrayList<>();

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements OnMapReadyCallback {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ ArrayList<CustomLatLng> f23804II0xO0;

        public II0xO0(ArrayList<CustomLatLng> arrayList) {
            this.f23804II0xO0 = arrayList;
        }

        @Override // com.google.android.gms.maps.OnMapReadyCallback
        public void onMapReady(@OXOo.OOXIXo GoogleMap googleMap) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(googleMap, "googleMap");
            MapsInitializer.initialize(SportDetailMapFragment.this.getMActivity());
            SportDetailMapFragment.this.setMGoogleMap(googleMap);
            ArrayList<CustomLatLng> arrayList = this.f23804II0xO0;
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(com.sma.smartv3.util.IIXOooo.II0xO0(arrayList), com.sma.smartv3.util.xI.II0xO0(arrayList)));
            SportDetailMapFragment.this.addLine();
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TrackPlay.oIX0oI {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void I0Io(float f) {
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void II0xO0() {
            SportDetailMapFragment.this.getBtnMapHot().setEnabled(true);
            SportDetailMapFragment.this.getBtnMapMark().setEnabled(true);
            SportDetailMapFragment.this.getMColorList().clear();
            SportDetailMapFragment.this.getMColorList().addAll(SportDetailMapFragment.this.getMLineColors());
            SportDetailMapFragment.this.addLine();
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<com.google.android.gms.maps.model.LatLng> points, float f) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
            if (points.size() > 1) {
                SportDetailMapFragment.this.addGoogleLine(points);
            }
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void onStart() {
            SportDetailMapFragment.this.getBtnMapHot().setEnabled(false);
            SportDetailMapFragment.this.getBtnMapMark().setEnabled(false);
            SportDetailMapFragment.this.getMColorList().clear();
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void oxoX(@OXOo.OOXIXo ArrayList<LatLng> points, float f, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
            SportDetailMapFragment.this.getMColorList().add(Integer.valueOf(i));
            if (points.size() > 1) {
                SportDetailMapFragment.this.addBaiduLine(points);
            }
        }
    }

    public SportDetailMapFragment() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mLocationDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailMapFragment$mLocationDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final LocationDao invoke() {
                return MyDb.INSTANCE.getMDatabase().locationDao();
            }
        });
        this.isInChinaMainland = xo0.oIX0oI().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24367IXxxXO, false);
        this.mSmoothLocationList = new ArrayList<>();
        this.mFinalOriginalLocationList = new ArrayList<>();
        this.mStartIcon = R.drawable.icon_sport_map_start;
        this.mCurrentIcon = R.drawable.icon_sport_map_end;
        this.isShowLineMarker = true;
        this.mMapLineColor = R.color.map_track_color;
        this.mColorList = new ArrayList<>();
        this.mTrackPlay = new TrackPlay(new oIX0oI());
        this.isLocationEmpty = true;
    }

    private final void addBaiduDottedLine(ArrayList<LatLng> arrayList) {
        PolylineOptions points = new PolylineOptions().width(this.mBaiDuMapLineWidth).color(ContextCompat.getColor(requireContext(), this.mMapLineColor)).dottedLine(true).dottedLineType(PolylineDottedLineType.DOTTED_LINE_CIRCLE).zIndex(2).points(arrayList);
        kotlin.jvm.internal.IIX0o.oO(points, "points(...)");
        Overlay addOverlay = getMBaiDuMap().addOverlay(points);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(addOverlay, "null cannot be cast to non-null type com.baidu.mapapi.map.Polyline");
        this.mBaiduDottedLine = (Polyline) addOverlay;
    }

    private final void addBaiduMarkView(ArrayList<CustomLatLng> arrayList) {
        this.mBaiduMarkers.clear();
        Context requireContext = requireContext();
        kotlin.jvm.internal.IIX0o.oO(requireContext, "requireContext(...)");
        com.sma.smartv3.util.o0xxxXXxX o0xxxxxxx = new com.sma.smartv3.util.o0xxxXXxX(requireContext, R.layout.map_markers_text);
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            CustomLatLng customLatLng = (CustomLatLng) obj;
            Overlay addOverlay = getMBaiDuMap().addOverlay(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(o0xxxxxxx.II0xO0(String.valueOf(i2)))).zIndex(9).position(new LatLng(customLatLng.getLatitude(), customLatLng.getLongitude())));
            kotlin.jvm.internal.IIX0o.x0XOIxOo(addOverlay, "null cannot be cast to non-null type com.baidu.mapapi.map.Marker");
            this.mBaiduMarkers.add((Marker) addOverlay);
            i = i2;
        }
    }

    private final void addGoogleMarkView(ArrayList<CustomLatLng> arrayList) {
        this.mGoogleMarkers.clear();
        Context requireContext = requireContext();
        kotlin.jvm.internal.IIX0o.oO(requireContext, "requireContext(...)");
        com.sma.smartv3.util.o0xxxXXxX o0xxxxxxx = new com.sma.smartv3.util.o0xxxXXxX(requireContext, R.layout.map_markers_text);
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            CustomLatLng customLatLng = (CustomLatLng) obj;
            com.google.android.gms.maps.model.MarkerOptions position = new com.google.android.gms.maps.model.MarkerOptions().icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(o0xxxxxxx.II0xO0(String.valueOf(i2)))).zIndex(9.0f).position(new com.google.android.gms.maps.model.LatLng(customLatLng.getLatitude(), customLatLng.getLongitude()));
            kotlin.jvm.internal.IIX0o.oO(position, "position(...)");
            com.google.android.gms.maps.model.Marker addMarker = getMGoogleMap().addMarker(position);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(addMarker);
            this.mGoogleMarkers.add(addMarker);
            i = i2;
        }
    }

    private final void calculateModeSpeed() {
        LogUtils.d("calculateModeSpeed  mode = " + getMWorkout().getMMode());
        int mMode = getMWorkout().getMMode();
        if (mMode != 12) {
            if (mMode != 13) {
                if (mMode != 19) {
                    if (mMode != 50) {
                        switch (mMode) {
                            case 7:
                            case 8:
                                XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
                                this.speedRangeSlow = xIo0oOXIx.II0xO0(3600, 8000);
                                this.speedRangeFast = xIo0oOXIx.II0xO0(3600, 10000);
                                return;
                            case 9:
                                XIo0oOXIx xIo0oOXIx2 = XIo0oOXIx.f23889oIX0oI;
                                this.speedRangeSlow = xIo0oOXIx2.II0xO0(3600, 3000);
                                this.speedRangeFast = xIo0oOXIx2.II0xO0(3600, 6000);
                                return;
                            case 10:
                                XIo0oOXIx xIo0oOXIx3 = XIo0oOXIx.f23889oIX0oI;
                                this.speedRangeSlow = xIo0oOXIx3.II0xO0(3600, 15000);
                                this.speedRangeFast = xIo0oOXIx3.II0xO0(3600, ErrorCode.ERROR_AIMIC_BASE);
                                return;
                            default:
                                return;
                        }
                    }
                    XIo0oOXIx xIo0oOXIx4 = XIo0oOXIx.f23889oIX0oI;
                    this.speedRangeSlow = xIo0oOXIx4.II0xO0(3600, 3000);
                    this.speedRangeFast = xIo0oOXIx4.II0xO0(3600, 6000);
                    return;
                }
                XIo0oOXIx xIo0oOXIx5 = XIo0oOXIx.f23889oIX0oI;
                this.speedRangeSlow = xIo0oOXIx5.II0xO0(3600, 10000);
                this.speedRangeFast = xIo0oOXIx5.II0xO0(3600, ErrorCode.MSP_ERROR_ISV_NO_USER);
                return;
            }
            XIo0oOXIx xIo0oOXIx6 = XIo0oOXIx.f23889oIX0oI;
            this.speedRangeSlow = xIo0oOXIx6.II0xO0(3600, 3000);
            this.speedRangeFast = xIo0oOXIx6.II0xO0(3600, 5000);
            return;
        }
        XIo0oOXIx xIo0oOXIx7 = XIo0oOXIx.f23889oIX0oI;
        this.speedRangeSlow = xIo0oOXIx7.II0xO0(3600, 4000);
        this.speedRangeFast = xIo0oOXIx7.II0xO0(3600, 7000);
    }

    private final void calculateSpeedColor(int i, int i2, int i3, CustomLatLng customLatLng, ArrayList<CustomLatLng> arrayList) {
        int speedColorV2;
        if (this.speedRangeSlow == 0 && this.speedRangeFast == 0) {
            speedColorV2 = speedColorV1(i, i2, i3);
        } else {
            speedColorV2 = speedColorV2(i3);
        }
        arrayList.add(customLatLng);
        Iterator<CustomLatLng> it = arrayList.iterator();
        while (it.hasNext()) {
            CustomLatLng next = it.next();
            this.mLineColors.add(Integer.valueOf(speedColorV2));
            next.setColor(speedColorV2);
        }
        arrayList.clear();
    }

    private final Overlay createBaiduIcon(int i, LatLng latLng, boolean z) {
        BaiduMap mBaiDuMap = getMBaiDuMap();
        MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(i)).draggable(false).flat(true).zIndex(9);
        if (z && this.endMarkerAnchorCenter) {
            zIndex.anchor(0.5f, 0.5f);
        }
        Overlay addOverlay = mBaiDuMap.addOverlay(zIndex);
        kotlin.jvm.internal.IIX0o.oO(addOverlay, "addOverlay(...)");
        return addOverlay;
    }

    public static /* synthetic */ Overlay createBaiduIcon$default(SportDetailMapFragment sportDetailMapFragment, int i, LatLng latLng, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return sportDetailMapFragment.createBaiduIcon(i, latLng, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBaiduIcon");
    }

    private final CheckBox getBtnDownloadGpx() {
        return (CheckBox) this.btnDownloadGpx$delegate.getValue();
    }

    private final CheckBox getBtnMap3D() {
        return (CheckBox) this.btnMap3D$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox getBtnMapHot() {
        return (CheckBox) this.btnMapHot$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox getBtnMapMark() {
        return (CheckBox) this.btnMapMark$delegate.getValue();
    }

    private final void getGradientLineColors(ArrayList<CustomLatLng> arrayList) {
        int i;
        SportDetailMapFragment sportDetailMapFragment;
        int i2;
        CustomLatLng customLatLng;
        int i3;
        SportDetailMapFragment sportDetailMapFragment2 = this;
        ArrayList<CustomLatLng> arrayList2 = arrayList;
        CustomLatLng customLatLng2 = new CustomLatLng(arrayList2.get(0).getLatitude(), arrayList2.get(0).getLongitude(), arrayList2.get(0).getTime(), arrayList2.get(0).getAltitude(), 0, 16, null);
        long time = customLatLng2.getTime();
        if (getMWorkout().getMDistance() > 1000) {
            i = 300;
        } else {
            i = 20;
        }
        ArrayList<CustomLatLng> arrayList3 = new ArrayList<>();
        int size = arrayList.size();
        float f = 0.0f;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            CustomLatLng customLatLng3 = arrayList2.get(i5);
            kotlin.jvm.internal.IIX0o.oO(customLatLng3, "get(...)");
            CustomLatLng customLatLng4 = customLatLng3;
            if (customLatLng4.getLatitude() == customLatLng2.getLatitude() && customLatLng4.getLongitude() == customLatLng2.getLongitude()) {
                arrayList3.add(customLatLng4);
                sportDetailMapFragment = sportDetailMapFragment2;
                i3 = 1;
                customLatLng = customLatLng2;
            } else {
                long j = time;
                f += oOIx.oxoX.IIX0(DistanceUtil.getDistance(new LatLng(customLatLng2.getLatitude(), customLatLng2.getLongitude()), new LatLng(customLatLng4.getLatitude(), customLatLng4.getLongitude())) * 100) / 100.0f;
                if (f < i && i5 != arrayList.size() - 1) {
                    arrayList3.add(customLatLng4);
                    sportDetailMapFragment = this;
                    customLatLng = customLatLng2;
                    time = j;
                } else {
                    long abs = Math.abs(customLatLng4.getTime() - j) / 1000;
                    int II0xO02 = XIo0oOXIx.f23889oIX0oI.II0xO0((int) abs, (int) f);
                    StringBuilder sb = new StringBuilder();
                    sb.append("getGradientLineColors distance = ");
                    sb.append(f);
                    sb.append("  intervalTime = ");
                    sb.append(abs);
                    sb.append("  secondSpeed = ");
                    sb.append(II0xO02);
                    sb.append("  speedRangeFast = ");
                    sportDetailMapFragment = this;
                    sb.append(sportDetailMapFragment.speedRangeFast);
                    sb.append("  , speedRangeSlow = ");
                    sb.append(sportDetailMapFragment.speedRangeSlow);
                    LogUtils.d(sb.toString());
                    if (II0xO02 < i6 || i6 == 0) {
                        i6 = II0xO02;
                    }
                    if (II0xO02 > i4) {
                        i2 = II0xO02;
                    } else {
                        i2 = i4;
                    }
                    customLatLng = customLatLng2;
                    calculateSpeedColor(i2, i6, II0xO02, customLatLng4, arrayList3);
                    time = customLatLng4.getTime();
                    i4 = i2;
                    f = 0.0f;
                }
                customLatLng.setLatitude(customLatLng4.getLatitude());
                customLatLng.setLongitude(customLatLng4.getLongitude());
                customLatLng.setTime(customLatLng4.getTime());
                customLatLng.setAltitude(customLatLng4.getAltitude());
                i3 = 1;
            }
            i5 += i3;
            arrayList2 = arrayList;
            customLatLng2 = customLatLng;
            sportDetailMapFragment2 = sportDetailMapFragment;
        }
        SportDetailMapFragment sportDetailMapFragment3 = sportDetailMapFragment2;
        if (sportDetailMapFragment3.isGradient && sportDetailMapFragment3.mLineColors.size() == 0 && arrayList3.size() > 0) {
            for (CustomLatLng customLatLng5 : arrayList3) {
                sportDetailMapFragment3.mLineColors.add(Integer.valueOf(ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_startColor)));
            }
        }
    }

    private final void getIntiLocationList() {
        SportDetailViewModel mSportViewModel;
        SportDetailV2Activity sportDetailV2Activity = this.sportDetailV2Activity;
        if (sportDetailV2Activity != null && (mSportViewModel = sportDetailV2Activity.getMSportViewModel()) != null) {
            mSportViewModel.getIntiLocationList(this.mSmoothLocationList, this.userProfile.getUnit());
        }
    }

    private final LocationDao getMLocationDao() {
        return (LocationDao) this.mLocationDao$delegate.getValue();
    }

    private final void getMarkersData() {
        SportDetailViewModel mSportViewModel;
        SportDetailV2Activity sportDetailV2Activity = this.sportDetailV2Activity;
        if (sportDetailV2Activity != null && (mSportViewModel = sportDetailV2Activity.getMSportViewModel()) != null) {
            mSportViewModel.getMarkList(this.mSmoothLocationList, this.userProfile.getUnit());
        }
    }

    private final void getSportDetailActivity() {
        if (getActivity() instanceof SportDetailV2Activity) {
            FragmentActivity activity = getActivity();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(activity, "null cannot be cast to non-null type com.sma.smartv3.ui.sport.SportDetailV2Activity");
            this.sportDetailV2Activity = (SportDetailV2Activity) activity;
        }
    }

    private final TextView getTvAvgBpmValue() {
        return (TextView) this.tvAvgBpmValue$delegate.getValue();
    }

    private final TextView getTvCaloriesValue() {
        return (TextView) this.tvCaloriesValue$delegate.getValue();
    }

    private final TextView getTvDistanceUnit() {
        return (TextView) this.tvDistanceUnit$delegate.getValue();
    }

    private final TextView getTvDistanceValue() {
        return (TextView) this.tvDistanceValue$delegate.getValue();
    }

    private final TextView getTvDuration() {
        return (TextView) this.tvDuration$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(SportDetailMapFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.downloadGpx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(SportDetailMapFragment this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showHot(z);
        if (z) {
            this$0.removeLine();
        } else {
            this$0.addLine();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(SportDetailMapFragment this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.show3d(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(SportDetailMapFragment this$0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showMark(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(SportDetailMapFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.playTrack();
    }

    private final void removeLine() {
        if (this.isInChinaMainland) {
            Marker marker = this.mBaiduLineStart;
            if (marker != null) {
                marker.remove();
            }
            this.mBaiduLineStart = null;
            Polyline polyline = this.mBaiduLine;
            if (polyline != null) {
                polyline.remove();
            }
            this.mBaiduLine = null;
            Marker marker2 = this.mBaiduLineEnd;
            if (marker2 != null) {
                marker2.remove();
            }
            this.mBaiduLineEnd = null;
            return;
        }
        com.google.android.gms.maps.model.Marker marker3 = this.mGoogleLineStart;
        if (marker3 != null) {
            marker3.remove();
        }
        this.mGoogleLineStart = null;
        com.google.android.gms.maps.model.Polyline polyline2 = this.mGoogleLine;
        if (polyline2 != null) {
            polyline2.remove();
        }
        this.mGoogleLine = null;
        com.google.android.gms.maps.model.Marker marker4 = this.mGoogleLineEnd;
        if (marker4 != null) {
            marker4.remove();
        }
        this.mGoogleLineEnd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void share$lambda$25(SportDetailMapFragment this$0, Bitmap topBitmap, Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "$topBitmap");
        if (bitmap != null) {
            this$0.shareMapBitmap(topBitmap, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void share$lambda$27(SportDetailMapFragment this$0, Bitmap topBitmap, Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "$topBitmap");
        if (bitmap != null) {
            this$0.shareMapBitmap(topBitmap, bitmap);
        }
    }

    private final void show3d(boolean z) {
        LogUtils.d("show3d " + z);
        if (z) {
            if (this.isInChinaMainland) {
                getMBaiDuMap().setMapType(2);
                return;
            } else {
                getMGoogleMap().setMapType(2);
                return;
            }
        }
        if (this.isInChinaMainland) {
            getMBaiDuMap().setMapType(1);
        } else {
            getMGoogleMap().setMapType(1);
        }
    }

    private final void showBaiDuMap(ArrayList<CustomLatLng> arrayList) {
        getMBMapView().setVisibility(0);
        TextureMapView mBMapView = getMBMapView();
        mBMapView.showZoomControls(false);
        mBMapView.showScaleControl(false);
        BaiduMap map = getMBMapView().getMap();
        map.setCompassEnable(false);
        kotlin.jvm.internal.IIX0o.oO(map, "apply(...)");
        setMBaiDuMap(map);
        getMBaiDuMap().setOnMapTouchListener(new BaiduMap.OnMapTouchListener() { // from class: com.sma.smartv3.ui.sport.xxX
            @Override // com.baidu.mapapi.map.BaiduMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                SportDetailMapFragment.showBaiDuMap$lambda$22(SportDetailMapFragment.this, motionEvent);
            }
        });
        mapStatusBaiDuCenterPoint(arrayList);
        getMBaiDuMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(com.sma.smartv3.util.I0Io.oIX0oI(arrayList), getMBMapView().getWidth(), getMBMapView().getHeight()));
        getMBaiDuMap().setMapStatus(MapStatusUpdateFactory.zoomTo(com.sma.smartv3.util.xI.II0xO0(arrayList) + 0.5f));
        addLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBaiDuMap$lambda$22(SportDetailMapFragment this$0, MotionEvent motionEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            RelativeLayout rootView = this$0.getRootView();
            if (rootView != null) {
                rootView.requestDisallowInterceptTouchEvent(false);
                return;
            }
            return;
        }
        RelativeLayout rootView2 = this$0.getRootView();
        if (rootView2 != null) {
            rootView2.requestDisallowInterceptTouchEvent(true);
        }
    }

    private final void showGoogleMap(ArrayList<CustomLatLng> arrayList) {
        CustomGoogleMapView mGMapView = getMGMapView();
        mGMapView.setVisibility(0);
        mGMapView.onCreate(null);
        mGMapView.getMapAsync(new II0xO0(arrayList));
    }

    private final void showHot(boolean z) {
        LogUtils.d("showHot " + z);
        if (z) {
            if (this.isInChinaMainland) {
                try {
                    this.mBaiduHeatMap = new HeatMap.Builder().data(this.mBaiduPoints).radius(50).build();
                    getMBaiDuMap().addHeatMap(this.mBaiduHeatMap);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.mGoogleHeatMapProvider = new HeatmapTileProvider.Builder().data(this.mGooglePoints).radius(50).build();
            GoogleMap mGoogleMap = getMGoogleMap();
            TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
            HeatmapTileProvider heatmapTileProvider = this.mGoogleHeatMapProvider;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(heatmapTileProvider);
            this.mGoogleHeatMapOverlay = mGoogleMap.addTileOverlay(tileOverlayOptions.tileProvider(heatmapTileProvider));
            return;
        }
        if (this.isInChinaMainland) {
            HeatMap heatMap = this.mBaiduHeatMap;
            if (heatMap != null) {
                heatMap.removeHeatMap();
            }
            this.mBaiduHeatMap = null;
            return;
        }
        TileOverlay tileOverlay = this.mGoogleHeatMapOverlay;
        if (tileOverlay != null) {
            tileOverlay.remove();
        }
        this.mGoogleHeatMapProvider = null;
    }

    private final void showLocation() {
        boolean z;
        List<Location> location = getMLocationDao().getLocation(getMWorkout().getMStart(), getMWorkout().getMEnd());
        if (!location.isEmpty() && location.size() >= 2) {
            z = false;
        } else {
            z = true;
        }
        this.isLocationEmpty = z;
        showMapLocation(location);
    }

    private final void showMapContent(ArrayList<CustomLatLng> arrayList, boolean z) {
        this.isShowMap = true;
        LogUtils.d("showMapContent isInChinaMainland=" + z);
        LogUtils.d("showMapContent locationList=" + arrayList);
        if (this.isGradient) {
            calculateModeSpeed();
            getGradientLineColors(arrayList);
        }
        if (z) {
            for (CustomLatLng customLatLng : arrayList) {
                this.mBaiduPoints.add(new LatLng(customLatLng.getLatitude(), customLatLng.getLongitude()));
            }
            showBaiDuMap(arrayList);
            if (ProjectManager.f19822oIX0oI.XO0o()) {
                addBaiduDottedLine(this.mBaiduDottedPoints);
                return;
            }
            return;
        }
        for (CustomLatLng customLatLng2 : arrayList) {
            this.mGooglePoints.add(new com.google.android.gms.maps.model.LatLng(customLatLng2.getLatitude(), customLatLng2.getLongitude()));
        }
        showGoogleMap(arrayList);
    }

    private final void showMark(boolean z) {
        LogUtils.d("showMark " + z);
        if (z) {
            if (this.isInChinaMainland) {
                getMarkersData();
                return;
            } else {
                getMarkersData();
                return;
            }
        }
        if (this.isInChinaMainland) {
            Iterator<T> it = this.mBaiduMarkers.iterator();
            while (it.hasNext()) {
                ((Marker) it.next()).remove();
            }
        } else {
            Iterator<T> it2 = this.mGoogleMarkers.iterator();
            while (it2.hasNext()) {
                ((com.google.android.gms.maps.model.Marker) it2.next()).remove();
            }
        }
    }

    private final int speedColorV1(int i, int i2, int i3) {
        int i4 = (i - i2) / 10;
        if (i3 > (i4 * 5) + i2) {
            return ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_startColor);
        }
        if (i3 > i2 + (i4 * 2)) {
            return ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_centerColor);
        }
        return ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_endColor);
    }

    private final int speedColorV2(int i) {
        if (i > this.speedRangeSlow) {
            return ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_startColor);
        }
        if (i < this.speedRangeFast) {
            return ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_endColor);
        }
        return ContextCompat.getColor(requireContext(), R.color.sport_detail_bg_centerColor);
    }

    public final void addBaiduLine(@OXOo.OOXIXo ArrayList<LatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        if (this.isShowLineMarker) {
            Marker marker = this.mBaiduLineStart;
            if (marker == null) {
                Overlay createBaiduIcon$default = createBaiduIcon$default(this, this.mStartIcon, (LatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(points), false, 4, null);
                kotlin.jvm.internal.IIX0o.x0XOIxOo(createBaiduIcon$default, "null cannot be cast to non-null type com.baidu.mapapi.map.Marker");
                this.mBaiduLineStart = (Marker) createBaiduIcon$default;
            } else if (marker != null) {
                marker.setPosition((LatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(points));
            }
        }
        if (this.mBaiduLine == null) {
            this.mInitialPoints = points;
            PolylineOptions isGradient = new PolylineOptions().width(this.mBaiDuMapLineWidth).color(ContextCompat.getColor(requireContext(), this.mMapLineColor)).isGradient(this.isGradient);
            if (this.isGradient) {
                isGradient.colorsValues(this.mLineColors);
            }
            PolylineOptions points2 = isGradient.zIndex(8).points(points);
            kotlin.jvm.internal.IIX0o.oO(points2, "points(...)");
            Overlay addOverlay = getMBaiDuMap().addOverlay(points2);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(addOverlay, "null cannot be cast to non-null type com.baidu.mapapi.map.Polyline");
            this.mBaiduLine = (Polyline) addOverlay;
        } else {
            if (this.isGradient) {
                int[] o0Oox0xox = CollectionsKt___CollectionsKt.o0Oox0xox(this.mColorList);
                Polyline polyline = this.mBaiduLine;
                if (polyline != null) {
                    polyline.setColorList(o0Oox0xox);
                }
            }
            Polyline polyline2 = this.mBaiduLine;
            if (polyline2 != null) {
                polyline2.setPoints(points);
            }
        }
        if (this.isShowLineMarker) {
            Marker marker2 = this.mBaiduLineEnd;
            if (marker2 == null) {
                Overlay createBaiduIcon = createBaiduIcon(this.mCurrentIcon, (LatLng) CollectionsKt___CollectionsKt.O0O0Io00X(points), true);
                kotlin.jvm.internal.IIX0o.x0XOIxOo(createBaiduIcon, "null cannot be cast to non-null type com.baidu.mapapi.map.Marker");
                this.mBaiduLineEnd = (Marker) createBaiduIcon;
            } else if (marker2 != null) {
                marker2.setPosition((LatLng) CollectionsKt___CollectionsKt.O0O0Io00X(points));
            }
        }
    }

    public final void addGoogleLine(@OXOo.OOXIXo ArrayList<com.google.android.gms.maps.model.LatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        GoogleMap mGoogleMap = getMGoogleMap();
        com.google.android.gms.maps.model.Marker marker = this.mGoogleLineStart;
        if (marker == null && this.isShowLineMarker) {
            this.mGoogleLineStart = mGoogleMap.addMarker(new com.google.android.gms.maps.model.MarkerOptions().position((com.google.android.gms.maps.model.LatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(points)).icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(this.mStartIcon)));
        } else if (marker != null) {
            marker.setPosition((com.google.android.gms.maps.model.LatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(points));
        }
        if (this.isGradient && this.mGoogleLineColors.size() == 0 && this.mLineColors.size() > 0) {
            ArrayList<Integer> arrayList = this.mLineColors;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(this.mGoogleLineColors.add(new StyleSpan(((Number) it.next()).intValue()))));
            }
        }
        com.google.android.gms.maps.model.Polyline polyline = this.mGoogleLine;
        if (polyline == null) {
            com.google.android.gms.maps.model.PolylineOptions polylineOptions = new com.google.android.gms.maps.model.PolylineOptions();
            polylineOptions.addAll(points);
            polylineOptions.width(this.mBaiDuMapLineWidth);
            if (this.isGradient) {
                polylineOptions.addAllSpans(this.mGoogleLineColors);
            } else {
                polylineOptions.color(ContextCompat.getColor(requireContext(), this.mMapLineColor));
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            this.mGoogleLine = mGoogleMap.addPolyline(polylineOptions);
        } else if (polyline != null) {
            polyline.setPoints(points);
        }
        com.google.android.gms.maps.model.Marker marker2 = this.mGoogleLineEnd;
        if (marker2 == null && this.isShowLineMarker) {
            com.google.android.gms.maps.model.MarkerOptions position = new com.google.android.gms.maps.model.MarkerOptions().position((com.google.android.gms.maps.model.LatLng) CollectionsKt___CollectionsKt.O0O0Io00X(points));
            if (this.endMarkerAnchorCenter) {
                position.anchor(0.5f, 0.5f);
            }
            oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
            this.mGoogleLineEnd = mGoogleMap.addMarker(position.icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(this.mCurrentIcon)));
            return;
        }
        if (marker2 != null) {
            marker2.setPosition((com.google.android.gms.maps.model.LatLng) CollectionsKt___CollectionsKt.O0O0Io00X(points));
        }
    }

    public final void addLine() {
        if (this.isInChinaMainland) {
            addBaiduLine(this.mBaiduPoints);
        } else {
            addGoogleLine(this.mGooglePoints);
        }
        initializedMapFinish();
    }

    public final void downloadGpx() {
        List<Location> location = getMLocationDao().getLocation(getMWorkout().getMStart(), getMWorkout().getMEnd());
        LocationData locationData = LocationData.INSTANCE;
        ArrayList<CustomLatLng> finalLocationList = locationData.getFinalLocationList(location, false);
        if (finalLocationList.size() > 0) {
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            FileIOUtils.writeFileFromString(com.sma.smartv3.initializer.IXxxXO.ooXIXxIX(oix0oi), locationData.getGpxFileString(finalLocationList, getMWorkout().getMStart(), this.userProfile.getNickname(), ProductManager.f20544oIX0oI.xIXX(getMWorkout().getMMode())));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", getString(R.string.share_gpx_file));
            intent.putExtra("android.intent.extra.STREAM", oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.ooXIXxIX(oix0oi)));
            intent.setType("application/gpx");
            startActivity(Intent.createChooser(intent, getString(R.string.share_gpx_file)));
            return;
        }
        ToastUtils.showLong(R.string.no_data);
    }

    public final Button getBtnTrackPlay() {
        return (Button) this.btnTrackPlay$delegate.getValue();
    }

    public final boolean getEndMarkerAnchorCenter() {
        return this.endMarkerAnchorCenter;
    }

    public final TextureMapView getMBMapView() {
        return (TextureMapView) this.mBMapView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaiduMap getMBaiDuMap() {
        BaiduMap baiduMap = this.mBaiDuMap;
        if (baiduMap != null) {
            return baiduMap;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mBaiDuMap");
        return null;
    }

    public final int getMBaiDuMapLineWidth() {
        return this.mBaiDuMapLineWidth;
    }

    @OXOo.oOoXoXO
    public final Marker getMBaiduLineEnd() {
        return this.mBaiduLineEnd;
    }

    @OXOo.oOoXoXO
    public final Marker getMBaiduLineStart() {
        return this.mBaiduLineStart;
    }

    @OXOo.OOXIXo
    public final ArrayList<Integer> getMColorList() {
        return this.mColorList;
    }

    public final int getMCurrentIcon() {
        return this.mCurrentIcon;
    }

    public final CustomGoogleMapView getMGMapView() {
        return (CustomGoogleMapView) this.mGMapView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final List<StyleSpan> getMGoogleLineColors() {
        return this.mGoogleLineColors;
    }

    @OXOo.OOXIXo
    public final GoogleMap getMGoogleMap() {
        GoogleMap googleMap = this.mGoogleMap;
        if (googleMap != null) {
            return googleMap;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mGoogleMap");
        return null;
    }

    @OXOo.oOoXoXO
    public final ArrayList<LatLng> getMInitialPoints() {
        return this.mInitialPoints;
    }

    @OXOo.OOXIXo
    public final ArrayList<Integer> getMLineColors() {
        return this.mLineColors;
    }

    public final int getMMapLineColor() {
        return this.mMapLineColor;
    }

    @OXOo.OOXIXo
    public final ArrayList<CustomLatLng> getMSmoothLocationList() {
        return this.mSmoothLocationList;
    }

    public final int getMStartIcon() {
        return this.mStartIcon;
    }

    @OXOo.OOXIXo
    public TrackPlay getMTrackPlay() {
        return this.mTrackPlay;
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

    public final RelativeLayout getRootView() {
        return (RelativeLayout) this.rootView$delegate.getValue();
    }

    public final int getSpeedRangeFast() {
        return this.speedRangeFast;
    }

    public final int getSpeedRangeSlow() {
        return this.speedRangeSlow;
    }

    public final TextView getTvDateTime() {
        return (TextView) this.tvDateTime$delegate.getValue();
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

    @SuppressLint({"SetTextI18n"})
    public void initView() {
        TrackPlay.SourceType sourceType;
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Workout");
        setMWorkout((Workout) mArg3);
        getSportDetailActivity();
        getTvDateTime().setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(getMWorkout().getMStart())));
        getTvDuration().setText(com.sma.smartv3.util.xoIox.IoOoX(getMWorkout().getMDuration() * 1000));
        getTvAvgBpmValue().setText(String.valueOf(getMWorkout().getMAvgBpm()));
        getTvDistanceValue().setText(String.valueOf(TextConvertKt.ooOOo0oXI(getMWorkout().getMDistance(), this.userProfile.getUnit(), false, 4, null)));
        getTvDistanceUnit().setText(getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
        getTvCaloriesValue().setText(String.valueOf(getMWorkout().getMCalorie() / 1000));
        showLocation();
        getBtnDownloadGpx().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.IIX0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailMapFragment.initView$lambda$2(SportDetailMapFragment.this, view);
            }
        });
        getBtnMapHot().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.sport.ooXIXxIX
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SportDetailMapFragment.initView$lambda$3(SportDetailMapFragment.this, compoundButton, z);
            }
        });
        getBtnMap3D().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.sport.xI
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SportDetailMapFragment.initView$lambda$4(SportDetailMapFragment.this, compoundButton, z);
            }
        });
        getBtnMapMark().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.sport.oo0xXOI0I
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SportDetailMapFragment.initView$lambda$5(SportDetailMapFragment.this, compoundButton, z);
            }
        });
        TrackPlay mTrackPlay = getMTrackPlay();
        ArrayList<CustomLatLng> arrayList = this.mSmoothLocationList;
        if (this.isInChinaMainland) {
            sourceType = TrackPlay.SourceType.BAIDU;
        } else {
            sourceType = TrackPlay.SourceType.GOOGLE;
        }
        mTrackPlay.o00(arrayList, sourceType);
        getBtnTrackPlay().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.IoOoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailMapFragment.initView$lambda$6(SportDetailMapFragment.this, view);
            }
        });
    }

    public void initializedMapFinish() {
    }

    public final boolean isGradient() {
        return this.isGradient;
    }

    public final boolean isInChinaMainland() {
        return this.isInChinaMainland;
    }

    public final boolean isLocationEmpty() {
        return this.isLocationEmpty;
    }

    public final boolean isShowLineMarker() {
        return this.isShowLineMarker;
    }

    public int layoutId() {
        return R.layout.fragment_sport_detail_map;
    }

    public void mapStatusBaiDuCenterPoint(@OXOo.OOXIXo ArrayList<CustomLatLng> locationList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(locationList, "locationList");
        getMBaiDuMap().setMapStatus(com.sma.smartv3.util.I0Io.II0xO0(locationList));
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.isShowMap) {
            if (this.isInChinaMainland) {
                getMBMapView().onDestroy();
            } else {
                getMGMapView().onDestroy();
            }
        }
    }

    public void onLoadMarkView(@OXOo.OOXIXo ArrayList<CustomLatLng> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        if (this.isInChinaMainland) {
            addBaiduMarkView(list);
        } else {
            addGoogleMarkView(list);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.isShowMap) {
            if (this.isInChinaMainland) {
                getMBMapView().onPause();
            } else {
                getMGMapView().onPause();
            }
        }
    }

    public void playTrack() {
        if (!getMTrackPlay().oO()) {
            getBtnMapHot().setChecked(false);
            getBtnMapMark().setChecked(false);
            getMTrackPlay().x0xO0oo();
        }
    }

    public final void setEndMarkerAnchorCenter(boolean z) {
        this.endMarkerAnchorCenter = z;
    }

    public final void setGradient(boolean z) {
        this.isGradient = z;
    }

    public final void setLocationEmpty(boolean z) {
        this.isLocationEmpty = z;
    }

    public final void setMBaiDuMap(@OXOo.OOXIXo BaiduMap baiduMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(baiduMap, "<set-?>");
        this.mBaiDuMap = baiduMap;
    }

    public final void setMBaiDuMapLineWidth(int i) {
        this.mBaiDuMapLineWidth = i;
    }

    public final void setMBaiduLineEnd(@OXOo.oOoXoXO Marker marker) {
        this.mBaiduLineEnd = marker;
    }

    public final void setMBaiduLineStart(@OXOo.oOoXoXO Marker marker) {
        this.mBaiduLineStart = marker;
    }

    public final void setMColorList(@OXOo.OOXIXo ArrayList<Integer> arrayList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.mColorList = arrayList;
    }

    public final void setMCurrentIcon(int i) {
        this.mCurrentIcon = i;
    }

    public final void setMGoogleMap(@OXOo.OOXIXo GoogleMap googleMap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(googleMap, "<set-?>");
        this.mGoogleMap = googleMap;
    }

    public final void setMInitialPoints(@OXOo.oOoXoXO ArrayList<LatLng> arrayList) {
        this.mInitialPoints = arrayList;
    }

    public final void setMMapLineColor(int i) {
        this.mMapLineColor = i;
    }

    public final void setMSmoothLocationList(@OXOo.OOXIXo ArrayList<CustomLatLng> arrayList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.mSmoothLocationList = arrayList;
    }

    public final void setMStartIcon(int i) {
        this.mStartIcon = i;
    }

    public void setMTrackPlay(@OXOo.OOXIXo TrackPlay trackPlay) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(trackPlay, "<set-?>");
        this.mTrackPlay = trackPlay;
    }

    public final void setMWorkout(@OXOo.OOXIXo Workout workout) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(workout, "<set-?>");
        this.mWorkout = workout;
    }

    public final void setShowLineMarker(boolean z) {
        this.isShowLineMarker = z;
    }

    public final void setSpeedRangeFast(int i) {
        this.speedRangeFast = i;
    }

    public final void setSpeedRangeSlow(int i) {
        this.speedRangeSlow = i;
    }

    public void share(@OXOo.OOXIXo final Bitmap topBitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "topBitmap");
        if (this.isInChinaMainland) {
            getMBaiDuMap().snapshot(new BaiduMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.XxX0x0xxx
                @Override // com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) {
                    SportDetailMapFragment.share$lambda$25(SportDetailMapFragment.this, topBitmap, bitmap);
                }
            });
        } else {
            getMGoogleMap().snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.xXxxox0I
                @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) {
                    SportDetailMapFragment.share$lambda$27(SportDetailMapFragment.this, topBitmap, bitmap);
                }
            });
        }
    }

    public void shareMapBitmap(@OXOo.OOXIXo Bitmap topBitmap, @OXOo.OOXIXo Bitmap mapBitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "topBitmap");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mapBitmap, "mapBitmap");
        Bitmap createBitmap = Bitmap.createBitmap(getRootView().getWidth(), getRootView().getHeight() + topBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(topBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(mapBitmap, 0.0f, topBitmap.getHeight(), (Paint) null);
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        RelativeLayout rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        canvas.drawBitmap(oxx0IOOO.II0xO0(rootView), 0.0f, topBitmap.getHeight(), (Paint) null);
        oxx0IOOO.oxoX(getMActivity(), createBitmap);
    }

    public void showMapLocation(@OXOo.OOXIXo List<Location> locationList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(locationList, "locationList");
        if (this.isLocationEmpty) {
            return;
        }
        this.mFinalOriginalLocationList = LocationData.INSTANCE.getFinalLocationList(locationList, this.isInChinaMainland);
        if (ProjectManager.f19822oIX0oI.XO0o()) {
            for (CustomLatLng customLatLng : this.mFinalOriginalLocationList) {
                this.mBaiduDottedPoints.add(new LatLng(customLatLng.getLatitude(), customLatLng.getLongitude()));
            }
        }
        this.mSmoothLocationList.addAll(LocationData.INSTANCE.getSmoothLocationListAlgorithm(this.mFinalOriginalLocationList, getMWorkout().getMMode()));
        getIntiLocationList();
        showMapContent(this.mSmoothLocationList, this.isInChinaMainland);
    }
}
