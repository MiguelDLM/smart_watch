package com.sma.smartv3.ui.status;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.SPUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.o0xxxXXxX;
import com.sma.smartv3.util.xI;
import com.sma.smartv3.view.CustomGoogleMapView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nGoogleMapSportRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoogleMapSportRecordFragment.kt\ncom/sma/smartv3/ui/status/GoogleMapSportRecordFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,156:1\n19#2:157\n15#2:158\n*S KotlinDebug\n*F\n+ 1 GoogleMapSportRecordFragment.kt\ncom/sma/smartv3/ui/status/GoogleMapSportRecordFragment\n*L\n33#1:157\n33#1:158\n*E\n"})
/* loaded from: classes12.dex */
public final class GoogleMapSportRecordFragment extends BaseFragment {

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO mMapView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CustomGoogleMapView>() { // from class: com.sma.smartv3.ui.status.GoogleMapSportRecordFragment$mMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CustomGoogleMapView invoke() {
            View mView;
            mView = GoogleMapSportRecordFragment.this.getMView();
            return (CustomGoogleMapView) mView.findViewById(R.id.mapView);
        }
    });
    private GoogleMap map;
    private NestedScrollView view;

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements CustomGoogleMapView.oIX0oI {
        public II0xO0() {
        }

        @Override // com.sma.smartv3.view.CustomGoogleMapView.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo MotionEvent motionEvent) {
            IIX0o.x0xO0oo(motionEvent, "motionEvent");
            NestedScrollView nestedScrollView = null;
            if (motionEvent.getAction() == 1) {
                NestedScrollView nestedScrollView2 = GoogleMapSportRecordFragment.this.view;
                if (nestedScrollView2 == null) {
                    IIX0o.XOxIOxOx(ViewHierarchyConstants.VIEW_KEY);
                } else {
                    nestedScrollView = nestedScrollView2;
                }
                nestedScrollView.requestDisallowInterceptTouchEvent(false);
                return;
            }
            NestedScrollView nestedScrollView3 = GoogleMapSportRecordFragment.this.view;
            if (nestedScrollView3 == null) {
                IIX0o.XOxIOxOx(ViewHierarchyConstants.VIEW_KEY);
            } else {
                nestedScrollView = nestedScrollView3;
            }
            nestedScrollView.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements OnMapReadyCallback {
        public oIX0oI() {
        }

        @Override // com.google.android.gms.maps.OnMapReadyCallback
        public void onMapReady(@OXOo.OOXIXo GoogleMap googleMap) {
            IIX0o.x0xO0oo(googleMap, "googleMap");
            MapsInitializer.initialize(GoogleMapSportRecordFragment.this.getMActivity());
            GoogleMapSportRecordFragment.this.map = googleMap;
            GoogleMapSportRecordFragment googleMapSportRecordFragment = GoogleMapSportRecordFragment.this;
            Serializable mArg3 = googleMapSportRecordFragment.getMArg3();
            IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.model.CustomLatLng>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.model.CustomLatLng> }");
            googleMapSportRecordFragment.showMapContent((ArrayList) mArg3);
        }
    }

    public GoogleMapSportRecordFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final CustomGoogleMapView getMMapView() {
        return (CustomGoogleMapView) this.mMapView$delegate.getValue();
    }

    private final void setCustomerMakerIcon(GoogleMap googleMap, LatLng latLng, Bitmap bitmap) {
        MarkerOptions position = new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(9.0f).position(latLng);
        IIX0o.oO(position, "position(...)");
        googleMap.addMarker(position);
    }

    private final void setTextMakers(GoogleMap googleMap, ArrayList<CustomLatLng> arrayList) {
        Context context = getContext();
        IIX0o.ooOOo0oXI(context);
        o0xxxXXxX o0xxxxxxx = new o0xxxXXxX(context, R.layout.map_markers_text);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            LatLng latLng = new LatLng(arrayList.get(i).getLatitude(), arrayList.get(i).getLongitude());
            i++;
            setCustomerMakerIcon(googleMap, latLng, o0xxxxxxx.II0xO0(String.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMapContent(ArrayList<CustomLatLng> arrayList) {
        GoogleMap googleMap = this.map;
        if (googleMap == null) {
            IIX0o.XOxIOxOx(MapPlugin.MapSearchTool);
            googleMap = null;
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(com.sma.smartv3.util.IIXOooo.II0xO0(arrayList), xI.II0xO0(arrayList) - 1.0f));
        PolylineOptions polylineOptions = new PolylineOptions();
        Iterator<CustomLatLng> it = arrayList.iterator();
        while (it.hasNext()) {
            CustomLatLng next = it.next();
            polylineOptions.add(new LatLng(next.getLatitude(), next.getLongitude()));
        }
        polylineOptions.width(12.0f);
        polylineOptions.color(ContextCompat.getColor(getMActivity(), R.color.map_track_color));
        googleMap.addPolyline(polylineOptions);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(((CustomLatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)).getLatitude(), ((CustomLatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)).getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.sport_start)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(((CustomLatLng) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList)).getLatitude(), ((CustomLatLng) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList)).getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.sport_end)));
        getMMapView().setOnMapTouchListener(new II0xO0());
    }

    @OXOo.OOXIXo
    public final GoogleMap getGoogleMap() {
        GoogleMap googleMap = this.map;
        if (googleMap == null) {
            IIX0o.XOxIOxOx(MapPlugin.MapSearchTool);
            return null;
        }
        return googleMap;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        CustomGoogleMapView mMapView = getMMapView();
        mMapView.onCreate(null);
        mMapView.getMapAsync(new oIX0oI());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_google_map_sport_record;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getMMapView().onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getMMapView().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getMMapView().onResume();
    }

    public final void setOnMapTouchListener(@OXOo.OOXIXo NestedScrollView nestedScrollView) {
        IIX0o.x0xO0oo(nestedScrollView, "nestedScrollView");
        this.view = nestedScrollView;
    }
}
