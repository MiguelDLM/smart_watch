package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdNativeView;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_for {
    private List<WeakReference<TanxFeedAdNativeView>> tanxc_do;
    private List<WeakReference<TanxFeedAdWebView>> tanxc_for;
    private List<WeakReference<TanxFeedAdInteractionView>> tanxc_if;

    public TanxFeedAdView tanxc_do(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxFeedAdNativeView tanxFeedAdNativeView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_do == null) {
            this.tanxc_do = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxFeedAdNativeView>> it = this.tanxc_do.iterator();
        while (it.hasNext()) {
            TanxFeedAdNativeView tanxFeedAdNativeView2 = it.next().get();
            if (tanxFeedAdNativeView2 == null) {
                it.remove();
            } else if (tanxFeedAdNativeView == null && tanxFeedAdNativeView2.getParent() == null) {
                tanxFeedAdNativeView = tanxFeedAdNativeView2;
            }
        }
        if (tanxFeedAdNativeView == null) {
            TanxFeedAdNativeView tanxFeedAdNativeView3 = new TanxFeedAdNativeView(context);
            this.tanxc_do.add(new WeakReference<>(tanxFeedAdNativeView3));
            return tanxFeedAdNativeView3;
        }
        return tanxFeedAdNativeView;
    }

    public TanxFeedAdView tanxc_for(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxFeedAdWebView tanxFeedAdWebView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxFeedAdWebView>> it = this.tanxc_for.iterator();
        while (it.hasNext()) {
            TanxFeedAdWebView tanxFeedAdWebView2 = it.next().get();
            if (tanxFeedAdWebView2 == null) {
                it.remove();
            } else if (tanxFeedAdWebView == null && tanxFeedAdWebView2.getParent() == null) {
                tanxFeedAdWebView = tanxFeedAdWebView2;
            }
        }
        if (tanxFeedAdWebView == null) {
            TanxFeedAdWebView tanxFeedAdWebView3 = new TanxFeedAdWebView(context);
            this.tanxc_for.add(new WeakReference<>(tanxFeedAdWebView3));
            return tanxFeedAdWebView3;
        }
        return tanxFeedAdWebView;
    }

    public TanxFeedAdView tanxc_if(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxFeedAdInteractionView tanxFeedAdInteractionView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_if == null) {
            this.tanxc_if = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxFeedAdInteractionView>> it = this.tanxc_if.iterator();
        while (it.hasNext()) {
            TanxFeedAdInteractionView tanxFeedAdInteractionView2 = it.next().get();
            if (tanxFeedAdInteractionView2 == null) {
                it.remove();
            } else if (tanxFeedAdInteractionView == null && tanxFeedAdInteractionView2.getParent() == null) {
                tanxFeedAdInteractionView = tanxFeedAdInteractionView2;
            }
        }
        if (tanxFeedAdInteractionView == null) {
            TanxFeedAdInteractionView tanxFeedAdInteractionView3 = new TanxFeedAdInteractionView(context);
            this.tanxc_if.add(new WeakReference<>(tanxFeedAdInteractionView3));
            return tanxFeedAdInteractionView3;
        }
        return tanxFeedAdInteractionView;
    }
}
