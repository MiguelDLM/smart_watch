package com.garmin.fit;

/* loaded from: classes9.dex */
public enum Sport {
    GENERIC(0),
    RUNNING(1),
    CYCLING(2),
    TRANSITION(3),
    FITNESS_EQUIPMENT(4),
    SWIMMING(5),
    BASKETBALL(6),
    SOCCER(7),
    TENNIS(8),
    AMERICAN_FOOTBALL(9),
    TRAINING(10),
    WALKING(11),
    CROSS_COUNTRY_SKIING(12),
    ALPINE_SKIING(13),
    SNOWBOARDING(14),
    ROWING(15),
    MOUNTAINEERING(16),
    HIKING(17),
    MULTISPORT(18),
    PADDLING(19),
    FLYING(20),
    E_BIKING(21),
    MOTORCYCLING(22),
    BOATING(23),
    DRIVING(24),
    GOLF(25),
    HANG_GLIDING(26),
    HORSEBACK_RIDING(27),
    HUNTING(28),
    FISHING(29),
    INLINE_SKATING(30),
    ROCK_CLIMBING(31),
    SAILING(32),
    ICE_SKATING(33),
    SKY_DIVING(34),
    SNOWSHOEING(35),
    SNOWMOBILING(36),
    STAND_UP_PADDLEBOARDING(37),
    SURFING(38),
    WAKEBOARDING(39),
    WATER_SKIING(40),
    KAYAKING(41),
    RAFTING(42),
    WINDSURFING(43),
    KITESURFING(44),
    TACTICAL(45),
    JUMPMASTER(46),
    BOXING(47),
    FLOOR_CLIMBING(48),
    BASEBALL(49),
    DIVING(53),
    HIIT(62),
    RACKET(64),
    WHEELCHAIR_PUSH_WALK(65),
    WHEELCHAIR_PUSH_RUN(66),
    MEDITATION(67),
    DISC_GOLF(69),
    CRICKET(71),
    RUGBY(72),
    HOCKEY(73),
    LACROSSE(74),
    VOLLEYBALL(75),
    WATER_TUBING(76),
    WAKESURFING(77),
    MIXED_MARTIAL_ARTS(80),
    SNORKELING(82),
    DANCE(83),
    JUMP_ROPE(84),
    ALL(254),
    INVALID(255);

    protected short value;

    Sport(short s) {
        this.value = s;
    }

    public static Sport getByValue(Short sh) {
        for (Sport sport : values()) {
            if (sh.shortValue() == sport.value) {
                return sport;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(Sport sport) {
        return sport.name();
    }

    public short getValue() {
        return this.value;
    }
}
