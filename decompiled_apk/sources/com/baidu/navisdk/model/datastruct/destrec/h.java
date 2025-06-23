package com.baidu.navisdk.model.datastruct.destrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.baidu.entity.pb.SubParkingInfo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class h {

    @OOXIXo
    public static final a e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private String f6923a;
    private int b;
    private int c;
    private int d;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        @x0XOIxOo
        @OOXIXo
        public final h a(@oOoXoXO SubParkingInfo subParkingInfo) {
            h hVar = new h();
            if (subParkingInfo != null) {
                String stringUtf8 = subParkingInfo.getName().toStringUtf8();
                IIX0o.oO(stringUtf8, "it.name.toStringUtf8()");
                hVar.f6923a = stringUtf8;
                hVar.b = subParkingInfo.getParkTotal();
                hVar.c = subParkingInfo.getParkLeft();
                hVar.d = subParkingInfo.getStatus();
            }
            return hVar;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }
}
