package com.alimm.tanx.core.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import androidx.core.view.MenuItemCompat;
import com.alimm.tanx.core.ad.view.ActionMenu;

/* loaded from: classes.dex */
public class AdWebViewUtils implements NotConfused {
    private static final String TAG = "AdClickUtils";

    public static boolean isDestroyed(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public static boolean isNormalWebTitleValid(CharSequence charSequence, WebView webView) {
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        String str = null;
        if (webView != null) {
            try {
                copyBackForwardList = webView.copyBackForwardList();
            } catch (Throwable th) {
                LogUtils.d(TAG, "isNormalWebTitleValid exception: title = " + ((Object) charSequence), th);
            }
        } else {
            copyBackForwardList = null;
        }
        if (copyBackForwardList != null && (currentItem = copyBackForwardList.getCurrentItem()) != null) {
            str = currentItem.getUrl();
        }
        LogUtils.d(TAG, "isNormalWebTitleValid: url = " + str + ", title = " + ((Object) charSequence));
        if (str != null && !TextUtils.isEmpty(charSequence)) {
            String lowerCase = str.toLowerCase();
            if (charSequence instanceof String) {
                charSequence = ((String) charSequence).toLowerCase();
            }
            if (!lowerCase.contains(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static void setShowAsAction(Menu menu, ActionMenu actionMenu) {
        MenuItem add = menu.add(0, actionMenu.id, 0, actionMenu.name);
        add.setIcon(actionMenu.drawable);
        MenuItemCompat.setShowAsAction(add, 2);
    }
}
