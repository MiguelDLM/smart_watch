package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.kuaishou.weapon.p0.bq;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

public /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2 extends FunctionReferenceImpl implements oOoXoXO<SupportSQLiteDatabase, Boolean> {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2() {
        super(1, SupportSQLiteDatabase.class, "yieldIfContendedSafely", "yieldIfContendedSafely()Z", 0);
    }

    @OOXIXo
    public final Boolean invoke(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, bq.g);
        return Boolean.valueOf(supportSQLiteDatabase.yieldIfContendedSafely());
    }
}
