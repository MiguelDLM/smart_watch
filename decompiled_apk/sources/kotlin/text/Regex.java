package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oxxXoxO;
import kotlin.sequences.SequencesKt__SequencesKt;

@XX({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n22#2,3:398\n1#3:401\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n103#1:398,3\n*E\n"})
/* loaded from: classes6.dex */
public final class Regex implements Serializable {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.oOoXoXO
    private Set<? extends RegexOption> _options;

    @OXOo.OOXIXo
    private final Pattern nativePattern;

    /* loaded from: classes6.dex */
    public static final class Serialized implements Serializable {

        @OXOo.OOXIXo
        public static final oIX0oI Companion = new oIX0oI(null);
        private static final long serialVersionUID = 0;
        private final int flags;

        @OXOo.OOXIXo
        private final String pattern;

        /* loaded from: classes6.dex */
        public static final class oIX0oI {
            public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            public oIX0oI() {
            }
        }

        public Serialized(@OXOo.OOXIXo String pattern, int i) {
            IIX0o.x0xO0oo(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            IIX0o.oO(compile, "compile(...)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @OXOo.OOXIXo
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final String I0Io(@OXOo.OOXIXo String literal) {
            IIX0o.x0xO0oo(literal, "literal");
            String quote = Pattern.quote(literal);
            IIX0o.oO(quote, "quote(...)");
            return quote;
        }

        public final int II0xO0(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        @OXOo.OOXIXo
        public final Regex X0o0xo(@OXOo.OOXIXo String literal) {
            IIX0o.x0xO0oo(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }

        @OXOo.OOXIXo
        public final String oxoX(@OXOo.OOXIXo String literal) {
            IIX0o.x0xO0oo(literal, "literal");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            IIX0o.oO(quoteReplacement, "quoteReplacement(...)");
            return quoteReplacement;
        }

        public oIX0oI() {
        }
    }

    @o0
    public Regex(@OXOo.OOXIXo Pattern nativePattern) {
        IIX0o.x0xO0oo(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ x0XOIxOo find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ kotlin.sequences.ooOOo0oXI splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        IIX0o.oO(pattern, "pattern(...)");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@OXOo.OOXIXo CharSequence input) {
        IIX0o.x0xO0oo(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @OXOo.oOoXoXO
    public final x0XOIxOo find(@OXOo.OOXIXo CharSequence input, int i) {
        IIX0o.x0xO0oo(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        IIX0o.oO(matcher, "matcher(...)");
        return RegexKt.oIX0oI(matcher, i, input);
    }

    @OXOo.OOXIXo
    public final kotlin.sequences.ooOOo0oXI<x0XOIxOo> findAll(@OXOo.OOXIXo final CharSequence input, final int i) {
        IIX0o.x0xO0oo(input, "input");
        if (i >= 0 && i <= input.length()) {
            return SequencesKt__SequencesKt.ooOOo0oXI(new Oox.oIX0oI<x0XOIxOo>() { // from class: kotlin.text.Regex$findAll$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                @OXOo.oOoXoXO
                public final x0XOIxOo invoke() {
                    return Regex.this.find(input, i);
                }
            }, Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + input.length());
    }

    @OXOo.OOXIXo
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set == null) {
            final int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            IIX0o.ooOOo0oXI(allOf);
            kotlin.collections.OxI.IoIOOxIIo(allOf, new Oox.oOoXoXO<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(RegexOption regexOption) {
                    RegexOption regexOption2 = regexOption;
                    return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
                }
            });
            Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
            IIX0o.oO(unmodifiableSet, "unmodifiableSet(...)");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @OXOo.OOXIXo
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        IIX0o.oO(pattern, "pattern(...)");
        return pattern;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public final x0XOIxOo matchAt(@OXOo.OOXIXo CharSequence input, int i) {
        IIX0o.x0xO0oo(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i, input.length());
        if (region.lookingAt()) {
            IIX0o.ooOOo0oXI(region);
            return new MatcherMatchResult(region, input);
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final x0XOIxOo matchEntire(@OXOo.OOXIXo CharSequence input) {
        IIX0o.x0xO0oo(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        IIX0o.oO(matcher, "matcher(...)");
        return RegexKt.II0xO0(matcher, input);
    }

    public final boolean matches(@OXOo.OOXIXo CharSequence input) {
        IIX0o.x0xO0oo(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.7")
    public final boolean matchesAt(@OXOo.OOXIXo CharSequence input, int i) {
        IIX0o.x0xO0oo(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i, input.length()).lookingAt();
    }

    @OXOo.OOXIXo
    public final String replace(@OXOo.OOXIXo CharSequence input, @OXOo.OOXIXo String replacement) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        IIX0o.oO(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    @OXOo.OOXIXo
    public final String replaceFirst(@OXOo.OOXIXo CharSequence input, @OXOo.OOXIXo String replacement) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        IIX0o.oO(replaceFirst, "replaceFirst(...)");
        return replaceFirst;
    }

    @OXOo.OOXIXo
    public final List<String> split(@OXOo.OOXIXo CharSequence input, int i) {
        IIX0o.x0xO0oo(input, "input");
        StringsKt__StringsKt.ox0(i);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i != 1 && matcher.find()) {
            int i2 = 10;
            if (i > 0) {
                i2 = X0.IIXOooo.XI0IXoo(i, 10);
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = i - 1;
            int i4 = 0;
            do {
                arrayList.add(input.subSequence(i4, matcher.start()).toString());
                i4 = matcher.end();
                if (i3 >= 0 && arrayList.size() == i3) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i4, input.length()).toString());
            return arrayList;
        }
        return kotlin.collections.oI0IIXIo.OOXIXo(input.toString());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.6")
    public final kotlin.sequences.ooOOo0oXI<String> splitToSequence(@OXOo.OOXIXo CharSequence input, int i) {
        IIX0o.x0xO0oo(input, "input");
        StringsKt__StringsKt.ox0(i);
        return kotlin.sequences.IXxxXO.II0xO0(new Regex$splitToSequence$1(this, input, i, null));
    }

    @OXOo.OOXIXo
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @OXOo.OOXIXo
    public String toString() {
        String pattern = this.nativePattern.toString();
        IIX0o.oO(pattern, "toString(...)");
        return pattern;
    }

    @OXOo.OOXIXo
    public final String replace(@OXOo.OOXIXo CharSequence input, @OXOo.OOXIXo Oox.oOoXoXO<? super x0XOIxOo, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        x0XOIxOo find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i, find$default.II0XooXoX().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i = find$default.II0XooXoX().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(input, i, length);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(@OXOo.OOXIXo java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.IIX0o.oO(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(@OXOo.OOXIXo java.lang.String r2, @OXOo.OOXIXo kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            kotlin.text.Regex$oIX0oI r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.oIX0oI.oIX0oI(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(...)"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(@OXOo.OOXIXo java.lang.String r2, @OXOo.OOXIXo java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            kotlin.text.Regex$oIX0oI r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.RegexKt.X0o0xo(r3)
            int r3 = kotlin.text.Regex.oIX0oI.oIX0oI(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(...)"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
