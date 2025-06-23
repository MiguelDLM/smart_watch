package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.component.BleCache;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.X0IIOO;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import xX0ox.Oxx0IOOO;

@XX({"SMAP\nSportRecordData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportRecordData.kt\ncom/sma/smartv3/model/SportRecordDataKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1055:1\n1011#2,2:1056\n1011#2,2:1058\n1011#2,2:1060\n1549#2:1062\n1620#2,3:1063\n*S KotlinDebug\n*F\n+ 1 SportRecordData.kt\ncom/sma/smartv3/model/SportRecordDataKt\n*L\n165#1:1056,2\n212#1:1058,2\n254#1:1060,2\n1006#1:1062\n1006#1:1063,3\n*E\n"})
/* loaded from: classes12.dex */
public final class SportRecordDataKt {
    public static final int ACTIVITY = 0;
    public static final int PHONE_SPORT = 2;
    public static final int WORKOUT = 1;

    public static final void deleteSportRecord(@OOXIXo SportRecordData sportRecordData) {
        IIX0o.x0xO0oo(sportRecordData, "sportRecordData");
        LogUtils.d("delete " + sportRecordData);
        if (sportRecordData.getMSource() == 0) {
            ActivityDao activityDao = MyDb.INSTANCE.getMDatabase().activityDao();
            List<Activity> workoutListDESC = activityDao.getWorkoutListDESC(sportRecordData.getMStartTime(), sportRecordData.getMEndTime(), sportRecordData.getMMode());
            List<Activity> list = workoutListDESC;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
            for (Activity activity : list) {
                activity.setMIsSync(0);
                activity.setMIsDelete(1);
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
            }
            activityDao.update(workoutListDESC);
            return;
        }
        WorkoutDao workoutDao = MyDb.INSTANCE.getMDatabase().workoutDao();
        Workout workout = workoutDao.getWorkout(sportRecordData.getMStartTime(), sportRecordData.getMEndTime());
        workout.setMIsSync(0);
        workout.setMIsDelete(1);
        workoutDao.update(workout);
    }

    @OOXIXo
    public static final ArrayList<SportRecordData> getActivityWorkoutList(@OOXIXo List<Activity> workoutActivity) {
        IIX0o.x0xO0oo(workoutActivity, "workoutActivity");
        ArrayList<SportRecordData> arrayList = new ArrayList<>();
        while (true) {
            long j = 0;
            long j2 = 0;
            int i = -1;
            for (Activity activity : workoutActivity) {
                if (i >= 0 || activity.getMState() == 4) {
                    int mState = activity.getMState();
                    if (mState != 0) {
                        if (mState == 4) {
                            i = activity.getMMode();
                            j = activity.getMTime();
                        }
                    } else if (activity.getMMode() == i && j > activity.getMTime()) {
                        j2 = activity.getMTime();
                    } else {
                        i = -1;
                    }
                    if (i > 0 && j2 > 0) {
                        break;
                    }
                }
            }
            return arrayList;
            SportRecordData sportRecordData = new SportRecordData();
            sportRecordData.setMStartTime(j2);
            sportRecordData.setMEndTime(j);
            sportRecordData.setMMode(i);
            sportRecordData.setMSource(0);
            arrayList.add(sportRecordData);
        }
    }

    public static final int getGpsState(@OOXIXo SportRecordData sportRecordData) {
        IIX0o.x0xO0oo(sportRecordData, "sportRecordData");
        if (sportRecordData.getMIsLocationEmpty()) {
            return R.drawable.icon_no_gps;
        }
        return R.drawable.icon_gps;
    }

