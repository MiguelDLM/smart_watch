package androidx.room.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @XO
    @OOXIXo
    public final String name;
    @XO
    @oOoXoXO
    public final String sql;

    @XX({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\nandroidx/room/util/ViewInfo$Companion\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,83:1\n145#2,7:84\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\nandroidx/room/util/ViewInfo$Companion\n*L\n73#1:84,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final ViewInfo read(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo String str) {
            ViewInfo viewInfo;
            IIX0o.x0xO0oo(supportSQLiteDatabase, "database");
            IIX0o.x0xO0oo(str, "viewName");
            Closeable query = supportSQLiteDatabase.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
            try {
                Cursor cursor = (Cursor) query;
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    IIX0o.oO(string, "cursor.getString(0)");
                    viewInfo = new ViewInfo(string, cursor.getString(1));
                } else {
                    viewInfo = new ViewInfo(str, (String) null);
                }
                II0xO0.oIX0oI(query, (Throwable) null);
                return viewInfo;
            } catch (Throwable th) {
                II0xO0.oIX0oI(query, th);
                throw th;
            }
        }

        private Companion() {
        }
    }

    public ViewInfo(@OOXIXo String str, @oOoXoXO String str2) {
        IIX0o.x0xO0oo(str, "name");
        this.name = str;
        this.sql = str2;
    }

    @x0XOIxOo
    @OOXIXo
    public static final ViewInfo read(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@oOoXoXO Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (IIX0o.Oxx0IOOO(this.name, viewInfo.name)) {
            String str = this.sql;
            String str2 = viewInfo.sql;
            if (str != null) {
                z = IIX0o.Oxx0IOOO(str, str2);
            } else if (str2 == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.name.hashCode() * 31;
        String str = this.sql;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    @OOXIXo
    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
