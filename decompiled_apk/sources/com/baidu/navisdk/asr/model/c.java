package com.baidu.navisdk.asr.model;

import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f6556a = new JSONObject();

    private String c(String str) {
        try {
            Object obj = this.f6556a.get("client");
            if (obj instanceof JSONObject) {
                return ((JSONObject) obj).getString(str);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public c a(int i) {
        if (i != 16) {
            switch (i) {
                case 1:
                    a("NaviPage", "", "");
                    break;
                case 2:
                    a("RoutePage", "", "light_navi");
                    break;
                case 3:
                    a("RoutePage", "", "navi_commute");
                    break;
                case 4:
                    a("TruckPage", "", "");
                    break;
                case 5:
                    a("MotorPage", "", "");
                    break;
                case 6:
                    a("NewEngPage", "", "");
                    break;
                case 7:
                    a("RoutePage", "RouteResultScene", "car_result");
                    break;
                case 8:
                    a("RoutePage", "MotorRouteResultScene", "motor_result");
                    break;
                case 9:
                    a("RoutePage", "TruckRouteResultScene", "truck_result");
                    break;
            }
        } else {
            a("RoutePage", "NewEngResultScene", "neweng_result");
        }
        return this;
    }

    public c b(Object obj) {
        a("intention", obj);
        return this;
    }

    public c d(Object obj) {
        try {
            this.f6556a.put("node_list", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c e(Object obj) {
        try {
            this.f6556a.put("pgid", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c f(Object obj) {
        try {
            this.f6556a.put("pgname", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c g(Object obj) {
        try {
            this.f6556a.put("pgtype", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c h(Object obj) {
        try {
            this.f6556a.put("prodtype", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c i(Object obj) {
        try {
            this.f6556a.put("navi_route_list", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c j(Object obj) {
        a("sceneid", obj);
        return this;
    }

    public c k(Object obj) {
        try {
            this.f6556a.put("speak_again", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String b() {
        return c("intention");
    }

    public c b(JSONObject jSONObject) {
        try {
            this.f6556a.put("road_info", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c b(String str) {
        a(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, str);
        return this;
    }

    public c c(Object obj) {
        try {
            this.f6556a.put("list", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c a(Object obj, Object obj2, Object obj3) {
        f(obj);
        e(obj2);
        g(obj3);
        return this;
    }

    public c a(String str, Object obj) {
        try {
            Object opt = this.f6556a.opt("client");
            if (opt == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                this.f6556a.put("client", jSONObject);
            } else if (opt instanceof JSONObject) {
                ((JSONObject) opt).put(str, obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c a(Object obj) {
        a("is_ask_type", obj);
        return this;
    }

    public c a(JSONObject jSONObject) {
        try {
            this.f6556a.put("intention_detail", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public c a(String str) {
        a("broad_tts", str);
        return this;
    }

    public String a() {
        return this.f6556a.toString();
    }
}
