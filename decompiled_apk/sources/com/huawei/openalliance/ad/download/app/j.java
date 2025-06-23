package com.huawei.openalliance.ad.download.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.o;

/* loaded from: classes10.dex */
public class j {
    static final String Code = "AppPermissionsDialog";

    /* loaded from: classes10.dex */
    public interface a {
        void Code();
    }

    public static void Code(Context context, AppInfo appInfo) {
        Code(context, appInfo, null);
    }

    public static void Code(Context context, AppInfo appInfo, final a aVar) {
        int i;
        Window window;
        fb.V(Code, "show, context:" + context);
        AlertDialog.Builder Code2 = o.Code(context);
        Code2.setTitle("");
        if (aVar != null) {
            Code2.setPositiveButton(R.string.hiad_dialog_accept, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.j.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    a.this.Code();
                }
            });
            i = R.string.hiad_dialog_cancel;
        } else {
            i = R.string.hiad_dialog_close;
        }
        Code2.setNeutralButton(i, (DialogInterface.OnClickListener) null);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_permission_dialog_cotent, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.hiad_permissions_dialog_content_title_tv)).setText(context.getResources().getString(R.string.hiad_permission_dialog_title, appInfo.L()));
        ((ListView) inflate.findViewById(R.id.hiad_permissions_dialog_content_lv)).setAdapter((ListAdapter) new i(context, appInfo.b()));
        Code2.setView(inflate);
        AlertDialog create = Code2.create();
        if (!(context instanceof Activity) && (window = create.getWindow()) != null) {
            window.setType(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
        }
        fb.Code(Code, "show, time:%s", Long.valueOf(System.currentTimeMillis()));
        create.show();
    }
}
