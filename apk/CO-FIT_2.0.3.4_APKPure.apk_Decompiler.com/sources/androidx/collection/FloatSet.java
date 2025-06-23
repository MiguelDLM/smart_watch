package androidx.collection;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nFloatSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatSet.kt\nandroidx/collection/FloatSet\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 3 FloatSet.kt\nandroidx/collection/FloatSetKt\n*L\n1#1,853:1\n262#1,4:854\n232#1,7:858\n243#1,3:866\n246#1,2:870\n266#1,2:872\n249#1,6:874\n268#1:880\n262#1,4:881\n232#1,7:885\n243#1,3:893\n246#1,2:897\n266#1,2:899\n249#1,6:901\n268#1:907\n232#1,7:910\n243#1,3:918\n246#1,9:922\n262#1,4:931\n232#1,7:935\n243#1,3:943\n246#1,2:947\n266#1,2:949\n249#1,6:951\n268#1:957\n262#1,4:958\n232#1,7:962\n243#1,3:970\n246#1,2:974\n266#1,2:976\n249#1,6:978\n268#1:984\n262#1,4:985\n232#1,7:989\n243#1,3:997\n246#1,2:1001\n266#1,2:1003\n249#1,6:1005\n268#1:1011\n442#1:1012\n443#1:1016\n445#1,2:1018\n447#1,3:1021\n450#1:1027\n451#1:1031\n452#1:1033\n453#1,4:1036\n459#1:1041\n460#1,8:1043\n262#1,4:1051\n232#1,7:1055\n243#1,3:1063\n246#1,2:1067\n266#1,2:1069\n249#1,6:1071\n268#1:1077\n262#1,4:1078\n232#1,7:1082\n243#1,3:1090\n246#1,2:1094\n266#1,2:1096\n249#1,6:1098\n268#1:1104\n262#1,4:1105\n232#1,7:1109\n243#1,3:1117\n246#1,2:1121\n266#1,2:1123\n249#1,6:1125\n268#1:1131\n262#1,4:1132\n232#1,7:1136\n243#1,3:1144\n246#1,2:1148\n266#1,2:1150\n249#1,6:1152\n268#1:1158\n262#1,4:1159\n232#1,7:1163\n243#1,3:1171\n246#1,2:1175\n266#1,2:1177\n249#1,6:1179\n268#1:1185\n365#1,11:1202\n262#1,4:1213\n232#1,7:1217\n243#1,3:1225\n246#1,2:1229\n266#1:1231\n376#1,10:1232\n267#1:1242\n249#1,6:1243\n268#1:1249\n386#1,2:1250\n365#1,11:1252\n262#1,4:1263\n232#1,7:1267\n243#1,3:1275\n246#1,2:1279\n266#1:1281\n376#1,10:1282\n267#1:1292\n249#1,6:1293\n268#1:1299\n386#1,2:1300\n365#1,11:1302\n262#1,4:1313\n232#1,7:1317\n243#1,3:1325\n246#1,2:1329\n266#1:1331\n376#1,10:1332\n267#1:1342\n249#1,6:1343\n268#1:1349\n386#1,2:1350\n365#1,11:1352\n262#1,4:1363\n232#1,7:1367\n243#1,3:1375\n246#1,2:1379\n266#1:1381\n376#1,10:1382\n267#1:1392\n249#1,6:1393\n268#1:1399\n386#1,2:1400\n365#1,11:1402\n262#1,4:1413\n232#1,7:1417\n243#1,3:1425\n246#1,2:1429\n266#1:1431\n376#1,10:1432\n267#1:1442\n249#1,6:1443\n268#1:1449\n386#1,2:1450\n1826#2:865\n1688#2:869\n1826#2:892\n1688#2:896\n1826#2:908\n1688#2:909\n1826#2:917\n1688#2:921\n1826#2:942\n1688#2:946\n1826#2:969\n1688#2:973\n1826#2:996\n1688#2:1000\n1619#2:1017\n1615#2:1020\n1795#2,3:1024\n1809#2,3:1028\n1733#2:1032\n1721#2:1034\n1715#2:1035\n1728#2:1040\n1818#2:1042\n1826#2:1062\n1688#2:1066\n1826#2:1089\n1688#2:1093\n1826#2:1116\n1688#2:1120\n1826#2:1143\n1688#2:1147\n1826#2:1170\n1688#2:1174\n1619#2:1189\n1615#2:1190\n1795#2,3:1191\n1809#2,3:1194\n1733#2:1197\n1721#2:1198\n1715#2:1199\n1728#2:1200\n1818#2:1201\n1826#2:1224\n1688#2:1228\n1826#2:1274\n1688#2:1278\n1826#2:1324\n1688#2:1328\n1826#2:1374\n1688#2:1378\n1826#2:1424\n1688#2:1428\n849#3,3:1013\n849#3,3:1186\n*S KotlinDebug\n*F\n+ 1 FloatSet.kt\nandroidx/collection/FloatSet\n*L\n203#1:854,4\n203#1:858,7\n203#1:866,3\n203#1:870,2\n203#1:872,2\n203#1:874,6\n203#1:880\n222#1:881,4\n222#1:885,7\n222#1:893,3\n222#1:897,2\n222#1:899,2\n222#1:901,6\n222#1:907\n265#1:910,7\n265#1:918,3\n265#1:922,9\n277#1:931,4\n277#1:935,7\n277#1:943,3\n277#1:947,2\n277#1:949,2\n277#1:951,6\n277#1:957\n290#1:958,4\n290#1:962,7\n290#1:970,3\n290#1:974,2\n290#1:976,2\n290#1:978,6\n290#1:984\n311#1:985,4\n311#1:989,7\n311#1:997,3\n311#1:1001,2\n311#1:1003,2\n311#1:1005,6\n311#1:1011\n322#1:1012\n322#1:1016\n322#1:1018,2\n322#1:1021,3\n322#1:1027\n322#1:1031\n322#1:1033\n322#1:1036,4\n322#1:1041\n322#1:1043,8\n342#1:1051,4\n342#1:1055,7\n342#1:1063,3\n342#1:1067,2\n342#1:1069,2\n342#1:1071,6\n342#1:1077\n375#1:1078,4\n375#1:1082,7\n375#1:1090,3\n375#1:1094,2\n375#1:1096,2\n375#1:1098,6\n375#1:1104\n375#1:1105,4\n375#1:1109,7\n375#1:1117,3\n375#1:1121,2\n375#1:1123,2\n375#1:1125,6\n375#1:1131\n396#1:1132,4\n396#1:1136,7\n396#1:1144,3\n396#1:1148,2\n396#1:1150,2\n396#1:1152,6\n396#1:1158\n422#1:1159,4\n422#1:1163,7\n422#1:1171,3\n422#1:1175,2\n422#1:1177,2\n422#1:1179,6\n422#1:1185\n-1#1:1202,11\n-1#1:1213,4\n-1#1:1217,7\n-1#1:1225,3\n-1#1:1229,2\n-1#1:1231\n-1#1:1232,10\n-1#1:1242\n-1#1:1243,6\n-1#1:1249\n-1#1:1250,2\n-1#1:1252,11\n-1#1:1263,4\n-1#1:1267,7\n-1#1:1275,3\n-1#1:1279,2\n-1#1:1281\n-1#1:1282,10\n-1#1:1292\n-1#1:1293,6\n-1#1:1299\n-1#1:1300,2\n-1#1:1302,11\n-1#1:1313,4\n-1#1:1317,7\n-1#1:1325,3\n-1#1:1329,2\n-1#1:1331\n-1#1:1332,10\n-1#1:1342\n-1#1:1343,6\n-1#1:1349\n-1#1:1350,2\n-1#1:1352,11\n-1#1:1363,4\n-1#1:1367,7\n-1#1:1375,3\n-1#1:1379,2\n-1#1:1381\n-1#1:1382,10\n-1#1:1392\n-1#1:1393,6\n-1#1:1399\n-1#1:1400,2\n-1#1:1402,11\n-1#1:1413,4\n-1#1:1417,7\n-1#1:1425,3\n-1#1:1429,2\n-1#1:1431\n-1#1:1432,10\n-1#1:1442\n-1#1:1443,6\n-1#1:1449\n-1#1:1450,2\n203#1:865\n203#1:869\n222#1:892\n222#1:896\n238#1:908\n245#1:909\n265#1:917\n265#1:921\n277#1:942\n277#1:946\n290#1:969\n290#1:973\n311#1:996\n311#1:1000\n322#1:1017\n322#1:1020\n322#1:1024,3\n322#1:1028,3\n322#1:1032\n322#1:1034\n322#1:1035\n322#1:1040\n322#1:1042\n342#1:1062\n342#1:1066\n375#1:1089\n375#1:1093\n375#1:1116\n375#1:1120\n396#1:1143\n396#1:1147\n422#1:1170\n422#1:1174\n443#1:1189\n446#1:1190\n449#1:1191,3\n450#1:1194,3\n451#1:1197\n452#1:1198\n452#1:1199\n456#1:1200\n459#1:1201\n-1#1:1224\n-1#1:1228\n-1#1:1274\n-1#1:1278\n-1#1:1324\n-1#1:1328\n-1#1:1374\n-1#1:1378\n-1#1:1424\n-1#1:1428\n322#1:1013,3\n442#1:1186,3\n*E\n"})
public abstract class FloatSet {
    @XO
    public int _capacity;
    @XO
    public int _size;
    @XO
    @OOXIXo
    public float[] elements;
    @XO
    @OOXIXo
    public long[] metadata;

