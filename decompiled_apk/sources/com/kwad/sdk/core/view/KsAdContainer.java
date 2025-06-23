package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.ac;

/* loaded from: classes11.dex */
public class KsAdContainer extends RelativeLayout {
    protected ac.a aDU;

    public KsAdContainer(Context context) {
        super(context);
        this.aDU = new ac.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.aDU.g(motionEvent.getX(), motionEvent.getY());
            }
        } else {
            ac.a aVar = new ac.a(getWidth(), getHeight());
            this.aDU = aVar;
            aVar.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public ac.a getTouchCoords() {
        return this.aDU;
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDU = new ac.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDU = new ac.a();
    }
}
