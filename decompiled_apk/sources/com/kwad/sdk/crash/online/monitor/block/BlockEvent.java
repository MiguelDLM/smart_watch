package com.kwad.sdk.crash.online.monitor.block;

import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* loaded from: classes11.dex */
public class BlockEvent extends com.kwad.sdk.core.response.a.a {
    public long blockTimeThreshold;
    public long blockDuration = 0;
    public long blockLoopInterval = 100;
    public long calcBlockOverhead = 0;
    public String currentActivity = "";
    public String processName = "";
    public List<a> stackTraceSample = new ArrayList();

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long aHN;
        public boolean aHO = false;
        public String aHP;
        public long aHQ;
        public int repeatCount;
    }
}
