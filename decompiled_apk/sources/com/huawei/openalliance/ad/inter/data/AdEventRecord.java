package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class AdEventRecord {
    private d ad;
    private long endTime;
    private Long eventTime;
    private String eventType;
    private long startTime;

    @com.huawei.openalliance.ad.annotations.b
    public AdEventRecord() {
    }

    public Long B() {
        return this.eventTime;
    }

    public d Code() {
        return this.ad;
    }

    public long I() {
        return this.endTime;
    }

    public long V() {
        return this.startTime;
    }

    public String Z() {
        return this.eventType;
    }

    @com.huawei.openalliance.ad.annotations.b
    public AdEventRecord(c cVar, long j, long j2, String str, Long l) {
        this.ad = cVar;
        this.startTime = j;
        this.endTime = j2;
        this.eventType = str;
        this.eventTime = l;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(long j) {
        this.startTime = j;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(long j) {
        this.endTime = j;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(d dVar) {
        this.ad = dVar;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(Long l) {
        this.eventTime = l;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(String str) {
        this.eventType = str;
    }
}
