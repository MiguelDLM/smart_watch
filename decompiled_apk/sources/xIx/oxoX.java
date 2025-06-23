package xIx;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class oxoX extends JSONObject {

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f34329I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public JSONObject f34330II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public JSONObject f34331oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public String f34332oxoX;

        public oIX0oI I0Io(JSONObject jSONObject) {
            this.f34331oIX0oI = jSONObject;
            return this;
        }

        public oIX0oI II0xO0(String str) {
            this.f34329I0Io = str;
            return this;
        }

        public oIX0oI Oxx0IOOO(String str) {
            this.f34332oxoX = str;
            return this;
        }

        public oxoX oxoX() {
            return new oxoX(this);
        }
    }

    public oxoX(oIX0oI oix0oi) {
        try {
            put("pid", oix0oi.f34332oxoX);
            put("nameSpace", oix0oi.f34329I0Io);
            put("macroArgs", oix0oi.f34330II0xO0);
            put("utArgs", oix0oi.f34331oIX0oI);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject II0xO0() {
        return optJSONObject("macroArgs");
    }

    public JSONObject oIX0oI() {
        return optJSONObject("utArgs");
    }

    public oxoX(String str) throws JSONException {
        super(str);
    }
}
