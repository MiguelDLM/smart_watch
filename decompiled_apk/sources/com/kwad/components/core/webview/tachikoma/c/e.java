package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.g;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public class e extends g {
    public com.kwad.components.core.webview.tachikoma.e.c Tf;
    protected StyleTemplate Th;
    protected com.kwad.components.core.webview.tachikoma.c.b abk;
    protected k abm;
    protected com.kwad.components.core.webview.tachikoma.k abn;
    public boolean abo;
    public a abp;
    private com.kwad.components.core.webview.tachikoma.e.d abs;
    private d abv;
    private KSFrameLayout abw;
    protected List<DialogInterface.OnDismissListener> abx = new CopyOnWriteArrayList();
    public boolean aby = false;
    public AdResultData mAdResultData;
    private Presenter mPresenter;

    /* renamed from: xo, reason: collision with root package name */
    public String f18471xo;

    /* loaded from: classes11.dex */
    public interface a {
        boolean fU();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private StyleTemplate abA;
        private com.kwad.components.core.webview.tachikoma.k abB;
        private k abm;
        private boolean abo;
        private boolean aby;
        private AdResultData mAdResultData;
        private String templateId;

        public final void a(StyleTemplate styleTemplate) {
            this.abA = styleTemplate;
        }

        public final void aW(boolean z) {
            this.abo = false;
        }

        public final void aX(String str) {
            this.templateId = str;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final AdResultData hl() {
            return this.mAdResultData;
        }

        public final boolean kf() {
            return this.abo;
        }

        public final boolean tB() {
            return this.aby;
        }

        public final void a(com.kwad.components.core.webview.tachikoma.k kVar) {
            this.abB = kVar;
        }

        public final void aX(boolean z) {
            this.aby = true;
        }

        public final void c(k kVar) {
            this.abm = kVar;
        }

        public final void d(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }
    }

    private Presenter af() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        if (this.abk.abn != null) {
            presenter.a(tA());
        } else {
            presenter.a(jm());
        }
        return this.mPresenter;
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.hl();
        eVar.f18471xo = bVar.getTemplateId();
        eVar.abo = bVar.abo;
        eVar.aby = bVar.aby;
        eVar.Th = bVar.abA;
        eVar.abm = bVar.abm;
        eVar.abn = bVar.abB;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    private d tA() {
        if (this.abv == null) {
            this.abv = new d();
        }
        return this.abv;
    }

    private void z(View view) {
        if (this.abk == null) {
            this.abk = jl();
        }
        jn();
        if (this.mPresenter == null) {
            Presenter af = af();
            this.mPresenter = af;
            af.G(view);
        }
        this.mPresenter.k(this.abk);
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.abx.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.abx.remove(onDismissListener);
    }

    public com.kwad.components.core.webview.tachikoma.c.b jl() {
        return new com.kwad.components.core.webview.tachikoma.c.b();
    }

    public c jm() {
        return new c();
    }

    public void jn() {
        this.abk.d(this.mAdResultData);
        this.abk.mActivity = getActivity();
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.abk;
        bVar.Zt = this;
        bVar.abl = this.abw;
        bVar.f18469xo = this.f18471xo;
        bVar.Th = this.Th;
        bVar.abo = this.abo;
        bVar.abm = this.abm;
        bVar.abn = this.abn;
        bVar.abp = this.abp;
        bVar.Tf = this.Tf;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        Resources resources;
        int identifier;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        int i = 0;
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (b(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        try {
            if (this.abm.isHideNavigationBar()) {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                    i = getContext().getResources().getDimensionPixelSize(identifier);
                }
                if (i > 0) {
                    getDialog().getWindow().getDecorView().setSystemUiVisibility(5382);
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.c.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 == 4 && keyEvent.getAction() == 0) {
                    e eVar = e.this;
                    if (eVar.aby) {
                        return true;
                    }
                    if (eVar.abv != null) {
                        return e.this.abv.onBackPressed();
                    }
                    return false;
                }
                return false;
            }
        });
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18471xo = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.abk;
        if (bVar != null) {
            bVar.release();
            this.abk = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("TkDialogFragment", "destroy view failed:" + th);
        }
        KSFrameLayout kSFrameLayout = this.abw;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.abw.getParent()).removeView(this.abw);
            this.abw = null;
        }
        com.kwad.components.core.webview.tachikoma.e.d dVar = this.abs;
        if (dVar != null) {
            dVar.ga();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Tf;
        if (cVar != null) {
            cVar.ga();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.abx) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        k kVar = this.abm;
        if (kVar != null) {
            kVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        z(view);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Tf;
        if (cVar != null) {
            cVar.fS();
        }
        com.kwad.components.core.webview.tachikoma.e.d dVar = this.abs;
        if (dVar != null) {
            dVar.fS();
        }
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.d dVar) {
        this.abs = dVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.abw == null) {
            this.abw = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.abw;
    }

    private static boolean b(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }
}
