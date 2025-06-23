package com.baidu.mapapi.map;

import O0IoXXOx.XO;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class Marker extends Overlay {
    Point B;
    InfoWindow C;
    InfoWindow.a D;
    InfoWindowAdapter J;

    /* renamed from: a, reason: collision with root package name */
    LatLng f5832a;
    BitmapDescriptor b;
    float c;
    float d;
    boolean e;
    boolean f;
    float g;
    String h;
    TitleOptions i;
    int j;
    int k;
    float n;
    int o;
    int u;
    ArrayList<BitmapDescriptor> v;
    Animation x;
    boolean l = false;
    boolean m = false;
    boolean p = false;
    boolean q = true;
    boolean r = false;
    boolean s = false;
    boolean t = false;
    int w = 20;
    float y = 1.0f;
    float z = 1.0f;
    float A = 1.0f;
    boolean E = false;
    int F = Integer.MAX_VALUE;
    int G = 4;
    int H = 22;
    int I = 0;

    public Marker() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
    }

    private void a(InfoWindow infoWindow, InfoWindow infoWindow2) {
        infoWindow.b = infoWindow2.getBitmapDescriptor();
        infoWindow.d = infoWindow2.getPosition();
        infoWindow.f5816a = infoWindow2.getTag();
        infoWindow.c = infoWindow2.getView();
        infoWindow.g = infoWindow2.getYOffset();
        infoWindow.k = infoWindow2.k;
        infoWindow.e = infoWindow2.e;
    }

    public void cancelAnimation() {
        Animation animation = this.x;
        if (animation != null) {
            animation.bdAnimation.b();
        }
    }

    public float getAlpha() {
        return this.n;
    }

    public float getAnchorX() {
        return this.c;
    }

    public float getAnchorY() {
        return this.d;
    }

    public int getEndLevel() {
        return this.H;
    }

    public Point getFixedPosition() {
        return this.B;
    }

    public BitmapDescriptor getIcon() {
        return this.b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.v;
    }

    public String getId() {
        return this.K;
    }

    public InfoWindow getInfoWindow() {
        return this.C;
    }

    public int getPeriod() {
        return this.w;
    }

    public LatLng getPosition() {
        return this.f5832a;
    }

    public int getPriority() {
        return this.F;
    }

    public float getRotate() {
        return this.g;
    }

    public float getScale() {
        return this.A;
    }

    public float getScaleX() {
        return this.y;
    }

    public float getScaleY() {
        return this.z;
    }

    public int getStartLevel() {
        return this.G;
    }

    public String getTitle() {
        return this.h;
    }

    public TitleOptions getTitleOptions() {
        return this.i;
    }

    public int getXOffset() {
        return this.k;
    }

    public int getYOffset() {
        return this.j;
    }

    public void hideInfoWindow() {
        InfoWindow.a aVar = this.D;
        if (aVar != null) {
            aVar.a(this.C);
            this.E = false;
        }
        this.C = null;
    }

    public boolean isClickable() {
        return this.q;
    }

    public boolean isDraggable() {
        return this.f;
    }

    public boolean isFixed() {
        return this.p;
    }

    public boolean isFlat() {
        return this.l;
    }

    public boolean isForceDisplay() {
        return this.t;
    }

    public boolean isInfoWindowEnabled() {
        return this.E;
    }

    public boolean isJoinCollision() {
        return this.r;
    }

    public boolean isPerspective() {
        return this.e;
    }

    public boolean isPoiCollided() {
        return this.s;
    }

    public void poiCollided(boolean z) {
        this.s = z;
    }

    public void setAlpha(float f) {
        if (f >= 0.0f && f <= 1.0d) {
            this.n = f;
            this.listener.c(this);
        } else {
            this.n = 1.0f;
        }
    }

    public void setAnchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.c = f;
            this.d = f2;
            this.listener.c(this);
        }
    }

    public void setAnimateType(int i) {
        this.o = i;
        this.listener.c(this);
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            this.x = animation;
            animation.bdAnimation.a(this, animation);
        }
    }

    public void setClickable(boolean z) {
        this.q = z;
        this.listener.c(this);
    }

    public void setDraggable(boolean z) {
        this.f = z;
        this.listener.c(this);
    }

    public void setEndLevel(int i) {
        this.H = i;
        this.listener.c(this);
    }

    public void setFixedScreenPosition(Point point) {
        if (point != null) {
            this.B = point;
            this.p = true;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
    }

    public void setFlat(boolean z) {
        this.l = z;
        this.listener.c(this);
    }

    public void setForceDisplay(boolean z) {
        this.t = z;
        this.listener.c(this);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.b = bitmapDescriptor;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return;
            }
            if (arrayList.size() == 1) {
                this.b = arrayList.get(0);
            } else {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) == null || arrayList.get(i).f5792a == null) {
                        return;
                    }
                }
                this.v = (ArrayList) arrayList.clone();
                this.b = null;
            }
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
    }

    public void setJoinCollision(boolean z) {
        this.r = z;
        this.listener.c(this);
    }

    public void setPeriod(int i) {
        if (i > 0) {
            this.w = i;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
    }

    public void setPerspective(boolean z) {
        this.e = z;
        this.listener.c(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f5832a = latLng;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public void setPositionWithInfoWindow(LatLng latLng) {
        if (latLng != null) {
            this.f5832a = latLng;
            this.listener.c(this);
            InfoWindow infoWindow = this.C;
            if (infoWindow != null) {
                infoWindow.setPosition(latLng);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public void setPriority(int i) {
        this.F = i;
        this.listener.c(this);
    }

    public void setRotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.g = f % 360.0f;
        this.listener.c(this);
    }

    public void setScale(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.y = f;
        this.z = f;
        this.listener.c(this);
    }

    public void setScaleX(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.y = f;
        this.listener.c(this);
    }

    public void setScaleY(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.z = f;
        this.listener.c(this);
    }

    public void setStartLevel(int i) {
        this.G = i;
        this.listener.c(this);
    }

    public void setTitle(String str) {
        this.h = str;
        this.listener.c(this);
    }

    public void setTitleOptions(TitleOptions titleOptions) {
        this.i = titleOptions;
        this.I = 1;
        this.listener.c(this);
    }

    public void setToTop() {
        this.m = true;
        this.listener.c(this);
    }

    public void setXOffset(int i) {
        this.k = i;
        this.listener.c(this);
    }

    public void setYOffset(int i) {
        this.j = i;
        this.listener.c(this);
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow != null) {
            InfoWindow infoWindow2 = this.C;
            if (infoWindow2 == null) {
                this.C = infoWindow;
            } else {
                InfoWindow.a aVar = this.D;
                if (aVar != null) {
                    aVar.a(infoWindow2);
                }
                a(this.C, infoWindow);
            }
            InfoWindow.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.b(this.C);
                this.E = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
    }

    public void showSmoothMoveInfoWindow(InfoWindow infoWindow) {
        if (infoWindow == null) {
            return;
        }
        if (infoWindow.k) {
            if (infoWindow.c != null) {
                InfoWindow infoWindow2 = this.C;
                if (infoWindow2 == null) {
                    this.C = infoWindow;
                } else {
                    a(infoWindow2, infoWindow);
                }
                InfoWindow infoWindow3 = this.C;
                infoWindow3.j = true;
                InfoWindow.a aVar = this.D;
                if (aVar != null) {
                    aVar.b(infoWindow3);
                    this.E = true;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
        }
        throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
    }

    public void startAnimation() {
        Animation animation = this.x;
        if (animation != null) {
            animation.bdAnimation.a();
        }
    }

    public void updateInfoWindowBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        InfoWindow infoWindow = this.C;
        if (infoWindow != null && !infoWindow.l) {
            infoWindow.setBitmapDescriptor(bitmapDescriptor);
        }
    }

    public void updateInfoWindowPosition(LatLng latLng) {
        InfoWindow infoWindow = this.C;
        if (infoWindow != null) {
            infoWindow.setPosition(latLng);
        }
    }

    public void updateInfoWindowView(View view) {
        InfoWindow infoWindow = this.C;
        if (infoWindow != null && infoWindow.k) {
            infoWindow.setView(view);
        }
    }

    public void updateInfoWindowYOffset(int i) {
        InfoWindow infoWindow = this.C;
        if (infoWindow != null) {
            infoWindow.setYOffset(i);
        }
    }

    public void setAnimation(Animation animation, TypeEvaluator typeEvaluator) {
        if (animation != null) {
            this.x = animation;
            animation.bdAnimation.a(typeEvaluator);
            this.x.bdAnimation.a(this, animation);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Bundle bundle2 = new Bundle();
        BitmapDescriptor bitmapDescriptor = this.b;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.b());
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f5832a);
        bundle.putInt("animatetype", this.o);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("perspective", this.e ? 1 : 0);
        bundle.putFloat("anchor_x", this.c);
        bundle.putFloat("anchor_y", this.d);
        bundle.putFloat("rotate", this.g);
        bundle.putInt("y_offset", this.j);
        bundle.putInt("x_offset", this.k);
        bundle.putInt("isflat", this.l ? 1 : 0);
        bundle.putInt("istop", this.m ? 1 : 0);
        bundle.putInt(TypedValues.CycleType.S_WAVE_PERIOD, this.w);
        bundle.putFloat("alpha", this.n);
        bundle.putInt("m_height", this.u);
        bundle.putFloat("scaleX", this.y);
        bundle.putFloat("scaleY", this.z);
        bundle.putInt("isClickable", this.q ? 1 : 0);
        bundle.putInt("priority", this.F);
        bundle.putInt("isJoinCollision", this.r ? 1 : 0);
        bundle.putInt("isForceDisplay", this.t ? 1 : 0);
        bundle.putInt("startLevel", this.G);
        bundle.putInt("endLevel", this.H);
        Point point = this.B;
        if (point != null) {
            bundle.putInt("fix_x", point.x);
            bundle.putInt("fix_y", this.B.y);
        }
        bundle.putInt("isfixed", this.p ? 1 : 0);
        ArrayList<BitmapDescriptor> arrayList = this.v;
        if (arrayList != null && arrayList.size() > 0) {
            a(this.v, bundle);
        }
        bundle2.putBundle(XO.f1160OOXIXo, bundle);
        TitleOptions titleOptions = this.i;
        if (titleOptions != null) {
            bundle.putBundle("m_title", titleOptions.b());
        }
        bundle.putInt("update", this.I);
        bundle.putInt("poi_collied", this.s ? 1 : 0);
        return bundle;
    }

    public void showInfoWindow() {
        LatLng latLng;
        InfoWindowAdapter infoWindowAdapter = this.J;
        if (infoWindowAdapter == null) {
            Log.e("BDMapSDKException", "Marker showInfoWindow InfoWindowAdapter listener can not be null");
            return;
        }
        InfoWindow infoWindow = infoWindowAdapter.getInfoWindow(this);
        if (infoWindow == null) {
            View infoWindowView = this.J.getInfoWindowView(this);
            int infoWindowViewYOffset = this.J.getInfoWindowViewYOffset();
            if (infoWindowView != null && (latLng = this.f5832a) != null) {
                infoWindow = new InfoWindow(infoWindowView, latLng, infoWindowViewYOffset);
            }
        }
        if (infoWindow != null) {
            InfoWindow infoWindow2 = this.C;
            if (infoWindow2 == null) {
                this.C = infoWindow;
            } else {
                InfoWindow.a aVar = this.D;
                if (aVar != null) {
                    aVar.a(infoWindow2);
                }
                a(this.C, infoWindow);
            }
            InfoWindow.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.b(this.C);
                this.E = true;
            }
        }
    }

    private void a(ArrayList<BitmapDescriptor> arrayList, Bundle bundle) {
        int i;
        MessageDigest messageDigest;
        ArrayList arrayList2 = new ArrayList();
        Iterator<BitmapDescriptor> it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            BitmapDescriptor next = it.next();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle2 = new Bundle();
            Bitmap bitmap = next.f5792a;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            bundle2.putByteArray("image_data", array);
            bundle2.putInt(RouteGuideParams.RGKey.ExpandMap.ImageWidth, bitmap.getWidth());
            bundle2.putInt(RouteGuideParams.RGKey.ExpandMap.ImageHeight, bitmap.getHeight());
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest != null) {
                messageDigest.update(array, 0, array.length);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                while (i < digest.length) {
                    sb.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
                    i++;
                }
                bundle2.putString("image_hashcode", sb.toString());
            }
            parcelItem.setBundle(bundle2);
            arrayList2.add(parcelItem);
        }
        if (arrayList2.size() > 0) {
            ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
            while (i < arrayList2.size()) {
                parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                i++;
            }
            bundle.putParcelableArray("icons", parcelItemArr);
        }
    }
}
