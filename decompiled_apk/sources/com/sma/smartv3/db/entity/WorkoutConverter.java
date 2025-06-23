package com.sma.smartv3.db.entity;

import OI0.oIX0oI;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.util.IXxxXO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nWorkout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Workout.kt\ncom/sma/smartv3/db/entity/WorkoutConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,302:1\n1549#2:303\n1620#2,3:304\n*S KotlinDebug\n*F\n+ 1 Workout.kt\ncom/sma/smartv3/db/entity/WorkoutConverter\n*L\n79#1:303\n79#1:304,3\n*E\n"})
/* loaded from: classes12.dex */
public final class WorkoutConverter {
    @TypeConverter
    @oOoXoXO
    public final String floatArrayListToString(@oOoXoXO List<float[]> list) {
        if (list != null) {
            return new GsonBuilder().registerTypeAdapter(float[].class, new IXxxXO()).create().toJson(list);
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final List<float[]> floatArrayToWatchList(@oOoXoXO String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return IXxxXO.oIX0oI(str);
        } catch (Exception e) {
            oIX0oI.f1507oIX0oI.II0xO0("workout floatArrayToWatchList e = " + e + "  ,  value = " + str);
            return null;
        }
    }

    @TypeConverter
    @oOoXoXO
    public final String fromIntArray(@oOoXoXO int[] iArr) {
        boolean z;
        if (iArr != null) {
            if (iArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return ArraysKt___ArraysKt.Oo00XooIO(iArr, ",", null, null, 0, null, null, 62, null);
            }
            return null;
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final String stopWatchListToString(@oOoXoXO List<Integer> list) {
        if (list != null) {
            return new Gson().toJson(list);
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final List<Integer> stringToStopWatchList(@oOoXoXO String str) {
        if (!TextUtils.isEmpty(str)) {
            return (List) new Gson().fromJson(str, new TypeToken<List<? extends Integer>>() { // from class: com.sma.smartv3.db.entity.WorkoutConverter$stringToStopWatchList$listType$1
            }.getType());
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final int[] toIntArray(@oOoXoXO String str) {
        if (str == null || !StringsKt__StringsKt.o00xOoIO(str, ",", false, 2, null)) {
            return null;
        }
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(XXoO0oX2, 10));
        Iterator it = XXoO0oX2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(StringsKt__StringsKt.oIoIXxIO((String) it.next()).toString())));
        }
        return CollectionsKt___CollectionsKt.o0Oox0xox(arrayList);
    }
}
