package com.baidu.mapframework.nirvana.schedule;

/* loaded from: classes7.dex */
public class DataTaskType implements TaskType {

    /* renamed from: a, reason: collision with root package name */
    private final Purpose f6112a;

    /* loaded from: classes7.dex */
    public enum Purpose {
        UPDATE_DATA,
        DOWNLOAD,
        STATISTICS
    }

    private DataTaskType(Purpose purpose) {
        this.f6112a = purpose;
    }

    public static DataTaskType forDownload() {
        return new DataTaskType(Purpose.DOWNLOAD);
    }

    public static DataTaskType forStatictics() {
        return new DataTaskType(Purpose.STATISTICS);
    }

    public static DataTaskType forUpdateData() {
        return new DataTaskType(Purpose.UPDATE_DATA);
    }

    public String toString() {
        return "DataTaskType{purpose=" + this.f6112a + '}';
    }
}
