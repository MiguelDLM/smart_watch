package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class AnalyticsUserIDStore {

    @OXOo.OOXIXo
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";

    @OXOo.OOXIXo
    public static final AnalyticsUserIDStore INSTANCE = new AnalyticsUserIDStore();

    @OXOo.OOXIXo
    private static final String TAG;
    private static volatile boolean initialized;

    @OXOo.OOXIXo
    private static final ReentrantReadWriteLock lock;

    @OXOo.oOoXoXO
    private static String userID;

    static {
        String simpleName = AnalyticsUserIDStore.class.getSimpleName();
        IIX0o.oO(simpleName, "AnalyticsUserIDStore::class.java.simpleName");
        TAG = simpleName;
        lock = new ReentrantReadWriteLock();
    }

    private AnalyticsUserIDStore() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getUserID() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            INSTANCE.initAndWait();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.readLock().lock();
        try {
            String str = userID;
            reentrantReadWriteLock.readLock().unlock();
            return str;
        } catch (Throwable th) {
            lock.readLock().unlock();
            throw th;
        }
    }

    private final void initAndWait() {
        if (initialized) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (initialized) {
                reentrantReadWriteLock.writeLock().unlock();
                return;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, null);
            initialized = true;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            lock.writeLock().unlock();
            throw th;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void initStore() {
        if (initialized) {
            return;
        }
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsUserIDStore.m126initStore$lambda0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initStore$lambda-0, reason: not valid java name */
    public static final void m126initStore$lambda0() {
        INSTANCE.initAndWait();
    }

    @XO0OX.x0XOIxOo
    public static final void setUserID(@OXOo.oOoXoXO final String str) {
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            INSTANCE.initAndWait();
        }
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable() { // from class: com.facebook.appevents.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsUserIDStore.m127setUserID$lambda1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUserID$lambda-1, reason: not valid java name */
    public static final void m127setUserID$lambda1(String str) {
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            userID = str;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.putString(ANALYTICS_USER_ID_KEY, userID);
            edit.apply();
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            lock.writeLock().unlock();
            throw th;
        }
    }
}
