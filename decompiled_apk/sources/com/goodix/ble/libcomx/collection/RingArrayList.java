package com.goodix.ble.libcomx.collection;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class RingArrayList<E> extends AbstractList<E> {
    private Object[] elements;
    private int writeIdx = 0;
    private int elementCnt = 0;

    public RingArrayList(int i) {
        this.elements = new Object[i];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        Object[] objArr = this.elements;
        int i = this.writeIdx;
        objArr[i] = e;
        this.writeIdx = (i + 1) % objArr.length;
        int i2 = this.elementCnt;
        if (i2 < objArr.length) {
            this.elementCnt = i2 + 1;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        Object[] objArr = this.elements;
        if (objArr.length > size) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return true;
        }
        int length = size - objArr.length;
        Object[] array = collection.toArray();
        Object[] objArr2 = this.elements;
        System.arraycopy(array, length, objArr2, 0, objArr2.length);
        this.writeIdx = 0;
        this.elementCnt = this.elements.length;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.writeIdx = 0;
        this.elementCnt = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        int i2 = this.elementCnt;
        Object[] objArr = this.elements;
        if (i2 < objArr.length) {
            return (E) objArr[i];
        }
        return (E) objArr[(this.writeIdx + i) % objArr.length];
    }

    public E reuseElement() {
        return (E) this.elements[this.writeIdx];
    }

    public void setCapability(int i) {
        Object[] objArr = this.elements;
        int i2 = this.elementCnt;
        int i3 = this.writeIdx;
        if (i == objArr.length) {
            return;
        }
        this.elements = new Object[i];
        int i4 = 0;
        this.writeIdx = 0;
        this.elementCnt = 0;
        if (i2 > i) {
            i4 = i2 - i;
        }
        while (i4 < i2) {
            int length = (i3 + i4) % objArr.length;
            Object[] objArr2 = this.elements;
            int i5 = this.writeIdx;
            objArr2[i5] = objArr[length];
            this.writeIdx = (i5 + 1) % objArr2.length;
            int i6 = this.elementCnt;
            if (i6 < objArr2.length) {
                this.elementCnt = i6 + 1;
            }
            i4++;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.elementCnt;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        Object[] objArr = new Object[this.elements.length];
        objArr[i] = e;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = get(i2);
        }
        int i3 = this.elementCnt;
        if (i3 >= this.elements.length) {
            i3--;
        }
        for (int i4 = i; i4 < i3; i4++) {
            objArr[i + 1] = get(i4);
        }
        this.elements = objArr;
        int i5 = i + 1 + i3;
        this.elementCnt = i5;
        this.writeIdx = i5 % objArr.length;
    }
}
