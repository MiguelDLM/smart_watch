package com.baidu.ar;

import android.content.Context;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Scanner;

/* loaded from: classes7.dex */
public class im extends ArrayList<ij> {
    private WeakReference<Context> of;
    private boolean tA = false;
    private String yY;
    private int yZ;
    private int za;

    public im(Context context, String str, int i, int i2) {
        this.of = new WeakReference<>(context);
        this.yZ = i;
        this.yY = str;
        this.za = i2;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private void fY() {
        Context context;
        Scanner scanner;
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        ij bG;
        if (this.za > 0 && (context = this.of.get()) != null && context.getFileStreamPath(this.yY).exists()) {
            try {
                fileInputStream = context.openFileInput(this.yY);
                try {
                    scanner = new Scanner(fileInputStream, "utf-8");
                    while (scanner.hasNextLine()) {
                        try {
                            try {
                                String nextLine = scanner.nextLine();
                                if (nextLine != null && !nextLine.isEmpty() && (bG = ij.bG(nextLine)) != null) {
                                    add(bG);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                a(fileInputStream);
                                a(scanner);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            a(fileInputStream);
                            a(scanner);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    scanner = null;
                    e = e3;
                } catch (Throwable th3) {
                    scanner = null;
                    th = th3;
                    a(fileInputStream);
                    a(scanner);
                    throw th;
                }
            } catch (Exception e4) {
                scanner = null;
                e = e4;
                fileInputStream = null;
            } catch (Throwable th4) {
                scanner = null;
                th = th4;
                fileInputStream = null;
            }
            a(fileInputStream);
            a(scanner);
        }
    }

    public void N(int i) {
        if (i > 0) {
            ij[] ijVarArr = new ij[i];
            for (int i2 = 0; i2 < i; i2++) {
                ijVarArr[i2] = get(i2);
            }
            removeRange(0, i);
            ij.a(ijVarArr);
        }
    }

    public void fX() {
        if (this.tA) {
            return;
        }
        fY();
        this.tA = true;
    }

    public void flush() {
        Context context;
        if (this.za > 0 && (context = this.of.get()) != null) {
            int size = size();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = context.openFileOutput(this.yY, 0);
                    if (size > 0) {
                        int i = this.za;
                        if (size > i) {
                            size = i;
                        }
                        for (int i2 = 0; i2 < size; i2++) {
                            fileOutputStream.write((ij.b((ij) get(i2)) + "\n").getBytes("utf-8"));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                a(fileOutputStream);
            }
        }
    }

    public void k(ij ijVar) {
        if (size() < this.yZ) {
            add(ijVar);
        }
    }
}
