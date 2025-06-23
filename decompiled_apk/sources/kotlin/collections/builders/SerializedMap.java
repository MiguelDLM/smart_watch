package kotlin.collections.builders;

import OXOo.OOXIXo;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.OI0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
final class SerializedMap implements Externalizable {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final long serialVersionUID = 0;

    @OOXIXo
    private Map<?, ?> map;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public SerializedMap(@OOXIXo Map<?, ?> map) {
        IIX0o.x0xO0oo(map, "map");
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@OOXIXo ObjectInput input) {
        IIX0o.x0xO0oo(input, "input");
        byte readByte = input.readByte();
        if (readByte == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                Map II0XooXoX2 = OI0.II0XooXoX(readInt);
                for (int i = 0; i < readInt; i++) {
                    II0XooXoX2.put(input.readObject(), input.readObject());
                }
                this.map = OI0.oxoX(II0XooXoX2);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte));
    }

    @Override // java.io.Externalizable
    public void writeExternal(@OOXIXo ObjectOutput output) {
        IIX0o.x0xO0oo(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public SerializedMap() {
        this(o0.O0xOxO());
    }
}
