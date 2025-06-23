package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AccountOrderData extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private List<OrderContentData> content;

    public AccountOrderData(@OOXIXo List<OrderContentData> content) {
        IIX0o.x0xO0oo(content, "content");
        this.content = content;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccountOrderData copy$default(AccountOrderData accountOrderData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = accountOrderData.content;
        }
        return accountOrderData.copy(list);
    }

    @OOXIXo
    public final List<OrderContentData> component1() {
        return this.content;
    }

    @OOXIXo
    public final AccountOrderData copy(@OOXIXo List<OrderContentData> content) {
        IIX0o.x0xO0oo(content, "content");
        return new AccountOrderData(content);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountOrderData) && IIX0o.Oxx0IOOO(this.content, ((AccountOrderData) obj).content);
    }

    @OOXIXo
    public final List<OrderContentData> getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public final void setContent(@OOXIXo List<OrderContentData> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.content = list;
    }

    @OOXIXo
    public String toString() {
        return "AccountOrderData(content=" + this.content + HexStringBuilder.COMMENT_END_CHAR;
    }
}
