package com.baidu.platform.comapi.wnplatform.h;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.R;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class a extends ItemizedOverlay {
    private View b;
    private ImageView c;
    private ImageView d;
    private Context e;

    /* renamed from: com.baidu.platform.comapi.wnplatform.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0541a {

        /* renamed from: a, reason: collision with root package name */
        static final a f9915a = new a();
    }

    public static a b() {
        return C0541a.f9915a;
    }

    public void a(Context context, int[] iArr, int[] iArr2, int[] iArr3) {
        this.e = context;
        Bundle bundle = new Bundle();
        removeAll();
        for (int i = 0; i < iArr.length; i++) {
            bundle.putDouble("x", iArr[i]);
            bundle.putDouble("y", iArr2[i]);
            if (iArr3[i] < RouteGuideKind.values().length) {
                int[] a2 = com.baidu.platform.comapi.walknavi.h.b.c.a(RouteGuideKind.values()[iArr3[i]]);
                bundle.putInt("upResId", a2[0]);
                bundle.putInt("downResId", a2[1]);
                a(context, bundle);
            }
        }
    }

    private a() {
        super(null, com.baidu.platform.comapi.walknavi.b.a().N().a());
    }

    public void a(Context context, Bundle bundle) {
        double d = bundle.getDouble("x");
        double d2 = bundle.getDouble("y");
        int i = bundle.getInt("upResId");
        int i2 = bundle.getInt("downResId");
        new GeoPoint(d2, d);
        LatLng latLng = new LatLng(d2, d);
        MarkerOptions markerOptions = new MarkerOptions();
        BitmapDescriptor a2 = a(context, i, i2);
        if (a2 != null) {
            markerOptions.icon(a2);
            markerOptions.position(latLng);
            addItem(markerOptions);
        }
    }

    private BitmapDescriptor a(Context context, int i, int i2) {
        try {
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.wsdk_walk_type_overlay, (ViewGroup) null);
            this.b = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.node_index_iv_up);
            this.c = imageView;
            imageView.setImageResource(i);
            ImageView imageView2 = (ImageView) this.b.findViewById(R.id.node_index_iv_down);
            this.d = imageView2;
            imageView2.setImageResource(i2);
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
