package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
final class zzfh extends zzfl {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ zzfh(zzfg zzfgVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzhj.zzf(obj, j);
        if (list instanceof zzff) {
            unmodifiableList = ((zzff) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzge) && (list instanceof zzez)) {
                zzez zzezVar = (zzez) list;
                if (zzezVar.zzc()) {
                    zzezVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzhj.zzp(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zzb(Object obj, Object obj2, long j) {
        zzfe zzfeVar;
        List list = (List) zzhj.zzf(obj2, j);
        int size = list.size();
        List list2 = (List) zzhj.zzf(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzff) {
                list2 = new zzfe(size);
            } else if ((list2 instanceof zzge) && (list2 instanceof zzez)) {
                list2 = ((zzez) list2).zzd(size);
            } else {
                list2 = new ArrayList(size);
            }
            zzhj.zzp(obj, j, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzhj.zzp(obj, j, arrayList);
                zzfeVar = arrayList;
            } else if (list2 instanceof zzhe) {
                zzfe zzfeVar2 = new zzfe(list2.size() + size);
                zzfeVar2.addAll(zzfeVar2.size(), (zzhe) list2);
                zzhj.zzp(obj, j, zzfeVar2);
                zzfeVar = zzfeVar2;
            } else if ((list2 instanceof zzge) && (list2 instanceof zzez)) {
                zzez zzezVar = (zzez) list2;
                if (!zzezVar.zzc()) {
                    list2 = zzezVar.zzd(list2.size() + size);
                    zzhj.zzp(obj, j, list2);
                }
            }
            list2 = zzfeVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzhj.zzp(obj, j, list);
    }

    private zzfh() {
        super(null);
    }
}
