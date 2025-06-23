package kotlin.reflect;

import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public interface KParameter extends II0xO0 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes6.dex */
    public static final class Kind {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind INSTANCE = new Kind("INSTANCE", 0);
        public static final Kind EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 1);
        public static final Kind VALUE = new Kind("VALUE", 2);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{INSTANCE, EXTENSION_RECEIVER, VALUE};
        }

        static {
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private Kind(String str, int i) {
        }

        @OXOo.OOXIXo
        public static kotlin.enums.oIX0oI<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @oxxXoxO(version = "1.1")
        public static /* synthetic */ void oIX0oI() {
        }
    }

    int I0Io();

    @OXOo.oOoXoXO
    String getName();

    @OXOo.OOXIXo
    Oxx0xo getType();

    @OXOo.OOXIXo
    Kind oIX0oI();

    boolean xoIox();

    boolean xxIXOIIO();
}
