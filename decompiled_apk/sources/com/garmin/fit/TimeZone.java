package com.garmin.fit;

/* loaded from: classes9.dex */
public enum TimeZone {
    ALMATY(0),
    BANGKOK(1),
    BOMBAY(2),
    BRASILIA(3),
    CAIRO(4),
    CAPE_VERDE_IS(5),
    DARWIN(6),
    ENIWETOK(7),
    FIJI(8),
    HONG_KONG(9),
    ISLAMABAD(10),
    KABUL(11),
    MAGADAN(12),
    MID_ATLANTIC(13),
    MOSCOW(14),
    MUSCAT(15),
    NEWFOUNDLAND(16),
    SAMOA(17),
    SYDNEY(18),
    TEHRAN(19),
    TOKYO(20),
    US_ALASKA(21),
    US_ATLANTIC(22),
    US_CENTRAL(23),
    US_EASTERN(24),
    US_HAWAII(25),
    US_MOUNTAIN(26),
    US_PACIFIC(27),
    OTHER(28),
    AUCKLAND(29),
    KATHMANDU(30),
    EUROPE_WESTERN_WET(31),
    EUROPE_CENTRAL_CET(32),
    EUROPE_EASTERN_EET(33),
    JAKARTA(34),
    PERTH(35),
    ADELAIDE(36),
    BRISBANE(37),
    TASMANIA(38),
    ICELAND(39),
    AMSTERDAM(40),
    ATHENS(41),
    BARCELONA(42),
    BERLIN(43),
    BRUSSELS(44),
    BUDAPEST(45),
    COPENHAGEN(46),
    DUBLIN(47),
    HELSINKI(48),
    LISBON(49),
    LONDON(50),
    MADRID(51),
    MUNICH(52),
    OSLO(53),
    PARIS(54),
    PRAGUE(55),
    REYKJAVIK(56),
    ROME(57),
    STOCKHOLM(58),
    VIENNA(59),
    WARSAW(60),
    ZURICH(61),
    QUEBEC(62),
    ONTARIO(63),
    MANITOBA(64),
    SASKATCHEWAN(65),
    ALBERTA(66),
    BRITISH_COLUMBIA(67),
    BOISE(68),
    BOSTON(69),
    CHICAGO(70),
    DALLAS(71),
    DENVER(72),
    KANSAS_CITY(73),
    LAS_VEGAS(74),
    LOS_ANGELES(75),
    MIAMI(76),
    MINNEAPOLIS(77),
    NEW_YORK(78),
    NEW_ORLEANS(79),
    PHOENIX(80),
    SANTA_FE(81),
    SEATTLE(82),
    WASHINGTON_DC(83),
    US_ARIZONA(84),
    CHITA(85),
    EKATERINBURG(86),
    IRKUTSK(87),
    KALININGRAD(88),
    KRASNOYARSK(89),
    NOVOSIBIRSK(90),
    PETROPAVLOVSK_KAMCHATSKIY(91),
    SAMARA(92),
    VLADIVOSTOK(93),
    MEXICO_CENTRAL(94),
    MEXICO_MOUNTAIN(95),
    MEXICO_PACIFIC(96),
    CAPE_TOWN(97),
    WINKHOEK(98),
    LAGOS(99),
    RIYAHD(100),
    VENEZUELA(101),
    AUSTRALIA_LH(102),
    SANTIAGO(103),
    MANUAL(253),
    AUTOMATIC(254),
    INVALID(255);

    protected short value;

    TimeZone(short s) {
        this.value = s;
    }

    public static TimeZone getByValue(Short sh) {
        for (TimeZone timeZone : values()) {
            if (sh.shortValue() == timeZone.value) {
                return timeZone;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(TimeZone timeZone) {
        return timeZone.name();
    }

    public short getValue() {
        return this.value;
    }
}
