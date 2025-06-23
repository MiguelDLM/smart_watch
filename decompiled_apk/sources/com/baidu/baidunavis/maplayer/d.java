package com.baidu.baidunavis.maplayer;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.platform.comapi.map.OverlayItem;
import java.util.Map;

/* loaded from: classes7.dex */
public class d extends OverlayItem {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f5579a;

    public d(com.baidu.nplatform.comapi.basestruct.c cVar, String str, String str2) {
        super(h.a(cVar), str, str2);
    }

    public String a() {
        return super.getSnippet();
    }

    public void b(int i) {
        super.setMask(i);
    }

    public void a(Drawable drawable) {
        super.setMarker(drawable);
    }

    public String b() {
        return super.getTitle();
    }

    public void a(float f, float f2) {
        super.setAnchor(f, f2);
    }

    public void a(int i) {
        super.setAnchor(i);
    }

    public void a(Bundle bundle) {
        super.addClickRect(bundle);
    }

    @Nullable
    public Object a(@NonNull String str) {
        Map<String, Object> map = this.f5579a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
