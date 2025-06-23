package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AIFunction implements Serializable {
    private int bg;

    @OOXIXo
    private String desc;
    private int detailsBg;

    @OOXIXo
    private String detailsDescribe;

    @OOXIXo
    private String detailsExample;

    @OOXIXo
    private String detailsHint;

    @OOXIXo
    private String detailsQuestion;
    private int icon;

    @oOoXoXO
    private transient Intent intent;
    private boolean isHot;

    @OOXIXo
    private String title;

    @OOXIXo
    private AIFunctionType type;

    public AIFunction(@OOXIXo AIFunctionType type, @OOXIXo String title, int i, @OOXIXo String desc, int i2, int i3, @OOXIXo String detailsDescribe, @OOXIXo String detailsHint, @OOXIXo String detailsExample, @OOXIXo String detailsQuestion, boolean z, @oOoXoXO Intent intent) {
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(desc, "desc");
        IIX0o.x0xO0oo(detailsDescribe, "detailsDescribe");
        IIX0o.x0xO0oo(detailsHint, "detailsHint");
        IIX0o.x0xO0oo(detailsExample, "detailsExample");
        IIX0o.x0xO0oo(detailsQuestion, "detailsQuestion");
        this.type = type;
        this.title = title;
        this.bg = i;
        this.desc = desc;
        this.icon = i2;
        this.detailsBg = i3;
        this.detailsDescribe = detailsDescribe;
        this.detailsHint = detailsHint;
        this.detailsExample = detailsExample;
        this.detailsQuestion = detailsQuestion;
        this.isHot = z;
        this.intent = intent;
    }

    @OOXIXo
    public final AIFunctionType component1() {
        return this.type;
    }

    @OOXIXo
    public final String component10() {
        return this.detailsQuestion;
    }

    public final boolean component11() {
        return this.isHot;
    }

    @oOoXoXO
    public final Intent component12() {
        return this.intent;
    }

    @OOXIXo
    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.bg;
    }

    @OOXIXo
    public final String component4() {
        return this.desc;
    }

    public final int component5() {
        return this.icon;
    }

    public final int component6() {
        return this.detailsBg;
    }

    @OOXIXo
    public final String component7() {
        return this.detailsDescribe;
    }

    @OOXIXo
    public final String component8() {
        return this.detailsHint;
    }

    @OOXIXo
    public final String component9() {
        return this.detailsExample;
    }

    @OOXIXo
    public final AIFunction copy(@OOXIXo AIFunctionType type, @OOXIXo String title, int i, @OOXIXo String desc, int i2, int i3, @OOXIXo String detailsDescribe, @OOXIXo String detailsHint, @OOXIXo String detailsExample, @OOXIXo String detailsQuestion, boolean z, @oOoXoXO Intent intent) {
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(desc, "desc");
        IIX0o.x0xO0oo(detailsDescribe, "detailsDescribe");
        IIX0o.x0xO0oo(detailsHint, "detailsHint");
        IIX0o.x0xO0oo(detailsExample, "detailsExample");
        IIX0o.x0xO0oo(detailsQuestion, "detailsQuestion");
        return new AIFunction(type, title, i, desc, i2, i3, detailsDescribe, detailsHint, detailsExample, detailsQuestion, z, intent);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIFunction)) {
            return false;
        }
        AIFunction aIFunction = (AIFunction) obj;
        return this.type == aIFunction.type && IIX0o.Oxx0IOOO(this.title, aIFunction.title) && this.bg == aIFunction.bg && IIX0o.Oxx0IOOO(this.desc, aIFunction.desc) && this.icon == aIFunction.icon && this.detailsBg == aIFunction.detailsBg && IIX0o.Oxx0IOOO(this.detailsDescribe, aIFunction.detailsDescribe) && IIX0o.Oxx0IOOO(this.detailsHint, aIFunction.detailsHint) && IIX0o.Oxx0IOOO(this.detailsExample, aIFunction.detailsExample) && IIX0o.Oxx0IOOO(this.detailsQuestion, aIFunction.detailsQuestion) && this.isHot == aIFunction.isHot && IIX0o.Oxx0IOOO(this.intent, aIFunction.intent);
    }

    public final int getBg() {
        return this.bg;
    }

    @OOXIXo
    public final String getDesc() {
        return this.desc;
    }

    public final int getDetailsBg() {
        return this.detailsBg;
    }

    @OOXIXo
    public final String getDetailsDescribe() {
        return this.detailsDescribe;
    }

    @OOXIXo
    public final String getDetailsExample() {
        return this.detailsExample;
    }

    @OOXIXo
    public final String getDetailsHint() {
        return this.detailsHint;
    }

    @OOXIXo
    public final String getDetailsQuestion() {
        return this.detailsQuestion;
    }

    public final int getIcon() {
        return this.icon;
    }

    @oOoXoXO
    public final Intent getIntent() {
        return this.intent;
    }

    @OOXIXo
    public final String getTitle() {
        return this.title;
    }

    @OOXIXo
    public final AIFunctionType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.type.hashCode() * 31) + this.title.hashCode()) * 31) + this.bg) * 31) + this.desc.hashCode()) * 31) + this.icon) * 31) + this.detailsBg) * 31) + this.detailsDescribe.hashCode()) * 31) + this.detailsHint.hashCode()) * 31) + this.detailsExample.hashCode()) * 31) + this.detailsQuestion.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isHot)) * 31;
        Intent intent = this.intent;
        return hashCode + (intent == null ? 0 : intent.hashCode());
    }

    public final boolean isHot() {
        return this.isHot;
    }

    public final void setBg(int i) {
        this.bg = i;
    }

    public final void setDesc(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.desc = str;
    }

    public final void setDetailsBg(int i) {
        this.detailsBg = i;
    }

    public final void setDetailsDescribe(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.detailsDescribe = str;
    }

    public final void setDetailsExample(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.detailsExample = str;
    }

    public final void setDetailsHint(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.detailsHint = str;
    }

    public final void setDetailsQuestion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.detailsQuestion = str;
    }

    public final void setHot(boolean z) {
        this.isHot = z;
    }

    public final void setIcon(int i) {
        this.icon = i;
    }

    public final void setIntent(@oOoXoXO Intent intent) {
        this.intent = intent;
    }

    public final void setTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.title = str;
    }

    public final void setType(@OOXIXo AIFunctionType aIFunctionType) {
        IIX0o.x0xO0oo(aIFunctionType, "<set-?>");
        this.type = aIFunctionType;
    }

    @OOXIXo
    public String toString() {
        return "AIFunction(type=" + this.type + ", title=" + this.title + ", bg=" + this.bg + ", desc=" + this.desc + ", icon=" + this.icon + ", detailsBg=" + this.detailsBg + ", detailsDescribe=" + this.detailsDescribe + ", detailsHint=" + this.detailsHint + ", detailsExample=" + this.detailsExample + ", detailsQuestion=" + this.detailsQuestion + ", isHot=" + this.isHot + ", intent=" + this.intent + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AIFunction(AIFunctionType aIFunctionType, String str, int i, String str2, int i2, int i3, String str3, String str4, String str5, String str6, boolean z, Intent intent, int i4, IIXOooo iIXOooo) {
        this(aIFunctionType, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? "" : str3, (i4 & 128) != 0 ? "" : str4, (i4 & 256) != 0 ? "" : str5, (i4 & 512) == 0 ? str6 : "", (i4 & 1024) == 0 ? z : false, (i4 & 2048) != 0 ? null : intent);
    }
}
