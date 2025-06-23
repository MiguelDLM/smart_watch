package com.alibaba.fastjson.util;

import androidx.exifinterface.media.ExifInterface;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.x;
import com.vtrump.vtble.Oxx0IOOO;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ASMUtils {
    public static final boolean IS_ANDROID;
    public static final String JAVA_VM_NAME;

    static {
        String property = System.getProperty("java.vm.name");
        JAVA_VM_NAME = property;
        IS_ANDROID = isAndroid(property);
    }

    public static boolean checkName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < 1 || charAt > 127 || charAt == '.') {
                return false;
            }
        }
        return true;
    }

    public static String desc(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder((parameterTypes.length + 1) << 4);
        sb.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
        for (Class desc : parameterTypes) {
            sb.append(desc((Class<?>) desc));
        }
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        sb.append(desc(method.getReturnType()));
        return sb.toString();
    }

    public static Type getMethodType(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, (Class[]) null).getGenericReturnType();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getPrimitiveLetter(Class<?> cls) {
        if (Integer.TYPE == cls) {
            return Oxx0IOOO.f13869xI;
        }
        if (Void.TYPE == cls) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        if (Boolean.TYPE == cls) {
            return "Z";
        }
        if (Character.TYPE == cls) {
            return "C";
        }
        if (Byte.TYPE == cls) {
            return "B";
        }
        if (Short.TYPE == cls) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (Float.TYPE == cls) {
            return "F";
        }
        if (Long.TYPE == cls) {
            return ContentClassification.AD_CONTENT_CLASSIFICATION_J;
        }
        if (Double.TYPE == cls) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    public static boolean isAndroid(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("dalvik") || lowerCase.contains("lemur")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00aa, code lost:
        return new java.lang.String[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        com.alibaba.fastjson.util.IOUtils.close(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        throw r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00a5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] lookupParameterNames(java.lang.reflect.AccessibleObject r8) {
        /*
            boolean r0 = IS_ANDROID
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.lang.String[] r8 = new java.lang.String[r1]
            return r8
        L_0x0008:
            boolean r0 = r8 instanceof java.lang.reflect.Method
            if (r0 == 0) goto L_0x001f
            java.lang.reflect.Method r8 = (java.lang.reflect.Method) r8
            java.lang.Class[] r0 = r8.getParameterTypes()
            java.lang.String r2 = r8.getName()
            java.lang.Class r3 = r8.getDeclaringClass()
            java.lang.annotation.Annotation[][] r8 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Method) r8)
            goto L_0x002f
        L_0x001f:
            java.lang.reflect.Constructor r8 = (java.lang.reflect.Constructor) r8
            java.lang.Class[] r0 = r8.getParameterTypes()
            java.lang.Class r3 = r8.getDeclaringClass()
            java.lang.annotation.Annotation[][] r8 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r8)
            java.lang.String r2 = "<init>"
        L_0x002f:
            int r4 = r0.length
            if (r4 != 0) goto L_0x0035
            java.lang.String[] r8 = new java.lang.String[r1]
            return r8
        L_0x0035:
            java.lang.ClassLoader r4 = r3.getClassLoader()
            if (r4 != 0) goto L_0x003f
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()
        L_0x003f:
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 46
            r7 = 47
            java.lang.String r3 = r3.replace(r6, r7)
            r5.append(r3)
            java.lang.String r3 = ".class"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.io.InputStream r3 = r4.getResourceAsStream(r3)
            if (r3 != 0) goto L_0x0065
            java.lang.String[] r8 = new java.lang.String[r1]
            return r8
        L_0x0065:
            com.alibaba.fastjson.asm.ClassReader r4 = new com.alibaba.fastjson.asm.ClassReader     // Catch:{ IOException -> 0x00a5 }
            r4.<init>(r3, r1)     // Catch:{ IOException -> 0x00a5 }
            com.alibaba.fastjson.asm.TypeCollector r5 = new com.alibaba.fastjson.asm.TypeCollector     // Catch:{ IOException -> 0x00a5 }
            r5.<init>(r2, r0)     // Catch:{ IOException -> 0x00a5 }
            r4.accept(r5)     // Catch:{ IOException -> 0x00a5 }
            java.lang.String[] r0 = r5.getParameterNamesForMethod()     // Catch:{ IOException -> 0x00a5 }
            r2 = 0
        L_0x0077:
            int r4 = r0.length     // Catch:{ IOException -> 0x00a5 }
            if (r2 >= r4) goto L_0x00a1
            r4 = r8[r2]     // Catch:{ IOException -> 0x00a5 }
            if (r4 == 0) goto L_0x009e
            r5 = 0
        L_0x007f:
            int r6 = r4.length     // Catch:{ IOException -> 0x00a5 }
            if (r5 >= r6) goto L_0x009e
            r6 = r4[r5]     // Catch:{ IOException -> 0x00a5 }
            boolean r7 = r6 instanceof com.alibaba.fastjson.annotation.JSONField     // Catch:{ IOException -> 0x00a5 }
            if (r7 == 0) goto L_0x009b
            com.alibaba.fastjson.annotation.JSONField r6 = (com.alibaba.fastjson.annotation.JSONField) r6     // Catch:{ IOException -> 0x00a5 }
            java.lang.String r6 = r6.name()     // Catch:{ IOException -> 0x00a5 }
            if (r6 == 0) goto L_0x009b
            int r7 = r6.length()     // Catch:{ IOException -> 0x00a5 }
            if (r7 <= 0) goto L_0x009b
            r0[r2] = r6     // Catch:{ IOException -> 0x00a5 }
            goto L_0x009b
        L_0x0099:
            r8 = move-exception
            goto L_0x00ab
        L_0x009b:
            int r5 = r5 + 1
            goto L_0x007f
        L_0x009e:
            int r2 = r2 + 1
            goto L_0x0077
        L_0x00a1:
            com.alibaba.fastjson.util.IOUtils.close(r3)
            return r0
        L_0x00a5:
            java.lang.String[] r8 = new java.lang.String[r1]     // Catch:{ all -> 0x0099 }
            com.alibaba.fastjson.util.IOUtils.close(r3)
            return r8
        L_0x00ab:
            com.alibaba.fastjson.util.IOUtils.close(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(java.lang.reflect.AccessibleObject):java.lang.String[]");
    }

    public static String type(Class<?> cls) {
        if (cls.isArray()) {
            return "[" + desc(cls.getComponentType());
        } else if (!cls.isPrimitive()) {
            return cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
        } else {
            return getPrimitiveLetter(cls);
        }
    }

    public static String desc(Class<?> cls) {
        if (cls.isPrimitive()) {
            return getPrimitiveLetter(cls);
        }
        if (cls.isArray()) {
            return "[" + desc(cls.getComponentType());
        }
        return "L" + type(cls) + x.aL;
    }
}
