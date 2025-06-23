package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SerializeFilterable {
    protected List<BeforeFilter> beforeFilters = null;
    protected List<AfterFilter> afterFilters = null;
    protected List<PropertyFilter> propertyFilters = null;
    protected List<ValueFilter> valueFilters = null;
    protected List<NameFilter> nameFilters = null;
    protected List<PropertyPreFilter> propertyPreFilters = null;
    protected List<LabelFilter> labelFilters = null;
    protected List<ContextValueFilter> contextValueFilters = null;
    protected boolean writeDirect = true;

    public void addFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof PropertyPreFilter) {
            getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof NameFilter) {
            getNameFilters().add((NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof ValueFilter) {
            getValueFilters().add((ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof ContextValueFilter) {
            getContextValueFilters().add((ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof PropertyFilter) {
            getPropertyFilters().add((PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof BeforeFilter) {
            getBeforeFilters().add((BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof AfterFilter) {
            getAfterFilters().add((AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof LabelFilter) {
            getLabelFilters().add((LabelFilter) serializeFilter);
        }
    }

    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<PropertyFilter> list = jSONSerializer.propertyFilters;
        if (list != null) {
            Iterator<PropertyFilter> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<PropertyFilter> list2 = this.propertyFilters;
        if (list2 != null) {
            Iterator<PropertyFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!it2.next().apply(obj, str, obj2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean applyName(JSONSerializer jSONSerializer, Object obj, String str) {
        List<PropertyPreFilter> list = jSONSerializer.propertyPreFilters;
        if (list != null) {
            Iterator<PropertyPreFilter> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
        }
        List<PropertyPreFilter> list2 = this.propertyPreFilters;
        if (list2 != null) {
            Iterator<PropertyPreFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!it2.next().apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.beforeFilters;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters == null) {
            this.contextValueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.contextValueFilters;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.labelFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.valueFilters;
    }

    public String processKey(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<NameFilter> list = jSONSerializer.nameFilters;
        if (list != null) {
            Iterator<NameFilter> it = list.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, obj2);
            }
        }
        List<NameFilter> list2 = this.nameFilters;
        if (list2 != null) {
            Iterator<NameFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                str = it2.next().process(obj, str, obj2);
            }
        }
        return str;
    }

    public Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2) {
        return processValue(jSONSerializer, beanContext, obj, str, obj2, 0);
    }

    public boolean writeDirect(JSONSerializer jSONSerializer) {
        if (jSONSerializer.out.writeDirect && this.writeDirect && jSONSerializer.writeDirect) {
            return true;
        }
        return false;
    }

    public Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2, int i) {
        boolean z;
        if (obj2 != null) {
            int i2 = jSONSerializer.out.features;
            SerializerFeature serializerFeature = SerializerFeature.WriteNonStringValueAsString;
            if ((!SerializerFeature.isEnabled(i2, i, serializerFeature) && (beanContext == null || (beanContext.getFeatures() & serializerFeature.mask) == 0)) || (!((z = obj2 instanceof Number)) && !(obj2 instanceof Boolean))) {
                if (beanContext != null && beanContext.isJsonDirect()) {
                    obj2 = JSON.parse((String) obj2);
                }
            } else {
                String format = (!z || beanContext == null) ? null : beanContext.getFormat();
                if (format != null) {
                    obj2 = new DecimalFormat(format).format(obj2);
                } else {
                    obj2 = obj2.toString();
                }
            }
        }
        List<ValueFilter> list = jSONSerializer.valueFilters;
        if (list != null) {
            Iterator<ValueFilter> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().process(obj, str, obj2);
            }
        }
        List<ValueFilter> list2 = this.valueFilters;
        if (list2 != null) {
            Iterator<ValueFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().process(obj, str, obj2);
            }
        }
        List<ContextValueFilter> list3 = jSONSerializer.contextValueFilters;
        if (list3 != null) {
            Iterator<ContextValueFilter> it3 = list3.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().process(beanContext, obj, str, obj2);
            }
        }
        List<ContextValueFilter> list4 = this.contextValueFilters;
        if (list4 != null) {
            Iterator<ContextValueFilter> it4 = list4.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().process(beanContext, obj, str, obj2);
            }
        }
        return obj2;
    }
}
