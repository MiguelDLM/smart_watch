package okio;

import XO0OX.x0XOIxOo;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;

    @OXOo.OOXIXo
    private static final AtomicReference<Segment>[] hashBuckets;

    @OXOo.OOXIXo
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;

    @OXOo.OOXIXo
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> firstRef() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (HASH_BUCKET_COUNT - 1))];
    }

    @x0XOIxOo
    public static final void recycle(@OXOo.OOXIXo Segment segment) {
        AtomicReference<Segment> firstRef;
        Segment segment2;
        Segment andSet;
        int i;
        IIX0o.x0xO0oo(segment, "segment");
        if (segment.next == null && segment.prev == null) {
            if (segment.shared || (andSet = (firstRef = INSTANCE.firstRef()).getAndSet((segment2 = LOCK))) == segment2) {
                return;
            }
            if (andSet != null) {
                i = andSet.limit;
            } else {
                i = 0;
            }
            if (i >= MAX_SIZE) {
                firstRef.set(andSet);
                return;
            }
            segment.next = andSet;
            segment.pos = 0;
            segment.limit = i + 8192;
            firstRef.set(segment);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final Segment take() {
        AtomicReference<Segment> firstRef = INSTANCE.firstRef();
        Segment segment = LOCK;
        Segment andSet = firstRef.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            firstRef.set(null);
            return new Segment();
        }
        firstRef.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final int getByteCount() {
        Segment segment = firstRef().get();
        if (segment == null) {
            return 0;
        }
        return segment.limit;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
