package com.baidu.ar;

import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class ja {
    public static Map<String, String> gd() {
        HashMap hashMap = new HashMap();
        hashMap.put(StatisticConstants.EVENT_SDK_START, "调用SDK");
        hashMap.put(StatisticConstants.EVENT_SDK_END, "结束调用SDK");
        hashMap.put(StatisticConstants.FIRST_LOAD_START_QUERY, "发起查包请求");
        hashMap.put(StatisticConstants.FIRST_LOAD_QUERY_SUCCESS, "查包成功");
        hashMap.put(StatisticConstants.LOAD_START_DOWNLOAD, "开始下载资源包");
        hashMap.put(StatisticConstants.LOAD_DOWNLOAD_SUCCESS, "资源包下载成功");
        hashMap.put(StatisticConstants.LOAD_START_QUERY, "分布加载");
        hashMap.put(StatisticConstants.FIRST_LOAD_FILE_MANAGE_SUCCESS, "完成解压");
        hashMap.put(StatisticConstants.EVENT_CASE_FIRST, "首次使用项目");
        hashMap.put(StatisticConstants.EVENT_CASE_START, "使用项目");
        hashMap.put(StatisticConstants.EVENT_CASE_END, "结束项目");
        hashMap.put(StatisticConstants.CLOUD_SEARCH_SUCCESS, "云识图触发");
        hashMap.put(StatisticConstants.DEVICE_SEARCH_SUCCESS, "端识图触发");
        hashMap.put(StatisticConstants.IMU_SET_SUCCESS, "IMU放置");
        hashMap.put(StatisticConstants.TRACKED, "2D跟踪");
        hashMap.put(StatisticConstants.SLAM_TRACK_ON, "SLAM放置");
        hashMap.put(StatisticConstants.EVENT_LBSNPC_ACTIVITY, "步导NPC动作触发");
        hashMap.put(StatisticConstants.EVENT_FACE_MASKS_ON, "人脸贴纸");
        hashMap.put(StatisticConstants.EVENT_FACE_MASKS_OFF, "人脸贴纸跟丢");
        hashMap.put(StatisticConstants.EVENT_FACE_EXPRESSION, "表情触发");
        hashMap.put(StatisticConstants.MODEL_CAMERA_SWITCH, "前后摄像头切换");
        hashMap.put(StatisticConstants.RECOMMEND_ENTRANCE_CLICK, "切换case入口点击");
        hashMap.put(StatisticConstants.RECOMMEND_CASE_CLICK, "case切换");
        hashMap.put(StatisticConstants.MODEL_PHONE_SHAKE, "摇一摇");
        hashMap.put(StatisticConstants.SPEECH_TYPE_RESULT, "语音");
        hashMap.put(StatisticConstants.ONCLICK_CAPTURE_SCREEN, "拍照");
        hashMap.put(StatisticConstants.ONCLICK_CAPTURE_SCREEN_SAVE, "拍照保存");
        hashMap.put(StatisticConstants.ONCLICK_CAPTURE_SCREEN_SHARE, "拍照分享");
        hashMap.put(StatisticConstants.ONCLICK_CAPTURE_VIDEO, "开始录制");
        hashMap.put(StatisticConstants.ONCLICK_CAPTURE_VIDEO_SAVE, "录制保存");
        hashMap.put(StatisticConstants.ONCLICK_CAPTURE_VIDEO_SHARE, "录制分享");
        hashMap.put(StatisticConstants.SCREENSHOT, "截屏");
        hashMap.put(StatisticConstants.SYSTEM_REQUEST_CAMERA_PERMISSION, "相机权限-弹窗");
        hashMap.put(StatisticConstants.SYSTEM_CAMERA_PERMISSION_GRANTED, "相机权限-确认");
        hashMap.put(StatisticConstants.SYSTEM_CAMERA_PERMISSION_DENY, "相机权限-取消");
        hashMap.put(StatisticConstants.MIC_PERMISSION_SHOW, "麦克风权限-弹窗");
        hashMap.put(StatisticConstants.MIC_PERMISSION_YES, "麦克风权限-确认");
        hashMap.put(StatisticConstants.MIC_PERMISSION_NO, "麦克风权限-取消");
        return hashMap;
    }
}
