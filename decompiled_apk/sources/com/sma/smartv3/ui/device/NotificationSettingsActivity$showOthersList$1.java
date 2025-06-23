package com.sma.smartv3.ui.device;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.sma.smartv3.app.ProjectManager;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class NotificationSettingsActivity$showOthersList$1 extends Lambda implements Oox.oIX0oI<kotlin.oXIO0o0XI> {
    final /* synthetic */ NotificationSettingsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationSettingsActivity$showOthersList$1(NotificationSettingsActivity notificationSettingsActivity) {
        super(0);
        this.this$0 = notificationSettingsActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(NotificationSettingsActivity this$0) {
        XIOOI.oIX0oI mListAdapter;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        mListAdapter = this$0.getMListAdapter();
        mListAdapter.notifyDataSetChanged();
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
        invoke2();
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List mList;
        List<ApplicationInfo> installedApplications = this.this$0.getPackageManager().getInstalledApplications(8192);
        kotlin.jvm.internal.IIX0o.oO(installedApplications, "getInstalledApplications(...)");
        for (ApplicationInfo applicationInfo : installedApplications) {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (!projectManager.xX()) {
                int i = applicationInfo.flags;
                if ((i & 128) == 0 && (i & 1) == 0) {
                }
            }
            if (!ArraysKt___ArraysKt.OXO0oX(projectManager.oI0IIXIo(), applicationInfo.packageName) && !TextUtils.equals(this.this$0.getPackageName(), applicationInfo.packageName)) {
                x0XOIxOo x0xoixoo = new x0XOIxOo();
                x0xoixoo.XO(applicationInfo.loadIcon(this.this$0.getPackageManager()));
                x0xoixoo.Oxx0IOOO(applicationInfo.loadLabel(this.this$0.getPackageManager()).toString());
                x0xoixoo.II0XooXoX(applicationInfo.packageName);
                mList = this.this$0.getMList();
                mList.add(x0xoixoo);
            }
        }
        final NotificationSettingsActivity notificationSettingsActivity = this.this$0;
        notificationSettingsActivity.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.o0Xo
            @Override // java.lang.Runnable
            public final void run() {
                NotificationSettingsActivity$showOthersList$1.invoke$lambda$0(NotificationSettingsActivity.this);
            }
        });
    }
}
