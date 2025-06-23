package com.sma.smartv3.biz.ai.completion.chat;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ChatMessage extends JsonFieldContainer {

    @OOXIXo
    private String content;

    @OOXIXo
    private String name;

    @OOXIXo
    private String role;

    public ChatMessage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ChatMessage copy$default(ChatMessage chatMessage, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatMessage.role;
        }
        if ((i & 2) != 0) {
            str2 = chatMessage.content;
        }
        if ((i & 4) != 0) {
            str3 = chatMessage.name;
        }
        return chatMessage.copy(str, str2, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.role;
    }

    @OOXIXo
    public final String component2() {
        return this.content;
    }

    @OOXIXo
    public final String component3() {
        return this.name;
    }

    @OOXIXo
    public final ChatMessage copy(@OOXIXo String role, @OOXIXo String content, @OOXIXo String name) {
        IIX0o.x0xO0oo(role, "role");
        IIX0o.x0xO0oo(content, "content");
        IIX0o.x0xO0oo(name, "name");
        return new ChatMessage(role, content, name);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) obj;
        return IIX0o.Oxx0IOOO(this.role, chatMessage.role) && IIX0o.Oxx0IOOO(this.content, chatMessage.content) && IIX0o.Oxx0IOOO(this.name, chatMessage.name);
    }

    @OOXIXo
    public final String getContent() {
        return this.content;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return (((this.role.hashCode() * 31) + this.content.hashCode()) * 31) + this.name.hashCode();
    }

    public final void setContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.content = str;
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setRole(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.role = str;
    }

    @OOXIXo
    public String toString() {
        return "ChatMessage(role=" + this.role + ", content=" + this.content + ", name=" + this.name + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ChatMessage(String str, String str2, String str3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public ChatMessage(@OOXIXo String role, @OOXIXo String content, @OOXIXo String name) {
        IIX0o.x0xO0oo(role, "role");
        IIX0o.x0xO0oo(content, "content");
        IIX0o.x0xO0oo(name, "name");
        this.role = role;
        this.content = content;
        this.name = name;
    }
}
