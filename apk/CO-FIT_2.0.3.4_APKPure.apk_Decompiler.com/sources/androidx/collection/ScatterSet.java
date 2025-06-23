package androidx.collection;

import OI0IXox.oIX0oI;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import androidx.collection.internal.ContainerHelpersKt;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.OxxIIOOXO;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlin.sequences.IXxxXO;

@XX({"SMAP\nScatterSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1100:1\n267#1,4:1101\n237#1,7:1105\n248#1,3:1113\n251#1,2:1117\n272#1,2:1119\n254#1,6:1121\n274#1:1127\n267#1,4:1128\n237#1,7:1132\n248#1,3:1140\n251#1,2:1144\n272#1,2:1146\n254#1,6:1148\n274#1:1154\n267#1,4:1155\n237#1,7:1159\n248#1,3:1167\n251#1,2:1171\n272#1,2:1173\n254#1,6:1175\n274#1:1181\n237#1,7:1184\n248#1,3:1192\n251#1,9:1196\n267#1,4:1205\n237#1,7:1209\n248#1,3:1217\n251#1,2:1221\n272#1,2:1223\n254#1,6:1225\n274#1:1231\n267#1,4:1232\n237#1,7:1236\n248#1,3:1244\n251#1,2:1248\n272#1,2:1250\n254#1,6:1252\n274#1:1258\n267#1,4:1259\n237#1,7:1263\n248#1,3:1271\n251#1,2:1275\n272#1,2:1277\n254#1,6:1279\n274#1:1285\n433#1:1286\n434#1:1290\n436#1,2:1292\n438#1,3:1295\n441#1:1301\n442#1:1305\n443#1:1307\n444#1,4:1310\n450#1:1315\n451#1,8:1317\n267#1,4:1325\n237#1,7:1329\n248#1,3:1337\n251#1,2:1341\n272#1,2:1343\n254#1,6:1345\n274#1:1351\n267#1,4:1352\n237#1,7:1356\n248#1,3:1364\n251#1,2:1368\n272#1,2:1370\n254#1,6:1372\n274#1:1378\n267#1,4:1379\n237#1,7:1383\n248#1,3:1391\n251#1,2:1395\n272#1,2:1397\n254#1,6:1399\n274#1:1405\n1826#2:1112\n1688#2:1116\n1826#2:1139\n1688#2:1143\n1826#2:1166\n1688#2:1170\n1826#2:1182\n1688#2:1183\n1826#2:1191\n1688#2:1195\n1826#2:1216\n1688#2:1220\n1826#2:1243\n1688#2:1247\n1826#2:1270\n1688#2:1274\n1605#2,3:1287\n1619#2:1291\n1615#2:1294\n1795#2,3:1298\n1809#2,3:1302\n1733#2:1306\n1721#2:1308\n1715#2:1309\n1728#2:1314\n1818#2:1316\n1826#2:1336\n1688#2:1340\n1826#2:1363\n1688#2:1367\n1826#2:1390\n1688#2:1394\n1605#2,3:1406\n1619#2:1409\n1615#2:1410\n1795#2,3:1411\n1809#2,3:1414\n1733#2:1417\n1721#2:1418\n1715#2:1419\n1728#2:1420\n1818#2:1421\n*S KotlinDebug\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSet\n*L\n201#1:1101,4\n201#1:1105,7\n201#1:1113,3\n201#1:1117,2\n201#1:1119,2\n201#1:1121,6\n201#1:1127\n214#1:1128,4\n214#1:1132,7\n214#1:1140,3\n214#1:1144,2\n214#1:1146,2\n214#1:1148,6\n214#1:1154\n227#1:1155,4\n227#1:1159,7\n227#1:1167,3\n227#1:1171,2\n227#1:1173,2\n227#1:1175,6\n227#1:1181\n270#1:1184,7\n270#1:1192,3\n270#1:1196,9\n284#1:1205,4\n284#1:1209,7\n284#1:1217,3\n284#1:1221,2\n284#1:1223,2\n284#1:1225,6\n284#1:1231\n297#1:1232,4\n297#1:1236,7\n297#1:1244,3\n297#1:1248,2\n297#1:1250,2\n297#1:1252,6\n297#1:1258\n318#1:1259,4\n318#1:1263,7\n318#1:1271,3\n318#1:1275,2\n318#1:1277,2\n318#1:1279,6\n318#1:1285\n329#1:1286\n329#1:1290\n329#1:1292,2\n329#1:1295,3\n329#1:1301\n329#1:1305\n329#1:1307\n329#1:1310,4\n329#1:1315\n329#1:1317,8\n352#1:1325,4\n352#1:1329,7\n352#1:1337,3\n352#1:1341,2\n352#1:1343,2\n352#1:1345,6\n352#1:1351\n378#1:1352,4\n378#1:1356,7\n378#1:1364,3\n378#1:1368,2\n378#1:1370,2\n378#1:1372,6\n378#1:1378\n407#1:1379,4\n407#1:1383,7\n407#1:1391,3\n407#1:1395,2\n407#1:1397,2\n407#1:1399,6\n407#1:1405\n201#1:1112\n201#1:1116\n214#1:1139\n214#1:1143\n227#1:1166\n227#1:1170\n243#1:1182\n250#1:1183\n270#1:1191\n270#1:1195\n284#1:1216\n284#1:1220\n297#1:1243\n297#1:1247\n318#1:1270\n318#1:1274\n329#1:1287,3\n329#1:1291\n329#1:1294\n329#1:1298,3\n329#1:1302,3\n329#1:1306\n329#1:1308\n329#1:1309\n329#1:1314\n329#1:1316\n352#1:1336\n352#1:1340\n378#1:1363\n378#1:1367\n407#1:1390\n407#1:1394\n433#1:1406,3\n434#1:1409\n437#1:1410\n440#1:1411,3\n441#1:1414,3\n442#1:1417\n443#1:1418\n443#1:1419\n447#1:1420\n450#1:1421\n*E\n"})
public abstract class ScatterSet<E> {
    @XO
    public int _capacity;
    @XO
    public int _size;
    @XO
    @OOXIXo
    public Object[] elements;
    @XO
    @OOXIXo
    public long[] metadata;

