package com.baidu.navisdk.ui.routeguide.fsm;

import XXO0.oIX0oI;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.pronavi.state.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.utils.c;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class RouteGuideFSM {
    public static final String TAG = "RouteGuide_FSM";
    private static String mCurrentGlassState;
    private static volatile RouteGuideFSM mInstance;
    private static String mLatestMap2DOr3DState;
    private String mCurrentEvent;
    private String mCurrentState;
    private ArrayList<IFSMDestStateListener> mFsmDestStateListeners;
    private a mUiState;
    private boolean mInited = false;
    private final List<String> mBackStates = new ArrayList();
    private boolean mSetFullViewByUser = false;
    private final RGFSMFactory mFsmFactory = new RGFSMFactory();

    /* loaded from: classes8.dex */
    public interface IFSMDestStateListener {
        void onDestState(String str, String str2);
    }

    private RouteGuideFSM() {
        setInitialState(RGFSMTable.FsmState.SimpleGuide);
        RGFSMTable.initTransition();
    }

    private boolean backToState(String str) {
        int indexInBackStates = getIndexInBackStates(str);
        if (indexInBackStates < 0) {
            return false;
        }
        for (int size = this.mBackStates.size() - 1; size > indexInBackStates; size--) {
            this.mBackStates.remove(size);
        }
        return true;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (RouteGuideFSM.class) {
                try {
                    if (mInstance != null) {
                        mInstance.dispose();
                        mInstance = null;
                    }
                } finally {
                }
            }
        }
    }

    private void dispose() {
        this.mInited = false;
        mCurrentGlassState = null;
        clearDestStateListener();
        RGFSMTable.destory();
    }

    private void dumpBackStates() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.mBackStates.size(); i++) {
            stringBuffer.append("[");
            stringBuffer.append(this.mBackStates.get(i));
            stringBuffer.append("] -> ");
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, stringBuffer.toString());
        }
    }

    private void filterInvalidState() {
        for (int size = this.mBackStates.size() - 1; size >= 1; size--) {
            if (RGFSMTable.FsmState.EnlargeRoadmap.equals(this.mBackStates.get(size)) && !i.s().k()) {
                this.mBackStates.remove(size);
            }
        }
    }

    public static String getCurrentGlassState() {
        return mCurrentGlassState;
    }

    public static RouteGuideFSM getInstance() {
        if (mInstance == null) {
            synchronized (RouteGuideFSM.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new RouteGuideFSM();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    private void logStateTransition(String str, String str2, String str3) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", (("FSM Transition:(" + str + oIX0oI.I0Io.f4095I0Io) + "   -----  " + str2 + "  ----->   ") + oIX0oI.I0Io.f4096II0xO0 + str3 + oIX0oI.I0Io.f4095I0Io);
        }
    }

    private String popState() {
        if (this.mBackStates.size() == 1) {
            return null;
        }
        List<String> list = this.mBackStates;
        String remove = list.remove(list.size() - 1);
        filterInvalidState();
        return remove;
    }

    private void pushState(String str) {
        if (str != null && str.length() != 0) {
            if (getTopState() == null || !getTopState().equals(str)) {
                this.mBackStates.add(str);
                this.mCurrentState = str;
            }
        }
    }

    public void addDestStateListener(IFSMDestStateListener iFSMDestStateListener) {
        if (this.mFsmDestStateListeners == null) {
            this.mFsmDestStateListeners = new ArrayList<>();
        }
        this.mFsmDestStateListeners.add(iFSMDestStateListener);
    }

    public void cacheBackMapState(String str) {
        if (str != null && str.length() != 0) {
            mCurrentGlassState = str;
            if (RGFSMTable.FsmState.North2D.equals(str)) {
                mLatestMap2DOr3DState = RGFSMTable.FsmState.North2D;
            } else if (RGFSMTable.FsmState.Car3D.equals(str)) {
                mLatestMap2DOr3DState = RGFSMTable.FsmState.Car3D;
            }
        }
    }

    public void clearDestStateListener() {
        ArrayList<IFSMDestStateListener> arrayList = this.mFsmDestStateListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    public void delDestStateListener(IFSMDestStateListener iFSMDestStateListener) {
        ArrayList<IFSMDestStateListener> arrayList = this.mFsmDestStateListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(iFSMDestStateListener);
    }

    public String getCurrentEvent() {
        return this.mCurrentEvent;
    }

    public String getCurrentState() {
        if (!l0.c(this.mCurrentState)) {
            return this.mCurrentState;
        }
        return getTopState();
    }

    public String getEventToLastestMapState() {
        String str;
        String str2 = mLatestMap2DOr3DState;
        if (str2 == null || str2.length() == 0) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "getEventToLastestMapState is null");
            }
            if (BNCommSettingManager.getInstance().getMapMode() != 1 && BNCommSettingManager.getInstance().getMapMode() != 3) {
                str = RGFSMTable.FsmState.North2D;
            } else {
                str = RGFSMTable.FsmState.Car3D;
            }
            mLatestMap2DOr3DState = str;
        }
        if (mLatestMap2DOr3DState.equals(RGFSMTable.FsmState.North2D)) {
            return RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D;
        }
        if (mLatestMap2DOr3DState.equals(RGFSMTable.FsmState.Car3D)) {
            return RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D;
        }
        return null;
    }

    public int getIndexInBackStates(String str) {
        if (str != null && str.length() != 0) {
            for (int size = this.mBackStates.size() - 1; size >= 0; size--) {
                if (str.equals(this.mBackStates.get(size))) {
                    return size;
                }
            }
        }
        return -1;
    }

    public String getLastestMap2DOr3DStateFromLocal() {
        String str;
        String str2 = mLatestMap2DOr3DState;
        if (str2 == null || str2.length() == 0) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "getLastestMap2DOr3DStateFromLocal is null");
            }
            if (BNCommSettingManager.getInstance().getMapMode() != 1 && BNCommSettingManager.getInstance().getMapMode() != 3) {
                str = RGFSMTable.FsmState.North2D;
            } else {
                str = RGFSMTable.FsmState.Car3D;
            }
            mLatestMap2DOr3DState = str;
        }
        if (mLatestMap2DOr3DState.equals(RGFSMTable.FsmState.North2D)) {
            return RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D;
        }
        if (mLatestMap2DOr3DState.equals(RGFSMTable.FsmState.Car3D)) {
            return RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D;
        }
        return null;
    }

    public String getLatestMap2DOr3DState() {
        return mLatestMap2DOr3DState;
    }

    public String getSecondState() {
        if (this.mBackStates.size() > 1) {
            return this.mBackStates.get(r0.size() - 2);
        }
        return null;
    }

    public RGState getState(String str) {
        return this.mFsmFactory.obtainFsm(str);
    }

    public String getTopState() {
        if (this.mBackStates.size() > 0) {
            return this.mBackStates.get(r0.size() - 1);
        }
        return null;
    }

    public boolean isBaseState() {
        if (getTopState() != null && (RGFSMTable.FsmState.SimpleGuide.equals(getTopState()) || RGFSMTable.FsmState.NaviReady.equals(getTopState()) || RGFSMTable.FsmState.EnlargeRoadmap.equals(getTopState()) || RGFSMTable.FsmState.Colladamap.equals(getTopState()) || RGFSMTable.FsmState.Voice.equals(getTopState()) || RGFSMTable.FsmState.ArriveDest.equals(getTopState()) || RGFSMTable.FsmState.NearbySearch.equals(getTopState()) || RGFSMTable.FsmState.DynamicLayer.equals(getTopState()))) {
            return true;
        }
        return false;
    }

    public final boolean isBrowseState() {
        if (!isTopState(RGFSMTable.FsmState.BrowseMap) && !isTopState(RGFSMTable.FsmState.NearbySearch) && !isTopState(RGFSMTable.FsmState.DynamicLayer) && !isTopState(RGFSMTable.FsmState.ArriveDest)) {
            return false;
        }
        return true;
    }

    public boolean isCurrentGlassState3DOr2D() {
        String str = mCurrentGlassState;
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!mCurrentGlassState.equals(RGFSMTable.FsmState.North2D) && !mCurrentGlassState.equals(RGFSMTable.FsmState.Car3D)) {
            return false;
        }
        return true;
    }

    public boolean isEqualCurrentState(String... strArr) {
        if (strArr == null) {
            return false;
        }
        String currentState = getCurrentState();
        if (TextUtils.isEmpty(currentState)) {
            return false;
        }
        for (String str : strArr) {
            if (currentState.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSetFullViewByUser() {
        return this.mSetFullViewByUser;
    }

    public boolean isTopState(String str) {
        if (str != null && str.length() != 0) {
            return str.equals(getTopState());
        }
        return false;
    }

    public boolean run(String str) {
        return run(str, null);
    }

    public synchronized void runFirstFullViewSate() {
        try {
            String topState = getTopState();
            RGState obtainFsm = this.mFsmFactory.obtainFsm(topState);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "runFirstFullViewSate -> fsm = " + obtainFsm + ", getTopState() = " + topState);
            }
            obtainFsm.enter();
            obtainFsm.excute();
            run(RGFSMTable.FsmEvent.BTN_CLICK_FULL_VIEW);
            c.c(topState);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void runInitialState(Bundle bundle) {
        String bundle2;
        try {
            String topState = getTopState();
            RGState obtainFsm = this.mFsmFactory.obtainFsm(topState);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("runInitialState -> bundle = ");
                if (bundle == null) {
                    bundle2 = "null";
                } else {
                    bundle2 = bundle.toString();
                }
                sb.append(bundle2);
                sb.append(", fsm = ");
                sb.append(obtainFsm);
                sb.append(", topStae = ");
                sb.append(topState);
                gVar.e(TAG, sb.toString());
            }
            obtainFsm.enter();
            obtainFsm.excute();
            run(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR, bundle);
            c.c(topState);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean runRemoveState(String str) {
        List<String> list = this.mBackStates;
        if (list != null && list.size() > 0 && this.mBackStates.contains(str)) {
            return this.mBackStates.remove(str);
        }
        return false;
    }

    public void setFullViewByUser(boolean z) {
        this.mSetFullViewByUser = z;
    }

    public synchronized void setInitialState(String str) {
        String str2;
        try {
            this.mBackStates.clear();
            this.mCurrentState = null;
            if (BNCommSettingManager.getInstance().getMapMode() != 1 && BNCommSettingManager.getInstance().getMapMode() != 3) {
                str2 = RGFSMTable.FsmState.North2D;
                mLatestMap2DOr3DState = str2;
                pushState(str);
                this.mInited = true;
            }
            str2 = RGFSMTable.FsmState.Car3D;
            mLatestMap2DOr3DState = str2;
            pushState(str);
            this.mInited = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setUiState(a aVar) {
        this.mUiState = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x00fd, code lost:
    
        if (getSecondState().equals(com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState.HUDMirror) != false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0395 A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0025, B:12:0x002c, B:14:0x0032, B:15:0x0039, B:17:0x0041, B:20:0x004a, B:22:0x0056, B:25:0x0060, B:27:0x0069, B:29:0x0071, B:31:0x007a, B:33:0x0086, B:37:0x008e, B:38:0x00c4, B:40:0x00d1, B:42:0x00d7, B:46:0x0101, B:48:0x0107, B:50:0x012f, B:52:0x013d, B:56:0x0145, B:58:0x014d, B:61:0x0178, B:63:0x017e, B:64:0x01ac, B:66:0x01b4, B:69:0x01c9, B:70:0x01ce, B:72:0x01df, B:73:0x01fd, B:75:0x0203, B:77:0x0209, B:80:0x0229, B:82:0x0237, B:84:0x0244, B:85:0x0247, B:86:0x0381, B:88:0x038c, B:92:0x024e, B:94:0x0254, B:96:0x0258, B:98:0x0274, B:100:0x0286, B:102:0x02a6, B:105:0x02ae, B:107:0x02bc, B:109:0x02c4, B:112:0x02cd, B:114:0x02d5, B:117:0x02de, B:119:0x02e6, B:121:0x02ee, B:123:0x02f7, B:124:0x0309, B:125:0x0313, B:128:0x031e, B:129:0x0328, B:130:0x0332, B:132:0x0338, B:133:0x034c, B:134:0x0355, B:136:0x0359, B:137:0x035c, B:139:0x0363, B:141:0x036b, B:143:0x0373, B:145:0x037e, B:148:0x025e, B:150:0x026b, B:151:0x026e, B:152:0x01bc, B:154:0x01c4, B:155:0x015a, B:157:0x0163, B:160:0x0170, B:161:0x0175, B:162:0x0395, B:164:0x03a1, B:167:0x00e4, B:169:0x00ed, B:171:0x00f3, B:173:0x0093, B:175:0x009b, B:177:0x00a3, B:179:0x00ac, B:181:0x00b8, B:185:0x00c0), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0025, B:12:0x002c, B:14:0x0032, B:15:0x0039, B:17:0x0041, B:20:0x004a, B:22:0x0056, B:25:0x0060, B:27:0x0069, B:29:0x0071, B:31:0x007a, B:33:0x0086, B:37:0x008e, B:38:0x00c4, B:40:0x00d1, B:42:0x00d7, B:46:0x0101, B:48:0x0107, B:50:0x012f, B:52:0x013d, B:56:0x0145, B:58:0x014d, B:61:0x0178, B:63:0x017e, B:64:0x01ac, B:66:0x01b4, B:69:0x01c9, B:70:0x01ce, B:72:0x01df, B:73:0x01fd, B:75:0x0203, B:77:0x0209, B:80:0x0229, B:82:0x0237, B:84:0x0244, B:85:0x0247, B:86:0x0381, B:88:0x038c, B:92:0x024e, B:94:0x0254, B:96:0x0258, B:98:0x0274, B:100:0x0286, B:102:0x02a6, B:105:0x02ae, B:107:0x02bc, B:109:0x02c4, B:112:0x02cd, B:114:0x02d5, B:117:0x02de, B:119:0x02e6, B:121:0x02ee, B:123:0x02f7, B:124:0x0309, B:125:0x0313, B:128:0x031e, B:129:0x0328, B:130:0x0332, B:132:0x0338, B:133:0x034c, B:134:0x0355, B:136:0x0359, B:137:0x035c, B:139:0x0363, B:141:0x036b, B:143:0x0373, B:145:0x037e, B:148:0x025e, B:150:0x026b, B:151:0x026e, B:152:0x01bc, B:154:0x01c4, B:155:0x015a, B:157:0x0163, B:160:0x0170, B:161:0x0175, B:162:0x0395, B:164:0x03a1, B:167:0x00e4, B:169:0x00ed, B:171:0x00f3, B:173:0x0093, B:175:0x009b, B:177:0x00a3, B:179:0x00ac, B:181:0x00b8, B:185:0x00c0), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0025, B:12:0x002c, B:14:0x0032, B:15:0x0039, B:17:0x0041, B:20:0x004a, B:22:0x0056, B:25:0x0060, B:27:0x0069, B:29:0x0071, B:31:0x007a, B:33:0x0086, B:37:0x008e, B:38:0x00c4, B:40:0x00d1, B:42:0x00d7, B:46:0x0101, B:48:0x0107, B:50:0x012f, B:52:0x013d, B:56:0x0145, B:58:0x014d, B:61:0x0178, B:63:0x017e, B:64:0x01ac, B:66:0x01b4, B:69:0x01c9, B:70:0x01ce, B:72:0x01df, B:73:0x01fd, B:75:0x0203, B:77:0x0209, B:80:0x0229, B:82:0x0237, B:84:0x0244, B:85:0x0247, B:86:0x0381, B:88:0x038c, B:92:0x024e, B:94:0x0254, B:96:0x0258, B:98:0x0274, B:100:0x0286, B:102:0x02a6, B:105:0x02ae, B:107:0x02bc, B:109:0x02c4, B:112:0x02cd, B:114:0x02d5, B:117:0x02de, B:119:0x02e6, B:121:0x02ee, B:123:0x02f7, B:124:0x0309, B:125:0x0313, B:128:0x031e, B:129:0x0328, B:130:0x0332, B:132:0x0338, B:133:0x034c, B:134:0x0355, B:136:0x0359, B:137:0x035c, B:139:0x0363, B:141:0x036b, B:143:0x0373, B:145:0x037e, B:148:0x025e, B:150:0x026b, B:151:0x026e, B:152:0x01bc, B:154:0x01c4, B:155:0x015a, B:157:0x0163, B:160:0x0170, B:161:0x0175, B:162:0x0395, B:164:0x03a1, B:167:0x00e4, B:169:0x00ed, B:171:0x00f3, B:173:0x0093, B:175:0x009b, B:177:0x00a3, B:179:0x00ac, B:181:0x00b8, B:185:0x00c0), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean run(java.lang.String r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM.run(java.lang.String, android.os.Bundle):boolean");
    }
}
