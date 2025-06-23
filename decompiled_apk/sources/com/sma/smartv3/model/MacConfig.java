package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class MacConfig extends JsonFieldContainer {

    @OOXIXo
    private String aiModelService;

    @OOXIXo
    private String mac;

    @OOXIXo
    private String supDirectAI;

    public MacConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MacConfig copy$default(MacConfig macConfig, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = macConfig.mac;
        }
        if ((i & 2) != 0) {
            str2 = macConfig.supDirectAI;
        }
        if ((i & 4) != 0) {
            str3 = macConfig.aiModelService;
        }
        return macConfig.copy(str, str2, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.mac;
    }

    @OOXIXo
    public final String component2() {
        return this.supDirectAI;
    }

    @OOXIXo
    public final String component3() {
        return this.aiModelService;
    }

    @OOXIXo
    public final MacConfig copy(@OOXIXo String mac, @OOXIXo String supDirectAI, @OOXIXo String aiModelService) {
        IIX0o.x0xO0oo(mac, "mac");
        IIX0o.x0xO0oo(supDirectAI, "supDirectAI");
        IIX0o.x0xO0oo(aiModelService, "aiModelService");
        return new MacConfig(mac, supDirectAI, aiModelService);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MacConfig)) {
            return false;
        }
        MacConfig macConfig = (MacConfig) obj;
        return IIX0o.Oxx0IOOO(this.mac, macConfig.mac) && IIX0o.Oxx0IOOO(this.supDirectAI, macConfig.supDirectAI) && IIX0o.Oxx0IOOO(this.aiModelService, macConfig.aiModelService);
    }

    @OOXIXo
    public final String getAiModelService() {
        return this.aiModelService;
    }

    @OOXIXo
    public final String getMac() {
        return this.mac;
    }

    @OOXIXo
    public final String getSupDirectAI() {
        return this.supDirectAI;
    }

    public int hashCode() {
        return (((this.mac.hashCode() * 31) + this.supDirectAI.hashCode()) * 31) + this.aiModelService.hashCode();
    }

    public final void setAiModelService(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.aiModelService = str;
    }

    public final void setMac(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mac = str;
    }

    public final void setSupDirectAI(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supDirectAI = str;
    }

    @OOXIXo
    public String toString() {
        return "MacConfig(mac=" + this.mac + ", supDirectAI=" + this.supDirectAI + ", aiModelService=" + this.aiModelService + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ MacConfig(String str, String str2, String str3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public MacConfig(@OOXIXo String mac, @OOXIXo String supDirectAI, @OOXIXo String aiModelService) {
        IIX0o.x0xO0oo(mac, "mac");
        IIX0o.x0xO0oo(supDirectAI, "supDirectAI");
        IIX0o.x0xO0oo(aiModelService, "aiModelService");
        this.mac = mac;
        this.supDirectAI = supDirectAI;
        this.aiModelService = aiModelService;
    }
}
