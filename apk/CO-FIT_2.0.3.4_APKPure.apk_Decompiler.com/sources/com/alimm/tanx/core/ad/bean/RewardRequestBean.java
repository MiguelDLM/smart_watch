package com.alimm.tanx.core.ad.bean;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class RewardRequestBean extends RequestBaseBean {
    public Type ad_context;
    public List<PidVerifications> task_check;
    public Integer trigger_event;
    public RewardUserBean user;

    public static class PidVerifications extends BaseBean {
        public int check;
        public String pid;

        public PidVerifications(String str, int i) {
            this.pid = str;
            this.check = i;
        }
    }

    public static class RewardUserBean extends BaseBean {
        public String media_uid;
    }

    public static class Type extends BaseBean {
        public String session_id;
    }

    private RewardRequestBean build(String str, List<PidVerifications> list) {
        RewardUserBean rewardUserBean = new RewardUserBean();
        this.user = rewardUserBean;
        rewardUserBean.media_uid = str;
        this.task_check = list;
        return this;
    }

    public RewardRequestBean buildSessionId(Integer num, String str) {
        this.trigger_event = num;
        if (this.ad_context == null) {
            this.ad_context = new Type();
        }
        this.ad_context.session_id = str;
        return this;
    }

    public RewardRequestBean build(String str, String str2, RewardParam rewardParam) {
        if (rewardParam == null) {
            rewardParam = new RewardParam();
        }
        PidVerifications pidVerifications = new PidVerifications(str2, rewardParam.isRewardVerification() ? 1 : 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(pidVerifications);
        return build(str, arrayList);
    }

    public RewardRequestBean build(String str, List<String> list, RewardParam rewardParam) {
        if (rewardParam == null) {
            rewardParam = new RewardParam();
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.isEmpty(list.get(i))) {
                    arrayList.add(new PidVerifications(list.get(i), rewardParam.isRewardVerification() ? 1 : 0));
                }
            }
        }
        return build(str, arrayList);
    }
}
