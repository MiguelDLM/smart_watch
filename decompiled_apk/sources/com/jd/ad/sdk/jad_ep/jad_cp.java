package com.jd.ad.sdk.jad_ep;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Registry;
import com.jd.ad.sdk.jad_ep.jad_dq;
import com.jd.ad.sdk.jad_ep.jad_fs;
import com.jd.ad.sdk.jad_it.jad_er;
import com.jd.ad.sdk.jad_it.jad_kx;
import com.jd.ad.sdk.jad_it.jad_mz;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_mx.jad_iv;
import com.jd.ad.sdk.jad_ny.jad_an;
import com.jd.ad.sdk.jad_oz.jad_an;
import com.jd.ad.sdk.jad_oz.jad_bo;
import com.jd.ad.sdk.jad_oz.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_er;
import com.jd.ad.sdk.jad_oz.jad_fs;
import com.jd.ad.sdk.jad_oz.jad_kx;
import com.jd.ad.sdk.jad_oz.jad_sf;
import com.jd.ad.sdk.jad_oz.jad_tg;
import com.jd.ad.sdk.jad_oz.jad_uh;
import com.jd.ad.sdk.jad_oz.jad_vi;
import com.jd.ad.sdk.jad_oz.jad_wj;
import com.jd.ad.sdk.jad_oz.jad_xk;
import com.jd.ad.sdk.jad_pa.jad_an;
import com.jd.ad.sdk.jad_pa.jad_bo;
import com.jd.ad.sdk.jad_pa.jad_cp;
import com.jd.ad.sdk.jad_pa.jad_dq;
import com.jd.ad.sdk.jad_pa.jad_er;
import com.jd.ad.sdk.jad_rc.jad_re;
import com.jd.ad.sdk.jad_rc.jad_uh;
import com.jd.ad.sdk.jad_rc.jad_wj;
import com.jd.ad.sdk.jad_rc.jad_xk;
import com.jd.ad.sdk.jad_sd.jad_an;
import com.jd.ad.sdk.jad_xi.jad_pc;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes10.dex */
public class jad_cp implements ComponentCallbacks2 {

    @GuardedBy("Glide.class")
    public static volatile jad_cp jad_iv;
    public static volatile boolean jad_jw;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_an;
    public final com.jd.ad.sdk.jad_mx.jad_hu jad_bo;
    public final jad_er jad_cp;
    public final jad_hu jad_dq;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_er;
    public final jad_pc jad_fs;

    @GuardedBy("managers")
    public final List<jad_jw> jad_hu = new ArrayList();
    public final com.jd.ad.sdk.jad_xi.jad_dq jad_jt;

    /* loaded from: classes10.dex */
    public interface jad_an {
    }

