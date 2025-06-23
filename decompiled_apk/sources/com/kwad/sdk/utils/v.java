package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class v {
    private static Handler fS = new Handler(Looper.getMainLooper());
    private static volatile boolean Ig = false;

    public static void P(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i, long j) {
        if (!com.kwad.framework.a.a.aex.booleanValue() || Ig) {
            return;
        }
        Ig = true;
        View inflate = com.kwad.sdk.n.l.inflate(context, i, null);
        ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
        fS.postDelayed(new az() { // from class: com.kwad.sdk.utils.v.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                v.access$002(false);
            }
        }, j);
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        Ig = false;
        return false;
    }

    private static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    public static void c(Context context, String str, long j) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    public static void c(Context context, String str, int i) {
        if (com.kwad.framework.a.a.aex.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }
}
