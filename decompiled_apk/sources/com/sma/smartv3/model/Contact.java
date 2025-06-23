package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Contact {

    @OOXIXo
    private String name;

    @OOXIXo
    private String phone;

    public Contact(@OOXIXo String name, @OOXIXo String phone) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(phone, "phone");
        this.name = name;
        this.phone = phone;
    }

    public static /* synthetic */ Contact copy$default(Contact contact, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contact.name;
        }
        if ((i & 2) != 0) {
            str2 = contact.phone;
        }
        return contact.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.name;
    }

    @OOXIXo
    public final String component2() {
        return this.phone;
    }

    @OOXIXo
    public final Contact copy(@OOXIXo String name, @OOXIXo String phone) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(phone, "phone");
        return new Contact(name, phone);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        return IIX0o.Oxx0IOOO(this.name, contact.name) && IIX0o.Oxx0IOOO(this.phone, contact.phone);
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.phone.hashCode();
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setPhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.phone = str;
    }

    @OOXIXo
    public String toString() {
        return "Contact(name=" + this.name + ", phone=" + this.phone + HexStringBuilder.COMMENT_END_CHAR;
    }
}
