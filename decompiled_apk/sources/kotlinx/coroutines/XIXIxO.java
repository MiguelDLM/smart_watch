package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@kotlin.jvm.internal.XX({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1364#1:1455,6\n*E\n"})
/* loaded from: classes6.dex */
public final class XIXIxO extends kotlinx.coroutines.internal.xoXoI implements ooOx {
    @OXOo.OOXIXo
    public final String XI0IXoo(@OXOo.OOXIXo String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object OOXIXo2 = OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        boolean z = true;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) OOXIXo2; !kotlin.jvm.internal.IIX0o.Oxx0IOOO(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.oOoXoXO()) {
            if (lockFreeLinkedListNode instanceof xx0X0) {
                xx0X0 xx0x0 = (xx0X0) lockFreeLinkedListNode;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(xx0x0);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlinx.coroutines.ooOx
    @OXOo.OOXIXo
    public XIXIxO getList() {
        return this;
    }

    @Override // kotlinx.coroutines.ooOx
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @OXOo.OOXIXo
    public String toString() {
        return super.toString();
    }
}
