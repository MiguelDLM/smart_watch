package com.baidu.ar;

import java.util.List;

/* loaded from: classes7.dex */
public class jp {
    private List<jn> Be;
    private jo Bf;
    private jq Bg;

    /* loaded from: classes7.dex */
    public enum a {
        MODEL_DISAPPEAR_UNTRACKED,
        MODEL_PERSIST_UNTRACKED,
        MODEL_SHOW_IMMEDIATELY
    }

    public void a(jo joVar) {
        this.Bf = joVar;
    }

    public List<jn> gt() {
        return this.Be;
    }

    public jo gu() {
        return this.Bf;
    }

    public jq gv() {
        return this.Bg;
    }

    public void l(List<jn> list) {
        this.Be = list;
    }

    public void a(jq jqVar) {
        this.Bg = jqVar;
    }
}
