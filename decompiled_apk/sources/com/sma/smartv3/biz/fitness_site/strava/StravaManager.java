package com.sma.smartv3.biz.fitness_site.strava;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.internal.ServerProtocol;
import com.garmin.fit.Fit;
import com.garmin.fit.OIx00oxx;
import com.garmin.fit.OX00o0X;
import com.garmin.fit.SubSport;
import com.garmin.fit.XI0oooXX;
import com.garmin.fit.o0xxxXXxX;
import com.garmin.fit.oI00o;
import com.garmin.fit.xOOxIO;
import com.garmin.fit.xOxOoo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.fitness_site.FunctionKt;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WorkoutIndexDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.WorkoutIndex;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.model.LocationData;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import org.json.JSONObject;

@XX({"SMAP\nStravaManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StravaManager.kt\ncom/sma/smartv3/biz/fitness_site/strava/StravaManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,667:1\n15#2:668\n18#2,2:669\n15#2:671\n15#2:672\n18#2,2:673\n15#2:675\n11#2,2:676\n18#2,2:678\n15#2:680\n18#2,2:692\n15#2:694\n1549#3:681\n1620#3,3:682\n1855#3:685\n1856#3:687\n1855#3,2:688\n1855#3,2:690\n1#4:686\n29#5:695\n*S KotlinDebug\n*F\n+ 1 StravaManager.kt\ncom/sma/smartv3/biz/fitness_site/strava/StravaManager\n*L\n65#1:668\n70#1:669,2\n70#1:671\n103#1:672\n135#1:673,2\n135#1:675\n152#1:676,2\n291#1:678,2\n291#1:680\n606#1:692,2\n606#1:694\n412#1:681\n412#1:682,3\n465#1:685\n465#1:687\n532#1:688,2\n542#1:690,2\n644#1:695\n*E\n"})
/* loaded from: classes12.dex */
public final class StravaManager {

    @OOXIXo
    private static final String CREATE_ACTIVITY = "https://www.strava.com/api/v3/activities";

    @OOXIXo
    private static final String CREATE_UPLOAD = "https://www.strava.com/api/v3/uploads";
    private static final double EARTH_RADIUS = 6371000.0d;

    @OOXIXo
    public static final StravaManager INSTANCE = new StravaManager();
    private static final int STATUS_CODE_UNAUTHORIZED = 401;

    @OOXIXo
    private static final String TAG = "StravaManager";

    @OOXIXo
    public static final String URL_AUTHORIZE = "https://www.strava.com/oauth/mobile/authorize";

    @OOXIXo
    public static final String URL_CALLBACK = "http://localhost/auth/callback";

    @OOXIXo
    private static final String URL_DEAUTHORIZE = "https://www.strava.com/oauth/deauthorize";

    @OOXIXo
    private static final String URL_GET_TOKEN = "https://www.strava.com/oauth/token";

    private StravaManager() {
    }

