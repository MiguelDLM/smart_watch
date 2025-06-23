package androidx.collection;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.collection.internal.ContainerHelpersKt;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nIntObjectMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n+ 2 IntSet.kt\nandroidx/collection/IntSetKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1034:1\n619#1:1035\n620#1:1039\n622#1,2:1041\n624#1,4:1044\n628#1:1051\n629#1:1055\n630#1:1057\n631#1,4:1060\n637#1:1065\n638#1,8:1067\n619#1:1075\n620#1:1079\n622#1,2:1081\n624#1,4:1084\n628#1:1091\n629#1:1095\n630#1:1097\n631#1,4:1100\n637#1:1105\n638#1,8:1107\n354#1,6:1117\n364#1,3:1124\n367#1,9:1128\n354#1,6:1137\n364#1,3:1144\n367#1,9:1148\n354#1,6:1157\n364#1,3:1164\n367#1,9:1168\n382#1,4:1177\n354#1,6:1181\n364#1,3:1188\n367#1,2:1192\n387#1,2:1194\n370#1,6:1196\n389#1:1202\n382#1,4:1203\n354#1,6:1207\n364#1,3:1214\n367#1,2:1218\n387#1,2:1220\n370#1,6:1222\n389#1:1228\n382#1,4:1229\n354#1,6:1233\n364#1,3:1240\n367#1,2:1244\n387#1,2:1246\n370#1,6:1248\n389#1:1254\n619#1:1255\n620#1:1259\n622#1,2:1261\n624#1,4:1264\n628#1:1271\n629#1:1275\n630#1:1277\n631#1,4:1280\n637#1:1285\n638#1,8:1287\n619#1:1295\n620#1:1299\n622#1,2:1301\n624#1,4:1304\n628#1:1311\n629#1:1315\n630#1:1317\n631#1,4:1320\n637#1:1325\n638#1,8:1327\n408#1,3:1335\n354#1,6:1338\n364#1,3:1345\n367#1,2:1349\n412#1,2:1351\n370#1,6:1353\n414#1:1359\n382#1,4:1360\n354#1,6:1364\n364#1,3:1371\n367#1,2:1375\n387#1,2:1377\n370#1,6:1379\n389#1:1385\n382#1,4:1386\n354#1,6:1390\n364#1,3:1397\n367#1,2:1401\n387#1,2:1403\n370#1,6:1405\n389#1:1411\n382#1,4:1412\n354#1,6:1416\n364#1,3:1423\n367#1,2:1427\n387#1,2:1429\n370#1,6:1431\n389#1:1437\n382#1,4:1438\n354#1,6:1442\n364#1,3:1449\n367#1,2:1453\n387#1,2:1455\n370#1,6:1457\n389#1:1463\n382#1,4:1464\n354#1,6:1468\n364#1,3:1475\n367#1,2:1479\n387#1,2:1481\n370#1,6:1483\n389#1:1489\n382#1,4:1490\n354#1,6:1494\n364#1,3:1501\n367#1,2:1505\n387#1,2:1507\n370#1,6:1509\n389#1:1515\n518#1,11:1532\n382#1,4:1543\n354#1,6:1547\n364#1,3:1554\n367#1,2:1558\n387#1:1560\n529#1,10:1561\n388#1:1571\n370#1,6:1572\n389#1:1578\n539#1,2:1579\n518#1,11:1581\n382#1,4:1592\n354#1,6:1596\n364#1,3:1603\n367#1,2:1607\n387#1:1609\n529#1,10:1610\n388#1:1620\n370#1,6:1621\n389#1:1627\n539#1,2:1628\n518#1,11:1630\n382#1,4:1641\n354#1,6:1645\n364#1,3:1652\n367#1,2:1656\n387#1:1658\n529#1,10:1659\n388#1:1669\n370#1,6:1670\n389#1:1676\n539#1,2:1677\n518#1,11:1679\n382#1,4:1690\n354#1,6:1694\n364#1,3:1701\n367#1,2:1705\n387#1:1707\n529#1,10:1708\n388#1:1718\n370#1,6:1719\n389#1:1725\n539#1,2:1726\n518#1,11:1728\n382#1,4:1739\n354#1,6:1743\n364#1,3:1750\n367#1,2:1754\n387#1:1756\n529#1,10:1757\n388#1:1767\n370#1,6:1768\n389#1:1774\n539#1,2:1775\n849#2,3:1036\n849#2,3:1076\n849#2,3:1256\n849#2,3:1296\n849#2,3:1516\n1619#3:1040\n1615#3:1043\n1795#3,3:1048\n1809#3,3:1052\n1733#3:1056\n1721#3:1058\n1715#3:1059\n1728#3:1064\n1818#3:1066\n1619#3:1080\n1615#3:1083\n1795#3,3:1088\n1809#3,3:1092\n1733#3:1096\n1721#3:1098\n1715#3:1099\n1728#3:1104\n1818#3:1106\n1826#3:1115\n1688#3:1116\n1826#3:1123\n1688#3:1127\n1826#3:1143\n1688#3:1147\n1826#3:1163\n1688#3:1167\n1826#3:1187\n1688#3:1191\n1826#3:1213\n1688#3:1217\n1826#3:1239\n1688#3:1243\n1619#3:1260\n1615#3:1263\n1795#3,3:1268\n1809#3,3:1272\n1733#3:1276\n1721#3:1278\n1715#3:1279\n1728#3:1284\n1818#3:1286\n1619#3:1300\n1615#3:1303\n1795#3,3:1308\n1809#3,3:1312\n1733#3:1316\n1721#3:1318\n1715#3:1319\n1728#3:1324\n1818#3:1326\n1826#3:1344\n1688#3:1348\n1826#3:1370\n1688#3:1374\n1826#3:1396\n1688#3:1400\n1826#3:1422\n1688#3:1426\n1826#3:1448\n1688#3:1452\n1826#3:1474\n1688#3:1478\n1826#3:1500\n1688#3:1504\n1619#3:1519\n1615#3:1520\n1795#3,3:1521\n1809#3,3:1524\n1733#3:1527\n1721#3:1528\n1715#3:1529\n1728#3:1530\n1818#3:1531\n1826#3:1553\n1688#3:1557\n1826#3:1602\n1688#3:1606\n1826#3:1651\n1688#3:1655\n1826#3:1700\n1688#3:1704\n1826#3:1749\n1688#3:1753\n*S KotlinDebug\n*F\n+ 1 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n*L\n321#1:1035\n321#1:1039\n321#1:1041,2\n321#1:1044,4\n321#1:1051\n321#1:1055\n321#1:1057\n321#1:1060,4\n321#1:1065\n321#1:1067,8\n331#1:1075\n331#1:1079\n331#1:1081,2\n331#1:1084,4\n331#1:1091\n331#1:1095\n331#1:1097\n331#1:1100,4\n331#1:1105\n331#1:1107,8\n385#1:1117,6\n385#1:1124,3\n385#1:1128,9\n398#1:1137,6\n398#1:1144,3\n398#1:1148,9\n410#1:1157,6\n410#1:1164,3\n410#1:1168,9\n420#1:1177,4\n420#1:1181,6\n420#1:1188,3\n420#1:1192,2\n420#1:1194,2\n420#1:1196,6\n420#1:1202\n430#1:1203,4\n430#1:1207,6\n430#1:1214,3\n430#1:1218,2\n430#1:1220,2\n430#1:1222,6\n430#1:1228\n446#1:1229,4\n446#1:1233,6\n446#1:1240,3\n446#1:1244,2\n446#1:1246,2\n446#1:1248,6\n446#1:1254\n456#1:1255\n456#1:1259\n456#1:1261,2\n456#1:1264,4\n456#1:1271\n456#1:1275\n456#1:1277\n456#1:1280,4\n456#1:1285\n456#1:1287,8\n462#1:1295\n462#1:1299\n462#1:1301,2\n462#1:1304,4\n462#1:1311\n462#1:1315\n462#1:1317\n462#1:1320,4\n462#1:1325\n462#1:1327,8\n469#1:1335,3\n469#1:1338,6\n469#1:1345,3\n469#1:1349,2\n469#1:1351,2\n469#1:1353,6\n469#1:1359\n493#1:1360,4\n493#1:1364,6\n493#1:1371,3\n493#1:1375,2\n493#1:1377,2\n493#1:1379,6\n493#1:1385\n528#1:1386,4\n528#1:1390,6\n528#1:1397,3\n528#1:1401,2\n528#1:1403,2\n528#1:1405,6\n528#1:1411\n528#1:1412,4\n528#1:1416,6\n528#1:1423,3\n528#1:1427,2\n528#1:1429,2\n528#1:1431,6\n528#1:1437\n549#1:1438,4\n549#1:1442,6\n549#1:1449,3\n549#1:1453,2\n549#1:1455,2\n549#1:1457,6\n549#1:1463\n575#1:1464,4\n575#1:1468,6\n575#1:1475,3\n575#1:1479,2\n575#1:1481,2\n575#1:1483,6\n575#1:1489\n601#1:1490,4\n601#1:1494,6\n601#1:1501,3\n601#1:1505,2\n601#1:1507,2\n601#1:1509,6\n601#1:1515\n-1#1:1532,11\n-1#1:1543,4\n-1#1:1547,6\n-1#1:1554,3\n-1#1:1558,2\n-1#1:1560\n-1#1:1561,10\n-1#1:1571\n-1#1:1572,6\n-1#1:1578\n-1#1:1579,2\n-1#1:1581,11\n-1#1:1592,4\n-1#1:1596,6\n-1#1:1603,3\n-1#1:1607,2\n-1#1:1609\n-1#1:1610,10\n-1#1:1620\n-1#1:1621,6\n-1#1:1627\n-1#1:1628,2\n-1#1:1630,11\n-1#1:1641,4\n-1#1:1645,6\n-1#1:1652,3\n-1#1:1656,2\n-1#1:1658\n-1#1:1659,10\n-1#1:1669\n-1#1:1670,6\n-1#1:1676\n-1#1:1677,2\n-1#1:1679,11\n-1#1:1690,4\n-1#1:1694,6\n-1#1:1701,3\n-1#1:1705,2\n-1#1:1707\n-1#1:1708,10\n-1#1:1718\n-1#1:1719,6\n-1#1:1725\n-1#1:1726,2\n-1#1:1728,11\n-1#1:1739,4\n-1#1:1743,6\n-1#1:1750,3\n-1#1:1754,2\n-1#1:1756\n-1#1:1757,10\n-1#1:1767\n-1#1:1768,6\n-1#1:1774\n-1#1:1775,2\n321#1:1036,3\n331#1:1076,3\n456#1:1256,3\n462#1:1296,3\n619#1:1516,3\n321#1:1040\n321#1:1043\n321#1:1048,3\n321#1:1052,3\n321#1:1056\n321#1:1058\n321#1:1059\n321#1:1064\n321#1:1066\n331#1:1080\n331#1:1083\n331#1:1088,3\n331#1:1092,3\n331#1:1096\n331#1:1098\n331#1:1099\n331#1:1104\n331#1:1106\n359#1:1115\n366#1:1116\n385#1:1123\n385#1:1127\n398#1:1143\n398#1:1147\n410#1:1163\n410#1:1167\n420#1:1187\n420#1:1191\n430#1:1213\n430#1:1217\n446#1:1239\n446#1:1243\n456#1:1260\n456#1:1263\n456#1:1268,3\n456#1:1272,3\n456#1:1276\n456#1:1278\n456#1:1279\n456#1:1284\n456#1:1286\n462#1:1300\n462#1:1303\n462#1:1308,3\n462#1:1312,3\n462#1:1316\n462#1:1318\n462#1:1319\n462#1:1324\n462#1:1326\n469#1:1344\n469#1:1348\n493#1:1370\n493#1:1374\n528#1:1396\n528#1:1400\n528#1:1422\n528#1:1426\n549#1:1448\n549#1:1452\n575#1:1474\n575#1:1478\n601#1:1500\n601#1:1504\n620#1:1519\n623#1:1520\n627#1:1521,3\n628#1:1524,3\n629#1:1527\n630#1:1528\n630#1:1529\n634#1:1530\n637#1:1531\n-1#1:1553\n-1#1:1557\n-1#1:1602\n-1#1:1606\n-1#1:1651\n-1#1:1655\n-1#1:1700\n-1#1:1704\n-1#1:1749\n-1#1:1753\n*E\n"})
public abstract class IntObjectMap<V> {
    @XO
    public int _capacity;
    @XO
    public int _size;
    @XO
    @OOXIXo
    public int[] keys;
    @XO
    @OOXIXo
    public long[] metadata;
    @XO
    @OOXIXo
    public Object[] values;

