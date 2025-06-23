package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.I0Io;
import kotlinx.serialization.descriptors.XO;
import kotlinx.serialization.modules.Oxx0IOOO;
import kotlinx.serialization.modules.X0o0xo;
import xIXoO0Xx.oIX0oI;

@XX({"SMAP\nRouteDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteDecoder.kt\nandroidx/navigation/serialization/RouteDecoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
public final class RouteDecoder extends oIX0oI {
    private int elementIndex = -1;
    @OOXIXo
    private String elementName = "";
    @OOXIXo
    private final X0o0xo serializersModule = Oxx0IOOO.oIX0oI();
    @OOXIXo
    private final ArgStore store;

    public RouteDecoder(@OOXIXo Bundle bundle, @OOXIXo Map<String, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(map, "typeMap");
        this.store = new BundleArgStore(bundle, map);
    }

    public static /* synthetic */ void getSerializersModule$annotations() {
    }

    private final Object internalDecodeValue() {
        Object obj = this.store.get(this.elementName);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(("Unexpected null value for non-nullable argument " + this.elementName).toString());
    }

    public int decodeElementIndex(@OOXIXo XO xo2) {
        String Oxx0IOOO2;
        IIX0o.x0xO0oo(xo2, "descriptor");
        int i = this.elementIndex;
        do {
            i++;
            if (i >= xo2.XO()) {
                return -1;
            }
            Oxx0IOOO2 = xo2.Oxx0IOOO(i);
        } while (!this.store.contains(Oxx0IOOO2));
        this.elementIndex = i;
        this.elementName = Oxx0IOOO2;
        return i;
    }

    @OOXIXo
    public xIXoO0Xx.XO decodeInline(@OOXIXo XO xo2) {
        IIX0o.x0xO0oo(xo2, "descriptor");
        if (RouteSerializerKt.isValueClass(xo2)) {
            this.elementName = xo2.Oxx0IOOO(0);
            this.elementIndex = 0;
        }
        return super.decodeInline(xo2);
    }

    public boolean decodeNotNullMark() {
        if (this.store.get(this.elementName) != null) {
            return true;
        }
        return false;
    }

    @oOoXoXO
    public Void decodeNull() {
        return null;
    }

    public final <T> T decodeRouteWithArgs$navigation_common_release(@OOXIXo I0Io<? extends T> i0Io) {
        IIX0o.x0xO0oo(i0Io, "deserializer");
        return super.decodeSerializableValue(i0Io);
    }

    public <T> T decodeSerializableValue(@OOXIXo I0Io<? extends T> i0Io) {
        IIX0o.x0xO0oo(i0Io, "deserializer");
        return internalDecodeValue();
    }

    @OOXIXo
    public Object decodeValue() {
        return internalDecodeValue();
    }

    @OOXIXo
    public X0o0xo getSerializersModule() {
        return this.serializersModule;
    }

    public RouteDecoder(@OOXIXo SavedStateHandle savedStateHandle, @OOXIXo Map<String, ? extends NavType<?>> map) {
        IIX0o.x0xO0oo(savedStateHandle, "handle");
        IIX0o.x0xO0oo(map, "typeMap");
        this.store = new SavedStateArgStore(savedStateHandle, map);
    }
}
