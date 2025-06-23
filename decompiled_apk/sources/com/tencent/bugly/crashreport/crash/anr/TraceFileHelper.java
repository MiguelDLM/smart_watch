package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.al;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes13.dex */
public class TraceFileHelper {

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f26516a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    /* loaded from: classes13.dex */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, boolean z) {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new II0xO0(aVar, z));
        if (aVar.f26516a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        al.e("first dump error %s", aVar.f26516a + " " + aVar.c + " " + aVar.b);
        return null;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z) {
        if (str != null && str2 != null) {
            a aVar = new a();
            readTraceFile(str2, new oIX0oI(aVar, str, z));
            if (aVar.f26516a > 0 && aVar.c > 0 && aVar.b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        BufferedReader bufferedReader;
        int i = 0;
        if (str != null && bVar != null) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            file.lastModified();
            file.length();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                while (true) {
                    Pattern[] patternArr = new Pattern[1];
                    patternArr[i] = compile;
                    Object[] a2 = a(bufferedReader, patternArr);
                    if (a2 != null) {
                        Pattern[] patternArr2 = new Pattern[1];
                        patternArr2[i] = compile3;
                        Object[] a3 = a(bufferedReader, patternArr2);
                        if (a3 == null) {
                            al.d("Failed to find process name.", new Object[i]);
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e2) {
                                if (!al.a(e2)) {
                                    e2.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        String[] split = a2[1].toString().split("\\s");
                        long parseLong = Long.parseLong(split[2]);
                        long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                        Matcher matcher = compile3.matcher(a3[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!bVar.a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e3) {
                                if (!al.a(e3)) {
                                    e3.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        while (true) {
                            Object[] a4 = a(bufferedReader, compile4, compile2);
                            if (a4 == null) {
                                break;
                            }
                            if (a4[0] == compile4) {
                                String obj = a4[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader), b(bufferedReader));
                            } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e4) {
                                    if (!al.a(e4)) {
                                        e4.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        simpleDateFormat = simpleDateFormat2;
                        i = 0;
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e5) {
                            if (!al.a(e5)) {
                                e5.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader2 = bufferedReader;
                if (!al.a(e)) {
                    e.printStackTrace();
                }
                al.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        if (!al.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        throw th;
                    } catch (IOException e8) {
                        if (!al.a(e8)) {
                            e8.printStackTrace();
                            throw th;
                        }
                        throw th;
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class II0xO0 implements b {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ boolean f26514II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ a f26515oIX0oI;

        public II0xO0(a aVar, boolean z) {
            this.f26515oIX0oI = aVar;
            this.f26514II0xO0 = z;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(String str, int i, String str2, String str3) {
            al.c("new thread %s", str);
            a aVar = this.f26515oIX0oI;
            if (aVar.d == null) {
                aVar.d = new HashMap();
            }
            this.f26515oIX0oI.d.put(str, new String[]{str2, str3, String.valueOf(i)});
            return true;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j, long j2, String str) {
            al.c("new process %s", str);
            a aVar = this.f26515oIX0oI;
            aVar.f26516a = j;
            aVar.b = str;
            aVar.c = j2;
            return this.f26514II0xO0;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j) {
            al.c("process end %d", Long.valueOf(j));
            return false;
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI implements b {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ boolean f26517I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ String f26518II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ a f26519oIX0oI;

        public oIX0oI(a aVar, String str, boolean z) {
            this.f26519oIX0oI = aVar;
            this.f26518II0xO0 = str;
            this.f26517I0Io = z;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(String str, int i, String str2, String str3) {
            al.c("new thread %s", str);
            a aVar = this.f26519oIX0oI;
            if (aVar.f26516a > 0 && aVar.c > 0 && aVar.b != null) {
                if (aVar.d == null) {
                    aVar.d = new HashMap();
                }
                this.f26519oIX0oI.d.put(str, new String[]{str2, str3, String.valueOf(i)});
            }
            return true;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j, long j2, String str) {
            al.c("new process %s", str);
            if (!str.equals(this.f26518II0xO0)) {
                return true;
            }
            a aVar = this.f26519oIX0oI;
            aVar.f26516a = j;
            aVar.b = str;
            aVar.c = j2;
            return this.f26517I0Io;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j) {
            al.c("process end %d", Long.valueOf(j));
            a aVar = this.f26519oIX0oI;
            return aVar.f26516a <= 0 || aVar.c <= 0 || aVar.b == null;
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
