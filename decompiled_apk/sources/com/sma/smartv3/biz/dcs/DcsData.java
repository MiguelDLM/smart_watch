package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DcsData extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final List<DcsStruct> dcs;

    @OOXIXo
    private final DcsTts tts;

    public DcsData(@OOXIXo List<DcsStruct> dcs, @OOXIXo DcsTts tts) {
        IIX0o.x0xO0oo(dcs, "dcs");
        IIX0o.x0xO0oo(tts, "tts");
        this.dcs = dcs;
        this.tts = tts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DcsData copy$default(DcsData dcsData, List list, DcsTts dcsTts, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dcsData.dcs;
        }
        if ((i & 2) != 0) {
            dcsTts = dcsData.tts;
        }
        return dcsData.copy(list, dcsTts);
    }

    @OOXIXo
    public final List<DcsStruct> component1() {
        return this.dcs;
    }

    @OOXIXo
    public final DcsTts component2() {
        return this.tts;
    }

    @OOXIXo
    public final DcsData copy(@OOXIXo List<DcsStruct> dcs, @OOXIXo DcsTts tts) {
        IIX0o.x0xO0oo(dcs, "dcs");
        IIX0o.x0xO0oo(tts, "tts");
        return new DcsData(dcs, tts);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DcsData)) {
            return false;
        }
        DcsData dcsData = (DcsData) obj;
        return IIX0o.Oxx0IOOO(this.dcs, dcsData.dcs) && IIX0o.Oxx0IOOO(this.tts, dcsData.tts);
    }

    @OOXIXo
    public final List<DcsStruct> getDcs() {
        return this.dcs;
    }

    @OOXIXo
    public final DcsTts getTts() {
        return this.tts;
    }

    public int hashCode() {
        return (this.dcs.hashCode() * 31) + this.tts.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "DcsData(dcs=" + this.dcs + ", tts=" + this.tts + HexStringBuilder.COMMENT_END_CHAR;
    }
}
