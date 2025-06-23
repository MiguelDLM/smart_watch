package com.baidu.ar;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class ec {
    protected String qu = "animation_operation";
    protected a qv = new a();

    /* loaded from: classes7.dex */
    public static class a {
        private String qx;
        private String qw = "avatar";
        private int repeatCount = 0;
        private String qy = "play";
        private int qz = 1;

        public void as(String str) {
            this.qx = str;
        }

        public void at(String str) {
            this.qy = str;
        }

        public String dv() {
            return this.qw;
        }

        public String dw() {
            return this.qx;
        }

        public String dx() {
            return this.qy;
        }

        public int dy() {
            return this.qz;
        }

        public int getRepeatCount() {
            return this.repeatCount;
        }

        public void setRepeatCount(int i) {
            this.repeatCount = i;
        }

        public void x(int i) {
            this.qz = i;
        }
    }

    public ec aq(String str) {
        this.qv.as(str);
        return this;
    }

    public ec ar(String str) {
        this.qv.at(str);
        return this;
    }

    public HashMap<String, Object> du() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", this.qu);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("node", this.qv.dv());
        hashMap2.put("repeat_count", Integer.valueOf(this.qv.getRepeatCount()));
        hashMap2.put("chip", this.qv.dw());
        hashMap2.put("operation", this.qv.dx());
        hashMap2.put("anim_or_emotion", Integer.valueOf(this.qv.dy()));
        hashMap.put("event_data", hashMap2);
        return hashMap;
    }

    public ec v(int i) {
        this.qv.setRepeatCount(i);
        return this;
    }

    public ec w(int i) {
        this.qv.x(i);
        return this;
    }
}
