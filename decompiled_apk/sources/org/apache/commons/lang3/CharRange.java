package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    /* loaded from: classes6.dex */
    public static class II0xO0 implements Iterator<Character> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f32463IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final CharRange f32464Oo;

        /* renamed from: XO, reason: collision with root package name */
        public char f32465XO;

        public final void II0xO0() {
            if (this.f32464Oo.negated) {
                char c = this.f32465XO;
                if (c == 65535) {
                    this.f32463IXxxXO = false;
                    return;
                }
                if (c + 1 == this.f32464Oo.start) {
                    if (this.f32464Oo.end == 65535) {
                        this.f32463IXxxXO = false;
                        return;
                    } else {
                        this.f32465XO = (char) (this.f32464Oo.end + 1);
                        return;
                    }
                }
                this.f32465XO = (char) (this.f32465XO + 1);
                return;
            }
            if (this.f32465XO < this.f32464Oo.end) {
                this.f32465XO = (char) (this.f32465XO + 1);
            } else {
                this.f32463IXxxXO = false;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f32463IXxxXO;
        }

        @Override // java.util.Iterator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Character next() {
            if (this.f32463IXxxXO) {
                char c = this.f32465XO;
                II0xO0();
                return Character.valueOf(c);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public II0xO0(CharRange charRange) {
            this.f32464Oo = charRange;
            this.f32463IXxxXO = true;
            if (charRange.negated) {
                if (charRange.start == 0) {
                    if (charRange.end != 65535) {
                        this.f32465XO = (char) (charRange.end + 1);
                        return;
                    } else {
                        this.f32463IXxxXO = false;
                        return;
                    }
                }
                this.f32465XO = (char) 0;
                return;
            }
            this.f32465XO = charRange.start;
        }
    }

    private CharRange(char c, char c2, boolean z) {
        if (c > c2) {
            c2 = c;
            c = c2;
        }
        this.start = c;
        this.end = c2;
        this.negated = z;
    }

    public static CharRange is(char c) {
        return new CharRange(c, c, false);
    }

    public static CharRange isIn(char c, char c2) {
        return new CharRange(c, c2, false);
    }

    public static CharRange isNot(char c) {
        return new CharRange(c, c, true);
    }

    public static CharRange isNotIn(char c, char c2) {
        return new CharRange(c, c2, true);
    }

    public boolean contains(char c) {
        return (c >= this.start && c <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        if (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated) {
            return true;
        }
        return false;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new II0xO0();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb = new StringBuilder(4);
            if (isNegated()) {
                sb.append('^');
            }
            sb.append(this.start);
            if (this.start != this.end) {
                sb.append('-');
                sb.append(this.end);
            }
            this.iToString = sb.toString();
        }
        return this.iToString;
    }

    public boolean contains(CharRange charRange) {
        xoIxX.xo0x(charRange, "The Range must not be null", new Object[0]);
        return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
    }
}
