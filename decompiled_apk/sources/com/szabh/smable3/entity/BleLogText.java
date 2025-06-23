package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLogText extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 64;

    @OOXIXo
    private String mContent;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleLogText() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleLogText copy$default(BleLogText bleLogText, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleLogText.mContent;
        }
        return bleLogText.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mContent;
    }

    @OOXIXo
    public final BleLogText copy(@OOXIXo String mContent) {
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleLogText(mContent);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        boolean z;
        String str;
        super.decode();
        if (getMBytes() != null) {
            byte[] mBytes = getMBytes();
            IIX0o.ooOOo0oXI(mBytes);
            if (mBytes.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                byte[] mBytes2 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes2);
                int O00Ix = ArraysKt___ArraysKt.O00Ix(mBytes2, (byte) 0);
                if (O00Ix == -1) {
                    byte[] mBytes3 = getMBytes();
                    IIX0o.ooOOo0oXI(mBytes3);
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    IIX0o.oO(UTF_8, "UTF_8");
                    str = new String(mBytes3, UTF_8);
                } else {
                    byte[] mBytes4 = getMBytes();
                    IIX0o.ooOOo0oXI(mBytes4);
                    Charset UTF_82 = StandardCharsets.UTF_8;
                    IIX0o.oO(UTF_82, "UTF_8");
                    str = new String(mBytes4, 0, O00Ix, UTF_82);
                }
                this.mContent = str;
            }
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleLogText) && IIX0o.Oxx0IOOO(this.mContent, ((BleLogText) obj).mContent);
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
        return "BleLogText(mContent=" + this.mContent + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLogText(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }

    public BleLogText(@OOXIXo String mContent) {
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mContent = mContent;
    }
}
