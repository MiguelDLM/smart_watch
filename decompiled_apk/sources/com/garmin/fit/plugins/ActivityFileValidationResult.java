package com.garmin.fit.plugins;

/* loaded from: classes9.dex */
public class ActivityFileValidationResult {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f15110I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Level f15111II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f15112oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Status f15113oxoX = Status.SKIPPED;

    /* loaded from: classes9.dex */
    public enum Level {
        REQUIRED,
        OPTIONAL
    }

    /* loaded from: classes9.dex */
    public enum Status {
        SKIPPED,
        WARNING,
        FAILED,
        PASSED
    }

    public ActivityFileValidationResult(String str, Level level) {
        this.f15112oIX0oI = str;
        this.f15111II0xO0 = level;
    }

    public String I0Io() {
        return this.f15112oIX0oI;
    }

    public Level II0xO0() {
        return this.f15111II0xO0;
    }

    public void X0o0xo(String str) {
        this.f15110I0Io = str;
    }

    public void XO(Status status) {
        this.f15113oxoX = status;
    }

    public String oIX0oI() {
        return this.f15110I0Io;
    }

    public Status oxoX() {
        return this.f15113oxoX;
    }

    public String toString() {
        return I0Io() + " - Level: " + II0xO0() + " Status: " + oxoX();
    }
}
