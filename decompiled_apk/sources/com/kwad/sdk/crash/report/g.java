package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g extends d {
    public static final Pattern aIx = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aIy = Pattern.compile("\\sd+\\spc");

    private NativeExceptionMessage D(File file) {
        String str;
        try {
            str = q.V(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        q.S(file);
        return nativeExceptionMessage;
    }

    private static void c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    ThreadInfo threadInfo = new ThreadInfo();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.isEmpty()) {
                            arrayList.add(threadInfo);
                            threadInfo = new ThreadInfo();
                        } else if (aIy.matcher(readLine).matches()) {
                            if (threadInfo.mTrace != null) {
                                readLine = threadInfo.mTrace + readLine;
                            }
                            threadInfo.mTrace = readLine;
                            threadInfo.mTrace += "\n";
                        } else {
                            Matcher matcher = aIx.matcher(readLine);
                            if (matcher.lookingAt()) {
                                threadInfo.mName = matcher.group(1);
                                threadInfo.mTid = Integer.parseInt(matcher.group(2));
                                threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                            }
                        }
                    }
                    memoryInfo.mNativeThreads = arrayList;
                    exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                } catch (IOException e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            } catch (Throwable th) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage D = D(file2);
        try {
            a(D, file);
            b(file3, D);
            d.a(file4, D);
            c(new File(str + ".ntrace"), D);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) D.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            D.toString();
            D.mDumpsys = q.V(new File(str + ".minfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            D.mErrorMessage += this.mErrorMessage;
        }
        return D;
    }

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.fT(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z = false;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (z && readLine.startsWith("backtrace:")) {
                        z = false;
                        z2 = true;
                    } else if (z2) {
                        if (readLine.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    } else if (z) {
                        a(nativeExceptionMessage, readLine, sb2);
                    } else if (readLine.startsWith("*** ***")) {
                        z = true;
                    }
                } catch (IOException e) {
                    this.mErrorMessage += e + "\n";
                }
            } catch (Throwable th) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                throw th;
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
            return;
        }
        if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
            return;
        }
        if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
            return;
        }
        if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
            return;
        }
        if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
            return;
        }
        if (!str.startsWith("    r") && !str.startsWith("    ip") && !str.startsWith("    x") && !str.startsWith("    sp")) {
            if (str.startsWith("pid: ")) {
                String[] split = str.split("\\s+");
                if (split.length < 9) {
                    return;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < split.length; i4++) {
                    if ("name:".equals(split[i4])) {
                        i = i4;
                    } else if (">>>".equals(split[i4])) {
                        i2 = i4;
                    } else if ("<<<".equals(split[i4])) {
                        i3 = i4;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                int i5 = i + 1;
                sb2.append(split[i5]);
                while (true) {
                    i5++;
                    if (i5 >= i2) {
                        break;
                    }
                    sb2.append(" ");
                    sb2.append(split[i5]);
                }
                nativeExceptionMessage.mThreadName = sb2.toString();
                sb2.setLength(0);
                int i6 = i2 + 1;
                sb2.append(split[i6]);
                while (true) {
                    i6++;
                    if (i6 < i3) {
                        sb2.append(" ");
                        sb2.append(split[i6]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb2.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.fU(split2[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.fU(split2[5]);
                    nativeExceptionMessage.mFaultAddr = split2[split2.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split2[split2.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            sb.append(str);
            sb.append('\n');
        }
    }
}
