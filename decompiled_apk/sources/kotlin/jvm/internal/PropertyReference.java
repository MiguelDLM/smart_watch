package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;

/* loaded from: classes6.dex */
public abstract class PropertyReference extends CallableReference implements kotlin.reflect.x0XOIxOo {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.I0Io compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        return super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && IIX0o.Oxx0IOOO(getBoundReceiver(), propertyReference.getBoundReceiver())) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof kotlin.reflect.x0XOIxOo)) {
            return false;
        }
        return obj.equals(compute());
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.x0XOIxOo
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.x0XOIxOo
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        kotlin.reflect.I0Io compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + IO.f29280II0xO0;
    }

    @Override // kotlin.jvm.internal.CallableReference
    @kotlin.oxxXoxO(version = "1.1")
    public kotlin.reflect.x0XOIxOo getReflected() {
        if (!this.syntheticJavaProperty) {
            return (kotlin.reflect.x0XOIxOo) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    @kotlin.oxxXoxO(version = "1.1")
    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }
}
