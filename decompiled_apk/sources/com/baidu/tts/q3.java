package com.baidu.tts;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.SqlTool;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class q3 implements Callable<ModelFileBags> {

    /* renamed from: a, reason: collision with root package name */
    public Set<String> f10158a;
    public e1 b;

    public q3(e1 e1Var, Set<String> set) {
        this.f10158a = set;
        this.b = e1Var;
    }

    @Override // java.util.concurrent.Callable
    public ModelFileBags call() throws Exception {
        List<Map<String, String>> list;
        e1 e1Var = this.b;
        Set<String> set = this.f10158a;
        e1Var.getClass();
        if (set != null && !set.isEmpty()) {
            String[] fromSetToArray = DataTool.fromSetToArray(set);
            list = e1Var.a("select * from modelFile where " + SqlTool.buildInCondition("id", fromSetToArray), fromSetToArray);
        } else {
            list = null;
        }
        ModelFileBags modelFileBags = new ModelFileBags();
        modelFileBags.setList(list);
        return modelFileBags;
    }
}
