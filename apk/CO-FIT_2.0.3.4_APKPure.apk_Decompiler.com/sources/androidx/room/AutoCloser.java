package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAutoCloser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoCloser.kt\nandroidx/room/AutoCloser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,228:1\n1#2:229\n*E\n"})
public final class AutoCloser {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;
    @OOXIXo
    private final Runnable autoCloser;
    @GuardedBy("lock")
    @oOoXoXO
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;
    @OOXIXo
    private final Runnable executeAutoCloser;
    @OOXIXo
    private final Executor executor;
    @OOXIXo
    private final Handler handler = new Handler(Looper.getMainLooper());
    @GuardedBy("lock")
    private long lastDecrementRefCountTimeStamp;
    @OOXIXo
    private final Object lock = new Object();
    private boolean manuallyClosed;
    @oOoXoXO
    private Runnable onAutoCloseCallback;
    @GuardedBy("lock")
    private int refCount;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public AutoCloser(long j, @OOXIXo TimeUnit timeUnit, @OOXIXo Executor executor2) {
        IIX0o.x0xO0oo(timeUnit, "autoCloseTimeUnit");
        IIX0o.x0xO0oo(executor2, "autoCloseExecutor");
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j);
        this.executor = executor2;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.executeAutoCloser = new oIX0oI(this);
        this.autoCloser = new II0xO0(this);
    }

    /* access modifiers changed from: private */
    public static final void autoCloser$lambda$3(AutoCloser autoCloser2) {
        oXIO0o0XI oxio0o0xi;
        IIX0o.x0xO0oo(autoCloser2, "this$0");
        synchronized (autoCloser2.lock) {
            try {
                if (SystemClock.uptimeMillis() - autoCloser2.lastDecrementRefCountTimeStamp >= autoCloser2.autoCloseTimeoutInMs) {
                    if (autoCloser2.refCount == 0) {
                        Runnable runnable = autoCloser2.onAutoCloseCallback;
                        if (runnable != null) {
                            runnable.run();
                            oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                        } else {
                            oxio0o0xi = null;
                        }
                        if (oxio0o0xi != null) {
                            SupportSQLiteDatabase supportSQLiteDatabase = autoCloser2.delegateDatabase;
                            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                                supportSQLiteDatabase.close();
                            }
                            autoCloser2.delegateDatabase = null;
                            oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f19155oIX0oI;
                            return;
                        }
                        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void executeAutoCloser$lambda$0(AutoCloser autoCloser2) {
        IIX0o.x0xO0oo(autoCloser2, "this$0");
        autoCloser2.executor.execute(autoCloser2.autoCloser);
    }

    public final void closeDatabaseIfOpen() throws IOException {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        synchronized (this.lock) {
            try {
                int i = this.refCount;
                if (i > 0) {
                    int i2 = i - 1;
                    this.refCount = i2;
                    if (i2 == 0) {
                        if (this.delegateDatabase != null) {
                            this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);
                        } else {
                            return;
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                    return;
                }
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <V> V executeRefCountingFunction(@OOXIXo Oox.oOoXoXO<? super SupportSQLiteDatabase, ? extends V> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "block");
        try {
            return oooxoxo.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @oOoXoXO
    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    @OOXIXo
    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        IIX0o.XOxIOxOx("delegateOpenHelper");
        return null;
    }

    public final long getLastDecrementRefCountTimeStamp$room_runtime_release() {
        return this.lastDecrementRefCountTimeStamp;
    }

    @oOoXoXO
    public final Runnable getOnAutoCloseCallback$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final int getRefCount$room_runtime_release() {
        return this.refCount;
    }

    @VisibleForTesting
    public final int getRefCountForTest$room_runtime_release() {
        int i;
        synchronized (this.lock) {
            i = this.refCount;
        }
        return i;
    }

    @OOXIXo
    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.lock) {
            this.handler.removeCallbacks(this.executeAutoCloser);
            this.refCount++;
            if (!this.manuallyClosed) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return supportSQLiteDatabase;
                }
                SupportSQLiteDatabase writableDatabase = getDelegateOpenHelper().getWritableDatabase();
                this.delegateDatabase = writableDatabase;
                return writableDatabase;
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public final void init(@OOXIXo SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        IIX0o.x0xO0oo(supportSQLiteOpenHelper, "delegateOpenHelper");
        setDelegateOpenHelper(supportSQLiteOpenHelper);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "onAutoClose");
        this.onAutoCloseCallback = runnable;
    }

    public final void setDelegateDatabase$room_runtime_release(@oOoXoXO SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    public final void setDelegateOpenHelper(@OOXIXo SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        IIX0o.x0xO0oo(supportSQLiteOpenHelper, "<set-?>");
        this.delegateOpenHelper = supportSQLiteOpenHelper;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long j) {
        this.lastDecrementRefCountTimeStamp = j;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(@oOoXoXO Runnable runnable) {
        this.onAutoCloseCallback = runnable;
    }

    public final void setRefCount$room_runtime_release(int i) {
        this.refCount = i;
    }
}
