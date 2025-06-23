package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.IIX0o;
import okhttp3.HttpUrl;

@kotlin.IXxxXO
/* loaded from: classes6.dex */
public final class oIX0oI implements GenericArrayType, IIXOooo {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Type f29409XO;

    public oIX0oI(@OXOo.OOXIXo Type elementType) {
        IIX0o.x0xO0oo(elementType, "elementType");
        this.f29409XO = elementType;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if ((obj instanceof GenericArrayType) && IIX0o.Oxx0IOOO(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType())) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    @OXOo.OOXIXo
    public Type getGenericComponentType() {
        return this.f29409XO;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.IIXOooo
    @OXOo.OOXIXo
    public String getTypeName() {
        String xoIox2;
        StringBuilder sb = new StringBuilder();
        xoIox2 = TypesJVMKt.xoIox(this.f29409XO);
        sb.append(xoIox2);
        sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @OXOo.OOXIXo
    public String toString() {
        return getTypeName();
    }
}
