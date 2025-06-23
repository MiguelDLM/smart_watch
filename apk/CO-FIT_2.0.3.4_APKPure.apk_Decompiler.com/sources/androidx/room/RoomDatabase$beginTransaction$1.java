package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class RoomDatabase$beginTransaction$1 extends Lambda implements oOoXoXO<SupportSQLiteDatabase, Object> {
    final /* synthetic */ RoomDatabase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDatabase$beginTransaction$1(RoomDatabase roomDatabase) {
        super(1);
        this.this$0 = roomDatabase;
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, "it");
        this.this$0.internalBeginTransaction();
        return null;
    }
}
