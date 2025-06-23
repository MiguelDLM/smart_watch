package com.tenmeter.smlibrary.banner.indicator;

import android.view.View;
import androidx.annotation.NonNull;
import com.tenmeter.smlibrary.banner.config.IndicatorConfig;
import com.tenmeter.smlibrary.banner.listener.OnPageChangeListener;

/* loaded from: classes13.dex */
public interface Indicator extends OnPageChangeListener {
    IndicatorConfig getIndicatorConfig();

    @NonNull
    View getIndicatorView();

    void onPageChanged(int i, int i2);
}
