package com.alimm.tanx.core.ad.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.utils.LogUtils;

public class TemplateConfig extends BaseBean {
    @JSONField(name = "action_text")
    private String actionText;
    @JSONField(name = "all_slide_distance")
    private String allSlideDistance;
    @JSONField(name = "back_pop")
    private String backPop;
    @JSONField(name = "count_down")
    private String countDown;
    private MediaRenderingMode day;
    @JSONField(name = "interact_img")
    private String interactImg;
    private MediaRenderingMode night;
    @JSONField(name = "pid_style_id")
    private String pidStyleId;
    @JSONField(name = "render_url")
    private String renderUrl;
    @JSONField(name = "reward_mode")
    private int rewardMode;
    @JSONField(name = "shake_count")
    private String shakeCount;
    @JSONField(name = "shake_sensor_check_interval")
    private String shakeSensorCheckInterval;
    @JSONField(name = "shake_sensor_shake_interval")
    private String shakeSensorShakeInterval;
    @JSONField(name = "shake_splash")
    private String shakeSplash;
    @JSONField(name = "slide_distance")
    private String slideDistance;
    @JSONField(name = "slide_type")
    private String slideType;
    @JSONField(name = "sliding_direction")
    private int slidingDirection;
    @JSONField(name = "web_end_time")
    private String webEndTime;
    @JSONField(name = "web_height")
    private String webHeight;
    @JSONField(name = "web_start_time")
    private String webStartTime;
    @JSONField(name = "web_type")
    private String webType;
    @JSONField(name = "web_url")
    private String webUrl;
    @JSONField(name = "web_width")
    private String webWidth;

    public class DefaultConfig extends BaseBean {
        public static final String adColor = "#ffffff";
        public static final String adSize = "5";
        public static final String advColor = "#ffffff";
        public static final String advSize = "5";
        public static final String bAdColor = "#999999";
        public static final String bAdSize = "5";
        public static final String bAdvColor = "#999999";
        public static final String bAdvSize = "5";
        public static final String bBgColor = "#ffffff";
        public static final String bPicRadius = "4";
        public static final String bTitleColor = "#333333";
        public static final String bTitleSize = "8";
        public static final String bgColor = "#333333";
        public static final String picRadius = "4";
        public static final String titleColor = "#ffffff";
        public static final String titleSize = "8";

        public DefaultConfig() {
        }
    }

    private void setDefaultDaytimeMode() {
        this.day = new MediaRenderingMode("8", "#333333", "5", "#999999", "5", "#999999", "#ffffff", "4");
    }

    private void setDefaultNightMode() {
        this.night = new MediaRenderingMode("8", "#ffffff", "5", "#ffffff", "5", "#ffffff", "#333333", "4");
    }

    public String getActionText() {
        return this.actionText;
    }

    public String getAllSlideDistance() {
        return this.allSlideDistance;
    }

    public int getAllSlideDistance2Int() {
        try {
            return Integer.parseInt(this.allSlideDistance);
        } catch (Exception e) {
            LogUtils.d(LogUtils.getStackTraceMessage(e), new String[0]);
            return 120;
        }
    }

    public String getBackPop() {
        return this.backPop;
    }

    public String getCountDown() {
        return this.countDown;
    }

    public int getCountDown2Int() {
        if (TextUtils.isEmpty(this.countDown)) {
            return 0;
        }
        try {
            return Integer.parseInt(this.countDown);
        } catch (Exception e) {
            LogUtils.e("countDown转Int error", e);
            return 0;
        }
    }

    public MediaRenderingMode getDay() {
        return this.day;
    }

    public String getInteractImg() {
        return this.interactImg;
    }

