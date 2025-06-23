package com.alimm.tanx.core.ut.core;

import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.bean.UtItemBean;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class UserReportManager implements IUserReport {
    private static volatile UserReportManager instance;
    public String TAG = "UserReportManager";

    public static UserReportManager getInstance() {
        if (instance == null) {
            synchronized (UserReportManager.class) {
                try {
                    if (instance == null) {
                        instance = new UserReportManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void run() {
        QueueManager.getInstance().run();
    }

    public void destroy() {
        QueueManager.getInstance().destroy();
        UtRequest.getInstance().destroy();
    }

    public void init() {
        run();
        LifeCycleManager.getInstance().register(this.TAG, new LifeCycleManager.AppVisibleCallBack() {
            public void appVisibleCallBack(boolean z, boolean z2) {
                String str;
                String str2 = UserReportManager.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("当前前后台状态：->");
                if (z) {
                    str = "后台";
                } else {
                    str = "前台";
                }
                sb.append(str);
                sb.append(",是否由后台切换到前台：");
                sb.append(z2);
                LogUtils.d(str2, sb.toString());
                if (z) {
                    UserReportManager.this.destroy();
                }
                if (z2) {
                    UserReportManager.this.run();
                }
            }
        });
    }

    public void send(UtItemBean utItemBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(utItemBean);
        send((List<UtItemBean>) arrayList);
    }

    public void send(List<UtItemBean> list) {
        QueueManager.getInstance().addRealTimeQueue(new UtBean(list));
    }
}
