package com.alimm.tanx.core.view.feed;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.feed.TanxVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tanxc_do {
    private List<WeakReference<TanxVideoView>> tanxc_do;

    public TanxVideoView tanxc_do(ITanxFeedCacheContext iTanxFeedCacheContext, Context context) {
        TanxVideoView tanxVideoView = null;
        if (iTanxFeedCacheContext == null) {
            return null;
        }
        if (this.tanxc_do == null) {
            this.tanxc_do = new ArrayList();
        }
        iTanxFeedCacheContext.remove();
        Iterator<WeakReference<TanxVideoView>> it = this.tanxc_do.iterator();
        while (it.hasNext()) {
            TanxVideoView tanxVideoView2 = (TanxVideoView) it.next().get();
            if (tanxVideoView2 == null) {
                it.remove();
            } else if (tanxVideoView == null && tanxVideoView2.getParent() == null) {
                tanxVideoView = tanxVideoView2;
            }
        }
        if (tanxVideoView != null) {
            return tanxVideoView;
        }
        TanxVideoView tanxVideoView3 = new TanxVideoView(context);
        this.tanxc_do.add(new WeakReference(tanxVideoView3));
        return tanxVideoView3;
    }
}
