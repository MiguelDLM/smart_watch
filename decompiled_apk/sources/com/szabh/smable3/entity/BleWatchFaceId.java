package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleWatchFaceId extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long WATCHFACE_ID_INVALID = 4294967295L;

    @OOXIXo
    private List<Integer> mIdList;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleWatchFaceId() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleWatchFaceId copy$default(BleWatchFaceId bleWatchFaceId, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bleWatchFaceId.mIdList;
        }
        return bleWatchFaceId.copy(list);
    }

    @OOXIXo
    public final List<Integer> component1() {
        return this.mIdList;
    }

    @OOXIXo
    public final BleWatchFaceId copy(@OOXIXo List<Integer> mIdList) {
        IIX0o.x0xO0oo(mIdList, "mIdList");
        return new BleWatchFaceId(mIdList);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        int length;
        super.decode();
        byte[] mBytes = getMBytes();
        if (mBytes != null && (length = mBytes.length / 4) != 0) {
            for (int i = 0; i < length; i++) {
                this.mIdList.add(Integer.valueOf(BleReadable.readInt32$default(this, null, 1, null)));
            }
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleWatchFaceId) && IIX0o.Oxx0IOOO(this.mIdList, ((BleWatchFaceId) obj).mIdList);
    }

    @OOXIXo
    public final List<Integer> getMIdList() {
        return this.mIdList;
    }

    public int hashCode() {
        return this.mIdList.hashCode();
    }

    public final void setMIdList(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mIdList = list;
    }

    @OOXIXo
    public String toString() {
        return "BleWatchFaceId(mIdList=" + this.mIdList + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleWatchFaceId(List list, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public BleWatchFaceId(@OOXIXo List<Integer> mIdList) {
        IIX0o.x0xO0oo(mIdList, "mIdList");
        this.mIdList = mIdList;
    }
}
