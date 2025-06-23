package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ActionOnlyNavDirections implements NavDirections {
    private final int actionId;

    @OOXIXo
    private final Bundle arguments = new Bundle();

    public ActionOnlyNavDirections(int i) {
        this.actionId = i;
    }

    public static /* synthetic */ ActionOnlyNavDirections copy$default(ActionOnlyNavDirections actionOnlyNavDirections, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = actionOnlyNavDirections.actionId;
        }
        return actionOnlyNavDirections.copy(i);
    }

    public final int component1() {
        return this.actionId;
    }

    @OOXIXo
    public final ActionOnlyNavDirections copy(int i) {
        return new ActionOnlyNavDirections(i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IIX0o.Oxx0IOOO(ActionOnlyNavDirections.class, obj.getClass()) && getActionId() == ((ActionOnlyNavDirections) obj).getActionId()) {
            return true;
        }
        return false;
    }

    @Override // androidx.navigation.NavDirections
    public int getActionId() {
        return this.actionId;
    }

    @Override // androidx.navigation.NavDirections
    @OOXIXo
    public Bundle getArguments() {
        return this.arguments;
    }

    public int hashCode() {
        return 31 + getActionId();
    }

    @OOXIXo
    public String toString() {
        return "ActionOnlyNavDirections(actionId=" + getActionId() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
