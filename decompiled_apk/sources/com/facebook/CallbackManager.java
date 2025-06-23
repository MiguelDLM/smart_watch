package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public interface CallbackManager {

    /* loaded from: classes8.dex */
    public static final class ActivityResultParameters {

        @OXOo.oOoXoXO
        private final Intent data;
        private final int requestCode;
        private final int resultCode;

        public ActivityResultParameters(int i, int i2, @OXOo.oOoXoXO Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }

        public static /* synthetic */ ActivityResultParameters copy$default(ActivityResultParameters activityResultParameters, int i, int i2, Intent intent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = activityResultParameters.requestCode;
            }
            if ((i3 & 2) != 0) {
                i2 = activityResultParameters.resultCode;
            }
            if ((i3 & 4) != 0) {
                intent = activityResultParameters.data;
            }
            return activityResultParameters.copy(i, i2, intent);
        }

        public final int component1() {
            return this.requestCode;
        }

        public final int component2() {
            return this.resultCode;
        }

        @OXOo.oOoXoXO
        public final Intent component3() {
            return this.data;
        }

        @OXOo.OOXIXo
        public final ActivityResultParameters copy(int i, int i2, @OXOo.oOoXoXO Intent intent) {
            return new ActivityResultParameters(i, i2, intent);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityResultParameters)) {
                return false;
            }
            ActivityResultParameters activityResultParameters = (ActivityResultParameters) obj;
            return this.requestCode == activityResultParameters.requestCode && this.resultCode == activityResultParameters.resultCode && IIX0o.Oxx0IOOO(this.data, activityResultParameters.data);
        }

        @OXOo.oOoXoXO
        public final Intent getData() {
            return this.data;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public int hashCode() {
            int i = ((this.requestCode * 31) + this.resultCode) * 31;
            Intent intent = this.data;
            return i + (intent == null ? 0 : intent.hashCode());
        }

        @OXOo.OOXIXo
        public String toString() {
            return "ActivityResultParameters(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Factory {

        @OXOo.OOXIXo
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent);
}
