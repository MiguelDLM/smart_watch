package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.R;

/* loaded from: classes13.dex */
public class AutoPlayRecyclerView extends RecyclerView {
    private AutoPlaySnapHelper autoPlaySnapHelper;

    public AutoPlayRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AutoPlaySnapHelper autoPlaySnapHelper;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && (autoPlaySnapHelper = this.autoPlaySnapHelper) != null) {
                autoPlaySnapHelper.start();
            }
        } else {
            AutoPlaySnapHelper autoPlaySnapHelper2 = this.autoPlaySnapHelper;
            if (autoPlaySnapHelper2 != null) {
                autoPlaySnapHelper2.pause();
            }
        }
        return dispatchTouchEvent;
    }

    public void pause() {
        this.autoPlaySnapHelper.pause();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.autoPlaySnapHelper.attachToRecyclerView(this);
    }

    public void start() {
        this.autoPlaySnapHelper.start();
    }

    public AutoPlayRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoPlayRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SMAutoPlayRecyclerView);
        int i2 = obtainStyledAttributes.getInt(R.styleable.SMAutoPlayRecyclerView_sm_timeInterval, 2000);
        int i3 = obtainStyledAttributes.getInt(R.styleable.SMAutoPlayRecyclerView_sm_direction, 2);
        obtainStyledAttributes.recycle();
        this.autoPlaySnapHelper = new AutoPlaySnapHelper(i2, i3);
    }
}
