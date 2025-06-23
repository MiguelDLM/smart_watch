package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.l0;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class y {

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8607a;
        final /* synthetic */ VoiceInterfaceImplProxy b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y yVar, String str, String str2, String str3, VoiceInterfaceImplProxy voiceInterfaceImplProxy) {
            super(str, str2);
            this.f8607a = str3;
            this.b = voiceInterfaceImplProxy;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("voice_page", "showSwitchCloudVoiceGuide()->");
            }
            if (x.b().j(113).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_asr_normal)).f(this.f8607a).y()) {
                this.b.setCloudDefaultTTSSwitchNotificationShow(true);
                return null;
            }
            if (!gVar.d()) {
                return null;
            }
            gVar.e("voice_page", "showSwitchCloudVoiceGuide()->result = false!");
            return null;
        }
    }

    public boolean a() {
        boolean a2 = com.baidu.navisdk.ui.voice.b.a(com.baidu.navisdk.ui.voice.b.a());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGVoiceController", "checkHasNewVoice-> hasNewVoice= " + a2);
        }
        if (a2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.12.1.7", "1", null, null);
            BNCommSettingManager.getInstance().setVoiceBtnNeedNewTag(true);
            BNCommSettingManager.getInstance().setMoreBtnNeedNewTag(true);
        }
        return a2;
    }

    public void b() {
        com.baidu.navisdk.module.voice.a b = com.baidu.navisdk.module.cloudconfig.f.c().b();
        String str = null;
        if (b != null && b.a()) {
            if (!s.T().b(104)) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("voice_page", "showBusinessVoiceRecommend allowOperableNotificationShow return false!");
                    return;
                }
                return;
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("voice_page", "showBusinessVoiceRecommend !BNavigator.getInstance().hasCalcRouteOk() return false!");
                    return;
                }
                return;
            }
            if (BNSettingManager.getHasVoiceRecommendClicked()) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e("voice_page", "showBusinessVoiceRecommend getHasVoiceRecommendClicked return false!");
                    return;
                }
                return;
            }
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            if (fVar != null && fVar.f() != 0) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar4.d()) {
                    gVar4.e("voice_page", "showBusinessVoiceRecommend NE_Navi_Type_China return false!");
                    return;
                }
                return;
            }
            if (BNSettingManager.getVoiceRecommendNotificationShowCnt() >= b.i()) {
                com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar5.d()) {
                    gVar5.e("voice_page", "showBusinessVoiceRecommend mVoiceShowTime return false!");
                    return;
                }
                return;
            }
            ArrayList<String> arrayList = new ArrayList();
            String b2 = b.b();
            if (!l0.c(b2)) {
                String[] split = b2.split(",");
                if (split.length > 0) {
                    arrayList.addAll(Arrays.asList(split));
                }
            }
            if (!arrayList.contains(b.k())) {
                arrayList.add(b.k());
            }
            VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
            for (String str2 : arrayList) {
                if (o != null && o.isTaskDownloadFinish(str2)) {
                    com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar6.d()) {
                        gVar6.e("voice_page", "showBusinessVoiceRecommend" + str2 + "已经下载, return false!");
                        return;
                    }
                    return;
                }
            }
            arrayList.clear();
            String c = b.c();
            if (!l0.c(c)) {
                String[] split2 = c.split(",");
                if (split2.length > 0) {
                    arrayList.addAll(Arrays.asList(split2));
                }
            }
            if (o != null) {
                str = o.getCurrentVoice();
            }
            if (!l0.c(str) && !arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    if (str.equals(str3)) {
                        com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar7.d()) {
                            gVar7.e("voice_page", "showBusinessVoiceRecommend" + str3 + "正在使用, return false!");
                            return;
                        }
                        return;
                    }
                }
            }
            s.T().a(b.d(), b.f(), b.g(), b.j(), b.k(), b.h());
            x.b().a(false);
            return;
        }
        com.baidu.navisdk.util.common.g gVar8 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar8.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("showBusinessVoiceRecommend return false!mVoiceRecommendModel=");
            if (b != null) {
                str = b.toString();
            }
            sb.append(str);
            gVar8.e("voice_page", sb.toString());
        }
    }

    public void c() {
        VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o == null) {
            return;
        }
        String currentVoice = o.getCurrentVoice();
        if (!o.isUsedNormalVoice()) {
            String downloadedVoiceOuterBeanName = o.getDownloadedVoiceOuterBeanName(currentVoice);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("voice_page-BNVoiceManager", "showSwitchCloudVoiceGuide-> taskId= " + currentVoice + ", name= " + downloadedVoiceOuterBeanName);
            }
            if (!l0.c(downloadedVoiceOuterBeanName)) {
                com.baidu.navisdk.util.worker.c.a().a(new a(this, y.class.getSimpleName(), null, downloadedVoiceOuterBeanName + "设置成功", o), new com.baidu.navisdk.util.worker.e(99, 0), 5000L);
            }
        }
    }
}
