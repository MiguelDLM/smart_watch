package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.gms.maps.MapView;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CustomGoogleMapView extends MapView {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oIX0oI f24878XO;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI(@OXOo.OOXIXo MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CustomGoogleMapView(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@OXOo.OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        oIX0oI oix0oi = this.f24878XO;
        if (oix0oi != null) {
            oix0oi.oIX0oI(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public final void setOnMapTouchListener(@OXOo.oOoXoXO oIX0oI oix0oi) {
        this.f24878XO = oix0oi;
    }

    public /* synthetic */ CustomGoogleMapView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CustomGoogleMapView(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs, int i) {
        super(context, attrs, i);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
    }
}
