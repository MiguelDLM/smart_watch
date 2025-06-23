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
/* loaded from: classes.dex */
public final class RouteDecoder extends oIX0oI {
    private int elementIndex;

    @OOXIXo
    private String elementName;

    @OOXIXo
    private final X0o0xo serializersModule;

    @OOXIXo
    private final ArgStore store;

    public RouteDecoder(@OOXIXo Bundle bundle, @OOXIXo Map<String, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.elementIndex = -1;
        this.elementName = "";
        this.serializersModule = Oxx0IOOO.oIX0oI();
        this.store = new BundleArgStore(bundle, typeMap);
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

    @Override // xIXoO0Xx.oxoX
    public int decodeElementIndex(@OOXIXo XO descriptor) {
        String Oxx0IOOO2;
        IIX0o.x0xO0oo(descriptor, "descriptor");
        int i = this.elementIndex;
        do {
            i++;
            if (i >= descriptor.XO()) {
                return -1;
            }
            Oxx0IOOO2 = descriptor.Oxx0IOOO(i);
        } while (!this.store.contains(Oxx0IOOO2));
        this.elementIndex = i;
        this.elementName = Oxx0IOOO2;
        return i;
    }

    @Override // xIXoO0Xx.oIX0oI, xIXoO0Xx.XO
    @OOXIXo
    public xIXoO0Xx.XO decodeInline(@OOXIXo XO descriptor) {
        IIX0o.x0xO0oo(descriptor, "descriptor");
        if (RouteSerializerKt.isValueClass(descriptor)) {
            this.elementName = descriptor.Oxx0IOOO(0);
            this.elementIndex = 0;
        }
        return super.decodeInline(descriptor);
    }

    @Override // xIXoO0Xx.oIX0oI, xIXoO0Xx.XO
    public boolean decodeNotNullMark() {
        if (this.store.get(this.elementName) != null) {
            return true;
        }
        return false;
    }

    @Override // xIXoO0Xx.oIX0oI, xIXoO0Xx.XO
    @oOoXoXO
    public Void decodeNull() {
        return null;
    }

    public final <T> T decodeRouteWithArgs$navigation_common_release(@OOXIXo I0Io<? extends T> deserializer) {
        IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) super.decodeSerializableValue(deserializer);
    }

    @Override // xIXoO0Xx.oIX0oI, xIXoO0Xx.XO
    public <T> T decodeSerializableValue(@OOXIXo I0Io<? extends T> deserializer) {
        IIX0o.x0xO0oo(deserializer, "deserializer");
        return (T) internalDecodeValue();
    }

    @Override // xIXoO0Xx.oIX0oI
    @OOXIXo
    public Object decodeValue() {
        return internalDecodeValue();
    }

    @Override // xIXoO0Xx.XO, xIXoO0Xx.oxoX
    @OOXIXo
    public X0o0xo getSerializersModule() {
        return this.serializersModule;
    }

    public RouteDecoder(@OOXIXo SavedStateHandle handle, @OOXIXo Map<String, ? extends NavType<?>> typeMap) {
        IIX0o.x0xO0oo(handle, "handle");
        IIX0o.x0xO0oo(typeMap, "typeMap");
        this.elementIndex = -1;
        this.elementName = "";
        this.serializersModule = Oxx0IOOO.oIX0oI();
        this.store = new SavedStateArgStore(handle, typeMap);
    }
}
