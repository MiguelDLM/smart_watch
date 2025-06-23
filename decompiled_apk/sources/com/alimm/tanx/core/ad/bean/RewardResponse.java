package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* loaded from: classes.dex */
public class RewardResponse extends BaseBean {

    @JSONField(name = "tasks")
    private List<PidRewards> pidRewards;

    @JSONField(name = "id")
    private String requestId;

    @JSONField(name = "status")
    private int status;

    /* loaded from: classes.dex */
    public class PidRewards extends BaseBean {

        @JSONField(name = "complete_time")
        private String completeTime;
        private String pid;

        @JSONField(name = "reward_count")
        private int rewardCount;

        @JSONField(name = MediationConstant.REWARD_NAME)
        private String rewardName;

        @JSONField(name = "session_id")
        private String sessionId;

        @JSONField(name = "task_type")
        private int taskType;

        public PidRewards() {
        }

        public String getCompleteTime() {
            return this.completeTime;
        }

        public String getPid() {
            return this.pid;
        }

        public int getRewardCount() {
            return this.rewardCount;
        }

        public String getRewardName() {
            return this.rewardName;
        }

        public String getSessionId() {
            return this.sessionId;
        }

        public int getTaskType() {
            return this.taskType;
        }

        public void setCompleteTime(String str) {
            this.completeTime = str;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setRewardCount(int i) {
            this.rewardCount = i;
        }

        public void setRewardName(String str) {
            this.rewardName = str;
        }

        public void setSessionId(String str) {
            this.sessionId = str;
        }

        public void setTaskType(int i) {
            this.taskType = i;
        }
    }

    public List<PidRewards> getPidRewards() {
        return this.pidRewards;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setPidRewards(List<PidRewards> list) {
        this.pidRewards = list;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
