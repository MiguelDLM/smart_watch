package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class BNFrameLayout extends FrameLayout implements IVisibility {
    private static final String ANIM_VISIBLE = "anim_visible";
    private static final String DEFAULT_VISIBLE = "default_visible";
    private static final String TAG = "BNFrameLayout";
    private BNOnTouchListener mTouchEventListener;
    private Map<String, Boolean> mVisibleMap;

    public BNFrameLayout(@NonNull Context context) {
        super(context);
    }

    private Map<String, Boolean> getVisibleMap() {
        if (this.mVisibleMap == null) {
            this.mVisibleMap = new HashMap();
        }
        return this.mVisibleMap;
    }

    private boolean isVisibilityValid(int i) {
        return i == 0 || i == 4 || i == 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "dispatchTouchEvent --> event = " + motionEvent + ", BNFrameLayout = " + this);
        }
        BNOnTouchListener bNOnTouchListener = this.mTouchEventListener;
        if (bNOnTouchListener != null) {
            bNOnTouchListener.onTouch(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onInterceptTouchEvent --> event = " + motionEvent + ", BNFrameLayout = " + this);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onTouchEvent() --> event = " + motionEvent + ", BNFrameLayout = " + this);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setTouchEventListener(BNOnTouchListener bNOnTouchListener) {
        this.mTouchEventListener = bNOnTouchListener;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        String obj;
        if (!isVisibilityValid(i)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setVisibility --> visibility is illegal!!! visibility = " + i);
                LogUtil.printException("BNFrameLayout setVisibility visibility: " + i + ", invalid visibility!!!", new IllegalArgumentException());
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibility --> tag = ");
            if (getTag() == null) {
                obj = "null";
            } else {
                obj = getTag().toString();
            }
            sb.append(obj);
            sb.append(", visibility = ");
            sb.append(i);
            LogUtil.e(TAG, sb.toString());
        }
        Map<String, Boolean> visibleMap = getVisibleMap();
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        visibleMap.put(DEFAULT_VISIBLE, Boolean.valueOf(z));
        super.setVisibility(i);
    }

    @Override // com.baidu.navisdk.ui.widget.IVisibility
    public void setVisible(boolean z) {
        setVisible(DEFAULT_VISIBLE, z);
    }

    @Override // com.baidu.navisdk.ui.widget.IVisibility
    public void setVisibleByAnim(boolean z) {
        setVisible(ANIM_VISIBLE, z);
    }

    public BNFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.navisdk.ui.widget.IVisibility
    public void setVisible(String str, boolean z) {
        boolean z2;
        getVisibleMap().put(str, Boolean.valueOf(z));
        if (!getVisibleMap().containsKey(DEFAULT_VISIBLE)) {
            getVisibleMap().put(DEFAULT_VISIBLE, Boolean.valueOf(getVisibility() == 0));
        }
        Iterator<Boolean> it = getVisibleMap().values().iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z2 = z2 && it.next().booleanValue();
            }
        }
        super.setVisibility(z2 ? 0 : 8);
    }

    public BNFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
