package org.apache.commons.lang3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class x0o {

    /* loaded from: classes6.dex */
    public static class oIX0oI extends ObjectInputStream {

        /* renamed from: Oo, reason: collision with root package name */
        public static final Map<String, Class<?>> f32924Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final ClassLoader f32925XO;

        static {
            HashMap hashMap = new HashMap();
            f32924Oo = hashMap;
            hashMap.put("byte", Byte.TYPE);
            hashMap.put("short", Short.TYPE);
            hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, Integer.TYPE);
            hashMap.put("long", Long.TYPE);
            hashMap.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
            hashMap.put("double", Double.TYPE);
            hashMap.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
            hashMap.put("char", Character.TYPE);
            hashMap.put("void", Void.TYPE);
        }

        public oIX0oI(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.f32925XO = classLoader;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.f32925XO);
                } catch (ClassNotFoundException e) {
                    Class<?> cls = f32924Oo.get(name);
                    if (cls != null) {
                        return cls;
                    }
                    throw e;
                }
            } catch (ClassNotFoundException unused) {
                return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
            }
        }
    }

    public static <T> T I0Io(byte[] bArr) {
        xoIxX.xo0x(bArr, "The byte[] must not be null", new Object[0]);
        return (T) II0xO0(new ByteArrayInputStream(bArr));
    }

    public static <T> T II0xO0(InputStream inputStream) {
        xoIxX.xo0x(inputStream, "The InputStream must not be null", new Object[0]);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                T t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(e);
        }
    }

    public static void X0o0xo(Serializable serializable, OutputStream outputStream) {
        xoIxX.xo0x(outputStream, "The OutputStream must not be null", new Object[0]);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public static byte[] XO(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        X0o0xo(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static <T extends Serializable> T oIX0oI(T t) {
        if (t == null) {
            return null;
        }
        try {
            oIX0oI oix0oi = new oIX0oI(new ByteArrayInputStream(XO(t)), t.getClass().getClassLoader());
            try {
                T t2 = (T) oix0oi.readObject();
                oix0oi.close();
                return t2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        oix0oi.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new SerializationException("IOException while reading or closing cloned object data", e);
        } catch (ClassNotFoundException e2) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", e2);
        }
    }

    public static <T extends Serializable> T oxoX(T t) {
        return (T) I0Io(XO(t));
    }
}
