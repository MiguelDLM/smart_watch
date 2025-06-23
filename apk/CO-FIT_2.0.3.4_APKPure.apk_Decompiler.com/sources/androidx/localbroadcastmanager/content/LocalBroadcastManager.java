package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.text.ooOOo0oXI;

@Deprecated
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap<>();

    public static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent intent2, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent2;
            this.receivers = arrayList;
        }
    }

    public static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append(ooOOo0oXI.f22054oOoXoXO);
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r4 = r2[r3];
        r5 = r4.receivers.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r6 >= r5) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r7 = r4.receivers.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r7.dead != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r7.receiver.onReceive(r10.mAppContext, r4.intent);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executePendingBroadcasts() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r0 = r10.mReceivers
            monitor-enter(r0)
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r1 = r10.mPendingBroadcasts     // Catch:{ all -> 0x000d }
            int r1 = r1.size()     // Catch:{ all -> 0x000d }
            if (r1 > 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r1 = move-exception
            goto L_0x0046
        L_0x000f:
            androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord[] r2 = new androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord[r1]     // Catch:{ all -> 0x000d }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x000d }
            r3.toArray(r2)     // Catch:{ all -> 0x000d }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x000d }
            r3.clear()     // Catch:{ all -> 0x000d }
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            r0 = 0
            r3 = 0
        L_0x001e:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord> r5 = r4.receivers
            int r5 = r5.size()
            r6 = 0
        L_0x0029:
            if (r6 >= r5) goto L_0x0043
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord> r7 = r4.receivers
            java.lang.Object r7 = r7.get(r6)
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r7 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r7
            boolean r8 = r7.dead
            if (r8 != 0) goto L_0x0040
            android.content.BroadcastReceiver r7 = r7.receiver
            android.content.Context r8 = r10.mAppContext
            android.content.Intent r9 = r4.intent
            r7.onReceive(r8, r9)
        L_0x0040:
            int r6 = r6 + 1
            goto L_0x0029
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.localbroadcastmanager.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
                ArrayList arrayList = this.mReceivers.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.mReceivers.put(broadcastReceiver, arrayList);
                }
                arrayList.add(receiverRecord);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = this.mActions.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.mActions.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0175, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0177, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(@androidx.annotation.NonNull android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r2 = r1.mReceivers
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x0057 }
            android.content.Context r3 = r1.mAppContext     // Catch:{ all -> 0x0057 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0057 }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0057 }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x0057 }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x0057 }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x0057 }
            int r3 = r22.getFlags()     // Catch:{ all -> 0x0057 }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002c
            r16 = 1
            goto L_0x002e
        L_0x002c:
            r16 = 0
        L_0x002e:
            if (r16 == 0) goto L_0x005a
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r4.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = "Resolving type "
            r4.append(r5)     // Catch:{ all -> 0x0057 }
            r4.append(r11)     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = " scheme "
            r4.append(r5)     // Catch:{ all -> 0x0057 }
            r4.append(r13)     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = " of intent "
            r4.append(r5)     // Catch:{ all -> 0x0057 }
            r4.append(r0)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            r0 = move-exception
            goto L_0x0179
        L_0x005a:
            java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r3 = r1.mActions     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x0057 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0057 }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x0057 }
            if (r8 == 0) goto L_0x0176
            if (r16 == 0) goto L_0x0081
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r4.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = "Action list: "
            r4.append(r5)     // Catch:{ all -> 0x0057 }
            r4.append(r8)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0057 }
        L_0x0081:
            r3 = 0
            r7 = r3
            r6 = 0
        L_0x0084:
            int r3 = r8.size()     // Catch:{ all -> 0x0057 }
            if (r6 >= r3) goto L_0x0146
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x0057 }
            r5 = r3
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r5 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r5     // Catch:{ all -> 0x0057 }
            if (r16 == 0) goto L_0x00ab
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r4.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r9 = "Matching against filter "
            r4.append(r9)     // Catch:{ all -> 0x0057 }
            android.content.IntentFilter r9 = r5.filter     // Catch:{ all -> 0x0057 }
            r4.append(r9)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0057 }
        L_0x00ab:
            boolean r3 = r5.broadcasting     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x00c4
            if (r16 == 0) goto L_0x00b8
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "  Filter's target already added"
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0057 }
        L_0x00b8:
            r17 = r6
            r19 = r8
            r18 = r10
            r20 = r11
            r11 = 1
            r10 = r7
            goto L_0x013b
        L_0x00c4:
            android.content.IntentFilter r3 = r5.filter     // Catch:{ all -> 0x0057 }
            java.lang.String r9 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r17 = r6
            r6 = r13
            r18 = r10
            r10 = r7
            r7 = r12
            r19 = r8
            r8 = r14
            r20 = r11
            r11 = 1
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0057 }
            if (r3 < 0) goto L_0x0109
            if (r16 == 0) goto L_0x00fa
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r5.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = "  Filter matched!  match=0x"
            r5.append(r6)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0057 }
            r5.append(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0057 }
        L_0x00fa:
            if (r10 != 0) goto L_0x0102
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            r7.<init>()     // Catch:{ all -> 0x0057 }
            goto L_0x0103
        L_0x0102:
            r7 = r10
        L_0x0103:
            r7.add(r15)     // Catch:{ all -> 0x0057 }
            r15.broadcasting = r11     // Catch:{ all -> 0x0057 }
            goto L_0x013c
        L_0x0109:
            if (r16 == 0) goto L_0x013b
            r4 = -4
            if (r3 == r4) goto L_0x0123
            r4 = -3
            if (r3 == r4) goto L_0x0120
            r4 = -2
            if (r3 == r4) goto L_0x011d
            r4 = -1
            if (r3 == r4) goto L_0x011a
            java.lang.String r3 = "unknown reason"
            goto L_0x0125
        L_0x011a:
            java.lang.String r3 = "type"
            goto L_0x0125
        L_0x011d:
            java.lang.String r3 = "data"
            goto L_0x0125
        L_0x0120:
            java.lang.String r3 = "action"
            goto L_0x0125
        L_0x0123:
            java.lang.String r3 = "category"
        L_0x0125:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r5.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = "  Filter did not match: "
            r5.append(r6)     // Catch:{ all -> 0x0057 }
            r5.append(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0057 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0057 }
        L_0x013b:
            r7 = r10
        L_0x013c:
            int r6 = r17 + 1
            r10 = r18
            r8 = r19
            r11 = r20
            goto L_0x0084
        L_0x0146:
            r10 = r7
            r11 = 1
            if (r10 == 0) goto L_0x0176
            r3 = 0
        L_0x014b:
            int r4 = r10.size()     // Catch:{ all -> 0x0057 }
            if (r3 >= r4) goto L_0x015d
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0057 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r4 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r4     // Catch:{ all -> 0x0057 }
            r5 = 0
            r4.broadcasting = r5     // Catch:{ all -> 0x0057 }
            int r3 = r3 + 1
            goto L_0x014b
        L_0x015d:
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r1.mPendingBroadcasts     // Catch:{ all -> 0x0057 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord r4 = new androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord     // Catch:{ all -> 0x0057 }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x0057 }
            r3.add(r4)     // Catch:{ all -> 0x0057 }
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x0057 }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0174
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x0057 }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x0057 }
        L_0x0174:
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            return r11
        L_0x0176:
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            r0 = 0
            return r0
        L_0x0179:
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.localbroadcastmanager.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(@NonNull Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            try {
                ArrayList remove = this.mReceivers.remove(broadcastReceiver);
                if (remove != null) {
                    for (int size = remove.size() - 1; size >= 0; size--) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) remove.get(size);
                        receiverRecord.dead = true;
                        for (int i = 0; i < receiverRecord.filter.countActions(); i++) {
                            String action = receiverRecord.filter.getAction(i);
                            ArrayList arrayList = this.mActions.get(action);
                            if (arrayList != null) {
                                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                    ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList.get(size2);
                                    if (receiverRecord2.receiver == broadcastReceiver) {
                                        receiverRecord2.dead = true;
                                        arrayList.remove(size2);
                                    }
                                }
                                if (arrayList.size() <= 0) {
                                    this.mActions.remove(action);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
