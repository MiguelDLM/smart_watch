package com.szabh.smable3.watchface;

public final class WatchFaceBuilder {
    public static final WatchFaceBuilder INSTANCE;

    static {
        WatchFaceBuilder watchFaceBuilder = new WatchFaceBuilder();
        INSTANCE = watchFaceBuilder;
        System.loadLibrary("smawatchface");
        watchFaceBuilder.initLib();
    }

    private WatchFaceBuilder() {
    }

    public final native byte[] build(Element[] elementArr, int i);

    public final native void initLib();
}
