package com.alibaba.fastjson;

import XIXIX.OOXIXo;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        JSONObject.SecureObjectInputStream.ensureFields();
        if (JSONObject.SecureObjectInputStream.fields != null && !JSONObject.SecureObjectInputStream.fields_error) {
            try {
                new JSONObject.SecureObjectInputStream(objectInputStream).defaultReadObject();
                return;
            } catch (NotActiveException unused) {
            }
        }
        objectInputStream.defaultReadObject();
        for (Object next : this.list) {
            if (next != null) {
                String name = next.getClass().getName();
                if (TypeUtils.getClassFromMapping(name) == null) {
                    ParserConfig.global.checkAutoType(name, (Class<?>) null);
                }
            }
        }
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public boolean addAll(Collection<?> collection) {
        return this.list.addAll(collection);
    }

    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray((List<Object>) new ArrayList(this.list));
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JSONArray) {
            return this.list.equals(((JSONArray) obj).list);
        }
        return this.list.equals(obj);
    }

    public JSONArray fluentAdd(Object obj) {
        this.list.add(obj);
        return this;
    }

    public JSONArray fluentAddAll(Collection<?> collection) {
        this.list.addAll(collection);
        return this;
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    public JSONArray fluentRemove(Object obj) {
        this.list.remove(obj);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        this.list.removeAll(collection);
        return this;
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        this.list.retainAll(collection);
        return this;
    }

    public JSONArray fluentSet(int i, Object obj) {
        set(i, obj);
        return this;
    }

    public Object get(int i) {
        return this.list.get(i);
    }

    public BigDecimal getBigDecimal(int i) {
        return TypeUtils.castToBigDecimal(get(i));
    }

    public BigInteger getBigInteger(int i) {
        return TypeUtils.castToBigInteger(get(i));
    }

    public Boolean getBoolean(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(int i) {
        Object obj = get(i);
        if (obj == null) {
            return false;
        }
        return TypeUtils.castToBoolean(obj).booleanValue();
    }

    public Byte getByte(int i) {
        return TypeUtils.castToByte(get(i));
    }

    public byte getByteValue(int i) {
        Byte castToByte = TypeUtils.castToByte(get(i));
        if (castToByte == null) {
            return 0;
        }
        return castToByte.byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i) {
        return TypeUtils.castToDate(get(i));
    }

    public Double getDouble(int i) {
        return TypeUtils.castToDouble(get(i));
    }

    public double getDoubleValue(int i) {
        Double castToDouble = TypeUtils.castToDouble(get(i));
        if (castToDouble == null) {
            return OOXIXo.f29376XO;
        }
        return castToDouble.doubleValue();
    }

    public Float getFloat(int i) {
        return TypeUtils.castToFloat(get(i));
    }

    public float getFloatValue(int i) {
        Float castToFloat = TypeUtils.castToFloat(get(i));
        if (castToFloat == null) {
            return 0.0f;
        }
        return castToFloat.floatValue();
    }

    public int getIntValue(int i) {
        Integer castToInt = TypeUtils.castToInt(get(i));
        if (castToInt == null) {
            return 0;
        }
        return castToInt.intValue();
    }

    public Integer getInteger(int i) {
        return TypeUtils.castToInt(get(i));
    }

    public JSONArray getJSONArray(int i) {
        Object obj = this.list.get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj instanceof List) {
            return new JSONArray((List<Object>) (List) obj);
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(int i) {
        Object obj = this.list.get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof Map) {
            return new JSONObject((Map<String, Object>) (Map) obj);
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(int i) {
        return TypeUtils.castToLong(get(i));
    }

    public long getLongValue(int i) {
        Long castToLong = TypeUtils.castToLong(get(i));
        if (castToLong == null) {
            return 0;
        }
        return castToLong.longValue();
    }

    public <T> T getObject(int i, Class<T> cls) {
        return TypeUtils.castToJavaBean(this.list.get(i), cls);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i) {
        return TypeUtils.castToShort(get(i));
    }

    public short getShortValue(int i) {
        Short castToShort = TypeUtils.castToShort(get(i));
        if (castToShort == null) {
            return 0;
        }
        return castToShort.shortValue();
    }

    public Object getSqlDate(int i) {
        return TypeUtils.castToSqlDate(get(i));
    }

    public String getString(int i) {
        return TypeUtils.castToString(get(i));
    }

    public Object getTimestamp(int i) {
        return TypeUtils.castToTimestamp(get(i));
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public Object set(int i, Object obj) {
        if (i == -1) {
            this.list.add(obj);
            return null;
        } else if (this.list.size() > i) {
            return this.list.set(i, obj);
        } else {
            for (int size = this.list.size(); size < i; size++) {
                this.list.add((Object) null);
            }
            this.list.add(obj);
            return null;
        }
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    public int size() {
        return this.list.size();
    }

    public List<Object> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> List<T> toJavaList(Class<T> cls) {
        ArrayList arrayList = new ArrayList(size());
        ParserConfig globalInstance = ParserConfig.getGlobalInstance();
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            arrayList.add(TypeUtils.cast(it.next(), cls, globalInstance));
        }
        return arrayList;
    }

    public void add(int i, Object obj) {
        this.list.add(i, obj);
    }

    public boolean addAll(int i, Collection<?> collection) {
        return this.list.addAll(i, collection);
    }

    public JSONArray fluentAdd(int i, Object obj) {
        this.list.add(i, obj);
        return this;
    }

    public JSONArray fluentAddAll(int i, Collection<?> collection) {
        this.list.addAll(i, collection);
        return this;
    }

    public JSONArray fluentRemove(int i) {
        this.list.remove(i);
        return this;
    }

    public ListIterator<Object> listIterator(int i) {
        return this.list.listIterator(i);
    }

    public Object remove(int i) {
        return this.list.remove(i);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.list.toArray(tArr);
    }

    public JSONArray(List<Object> list2) {
        if (list2 != null) {
            this.list = list2;
            return;
        }
        throw new IllegalArgumentException("list is null.");
    }

    public <T> T getObject(int i, Type type) {
        Object obj = this.list.get(i);
        if (type instanceof Class) {
            return TypeUtils.castToJavaBean(obj, (Class) type);
        }
        return JSON.parseObject(JSON.toJSONString(obj), type, new Feature[0]);
    }

    public JSONArray(int i) {
        this.list = new ArrayList(i);
    }
}
