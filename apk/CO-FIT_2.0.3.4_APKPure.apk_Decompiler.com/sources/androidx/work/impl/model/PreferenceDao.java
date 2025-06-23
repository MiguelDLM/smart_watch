package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PreferenceDao {
    @oOoXoXO
    @Query("SELECT long_value FROM Preference where `key`=:key")
    Long getLongValue(@OOXIXo String str);

    @OOXIXo
    @Query("SELECT long_value FROM Preference where `key`=:key")
    LiveData<Long> getObservableLongValue(@OOXIXo String str);

    @Insert(onConflict = 1)
    void insertPreference(@OOXIXo Preference preference);
}
