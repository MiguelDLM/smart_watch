package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
import com.baidu.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9560a;

    public b(a aVar) {
        this.f9560a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.platform.comapi.walknavi.b.a().ad()) {
            if (this.f9560a.g != null && this.f9560a.g.y() != null) {
                this.f9560a.g.y().F();
                return;
            }
            return;
        }
        this.f9560a.g.a(false, R.string.wsdk_string_rg_nav_gps_exit);
    }
}
