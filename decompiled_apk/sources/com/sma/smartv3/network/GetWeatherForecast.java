package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class GetWeatherForecast {

    @OOXIXo
    public static final String BLE_NAME = "bleName";

    @OOXIXo
    public static final String FLAG = "flag";

    @OOXIXo
    public static final GetWeatherForecast INSTANCE = new GetWeatherForecast();

    @OOXIXo
    public static final String LAT = "lat";

    @OOXIXo
    public static final String LON = "lon";

    @OOXIXo
    public static final String PROJECT_ID = "projectId";

    @OOXIXo
    public static final String URL = "/weather_info/forecast";

    private GetWeatherForecast() {
    }
}
