package com.bytedance.pangle.dex;

import com.bytedance.pangle.d.c;
import com.bytedance.pangle.e.b;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.util.FieldUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f10531a;
    private static volatile Constructor<?> b;

    public static void a(ClassLoader classLoader, String str, int i) {
        Object obj = FieldUtils.getField(classLoader.getClass(), "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        String[] split = g.a(str, i).split(":");
        String c = c.c(str, i);
        for (String str2 : split) {
            Object native_load_direct_dex = DirectDex.native_load_direct_dex(str2);
            if (native_load_direct_dex == null) {
                native_load_direct_dex = DexFile.loadDex(str2, c + File.separator + b.a(str2), 0);
            }
            arrayList.add(a(new File(str2), native_load_direct_dex));
        }
        Object[] array = arrayList.toArray();
        Field field = FieldUtils.getField(obj.getClass(), "dexElements");
        Object[] objArr = (Object[]) field.get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + array.length);
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        System.arraycopy(array, 0, objArr2, objArr.length, array.length);
        field.set(obj, objArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x001d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object a(java.io.File r13, java.lang.Object r14) {
        /*
            r0 = 4
            r1 = 3
            r2 = 0
            r3 = 2
            r4 = 1
            int r5 = com.bytedance.pangle.dex.a.f10531a
            java.lang.reflect.Constructor<?> r6 = com.bytedance.pangle.dex.a.b
            r7 = 0
            if (r6 != 0) goto L14
            java.lang.String r8 = "dalvik.system.DexPathList$Element"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Exception -> L13
            goto L15
        L13:
        L14:
            r8 = r7
        L15:
            r9 = 8
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            java.lang.Class<java.io.File> r11 = java.io.File.class
            if (r6 != 0) goto L35
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L33
            r6[r2] = r11     // Catch: java.lang.Exception -> L33
            java.lang.Class r12 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L33
            r6[r4] = r12     // Catch: java.lang.Exception -> L33
            r6[r3] = r11     // Catch: java.lang.Exception -> L33
            r6[r1] = r10     // Catch: java.lang.Exception -> L33
            java.lang.reflect.Constructor r6 = r8.getConstructor(r6)     // Catch: java.lang.Exception -> L33
            r6.setAccessible(r4)     // Catch: java.lang.Exception -> L33
            r5 = 8
            goto L35
        L33:
            r6 = r7
        L35:
            if (r6 != 0) goto L4c
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L4a
            r6[r2] = r11     // Catch: java.lang.Exception -> L4a
            java.lang.Class<java.util.zip.ZipFile> r12 = java.util.zip.ZipFile.class
            r6[r4] = r12     // Catch: java.lang.Exception -> L4a
            r6[r3] = r10     // Catch: java.lang.Exception -> L4a
            java.lang.reflect.Constructor r6 = r8.getConstructor(r6)     // Catch: java.lang.Exception -> L4a
            r6.setAccessible(r4)     // Catch: java.lang.Exception -> L4a
            r5 = 4
            goto L4c
        L4a:
            r6 = r7
        L4c:
            if (r6 != 0) goto L61
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L5f
            r6[r2] = r11     // Catch: java.lang.Exception -> L5f
            r6[r4] = r11     // Catch: java.lang.Exception -> L5f
            r6[r3] = r10     // Catch: java.lang.Exception -> L5f
            java.lang.reflect.Constructor r6 = r8.getConstructor(r6)     // Catch: java.lang.Exception -> L5f
            r6.setAccessible(r4)     // Catch: java.lang.Exception -> L5f
            r5 = 2
            goto L61
        L5f:
            r6 = r7
        L61:
            if (r6 != 0) goto L79
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L78
            r6[r2] = r11     // Catch: java.lang.Exception -> L78
            java.lang.Class r12 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L78
            r6[r4] = r12     // Catch: java.lang.Exception -> L78
            r6[r3] = r11     // Catch: java.lang.Exception -> L78
            r6[r1] = r10     // Catch: java.lang.Exception -> L78
            java.lang.reflect.Constructor r6 = r8.getConstructor(r6)     // Catch: java.lang.Exception -> L78
            r6.setAccessible(r4)     // Catch: java.lang.Exception -> L78
            r5 = 1
            goto L79
        L78:
            r6 = r7
        L79:
            com.bytedance.pangle.dex.a.b = r6
            com.bytedance.pangle.dex.a.f10531a = r5
            if (r5 == r4) goto L93
            if (r5 == r3) goto L86
            if (r5 == r0) goto L86
            if (r5 == r9) goto L93
            goto La3
        L86:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r0[r2] = r13
            r0[r4] = r7
            r0[r3] = r14
            java.lang.Object r7 = a(r6, r0)
            goto La3
        L93:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r13
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            r0[r4] = r13
            r0[r3] = r7
            r0[r1] = r14
            java.lang.Object r7 = a(r6, r0)
        La3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.dex.a.a(java.io.File, java.lang.Object):java.lang.Object");
    }

    private static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
