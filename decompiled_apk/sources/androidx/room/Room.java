package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class Room {

    @OXOo.OOXIXo
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";

    @OXOo.OOXIXo
    public static final Room INSTANCE = new Room();

    @OXOo.OOXIXo
    public static final String LOG_TAG = "ROOM";

    @OXOo.OOXIXo
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Class<T> klass, @OXOo.oOoXoXO String str) {
        boolean z;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(klass, "klass");
        if (str != null && !kotlin.text.OxI.X0O0I0(str)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return new RoomDatabase.Builder<>(context, klass, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    @XO0OX.x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(@OXOo.OOXIXo Class<C> klass, @OXOo.OOXIXo String suffix) {
        String str;
        IIX0o.x0xO0oo(klass, "klass");
        IIX0o.x0xO0oo(suffix, "suffix");
        Package r0 = klass.getPackage();
        IIX0o.ooOOo0oXI(r0);
        String fullPackage = r0.getName();
        String canonicalName = klass.getCanonicalName();
        IIX0o.ooOOo0oXI(canonicalName);
        IIX0o.oO(fullPackage, "fullPackage");
        if (fullPackage.length() != 0) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            IIX0o.oO(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str2 = kotlin.text.OxI.oXO0oOx0(canonicalName, '.', '_', false, 4, null) + suffix;
        try {
            if (fullPackage.length() == 0) {
                str = str2;
            } else {
                str = fullPackage + '.' + str2;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            IIX0o.x0XOIxOo(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str2 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName());
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Class<T> klass) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(klass, "klass");
        return new RoomDatabase.Builder<>(context, klass, null);
    }
}
