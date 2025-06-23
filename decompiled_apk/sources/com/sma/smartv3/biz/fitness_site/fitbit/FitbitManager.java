package com.sma.smartv3.biz.fitness_site.fitbit;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.content.Context;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.baidu.mobads.sdk.internal.an;
import com.blankj.utilcode.util.LogUtils;
import com.garmin.fit.xOxOoo;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.constant.bn;
import com.sma.smartv3.biz.fitness_site.FunctionKt;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WorkoutIndexDao;
import com.sma.smartv3.db.entity.WorkoutIndex;
import com.sma.smartv3.util.Xo0;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import o0oIxXOx.XIxXXX0x0;
import org.json.JSONObject;

@XX({"SMAP\nFitbitManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FitbitManager.kt\ncom/sma/smartv3/biz/fitness_site/fitbit/FitbitManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,221:1\n15#2:222\n18#2,2:223\n15#2:225\n15#2:226\n18#2,2:227\n15#2:229\n11#2,2:230\n18#2,2:232\n15#2:234\n*S KotlinDebug\n*F\n+ 1 FitbitManager.kt\ncom/sma/smartv3/biz/fitness_site/fitbit/FitbitManager\n*L\n42#1:222\n47#1:223,2\n47#1:225\n83#1:226\n113#1:227,2\n113#1:229\n130#1:230,2\n157#1:232,2\n157#1:234\n*E\n"})
/* loaded from: classes12.dex */
public final class FitbitManager {

    @OOXIXo
    public static final FitbitManager INSTANCE = new FitbitManager();
    private static final int STATUS_CODE_UNAUTHORIZED = 401;

    @OOXIXo
    private static final String TAG = "FitbitManager";

    @OOXIXo
    public static final String URL_AUTHORIZE = "https://www.fitbit.com/oauth2/authorize";

    @OOXIXo
    private static final String URL_DEAUTHORIZE = "https://api.fitbit.com/oauth2/revoke";

    @OOXIXo
    private static final String URL_GET_TOKEN = "https://api.fitbit.com/oauth2/token";

