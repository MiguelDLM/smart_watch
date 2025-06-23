package kotlin.jvm.internal;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;

/* loaded from: classes6.dex */
public abstract class CallableReference implements kotlin.reflect.I0Io, Serializable {

    @kotlin.oxxXoxO(version = "1.1")
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    private final boolean isTopLevel;

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    private final String name;

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    private final Class owner;

    @kotlin.oxxXoxO(version = "1.1")
    protected final Object receiver;
    private transient kotlin.reflect.I0Io reflected;

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    private final String signature;

    @kotlin.oxxXoxO(version = "1.2")
    /* loaded from: classes6.dex */
    public static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // kotlin.reflect.I0Io
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.I0Io
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @kotlin.oxxXoxO(version = "1.1")
    public kotlin.reflect.I0Io compute() {
        kotlin.reflect.I0Io i0Io = this.reflected;
        if (i0Io == null) {
            kotlin.reflect.I0Io computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return i0Io;
    }

    public abstract kotlin.reflect.I0Io computeReflected();

    @Override // kotlin.reflect.II0xO0
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @kotlin.oxxXoxO(version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.I0Io
    public String getName() {
        return this.name;
    }

    public kotlin.reflect.II0XooXoX getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return IO.Oxx0IOOO(cls);
        }
        return IO.oxoX(cls);
    }

    @Override // kotlin.reflect.I0Io
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @kotlin.oxxXoxO(version = "1.1")
    public kotlin.reflect.I0Io getReflected() {
        kotlin.reflect.I0Io compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.I0Io
    public kotlin.reflect.Oxx0xo getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.1")
    public List<kotlin.reflect.oI0IIXIo> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.1")
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.I0Io
    @kotlin.oxxXoxO(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @kotlin.oxxXoxO(version = "1.1")
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
