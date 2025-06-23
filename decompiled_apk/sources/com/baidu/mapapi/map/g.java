package com.baidu.mapapi.map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements com.baidu.platform.comapi.map.al {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5899a;

    public g(BaiduMap baiduMap) {
        this.f5899a = baiduMap;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000b */
    @Override // com.baidu.platform.comapi.map.al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r4) {
        /*
            r3 = this;
            r0 = 0
        L1:
            com.baidu.mapapi.map.BaiduMap r1 = r3.f5899a
            java.util.concurrent.CopyOnWriteArrayList r1 = com.baidu.mapapi.map.BaiduMap.i(r1)
            int r1 = r1.size()
            if (r0 >= r1) goto L37
            com.baidu.mapapi.map.BaiduMap r1 = r3.f5899a
            java.util.concurrent.CopyOnWriteArrayList r1 = com.baidu.mapapi.map.BaiduMap.i(r1)
            java.lang.Object r1 = r1.get(r0)
            com.baidu.mapapi.map.Building r1 = (com.baidu.mapapi.map.Building) r1
            int r1 = r1.getBuildingId()
            if (r1 != r4) goto L34
            com.baidu.mapapi.map.BaiduMap r1 = r3.f5899a
            com.baidu.mapapi.map.Building3DListener r1 = com.baidu.mapapi.map.BaiduMap.k(r1)
            com.baidu.mapapi.map.BaiduMap r2 = r3.f5899a
            java.util.concurrent.CopyOnWriteArrayList r2 = com.baidu.mapapi.map.BaiduMap.i(r2)
            java.lang.Object r2 = r2.get(r0)
            com.baidu.mapapi.map.Building r2 = (com.baidu.mapapi.map.Building) r2
            r1.onBuildingFloorAnimationStop(r2)
        L34:
            int r0 = r0 + 1
            goto L1
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.g.a(int):void");
    }
}
