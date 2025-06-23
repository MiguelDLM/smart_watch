package com.sma.smartv3.view.swipelist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class SwipeListView extends ListView {

    /* renamed from: XO, reason: collision with root package name */
    public boolean f25770XO;

    public SwipeListView(Context context) {
        super(context);
        this.f25770XO = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.f25770XO = true;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void oIX0oI() {
        if (this.f25770XO) {
            this.f25770XO = false;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                SwipeLayout swipeLayout = (SwipeLayout) getChildAt(i).findViewById(R.id.swipe_layout);
                if (swipeLayout != null) {
                    swipeLayout.X0o0xo(true);
                }
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 2) {
            oIX0oI();
        }
        return super.onTouchEvent(ev);
    }

    public SwipeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f25770XO = true;
    }

    public SwipeListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f25770XO = true;
    }
}
