package com.kwad.components.ad.reward.l;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean xD = false;
    protected String xE;
    protected String xF;

    private boolean jx() {
        return this.xD;
    }

    private void jy() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.xD));
    }

    public boolean isCompleted() {
        return jx();
    }

    public final void jt() {
        if (!this.xD) {
            this.xD = true;
            jy();
        }
    }

    public final void ju() {
        if (this.xD) {
            this.xD = false;
            jy();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String jv() {
        return this.xE;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String jw() {
        return this.xF;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xD = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "selfCompleted", this.xD);
        return jSONObject;
    }
}
