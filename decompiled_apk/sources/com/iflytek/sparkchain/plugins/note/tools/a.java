package com.iflytek.sparkchain.plugins.note.tools;

import com.iflytek.sparkchain.plugins.base.BaseTool;

/* loaded from: classes10.dex */
public class a extends BaseTool {
    public a() {
        init();
    }

    private void init() {
        this.description = "记录备忘录。";
        this.name = NotePlugin.NoteTool;
        this.argsSchema = new com.iflytek.sparkchain.plugins.iflb.ifla.a();
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        return toResult(obj.toString(), 0, "do note success!");
    }
}
