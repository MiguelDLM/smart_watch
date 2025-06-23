package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.AmbiguousColumnResolver;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oOXoIIIo;
import kotlin.collections.oX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,253:1\n1#2:254\n13579#3,2:255\n13644#3,3:257\n13644#3,2:260\n11335#3:262\n11670#3,2:263\n11672#3:267\n13646#3:268\n1855#4,2:265\n1726#4,3:269\n1549#4:272\n1620#4,3:273\n1855#4,2:278\n37#5,2:276\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n*L\n85#1:255,2\n87#1:257,3\n96#1:260,2\n118#1:262\n118#1:263,2\n118#1:267\n96#1:268\n120#1:265,2\n141#1:269,3\n151#1:272\n151#1:273,3\n188#1:278,2\n151#1:276,2\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class AmbiguousColumnResolver {

    @OXOo.OOXIXo
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* loaded from: classes.dex */
    public static final class Match {

        @OXOo.OOXIXo
        private final List<Integer> resultIndices;

        @OXOo.OOXIXo
        private final X0.oOoXoXO resultRange;

        public Match(@OXOo.OOXIXo X0.oOoXoXO resultRange, @OXOo.OOXIXo List<Integer> resultIndices) {
            IIX0o.x0xO0oo(resultRange, "resultRange");
            IIX0o.x0xO0oo(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        @OXOo.OOXIXo
        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        @OXOo.OOXIXo
        public final X0.oOoXoXO getResultRange() {
            return this.resultRange;
        }
    }

    /* loaded from: classes.dex */
    public static final class ResultColumn {
        private final int index;

        @OXOo.OOXIXo
        private final String name;

        public ResultColumn(@OXOo.OOXIXo String name, int i) {
            IIX0o.x0xO0oo(name, "name");
            this.name = name;
            this.index = i;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i2 & 2) != 0) {
                i = resultColumn.index;
            }
            return resultColumn.copy(str, i);
        }

        @OXOo.OOXIXo
        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        @OXOo.OOXIXo
        public final ResultColumn copy(@OXOo.OOXIXo String name, int i) {
            IIX0o.x0xO0oo(name, "name");
            return new ResultColumn(name, i);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return IIX0o.Oxx0IOOO(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        @OXOo.OOXIXo
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes.dex */
    public static final class Solution implements Comparable<Solution> {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        private static final Solution NO_SOLUTION = new Solution(CollectionsKt__CollectionsKt.ooXIXxIX(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;

        @OXOo.OOXIXo
        private final List<Match> matches;
        private final int overlaps;

        @XX({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,253:1\n1#2:254\n1774#3,3:255\n1855#3,2:258\n1777#3:260\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n*L\n232#1:255,3\n234#1:258,2\n232#1:260\n*E\n"})
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final Solution build(@OXOo.OOXIXo List<Match> matches) {
                IIX0o.x0xO0oo(matches, "matches");
                List<Match> list = matches;
                int i = 0;
                int i2 = 0;
                for (Match match : list) {
                    i2 += ((match.getResultRange().X0o0xo() - match.getResultRange().oxoX()) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list.iterator();
                if (it.hasNext()) {
                    int oxoX2 = ((Match) it.next()).getResultRange().oxoX();
                    while (it.hasNext()) {
                        int oxoX3 = ((Match) it.next()).getResultRange().oxoX();
                        if (oxoX2 > oxoX3) {
                            oxoX2 = oxoX3;
                        }
                    }
                    Iterator<T> it2 = list.iterator();
                    if (it2.hasNext()) {
                        int X0o0xo2 = ((Match) it2.next()).getResultRange().X0o0xo();
                        while (it2.hasNext()) {
                            int X0o0xo3 = ((Match) it2.next()).getResultRange().X0o0xo();
                            if (X0o0xo2 < X0o0xo3) {
                                X0o0xo2 = X0o0xo3;
                            }
                        }
                        Iterable oooxoxo = new X0.oOoXoXO(oxoX2, X0o0xo2);
                        if (!(oooxoxo instanceof Collection) || !((Collection) oooxoxo).isEmpty()) {
                            Iterator it3 = oooxoxo.iterator();
                            int i3 = 0;
                            while (it3.hasNext()) {
                                int nextInt = ((oOXoIIIo) it3).nextInt();
                                Iterator<T> it4 = list.iterator();
                                int i4 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    if (((Match) it4.next()).getResultRange().xxIXOIIO(nextInt)) {
                                        i4++;
                                    }
                                    if (i4 > 1) {
                                        i3++;
                                        if (i3 < 0) {
                                            CollectionsKt__CollectionsKt.oxxXoxO();
                                        }
                                    }
                                }
                            }
                            i = i3;
                        }
                        return new Solution(matches, i2, i);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }

            @OXOo.OOXIXo
            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(@OXOo.OOXIXo List<Match> matches, int i, int i2) {
            IIX0o.x0xO0oo(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i;
            this.overlaps = i2;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        @OXOo.OOXIXo
        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(@OXOo.OOXIXo Solution other) {
            IIX0o.x0xO0oo(other, "other");
            int oI0IIXIo2 = IIX0o.oI0IIXIo(this.overlaps, other.overlaps);
            return oI0IIXIo2 != 0 ? oI0IIXIo2 : IIX0o.oI0IIXIo(this.coverageOffset, other.coverageOffset);
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i, Oox.oOoXoXO<? super List<? extends T>, oXIO0o0XI> oooxoxo) {
        if (i == list.size()) {
            oooxoxo.invoke(CollectionsKt___CollectionsKt.oOo0o(list2));
            return;
        }
        Iterator<T> it = list.get(i).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i + 1, oooxoxo);
            kotlin.collections.OxI.xx0X0(list2);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i, oooxoxo);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, Oox.IXxxXO<? super Integer, ? super Integer, ? super List<ResultColumn>, oXIO0o0XI> iXxxXO) {
        int i = 0;
        int i2 = 0;
        for (String str : strArr) {
            i2 += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (i2 == i3) {
                iXxxXO.invoke(Integer.valueOf(i), Integer.valueOf(length), list.subList(i, length));
            }
            int i4 = i + 1;
            int i5 = length + 1;
            if (i5 > list.size()) {
                return;
            }
            i3 = (i3 - list.get(i).getName().hashCode()) + list.get(length).getName().hashCode();
            i = i4;
            length = i5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final int[][] resolve(@OXOo.OOXIXo String[] resultColumns, @OXOo.OOXIXo String[][] mappings) {
        IIX0o.x0xO0oo(resultColumns, "resultColumns");
        IIX0o.x0xO0oo(mappings, "mappings");
        int length = resultColumns.length;
        for (int i = 0; i < length; i++) {
            String str = resultColumns[i];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
                IIX0o.oO(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = str.toLowerCase(US);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            resultColumns[i] = lowerCase;
        }
        int length2 = mappings.length;
        for (int i2 = 0; i2 < length2; i2++) {
            int length3 = mappings[i2].length;
            for (int i3 = 0; i3 < length3; i3++) {
                String[] strArr = mappings[i2];
                String str2 = strArr[i3];
                Locale US2 = Locale.US;
                IIX0o.oO(US2, "US");
                String lowerCase2 = str2.toLowerCase(US2);
                IIX0o.oO(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr[i3] = lowerCase2;
            }
        }
        Set oxoX2 = oX.oxoX();
        for (String[] strArr2 : mappings) {
            kotlin.collections.OxI.xxIO(oxoX2, strArr2);
        }
        Set oIX0oI2 = oX.oIX0oI(oxoX2);
        List xxIXOIIO2 = kotlin.collections.oI0IIXIo.xxIXOIIO();
        int length4 = resultColumns.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length4) {
            String str3 = resultColumns[i4];
            int i6 = i5 + 1;
            if (oIX0oI2.contains(str3)) {
                xxIXOIIO2.add(new ResultColumn(str3, i5));
            }
            i4++;
            i5 = i6;
        }
        List<ResultColumn> oIX0oI3 = kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO2);
        int length5 = mappings.length;
        final ArrayList arrayList = new ArrayList(length5);
        for (int i7 = 0; i7 < length5; i7++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i8 = 0;
        final int i9 = 0;
        while (i8 < length6) {
            final String[] strArr3 = mappings[i8];
            int i10 = i9 + 1;
            INSTANCE.rabinKarpSearch(oIX0oI3, strArr3, new Oox.IXxxXO<Integer, Integer, List<? extends ResultColumn>, oXIO0o0XI>() { // from class: androidx.room.AmbiguousColumnResolver$resolve$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2, List<? extends AmbiguousColumnResolver.ResultColumn> list) {
                    invoke(num.intValue(), num2.intValue(), (List<AmbiguousColumnResolver.ResultColumn>) list);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(int i11, int i12, @OXOo.OOXIXo List<AmbiguousColumnResolver.ResultColumn> resultColumnsSublist) {
                    Object obj;
                    IIX0o.x0xO0oo(resultColumnsSublist, "resultColumnsSublist");
                    String[] strArr4 = strArr3;
                    ArrayList arrayList2 = new ArrayList(strArr4.length);
                    for (String str4 : strArr4) {
                        Iterator<T> it = resultColumnsSublist.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (IIX0o.Oxx0IOOO(str4, ((AmbiguousColumnResolver.ResultColumn) obj).component1())) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        AmbiguousColumnResolver.ResultColumn resultColumn = (AmbiguousColumnResolver.ResultColumn) obj;
                        if (resultColumn == null) {
                            return;
                        }
                        arrayList2.add(Integer.valueOf(resultColumn.getIndex()));
                    }
                    arrayList.get(i9).add(new AmbiguousColumnResolver.Match(new X0.oOoXoXO(i11, i12 - 1), arrayList2));
                }
            });
            if (((List) arrayList.get(i9)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                for (String str4 : strArr3) {
                    List xxIXOIIO3 = kotlin.collections.oI0IIXIo.xxIXOIIO();
                    for (ResultColumn resultColumn : oIX0oI3) {
                        if (IIX0o.Oxx0IOOO(str4, resultColumn.getName())) {
                            xxIXOIIO3.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List oIX0oI4 = kotlin.collections.oI0IIXIo.oIX0oI(xxIXOIIO3);
                    if (!oIX0oI4.isEmpty()) {
                        arrayList2.add(oIX0oI4);
                    } else {
                        throw new IllegalStateException(("Column " + str4 + " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new Oox.oOoXoXO<List<? extends Integer>, oXIO0o0XI>() { // from class: androidx.room.AmbiguousColumnResolver$resolve$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<? extends Integer> list) {
                        invoke2((List<Integer>) list);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo List<Integer> indices) {
                        IIX0o.x0xO0oo(indices, "indices");
                        List<Integer> list = indices;
                        Iterator<T> it = list.iterator();
                        if (it.hasNext()) {
                            int intValue = ((Number) it.next()).intValue();
                            while (it.hasNext()) {
                                int intValue2 = ((Number) it.next()).intValue();
                                if (intValue > intValue2) {
                                    intValue = intValue2;
                                }
                            }
                            Iterator<T> it2 = list.iterator();
                            if (it2.hasNext()) {
                                int intValue3 = ((Number) it2.next()).intValue();
                                while (it2.hasNext()) {
                                    int intValue4 = ((Number) it2.next()).intValue();
                                    if (intValue3 < intValue4) {
                                        intValue3 = intValue4;
                                    }
                                }
                                arrayList.get(i9).add(new AmbiguousColumnResolver.Match(new X0.oOoXoXO(intValue, intValue3), indices));
                                return;
                            }
                            throw new NoSuchElementException();
                        }
                        throw new NoSuchElementException();
                    }
                }, 6, null);
            }
            i8++;
            i9 = i10;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((List) it.next()).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new Oox.oOoXoXO<List<? extends Match>, oXIO0o0XI>() { // from class: androidx.room.AmbiguousColumnResolver$resolve$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<? extends AmbiguousColumnResolver.Match> list) {
                invoke2((List<AmbiguousColumnResolver.Match>) list);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo List<AmbiguousColumnResolver.Match> it2) {
                IIX0o.x0xO0oo(it2, "it");
                ?? build = AmbiguousColumnResolver.Solution.Companion.build(it2);
                if (build.compareTo(objectRef.element) < 0) {
                    objectRef.element = build;
                }
            }
        }, 6, null);
        List<Match> matches = ((Solution) objectRef.element).getMatches();
        ArrayList arrayList3 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(matches, 10));
        Iterator<T> it2 = matches.iterator();
        while (it2.hasNext()) {
            arrayList3.add(CollectionsKt___CollectionsKt.o0Oox0xox(((Match) it2.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0]);
    }
}
