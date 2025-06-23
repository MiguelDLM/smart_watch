package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,161:1\n77#1,5:162\n77#1,5:168\n131#1,13:183\n1#2:167\n1360#3:173\n1446#3,5:174\n1549#3:179\n1620#3,3:180\n1064#4,2:196\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n60#1:162,5\n61#1:168,5\n117#1:183,13\n99#1:173\n99#1:174,5\n101#1:179\n101#1:180,3\n153#1:196,2\n*E\n"})
/* loaded from: classes6.dex */
public final class x0XOIxOo {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30311II0xO0 = "META-INF/services/";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0XOIxOo f30312oIX0oI = new x0XOIxOo();

    public final <S> List<S> I0Io(Class<S> cls, ClassLoader classLoader) {
        try {
            return X0o0xo(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.oOo0o(ServiceLoader.load(cls, classLoader));
        }
    }

    public final <R> R II0XooXoX(JarFile jarFile, Oox.oOoXoXO<? super JarFile, ? extends R> oooxoxo) {
        try {
            R invoke = oooxoxo.invoke(jarFile);
            kotlin.jvm.internal.xxX.oxoX(1);
            jarFile.close();
            kotlin.jvm.internal.xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                try {
                    jarFile.close();
                    kotlin.jvm.internal.xxX.I0Io(1);
                    throw th2;
                } catch (Throwable th3) {
                    kotlin.oO.oIX0oI(th, th3);
                    throw th;
                }
            }
        }
    }

    public final <S> S II0xO0(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(null).newInstance(null));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final List<String> Oxx0IOOO(BufferedReader bufferedReader) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt___CollectionsKt.oOo0o(linkedHashSet);
            }
            String obj = StringsKt__StringsKt.oIoIXxIO(StringsKt__StringsKt.OoxxX(readLine, OoOoXO0.xoXoI.f2670oxoX, null, 2, null)).toString();
            for (int i = 0; i < obj.length(); i++) {
                char charAt = obj.charAt(i);
                if (charAt != '.' && !Character.isJavaIdentifierPart(charAt)) {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    @OXOo.OOXIXo
    public final <S> List<S> X0o0xo(@OXOo.OOXIXo Class<S> cls, @OXOo.OOXIXo ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(f30311II0xO0 + cls.getName()));
        kotlin.jvm.internal.IIX0o.oO(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.OxI.XIo0oOXIx(arrayList, f30312oIX0oI.XO((URL) it.next()));
        }
        Set XxI0 = CollectionsKt___CollectionsKt.XxI0(arrayList);
        if (!XxI0.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(XxI0, 10));
            Iterator it2 = XxI0.iterator();
            while (it2.hasNext()) {
                arrayList2.add(f30312oIX0oI.II0xO0((String) it2.next(), classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader");
    }

    public final List<String> XO(URL url) {
        BufferedReader bufferedReader;
        String url2 = url.toString();
        if (kotlin.text.OxI.IOOoXo0Ix(url2, "jar", false, 2, null)) {
            String xxx2 = StringsKt__StringsKt.xxx(StringsKt__StringsKt.oO0(url2, "jar:file:", null, 2, null), OoIXo.oOoXoXO.f2346I0Io, null, 2, null);
            String oO02 = StringsKt__StringsKt.oO0(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(xxx2, false);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(oO02)), "UTF-8"));
                try {
                    List<String> Oxx0IOOO2 = f30312oIX0oI.Oxx0IOOO(bufferedReader);
                    kotlin.io.II0xO0.oIX0oI(bufferedReader, null);
                    jarFile.close();
                    return Oxx0IOOO2;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        kotlin.oO.oIX0oI(th, th3);
                        throw th;
                    }
                }
            }
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> Oxx0IOOO3 = f30312oIX0oI.Oxx0IOOO(bufferedReader);
                kotlin.io.II0xO0.oIX0oI(bufferedReader, null);
                return Oxx0IOOO3;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } finally {
                }
            }
        }
    }

    public final XI0IXoo oIX0oI(Class<XI0IXoo> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @OXOo.OOXIXo
    public final List<XI0IXoo> oxoX() {
        XI0IXoo xI0IXoo;
        if (!oO.oIX0oI()) {
            return I0Io(XI0IXoo.class, XI0IXoo.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            XI0IXoo xI0IXoo2 = null;
            try {
                xI0IXoo = (XI0IXoo) XI0IXoo.class.cast(Class.forName("kotlinx.coroutines.android.oIX0oI", true, XI0IXoo.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused) {
                xI0IXoo = null;
            }
            if (xI0IXoo != null) {
                arrayList.add(xI0IXoo);
            }
            try {
                xI0IXoo2 = (XI0IXoo) XI0IXoo.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, XI0IXoo.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused2) {
            }
            if (xI0IXoo2 != null) {
                arrayList.add(xI0IXoo2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return I0Io(XI0IXoo.class, XI0IXoo.class.getClassLoader());
        }
    }
}
