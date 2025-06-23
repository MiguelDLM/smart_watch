package com.jieli.jl_filebrowse.util;

import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class DeviceChoseUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f17834a = "DeviceChoseUtil";

    public static List<SDCardBean> getSdOfUsbDev() {
        List<SDCardBean> onlineDev = FileBrowseManager.getInstance().getOnlineDev();
        ArrayList arrayList = new ArrayList();
        for (SDCardBean sDCardBean : onlineDev) {
            if (sDCardBean.getType() == 0 || sDCardBean.getType() == 1) {
                arrayList.add(sDCardBean);
            }
        }
        return arrayList;
    }

    public static SDCardBean getTargetDev() {
        if (FileBrowseManager.getInstance().getOnlineDev().isEmpty()) {
            JL_Log.e(f17834a, "getTargetDev", "no online device");
            return null;
        }
        List<SDCardBean> onlineDev = FileBrowseManager.getInstance().getOnlineDev();
        for (SDCardBean sDCardBean : onlineDev) {
            if (sDCardBean.getType() == 0) {
                return sDCardBean;
            }
        }
        for (SDCardBean sDCardBean2 : onlineDev) {
            if (sDCardBean2.getType() == 1) {
                return sDCardBean2;
            }
        }
        return null;
    }

    public static SDCardBean getTargetDevFlash2First() {
        if (FileBrowseManager.getInstance().getOnlineDev().isEmpty()) {
            JL_Log.e(f17834a, "getTargetDevFlash2First", "no online device");
            return null;
        }
        for (SDCardBean sDCardBean : FileBrowseManager.getInstance().getOnlineDev()) {
            if (sDCardBean.getType() == 4) {
                return sDCardBean;
            }
        }
        return getTargetDev();
    }
}
