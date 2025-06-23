package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes11.dex */
public class a {
    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (a(r7, java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getADActivityName())) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        if (a(r7, java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getPortraitADActivityName())) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (a(r7, java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getLandscapeADActivityName())) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        r2 = new java.lang.Class[]{java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getDownLoadServiceName())}[0];
        r3 = new android.content.Intent();
        r3.setClass(r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r7.getPackageManager().resolveService(r3, 65536) != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Service[%s]需要在AndroidManifest.xml中声明", r2.getName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a2, code lost:
    
        com.qq.e.comm.util.GDTLogger.e("检查Service时发生异常", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r7) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "android.permission.INTERNET"
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L31
            r3 = 0
        Lb:
            r4 = 2
            if (r3 >= r4) goto L34
            r4 = r2[r3]     // Catch: java.lang.Throwable -> L26
            int r5 = r7.checkCallingOrSelfPermission(r4)     // Catch: java.lang.Throwable -> L26
            r6 = -1
            if (r5 != r6) goto L28
            java.lang.String r7 = "Permission[%s]需要在AndroidManifest.xml中声明"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L26
            r1[r0] = r4     // Catch: java.lang.Throwable -> L26
            java.lang.String r7 = java.lang.String.format(r7, r1)     // Catch: java.lang.Throwable -> L26
            com.qq.e.comm.util.GDTLogger.e(r7)     // Catch: java.lang.Throwable -> L26
            goto La7
        L26:
            r7 = move-exception
            goto L2a
        L28:
            int r3 = r3 + r1
            goto Lb
        L2a:
            java.lang.String r1 = "检查权限时发生异常"
            com.qq.e.comm.util.GDTLogger.e(r1, r7)     // Catch: java.lang.Throwable -> L31
            goto La7
        L31:
            r7 = move-exception
            goto La8
        L34:
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getADActivityName()     // Catch: java.lang.Throwable -> L31
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L31
            r3[r0] = r2     // Catch: java.lang.Throwable -> L31
            boolean r2 = a(r7, r3)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto La7
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getPortraitADActivityName()     // Catch: java.lang.Throwable -> L31
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L31
            r3[r0] = r2     // Catch: java.lang.Throwable -> L31
            boolean r2 = a(r7, r3)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto La7
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getLandscapeADActivityName()     // Catch: java.lang.Throwable -> L31
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L31
            r3[r0] = r2     // Catch: java.lang.Throwable -> L31
            boolean r2 = a(r7, r3)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto La7
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getDownLoadServiceName()     // Catch: java.lang.Throwable -> L31
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L31
            r3[r0] = r2     // Catch: java.lang.Throwable -> L31
            r2 = r3[r0]     // Catch: java.lang.Throwable -> L9e
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L9e
            r3.<init>()     // Catch: java.lang.Throwable -> L9e
            r3.setClass(r7, r2)     // Catch: java.lang.Throwable -> L9e
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch: java.lang.Throwable -> L9e
            r4 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveService(r3, r4)     // Catch: java.lang.Throwable -> L9e
            if (r7 != 0) goto La0
            java.lang.String r7 = "Service[%s]需要在AndroidManifest.xml中声明"
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L9e
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
            r1[r0] = r2     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = java.lang.String.format(r7, r1)     // Catch: java.lang.Throwable -> L9e
            com.qq.e.comm.util.GDTLogger.e(r7)     // Catch: java.lang.Throwable -> L9e
            goto La7
        L9e:
            r7 = move-exception
            goto La2
        La0:
            r0 = 1
            goto La7
        La2:
            java.lang.String r1 = "检查Service时发生异常"
            com.qq.e.comm.util.GDTLogger.e(r1, r7)     // Catch: java.lang.Throwable -> L31
        La7:
            return r0
        La8:
            java.lang.String r1 = "检查AndroidManifest.xml时发生异常"
            com.qq.e.comm.util.GDTLogger.e(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(android.content.Context):boolean");
    }
}