    public jad_cp(@NonNull Context context, @NonNull jad_mz jad_mzVar, @NonNull com.jd.ad.sdk.jad_mx.jad_hu jad_huVar, @NonNull com.jd.ad.sdk.jad_lw.jad_er jad_erVar, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, @NonNull jad_pc jad_pcVar, @NonNull com.jd.ad.sdk.jad_xi.jad_dq jad_dqVar, int i, @NonNull jad_an jad_anVar, @NonNull Map<Class<?>, jad_kx<?, ?>> map, @NonNull List<com.jd.ad.sdk.jad_al.jad_jt<Object>> list, jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_hs.jad_ly jad_fsVar2;
        com.jd.ad.sdk.jad_hs.jad_ly jad_uhVar;
        jad_hu jad_huVar2;
        this.jad_an = jad_erVar;
        this.jad_er = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_fs = jad_pcVar;
        this.jad_jt = jad_dqVar;
        Resources resources = context.getResources();
        jad_hu jad_huVar3 = new jad_hu();
        this.jad_dq = jad_huVar3;
        jad_huVar3.jad_an((com.jd.ad.sdk.jad_hs.jad_fs) new com.jd.ad.sdk.jad_rc.jad_hu());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            jad_huVar3.jad_an((com.jd.ad.sdk.jad_hs.jad_fs) new com.jd.ad.sdk.jad_rc.jad_mz());
        }
        List<com.jd.ad.sdk.jad_hs.jad_fs> jad_an2 = jad_huVar3.jad_an();
        com.jd.ad.sdk.jad_vg.jad_an jad_anVar2 = new com.jd.ad.sdk.jad_vg.jad_an(context, jad_an2, jad_erVar, jad_boVar);
        com.jd.ad.sdk.jad_hs.jad_ly<ParcelFileDescriptor, Bitmap> jad_cp = jad_xk.jad_cp(jad_erVar);
        com.jd.ad.sdk.jad_rc.jad_jw jad_jwVar = new com.jd.ad.sdk.jad_rc.jad_jw(jad_huVar3.jad_an(), resources.getDisplayMetrics(), jad_erVar, jad_boVar);
        if (i2 < 28 || !jad_fsVar.jad_an(jad_dq.jad_cp.class)) {
            jad_fsVar2 = new com.jd.ad.sdk.jad_rc.jad_fs(jad_jwVar);
            jad_uhVar = new jad_uh(jad_jwVar, jad_boVar);
        } else {
            jad_uhVar = new com.jd.ad.sdk.jad_rc.jad_pc();
            jad_fsVar2 = new com.jd.ad.sdk.jad_rc.jad_jt();
        }
        if (i2 >= 28 && jad_fsVar.jad_an(jad_dq.jad_bo.class)) {
            jad_huVar3.jad_an("Animation", InputStream.class, Drawable.class, com.jd.ad.sdk.jad_te.jad_an.jad_bo(jad_an2, jad_boVar));
            jad_huVar3.jad_an("Animation", ByteBuffer.class, Drawable.class, com.jd.ad.sdk.jad_te.jad_an.jad_an(jad_an2, jad_boVar));
        }
        com.jd.ad.sdk.jad_te.jad_er jad_erVar2 = new com.jd.ad.sdk.jad_te.jad_er(context);
        jad_sf.jad_cp jad_cpVar = new jad_sf.jad_cp(resources);
        jad_sf.jad_dq jad_dqVar2 = new jad_sf.jad_dq(resources);
        jad_sf.jad_bo jad_boVar2 = new jad_sf.jad_bo(resources);
        jad_sf.jad_an jad_anVar3 = new jad_sf.jad_an(resources);
        com.jd.ad.sdk.jad_rc.jad_cp jad_cpVar2 = new com.jd.ad.sdk.jad_rc.jad_cp(jad_boVar);
        com.jd.ad.sdk.jad_wh.jad_an jad_anVar4 = new com.jd.ad.sdk.jad_wh.jad_an();
        com.jd.ad.sdk.jad_wh.jad_dq jad_dqVar3 = new com.jd.ad.sdk.jad_wh.jad_dq();
        ContentResolver contentResolver = context.getContentResolver();
        jad_huVar3.jad_an(ByteBuffer.class, new com.jd.ad.sdk.jad_oz.jad_cp()).jad_an(InputStream.class, new jad_tg(jad_boVar)).jad_an(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, jad_fsVar2).jad_an(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, jad_uhVar);
        if (com.jd.ad.sdk.jad_it.jad_mz.jad_cp()) {
            jad_huVar3.jad_an(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new jad_re(jad_jwVar));
        }
        jad_hu jad_an3 = jad_huVar3.jad_an(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, jad_cp).jad_an(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, jad_xk.jad_an(jad_erVar));
        jad_vi.jad_an<?> jad_anVar5 = jad_vi.jad_an.jad_an;
        jad_an3.jad_an(Bitmap.class, Bitmap.class, jad_anVar5).jad_an(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new jad_wj()).jad_an(Bitmap.class, (com.jd.ad.sdk.jad_hs.jad_mz) jad_cpVar2).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_fsVar2)).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_uhVar)).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_cp)).jad_an(BitmapDrawable.class, (com.jd.ad.sdk.jad_hs.jad_mz) new com.jd.ad.sdk.jad_rc.jad_bo(jad_erVar, jad_cpVar2)).jad_an("Animation", InputStream.class, com.jd.ad.sdk.jad_vg.jad_cp.class, new com.jd.ad.sdk.jad_vg.jad_jw(jad_an2, jad_anVar2, jad_boVar)).jad_an("Animation", ByteBuffer.class, com.jd.ad.sdk.jad_vg.jad_cp.class, jad_anVar2).jad_an(com.jd.ad.sdk.jad_vg.jad_cp.class, (com.jd.ad.sdk.jad_hs.jad_mz) new com.jd.ad.sdk.jad_vg.jad_dq()).jad_an(com.jd.ad.sdk.jad_gr.jad_an.class, com.jd.ad.sdk.jad_gr.jad_an.class, jad_anVar5).jad_an(Registry.BUCKET_BITMAP, com.jd.ad.sdk.jad_gr.jad_an.class, Bitmap.class, new com.jd.ad.sdk.jad_vg.jad_hu(jad_erVar)).jad_an(Uri.class, Drawable.class, jad_erVar2).jad_an(Uri.class, Bitmap.class, new com.jd.ad.sdk.jad_rc.jad_tg(jad_erVar2, jad_erVar)).jad_an((jad_er.jad_an<?>) new jad_an.C0715jad_an()).jad_an(File.class, ByteBuffer.class, new jad_dq.jad_bo()).jad_an(File.class, InputStream.class, new jad_fs.jad_er()).jad_an(File.class, File.class, new com.jd.ad.sdk.jad_uf.jad_an()).jad_an(File.class, ParcelFileDescriptor.class, new jad_fs.jad_bo()).jad_an(File.class, File.class, jad_anVar5).jad_an((jad_er.jad_an<?>) new jad_kx.jad_an(jad_boVar));
        if (com.jd.ad.sdk.jad_it.jad_mz.jad_cp()) {
            jad_huVar2 = jad_huVar3;
            jad_huVar2.jad_an((jad_er.jad_an<?>) new jad_mz.jad_an());
        } else {
            jad_huVar2 = jad_huVar3;
        }
        Class cls = Integer.TYPE;
        jad_huVar2.jad_an(cls, InputStream.class, jad_cpVar).jad_an(cls, ParcelFileDescriptor.class, jad_boVar2).jad_an(Integer.class, InputStream.class, jad_cpVar).jad_an(Integer.class, ParcelFileDescriptor.class, jad_boVar2).jad_an(Integer.class, Uri.class, jad_dqVar2).jad_an(cls, AssetFileDescriptor.class, jad_anVar3).jad_an(Integer.class, AssetFileDescriptor.class, jad_anVar3).jad_an(cls, Uri.class, jad_dqVar2).jad_an(String.class, InputStream.class, new jad_er.jad_cp()).jad_an(Uri.class, InputStream.class, new jad_er.jad_cp()).jad_an(String.class, InputStream.class, new jad_uh.jad_cp()).jad_an(String.class, ParcelFileDescriptor.class, new jad_uh.jad_bo()).jad_an(String.class, AssetFileDescriptor.class, new jad_uh.jad_an()).jad_an(Uri.class, InputStream.class, new jad_an.jad_cp(context.getAssets())).jad_an(Uri.class, AssetFileDescriptor.class, new jad_an.jad_bo(context.getAssets())).jad_an(Uri.class, InputStream.class, new jad_bo.jad_an(context)).jad_an(Uri.class, InputStream.class, new jad_cp.jad_an(context));
        if (i2 >= 29) {
            jad_huVar2.jad_an(Uri.class, InputStream.class, new jad_dq.jad_cp(context));
            jad_huVar2.jad_an(Uri.class, ParcelFileDescriptor.class, new jad_dq.jad_bo(context));
        }
        jad_huVar2.jad_an(Uri.class, InputStream.class, new jad_wj.jad_dq(contentResolver)).jad_an(Uri.class, ParcelFileDescriptor.class, new jad_wj.jad_bo(contentResolver)).jad_an(Uri.class, AssetFileDescriptor.class, new jad_wj.jad_an(contentResolver)).jad_an(Uri.class, InputStream.class, new jad_xk.jad_an()).jad_an(URL.class, InputStream.class, new jad_er.jad_an()).jad_an(Uri.class, File.class, new jad_kx.jad_an(context)).jad_an(com.jd.ad.sdk.jad_oz.jad_jt.class, InputStream.class, new jad_an.C0710jad_an()).jad_an(byte[].class, ByteBuffer.class, new jad_bo.jad_an()).jad_an(byte[].class, InputStream.class, new jad_bo.jad_dq()).jad_an(Uri.class, Uri.class, jad_anVar5).jad_an(Drawable.class, Drawable.class, jad_anVar5).jad_an(Drawable.class, Drawable.class, new com.jd.ad.sdk.jad_te.jad_fs()).jad_an(Bitmap.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_wh.jad_bo(resources)).jad_an(Bitmap.class, byte[].class, jad_anVar4).jad_an(Drawable.class, byte[].class, new com.jd.ad.sdk.jad_wh.jad_cp(jad_erVar, jad_anVar4, jad_dqVar3)).jad_an(com.jd.ad.sdk.jad_vg.jad_cp.class, byte[].class, jad_dqVar3);
        if (i2 >= 23) {
            com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Bitmap> jad_bo = com.jd.ad.sdk.jad_rc.jad_xk.jad_bo(jad_erVar);
            jad_huVar2.jad_an(ByteBuffer.class, Bitmap.class, jad_bo);
            jad_huVar2.jad_an(ByteBuffer.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_bo));
        }
        this.jad_cp = new jad_er(context, jad_boVar, jad_huVar2, new com.jd.ad.sdk.jad_bm.jad_bo(), jad_anVar, map, list, jad_mzVar, jad_fsVar, i);
    }

    @NonNull
    public com.jd.ad.sdk.jad_lw.jad_er jad_an() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_xi.jad_dq jad_bo() {
        return this.jad_jt;
    }

    @NonNull
    public Context jad_cp() {
        return this.jad_cp.getBaseContext();
    }

    @NonNull
    public jad_er jad_dq() {
        return this.jad_cp;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        com.jd.ad.sdk.jad_gp.jad_ly.jad_an();
        ((com.jd.ad.sdk.jad_gp.jad_hu) this.jad_bo).jad_an(0L);
        this.jad_an.jad_an();
        this.jad_er.jad_an();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        long j;
        com.jd.ad.sdk.jad_gp.jad_ly.jad_an();
        synchronized (this.jad_hu) {
            try {
                Iterator<jad_jw> it = this.jad_hu.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.jd.ad.sdk.jad_mx.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_mx.jad_jt) this.jad_bo;
        jad_jtVar.getClass();
        if (i >= 40) {
            jad_jtVar.jad_an(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (jad_jtVar) {
                j = jad_jtVar.jad_bo;
            }
            jad_jtVar.jad_an(j / 2);
        }
        this.jad_an.jad_an(i);
        this.jad_er.jad_an(i);
    }

    @NonNull
    public static jad_jw jad_bo(@NonNull Context context) {
        if (context != null) {
            return jad_an(context).jad_fs.jad_bo(context);
        }
        throw new NullPointerException("You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    }

    public void jad_an(jad_jw jad_jwVar) {
        synchronized (this.jad_hu) {
            try {
                if (this.jad_hu.contains(jad_jwVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.jad_hu.add(jad_jwVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void jad_an(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @GuardedBy("Glide.class")
    public static void jad_an(@NonNull Context context, @Nullable com.jd.ad.sdk.jad_ep.jad_an jad_anVar) {
        if (jad_jw) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        jad_jw = true;
        jad_dq jad_dqVar = new jad_dq();
        Context applicationContext = context.getApplicationContext();
        List<com.jd.ad.sdk.jad_yj.jad_bo> emptyList = Collections.emptyList();
        if (jad_anVar != null && !jad_anVar.jad_an().isEmpty()) {
            Set<Class<?>> jad_an2 = jad_anVar.jad_an();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.jad_yj.jad_bo jad_boVar = (com.jd.ad.sdk.jad_yj.jad_bo) it.next();
                if (jad_an2.contains(jad_boVar.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Logger.d("Glide", "AppGlideModule excludes manifest GlideModule: " + jad_boVar);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (com.jd.ad.sdk.jad_yj.jad_bo jad_boVar2 : emptyList) {
                StringBuilder jad_an3 = jad_ly.jad_an("Discovered GlideModule from manifest: ");
                jad_an3.append(jad_boVar2.getClass());
                Logger.d("Glide", jad_an3.toString());
            }
        }
        jad_dqVar.jad_na = null;
        Iterator it2 = emptyList.iterator();
        while (it2.hasNext()) {
            ((com.jd.ad.sdk.jad_yj.jad_bo) it2.next()).jad_an(applicationContext, jad_dqVar);
        }
        if (jad_dqVar.jad_jt == null) {
            jad_an.ThreadFactoryC0701jad_an threadFactoryC0701jad_an = new jad_an.ThreadFactoryC0701jad_an();
            int jad_an4 = com.jd.ad.sdk.jad_ny.jad_an.jad_an();
            if (TextUtils.isEmpty("source")) {
                StringBuilder jad_an5 = jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an5.append("source");
                throw new IllegalArgumentException(jad_an5.toString());
            }
            jad_dqVar.jad_jt = new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(jad_an4, jad_an4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jad_an.jad_bo(threadFactoryC0701jad_an, "source", jad_an.jad_cp.jad_an, false)));
        }
        if (jad_dqVar.jad_hu == null) {
            int i = com.jd.ad.sdk.jad_ny.jad_an.jad_cp;
            jad_an.ThreadFactoryC0701jad_an threadFactoryC0701jad_an2 = new jad_an.ThreadFactoryC0701jad_an();
            if (TextUtils.isEmpty("disk-cache")) {
                StringBuilder jad_an6 = jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an6.append("disk-cache");
                throw new IllegalArgumentException(jad_an6.toString());
            }
            jad_dqVar.jad_hu = new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jad_an.jad_bo(threadFactoryC0701jad_an2, "disk-cache", jad_an.jad_cp.jad_an, true)));
        }
        if (jad_dqVar.jad_ob == null) {
            int i2 = com.jd.ad.sdk.jad_ny.jad_an.jad_an() >= 4 ? 2 : 1;
            jad_an.ThreadFactoryC0701jad_an threadFactoryC0701jad_an3 = new jad_an.ThreadFactoryC0701jad_an();
            if (TextUtils.isEmpty("animation")) {
                StringBuilder jad_an7 = jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an7.append("animation");
                throw new IllegalArgumentException(jad_an7.toString());
            }
            jad_dqVar.jad_ob = new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jad_an.jad_bo(threadFactoryC0701jad_an3, "animation", jad_an.jad_cp.jad_an, true)));
        }
        if (jad_dqVar.jad_jw == null) {
            jad_dqVar.jad_jw = new com.jd.ad.sdk.jad_mx.jad_iv(new jad_iv.jad_an(applicationContext));
        }
        if (jad_dqVar.jad_kx == null) {
            jad_dqVar.jad_kx = new com.jd.ad.sdk.jad_xi.jad_fs();
        }
        if (jad_dqVar.jad_dq == null) {
            int i3 = jad_dqVar.jad_jw.jad_an;
            if (i3 > 0) {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_lw.jad_kx(i3, com.jd.ad.sdk.jad_lw.jad_kx.jad_er(), com.jd.ad.sdk.jad_lw.jad_kx.jad_dq());
            } else {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_lw.jad_fs();
            }
        }
        if (jad_dqVar.jad_er == null) {
            jad_dqVar.jad_er = new com.jd.ad.sdk.jad_lw.jad_jw(jad_dqVar.jad_jw.jad_dq);
        }
        if (jad_dqVar.jad_fs == null) {
            jad_dqVar.jad_fs = new com.jd.ad.sdk.jad_mx.jad_jt(jad_dqVar.jad_jw.jad_bo);
        }
        if (jad_dqVar.jad_iv == null) {
            jad_dqVar.jad_iv = new com.jd.ad.sdk.jad_mx.jad_fs(applicationContext, "image_manager_disk_cache", 262144000L);
        }
        if (jad_dqVar.jad_cp == null) {
            jad_dqVar.jad_cp = new com.jd.ad.sdk.jad_kv.jad_mz(jad_dqVar.jad_fs, jad_dqVar.jad_iv, jad_dqVar.jad_hu, jad_dqVar.jad_jt, new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(0, Integer.MAX_VALUE, com.jd.ad.sdk.jad_ny.jad_an.jad_bo, TimeUnit.MILLISECONDS, new SynchronousQueue(), new jad_an.jad_bo(new jad_an.ThreadFactoryC0701jad_an(), "source-unlimited", jad_an.jad_cp.jad_an, false))), jad_dqVar.jad_ob, null, null, null, null, null, null, false);
        }
        List<com.jd.ad.sdk.jad_al.jad_jt<Object>> list = jad_dqVar.jad_pc;
        jad_dqVar.jad_pc = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        jad_fs.jad_an jad_anVar2 = jad_dqVar.jad_bo;
        jad_anVar2.getClass();
        jad_fs jad_fsVar = new jad_fs(jad_anVar2);
        jad_cp jad_cpVar = new jad_cp(applicationContext, jad_dqVar.jad_cp, jad_dqVar.jad_fs, jad_dqVar.jad_dq, jad_dqVar.jad_er, new jad_pc(jad_dqVar.jad_na, jad_fsVar), jad_dqVar.jad_kx, jad_dqVar.jad_ly, jad_dqVar.jad_mz, jad_dqVar.jad_an, jad_dqVar.jad_pc, jad_fsVar);
        for (com.jd.ad.sdk.jad_yj.jad_bo jad_boVar3 : emptyList) {
            try {
                jad_boVar3.jad_an(applicationContext, jad_cpVar, jad_cpVar.jad_dq);
            } catch (AbstractMethodError e) {
                StringBuilder jad_an8 = jad_ly.jad_an("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                jad_an8.append(jad_boVar3.getClass().getName());
                throw new IllegalStateException(jad_an8.toString(), e);
            }
        }
        applicationContext.registerComponentCallbacks(jad_cpVar);
        jad_iv = jad_cpVar;
        jad_jw = false;
    }

    @NonNull
    public static jad_cp jad_an(@NonNull Context context) {
        if (jad_iv == null) {
            com.jd.ad.sdk.jad_ep.jad_an jad_anVar = null;
            try {
                jad_anVar = (com.jd.ad.sdk.jad_ep.jad_an) Class.forName("com.jd.ad.sdk.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Logger.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (IllegalAccessException e) {
                jad_an(e);
                throw null;
            } catch (InstantiationException e2) {
                jad_an(e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                jad_an(e3);
                throw null;
            } catch (InvocationTargetException e4) {
                jad_an(e4);
                throw null;
            }
            synchronized (jad_cp.class) {
                try {
                    if (jad_iv == null) {
                        jad_an(context, jad_anVar);
                    }
                } finally {
                }
            }
        }
        return jad_iv;
    }
}
