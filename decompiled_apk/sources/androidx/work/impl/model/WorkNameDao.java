package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
/* loaded from: classes.dex */
public interface WorkNameDao {
    @OOXIXo
    @Query("SELECT name FROM workname WHERE work_spec_id=:workSpecId")
    List<String> getNamesForWorkSpecId(@OOXIXo String str);

    @OOXIXo
    @Query("SELECT work_spec_id FROM workname WHERE name=:name")
    List<String> getWorkSpecIdsWithName(@OOXIXo String str);

    @Insert(onConflict = 5)
    void insert(@OOXIXo WorkName workName);
}
