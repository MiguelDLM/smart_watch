package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes9.dex */
final class zac implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;

    @Nullable
    private final Bitmap zac;
    private final CountDownLatch zad;

    public zac(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = bitmap;
        this.zad = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Object obj;
        HashSet hashSet;
        ArrayList arrayList;
        Map map2;
        zam zamVar;
        Map map3;
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        map = this.zaa.zai;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) map.remove(this.zab);
        if (imageReceiver != null) {
            arrayList = imageReceiver.zac;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zag zagVar = (zag) arrayList.get(i);
                Bitmap bitmap = this.zac;
                if (bitmap != null) {
                    zagVar.zac(this.zaa.zad, bitmap, false);
                } else {
                    ImageManager imageManager = this.zaa;
                    Uri uri = this.zab;
                    map2 = imageManager.zaj;
                    map2.put(uri, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager2 = this.zaa;
                    Context context = imageManager2.zad;
                    zamVar = imageManager2.zag;
                    zagVar.zab(context, zamVar, false);
                }
                if (!(zagVar instanceof zaf)) {
                    map3 = this.zaa.zah;
                    map3.remove(zagVar);
                }
            }
        }
        this.zad.countDown();
        obj = ImageManager.zaa;
        synchronized (obj) {
            hashSet = ImageManager.zab;
            hashSet.remove(this.zab);
        }
    }
}
