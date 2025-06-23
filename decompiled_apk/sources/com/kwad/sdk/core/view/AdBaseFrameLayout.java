package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes11.dex */
public class AdBaseFrameLayout extends FrameLayout implements d, e {
    private static final ac.a aDU = new ac.a();
    private List<View.OnTouchListener> aDS;
    private c aDT;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.aDS = new ArrayList();
        this.aDT = new c();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (!this.aDS.contains(onTouchListener)) {
            this.aDS.add(onTouchListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            com.kwad.sdk.service.c.gatherException(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aDS.isEmpty()) {
            Iterator<View.OnTouchListener> it = this.aDS.iterator();
            while (it.hasNext()) {
                it.next().onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                aDU.g(motionEvent.getX(), motionEvent.getY());
            }
        } else {
            ac.a aVar = aDU;
            aVar.z(getWidth(), getHeight());
            aVar.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public ac.a getTouchCoords() {
        return aDU;
    }

    @Override // com.kwad.sdk.core.view.d
    @NonNull
    public c getWindowFocusChangeHelper() {
        return this.aDT;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.e.c.d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z);
        this.aDT.j(this, z);
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDS = new ArrayList();
        this.aDT = new c();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDS = new ArrayList();
        this.aDT = new c();
    }
}
