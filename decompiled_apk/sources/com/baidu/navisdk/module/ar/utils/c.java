package com.baidu.navisdk.module.ar.utils;

import OXOo.OOXIXo;
import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final c f7009a = new c();

    private c() {
    }

    public final void a(@OOXIXo Context appCtx, @OOXIXo String srcDir, @OOXIXo String dstDir) {
        IIX0o.x0xO0oo(appCtx, "appCtx");
        IIX0o.x0xO0oo(srcDir, "srcDir");
        IIX0o.x0xO0oo(dstDir, "dstDir");
        if (srcDir.length() == 0 || dstDir.length() == 0) {
            return;
        }
        try {
            if (!new File(dstDir).exists()) {
                new File(dstDir).mkdirs();
            }
            String[] list = appCtx.getAssets().list(srcDir);
            IIX0o.ooOOo0oXI(list);
            for (String str : list) {
                StringBuilder sb = new StringBuilder();
                sb.append(srcDir);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(str);
                String sb2 = sb.toString();
                String str3 = dstDir + str2 + str;
                if (new File(sb2).isDirectory()) {
                    a(appCtx, sb2, str3);
                } else {
                    b(appCtx, sb2, str3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cc A[Catch: IOException -> 0x00c8, TRY_LEAVE, TryCatch #10 {IOException -> 0x00c8, blocks: (B:69:0x00c4, B:62:0x00cc), top: B:68:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(@OXOo.OOXIXo android.content.Context r8, @OXOo.OOXIXo java.lang.String r9, @OXOo.OOXIXo java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.ar.utils.c.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void a(@OOXIXo String fileDir) {
        IIX0o.x0xO0oo(fileDir, "fileDir");
        Object[] array = StringsKt__StringsKt.XXoO0oX(fileDir, new String[]{"\\/"}, false, 0, 6, null).toArray(new String[0]);
        if (array != null) {
            String str = "";
            for (String str2 : (String[]) array) {
                str = str + "/" + str2;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
