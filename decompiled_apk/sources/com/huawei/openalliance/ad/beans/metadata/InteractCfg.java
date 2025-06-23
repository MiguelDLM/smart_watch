package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.ay;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class InteractCfg implements Serializable {
    private static final int DEFAULT_TWIST_ACC = 15;
    private static final int MIN_TWIST_ACC = 10;
    private static final long serialVersionUID = 9151867350505964337L;
    private Integer splashAdTagClickableType;
    private Integer splashInteractCfg;
    private String splashRedirectTxt;
    private String swipeClkTxt;
    private Integer swipeDirection;
    private Integer swipeDp;
    private String swipeTxt;
    private Integer twistAcc;
    private String twistClkTxt;
    private Integer twistDegree;
    private String twistTxt;

    public Integer B() {
        return this.splashAdTagClickableType;
    }

    public Integer C() {
        Integer num = this.swipeDirection;
        if (num == null || !(num.intValue() == 0 || this.swipeDirection.intValue() == 1)) {
            return 0;
        }
        return this.swipeDirection;
    }

    public Integer Code() {
        Integer num = this.splashInteractCfg;
        if (num == null || (num.intValue() >= 0 && this.splashInteractCfg.intValue() <= 4)) {
            return this.splashInteractCfg;
        }
        return 0;
    }

    public String D() {
        return ay.V(this.swipeClkTxt);
    }

    public String F() {
        return ay.V(this.twistTxt);
    }

    public Integer I() {
        Integer num = this.twistAcc;
        if (num == null) {
            return 15;
        }
        if (10 > num.intValue()) {
            return 10;
        }
        return this.twistAcc;
    }

    public String L() {
        return ay.V(this.twistClkTxt);
    }

    public String S() {
        return ay.V(this.swipeTxt);
    }

    public Integer V() {
        return this.swipeDp;
    }

    public Integer Z() {
        return this.twistDegree;
    }

    public String a() {
        return ay.V(this.splashRedirectTxt);
    }

    public void Code(Integer num) {
        this.splashInteractCfg = num;
    }

    public void V(Integer num) {
        this.splashAdTagClickableType = num;
    }
}
