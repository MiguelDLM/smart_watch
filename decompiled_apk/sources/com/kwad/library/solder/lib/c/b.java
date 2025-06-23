package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes11.dex */
public final class b implements Comparable<b> {
    public boolean JE;
    public String akV;
    public String akW;
    public long akX;
    public String akY;
    public String aky;
    public boolean akz;
    public List<String> alc;
    public List<String> ald;
    public ClassLoader ale;
    public String version;
    public boolean akZ = false;
    public boolean ala = true;
    public HashMap<String, String> alb = new HashMap<>(10);

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.akV + "', version='" + this.version + "', downloadUrl='" + this.akW + "', fileSize=" + this.akX + ", enable=" + this.JE + ", md5sum='" + this.akY + "', onlyWifiDownload=" + this.akZ + ", onlyWifiRetryDownload=" + this.ala + ", soMd5s=" + this.alb + ", hostPackages=" + this.alc + ", hostInterfaces=" + this.ald + '}';
    }
}
