package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class c extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private final int f7292a;
    private final int b = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_15dp);

    public c(int i) {
        this.f7292a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) >= this.f7292a) {
            rect.top = this.b;
        }
    }
}