    @OOXIXo
    public static final ArrayList<SportRecordData> getSportRecordList(int i, int i2) {
        long mTime;
        ArrayList<SportRecordData> arrayList = new ArrayList<>();
        MyDb myDb = MyDb.INSTANCE;
        ActivityDao activityDao = myDb.getMDatabase().activityDao();
        WorkoutDao workoutDao = myDb.getMDatabase().workoutDao();
        List<Activity> stateActivityList = activityDao.getStateActivityList(0, i, i2);
        if (!stateActivityList.isEmpty()) {
            if (i == 0) {
                mTime = new Date().getTime();
            } else {
                mTime = ((Activity) CollectionsKt___CollectionsKt.O0OOX0IIx(stateActivityList)).getMTime();
            }
            arrayList.addAll(getActivityWorkoutList(activityDao.getListDESC(((Activity) CollectionsKt___CollectionsKt.O0O0Io00X(stateActivityList)).getMTime(), mTime)));
        }
        List<Workout> listDESC = workoutDao.getListDESC(i == 0 ? 0 : i + 1, i2, 0);
        if (!listDESC.isEmpty()) {
            for (Workout workout : listDESC) {
                SportRecordData sportRecordData = new SportRecordData();
                sportRecordData.setMStartTime(workout.getMStart());
                sportRecordData.setMEndTime(workout.getMEnd());
                sportRecordData.setMMode(workout.getMMode());
                sportRecordData.setMSource(workout.getMSource() == 1 ? 2 : 1);
                sportRecordData.setMWorkoutId(workout.getMId());
                sportRecordData.setMDistance(workout.getMDistance());
                sportRecordData.setMPace(workout.getMPace());
                sportRecordData.setMCalorie(workout.getMCalorie());
                sportRecordData.setMDuration(workout.getMDuration());
                sportRecordData.setMPlatform(workout.getMPlatform());
                sportRecordData.setMSpeed(workout.getMSpeed());
                arrayList.add(sportRecordData);
            }
        }
        if (arrayList.size() > 1) {
            o00.OO0x0xX(arrayList, new Comparator() { // from class: com.sma.smartv3.model.SportRecordDataKt$getSportRecordList$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return Oxx0IOOO.oOoXoXO(Long.valueOf(((SportRecordData) t2).getMStartTime()), Long.valueOf(((SportRecordData) t).getMStartTime()));
                }
            });
        }
        return arrayList;
    }

    public static /* synthetic */ ArrayList getSportRecordList$default(long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return getSportRecordList(j, j2, i);
    }

    @OOXIXo
    public static final ArrayList<SportRecordData> getSportRecordListByMode(int i, int i2, int i3) {
        int i4;
        ArrayList<SportRecordData> arrayList = new ArrayList<>();
        WorkoutDao workoutDao = MyDb.INSTANCE.getMDatabase().workoutDao();
        if (i == 0) {
            i4 = 0;
        } else {
            i4 = i + 1;
        }
        List<Workout> listDESCByMode = workoutDao.getListDESCByMode(i4, i2, i3);
        if (!listDESCByMode.isEmpty()) {
            for (Workout workout : listDESCByMode) {
                SportRecordData sportRecordData = new SportRecordData();
                sportRecordData.setMStartTime(workout.getMStart());
                sportRecordData.setMEndTime(workout.getMEnd());
                sportRecordData.setMMode(workout.getMMode());
                sportRecordData.setMSource(1);
                sportRecordData.setMWorkoutId(workout.getMId());
                sportRecordData.setMDistance(workout.getMDistance());
                sportRecordData.setMPace(workout.getMPace());
                sportRecordData.setMCalorie(workout.getMCalorie());
                sportRecordData.setMDuration(workout.getMDuration());
                sportRecordData.setMPlatform(workout.getMPlatform());
                arrayList.add(sportRecordData);
            }
        }
        if (arrayList.size() > 1) {
            o00.OO0x0xX(arrayList, new Comparator() { // from class: com.sma.smartv3.model.SportRecordDataKt$getSportRecordListByMode$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return Oxx0IOOO.oOoXoXO(Long.valueOf(((SportRecordData) t2).getMStartTime()), Long.valueOf(((SportRecordData) t).getMStartTime()));
                }
            });
        }
        return arrayList;
    }

    @OOXIXo
    public static final String getSportStartTime(@OOXIXo SportRecordData sportRecordData) {
        IIX0o.x0xO0oo(sportRecordData, "sportRecordData");
        String format = xoIox.oxxXoxO(false, false, 3, null).format(Long.valueOf(sportRecordData.getMStartTime()));
        IIX0o.oO(format, "format(...)");
        return format;
    }

    public static final int getWorkoutImage(@OOXIXo Context mContext, @OOXIXo SportRecordData sportRecordData) {
        IIX0o.x0xO0oo(mContext, "mContext");
        IIX0o.x0xO0oo(sportRecordData, "sportRecordData");
        try {
            int identifier = mContext.getResources().getIdentifier("ic_workout" + sportRecordData.getMMode(), "drawable", mContext.getPackageName());
            if (identifier == 0) {
                return R.drawable.ic_workout9;
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.ic_workout9;
        }
    }

    public static final int getWorkoutName(@OOXIXo Context mContext, @OOXIXo SportRecordData sportRecordData) {
        IIX0o.x0xO0oo(mContext, "mContext");
        IIX0o.x0xO0oo(sportRecordData, "sportRecordData");
        try {
            int identifier = mContext.getResources().getIdentifier(NotificationCompat.CATEGORY_WORKOUT + sportRecordData.getMMode(), TypedValues.Custom.S_STRING, mContext.getPackageName());
            if (identifier == 0) {
                return R.string.workout9;
            }
            if (ProductManager.f20544oIX0oI.xxx00()) {
                int identifier2 = mContext.getResources().getIdentifier(NotificationCompat.CATEGORY_WORKOUT + sportRecordData.getMMode() + "_2", TypedValues.Custom.S_STRING, mContext.getPackageName());
                if (identifier2 != 0) {
                    return identifier2;
                }
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return R.string.workout9;
        }
    }

    @OOXIXo
    public static final SportRecordItemCommonData parseSportRecordItemCommonData(@OOXIXo Context context, @OOXIXo AppUser userProfile, @OOXIXo SportRecordData sportRecordData) {
        RecordActivityData sportRecordWorkout;
        String valueOf;
        List X00IoxXI2;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(userProfile, "userProfile");
        IIX0o.x0xO0oo(sportRecordData, "sportRecordData");
        MyDb myDb = MyDb.INSTANCE;
        HeartRateDao heartRateDao = myDb.getMDatabase().heartRateDao();
        LocationDao locationDao = myDb.getMDatabase().locationDao();
        if (sportRecordData.getMSource() == 0) {
            sportRecordWorkout = sportRecordActivity(sportRecordData.getMStartTime(), sportRecordData.getMEndTime(), userProfile.getUnit());
        } else {
            sportRecordWorkout = sportRecordWorkout(sportRecordData.getMStartTime(), sportRecordData.getMEndTime(), userProfile.getUnit());
        }
        if (sportRecordWorkout.getMAvgBpm() <= 0 && (sportRecordData.getMSource() != 2 || sportRecordWorkout.getMAvgBpm() != 0)) {
            valueOf = sportRecordHeartRate(heartRateDao, sportRecordWorkout.getMTimeList());
        } else {
            valueOf = String.valueOf(sportRecordWorkout.getMAvgBpm());
        }
        sportRecordData.setMIsLocationEmpty(sportRecordLocation(locationDao, sportRecordData.getMStartTime(), sportRecordData.getMEndTime()));
        int gpsState = getGpsState(sportRecordData);
        int mMode = sportRecordData.getMMode();
        if (mMode != 12) {
            if (mMode != 116) {
                switch (mMode) {
                    case 8:
                        break;
                    case 9:
                        X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(new SportRecordItemData(valueOf, R.drawable.icon_sport_hr), new SportRecordItemData(sportRecordWorkout.getMSportTimeStr(), R.drawable.icon_time), new SportRecordItemData(String.valueOf(sportRecordWorkout.getMDistanceTotal()), R.drawable.icon_distance_72));
                        break;
                    case 10:
                        if (BleCache.INSTANCE.getMAGpsType() == 0 && !ProductManager.f20544oIX0oI.o0oIxOo()) {
                            X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(new SportRecordItemData(valueOf, R.drawable.icon_sport_hr), new SportRecordItemData(sportRecordWorkout.getMSportTimeStr(), R.drawable.icon_time), new SportRecordItemData(String.valueOf(sportRecordWorkout.getMCalorieTotal()), R.drawable.icon_calories_72));
                            break;
                        } else {
                            X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(new SportRecordItemData(String.valueOf(sportRecordWorkout.getMSpeed()), R.drawable.icon_speed), new SportRecordItemData(sportRecordWorkout.getMSportTimeStr(), R.drawable.icon_time), new SportRecordItemData(String.valueOf(sportRecordWorkout.getMDistanceTotal()), R.drawable.icon_distance_72));
                            break;
                        }
                        break;
                    default:
                        X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(new SportRecordItemData(valueOf, R.drawable.icon_sport_hr), new SportRecordItemData(sportRecordWorkout.getMSportTimeStr(), R.drawable.icon_time), new SportRecordItemData(String.valueOf(sportRecordWorkout.getMCalorieTotal()), R.drawable.icon_calories_72));
                        break;
                }
            } else {
                X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(new SportRecordItemData(valueOf, R.drawable.icon_sport_hr), new SportRecordItemData(sportRecordWorkout.getMSportTimeStr(), R.drawable.icon_time), new SportRecordItemData(String.valueOf(sportRecordWorkout.getMAvgStress()), R.drawable.icon_pressure_72));
            }
            List list = X00IoxXI2;
            LogUtils.d("sportRecordData " + sportRecordData);
            return new SportRecordItemCommonData(getSportStartTime(sportRecordData), getWorkoutImage(context, sportRecordData), getWorkoutName(context, sportRecordData), gpsState, list, 3, "", sportRecordData.getMDistance(), sportRecordData.getMPace(), sportRecordData.getMCalorie(), sportRecordData.getMDuration(), sportRecordData.getMMode(), sportRecordData.getMPlatform(), 0.0f, sportRecordData.getMSpeed(), 8192, null);
        }
        X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(new SportRecordItemData(valueOf, R.drawable.icon_sport_hr), new SportRecordItemData(sportRecordWorkout.getMSportTimeStr(), R.drawable.icon_time), new SportRecordItemData(String.valueOf(sportRecordWorkout.getMStepTotal()), R.drawable.icon_step));
        List list2 = X00IoxXI2;
        LogUtils.d("sportRecordData " + sportRecordData);
        return new SportRecordItemCommonData(getSportStartTime(sportRecordData), getWorkoutImage(context, sportRecordData), getWorkoutName(context, sportRecordData), gpsState, list2, 3, "", sportRecordData.getMDistance(), sportRecordData.getMPace(), sportRecordData.getMCalorie(), sportRecordData.getMDuration(), sportRecordData.getMMode(), sportRecordData.getMPlatform(), 0.0f, sportRecordData.getMSpeed(), 8192, null);
    }

    @OOXIXo
    public static final RecordActivityData sportRecordActivity(long j, long j2, int i) {
        int i2;
        int i3;
        int i4;
        List<Activity> list;
        int i5;
        int i6;
        List<Activity> listDESC = MyDb.INSTANCE.getMDatabase().activityDao().getListDESC(j, j2);
        ArrayList arrayList = new ArrayList();
        int size = listDESC.size();
        int i7 = -1;
        long j3 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i8 < size) {
            Activity activity = listDESC.get(i8);
            if (i7 < 0 && activity.getMState() != 4) {
                list = listDESC;
                i5 = size;
            } else {
                list = listDESC;
                i5 = size;
                if (OxI.XO0o(activity.getMLocalTime(), "00:00:00", false, 2, null)) {
                    i10 += i13;
                    i11 += i14;
                    i12 += i15;
                }
                int i16 = i11;
                int i17 = i12;
                if (OxI.XO0o(activity.getMLocalTime(), "23:59:00", false, 2, null)) {
                    i13 = activity.getMStep();
                    i14 = activity.getMCalorie();
                    i15 = activity.getMDistance();
                }
                int mState = activity.getMState();
                if (mState != 0) {
                    if (mState != 2) {
                        if (mState != 3) {
                            if (mState == 4) {
                                LogUtils.d("END " + activity.getMStep() + TokenParser.SP + activity.getMCalorie() + TokenParser.SP + activity.getMDistance());
                                int mMode = activity.getMMode();
                                long mTime = activity.getMTime();
                                i13 = activity.getMStep();
                                i14 = activity.getMCalorie();
                                i15 = activity.getMDistance();
                                arrayList.add(new RecordTimeList(activity.getMTime(), activity.getMState()));
                                i11 = i16;
                                j3 = mTime;
                                i12 = i17;
                                i7 = mMode;
                            }
                        } else if (activity.getMMode() == i7) {
                            LogUtils.d("RESUME " + activity.getMStep() + TokenParser.SP + activity.getMCalorie() + TokenParser.SP + activity.getMDistance() + TokenParser.SP + i10 + "  " + i16 + TokenParser.SP + i17);
                            long mTime2 = activity.getMTime();
                            i10 += i13 - activity.getMStep();
                            i11 = i16 + (i14 - activity.getMCalorie());
                            i12 = i17 + (i15 - activity.getMDistance());
                            arrayList.add(new RecordTimeList(activity.getMTime(), activity.getMState()));
                            j3 = mTime2;
                            i6 = 1;
                            i13 = 0;
                            i14 = 0;
                            i15 = 0;
                            i8 += i6;
                            listDESC = list;
                            size = i5;
                        }
                    } else if (activity.getMMode() == i7 && j3 > activity.getMTime()) {
                        LogUtils.d("PAUSE " + activity.getMStep() + TokenParser.SP + activity.getMCalorie() + TokenParser.SP + activity.getMDistance());
                        i9 += (int) (j3 - activity.getMTime());
                        i13 = activity.getMStep();
                        i14 = activity.getMCalorie();
                        i15 = activity.getMDistance();
                        if (arrayList.size() == 1 && ((RecordTimeList) CollectionsKt___CollectionsKt.O0O0Io00X(arrayList)).getMState() == 4) {
                            arrayList.clear();
                        }
                        arrayList.add(new RecordTimeList(activity.getMTime(), activity.getMState()));
                    }
                    i11 = i16;
                    i12 = i17;
                } else {
                    if (activity.getMMode() == i7) {
                        LogUtils.d("BEGIN " + activity.getMStep() + TokenParser.SP + activity.getMCalorie() + TokenParser.SP + activity.getMDistance() + TokenParser.SP + i10 + TokenParser.SP + i16 + TokenParser.SP + i17);
                        i10 += i13 - activity.getMStep();
                        i11 = i16 + (i14 - activity.getMCalorie());
                        i12 = i17 + (i15 - activity.getMDistance());
                        arrayList.add(new RecordTimeList(activity.getMTime(), activity.getMState()));
                    }
                    i11 = i16;
                    i12 = i17;
                }
            }
            i6 = 1;
            i8 += i6;
            listDESC = list;
            size = i5;
        }
        X0IIOO.oXX0IoI(arrayList);
        int i18 = (int) ((j2 - j) - i9);
        int i19 = i18 / 1000;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i2 = 0;
        } else {
            i2 = i11;
        }
        if (i12 < 0) {
            i3 = 0;
        } else {
            i3 = i12;
        }
        if (i9 < 10000) {
            i9 = 0;
        }
        RecordActivityData recordActivityData = new RecordActivityData();
        recordActivityData.setMStepTotal(i10);
        recordActivityData.setMCalorieTotal(i2 / 10000);
        int i20 = i3 / 10000;
        recordActivityData.setMDistanceTotal(TextConvertKt.oOoXoXO(i20, i, false));
        recordActivityData.setMPauseTimeTotal(xoIox.IoOoX(i9));
        recordActivityData.setMSportTimeStr(xoIox.IoOoX(i18));
        recordActivityData.getMTimeList().addAll(arrayList);
        recordActivityData.setMSpeed(TextConvertKt.xXOx(i20, i19, i));
        int i21 = i10 * 60;
        if (i19 <= 0) {
            i4 = 1;
        } else {
            i4 = i19;
        }
        recordActivityData.setMSpm(i21 / i4);
        recordActivityData.setMPace(TextConvertKt.x0o(TextConvertKt.x0XOIxOo(i20, i), i19));
        return recordActivityData;
    }

    @OOXIXo
    public static final RecordDetailSpeedData sportRecordActivityDetailSpeed(@OOXIXo ArrayList<RecordTimeList> mTimeList, int i, int i2) {
        int i3;
        int i4;
        int i5;
        IIX0o.x0xO0oo(mTimeList, "mTimeList");
        ActivityDao activityDao = MyDb.INSTANCE.getMDatabase().activityDao();
        ArrayList arrayList = new ArrayList();
        char c = 0;
        LogUtils.i("sportRecordActivityDetailSpeed " + mTimeList.size());
        int size = mTimeList.size() + (-2);
        float f = 0.0f;
        if (size >= 0) {
            int i6 = 0;
            float f2 = 0.0f;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = i6 + 1;
                int i10 = i6;
                List<Activity> workoutListDESC = activityDao.getWorkoutListDESC(mTimeList.get(i6).getMTime(), mTimeList.get(i9).getMTime(), i);
                Object[] objArr = new Object[1];
                objArr[c] = "sportRecordActivityDetailSpeed " + workoutListDESC.size();
                LogUtils.i(objArr);
                int size2 = workoutListDESC.size();
                int i11 = 0;
                while (i11 < size2) {
                    Activity activity = workoutListDESC.get(i11);
                    if (i11 < workoutListDESC.size() - 1) {
                        int i12 = i11 + 1;
                        int mDistance = activity.getMDistance() - workoutListDESC.get(i12).getMDistance();
                        long mTime = activity.getMTime() - workoutListDESC.get(i12).getMTime();
                        i5 = size;
                        int abs = Math.abs((int) (mTime / 1000));
                        float xXOx2 = TextConvertKt.xXOx(mDistance / 10000, abs, i2);
                        if (f2 < xXOx2) {
                            f2 = xXOx2;
                        }
                        int i13 = i8 + mDistance;
                        int i14 = i7 + abs;
                        float x0XOIxOo2 = TextConvertKt.x0XOIxOo(i13 / 10000, i2);
                        i8 = i13;
                        if (x0XOIxOo2 >= 1.0d) {
                            arrayList.add(Integer.valueOf(TextConvertKt.x0o(x0XOIxOo2, i14)));
                            i7 = 0;
                            i8 = 0;
                        } else {
                            i7 = i14;
                        }
                    } else {
                        i5 = size;
                    }
                    i11++;
                    size = i5;
                }
                int i15 = size;
                if (i10 == i15) {
                    break;
                }
                size = i15;
                i6 = i9;
                c = 0;
            }
            f = f2;
            i3 = i7;
            i4 = i8;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (i4 > 0) {
            arrayList.add(Integer.valueOf(TextConvertKt.x0o(TextConvertKt.x0XOIxOo(i4 / 1000, i2), i3)));
        }
        LogUtils.i("sportRecordActivityDetailSpeed " + arrayList.size());
        RecordDetailSpeedData recordDetailSpeedData = new RecordDetailSpeedData();
        recordDetailSpeedData.setMFastestSpeed(f);
        recordDetailSpeedData.getMPaceList().addAll(arrayList);
        return recordDetailSpeedData;
    }

    @OOXIXo
    public static final String sportRecordHeartRate(@OOXIXo HeartRateDao mHeartRateDao, @OOXIXo ArrayList<RecordTimeList> mTimeList) {
        IIX0o.x0xO0oo(mHeartRateDao, "mHeartRateDao");
        IIX0o.x0xO0oo(mTimeList, "mTimeList");
        int size = mTimeList.size() - 2;
        int i = 0;
        int i2 = 0;
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i + 1;
                for (HeartRate heartRate : mHeartRateDao.getHeartRates(mTimeList.get(i).getMTime(), mTimeList.get(i4).getMTime())) {
                    if (heartRate.getMBpm() > 0) {
                        i2 += heartRate.getMBpm();
                        i3++;
                    }
                }
                if (i == size) {
                    break;
                }
                i = i4;
            }
            i = i3;
        }
        if (i == 0) {
            return "0";
        }
        return String.valueOf(i2 / i);
    }

    @OOXIXo
    public static final RecordDetailHeartRateData sportRecordHeartRateDetail(@OOXIXo HeartRateDao heartRateDao, @OOXIXo ArrayList<RecordTimeList> arrayList) {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j5;
        int i6;
        int i7;
        int i8;
        HeartRateDao mHeartRateDao = heartRateDao;
        ArrayList<RecordTimeList> mTimeList = arrayList;
        IIX0o.x0xO0oo(mHeartRateDao, "mHeartRateDao");
        IIX0o.x0xO0oo(mTimeList, "mTimeList");
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size() - 2;
        long j6 = 0;
        if (size >= 0) {
            long j7 = 0;
            j = 0;
            j2 = 0;
            j3 = 0;
            int i9 = 0;
            i3 = 0;
            i4 = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                j5 = j6;
                int i12 = i9 + 1;
                j4 = j7;
                List<HeartRate> heartRates = mHeartRateDao.getHeartRates(mTimeList.get(i9).getMTime(), mTimeList.get(i12).getMTime());
                int size2 = heartRates.size();
                i6 = i10;
                int i13 = 0;
                while (i13 < size2) {
                    HeartRate heartRate = heartRates.get(i13);
                    if (i11 == 0) {
                        i11 = heartRate.getMBpm();
                    }
                    int i14 = i11;
                    if (heartRate.getMBpm() > 0) {
                        arrayList2.add(heartRate);
                        i3 += heartRate.getMBpm();
                        i7 = size2;
                        if (i6 < heartRate.getMBpm()) {
                            i6 = heartRate.getMBpm();
                        }
                        if (i14 > heartRate.getMBpm()) {
                            i14 = heartRate.getMBpm();
                        }
                        i4++;
                        if (i13 < heartRates.size() - 1) {
                            long mTime = heartRates.get(i13 + 1).getMTime() - heartRate.getMTime();
                            i8 = i14;
                            if (heartRate.getMBpm() >= 140) {
                                j5 += mTime;
                            } else if (heartRate.getMBpm() >= 114) {
                                j4 += mTime;
                            } else if (heartRate.getMBpm() >= 90) {
                                j += mTime;
                            } else if (heartRate.getMBpm() >= 80) {
                                j2 += mTime;
                            } else {
                                j3 += mTime;
                            }
                        } else {
                            i8 = i14;
                        }
                        i11 = i8;
                    } else {
                        i7 = size2;
                        i11 = i14;
                    }
                    i13++;
                    size2 = i7;
                }
                if (i9 == size) {
                    break;
                }
                mHeartRateDao = heartRateDao;
                mTimeList = arrayList;
                i10 = i6;
                i9 = i12;
                j6 = j5;
                j7 = j4;
            }
            i = i6;
            i2 = i11;
            j6 = j5;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        if (i4 == 0) {
            i5 = 0;
        } else {
            i5 = i3 / i4;
        }
        RecordDetailHeartRateData recordDetailHeartRateData = new RecordDetailHeartRateData();
        recordDetailHeartRateData.setMAvgHR(i5);
        recordDetailHeartRateData.setMMaxHR(i);
        recordDetailHeartRateData.setMMinHR(i2);
        recordDetailHeartRateData.getMHeartRateList().addAll(arrayList2);
        long j8 = 1000;
        long j9 = 60;
        recordDetailHeartRateData.setMStrenuous((j6 / j8) / j9);
        recordDetailHeartRateData.setMAnaerobic((j4 / j8) / j9);
        recordDetailHeartRateData.setMAerobic((j / j8) / j9);
        recordDetailHeartRateData.setMFatBurning((j2 / j8) / j9);
        recordDetailHeartRateData.setMWarmUp((j3 / j8) / j9);
        return recordDetailHeartRateData;
    }

    public static final boolean sportRecordLocation(@OOXIXo LocationDao mLocationDao, long j, long j2) {
        IIX0o.x0xO0oo(mLocationDao, "mLocationDao");
        List<Location> location = mLocationDao.getLocation(j, j2);
        if (!location.isEmpty() && location.size() >= 2) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public static final RecordActivityData sportRecordWorkout(long j, long j2, int i) {
        Workout workout = MyDb.INSTANCE.getMDatabase().workoutDao().getWorkout(j, j2);
        ArrayList Oxx0xo2 = CollectionsKt__CollectionsKt.Oxx0xo(new RecordTimeList(workout.getMStart(), 0), new RecordTimeList(workout.getMEnd(), 0));
        int mEnd = (int) ((workout.getMEnd() - workout.getMStart()) - (workout.getMDuration() * 1000));
        if (mEnd < 10000) {
            mEnd = 0;
        }
        RecordActivityData recordActivityData = new RecordActivityData();
        recordActivityData.setMSportTimeStr(xoIox.IoOoX(workout.getMDuration() * 1000));
        recordActivityData.setMPauseTimeTotal(xoIox.IoOoX(mEnd));
        recordActivityData.getMTimeList().addAll(Oxx0xo2);
        recordActivityData.setMAltitude(workout.getMAltitude());
        recordActivityData.setMSpm(workout.getMSpm());
        recordActivityData.setMStepTotal(workout.getMStep());
        recordActivityData.setMDistanceTotal(TextConvertKt.ooOOo0oXI(workout.getMDistance(), i, false, 4, null));
        recordActivityData.setMCalorieTotal(workout.getMCalorie() / 1000);
        recordActivityData.setMSpeed(TextConvertKt.xo0x(workout.getMSpeed() / 1000.0d, i));
        recordActivityData.setMPace(workout.getMPace());
        recordActivityData.setMAvgBpm(workout.getMAvgBpm());
        recordActivityData.setMMaxBpm(workout.getMMaxBpm());
        recordActivityData.setMMinBpm(workout.getMMinBpm());
        recordActivityData.setMMaxSpm(workout.getMMaxSpm());
        recordActivityData.setMMinSpm(workout.getMMinSpm());
        recordActivityData.setMMaxPace(workout.getMMaxPace());
        recordActivityData.setMMinPace(workout.getMMinPace());
        recordActivityData.setMMinStress(workout.getMMinStress());
        recordActivityData.setMMaxStress(workout.getMMaxStress());
        recordActivityData.setMAvgStress(workout.getMAvgStress());
        recordActivityData.setMPlatform(workout.getMPlatform());
        recordActivityData.setMAvgSpeed(workout.getMAvgSpeed());
        return recordActivityData;
    }

    @OOXIXo
    public static final RecordDetailSpeedData sportRecordWorkoutDetailSpeed(@OOXIXo ArrayList<RecordTimeList> mTimeList, int i, int i2, @OOXIXo ArrayList<CustomLatLng> locationList) {
        int i3;
        int i4;
        IIX0o.x0xO0oo(mTimeList, "mTimeList");
        IIX0o.x0xO0oo(locationList, "locationList");
        int i5 = 1;
        LogUtils.d("test mTimeList.size =  " + mTimeList.size());
        ArrayList arrayList = new ArrayList();
        int size = locationList.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        float f = 0.0f;
        while (i6 < size) {
            CustomLatLng customLatLng = locationList.get(i6);
            IIX0o.oO(customLatLng, "get(...)");
            CustomLatLng customLatLng2 = customLatLng;
            if (i6 < locationList.size() - i5) {
                int i9 = i6 + 1;
                i3 = size;
                int distance = (int) DistanceUtil.getDistance(new LatLng(customLatLng2.getLatitude(), customLatLng2.getLongitude()), new LatLng(locationList.get(i9).getLatitude(), locationList.get(i9).getLongitude()));
                int abs = Math.abs((int) ((customLatLng2.getTime() - locationList.get(i9).getTime()) / 1000));
                float xXOx2 = TextConvertKt.xXOx(distance, abs, i2);
                LogUtils.d("test " + f + TokenParser.SP + xXOx2 + "  " + distance + TokenParser.SP + abs + "  " + locationList.get(i6));
                if (f < xXOx2 && xXOx2 < 150.0f) {
                    f = xXOx2;
                }
                i7 += distance;
                i8 += abs;
                float x0XOIxOo2 = TextConvertKt.x0XOIxOo(i7, i2);
                if (x0XOIxOo2 >= 1.0d) {
                    LogUtils.d(" distanceToKmNumber " + i6 + TokenParser.SP + x0XOIxOo2);
                    arrayList.add(Integer.valueOf(TextConvertKt.x0o(x0XOIxOo2, i8)));
                    if (x0XOIxOo2 > 1.0f && i6 == locationList.size() - 2) {
                        arrayList.add(Integer.valueOf(TextConvertKt.x0o(0.0f, abs)));
                    }
                    i4 = 1;
                    i7 = 0;
                    i8 = 0;
                    i6 += i4;
                    size = i3;
                    i5 = 1;
                }
            } else {
                i3 = size;
            }
            i4 = 1;
            i6 += i4;
            size = i3;
            i5 = 1;
        }
        if (i7 > 0) {
            float x0XOIxOo3 = TextConvertKt.x0XOIxOo(i7, i2);
            LogUtils.d("last km " + x0XOIxOo3 + TokenParser.SP + i8);
            if (arrayList.size() == 0 && !mTimeList.isEmpty() && mTimeList.size() > 1) {
                arrayList.add(Integer.valueOf(TextConvertKt.x0o(x0XOIxOo3, (int) ((mTimeList.get(1).getMTime() - mTimeList.get(0).getMTime()) / 1000))));
            } else {
                arrayList.add(Integer.valueOf(TextConvertKt.x0o(x0XOIxOo3, i8)));
            }
        }
        RecordDetailSpeedData recordDetailSpeedData = new RecordDetailSpeedData();
        recordDetailSpeedData.setMFastestSpeed(f);
        recordDetailSpeedData.getMPaceList().addAll(arrayList);
        return recordDetailSpeedData;
    }

    @OOXIXo
    public static final ArrayList<SportRecordData> getSportRecordList(long j, long j2, int i) {
        List<Workout> listDESC;
        ArrayList<SportRecordData> arrayList = new ArrayList<>();
        MyDb myDb = MyDb.INSTANCE;
        ActivityDao activityDao = myDb.getMDatabase().activityDao();
        WorkoutDao workoutDao = myDb.getMDatabase().workoutDao();
        arrayList.addAll(getActivityWorkoutList(activityDao.getListDESC(j, j2)));
        if (i != 0) {
            listDESC = workoutDao.getListModeDESC(j, j2, 116);
        } else {
            listDESC = workoutDao.getListDESC(j, j2, 0);
        }
        if (!listDESC.isEmpty()) {
            for (Workout workout : listDESC) {
                SportRecordData sportRecordData = new SportRecordData();
                sportRecordData.setMStartTime(workout.getMStart());
                sportRecordData.setMEndTime(workout.getMEnd());
                sportRecordData.setMMode(workout.getMMode());
                sportRecordData.setMSource(workout.getMSource() == 1 ? 2 : 1);
                sportRecordData.setMWorkoutId(workout.getMId());
                sportRecordData.setMDistance(workout.getMDistance());
                sportRecordData.setMPace(workout.getMPace());
                sportRecordData.setMCalorie(workout.getMCalorie());
                sportRecordData.setMDuration(workout.getMDuration());
                arrayList.add(sportRecordData);
            }
        }
        if (arrayList.size() > 1) {
            o00.OO0x0xX(arrayList, new Comparator() { // from class: com.sma.smartv3.model.SportRecordDataKt$getSportRecordList$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return Oxx0IOOO.oOoXoXO(Long.valueOf(((SportRecordData) t2).getMStartTime()), Long.valueOf(((SportRecordData) t).getMStartTime()));
                }
            });
        }
        return arrayList;
    }
}
