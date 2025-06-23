package com.adp.sdk.api;

import androidx.fragment.app.Fragment;

public interface ADPFeedPage {
    Fragment getFragment();

    boolean onBackPressed();
}
