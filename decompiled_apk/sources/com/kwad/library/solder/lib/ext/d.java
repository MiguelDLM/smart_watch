package com.kwad.library.solder.lib.ext;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"LongLogTag"})
/* loaded from: classes11.dex */
public final class d {

    /* loaded from: classes11.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            Field c = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) c.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            c.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* loaded from: classes11.dex */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            Field c = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            Collection collection = (List) c.get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(collection);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            c.set(obj, arrayList);
            if (c.get(obj) != arrayList) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field c2 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements");
            c2.set(obj, obj2);
            if (c2.get(obj) != obj2) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* renamed from: com.kwad.library.solder.lib.ext.d$d, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0837d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* loaded from: classes11.dex */
    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field c = com.kwad.library.solder.lib.ext.e.c(classLoader, "libPath");
            String valueOf = String.valueOf(c.get(classLoader));
            if (!TextUtils.isEmpty(valueOf)) {
                str = valueOf + ":" + path;
            } else {
                str = path;
            }
            c.set(classLoader, str);
            Field c2 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libraryPathElements");
            List list = (List) c2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            c2.set(classLoader, list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:
    
        if (r6 == 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void c(java.lang.ClassLoader r9, java.io.File r10) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.lang.Class<com.kwad.library.solder.lib.ext.d> r3 = com.kwad.library.solder.lib.ext.d.class
            monitor-enter(r3)
            if (r10 == 0) goto La2
            boolean r4 = r10.exists()     // Catch: java.lang.Throwable -> L1d
            if (r4 != 0) goto L10
            goto La2
        L10:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            r5 = 25
            if (r4 != r5) goto L20
            int r6 = com.bytedance.pangle.I0Io.oIX0oI()     // Catch: java.lang.Throwable -> L1d
            if (r6 != 0) goto L22
            goto L20
        L1d:
            r9 = move-exception
            goto Lb3
        L20:
            if (r4 <= r5) goto L48
        L22:
            com.kwad.library.solder.lib.ext.d.C0837d.h(r9, r10)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r3)
            return
        L27:
            r4 = move-exception
            java.lang.String r5 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L1d
            r0[r2] = r7     // Catch: java.lang.Throwable -> L1d
            r0[r1] = r4     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = java.lang.String.format(r6, r0)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r5, r0)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.ext.d.b.f(r9, r10)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)
            return
        L48:
            r5 = 24
            if (r4 != r5) goto L72
            com.kwad.library.solder.lib.ext.d.c.g(r9, r10)     // Catch: java.lang.Throwable -> L51
            monitor-exit(r3)
            return
        L51:
            r4 = move-exception
            java.lang.String r5 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r8 = r4.getMessage()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L1d
            r0[r2] = r7     // Catch: java.lang.Throwable -> L1d
            r0[r1] = r8     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = java.lang.String.format(r6, r0)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r5, r0)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.ext.d.a.e(r9, r10)     // Catch: java.lang.Throwable -> L71
            goto L9a
        L71:
            throw r4     // Catch: java.lang.Throwable -> L1d
        L72:
            r5 = 23
            if (r4 < r5) goto L9d
            com.kwad.library.solder.lib.ext.d.b.f(r9, r10)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r3)
            return
        L7b:
            r4 = move-exception
            java.lang.String r5 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r8 = r4.getMessage()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L1d
            r0[r2] = r7     // Catch: java.lang.Throwable -> L1d
            r0[r1] = r8     // Catch: java.lang.Throwable -> L1d
            java.lang.String r0 = java.lang.String.format(r6, r0)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r5, r0)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.ext.d.a.e(r9, r10)     // Catch: java.lang.Throwable -> L9c
        L9a:
            monitor-exit(r3)
            return
        L9c:
            throw r4     // Catch: java.lang.Throwable -> L1d
        L9d:
            com.kwad.library.solder.lib.ext.d.a.e(r9, r10)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)
            return
        La2:
            java.lang.String r9 = "Sodler.ShareLibraryLoader"
            java.lang.String r0 = "installNativeLibraryPath, folder %s is illegal"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L1d
            r1[r2] = r10     // Catch: java.lang.Throwable -> L1d
            java.lang.String r10 = java.lang.String.format(r0, r1)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r9, r10)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)
            return
        Lb3:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.ext.d.c(java.lang.ClassLoader, java.io.File):void");
    }
}
