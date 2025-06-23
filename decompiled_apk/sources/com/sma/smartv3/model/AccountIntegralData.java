package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AccountIntegralData extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private List<IntegralContentData> content;

    public AccountIntegralData(@OOXIXo List<IntegralContentData> content) {
        IIX0o.x0xO0oo(content, "content");
        this.content = content;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccountIntegralData copy$default(AccountIntegralData accountIntegralData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = accountIntegralData.content;
        }
        return accountIntegralData.copy(list);
    }

    @OOXIXo
    public final List<IntegralContentData> component1() {
        return this.content;
    }

    @OOXIXo
    public final AccountIntegralData copy(@OOXIXo List<IntegralContentData> content) {
        IIX0o.x0xO0oo(content, "content");
        return new AccountIntegralData(content);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountIntegralData) && IIX0o.Oxx0IOOO(this.content, ((AccountIntegralData) obj).content);
    }

    @OOXIXo
    public final List<IntegralContentData> getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public final void setContent(@OOXIXo List<IntegralContentData> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.content = list;
    }

    @OOXIXo
    public String toString() {
        return "AccountIntegralData(content=" + this.content + HexStringBuilder.COMMENT_END_CHAR;
    }
}
