package com.baidu.navisdk.ui.widget.bucket;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public class BNBucketItem {

    @oOoXoXO
    private Callback callback;
    private final int id;
    private boolean isGoneByPriority;
    private final int landPriority;
    private final int priority;

    @oOoXoXO
    private View view;
    private int type = -1;

    @OOXIXo
    private BNViewPriorityBucket.ItemLocation itemLocation = BNViewPriorityBucket.ItemLocation.END;
    private int priorityForGone = Integer.MAX_VALUE;
    private boolean isSupportPriorityGone = true;

    /* loaded from: classes8.dex */
    public interface Callback {
        void refreshStyle(int i);

        int refreshVisibility(int i);
    }

    /* loaded from: classes8.dex */
    public interface Visibility {

        @OOXIXo
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int GONE = 8;
        public static final int INVISIBLE = 4;
        public static final int VISIBLE = 0;

        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int GONE = 8;
            public static final int INVISIBLE = 4;
            public static final int VISIBLE = 0;

            private Companion() {
            }
        }
    }

    public BNBucketItem(int i, int i2, int i3) {
        this.id = i;
        this.priority = i2;
        this.landPriority = i3;
    }

    public boolean equals(@oOoXoXO Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!IIX0o.Oxx0IOOO(cls2, cls)) {
            return false;
        }
        if (obj != null) {
            if (this.id == ((BNBucketItem) obj).id) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.widget.bucket.BNBucketItem");
    }

    @oOoXoXO
    public final Callback getCallback() {
        return this.callback;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final BNViewPriorityBucket.ItemLocation getItemLocation() {
        return this.itemLocation;
    }

    public final int getLandPriority() {
        return this.landPriority;
    }

    @oOoXoXO
    public View.OnClickListener getOnClickListener() {
        return null;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getPriorityForGone() {
        return this.priorityForGone;
    }

    public final int getType() {
        return this.type;
    }

    @oOoXoXO
    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        return this.id;
    }

    public final boolean isGoneByPriority() {
        return this.isGoneByPriority;
    }

    public boolean isInterceptSetVisible(int i) {
        return false;
    }

    public final boolean isSupportPriorityGone() {
        return this.isSupportPriorityGone;
    }

    public final boolean isValid() {
        if (this.view != null) {
            return true;
        }
        return false;
    }

    public final boolean isVisible() {
        int i;
        View view = this.view;
        if (view != null) {
            i = view.getVisibility();
        } else {
            i = 8;
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    public void loadBucketItem(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
    }

    public void onDestroy() {
        this.callback = null;
        this.view = null;
    }

    public void onInterceptSetVisible(@oOoXoXO View view, int i) {
    }

    public void onOrientationChangePre(int i) {
    }

    public void onRefreshViewStyle(int i) {
    }

    public int onVisibility(int i) {
        return 0;
    }

    public void onVisibleChange(int i) {
    }

    public final void refreshStyle() {
        Callback callback = this.callback;
        if (callback != null) {
            callback.refreshStyle(this.id);
        }
    }

    public final int refreshVisible() {
        Callback callback = this.callback;
        if (callback != null) {
            return callback.refreshVisibility(this.id);
        }
        return 8;
    }

    public final void removeFromParent() {
        View view = this.view;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            if (view.getParent() instanceof ViewGroup) {
                View view2 = this.view;
                IIX0o.ooOOo0oXI(view2);
                ViewParent parent = view2.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.view);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    public final void setCallback(@oOoXoXO Callback callback) {
        this.callback = callback;
    }

    public final void setGoneByPriority(boolean z) {
        this.isGoneByPriority = z;
    }

    public final void setItemLocation(@OOXIXo BNViewPriorityBucket.ItemLocation itemLocation) {
        IIX0o.x0xO0oo(itemLocation, "<set-?>");
        this.itemLocation = itemLocation;
    }

    public final void setPriorityForGone(int i) {
        this.priorityForGone = i;
    }

    public final void setSupportPriorityGone(boolean z) {
        this.isSupportPriorityGone = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setView(@oOoXoXO View view) {
        this.view = view;
    }

    @OOXIXo
    public String toString() {
        return "BNBucketItem(id=" + this.id + ", priority=" + this.priority + ", landPriority=" + this.landPriority + ", view=" + this.view + ", type=" + this.type + ", itemLocation=" + this.itemLocation + ",isGoneByPriority=" + this.isGoneByPriority + HexStringBuilder.COMMENT_END_CHAR;
    }
}
