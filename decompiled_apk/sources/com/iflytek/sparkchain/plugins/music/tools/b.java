package com.iflytek.sparkchain.plugins.music.tools;

import com.iflytek.sparkchain.plugins.base.BaseTool;

/* loaded from: classes10.dex */
public class b extends BaseTool {
    public b() {
        a();
    }

    private void a() {
        this.name = MusicPlugin.PlayMusic;
        this.description = "歌曲播放器。播放指定歌曲";
        this.argsSchema = new com.iflytek.sparkchain.plugins.music.ifla.b();
        this.isDirect = true;
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        return toResult(obj.toString(), 0, "do music success!");
    }
}
