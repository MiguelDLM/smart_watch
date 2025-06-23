package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;

public final class Room {
    @OOXIXo
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    @OOXIXo
    public static final Room INSTANCE = new Room();
    @OOXIXo
    public static final String LOG_TAG = "ROOM";
    @OOXIXo
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@OOXIXo Context context, @OOXIXo Class<T> cls, @oOoXoXO String str) {
        boolean z;
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(cls, "klass");
        if (str == null || OxI.X0O0I0(str)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return new RoomDatabase.Builder<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(@OOXIXo Class<C> cls, @OOXIXo String str) {
        String str2;
        IIX0o.x0xO0oo(cls, "klass");
        IIX0o.x0xO0oo(str, "suffix");
        Package packageR = cls.getPackage();
        IIX0o.ooOOo0oXI(packageR);
        String name = packageR.getName();
        String canonicalName = cls.getCanonicalName();
        IIX0o.ooOOo0oXI(canonicalName);
        IIX0o.oO(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            IIX0o.oO(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str3 = canonicalName;
        String str4 = OxI.oXO0oOx0(str3, '.', '_', false, 4, (Object) null) + str;
        try {
            if (name.length() == 0) {
                str2 = str4;
            } else {
                str2 = name + '.' + str4;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            IIX0o.x0XOIxOo(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return cls2.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str4 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@OOXIXo Context context, @OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(cls, "klass");
        return new RoomDatabase.Builder<>(context, cls, (String) null);
    }
}
