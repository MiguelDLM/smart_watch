package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class MediationAdLoaderImpl implements IMediationAdLoader {
    public static final String TAG = "TTMediationSDK";
    public Bridge mGmAdLoader;
    public MediationAdSlotValueSet mSlotValueSet;

    private Field a(Class<?> cls, String str) {
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        }
        return (T) callFunction(i, valueSet, cls);
    }

    public <T> T callFunction(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public String getAdm() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return (String) bridge.call(8137, null, String.class);
        }
        return "";
    }

    public String getAdnId() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getADNId();
        }
        return null;
    }

    public int getBiddingType() {
        Integer num;
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null || (num = (Integer) bridge.call(8226, null, Integer.class)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public Bridge getGMBridge() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null) {
            return null;
        }
        return (Bridge) bridge.call(8127, null, Bridge.class);
    }

    public int getLoadTimeOut() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getAdLoadTimeOut();
        }
        return 3000;
    }

    public Activity getOriginActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (Activity) a(activity, "mOriginActivity");
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getOriginType() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOriginType();
        }
        return 0;
    }

    public String getRitId() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRitId();
        }
        return null;
    }

    public boolean getSplashShakeButton() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isSplashShakeButton();
        }
        return false;
    }

    public boolean hasNotifyFail() {
        Boolean bool;
        Bridge bridge = this.mGmAdLoader;
        if (bridge == null || (bool = (Boolean) bridge.call(8210, null, Boolean.class)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isClientBidding() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8110, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8141, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isServerBidding() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8136, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.mSlotValueSet;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isSplashPreLoad();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationAdLoader
    public final void load(Context context, ValueSet valueSet) {
        MediationAdSlotValueSet create = MediationAdSlotValueSet.create(valueSet);
        this.mSlotValueSet = create;
        this.mGmAdLoader = create.getAdLoaderCallback();
        realLoader(context, create);
    }

    public void notifyAdCache(Bridge bridge, int i, String str) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8303, bridge);
            create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, i);
            create.add(8015, str);
            this.mGmAdLoader.call(8112, create.build(), Void.class);
        }
    }

    public void notifyAdFailed(int i, String str) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, i);
            create.add(8015, str);
            this.mGmAdLoader.call(8108, create.build(), Void.class);
        }
    }

    @Deprecated
    public void notifyAdSuccess(Bridge bridge) {
        if (this.mGmAdLoader != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bridge);
            notifyAdSuccess(arrayList);
        }
    }

    public abstract void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet);

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private Object a(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public void notifyAdSuccess(Bridge bridge, Bridge bridge2) {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8035, bridge);
        bridge2.call(8128, create.build(), Void.class);
        if (this.mGmAdLoader != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bridge2);
            notifyAdSuccess(arrayList);
        }
    }

    private Object a(Object obj, String str) throws IllegalAccessException {
        Field a2 = a(obj.getClass(), str);
        if (a2 != null) {
            return a(a2, obj);
        }
        return null;
    }

    public void notifyAdSuccess(List<Bridge> list) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8303, list);
            this.mGmAdLoader.call(8107, create.build(), Bridge.class);
        }
    }
}
