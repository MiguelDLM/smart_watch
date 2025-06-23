package com.goodix.ble.libcomx.ptmodel;

import XXO0.oIX0oI;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public final class PtJudge {
    public String exception;
    public boolean logicalNot;
    public boolean logicalOr;
    public String name;
    public String note;
    private Boolean pass;
    private PtCriterion ref;
    private ArrayList<PtJudge> subJudgeList = null;
    public long timestamp;
    public String value;

    public PtJudge(PtCriterion ptCriterion) {
        this.ref = ptCriterion;
        if (ptCriterion != null) {
            this.name = ptCriterion.name;
            this.logicalNot = ptCriterion.logicalNot;
        }
    }

    private boolean isComplex() {
        ArrayList<PtJudge> arrayList = this.subJudgeList;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public PtJudge createSubJudge(PtCriterion ptCriterion) {
        if (this.subJudgeList == null) {
            this.subJudgeList = new ArrayList<>(8);
        }
        PtJudge ptJudge = new PtJudge(ptCriterion);
        this.subJudgeList.add(ptJudge);
        return ptJudge;
    }

    public PtCriterion getCriterion() {
        return this.ref;
    }

    public String getReportCaption() {
        HexStringBuilder hexStringBuilder = new HexStringBuilder(128);
        hexStringBuilder.a(this.name);
        hexStringBuilder.a(oIX0oI.I0Io.f4096II0xO0);
        if (this.logicalNot) {
            hexStringBuilder.a("NOT ");
        }
        PtCriterion ptCriterion = this.ref;
        if (ptCriterion != null) {
            String str = ptCriterion.valueExact;
            if (str != null) {
                hexStringBuilder.a(str);
            } else {
                Long l = ptCriterion.valueMin;
                if (l != null || ptCriterion.valueMax != null) {
                    if (l != null) {
                        hexStringBuilder.getStringBuilder().append(this.ref.valueMin);
                    } else {
                        hexStringBuilder.a("N");
                    }
                    hexStringBuilder.a(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                    if (this.ref.valueMax != null) {
                        hexStringBuilder.getStringBuilder().append(this.ref.valueMax);
                    } else {
                        hexStringBuilder.a("N");
                    }
                }
            }
            String str2 = this.ref.valueUnit;
            if (str2 != null) {
                hexStringBuilder.a(str2);
            }
        }
        hexStringBuilder.a(oIX0oI.I0Io.f4095I0Io);
        return hexStringBuilder.toString();
    }

    public String getReportContent() {
        String str;
        HexStringBuilder hexStringBuilder = new HexStringBuilder(128);
        if (isPass()) {
            str = "PASS";
        } else {
            str = "FAIL";
        }
        hexStringBuilder.a(str);
        if (this.exception != null) {
            hexStringBuilder.a(oIX0oI.I0Io.f4096II0xO0).a(this.exception).a(oIX0oI.I0Io.f4095I0Io);
        } else {
            hexStringBuilder.a(oIX0oI.I0Io.f4096II0xO0);
            if (isComplex()) {
                for (int i = 0; i < this.subJudgeList.size(); i++) {
                    hexStringBuilder.a(oIX0oI.I0Io.f4096II0xO0).a(this.subJudgeList.get(i).name).a(":").a(this.subJudgeList.get(i).value).a(oIX0oI.I0Io.f4095I0Io);
                }
            } else {
                hexStringBuilder.a(this.value);
            }
            hexStringBuilder.a(oIX0oI.I0Io.f4095I0Io);
        }
        return hexStringBuilder.toString();
    }

    public PtJudge getSubJudge(int i) {
        if (i < this.subJudgeList.size()) {
            return this.subJudgeList.get(i);
        }
        return null;
    }

    public int getSubJudgeCount() {
        return this.subJudgeList.size();
    }

    public boolean hasValue() {
        if (this.value != null) {
            return true;
        }
        return false;
    }

    public boolean isPass() {
        Boolean bool = this.pass;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean isTested() {
        if (this.pass == null && this.exception == null) {
            return false;
        }
        return true;
    }

    public boolean judge(String str) {
        PtCriterion ptCriterion;
        this.value = str;
        this.timestamp = System.currentTimeMillis();
        if (isComplex()) {
            if (this.logicalOr) {
                this.pass = Boolean.FALSE;
                Iterator<PtJudge> it = this.subJudgeList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().isPass()) {
                        this.pass = Boolean.TRUE;
                        break;
                    }
                }
            } else {
                this.pass = Boolean.TRUE;
                Iterator<PtJudge> it2 = this.subJudgeList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().isPass()) {
                        this.pass = Boolean.FALSE;
                        break;
                    }
                }
            }
            if (this.logicalNot) {
                this.pass = Boolean.valueOf(!this.pass.booleanValue());
            }
        } else if (str != null && (ptCriterion = this.ref) != null) {
            String str2 = ptCriterion.valueExact;
            if (str2 != null) {
                this.pass = Boolean.valueOf(str.equals(str2));
            } else if (ptCriterion.valueMin != null || ptCriterion.valueMax != null) {
                this.pass = Boolean.TRUE;
                if (ptCriterion.valuePrecision == null) {
                    long parseLong = Long.parseLong(str);
                    Long l = this.ref.valueMin;
                    if (l != null && parseLong < l.longValue()) {
                        this.pass = Boolean.FALSE;
                    }
                    Long l2 = this.ref.valueMax;
                    if (l2 != null && parseLong > l2.longValue()) {
                        this.pass = Boolean.FALSE;
                    }
                } else {
                    float parseFloat = Float.parseFloat(str);
                    if (this.ref.valueMin != null && ((int) (((float) r0.valuePrecision.longValue()) * parseFloat)) < this.ref.valueMin.longValue()) {
                        this.pass = Boolean.FALSE;
                    }
                    if (this.ref.valueMax != null && ((int) (parseFloat * ((float) r0.valuePrecision.longValue()))) > this.ref.valueMax.longValue()) {
                        this.pass = Boolean.FALSE;
                    }
                }
            }
            if (this.pass != null && this.logicalNot) {
                this.pass = Boolean.valueOf(!r6.booleanValue());
            }
        }
        return isPass();
    }

    public void reset() {
        this.value = null;
        this.timestamp = 0L;
        this.pass = null;
        this.exception = null;
        this.note = null;
        if (isComplex()) {
            Iterator<PtJudge> it = this.subJudgeList.iterator();
            while (it.hasNext()) {
                it.next().reset();
            }
        }
    }

    public void setCriterion(PtCriterion ptCriterion) {
        this.ref = ptCriterion;
    }

    public void setPass(Boolean bool) {
        this.pass = bool;
        if (isComplex()) {
            Iterator<PtJudge> it = this.subJudgeList.iterator();
            while (it.hasNext()) {
                it.next().setPass(bool);
            }
        }
    }

    public boolean judge(int i) {
        return judge(String.valueOf(i));
    }

    public boolean judge(long j) {
        return judge(String.valueOf(j));
    }

    public boolean judge(float f) {
        return judge(String.valueOf(f));
    }
}
