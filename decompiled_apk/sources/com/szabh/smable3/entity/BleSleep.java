package com.szabh.smable3.entity;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.util.SparseIntArray;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

/* loaded from: classes13.dex */
public final class BleSleep extends BleReadable {
    public static final int AWAKE = 3;
    public static final int AWAKE_LENGTH = 7;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DEEP = 1;
    public static final int DEEP_LENGTH = 5;
    public static final int END = 34;
    private static final int ERROR_DATA = 14400;
    public static final int ITEM_LENGTH = 7;
    public static final int LIGHT = 2;
    public static final int LIGHT_LENGTH = 6;
    private static final int OFFSET = 60;
    private static final int PERIOD = 900;
    public static final int PIECEMEAL = 8;
    public static final int REM = 9;
    public static final int START = 17;
    public static final int TOTAL_LENGTH = 4;
    private int mMode;
    private int mSoft;
    private int mStrong;
    private int mTime;

    @XX({"SMAP\nBleSleep.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleSleep.kt\ncom/szabh/smable3/entity/BleSleep$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,422:1\n1559#2:423\n1590#2,4:424\n1864#2,3:428\n1864#2,3:431\n1864#2,3:434\n1855#2,2:437\n1864#2,3:439\n1864#2,3:442\n1864#2,3:445\n1864#2,3:449\n1549#2:452\n1620#2,3:453\n1#3:448\n*S KotlinDebug\n*F\n+ 1 BleSleep.kt\ncom/szabh/smable3/entity/BleSleep$Companion\n*L\n58#1:423\n58#1:424,4\n75#1:428,3\n182#1:431,3\n219#1:434,3\n242#1:437,2\n263#1:439,3\n325#1:442,3\n351#1:445,3\n381#1:449,3\n409#1:452\n409#1:453,3\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ List analyseSleep$default(Companion companion, List list, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.analyseSleep(list, i);
        }

        @OOXIXo
        public final List<BleSleep> analyseSleep(@OOXIXo List<BleSleep> origin, int i) {
            IIX0o.x0xO0oo(origin, "origin");
            if (origin.size() < 2) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            List<BleSleep> list = origin;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (Object obj : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                if (((BleSleep) obj).getMMode() == 17) {
                    i3 = i4;
                }
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
                i4 = i5;
            }
            List oxXIOXO = CollectionsKt___CollectionsKt.oxXIOXO(origin, origin.size() - i3);
            int size = oxXIOXO.size() - 2;
            if (size >= 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    if (((BleSleep) oxXIOXO.get(i7)).getMTime() - ((BleSleep) oxXIOXO.get(i6)).getMTime() >= BleSleep.ERROR_DATA) {
                        return CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    if (i6 == size) {
                        break;
                    }
                    i6 = i7;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (i == 0) {
                boolean z = false;
                int i8 = 0;
                for (Object obj2 : oxXIOXO) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    BleSleep bleSleep = (BleSleep) obj2;
                    int mMode = bleSleep.getMMode();
                    if (mMode != 1) {
                        if (mMode != 2) {
                            if (mMode != 3) {
                                if (mMode == 17) {
                                    arrayList2.clear();
                                    bleSleep.setMMode(2);
                                    arrayList2.add(bleSleep);
                                    if (oxXIOXO.size() > i9 && ((BleSleep) oxXIOXO.get(i9)).getMTime() - bleSleep.getMTime() > 900) {
                                        arrayList2.add(new BleSleep(bleSleep.getMTime() + 900, 1, 0, 0, 12, null));
                                    }
                                    z = true;
                                }
                            } else if (arrayList2.isEmpty() || ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMMode() != bleSleep.getMMode()) {
                                arrayList2.add(bleSleep);
                            }
                        } else if (bleSleep.getMStrong() <= 2 && bleSleep.getMSoft() <= 25) {
                            if (arrayList2.isEmpty() || ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMMode() != bleSleep.getMMode()) {
                                arrayList2.add(bleSleep);
                            }
                        } else if (!arrayList2.isEmpty() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() <= 900) {
                            if (!arrayList2.isEmpty() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() <= 900) {
                                ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).setMMode(3);
                            }
                        } else {
                            arrayList2.add(BleSleep.copy$default(bleSleep, bleSleep.getMTime() - 900, 3, 0, 0, 12, null));
                        }
                    } else if (bleSleep.getMStrong() > 2) {
                        if (!arrayList2.isEmpty() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() <= 960) {
                            if (!arrayList2.isEmpty() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() <= 840) {
                                ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).setMMode(3);
                            } else {
                                arrayList2.add(BleSleep.copy$default(bleSleep, 0, 3, 0, 0, 13, null));
                            }
                        } else {
                            arrayList2.add(BleSleep.copy$default(bleSleep, bleSleep.getMTime() - 900, 3, 0, 0, 12, null));
                        }
                    } else if (bleSleep.getMSoft() > 2) {
                        if (!arrayList2.isEmpty() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() <= 900) {
                            if (!arrayList2.isEmpty() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() <= 900) {
                                ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).setMMode(2);
                            } else {
                                arrayList2.add(BleSleep.copy$default(bleSleep, 0, 2, 0, 0, 13, null));
                            }
                        } else {
                            arrayList2.add(BleSleep.copy$default(bleSleep, bleSleep.getMTime() - 900, 2, 0, 0, 12, null));
                        }
                    } else if (!arrayList2.isEmpty() && ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMMode() == bleSleep.getMMode() && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() > 840) {
                        arrayList2.add(BleSleep.copy$default(bleSleep, bleSleep.getMTime(), 2, 0, 0, 12, null));
                    } else if (arrayList2.size() > 2 && ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMMode() == 2 && ((BleSleep) arrayList2.get(arrayList2.size() - 2)).getMMode() == 1 && bleSleep.getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMTime() > 840) {
                        arrayList2.add(BleSleep.copy$default(bleSleep, bleSleep.getMTime(), 2, 0, 0, 12, null));
                    } else if (arrayList2.isEmpty() || ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMMode() != bleSleep.getMMode()) {
                        arrayList2.add(bleSleep);
                    }
                    i8 = i9;
                }
                if (!z && !arrayList2.isEmpty()) {
                    ((BleSleep) arrayList2.get(0)).setMMode(2);
                    if (arrayList2.size() > 1 && ((BleSleep) arrayList2.get(1)).getMTime() - ((BleSleep) arrayList2.get(0)).getMTime() > 900) {
                        arrayList2.add(1, new BleSleep(((BleSleep) arrayList2.get(0)).getMTime() + 900, 1, 0, 0, 12, null));
                    }
                }
                return arrayList2;
            }
            for (Object obj3 : oxXIOXO) {
                int i10 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                BleSleep bleSleep2 = (BleSleep) obj3;
                int mMode2 = bleSleep2.getMMode();
                if (mMode2 != 1) {
                    if (mMode2 != 2) {
                        if (mMode2 != 3) {
                            if (mMode2 != 17) {
                                if (mMode2 == 34 && !arrayList2.isEmpty()) {
                                    arrayList2.add(BleSleep.copy$default(bleSleep2, 0, ((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList2)).getMMode(), 0, 0, 13, null));
                                }
                            } else {
                                arrayList2.clear();
                            }
                        } else {
                            arrayList2.add(bleSleep2);
                        }
                    } else {
                        arrayList2.add(bleSleep2);
                    }
                } else {
                    arrayList2.add(bleSleep2);
                }
                i2 = i10;
            }
            return arrayList2;
        }

        @OOXIXo
        public final List<BleSleep> analyseSleepAllDay(@OOXIXo List<BleSleep> sleeps, long j) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            int i = 0;
            int i2 = 0;
            for (Object obj : sleeps) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                oIX0oI.f1507oIX0oI.oIX0oI("analyseSleepAllDay origin -> " + i2 + TokenParser.SP + ((BleSleep) obj));
                i2 = i3;
            }
            long millis = TimeUnit.DAYS.toMillis(1L) + j;
            oIX0oI.f1507oIX0oI.oIX0oI("analyseSleepAllDay -> " + j + TokenParser.SP + millis);
            int size = sleeps.size();
            while (true) {
                if (i < size) {
                    if (sleeps.get(i).getMLocalTime() >= j) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            oIX0oI.f1507oIX0oI.oIX0oI("analyseSleepAllDay -> start = " + i);
            if (i == -1) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i > 0) {
                int i4 = i - 1;
                while (true) {
                    BleSleep bleSleep = sleeps.get(i4);
                    if (bleSleep.getMMode() == 17) {
                        i = i4;
                        break;
                    }
                    if (bleSleep.getMMode() == 34 || i4 - 1 < 0) {
                        break;
                    }
                }
            }
            oIX0oI.f1507oIX0oI.oIX0oI("analyseSleepAllDay -> start = " + i);
            int size2 = sleeps.size();
            int i5 = size2 + (-1);
            while (true) {
                BleSleep bleSleep2 = sleeps.get(i5);
                if (bleSleep2.getMLocalTime() < millis) {
                    if (bleSleep2.getMMode() == 17) {
                        size2 = i5;
                        break;
                    }
                    if (bleSleep2.getMMode() == 34) {
                        size2 = i5 + 1;
                        break;
                    }
                }
                i5--;
                if (i5 < i) {
                    break;
                }
            }
            oIX0oI.f1507oIX0oI.oIX0oI("analyseSleepAllDay -> " + i + " - " + size2);
            return sleeps.subList(i, size2);
        }

        @OOXIXo
        public final HashMap<Integer, Integer> getSleepAllDaySegmentStatus(@OOXIXo List<BleSleep> sleeps) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int i = 0;
            Integer num = 0;
            if (sleeps.size() == 2 && sleeps.get(0).getMMode() == 17 && sleeps.get(1).getMMode() == 34) {
                i = sleeps.get(1).getMTime() - sleeps.get(0).getMTime();
            } else if (sleeps.size() > 2) {
                int i2 = 0;
                for (Object obj : sleeps) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    BleSleep bleSleep = (BleSleep) obj;
                    if (i2 < CollectionsKt__CollectionsKt.oo0xXOI0I(sleeps)) {
                        int mMode = bleSleep.getMMode();
                        Integer num2 = hashMap.get(Integer.valueOf(mMode));
                        if (num2 == null) {
                            num2 = num;
                        }
                        IIX0o.ooOOo0oXI(num2);
                        hashMap.put(Integer.valueOf(mMode), Integer.valueOf(num2.intValue() + (sleeps.get(i3).getMTime() - sleeps.get(i2).getMTime())));
                    }
                    i2 = i3;
                }
            }
            if (i > 0) {
                hashMap.put(8, Integer.valueOf(i / 60));
            } else {
                int mTime = (((BleSleep) CollectionsKt___CollectionsKt.O0O0Io00X(sleeps)).getMTime() - ((BleSleep) CollectionsKt___CollectionsKt.O0OOX0IIx(sleeps)).getMTime()) / 60;
                Integer num3 = hashMap.get(2);
                if (num3 == null) {
                    num3 = num;
                }
                hashMap.put(2, Integer.valueOf(num3.intValue() / 60));
                Integer num4 = hashMap.get(1);
                if (num4 == null) {
                    num4 = num;
                }
                hashMap.put(1, Integer.valueOf(num4.intValue() / 60));
                Integer num5 = hashMap.get(9);
                if (num5 == null) {
                    num5 = num;
                }
                hashMap.put(9, Integer.valueOf(num5.intValue() / 60));
                Integer num6 = hashMap.get(2);
                if (num6 == null) {
                    num6 = num;
                }
                int intValue = mTime - num6.intValue();
                Integer num7 = hashMap.get(1);
                if (num7 == null) {
                    num7 = num;
                }
                int intValue2 = intValue - num7.intValue();
                Integer num8 = hashMap.get(9);
                if (num8 != null) {
                    num = num8;
                }
                hashMap.put(3, Integer.valueOf(intValue2 - num.intValue()));
            }
            return hashMap;
        }

        @OOXIXo
        public final List<List<BleSleep>> getSleepAllDaySegments(@OOXIXo List<BleSleep> sleeps) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (Object obj : sleeps) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                BleSleep bleSleep = (BleSleep) obj;
                arrayList2.add(BleSleep.copy$default(bleSleep, 0, 0, 0, 0, 15, null));
                if (bleSleep.getMMode() == 34 || (!arrayList2.isEmpty() && i == CollectionsKt__CollectionsKt.oo0xXOI0I(sleeps))) {
                    arrayList.add(arrayList2);
                    arrayList2 = new ArrayList();
                }
                i = i2;
            }
            return arrayList;
        }

        @OOXIXo
        public final HashMap<Integer, Integer> getSleepAllDayStatus(@OOXIXo List<BleSleep> sleeps) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            List<List<BleSleep>> sleepAllDaySegments = getSleepAllDaySegments(sleeps);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int i = 0;
            for (Object obj : sleepAllDaySegments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                HashMap<Integer, Integer> sleepAllDaySegmentStatus = BleSleep.Companion.getSleepAllDaySegmentStatus((List) obj);
                Integer num = sleepAllDaySegmentStatus.get(2);
                if (num == null) {
                    num = 0;
                }
                IIX0o.ooOOo0oXI(num);
                int intValue = num.intValue();
                Integer num2 = sleepAllDaySegmentStatus.get(1);
                if (num2 == null) {
                    num2 = 0;
                }
                IIX0o.ooOOo0oXI(num2);
                int intValue2 = num2.intValue();
                Integer num3 = sleepAllDaySegmentStatus.get(3);
                if (num3 == null) {
                    num3 = 0;
                }
                IIX0o.ooOOo0oXI(num3);
                int intValue3 = num3.intValue();
                Integer num4 = sleepAllDaySegmentStatus.get(9);
                if (num4 == null) {
                    num4 = 0;
                }
                IIX0o.ooOOo0oXI(num4);
                int intValue4 = num4.intValue();
                Integer num5 = sleepAllDaySegmentStatus.get(8);
                if (num5 == null) {
                    num5 = 0;
                }
                IIX0o.ooOOo0oXI(num5);
                int intValue5 = num5.intValue();
                Integer num6 = hashMap.get(2);
                if (num6 == null) {
                    num6 = 0;
                }
                hashMap.put(2, Integer.valueOf(num6.intValue() + intValue));
                Integer num7 = hashMap.get(1);
                if (num7 == null) {
                    num7 = 0;
                }
                hashMap.put(1, Integer.valueOf(num7.intValue() + intValue2));
                Integer num8 = hashMap.get(3);
                if (num8 == null) {
                    num8 = 0;
                }
                hashMap.put(3, Integer.valueOf(num8.intValue() + intValue3));
                Integer num9 = hashMap.get(9);
                if (num9 == null) {
                    num9 = 0;
                }
                hashMap.put(9, Integer.valueOf(num9.intValue() + intValue4));
                Integer num10 = hashMap.get(8);
                if (num10 == null) {
                    num10 = 0;
                }
                hashMap.put(8, Integer.valueOf(num10.intValue() + intValue5));
                oIX0oI.f1507oIX0oI.oIX0oI("getSleepAllDayStatus -> " + i + ", " + hashMap);
                i = i2;
            }
            return hashMap;
        }

        @OOXIXo
        public final List<BleSleep> getSleepAllDayViewDatas(@OOXIXo List<BleSleep> sleeps) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            ArrayList arrayList = new ArrayList();
            for (List<BleSleep> list : getSleepAllDaySegments(sleeps)) {
                Integer num = getSleepAllDaySegmentStatus(list).get(8);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() > 0) {
                    arrayList.add(BleSleep.copy$default(list.get(0), 0, 17, 0, 0, 13, null));
                    List<BleSleep> list2 = list;
                    ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                    for (BleSleep bleSleep : list2) {
                        bleSleep.setMMode(8);
                        arrayList2.add(bleSleep);
                    }
                    arrayList.addAll(arrayList2);
                    arrayList.add(BleSleep.copy$default(list.get(1), 0, 34, 0, 0, 13, null));
                } else {
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }

        @OOXIXo
        public final SparseIntArray getSleepStatusDuration(@OOXIXo List<BleSleep> sleeps) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            SparseIntArray sparseIntArray = new SparseIntArray();
            int i = 0;
            for (Object obj : sleeps) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                BleSleep bleSleep = (BleSleep) obj;
                if (i < CollectionsKt__CollectionsKt.oo0xXOI0I(sleeps)) {
                    int mMode = bleSleep.getMMode();
                    sparseIntArray.put(mMode, sparseIntArray.get(mMode) + (sleeps.get(i2).getMTime() - bleSleep.getMTime()));
                }
                i = i2;
            }
            sparseIntArray.put(2, sparseIntArray.get(2) / 60);
            sparseIntArray.put(1, sparseIntArray.get(1) / 60);
            sparseIntArray.put(3, sparseIntArray.get(3) / 60);
            return sparseIntArray;
        }

        private Companion() {
        }

        @OOXIXo
        public final SparseIntArray getSleepStatusDuration(@OOXIXo List<BleSleep> sleeps, @OOXIXo List<BleSleep> origin) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
            IIX0o.x0xO0oo(origin, "origin");
            SparseIntArray sparseIntArray = new SparseIntArray();
            for (BleSleep bleSleep : origin) {
                int mMode = bleSleep.getMMode();
                if (mMode == 4) {
                    sparseIntArray.put(4, (bleSleep.getMSoft() << 8) + bleSleep.getMStrong());
                } else if (mMode == 5) {
                    sparseIntArray.put(1, (bleSleep.getMSoft() << 8) + bleSleep.getMStrong());
                } else if (mMode == 6) {
                    sparseIntArray.put(2, (bleSleep.getMSoft() << 8) + bleSleep.getMStrong());
                } else if (mMode == 7) {
                    sparseIntArray.put(3, (bleSleep.getMSoft() << 8) + bleSleep.getMStrong());
                }
            }
            if (sparseIntArray.get(4) != 0) {
                return sparseIntArray;
            }
            SparseIntArray sleepStatusDuration = getSleepStatusDuration(sleeps);
            sleepStatusDuration.put(4, sleepStatusDuration.get(2) + sleepStatusDuration.get(1) + sleepStatusDuration.get(3));
            return sleepStatusDuration;
        }
    }

    public BleSleep() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ BleSleep copy$default(BleSleep bleSleep, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bleSleep.mTime;
        }
        if ((i5 & 2) != 0) {
            i2 = bleSleep.mMode;
        }
        if ((i5 & 4) != 0) {
            i3 = bleSleep.mSoft;
        }
        if ((i5 & 8) != 0) {
            i4 = bleSleep.mStrong;
        }
        return bleSleep.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mMode;
    }

    public final int component3() {
        return this.mSoft;
    }

    public final int component4() {
        return this.mStrong;
    }

    @OOXIXo
    public final BleSleep copy(int i, int i2, int i3, int i4) {
        return new BleSleep(i, i2, i3, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mMode = readUInt8();
        this.mSoft = readUInt8();
        this.mStrong = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSleep)) {
            return false;
        }
        BleSleep bleSleep = (BleSleep) obj;
        return this.mTime == bleSleep.mTime && this.mMode == bleSleep.mMode && this.mSoft == bleSleep.mSoft && this.mStrong == bleSleep.mStrong;
    }

    public final long getMLocalTime() {
        return BleReadable.Companion.timeToMillis(this.mTime);
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMSoft() {
        return this.mSoft;
    }

    public final int getMStrong() {
        return this.mStrong;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((this.mTime * 31) + this.mMode) * 31) + this.mSoft) * 31) + this.mStrong;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMSoft(int i) {
        this.mSoft = i;
    }

    public final void setMStrong(int i) {
        this.mStrong = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSleep(mTime=" + this.mTime + ", mMode=" + this.mMode + ", mSoft=" + this.mSoft + ", mStrong=" + this.mStrong + ", mLocalTime=" + getMLocalTime() + HexStringBuilder.COMMENT_BEGIN_CHAR + BleReadable.Companion.timeFormat$default(BleReadable.Companion, null, 1, null).format(Long.valueOf(getMLocalTime())) + "))";
    }

    public /* synthetic */ BleSleep(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public BleSleep(int i, int i2, int i3, int i4) {
        this.mTime = i;
        this.mMode = i2;
        this.mSoft = i3;
        this.mStrong = i4;
    }
}
