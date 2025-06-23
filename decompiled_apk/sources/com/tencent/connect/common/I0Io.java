package com.tencent.connect.common;

import XxXX.Oxx0IOOO;
import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static I0Io f26725II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<String, oIX0oI> f26726oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public o0Oo.II0xO0 f26728II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f26729oIX0oI;

        public oIX0oI(int i, o0Oo.II0xO0 iI0xO0) {
            this.f26729oIX0oI = i;
            this.f26728II0xO0 = iI0xO0;
        }
    }

    public I0Io() {
        Map<String, oIX0oI> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f26726oIX0oI = synchronizedMap;
        if (synchronizedMap == null) {
            this.f26726oIX0oI = Collections.synchronizedMap(new HashMap());
        }
    }

    public static I0Io II0xO0() {
        if (f26725II0xO0 == null) {
            f26725II0xO0 = new I0Io();
        }
        return f26725II0xO0;
    }

    public o0Oo.II0xO0 I0Io(String str) {
        oIX0oI oix0oi;
        if (str == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f26726oIX0oI) {
            oix0oi = this.f26726oIX0oI.get(str);
            this.f26726oIX0oI.remove(str);
        }
        if (oix0oi == null) {
            return null;
        }
        return oix0oi.f26728II0xO0;
    }

    public Object II0XooXoX(String str, o0Oo.II0xO0 iI0xO0) {
        oIX0oI put;
        int oIX0oI2 = Oxx0IOOO.oIX0oI(str);
        if (oIX0oI2 == -1) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f26726oIX0oI) {
            put = this.f26726oIX0oI.put(str, new oIX0oI(oIX0oI2, iI0xO0));
        }
        if (put == null) {
            return null;
        }
        return put.f26728II0xO0;
    }

    public Object Oxx0IOOO(int i, o0Oo.II0xO0 iI0xO0) {
        oIX0oI put;
        String oxoX2 = Oxx0IOOO.oxoX(i);
        if (oxoX2 == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.f26726oIX0oI) {
            put = this.f26726oIX0oI.put(oxoX2, new oIX0oI(i, iI0xO0));
        }
        if (put == null) {
            return null;
        }
        return put.f26728II0xO0;
    }

    public void X0o0xo(Intent intent, o0Oo.II0xO0 iI0xO0) {
        String str;
        xxIXOIIO.oOoXoXO("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iI0xO0.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(II0xO0.f26845oOo);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(II0xO0.f26739IIX0, 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra(II0xO0.f26765O0X);
                if (stringExtra2 != null) {
                    try {
                        iI0xO0.onComplete(com.tencent.open.utils.II0xO0.xXxxox0I(stringExtra2));
                        return;
                    } catch (JSONException e) {
                        iI0xO0.oIX0oI(new o0Oo.I0Io(-4, II0xO0.f26896xXOx, stringExtra2));
                        xxIXOIIO.xxIXOIIO("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        return;
                    }
                }
                xxIXOIIO.XO("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iI0xO0.onComplete(new JSONObject());
                return;
            }
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
            iI0xO0.oIX0oI(new o0Oo.I0Io(intExtra, intent.getStringExtra(II0xO0.f26893xOoOIoI), intent.getStringExtra(II0xO0.f26786Ox0O)));
            return;
        }
        if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra3)) {
                iI0xO0.onCancel();
                return;
            }
            if ("error".equals(stringExtra3)) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(-6, "unknown error", stringExtra4 + ""));
                return;
            }
            if ("complete".equals(stringExtra3)) {
                try {
                    if (stringExtra4 == null) {
                        str = "{\"ret\": 0}";
                    } else {
                        str = stringExtra4;
                    }
                    iI0xO0.onComplete(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    iI0xO0.oIX0oI(new o0Oo.I0Io(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean XO(int i, int i2, Intent intent, o0Oo.II0xO0 iI0xO0) {
        String str;
        xxIXOIIO.oOoXoXO("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        o0Oo.II0xO0 oxoX2 = oxoX(i);
        if (oxoX2 == null) {
            if (iI0xO0 != null) {
                oxoX2 = oIX0oI(i, iI0xO0);
            } else {
                xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i2 == -1) {
            if (intent == null) {
                oxoX2.oIX0oI(new o0Oo.I0Io(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
                return true;
            }
            String stringExtra = intent.getStringExtra(II0xO0.f26845oOo);
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra(II0xO0.f26739IIX0, 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra(II0xO0.f26765O0X);
                    if (stringExtra2 != null) {
                        try {
                            oxoX2.onComplete(com.tencent.open.utils.II0xO0.xXxxox0I(stringExtra2));
                        } catch (JSONException e) {
                            oxoX2.oIX0oI(new o0Oo.I0Io(-4, II0xO0.f26896xXOx, stringExtra2));
                            xxIXOIIO.xxIXOIIO("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        }
                    } else {
                        xxIXOIIO.XO("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                        oxoX2.onComplete(new JSONObject());
                    }
                } else {
                    xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                    oxoX2.oIX0oI(new o0Oo.I0Io(intExtra, intent.getStringExtra(II0xO0.f26893xOoOIoI), intent.getStringExtra(II0xO0.f26786Ox0O)));
                }
            } else if (!"action_share".equals(stringExtra) && !"action_request_avatar".equals(stringExtra) && !"action_request_dynamic_avatar".equals(stringExtra) && !"action_request_set_emotion".equals(stringExtra)) {
                int intExtra2 = intent.getIntExtra(II0xO0.f26739IIX0, 0);
                if (intExtra2 == 0) {
                    String stringExtra3 = intent.getStringExtra(II0xO0.f26765O0X);
                    if (stringExtra3 != null) {
                        try {
                            oxoX2.onComplete(com.tencent.open.utils.II0xO0.xXxxox0I(stringExtra3));
                        } catch (JSONException unused) {
                            oxoX2.oIX0oI(new o0Oo.I0Io(-4, II0xO0.f26896xXOx, stringExtra3));
                        }
                    } else {
                        oxoX2.onComplete(new JSONObject());
                    }
                } else {
                    oxoX2.oIX0oI(new o0Oo.I0Io(intExtra2, intent.getStringExtra(II0xO0.f26893xOoOIoI), intent.getStringExtra(II0xO0.f26786Ox0O)));
                }
            } else {
                String stringExtra4 = intent.getStringExtra("result");
                String stringExtra5 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra4)) {
                    oxoX2.onCancel();
                } else if ("error".equals(stringExtra4)) {
                    oxoX2.oIX0oI(new o0Oo.I0Io(-6, "unknown error", stringExtra5 + ""));
                } else if ("complete".equals(stringExtra4)) {
                    try {
                        if (stringExtra5 == null) {
                            str = "{\"ret\": 0}";
                        } else {
                            str = stringExtra5;
                        }
                        oxoX2.onComplete(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        oxoX2.oIX0oI(new o0Oo.I0Io(-4, "json error", stringExtra5 + ""));
                    }
                }
            }
        } else {
            oxoX2.onCancel();
        }
        return true;
    }

    public final o0Oo.II0xO0 oIX0oI(int i, o0Oo.II0xO0 iI0xO0) {
        if (i == 11101) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iI0xO0;
    }

    public o0Oo.II0xO0 oxoX(int i) {
        String oxoX2 = Oxx0IOOO.oxoX(i);
        if (oxoX2 == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
            return null;
        }
        return I0Io(oxoX2);
    }
}
