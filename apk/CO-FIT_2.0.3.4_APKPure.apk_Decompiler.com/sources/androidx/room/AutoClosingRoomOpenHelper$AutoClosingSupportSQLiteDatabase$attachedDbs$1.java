package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1 extends Lambda implements oOoXoXO<SupportSQLiteDatabase, List<? extends Pair<String, String>>> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1() {
        super(1);
    }

    @OXOo.oOoXoXO
    public final List<Pair<String, String>> invoke(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return supportSQLiteDatabase.getAttachedDbs();
    }
}
