package com.baidu.navisdk.framework.interfaces.impl;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.debug.d;
import com.baidu.navisdk.ugc.f;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class h implements com.baidu.navisdk.ugc.e, com.baidu.navisdk.ugc.f {

    /* loaded from: classes7.dex */
    public class a implements d.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.a f6814a;

        public a(h hVar, f.a aVar) {
            this.f6814a = aVar;
        }

        @Override // com.baidu.navisdk.debug.d.g
        public void a(String str, Bitmap bitmap) {
            this.f6814a.a(str, bitmap);
        }
    }

    @Override // com.baidu.navisdk.ugc.e
    @NonNull
    public com.baidu.navisdk.model.datastruct.g a() {
        return com.baidu.navisdk.util.logic.g.j().a();
    }

    @Override // com.baidu.navisdk.ugc.e
    @NonNull
    public com.baidu.navisdk.model.datastruct.g b() {
        return com.baidu.navisdk.util.logic.g.j().d();
    }

    @Override // com.baidu.navisdk.ugc.f
    public void a(@NonNull ArrayList<View> arrayList, int i, @NonNull f.a aVar) {
        com.baidu.navisdk.debug.d.g().a(arrayList, i, new a(this, aVar));
    }

    @Override // com.baidu.navisdk.ugc.f
    public void a(@NonNull String str, @NonNull ImageView imageView, boolean z) {
        com.baidu.navisdk.util.drawable.b.a(str, imageView, true);
    }
}
