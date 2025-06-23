package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class ej {
    private DefaultParams D;
    private String mCasePath;
    private IARRenderer rm;
    private FilterStateListener rn;
    private HashMap<FilterNode, Boolean> ro = new HashMap<>();
    private HashMap<FilterNode, Boolean> rp = new HashMap<>();
    private HashMap<FilterNode, Boolean> rq = new HashMap<>();
    private ek rr = new ek();

    public ej(DefaultParams defaultParams) {
        this.D = defaultParams;
        HashMap<FilterNode, Boolean> hashMap = this.ro;
        if (hashMap != null) {
            FilterNode filterNode = FilterNode.lutFilter;
            Boolean bool = Boolean.FALSE;
            hashMap.put(filterNode, bool);
            this.ro.put(FilterNode.skinFilter, bool);
            this.ro.put(FilterNode.faceFilter, bool);
            this.ro.put(FilterNode.makeupFilter, bool);
        }
        HashMap<FilterNode, Boolean> hashMap2 = this.rp;
        if (hashMap2 != null) {
            hashMap2.put(FilterNode.lutFilter, Boolean.TRUE);
            this.rp.put(FilterNode.skinFilter, Boolean.valueOf(this.D.isUseBeautyFilter()));
            this.rp.put(FilterNode.faceFilter, Boolean.valueOf(this.D.isUseFaceFilter()));
            this.rp.put(FilterNode.makeupFilter, Boolean.valueOf(this.D.isUseMakeupFilter()));
        }
    }

    private String aw(String str) {
        return FilterNode.faceFilter.getNodeName().equals(str) ? "ability_face_filter" : FilterNode.makeupFilter.getNodeName().equals(str) ? "ability_makeup_filter" : "ability_common_filter";
    }

    private void ax(String str) {
        String str2;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1361525779:
                if (str.equals("cheeks")) {
                    c = 0;
                    break;
                }
                break;
            case -681210700:
                if (str.equals("highlight")) {
                    c = 1;
                    break;
                }
                break;
            case 3321920:
                if (str.equals("lips")) {
                    c = 2;
                    break;
                }
                break;
            case 379533195:
                if (str.equals("lips_mask")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = StatisticConstants.EVENT_MAKEUP_BLUSHER_ENTER;
                break;
            case 1:
                str2 = StatisticConstants.EVENT_MAKEUP_HIGHLIGHT_ENTER;
                break;
            case 2:
            case 3:
                str2 = StatisticConstants.EVENT_MAKEUP_LIPSTICK_ENTER;
                break;
            default:
                str2 = null;
                break;
        }
        if (str2 != null) {
            StatisticApi.onEvent(str2);
        }
    }

    private String c(Object obj) {
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return "/opacity";
        }
        if (obj instanceof String) {
            return "/texture_path";
        }
        if (obj instanceof Integer) {
            return "/is_enable";
        }
        return null;
    }

    private void z(int i) {
        if (this.rm != null) {
            bh bhVar = new bh();
            bhVar.u("ability_common_filter");
            bhVar.setFilterName(FilterNode.faceFilter.getNodeName());
            bhVar.L("clearAllKnead");
            bhVar.a(Integer.valueOf(i));
            this.rm.updateFilterData(bhVar);
        }
    }

    public void a(IARRenderer iARRenderer) {
        this.rm = iARRenderer;
    }

    public void av(String str) {
        this.mCasePath = str;
    }

    public void clearAllFilter() {
        z(1);
    }

    public void clearCaseLutFilter() {
        IARRenderer iARRenderer = this.rm;
        if (iARRenderer != null) {
            iARRenderer.clearCaseLutFilter();
        }
    }

    public synchronized void dC() {
        try {
            HashMap<FilterNode, Boolean> hashMap = this.ro;
            if (hashMap != null) {
                FilterNode filterNode = FilterNode.lutFilter;
                Boolean bool = Boolean.TRUE;
                hashMap.put(filterNode, bool);
                this.ro.put(FilterNode.skinFilter, bool);
                this.ro.put(FilterNode.faceFilter, bool);
                this.ro.put(FilterNode.makeupFilter, bool);
                kf.c("ARFilterManager", "onPipelineCreate mPipelineStates = " + this.ro.toString());
            }
            dD();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void dD() {
        HashMap<FilterNode, Boolean> hashMap;
        HashMap<FilterNode, Boolean> hashMap2 = this.rq;
        if (hashMap2 != null && (hashMap = this.ro) != null && this.rp != null) {
            FilterNode filterNode = FilterNode.lutFilter;
            boolean z = false;
            hashMap2.put(filterNode, Boolean.valueOf(hashMap.get(filterNode).booleanValue() && this.rp.get(filterNode).booleanValue()));
            HashMap<FilterNode, Boolean> hashMap3 = this.rq;
            FilterNode filterNode2 = FilterNode.skinFilter;
            hashMap3.put(filterNode2, Boolean.valueOf(this.ro.get(filterNode2).booleanValue() && this.rp.get(filterNode2).booleanValue()));
            HashMap<FilterNode, Boolean> hashMap4 = this.rq;
            FilterNode filterNode3 = FilterNode.faceFilter;
            hashMap4.put(filterNode3, Boolean.valueOf(this.ro.get(filterNode3).booleanValue() && this.rp.get(filterNode3).booleanValue()));
            HashMap<FilterNode, Boolean> hashMap5 = this.rq;
            FilterNode filterNode4 = FilterNode.makeupFilter;
            if (this.ro.get(filterNode4).booleanValue() && this.rp.get(filterNode4).booleanValue()) {
                z = true;
            }
            hashMap5.put(filterNode4, Boolean.valueOf(z));
            kf.c("ARFilterManager", "callbackFilterStates mFilterStates = " + this.rq.toString() + " && mCasePath = " + this.mCasePath);
        }
        FilterStateListener filterStateListener = this.rn;
        if (filterStateListener != null) {
            filterStateListener.onFilterStateChanged(this.rq, this.mCasePath);
        }
    }

    public void dE() {
        if (this.rr.dG()) {
            c(this.rr.dF(), true);
        }
    }

    public synchronized void f(List<String> list) {
        if (list == null) {
            return;
        }
        try {
            HashMap<FilterNode, Boolean> hashMap = this.ro;
            if (hashMap != null) {
                FilterNode filterNode = FilterNode.lutFilter;
                hashMap.put(filterNode, Boolean.valueOf(list.contains(filterNode.getNodeName())));
                HashMap<FilterNode, Boolean> hashMap2 = this.ro;
                FilterNode filterNode2 = FilterNode.skinFilter;
                hashMap2.put(filterNode2, Boolean.valueOf(list.contains(filterNode2.getNodeName())));
                HashMap<FilterNode, Boolean> hashMap3 = this.ro;
                FilterNode filterNode3 = FilterNode.faceFilter;
                hashMap3.put(filterNode3, Boolean.valueOf(list.contains(filterNode3.getNodeName())));
                HashMap<FilterNode, Boolean> hashMap4 = this.ro;
                FilterNode filterNode4 = FilterNode.makeupFilter;
                hashMap4.put(filterNode4, Boolean.valueOf(list.contains(filterNode4.getNodeName())));
                kf.c("ARFilterManager", "onPipelineChanged mPipelineStates = " + this.ro.toString());
            }
            dD();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void release() {
        try {
            this.D = null;
            this.rm = null;
            this.rr = null;
            this.rn = null;
            HashMap<FilterNode, Boolean> hashMap = this.ro;
            if (hashMap != null) {
                hashMap.clear();
                this.ro = null;
            }
            HashMap<FilterNode, Boolean> hashMap2 = this.rp;
            if (hashMap2 != null) {
                hashMap2.clear();
                this.rp = null;
            }
            HashMap<FilterNode, Boolean> hashMap3 = this.rq;
            if (hashMap3 != null) {
                hashMap3.clear();
                this.rq = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void resetAllFilter() {
        z(0);
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.rn = filterStateListener;
    }

    public void updateFilter(String str, String str2, Object obj) {
        boolean z;
        String str3;
        String str4 = null;
        if (FilterNode.makeupFilter.getNodeName().equals(str)) {
            if (obj instanceof String) {
                ax(str2);
            } else if (obj instanceof Integer) {
                str3 = null;
                z = true;
                a(str, str2, obj, str3, z);
            }
        } else if (FilterNode.advanceBeautyFilter.getNodeName().equals(str) && (obj instanceof Float)) {
            str4 = "/intensity";
        }
        str3 = str4;
        z = false;
        a(str, str2, obj, str3, z);
    }

    public String updateFilterCase(String str) {
        if (this.rm == null) {
            return null;
        }
        String renderPipeline = this.D.getRenderPipeline();
        if (!TextUtils.isEmpty(renderPipeline) && renderPipeline.contains(FilterNode.highlightFilter.getNodeName())) {
            kf.c("ARFilterManager", "updateFilterCase: getRenderPipeline " + renderPipeline);
            this.rr.ay(str);
        }
        return this.rm.updateFilterCase(str);
    }

    public synchronized void a(FilterNode filterNode, boolean z) {
        HashMap<FilterNode, Boolean> hashMap;
        kf.c("ARFilterManager", "updateAbilityState filerName = " + filterNode + " && state = " + z);
        if (filterNode != null && (hashMap = this.rp) != null && hashMap.containsKey(filterNode)) {
            this.rp.put(filterNode, Boolean.valueOf(z));
        }
    }

    public void c(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bh bhVar = new bh();
        bhVar.j(true);
        bhVar.u(aw(str));
        bhVar.setFilterName(str);
        bhVar.L("is_enable");
        bhVar.a(z ? 1 : 0);
        IARRenderer iARRenderer = this.rm;
        if (iARRenderer != null) {
            iARRenderer.updateFilterData(bhVar);
        }
    }

    public void a(FilterParam filterParam, Object obj) {
        String str;
        boolean z;
        String str2;
        if (filterParam == null) {
            return;
        }
        FilterNode filterNode = filterParam.getFilterNode();
        if (FilterNode.makeupFilter.equals(filterNode)) {
            str = c(obj);
            if (obj instanceof String) {
                ax(filterParam.getParamName());
            } else if (obj instanceof Integer) {
                str2 = str;
                z = true;
                a(filterNode.getNodeName(), filterParam.getParamName(), obj, str2, z);
            }
        } else {
            str = (FilterNode.advanceBeautyFilter.equals(filterNode) && (obj instanceof Float)) ? "/intensity" : null;
        }
        str2 = str;
        z = false;
        a(filterNode.getNodeName(), filterParam.getParamName(), obj, str2, z);
    }

    public void a(String str, String str2, Object obj, String str3, boolean z) {
        bh bhVar = new bh();
        bhVar.u(aw(str));
        bhVar.setFilterName(str);
        bhVar.a(obj);
        bhVar.j(z);
        if (TextUtils.isEmpty(str3)) {
            bhVar.L(str2);
        } else {
            bhVar.L(str2 + str3);
        }
        IARRenderer iARRenderer = this.rm;
        if (iARRenderer != null) {
            iARRenderer.updateFilterData(bhVar);
        }
    }
}
