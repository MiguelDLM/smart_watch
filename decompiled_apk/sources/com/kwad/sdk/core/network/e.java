package com.kwad.sdk.core.network;

import androidx.media2.session.SessionCommand;
import com.baidu.datahub.HttpClient;

/* loaded from: classes11.dex */
public final class e {
    public static e awF = new e(-1, "请求超时事件");
    public static e awG = new e(-2, HttpClient.HTTP_CLIENT_ERROR);
    public static e awH = new e(-1000, "该业务组件未加载");
    public static e awI = new e(40001, "网络错误");
    public static e awJ = new e(40002, "数据解析错误");
    public static e awK = new e(SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, "数据为空");
    public static e awL = new e(40004, "视频资源缓存失败");
    public static e awM = new e(40005, "网络超时");
    public static e awN = new e(40007, "图片下载失败");
    public static e awO = new e(40008, "广告场景不匹配");
    public static e awP = new e(40009, "广告加载异常");
    public static e awQ = new e(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, "activity场景不匹配");
    public static e awR = new e(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, "sdk初始化失败");
    public static e awS = new e(40012, "权限未开启");
    public static e awT = new e(40013, "SDK未调用start方法");
    public static e awU = new e(100006, "更多视频请前往快手App查看");
    public static e awV = new e(100007, "复制链接失败，请稍后重试");
    public static e awW = new e(100008, "内容有点敏感，不可以发送哦");
    public static e awX = new e(130001, "数据不存在");
    public static e awY = new e(0, "网络超时");
    public final int errorCode;
    public final String msg;

    private e(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
