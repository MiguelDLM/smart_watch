package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AIAnswer {
    private int ended;

    @OOXIXo
    private Object extra;

    @OOXIXo
    private String model;

    @OOXIXo
    private String text;

    @OOXIXo
    private AIFunctionType type;

    public AIAnswer(@OOXIXo AIFunctionType type, @OOXIXo String text, int i, @OOXIXo String model, @OOXIXo Object extra) {
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(model, "model");
        IIX0o.x0xO0oo(extra, "extra");
        this.type = type;
        this.text = text;
        this.ended = i;
        this.model = model;
        this.extra = extra;
    }

    public static /* synthetic */ AIAnswer copy$default(AIAnswer aIAnswer, AIFunctionType aIFunctionType, String str, int i, String str2, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            aIFunctionType = aIAnswer.type;
        }
        if ((i2 & 2) != 0) {
            str = aIAnswer.text;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            i = aIAnswer.ended;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = aIAnswer.model;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            obj = aIAnswer.extra;
        }
        return aIAnswer.copy(aIFunctionType, str3, i3, str4, obj);
    }

    @OOXIXo
    public final AIFunctionType component1() {
        return this.type;
    }

    @OOXIXo
    public final String component2() {
        return this.text;
    }

    public final int component3() {
        return this.ended;
    }

    @OOXIXo
    public final String component4() {
        return this.model;
    }

    @OOXIXo
    public final Object component5() {
        return this.extra;
    }

    @OOXIXo
    public final AIAnswer copy(@OOXIXo AIFunctionType type, @OOXIXo String text, int i, @OOXIXo String model, @OOXIXo Object extra) {
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(model, "model");
        IIX0o.x0xO0oo(extra, "extra");
        return new AIAnswer(type, text, i, model, extra);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIAnswer)) {
            return false;
        }
        AIAnswer aIAnswer = (AIAnswer) obj;
        return this.type == aIAnswer.type && IIX0o.Oxx0IOOO(this.text, aIAnswer.text) && this.ended == aIAnswer.ended && IIX0o.Oxx0IOOO(this.model, aIAnswer.model) && IIX0o.Oxx0IOOO(this.extra, aIAnswer.extra);
    }

    public final int getEnded() {
        return this.ended;
    }

    @OOXIXo
    public final Object getExtra() {
        return this.extra;
    }

    @OOXIXo
    public final String getModel() {
        return this.model;
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
        return (((((((this.type.hashCode() * 31) + this.text.hashCode()) * 31) + this.ended) * 31) + this.model.hashCode()) * 31) + this.extra.hashCode();
    }

    public final void setEnded(int i) {
        this.ended = i;
    }

    public final void setExtra(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<set-?>");
        this.extra = obj;
    }

    public final void setModel(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.model = str;
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
        return "AIAnswer(type=" + this.type + ", text=" + this.text + ", ended=" + this.ended + ", model=" + this.model + ", extra=" + this.extra + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AIAnswer(AIFunctionType aIFunctionType, String str, int i, String str2, Object obj, int i2, IIXOooo iIXOooo) {
        this(aIFunctionType, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? new Object() : obj);
    }
}
