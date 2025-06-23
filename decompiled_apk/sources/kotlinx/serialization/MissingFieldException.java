package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.o0;

@oxoX
/* loaded from: classes6.dex */
public final class MissingFieldException extends SerializationException {

    @OXOo.OOXIXo
    private final List<String> missingFields;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(@OXOo.OOXIXo List<String> missingFields, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO Throwable th) {
        super(str, th);
        IIX0o.x0xO0oo(missingFields, "missingFields");
        this.missingFields = missingFields;
    }

    @OXOo.OOXIXo
    public final List<String> getMissingFields() {
        return this.missingFields;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MissingFieldException(@OXOo.OOXIXo java.util.List<java.lang.String> r3, @OXOo.OOXIXo java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "missingFields"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "serialName"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            int r0 = r3.size()
            r1 = 1
            if (r0 != r1) goto L37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Field '"
            r0.append(r1)
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r1 = "' is required for type with serial name '"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "', but it was missing"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            goto L55
        L37:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Fields "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " are required for type with serial name '"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "', but they were missing"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
        L55:
            r0 = 0
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.MissingFieldException.<init>(java.util.List, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissingFieldException(@OXOo.OOXIXo String missingField, @OXOo.OOXIXo String serialName) {
        this(kotlin.collections.oI0IIXIo.OOXIXo(missingField), "Field '" + missingField + "' is required for type with serial name '" + serialName + "', but it was missing", null);
        IIX0o.x0xO0oo(missingField, "missingField");
        IIX0o.x0xO0oo(serialName, "serialName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @o0
    public MissingFieldException(@OXOo.OOXIXo String missingField) {
        this(kotlin.collections.oI0IIXIo.OOXIXo(missingField), "Field '" + missingField + "' is required, but it was missing", null);
        IIX0o.x0xO0oo(missingField, "missingField");
    }
}
