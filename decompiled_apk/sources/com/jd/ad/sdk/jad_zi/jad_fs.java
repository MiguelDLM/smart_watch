package com.jd.ad.sdk.jad_zi;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes10.dex */
public final class jad_fs extends AbstractList<jad_cp> implements RandomAccess {
    public final jad_cp[] jad_an;
    public final int[] jad_bo;

    public jad_fs(jad_cp[] jad_cpVarArr, int[] iArr) {
        this.jad_an = jad_cpVarArr;
        this.jad_bo = iArr;
    }

    public static void jad_an(long j, jad_an jad_anVar, int i, List<jad_cp> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        long j2;
        jad_an jad_anVar2;
        int i7;
        int i8;
        jad_an jad_anVar3;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i9 = i2; i9 < i3; i9++) {
            if (list.get(i9).jad_cp() < i) {
                throw new AssertionError();
            }
        }
        jad_cp jad_cpVar = list.get(i2);
        jad_cp jad_cpVar2 = list.get(i3 - 1);
        if (i == jad_cpVar.jad_cp()) {
            int i10 = i2 + 1;
            i5 = i10;
            i4 = list2.get(i2).intValue();
            jad_cpVar = list.get(i10);
        } else {
            i4 = -1;
            i5 = i2;
        }
        long j3 = 4;
        if (jad_cpVar.jad_an(i) != jad_cpVar2.jad_an(i)) {
            int i11 = 1;
            for (int i12 = i5 + 1; i12 < i3; i12++) {
                if (list.get(i12 - 1).jad_an(i) != list.get(i12).jad_an(i)) {
                    i11++;
                }
            }
            long j4 = j + ((int) (jad_anVar.jad_bo / 4)) + 2 + (i11 * 2);
            jad_anVar.jad_cp(i11);
            jad_anVar.jad_cp(i4);
            for (int i13 = i5; i13 < i3; i13++) {
                byte jad_an = list.get(i13).jad_an(i);
                if (i13 == i5 || jad_an != list.get(i13 - 1).jad_an(i)) {
                    jad_anVar.jad_cp(jad_an & 255);
                }
            }
            jad_anVar2 = new jad_an();
            int i14 = i5;
            while (i14 < i3) {
                byte jad_an2 = list.get(i14).jad_an(i);
                int i15 = i14 + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= i3) {
                        i7 = i3;
                        break;
                    } else {
                        if (jad_an2 != list.get(i16).jad_an(i)) {
                            i7 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                if (i15 == i7 && i + 1 == list.get(i14).jad_cp()) {
                    jad_anVar.jad_cp(list2.get(i14).intValue());
                    i8 = i7;
                    jad_anVar3 = jad_anVar2;
                } else {
                    jad_anVar.jad_cp((int) ((((int) (jad_anVar2.jad_bo / j3)) + j4) * (-1)));
                    i8 = i7;
                    jad_anVar3 = jad_anVar2;
                    jad_an(j4, jad_anVar2, i + 1, list, i14, i7, list2);
                }
                jad_anVar2 = jad_anVar3;
                i14 = i8;
                j3 = 4;
            }
            j2 = jad_anVar2.jad_bo;
        } else {
            int min = Math.min(jad_cpVar.jad_cp(), jad_cpVar2.jad_cp());
            int i17 = 0;
            for (int i18 = i; i18 < min && jad_cpVar.jad_an(i18) == jad_cpVar2.jad_an(i18); i18++) {
                i17++;
            }
            long j5 = 1 + j + ((int) (jad_anVar.jad_bo / 4)) + 2 + i17;
            jad_anVar.jad_cp(-i17);
            jad_anVar.jad_cp(i4);
            int i19 = i;
            while (true) {
                i6 = i + i17;
                if (i19 >= i6) {
                    break;
                }
                jad_anVar.jad_cp(jad_cpVar.jad_an(i19) & 255);
                i19++;
            }
            if (i5 + 1 == i3) {
                if (i6 != list.get(i5).jad_cp()) {
                    throw new AssertionError();
                }
                jad_anVar.jad_cp(list2.get(i5).intValue());
                return;
            } else {
                jad_an jad_anVar4 = new jad_an();
                jad_anVar.jad_cp((int) ((((int) (jad_anVar4.jad_bo / 4)) + j5) * (-1)));
                jad_an(j5, jad_anVar4, i6, list, i5, i3, list2);
                j2 = jad_anVar4.jad_bo;
                jad_anVar2 = jad_anVar4;
            }
        }
        jad_anVar.jad_bo(jad_anVar2, j2);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.jad_an[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.jad_an.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.jd.ad.sdk.jad_zi.jad_fs jad_an(com.jd.ad.sdk.jad_zi.jad_cp... r15) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_zi.jad_fs.jad_an(com.jd.ad.sdk.jad_zi.jad_cp[]):com.jd.ad.sdk.jad_zi.jad_fs");
    }
}
