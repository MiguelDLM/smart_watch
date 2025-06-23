package androidx.activity;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,178:1\n1#2:179\n1855#3,2:180\n*S KotlinDebug\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n*L\n143#1:180,2\n*E\n"})
public final class FullyDrawnReporter {
    @OOXIXo
    private final Executor executor;
    @OOXIXo
    private final Object lock = new Object();
    @GuardedBy("lock")
    @OOXIXo
    private final List<oIX0oI<oXIO0o0XI>> onReportCallbacks = new ArrayList();
    @OOXIXo
    private final oIX0oI<oXIO0o0XI> reportFullyDrawn;
    @GuardedBy("lock")
    private boolean reportPosted;
    @OOXIXo
    private final Runnable reportRunnable = new IXxxXO(this);
    @GuardedBy("lock")
    private boolean reportedFullyDrawn;
    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(@OOXIXo Executor executor2, @OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
        IIX0o.x0xO0oo(executor2, "executor");
        IIX0o.x0xO0oo(oix0oi, "reportFullyDrawn");
        this.executor = executor2;
        this.reportFullyDrawn = oix0oi;
    }

    private final void postWhenReportersAreDone() {
        if (!this.reportPosted && this.reporterCount == 0) {
            this.reportPosted = true;
            this.executor.execute(this.reportRunnable);
        }
    }

    /* access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter fullyDrawnReporter) {
        synchronized (fullyDrawnReporter.lock) {
            try {
                fullyDrawnReporter.reportPosted = false;
                if (fullyDrawnReporter.reporterCount == 0 && !fullyDrawnReporter.reportedFullyDrawn) {
                    fullyDrawnReporter.reportFullyDrawn.invoke();
                    fullyDrawnReporter.fullyDrawnReported();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void addOnReportDrawnListener(@OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
        boolean z;
        IIX0o.x0xO0oo(oix0oi, bn.f.L);
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z = true;
            } else {
                this.onReportCallbacks.add(oix0oi);
                z = false;
            }
        }
        if (z) {
            oix0oi.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn) {
                    this.reporterCount++;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                for (oIX0oI invoke : this.onReportCallbacks) {
                    invoke.invoke();
                }
                this.onReportCallbacks.clear();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z;
        synchronized (this.lock) {
            z = this.reportedFullyDrawn;
        }
        return z;
    }

    public final void removeOnReportDrawnListener(@OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
        IIX0o.x0xO0oo(oix0oi, bn.f.L);
        synchronized (this.lock) {
            this.onReportCallbacks.remove(oix0oi);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        }
    }

    public final void removeReporter() {
        int i;
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn && (i = this.reporterCount) > 0) {
                    this.reporterCount = i - 1;
                    postWhenReportersAreDone();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
