package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public class LocationOverlay extends InnerOverlay {

    /* renamed from: a, reason: collision with root package name */
    private AppBaseMap f9610a;

    public LocationOverlay() {
        super(7);
    }

    public void beginLocationLayerAnimation() {
        this.f9610a.BeginLocationLayerAnimation();
    }

    public void clearLocationLayerData(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("locationaddr", this.mLayerID);
        this.f9610a.ClearLocationLayerData(bundle);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean getDefaultShowStatus() {
        return true;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        return "location";
    }

    public void setLocationLayerData(List<OverlayLocationData> list) {
        Bundle bundle;
        Bundle bundle2;
        List<OverlayLocationData> list2 = list;
        if (list2 != null && list.size() > 0 && this.mLayerID != 0) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("locationaddr", this.mLayerID);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < list.size()) {
                OverlayLocationData overlayLocationData = list2.get(i);
                if (overlayLocationData.getImgType() == "arrowicon") {
                    if (overlayLocationData.getImage() != null) {
                        ParcelItem parcelItem = new ParcelItem();
                        Bitmap image = overlayLocationData.getImage();
                        Bundle bundle4 = new Bundle();
                        ByteBuffer allocate = ByteBuffer.allocate(image.getWidth() * image.getHeight() * 4);
                        image.copyPixelsToBuffer(allocate);
                        bundle4.putByteArray("imgbin", allocate.array());
                        bundle4.putInt(IAdInterListener.AdReqParam.WIDTH, overlayLocationData.getImgWidth());
                        bundle4.putInt(IAdInterListener.AdReqParam.HEIGHT, overlayLocationData.getImgHeight());
                        bundle4.putInt("len", image.getWidth() * image.getHeight() * 4);
                        bundle4.putInt("rotation", 1);
                        bundle4.putString("imgtype", overlayLocationData.getImgType());
                        bundle4.putString("name", overlayLocationData.getImgName());
                        bundle4.putFloat("arrowsize", overlayLocationData.getArrowSize());
                        parcelItem.setBundle(bundle4);
                        arrayList.add(parcelItem);
                    }
                } else {
                    if (overlayLocationData.getImgType() == com.huawei.openalliance.ad.constant.x.cD) {
                        if (overlayLocationData.getImage() != null) {
                            ParcelItem parcelItem2 = new ParcelItem();
                            Bitmap image2 = overlayLocationData.getImage();
                            Bundle bundle5 = new Bundle();
                            bundle2 = bundle3;
                            ByteBuffer allocate2 = ByteBuffer.allocate(image2.getWidth() * image2.getHeight() * 4);
                            image2.copyPixelsToBuffer(allocate2);
                            bundle5.putByteArray("imgbin", allocate2.array());
                            bundle5.putInt(IAdInterListener.AdReqParam.WIDTH, overlayLocationData.getImgWidth());
                            bundle5.putInt(IAdInterListener.AdReqParam.HEIGHT, overlayLocationData.getImgHeight());
                            bundle5.putInt("len", image2.getWidth() * image2.getHeight() * 4);
                            bundle5.putInt("rotation", overlayLocationData.isRotation());
                            bundle5.putInt("animation", overlayLocationData.isAnimation());
                            bundle5.putString("imgtype", overlayLocationData.getImgType());
                            bundle5.putString("name", overlayLocationData.getImgName());
                            bundle5.putFloat("markersize", overlayLocationData.getMarkerSize());
                            parcelItem2.setBundle(bundle5);
                            arrayList.add(parcelItem2);
                        }
                    } else {
                        bundle2 = bundle3;
                        if (overlayLocationData.getImgType() == "gificon") {
                            if (overlayLocationData.getGIFImgPath() != null) {
                                ParcelItem parcelItem3 = new ParcelItem();
                                Bundle bundle6 = new Bundle();
                                bundle6.putInt("rotation", overlayLocationData.isRotation());
                                bundle6.putInt("animation", overlayLocationData.isAnimation());
                                bundle6.putString("gifpath", overlayLocationData.getGIFImgPath());
                                bundle6.putString("imgtype", overlayLocationData.getImgType());
                                bundle6.putString("name", overlayLocationData.getImgName());
                                bundle6.putFloat("markersize", overlayLocationData.getMarkerSize());
                                parcelItem3.setBundle(bundle6);
                                arrayList.add(parcelItem3);
                            }
                        } else {
                            if (overlayLocationData.getImage() == null) {
                                return;
                            }
                            ParcelItem parcelItem4 = new ParcelItem();
                            Bitmap image3 = overlayLocationData.getImage();
                            Bundle bundle7 = new Bundle();
                            ByteBuffer allocate3 = ByteBuffer.allocate(image3.getWidth() * image3.getHeight() * 4);
                            image3.copyPixelsToBuffer(allocate3);
                            byte[] array = allocate3.array();
                            bundle7.putByteArray("imgbin", array);
                            bundle7.putInt(IAdInterListener.AdReqParam.WIDTH, overlayLocationData.getImgWidth());
                            bundle7.putInt(IAdInterListener.AdReqParam.HEIGHT, overlayLocationData.getImgHeight());
                            bundle7.putInt("rotation", overlayLocationData.isRotation());
                            bundle7.putString("name", overlayLocationData.getImgName() + "_" + Arrays.hashCode(array));
                            parcelItem4.setBundle(bundle7);
                            arrayList.add(parcelItem4);
                        }
                    }
                    i++;
                    list2 = list;
                    bundle3 = bundle2;
                }
                bundle2 = bundle3;
                i++;
                list2 = list;
                bundle3 = bundle2;
            }
            Bundle bundle8 = bundle3;
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                }
                bundle = bundle8;
                bundle.putParcelableArray("imagedata", parcelItemArr);
            } else {
                bundle = bundle8;
            }
            this.f9610a.SetLocationLayerData(bundle);
        }
    }

    public LocationOverlay(AppBaseMap appBaseMap) {
        super(7, appBaseMap);
        this.f9610a = appBaseMap;
    }
}
