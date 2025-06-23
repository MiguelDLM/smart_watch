package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class di implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RelativeLayout f6309a;
    final /* synthetic */ de b;

    public di(de deVar, RelativeLayout relativeLayout) {
        this.b = deVar;
        this.f6309a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.b.h);
            hashMap.put("banner_container", this.f6309a);
            hashMap.put("entry", Integer.valueOf(this.b.D));
            hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b.E));
            hashMap.put("novel_id", this.b.F);
            hashMap.put("isnight", Boolean.valueOf(this.b.x()));
            this.b.a(de.u, hashMap);
        }
    }
}
