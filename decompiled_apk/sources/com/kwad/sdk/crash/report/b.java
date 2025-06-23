package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b extends d {
    private AnrExceptionMessage B(File file) {
        String str;
        try {
            str = q.V(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        q.S(file);
        return anrExceptionMessage;
    }

    private String fN(String str) {
        File file = new File(str + ".anr");
        String str2 = "";
        if (file.exists()) {
            try {
                str2 = q.V(file);
            } catch (IOException e) {
                this.mErrorMessage += e + "\n";
            }
            q.S(file);
        }
        return str2;
    }

    private static boolean fO(@NonNull String str) {
        for (String str2 : com.kwad.sdk.crash.e.If().Ig()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.e.c.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        com.kwad.sdk.core.e.c.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage B = B(file2);
        try {
            B.mReason = fN(str);
            a(B, file);
            b(file3, B);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) B.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            B.toString();
            B.mDumpsys = q.V(new File(str + ".minfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            B.mErrorMessage += this.mErrorMessage;
        }
        return B;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.b.a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }
}
