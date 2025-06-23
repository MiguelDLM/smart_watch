package kotlin.text;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class RegexOption implements Oxx0IOOO {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ RegexOption[] $VALUES;
    public static final RegexOption CANON_EQ;
    public static final RegexOption COMMENTS;
    public static final RegexOption DOT_MATCHES_ALL;
    public static final RegexOption IGNORE_CASE;
    public static final RegexOption LITERAL;
    public static final RegexOption MULTILINE;
    public static final RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        int i = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, i, 0, 2, null);
        int i2 = 2;
        kotlin.jvm.internal.IIXOooo iIXOooo = null;
        int i3 = 0;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, i3, i2, iIXOooo);
        int i4 = 2;
        kotlin.jvm.internal.IIXOooo iIXOooo2 = null;
        int i5 = 0;
        LITERAL = new RegexOption("LITERAL", i, 16, i5, i4, iIXOooo2);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, i3, i2, iIXOooo);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, i5, i4, iIXOooo2);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, i3, i2, iIXOooo);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, i5, i4, iIXOooo2);
        RegexOption[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private RegexOption(String str, int i, int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    @Override // kotlin.text.Oxx0IOOO
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.Oxx0IOOO
    public int getValue() {
        return this.value;
    }

    public /* synthetic */ RegexOption(String str, int i, int i2, int i3, int i4, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }
}
