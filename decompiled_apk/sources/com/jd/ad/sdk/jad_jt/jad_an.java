package com.jd.ad.sdk.jad_jt;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.jad_xk.jad_kx;
import com.jd.ad.sdk.jad_xk.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes10.dex */
public class jad_an implements Runnable {
    public final /* synthetic */ JADSlot jad_an;
    public final /* synthetic */ JADAdLoadListener jad_bo;
    public final /* synthetic */ String jad_cp;
    public final /* synthetic */ String jad_dq;
    public final /* synthetic */ jad_jt jad_er;

    public jad_an(jad_jt jad_jtVar, JADSlot jADSlot, JADAdLoadListener jADAdLoadListener, String str, String str2) {
        this.jad_er = jad_jtVar;
        this.jad_an = jADSlot;
        this.jad_bo = jADAdLoadListener;
        this.jad_cp = str;
        this.jad_dq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        jad_jt.jad_an(this.jad_er, this.jad_an);
        com.jd.ad.sdk.jad_na.jad_cp jad_cp = com.jd.ad.sdk.jad_pc.jad_an.jad_cp();
        String jad_an = jad_hu.jad_an(jad_cp, this.jad_an.getSlotID());
        Logger.d("loadAd URl: " + jad_an);
        if (TextUtils.isEmpty(jad_an)) {
            jad_jt jad_jtVar = this.jad_er;
            JADAdLoadListener jADAdLoadListener = this.jad_bo;
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_URL_IS_NULL_ERROR;
            jad_jtVar.jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(this.jad_cp, 7, jad_anVar.jad_an, this.jad_er.jad_an(this.jad_an.getSlotID(), this.jad_an.getAdType(), jad_anVar.jad_an(new String[0])), 0);
            return;
        }
        com.jd.ad.sdk.jad_xk.jad_er jad_erVar = new com.jd.ad.sdk.jad_xk.jad_er(jad_hu.jad_bo(this.jad_an));
        com.jd.ad.sdk.jad_xk.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_xk.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_ob.jad_fs.jad_cp());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        this.jad_er.getClass();
        com.jd.ad.sdk.jad_na.jad_an jad_an2 = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        if (jad_an2 == null || !"1".equals(jad_an2.jad_bo)) {
            jad_fsVar.jad_an("sdkxid", "default");
        }
        jad_kx.jad_bo jad_an3 = com.jd.ad.sdk.jad_xk.jad_bo.jad_an();
        jad_an3.jad_er = jad_an;
        jad_an3.jad_fs = jad_erVar;
        jad_an3.jad_bo = jad_fsVar;
        int i3 = 5000;
        if (jad_cp == null) {
            i = 5000;
        } else {
            i = (int) jad_cp.jad_dq;
        }
        jad_an3.jad_cp = i;
        if (jad_cp != null) {
            i3 = (int) jad_cp.jad_dq;
        }
        jad_an3.jad_dq = i3;
        jad_an3.jad_jt = new C0689jad_an();
        jad_jt jad_jtVar2 = this.jad_er;
        JADSlot jADSlot = this.jad_an;
        jad_jtVar2.getClass();
        if (jADSlot != null) {
            long currentTimeMillis = System.currentTimeMillis() - jADSlot.getLoadTime();
            String requestId = jADSlot.getRequestId();
            String slotID = jADSlot.getSlotID();
            int adType = jADSlot.getAdType();
            int sen = jADSlot.getSen();
            int rem = jADSlot.getRem();
            int width = (int) jADSlot.getWidth();
            int height = (int) jADSlot.getHeight();
            if (rem == 2) {
                width = (int) jADSlot.getAdImageWidth();
                height = (int) jADSlot.getAdImageHeight();
            }
            int i4 = width;
            int i5 = height;
            int templateId = jADSlot.getTemplateId();
            int ds = JADMediator.getInstance().getInitService().getDs(jADSlot.getSlotID());
            int r = JADMediator.getInstance().getInitService().getR(jADSlot.getSlotID());
            if (!jADSlot.isFromNativeAd() && adType == 1) {
                i2 = (int) jADSlot.getTolerateTime();
            } else {
                i2 = 0;
            }
            if (jADSlot.getAdDataRequestSourceType() != 1 && jADSlot.getAdDataRequestSourceType() != 2) {
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an(requestId, slotID, 1, adType, sen, i5, i4, templateId, rem, currentTimeMillis, ds, r, 0, i2);
            } else {
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an(requestId, slotID, 1, adType, sen, i5, i4, templateId, rem, currentTimeMillis, ds, r, 1, i2);
            }
        }
        jad_an3.jad_an(com.jd.ad.sdk.jad_cn.jad_bo.jad_an);
    }

    /* renamed from: com.jd.ad.sdk.jad_jt.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0689jad_an implements jad_kx.jad_an {

        /* renamed from: com.jd.ad.sdk.jad_jt.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC0690jad_an implements Runnable {
            public RunnableC0690jad_an() {
            }

            @Override // java.lang.Runnable
            public void run() {
                jad_an jad_anVar = jad_an.this;
                jad_jt.jad_an(jad_anVar.jad_er, jad_anVar.jad_bo, jad_anVar.jad_an.getAdDataRequestSourceType());
            }
        }

        public C0689jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_xk.jad_kx.jad_an
        public void jad_an(jad_ly jad_lyVar) {
            String jad_an;
            String jad_an2;
            String jad_an3;
            com.jd.ad.sdk.jad_wj.jad_dq jad_dqVar;
            String jad_an4;
            String jad_an5;
            String jad_an6;
            String jad_an7;
            String jad_an8;
            try {
                if (jad_lyVar.jad_cp() != 200) {
                    jad_an jad_anVar = jad_an.this;
                    jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, jad_lyVar.jad_cp(), "error code: " + jad_lyVar.jad_cp());
                    String str = "";
                    if (jad_lyVar.jad_bo() != null) {
                        str = jad_lyVar.jad_bo().jad_bo();
                    }
                    Logger.d("【load】loadAd error code:" + jad_lyVar.jad_cp() + ",msg=" + str);
                    String str2 = jad_an.this.jad_cp;
                    int jad_cp = jad_lyVar.jad_cp();
                    jad_an jad_anVar2 = jad_an.this;
                    jad_an8 = jad_anVar2.jad_er.jad_an(jad_anVar2.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), str);
                    com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str2, 3, jad_cp, jad_an8, jad_an.this.jad_an.getSen());
                    return;
                }
                if (jad_lyVar.jad_bo() == null) {
                    Logger.d("loadAd response body is null");
                    jad_an jad_anVar3 = jad_an.this;
                    jad_jt jad_jtVar = jad_anVar3.jad_er;
                    JADAdLoadListener jADAdLoadListener = jad_anVar3.jad_bo;
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar4 = com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_BODY_NULL_ERROR;
                    jad_jtVar.jad_an(jADAdLoadListener, jad_anVar4.jad_an(), jad_anVar4.jad_an(new String[0]));
                    String str3 = jad_an.this.jad_cp;
                    int jad_an9 = jad_anVar4.jad_an();
                    jad_an jad_anVar5 = jad_an.this;
                    jad_an7 = jad_anVar5.jad_er.jad_an(jad_anVar5.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar4.jad_an(new String[0]));
                    com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str3, 3, jad_an9, jad_an7, jad_an.this.jad_an.getSen());
                    return;
                }
                String jad_bo = jad_lyVar.jad_bo().jad_bo();
                Logger.d("loadAd gw response: " + jad_bo);
                if (TextUtils.isEmpty(jad_bo)) {
                    jad_an jad_anVar6 = jad_an.this;
                    jad_jt jad_jtVar2 = jad_anVar6.jad_er;
                    JADAdLoadListener jADAdLoadListener2 = jad_anVar6.jad_bo;
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar7 = com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_BODY_DATA_NULL_ERROR;
                    jad_jtVar2.jad_an(jADAdLoadListener2, jad_anVar7.jad_an(), jad_anVar7.jad_an(new String[0]));
                    String str4 = jad_an.this.jad_cp;
                    int jad_an10 = jad_anVar7.jad_an();
                    jad_an jad_anVar8 = jad_an.this;
                    jad_an6 = jad_anVar8.jad_er.jad_an(jad_anVar8.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar7.jad_an(new String[0]));
                    com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str4, 3, jad_an10, jad_an6, jad_an.this.jad_an.getSen());
                    return;
                }
                String je = ANEProxy.je(jad_bo);
                Logger.d("GW Data: " + je);
                if (TextUtils.isEmpty(je)) {
                    jad_an jad_anVar9 = jad_an.this;
                    jad_jt jad_jtVar3 = jad_anVar9.jad_er;
                    JADAdLoadListener jADAdLoadListener3 = jad_anVar9.jad_bo;
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar10 = com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_DES_ERROR_ERROR;
                    jad_jtVar3.jad_an(jADAdLoadListener3, jad_anVar10.jad_an(), jad_anVar10.jad_an(new String[0]));
                    String str5 = jad_an.this.jad_cp;
                    int jad_an11 = jad_anVar10.jad_an();
                    jad_an jad_anVar11 = jad_an.this;
                    jad_an5 = jad_anVar11.jad_er.jad_an(jad_anVar11.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar10.jad_an(new String[0]));
                    com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str5, 3, jad_an11, jad_an5, jad_an.this.jad_an.getSen());
                    return;
                }
                com.jd.ad.sdk.jad_wj.jad_jt jad_an12 = com.jd.ad.sdk.jad_wj.jad_jt.jad_an(je);
                if (jad_an12.jad_an() != 0) {
                    jad_an jad_anVar12 = jad_an.this;
                    jad_anVar12.jad_er.jad_an(jad_anVar12.jad_bo, jad_an12.jad_an(), jad_an12.jad_bo());
                    String str6 = jad_an.this.jad_cp;
                    int jad_an13 = jad_an12.jad_an();
                    jad_an jad_anVar13 = jad_an.this;
                    jad_an4 = jad_anVar13.jad_er.jad_an(jad_anVar13.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_an12.jad_bo());
                    com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str6, 3, jad_an13, jad_an4, jad_an.this.jad_an.getSen());
                    return;
                }
                Logger.d("【preload】缓存请求 - 成功");
                if (jad_an.this.jad_an.getAdDataRequestSourceType() == 1) {
                    Logger.d("【preload】缓存 - 预加载广告数据");
                    jad_an jad_anVar14 = jad_an.this;
                    jad_jt.jad_an(jad_anVar14.jad_er, jad_anVar14.jad_an, je);
                } else {
                    if (jad_an.this.jad_an.getDynamicRenderTemplateHelper() != null) {
                        jad_an.this.jad_an.getDynamicRenderTemplateHelper().jad_an(je);
                    }
                    if (jad_an12.jad_cp() != null && jad_an12.jad_cp().jad_an() != null && jad_an12.jad_cp().jad_an().size() > 0 && (jad_dqVar = jad_an12.jad_cp().jad_an().get(0)) != null && jad_dqVar.jad_an() != null) {
                        jad_an.this.jad_an.setTemplateId(jad_dqVar.jad_an().jad_dq());
                        jad_an.this.jad_an.setMediaSpecSetType(jad_dqVar.jad_an().jad_cp());
                        jad_an.this.jad_an.setEventInteractionType(jad_dqVar.jad_an().jad_bo());
                        jad_an.this.jad_an.setModelClickAreaType(jad_dqVar.jad_an().jad_an());
                        if (jad_an.this.jad_an.getAdType() == 2 && (jad_an.this.jad_an.getMediaSpecSetType() == 10007 || jad_an.this.jad_an.getMediaSpecSetType() == 10008)) {
                            jad_an.this.jad_an.setAdType(3);
                        }
                    }
                    jad_an jad_anVar15 = jad_an.this;
                    jad_jt.jad_an(jad_anVar15.jad_er, jad_anVar15.jad_dq, je);
                }
                jad_an jad_anVar16 = jad_an.this;
                jad_jt.jad_bo(jad_anVar16.jad_er, jad_anVar16.jad_an);
                HandlerUtils.runOnUiThread(new RunnableC0690jad_an());
            } catch (IOException e) {
                jad_an jad_anVar17 = jad_an.this;
                jad_jt jad_jtVar4 = jad_anVar17.jad_er;
                JADAdLoadListener jADAdLoadListener4 = jad_anVar17.jad_bo;
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar18 = com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_DATA_IO_ERROR;
                jad_jtVar4.jad_an(jADAdLoadListener4, jad_anVar18.jad_an(), jad_anVar18.jad_an(new String[0]));
                String str7 = jad_an.this.jad_cp;
                int jad_an14 = jad_anVar18.jad_an();
                jad_an jad_anVar19 = jad_an.this;
                jad_an3 = jad_anVar19.jad_er.jad_an(jad_anVar19.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar18.jad_an(e.getMessage()));
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str7, 3, jad_an14, jad_an3, jad_an.this.jad_an.getSen());
            } catch (JSONException e2) {
                jad_an jad_anVar20 = jad_an.this;
                jad_jt jad_jtVar5 = jad_anVar20.jad_er;
                JADAdLoadListener jADAdLoadListener5 = jad_anVar20.jad_bo;
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar21 = com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_JSON_PARSER_ERROR;
                jad_jtVar5.jad_an(jADAdLoadListener5, jad_anVar21.jad_an(), jad_anVar21.jad_an(new String[0]));
                String str8 = jad_an.this.jad_cp;
                int jad_an15 = jad_anVar21.jad_an();
                jad_an jad_anVar22 = jad_an.this;
                jad_an2 = jad_anVar22.jad_er.jad_an(jad_anVar22.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar21.jad_an(e2.getMessage()));
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str8, 3, jad_an15, jad_an2, jad_an.this.jad_an.getSen());
            } catch (Exception e3) {
                jad_an jad_anVar23 = jad_an.this;
                jad_jt jad_jtVar6 = jad_anVar23.jad_er;
                JADAdLoadListener jADAdLoadListener6 = jad_anVar23.jad_bo;
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar24 = com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_OTHER_ERROR;
                jad_jtVar6.jad_an(jADAdLoadListener6, jad_anVar24.jad_an(), jad_anVar24.jad_an(new String[0]));
                String str9 = jad_an.this.jad_cp;
                int jad_an16 = jad_anVar24.jad_an();
                jad_an jad_anVar25 = jad_an.this;
                jad_an = jad_anVar25.jad_er.jad_an(jad_anVar25.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), com.jd.ad.sdk.jad_uh.jad_an.GW_RESPONSE_DATA_IO_ERROR.jad_an(e3.getMessage()));
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str9, 3, jad_an16, jad_an, jad_an.this.jad_an.getSen());
            }
        }

        @Override // com.jd.ad.sdk.jad_xk.jad_kx.jad_an
        public void jad_an(int i, String str) {
            jad_an jad_anVar = jad_an.this;
            jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, i, str);
            jad_an jad_anVar2 = jad_an.this;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(jad_anVar2.jad_cp, 3, i, jad_anVar2.jad_er.jad_an(jad_anVar2.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), str), jad_an.this.jad_an.getSen());
        }
    }
}
