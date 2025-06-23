package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AIQuestion {

    @OOXIXo
    private Object extra;

    @OOXIXo
    private String model;
    private boolean stream;

    @OOXIXo
    private String text;

    @OOXIXo
    private AIFunctionType type;

    public AIQuestion(@OOXIXo AIFunctionType type, @OOXIXo String text, @OOXIXo Object extra, @OOXIXo String model, boolean z) {
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(extra, "extra");
        IIX0o.x0xO0oo(model, "model");
        this.type = type;
        this.text = text;
        this.extra = extra;
        this.model = model;
        this.stream = z;
    }

    public static /* synthetic */ AIQuestion copy$default(AIQuestion aIQuestion, AIFunctionType aIFunctionType, String str, Object obj, String str2, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            aIFunctionType = aIQuestion.type;
        }
        if ((i & 2) != 0) {
            str = aIQuestion.text;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            obj = aIQuestion.extra;
        }
        Object obj3 = obj;
        if ((i & 8) != 0) {
            str2 = aIQuestion.model;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            z = aIQuestion.stream;
        }
        return aIQuestion.copy(aIFunctionType, str3, obj3, str4, z);
    }

    @OOXIXo
    public final AIFunctionType component1() {
        return this.type;
    }

    @OOXIXo
    public final String component2() {
        return this.text;
    }

    @OOXIXo
    public final Object component3() {
        return this.extra;
    }

    @OOXIXo
    public final String component4() {
        return this.model;
    }

    public final boolean component5() {
        return this.stream;
    }

    @OOXIXo
    public final AIQuestion copy(@OOXIXo AIFunctionType type, @OOXIXo String text, @OOXIXo Object extra, @OOXIXo String model, boolean z) {
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(extra, "extra");
        IIX0o.x0xO0oo(model, "model");
        return new AIQuestion(type, text, extra, model, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIQuestion)) {
            return false;
        }
        AIQuestion aIQuestion = (AIQuestion) obj;
        return this.type == aIQuestion.type && IIX0o.Oxx0IOOO(this.text, aIQuestion.text) && IIX0o.Oxx0IOOO(this.extra, aIQuestion.extra) && IIX0o.Oxx0IOOO(this.model, aIQuestion.model) && this.stream == aIQuestion.stream;
    }

    @OOXIXo
    public final Object getExtra() {
        return this.extra;
    }

    @OOXIXo
    public final String getModel() {
        return this.model;
    }

    public final boolean getStream() {
        return this.stream;
    }

    @OOXIXo
    public final String getText() {
        return this.text;
    }

    @OOXIXo
    public final AIFunctionType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + this.text.hashCode()) * 31) + this.extra.hashCode()) * 31) + this.model.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.stream);
    }

    public final void setExtra(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<set-?>");
        this.extra = obj;
    }

    public final void setModel(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.model = str;
    }

    public final void setStream(boolean z) {
        this.stream = z;
    }

    public final void setText(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.text = str;
    }

    public final void setType(@OOXIXo AIFunctionType aIFunctionType) {
        IIX0o.x0xO0oo(aIFunctionType, "<set-?>");
        this.type = aIFunctionType;
    }

    @OOXIXo
    public String toString() {
        return "AIQuestion(type=" + this.type + ", text=" + this.text + ", extra=" + this.extra + ", model=" + this.model + ", stream=" + this.stream + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AIQuestion(AIFunctionType aIFunctionType, String str, Object obj, String str2, boolean z, int i, IIXOooo iIXOooo) {
        this(aIFunctionType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? new Object() : obj, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? false : z);
    }
}
