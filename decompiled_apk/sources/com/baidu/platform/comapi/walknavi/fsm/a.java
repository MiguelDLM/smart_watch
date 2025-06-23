package com.baidu.platform.comapi.walknavi.fsm;

import XIXIX.OOXIXo;
import android.graphics.Point;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.walkmap.f;

/* loaded from: classes8.dex */
class a implements f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RGStateEntry f9759a;

    public a(RGStateEntry rGStateEntry) {
        this.f9759a = rGStateEntry;
    }

    @Override // com.baidu.platform.comapi.wnplatform.walkmap.f
    public void a() {
        int i;
        int i2;
        i = this.f9759a.b;
        if (i != 1) {
            i2 = this.f9759a.b;
            if (i2 != 2) {
                this.f9759a.b = 0;
                b.a().N().a((f) null);
                b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
                return;
            }
            GeoPoint e = b.a().K().e();
            MapStatus h = b.a().N().h();
            if (h != null && e != null) {
                MapStatus.Builder builder = new MapStatus.Builder(h);
                WinRound winRound = h.winRound;
                long abs = 0 - ((Math.abs(winRound.bottom - winRound.top) * 2) / 10);
                WinRound winRound2 = h.winRound;
                builder.targetScreen(new Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - ((int) abs)));
                if (e.getLongitudeE6() != OOXIXo.f3760XO && e.getLatitudeE6() != OOXIXo.f3760XO) {
                    builder.target(com.baidu.platform.comapi.wnplatform.p.f.a(e));
                    b.a().N().a(builder.build());
                }
            }
            this.f9759a.b = 0;
            b.a().K().a(false);
            b.a().N().a((f) null);
            b.a().a(1000, RGFSMTable.FsmState.Car3D);
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.b("Animate", "onMapViewAnimationFinish --- move2center");
        MapStatus h2 = b.a().N().h();
        if (h2 != null) {
            int p = b.a().Y().p();
            MapStatus.Builder builder2 = new MapStatus.Builder(h2);
            WinRound winRound3 = h2.winRound;
            int[] iArr = {(winRound3.left + winRound3.right) / 2, (Math.abs((winRound3.bottom - p) - winRound3.top) * 7) / 10};
            int[] iArr2 = {0, 0};
            b.a().N().a(iArr, iArr2);
            LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(iArr2[1], iArr2[0]));
            LatLng latLng = h2.target;
            double d = (latLng.latitude * 2.0d) - mc2ll.latitude;
            double d2 = (latLng.longitude * 2.0d) - mc2ll.longitude;
            com.baidu.platform.comapi.wnplatform.d.a.a("x is " + d);
            com.baidu.platform.comapi.wnplatform.d.a.a("y is " + d2);
            builder2.target(new LatLng(d, d2));
            b.a().N().a(builder2.build(), 500);
        }
        this.f9759a.b = 2;
    }
}
