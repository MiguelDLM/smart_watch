package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AppConfigInfo extends JsonFieldContainer {

    @OOXIXo
    private String supComment;

    @OOXIXo
    private String supCreate;

    @OOXIXo
    private String supMember;

    public AppConfigInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AppConfigInfo copy$default(AppConfigInfo appConfigInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appConfigInfo.supComment;
        }
        if ((i & 2) != 0) {
            str2 = appConfigInfo.supCreate;
        }
        if ((i & 4) != 0) {
            str3 = appConfigInfo.supMember;
        }
        return appConfigInfo.copy(str, str2, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.supComment;
    }

    @OOXIXo
    public final String component2() {
        return this.supCreate;
    }

    @OOXIXo
    public final String component3() {
        return this.supMember;
    }

    @OOXIXo
    public final AppConfigInfo copy(@OOXIXo String supComment, @OOXIXo String supCreate, @OOXIXo String supMember) {
        IIX0o.x0xO0oo(supComment, "supComment");
        IIX0o.x0xO0oo(supCreate, "supCreate");
        IIX0o.x0xO0oo(supMember, "supMember");
        return new AppConfigInfo(supComment, supCreate, supMember);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppConfigInfo)) {
            return false;
        }
        AppConfigInfo appConfigInfo = (AppConfigInfo) obj;
        return IIX0o.Oxx0IOOO(this.supComment, appConfigInfo.supComment) && IIX0o.Oxx0IOOO(this.supCreate, appConfigInfo.supCreate) && IIX0o.Oxx0IOOO(this.supMember, appConfigInfo.supMember);
    }

    @OOXIXo
    public final String getSupComment() {
        return this.supComment;
    }

    @OOXIXo
    public final String getSupCreate() {
        return this.supCreate;
    }

    @OOXIXo
    public final String getSupMember() {
        return this.supMember;
    }

    public int hashCode() {
        return (((this.supComment.hashCode() * 31) + this.supCreate.hashCode()) * 31) + this.supMember.hashCode();
    }

    public final void setSupComment(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supComment = str;
    }

    public final void setSupCreate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supCreate = str;
    }

    public final void setSupMember(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supMember = str;
    }

    @OOXIXo
    public String toString() {
        return "AppConfigInfo(supComment=" + this.supComment + ", supCreate=" + this.supCreate + ", supMember=" + this.supMember + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AppConfigInfo(String str, String str2, String str3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "0" : str, (i & 2) != 0 ? "0" : str2, (i & 4) != 0 ? "1" : str3);
    }

    public AppConfigInfo(@OOXIXo String supComment, @OOXIXo String supCreate, @OOXIXo String supMember) {
        IIX0o.x0xO0oo(supComment, "supComment");
        IIX0o.x0xO0oo(supCreate, "supCreate");
        IIX0o.x0xO0oo(supMember, "supMember");
        this.supComment = supComment;
        this.supCreate = supCreate;
        this.supMember = supMember;
    }
}
