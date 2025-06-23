package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5888a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ TileOverlay e;

    public al(TileOverlay tileOverlay, int i, int i2, int i3, String str) {
        this.e = tileOverlay;
        this.f5888a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TileProvider tileProvider;
        String str;
        HashSet hashSet;
        String str2;
        tileProvider = this.e.g;
        Tile tile = ((FileTileProvider) tileProvider).getTile(this.f5888a, this.b, this.c);
        if (tile == null) {
            str = TileOverlay.b;
            Log.e(str, "FileTile pic is null");
        } else if (tile.width != 256 || tile.height != 256) {
            str2 = TileOverlay.b;
            Log.e(str2, "FileTile pic must be 256 * 256");
        } else {
            this.e.a(this.f5888a + "_" + this.b + "_" + this.c, tile);
        }
        hashSet = this.e.e;
        hashSet.remove(this.d);
    }
}
