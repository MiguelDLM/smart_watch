package com.baidu.mapframework.nirvana.schedule;

/* loaded from: classes7.dex */
public class UITaskType implements TaskType {

    /* renamed from: a, reason: collision with root package name */
    private final UIType f6121a;
    private final String b;

    /* loaded from: classes7.dex */
    public enum UIType {
        PAGE,
        SCENE,
        ACTIVITY
    }

    private UITaskType(UIType uIType, String str) {
        this.f6121a = uIType;
        this.b = str;
    }

    public static UITaskType forActivity(String str) {
        return new UITaskType(UIType.ACTIVITY, str);
    }

    public static UITaskType forPage(String str) {
        return new UITaskType(UIType.PAGE, str);
    }

    public static UITaskType forScene(String str) {
        return new UITaskType(UIType.SCENE, str);
    }

    public String getName() {
        return this.b;
    }

    public UIType getType() {
        return this.f6121a;
    }

    public String toString() {
        return "UITaskType{type=" + this.f6121a + ", name='" + this.b + "'}";
    }
}
