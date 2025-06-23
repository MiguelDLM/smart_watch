package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.IBasicCPUAggregation;
import com.baidu.mobads.sdk.internal.au;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class NativeCPUAggregationData implements IBasicCPUAggregation {
    private static final String CLASS_NAME = x.o;
    private final ClassLoader mClassLoader;
    private IBasicCPUAggregation.ICpuHotNativeStatus mCpuNativeStatusCBListener;
    private final Context mCtx;
    public Object mInstance;
    private final HashMap<String, Object> mSettings;
    public au remoteUtils;

    public NativeCPUAggregationData(Context context, Object obj, HashMap<String, Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = au.a(context, CLASS_NAME);
        this.mClassLoader = bu.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickView(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "handleClickView", view);
    }

    private void onImpression(View view) {
        HashMap<String, Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    private void setStatusListener(IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        this.mCpuNativeStatusCBListener = iCpuHotNativeStatus;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.mClassLoader, new Class[]{av.a(x.p, this.mClassLoader)}, new InvocationHandler() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.2
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (NativeCPUAggregationData.this.mCpuNativeStatusCBListener != null && method != null && "onNotifyPerformance".equals(method.getName()) && objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                        NativeCPUAggregationData.this.mCpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
                    }
                    return null;
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getContentId() {
        Object b = this.remoteUtils.b(this.mInstance, "getContentId", new Object[0]);
        if (b instanceof String) {
            return (String) b;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public List<String> getImagesList() {
        Object b = this.remoteUtils.b(this.mInstance, "getImagesList", new Object[0]);
        if (b instanceof List) {
            return (List) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getLongTitle() {
        Object b = this.remoteUtils.b(this.mInstance, "getLongTitle", new Object[0]);
        if (b instanceof String) {
            return (String) b;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getShortTitle() {
        Object b = this.remoteUtils.b(this.mInstance, "getShortTitle", new Object[0]);
        if (b instanceof String) {
            return (String) b;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public String getTitle() {
        Object b = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
        if (b instanceof String) {
            return (String) b;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUAggregation
    public void registerViewForInteraction(View view, List<View> list, IBasicCPUAggregation.ICpuHotNativeStatus iCpuHotNativeStatus) {
        setStatusListener(iCpuHotNativeStatus);
        onImpression(view);
        if (list != null && list.size() > 0) {
            for (final View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            NativeCPUAggregationData.this.handleClickView(view3);
                            view2.setClickable(false);
                            view2.postDelayed(new Runnable() { // from class: com.baidu.mobads.sdk.api.NativeCPUAggregationData.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    View view4 = view2;
                                    if (view4 != null) {
                                        view4.setClickable(true);
                                    }
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        }
    }
}
