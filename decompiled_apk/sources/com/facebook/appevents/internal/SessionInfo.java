package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class SessionInfo {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";

    @OOXIXo
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";

    @OOXIXo
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";

    @OOXIXo
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";

    @oOoXoXO
    private Long diskRestoreTime;
    private int interruptionCount;

    @OOXIXo
    private UUID sessionId;

    @oOoXoXO
    private Long sessionLastEventTime;

    @oOoXoXO
    private final Long sessionStartTime;

    @oOoXoXO
    private SourceApplicationInfo sourceApplicationInfo;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public final void clearSavedSessionFromDisk() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.remove(SessionInfo.LAST_SESSION_INFO_START_KEY);
            edit.remove(SessionInfo.LAST_SESSION_INFO_END_KEY);
            edit.remove(SessionInfo.INTERRUPTION_COUNT_KEY);
            edit.remove(SessionInfo.SESSION_ID_KEY);
            edit.apply();
            SourceApplicationInfo.Companion.clearSavedSourceApplicationInfoFromDisk();
        }

        @x0XOIxOo
        @oOoXoXO
        public final SessionInfo getStoredSessionInfo() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            long j = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_START_KEY, 0L);
            long j2 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_END_KEY, 0L);
            String string = defaultSharedPreferences.getString(SessionInfo.SESSION_ID_KEY, null);
            if (j == 0 || j2 == 0 || string == null) {
                return null;
            }
            SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j), Long.valueOf(j2), null, 4, null);
            sessionInfo.interruptionCount = defaultSharedPreferences.getInt(SessionInfo.INTERRUPTION_COUNT_KEY, 0);
            sessionInfo.setSourceApplicationInfo(SourceApplicationInfo.Companion.getStoredSourceApplicatioInfo());
            sessionInfo.setDiskRestoreTime(Long.valueOf(System.currentTimeMillis()));
            UUID fromString = UUID.fromString(string);
            IIX0o.oO(fromString, "fromString(sessionIDStr)");
            sessionInfo.setSessionId(fromString);
            return sessionInfo;
        }

        private Companion() {
        }
    }

    @xoIox
    public SessionInfo(@oOoXoXO Long l, @oOoXoXO Long l2) {
        this(l, l2, null, 4, null);
    }

    @x0XOIxOo
    public static final void clearSavedSessionFromDisk() {
        Companion.clearSavedSessionFromDisk();
    }

    @x0XOIxOo
    @oOoXoXO
    public static final SessionInfo getStoredSessionInfo() {
        return Companion.getStoredSessionInfo();
    }

    @oOoXoXO
    public final Long getDiskRestoreTime() {
        Long l = this.diskRestoreTime;
        if (l == null) {
            return 0L;
        }
        return l;
    }

    public final int getInterruptionCount() {
        return this.interruptionCount;
    }

    @OOXIXo
    public final UUID getSessionId() {
        return this.sessionId;
    }

    @oOoXoXO
    public final Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public final long getSessionLength() {
        Long l;
        if (this.sessionStartTime != null && (l = this.sessionLastEventTime) != null) {
            if (l != null) {
                return l.longValue() - this.sessionStartTime.longValue();
            }
            throw new IllegalStateException("Required value was null.");
        }
        return 0L;
    }

    @oOoXoXO
    public final Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    @oOoXoXO
    public final SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public final void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public final void setDiskRestoreTime(@oOoXoXO Long l) {
        this.diskRestoreTime = l;
    }

    public final void setSessionId(@OOXIXo UUID uuid) {
        IIX0o.x0xO0oo(uuid, "<set-?>");
        this.sessionId = uuid;
    }

    public final void setSessionLastEventTime(@oOoXoXO Long l) {
        this.sessionLastEventTime = l;
    }

    public final void setSourceApplicationInfo(@oOoXoXO SourceApplicationInfo sourceApplicationInfo) {
        this.sourceApplicationInfo = sourceApplicationInfo;
    }

    public final void writeSessionToDisk() {
        long longValue;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        Long l = this.sessionStartTime;
        long j = 0;
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        edit.putLong(LAST_SESSION_INFO_START_KEY, longValue);
        Long l2 = this.sessionLastEventTime;
        if (l2 != null) {
            j = l2.longValue();
        }
        edit.putLong(LAST_SESSION_INFO_END_KEY, j);
        edit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        edit.putString(SESSION_ID_KEY, this.sessionId.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.sourceApplicationInfo;
        if (sourceApplicationInfo != null && sourceApplicationInfo != null) {
            sourceApplicationInfo.writeSourceApplicationInfoToDisk();
        }
    }

    @xoIox
    public SessionInfo(@oOoXoXO Long l, @oOoXoXO Long l2, @OOXIXo UUID sessionId) {
        IIX0o.x0xO0oo(sessionId, "sessionId");
        this.sessionStartTime = l;
        this.sessionLastEventTime = l2;
        this.sessionId = sessionId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SessionInfo(java.lang.Long r1, java.lang.Long r2, java.util.UUID r3, int r4, kotlin.jvm.internal.IIXOooo r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto Ld
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r4 = "randomUUID()"
            kotlin.jvm.internal.IIX0o.oO(r3, r4)
        Ld:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.SessionInfo.<init>(java.lang.Long, java.lang.Long, java.util.UUID, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
