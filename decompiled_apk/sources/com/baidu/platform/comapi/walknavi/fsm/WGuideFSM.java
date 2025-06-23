package com.baidu.platform.comapi.walknavi.fsm;

import android.util.Log;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.walknavi.b;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes8.dex */
public class WGuideFSM extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a, reason: collision with root package name */
    private String f9758a;
    private String b;
    private String c;

    public WGuideFSM() {
        setInitialState("Entry");
        this.c = this.f9758a;
        FSMTable.initTransition();
    }

    private void a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(RGState.PACKAGE_NAME + FileUtils.FILE_EXTENSION_SEPARATOR + RGState.CLASS_PREFIX + str);
            cls.getMethod(str2, null).invoke(cls.newInstance(), null);
        } catch (Exception e) {
            Log.e(WGuideFSM.class.getName(), e.toString());
        }
    }

    private String b(String str) {
        if (RGFSMTable.FsmState.BrowseMap.equals(str)) {
            return this.c;
        }
        return null;
    }

    public static void restoreZoomLevel() {
        int i = com.baidu.platform.comapi.walknavi.b.a.c;
        if (i < 15) {
            i = 15;
        } else if (i > 20) {
            i = 19;
        }
        com.baidu.platform.comapi.walknavi.b.a.c = i;
    }

    public static void saveZoomLevel() {
        int j = (int) b.a().N().j();
        if (j < 15) {
            j = 15;
        } else if (j > 20) {
            j = 19;
        }
        com.baidu.platform.comapi.walknavi.b.a.c = j;
    }

    public String getCurrentEvent() {
        return this.b;
    }

    public String getCurrentState() {
        return this.f9758a;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        FSMTable.release();
    }

    public synchronized void run(String str) {
        try {
            String str2 = this.f9758a;
            String queryDestState = FSMTable.queryDestState(str2, str);
            if (queryDestState != null) {
                this.b = str;
                if (RGFSMTable.FsmState.BACK.equals(queryDestState)) {
                    queryDestState = b(str2);
                }
                a(str2, "exit");
                a(queryDestState, "enter");
                a(queryDestState, "excute");
                this.f9758a = queryDestState;
                a(queryDestState);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void runCurrentState() {
        if (!this.f9758a.equalsIgnoreCase("Entry")) {
            a(this.f9758a, "excute");
        }
    }

    public synchronized void runEntryState() {
        try {
            if (b.a().Q() == 4) {
                this.f9758a = "SegEntry";
            } else {
                this.f9758a = "Entry";
            }
            a(this.f9758a, "excute");
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setInitialState(String str) {
        this.f9758a = str;
    }

    private void a(String str) {
        if (RGFSMTable.FsmState.North2D.equals(str)) {
            this.c = RGFSMTable.FsmState.North2D;
        } else if (RGFSMTable.FsmState.Car3D.equals(str) || "Entry".equals(str)) {
            this.c = RGFSMTable.FsmState.Car3D;
        }
    }
}