    @XX({"SMAP\nScatterSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSet$SetWrapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1100:1\n1855#2,2:1101\n*S KotlinDebug\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSet$SetWrapper\n*L\n478#1:1101,2\n*E\n"})
    public class SetWrapper implements Set<E>, oIX0oI {
        public SetWrapper() {
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(Object obj) {
            return ScatterSet.this.contains(obj);
        }

        public boolean containsAll(@OOXIXo Collection<? extends Object> collection) {
            IIX0o.x0xO0oo(collection, "elements");
            ScatterSet<E> scatterSet = ScatterSet.this;
            for (Object contains : collection) {
                if (!scatterSet.contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public int getSize() {
            return ScatterSet.this._size;
        }

        public boolean isEmpty() {
            return ScatterSet.this.isEmpty();
        }

        @OOXIXo
        public Iterator<E> iterator() {
            return IXxxXO.oIX0oI(new ScatterSet$SetWrapper$iterator$1(ScatterSet.this, (I0Io<? super ScatterSet$SetWrapper$iterator$1>) null));
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public Object[] toArray() {
            return OxxIIOOXO.oIX0oI(this);
        }

        public <T> T[] toArray(T[] tArr) {
            IIX0o.x0xO0oo(tArr, "array");
            return OxxIIOOXO.II0xO0(this, tArr);
        }
    }

    public /* synthetic */ ScatterSet(IIXOooo iIXOooo) {
        this();
    }

    @o0
    public static /* synthetic */ void getElements$annotations() {
    }

    @o0
    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ScatterSet scatterSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            CharSequence charSequence6 = "";
            if ((i2 & 2) != 0) {
                charSequence5 = charSequence6;
            } else {
                charSequence5 = charSequence2;
            }
            if ((i2 & 4) == 0) {
                charSequence6 = charSequence3;
            }
            if ((i2 & 8) != 0) {
                i3 = -1;
            } else {
                i3 = i;
            }
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            CharSequence charSequence7 = charSequence4;
            if ((i2 & 32) != 0) {
                oooxoxo = null;
            }
            return scatterSet.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        oOoXoXO<? super E, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && !oooxoxo2.invoke(objArr[(i << 3) + i3]).booleanValue()) {
                        return false;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    @OOXIXo
    public final Set<E> asSet() {
        return new SetWrapper();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0070, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0072, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean contains(E r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto L_0x000c
            int r3 = r18.hashCode()
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = 0
        L_0x001d:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x004a:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x0069
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.elements
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r15, r1)
            if (r15 == 0) goto L_0x0063
            goto L_0x0073
        L_0x0063:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x004a
        L_0x0069:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 == 0) goto L_0x0077
            r11 = -1
        L_0x0073:
            if (r11 < 0) goto L_0x0076
            r2 = 1
        L_0x0076:
            return r2
        L_0x0077:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.contains(java.lang.Object):boolean");
    }

    @IntRange(from = 0)
    public final int count() {
        return getSize();
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@OXOo.oOoXoXO java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof androidx.collection.ScatterSet
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            int r3 = r1.getSize()
            int r5 = r18.getSize()
            if (r3 == r5) goto L_0x001b
            return r4
        L_0x001b:
            java.lang.Object[] r3 = r0.elements
            long[] r5 = r0.metadata
            int r6 = r5.length
            int r6 = r6 + -2
            if (r6 < 0) goto L_0x0061
            r7 = 0
        L_0x0025:
            r8 = r5[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x005c
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L_0x003f:
            if (r12 >= r10) goto L_0x005a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.32E-322)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto L_0x0056
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r3[r13]
            boolean r13 = r1.contains(r13)
            if (r13 != 0) goto L_0x0056
            return r4
        L_0x0056:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L_0x003f
        L_0x005a:
            if (r10 != r11) goto L_0x0061
        L_0x005c:
            if (r7 == r6) goto L_0x0061
            int r7 = r7 + 1
            goto L_0x0025
        L_0x0061:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.equals(java.lang.Object):boolean");
    }

    public final int findElementIndex$collection(E e) {
        int i;
        int i2 = 0;
        if (e != null) {
            i = e.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * ScatterMapKt.MurmurHashC1;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 & 127;
        int i6 = this._capacity;
        int i7 = i4 >>> 7;
        while (true) {
            int i8 = i7 & i6;
            long[] jArr = this.metadata;
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-((long) i10)) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (((long) i5) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i8) & i6;
                if (IIX0o.Oxx0IOOO(this.elements[numberOfTrailingZeros], e)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i2 += 8;
            i7 = i8 + i2;
        }
    }

    public final E first() {
        E[] eArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            return eArr[(i << 3) + i3];
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        throw new NoSuchElementException("The ScatterSet is empty");
    }

    @OXOo.oOoXoXO
    public final E firstOrNull(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        oOoXoXO<? super E, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        E[] eArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        E e = eArr[(i << 3) + i3];
                        if (oooxoxo2.invoke(e).booleanValue()) {
                            return e;
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return null;
                }
            }
            if (i == length) {
                return null;
            }
            i++;
        }
    }

    public final void forEach(@OOXIXo oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        oOoXoXO<? super E, oXIO0o0XI> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "block");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            oooxoxo2.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @o0
    public final void forEachIndex(@OOXIXo oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            oooxoxo.invoke(Integer.valueOf((i << 3) + i3));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @IntRange(from = 0)
    public final int getCapacity() {
        return this._capacity;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i;
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i2 = 0;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i3 << 3) + i6];
                            if (obj != null) {
                                i = obj.hashCode();
                            } else {
                                i = 0;
                            }
                            i4 += i;
                        }
                        j >>= 8;
                    }
                    if (i5 != 8) {
                        return i4;
                    }
                }
                if (i3 == length) {
                    i2 = i4;
                    break;
                }
                i3++;
            }
        }
        return i2;
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    @xoIox
    @OOXIXo
    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 63, (Object) null);
    }

    public final boolean none() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, new ScatterSet$toString$1(this), 25, (Object) null);
    }

    private ScatterSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public final boolean any(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        oOoXoXO<? super E, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && oooxoxo2.invoke(objArr[(i << 3) + i3]).booleanValue()) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    @IntRange(from = 0)
    public final int count(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        oOoXoXO<? super E, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128 && oooxoxo2.invoke(objArr[(i2 << 3) + i5]).booleanValue()) {
                            i3++;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 62, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 60, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, (oOoXoXO) null, 56, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, (oOoXoXO) null, 48, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        IIX0o.x0xO0oo(charSequence4, "truncated");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, charSequence4, (oOoXoXO) null, 32, (Object) null);
    }

    public final E first(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        oOoXoXO<? super E, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        E[] eArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            E e = eArr[(i << 3) + i3];
                            if (oooxoxo2.invoke(e).booleanValue()) {
                                return e;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        throw new NoSuchElementException("Could not find a match");
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4, @OXOo.oOoXoXO oOoXoXO<? super E, ? extends CharSequence> oooxoxo) {
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        oOoXoXO<? super E, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(charSequence5, "separator");
        IIX0o.x0xO0oo(charSequence6, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence7, "postfix");
        IIX0o.x0xO0oo(charSequence8, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i2 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            Object obj = objArr[(i2 << 3) + i6];
                            if (i3 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence5);
                            }
                            if (oooxoxo2 == null) {
                                sb.append(obj);
                            } else {
                                sb.append((CharSequence) oooxoxo2.invoke(obj));
                            }
                            i3++;
                            i4 = 8;
                        } else {
                            int i7 = i;
                        }
                        j >>= i4;
                        i6++;
                    }
                    int i8 = i;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    int i9 = i;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
