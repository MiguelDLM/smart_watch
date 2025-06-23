package com.baidu.navisdk.ui.widget.bucket;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.ui.widget.bucket.BNBucketItem;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class BNViewPriorityBucket extends LinearLayout implements BNBucketItem.Callback {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String SPACE_VIEW_TAG = "spaceView";

    @OOXIXo
    public static final String TAG = "BNPriorityBucket";
    private ArrayList<BNBucketItem> bottomAddedItemList;

    @oOoXoXO
    private ArrayList<BNBucketItem> goneByPriorityItemList;

    @oOoXoXO
    private ArrayList<BNBucketItem> needRemoveFromNotAddedList;

    @oOoXoXO
    private ArrayList<BNBucketItem> notAddedItemList;
    private View.OnLayoutChangeListener onLayoutChangeListener;
    private int screenOrientation;
    private final View spaceView;

    @oOoXoXO
    private OnStatueChangeListener statusChangeListener;
    private ArrayList<BNBucketItem> topAddedItemList;

    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public enum ItemLocation {
        START,
        END
    }

    /* loaded from: classes8.dex */
    public static abstract class OnStatueChangeListener {
        public void onAddView(@oOoXoXO BNBucketItem bNBucketItem, boolean z) {
        }

        public void onRemoveView(@oOoXoXO BNBucketItem bNBucketItem, boolean z) {
        }

        public void onVisibleChange(@oOoXoXO BNBucketItem bNBucketItem) {
        }
    }

    @xoIox
    public BNViewPriorityBucket(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final int addAndGetViewIndex(BNBucketItem bNBucketItem, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "addAndGetViewIndex: " + z);
        }
        if (bNBucketItem == null) {
            return -1;
        }
        if (this.topAddedItemList == null) {
            this.topAddedItemList = new ArrayList<>(6);
        }
        if (this.bottomAddedItemList == null) {
            this.bottomAddedItemList = new ArrayList<>(6);
        }
        int i = 0;
        if (bNBucketItem.getItemLocation() == ItemLocation.START) {
            ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
            IIX0o.ooOOo0oXI(arrayList);
            if (!arrayList.contains(bNBucketItem)) {
                ArrayList<BNBucketItem> arrayList2 = this.topAddedItemList;
                IIX0o.ooOOo0oXI(arrayList2);
                Iterator<T> it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        BNBucketItem bNBucketItem2 = (BNBucketItem) it.next();
                        if (z) {
                            if (bNBucketItem2.getPriority() > bNBucketItem.getPriority()) {
                                break;
                            }
                            i++;
                        } else {
                            if (bNBucketItem2.getLandPriority() > bNBucketItem.getLandPriority()) {
                                break;
                            }
                            i++;
                        }
                    } else {
                        i = arrayList2.size();
                        break;
                    }
                }
                ArrayList<BNBucketItem> arrayList3 = this.topAddedItemList;
                IIX0o.ooOOo0oXI(arrayList3);
                arrayList3.add(i, bNBucketItem);
                return i;
            }
            ArrayList<BNBucketItem> arrayList4 = this.topAddedItemList;
            IIX0o.ooOOo0oXI(arrayList4);
            return arrayList4.indexOf(bNBucketItem);
        }
        ArrayList<BNBucketItem> arrayList5 = this.bottomAddedItemList;
        IIX0o.ooOOo0oXI(arrayList5);
        int size = arrayList5.size();
        ArrayList<BNBucketItem> arrayList6 = this.bottomAddedItemList;
        IIX0o.ooOOo0oXI(arrayList6);
        if (!arrayList6.contains(bNBucketItem)) {
            ArrayList<BNBucketItem> arrayList7 = this.bottomAddedItemList;
            IIX0o.ooOOo0oXI(arrayList7);
            Iterator<T> it2 = arrayList7.iterator();
            while (true) {
                if (it2.hasNext()) {
                    BNBucketItem bNBucketItem3 = (BNBucketItem) it2.next();
                    if (z) {
                        if (bNBucketItem3.getPriority() > bNBucketItem.getPriority()) {
                            break;
                        }
                        i++;
                    } else {
                        if (bNBucketItem3.getLandPriority() > bNBucketItem.getLandPriority()) {
                            break;
                        }
                        i++;
                    }
                } else {
                    i = arrayList7.size();
                    break;
                }
            }
            ArrayList<BNBucketItem> arrayList8 = this.bottomAddedItemList;
            IIX0o.ooOOo0oXI(arrayList8);
            arrayList8.add(i, bNBucketItem);
        } else {
            ArrayList<BNBucketItem> arrayList9 = this.bottomAddedItemList;
            IIX0o.ooOOo0oXI(arrayList9);
            i = arrayList9.indexOf(bNBucketItem);
            size--;
        }
        ArrayList<BNBucketItem> arrayList10 = this.topAddedItemList;
        IIX0o.ooOOo0oXI(arrayList10);
        return (size - i) + arrayList10.size() + 1;
    }

    private final void addItemToNotAdded(BNBucketItem bNBucketItem) {
        if (bNBucketItem == null) {
            return;
        }
        if (this.notAddedItemList == null) {
            this.notAddedItemList = new ArrayList<>(6);
        }
        ArrayList<BNBucketItem> arrayList = this.notAddedItemList;
        if (arrayList != null) {
            arrayList.add(bNBucketItem);
        }
    }

    private final void addToNeedRemoveList(BNBucketItem bNBucketItem) {
        ArrayList<BNBucketItem> arrayList;
        if (bNBucketItem != null && (arrayList = this.needRemoveFromNotAddedList) != null) {
            arrayList.add(bNBucketItem);
        }
    }

    private final void clearNotAddItemList() {
        ArrayList<BNBucketItem> arrayList = this.needRemoveFromNotAddedList;
        if (arrayList != null) {
            for (BNBucketItem bNBucketItem : arrayList) {
                ArrayList<BNBucketItem> arrayList2 = this.notAddedItemList;
                if (arrayList2 != null) {
                    arrayList2.remove(bNBucketItem);
                }
            }
        }
        ArrayList<BNBucketItem> arrayList3 = this.needRemoveFromNotAddedList;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private final BNBucketItem getItemInAdded(int i) {
        BNBucketItem bNBucketItem;
        Object obj;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "getItemInAdded:" + i);
        }
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        BNBucketItem bNBucketItem2 = null;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((BNBucketItem) obj).getId() == i) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            bNBucketItem = (BNBucketItem) obj;
        } else {
            bNBucketItem = null;
        }
        if (bNBucketItem == null) {
            ArrayList<BNBucketItem> arrayList2 = this.bottomAddedItemList;
            if (arrayList2 != null) {
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (((BNBucketItem) next).getId() == i) {
                        bNBucketItem2 = next;
                        break;
                    }
                }
                bNBucketItem2 = bNBucketItem2;
            }
        } else {
            bNBucketItem2 = bNBucketItem;
        }
        g gVar2 = g.COMMON_UI;
        if (gVar2.d()) {
            gVar2.e(TAG, "getItemInAdded:" + i + "->" + bNBucketItem2);
        }
        return bNBucketItem2;
    }

    private final BNBucketItem getItemInNotAdded(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "getItemInNotAdded:" + i);
        }
        ArrayList<BNBucketItem> arrayList = this.notAddedItemList;
        Object obj = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((BNBucketItem) next).getId() == i) {
                obj = next;
                break;
            }
        }
        return (BNBucketItem) obj;
    }

    private final void initNeedRemoveList() {
        ArrayList<BNBucketItem> arrayList = this.needRemoveFromNotAddedList;
        if (arrayList == null) {
            this.needRemoveFromNotAddedList = new ArrayList<>(6);
        } else {
            IIX0o.ooOOo0oXI(arrayList);
            arrayList.clear();
        }
    }

    private final <T> int insertIndexOfFirst(List<? extends T> list, Oox.oOoXoXO<? super T, Boolean> oooxoxo) {
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (oooxoxo.invoke(it.next()).booleanValue()) {
                return i;
            }
            i++;
        }
        return list.size();
    }

    private final boolean isContainerAdded(int i) {
        if (getItemInAdded(i) != null) {
            return true;
        }
        return false;
    }

    private final int refreshView(BNBucketItem bNBucketItem, boolean z) {
        if (bNBucketItem == null) {
            return 8;
        }
        int refreshViewVisibility = refreshViewVisibility(bNBucketItem, z);
        if (z || refreshViewVisibility != 8) {
            refreshViewStyle(bNBucketItem);
        }
        return refreshViewVisibility;
    }

    private final void refreshViewStyle(BNBucketItem bNBucketItem) {
        View view;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshViewStyle:" + bNBucketItem);
        }
        if (bNBucketItem != null) {
            view = bNBucketItem.getView();
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        bNBucketItem.onRefreshViewStyle(this.screenOrientation);
    }

    private final int refreshViewVisibility(BNBucketItem bNBucketItem, boolean z) {
        boolean z2;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshViewVisibility:" + bNBucketItem + ", " + z);
        }
        if (bNBucketItem == null) {
            return 8;
        }
        int onVisibility = bNBucketItem.onVisibility(this.screenOrientation);
        if (z && bNBucketItem.isValid()) {
            View view = bNBucketItem.getView();
            if (view == null || view.getVisibility() != onVisibility) {
                if (!bNBucketItem.isInterceptSetVisible(onVisibility)) {
                    View view2 = bNBucketItem.getView();
                    if (view2 != null) {
                        view2.setVisibility(onVisibility);
                    }
                } else {
                    bNBucketItem.onInterceptSetVisible(bNBucketItem.getView(), onVisibility);
                }
                bNBucketItem.onVisibleChange(onVisibility);
            }
        } else if (onVisibility != 8) {
            if (this.screenOrientation != 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!showView(bNBucketItem, onVisibility, z2)) {
                return 8;
            }
            addToNeedRemoveList(bNBucketItem);
        }
        return onVisibility;
    }

    private final int refreshViewVisibilityById(int i) {
        boolean z;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshViewByTag:" + i);
        }
        BNBucketItem itemInAdded = getItemInAdded(i);
        if (itemInAdded == null) {
            itemInAdded = getItemInNotAdded(i);
            z = false;
        } else {
            z = true;
        }
        int refreshViewVisibility = refreshViewVisibility(itemInAdded, z);
        if (!z && refreshViewVisibility != 8) {
            removeItemInNotAdded(i);
        }
        OnStatueChangeListener onStatueChangeListener = this.statusChangeListener;
        if (onStatueChangeListener != null) {
            onStatueChangeListener.onVisibleChange(itemInAdded);
        }
        return refreshViewVisibility;
    }

    private final BNBucketItem removeItemInNotAdded(int i) {
        ArrayList<BNBucketItem> arrayList = this.notAddedItemList;
        BNBucketItem bNBucketItem = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<T> it = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (((BNBucketItem) it.next()).getId() == i) {
                bNBucketItem = arrayList.remove(i2);
                break;
            }
            i2++;
        }
        return bNBucketItem;
    }

    private final <T> T removeOfFirst(List<T> list, Oox.oOoXoXO<? super T, Boolean> oooxoxo) {
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (oooxoxo.invoke(it.next()).booleanValue()) {
                return list.remove(i);
            }
            i++;
        }
        return null;
    }

    private final boolean removeViewByItemInAdded(BNBucketItem bNBucketItem) {
        boolean z;
        if (bNBucketItem == null) {
            return false;
        }
        if (bNBucketItem.getView() != null) {
            removeView(bNBucketItem.getView());
        }
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        if (arrayList != null) {
            z = arrayList.remove(bNBucketItem);
        } else {
            z = false;
        }
        if (!z) {
            ArrayList<BNBucketItem> arrayList2 = this.bottomAddedItemList;
            if (arrayList2 == null) {
                return false;
            }
            return arrayList2.remove(bNBucketItem);
        }
        return z;
    }

    private final boolean showView(BNBucketItem bNBucketItem, int i, boolean z) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "showView :" + bNBucketItem + ", visible:" + i + ", isPortrait" + z);
        }
        if (!bNBucketItem.isValid()) {
            int i2 = this.screenOrientation;
            Context context = getContext();
            IIX0o.oO(context, "this.context");
            bNBucketItem.loadBucketItem(this, i2, context);
        } else {
            refreshViewStyle(bNBucketItem);
        }
        if (!bNBucketItem.isValid()) {
            if (gVar.c()) {
                gVar.c(TAG, "showView not valid:" + bNBucketItem + ", visible:" + i);
            }
            return false;
        }
        int addAndGetViewIndex = addAndGetViewIndex(bNBucketItem, z);
        if (gVar.d()) {
            gVar.e(TAG, "showView " + bNBucketItem + " index:" + addAndGetViewIndex);
        }
        if (addAndGetViewIndex < 0) {
            return false;
        }
        View view = bNBucketItem.getView();
        IIX0o.ooOOo0oXI(view);
        if (view.getParent() instanceof ViewGroup) {
            View view2 = bNBucketItem.getView();
            IIX0o.ooOOo0oXI(view2);
            ViewParent parent = view2.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(bNBucketItem.getView());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        if (gVar.c() && addAndGetViewIndex > getChildCount()) {
            g.PRO_NAV.c(TAG, "index exception: " + String.valueOf(this.topAddedItemList) + " ; " + String.valueOf(this.bottomAddedItemList));
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                g.PRO_NAV.c(TAG, "index exception child: " + childAt);
            }
        }
        if (addAndGetViewIndex > getChildCount()) {
            addAndGetViewIndex = getChildCount();
        }
        addView(bNBucketItem.getView(), addAndGetViewIndex);
        View.OnClickListener onClickListener = bNBucketItem.getOnClickListener();
        if (onClickListener != null) {
            View view3 = bNBucketItem.getView();
            IIX0o.ooOOo0oXI(view3);
            view3.setOnClickListener(onClickListener);
        }
        if (!bNBucketItem.isInterceptSetVisible(i)) {
            View view4 = bNBucketItem.getView();
            IIX0o.ooOOo0oXI(view4);
            view4.setVisibility(i);
        } else {
            bNBucketItem.onInterceptSetVisible(bNBucketItem.getView(), i);
        }
        bNBucketItem.onVisibleChange(i);
        OnStatueChangeListener onStatueChangeListener = this.statusChangeListener;
        if (onStatueChangeListener != null) {
            onStatueChangeListener.onAddView(bNBucketItem, true);
        }
        return true;
    }

    public final void addBucketLayoutChangeListener(@OOXIXo View.OnLayoutChangeListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        removeBucketLayoutChangeListener();
        this.onLayoutChangeListener = listener;
        addOnLayoutChangeListener(listener);
    }

    public final boolean addItem(@oOoXoXO BNBucketItem bNBucketItem, int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "addView:" + bNBucketItem + " + " + i);
        }
        this.screenOrientation = i;
        boolean z = false;
        if (bNBucketItem == null) {
            return false;
        }
        int onVisibility = bNBucketItem.onVisibility(i);
        bNBucketItem.setCallback(this);
        BNBucketItem itemInAdded = getItemInAdded(bNBucketItem.getId());
        if (itemInAdded != null) {
            refreshView(itemInAdded, true);
            OnStatueChangeListener onStatueChangeListener = this.statusChangeListener;
            if (onStatueChangeListener != null) {
                onStatueChangeListener.onVisibleChange(itemInAdded);
            }
            return false;
        }
        BNBucketItem itemInNotAdded = getItemInNotAdded(bNBucketItem.getId());
        if (onVisibility == 8) {
            if (itemInNotAdded == null) {
                addItemToNotAdded(bNBucketItem);
            }
        } else {
            if (itemInNotAdded != null) {
                bNBucketItem = itemInNotAdded;
            }
            if (i != 2) {
                z = true;
            }
            if (showView(bNBucketItem, onVisibility, z)) {
                OnStatueChangeListener onStatueChangeListener2 = this.statusChangeListener;
                if (onStatueChangeListener2 != null) {
                    onStatueChangeListener2.onVisibleChange(bNBucketItem);
                }
                removeItemInNotAdded(bNBucketItem.getId());
            }
        }
        return true;
    }

    public final void destroy() {
        removeBucketLayoutChangeListener();
        removeAllViews();
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((BNBucketItem) it.next()).onDestroy();
            }
        }
        ArrayList<BNBucketItem> arrayList2 = this.bottomAddedItemList;
        if (arrayList2 != null) {
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((BNBucketItem) it2.next()).onDestroy();
            }
        }
        ArrayList<BNBucketItem> arrayList3 = this.notAddedItemList;
        if (arrayList3 != null) {
            Iterator<T> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ((BNBucketItem) it3.next()).onDestroy();
            }
        }
    }

    public final int getBottomVisibleSize() {
        ArrayList<BNBucketItem> arrayList = this.bottomAddedItemList;
        int i = 0;
        if (arrayList != null) {
            for (BNBucketItem bNBucketItem : arrayList) {
                if (bNBucketItem.isValid()) {
                    View view = bNBucketItem.getView();
                    IIX0o.ooOOo0oXI(view);
                    if (view.getVisibility() == 0) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    @oOoXoXO
    public final View getFirstVisibleView() {
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            view = getChildAt(i);
            if (view != null && view.getVisibility() == 0) {
                break;
            }
        }
        return view;
    }

    @oOoXoXO
    public final ArrayList<BNBucketItem> getGoneByPriorityItemList() {
        return this.goneByPriorityItemList;
    }

    public final int getGoneByPrioritySize() {
        ArrayList<BNBucketItem> arrayList = this.goneByPriorityItemList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @oOoXoXO
    public final ArrayList<BNBucketItem> getNeedRemoveFromNotAddedList() {
        return this.needRemoveFromNotAddedList;
    }

    @oOoXoXO
    public final ArrayList<BNBucketItem> getNotAddedItemList() {
        return this.notAddedItemList;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    @oOoXoXO
    public final OnStatueChangeListener getStatusChangeListener() {
        return this.statusChangeListener;
    }

    public final int getTopVisibleSize() {
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        int i = 0;
        if (arrayList != null) {
            for (BNBucketItem bNBucketItem : arrayList) {
                if (bNBucketItem.isValid()) {
                    View view = bNBucketItem.getView();
                    IIX0o.ooOOo0oXI(view);
                    if (view.getVisibility() == 0) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public final void goneBottomItemByPriority() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "goneBottomItemByPriority:");
        }
        ArrayList<BNBucketItem> arrayList = this.bottomAddedItemList;
        BNBucketItem bNBucketItem = null;
        if (arrayList != null) {
            for (BNBucketItem bNBucketItem2 : arrayList) {
                if (bNBucketItem2.isSupportPriorityGone()) {
                    if (bNBucketItem == null) {
                        if (bNBucketItem2.isVisible()) {
                            bNBucketItem = bNBucketItem2;
                        }
                    } else if (bNBucketItem2.isVisible()) {
                        int priorityForGone = bNBucketItem2.getPriorityForGone();
                        IIX0o.ooOOo0oXI(bNBucketItem);
                        if (priorityForGone < bNBucketItem.getPriorityForGone()) {
                            bNBucketItem = bNBucketItem2;
                        }
                    }
                }
            }
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(TAG, "goneBottomItemByPriority: " + bNBucketItem);
        }
        if (bNBucketItem != null) {
            bNBucketItem.setGoneByPriority(true);
            bNBucketItem.refreshVisible();
            if (this.goneByPriorityItemList == null) {
                this.goneByPriorityItemList = new ArrayList<>(4);
            }
            ArrayList<BNBucketItem> arrayList2 = this.goneByPriorityItemList;
            if (arrayList2 != null) {
                arrayList2.add(bNBucketItem);
            }
        }
    }

    public final boolean isSpaceView(@oOoXoXO View view) {
        Object obj;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if ((obj instanceof String) && IIX0o.Oxx0IOOO(SPACE_VIEW_TAG, view.getTag())) {
            return true;
        }
        return false;
    }

    public final void recoverBottomForPriorityGone(int i) {
        ListIterator<BNBucketItem> listIterator;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "recoverBottomForPriorityGone:" + i);
            gVar.e(TAG, "recoverBottomForPriorityGone:" + this.goneByPriorityItemList);
        }
        if (i <= 0) {
            return;
        }
        ArrayList<BNBucketItem> arrayList = this.goneByPriorityItemList;
        if (arrayList != null) {
            listIterator = arrayList.listIterator();
        } else {
            listIterator = null;
        }
        while (listIterator != null && listIterator.hasNext()) {
            BNBucketItem next = listIterator.next();
            next.setGoneByPriority(false);
            if (next.refreshVisible() == 0) {
                i--;
            }
            listIterator.remove();
            if (i <= 0) {
                return;
            }
        }
    }

    public final void refreshAllView() {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshAllView:");
        }
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                refreshView((BNBucketItem) it.next(), true);
            }
        }
        ArrayList<BNBucketItem> arrayList2 = this.bottomAddedItemList;
        if (arrayList2 != null) {
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                refreshView((BNBucketItem) it2.next(), true);
            }
        }
        initNeedRemoveList();
        ArrayList<BNBucketItem> arrayList3 = this.notAddedItemList;
        if (arrayList3 != null) {
            Iterator<T> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                refreshView((BNBucketItem) it3.next(), false);
            }
        }
        clearNotAddItemList();
        OnStatueChangeListener onStatueChangeListener = this.statusChangeListener;
        if (onStatueChangeListener != null) {
            onStatueChangeListener.onVisibleChange(null);
        }
    }

    public final void refreshAllViewStyle() {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshAllViewStyle:");
        }
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                refreshViewStyle((BNBucketItem) it.next());
            }
        }
        ArrayList<BNBucketItem> arrayList2 = this.bottomAddedItemList;
        if (arrayList2 != null) {
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                refreshViewStyle((BNBucketItem) it2.next());
            }
        }
    }

    public final void refreshAllViewVisibility() {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshAllView");
        }
        ArrayList<BNBucketItem> arrayList = this.topAddedItemList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                refreshViewVisibility((BNBucketItem) it.next(), true);
            }
        }
        ArrayList<BNBucketItem> arrayList2 = this.bottomAddedItemList;
        if (arrayList2 != null) {
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                refreshViewVisibility((BNBucketItem) it2.next(), true);
            }
        }
        initNeedRemoveList();
        ArrayList<BNBucketItem> arrayList3 = this.notAddedItemList;
        if (arrayList3 != null) {
            Iterator<T> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                refreshViewVisibility((BNBucketItem) it3.next(), false);
            }
        }
        clearNotAddItemList();
        OnStatueChangeListener onStatueChangeListener = this.statusChangeListener;
        if (onStatueChangeListener != null) {
            onStatueChangeListener.onVisibleChange(null);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem.Callback
    public void refreshStyle(int i) {
        refreshViewStyleById(i);
    }

    public final void refreshViewById(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshViewByTag:" + i);
        }
        BNBucketItem itemInAdded = getItemInAdded(i);
        if (itemInAdded != null) {
            refreshView(itemInAdded, true);
            return;
        }
        BNBucketItem itemInNotAdded = getItemInNotAdded(i);
        if (itemInNotAdded != null && refreshView(itemInNotAdded, false) != 8) {
            removeItemInNotAdded(i);
        }
    }

    public final void refreshViewStyleById(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "refreshViewStyleByTag:" + i);
        }
        refreshViewStyle(getItemInAdded(i));
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem.Callback
    public int refreshVisibility(int i) {
        return refreshViewVisibilityById(i);
    }

    public final void removeBucketLayoutChangeListener() {
        View.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Nullable
    @oOoXoXO
    public final BNBucketItem removeView(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e(TAG, "removeView:" + i);
        }
        BNBucketItem itemInAdded = getItemInAdded(i);
        if (itemInAdded != null) {
            removeViewByItemInAdded(itemInAdded);
            OnStatueChangeListener onStatueChangeListener = this.statusChangeListener;
            if (onStatueChangeListener != null) {
                onStatueChangeListener.onRemoveView(itemInAdded, true);
            }
        } else {
            itemInAdded = removeItemInNotAdded(i);
        }
        if (itemInAdded != null) {
            itemInAdded.onDestroy();
        }
        OnStatueChangeListener onStatueChangeListener2 = this.statusChangeListener;
        if (onStatueChangeListener2 != null) {
            onStatueChangeListener2.onVisibleChange(itemInAdded);
        }
        return itemInAdded;
    }

    public final void setGoneByPriorityItemList(@oOoXoXO ArrayList<BNBucketItem> arrayList) {
        this.goneByPriorityItemList = arrayList;
    }

    public final void setNeedRemoveFromNotAddedList(@oOoXoXO ArrayList<BNBucketItem> arrayList) {
        this.needRemoveFromNotAddedList = arrayList;
    }

    public final void setNotAddedItemList(@oOoXoXO ArrayList<BNBucketItem> arrayList) {
        this.notAddedItemList = arrayList;
    }

    public final void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }

    public final void setStatusChangeListener(@oOoXoXO OnStatueChangeListener onStatueChangeListener) {
        this.statusChangeListener = onStatueChangeListener;
    }

    @xoIox
    public BNViewPriorityBucket(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNViewPriorityBucket(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        int i2 = 1;
        this.screenOrientation = 1;
        int i3 = -2;
        if (getOrientation() == 0) {
            i2 = -2;
            i3 = 1;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.weight = 1.0f;
        View view = new View(context);
        this.spaceView = view;
        view.setLayoutParams(layoutParams);
        view.setTag(SPACE_VIEW_TAG);
        addView(view, 0);
    }

    public /* synthetic */ BNViewPriorityBucket(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
