package com.sma.smartv3.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.me.WebViewV2Activity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.component.BleCache;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCommentDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentDialog.kt\ncom/sma/smartv3/view/CommentDialog\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,174:1\n87#2,7:175\n94#2,3:183\n70#2,7:186\n97#2:193\n1#3:182\n*S KotlinDebug\n*F\n+ 1 CommentDialog.kt\ncom/sma/smartv3/view/CommentDialog\n*L\n69#1:175,7\n69#1:183,3\n69#1:186,7\n69#1:193\n69#1:182\n*E\n"})
/* loaded from: classes12.dex */
public final class II0XooXoX {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f25048Oxx0IOOO = 2;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f25049X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f25050XO = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f25052oxoX = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0XooXoX f25051oIX0oI = new II0XooXoX();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f25047II0xO0 = "https://api.iot-solution.net/satisfactionSurvey/";

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f25046I0Io = "https://api.iot-solution.net/satisfactionSurvey/#/information";

    public static final void oO(Context context, int i, Dialog dialog, View view) {
        IIX0o.x0xO0oo(context, "$context");
        IIX0o.x0xO0oo(dialog, "$dialog");
        f25051oIX0oI.OOXIXo(context, i);
        dialog.dismiss();
    }

    public static final void ooOOo0oXI(RatingBar ratingBar, Context context, Dialog dialog, View view) {
        IIX0o.x0xO0oo(context, "$context");
        IIX0o.x0xO0oo(dialog, "$dialog");
        if (ratingBar.getRating() >= 4.0f) {
            II0XooXoX iI0XooXoX = f25051oIX0oI;
            iI0XooXoX.xxIXOIIO(context, f25052oxoX);
            iI0XooXoX.x0XOIxOo(context, 0);
            dialog.dismiss();
            return;
        }
        f25051oIX0oI.xxIXOIIO(context, f25047II0xO0);
        dialog.dismiss();
    }

    public static final void x0xO0oo(Dialog dialog, Context context, int i, View view) {
        IIX0o.x0xO0oo(dialog, "$dialog");
        IIX0o.x0xO0oo(context, "$context");
        dialog.dismiss();
        f25051oIX0oI.xoIox(context, i);
    }

    public final boolean II0XooXoX() {
        if (ProjectManager.f19822oIX0oI.oxIIX0o() && Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24398OooI, true)) {
            return true;
        }
        return false;
    }

    public final void OOXIXo(Context context, int i) {
        if (i != 0) {
            if (i == 1) {
                xxIXOIIO(context, f25052oxoX);
                x0XOIxOo(context, 0);
                return;
            }
            return;
        }
        xxIXOIIO(context, f25046I0Io);
    }

    public final int Oxx0IOOO(int i) {
        return (i == 0 || i != 1) ? R.string.yes : R.string.to_evaluate;
    }

    public final int X0o0xo(int i) {
        return (i == 0 || i != 1) ? R.string.f35581no : R.string.surrender;
    }

    public final int XO(int i) {
        return (i == 0 || i != 1) ? R.string.on_amazon_platform : R.string.need_your_comments;
    }

    public final void oOoXoXO(@OXOo.OOXIXo final Context context) {
        IIX0o.x0xO0oo(context, "context");
        final Dialog dialog = new Dialog(context, R.style.AppDialogTheme);
        dialog.setContentView(R.layout.dialog_comment);
        dialog.show();
        final RatingBar ratingBar = (RatingBar) dialog.findViewById(R.id.rat_bar);
        ((TextView) dialog.findViewById(R.id.tv_next)).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.view.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                II0XooXoX.ooOOo0oXI(ratingBar, context, dialog, view);
            }
        });
    }

    public final boolean oxoX() {
        String mFirmwareFlag = BleCache.INSTANCE.getMFirmwareFlag();
        if (IIX0o.Oxx0IOOO(mFirmwareFlag, "F34_WSQ_GT")) {
            return true;
        }
        return IIX0o.Oxx0IOOO(mFirmwareFlag, "WSQ_GR_1");
    }

    public final void x0XOIxOo(final Context context, final int i) {
        final Dialog dialog = new Dialog(context, R.style.AppDialogTheme);
        dialog.setContentView(R.layout.dialog_hint_comment);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) dialog.findViewById(R.id.tv_yes);
        TextView textView3 = (TextView) dialog.findViewById(R.id.tv_no);
        textView.setText(XO(i));
        textView3.setText(X0o0xo(i));
        textView2.setText(Oxx0IOOO(i));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.view.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                II0XooXoX.oO(context, i, dialog, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.view.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                II0XooXoX.x0xO0oo(dialog, context, i, view);
            }
        });
    }

    public final void xoIox(Context context, int i) {
        if (i != 0) {
            if (i == 1) {
                xxIXOIIO(context, f25046I0Io);
                return;
            }
            return;
        }
        x0XOIxOo(context, 1);
    }

    public final void xxIXOIIO(Context context, String str) {
        IIX0o.x0XOIxOo(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(activity, (Class<?>) WebViewV2Activity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
