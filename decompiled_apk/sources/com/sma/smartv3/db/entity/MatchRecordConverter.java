package com.sma.smartv3.db.entity;

import OXOo.oOoXoXO;
import android.text.TextUtils;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.szabh.smable3.entity.BleMatchRecordTeam;
import com.szabh.smable3.entity.BleWeather;
import java.util.List;

/* loaded from: classes12.dex */
public final class MatchRecordConverter {
    @TypeConverter
    @oOoXoXO
    public final String stopWatchListToString(@oOoXoXO List<Integer> list) {
        if (list != null) {
            return new Gson().toJson(list);
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final List<Integer> stringToStopWatchList(@oOoXoXO String str) {
        if (!TextUtils.isEmpty(str)) {
            return (List) new Gson().fromJson(str, new TypeToken<List<? extends Integer>>() { // from class: com.sma.smartv3.db.entity.MatchRecordConverter$stringToStopWatchList$listType$1
            }.getType());
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final BleMatchRecordTeam stringToTeamInfo(@oOoXoXO String str) {
        if (!TextUtils.isEmpty(str)) {
            return (BleMatchRecordTeam) new Gson().fromJson(str, BleMatchRecordTeam.class);
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final BleWeather stringToWeather(@oOoXoXO String str) {
        if (!TextUtils.isEmpty(str)) {
            return (BleWeather) new Gson().fromJson(str, BleWeather.class);
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final String teamInfoToString(@oOoXoXO BleMatchRecordTeam bleMatchRecordTeam) {
        if (bleMatchRecordTeam != null) {
            return new Gson().toJson(bleMatchRecordTeam);
        }
        return null;
    }

    @TypeConverter
    @oOoXoXO
    public final String weatherToString(@oOoXoXO BleWeather bleWeather) {
        if (bleWeather != null) {
            return new Gson().toJson(bleWeather);
        }
        return null;
    }
}
