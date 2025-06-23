package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public class FunctionReference extends CallableReference implements XIxXXX0x0, kotlin.reflect.xxIXOIIO {
    private final int arity;

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    private final int flags;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @kotlin.oxxXoxO(version = "1.1")
    public kotlin.reflect.I0Io computeReflected() {
        return IO.I0Io(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && IIX0o.Oxx0IOOO(getBoundReceiver(), functionReference.getBoundReceiver()) && IIX0o.Oxx0IOOO(getOwner(), functionReference.getOwner())) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof kotlin.reflect.xxIXOIIO)) {
            return false;
        }
        return obj.equals(compute());
    }

    @Override // kotlin.jvm.internal.XIxXXX0x0
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        int hashCode;
        if (getOwner() == null) {
            hashCode = 0;
        } else {
            hashCode = getOwner().hashCode() * 31;
        }
        return ((hashCode + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.xxIXOIIO
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.xxIXOIIO
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.xxIXOIIO
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.xxIXOIIO
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        kotlin.reflect.I0Io compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if (com.squareup.javapoet.X0o0xo.f25868oOoXoXO.equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + IO.f29280II0xO0;
    }

    @kotlin.oxxXoxO(version = "1.1")
    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @kotlin.oxxXoxO(version = "1.1")
    public kotlin.reflect.xxIXOIIO getReflected() {
        return (kotlin.reflect.xxIXOIIO) super.getReflected();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
