package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.x0XOIxOo;

/* loaded from: classes6.dex */
public final class MatcherMatchResult implements x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oOoXoXO f29509I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CharSequence f29510II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Matcher f29511oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public List<String> f29512oxoX;

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.collections.II0xO0<String> {
        public oIX0oI() {
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        @OXOo.OOXIXo
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public String get(int i) {
            String group = MatcherMatchResult.this.II0xO0().group(i);
            if (group == null) {
                return "";
            }
            return group;
        }

        public /* bridge */ int X0o0xo(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return oIX0oI((String) obj);
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return MatcherMatchResult.this.II0xO0().groupCount() + 1;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return oxoX((String) obj);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return X0o0xo((String) obj);
        }

        public /* bridge */ boolean oIX0oI(String str) {
            return super.contains(str);
        }

        public /* bridge */ int oxoX(String str) {
            return super.indexOf(str);
        }
    }

    public MatcherMatchResult(@OXOo.OOXIXo Matcher matcher, @OXOo.OOXIXo CharSequence input) {
        IIX0o.x0xO0oo(matcher, "matcher");
        IIX0o.x0xO0oo(input, "input");
        this.f29511oIX0oI = matcher;
        this.f29510II0xO0 = input;
        this.f29509I0Io = new MatcherMatchResult$groups$1(this);
    }

    @Override // kotlin.text.x0XOIxOo
    @OXOo.OOXIXo
    public X0.oOoXoXO II0XooXoX() {
        return RegexKt.I0Io(II0xO0());
    }

    public final MatchResult II0xO0() {
        return this.f29511oIX0oI;
    }

    @Override // kotlin.text.x0XOIxOo
    @OXOo.OOXIXo
    public List<String> OOXIXo() {
        if (this.f29512oxoX == null) {
            this.f29512oxoX = new oIX0oI();
        }
        List<String> list = this.f29512oxoX;
        IIX0o.ooOOo0oXI(list);
        return list;
    }

    @Override // kotlin.text.x0XOIxOo
    @OXOo.OOXIXo
    public String getValue() {
        String group = II0xO0().group();
        IIX0o.oO(group, "group(...)");
        return group;
    }

    @Override // kotlin.text.x0XOIxOo
    @OXOo.oOoXoXO
    public x0XOIxOo next() {
        int i;
        int end = II0xO0().end();
        if (II0xO0().end() == II0xO0().start()) {
            i = 1;
        } else {
            i = 0;
        }
        int i2 = end + i;
        if (i2 <= this.f29510II0xO0.length()) {
            Matcher matcher = this.f29511oIX0oI.pattern().matcher(this.f29510II0xO0);
            IIX0o.oO(matcher, "matcher(...)");
            return RegexKt.oIX0oI(matcher, i2, this.f29510II0xO0);
        }
        return null;
    }

    @Override // kotlin.text.x0XOIxOo
    @OXOo.OOXIXo
    public oOoXoXO xoIox() {
        return this.f29509I0Io;
    }

    @Override // kotlin.text.x0XOIxOo
    @OXOo.OOXIXo
    public x0XOIxOo.II0xO0 xxIXOIIO() {
        return x0XOIxOo.oIX0oI.oIX0oI(this);
    }
}
