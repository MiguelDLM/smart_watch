package kotlin.collections.builders;

import OXOo.OOXIXo;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.oX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
/* loaded from: classes6.dex */
public final class SerializedCollection implements Externalizable {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    @OOXIXo
    private Collection<?> collection;
    private final int tag;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public SerializedCollection(@OOXIXo Collection<?> collection, int i) {
        IIX0o.x0xO0oo(collection, "collection");
        this.collection = collection;
        this.tag = i;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@OOXIXo ObjectInput input) {
        List oIX0oI2;
        IIX0o.x0xO0oo(input, "input");
        byte readByte = input.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                int i2 = 0;
                if (i != 0) {
                    if (i == 1) {
                        Set X0o0xo2 = oX.X0o0xo(readInt);
                        while (i2 < readInt) {
                            X0o0xo2.add(input.readObject());
                            i2++;
                        }
                        oIX0oI2 = oX.oIX0oI(X0o0xo2);
                    } else {
                        throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
                    }
                } else {
                    List xoIox2 = oI0IIXIo.xoIox(readInt);
                    while (i2 < readInt) {
                        xoIox2.add(input.readObject());
                        i2++;
                    }
                    oIX0oI2 = oI0IIXIo.oIX0oI(xoIox2);
                }
                this.collection = oIX0oI2;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(@OOXIXo ObjectOutput output) {
        IIX0o.x0xO0oo(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public SerializedCollection() {
        this(CollectionsKt__CollectionsKt.ooXIXxIX(), 0);
    }
}
