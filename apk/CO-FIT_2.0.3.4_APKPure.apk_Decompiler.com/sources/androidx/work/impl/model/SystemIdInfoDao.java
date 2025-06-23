package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

@Dao
public interface SystemIdInfoDao {

    public static final class DefaultImpls {
        @Deprecated
        @oOoXoXO
        public static SystemIdInfo getSystemIdInfo(@OOXIXo SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId workGenerationalId) {
            IIX0o.x0xO0oo(workGenerationalId, "id");
            return I0Io.oIX0oI(systemIdInfoDao, workGenerationalId);
        }

        @Deprecated
        public static void removeSystemIdInfo(@OOXIXo SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId workGenerationalId) {
            IIX0o.x0xO0oo(workGenerationalId, "id");
            I0Io.II0xO0(systemIdInfoDao, workGenerationalId);
        }
    }

    @oOoXoXO
    SystemIdInfo getSystemIdInfo(@OOXIXo WorkGenerationalId workGenerationalId);

    @oOoXoXO
    @Query("SELECT * FROM SystemIdInfo WHERE work_spec_id=:workSpecId AND generation=:generation")
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