    private final double calculateDistance(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d3);
        double radians4 = Math.toRadians(d4) - radians2;
        double d5 = 2;
        double d6 = (radians3 - radians) / d5;
        double d7 = radians4 / d5;
        double sin = (Math.sin(d6) * Math.sin(d6)) + (Math.cos(radians) * Math.cos(radians3) * Math.sin(d7) * Math.sin(d7));
        return d5 * Math.atan2(Math.sqrt(sin), Math.sqrt(1 - sin)) * EARTH_RADIUS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createActivity$default(StravaManager stravaManager, WorkoutIndex workoutIndex, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        stravaManager.createActivity(workoutIndex, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createActivityFitHeartRate$default(StravaManager stravaManager, WorkoutIndex workoutIndex, oOoXoXO oooxoxo, StravaWorkout stravaWorkout, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        stravaManager.createActivityFitHeartRate(workoutIndex, oooxoxo, stravaWorkout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deauthorizeStrava$default(StravaManager stravaManager, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        stravaManager.deauthorizeStrava(oooxoxo);
    }

    private final void updateWorkoutIndexStravaSynced(WorkoutIndex workoutIndex) {
        WorkoutIndexDao workoutIndexDao = MyDb.INSTANCE.getMDatabase().workoutIndexDao();
        workoutIndex.setMSyncStatus(workoutIndex.getMSyncStatus() | 1);
        workoutIndexDao.update(workoutIndex);
    }

    @OOXIXo
    public final Pair<Double, Double> bd09ToWgs84(double d, double d2) {
        double d3 = d2 - 0.0065d;
        double d4 = d - 0.006d;
        double sqrt = Math.sqrt((d3 * d3) + (d4 * d4)) - (Math.sin(d4 * 52.35987755982988d) * 2.0E-5d);
        double atan2 = Math.atan2(d4, d3) - (Math.cos(d3 * 52.35987755982988d) * 3.0E-6d);
        return new Pair<>(Double.valueOf(Math.sin(atan2) * sqrt), Double.valueOf(sqrt * Math.cos(atan2)));
    }

    @OOXIXo
    public final Pair<Integer, Integer> convertToInteger(double d, double d2) {
        return new Pair<>(Integer.valueOf((int) Math.round(d * 1.1930464705555556E7d)), Integer.valueOf((int) Math.round(d2 * 1.1930464705555556E7d)));
    }

    public final void createActivity(@OOXIXo WorkoutIndex workoutIndex, @OXOo.oOoXoXO oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        boolean z;
        IIX0o.x0xO0oo(workoutIndex, "workoutIndex");
        oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("StravaManager createActivity workoutIndex -> " + workoutIndex);
        if ((workoutIndex.getMSyncStatus() & 1) > 0) {
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        StravaWorkout oxoX2 = FunctionKt.oxoX(workoutIndex);
        if (oxoX2 == null) {
            updateWorkoutIndexStravaSynced(workoutIndex);
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        oix0oi.oIX0oI("StravaManager createActivity stravaWorkout -> " + oxoX2);
        try {
            if (ProjectManager.f19822oIX0oI.Ix00oIoI()) {
                createActivityFitHeartRate(workoutIndex, oooxoxo, oxoX2);
                return;
            }
            List<Location> location = MyDb.INSTANCE.getMDatabase().locationDao().getLocation(oxoX2.getMStart(), oxoX2.getMEnd());
            if (!location.isEmpty() && location.size() >= 2) {
                LocationData locationData = LocationData.INSTANCE;
                locationData.getSmoothLocationListAlgorithm(locationData.getFinalLocationList(location, true), oxoX2.getMMode());
                String valueOf = String.valueOf(workoutIndex.getMEndTime());
                File file = new File(IXxxXO.IIX0o(X00IoxXI.oIX0oI.f3233oIX0oI), valueOf);
                ArrayList<CustomLatLng> finalLocationList = locationData.getFinalLocationList(location, true);
                long mStart = oxoX2.getMStart();
                String string = Utils.getApp().getString(R.string.app_name);
                IIX0o.oO(string, "getString(...)");
                FileIOUtils.writeFileFromString(file, locationData.getGpxFileString(finalLocationList, mStart, string, oxoX2.getMName()));
                z = INSTANCE.createUpload(valueOf, oxoX2.getMName(), file, IXxxXO.f20859Xx000oIo);
            } else {
                z = false;
            }
            if (!z) {
                int mDistance = (oxoX2.getMDistance() / 10) * 10;
                ANRequest.PostRequestBuilder post = AndroidNetworking.post(CREATE_ACTIVITY);
                Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(StravaToken.class.getName()), (Class<Object>) StravaToken.class);
                if (fromJson == null) {
                    fromJson = StravaToken.class.newInstance();
                }
                ANResponse executeForJSONObject = post.addBodyParameter("access_token", ((StravaToken) fromJson).getAccess_token()).addBodyParameter("name", oxoX2.getMName()).addBodyParameter("type", oxoX2.getMType()).addBodyParameter("start_date_local", oxoX2.getMStartTime()).addBodyParameter("elapsed_time", String.valueOf(oxoX2.getMElapsedTime())).addBodyParameter(xOxOoo.f15470o00, String.valueOf(mDistance)).setTag((Object) "StravaManager createActivity").setPriority(Priority.HIGH).build().executeForJSONObject();
                oix0oi.oIX0oI("StravaManager createActivity -> response.error:" + executeForJSONObject.getError() + " response.result:" + executeForJSONObject.getResult());
            }
            updateWorkoutIndexStravaSynced(workoutIndex);
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.TRUE);
            }
        } catch (Exception e) {
            oIX0oI oix0oi2 = oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("StravaManager createActivity -> exception : ");
            e.printStackTrace();
            sb.append(oXIO0o0XI.f29392oIX0oI);
            oix0oi2.oIX0oI(sb.toString());
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.FALSE);
            }
        }
    }

    public final void createActivityFitHeartRate(@OOXIXo WorkoutIndex workoutIndex, @OXOo.oOoXoXO oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo, @OOXIXo StravaWorkout stravaWorkout) {
        String str;
        File file;
        OIx00oxx oIx00oxx;
        Pair<Integer, Integer> convertToInteger;
        Object obj;
        Object obj2;
        Location location;
        List list;
        String str2;
        Iterator it;
        File file2;
        OIx00oxx oIx00oxx2;
        List<Activity> list2;
        List list3;
        IIX0o.x0xO0oo(workoutIndex, "workoutIndex");
        IIX0o.x0xO0oo(stravaWorkout, "stravaWorkout");
        oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("StravaManager createActivityFitHeartRate");
        String str3 = workoutIndex.getMEndTime() + ".fit";
        File file3 = new File(IXxxXO.xXxxox0I(X00IoxXI.oIX0oI.f3233oIX0oI), str3);
        OIx00oxx oIx00oxx3 = new OIx00oxx(file3, Fit.ProtocolVersion.V2_0);
        xOOxIO xooxio = new xOOxIO();
        xooxio.x00IOx(com.garmin.fit.File.ACTIVITY);
        xooxio.xOOxIO(1);
        xooxio.oxOXxoXII(1);
        xooxio.XO0o(123456789L);
        xooxio.IxX00("FIT Cookbook");
        long j = 1000;
        xooxio.oX0I0O(new o0xxxXXxX(stravaWorkout.getMStart() / j));
        oIx00oxx3.XO(xooxio);
        XI0oooXX xI0oooXX = new XI0oooXX();
        xI0oooXX.xOOxIO((short) 0);
        xI0oooXX.O00(111L);
        oIx00oxx3.XO(xI0oooXX);
        OX00o0X oX00o0X = new OX00o0X();
        oX00o0X.OIOxOX(0);
        oX00o0X.X0OXI(0);
        oX00o0X.OXI(1);
        oX00o0X.x0I0(new o0xxxXXxX((stravaWorkout.getMStart() - 631065600000L) / j));
        oX00o0X.I0o(Float.valueOf((float) stravaWorkout.getMElapsedTime()));
        oX00o0X.XOO(Float.valueOf(stravaWorkout.getMDistance()));
        oX00o0X.OoIoI0(Integer.valueOf(stravaWorkout.getMCalorie() / 1000));
        oX00o0X.IxOIO(Short.valueOf((short) stravaWorkout.getMAvgBpm()));
        oX00o0X.O0OOoIox(Short.valueOf((short) stravaWorkout.getMMaxBpm()));
        oX00o0X.IoXIo(Short.valueOf((short) stravaWorkout.getMMinBpm()));
        oX00o0X.OI(StravaWorkout.Companion.getTypeByActivityModeType(stravaWorkout.getMMode()));
        oX00o0X.XoOOxOo0o(SubSport.GENERIC);
        oIx00oxx3.XO(oX00o0X);
        MyDb myDb = MyDb.INSTANCE;
        List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(myDb.getMDatabase().locationDao().getLocation(stravaWorkout.getMStart(), stravaWorkout.getMEnd()));
        List<HeartRate> heartRates = myDb.getMDatabase().heartRateDao().getHeartRates(stravaWorkout.getMStart(), stravaWorkout.getMEnd());
        List<Activity> listDESC = myDb.getMDatabase().activityDao().getListDESC(stravaWorkout.getMStart(), stravaWorkout.getMEnd());
        oix0oi.oIX0oI("StravaManager createActivityFitHeartRate  stravaWorkout = " + stravaWorkout + " ,  mElapsedTime = " + ((float) stravaWorkout.getMElapsedTime()) + " , locationList = " + o0Xo0XII.size() + ", heartRateList = " + heartRates.size() + "  , activityList = " + listDESC.size());
        if (!o0Xo0XII.isEmpty() && o0Xo0XII.size() >= 2) {
            long mTime = ((Location) CollectionsKt___CollectionsKt.O0O0Io00X(o0Xo0XII)).getMTime() - ((Location) CollectionsKt___CollectionsKt.O0OOX0IIx(o0Xo0XII)).getMTime();
            List<Location> list4 = o0Xo0XII;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list4, 10));
            Iterator it2 = list4.iterator();
            float f = 0.0f;
            Location location2 = null;
            Location location3 = null;
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it2.hasNext()) {
                Location location4 = (Location) it2.next();
                if (location2 == null) {
                    str2 = str3;
                    file2 = file3;
                    oIx00oxx2 = oIx00oxx3;
                    list2 = listDESC;
                    list3 = o0Xo0XII;
                    it = it2;
                    location3 = location4;
                } else {
                    str2 = str3;
                    it = it2;
                    file2 = file3;
                    oIx00oxx2 = oIx00oxx3;
                    list2 = listDESC;
                    list3 = o0Xo0XII;
                    double calculateDistance = INSTANCE.calculateDistance(location2.getMLatitude(), location2.getMLongitude(), location4.getMLatitude(), location4.getMLongitude());
                    if (calculateDistance > XIXIX.OOXIXo.f3760XO) {
                        f3 = (float) calculateDistance;
                        f2 += f3;
                    } else {
                        location2 = location3;
                    }
                    location3 = location2;
                }
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
                location2 = location4;
                str3 = str2;
                it2 = it;
                file3 = file2;
                oIx00oxx3 = oIx00oxx2;
                o0Xo0XII = list3;
                listDESC = list2;
            }
            str = str3;
            file = file3;
            OIx00oxx oIx00oxx4 = oIx00oxx3;
            List<Activity> list5 = listDESC;
            List list6 = o0Xo0XII;
            oIX0oI.f1507oIX0oI.oIX0oI("StravaManager  addLocationStart saveDistance = " + f3 + " ,  sum = " + f2);
            float mDistance = ((float) stravaWorkout.getMDistance()) - f2;
            float f4 = mDistance / f3;
            float mElapsedTime = (((float) stravaWorkout.getMElapsedTime()) - ((float) (mTime / j))) / f4;
            Location location5 = (Location) CollectionsKt___CollectionsKt.O0O0Io00X(list6);
            if (mDistance > 0.0f) {
                int i = (int) f4;
                int i2 = 0;
                boolean z = false;
                while (i2 < i) {
                    long mTime2 = location5.getMTime() + ((int) (1000 * mElapsedTime));
                    location5.setMTime(mTime2);
                    boolean z2 = !z;
                    if (!z) {
                        IIX0o.ooOOo0oXI(location3);
                        location = location3;
                        location.setMTime(mTime2);
                        list = list6;
                        list.add(location);
                    } else {
                        location = location3;
                        list = list6;
                        list.add(location5);
                    }
                    i2++;
                    location3 = location;
                    list6 = list;
                    z = z2;
                }
            }
            oIX0oI oix0oi2 = oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("StravaManager  addLocationEnd locationList = ");
            sb.append(list6.size());
            sb.append(" , mDistanceSum = ");
            sb.append(stravaWorkout.getMDistance());
            oix0oi2.oIX0oI(sb.toString());
            Location location6 = null;
            short s = 0;
            for (Location location7 : list4) {
                oI00o oi00o = new oI00o();
                oi00o.oIX0oI(new o0xxxXXxX(location7.getMTime() / j));
                if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24367IXxxXO, false)) {
                    StravaManager stravaManager = INSTANCE;
                    Pair<Double, Double> bd09ToWgs84 = stravaManager.bd09ToWgs84(location7.getMLatitude(), location7.getMLongitude());
                    convertToInteger = stravaManager.convertToInteger(bd09ToWgs84.component1().doubleValue(), bd09ToWgs84.component2().doubleValue());
                } else {
                    convertToInteger = INSTANCE.convertToInteger(location7.getMLatitude(), location7.getMLongitude());
                }
                int intValue = convertToInteger.component1().intValue();
                int intValue2 = convertToInteger.component2().intValue();
                oi00o.IOOXOOOOo(Integer.valueOf(intValue));
                oi00o.XXx0OXXXo(Integer.valueOf(intValue2));
                if (location7.getMAltitude() != 0) {
                    oi00o.O0O0Io00X(Float.valueOf(location7.getMAltitude()));
                }
                if (ProjectManager.f19822oIX0oI.X0O0I0()) {
                    Iterator<T> it3 = heartRates.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            obj2 = it3.next();
                            if (((HeartRate) obj2).getMTime() >= location7.getMTime()) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    HeartRate heartRate = (HeartRate) obj2;
                    if (heartRate != null) {
                        s = (byte) heartRate.getMBpm();
                    }
                    if (!heartRates.isEmpty() && s > 0) {
                        oi00o.XoOOx0IX(Short.valueOf(s));
                    }
                }
                if (location6 != null) {
                    f += (float) INSTANCE.calculateDistance(location6.getMLatitude(), location6.getMLongitude(), location7.getMLatitude(), location7.getMLongitude());
                    oi00o.XO0OX(Float.valueOf(f));
                    oi00o.O0O0Io00X(Float.valueOf(location7.getMAltitude()));
                }
                Iterator<T> it4 = list5.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj = it4.next();
                        if (((Activity) obj).getMTime() >= location7.getMTime()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Activity activity = (Activity) obj;
                if (activity != null) {
                    oi00o.xX0ox(Integer.valueOf((byte) (activity.getMCalorie() / 1000)));
                }
                OIx00oxx oIx00oxx5 = oIx00oxx4;
                oIx00oxx5.XO(oi00o);
                oIx00oxx4 = oIx00oxx5;
                location6 = location7;
            }
            oIx00oxx = oIx00oxx4;
        } else {
            str = str3;
            file = file3;
            oIx00oxx = oIx00oxx3;
            if (!heartRates.isEmpty()) {
                for (HeartRate heartRate2 : heartRates) {
                    oI00o oi00o2 = new oI00o();
                    oi00o2.oIX0oI(new o0xxxXXxX(heartRate2.getMTime() / j));
                    if (ProjectManager.f19822oIX0oI.X0O0I0()) {
                        oi00o2.XoOOx0IX(Short.valueOf((byte) heartRate2.getMBpm()));
                    }
                    oIx00oxx.XO(oi00o2);
                }
            } else if (!listDESC.isEmpty()) {
                for (Activity activity2 : listDESC) {
                    oI00o oi00o3 = new oI00o();
                    oi00o3.oIX0oI(new o0xxxXXxX(activity2.getMTime() / j));
                    oi00o3.XO0OX(Float.valueOf((byte) activity2.getMDistance()));
                    oi00o3.xX0ox(Integer.valueOf((byte) (activity2.getMCalorie() / 1000)));
                    oIx00oxx.XO(oi00o3);
                }
            }
        }
        oIX0oI oix0oi3 = oIX0oI.f1507oIX0oI;
        oix0oi3.oIX0oI("StravaManager createActivityFitHeartRate  createFile");
        oIx00oxx.oIX0oI();
        oix0oi3.oIX0oI("StravaManager createActivityFitHeartRate  createFile  isUploadFit = " + createUpload(str, stravaWorkout.getMName(), file, IXxxXO.f20852X00IoxXI) + TokenParser.SP);
        updateWorkoutIndexStravaSynced(workoutIndex);
        if (oooxoxo != null) {
            oooxoxo.invoke(Boolean.TRUE);
        }
    }

    public final boolean createUpload(@OOXIXo String externalId, @OOXIXo String name, @OOXIXo File file, @OOXIXo String data_type) {
        IIX0o.x0xO0oo(externalId, "externalId");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(data_type, "data_type");
        try {
            ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(CREATE_UPLOAD);
            Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(StravaToken.class.getName()), (Class<Object>) StravaToken.class);
            if (fromJson == null) {
                fromJson = StravaToken.class.newInstance();
            }
            ANResponse executeForJSONObject = upload.addMultipartParameter("access_token", ((StravaToken) fromJson).getAccess_token()).addMultipartParameter("name", name).addMultipartParameter("data_type", data_type).addMultipartParameter("external_id", externalId).addMultipartFile("file", file).setTag((Object) "StravaManager createUpload").setPriority(Priority.HIGH).build().executeForJSONObject();
            oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI("StravaManager createUpload -> " + externalId + " response.error:" + executeForJSONObject.getError() + " , response.result:" + executeForJSONObject.getResult());
            if (executeForJSONObject.getResult() != null) {
                oix0oi.oIX0oI("StravaManager createUpload -> file = " + file.getAbsolutePath() + TokenParser.SP);
                return true;
            }
            return false;
        } catch (Exception e) {
            oIX0oI oix0oi2 = oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("StravaManager createUpload -> exception : ");
            e.printStackTrace();
            sb.append(oXIO0o0XI.f29392oIX0oI);
            oix0oi2.oIX0oI(sb.toString());
            return false;
        }
    }

    public final void deauthorizeStrava(@OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        StravaToken stravaToken = (StravaToken) new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(StravaToken.class.getName()), StravaToken.class);
        if (stravaToken != null && stravaToken.getAccess_token().length() != 0) {
            AndroidNetworking.post(URL_DEAUTHORIZE).addBodyParameter("access_token", stravaToken.getAccess_token()).setTag((Object) "StravaManager deauthorizeStrava").setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.fitness_site.strava.StravaManager$deauthorizeStrava$1
                @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
                public void onError(@OOXIXo ANError anError) {
                    IIX0o.x0xO0oo(anError, "anError");
                    if (anError.getErrorCode() == 401) {
                        oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.TRUE);
                        }
                        Xo0.f24349oIX0oI.XO().remove(StravaToken.class.getName());
                        return;
                    }
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                }

                @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
                public void onResponse(@OOXIXo JSONObject response) {
                    IIX0o.x0xO0oo(response, "response");
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                    }
                    Xo0.f24349oIX0oI.XO().remove(StravaToken.class.getName());
                }
            });
        }
    }

    public final void getToken(@OOXIXo Context context, @OOXIXo String code, @OOXIXo final oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(callback, "callback");
        AndroidNetworking.post(URL_GET_TOKEN).addBodyParameter("client_id", context.getString(R.string.strava_client_id)).addBodyParameter("client_secret", context.getString(R.string.strava_client_secret)).addBodyParameter("code", code).setTag((Object) "StravaManager getToken").setPriority(Priority.HIGH).build().getAsObject(StravaToken.class, new ParsedRequestListener<StravaToken>() { // from class: com.sma.smartv3.biz.fitness_site.strava.StravaManager$getToken$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OOXIXo ANError anError) {
                IIX0o.x0xO0oo(anError, "anError");
                callback.invoke(Boolean.FALSE);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OOXIXo StravaToken response) {
                IIX0o.x0xO0oo(response, "response");
                Xo0.f24349oIX0oI.XO().put(StravaToken.class.getName(), new Gson().toJson(response));
                callback.invoke(Boolean.TRUE);
            }
        });
    }

    public final void handleStravaAppIntent(@OOXIXo Context context, @OOXIXo Intent intent, @OOXIXo final oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        String queryParameter;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(intent, "intent");
        IIX0o.x0xO0oo(callback, "callback");
        oIX0oI.f1507oIX0oI.oIX0oI("StravaManager handleStravaAppIntent -> data: " + intent.getData());
        Uri data = intent.getData();
        if (data != null && (queryParameter = data.getQueryParameter("code")) != null) {
            INSTANCE.getToken(context, queryParameter, new oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.fitness_site.strava.StravaManager$handleStravaAppIntent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    callback.invoke(Boolean.valueOf(z));
                }
            });
        }
    }

    public final boolean isEnabled() {
        if (new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(StravaToken.class.getName()), StravaToken.class) != null) {
            return true;
        }
        return false;
    }

    public final boolean isExpired() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(StravaToken.class.getName()), (Class<Object>) StravaToken.class);
        if (fromJson == null) {
            fromJson = StravaToken.class.newInstance();
        }
        if (System.currentTimeMillis() > (((StravaToken) fromJson).getExpires_at() * 1000) - TimeUnit.MINUTES.toMillis(5L)) {
            return true;
        }
        return false;
    }

    public final boolean refreshToken(@OOXIXo Context context) {
        StravaToken stravaToken;
        IIX0o.x0xO0oo(context, "context");
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(StravaToken.class.getName()), (Class<Object>) StravaToken.class);
        if (fromJson == null) {
            fromJson = StravaToken.class.newInstance();
        }
        try {
            Object result = AndroidNetworking.post(URL_GET_TOKEN).addBodyParameter("client_id", context.getString(R.string.strava_client_id)).addBodyParameter("client_secret", context.getString(R.string.strava_client_secret)).addBodyParameter("grant_type", "refresh_token").addBodyParameter("refresh_token", ((StravaToken) fromJson).getRefresh_token()).setTag((Object) "StravaManager refreshToken").setPriority(Priority.HIGH).build().executeForObject(StravaToken.class).getResult();
            IIX0o.x0XOIxOo(result, "null cannot be cast to non-null type com.sma.smartv3.biz.fitness_site.strava.StravaToken");
            stravaToken = (StravaToken) result;
        } catch (Exception unused) {
            stravaToken = null;
        }
        if (stravaToken != null) {
            Xo0.f24349oIX0oI.XO().put(StravaToken.class.getName(), new Gson().toJson(stravaToken));
            return true;
        }
        return false;
    }

    public final void toStravaAppAuthorize(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        Uri build = Uri.parse(URL_AUTHORIZE).buildUpon().appendQueryParameter("client_id", context.getString(R.string.strava_client_id)).appendQueryParameter("redirect_uri", "strava://localhost/" + AppUtils.getAppPackageName() + "/callback").appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code").appendQueryParameter("approval_prompt", "auto").appendQueryParameter("scope", "activity:write").build();
        oIX0oI.f1507oIX0oI.oIX0oI("StravaManager toStravaAppAuthorize -> data: " + build);
        context.startActivity(new Intent("android.intent.action.VIEW", build));
    }
}