    public /* synthetic */ FloatSet(IIXOooo iIXOooo) {
        this();
    }

    @o0
    public static /* synthetic */ void getElements$annotations() {
    }

    @o0
    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(FloatSet floatSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            CharSequence charSequence5 = "";
            CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
            if ((i2 & 4) == 0) {
                charSequence5 = charSequence3;
            }
            int i3 = (i2 & 8) != 0 ? -1 : i;
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            return floatSet.joinToString(charSequence, charSequence6, charSequence5, i3, charSequence4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(@OOXIXo oOoXoXO<? super Float, Boolean> oooxoxo) {
        oOoXoXO<? super Float, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        float[] fArr = this.elements;
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
                    if ((255 & j) < 128 && !oooxoxo2.invoke(Float.valueOf(fArr[(i << 3) + i3])).booleanValue()) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0068, code lost:
        if (((r6 & ((~r6) << 6)) & -9187201950435737472L) == 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006a, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean contains(float r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = java.lang.Float.floatToIntBits(r17)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = 0
        L_0x0017:
            long[] r6 = r0.metadata
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L_0x0044:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L_0x0061
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            float[] r14 = r0.elements
            r14 = r14[r10]
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x005b
            goto L_0x006b
        L_0x005b:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L_0x0044
        L_0x0061:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x006f
            r10 = -1
        L_0x006b:
            if (r10 < 0) goto L_0x006e
            r4 = 1
        L_0x006e:
            return r4
        L_0x006f:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatSet.contains(float):boolean");
    }

    @IntRange(from = 0)
    public final int count() {
        return this._size;
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
            boolean r3 = r1 instanceof androidx.collection.FloatSet
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.FloatSet r1 = (androidx.collection.FloatSet) r1
            int r3 = r1._size
            int r5 = r0._size
            if (r3 == r5) goto L_0x0017
            return r4
        L_0x0017:
            float[] r3 = r0.elements
            long[] r5 = r0.metadata
            int r6 = r5.length
            int r6 = r6 + -2
            if (r6 < 0) goto L_0x005d
            r7 = 0
        L_0x0021:
            r8 = r5[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0058
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L_0x003b:
            if (r12 >= r10) goto L_0x0056
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.32E-322)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto L_0x0052
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r3[r13]
            boolean r13 = r1.contains(r13)
            if (r13 != 0) goto L_0x0052
            return r4
        L_0x0052:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L_0x003b
        L_0x0056:
            if (r10 != r11) goto L_0x005d
        L_0x0058:
            if (r7 == r6) goto L_0x005d
            int r7 = r7 + 1
            goto L_0x0021
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatSet.equals(java.lang.Object):boolean");
    }

    public final int findElementIndex$collection(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        int i = floatToIntBits ^ (floatToIntBits << 16);
        int i2 = i & 127;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-((long) i7)) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (this.elements[numberOfTrailingZeros] == f) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
    }

    public final float first() {
        float[] fArr = this.elements;
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
                            return fArr[(i << 3) + i3];
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
        throw new NoSuchElementException("The FloatSet is empty");
    }

    public final void forEach(@OOXIXo oOoXoXO<? super Float, oXIO0o0XI> oooxoxo) {
        oOoXoXO<? super Float, oXIO0o0XI> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "block");
        float[] fArr = this.elements;
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
                            oooxoxo2.invoke(Float.valueOf(fArr[(i << 3) + i3]));
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
        float[] fArr = this.elements;
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
                        if ((255 & j) < 128) {
                            i3 += Float.floatToIntBits(fArr[(i2 << 3) + i5]);
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
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null);
    }

    public final boolean none() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, 25, (Object) null);
    }

