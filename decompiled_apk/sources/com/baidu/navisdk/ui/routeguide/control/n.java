package com.baidu.navisdk.ui.routeguide.control;

import XIXIX.OOXIXo;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes8.dex */
public class n {
    private static final String f = "n";
    public static n g = null;
    public static boolean h = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8567a = false;
    public ArrayList<Integer> b = new ArrayList<>();
    private Random c = new Random();
    private int d = 0;
    private boolean e = true;

    public static n d() {
        if (g == null) {
            g = new n();
        }
        return g;
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(RGLaneInfoModel.TAG, "handleSimulateHide");
        }
        RGLaneInfoModel model = RGLaneInfoModel.getModel(false);
        if (model != null) {
            model.isShow = false;
        }
        d().b.clear();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(7, false, 2);
    }

    public void b() {
        int i;
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d() && h) {
            int i2 = 0;
            if (this.e) {
                int i3 = this.d + 1;
                this.d = i3;
                if (i3 >= 12) {
                    this.d = 12;
                    this.e = false;
                }
            } else {
                int i4 = this.d - 1;
                this.d = i4;
                if (i4 <= 0) {
                    this.d = 0;
                    this.e = true;
                }
            }
            int i5 = this.d;
            if (i5 > 0) {
                RGLaneInfoModel model = RGLaneInfoModel.getModel(true);
                model.isShow = false;
                model.isLaneShow = true;
                model.mID = 101;
                model.mLineNumber = i5;
                model.mRemainDist = 11;
                model.mStartDist = 101;
                model.mX = OOXIXo.f3760XO;
                model.mY = OOXIXo.f3760XO;
                RGLineItem[] rGLineItemArr = new RGLineItem[i5];
                while (i2 < i5) {
                    if (i2 % 4 == 0) {
                        rGLineItemArr[i2] = new RGLineItem(this.c.nextBoolean(), false, true, true, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false);
                        i = i5;
                    } else if (i2 % 2 == 0) {
                        i = i5;
                        rGLineItemArr[i2] = new RGLineItem(this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), false, false, true, false, false, false, false, false, false, false, false);
                    } else {
                        i = i5;
                        rGLineItemArr[i2] = new RGLineItem(this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean(), this.c.nextBoolean());
                    }
                    i2++;
                    i5 = i;
                }
                model.mLaneLineList = rGLineItemArr;
                model.cloneData(rGLineItemArr);
                a(model);
                return;
            }
            a();
        }
    }

    public void c() {
        this.b.clear();
        RGLaneInfoModel rGLaneInfoModel = RGLaneInfoModel.mInstance;
        if (rGLaneInfoModel != null) {
            rGLaneInfoModel.isLaneShow = false;
            rGLaneInfoModel.isShow = false;
        }
    }

    public void a(RGLaneInfoModel rGLaneInfoModel) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(f, "handleShowMessage");
        }
        if (rGLaneInfoModel == null) {
            return;
        }
        if (!BNCommSettingManager.getInstance().isShowLaneLine()) {
            if (gVar.d()) {
                gVar.e(f, "handleLaneLineShowMessage: user closed");
            }
            rGLaneInfoModel.isShow = false;
            return;
        }
        rGLaneInfoModel.initMap();
        rGLaneInfoModel.isShow = true;
        if (!rGLaneInfoModel.isLaneShow) {
            if (gVar.d()) {
                gVar.e(f, "handleShowMessage isLaneShow " + rGLaneInfoModel.isLaneShow);
                return;
            }
            return;
        }
        if (rGLaneInfoModel.mLineNumber > 14) {
            rGLaneInfoModel.mLineNumber = 14;
        }
        rGLaneInfoModel.mImageIdList.clear();
        for (int i = 0; i < rGLaneInfoModel.mLineNumber; i++) {
            rGLaneInfoModel.mImageIdList.add(Integer.valueOf(rGLaneInfoModel.getImageIDFromItem(rGLaneInfoModel.mLaneLineList[i])));
        }
        if (!b(rGLaneInfoModel)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(f, "update, not show");
                return;
            }
            return;
        }
        d().b.clear();
        Iterator<Integer> it = rGLaneInfoModel.mImageIdList.iterator();
        while (it.hasNext()) {
            d().b.add(it.next());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b(rGLaneInfoModel.mImageIdList);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(rGLaneInfoModel.mImageIdList);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(7, true, 2);
    }

    private boolean b(RGLaneInfoModel rGLaneInfoModel) {
        ArrayList<Integer> arrayList;
        if (rGLaneInfoModel == null) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k() || (arrayList = rGLaneInfoModel.mImageIdList) == null || this.b == null || arrayList.size() != this.b.size()) {
            return true;
        }
        for (int i = 0; i < rGLaneInfoModel.mImageIdList.size(); i++) {
            if (rGLaneInfoModel.mImageIdList.get(i).intValue() != this.b.get(i).intValue()) {
                return true;
            }
        }
        return false;
    }
}
