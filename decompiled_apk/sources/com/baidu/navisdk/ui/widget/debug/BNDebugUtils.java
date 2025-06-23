package com.baidu.navisdk.ui.widget.debug;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNUserKeyLogDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.drivertool.b;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;

/* loaded from: classes8.dex */
public class BNDebugUtils {
    public static final String SEARCH_FACTORY_MODE_SECRET = "智能语音导航";
    private static final String SEARCH_FACTORY_MODE_TTS = "最好用的tts";
    private static final String SEARCH_FACTORY_MODE_USER_KEY_LOG = "最好用的百度地图";
    private static final String TAG = "BNDebugUtils";

    @SuppressLint({"NewApi"})
    public static boolean checkFactoryMode(String str) {
        LogUtil.e(TAG, "checkFactoryMode key = " + str);
        if (str != null && SEARCH_FACTORY_MODE_SECRET.equals(str.trim())) {
            ((ClipboardManager) a.c().a().getSystemService("clipboard")).setText("CUID:" + a0.e());
            TipTool.onCreateToastDialog(a.c().a(), "CUID已经复制到粘贴板，进入导航设置中查看工程模式！");
            final String isRouteGuideCloud = JNIGuidanceControl.getInstance().isRouteGuideCloud();
            String str2 = null;
            if (!l0.c(isRouteGuideCloud)) {
                c.a().a(new f<String, String>("CheckFactoryMode-BNDebugUtils", str2) { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugUtils.1
                    @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                    public String execute() {
                        TipTool.onCreateToastDialog(a.c().a(), isRouteGuideCloud);
                        return null;
                    }
                }, new e(99, 0), 3000L);
            }
            c.a().a((f) new f<String, String>("CheckFactoryMode2-BNDebugUtils", str2) { // from class: com.baidu.navisdk.ui.widget.debug.BNDebugUtils.2
                @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                public String execute() {
                    BNDebugModelDialog bNDebugModelDialog = new BNDebugModelDialog(a.c().b());
                    b.n().a(bNDebugModelDialog);
                    bNDebugModelDialog.show();
                    return null;
                }
            }, new e(99, 0));
            return true;
        }
        if (str != null && SEARCH_FACTORY_MODE_TTS.equals(str.trim())) {
            com.baidu.navisdk.util.testtts.a.d().a();
            com.baidu.navisdk.util.testtts.a.d().b();
            TipTool.onCreateToastDialog(a.c().a(), "开始进入TTS测试模式");
            return true;
        }
        if (str != null && SEARCH_FACTORY_MODE_USER_KEY_LOG.equals(str.trim())) {
            if (a.c().b() != null) {
                new BNUserKeyLogDialog(a.c().b()).show();
            }
            return true;
        }
        if (str == null || !"琴鸟顶呱呱".equals(str.trim())) {
            return false;
        }
        f.z.j = true;
        JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("ecvoicenew", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voicesquare/newvoice?");
        JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("ecvoiceupdate", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voicesquare/updatedvoice");
        JNIGuidanceControl.getInstance().loadUrlAddrConfigParams("specvoicedownload", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/download");
        com.baidu.navisdk.util.http.b.d().a("iceSquareIndex", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voicesquare/index");
        com.baidu.navisdk.util.http.b.d().a("voiceUserHot", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/hot");
        com.baidu.navisdk.util.http.b.d().a("voiceUserRecommend", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voice/rcmdtopics");
        com.baidu.navisdk.util.http.b.d().a("voiceUserBanner", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/banner/newugcindex");
        com.baidu.navisdk.util.http.b.d().a("voiceSearchRecommend", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/newvoice/searchreco");
        com.baidu.navisdk.util.http.b.d().a("voiceUserList", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voice/categorylists");
        com.baidu.navisdk.util.http.b.d().a("voiceUserInfo", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/categoryinfo");
        com.baidu.navisdk.util.http.b.d().a("voicePublish", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/publish");
        com.baidu.navisdk.util.http.b.d().a("voicePublishCancel", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/publishcancel");
        com.baidu.navisdk.util.http.b.d().a("voiceMeRecordList", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/userrecord");
        com.baidu.navisdk.util.http.b.d().a("voiceUserRecord", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/recentlyinfo");
        com.baidu.navisdk.util.http.b.d().a("voiceMeRecordDel", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/delete");
        com.baidu.navisdk.util.http.b.d().a("voiceOnceInfo", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/info");
        com.baidu.navisdk.util.http.b.d().a("voiceUpdate", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/update");
        com.baidu.navisdk.util.http.b.d().a("lyrebirdTextInfo", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voice/textinfo");
        com.baidu.navisdk.util.http.b.d().a("lyrebirdSpecTextInfo", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/spectextinfo");
        com.baidu.navisdk.util.http.b.d().a("lyrebirdSpecUpdate", "http://cp01-ocean-2436.epc.baidu.com:8080/pvn/voice/specupdate");
        com.baidu.navisdk.util.http.b.d().a("lyrebirdRecordStatus", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/recordstatus");
        com.baidu.navisdk.util.http.b.d().a("voiceSearchHot", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/pvn/voice/hotsearch");
        com.baidu.navisdk.util.http.b.d().a("voiceSearchResult", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voice/SearchByName");
        com.baidu.navisdk.util.http.b.d().a("voiceSearchRecomById", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/rcmddetaillist");
        com.baidu.navisdk.util.http.b.d().a("voiceCarNetAuthorize", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/authorization/authorize");
        com.baidu.navisdk.util.http.b.d().a("lyrebirdCustomCommit", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/specsubmit");
        com.baidu.navisdk.util.http.b.d().a("voiceRecommendTopic", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/rcmdtopics");
        com.baidu.navisdk.util.http.b.d().a("voiceSquareVideo", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/newvoice/videobonusscenev2");
        com.baidu.navisdk.util.http.b.d().a("voiceSequareVideoSearch", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/newvoice/videoinfo");
        com.baidu.navisdk.util.http.b.d().a("voiceDownloadBanner", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/banner/downloadindex");
        com.baidu.navisdk.util.http.b.d().a("voiceRecommend", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voice/rcmdtopics");
        com.baidu.navisdk.util.http.b.d().a("voiceRecommendBanner", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/banner/rcmdindex");
        com.baidu.navisdk.util.http.b.d().a("voiceThemeAll", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voice/rcmdtopics");
        com.baidu.navisdk.util.http.b.d().a("voiceClassifyAll", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voice/categoryinfo");
        com.baidu.navisdk.util.http.b.d().a("voiceThemeDetail", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/newvoice/newrcmddetail");
        com.baidu.navisdk.util.http.b.d().a("voiceClassifyDetail", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/newvoice/newcategorylists");
        com.baidu.navisdk.util.http.b.d().a("voiceSquareKingKong", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/banner/kingkongindex");
        com.baidu.navisdk.util.http.b.d().a("voiceSetVoiceOpt", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voicecloud/setvoiceopt");
        com.baidu.navisdk.util.http.b.d().a("voiceSetVoice", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voicecloud/usersetvoice");
        com.baidu.navisdk.util.http.b.d().a("voiceUserDownloadedList", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/opn/pvn/voicecloud/userdownloadedlist");
        com.baidu.navisdk.util.http.b.d().a("voiceDownloadOpt", "http://lbs-navi-server-sz-sandbox00.bcc-bdbl.baidu.com:8187/pvn/voicecloud/downloadopt");
        return true;
    }
}
