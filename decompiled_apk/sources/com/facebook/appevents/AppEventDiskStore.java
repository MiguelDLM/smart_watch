package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class AppEventDiskStore {

    @OXOo.OOXIXo
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();

    @OXOo.OOXIXo
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";

    @OXOo.OOXIXo
    private static final String TAG;

    /* loaded from: classes8.dex */
    public static final class MovedClassObjectInputStream extends ObjectInputStream {

        @OXOo.OOXIXo
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";

        @OXOo.OOXIXo
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public MovedClassObjectInputStream(@OXOo.oOoXoXO InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        @OXOo.OOXIXo
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (IIX0o.Oxx0IOOO(resultClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (IIX0o.Oxx0IOOO(resultClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            IIX0o.oO(resultClassDescriptor, "resultClassDescriptor");
            return resultClassDescriptor;
        }
    }

    static {
        String name = AppEventDiskStore.class.getName();
        IIX0o.oO(name, "AppEventDiskStore::class.java.name");
        TAG = name;
    }

    private AppEventDiskStore() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0003, B:12:0x002c, B:14:0x0031, B:17:0x00ac, B:23:0x003f, B:44:0x007d, B:46:0x0082, B:47:0x0094, B:50:0x008d, B:36:0x0065, B:38:0x006a, B:41:0x0075, B:33:0x0079, B:27:0x0095, B:29:0x009a, B:32:0x00a5), top: B:3:0x0003, inners: #0, #1, #8, #9 }] */
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventDiskStore> r0 = com.facebook.appevents.AppEventDiskStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch: java.lang.Throwable -> L3b
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch: java.lang.Throwable -> L3b
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch: java.lang.Throwable -> L3b
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.io.FileNotFoundException -> L5c
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.IIX0o.oO(r3, r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.io.FileNotFoundException -> L5c
            com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.io.FileNotFoundException -> L5c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.io.FileNotFoundException -> L5c
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.io.FileNotFoundException -> L5c
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.io.FileNotFoundException -> L5c
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b java.io.FileNotFoundException -> L95
            if (r3 == 0) goto L4d
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b java.io.FileNotFoundException -> L95
            com.facebook.internal.Utility r2 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> L3b
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            goto L46
        L3b:
            r1 = move-exception
            goto Lb3
        L3e:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> L3b
        L46:
            r2 = r3
            goto Laa
        L49:
            r2 = move-exception
            goto L7d
        L4b:
            r3 = move-exception
            goto L5e
        L4d:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b java.io.FileNotFoundException -> L95
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b java.io.FileNotFoundException -> L95
            throw r3     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b java.io.FileNotFoundException -> L95
        L55:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L7d
        L59:
            r3 = move-exception
            r4 = r2
            goto L5e
        L5c:
            r4 = r2
            goto L95
        L5e:
            java.lang.String r5 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L49
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L49
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> L3b
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L74
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L74
            goto Laa
        L74:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L79:
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b
            goto Laa
        L7d:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> L3b
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L8c
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L8c
            goto L94
        L8c:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b
        L94:
            throw r2     // Catch: java.lang.Throwable -> L3b
        L95:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch: java.lang.Throwable -> L3b
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> La4
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> La4
            goto Laa
        La4:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L79
        Laa:
            if (r2 != 0) goto Lb1
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> L3b
            r2.<init>()     // Catch: java.lang.Throwable -> L3b
        Lb1:
            monitor-exit(r0)
            return r2
        Lb3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    @XO0OX.x0XOIxOo
    public static final void saveEventsToDisk$facebook_core_release(@OXOo.oOoXoXO PersistedEvents persistedEvents) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream2.writeObject(persistedEvents);
                Utility utility = Utility.INSTANCE;
                Utility.closeQuietly(objectOutputStream2);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.closeQuietly(objectOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