    public MediaRenderingMode getNight() {
        return this.night;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[SYNTHETIC, Splitter:B:17:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b2 A[Catch:{ Exception -> 0x0016 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alimm.tanx.core.ad.bean.MediaRenderingMode getNowConfig(boolean r4, boolean r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "getNowConfig start"
            java.lang.String r1 = "TemplateConfig"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r0)
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r0 = r3.day     // Catch:{ Exception -> 0x0016 }
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getTitleColor()     // Catch:{ Exception -> 0x0016 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0016 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0019
        L_0x0016:
            r4 = move-exception
            goto L_0x0129
        L_0x0019:
            java.lang.String r0 = "getNowConfig setDefaultDaytimeMode"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0016 }
            r3.setDefaultDaytimeMode()     // Catch:{ Exception -> 0x0016 }
        L_0x0021:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r0 = r3.night     // Catch:{ Exception -> 0x0016 }
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r0.getTitleColor()     // Catch:{ Exception -> 0x0016 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0016 }
            if (r0 == 0) goto L_0x0037
        L_0x002f:
            java.lang.String r0 = "getNowConfig setDefaultNightMode"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0016 }
            r3.setDefaultNightMode()     // Catch:{ Exception -> 0x0016 }
        L_0x0037:
            java.lang.String r0 = ""
            if (r4 == 0) goto L_0x00b2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
            r4.<init>()     // Catch:{ Exception -> 0x0016 }
            java.lang.String r2 = "isNightMode true customTitleSizeSwitch:"
            r4.append(r2)     // Catch:{ Exception -> 0x0016 }
            r4.append(r5)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r2 = ",night:"
            r4.append(r2)     // Catch:{ Exception -> 0x0016 }
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r2 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0016 }
            r4.append(r2)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0016 }
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0016 }
            if (r5 == 0) goto L_0x0089
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = r4.getServerTitleSize()     // Catch:{ Exception -> 0x0016 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0016 }
            if (r4 == 0) goto L_0x0074
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r4.getTitleSize()     // Catch:{ Exception -> 0x0016 }
            r4.setServerTitleSize(r5)     // Catch:{ Exception -> 0x0016 }
        L_0x0074:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
            r5.<init>()     // Catch:{ Exception -> 0x0016 }
            r5.append(r6)     // Catch:{ Exception -> 0x0016 }
            r5.append(r0)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0016 }
            r4.setTitleSize(r5)     // Catch:{ Exception -> 0x0016 }
            goto L_0x00af
        L_0x0089:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = r4.getServerTitleSize()     // Catch:{ Exception -> 0x0016 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0016 }
            if (r4 != 0) goto L_0x00af
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
            r5.<init>()     // Catch:{ Exception -> 0x0016 }
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r6 = r3.night     // Catch:{ Exception -> 0x0016 }
            java.lang.String r6 = r6.getServerTitleSize()     // Catch:{ Exception -> 0x0016 }
            r5.append(r6)     // Catch:{ Exception -> 0x0016 }
            r5.append(r0)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0016 }
            r4.setTitleSize(r5)     // Catch:{ Exception -> 0x0016 }
        L_0x00af:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.night     // Catch:{ Exception -> 0x0016 }
            return r4
        L_0x00b2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
            r4.<init>()     // Catch:{ Exception -> 0x0016 }
            java.lang.String r2 = "isNightMode false customTitleSizeSwitch:"
            r4.append(r2)     // Catch:{ Exception -> 0x0016 }
            r4.append(r5)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r2 = ",day:"
            r4.append(r2)     // Catch:{ Exception -> 0x0016 }
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r2 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0016 }
            r4.append(r2)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0016 }
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0016 }
            if (r5 == 0) goto L_0x0100
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = r4.getServerTitleSize()     // Catch:{ Exception -> 0x0016 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0016 }
            if (r4 == 0) goto L_0x00eb
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r4.getTitleSize()     // Catch:{ Exception -> 0x0016 }
            r4.setServerTitleSize(r5)     // Catch:{ Exception -> 0x0016 }
        L_0x00eb:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
            r5.<init>()     // Catch:{ Exception -> 0x0016 }
            r5.append(r6)     // Catch:{ Exception -> 0x0016 }
            r5.append(r0)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0016 }
            r4.setTitleSize(r5)     // Catch:{ Exception -> 0x0016 }
            goto L_0x0126
        L_0x0100:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.String r4 = r4.getServerTitleSize()     // Catch:{ Exception -> 0x0016 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0016 }
            if (r4 != 0) goto L_0x0126
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0016 }
            r5.<init>()     // Catch:{ Exception -> 0x0016 }
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r6 = r3.day     // Catch:{ Exception -> 0x0016 }
            java.lang.String r6 = r6.getServerTitleSize()     // Catch:{ Exception -> 0x0016 }
            r5.append(r6)     // Catch:{ Exception -> 0x0016 }
            r5.append(r0)     // Catch:{ Exception -> 0x0016 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0016 }
            r4.setTitleSize(r5)     // Catch:{ Exception -> 0x0016 }
        L_0x0126:
            com.alimm.tanx.core.ad.bean.MediaRenderingMode r4 = r3.day     // Catch:{ Exception -> 0x0016 }
            return r4
        L_0x0129:
            java.lang.String r5 = "TemplateConfig getNowConfig Exception"
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r5, (java.lang.Exception) r4)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.bean.TemplateConfig.getNowConfig(boolean, boolean, int):com.alimm.tanx.core.ad.bean.MediaRenderingMode");
    }

    public String getPidStyleId() {
        return this.pidStyleId;
    }

    public String getRenderUrl() {
        return this.renderUrl;
    }

    public int getRewardMode() {
        return this.rewardMode;
    }

    public String getShakeCount() {
        return this.shakeCount;
    }

    public String getShakeSensorCheckInterval() {
        return this.shakeSensorCheckInterval;
    }

    public String getShakeSensorShakeInterval() {
        return this.shakeSensorShakeInterval;
    }

    public String getShakeSplash() {
        return this.shakeSplash;
    }

    public int getShakeSplash2Int() {
        try {
            return Integer.parseInt(this.shakeSplash);
        } catch (Exception e) {
            LogUtils.d(LogUtils.getStackTraceMessage(e), new String[0]);
            return 15;
        }
    }

    public String getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideDistance2Int() {
        try {
            return Integer.parseInt(this.slideDistance);
        } catch (Exception e) {
            LogUtils.d(LogUtils.getStackTraceMessage(e), new String[0]);
            return 55;
        }
    }

    public String getSlideType() {
        return this.slideType;
    }

    public int getSlideType2Int() {
        try {
            return Integer.parseInt(this.slideType);
        } catch (Exception e) {
            LogUtils.d(LogUtils.getStackTraceMessage(e), new String[0]);
            return 1;
        }
    }

    public int getSlidingDirection() {
        return this.slidingDirection;
    }

    public String getWebEndTime() {
        return this.webEndTime;
    }

    public Long getWebEndTime2Long() {
        try {
            return Long.valueOf(Long.parseLong(this.webEndTime));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getWebHeight() {
        return this.webHeight;
    }

    public int getWebHeight2Int() {
        int i;
        try {
            i = Integer.parseInt(this.webHeight);
        } catch (Exception unused) {
            i = 9;
        }
        if (i <= 0) {
            return 9;
        }
        return i;
    }

    public String getWebStartTime() {
        return this.webStartTime;
    }

    public Long getWebStartTime2Long() {
        try {
            return Long.valueOf(Long.parseLong(this.webStartTime));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getWebType() {
        return this.webType;
    }

    public int getWebType2Int() {
        try {
            return Integer.parseInt(this.webType);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public String getWebWidth() {
        return this.webWidth;
    }

    public int getWebWidth2Int() {
        int i;
        try {
            i = Integer.parseInt(this.webWidth);
        } catch (Exception unused) {
            i = 16;
        }
        if (i <= 0) {
            return 16;
        }
        return i;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setAllSlideDistance(String str) {
        this.allSlideDistance = str;
    }

    public void setBackPop(String str) {
        this.backPop = str;
    }

    public void setCountDown(String str) {
        this.countDown = str;
    }

    public void setDay(MediaRenderingMode mediaRenderingMode) {
        this.day = mediaRenderingMode;
    }

    public void setInteractImg(String str) {
        this.interactImg = str;
    }

    public void setNight(MediaRenderingMode mediaRenderingMode) {
        this.night = mediaRenderingMode;
    }

    public void setPidStyleId(String str) {
        this.pidStyleId = str;
    }

    public void setRenderUrl(String str) {
        this.renderUrl = str;
    }

    public void setRewardMode(int i) {
        this.rewardMode = i;
    }

    public void setShakeCount(String str) {
        this.shakeCount = str;
    }

    public void setShakeSensorCheckInterval(String str) {
        this.shakeSensorCheckInterval = str;
    }

    public void setShakeSensorShakeInterval(String str) {
        this.shakeSensorShakeInterval = str;
    }

    public void setShakeSplash(String str) {
        this.shakeSplash = str;
    }

    public void setSlideDistance(String str) {
        this.slideDistance = str;
    }

    public void setSlideType(String str) {
        this.slideType = str;
    }

    public void setSlidingDirection(int i) {
        this.slidingDirection = i;
    }

    public void setWebEndTime(String str) {
        this.webEndTime = str;
    }

    public void setWebHeight(String str) {
        this.webHeight = str;
    }

    public void setWebStartTime(String str) {
        this.webStartTime = str;
    }

    public void setWebType(String str) {
        this.webType = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setWebWidth(String str) {
        this.webWidth = str;
    }
}
