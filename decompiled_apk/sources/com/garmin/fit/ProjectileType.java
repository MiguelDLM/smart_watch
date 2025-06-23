package com.garmin.fit;

/* loaded from: classes9.dex */
public enum ProjectileType {
    ARROW(0),
    RIFLE_CARTRIDGE(1),
    PISTOL_CARTRIDGE(2),
    SHOTSHELL(3),
    AIR_RIFLE_PELLET(4),
    OTHER(5),
    INVALID(255);

    protected short value;

    ProjectileType(short s) {
        this.value = s;
    }

    public static ProjectileType getByValue(Short sh) {
        for (ProjectileType projectileType : values()) {
            if (sh.shortValue() == projectileType.value) {
                return projectileType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(ProjectileType projectileType) {
        return projectileType.name();
    }

    public short getValue() {
        return this.value;
    }
}
