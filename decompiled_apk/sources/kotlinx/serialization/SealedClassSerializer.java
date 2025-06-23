package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.XxX0x0xxx;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.descriptors.II0XooXoX;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.oxoX;

@XX({"SMAP\nSealedSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SealedSerializer.kt\nkotlinx/serialization/SealedClassSerializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Platform.common.kt\nkotlinx/serialization/internal/Platform_commonKt\n*L\n1#1,154:1\n1536#2:155\n1238#2,4:165\n53#3:156\n80#3,6:157\n453#4:163\n403#4:164\n83#5:169\n*S KotlinDebug\n*F\n+ 1 SealedSerializer.kt\nkotlinx/serialization/SealedClassSerializer\n*L\n130#1:155\n140#1:165,4\n131#1:156\n131#1:157,6\n140#1:163\n140#1:164\n151#1:169\n*E\n"})
@XO
/* loaded from: classes6.dex */
public final class SealedClassSerializer<T> extends kotlinx.serialization.internal.II0xO0<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f30554I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<? extends Annotation> f30555II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Map<String, Oxx0IOOO<? extends T>> f30556X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.reflect.oxoX<T> f30557oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Map<kotlin.reflect.oxoX<? extends T>, Oxx0IOOO<? extends T>> f30558oxoX;

    @XX({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n+ 2 SealedSerializer.kt\nkotlinx/serialization/SealedClassSerializer\n*L\n1#1,3683:1\n130#2:3684\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements XxX0x0xxx<Map.Entry<? extends kotlin.reflect.oxoX<? extends T>, ? extends Oxx0IOOO<? extends T>>, String> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Iterable f30559oIX0oI;

        public oIX0oI(Iterable iterable) {
            this.f30559oIX0oI = iterable;
        }

        @Override // kotlin.collections.XxX0x0xxx
        @OXOo.OOXIXo
        public Iterator<Map.Entry<? extends kotlin.reflect.oxoX<? extends T>, ? extends Oxx0IOOO<? extends T>>> II0xO0() {
            return this.f30559oIX0oI.iterator();
        }

        @Override // kotlin.collections.XxX0x0xxx
        public String oIX0oI(Map.Entry<? extends kotlin.reflect.oxoX<? extends T>, ? extends Oxx0IOOO<? extends T>> entry) {
            return entry.getValue().oIX0oI().xxIXOIIO();
        }
    }

    public SealedClassSerializer(@OXOo.OOXIXo final String serialName, @OXOo.OOXIXo kotlin.reflect.oxoX<T> baseClass, @OXOo.OOXIXo kotlin.reflect.oxoX<? extends T>[] subclasses, @OXOo.OOXIXo Oxx0IOOO<? extends T>[] subclassSerializers) {
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(subclasses, "subclasses");
        IIX0o.x0xO0oo(subclassSerializers, "subclassSerializers");
        this.f30557oIX0oI = baseClass;
        this.f30555II0xO0 = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f30554I0Io = XIxXXX0x0.I0Io(LazyThreadSafetyMode.PUBLICATION, new Oox.oIX0oI<kotlinx.serialization.descriptors.XO>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.descriptors.XO invoke() {
                final SealedClassSerializer<T> sealedClassSerializer = this;
                return SerialDescriptorsKt.X0o0xo(serialName, oxoX.II0xO0.f30604oIX0oI, new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                        invoke2(oix0oi);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        IIX0o.x0xO0oo(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor, "type", xx.oOoXoXO.oo(oxxXoxO.f29356oIX0oI).oIX0oI(), null, false, 12, null);
                        final SealedClassSerializer<T> sealedClassSerializer2 = sealedClassSerializer;
                        kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor, "value", SerialDescriptorsKt.X0o0xo("kotlinx.serialization.Sealed<" + sealedClassSerializer.xoIox().xoXoI() + kotlin.text.XIxXXX0x0.f29545XO, II0XooXoX.oIX0oI.f30568oIX0oI, new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2$1$elementDescriptor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                                invoke2(oix0oi);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildSerialDescriptor2) {
                                Map map;
                                IIX0o.x0xO0oo(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                                map = sealedClassSerializer2.f30556X0o0xo;
                                for (Map.Entry entry : map.entrySet()) {
                                    kotlinx.serialization.descriptors.oIX0oI.II0xO0(buildSerialDescriptor2, (String) entry.getKey(), ((Oxx0IOOO) entry.getValue()).oIX0oI(), null, false, 12, null);
                                }
                            }
                        }), null, false, 12, null);
                        list = sealedClassSerializer.f30555II0xO0;
                        buildSerialDescriptor.oOoXoXO(list);
                    }
                });
            }
        });
        if (subclasses.length == subclassSerializers.length) {
            Map<kotlin.reflect.oxoX<? extends T>, Oxx0IOOO<? extends T>> ooOx2 = o0.ooOx(ArraysKt___ArraysKt.OxIO(subclasses, subclassSerializers));
            this.f30558oxoX = ooOx2;
            XxX0x0xxx oix0oi = new oIX0oI(ooOx2.entrySet());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<T> II0xO02 = oix0oi.II0xO0();
            while (II0xO02.hasNext()) {
                T next = II0xO02.next();
                Object oIX0oI2 = oix0oi.oIX0oI(next);
                Object obj = linkedHashMap.get(oIX0oI2);
                if (obj == null) {
                    linkedHashMap.containsKey(oIX0oI2);
                }
                Map.Entry entry = (Map.Entry) next;
                Map.Entry entry2 = (Map.Entry) obj;
                String str = (String) oIX0oI2;
                if (entry2 != null) {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + xoIox() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
                linkedHashMap.put(oIX0oI2, entry);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(OI0.xoIox(linkedHashMap.size()));
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (Oxx0IOOO) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.f30556X0o0xo = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + xoIox().xoXoI() + " should be marked @Serializable");
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @OXOo.oOoXoXO
    public I0Io<T> II0XooXoX(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(decoder, "decoder");
        Oxx0IOOO<? extends T> oxx0IOOO = this.f30556X0o0xo.get(str);
        if (oxx0IOOO == null) {
            return super.II0XooXoX(decoder, str);
        }
        return oxx0IOOO;
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return (kotlinx.serialization.descriptors.XO) this.f30554I0Io.getValue();
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @OXOo.OOXIXo
    public kotlin.reflect.oxoX<T> xoIox() {
        return this.f30557oIX0oI;
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @OXOo.oOoXoXO
    public Oxx0xo<T> xxIXOIIO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        Oxx0IOOO<? extends T> oxx0IOOO = this.f30558oxoX.get(IO.oxoX(value.getClass()));
        if (oxx0IOOO == null) {
            oxx0IOOO = super.xxIXOIIO(encoder, value);
        }
        if (oxx0IOOO == null) {
            return null;
        }
        return oxx0IOOO;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.o0
    public SealedClassSerializer(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo kotlin.reflect.oxoX<T> baseClass, @OXOo.OOXIXo kotlin.reflect.oxoX<? extends T>[] subclasses, @OXOo.OOXIXo Oxx0IOOO<? extends T>[] subclassSerializers, @OXOo.OOXIXo Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        IIX0o.x0xO0oo(serialName, "serialName");
        IIX0o.x0xO0oo(baseClass, "baseClass");
        IIX0o.x0xO0oo(subclasses, "subclasses");
        IIX0o.x0xO0oo(subclassSerializers, "subclassSerializers");
        IIX0o.x0xO0oo(classAnnotations, "classAnnotations");
        this.f30555II0xO0 = kotlin.collections.ooOOo0oXI.oI0IIXIo(classAnnotations);
    }
}
