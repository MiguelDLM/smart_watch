package com.octopus.ad.internal.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.c;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.xoIox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import x0OxxIOxX.II0xO0;

/* loaded from: classes11.dex */
public class InterstitialAdViewImpl extends AdViewImpl {

    /* renamed from: IoXIXo, reason: collision with root package name */
    public static final String f19000IoXIXo = "TIME";

    /* renamed from: O0IxXx, reason: collision with root package name */
    public static InterstitialAdViewImpl f19001O0IxXx = null;

    /* renamed from: xxOXOOoIX, reason: collision with root package name */
    public static final String f19002xxOXOOoIX = "CLOSE_BUTTON_DELAY";

    /* renamed from: IXO, reason: collision with root package name */
    public AdActivity.I0Io f19003IXO;

    /* renamed from: Ix00oIoI, reason: collision with root package name */
    public boolean f19004Ix00oIoI;

    /* renamed from: IxIX0I, reason: collision with root package name */
    public boolean f19005IxIX0I;

    /* renamed from: XXoOx0, reason: collision with root package name */
    public int f19006XXoOx0;

    /* renamed from: oI, reason: collision with root package name */
    public boolean f19007oI;

    /* renamed from: oOoIIO0, reason: collision with root package name */
    public Queue<X0o0xo> f19008oOoIIO0;

    /* renamed from: x0OIX00oO, reason: collision with root package name */
    public int f19009x0OIX00oO;

