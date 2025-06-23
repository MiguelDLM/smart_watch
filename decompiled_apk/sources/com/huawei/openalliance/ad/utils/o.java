package com.huawei.openalliance.ad.utils;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.Window;
import com.huawei.hms.ads.ck;

/* loaded from: classes10.dex */
public abstract class o {

    /* loaded from: classes10.dex */
    public interface a {
        void Code();

        void V();
    }

    public static AlertDialog.Builder Code(Context context) {
        if (ck.V(context)) {
            return new AlertDialog.Builder(context);
        }
        int i = Build.VERSION.SDK_INT;
        return (i < 22 || !w.C(context)) ? i >= 22 ? new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Light.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.Material.Light.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Dialog.Alert);
    }

    private static Dialog Code(Context context, AlertDialog.Builder builder, String str, String str2, String str3, final a aVar) {
        Window window;
        if (str != null) {
            builder.setTitle(str);
        }
        builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.o.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Code();
                }
            }
        });
        builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.o.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.V();
                }
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.openalliance.ad.utils.o.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.V();
                }
            }
        });
        if (!(context instanceof Activity) && (window = create.getWindow()) != null) {
            window.setType(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
        }
        return create;
    }

    public static Dialog Code(Context context, String str, String str2, String str3, String str4, a aVar) {
        AlertDialog.Builder Code = Code(context);
        if (str2 != null) {
            Code.setMessage(str2);
        }
        Dialog Code2 = Code(context, Code, str, str3, str4, aVar);
        Code2.show();
        return Code2;
    }
}
