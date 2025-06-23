package androidx.navigation.serialization;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.Oxx0IOOO;
import kotlinx.serialization.Oxx0xo;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import kotlinx.serialization.modules.X0o0xo;
import xIXoO0Xx.II0XooXoX;
import xIXoO0Xx.II0xO0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class RouteEncoder<T> extends II0xO0 {
    private int elementIndex;

    @OOXIXo
    private final Map<String, List<String>> map;

    @OOXIXo
    private final Oxx0IOOO<T> serializer;

    @OOXIXo
    private final X0o0xo serializersModule;

    @OOXIXo
    private final Map<String, NavType<Object>> typeMap;

    /* JADX WARN: Multi-variable type inference failed */
    public RouteEncoder(@OOXIXo Oxx0IOOO<T> serializer, @OOXIXo Map<String, ? extends NavType<Object>> typeMap) {
        IIX0o.x0xO0oo(serializer, "serializer");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.serializer = serializer;
        this.typeMap = typeMap;
        this.serializersModule = SerializersModuleBuildersKt.oIX0oI();
        this.map = new LinkedHashMap();
        this.elementIndex = -1;
    }

    private final void internalEncodeValue(Object obj) {
        List<String> OOXIXo2;
        String Oxx0IOOO2 = this.serializer.oIX0oI().Oxx0IOOO(this.elementIndex);
        NavType<Object> navType = this.typeMap.get(Oxx0IOOO2);
        if (navType != null) {
            if (navType instanceof CollectionNavType) {
                OOXIXo2 = ((CollectionNavType) navType).serializeAsValues(obj);
            } else {
                OOXIXo2 = oI0IIXIo.OOXIXo(navType.serializeAsValue(obj));
            }
            this.map.put(Oxx0IOOO2, OOXIXo2);
            return;
        }
        throw new IllegalStateException(("Cannot find NavType for argument " + Oxx0IOOO2 + ". Please provide NavType through typeMap.").toString());
    }

    @Override // xIXoO0Xx.II0xO0
    public boolean encodeElement(@OOXIXo XO descriptor, int i) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        this.elementIndex = i;
        return true;
    }

    @Override // xIXoO0Xx.II0xO0, xIXoO0Xx.II0XooXoX
    @OOXIXo
    public II0XooXoX encodeInline(@OOXIXo XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (RouteSerializerKt.isValueClass(descriptor)) {
            this.elementIndex = 0;
        }
        return super.encodeInline(descriptor);
    }

    @Override // xIXoO0Xx.II0xO0, xIXoO0Xx.II0XooXoX
    public void encodeNull() {
        internalEncodeValue(null);
    }

    @Override // xIXoO0Xx.II0xO0, xIXoO0Xx.II0XooXoX
    public <T> void encodeSerializableValue(@OOXIXo Oxx0xo<? super T> serializer, T t) {
        IIX0o.x0xO0oo(serializer, "serializer");
        internalEncodeValue(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    public final Map<String, List<String>> encodeToArgMap(@OOXIXo Object value) {
        IIX0o.x0xO0oo(value, "value");
        super.encodeSerializableValue(this.serializer, value);
        return o0.OX00O0xII(this.map);
    }

    @Override // xIXoO0Xx.II0xO0
    public void encodeValue(@OOXIXo Object value) {
        IIX0o.x0xO0oo(value, "value");
        internalEncodeValue(value);
    }

    @Override // xIXoO0Xx.II0XooXoX, xIXoO0Xx.X0o0xo
    @OOXIXo
    public X0o0xo getSerializersModule() {
        return this.serializersModule;
    }
}
