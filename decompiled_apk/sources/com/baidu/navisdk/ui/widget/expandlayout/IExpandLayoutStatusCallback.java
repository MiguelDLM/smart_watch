package com.baidu.navisdk.ui.widget.expandlayout;

import OXOo.OOXIXo;
import com.baidu.navisdk.ui.widget.expandlayout.BNExpandConstraintLayout;

/* loaded from: classes8.dex */
public interface IExpandLayoutStatusCallback {
    void onAnimStart4StatusChange(@OOXIXo BNExpandConstraintLayout.State state);

    void onFlingStatusChange(@OOXIXo BNExpandConstraintLayout.State state);

    void onStatusChange(@OOXIXo BNExpandConstraintLayout.State state);
}
