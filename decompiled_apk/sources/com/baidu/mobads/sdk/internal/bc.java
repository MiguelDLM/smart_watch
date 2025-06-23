package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.support.v4.media.RatingCompat;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes7.dex */
public class bc {
    public static void a(@NonNull Context context) {
        try {
            ViewCompat.generateViewId();
            AccessibilityNodeInfoCompat.obtain();
            LocalBroadcastManager.getInstance(context);
            new ViewPager(context);
            new NestedScrollView(context);
            new Fragment();
            new SwipeRefreshLayout(context);
            new RecyclerView(context);
            RatingCompat.newPercentageRating(1.0f);
            new ArraySet();
            new LongSparseArray();
            new LinearLayoutManager(context);
            new PagerSnapHelper();
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }
}
