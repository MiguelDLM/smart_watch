package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.baidu.mobads.sdk.internal.bn;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
@XX({"SMAP\nWorkTagDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkTagDao.kt\nandroidx/work/impl/model/WorkTagDao\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1855#2,2:64\n*S KotlinDebug\n*F\n+ 1 WorkTagDao.kt\nandroidx/work/impl/model/WorkTagDao\n*L\n60#1:64,2\n*E\n"})
public interface WorkTagDao {

    public static final class DefaultImpls {
        @Deprecated
        public static void insertTags(@OOXIXo WorkTagDao workTagDao, @OOXIXo String str, @OOXIXo Set<String> set) {
            IIX0o.x0xO0oo(str, "id");
            IIX0o.x0xO0oo(set, bn.l);
            Oxx0IOOO.oIX0oI(workTagDao, str, set);
        }
    }

    @Query("DELETE FROM worktag WHERE work_spec_id=:id")
    void deleteByWorkSpecId(@OOXIXo String str);

    @OOXIXo
    @Query("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=:id")
    List<String> getTagsForWorkSpecId(@OOXIXo String str);

    @OOXIXo
    @Query("SELECT work_spec_id FROM worktag WHERE tag=:tag")
    List<String> getWorkSpecIdsWithTag(@OOXIXo String str);

    @Insert(onConflict = 5)
    void insert(@OOXIXo WorkTag workTag);

    void insertTags(@OOXIXo String str, @OOXIXo Set<String> set);
}
