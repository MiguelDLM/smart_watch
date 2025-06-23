package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes6.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<OOXIXo> implements ooOOo0oXI {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f29513XO;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f29513XO = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof OOXIXo;
        }
        if (!z) {
            return false;
        }
        return oIX0oI((OOXIXo) obj);
    }

    @Override // kotlin.text.oOoXoXO
    @OXOo.oOoXoXO
    public OOXIXo get(int i) {
        X0.oOoXoXO xoIox2;
        xoIox2 = RegexKt.xoIox(this.f29513XO.II0xO0(), i);
        if (xoIox2.getStart().intValue() < 0) {
            return null;
        }
        String group = this.f29513XO.II0xO0().group(i);
        IIX0o.oO(group, "group(...)");
        return new OOXIXo(group, xoIox2);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f29513XO.II0xO0().groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<OOXIXo> iterator() {
        return SequencesKt___SequencesKt.X0xxXX0(CollectionsKt___CollectionsKt.OooI(CollectionsKt__CollectionsKt.xI(this)), new Oox.oOoXoXO<Integer, OOXIXo>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ OOXIXo invoke(Integer num) {
                return invoke(num.intValue());
            }

            @OXOo.oOoXoXO
            public final OOXIXo invoke(int i) {
                return MatcherMatchResult$groups$1.this.get(i);
            }
        }).iterator();
    }

    public /* bridge */ boolean oIX0oI(OOXIXo oOXIXo) {
        return super.contains(oOXIXo);
    }

    @Override // kotlin.text.ooOOo0oXI
    @OXOo.oOoXoXO
    public OOXIXo get(@OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        return xx0o0O.ooOOo0oXI.f35291oIX0oI.I0Io(this.f29513XO.II0xO0(), name);
    }
}
