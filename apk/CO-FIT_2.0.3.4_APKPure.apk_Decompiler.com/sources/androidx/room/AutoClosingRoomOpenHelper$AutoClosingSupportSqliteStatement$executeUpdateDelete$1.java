package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1 extends Lambda implements oOoXoXO<SupportSQLiteStatement, Integer> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1() {
        super(1);
    }

    @OOXIXo
    public final Integer invoke(@OOXIXo SupportSQLiteStatement supportSQLiteStatement) {
        IIX0o.x0xO0oo(supportSQLiteStatement, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return Integer.valueOf(supportSQLiteStatement.executeUpdateDelete());
    }
}
