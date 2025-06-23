package com.baidu.platform.comapi.wnplatform.h;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.wnplatform.f;

/* loaded from: classes8.dex */
public class c extends ItemizedOverlay {
    private View b;
    private TextView c;
    private ImageView d;
    private Context e;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final c f9916a = new c();
    }

    public static c b() {
        return a.f9916a;
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble("x", iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            bundle.putInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX, iArr3[i]);
            a(context, bundle);
        }
    }

    private c() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().N().a());
    }

    private void a(Context context, Bundle bundle) {
        double d = bundle.getDouble("x");
        double d2 = bundle.getDouble("y");
        int i = bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX);
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "addItem:lng:" + d + "lat:" + d2 + "index:" + i);
        new GeoPoint(d2, d);
        LatLng latLng = new LatLng(d2, d);
        MarkerOptions markerOptions = new MarkerOptions();
        BitmapDescriptor a2 = a(context, i);
        if (a2 != null) {
            markerOptions.icon(a2);
            markerOptions.position(latLng);
            addItem(markerOptions);
        }
    }

    private BitmapDescriptor a(Context context, int i) {
        try {
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.wsdk_node_overlay, (ViewGroup) null);
            this.b = inflate;
            this.c = (TextView) inflate.findViewById(R.id.node_index_tv);
            this.d = (ImageView) this.b.findViewById(R.id.node_index_iv);
            if (f.a().i() == 2) {
                this.c.setText(i + "");
            } else {
                this.c.setText("途");
            }
            this.b.setDrawingCacheEnabled(true);
            this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            View view = this.b;
            view.layout(0, 0, view.getMeasuredWidth(), this.b.getMeasuredHeight());
            this.b.buildDrawingCache();
            return BitmapDescriptorFactory.fromBitmap(this.b.getDrawingCache());
        } catch (Exception unused) {
            return null;
        }
    }
}