    private FloatSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = FloatSetKt.getEmptyFloatArray();
    }

    public final boolean any(@OOXIXo oOoXoXO<? super Float, Boolean> oooxoxo) {
        oOoXoXO<? super Float, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && oooxoxo2.invoke(Float.valueOf(fArr[(i << 3) + i3])).booleanValue()) {
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
    public final int count(@OOXIXo oOoXoXO<? super Float, Boolean> oooxoxo) {
        oOoXoXO<? super Float, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        float[] fArr = this.elements;
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
                        if ((255 & j) < 128 && oooxoxo2.invoke(Float.valueOf(fArr[(i2 << 3) + i5])).booleanValue()) {
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
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 30, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, 28, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public static /* synthetic */ String joinToString$default(FloatSet floatSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, oOoXoXO oooxoxo, int i2, Object obj) {
        FloatSet floatSet2 = floatSet;
        oOoXoXO oooxoxo2 = oooxoxo;
        if (obj == null) {
            String str = (i2 & 1) != 0 ? ", " : charSequence;
            CharSequence charSequence5 = "";
            CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
            if ((i2 & 4) == 0) {
                charSequence5 = charSequence3;
            }
            int i3 = (i2 & 8) != 0 ? -1 : i;
            String str2 = (i2 & 16) != 0 ? "..." : charSequence4;
            IIX0o.x0xO0oo(str, "separator");
            IIX0o.x0xO0oo(charSequence6, RequestParameters.PREFIX);
            IIX0o.x0xO0oo(charSequence5, "postfix");
            IIX0o.x0xO0oo(str2, "truncated");
            IIX0o.x0xO0oo(oooxoxo2, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence6);
            float[] fArr = floatSet2.elements;
            long[] jArr = floatSet2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i4 = 0;
                int i5 = 0;
                loop0:
                while (true) {
                    long j = jArr[i4];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i4 - length)) >>> 31);
                        for (int i8 = 0; i8 < i7; i8++) {
                            if ((j & 255) < 128) {
                                float f = fArr[(i4 << 3) + i8];
                                if (i5 == i3) {
                                    sb.append(str2);
                                    break loop0;
                                }
                                if (i5 != 0) {
                                    sb.append(str);
                                }
                                sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                                i5++;
                                i6 = 8;
                            }
                            j >>= i6;
                        }
                        if (i7 != i6) {
                            break;
                        }
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                }
            }
            sb.append(charSequence5);
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, 16, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4) {
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        IIX0o.x0xO0oo(charSequence5, "separator");
        IIX0o.x0xO0oo(charSequence6, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence7, "postfix");
        IIX0o.x0xO0oo(charSequence8, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i2 << 3) + i5];
                            if (i3 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(f);
                            i3++;
                        } else {
                            int i6 = i;
                        }
                        j >>= 8;
                    }
                    int i7 = i;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    int i8 = i;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence7);
        String sb22 = sb.toString();
        IIX0o.oO(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    public final float first(@OOXIXo oOoXoXO<? super Float, Boolean> oooxoxo) {
        oOoXoXO<? super Float, Boolean> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "predicate");
        float[] fArr = this.elements;
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
                            float f = fArr[(i << 3) + i3];
                            if (oooxoxo2.invoke(Float.valueOf(f)).booleanValue()) {
                                return f;
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
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4, @OOXIXo oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        oOoXoXO<? super Float, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(charSequence5, "separator");
        IIX0o.x0xO0oo(charSequence6, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence7, "postfix");
        IIX0o.x0xO0oo(charSequence8, "truncated");
        IIX0o.x0xO0oo(oooxoxo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i2 << 3) + i5];
                            if (i3 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                            i3++;
                        } else {
                            int i6 = i;
                        }
                        j >>= 8;
                        i5++;
                    }
                    int i7 = i;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    int i8 = i;
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

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        oOoXoXO<? super Float, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(charSequence4, "separator");
        IIX0o.x0xO0oo(charSequence5, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence6, "postfix");
        IIX0o.x0xO0oo(oooxoxo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        float[] fArr = this.elements;
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
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i2 << 3) + i6];
                            if (i3 == i) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                            i3++;
                            i4 = 8;
                        } else {
                            int i7 = i;
                        }
                        j >>= i4;
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
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence6);
        String sb22 = sb.toString();
        IIX0o.oO(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, @OOXIXo oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        oOoXoXO<? super Float, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(charSequence4, "separator");
        IIX0o.x0xO0oo(charSequence5, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence6, "postfix");
        IIX0o.x0xO0oo(oooxoxo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0:
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i << 3) + i4];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(charSequence6);
        String sb22 = sb.toString();
        IIX0o.oO(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        oOoXoXO<? super Float, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(charSequence3, "separator");
        IIX0o.x0xO0oo(charSequence4, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(oooxoxo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0:
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            float f = fArr[(i << 3) + i4];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence3);
                            }
                            sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append("");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        CharSequence charSequence2 = charSequence;
        oOoXoXO<? super Float, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(charSequence2, "separator");
        IIX0o.x0xO0oo(oooxoxo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0:
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i << 3) + i4];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append("");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        oOoXoXO<? super Float, ? extends CharSequence> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0:
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            float f = fArr[(i << 3) + i4];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(", ");
                            }
                            sb.append((CharSequence) oooxoxo2.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append("");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
