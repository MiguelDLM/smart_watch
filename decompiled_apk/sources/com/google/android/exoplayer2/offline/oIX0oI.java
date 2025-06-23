package com.google.android.exoplayer2.offline;

/* loaded from: classes9.dex */
public final /* synthetic */ class oIX0oI {
    public static boolean I0Io(DownloadCursor downloadCursor) {
        if (downloadCursor.getPosition() == 0 && downloadCursor.getCount() != 0) {
            return true;
        }
        return false;
    }

    public static boolean II0XooXoX(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() - 1);
    }

    public static boolean II0xO0(DownloadCursor downloadCursor) {
        if (downloadCursor.getCount() == 0 || downloadCursor.getPosition() == -1) {
            return true;
        }
        return false;
    }

    public static boolean Oxx0IOOO(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() + 1);
    }

    public static boolean X0o0xo(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(0);
    }

    public static boolean XO(DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getCount() - 1);
    }

    public static boolean oIX0oI(DownloadCursor downloadCursor) {
        if (downloadCursor.getCount() == 0 || downloadCursor.getPosition() == downloadCursor.getCount()) {
            return true;
        }
        return false;
    }

    public static boolean oxoX(DownloadCursor downloadCursor) {
        int count = downloadCursor.getCount();
        if (downloadCursor.getPosition() == count - 1 && count != 0) {
            return true;
        }
        return false;
    }
}
