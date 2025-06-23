package com.alimm.tanx.ui.image.glide.request.target;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.alimm.tanx.ui.image.glide.request.Request;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce = false;
    private static Integer tagId;
    private final SizeDeterminer sizeDeterminer;
    protected final T view;

    /* loaded from: classes.dex */
    public static class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        private final List<SizeReadyCallback> cbs = new ArrayList();
        private Point displayDimens;
        private SizeDeterminerLayoutListener layoutListener;
        private final View view;

        /* loaded from: classes.dex */
        public static class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called listener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.checkCurrentDimens();
                    return true;
                }
                return true;
            }
        }

        public SizeDeterminer(View view) {
            this.view = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkCurrentDimens() {
            if (this.cbs.isEmpty()) {
                return;
            }
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                notifyCbs(viewWidthOrParam, viewHeightOrParam);
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                }
                this.layoutListener = null;
            }
        }

        @TargetApi(13)
        private Point getDisplayDimens() {
            Point point = this.displayDimens;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            Point point2 = new Point();
            this.displayDimens = point2;
            defaultDisplay.getSize(point2);
            return this.displayDimens;
        }

        private int getSizeForParam(int i, boolean z) {
            if (i == -2) {
                Point displayDimens = getDisplayDimens();
                if (z) {
                    return displayDimens.y;
                }
                return displayDimens.x;
            }
            return i;
        }

        private int getViewHeightOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getHeight())) {
                return this.view.getHeight();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.height, true);
            }
            return 0;
        }

        private int getViewWidthOrParam() {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams == null) {
                return 0;
            }
            return getSizeForParam(layoutParams.width, false);
        }

        private boolean isSizeValid(int i) {
            return i > 0 || i == -2;
        }

        private void notifyCbs(int i, int i2) {
            Iterator<SizeReadyCallback> it = this.cbs.iterator();
            while (it.hasNext()) {
                it.next().onSizeReady(i, i2);
            }
            this.cbs.clear();
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.layoutListener = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }
    }

    public ViewTarget(T t) {
        if (t != null) {
            this.view = t;
            this.sizeDeterminer = new SizeDeterminer(t);
            return;
        }
        throw new NullPointerException("View must not be null!");
    }

    private Object getTag() {
        Integer num = tagId;
        if (num == null) {
            return this.view.getTag();
        }
        return this.view.getTag(num.intValue());
    }

    private void setTag(Object obj) {
        Integer num = tagId;
        if (num == null) {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
        } else {
            this.view.setTag(num.intValue(), obj);
        }
    }

    public static void setTagId(int i) {
        if (tagId == null && !isTagUsedAtLeastOnce) {
            tagId = Integer.valueOf(i);
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public Request getRequest() {
        Object tag = getTag();
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public T getView() {
        return this.view;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(Request request) {
        setTag(request);
    }

    public String toString() {
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Target for: ");
        oIX0oI2.append(this.view);
        return oIX0oI2.toString();
    }
}
