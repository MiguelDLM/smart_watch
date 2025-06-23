package com.sma.smartv3.ui.status;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.o0xxxXXxX;
import com.sma.smartv3.util.xI;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBaiDuMapSportRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaiDuMapSportRecordFragment.kt\ncom/sma/smartv3/ui/status/BaiDuMapSportRecordFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,221:1\n19#2:222\n15#2:223\n*S KotlinDebug\n*F\n+ 1 BaiDuMapSportRecordFragment.kt\ncom/sma/smartv3/ui/status/BaiDuMapSportRecordFragment\n*L\n26#1:222\n26#1:223\n*E\n"})
/* loaded from: classes12.dex */
public final class BaiDuMapSportRecordFragment extends BaseFragment {

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO mMapView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextureMapView>() { // from class: com.sma.smartv3.ui.status.BaiDuMapSportRecordFragment$mMapView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextureMapView invoke() {
            View mView;
            mView = BaiDuMapSportRecordFragment.this.getMView();
            return (TextureMapView) mView.findViewById(R.id.mapView);
        }
    });

    @OXOo.oOoXoXO
    private NestedScrollView view;

    public BaiDuMapSportRecordFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final TextureMapView getMMapView() {
        return (TextureMapView) this.mMapView$delegate.getValue();
    }

    private final void setCustomerMakerIcon(BaiduMap baiduMap, LatLng latLng, Bitmap bitmap) {
        baiduMap.addOverlay(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(9).position(latLng));
    }

    private final void setTextMakers(BaiduMap baiduMap, ArrayList<CustomLatLng> arrayList) {
        Context context = getContext();
        IIX0o.ooOOo0oXI(context);
        o0xxxXXxX o0xxxxxxx = new o0xxxXXxX(context, R.layout.map_markers_text);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            LatLng latLng = new LatLng(arrayList.get(i).getLatitude(), arrayList.get(i).getLongitude());
            i++;
            setCustomerMakerIcon(baiduMap, latLng, o0xxxxxxx.II0xO0(String.valueOf(i)));
        }
    }

    public static /* synthetic */ void showMapContent$default(BaiDuMapSportRecordFragment baiDuMapSportRecordFragment, ArrayList arrayList, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        baiDuMapSportRecordFragment.showMapContent(arrayList, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMapContent$lambda$2(BaiDuMapSportRecordFragment this$0, MotionEvent motionEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            NestedScrollView nestedScrollView = this$0.view;
            if (nestedScrollView != null) {
                nestedScrollView.requestDisallowInterceptTouchEvent(false);
                return;
            }
            return;
        }
        NestedScrollView nestedScrollView2 = this$0.view;
        if (nestedScrollView2 != null) {
            nestedScrollView2.requestDisallowInterceptTouchEvent(true);
        }
    }

    @OXOo.OOXIXo
    public final BaiduMap getBaiDuMap() {
        BaiduMap map = getMMapView().getMap();
        IIX0o.oO(map, "getMap(...)");
        return map;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.model.CustomLatLng>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.model.CustomLatLng> }");
        showMapContent$default(this, (ArrayList) mArg3, false, 2, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_baidu_map_sport_record;
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

    public final void showMapContent(@OXOo.OOXIXo ArrayList<CustomLatLng> tmpLocationList, boolean z) {
        IIX0o.x0xO0oo(tmpLocationList, "tmpLocationList");
        int i = 0;
        if (z) {
            BaiduMap map = getMMapView().getMap();
            map.clear();
            if (!tmpLocationList.isEmpty() && tmpLocationList.size() >= 2) {
                map.setMapStatus(com.sma.smartv3.util.I0Io.II0xO0(tmpLocationList));
                map.clear();
                ArrayList arrayList = new ArrayList();
                int size = tmpLocationList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new LatLng(tmpLocationList.get(i2).getLatitude(), tmpLocationList.get(i2).getLongitude()));
                }
                PolylineOptions points = new PolylineOptions().width(16).color(ContextCompat.getColor(getMActivity(), R.color.map_track_color)).points(arrayList);
                IIX0o.oO(points, "points(...)");
                map.addOverlay(points);
                int size2 = tmpLocationList.size();
                while (i < size2) {
                    TextOptions position = new TextOptions().text(String.valueOf(i)).bgColor(SupportMenu.CATEGORY_MASK).fontSize(44).fontColor(ViewCompat.MEASURED_STATE_MASK).rotate(-30.0f).position(new LatLng(tmpLocationList.get(i).getLatitude(), tmpLocationList.get(i).getLongitude()));
                    IIX0o.oO(position, "position(...)");
                    map.addOverlay(position);
                    i++;
                }
                return;
            }
            return;
        }
        TextureMapView mMapView = getMMapView();
        mMapView.showZoomControls(false);
        mMapView.showScaleControl(false);
        BaiduMap map2 = getMMapView().getMap();
        map2.setCompassEnable(false);
        if (!tmpLocationList.isEmpty() && tmpLocationList.size() >= 2) {
            map2.setMapStatus(com.sma.smartv3.util.I0Io.II0xO0(tmpLocationList));
            map2.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(com.sma.smartv3.util.I0Io.oIX0oI(tmpLocationList), getMMapView().getWidth(), getMMapView().getHeight()));
            map2.setMapStatus(MapStatusUpdateFactory.zoomTo(xI.II0xO0(tmpLocationList)));
            map2.setOnMapTouchListener(new BaiduMap.OnMapTouchListener() { // from class: com.sma.smartv3.ui.status.oIX0oI
                @Override // com.baidu.mapapi.map.BaiduMap.OnMapTouchListener
                public final void onTouch(MotionEvent motionEvent) {
                    BaiDuMapSportRecordFragment.showMapContent$lambda$2(BaiDuMapSportRecordFragment.this, motionEvent);
                }
            });
            ArrayList arrayList2 = new ArrayList();
            int size3 = tmpLocationList.size();
            while (i < size3) {
                arrayList2.add(new LatLng(tmpLocationList.get(i).getLatitude(), tmpLocationList.get(i).getLongitude()));
                i++;
            }
            PolylineOptions points2 = new PolylineOptions().width(12).color(ContextCompat.getColor(getMActivity(), R.color.map_track_color)).points(arrayList2);
            IIX0o.oO(points2, "points(...)");
            map2.addOverlay(points2);
            IIX0o.ooOOo0oXI(map2);
            setCustomerMakerIcon(map2, new LatLng(((CustomLatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(tmpLocationList)).getLatitude(), ((CustomLatLng) CollectionsKt___CollectionsKt.O0OOX0IIx(tmpLocationList)).getLongitude()), R.drawable.sport_start);
            setCustomerMakerIcon(map2, new LatLng(((CustomLatLng) CollectionsKt___CollectionsKt.O0O0Io00X(tmpLocationList)).getLatitude(), ((CustomLatLng) CollectionsKt___CollectionsKt.O0O0Io00X(tmpLocationList)).getLongitude()), R.drawable.sport_end);
        }
    }

    private final void setCustomerMakerIcon(BaiduMap baiduMap, LatLng latLng, int i) {
        MarkerOptions alpha = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(i)).draggable(false).flat(true).alpha(0.5f);
        IIX0o.oO(alpha, "alpha(...)");
        baiduMap.addOverlay(alpha);
    }
}
