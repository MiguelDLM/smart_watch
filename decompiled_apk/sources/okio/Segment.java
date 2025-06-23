package okio;

import java.util.Arrays;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSegment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Segment.kt\nokio/Segment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* loaded from: classes6.dex */
public final class Segment {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final byte[] data;

    @XO0OX.XO
    public int limit;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public Segment next;

    @XO0OX.XO
    public boolean owner;

    @XO0OX.XO
    public int pos;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public Segment prev;

    @XO0OX.XO
    public boolean shared;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i;
        Segment segment = this.prev;
        if (segment != this) {
            IIX0o.ooOOo0oXI(segment);
            if (!segment.owner) {
                return;
            }
            int i2 = this.limit - this.pos;
            Segment segment2 = this.prev;
            IIX0o.ooOOo0oXI(segment2);
            int i3 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            IIX0o.ooOOo0oXI(segment3);
            if (segment3.shared) {
                i = 0;
            } else {
                Segment segment4 = this.prev;
                IIX0o.ooOOo0oXI(segment4);
                i = segment4.pos;
            }
            if (i2 > i3 + i) {
                return;
            }
            Segment segment5 = this.prev;
            IIX0o.ooOOo0oXI(segment5);
            writeTo(segment5, i2);
            pop();
            SegmentPool.recycle(this);
            return;
        }
        throw new IllegalStateException("cannot compact");
    }

    @OXOo.oOoXoXO
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        IIX0o.ooOOo0oXI(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        IIX0o.ooOOo0oXI(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @OXOo.OOXIXo
    public final Segment push(@OXOo.OOXIXo Segment segment) {
        IIX0o.x0xO0oo(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        IIX0o.ooOOo0oXI(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @OXOo.OOXIXo
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @OXOo.OOXIXo
    public final Segment split(int i) {
        Segment take;
        if (i > 0 && i <= this.limit - this.pos) {
            if (i >= 1024) {
                take = sharedCopy();
            } else {
                take = SegmentPool.take();
                byte[] bArr = this.data;
                byte[] bArr2 = take.data;
                int i2 = this.pos;
                ooOOo0oXI.xX0IIXIx0(bArr, bArr2, 0, i2, i2 + i, 2, null);
            }
            take.limit = take.pos + i;
            this.pos += i;
            Segment segment = this.prev;
            IIX0o.ooOOo0oXI(segment);
            segment.push(take);
            return take;
        }
        throw new IllegalArgumentException("byteCount out of range");
    }

    @OXOo.OOXIXo
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        IIX0o.oO(copyOf, "copyOf(this, size)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@OXOo.OOXIXo Segment sink, int i) {
        IIX0o.x0xO0oo(sink, "sink");
        if (sink.owner) {
            int i2 = sink.limit;
            if (i2 + i > 8192) {
                if (!sink.shared) {
                    int i3 = sink.pos;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = sink.data;
                        ooOOo0oXI.xX0IIXIx0(bArr, bArr, 0, i3, i2, 2, null);
                        sink.limit -= sink.pos;
                        sink.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = sink.data;
            int i4 = sink.limit;
            int i5 = this.pos;
            ooOOo0oXI.O00XxXI(bArr2, bArr3, i4, i5, i5 + i);
            sink.limit += i;
            this.pos += i;
            return;
        }
        throw new IllegalStateException("only owner can write");
    }

    public Segment(@OXOo.OOXIXo byte[] data, int i, int i2, boolean z, boolean z2) {
        IIX0o.x0xO0oo(data, "data");
        this.data = data;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
