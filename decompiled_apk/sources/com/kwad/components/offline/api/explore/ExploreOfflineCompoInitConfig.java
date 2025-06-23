package com.kwad.components.offline.api.explore;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.explore.model.ExploreConfig;
import com.kwad.components.offline.api.explore.model.FuncInfo;
import java.util.List;

/* loaded from: classes11.dex */
public interface ExploreOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    Object callMethod(Object obj, String str, Object... objArr);

    Object callStaticMethod(Class<?> cls, String str, Object... objArr);

    boolean classExists(String str);

    List<Object> getAllFieldValue(Object obj);

    String getConfig();

    Object getField(Object obj, String str);

    String getFieldNameByTypeName(Class<?> cls, String str);

    ExploreConfig.TTInjectConfig getInjectConfig(String str);

    String getSdkVersion();

    Object getStaticFieldByTypeName(Class<?> cls, String str);

    boolean hasDowngraded(String str);

    boolean isPrimitive(Object obj);

    void logOnPublish(String str, String str2);

    void onConfigCallback(int i);

    void onLog(String str, String str2);

    void onReport(FuncInfo funcInfo);

    void onTaskReady(Runnable runnable);

    void saveDowngraded(String str);

    void setStaticField(Class<?> cls, String str, Object obj);
}
