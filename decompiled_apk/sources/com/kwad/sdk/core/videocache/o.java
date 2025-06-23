package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.alimm.tanx.core.view.player.cache.ProxyCacheManager;
import com.kwad.sdk.utils.ax;
import java.io.File;

/* loaded from: classes11.dex */
public final class o {
    public static File bx(Context context) {
        return new File(ax.cY(context), ProxyCacheManager.CACHE_DIR);
    }
}
