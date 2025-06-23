package com.baidu.mapapi.map;

/* loaded from: classes7.dex */
public enum ParticleEffectType {
    UnKnow(-1),
    Snow(0),
    RainStorm(4),
    Smog(5),
    SandStorm(7),
    Fireworks(8),
    Flower(9);


    /* renamed from: a, reason: collision with root package name */
    private int f5844a;

    ParticleEffectType(int i) {
        this.f5844a = i;
    }

    public int getType() {
        return this.f5844a;
    }
}
