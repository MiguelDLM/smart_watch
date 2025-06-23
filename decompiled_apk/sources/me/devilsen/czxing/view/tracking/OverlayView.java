package me.devilsen.czxing.view.tracking;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class OverlayView extends View {

    /* renamed from: XO, reason: collision with root package name */
    public final List<oIX0oI> f30969XO;

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        void oIX0oI(Canvas canvas);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30969XO = new LinkedList();
    }

    @Override // android.view.View
    public synchronized void draw(Canvas canvas) {
        super.draw(canvas);
        Iterator<oIX0oI> it = this.f30969XO.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(canvas);
        }
    }

    public void oIX0oI(oIX0oI oix0oi) {
        this.f30969XO.add(oix0oi);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Log.e("TAG", "OverlayView size:  height = " + getHeight() + " width = " + getWidth());
    }
}
