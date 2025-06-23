package com.goodix.ble.libcomx.ptmodel;

import OoOoXO0.xoXoI;
import com.goodix.ble.libcomx.task.ITask;
import com.goodix.ble.libcomx.task.TaskQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class PtCase<CTX> extends TaskQueue {
    private ArrayList<PtStep> stepList = new ArrayList<>(8);
    public final CTX targetCtx;

    public PtCase(CTX ctx) {
        this.targetCtx = ctx;
    }

    public final <T extends ITask> T addExtraAction(T t) {
        addTask(t);
        return t;
    }

    public final PtStep createStep(String str, PtCriterion ptCriterion) {
        PtJudge ptJudge = new PtJudge(ptCriterion);
        PtStep ptStep = new PtStep(ptJudge);
        this.stepList.add(ptStep);
        addTask(ptStep);
        if (str == null) {
            if (ptJudge.name == null) {
                ptJudge.name = getName() + xoXoI.f2670oxoX + this.stepList.size();
            }
        } else {
            ptJudge.name = str;
        }
        ptStep.setName(ptJudge.name);
        return ptStep;
    }

    public void getResults(List<PtJudge> list) {
        if (list == null) {
            return;
        }
        Iterator<PtStep> it = this.stepList.iterator();
        while (it.hasNext()) {
            PtStep next = it.next();
            PtJudge judge = next.getJudge();
            if (judge.name == null) {
                judge.name = next.getName();
            }
            list.add(judge);
        }
    }

    public final PtStep getStep(int i) {
        return this.stepList.get(i);
    }

    public final int getStepCount() {
        return this.stepList.size();
    }

    public final boolean isPass() {
        Iterator<PtStep> it = this.stepList.iterator();
        while (it.hasNext()) {
            if (!it.next().getJudge().isPass()) {
                return false;
            }
        }
        return true;
    }

    public final boolean isTested(boolean z) {
        if (z) {
            Iterator<PtStep> it = this.stepList.iterator();
            while (it.hasNext()) {
                if (!it.next().getJudge().isTested()) {
                    return false;
                }
            }
            return true;
        }
        Iterator<PtStep> it2 = this.stepList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getJudge().isTested()) {
                return true;
            }
        }
        return false;
    }

    public final PtStep createStep(PtCriterion ptCriterion) {
        return createStep(ptCriterion != null ? ptCriterion.name : null, ptCriterion);
    }
}
