package com.baidu.navisdk.util.http;

import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.o;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class b {
    private static boolean c = true;
    private static volatile b d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f9298a = null;
    private Map<String, String> b = null;

    private b() {
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                try {
                    if (d == null) {
                        d = new b();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private boolean e() {
        o m = c.p().m();
        if (m == null) {
            return false;
        }
        return m.f();
    }

    public String a(String str) {
        Map<String, String> map = this.f9298a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void b() {
        String str;
        String str2;
        String str3;
        String str4;
        Map<String, String> map = this.f9298a;
        if (map == null) {
            this.f9298a = new HashMap();
        } else {
            map.clear();
        }
        String a2 = a();
        this.f9298a.put("NaviStat", a2 + "appnavi.baidu.com/statistics/send");
        this.f9298a.put("RoadConditionCityUpdate", a2 + "its.map.baidu.com/its.php");
        this.f9298a.put("IPOGetGuideMsg", a2 + "appnavi.baidu.com/mop/getmsglist");
        this.f9298a.put("DebugModeGetURL", a2 + "navimon.baidu.com/hunter/emode/get");
        this.f9298a.put("BusinessGetAct", a2 + "appnavi.baidu.com/mop/getacts");
        this.f9298a.put("BusinessUpload", a2 + "appnavi.baidu.com/mop/naviend/upload");
        this.f9298a.put("FinishPageShare", a2 + "appnavi.baidu.com/mop/naviend/share");
        this.f9298a.put("CruiseQA", a2 + "appnavi.baidu.com/mop/naviend/upload");
        this.f9298a.put("MarkFavourite", a2 + "appnavi.baidu.com/mop/naviend/markfavourite");
        this.f9298a.put("CommentRoute", a2 + "navi.map.baidu.com/npb");
        this.f9298a.put("UGCRouteLockOrRouteBad", a2 + "i.map.baidu.com/api/page/road/roadobstructedorbad");
        this.f9298a.put("UGCTraficLagerror", a2 + "i.map.baidu.com/api/page/road/trafficsignswrong");
        this.f9298a.put("UGCRouteAdded", a2 + "i.map.baidu.com/api/page/road/addroad");
        Map<String, String> map2 = this.f9298a;
        if (e()) {
            str = "http://cp01-ocean-2436.epc.baidu.com:8100/static/webpage/voice_market_list_v2/";
        } else {
            str = a2 + "webpagenavi.baidu.com/static/webpage/voice_market_list_v2/";
        }
        map2.put("VoiceSquare", str);
        Map<String, String> map3 = this.f9298a;
        if (e()) {
            str2 = "http://cp01-ocean-2436.epc.baidu.com:8100/static/webpage/voice_market_details_v2/";
        } else {
            str2 = a2 + "webpagenavi.baidu.com/static/webpage/voice_market_details_v2/";
        }
        map3.put("VoiceDetail", str2);
        this.f9298a.put("VoiceTopic", "https://webpage.navi.baidu.com/static/webpage/voice_market_topic/clasic/");
        Map<String, String> map4 = this.f9298a;
        if (e()) {
            str3 = "http://cp01-ocean-2436.epc.baidu.com:8100/static/webpage/voice_market_navingvoice/navingvoice/";
        } else {
            str3 = a2 + "webpagenavi.baidu.com/static/webpage/voice_market_navingvoice/navingvoice/";
        }
        map4.put("VoiceSquareNaving", str3);
        this.f9298a.put("NativeCrashUploadProtocal", a2 + "client.map.baidu.com/imap/ulog/open");
        this.f9298a.put("NativeCrashUploadLog", a2 + "client.map.baidu.com/imap/ulog/upc");
        this.f9298a.put("NativeCrashUploadLogNavi", a2 + "navimon.baidu.com/hunter/log/post");
        this.f9298a.put("DataCheckNaviUrl", a2 + "appnavi.baidu.com/statistics/sendCheck");
        this.f9298a.put("StreetScapeReportError", a2 + "client.map.baidu.com/streetscape/report.html");
        this.f9298a.put("NavUserBehaviour", a2 + "client.map.baidu.com/navigation?resid=01");
        this.f9298a.put("naviArriveDestPoint", "http://gzns-map-vector-tmp07.gzns:8432/postnavi");
        this.f9298a.put("InitCloudConfig", a2 + "appnavi.baidu.com/mop/naviinit");
        this.f9298a.put("NavUserConfig", a2 + "appnavi.baidu.com/mop/control");
        this.f9298a.put("ugcRcEventCounts", a2 + "newclient.map.baidu.com/client/ugccenter/static/userReport?from=app");
        Map<String, String> map5 = this.f9298a;
        if (e()) {
            str4 = "http://cp01-ocean-2436.epc.baidu.com:8100/static/webpage/report/index.html";
        } else {
            str4 = a2 + "map.baidu.com/zt/client/contribution/index.html";
        }
        map5.put("ugcRcEventListShow", str4);
        this.f9298a.put("GetWeather", a2 + "appnavi.baidu.com/mop/long/getweather");
        this.f9298a.put("tuanyuan", a2 + "appnavi.baidu.com/mop/tuanyuan/client");
        this.f9298a.put("UgcGetEventDetail", a2 + "appnavi.baidu.com/mop/ugc/geteventdetail");
        this.f9298a.put("UgcEventFeedback", a2 + "appnavi.baidu.com/mop/ugc/eventfeedback");
        this.f9298a.put("getUgcNewCommentList", a2 + "appnavi.baidu.com/mop/ugc/commentlist");
        this.f9298a.put("UGCEventUpload", a2 + "appnavi.baidu.com/mop/navireport/addintelligence");
        this.f9298a.put("rubPointAdsorb", a2 + "appnavi.baidu.com/mop/navireport/coordadsorb");
        this.f9298a.put("SkyEyeUser", a2 + "appnavi.baidu.com/naviServerAdmin/skyeye/user");
        this.f9298a.put("SkyEyePostLog", a2 + "navimon.baidu.com/hunter/log/collectnew");
        this.f9298a.put("NavDestPark", a2 + "oil.baidu.com/poi/parkassistant/getrplistv2");
        this.f9298a.put("UgcSugs", a2 + "appnavi.baidu.com/mop/navireport/sug");
        this.f9298a.put("getVideoInfo", a2 + "appnavi.baidu.com/mop/ugc/getvideoinfo");
        this.f9298a.put("eta", a2 + "client.map.baidu.com/phpui2/");
        this.f9298a.put("TrafficRecord", a2 + "carowner.baidu.com/carservice/api/vehicle/report");
        this.f9298a.put("getNewCommentNum", a2 + "appnavi.baidu.com/mop/ugc/getnewcommentnum");
        this.f9298a.put("ugcInteractionClick", a2 + "appnavi.baidu.com/mop/ugc/updateuserhandlenotice");
        this.f9298a.put("getCarPlateCount", a2 + "carowner.baidu.com/carownerui/api?c=vehicle");
        this.f9298a.put("isNewEnergyCarOwner", a2 + "newclient.map.baidu.com/client/phpui2/?");
        this.f9298a.put("sync_to_travel_assistant", a2 + "client.map.baidu.com/aide/");
        this.f9298a.put("getEventOnlineState", a2 + "appnavi.baidu.com/mop/navireport/geteventonlinestate");
        this.f9298a.put("GetCloudConf", a2 + "appnavi.baidu.com/mop/cloud/getcloudconf");
        this.f9298a.put("CarOwnerDriveScore", a2 + "carowner.baidu.com/carservice/api/userinfo/getDimensionScore");
        this.f9298a.put("upload_on_voice_package_download_complete", a2 + "zt.baidu.com/activity/datasync/navivoice");
        this.f9298a.put("BlockUploadOpen", a2 + "webpagenavi.baidu.com/webpage/blockdetail");
        this.f9298a.put("CommuteHelp", a2 + "map.baidu.com/zt/client/drivePrivacy/");
        this.f9298a.put("iceSquareIndex", a2 + "client.map.baidu.com/opn/pvn/voicesquare/index");
        this.f9298a.put("voiceUserHot", a2 + "client.map.baidu.com/opn/pvn/voice/hot");
        this.f9298a.put("voiceUserRecommend", a2 + "client.map.baidu.com/opn/pvn/voice/rcmdtopics");
        this.f9298a.put("voiceUserBanner", a2 + "client.map.baidu.com/opn/pvn/banner/newugcindex");
        this.f9298a.put("voiceSearchRecommend", a2 + "client.map.baidu.com/opn/pvn/newvoice/searchreco");
        this.f9298a.put("voiceUserList", a2 + "client.map.baidu.com/opn/pvn/voice/categorylists");
        this.f9298a.put("voiceUserInfo", a2 + "client.map.baidu.com/opn/pvn/voice/categoryinfo");
        this.f9298a.put("voicePublish", a2 + "client.map.baidu.com/opn/pvn/voice/publish");
        this.f9298a.put("voicePublishCancel", a2 + "client.map.baidu.com/opn/pvn/voice/publishcancel");
        this.f9298a.put("voiceMeRecordList", a2 + "client.map.baidu.com/opn/pvn/voice/userrecord");
        this.f9298a.put("voiceUserRecord", a2 + "client.map.baidu.com/opn/pvn/voice/recentlyinfo");
        this.f9298a.put("voiceMeRecordDel", a2 + "client.map.baidu.com/opn/pvn/voice/delete");
        this.f9298a.put("voiceOnceInfo", a2 + "client.map.baidu.com/opn/pvn/voice/info");
        this.f9298a.put("voiceUpdate", a2 + "client.map.baidu.com/opn/pvn/voice/update");
        this.f9298a.put("voiceSearchHot", a2 + "client.map.baidu.com/opn/pvn/voice/hotsearch");
        this.f9298a.put("voiceSearchResult", a2 + "client.map.baidu.com/opn/pvn/voice/searchbyname");
        this.f9298a.put("lyrebirdTextInfo", a2 + "client.map.baidu.com/opn/pvn/voice/textinfo");
        this.f9298a.put("lyrebirdSpecTextInfo", a2 + "client.map.baidu.com/opn/pvn/voice/spectextinfo");
        this.f9298a.put("lyrebirdSpecUpdate", a2 + "client.map.baidu.com/opn/pvn/voice/specupdate");
        this.f9298a.put("lyrebirdRecordStatus", a2 + "client.map.baidu.com/opn/pvn/voice/recordstatus");
        this.f9298a.put("lyrebirdCustomCommit", a2 + "client.map.baidu.com/opn/pvn/voice/specsubmit");
        this.f9298a.put("voiceRecommendTopic", a2 + "client.map.baidu.com/opn/pvn/voice/rcmdtopics");
        this.f9298a.put("voiceRecommend", a2 + "client.map.baidu.com/opn/pvn/voice/rcmdtopics");
        this.f9298a.put("voiceRank", a2 + "client.map.baidu.com/opn/pvn/newvoice/voicepacketrank");
        this.f9298a.put("voiceRecommendBanner", a2 + "client.map.baidu.com/opn/pvn/banner/rcmdindex");
        this.f9298a.put("voicePostCard", a2 + "client.map.baidu.com/opn/pvn/newvoice/postcard");
        this.f9298a.put("voiceThemeAll", a2 + "client.map.baidu.com/opn/pvn/voice/rcmdtopics");
        this.f9298a.put("voiceSquareVideo", a2 + "client.map.baidu.com/opn/pvn/newvoice/videobonusscenev2");
        this.f9298a.put("voiceSequareVideoSearch", a2 + "client.map.baidu.com/opn/pvn/newvoice/videoinfo");
        this.f9298a.put("voiceUserRank", a2 + "client.map.baidu.com/opn/pvn/newvoice/voicepacketrank");
        this.f9298a.put("voiceSquareKingKong", a2 + "client.map.baidu.com/opn/pvn/banner/kingkongindex");
        this.f9298a.put("voiceDownloadBanner", a2 + "client.map.baidu.com/opn/pvn/banner/downloadindex");
        this.f9298a.put("voiceClassifyAll", a2 + "client.map.baidu.com/opn/pvn/voice/categoryinfo");
        this.f9298a.put("voiceThemeDetail", a2 + "client.map.baidu.com/opn/pvn/newvoice/newrcmddetail");
        this.f9298a.put("voiceRankDetail", a2 + "client.map.baidu.com/opn/pvn/newvoice/voicepacketrank");
        this.f9298a.put("voiceClassifyDetail", a2 + "client.map.baidu.com/opn/pvn/newvoice/newcategorylists");
        this.f9298a.put("carLogo3DList", a2 + "carowner.baidu.com/carownerui/api/privilege/listicons");
        this.f9298a.put("carLogoCurrent", a2 + "carowner.baidu.com/carownerui/api/privilege/geticon");
        this.f9298a.put("carLogoSet", a2 + "carowner.baidu.com/carownerui/api/privilege/seticon");
        this.f9298a.put("url_car_icon", a2 + "carowner.baidu.com/legal/legal.html#/naviBrand?fr=navi_setting_page&forceenv=base");
        this.f9298a.put("parkingLotMore", a2 + "oil.baidu.com/static/smart-parking/index.html?from=navover");
        this.f9298a.put("parkingLotRecord", a2 + "oil.baidu.com/static/smart-parking/index.html?from=navover#/sel/");
        this.f9298a.put("naviSafeActivity", a2 + "carowner.baidu.com/carownerui/api/cral/iscompensate");
        this.f9298a.put("voiceSearchRecomById", a2 + "client.map.baidu.com/opn/pvn/voice/rcmddetaillist");
        this.f9298a.put("voiceCarNetAuthorize", a2 + "client.map.baidu.com/opn/pvn/authorization/authorize");
        this.f9298a.put("IndoorParkService", a2 + "oil.baidu.com");
        this.f9298a.put("ApproachNodeParkService", a2 + "parking.baidu.com");
        this.f9298a.put("HighwayServicePartition", a2 + "parking.baidu.com/parking/api/navi/getservicepartition");
        this.f9298a.put("NavigationEpilogueParkingInfo", a2 + "parking.baidu.com/parking/api/navigation/epilogue");
        this.f9298a.put("AddParkRecord", a2 + "parking.baidu.com/parking/api/record/adduserparkingrecord");
        this.f9298a.put("IndoorParkReRecommand", a2 + "parking.baidu.com");
        this.f9298a.put("commuteResultH5Page", a2 + "map.baidu.com/zt/webapp/mossPhase/index.html?fr=8888");
        this.f9298a.put("mapOperationCallback", a2 + "zt.baidu.com/activity/datasync/callback");
        this.f9298a.put("HaoQiYe2020Operation", a2 + "newclient.map.baidu.com/client/maptoken/completetask");
        this.f9298a.put("UserGroupConfig", a2 + "appnavi.baidu.com/datacenter/group/groupconf");
        this.f9298a.put("carHomeCarOwner", a2 + "carowner.baidu.com/carservice/api/route/getModule");
        this.f9298a.put("truckOperationActivity", a2 + "zt.baidu.com/activity/datasync/callback");
        this.f9298a.put("truckChallengeMode", a2 + "route.map.baidu.com/?qt=placeapi");
        this.f9298a.put("scenic_booking_tip", a2 + "51trip.baidu.com/ticket/tipv2");
        this.f9298a.put("newEngStation", a2 + "oil.baidu.com/chargemap/recommend/getStationListForNavi");
        this.f9298a.put("roadTrip", a2 + "newclient.map.baidu.com/client/phpui2/?");
        this.f9298a.put("roadTripWeb", a2 + "scenes.map.baidu.com/pages/travel-detail");
        this.f9298a.put("business_quest", a2 + "webpagenavi.baidu.com/static/webpage/askSys/index.html");
        this.f9298a.put("voiceSetVoiceOpt", a2 + "client.map.baidu.com/opn/pvn/voicecloud/setvoiceopt");
        this.f9298a.put("voiceSetVoice", a2 + "client.map.baidu.com/opn/pvn/voicecloud/usersetvoice");
        this.f9298a.put("voiceUserDownloadedList", a2 + "client.map.baidu.com/opn/pvn/voicecloud/userdownloadedlist");
        this.f9298a.put("voiceDownloadOpt", a2 + "client.map.baidu.com/opn/pvn/voicecloud/downloadopt");
        this.f9298a.put("chatList", a2 + "appnavi.baidu.com/mop/ugc/getchatlist");
        this.f9298a.put("HighwayParkLeft", a2 + "parking.baidu.com/parking/api/park/getParkingListByUids");
        this.f9298a.put("RookieEventOp", a2 + "zt.baidu.com/activity/datasync/mapapp");
        this.f9298a.put("trucklimitinf", a2 + "newclient.map.baidu.com/client/phpui2/?");
        this.f9298a.put("carplatformnavi", a2 + "newclient.map.baidu.com/client/phpui2/?");
        this.f9298a.put("SocialGetChatRoomDetail", a2 + "route.map.baidu.com/social_center/chatroom/create");
        this.f9298a.put("questAoi", a2 + "ps.map.baidu.com");
        this.f9298a.put("normalHdExplainUrl", a2 + "opn.baidu.com/map/2022/citylane?fr=navigbutton");
        this.f9298a.put("hdExplainUrl", a2 + "opn.baidu.com/map/2021/1222cdjdh?tpltype=1");
        this.f9298a.put("BNTrackChargeKey", a2 + "newclient.map.baidu.com/client/phpui2/?");
        this.f9298a.put("BNUgcFeeH5", a2 + "map.baidu.com/zt/webapp/truckUGC/end.html#/");
        this.b = new HashMap(this.f9298a);
    }

    public boolean c() {
        return c;
    }

    public void a(String str, String str2) {
        if (this.b != null) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("userMap newest key-address = " + str + HelpFormatter.DEFAULT_OPT_PREFIX + str2);
            }
            this.b.put(str, str2);
            return;
        }
        LogUtil.e("wangyang", "HttpURLManager SoftReference is null");
    }

    public String a() {
        return c ? BNWebViewClient.URL_HTTPS_PREFIX : BNWebViewClient.URL_HTTP_PREFIX;
    }

    public void a(boolean z) {
        c = z;
    }

    public String b(String str) {
        Map<String, String> map = this.b;
        if (map == null) {
            return null;
        }
        String str2 = map.get(str);
        LogUtil.e("wangyang", "getUsedUrl : key=" + str + ";value=" + str2);
        return str2;
    }
}
