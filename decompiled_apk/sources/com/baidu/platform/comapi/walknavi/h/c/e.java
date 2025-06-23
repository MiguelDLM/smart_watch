package com.baidu.platform.comapi.walknavi.h.c;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.baidu.R;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.h.c.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements c.InterfaceC0538c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseNpcModel f9777a;
    final /* synthetic */ c b;

    public e(c cVar, BaseNpcModel baseNpcModel) {
        this.b = cVar;
        this.f9777a = baseNpcModel;
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.c.InterfaceC0538c
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        ImageView imageView;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.b.ac;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.b.ac;
            iWNPCLoadAndInitListener2.onSuccess();
        }
        imageView = this.b.Q;
        imageView.setImageBitmap(this.f9777a.getIcon());
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.c.InterfaceC0538c
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        ImageView imageView;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.b.ac;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.e.e.c().a("");
            this.b.b(true);
            com.baidu.platform.comapi.walknavi.b.a().K().a(0, 0);
            this.b.u();
            iWNPCLoadAndInitListener2 = this.b.ac;
            iWNPCLoadAndInitListener2.onFail();
        }
        imageView = this.b.Q;
        imageView.setImageBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.wsdk_npc_drawer_img_default));
    }
}
