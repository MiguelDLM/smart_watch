package com.baidu.mobads.sdk.api;

import android.app.Fragment;
import androidx.annotation.Nullable;

/* loaded from: classes7.dex */
public interface CPUComponent {
    void destroy();

    @Nullable
    Fragment getFragment();

    @Nullable
    androidx.fragment.app.Fragment getSupportFragment();

    void refresh();
}
