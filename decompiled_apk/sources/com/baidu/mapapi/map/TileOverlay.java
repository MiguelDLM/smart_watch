package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes7.dex */
public final class TileOverlay {
    private static final String b = "TileOverlay";
    private static int f;

    /* renamed from: a, reason: collision with root package name */
    BaiduMap f5867a;
    private TileProvider g;
    private HashMap<String, Tile> d = new HashMap<>();
    private HashSet<String> e = new HashSet<>();
    private ExecutorService c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f5867a = baiduMap;
        this.g = tileProvider;
    }

    public boolean clearTileCache() {
        BaiduMap baiduMap = this.f5867a;
        if (baiduMap == null) {
            return false;
        }
        return baiduMap.b();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.f5867a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }

    private synchronized boolean b(String str) {
        return this.e.contains(str);
    }

    private synchronized void c(String str) {
        this.e.add(str);
    }

    private synchronized Tile a(String str) {
        if (!this.d.containsKey(str)) {
            return null;
        }
        Tile tile = this.d.get(str);
        this.d.remove(str);
        return tile;
    }

    public void b() {
        this.c.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.d.put(str, tile);
    }

    public synchronized void a() {
        Logger.logE(b, "clearTaskSet");
        this.e.clear();
        this.d.clear();
    }

    public Tile a(int i, int i2, int i3) {
        String str = i + "_" + i2 + "_" + i3;
        Tile a2 = a(str);
        if (a2 != null) {
            return a2;
        }
        BaiduMap baiduMap = this.f5867a;
        if (baiduMap != null && f == 0) {
            WinRound winRound = baiduMap.getMapStatus().f5826a.j;
            f = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.d.size() > f) {
            a();
        }
        if (b(str) || this.c.isShutdown()) {
            return null;
        }
        try {
            c(str);
            this.c.execute(new al(this, i, i2, i3, str));
            return null;
        } catch (RejectedExecutionException unused) {
            Log.e(b, "ThreadPool excepiton");
            return null;
        } catch (Exception unused2) {
            Log.e(b, "fileDir is not legal");
            return null;
        }
    }
}
