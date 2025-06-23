package com.kwad.components.core.k;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat MR = new SimpleDateFormat("yyyy-MM-dd");
    public int MS;
    public long MT;

    public final boolean j(int i, int i2) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.MT > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = MR.format(new Date(this.MT));
            String format2 = MR.format(new Date(currentTimeMillis));
            c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
            if (!format.equals(format2)) {
                this.MS = 0;
                ph();
                return true;
            }
            long j = this.MT + (i * 3600000);
            c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.MS);
            if (j >= currentTimeMillis || this.MS > i2) {
                return false;
            }
            ph();
            return true;
        }
        ph();
        return true;
    }

    public final void ph() {
        this.MT = System.currentTimeMillis();
        this.MS++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.MT + ", currentActiveCount " + this.MS);
    }
}
