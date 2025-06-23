package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMPpg extends JsonFieldContainer {

    @OOXIXo
    private Integer[] ppg;

    @OOXIXo
    private String timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public BGEMPpg() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BGEMPpg copy$default(BGEMPpg bGEMPpg, Integer[] numArr, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            numArr = bGEMPpg.ppg;
        }
        if ((i & 2) != 0) {
            str = bGEMPpg.timestamp;
        }
        return bGEMPpg.copy(numArr, str);
    }

    @OOXIXo
    public final Integer[] component1() {
        return this.ppg;
    }

    @OOXIXo
    public final String component2() {
        return this.timestamp;
    }

    @OOXIXo
    public final BGEMPpg copy(@OOXIXo Integer[] ppg, @OOXIXo String timestamp) {
        IIX0o.x0xO0oo(ppg, "ppg");
        IIX0o.x0xO0oo(timestamp, "timestamp");
        return new BGEMPpg(ppg, timestamp);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMPpg)) {
            return false;
        }
        BGEMPpg bGEMPpg = (BGEMPpg) obj;
        return IIX0o.Oxx0IOOO(this.ppg, bGEMPpg.ppg) && IIX0o.Oxx0IOOO(this.timestamp, bGEMPpg.timestamp);
    }

    @OOXIXo
    public final Integer[] getPpg() {
        return this.ppg;
    }

    @OOXIXo
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.ppg) * 31) + this.timestamp.hashCode();
    }

    public final void setPpg(@OOXIXo Integer[] numArr) {
        IIX0o.x0xO0oo(numArr, "<set-?>");
        this.ppg = numArr;
    }

    public final void setTimestamp(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.timestamp = str;
    }

    @OOXIXo
    public String toString() {
        return "BGEMPpg(ppg=" + Arrays.toString(this.ppg) + ", timestamp=" + this.timestamp + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BGEMPpg(Integer[] numArr, String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new Integer[0] : numArr, (i & 2) != 0 ? "" : str);
    }

    public BGEMPpg(@OOXIXo Integer[] ppg, @OOXIXo String timestamp) {
        IIX0o.x0xO0oo(ppg, "ppg");
        IIX0o.x0xO0oo(timestamp, "timestamp");
        this.ppg = ppg;
        this.timestamp = timestamp;
    }
}