    private FitbitManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createActivity$default(FitbitManager fitbitManager, WorkoutIndex workoutIndex, String str, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        fitbitManager.createActivity(workoutIndex, str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deauthorizeFit$default(FitbitManager fitbitManager, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        fitbitManager.deauthorizeFit(oooxoxo);
    }

    private final String getActivityId(int i) {
        if (i != 7) {
            if (i != 14) {
                if (i != 22) {
                    switch (i) {
                        case 10:
                            return "90001";
                        case 11:
                            return "90024";
                        case 12:
                            return "90013";
                        default:
                            switch (i) {
                                case 16:
                                    return "15040";
                                case 17:
                                    return "15210";
                                case 18:
                                    return "15020";
                                default:
                                    return "2060";
                            }
                    }
                }
                return "90005";
            }
            return "52001";
        }
        return "90009";
    }

    private final void updateWorkoutIndexFitbitSynced(WorkoutIndex workoutIndex) {
        WorkoutIndexDao workoutIndexDao = MyDb.INSTANCE.getMDatabase().workoutIndexDao();
        workoutIndex.setMSyncStatus(workoutIndex.getMSyncStatus() | 2);
        workoutIndexDao.update(workoutIndex);
    }

    public final void createActivity(@OOXIXo WorkoutIndex workoutIndex, @OOXIXo String userId, @OXOo.oOoXoXO oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(workoutIndex, "workoutIndex");
        IIX0o.x0xO0oo(userId, "userId");
        LogUtils.v("FitbitManager createActivity -> " + workoutIndex);
        if ((workoutIndex.getMSyncStatus() & 2) > 0) {
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        FitbitWorkout oIX0oI2 = FunctionKt.oIX0oI(workoutIndex);
        if (oIX0oI2 == null) {
            updateWorkoutIndexFitbitSynced(workoutIndex);
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        LogUtils.d("FitbitManager createActivity -> " + oIX0oI2);
        try {
            String activityId = getActivityId(workoutIndex.getMMode());
            ANRequest.PostRequestBuilder contentType = AndroidNetworking.post("https://api.fitbit.com/1/user/" + userId + "/activities.json").setContentType(an.d);
            StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(FitbitToken.class.getName()), (Class<Object>) FitbitToken.class);
            if (fromJson == null) {
                fromJson = FitbitToken.class.newInstance();
            }
            sb.append(((FitbitToken) fromJson).getAccess_token());
            contentType.addHeaders("Authorization", sb.toString()).addBodyParameter("activityId", activityId).addBodyParameter("activitName", "").addBodyParameter("manualCalories", "300").addBodyParameter(bn.f.g, "15:00").addBodyParameter("durationMillis", String.valueOf(oIX0oI2.getMElapsedTime())).addBodyParameter("duration", String.valueOf(oIX0oI2.getMElapsedTime())).addBodyParameter(xOxOoo.f15470o00, "500").addBodyParameter(XIxXXX0x0.f31178xoIox, oIX0oI2.getMDate()).addBodyParameter("steps", "200").setTag((Object) "FitbitManager createActivity").setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.fitness_site.fitbit.FitbitManager$createActivity$response$1
                @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
                public void onError(@OXOo.oOoXoXO ANError aNError) {
                    LogUtils.d("FitbitManager createActivity ANError-> " + aNError + '}');
                }

                @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
                public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                    LogUtils.d("FitbitManager createActivity -> " + jSONObject);
                }
            });
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            updateWorkoutIndexFitbitSynced(workoutIndex);
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.TRUE);
            }
        } catch (Exception e) {
            oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FitbitManager createActivity -> exception : ");
            e.printStackTrace();
            sb2.append(oXIO0o0XI.f29392oIX0oI);
            oix0oi.oIX0oI(sb2.toString());
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.FALSE);
            }
        }
    }

    public final void deauthorizeFit(@OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        FitbitToken fitbitToken = (FitbitToken) new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(FitbitToken.class.getName()), FitbitToken.class);
        if (fitbitToken != null && fitbitToken.getAccess_token().length() != 0) {
            AndroidNetworking.post(URL_DEAUTHORIZE).addBodyParameter("access_token", fitbitToken.getAccess_token()).setTag((Object) "FitbitManager deauthorizeFit").setPriority(Priority.HIGH).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.fitness_site.fitbit.FitbitManager$deauthorizeFit$1
                @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
                public void onError(@OOXIXo ANError anError) {
                    IIX0o.x0xO0oo(anError, "anError");
                    if (anError.getErrorCode() == 401) {
                        oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.TRUE);
                        }
                        Xo0.f24349oIX0oI.XO().remove(FitbitToken.class.getName());
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
                    Xo0.f24349oIX0oI.XO().remove(FitbitToken.class.getName());
                }
            });
        }
    }

    public final void getToken(@OOXIXo Context context, @OOXIXo String code, @OOXIXo String code_verifier, @OOXIXo final oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(code_verifier, "code_verifier");
        IIX0o.x0xO0oo(callback, "callback");
        AndroidNetworking.post(URL_GET_TOKEN).addBodyParameter("client_id", context.getString(R.string.fitbit_client_id)).addBodyParameter("code", OxI.IIOIX(code, "#_", "", false, 4, null)).addBodyParameter("code_verifier", code_verifier).addBodyParameter("grant_type", "authorization_code").setPriority(Priority.HIGH).build().getAsObject(FitbitToken.class, new ParsedRequestListener<FitbitToken>() { // from class: com.sma.smartv3.biz.fitness_site.fitbit.FitbitManager$getToken$1
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OOXIXo ANError anError) {
                IIX0o.x0xO0oo(anError, "anError");
                callback.invoke(Boolean.FALSE);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OOXIXo FitbitToken response) {
                IIX0o.x0xO0oo(response, "response");
                Xo0.f24349oIX0oI.XO().put(FitbitToken.class.getName(), new Gson().toJson(response));
                callback.invoke(Boolean.TRUE);
            }
        });
    }

    public final boolean isEnabled() {
        if (new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(FitbitToken.class.getName()), FitbitToken.class) != null) {
            return true;
        }
        return false;
    }

    public final boolean isExpired() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(FitbitToken.class.getName()), (Class<Object>) FitbitToken.class);
        if (fromJson == null) {
            fromJson = FitbitToken.class.newInstance();
        }
        if (System.currentTimeMillis() > (((FitbitToken) fromJson).getExpires_at() * 1000) - TimeUnit.MINUTES.toMillis(5L)) {
            return true;
        }
        return false;
    }

    public final boolean refreshToken(@OOXIXo Context context) {
        FitbitToken fitbitToken;
        IIX0o.x0xO0oo(context, "context");
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(FitbitToken.class.getName()), (Class<Object>) FitbitToken.class);
        if (fromJson == null) {
            fromJson = FitbitToken.class.newInstance();
        }
        try {
            Object result = AndroidNetworking.post(URL_GET_TOKEN).addBodyParameter("client_id", context.getString(R.string.fitbit_client_id)).addBodyParameter("client_secret", context.getString(R.string.fitbit_client_secret)).addBodyParameter("grant_type", "refresh_token").addBodyParameter("refresh_token", ((FitbitToken) fromJson).getRefresh_token()).setTag((Object) "FitbitManager refreshToken").setPriority(Priority.HIGH).build().executeForObject(FitbitToken.class).getResult();
            IIX0o.x0XOIxOo(result, "null cannot be cast to non-null type com.sma.smartv3.biz.fitness_site.fitbit.FitbitToken");
            fitbitToken = (FitbitToken) result;
        } catch (Exception unused) {
            fitbitToken = null;
        }
        if (fitbitToken != null) {
            Xo0.f24349oIX0oI.XO().put(FitbitToken.class.getName(), new Gson().toJson(fitbitToken));
            return true;
        }
        return false;
    }
}
