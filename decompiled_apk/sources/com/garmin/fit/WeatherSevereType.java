package com.garmin.fit;

/* loaded from: classes9.dex */
public enum WeatherSevereType {
    UNSPECIFIED(0),
    TORNADO(1),
    TSUNAMI(2),
    HURRICANE(3),
    EXTREME_WIND(4),
    TYPHOON(5),
    INLAND_HURRICANE(6),
    HURRICANE_FORCE_WIND(7),
    WATERSPOUT(8),
    SEVERE_THUNDERSTORM(9),
    WRECKHOUSE_WINDS(10),
    LES_SUETES_WIND(11),
    AVALANCHE(12),
    FLASH_FLOOD(13),
    TROPICAL_STORM(14),
    INLAND_TROPICAL_STORM(15),
    BLIZZARD(16),
    ICE_STORM(17),
    FREEZING_RAIN(18),
    DEBRIS_FLOW(19),
    FLASH_FREEZE(20),
    DUST_STORM(21),
    HIGH_WIND(22),
    WINTER_STORM(23),
    HEAVY_FREEZING_SPRAY(24),
    EXTREME_COLD(25),
    WIND_CHILL(26),
    COLD_WAVE(27),
    HEAVY_SNOW_ALERT(28),
    LAKE_EFFECT_BLOWING_SNOW(29),
    SNOW_SQUALL(30),
    LAKE_EFFECT_SNOW(31),
    WINTER_WEATHER(32),
    SLEET(33),
    SNOWFALL(34),
    SNOW_AND_BLOWING_SNOW(35),
    BLOWING_SNOW(36),
    SNOW_ALERT(37),
    ARCTIC_OUTFLOW(38),
    FREEZING_DRIZZLE(39),
    STORM(40),
    STORM_SURGE(41),
    RAINFALL(42),
    AREAL_FLOOD(43),
    COASTAL_FLOOD(44),
    LAKESHORE_FLOOD(45),
    EXCESSIVE_HEAT(46),
    HEAT(47),
    WEATHER(48),
    HIGH_HEAT_AND_HUMIDITY(49),
    HUMIDEX_AND_HEALTH(50),
    HUMIDEX(51),
    GALE(52),
    FREEZING_SPRAY(53),
    SPECIAL_MARINE(54),
    SQUALL(55),
    STRONG_WIND(56),
    LAKE_WIND(57),
    MARINE_WEATHER(58),
    WIND(59),
    SMALL_CRAFT_HAZARDOUS_SEAS(60),
    HAZARDOUS_SEAS(61),
    SMALL_CRAFT(62),
    SMALL_CRAFT_WINDS(63),
    SMALL_CRAFT_ROUGH_BAR(64),
    HIGH_WATER_LEVEL(65),
    ASHFALL(66),
    FREEZING_FOG(67),
    DENSE_FOG(68),
    DENSE_SMOKE(69),
    BLOWING_DUST(70),
    HARD_FREEZE(71),
    FREEZE(72),
    FROST(73),
    FIRE_WEATHER(74),
    FLOOD(75),
    RIP_TIDE(76),
    HIGH_SURF(77),
    SMOG(78),
    AIR_QUALITY(79),
    BRISK_WIND(80),
    AIR_STAGNATION(81),
    LOW_WATER(82),
    HYDROLOGICAL(83),
    SPECIAL_WEATHER(84),
    INVALID(255);

    protected short value;

    WeatherSevereType(short s) {
        this.value = s;
    }

    public static WeatherSevereType getByValue(Short sh) {
        for (WeatherSevereType weatherSevereType : values()) {
            if (sh.shortValue() == weatherSevereType.value) {
                return weatherSevereType;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(WeatherSevereType weatherSevereType) {
        return weatherSevereType.name();
    }

    public short getValue() {
        return this.value;
    }
}
