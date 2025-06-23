package com.kuaishou.weapon.p0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"LongLogTag"})
/* renamed from: com.kuaishou.weapon.p0.do, reason: invalid class name */
/* loaded from: classes11.dex */
public class Cdo {

    /* renamed from: com.kuaishou.weapon.p0.do$a */
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            Field a2 = dq.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a2.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            a2.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$b */
    /* loaded from: classes11.dex */
    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            Field a2 = dq.a(obj, "nativeLibraryDirectories");
            Collection collection = (List) a2.get(obj);
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
            a2.set(obj, arrayList);
            if (a2.get(obj) != arrayList) {
                dq.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field a3 = dq.a(obj, "nativeLibraryPathElements");
            a3.set(obj, obj2);
            if (a3.get(obj) != obj2) {
                dq.b(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$c */
    /* loaded from: classes11.dex */
    public static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            List list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
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
            List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$d */
    /* loaded from: classes11.dex */
    public static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            List list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
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
            List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$e */
    /* loaded from: classes11.dex */
    public static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field a2 = dq.a(classLoader, "libPath");
            String valueOf = String.valueOf(a2.get(classLoader));
            if (!TextUtils.isEmpty(valueOf)) {
                str = valueOf + ":" + path;
            } else {
                str = path;
            }
            a2.set(classLoader, str);
            Field a3 = dq.a(classLoader, "libraryPathElements");
            List list = (List) a3.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            a3.set(classLoader, list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
    
        if (r3 == 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(java.lang.ClassLoader r4, java.io.File r5) {
        /*
            java.lang.Class<com.kuaishou.weapon.p0.do> r0 = com.kuaishou.weapon.p0.Cdo.class
            monitor-enter(r0)
            if (r5 == 0) goto L4d
            boolean r1 = r5.exists()     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto Lc
            goto L4d
        Lc:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L19
            r2 = 25
            if (r1 != r2) goto L1b
            int r3 = com.bytedance.pangle.I0Io.oIX0oI()     // Catch: java.lang.Throwable -> L19
            if (r3 != 0) goto L1d
            goto L1b
        L19:
            r4 = move-exception
            goto L4b
        L1b:
            if (r1 <= r2) goto L27
        L1d:
            com.kuaishou.weapon.p0.Cdo.d.a(r4, r5)     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return
        L22:
            com.kuaishou.weapon.p0.Cdo.b.a(r4, r5)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r0)
            return
        L27:
            r2 = 24
            if (r1 != r2) goto L36
            com.kuaishou.weapon.p0.Cdo.c.a(r4, r5)     // Catch: java.lang.Throwable -> L30
            monitor-exit(r0)
            return
        L30:
            r1 = move-exception
            com.kuaishou.weapon.p0.Cdo.a.a(r4, r5)     // Catch: java.lang.Throwable -> L35
            goto L43
        L35:
            throw r1     // Catch: java.lang.Throwable -> L19
        L36:
            r2 = 23
            if (r1 < r2) goto L46
            com.kuaishou.weapon.p0.Cdo.b.a(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r0)
            return
        L3f:
            r1 = move-exception
            com.kuaishou.weapon.p0.Cdo.a.a(r4, r5)     // Catch: java.lang.Throwable -> L45
        L43:
            monitor-exit(r0)
            return
        L45:
            throw r1     // Catch: java.lang.Throwable -> L19
        L46:
            com.kuaishou.weapon.p0.Cdo.a.a(r4, r5)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r0)
            return
        L4b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            throw r4
        L4d:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.Cdo.a(java.lang.ClassLoader, java.io.File):void");
    }
}
