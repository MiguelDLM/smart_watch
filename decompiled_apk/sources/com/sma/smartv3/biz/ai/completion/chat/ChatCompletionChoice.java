package com.sma.smartv3.biz.ai.completion.chat;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ChatCompletionChoice extends JsonFieldContainer {

    @OOXIXo
    private ChatMessage delta;

    @OOXIXo
    private String finishReason;
    private int index;

    public ChatCompletionChoice() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ChatCompletionChoice copy$default(ChatCompletionChoice chatCompletionChoice, int i, ChatMessage chatMessage, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = chatCompletionChoice.index;
        }
        if ((i2 & 2) != 0) {
            chatMessage = chatCompletionChoice.delta;
        }
        if ((i2 & 4) != 0) {
            str = chatCompletionChoice.finishReason;
        }
        return chatCompletionChoice.copy(i, chatMessage, str);
    }

    public final int component1() {
        return this.index;
    }

    @OOXIXo
    public final ChatMessage component2() {
        return this.delta;
    }

    @OOXIXo
    public final String component3() {
        return this.finishReason;
    }

    @OOXIXo
    public final ChatCompletionChoice copy(int i, @OOXIXo ChatMessage delta, @OOXIXo String finishReason) {
        IIX0o.x0xO0oo(delta, "delta");
        IIX0o.x0xO0oo(finishReason, "finishReason");
        return new ChatCompletionChoice(i, delta, finishReason);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatCompletionChoice)) {
            return false;
        }
        ChatCompletionChoice chatCompletionChoice = (ChatCompletionChoice) obj;
        return this.index == chatCompletionChoice.index && IIX0o.Oxx0IOOO(this.delta, chatCompletionChoice.delta) && IIX0o.Oxx0IOOO(this.finishReason, chatCompletionChoice.finishReason);
    }

    @OOXIXo
    public final ChatMessage getDelta() {
        return this.delta;
    }

    @OOXIXo
    public final String getFinishReason() {
        return this.finishReason;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return (((this.index * 31) + this.delta.hashCode()) * 31) + this.finishReason.hashCode();
    }

    public final void setDelta(@OOXIXo ChatMessage chatMessage) {
        IIX0o.x0xO0oo(chatMessage, "<set-?>");
        this.delta = chatMessage;
    }

    public final void setFinishReason(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.finishReason = str;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    @OOXIXo
    public String toString() {
        return "ChatCompletionChoice(index=" + this.index + ", delta=" + this.delta + ", finishReason=" + this.finishReason + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ChatCompletionChoice(int i, ChatMessage chatMessage, String str, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ChatMessage(null, null, null, 7, null) : chatMessage, (i2 & 4) != 0 ? "" : str);
    }

    public ChatCompletionChoice(int i, @OOXIXo ChatMessage delta, @OOXIXo String finishReason) {
        IIX0o.x0xO0oo(delta, "delta");
        IIX0o.x0xO0oo(finishReason, "finishReason");
        this.index = i;
        this.delta = delta;
        this.finishReason = finishReason;
    }
}