    public /* synthetic */ IntObjectMap(IIXOooo iIXOooo) {
        this();
    }

    @o0
    public static /* synthetic */ void getKeys$annotations() {
    }

    @o0
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @o0
    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public static /* synthetic */ String joinToString$default(IntObjectMap intObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
            return intObjectMap.joinToString(charSequence, charSequence6, charSequence5, i3, charSequence4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(@OOXIXo x0xO0oo<? super Integer, ? super V, Boolean> x0xo0oo) {
        x0xO0oo<? super Integer, ? super V, Boolean> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(x0xo0oo2, "predicate");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        if (!x0xo0oo2.invoke(Integer.valueOf(iArr[i4]), objArr[i4]).booleanValue()) {
                            return false;
                        }
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0064, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0066, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean contains(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = 0
        L_0x0015:
            long[] r7 = r0.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
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
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x0042:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x005d
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.keys
            r15 = r15[r11]
            if (r15 != r1) goto L_0x0057
            goto L_0x0067
        L_0x0057:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x0042
        L_0x005d:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 == 0) goto L_0x006b
            r11 = -1
        L_0x0067:
            if (r11 < 0) goto L_0x006a
            r5 = 1
        L_0x006a:
            return r5
        L_0x006b:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.contains(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0064, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0066, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean containsKey(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = 0
        L_0x0015:
            long[] r7 = r0.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
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
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x0042:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x005d
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.keys
            r15 = r15[r11]
            if (r15 != r1) goto L_0x0057
            goto L_0x0067
        L_0x0057:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x0042
        L_0x005d:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 == 0) goto L_0x006b
            r11 = -1
        L_0x0067:
            if (r11 < 0) goto L_0x006a
            r5 = 1
        L_0x006a:
            return r5
        L_0x006b:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.containsKey(int):boolean");
    }

    public final boolean containsValue(V v) {
        Object[] objArr = this.values;
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
                            if (IIX0o.Oxx0IOOO(v, objArr[(i << 3) + i3])) {
                                return true;
                            }
                        } else {
                            V v2 = v;
                        }
                        j >>= 8;
                    }
                    V v3 = v;
                    if (i2 != 8) {
                        break;
                    }
                } else {
                    V v4 = v;
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count() {
        return getSize();
    }

    /* JADX WARNING: type inference failed for: r20v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@OXOo.oOoXoXO java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof androidx.collection.IntObjectMap
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            androidx.collection.IntObjectMap r1 = (androidx.collection.IntObjectMap) r1
            int r3 = r1.getSize()
            int r5 = r19.getSize()
            if (r3 == r5) goto L_0x001b
            return r4
        L_0x001b:
            int[] r3 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x0078
            r8 = 0
        L_0x0027:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x0073
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = 0
        L_0x0041:
            if (r13 >= r11) goto L_0x0071
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x006d
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r14 = r5[r14]
            if (r14 != 0) goto L_0x0062
            java.lang.Object r14 = r1.get(r15)
            if (r14 != 0) goto L_0x0061
            boolean r14 = r1.containsKey(r15)
            if (r14 != 0) goto L_0x006d
        L_0x0061:
            return r4
        L_0x0062:
            java.lang.Object r15 = r1.get(r15)
            boolean r14 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r14, r15)
            if (r14 != 0) goto L_0x006d
            return r4
        L_0x006d:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L_0x0041
        L_0x0071:
            if (r11 != r12) goto L_0x0078
        L_0x0073:
            if (r8 == r7) goto L_0x0078
            int r8 = r8 + 1
            goto L_0x0027
        L_0x0078:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex$collection(int i) {
        int i2 = ScatterMapKt.MurmurHashC1 * i;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-((long) i9)) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (((long) i4) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i5;
                if (this.keys[numberOfTrailingZeros] == i) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & -9187201950435737472L) != 0) {
                return -1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
    }

    public final void forEach(@OOXIXo x0xO0oo<? super Integer, ? super V, oXIO0o0XI> x0xo0oo) {
        x0xO0oo<? super Integer, ? super V, oXIO0o0XI> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(x0xo0oo2, "block");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i4 = (i << 3) + i3;
                            x0xo0oo2.invoke(Integer.valueOf(iArr[i4]), objArr[i4]);
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
    public final void forEachIndexed(@OOXIXo oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
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

    public final void forEachKey(@OOXIXo oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "block");
        int[] iArr = this.keys;
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
                            oooxoxo2.invoke(Integer.valueOf(iArr[(i << 3) + i3]));
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

    public final void forEachValue(@OOXIXo oOoXoXO<? super V, oXIO0o0XI> oooxoxo) {
        oOoXoXO<? super V, oXIO0o0XI> oooxoxo2 = oooxoxo;
        IIX0o.x0xO0oo(oooxoxo2, "block");
        Object[] objArr = this.values;
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005f, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0061, code lost:
        r10 = -1;
     */
    @OXOo.oOoXoXO
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(int r14) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L_0x0010:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L_0x003d:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0058
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.keys
            r11 = r11[r10]
            if (r11 != r14) goto L_0x0052
            goto L_0x0062
        L_0x0052:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L_0x003d
        L_0x0058:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x006b
            r10 = -1
        L_0x0062:
            if (r10 < 0) goto L_0x0069
            java.lang.Object[] r14 = r13.values
            r14 = r14[r10]
            goto L_0x006a
        L_0x0069:
            r14 = 0
        L_0x006a:
            return r14
        L_0x006b:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.get(int):java.lang.Object");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005f, code lost:
        if (((r4 & ((~r4) << 6)) & -9187201950435737472L) == 0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0061, code lost:
        r10 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V getOrDefault(int r14, V r15) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L_0x0010:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L_0x003d:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0058
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.keys
            r11 = r11[r10]
            if (r11 != r14) goto L_0x0052
            goto L_0x0062
        L_0x0052:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L_0x003d
        L_0x0058:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x006a
            r10 = -1
        L_0x0062:
            if (r10 < 0) goto L_0x0069
            java.lang.Object[] r14 = r13.values
            r14 = r14[r10]
            return r14
        L_0x0069:
            return r15
        L_0x006a:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntObjectMap.getOrDefault(int, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(int i, @OOXIXo oIX0oI<? extends V> oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "defaultValue");
        V v = get(i);
        if (v == null) {
            return oix0oi.invoke();
        }
        return v;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i;
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i7 = (i3 << 3) + i6;
                            int i8 = iArr[i7];
                            Object obj = objArr[i7];
                            if (obj != null) {
                                i = obj.hashCode();
                            } else {
                                i = 0;
                            }
                            i4 += i ^ i8;
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
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int[] iArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            sb.append(i6);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(',');
                                sb.append(TokenParser.SP);
                            }
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
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "s.append('}').toString()");
        return sb2;
    }

    private IntObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public final boolean any(@OOXIXo x0xO0oo<? super Integer, ? super V, Boolean> x0xo0oo) {
        x0xO0oo<? super Integer, ? super V, Boolean> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(x0xo0oo2, "predicate");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i4 = (i << 3) + i3;
                            if (x0xo0oo2.invoke(Integer.valueOf(iArr[i4]), objArr[i4]).booleanValue()) {
                                return true;
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
        return false;
    }

    public final int count(@OOXIXo x0xO0oo<? super Integer, ? super V, Boolean> x0xo0oo) {
        x0xO0oo<? super Integer, ? super V, Boolean> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(x0xo0oo2, "predicate");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i6 = (i2 << 3) + i5;
                            if (x0xo0oo2.invoke(Integer.valueOf(iArr[i6]), objArr[i6]).booleanValue()) {
                                i3++;
                            }
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

    public static /* synthetic */ String joinToString$default(IntObjectMap intObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, x0xO0oo x0xo0oo, int i2, Object obj) {
        long[] jArr;
        long[] jArr2;
        IntObjectMap intObjectMap2 = intObjectMap;
        x0xO0oo x0xo0oo2 = x0xo0oo;
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
            IIX0o.x0xO0oo(x0xo0oo2, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence6);
            int[] iArr = intObjectMap2.keys;
            Object[] objArr = intObjectMap2.values;
            long[] jArr3 = intObjectMap2.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                int i5 = 0;
                loop0:
                while (true) {
                    long j = jArr3[i4];
                    int i6 = i4;
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j & 255) < 128) {
                                int i9 = (i6 << 3) + i8;
                                int i10 = iArr[i9];
                                Object obj2 = objArr[i9];
                                if (i5 == i3) {
                                    sb.append(str2);
                                    break loop0;
                                }
                                if (i5 != 0) {
                                    sb.append(str);
                                }
                                jArr2 = jArr3;
                                sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i10), obj2));
                                i5++;
                            } else {
                                jArr2 = jArr3;
                            }
                            j >>= 8;
                            i8++;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i7 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    int i11 = i6;
                    if (i11 == length) {
                        break;
                    }
                    i4 = i11 + 1;
                    jArr3 = jArr;
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
        int[] iArr;
        int[] iArr2;
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
        int[] iArr3 = this.keys;
        Object[] objArr = this.values;
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
                            int i6 = (i2 << 3) + i5;
                            int i7 = iArr3[i6];
                            Object obj = objArr[i6];
                            iArr2 = iArr3;
                            if (i3 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append(i7);
                            sb.append('=');
                            sb.append(obj);
                            i3++;
                        } else {
                            iArr2 = iArr3;
                            int i8 = i;
                        }
                        j >>= 8;
                        i5++;
                        iArr3 = iArr2;
                    }
                    iArr = iArr3;
                    int i9 = i;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    int i10 = i;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                iArr3 = iArr;
            }
        }
        sb.append(charSequence7);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4, @OOXIXo x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo) {
        int[] iArr;
        int[] iArr2;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        CharSequence charSequence8 = charSequence4;
        x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(charSequence5, "separator");
        IIX0o.x0xO0oo(charSequence6, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence7, "postfix");
        IIX0o.x0xO0oo(charSequence8, "truncated");
        IIX0o.x0xO0oo(x0xo0oo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        int[] iArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            int i8 = iArr3[i7];
                            Object obj = objArr[i7];
                            iArr2 = iArr3;
                            if (i3 == i) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence5);
                            }
                            sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i8), obj));
                            i3++;
                        } else {
                            iArr2 = iArr3;
                            int i9 = i;
                        }
                        j >>= 8;
                        i6++;
                        charSequence5 = charSequence;
                        iArr3 = iArr2;
                    }
                    iArr = iArr3;
                    int i10 = i;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    int i11 = i;
                }
                int i12 = i4;
                if (i12 == length) {
                    break;
                }
                i2 = i12 + 1;
                charSequence5 = charSequence;
                iArr3 = iArr;
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

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(charSequence4, "separator");
        IIX0o.x0xO0oo(charSequence5, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence6, "postfix");
        IIX0o.x0xO0oo(x0xo0oo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i6 = (i2 << 3) + i5;
                            int i7 = iArr[i6];
                            Object obj = objArr[i6];
                            if (i3 == i) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i7), obj));
                            i3++;
                        }
                        j >>= 8;
                        i5++;
                    }
                    if (i4 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence6);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, @OOXIXo x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(charSequence4, "separator");
        IIX0o.x0xO0oo(charSequence5, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence6, "postfix");
        IIX0o.x0xO0oo(x0xo0oo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence5);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((j & 255) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i6), obj));
                            i2++;
                        }
                        j >>= 8;
                        i4++;
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
        sb.append(charSequence6);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo) {
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(charSequence3, "separator");
        IIX0o.x0xO0oo(charSequence4, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(x0xo0oo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence4);
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence3);
                            }
                            sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i6), obj));
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
        sb.append("");
        String sb22 = sb.toString();
        IIX0o.oO(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo) {
        CharSequence charSequence2 = charSequence;
        x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(charSequence2, "separator");
        IIX0o.x0xO0oo(x0xo0oo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((j & 255) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence2);
                            }
                            sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i6), obj));
                            i2++;
                        }
                        j >>= 8;
                        i4++;
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
        sb.append("");
        String sb22 = sb.toString();
        IIX0o.oO(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo) {
        x0xO0oo<? super Integer, ? super V, ? extends CharSequence> x0xo0oo2 = x0xo0oo;
        IIX0o.x0xO0oo(x0xo0oo2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int[] iArr = this.keys;
        Object[] objArr = this.values;
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
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            if (i2 == -1) {
                                sb.append("...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(", ");
                            }
                            sb.append((CharSequence) x0xo0oo2.invoke(Integer.valueOf(i6), obj));
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
