package com.github.appintro.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class PermissionWrapper implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;

    @OOXIXo
    private String[] permissions;
    private int position;
    private boolean required;

    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public PermissionWrapper(@OOXIXo String[] permissions, int i, boolean z) {
        IIX0o.x0xO0oo(permissions, "permissions");
        this.permissions = permissions;
        this.position = i;
        this.required = z;
    }

    public static /* synthetic */ PermissionWrapper copy$default(PermissionWrapper permissionWrapper, String[] strArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            strArr = permissionWrapper.permissions;
        }
        if ((i2 & 2) != 0) {
            i = permissionWrapper.position;
        }
        if ((i2 & 4) != 0) {
            z = permissionWrapper.required;
        }
        return permissionWrapper.copy(strArr, i, z);
    }

    @OOXIXo
    public final String[] component1() {
        return this.permissions;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.required;
    }

    @OOXIXo
    public final PermissionWrapper copy(@OOXIXo String[] permissions, int i, boolean z) {
        IIX0o.x0xO0oo(permissions, "permissions");
        return new PermissionWrapper(permissions, i, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        if (!IIX0o.Oxx0IOOO(PermissionWrapper.class, cls)) {
            return false;
        }
        if (obj != null) {
            PermissionWrapper permissionWrapper = (PermissionWrapper) obj;
            if (Arrays.equals(this.permissions, permissionWrapper.permissions) && this.position == permissionWrapper.position && this.required == permissionWrapper.required) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.github.appintro.internal.PermissionWrapper");
    }

    @OOXIXo
    public final String[] getPermissions() {
        return this.permissions;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.permissions) * 31) + this.position) * 31) + oIX0oI.oIX0oI(this.required);
    }

    public final void setPermissions(@OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(strArr, "<set-?>");
        this.permissions = strArr;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    @OOXIXo
    public String toString() {
        return "PermissionWrapper(permissions=" + Arrays.toString(this.permissions) + ", position=" + this.position + ", required=" + this.required + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ PermissionWrapper(String[] strArr, int i, boolean z, int i2, IIXOooo iIXOooo) {
        this(strArr, i, (i2 & 4) != 0 ? true : z);
    }
}
