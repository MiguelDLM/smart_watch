package androidx.room.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.xxIXOIIO;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;
import org.apache.log4j.spi.LocationInfo;

@xxIXOIIO(name = "StringUtil")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nStringUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringUtil.kt\nandroidx/room/util/StringUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1603#2,9:87\n1855#2:96\n1856#2:98\n1612#2:99\n1#3:97\n*S KotlinDebug\n*F\n+ 1 StringUtil.kt\nandroidx/room/util/StringUtil\n*L\n66#1:87,9\n66#1:96\n66#1:98\n66#1:99\n66#1:97\n*E\n"})
public final class StringUtil {
    @XO
    @OOXIXo
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(@OOXIXo StringBuilder sb, int i) {
        IIX0o.x0xO0oo(sb, "builder");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(LocationInfo.NA);
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    @oOoXoXO
    public static final String joinIntoString(@oOoXoXO List<Integer> list) {
        if (list != null) {
            return CollectionsKt___CollectionsKt.OoIXo(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Oox.oOoXoXO) null, 62, (Object) null);
        }
        return null;
    }

    @OOXIXo
    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @oOoXoXO
    public static final List<Integer> splitToIntList(@oOoXoXO String str) {
        List<String> Xxx0oXX2;
        Integer num;
        if (str == null || (Xxx0oXX2 = StringsKt__StringsKt.Xxx0oXX(str, new char[]{','}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String parseInt : Xxx0oXX2) {
            try {
                num = Integer.valueOf(Integer.parseInt(parseInt));
            } catch (NumberFormatException e) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e);
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }
}
