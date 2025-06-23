package com.sma.smartv3.biz.fitness_site;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.gson.Gson;
import com.sma.smartv3.biz.fitness_site.fitbit.FitbitManager;
import com.sma.smartv3.biz.fitness_site.fitbit.FitbitToken;
import com.sma.smartv3.biz.fitness_site.fitbit.FitbitWorkout;
import com.sma.smartv3.biz.fitness_site.strava.StravaManager;
import com.sma.smartv3.biz.fitness_site.strava.StravaWorkout;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.db.entity.WorkoutIndex;
import com.sma.smartv3.util.Xo0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class FunctionKt {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final String f20283I0Io = "yyyy-MM";

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final String f20284II0xO0 = "yyyy-MM-dd";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final String f20285oIX0oI = "yyyy-MM-dd'T'HH:mm:ssXXX";

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final String f20286oxoX = "HH:mm";

    @oOoXoXO
    public static final FitbitWorkout I0Io(long j, int i) {
        Workout fitnessWorkout = MyDb.INSTANCE.getMDatabase().workoutDao().getFitnessWorkout(j, i);
        if (fitnessWorkout == null) {
            return null;
        }
        oIX0oI.f1507oIX0oI.XO("getFitbitWorkoutFromWorkout -> " + fitnessWorkout);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        FitbitWorkout.Companion companion = FitbitWorkout.Companion;
        String typeByActivityMode = companion.getTypeByActivityMode(i);
        String typeByActivityMode2 = companion.getTypeByActivityMode(i);
        String format = simpleDateFormat.format(new Date(fitnessWorkout.getMStart()));
        String format2 = simpleDateFormat2.format(Long.valueOf(fitnessWorkout.getMStart()));
        long mEnd = (fitnessWorkout.getMEnd() - fitnessWorkout.getMStart()) / 1000;
        int mDistance = fitnessWorkout.getMDistance();
        long mStart = fitnessWorkout.getMStart();
        long mEnd2 = fitnessWorkout.getMEnd();
        int mCalorie = fitnessWorkout.getMCalorie();
        IIX0o.ooOOo0oXI(format2);
        IIX0o.ooOOo0oXI(format);
        return new FitbitWorkout(typeByActivityMode, typeByActivityMode2, format2, mEnd, null, mDistance, 0, 0, mStart, mEnd2, i, format, mCalorie, 208, null);
    }

    public static /* synthetic */ void II0XooXoX(Context context, WorkoutIndex workoutIndex, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        Oxx0IOOO(context, workoutIndex, oooxoxo);
    }

    @oOoXoXO
    public static final FitbitWorkout II0xO0(long j, int i) {
        Activity endItem;
        ActivityDao activityDao = MyDb.INSTANCE.getMDatabase().activityDao();
        Activity beginItem = activityDao.getBeginItem(j - TimeUnit.DAYS.toMillis(1L), j, i);
        if (beginItem == null || (endItem = activityDao.getEndItem(j, i)) == null) {
            return null;
        }
        oIX0oI.f1507oIX0oI.XO("getFitbitWorkoutFromActivity -> " + beginItem + ", " + endItem);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        FitbitWorkout.Companion companion = FitbitWorkout.Companion;
        String typeByActivityMode = companion.getTypeByActivityMode(i);
        String typeByActivityMode2 = companion.getTypeByActivityMode(i);
        String format = simpleDateFormat.format(new Date(beginItem.getMTime()));
        String format2 = simpleDateFormat2.format(new Date(beginItem.getMTime()));
        long mTime = (endItem.getMTime() - beginItem.getMTime()) / 1000;
        int mDistance = (endItem.getMDistance() - beginItem.getMDistance()) / 10000;
        long mTime2 = beginItem.getMTime();
        long mTime3 = endItem.getMTime();
        int mCalorie = beginItem.getMCalorie();
        IIX0o.ooOOo0oXI(format2);
        IIX0o.ooOOo0oXI(format);
        return new FitbitWorkout(typeByActivityMode, typeByActivityMode2, format2, mTime, null, mDistance, 0, 0, mTime2, mTime3, i, format, mCalorie, 208, null);
    }

    public static final void Oxx0IOOO(@OOXIXo final Context context, @OOXIXo final WorkoutIndex workoutIndex, @oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(workoutIndex, "workoutIndex");
        ThreadUtils.executeBySingle(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.fitness_site.FunctionKt$uploadToFitnessSite$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @oOoXoXO
            public Void doInBackground() {
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                StravaManager stravaManager = StravaManager.INSTANCE;
                if (stravaManager.isEnabled()) {
                    if (stravaManager.isExpired()) {
                        if (stravaManager.refreshToken(context)) {
                            stravaManager.createActivity(workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.fitness_site.FunctionKt$uploadToFitnessSite$1$doInBackground$1
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(boolean z) {
                                    if (z) {
                                        return;
                                    }
                                    Ref.BooleanRef.this.element = false;
                                }
                            });
                        }
                    } else {
                        stravaManager.createActivity(workoutIndex, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.fitness_site.FunctionKt$uploadToFitnessSite$1$doInBackground$2
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(boolean z) {
                                if (z) {
                                    return;
                                }
                                Ref.BooleanRef.this.element = false;
                            }
                        });
                    }
                }
                FitbitManager fitbitManager = FitbitManager.INSTANCE;
                if (fitbitManager.isEnabled()) {
                    Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(FitbitToken.class.getName()), (Class<Object>) FitbitToken.class);
                    if (fromJson == null) {
                        fromJson = FitbitToken.class.newInstance();
                    }
                    FitbitToken fitbitToken = (FitbitToken) fromJson;
                    if (fitbitManager.isExpired()) {
                        if (fitbitManager.refreshToken(context)) {
                            fitbitManager.createActivity(workoutIndex, fitbitToken.getUser_id(), new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.fitness_site.FunctionKt$uploadToFitnessSite$1$doInBackground$3
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(boolean z) {
                                    if (z) {
                                        return;
                                    }
                                    Ref.BooleanRef.this.element = false;
                                }
                            });
                        }
                    } else {
                        fitbitManager.createActivity(workoutIndex, fitbitToken.getUser_id(), new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.fitness_site.FunctionKt$uploadToFitnessSite$1$doInBackground$4
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(boolean z) {
                                if (z) {
                                    return;
                                }
                                Ref.BooleanRef.this.element = false;
                            }
                        });
                    }
                }
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 == null) {
                    return null;
                }
                oooxoxo2.invoke(Boolean.valueOf(booleanRef.element));
                return null;
            }
        });
    }

    @oOoXoXO
    public static final StravaWorkout X0o0xo(long j, int i) {
        Activity endItem;
        ActivityDao activityDao = MyDb.INSTANCE.getMDatabase().activityDao();
        Activity beginItem = activityDao.getBeginItem(j - TimeUnit.DAYS.toMillis(1L), j, i);
        if (beginItem == null || (endItem = activityDao.getEndItem(j, i)) == null) {
            return null;
        }
        oIX0oI.f1507oIX0oI.XO("getStravaWorkoutFromActivity -> " + beginItem + ", " + endItem);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f20285oIX0oI, Locale.getDefault());
        String xIXX2 = ProductManager.f20544oIX0oI.xIXX(i);
        String typeByActivityMode = StravaWorkout.Companion.getTypeByActivityMode(i);
        String format = simpleDateFormat.format(new Date(beginItem.getMTime()));
        IIX0o.oO(format, "format(...)");
        return new StravaWorkout(xIXX2, typeByActivityMode, format, (endItem.getMTime() - beginItem.getMTime()) / 1000, null, (endItem.getMDistance() - beginItem.getMDistance()) / 10000, 0, 0, beginItem.getMTime(), endItem.getMTime(), i, Math.abs(endItem.getMCalorie() - beginItem.getMCalorie()) / 10000, 0, 0, 0, 208, null);
    }

    @oOoXoXO
    public static final StravaWorkout XO(long j, int i) {
        Workout fitnessWorkout = MyDb.INSTANCE.getMDatabase().workoutDao().getFitnessWorkout(j, i);
        if (fitnessWorkout == null) {
            return null;
        }
        oIX0oI.f1507oIX0oI.XO("getStravaWorkoutFromWorkout -> " + fitnessWorkout);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f20285oIX0oI, Locale.getDefault());
        String xIXX2 = ProductManager.f20544oIX0oI.xIXX(i);
        String typeByActivityMode = StravaWorkout.Companion.getTypeByActivityMode(i);
        String format = simpleDateFormat.format(Long.valueOf(fitnessWorkout.getMStart()));
        IIX0o.oO(format, "format(...)");
        return new StravaWorkout(xIXX2, typeByActivityMode, format, fitnessWorkout.getMDuration(), null, fitnessWorkout.getMDistance(), 0, 0, fitnessWorkout.getMStart(), fitnessWorkout.getMEnd(), i, fitnessWorkout.getMCalorie(), fitnessWorkout.getMAvgBpm(), fitnessWorkout.getMMaxBpm(), fitnessWorkout.getMMinBpm(), 208, null);
    }

    @oOoXoXO
    public static final FitbitWorkout oIX0oI(@OOXIXo WorkoutIndex workoutIndex) {
        IIX0o.x0xO0oo(workoutIndex, "workoutIndex");
        int mFrom = workoutIndex.getMFrom();
        if (mFrom != 1) {
            if (mFrom != 2) {
                return null;
            }
            return I0Io(workoutIndex.getMEndTime(), workoutIndex.getMMode());
        }
        return II0xO0(workoutIndex.getMEndTime(), workoutIndex.getMMode());
    }

    @oOoXoXO
    public static final StravaWorkout oxoX(@OOXIXo WorkoutIndex workoutIndex) {
        IIX0o.x0xO0oo(workoutIndex, "workoutIndex");
        int mFrom = workoutIndex.getMFrom();
        if (mFrom != 1) {
            if (mFrom != 2) {
                return null;
            }
            return XO(workoutIndex.getMEndTime(), workoutIndex.getMMode());
        }
        return X0o0xo(workoutIndex.getMEndTime(), workoutIndex.getMMode());
    }
}
