package com.jd.ad.sdk.jad_sb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.an;
import com.jd.ad.sdk.jad_js.jad_hu;
import com.jd.ad.sdk.jad_js.jad_jt;
import com.jd.ad.sdk.jad_js.jad_sf;
import com.jd.ad.sdk.jad_js.jad_zm;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes10.dex */
public class jad_fs {

    @NonNull
    public final jad_er jad_an;

    @NonNull
    public final jad_bo jad_bo;

    public jad_fs(@NonNull jad_er jad_erVar, @NonNull jad_bo jad_boVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_boVar;
    }

    @NonNull
    public final jad_sf<jad_jt> jad_an(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) {
        jad_cp jad_cpVar;
        jad_sf<jad_jt> jad_an;
        if (str2 == null) {
            str2 = an.d;
        }
        if (!str2.contains(DfuBaseService.MIME_TYPE_ZIP) && !str.split("\\?")[0].endsWith(".lottie")) {
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an.getClass();
            jad_cpVar = jad_cp.JSON;
            if (str3 == null) {
                jad_an = jad_hu.jad_an(inputStream, (String) null);
            } else {
                jad_an = jad_hu.jad_an(new FileInputStream(this.jad_an.jad_an(str, inputStream, jad_cpVar).getAbsolutePath()), str);
            }
        } else {
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an.getClass();
            jad_cpVar = jad_cp.ZIP;
            if (str3 == null) {
                jad_an = jad_hu.jad_an(new ZipInputStream(inputStream), (String) null);
            } else {
                jad_an = jad_hu.jad_an(new ZipInputStream(new FileInputStream(this.jad_an.jad_an(str, inputStream, jad_cpVar))), str);
            }
        }
        if (str3 != null && jad_an.jad_an != null) {
            jad_er jad_erVar = this.jad_an;
            jad_erVar.getClass();
            File file = new File(jad_erVar.jad_an(), jad_er.jad_an(str, jad_cpVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean renameTo = file.renameTo(file2);
            file2.toString();
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an.getClass();
            if (!renameTo) {
                StringBuilder jad_an2 = jad_zm.jad_an("Unable to rename cache file ");
                jad_an2.append(file.getAbsolutePath());
                jad_an2.append(" to ");
                jad_an2.append(file2.getAbsolutePath());
                jad_an2.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_an2.toString());
            }
        }
        return jad_an;
    }
}
