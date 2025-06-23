package com.sma.smartv3.db;

import OXOo.OOXIXo;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.dao.AlipayBindInfoDao;
import com.sma.smartv3.db.dao.BloodGlucose2Dao;
import com.sma.smartv3.db.dao.BloodGlucoseDao;
import com.sma.smartv3.db.dao.BloodOxygenDao;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.dao.DailyPowerDao;
import com.sma.smartv3.db.dao.ElectrocardiogramDao;
import com.sma.smartv3.db.dao.HanBaoVibrationDao;
import com.sma.smartv3.db.dao.HealthyReportDao;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.HrvDao;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.MatchRecordDao;
import com.sma.smartv3.db.dao.PressureDao;
import com.sma.smartv3.db.dao.ScheduleDao;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.dao.SportDataDao;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.dao.WorkoutIndexDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.AlipayBindInfo;
import com.sma.smartv3.db.entity.BloodGlucose;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.DailyPower;
import com.sma.smartv3.db.entity.Electrocardiogram;
import com.sma.smartv3.db.entity.HanBaoVibration;
import com.sma.smartv3.db.entity.HealthyReport;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.MatchLog;
import com.sma.smartv3.db.entity.MatchPeriod;
import com.sma.smartv3.db.entity.MatchRecord;
import com.sma.smartv3.db.entity.Pressure;
import com.sma.smartv3.db.entity.Schedule;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.SportData;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.db.entity.WorkoutIndex;

@Database(entities = {Activity.class, AIRecords.class, HeartRate.class, BloodPressure.class, Sleep.class, Workout.class, Location.class, Weight.class, Temperature.class, Schedule.class, WorkoutIndex.class, BloodOxygen.class, Hrv.class, Pressure.class, MatchLog.class, MatchPeriod.class, MatchRecord.class, SportData.class, BloodGlucose.class, AlipayBindInfo.class, Electrocardiogram.class, BloodGlucose2.class, HanBaoVibration.class, HealthyReport.class, DailyPower.class}, version = 41)
/* loaded from: classes12.dex */
public abstract class AppDatabase extends RoomDatabase {
    @OOXIXo
    public abstract ActivityDao activityDao();

    @OOXIXo
    public abstract AIRecordsDao aiRecordsDao();

    @OOXIXo
    public abstract AlipayBindInfoDao alipayBindInfoDao();

    @OOXIXo
    public abstract BloodGlucose2Dao bloodGlucose2Dao();

    @OOXIXo
    public abstract BloodGlucoseDao bloodGlucoseDao();

    @OOXIXo
    public abstract BloodOxygenDao bloodOxygenDao();

    @OOXIXo
    public abstract BloodPressureDao bloodPressureDao();

    @OOXIXo
    public abstract DailyPowerDao dailyPowerDao();

    @OOXIXo
    public abstract ElectrocardiogramDao electrocardiogramDao();

    @OOXIXo
    public abstract HanBaoVibrationDao hanBaoVibrationDao();

    @OOXIXo
    public abstract HealthyReportDao healthyReportDao();

    @OOXIXo
    public abstract HeartRateDao heartRateDao();

    @OOXIXo
    public abstract HrvDao hrvDao();

    @OOXIXo
    public abstract LocationDao locationDao();

    @OOXIXo
    public abstract MatchRecordDao matchRecordDao();

    @OOXIXo
    public abstract PressureDao pressureDao();

    @OOXIXo
    public abstract ScheduleDao scheduleDao();

    @OOXIXo
    public abstract SleepDao sleepDao();

    @OOXIXo
    public abstract SportDataDao sportDataDao();

    @OOXIXo
    public abstract TemperatureDao temperatureDao();

    @OOXIXo
    public abstract WeightDao weightDao();

    @OOXIXo
    public abstract WorkoutDao workoutDao();

    @OOXIXo
    public abstract WorkoutIndexDao workoutIndexDao();
}
