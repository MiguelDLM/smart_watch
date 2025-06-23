package com.tenmeter.smlibrary.utils;

import OoOoXO0.xoXoI;
import XXO0.oIX0oI;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.aw;
import com.sma.smartv3.network.GetGameDetail;
import com.szabh.smable3.entity.Languages;
import com.tenmeter.smlibrary.activity.SMADActivity;
import com.tenmeter.smlibrary.activity.SMGameH5Activity;
import com.tenmeter.smlibrary.activity.SMGameListNewActivity;
import com.tenmeter.smlibrary.activity.SMGameListSubActivity;
import com.tenmeter.smlibrary.activity.SMWebViewActivity;
import com.tenmeter.smlibrary.entity.BaseBean;
import com.tenmeter.smlibrary.entity.SMADBean;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMGameSensor;
import com.tenmeter.smlibrary.entity.SMGameUser;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.entity.SMPOPResultBean;
import com.tenmeter.smlibrary.entity.SMReportBean;
import com.tenmeter.smlibrary.listener.Consumer;
import com.tenmeter.smlibrary.listener.IADCallback;
import com.tenmeter.smlibrary.listener.IAdGameOpenListener;
import com.tenmeter.smlibrary.listener.ICalListener;
import com.tenmeter.smlibrary.listener.ICommonResultCallback;
import com.tenmeter.smlibrary.listener.IFragmentChangeCallback;
import com.tenmeter.smlibrary.listener.IGameGSensor;
import com.tenmeter.smlibrary.listener.IGameListBannerCallback;
import com.tenmeter.smlibrary.listener.IGameListCallback;
import com.tenmeter.smlibrary.listener.IGameListForTypeCallback;
import com.tenmeter.smlibrary.listener.IGameListItemClickListener;
import com.tenmeter.smlibrary.listener.IGameListRefreshUserListener;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.listener.IGameStatus;
import com.tenmeter.smlibrary.listener.IIconCallback;
import com.tenmeter.smlibrary.listener.IPopResultCallback;
import com.tenmeter.smlibrary.listener.IUserInfoCallback;
import com.tenmeter.smlibrary.listener.IVipPayClickListener;
import com.tenmeter.smlibrary.provider.BaseProvider;
import com.tenmeter.smlibrary.utils.HttpClientUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class SMGameClient {
    public static String baseUrl = "";

    @SuppressLint({"StaticFieldLeak"})
    private static Context context = null;
    private static volatile SMGameClient instance = null;
    public static boolean isClick = false;
    public static boolean isDev = false;
    public static boolean isRefresh = false;
    public static boolean isUserAddReport = false;
    public static String language = "";
    public static String thirdPartHeadImage = "";

    @SuppressLint({"StaticFieldLeak"})
    public static String thirdPartKey = "";
    public static String thirdPartName = "";
    public static String thirdPartNickname = "";
    public static String thirdPartUid = "";
    public int gameId;
    private ICalListener mCalGSensor;
    private IGameGSensor mGameGSensor;
    private IGameListItemClickListener mGameListItemClickListener;
    private IGameStatus mGameStatus;
    private IAdGameOpenListener mIAdGameOpenListener;
    private IFragmentChangeCallback mIFragmentChangeCallback;
    private IVipPayClickListener mIVipPayClickListener;
    private TextView tvData;
    private WebView webView;
    private static List<SMGameListBannerParent> bannerDatas = new ArrayList();
    private static List<SMGameListBannerParent> enBannerDatas = new ArrayList();
    private static List<SMIconListParent> iConsDatas = new ArrayList();
    private static List<SMIconListParent> enIConsDatas = new ArrayList();
    private static List<SMIconListParent> hotBottomDatas = new ArrayList();
    private static List<SMIconListParent> enHotBottomDatas = new ArrayList();
    private static List<SMGameListParent> gameTypeDatas = new ArrayList();
    private static List<SMGameListParent> enGameTypeDatas = new ArrayList();
    private static List<SMADBean> adDatas = new ArrayList();
    private static List<SMADBean> enAdDatas = new ArrayList();
    private String deviceName = "";
    private Map<String, String> gameInfoExpand = new HashMap();
    private List<IGameListRefreshUserListener> refreshUserListeners = new ArrayList();
    private boolean isReportDailyActive = false;
    private boolean isReportEntryExposureDaily = false;
    private boolean isReportExposureReport = false;
    private boolean isReportGameExposureDaily = false;
    private boolean isReportGameExposureNum = false;
    private boolean isReportUserAddReport = false;
    private boolean isBanner = false;
    private boolean isIcons = false;
    private boolean isHotBottom = false;
    private boolean isGameType = false;
    private boolean isAD = false;
    private boolean isGameListRequest = false;
    private boolean isADPopRequest = false;
    private boolean isADPopOpeRequest = false;

    /* renamed from: com.tenmeter.smlibrary.utils.SMGameClient$32, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass32 implements Consumer<Boolean> {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ SMGameInfo val$bean;
        final /* synthetic */ IGameOpenListener val$listener;

        public AnonymousClass32(Activity activity, IGameOpenListener iGameOpenListener, SMGameInfo sMGameInfo) {
            this.val$activity = activity;
            this.val$listener = iGameOpenListener;
            this.val$bean = sMGameInfo;
        }

        @Override // com.tenmeter.smlibrary.listener.Consumer
        public void accept(Boolean bool) {
            if (bool.booleanValue()) {
                SMGameClient.this.getInfo(new IUserInfoCallback() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.32.1
                    @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                    public void onError(String str) {
                        AnonymousClass32.this.val$activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.32.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                IGameOpenListener iGameOpenListener = AnonymousClass32.this.val$listener;
                                if (iGameOpenListener != null) {
                                    iGameOpenListener.openResult(false);
                                }
                                SMGameClient.isClick = false;
                            }
                        });
                    }

                    @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                    public void onSuccessFul(SMGameUser sMGameUser) {
                        AnonymousClass32.this.val$activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.32.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IGameOpenListener iGameOpenListener = AnonymousClass32.this.val$listener;
                                if (iGameOpenListener != null) {
                                    iGameOpenListener.openResult(true);
                                }
                                SMGameClient.isClick = false;
                                SMGameClient.isRefresh = false;
                                AnonymousClass32 anonymousClass32 = AnonymousClass32.this;
                                SMGameClient.this.jumpGame(anonymousClass32.val$bean, anonymousClass32.val$activity);
                            }
                        });
                    }
                });
            } else {
                this.val$activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.32.2
                    @Override // java.lang.Runnable
                    public void run() {
                        IGameOpenListener iGameOpenListener = AnonymousClass32.this.val$listener;
                        if (iGameOpenListener != null) {
                            iGameOpenListener.openResult(false);
                        }
                        SMGameClient.isClick = false;
                    }
                });
            }
        }
    }

    private SMGameClient() {
    }

    private void entryExposureDaily(final Consumer<Boolean> consumer) {
        if (!this.isReportEntryExposureDaily && !DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.ENTRY_EXPOSURE_DAILY_TIME, 0L), System.currentTimeMillis())) {
            KLog.i("entryExposureDaily+++++++++++++++++++++++");
            this.isReportEntryExposureDaily = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.ENTRY_EXPOSURE_DAILY, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.8
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isReportEntryExposureDaily = false;
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        BaseBean json2obj = JsonConvert.json2obj(str, SMReportBean.class);
                        if (json2obj.getCode() == 0) {
                            if (json2obj.getData() != null && ((SMReportBean) json2obj.getData()).isResult()) {
                                PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.ENTRY_EXPOSURE_DAILY_TIME, System.currentTimeMillis());
                            }
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.TRUE);
                            }
                        } else {
                            Consumer consumer3 = consumer;
                            if (consumer3 != null) {
                                consumer3.accept(Boolean.FALSE);
                            }
                        }
                        SMGameClient.this.isReportEntryExposureDaily = false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                this.isReportEntryExposureDaily = false;
            }
        }
    }

    private void gameExposureDaily(final Consumer<Boolean> consumer) {
        if (!this.isReportGameExposureDaily && !DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.GAME_EXPOSURE_DAILY_TIME, 0L), System.currentTimeMillis())) {
            KLog.i("gameExposureDaily+++++++++++++++++++++++每天只触发一次");
            this.isReportGameExposureDaily = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.GAME_EXPOSURE_DAILY, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.10
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isReportGameExposureDaily = false;
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        BaseBean json2obj = JsonConvert.json2obj(str, SMReportBean.class);
                        if (json2obj.getCode() == 0) {
                            if (json2obj.getData() != null && ((SMReportBean) json2obj.getData()).isResult()) {
                                PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.GAME_EXPOSURE_DAILY_TIME, System.currentTimeMillis());
                            }
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.TRUE);
                            }
                        } else {
                            Consumer consumer3 = consumer;
                            if (consumer3 != null) {
                                consumer3.accept(Boolean.FALSE);
                            }
                        }
                        SMGameClient.this.isReportGameExposureDaily = false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                this.isReportGameExposureDaily = false;
            }
        }
    }

    private synchronized void gameExposureNum(final Consumer<Boolean> consumer) {
        try {
            gameExposureDaily(null);
            Map<String, Integer> hashMapData = PreferencesUtils.getHashMapData(getContext(), "game_exposure_nNum");
            if (hashMapData.containsKey(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"))) {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), Integer.valueOf(hashMapData.get(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd")).intValue() + 1));
            } else {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), 1);
            }
            PreferencesUtils.putHashMapData(getContext(), "game_exposure_nNum", hashMapData);
            StringBuilder sb = new StringBuilder();
            for (String str : hashMapData.keySet()) {
                if (DateFormatUtils.getSecondsFromDate(str, "yyyy-MM-dd") < DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                    sb.append(str + xoXoI.f2670oxoX + hashMapData.get(str) + ",");
                }
            }
            if (!sb.toString().isEmpty() && !this.isReportGameExposureNum) {
                this.isReportGameExposureNum = true;
                JSONObject jSONObject = new JSONObject();
                KLog.i("gameExposureNum+++++++++++++++++++++++每次展示游戏列表都进行统计");
                try {
                    jSONObject.put("thirdPartName", thirdPartName);
                    jSONObject.put("data", sb.toString());
                    HttpClientUtils.post(baseUrl + URLContent.GAME_EXPOSURE_NUM, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.11
                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onError(String str2) {
                            SMGameClient.this.isReportGameExposureNum = false;
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.FALSE);
                            }
                        }

                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onSuccess(String str2) {
                            if (JsonConvert.json2obj(str2, SMReportBean.class).getCode() == 0) {
                                Map<String, Integer> hashMapData2 = PreferencesUtils.getHashMapData(SMGameClient.getContext(), "game_exposure_nNum");
                                HashMap hashMap = new HashMap();
                                for (String str3 : hashMapData2.keySet()) {
                                    if (DateFormatUtils.getSecondsFromDate(str3, "yyyy-MM-dd") == DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                                        hashMap.put(str3, hashMapData2.get(str3));
                                    }
                                }
                                PreferencesUtils.putHashMapData(SMGameClient.getContext(), "game_exposure_nNum", hashMap);
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.TRUE);
                                }
                            } else {
                                Consumer consumer3 = consumer;
                                if (consumer3 != null) {
                                    consumer3.accept(Boolean.FALSE);
                                }
                            }
                            SMGameClient.this.isReportGameExposureNum = false;
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    this.isReportGameExposureNum = false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getADs(final IADCallback iADCallback) {
        if (adDatas.size() != 0 && getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iADCallback != null) {
                iADCallback.onSuccessFul(adDatas);
                return;
            }
            return;
        }
        if (enAdDatas.size() != 0 && !getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iADCallback != null) {
                iADCallback.onSuccessFul(enAdDatas);
                return;
            }
            return;
        }
        if (!this.isAD) {
            this.isAD = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.AD_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.27
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isAD = false;
                        IADCallback iADCallback2 = iADCallback;
                        if (iADCallback2 != null) {
                            iADCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isAD = false;
                        BaseBean json2arrayOther = JsonConvert.json2arrayOther(str, SMADBean.class);
                        if (json2arrayOther.getCode() == 0) {
                            if (json2arrayOther.getData() != null) {
                                if (iADCallback != null) {
                                    if (SMGameClient.this.getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                                        SMGameClient.adDatas.clear();
                                        SMGameClient.adDatas.addAll((List) json2arrayOther.getData());
                                        iADCallback.onSuccessFul(SMGameClient.adDatas);
                                        return;
                                    } else {
                                        SMGameClient.enAdDatas.clear();
                                        SMGameClient.enAdDatas.addAll((List) json2arrayOther.getData());
                                        iADCallback.onSuccessFul(SMGameClient.enAdDatas);
                                        return;
                                    }
                                }
                                return;
                            }
                            IADCallback iADCallback2 = iADCallback;
                            if (iADCallback2 != null) {
                                iADCallback2.onSuccessFul(new ArrayList());
                                return;
                            }
                            return;
                        }
                        IADCallback iADCallback3 = iADCallback;
                        if (iADCallback3 != null) {
                            iADCallback3.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isAD = false;
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBanner(final IGameListBannerCallback iGameListBannerCallback) {
        JSONObject jSONObject = new JSONObject();
        if (bannerDatas.size() != 0 && getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iGameListBannerCallback != null) {
                iGameListBannerCallback.onSuccessFul(bannerDatas);
                return;
            }
            return;
        }
        if (enBannerDatas.size() != 0 && !getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iGameListBannerCallback != null) {
                iGameListBannerCallback.onSuccessFul(enBannerDatas);
            }
        } else if (!this.isBanner) {
            this.isBanner = true;
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.BANNER_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.19
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isBanner = false;
                        IGameListBannerCallback iGameListBannerCallback2 = iGameListBannerCallback;
                        if (iGameListBannerCallback2 != null) {
                            iGameListBannerCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isBanner = false;
                        BaseBean json2arrayOther = JsonConvert.json2arrayOther(str, SMGameListBannerParent.class);
                        if (json2arrayOther.getCode() == 0) {
                            if (json2arrayOther.getData() != null) {
                                if (iGameListBannerCallback != null) {
                                    if (SMGameClient.this.getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                                        SMGameClient.bannerDatas.clear();
                                        SMGameClient.bannerDatas.addAll((List) json2arrayOther.getData());
                                        iGameListBannerCallback.onSuccessFul(SMGameClient.bannerDatas);
                                        return;
                                    } else {
                                        SMGameClient.enBannerDatas.clear();
                                        SMGameClient.enBannerDatas.addAll((List) json2arrayOther.getData());
                                        iGameListBannerCallback.onSuccessFul(SMGameClient.enBannerDatas);
                                        return;
                                    }
                                }
                                return;
                            }
                            IGameListBannerCallback iGameListBannerCallback2 = iGameListBannerCallback;
                            if (iGameListBannerCallback2 != null) {
                                iGameListBannerCallback2.onSuccessFul(new ArrayList());
                                return;
                            }
                            return;
                        }
                        IGameListBannerCallback iGameListBannerCallback3 = iGameListBannerCallback;
                        if (iGameListBannerCallback3 != null) {
                            iGameListBannerCallback3.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                this.isBanner = false;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:2|3|(3:8|(2:10|(1:12))(2:16|(1:18))|13)|19|20|21|13) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a6, code lost:
    
        if (r7 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
    
        r7.accept(java.lang.Boolean.FALSE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
    
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void getBaseUrl(final com.tenmeter.smlibrary.listener.Consumer<java.lang.Boolean> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = com.tenmeter.smlibrary.utils.SMGameClient.thirdPartKey     // Catch: java.lang.Throwable -> L6e
            android.content.Context r1 = getContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = com.tenmeter.smlibrary.utils.PreferencesUtils.SAVE_THIRD_PART_KEY     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = ""
            java.lang.String r1 = com.tenmeter.smlibrary.utils.PreferencesUtils.getString(r1, r2, r3)     // Catch: java.lang.Throwable -> L6e
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L6e
            if (r0 == 0) goto L81
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = com.tenmeter.smlibrary.utils.PreferencesUtils.SECRET_VALID_TIME     // Catch: java.lang.Throwable -> L6e
            r2 = 0
            long r0 = com.tenmeter.smlibrary.utils.PreferencesUtils.getLong(r0, r1, r2)     // Catch: java.lang.Throwable -> L6e
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6e
            boolean r0 = com.tenmeter.smlibrary.utils.DateFormatUtils.isSameDay(r0, r4)     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L2c
            goto L81
        L2c:
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = com.tenmeter.smlibrary.utils.PreferencesUtils.SECRET_VALID     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r0 = com.tenmeter.smlibrary.utils.PreferencesUtils.getObject(r0, r1)     // Catch: java.lang.Throwable -> L6e
            if (r0 == 0) goto L70
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = com.tenmeter.smlibrary.utils.PreferencesUtils.SECRET_VALID     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r0 = com.tenmeter.smlibrary.utils.PreferencesUtils.getObject(r0, r1)     // Catch: java.lang.Throwable -> L6e
            com.tenmeter.smlibrary.entity.SMGameSecretValid r0 = (com.tenmeter.smlibrary.entity.SMGameSecretValid) r0     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r0.getBaseUrl()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L6e
            com.tenmeter.smlibrary.utils.SMGameClient.baseUrl = r0     // Catch: java.lang.Throwable -> L6e
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = com.tenmeter.smlibrary.utils.PreferencesUtils.SECRET_VALID     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r0 = com.tenmeter.smlibrary.utils.PreferencesUtils.getObject(r0, r1)     // Catch: java.lang.Throwable -> L6e
            com.tenmeter.smlibrary.entity.SMGameSecretValid r0 = (com.tenmeter.smlibrary.entity.SMGameSecretValid) r0     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r0.getEnv()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = "dev"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L6e
            com.tenmeter.smlibrary.utils.SMGameClient.isDev = r0     // Catch: java.lang.Throwable -> L6e
            if (r7 == 0) goto Lb0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L6e
            r7.accept(r0)     // Catch: java.lang.Throwable -> L6e
            goto Lb0
        L6e:
            r7 = move-exception
            goto Lb2
        L70:
            android.content.Context r0 = getContext()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = com.tenmeter.smlibrary.utils.PreferencesUtils.SECRET_VALID_TIME     // Catch: java.lang.Throwable -> L6e
            com.tenmeter.smlibrary.utils.PreferencesUtils.putLong(r0, r1, r2)     // Catch: java.lang.Throwable -> L6e
            if (r7 == 0) goto Lb0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L6e
            r7.accept(r0)     // Catch: java.lang.Throwable -> L6e
            goto Lb0
        L81:
            java.lang.String r0 = "https://server.10m.com.cn/secret/valid"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6e
            r1.<init>()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = "thirdPartKey"
            java.lang.String r3 = com.tenmeter.smlibrary.utils.SMGameClient.thirdPartKey     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            java.lang.String r2 = "thirdPartName"
            java.lang.String r3 = com.tenmeter.smlibrary.utils.SMGameClient.thirdPartName     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            com.tenmeter.smlibrary.utils.SMGameClient$6 r2 = new com.tenmeter.smlibrary.utils.SMGameClient$6     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            r2.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            com.tenmeter.smlibrary.utils.HttpClientUtils.post(r0, r1, r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> La5
            goto Lb0
        La5:
            r0 = move-exception
            if (r7 == 0) goto Lad
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L6e
            r7.accept(r1)     // Catch: java.lang.Throwable -> L6e
        Lad:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6e
        Lb0:
            monitor-exit(r6)
            return
        Lb2:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6e
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.SMGameClient.getBaseUrl(com.tenmeter.smlibrary.listener.Consumer):void");
    }

    public static Context getContext() {
        Context context2 = BaseProvider.mContext;
        if (context2 == null) {
            return context;
        }
        return context2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameListRequest(String str, final IGameListCallback iGameListCallback) {
        gameExposureNum(null);
        if (!this.isGameListRequest) {
            this.isGameListRequest = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                if (str != null && !str.equals("")) {
                    jSONObject.put("includeGameId", str);
                }
                HttpClientUtils.post(baseUrl + URLContent.GAME_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.28
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str2) {
                        SMGameClient.this.isGameListRequest = false;
                        IGameListCallback iGameListCallback2 = iGameListCallback;
                        if (iGameListCallback2 != null) {
                            iGameListCallback2.onError(str2);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str2) {
                        SMGameClient.this.isGameListRequest = false;
                        BaseBean json2array = JsonConvert.json2array(str2, SMGameInfo.class);
                        if (json2array.getCode() == 0) {
                            if (json2array.getData() != null) {
                                IGameListCallback iGameListCallback2 = iGameListCallback;
                                if (iGameListCallback2 != null) {
                                    iGameListCallback2.onSuccessFul((List) json2array.getData());
                                    return;
                                }
                                return;
                            }
                            IGameListCallback iGameListCallback3 = iGameListCallback;
                            if (iGameListCallback3 != null) {
                                iGameListCallback3.onSuccessFul(new ArrayList());
                                return;
                            }
                            return;
                        }
                        IGameListCallback iGameListCallback4 = iGameListCallback;
                        if (iGameListCallback4 != null) {
                            iGameListCallback4.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isGameListRequest = false;
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameTy(final IGameListForTypeCallback iGameListForTypeCallback) {
        if (gameTypeDatas.size() != 0 && getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iGameListForTypeCallback != null) {
                iGameListForTypeCallback.onSuccessFul(gameTypeDatas);
                return;
            }
            return;
        }
        if (enGameTypeDatas.size() != 0 && !getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iGameListForTypeCallback != null) {
                iGameListForTypeCallback.onSuccessFul(enGameTypeDatas);
                return;
            }
            return;
        }
        gameExposureNum(null);
        if (!this.isGameType) {
            this.isGameType = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.TAG_GAME_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.25
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isGameType = false;
                        IGameListForTypeCallback iGameListForTypeCallback2 = iGameListForTypeCallback;
                        if (iGameListForTypeCallback2 != null) {
                            iGameListForTypeCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isGameType = false;
                        BaseBean json2arrayOther = JsonConvert.json2arrayOther(str, SMGameListParent.class);
                        if (json2arrayOther.getCode() == 0) {
                            if (json2arrayOther.getData() != null) {
                                if (iGameListForTypeCallback != null) {
                                    if (SMGameClient.this.getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                                        SMGameClient.gameTypeDatas.clear();
                                        SMGameClient.gameTypeDatas.addAll((List) json2arrayOther.getData());
                                        iGameListForTypeCallback.onSuccessFul(SMGameClient.gameTypeDatas);
                                        return;
                                    } else {
                                        SMGameClient.enGameTypeDatas.clear();
                                        SMGameClient.enGameTypeDatas.addAll((List) json2arrayOther.getData());
                                        iGameListForTypeCallback.onSuccessFul(SMGameClient.enGameTypeDatas);
                                        return;
                                    }
                                }
                                return;
                            }
                            IGameListForTypeCallback iGameListForTypeCallback2 = iGameListForTypeCallback;
                            if (iGameListForTypeCallback2 != null) {
                                iGameListForTypeCallback2.onSuccessFul(new ArrayList());
                                return;
                            }
                            return;
                        }
                        IGameListForTypeCallback iGameListForTypeCallback3 = iGameListForTypeCallback;
                        if (iGameListForTypeCallback3 != null) {
                            iGameListForTypeCallback3.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isGameType = false;
                e.printStackTrace();
                iGameListForTypeCallback.onError(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHotBottom(final IIconCallback iIconCallback) {
        if (hotBottomDatas.size() != 0 && getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iIconCallback != null) {
                iIconCallback.onSuccessFul(hotBottomDatas);
                return;
            }
            return;
        }
        if (enHotBottomDatas.size() != 0 && !getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iIconCallback != null) {
                iIconCallback.onSuccessFul(enHotBottomDatas);
                return;
            }
            return;
        }
        if (!this.isHotBottom) {
            this.isHotBottom = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.STYLE_TYPE_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.24
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isHotBottom = false;
                        IIconCallback iIconCallback2 = iIconCallback;
                        if (iIconCallback2 != null) {
                            iIconCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isHotBottom = false;
                        BaseBean json2arrayOther = JsonConvert.json2arrayOther(str, SMIconListParent.class);
                        if (json2arrayOther.getCode() == 0) {
                            if (json2arrayOther.getData() != null) {
                                if (iIconCallback != null) {
                                    if (SMGameClient.this.getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                                        SMGameClient.hotBottomDatas.clear();
                                        SMGameClient.hotBottomDatas.addAll((List) json2arrayOther.getData());
                                        iIconCallback.onSuccessFul(SMGameClient.hotBottomDatas);
                                        return;
                                    } else {
                                        SMGameClient.enHotBottomDatas.clear();
                                        SMGameClient.enHotBottomDatas.addAll((List) json2arrayOther.getData());
                                        iIconCallback.onSuccessFul(SMGameClient.enHotBottomDatas);
                                        return;
                                    }
                                }
                                return;
                            }
                            IIconCallback iIconCallback2 = iIconCallback;
                            if (iIconCallback2 != null) {
                                iIconCallback2.onSuccessFul(new ArrayList());
                                return;
                            }
                            return;
                        }
                        IIconCallback iIconCallback3 = iIconCallback;
                        if (iIconCallback3 != null) {
                            iIconCallback3.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isHotBottom = false;
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getIcons(final IIconCallback iIconCallback) {
        if (iConsDatas.size() != 0 && getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iIconCallback != null) {
                iIconCallback.onSuccessFul(iConsDatas);
                return;
            }
            return;
        }
        if (enIConsDatas.size() != 0 && !getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (iIconCallback != null) {
                iIconCallback.onSuccessFul(enIConsDatas);
                return;
            }
            return;
        }
        if (!this.isIcons) {
            this.isIcons = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.ICON_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.22
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isIcons = false;
                        IIconCallback iIconCallback2 = iIconCallback;
                        if (iIconCallback2 != null) {
                            iIconCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isIcons = false;
                        BaseBean json2arrayOther = JsonConvert.json2arrayOther(str, SMIconListParent.class);
                        if (json2arrayOther.getCode() == 0) {
                            if (json2arrayOther.getData() != null) {
                                if (iIconCallback != null) {
                                    if (SMGameClient.this.getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                                        SMGameClient.iConsDatas.clear();
                                        List list = SMGameClient.iConsDatas;
                                        int size = ((List) json2arrayOther.getData()).size();
                                        List list2 = (List) json2arrayOther.getData();
                                        if (size > 4) {
                                            list2 = list2.subList(0, 4);
                                        }
                                        list.addAll(list2);
                                        iIconCallback.onSuccessFul(SMGameClient.iConsDatas);
                                        return;
                                    }
                                    SMGameClient.enIConsDatas.clear();
                                    List list3 = SMGameClient.enIConsDatas;
                                    int size2 = ((List) json2arrayOther.getData()).size();
                                    List list4 = (List) json2arrayOther.getData();
                                    if (size2 > 4) {
                                        list4 = list4.subList(0, 4);
                                    }
                                    list3.addAll(list4);
                                    iIconCallback.onSuccessFul(SMGameClient.enIConsDatas);
                                    return;
                                }
                                return;
                            }
                            IIconCallback iIconCallback2 = iIconCallback;
                            if (iIconCallback2 != null) {
                                iIconCallback2.onSuccessFul(new ArrayList());
                                return;
                            }
                            return;
                        }
                        IIconCallback iIconCallback3 = iIconCallback;
                        if (iIconCallback3 != null) {
                            iIconCallback3.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isIcons = false;
                e.printStackTrace();
            }
        }
    }

    public static SMGameClient getInstance() {
        if (instance == null) {
            synchronized (SMGameClient.class) {
                try {
                    if (instance == null) {
                        instance = new SMGameClient();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public static String getRequestBody(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("token", getInstance().getUserInfo().getUserToken());
            jSONObject.put("uid", getInstance().getUserInfo().getUid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void getUserByStartGame(final SMGameInfo sMGameInfo, final Activity activity, final IGameOpenListener iGameOpenListener) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new AnonymousClass32(activity, iGameOpenListener, sMGameInfo));
        } else {
            getInfo(new IUserInfoCallback() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.33
                @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                public void onError(String str) {
                    activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.33.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IGameOpenListener iGameOpenListener2 = iGameOpenListener;
                            if (iGameOpenListener2 != null) {
                                iGameOpenListener2.openResult(false);
                            }
                            SMGameClient.isClick = false;
                        }
                    });
                }

                @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                public void onSuccessFul(SMGameUser sMGameUser) {
                    activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.33.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IGameOpenListener iGameOpenListener2 = iGameOpenListener;
                            if (iGameOpenListener2 != null) {
                                iGameOpenListener2.openResult(true);
                            }
                            SMGameClient.isClick = false;
                            SMGameClient.isRefresh = false;
                            AnonymousClass33 anonymousClass33 = AnonymousClass33.this;
                            SMGameClient.this.jumpGame(sMGameInfo, activity);
                        }
                    });
                }
            });
        }
    }

    private static void init(Context context2) {
        context = context2;
    }

    private static void initUrl() {
        if (baseUrl.isEmpty()) {
            getInstance().getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.5
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    bool.booleanValue();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpGame(SMGameInfo sMGameInfo, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) SMGameH5Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMGameInfo);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDailyActive(final Consumer<Boolean> consumer) {
        if (!this.isReportDailyActive && !DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.DAILY_ACTIVE_REPORT_TIME, 0L), System.currentTimeMillis())) {
            KLog.i("reportDailyActive+++++++++++++++++++++++");
            this.isReportDailyActive = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.DAILY_ACTIVE_REPORT, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.7
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isReportDailyActive = false;
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        BaseBean json2obj = JsonConvert.json2obj(str, SMReportBean.class);
                        if (json2obj.getCode() == 0) {
                            if (json2obj.getData() != null && ((SMReportBean) json2obj.getData()).isResult()) {
                                PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.DAILY_ACTIVE_REPORT_TIME, System.currentTimeMillis());
                            }
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.TRUE);
                            }
                        } else {
                            Consumer consumer3 = consumer;
                            if (consumer3 != null) {
                                consumer3.accept(Boolean.FALSE);
                            }
                        }
                        SMGameClient.this.isReportDailyActive = false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                this.isReportDailyActive = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void userAddReport(final Consumer<Boolean> consumer) {
        try {
            if (!isUserAddReport) {
                Map<String, Integer> hashMapData = PreferencesUtils.getHashMapData(getContext(), "user_add_report");
                if (hashMapData.containsKey(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"))) {
                    hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), Integer.valueOf(hashMapData.get(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd")).intValue() + 1));
                } else {
                    hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), 1);
                }
                PreferencesUtils.putHashMapData(getContext(), "user_add_report", hashMapData);
                StringBuilder sb = new StringBuilder();
                for (String str : hashMapData.keySet()) {
                    if (DateFormatUtils.getSecondsFromDate(str, "yyyy-MM-dd") < DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                        sb.append(str + xoXoI.f2670oxoX + hashMapData.get(str) + ",");
                    }
                }
                if (!sb.toString().isEmpty() && !this.isReportUserAddReport) {
                    this.isReportUserAddReport = true;
                    KLog.i("userAddReport+++++++++++++++++++++++每个APP整个生命周期只调用一次");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("thirdPartName", thirdPartName);
                        jSONObject.put("data", sb.toString());
                        HttpClientUtils.post(baseUrl + URLContent.USER_ADD_REPORT, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.12
                            @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                            public void onError(String str2) {
                                SMGameClient.this.isReportUserAddReport = false;
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.FALSE);
                                }
                            }

                            @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                            public void onSuccess(String str2) {
                                BaseBean json2obj = JsonConvert.json2obj(str2, SMReportBean.class);
                                if (json2obj.getCode() == 0) {
                                    if (json2obj.getData() != null && ((SMReportBean) json2obj.getData()).isResult()) {
                                        SMGameClient.isUserAddReport = true;
                                    }
                                    Map<String, Integer> hashMapData2 = PreferencesUtils.getHashMapData(SMGameClient.getContext(), "user_add_report");
                                    HashMap hashMap = new HashMap();
                                    for (String str3 : hashMapData2.keySet()) {
                                        if (DateFormatUtils.getSecondsFromDate(str3, "yyyy-MM-dd") == DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                                            hashMap.put(str3, hashMapData2.get(str3));
                                        }
                                    }
                                    PreferencesUtils.putHashMapData(SMGameClient.getContext(), "user_add_report", hashMap);
                                    Consumer consumer2 = consumer;
                                    if (consumer2 != null) {
                                        consumer2.accept(Boolean.TRUE);
                                    }
                                } else {
                                    Consumer consumer3 = consumer;
                                    if (consumer3 != null) {
                                        consumer3.accept(Boolean.FALSE);
                                    }
                                }
                                SMGameClient.this.isReportUserAddReport = false;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.isReportUserAddReport = false;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void addRefreshUserListener(IGameListRefreshUserListener iGameListRefreshUserListener) {
        this.refreshUserListeners.add(iGameListRefreshUserListener);
    }

    public void clickPopOpeDialog(int i, final ICommonResultCallback iCommonResultCallback) {
        if (!this.isADPopOpeRequest) {
            this.isADPopOpeRequest = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("ope", i);
                HttpClientUtils.post(baseUrl + URLContent.POP_OPE, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.30
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isADPopRequest = false;
                        ICommonResultCallback iCommonResultCallback2 = iCommonResultCallback;
                        if (iCommonResultCallback2 != null) {
                            iCommonResultCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isADPopOpeRequest = false;
                        BaseBean json2obj = JsonConvert.json2obj(str, SMReportBean.class);
                        if (json2obj.getCode() == 0) {
                            if (json2obj.getData() != null) {
                                ICommonResultCallback iCommonResultCallback2 = iCommonResultCallback;
                                if (iCommonResultCallback2 != null) {
                                    iCommonResultCallback2.onSuccessFul(((SMReportBean) json2obj.getData()).isResult());
                                    return;
                                }
                                return;
                            }
                            ICommonResultCallback iCommonResultCallback3 = iCommonResultCallback;
                            if (iCommonResultCallback3 != null) {
                                iCommonResultCallback3.onSuccessFul(false);
                                return;
                            }
                            return;
                        }
                        ICommonResultCallback iCommonResultCallback4 = iCommonResultCallback;
                        if (iCommonResultCallback4 != null) {
                            iCommonResultCallback4.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isGameListRequest = false;
                e.printStackTrace();
            }
        }
    }

    public void closeGameActivity() {
        WebView webView = this.webView;
        if (webView != null && (webView.getContext() instanceof Activity)) {
            ((Activity) this.webView.getContext()).finish();
        }
    }

    public void comGameStart(int i, final Consumer<Boolean> consumer) {
        KLog.i("comGameStart+++++++++++++++++++++++游戏启动页调用");
        JSONObject jSONObject = new JSONObject();
        try {
            if (getUserInfo() != null) {
                jSONObject.put("thirdPartName", thirdPartName);
                jSONObject.put("gameId", i);
                jSONObject.put("uid", getUserInfo().getUid());
                HttpClientUtils.post(baseUrl + URLContent.COMP_GAME_START, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.13
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        if (JsonConvert.json2obj(str, SMReportBean.class).getCode() == 0) {
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.TRUE);
                                return;
                            }
                            return;
                        }
                        Consumer consumer3 = consumer;
                        if (consumer3 != null) {
                            consumer3.accept(Boolean.FALSE);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void expand(String str) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge." + str + "()", new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                }
            });
        }
    }

    public synchronized void exposureReport(final Consumer<Boolean> consumer) {
        try {
            KLog.i("exposureReport+++++++++++++++++++++++");
            entryExposureDaily(null);
            Map<String, Integer> hashMapData = PreferencesUtils.getHashMapData(getContext(), "entry_exposure_num");
            if (hashMapData.containsKey(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"))) {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), Integer.valueOf(hashMapData.get(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd")).intValue() + 1));
            } else {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), 1);
            }
            PreferencesUtils.putHashMapData(getContext(), "entry_exposure_num", hashMapData);
            StringBuilder sb = new StringBuilder();
            for (String str : hashMapData.keySet()) {
                if (DateFormatUtils.getSecondsFromDate(str, "yyyy-MM-dd") < DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                    sb.append(str + xoXoI.f2670oxoX + hashMapData.get(str) + ",");
                }
            }
            if (!sb.toString().isEmpty() && !this.isReportExposureReport) {
                this.isReportExposureReport = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("thirdPartName", thirdPartName);
                    jSONObject.put("data", sb.toString());
                    HttpClientUtils.post(baseUrl + URLContent.ENTRY_EXPOSURE_NUM, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.9
                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onError(String str2) {
                            SMGameClient.this.isReportExposureReport = false;
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.FALSE);
                            }
                        }

                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onSuccess(String str2) {
                            if (JsonConvert.json2obj(str2, SMReportBean.class).getCode() == 0) {
                                Map<String, Integer> hashMapData2 = PreferencesUtils.getHashMapData(SMGameClient.getContext(), "entry_exposure_num");
                                HashMap hashMap = new HashMap();
                                for (String str3 : hashMapData2.keySet()) {
                                    if (DateFormatUtils.getSecondsFromDate(str3, "yyyy-MM-dd") == DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                                        hashMap.put(str3, hashMapData2.get(str3));
                                    }
                                }
                                PreferencesUtils.putHashMapData(SMGameClient.getContext(), "entry_exposure_num", hashMap);
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.TRUE);
                                }
                            } else {
                                Consumer consumer3 = consumer;
                                if (consumer3 != null) {
                                    consumer3.accept(Boolean.FALSE);
                                }
                            }
                            SMGameClient.this.isReportExposureReport = false;
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    this.isReportExposureReport = false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void gamePrivate(Consumer<Boolean> consumer) {
        getBaseUrl(consumer);
    }

    public void getAD(final IADCallback iADCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.26
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getADs(iADCallback);
                    } else {
                        iADCallback.onError("init error...");
                    }
                }
            });
        } else {
            getADs(iADCallback);
        }
    }

    public void getADPopDialog(final IPopResultCallback iPopResultCallback) {
        if (!PreferencesUtils.getString(getContext(), PreferencesUtils.SAVE_AD_POP_TIME, "").equals(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd")) && !this.isADPopRequest) {
            this.isADPopRequest = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("language", getLanguage());
                jSONObject.put("thirdPartKey", thirdPartKey);
                jSONObject.put("thirdPartName", thirdPartName);
                HttpClientUtils.post(baseUrl + URLContent.GET_POP_AD, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.29
                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onError(String str) {
                        SMGameClient.this.isADPopRequest = false;
                        IPopResultCallback iPopResultCallback2 = iPopResultCallback;
                        if (iPopResultCallback2 != null) {
                            iPopResultCallback2.onError(str);
                        }
                    }

                    @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                    public void onSuccess(String str) {
                        SMGameClient.this.isADPopRequest = false;
                        BaseBean json2obj = JsonConvert.json2obj(str, SMPOPResultBean.class);
                        if (json2obj.getCode() == 0) {
                            if (json2obj.getData() != null) {
                                IPopResultCallback iPopResultCallback2 = iPopResultCallback;
                                if (iPopResultCallback2 != null) {
                                    iPopResultCallback2.onSuccessFul((SMPOPResultBean) json2obj.getData());
                                    return;
                                }
                                return;
                            }
                            IPopResultCallback iPopResultCallback3 = iPopResultCallback;
                            if (iPopResultCallback3 != null) {
                                iPopResultCallback3.onSuccessFul(null);
                                return;
                            }
                            return;
                        }
                        IPopResultCallback iPopResultCallback4 = iPopResultCallback;
                        if (iPopResultCallback4 != null) {
                            iPopResultCallback4.onError("Error");
                        }
                    }
                });
            } catch (Exception e) {
                this.isGameListRequest = false;
                e.printStackTrace();
            }
        }
    }

    public ICalListener getCalGSensor() {
        return this.mCalGSensor;
    }

    public String getDeviceName() {
        if (this.deviceName.equals("")) {
            return "Samsung";
        }
        return this.deviceName;
    }

    public void getGameBannerList(final IGameListBannerCallback iGameListBannerCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.18
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getBanner(iGameListBannerCallback);
                    } else {
                        iGameListBannerCallback.onError("init error...");
                    }
                }
            });
        } else {
            getBanner(iGameListBannerCallback);
        }
    }

    public IGameGSensor getGameGSonsorListener() {
        return this.mGameGSensor;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameInfo() {
        if (getUserInfo() == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", getUserInfo().getUserToken());
            jSONObject.put("uid", getUserInfo().getUid() + "");
            jSONObject.put(GetGameDetail.GAME_ID, this.gameId);
            jSONObject.put("serverUrl", getUserInfo().getServerUrl());
            jSONObject.put("joinRaceId", 0);
            jSONObject.put("otpToken", getUserInfo().getOtpToken());
            jSONObject.put("roomId", 0);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public Map<String, String> getGameInfoExpand() {
        return this.gameInfoExpand;
    }

    public void getGameList(final IGameListCallback iGameListCallback, final String str) {
        if (!thirdPartKey.isEmpty() && !thirdPartName.isEmpty()) {
            if (baseUrl.isEmpty()) {
                getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.16
                    @Override // com.tenmeter.smlibrary.listener.Consumer
                    public void accept(Boolean bool) {
                        if (bool.booleanValue()) {
                            SMGameClient.this.getGameListRequest(str, iGameListCallback);
                        } else {
                            iGameListCallback.onError("Error");
                        }
                    }
                });
                return;
            } else {
                getGameListRequest(str, iGameListCallback);
                return;
            }
        }
        Toast.makeText(getContext(), "Please initialize first", 1).show();
    }

    public IGameListItemClickListener getGameListItemClickListener() {
        return this.mGameListItemClickListener;
    }

    public IGameStatus getGameStatusListener() {
        return this.mGameStatus;
    }

    public void getHotBottomLists(final IIconCallback iIconCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.23
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getHotBottom(iIconCallback);
                    } else {
                        iIconCallback.onError("init error...");
                    }
                }
            });
        } else {
            getHotBottom(iIconCallback);
        }
    }

    public IAdGameOpenListener getIAdGameOpenListener() {
        return this.mIAdGameOpenListener;
    }

    public IFragmentChangeCallback getIFragmentChangeCallback() {
        return this.mIFragmentChangeCallback;
    }

    public IVipPayClickListener getIVipPayClickListener() {
        return this.mIVipPayClickListener;
    }

    public void getIconLists(final IIconCallback iIconCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.21
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getIcons(iIconCallback);
                    } else {
                        iIconCallback.onError("init error...");
                    }
                }
            });
        } else {
            getIcons(iIconCallback);
        }
    }

    public void getInfo(final IUserInfoCallback iUserInfoCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            jSONObject.put("thirdPartNickname", thirdPartNickname);
            jSONObject.put("thirdPartHeadImage", thirdPartHeadImage);
            jSONObject.put("thirdPartUid", thirdPartUid);
            HttpClientUtils.post(baseUrl + URLContent.SYNC_USER, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.15
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    IUserInfoCallback iUserInfoCallback2 = iUserInfoCallback;
                    if (iUserInfoCallback2 != null) {
                        iUserInfoCallback2.onError(str);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    try {
                        BaseBean json2obj = JsonConvert.json2obj(str, SMGameUser.class);
                        if (json2obj.getCode() == 0) {
                            if (json2obj.getData() != null) {
                                SMGameUser sMGameUser = (SMGameUser) json2obj.getData();
                                sMGameUser.setThirdPartHeadImage(SMGameClient.thirdPartHeadImage);
                                sMGameUser.setThirdPartNickname(SMGameClient.thirdPartNickname);
                                sMGameUser.setThirdPartUid(SMGameClient.thirdPartUid);
                                PreferencesUtils.putObject(SMGameClient.getContext(), SMGameClient.this.getSpUserKey(), sMGameUser);
                                IUserInfoCallback iUserInfoCallback2 = iUserInfoCallback;
                                if (iUserInfoCallback2 != null) {
                                    iUserInfoCallback2.onSuccessFul(SMGameClient.this.getUserInfo());
                                }
                            } else {
                                IUserInfoCallback iUserInfoCallback3 = iUserInfoCallback;
                                if (iUserInfoCallback3 != null) {
                                    iUserInfoCallback3.onError("Error");
                                }
                            }
                        } else {
                            IUserInfoCallback iUserInfoCallback4 = iUserInfoCallback;
                            if (iUserInfoCallback4 != null) {
                                iUserInfoCallback4.onError("Error");
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        iUserInfoCallback.onError("Error");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            iUserInfoCallback.onError(e.getMessage());
        }
    }

    public String getLanguage() {
        if (!language.isEmpty()) {
            return language;
        }
        if (getContext().getResources().getConfiguration().locale.getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH)) {
            return Languages.DEFAULT_LANGUAGE_ZH;
        }
        return Languages.DEFAULT_LANGUAGE;
    }

    public String getP1Data() {
        if (getUserInfo() == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(aw.r, getUserInfo().getUid());
            jSONObject.put("name", getUserInfo().getUserNickname());
            jSONObject.put(TtmlNode.TAG_HEAD, getUserInfo().getHeadImage());
            jSONObject.put("mac", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getSpUserKey() {
        if (!thirdPartUid.equals("")) {
            return thirdPartUid;
        }
        return thirdPartKey;
    }

    public void getTypeGameList(final IGameListForTypeCallback iGameListForTypeCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.20
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getGameTy(iGameListForTypeCallback);
                    } else {
                        iGameListForTypeCallback.onError("init error...");
                    }
                }
            });
        } else {
            getGameTy(iGameListForTypeCallback);
        }
    }

    public SMGameUser getUserInfo() {
        if (thirdPartKey.isEmpty()) {
            Toast.makeText(getContext(), "Please initialize first", 1).show();
        }
        if (PreferencesUtils.getObject(getContext(), getSpUserKey(), null) == null) {
            return null;
        }
        return (SMGameUser) PreferencesUtils.getObject(getContext(), getSpUserKey(), null);
    }

    public WebView getWebView() {
        return this.webView;
    }

    public boolean isChina() {
        return getLanguage().equals(Languages.DEFAULT_LANGUAGE_ZH);
    }

    public void jumpAD(SMPOPResultBean sMPOPResultBean, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) SMADActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("bean", sMPOPResultBean);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public void moveKeyDirection(int i) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge.getVKeyboardNum(" + i + oIX0oI.I0Io.f4095I0Io, new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.4
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void movePlayer(int i, SMGameSensor sMGameSensor) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge.moveP" + i + "Game(" + sMGameSensor.getX() + "," + sMGameSensor.getY() + "," + sMGameSensor.getSpeed() + "," + sMGameSensor.getX_Throw() + "," + sMGameSensor.getY_Throw() + "," + sMGameSensor.getZ_Gravity() + "," + sMGameSensor.getCount_Throw() + "," + sMGameSensor.getX_Gravity() + "," + sMGameSensor.getY_Gravity() + oIX0oI.I0Io.f4095I0Io, new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
            TextView textView = this.tvData;
            if (textView == null || !isDev) {
                return;
            }
            textView.setText("x: " + sMGameSensor.getX() + "\ny: " + sMGameSensor.getY() + "\nSpeed: " + sMGameSensor.getSpeed() + "\nX_Throw: " + sMGameSensor.getX_Throw() + "\nY_Throw: " + sMGameSensor.getY_Throw() + "\nCount_Throw: " + sMGameSensor.getCount_Throw() + "\nX_Gravity: " + sMGameSensor.getX_Gravity() + "\nY_Gravity: " + sMGameSensor.getY_Gravity() + "\nZ_Gravity: " + sMGameSensor.getZ_Gravity());
        }
    }

    public void refreshUserInfo(String str, String str2, String str3) {
        String str4;
        String str5;
        isRefresh = true;
        String str6 = "";
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        thirdPartUid = str4;
        if (str2 == null) {
            str5 = "";
        } else {
            str5 = str2;
        }
        thirdPartNickname = str5;
        if (str3 != null) {
            str6 = str3;
        }
        thirdPartHeadImage = str6;
        PreferencesUtils.putString(getContext(), PreferencesUtils.SAVE_THIRD_UID, str);
        PreferencesUtils.putString(getContext(), PreferencesUtils.SAVE_THIRD_USER_NAME, str2);
        PreferencesUtils.putString(getContext(), PreferencesUtils.SAVE_THIRD_HEAD, str3);
        if (this.refreshUserListeners.size() > 0) {
            Iterator<IGameListRefreshUserListener> it = this.refreshUserListeners.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }

    public void removeAllRefreshUserListener() {
        this.refreshUserListeners.clear();
    }

    public void removeRefreshUserListener(IGameListRefreshUserListener iGameListRefreshUserListener) {
        this.refreshUserListeners.remove(iGameListRefreshUserListener);
    }

    public void setCalGSensor(ICalListener iCalListener) {
        this.mCalGSensor = iCalListener;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setGameGSensorListener(IGameGSensor iGameGSensor) {
        this.mGameGSensor = iGameGSensor;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameInfoExpand(Map<String, String> map) {
        this.gameInfoExpand = map;
    }

    public void setGameListItemClickListener(IGameListItemClickListener iGameListItemClickListener) {
        this.mGameListItemClickListener = iGameListItemClickListener;
    }

    public void setGameStatusListener(IGameStatus iGameStatus) {
        this.mGameStatus = iGameStatus;
    }

    public void setIAdGameOpenListener(IAdGameOpenListener iAdGameOpenListener) {
        this.mIAdGameOpenListener = iAdGameOpenListener;
    }

    public void setIFragmentChangeCallback(IFragmentChangeCallback iFragmentChangeCallback) {
        this.mIFragmentChangeCallback = iFragmentChangeCallback;
    }

    public void setIVipPayClickListener(IVipPayClickListener iVipPayClickListener) {
        this.mIVipPayClickListener = iVipPayClickListener;
    }

    public void setLanguage(String str) {
        language = str;
    }

    public void setTextData(TextView textView) {
        this.tvData = textView;
    }

    public void setUserInfo(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6 = "";
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        thirdPartUid = str4;
        PreferencesUtils.putString(getContext(), PreferencesUtils.SAVE_THIRD_UID, str);
        if (getUserInfo() != null) {
            if (!getUserInfo().getThirdPartUid().equals(str) || !getUserInfo().getThirdPartNickname().equals(str2) || !getUserInfo().getThirdPartHeadImage().equals(str3)) {
                refreshUserInfo(str, str2, str3);
                return;
            }
            return;
        }
        isRefresh = true;
        if (str2 == null) {
            str5 = "";
        } else {
            str5 = str2;
        }
        thirdPartNickname = str5;
        if (str3 != null) {
            str6 = str3;
        }
        thirdPartHeadImage = str6;
        PreferencesUtils.putString(getContext(), PreferencesUtils.SAVE_THIRD_USER_NAME, str2);
        PreferencesUtils.putString(getContext(), PreferencesUtils.SAVE_THIRD_HEAD, str3);
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public void startGame(String str, Activity activity) {
        try {
            startGame((SMGameInfo) JsonConvert.fromJson(str, SMGameInfo.class), activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startGameList(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SMGameListNewActivity.class));
    }

    public void startGameListSub(SMGameListParent sMGameListParent, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) SMGameListSubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMGameListParent);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public void startWebActivity(String str, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) SMWebViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void init(Context context2, String str, String str2) {
        init(context2);
        if (!str.equals(PreferencesUtils.getString(getContext(), PreferencesUtils.SAVE_THIRD_PART_KEY, ""))) {
            adDatas.clear();
            enAdDatas.clear();
            gameTypeDatas.clear();
            enGameTypeDatas.clear();
            iConsDatas.clear();
            enIConsDatas.clear();
            enHotBottomDatas.clear();
            hotBottomDatas.clear();
            bannerDatas.clear();
            enBannerDatas.clear();
        }
        thirdPartKey = str;
        if (str2 == null) {
            str2 = "";
        }
        thirdPartName = str2;
    }

    public void startGame(SMGameInfo sMGameInfo, Activity activity) {
        if (isRefresh) {
            if (isClick) {
                return;
            }
            isClick = true;
            getUserByStartGame(sMGameInfo, activity, null);
            return;
        }
        if (isClick) {
            return;
        }
        isClick = true;
        if (getUserInfo() != null) {
            isClick = false;
            jumpGame(sMGameInfo, activity);
        } else {
            getUserByStartGame(sMGameInfo, activity, null);
        }
    }

    private void getUserInfo(final IUserInfoCallback iUserInfoCallback) {
        if (getUserInfo() != null) {
            if (iUserInfoCallback != null) {
                iUserInfoCallback.onSuccessFul(getUserInfo());
            }
        } else {
            if (!thirdPartKey.isEmpty() && !thirdPartName.isEmpty()) {
                if (baseUrl.isEmpty()) {
                    getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.14
                        @Override // com.tenmeter.smlibrary.listener.Consumer
                        public void accept(Boolean bool) {
                            if (bool.booleanValue()) {
                                SMGameClient.this.getInfo(iUserInfoCallback);
                                return;
                            }
                            IUserInfoCallback iUserInfoCallback2 = iUserInfoCallback;
                            if (iUserInfoCallback2 != null) {
                                iUserInfoCallback2.onError("Error");
                            }
                        }
                    });
                    return;
                } else {
                    if (iUserInfoCallback != null) {
                        getInfo(iUserInfoCallback);
                        return;
                    }
                    return;
                }
            }
            Toast.makeText(getContext(), "Please initialize first", 1).show();
        }
    }

    public void getGameList(final IGameListCallback iGameListCallback) {
        if (!thirdPartKey.isEmpty() && !thirdPartName.isEmpty()) {
            if (baseUrl.isEmpty()) {
                getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.17
                    @Override // com.tenmeter.smlibrary.listener.Consumer
                    public void accept(Boolean bool) {
                        if (bool.booleanValue()) {
                            IGameListCallback iGameListCallback2 = iGameListCallback;
                            if (iGameListCallback2 != null) {
                                SMGameClient.this.getGameListRequest("", iGameListCallback2);
                                return;
                            }
                            return;
                        }
                        IGameListCallback iGameListCallback3 = iGameListCallback;
                        if (iGameListCallback3 != null) {
                            iGameListCallback3.onError("Error");
                        }
                    }
                });
                return;
            } else {
                getGameListRequest("", iGameListCallback);
                return;
            }
        }
        Toast.makeText(getContext(), "Please initialize first", 1).show();
    }

    public void startGame(final SMGameInfo sMGameInfo, final Activity activity, final IGameOpenListener iGameOpenListener) {
        if (isRefresh) {
            if (isClick) {
                return;
            }
            isClick = true;
            getUserByStartGame(sMGameInfo, activity, iGameOpenListener);
            return;
        }
        if (isClick) {
            return;
        }
        isClick = true;
        if (getUserInfo() != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.31
                @Override // java.lang.Runnable
                public void run() {
                    IGameOpenListener iGameOpenListener2 = iGameOpenListener;
                    if (iGameOpenListener2 != null) {
                        iGameOpenListener2.openResult(true);
                    }
                    SMGameClient.isClick = false;
                    SMGameClient.this.jumpGame(sMGameInfo, activity);
                }
            });
        } else {
            getUserByStartGame(sMGameInfo, activity, iGameOpenListener);
        }
    }

    public void movePlayer(int i, int i2, int i3, int i4) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge.moveP" + i + "Game(0,0,0,0,0," + i4 + ",0," + i2 + "," + i3 + oIX0oI.I0Io.f4095I0Io, new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
            TextView textView = this.tvData;
            if (textView == null || !isDev) {
                return;
            }
            textView.setText("x: 0\ny: 0\nSpeed: 0\nX_Throw: 0\nY_Throw: 0\nCount_Throw: 0\nX_Gravity: " + i2 + "\nY_Gravity: " + i3 + "\nZ_Gravity: " + i4);
        }
    }
}
