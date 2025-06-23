package com.sma.smartv3.biz.ai.completion.chat;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ChatCompletionResult extends JsonFieldContainer {

    @OOXIXo
    private List<ChatCompletionChoice> choices;
    private long created;

    @OOXIXo
    private String id;

    @OOXIXo
    private String model;

    @OOXIXo
    private String object;

    public ChatCompletionResult() {
        this(null, null, 0L, null, null, 31, null);
    }

    public static /* synthetic */ ChatCompletionResult copy$default(ChatCompletionResult chatCompletionResult, String str, String str2, long j, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatCompletionResult.id;
        }
        if ((i & 2) != 0) {
            str2 = chatCompletionResult.object;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = chatCompletionResult.created;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = chatCompletionResult.model;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            list = chatCompletionResult.choices;
        }
        return chatCompletionResult.copy(str, str4, j2, str5, list);
    }

    @OOXIXo
    public final String component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.object;
    }

    public final long component3() {
        return this.created;
    }

    @OOXIXo
    public final String component4() {
        return this.model;
    }

    @OOXIXo
    public final List<ChatCompletionChoice> component5() {
        return this.choices;
    }

    @OOXIXo
    public final ChatCompletionResult copy(@OOXIXo String id, @OOXIXo String object, long j, @OOXIXo String model, @OOXIXo List<ChatCompletionChoice> choices) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(object, "object");
        IIX0o.x0xO0oo(model, "model");
        IIX0o.x0xO0oo(choices, "choices");
        return new ChatCompletionResult(id, object, j, model, choices);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatCompletionResult)) {
            return false;
        }
        ChatCompletionResult chatCompletionResult = (ChatCompletionResult) obj;
        return IIX0o.Oxx0IOOO(this.id, chatCompletionResult.id) && IIX0o.Oxx0IOOO(this.object, chatCompletionResult.object) && this.created == chatCompletionResult.created && IIX0o.Oxx0IOOO(this.model, chatCompletionResult.model) && IIX0o.Oxx0IOOO(this.choices, chatCompletionResult.choices);
    }

    @OOXIXo
    public final List<ChatCompletionChoice> getChoices() {
        return this.choices;
    }

    public final long getCreated() {
        return this.created;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final String getModel() {
        return this.model;
    }

    @OOXIXo
    public final String getObject() {
        return this.object;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.object.hashCode()) * 31) + oIX0oI.oIX0oI(this.created)) * 31) + this.model.hashCode()) * 31) + this.choices.hashCode();
    }

    public final void setChoices(@OOXIXo List<ChatCompletionChoice> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.choices = list;
    }

    public final void setCreated(long j) {
        this.created = j;
    }

    public final void setId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.id = str;
    }

    public final void setModel(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.model = str;
    }

    public final void setObject(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.object = str;
    }

    @OOXIXo
    public String toString() {
        return "ChatCompletionResult(id=" + this.id + ", object=" + this.object + ", created=" + this.created + ", model=" + this.model + ", choices=" + this.choices + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ChatCompletionResult(String str, String str2, long j, String str3, List list, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j, (i & 8) == 0 ? str3 : "", (i & 16) != 0 ? new ArrayList() : list);
    }

    public ChatCompletionResult(@OOXIXo String id, @OOXIXo String object, long j, @OOXIXo String model, @OOXIXo List<ChatCompletionChoice> choices) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(object, "object");
        IIX0o.x0xO0oo(model, "model");
        IIX0o.x0xO0oo(choices, "choices");
        this.id = id;
        this.object = object;
        this.created = j;
        this.model = model;
        this.choices = choices;
    }
}
