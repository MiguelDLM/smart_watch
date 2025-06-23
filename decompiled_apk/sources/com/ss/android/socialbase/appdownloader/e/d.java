package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26180a = "d";
    private static List<n> b = new ArrayList();
    private static com.ss.android.socialbase.appdownloader.view.a c;
    private static AlertDialog d;

    public static void b(@NonNull Activity activity, @NonNull n nVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f26180a;
                    com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(str);
                    c = aVar;
                    if (aVar == null) {
                        c = new com.ss.android.socialbase.appdownloader.view.a();
                        fragmentManager.beginTransaction().add(c, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    c.a();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    nVar.a();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        nVar.a();
    }

    public static boolean a() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.c.O()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (d.class) {
            try {
                AlertDialog alertDialog = d;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    d = null;
                }
                for (n nVar : b) {
                    if (nVar != null) {
                        if (z) {
                            nVar.a();
                        } else {
                            nVar.b();
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static synchronized void a(@NonNull final Activity activity, @NonNull final n nVar) {
        synchronized (d.class) {
            if (nVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } finally {
                    return;
                }
                if (!activity.isFinishing()) {
                    int a2 = i.a(com.ss.android.socialbase.downloader.downloader.c.O(), "tt_appdownloader_notification_request_title");
                    int a3 = i.a(com.ss.android.socialbase.downloader.downloader.c.O(), "tt_appdownloader_notification_request_message");
                    int a4 = i.a(com.ss.android.socialbase.downloader.downloader.c.O(), "tt_appdownloader_notification_request_btn_yes");
                    int a5 = i.a(com.ss.android.socialbase.downloader.downloader.c.O(), "tt_appdownloader_notification_request_btn_no");
                    b.add(nVar);
                    AlertDialog alertDialog = d;
                    if (alertDialog != null) {
                        if (!alertDialog.isShowing()) {
                        }
                        return;
                    }
                    d = new AlertDialog.Builder(activity).setTitle(a2).setMessage(a3).setPositiveButton(a4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            d.b(activity, nVar);
                            dialogInterface.cancel();
                            AlertDialog unused = d.d = null;
                        }
                    }).setNegativeButton(a5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            d.a(false);
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.1
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (i != 4) {
                                return false;
                            }
                            if (keyEvent.getAction() == 1) {
                                d.a(false);
                            }
                            return true;
                        }
                    }).setCancelable(false).show();
                    return;
                }
            }
            nVar.b();
        }
    }
}
