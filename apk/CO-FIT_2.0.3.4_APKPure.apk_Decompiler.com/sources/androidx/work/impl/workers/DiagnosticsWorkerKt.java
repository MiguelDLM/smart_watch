package androidx.work.impl.workers;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDiagnosticsWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiagnosticsWorker.kt\nandroidx/work/impl/workers/DiagnosticsWorkerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1855#2,2:87\n*S KotlinDebug\n*F\n+ 1 DiagnosticsWorker.kt\nandroidx/work/impl/workers/DiagnosticsWorkerKt\n*L\n75#1:87,2\n*E\n"})
public final class DiagnosticsWorkerKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("DiagnosticsWrkr");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"DiagnosticsWrkr\")");
        TAG = tagWithPrefix;
    }

    private static final String workSpecRow(WorkSpec workSpec, String str, Integer num, String str2) {
        return 10 + workSpec.id + "\t " + workSpec.workerClassName + "\t " + num + "\t " + workSpec.state.name() + "\t " + str + "\t " + str2 + 9;
    }

    /* access modifiers changed from: private */
    public static final String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        String str;
        Integer num;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 23) {
            str = "Job Id";
        } else {
            str = "Alarm Id";
        }
        sb.append("\n Id \t Class Name\t " + str + "\t State\t Unique Name\t Tags\t");
        for (WorkSpec workSpec : list) {
            SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(WorkSpecKt.generationalId(workSpec));
            if (systemIdInfo != null) {
                num = Integer.valueOf(systemIdInfo.systemId);
            } else {
                num = null;
            }
            sb.append(workSpecRow(workSpec, CollectionsKt___CollectionsKt.OoIXo(workNameDao.getNamesForWorkSpecId(workSpec.id), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 62, (Object) null), num, CollectionsKt___CollectionsKt.OoIXo(workTagDao.getTagsForWorkSpecId(workSpec.id), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 62, (Object) null)));
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