    public InterstitialAdViewImpl(Context context, boolean z, boolean z2) {
        super(context);
        this.f19009x0OIX00oO = 0;
        this.f19006XXoOx0 = 10000;
        this.f19008oOoIIO0 = new LinkedList();
        this.f19003IXO = null;
        this.f19007oI = false;
        this.f19004Ix00oIoI = false;
        this.f18764Io = z;
        this.f18801o0 = z2;
        if (z) {
            this.f18784X00IoxXI.I0Io(l.REWARDVIDEO);
        } else {
            this.f18784X00IoxXI.I0Io(l.INTERSTITIAL);
        }
        if (z) {
            this.f19009x0OIX00oO = ViewCompat.MEASURED_STATE_MASK;
        } else if (z2) {
            this.f19009x0OIX00oO = 0;
        } else {
            this.f19009x0OIX00oO = Color.argb(8, 0, 0, 0);
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void I0Io() {
        super.I0Io();
    }

    public int I0xX0(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.show_int));
            long currentTimeMillis = System.currentTimeMillis();
            if (oIIxXoo(currentTimeMillis) && !this.f19007oI) {
                Class<AdActivity> oIX0oI2 = AdActivity.oIX0oI();
                Intent intent = new Intent(activity, oIX0oI2);
                intent.putExtra("ACTIVITY_TYPE", "INTERSTITIAL");
                intent.putExtra("TIME", currentTimeMillis);
                intent.putExtra(f19002xxOXOOoIX, this.f19006XXoOx0);
                f19001O0IxXx = this;
                try {
                    activity.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    f19001O0IxXx = null;
                    com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.adactivity_missing, oIX0oI2.getName()));
                }
                return this.f19008oOoIIO0.size() - 1;
            }
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.empty_queue));
            return this.f19008oOoIIO0.size();
        }
        return this.f19008oOoIIO0.size();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void IIX0o() {
        this.f19004Ix00oIoI = true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void IoOoo() {
        AdActivity.I0Io i0Io = this.f19003IXO;
        if (i0Io != null) {
            i0Io.f();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean O0Xx() {
        return false;
    }

    public void OO0x0xX() {
        AdActivity.I0Io i0Io = this.f19003IXO;
        if (i0Io != null) {
            i0Io.g();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void Oxx0IOOO() {
        super.Oxx0IOOO();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void X0o0xo() {
        super.X0o0xo();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void XO() {
        super.XO();
    }

    public boolean XXXI() {
        return this.f19005IxIX0I;
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        c cVar = this.f18774OI0;
        if (cVar != null) {
            cVar.oxoX();
        }
        f19001O0IxXx = null;
        this.f19008oOoIIO0.clear();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void destroy() {
        super.destroy();
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.destroy_int));
        c cVar = this.f18774OI0;
        if (cVar != null) {
            cVar.oxoX();
        }
        this.f19008oOoIIO0.clear();
        f19001O0IxXx = null;
    }

    public AdActivity.I0Io getAdImplementation() {
        return this.f19003IXO;
    }

    public Queue<X0o0xo> getAdQueue() {
        return this.f19008oOoIIO0;
    }

    public int getBackgroundColor() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.get_bg));
        return this.f19009x0OIX00oO;
    }

    public int getCloseButtonDelay() {
        return this.f19006XXoOx0;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public int getCreativeHeight() {
        return -1;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public int getCreativeWidth() {
        return -1;
    }

    @Override // com.octopus.ad.internal.oIX0oI
    public l getMediaType() {
        if (this.f18764Io) {
            return l.REWARDVIDEO;
        }
        return l.INTERSTITIAL;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void o00(I0Io i0Io) {
        if (!oXX0IoI(i0Io)) {
            xI0oxI00(oOoIIO0.I0Io.f32012II0XooXoX);
            return;
        }
        I0Io i0Io2 = this.f18800XxX0x0xxx;
        if (i0Io2 != null) {
            i0Io2.destroy();
        }
        if (!this.f19007oI && !this.f19004Ix00oIoI) {
            this.f18800XxX0x0xxx = i0Io;
            this.f19008oOoIIO0.add(new oxoX(i0Io, Long.valueOf(System.currentTimeMillis()), false));
        } else if (i0Io != null) {
            i0Io.destroy();
        }
    }

    public final boolean oIIxXoo(long j) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<X0o0xo> it = this.f19008oOoIIO0.iterator();
        while (true) {
            if (it.hasNext()) {
                X0o0xo next = it.next();
                if (next != null && j - next.a() <= xoIox.f19058ooXIXxIX && j - next.a() >= 0 && !next.b()) {
                    z = true;
                    break;
                }
                arrayList.add(next);
            } else {
                z = false;
                break;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.f19008oOoIIO0.remove((X0o0xo) it2.next());
        }
        return z;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void oIX0oI() {
        super.oIX0oI();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean oXIO0o0XI(II0xO0.C1145II0xO0 c1145II0xO0) {
        c cVar;
        getAdParameters().X0o0xo(false);
        this.f18762IO = c1145II0xO0;
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.load_ad_int));
        if (!oxoX() || (cVar = this.f18774OI0) == null) {
            return false;
        }
        cVar.oxoX();
        this.f18774OI0.Oxx0IOOO();
        this.f18756I0oOIX = 1;
        this.f18832xoxXI = 0;
        return true;
    }

    public final boolean oXX0IoI(I0Io i0Io) {
        if (i0Io != null && !i0Io.oIX0oI()) {
            return true;
        }
        com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Loaded an ad with an invalid displayable");
        return false;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void ooXIXxIX() {
        this.f19004Ix00oIoI = false;
    }

    public void setAdImplementation(AdActivity.I0Io i0Io) {
        this.f19003IXO = i0Io;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.set_bg));
        this.f19009x0OIX00oO = i;
    }

    public void setCloseButtonDelay(int i) {
        this.f19006XXoOx0 = Math.min(i, 10000);
    }

    public void setDismissOnClick(boolean z) {
        this.f19005IxIX0I = z;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void xII(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.oct_ad_view);
        int indexCount = obtainStyledAttributes.getIndexCount();
        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.found_n_in_xml, indexCount));
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.oct_ad_view_oct_ad_slotId) {
                setAdSlotId(obtainStyledAttributes.getString(index));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.placement_id, obtainStyledAttributes.getString(index)));
            } else if (index == R.styleable.oct_ad_view_oct_test) {
                xoIox.oIX0oI().f19080oxoX = obtainStyledAttributes.getBoolean(index, false);
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_set_test, xoIox.oIX0oI().f19080oxoX));
            } else if (index == R.styleable.oct_ad_view_oct_opens_native_browser) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.xml_set_opens_native_browser));
                setOpensNativeBrowser(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.oct_ad_view_oct_show_loading_indicator) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.show_loading_indicator_xml));
                setShowLoadingIndicator(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == R.styleable.oct_ad_view_oct_load_landing_page_in_background) {
                setLoadsInBackground(obtainStyledAttributes.getBoolean(index, true));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_load_landing_page_in_background, this.f18766IoOoX));
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void xXxxox0I() {
        this.f19007oI = true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void xoIox() {
        super.xoIox();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void xoXoI(Context context, AttributeSet attributeSet) {
        super.xoXoI(context, attributeSet);
        this.f18774OI0.X0o0xo(-1);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        try {
            Activity activity = (Activity) context;
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            i -= activity.getWindow().findViewById(android.R.id.content).getTop();
        } catch (ClassCastException unused) {
        }
        xoIox oIX0oI2 = xoIox.oIX0oI();
        int OxxIIOOXO2 = (int) ((i / oIX0oI2.OxxIIOOXO()) + 0.5f);
        this.f18784X00IoxXI.oO((int) ((i2 / oIX0oI2.oI0IIXIo()) + 0.5f));
        this.f18784X00IoxXI.Oo(OxxIIOOXO2);
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean xoxXI() {
        return true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, oOoIIO0.II0xO0
    public void xxIXOIIO() {
        super.xxIXOIIO();
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19009x0OIX00oO = 0;
        this.f19006XXoOx0 = 10000;
        this.f19008oOoIIO0 = new LinkedList();
        this.f19003IXO = null;
        this.f19007oI = false;
        this.f19004Ix00oIoI = false;
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19009x0OIX00oO = 0;
        this.f19006XXoOx0 = 10000;
        this.f19008oOoIIO0 = new LinkedList();
        this.f19003IXO = null;
        this.f19007oI = false;
        this.f19004Ix00oIoI = false;
    }
}
