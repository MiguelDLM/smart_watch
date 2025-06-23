package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

@Dao
/* loaded from: classes.dex */
public interface SystemIdInfoDao {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @oOoXoXO
        @Deprecated
        public static SystemIdInfo getSystemIdInfo(@OOXIXo SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId id) {
            SystemIdInfo oIX0oI2;
            IIX0o.x0xO0oo(id, "id");
            oIX0oI2 = I0Io.oIX0oI(systemIdInfoDao, id);
            return oIX0oI2;
        }

        @Deprecated
        public static void removeSystemIdInfo(@OOXIXo SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId id) {
            IIX0o.x0xO0oo(id, "id");
            I0Io.II0xO0(systemIdInfoDao, id);
        }
    }

    @oOoXoXO
    SystemIdInfo getSystemIdInfo(@OOXIXo WorkGenerationalId workGenerationalId);

    @Query("SELECT * FROM SystemIdInfo WHERE work_spec_id=:workSpecId AND generation=:generation")
    @oOoXoXO
    SystemIdInfo getSystemIdInfo(@OOXIXo String str, int i);

    @OOXIXo
    @Query("SELECT DISTINCT work_spec_id FROM SystemIdInfo")
    List<String> getWorkSpecIds();

    @Insert(onConflict = 1)
    void insertSystemIdInfo(@OOXIXo SystemIdInfo systemIdInfo);

    void removeSystemIdInfo(@OOXIXo WorkGenerationalId workGenerationalId);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId")
    void removeSystemIdInfo(@OOXIXo String str);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId AND generation=:generation")
    void removeSystemIdInfo(@OOXIXo String str, int i);
}
