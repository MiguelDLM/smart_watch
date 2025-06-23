package com.sma.smartv3.db.dao;

import OXOo.OOXIXo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.sma.smartv3.db.entity.MatchLog;
import com.sma.smartv3.db.entity.MatchPeriod;
import com.sma.smartv3.db.entity.MatchRecord;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@Dao
/* loaded from: classes12.dex */
public interface MatchRecordDao {

    @XX({"SMAP\nMatchRecordDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchRecordDao.kt\ncom/sma/smartv3/db/dao/MatchRecordDao$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,74:1\n1855#2,2:75\n1855#2:77\n1855#2,2:78\n1855#2,2:80\n1856#2:82\n*S KotlinDebug\n*F\n+ 1 MatchRecordDao.kt\ncom/sma/smartv3/db/dao/MatchRecordDao$DefaultImpls\n*L\n17#1:75,2\n25#1:77\n27#1:78,2\n32#1:80,2\n25#1:82\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        public static void delete(@OOXIXo MatchRecordDao matchRecordDao, int i) {
            matchRecordDao._deleteMatchLogById(i);
            matchRecordDao._deleteMatchPeriodById(i);
            matchRecordDao._deleteMatchRecordById(i);
        }

        @OOXIXo
        public static List<MatchRecord> getMatchRecords(@OOXIXo MatchRecordDao matchRecordDao, int i, int i2) {
            List<MatchRecord> _getMatchRecords = matchRecordDao._getMatchRecords(i, i2);
            for (MatchRecord matchRecord : _getMatchRecords) {
                matchRecord.setMPeriodList(matchRecordDao._getMatchPeriodsById(matchRecord.getMId()));
                matchRecord.setMLogList(matchRecordDao._getMatchLogById(matchRecord.getMId()));
            }
            return _getMatchRecords;
        }

        public static void insert(@OOXIXo MatchRecordDao matchRecordDao, @OOXIXo List<MatchRecord> list) {
            IIX0o.x0xO0oo(list, "list");
            for (MatchRecord matchRecord : list) {
                long _insertMatchRecord = matchRecordDao._insertMatchRecord(matchRecord);
                Iterator<T> it = matchRecord.getMPeriodList().iterator();
                while (it.hasNext()) {
                    ((MatchPeriod) it.next()).setMMatchRecordId((int) _insertMatchRecord);
                }
                matchRecordDao._insertMatchPeriod(matchRecord.getMPeriodList());
                Iterator<T> it2 = matchRecord.getMLogList().iterator();
                while (it2.hasNext()) {
                    ((MatchLog) it2.next()).setMMatchRecordId((int) _insertMatchRecord);
                }
                matchRecordDao._insertMatchLog(matchRecord.getMLogList());
            }
        }
    }

    @Query("DELETE FROM MatchLog WHERE mMatchRecordId = :matchRecordId")
    void _deleteMatchLogById(int i);

    @Query("DELETE FROM MatchPeriod WHERE mMatchRecordId = :matchRecordId")
    void _deleteMatchPeriodById(int i);

    @Query("DELETE FROM MatchRecord WHERE mId = :id")
    void _deleteMatchRecordById(int i);

    @OOXIXo
    @Query("SELECT * FROM MatchLog WHERE mMatchRecordId = :matchRecordId")
    List<MatchLog> _getMatchLogById(int i);

    @OOXIXo
    @Query("SELECT * FROM MatchPeriod WHERE mMatchRecordId = :matchRecordId")
    List<MatchPeriod> _getMatchPeriodsById(int i);

    @OOXIXo
    @Query("SELECT * FROM MatchRecord WHERE  mIsDelete != 1 ORDER BY mStart DESC LIMIT :startIndex, :endIndex")
    List<MatchRecord> _getMatchRecords(int i, int i2);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] _insertMatchLog(@OOXIXo List<MatchLog> list);

    @Insert(onConflict = 1)
    @OOXIXo
    long[] _insertMatchPeriod(@OOXIXo List<MatchPeriod> list);

    @Insert(onConflict = 1)
    long _insertMatchRecord(@OOXIXo MatchRecord matchRecord);

    void delete(int i);

    @OOXIXo
    @Query("SELECT * FROM MatchRecord WHERE mIsDelete != 1")
    List<MatchRecord> getList();

    @OOXIXo
    @Query("SELECT * FROM MatchRecord WHERE mIsDelete != 1 AND mSource = :source")
    List<MatchRecord> getListBySource(int i);

    @OOXIXo
    List<MatchRecord> getMatchRecords(int i, int i2);

    void insert(@OOXIXo List<MatchRecord> list);

    @Update
    int update(@OOXIXo List<MatchRecord> list);
}
