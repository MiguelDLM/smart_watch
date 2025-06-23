package com.adp.sdk.listener;

import android.app.Activity;

public interface ADPDownloadConfirmListener {
    void onDownloadConfirm(Activity activity, int i, String str, ADPDownloadConfirmCallBack aDPDownloadConfirmCallBack);
}
