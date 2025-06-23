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
public final class RouteEncoder<T> extends II0xO0 {
    private int elementIndex = -1;
    @OOXIXo
    private final Map<String, List<String>> map = new LinkedHashMap();
    @OOXIXo
    private final Oxx0IOOO<T> serializer;
    @OOXIXo
    private final X0o0xo serializersModule = SerializersModuleBuildersKt.oIX0oI();
    @OOXIXo
    private final Map<String, NavType<Object>> typeMap;

    public RouteEncoder(@OOXIXo Oxx0IOOO<T> oxx0IOOO, @OOXIXo Map<String, ? extends NavType<Object>> map2) {
        IIX0o.x0xO0oo(oxx0IOOO, "serializer");
        IIX0o.x0xO0oo(map2, "typeMap");
        this.serializer = oxx0IOOO;
        this.typeMap = map2;
    }

    private final void internalEncodeValue(Object obj) {
        List<String> list;
        String Oxx0IOOO2 = this.serializer.oIX0oI().Oxx0IOOO(this.elementIndex);
        NavType navType = this.typeMap.get(Oxx0IOOO2);
        if (navType != null) {
            if (navType instanceof CollectionNavType) {
                list = ((CollectionNavType) navType).serializeAsValues(obj);
            } else {
                list = oI0IIXIo.OOXIXo(navType.serializeAsValue(obj));
            }
            this.map.put(Oxx0IOOO2, list);
            return;
        }
        throw new IllegalStateException(("Cannot find NavType for argument " + Oxx0IOOO2 + ". Please provide NavType through typeMap.").toString());
    }

    public boolean encodeElement(@OOXIXo XO xo2, int i) {
        IIX0o.x0xO0oo(xo2, "descriptor");
        this.elementIndex = i;
        return true;
    }

    @OOXIXo
    public II0XooXoX encodeInline(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "descriptor");
        if (RouteSerializerKt.isValueClass(xo2)) {
            this.elementIndex = 0;
        }
        return super.encodeInline(xo2);
    }

    public void encodeNull() {
        internalEncodeValue((Object) null);
    }

    public <T> void encodeSerializableValue(@OOXIXo Oxx0xo<? super T> oxx0xo, T t) {
        IIX0o.x0xO0oo(oxx0xo, "serializer");
        internalEncodeValue(t);
    }

    @OOXIXo
    public final Map<String, List<String>> encodeToArgMap(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "value");
        super.encodeSerializableValue(this.serializer, obj);
        return o0.OX00O0xII(this.map);
    }

    public void encodeValue(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "value");
        internalEncodeValue(obj);
    }

    @OOXIXo
    public X0o0xo getSerializersModule() {
        return this.serializersModule;
    }
}
