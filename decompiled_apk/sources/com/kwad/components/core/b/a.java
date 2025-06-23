package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class a implements View.OnClickListener {

    @Nullable
    private TextView Jl;

    @Nullable
    private ImageView Jm;

    @Nullable
    private ImageView Jn;

    @Nullable
    private InterfaceC0777a Jo;
    private ViewGroup sA;

    /* renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0777a {
        void u(View view);

        void v(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.sA = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.Jl = (TextView) this.sA.findViewById(R.id.ksad_kwad_titlebar_title);
        this.Jm = (ImageView) this.sA.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.sA.findViewById(R.id.ksad_kwad_web_navi_close);
        this.Jn = imageView;
        imageView.setOnClickListener(this);
        this.Jm.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC0777a interfaceC0777a) {
        this.Jo = interfaceC0777a;
    }

    @MainThread
    public final void ah(boolean z) {
        int i;
        ImageView imageView = this.Jn;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final ViewGroup gG() {
        return this.sA;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Jo == null) {
            return;
        }
        if (view.equals(this.Jn)) {
            this.Jo.v(view);
        } else if (view.equals(this.Jm)) {
            this.Jo.u(view);
        }
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.sA == null || (textView = this.Jl) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }
}
