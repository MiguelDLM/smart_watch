package com.bytedance.pangle.g;

import android.content.pm.Signature;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<byte[]> f10555a = new AtomicReference<>();

    public static o a(String str) {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        } catch (GeneralSecurityException e3) {
            e = e3;
        }
        try {
            ArrayList<JarEntry> arrayList = new ArrayList();
            JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            if (jarEntry == null) {
                throw new q(1, "Package " + str + " has no manifest");
            }
            Certificate[][] a2 = a(jarFile, jarEntry);
            if (com.bytedance.pangle.util.d.a(a2)) {
                throw new q(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
            }
            Signature[] a3 = d.a(a2);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                        arrayList.add(nextElement);
                    }
                }
            }
            for (JarEntry jarEntry2 : arrayList) {
                Certificate[][] a4 = a(jarFile, jarEntry2);
                if (com.bytedance.pangle.util.d.a(a4)) {
                    throw new q(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                }
                if (!o.a(a3, d.a(a4))) {
                    throw new q(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                }
            }
            o oVar = new o(a3, 1, null, null, null);
            try {
                jarFile.close();
            } catch (Exception unused) {
            }
            return oVar;
        } catch (IOException e4) {
            e = e4;
            throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (RuntimeException e5) {
            e = e5;
            throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (GeneralSecurityException e6) {
            e = e6;
            throw new q(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private static Certificate[][] a(JarFile jarFile, JarEntry jarEntry) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = jarFile.getInputStream(jarEntry);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        }
        try {
            byte[] andSet = f10555a.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            do {
            } while (inputStream.read(andSet, 0, andSet.length) != -1);
            f10555a.set(andSet);
            Certificate[][] certificateArr = {jarEntry.getCertificates()};
            try {
                inputStream.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
            return certificateArr;
        } catch (IOException e4) {
            e = e4;
            throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
        } catch (RuntimeException e5) {
            e = e5;
            throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
