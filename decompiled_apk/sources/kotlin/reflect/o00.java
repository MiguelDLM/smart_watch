package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@kotlin.IXxxXO
@XX({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n1549#2:231\n1620#2,3:232\n37#3,2:235\n26#4:237\n26#4:238\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n*L\n116#1:231\n116#1:232,3\n116#1:235,2\n134#1:237\n137#1:238\n*E\n"})
/* loaded from: classes6.dex */
public final class o00 implements TypeVariable<GenericDeclaration>, IIXOooo {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oI0IIXIo f29408XO;

    public o00(@OXOo.OOXIXo oI0IIXIo typeParameter) {
        IIX0o.x0xO0oo(typeParameter, "typeParameter");
        this.f29408XO = typeParameter;
    }

    @OXOo.OOXIXo
    public final Annotation[] I0Io() {
        return new Annotation[0];
    }

    @OXOo.OOXIXo
    public final Annotation[] II0xO0() {
        return new Annotation[0];
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (IIX0o.Oxx0IOOO(getName(), typeVariable.getName()) && IIX0o.Oxx0IOOO(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @OXOo.OOXIXo
    public Type[] getBounds() {
        Type I0Io2;
        List<Oxx0xo> upperBounds = this.f29408XO.getUpperBounds();
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            I0Io2 = TypesJVMKt.I0Io((Oxx0xo) it.next(), true);
            arrayList.add(I0Io2);
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    @OXOo.OOXIXo
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f29408XO));
    }

    @Override // java.lang.reflect.TypeVariable
    @OXOo.OOXIXo
    public String getName() {
        return this.f29408XO.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.IIXOooo
    @OXOo.OOXIXo
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @OXOo.oOoXoXO
    public final <T extends Annotation> T oIX0oI(@OXOo.OOXIXo Class<T> annotationClass) {
        IIX0o.x0xO0oo(annotationClass, "annotationClass");
        return null;
    }

    @OXOo.OOXIXo
    public String toString() {
        return getTypeName();
    }
}
