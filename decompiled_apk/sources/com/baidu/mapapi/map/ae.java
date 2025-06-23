package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
import com.baidu.mapapi.map.WearMapView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ae implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeDismissView f5881a;

    public ae(SwipeDismissView swipeDismissView) {
        this.f5881a = swipeDismissView;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        WearMapView.OnDismissCallback onDismissCallback = this.f5881a.f5862a;
        if (onDismissCallback == null) {
            return;
        }
        onDismissCallback.onDismiss();
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onNotify() {
        WearMapView.OnDismissCallback onDismissCallback = this.f5881a.f5862a;
        if (onDismissCallback == null) {
            return;
        }
        onDismissCallback.onNotify();
    }
}
