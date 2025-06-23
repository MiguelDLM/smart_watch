package androidx.room;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import X0.oOoXoXO;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
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
import kotlin.collections.OxI;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.oOXoIIIo;
import kotlin.collections.oX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@XX({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,253:1\n1#2:254\n13579#3,2:255\n13644#3,3:257\n13644#3,2:260\n11335#3:262\n11670#3,2:263\n11672#3:267\n13646#3:268\n1855#4,2:265\n1726#4,3:269\n1549#4:272\n1620#4,3:273\n1855#4,2:278\n37#5,2:276\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver\n*L\n85#1:255,2\n87#1:257,3\n96#1:260,2\n118#1:262\n118#1:263,2\n118#1:267\n96#1:268\n120#1:265,2\n141#1:269,3\n151#1:272\n151#1:273,3\n188#1:278,2\n151#1:276,2\n*E\n"})
public final class AmbiguousColumnResolver {
    @OOXIXo
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    public static final class Match {
        @OOXIXo
        private final List<Integer> resultIndices;
        @OOXIXo
        private final oOoXoXO resultRange;

        public Match(@OOXIXo oOoXoXO oooxoxo, @OOXIXo List<Integer> list) {
            IIX0o.x0xO0oo(oooxoxo, "resultRange");
            IIX0o.x0xO0oo(list, "resultIndices");
            this.resultRange = oooxoxo;
            this.resultIndices = list;
        }

        @OOXIXo
        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        @OOXIXo
        public final oOoXoXO getResultRange() {
            return this.resultRange;
        }
    }

    public static final class ResultColumn {
        private final int index;
        @OOXIXo
        private final String name;

        public ResultColumn(@OOXIXo String str, int i) {
            IIX0o.x0xO0oo(str, "name");
            this.name = str;
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

        @OOXIXo
        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        @OOXIXo
        public final ResultColumn copy(@OOXIXo String str, int i) {
            IIX0o.x0xO0oo(str, "name");
            return new ResultColumn(str, i);
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

        @OOXIXo
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        @OOXIXo
        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    public static final class Solution implements Comparable<Solution> {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        /* access modifiers changed from: private */
        @OOXIXo
        public static final Solution NO_SOLUTION = new Solution(CollectionsKt__CollectionsKt.ooXIXxIX(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        @OOXIXo
        private final List<Match> matches;
        private final int overlaps;

        @XX({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,253:1\n1#2:254\n1774#3,3:255\n1855#3,2:258\n1777#3:260\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$Solution$Companion\n*L\n232#1:255,3\n234#1:258,2\n232#1:260\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Solution build(@OOXIXo List<Match> list) {
                IIX0o.x0xO0oo(list, "matches");
                Iterable<Match> iterable = list;
                int i = 0;
                int i2 = 0;
                for (Match match : iterable) {
                    i2 += ((match.getResultRange().X0o0xo() - match.getResultRange().oxoX()) + 1) - match.getResultIndices().size();
                }
                Iterator it = iterable.iterator();
                if (it.hasNext()) {
                    int oxoX2 = ((Match) it.next()).getResultRange().oxoX();
                    while (it.hasNext()) {
                        int oxoX3 = ((Match) it.next()).getResultRange().oxoX();
                        if (oxoX2 > oxoX3) {
                            oxoX2 = oxoX3;
                        }
                    }
                    Iterator it2 = iterable.iterator();
                    if (it2.hasNext()) {
                        int X0o0xo2 = ((Match) it2.next()).getResultRange().X0o0xo();
                        while (it2.hasNext()) {
                            int X0o0xo3 = ((Match) it2.next()).getResultRange().X0o0xo();
                            if (X0o0xo2 < X0o0xo3) {
                                X0o0xo2 = X0o0xo3;
                            }
                        }
                        oOoXoXO oooxoxo = new oOoXoXO(oxoX2, X0o0xo2);
                        if (!(oooxoxo instanceof Collection) || !((Collection) oooxoxo).isEmpty()) {
                            Iterator it3 = oooxoxo.iterator();
                            int i3 = 0;
                            while (it3.hasNext()) {
                                int nextInt = ((oOXoIIIo) it3).nextInt();
                                Iterator it4 = iterable.iterator();
                                int i4 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    if (((Match) it4.next()).getResultRange().xxIXOIIO(nextInt)) {
                                        i4++;
                                        continue;
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
                        return new Solution(list, i2, i);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }

            @OOXIXo
            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(@OOXIXo List<Match> list, int i, int i2) {
            IIX0o.x0xO0oo(list, "matches");
            this.matches = list;
            this.coverageOffset = i;
            this.overlaps = i2;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        @OOXIXo
        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        public int compareTo(@OOXIXo Solution solution) {
            IIX0o.x0xO0oo(solution, "other");
            int oI0IIXIo2 = IIX0o.oI0IIXIo(this.overlaps, solution.overlaps);
            if (oI0IIXIo2 != 0) {
                return oI0IIXIo2;
            }
            return IIX0o.oI0IIXIo(this.coverageOffset, solution.coverageOffset);
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i, Oox.oOoXoXO<? super List<? extends T>, oXIO0o0XI> oooxoxo) {
        if (i == list.size()) {
            oooxoxo.invoke(CollectionsKt___CollectionsKt.oOo0o(list2));
            return;
        }
        for (Object add : (Iterable) list.get(i)) {
            list2.add(add);
            INSTANCE.dfs(list, list2, i + 1, oooxoxo);
            OxI.xx0X0(list2);
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

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, IXxxXO<? super Integer, ? super Integer, ? super List<ResultColumn>, oXIO0o0XI> iXxxXO) {
        int i = 0;
        int i2 = 0;
        for (String hashCode : strArr) {
            i2 += hashCode.hashCode();
        }
        int length = strArr.length;
        int i3 = 0;
        for (ResultColumn name : list.subList(0, length)) {
            i3 += name.getName().hashCode();
        }
        while (true) {
            if (i2 == i3) {
                iXxxXO.invoke(Integer.valueOf(i), Integer.valueOf(length), list.subList(i, length));
            }
            int i4 = i + 1;
            int i5 = length + 1;
            if (i5 <= list.size()) {
                i3 = (i3 - list.get(i).getName().hashCode()) + list.get(length).getName().hashCode();
                i = i4;
                length = i5;
            } else {
                return;
            }
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final int[][] resolve(@OOXIXo String[] strArr, @OOXIXo String[][] strArr2) {
        String[] strArr3 = strArr;
        String[][] strArr4 = strArr2;
        IIX0o.x0xO0oo(strArr3, "resultColumns");
        IIX0o.x0xO0oo(strArr4, "mappings");
        int length = strArr3.length;
        for (int i = 0; i < length; i++) {
            String str = strArr3[i];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
                IIX0o.oO(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale locale = Locale.US;
            IIX0o.oO(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            IIX0o.oO(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            strArr3[i] = lowerCase;
        }
        int length2 = strArr4.length;
        for (int i2 = 0; i2 < length2; i2++) {
            int length3 = strArr4[i2].length;
            for (int i3 = 0; i3 < length3; i3++) {
                String[] strArr5 = strArr4[i2];
                String str2 = strArr5[i3];
                Locale locale2 = Locale.US;
                IIX0o.oO(locale2, "US");
                String lowerCase2 = str2.toLowerCase(locale2);
                IIX0o.oO(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr5[i3] = lowerCase2;
            }
        }
        Set oxoX2 = oX.oxoX();
        for (String[] xxIO2 : strArr4) {
            OxI.xxIO(oxoX2, xxIO2);
        }
        Set oIX0oI2 = oX.oIX0oI(oxoX2);
        List xxIXOIIO2 = oI0IIXIo.xxIXOIIO();
        int length4 = strArr3.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length4) {
            String str3 = strArr3[i4];
            int i6 = i5 + 1;
            if (oIX0oI2.contains(str3)) {
                xxIXOIIO2.add(new ResultColumn(str3, i5));
            }
            i4++;
            i5 = i6;
        }
        List<ResultColumn> oIX0oI3 = oI0IIXIo.oIX0oI(xxIXOIIO2);
        int length5 = strArr4.length;
        ArrayList<List> arrayList = new ArrayList<>(length5);
        for (int i7 = 0; i7 < length5; i7++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr4.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length6) {
            String[] strArr6 = strArr4[i8];
            int i10 = i9 + 1;
            INSTANCE.rabinKarpSearch(oIX0oI3, strArr6, new AmbiguousColumnResolver$resolve$1$1(strArr6, arrayList, i9));
            if (((List) arrayList.get(i9)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr6.length);
                int length7 = strArr6.length;
                int i11 = 0;
                while (i11 < length7) {
                    String str4 = strArr6[i11];
                    List xxIXOIIO3 = oI0IIXIo.xxIXOIIO();
                    for (ResultColumn resultColumn : oIX0oI3) {
                        if (IIX0o.Oxx0IOOO(str4, resultColumn.getName())) {
                            xxIXOIIO3.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List oIX0oI4 = oI0IIXIo.oIX0oI(xxIXOIIO3);
                    if (!oIX0oI4.isEmpty()) {
                        arrayList2.add(oIX0oI4);
                        i11++;
                    } else {
                        throw new IllegalStateException(("Column " + str4 + " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, arrayList2, (List) null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i9), 6, (Object) null);
            }
            i8++;
            i9 = i10;
        }
        if (!arrayList.isEmpty()) {
            for (List isEmpty : arrayList) {
                if (isEmpty.isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, (List) null, 0, new AmbiguousColumnResolver$resolve$4(objectRef), 6, (Object) null);
        Iterable<Match> matches = ((Solution) objectRef.element).getMatches();
        ArrayList arrayList3 = new ArrayList(OxxIIOOXO.xo0x(matches, 10));
        for (Match resultIndices : matches) {
            arrayList3.add(CollectionsKt___CollectionsKt.o0Oox0xox(resultIndices.getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }
}
