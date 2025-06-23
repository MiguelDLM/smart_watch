package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.work.Data;

@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface WorkProgressDao {
    @Query("DELETE from WorkProgress where work_spec_id=:workSpecId")
    void delete(@OOXIXo String str);

    @Query("DELETE FROM WorkProgress")
    void deleteAll();

    @oOoXoXO
    @Query("SELECT progress FROM WorkProgress WHERE work_spec_id=:workSpecId")
    Data getProgressForWorkSpecId(@OOXIXo String str);

    @Insert(onConflict = 1)
    void insert(@OOXIXo WorkProgress workProgress);
}
