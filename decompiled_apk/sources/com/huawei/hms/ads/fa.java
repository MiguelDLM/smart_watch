package com.huawei.hms.ads;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/* loaded from: classes10.dex */
public final class fa extends ez {
    private static final long I = 4194304;
    private static final String V = "FileLogNode";
    private File Z;

    private fa() {
    }

    public static fg Code() {
        return new fe(new fa());
    }

    private void I(String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.Z, true);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                    } catch (FileNotFoundException | IOException unused) {
                    }
                } catch (FileNotFoundException unused2) {
                    bufferedOutputStream = null;
                } catch (IOException unused3) {
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused4) {
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (IOException unused5) {
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            Code(outputStreamWriter);
        } catch (FileNotFoundException unused6) {
            outputStreamWriter2 = outputStreamWriter;
            Log.w(V, "Exception when writing the log file.");
            Code(outputStreamWriter2);
            Code(bufferedOutputStream);
            Code(fileOutputStream);
        } catch (IOException unused7) {
            outputStreamWriter2 = outputStreamWriter;
            Log.w(V, "Exception when writing the log file.");
            Code(outputStreamWriter2);
            Code(bufferedOutputStream);
            Code(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter2 = outputStreamWriter;
            Code(outputStreamWriter2);
            Code(bufferedOutputStream);
            Code(fileOutputStream);
            throw th;
        }
        Code(bufferedOutputStream);
        Code(fileOutputStream);
    }

    private boolean V(String str) {
        String str2;
        if (this.Z.length() + str.length() > 4194304) {
            File file = new File(this.Z.getPath() + ".bak");
            if (file.exists() ? file.delete() : true) {
                str2 = this.Z.renameTo(file) ? "Cannot rename log file to bak." : "Failed to backup the log file.";
            }
            Log.w(V, str2);
            return false;
        }
        return true;
    }

    @Override // com.huawei.hms.ads.fg
    public fg Code(String str, String str2) {
        String str3;
        if (str2 == null || str2.isEmpty()) {
            Log.e(V, "Failed to initialize the file logger, parameter error.");
            return this;
        }
        if (this.Z == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    File canonicalFile = new File(str, "Log").getCanonicalFile();
                    if (!canonicalFile.isDirectory()) {
                        if (com.huawei.openalliance.ad.utils.r.Code(canonicalFile)) {
                        }
                    }
                    File file = new File(canonicalFile, str2 + ".log");
                    this.Z = file;
                    file.setReadable(true);
                    this.Z.setWritable(true);
                    this.Z.setExecutable(false, false);
                    return this;
                }
            } catch (IOException unused) {
                str3 = "file path error. ioex";
                Log.e(V, str3);
                Log.w(V, "the file logger has been created already.");
                return this;
            } catch (Throwable th) {
                str3 = "file path error. " + th.getClass().getSimpleName();
                Log.e(V, str3);
                Log.w(V, "the file logger has been created already.");
                return this;
            }
        }
        Log.w(V, "the file logger has been created already.");
        return this;
    }

    @Override // com.huawei.hms.ads.fg
    public void Code(fi fiVar, int i, String str) {
        if (fiVar == null) {
            return;
        }
        Code(fiVar.Code() + fiVar.V());
        fg fgVar = this.Code;
        if (fgVar != null) {
            fgVar.Code(fiVar, i, str);
        }
    }

    private static void Code(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.w(V, "Exception when closing the closeable.");
            }
        }
    }

    private void Code(String str) {
        if (str == null || this.Z == null) {
            return;
        }
        String str2 = str + '\n';
        if (V(str2)) {
            I(str2);
        }
    }
}
