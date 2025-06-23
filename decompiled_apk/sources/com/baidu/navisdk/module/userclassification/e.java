package com.baidu.navisdk.module.userclassification;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface e {
    Set<String> a();

    @AnyThread
    void a(@NonNull Map<String, JSONObject> map, boolean z, long j);
}
