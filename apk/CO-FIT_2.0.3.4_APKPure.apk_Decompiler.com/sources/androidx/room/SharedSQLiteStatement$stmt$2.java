package androidx.room;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.Lambda;

public final class SharedSQLiteStatement$stmt$2 extends Lambda implements oIX0oI<SupportSQLiteStatement> {
    final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        super(0);
        this.this$0 = sharedSQLiteStatement;
    }

    @OOXIXo
    public final SupportSQLiteStatement invoke() {
        return this.this$0.createNewStatement();
    }
}
