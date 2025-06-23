package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public final class a extends KSFrameLayout {
    private final DialogFragment LP;
    private final View LQ;
    private a.C0788a LR;

    public a(@NonNull Context context, DialogFragment dialogFragment, a.C0788a c0788a) {
        super(context);
        this.LP = dialogFragment;
        this.LR = c0788a;
        l.inflate(context, R.layout.ksad_seconed_confirm_dialog_layout, this);
        this.LQ = findViewById(R.id.ksad_second_confirm_root_view);
    }

    private static Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new d());
        return presenter;
    }

    private c oP() {
        c cVar = new c();
        cVar.LP = this.LP;
        cVar.LR = this.LR;
        return cVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        Presenter af = af();
        af.G(this.LQ);
        af.k(oP());
    }
}
