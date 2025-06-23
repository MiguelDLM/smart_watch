package com.kwad.sdk.g.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bh;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String aJm;
    public String aJn;
    public String aJo;
    public long aJp;
    public boolean aJq;
    public String akB;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Jf() {
        return this.aJp;
    }

    public final void aG(long j) {
        this.aJp = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bh.isEquals(this.aJm, bVar.aJm) && bh.isEquals(this.akB, bVar.akB) && bh.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.aJm);
        sb.append("_");
        sb.append(this.akB);
        sb.append("_");
        sb.append(this.version);
        if (TextUtils.isEmpty(sb.toString())) {
            return super.hashCode();
        }
        return sb.toString().hashCode();
    }

    public final boolean isValid() {
        if (!TextUtils.isEmpty(this.aJm) && !TextUtils.isEmpty(this.packageUrl) && !TextUtils.isEmpty(this.version) && !TextUtils.isEmpty(this.aJn)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aJm + "', zipFileName='" + this.aJn + "', zipPath='" + this.aJo + "', startDownloadTime=" + this.aJp + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.akB + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aJq + '}';
    }
}
