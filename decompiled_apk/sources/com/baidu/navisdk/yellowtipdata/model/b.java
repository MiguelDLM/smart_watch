package com.baidu.navisdk.yellowtipdata.model;

import OXOo.OOXIXo;
import com.baidu.entity.pb.NaviRpCloudData;
import com.baidu.entity.pb.cloud_yellow_tips_t;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.yellowtipdata.model.data.d;
import com.baidu.platform.comjni.tools.ProtobufUtils;
import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ArrayList<d>> f9460a;

    public b() {
        new HashMap();
        this.f9460a = new ArrayList<>();
        new ArrayList();
        new ArrayList();
        new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@OXOo.oOoXoXO java.lang.String[] r28, int r29) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.yellowtipdata.model.b.a(java.lang.String[], int):void");
    }

    @OOXIXo
    public final ArrayList<ArrayList<d>> b() {
        List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.f9460a);
        if (o0Xo0XII != null) {
            return (ArrayList) o0Xo0XII;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<com.baidu.navisdk.yellowtipdata.model.data.YellowTipData>>");
    }

    private final NaviRpCloudData b(byte[] bArr) {
        if (bArr == null) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.a()) {
                gVar.a("YellowTipDataParse", "RouteResult core log, parseToNaviRpCloudData --> pb is null, create default card data!!!");
            }
            return null;
        }
        try {
            MessageMicro messageLite = ProtobufUtils.getMessageLite(NaviRpCloudData.class.getSimpleName(), bArr);
            if (messageLite instanceof NaviRpCloudData) {
                return (NaviRpCloudData) messageLite;
            }
        } catch (Exception e) {
            g gVar2 = g.B4NAV;
            if (gVar2.d()) {
                gVar2.c("YellowTipDataParse", "parseToNaviRpCloudData --> e = " + e.getMessage());
            }
        }
        return null;
    }

    public final void a() {
        new HashMap();
        this.f9460a = new ArrayList<>();
        new ArrayList();
        new ArrayList();
        new ArrayList();
    }

    private final cloud_yellow_tips_t a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageMicro messageLite = ProtobufUtils.getMessageLite(cloud_yellow_tips_t.class.getSimpleName(), bArr);
            if (messageLite instanceof cloud_yellow_tips_t) {
                return (cloud_yellow_tips_t) messageLite;
            }
        } catch (Exception e) {
            g gVar = g.B4NAV;
            if (gVar.d()) {
                gVar.c("YellowTipDataRepository", "parseToCloudYellowTip --> e = " + e.getMessage());
            }
        }
        return null;
    }
}
