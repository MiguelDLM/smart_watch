package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMStatus {

    @OOXIXo
    private String message;
    private boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public BGEMStatus() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BGEMStatus copy$default(BGEMStatus bGEMStatus, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bGEMStatus.success;
        }
        if ((i & 2) != 0) {
            str = bGEMStatus.message;
        }
        return bGEMStatus.copy(z, str);
    }

    public final boolean component1() {
        return this.success;
    }

    @OOXIXo
    public final String component2() {
        return this.message;
    }

    @OOXIXo
    public final BGEMStatus copy(boolean z, @OOXIXo String message) {
        IIX0o.x0xO0oo(message, "message");
        return new BGEMStatus(z, message);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMStatus)) {
            return false;
        }
        BGEMStatus bGEMStatus = (BGEMStatus) obj;
        return this.success == bGEMStatus.success && IIX0o.Oxx0IOOO(this.message, bGEMStatus.message);
    }

    @OOXIXo
    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (androidx.work.oIX0oI.oIX0oI(this.success) * 31) + this.message.hashCode();
    }

    public final void setMessage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.message = str;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    @OOXIXo
    public String toString() {
        return "BGEMStatus(success=" + this.success + ", message=" + this.message + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BGEMStatus(boolean z, @OOXIXo String message) {
        IIX0o.x0xO0oo(message, "message");
        this.success = z;
        this.message = message;
    }

    public /* synthetic */ BGEMStatus(boolean z, String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }
}
