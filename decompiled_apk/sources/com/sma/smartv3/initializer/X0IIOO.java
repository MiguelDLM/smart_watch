package com.sma.smartv3.initializer;

import android.app.Application;
import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.biz.fitness_site.FitnessSiteUploadWorker;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.work.DataWorker;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkInitializer.kt\ncom/sma/smartv3/initializer/WorkInitializer\n+ 2 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequestKt\n*L\n1#1,93:1\n368#2:94\n368#2:95\n*S KotlinDebug\n*F\n+ 1 WorkInitializer.kt\ncom/sma/smartv3/initializer/WorkInitializer\n*L\n52#1:94\n72#1:95\n*E\n"})
/* loaded from: classes12.dex */
public final class X0IIOO implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20920IXxxXO = "fitness_site_upload";

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20921Oo = "uploadData";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20922Oxx0xo = "zewafit_upload";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0IIOO f20923XO = new X0IIOO();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static Application f20924oI0IIXIo;

    public final void I0Io(Application application) {
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        WorkManager.Companion.getInstance(application).enqueueUniquePeriodicWork(" sync sport data ", ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) DataWorker.class, 30L, timeUnit).setConstraints(build).setInitialDelay(5L, timeUnit).addTag(f20921Oo).build());
    }

    public final void II0xO0(Application application) {
        WorkManager.Companion.getInstance(application).enqueueUniquePeriodicWork(f20920IXxxXO, ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) FitnessSiteUploadWorker.class, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setInitialDelay(1L, TimeUnit.MINUTES).addTag(f20920IXxxXO).build());
    }

    @XO0.XO(tag = XoI0Ixx0.f24489xoIox)
    public final void X0o0xo(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onPrivacyAgree");
        Application application = f20924oI0IIXIo;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("app");
            application = null;
        }
        I0Io(application);
        Application application3 = f20924oI0IIXIo;
        if (application3 == null) {
            IIX0o.XOxIOxOx("app");
        } else {
            application2 = application3;
        }
        II0xO0(application2);
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        f20924oI0IIXIo = app;
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false)) {
            LogUtils.d("WorkInitializer initialize");
            X0o0xo(new Object());
        }
    }

    public final void oxoX(@OXOo.OOXIXo Context mContext, @OXOo.OOXIXo String tag) {
        IIX0o.x0xO0oo(mContext, "mContext");
        IIX0o.x0xO0oo(tag, "tag");
        WorkManager.Companion.getInstance(mContext).cancelAllWorkByTag(tag);
    }
}
