package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleRealtimeLog extends BleReadable {

    @OOXIXo
    private String mContent;

    /* JADX WARN: Multi-variable type inference failed */
    public BleRealtimeLog() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleRealtimeLog copy$default(BleRealtimeLog bleRealtimeLog, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleRealtimeLog.mContent;
        }
        return bleRealtimeLog.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mContent;
    }

    @OOXIXo
    public final BleRealtimeLog copy(@OOXIXo String mContent) {
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleRealtimeLog(mContent);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        String str;
        super.decode();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS    ", Locale.getDefault());
        if (getMBytes() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(simpleDateFormat.format(new Date()));
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            Charset UTF_8 = StandardCharsets.UTF_8;
            IIX0o.oO(UTF_8, "UTF_8");
            sb.append(new String(mBytes, UTF_8));
            str = sb.toString();
        } else {
            str = simpleDateFormat.format(new Date()) + "null";
        }
        this.mContent = str;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleRealtimeLog) && IIX0o.Oxx0IOOO(this.mContent, ((BleRealtimeLog) obj).mContent);
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    public int hashCode() {
        return this.mContent.hashCode();
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    @OOXIXo
    public String toString() {
        return "BleRealtimeLog(mContent=" + this.mContent + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BleRealtimeLog(@OOXIXo String mContent) {
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mContent = mContent;
    }

    public /* synthetic */ BleRealtimeLog(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }
}
