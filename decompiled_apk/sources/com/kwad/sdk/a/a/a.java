package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.core.proxy.d {

    @SuppressLint({"StaticFieldLeak"})
    private static a amp;

    @Nullable
    private final DialogInterface.OnDismissListener amq;
    private final AdTemplate mAdTemplate;

    @Nullable
    private final DialogInterface.OnClickListener mOnClickListener;

    private a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.amq = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean Ap() {
        a aVar = amp;
        if (aVar != null && aVar.isShowing()) {
            amp.dismiss();
            return true;
        }
        return false;
    }

    public static boolean nQ() {
        a aVar = amp;
        if (aVar != null && aVar.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.amq;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            amp = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        final AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
        String F = d.F(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate));
        if (F.equals("")) {
            F = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.b.a.au(dS));
        }
        textView.setText(F);
        textView3.setText(d.AA());
        textView2.setText(d.AB());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                al.a(com.kwad.sdk.core.download.a.H(dS), new al.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.al.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.al.a
                    public final void oK() {
                        com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.aZ(a.this.mAdTemplate);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = amp;
            if (aVar != null && aVar.isShowing()) {
                amp.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                amp = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate Av;
        if (activity == null || activity.isFinishing() || (Av = c.Au().Av()) == null) {
            return false;
        }
        return a(activity, Av, onDismissListener, onClickListener);
    }
}
