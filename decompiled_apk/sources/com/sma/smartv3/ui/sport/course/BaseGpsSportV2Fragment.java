package com.sma.smartv3.ui.sport.course;

import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.CustomGoogleMapView;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseGpsSportV2Fragment extends BaseSportV2Fragment {
    private BaiduMap mBaiDuMap;
    private GoogleMap mGoogleMap;

    @OXOo.oOoXoXO
    private com.sma.smartv3.location.oxoX mLocationClient;

    @OXOo.OOXIXo
    private final X0IIOO mGMapView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomGoogleMapView>() { // from class: com.sma.smartv3.ui.sport.course.BaseGpsSportV2Fragment$mGMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomGoogleMapView invoke() {
            View mView;
            mView = BaseGpsSportV2Fragment.this.getMView();
            return (CustomGoogleMapView) mView.findViewById(R.id.gMapView);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mBMapView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextureMapView>() { // from class: com.sma.smartv3.ui.sport.course.BaseGpsSportV2Fragment$mBMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextureMapView invoke() {
            View mView;
            mView = BaseGpsSportV2Fragment.this.getMView();
            return (TextureMapView) mView.findViewById(R.id.bMapView);
        }
    });
    private boolean isInChinaMainland = Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24367IXxxXO, false);

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements com.sma.smartv3.location.II0xO0 {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.location.II0xO0
        public void oIX0oI(@OXOo.OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            GoogleMap googleMap = null;
            BaiduMap baiduMap = null;
            if (BaseGpsSportV2Fragment.this.isInChinaMainland) {
                BaiduMap baiduMap2 = BaseGpsSportV2Fragment.this.mBaiDuMap;
                if (baiduMap2 == null) {
                    IIX0o.XOxIOxOx("mBaiDuMap");
                } else {
                    baiduMap = baiduMap2;
                }
                baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(location.II0xO0(), location.I0Io())));
            } else {
                try {
                    GoogleMap googleMap2 = BaseGpsSportV2Fragment.this.mGoogleMap;
                    if (googleMap2 == null) {
                        IIX0o.XOxIOxOx("mGoogleMap");
                    } else {
                        googleMap = googleMap2;
                    }
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(new com.google.android.gms.maps.model.LatLng(location.II0xO0(), location.I0Io())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            BaseGpsSportV2Fragment.this.stopLocationClient();
        }

        @Override // com.sma.smartv3.location.II0xO0
        public void onError(@OXOo.OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
        }
    }

    private final TextureMapView getMBMapView() {
        return (TextureMapView) this.mBMapView$delegate.getValue();
    }

    private final CustomGoogleMapView getMGMapView() {
        return (CustomGoogleMapView) this.mGMapView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLocationWhere$lambda$3$lambda$2(CustomGoogleMapView customGoogleMapView, BaseGpsSportV2Fragment this$0, GoogleMap googleMap) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(googleMap, "googleMap");
        MapsInitializer.initialize(customGoogleMapView.getContext());
        this$0.mGoogleMap = googleMap;
        if (googleMap == null) {
            IIX0o.XOxIOxOx("mGoogleMap");
            googleMap = null;
        }
        googleMap.getUiSettings().setAllGesturesEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopLocationClient() {
        com.sma.smartv3.location.oxoX oxox = this.mLocationClient;
        if (oxox != null) {
            oxox.II0XooXoX();
        }
    }

    @Override // com.sma.smartv3.ui.sport.course.BaseSportV2Fragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        onLocationWhere(new Object());
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.isInChinaMainland) {
            getMBMapView().onDestroy();
        } else {
            getMGMapView().onDestroy();
        }
    }

    @XO0.XO(tag = XoI0Ixx0.f24367IXxxXO)
    public final void onLocationWhere(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onLocationWhere");
        boolean z = Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24367IXxxXO, false);
        this.isInChinaMainland = z;
        if (z) {
            getMBMapView().setVisibility(0);
            getMBMapView().showZoomControls(false);
            getMBMapView().showScaleControl(false);
            getMBMapView().setLogoPosition(LogoPosition.logoPostionRightTop);
            BaiduMap map = getMBMapView().getMap();
            map.setCompassEnable(false);
            map.getUiSettings().setAllGesturesEnabled(false);
            IIX0o.oO(map, "apply(...)");
            this.mBaiDuMap = map;
        } else {
            final CustomGoogleMapView mGMapView = getMGMapView();
            mGMapView.setVisibility(0);
            mGMapView.onCreate(null);
            mGMapView.getMapAsync(new OnMapReadyCallback() { // from class: com.sma.smartv3.ui.sport.course.oxoX
                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public final void onMapReady(GoogleMap googleMap) {
                    BaseGpsSportV2Fragment.onLocationWhere$lambda$3$lambda$2(CustomGoogleMapView.this, this, googleMap);
                }
            });
        }
        com.sma.smartv3.location.oxoX II0xO02 = com.sma.smartv3.location.X0o0xo.II0xO0(new oIX0oI(), false, 2, null);
        this.mLocationClient = II0xO02;
        if (II0xO02 != null) {
            II0xO02.XO(R.string.show_map_and_phone_get_location_desc, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.isInChinaMainland) {
            getMBMapView().onPause();
        } else {
            getMGMapView().onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isInChinaMainland) {
            getMBMapView().onResume();
        } else {
            getMGMapView().onResume();
        }
    }
}
