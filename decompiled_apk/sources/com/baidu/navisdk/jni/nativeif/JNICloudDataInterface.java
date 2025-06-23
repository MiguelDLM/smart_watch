package com.baidu.navisdk.jni.nativeif;

import OXOo.OOXIXo;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class JNICloudDataInterface {
    private final ArrayList<CloudDataObserver> mObservers = new ArrayList<>();

    /* loaded from: classes7.dex */
    public static final class CloudDataDataId {
        public static final int BRULE = 3003;
        public static final int DYNA_UI = 3001;
        public static final int DYNA_UI_DATA = 3002;

        @OOXIXo
        public static final CloudDataDataId INSTANCE = new CloudDataDataId();
        public static final long Invalid = 0;
        public static final long YELLOW_TIPS = 1000;

        private CloudDataDataId() {
        }

        @kotlin.OOXIXo(message = "放在3001中")
        public static /* synthetic */ void getDYNA_UI_DATA$annotations() {
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class CloudDataObserver {
        private final long id;

        public CloudDataObserver(long j) {
            this.id = j;
        }

        public final long getId() {
            return this.id;
        }

        public abstract void update(int i, int i2, long j);
    }

    public JNICloudDataInterface(long j) {
    }

    private final native boolean addObserver(long j);

    private final native boolean deleteObserver(long j);

    public final void addObserver(@OOXIXo CloudDataObserver o) {
        IIX0o.x0xO0oo(o, "o");
        synchronized (this.mObservers) {
            if (this.mObservers.contains(o)) {
                return;
            }
            this.mObservers.add(o);
            addObserver(o.getId());
        }
    }

    public final void deleteObserver(@OOXIXo CloudDataObserver o) {
        IIX0o.x0xO0oo(o, "o");
        synchronized (this.mObservers) {
            int indexOf = this.mObservers.indexOf(o);
            if (indexOf == -1) {
                return;
            }
            this.mObservers.remove(indexOf);
            deleteObserver(o.getId());
        }
    }

    public final void dispatch(int i, int i2, long j) {
        synchronized (this.mObservers) {
            try {
                for (int size = this.mObservers.size() - 1; size >= 0 && this.mObservers.get(size) != null && this.mObservers.get(size).getId() == j; size--) {
                    this.mObservers.get(size).update(i, i2, j);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @OOXIXo
    public final byte[] getCloudDataPB(long j) {
        return getCloudDataPB(new long[]{j});
    }

    @OOXIXo
    public final native byte[] getCloudDataPB(@OOXIXo long[] jArr);

    @OOXIXo
    public final native String getCloudFilePath(int i);

    public final native void release();

    public final boolean updateCloudConfig(int i) {
        return updateCloudConfig(new int[]{i});
    }

    public final native boolean updateCloudConfig(@OOXIXo int[] iArr);
}
