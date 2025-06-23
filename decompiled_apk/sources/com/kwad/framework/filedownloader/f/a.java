package com.kwad.framework.filedownloader.f;

/* loaded from: classes11.dex */
public class a {
    private static void a(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean bd(int i) {
        a("request pause the task[%d] in the download service", Integer.valueOf(i));
        return false;
    }

    public static byte be(int i) {
        a("request get the status for the task[%d] in the download service", Integer.valueOf(i));
        return (byte) 0;
    }

    public static boolean bf(int i) {
        a("request clear the task[%d] data in the database", Integer.valueOf(i));
        return false;
    }

    public static boolean h(String str, String str2, boolean z) {
        a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }
}
