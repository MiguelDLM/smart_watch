package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public class xoXoI extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public /* bridge */ /* synthetic */ boolean IXxxXO() {
        return ((Boolean) O0xOxO()).booleanValue();
    }

    @OXOo.OOXIXo
    public final Void O0xOxO() {
        throw new IllegalStateException("head cannot be removed");
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @OXOo.oOoXoXO
    public LockFreeLinkedListNode Oo() {
        return null;
    }

    public final boolean OxI() {
        if (OOXIXo() == this) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final void X0IIOO() {
        Object OOXIXo2 = OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        xoXoI xoxoi = this;
        xoXoI xoxoi2 = (LockFreeLinkedListNode) OOXIXo2;
        while (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(xoxoi2, this)) {
            LockFreeLinkedListNode oOoXoXO2 = xoxoi2.oOoXoXO();
            xoxoi2.xoXoI(xoxoi, oOoXoXO2);
            xoxoi = xoxoi2;
            xoxoi2 = oOoXoXO2;
        }
        Object OOXIXo3 = OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        xoXoI(xoxoi, (LockFreeLinkedListNode) OOXIXo3);
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void o00(Oox.oOoXoXO<? super T, oXIO0o0XI> oooxoxo) {
        Object OOXIXo2 = OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) OOXIXo2; !kotlin.jvm.internal.IIX0o.Oxx0IOOO(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.oOoXoXO()) {
            kotlin.jvm.internal.IIX0o.OxI(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                oooxoxo.invoke(lockFreeLinkedListNode);
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean x0XOIxOo() {
        return false;
    }
}
