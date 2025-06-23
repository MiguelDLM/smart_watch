package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.bb;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class d implements bb.a {
    private gc E;
    private fs F;
    private bb G;
    private dh H;
    private fe I;
    private ej ab;
    private a ac;
    private String al;
    private JSONObject am;
    private HashMap<String, df> an;
    private bb.b ar;
    protected int as;
    private Context mContext;
    private Handler mHandler;
    protected int mInputHeight;
    protected int mInputWidth;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private List<dj> ao = new ArrayList();
    private boolean ap = false;
    private List<String> aq = new CopyOnWriteArrayList();
    protected boolean at = true;
    protected boolean mIsFrontCamera = true;
    private boolean au = true;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(String str, df dfVar);
    }

    private boolean u() {
        bb bbVar = this.G;
        if (bbVar == null || bbVar.bp() == null) {
            return false;
        }
        return this.G.bp().isSyncInputContent();
    }

    public void a(Context context, Looper looper) {
        this.mContext = context;
        this.mHandler = new Handler(looper);
    }

    public void adjust(HashMap<String, Object> hashMap) {
        boolean z;
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("sync".equals(str)) {
            z = true;
        } else {
            "async".equals(str);
            z = false;
        }
        boolean z2 = u() ? true : z;
        if (z2 != this.ap) {
            this.ap = z2;
            for (dj djVar : this.ao) {
                if (djVar != null && (djVar instanceof di)) {
                    ((di) djVar).s(this.ap);
                }
                dh dhVar = this.H;
                if (dhVar != null) {
                    dhVar.a((di) djVar);
                }
            }
        }
    }

    public final void b(int i, HashMap<String, Object> hashMap) {
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.b(i, hashMap);
        }
    }

    public void c(String str, df dfVar) {
        if (this.ao == null || TextUtils.isEmpty(str) || dfVar == null) {
            return;
        }
        for (dj djVar : this.ao) {
            if (djVar != null && str.equals(djVar.getName()) && (djVar instanceof db)) {
                ((db) djVar).c(dfVar);
            }
        }
    }

    public final void d(HashMap<String, Object> hashMap) {
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.b(1902, hashMap);
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getFaceModelPath() {
        return this.al;
    }

    public SparseArray<gb> getMdlConfigs() {
        gc gcVar = this.E;
        if (gcVar != null) {
            return gcVar.ev();
        }
        kf.b("AbstractAR", "mMdlConfigParams is null.");
        return new SparseArray<>();
    }

    public void k(String str) {
        List<String> list = this.aq;
        if (list == null || list.contains(str)) {
            return;
        }
        this.aq.add(str);
    }

    public void l(String str) {
        List<String> list = this.aq;
        if (list != null) {
            list.remove(str);
        }
    }

    public void onCaseCreate(String str) {
    }

    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.bb.a
    public void onInputSizeChange(int i, int i2) {
        bb bbVar = this.G;
        if (bbVar == null) {
            return;
        }
        this.mInputWidth = bbVar.bp().getInputWidth();
        this.mInputHeight = this.G.bp().getInputHeight();
    }

    public void pause() {
    }

    public void r() {
        List<String> list = this.aq;
        if (list != null) {
            list.clear();
        }
    }

    public void release() {
        HashMap<String, df> hashMap = this.an;
        if (hashMap != null) {
            for (Map.Entry<String, df> entry : hashMap.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            this.an.clear();
            this.an = null;
        }
        int size = this.ao.size();
        dj[] djVarArr = new dj[size];
        this.ao.toArray(djVarArr);
        for (int i = 0; i < size; i++) {
            a(djVarArr[i]);
        }
        this.ao.clear();
        this.ao = null;
        this.H = null;
        this.I = null;
        this.G = null;
        this.ab = null;
        this.F = null;
        this.am = null;
        this.mHandler = null;
        this.mContext = null;
    }

    public void resume() {
    }

    public boolean s() {
        List<String> list = this.aq;
        if (list != null && list.size() > 0) {
            return false;
        }
        for (dj djVar : this.ao) {
            if (djVar != null && (djVar instanceof db) && ((db) djVar).cM()) {
                return false;
            }
        }
        return true;
    }

    public void setFaceModelPath(String str) {
        this.al = str;
    }

    public void setMdlConfigParams(gc gcVar) {
        this.E = gcVar;
    }

    public void setup(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (!TextUtils.isEmpty(str) && "sync".equals(str)) {
            this.ap = true;
        }
        if (u()) {
            this.ap = true;
        }
    }

    public final IARRenderer t() {
        return this.G;
    }

    public void a(a aVar) {
        this.ac = aVar;
    }

    public final void b(ft ftVar) {
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.d(ftVar);
        }
    }

    public void a(dh dhVar, bb bbVar, ej ejVar) {
        this.H = dhVar;
        this.G = bbVar;
        this.ab = ejVar;
        this.mInputWidth = bbVar.bp().getInputWidth();
        this.mInputHeight = bbVar.bp().getInputHeight();
        this.mOutputWidth = bbVar.bq().getOutputWidth();
        this.mOutputHeight = bbVar.bq().getOutputHeight();
        this.as = bbVar.bp().getInputDegree();
        this.at = bbVar.bp().isCameraInput();
        this.mIsFrontCamera = bbVar.bp().isFrontCamera();
        bb.b bVar = new bb.b() { // from class: com.baidu.ar.d.1
            @Override // com.baidu.ar.bb.b
            public void a(int i, int i2) {
                d dVar = d.this;
                dVar.mOutputWidth = i;
                dVar.mOutputHeight = i2;
            }
        };
        this.ar = bVar;
        bbVar.a(bVar);
        bbVar.a(this);
        if (u()) {
            this.ap = true;
        }
    }

    public void b(String str, df dfVar) {
        if (this.ao == null || TextUtils.isEmpty(str) || dfVar == null) {
            return;
        }
        for (dj djVar : this.ao) {
            if (djVar != null && str.equals(djVar.getName()) && (djVar instanceof db)) {
                ((db) djVar).b(dfVar);
            }
        }
    }

    public final void a(dj djVar) {
        bb bbVar;
        if (djVar == null) {
            kf.b("AbstractAR", "removeDetector error!!! detector is null!!!");
            return;
        }
        if ((djVar instanceof di) && (bbVar = this.G) != null) {
            di diVar = (di) djVar;
            bbVar.destroyPixelReader(diVar.cT(), diVar);
        }
        dh dhVar = this.H;
        if (dhVar != null) {
            dhVar.a(djVar);
        }
        List<dj> list = this.ao;
        if (list != null) {
            list.remove(djVar);
        }
    }

    public void b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            List<String> list2 = this.aq;
            if (list2 != null && !list2.contains(str)) {
                this.aq.add(str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r2 != 270) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.baidu.ar.dj r5, com.baidu.ar.df r6) {
        /*
            r4 = this;
            if (r5 != 0) goto La
            java.lang.String r5 = "AbstractAR"
            java.lang.String r6 = "addDetector error!!! detector is null!!!"
            com.baidu.ar.kf.b(r5, r6)
            return
        La:
            boolean r0 = r5 instanceof com.baidu.ar.di
            if (r0 == 0) goto L62
            com.baidu.ar.bb r0 = r4.G
            if (r0 == 0) goto L62
            java.util.List<com.baidu.ar.dj> r0 = r4.ao
            r0.add(r5)
            r0 = r5
            com.baidu.ar.di r0 = (com.baidu.ar.di) r0
            android.os.Handler r1 = r4.mHandler
            r0.a(r1)
            boolean r1 = r4.ap
            r0.s(r1)
            com.baidu.ar.arplay.core.pixel.PixelReadParams r1 = r0.cT()
            boolean r2 = r4.at
            if (r2 == 0) goto L3f
            boolean r2 = r1.getIsPortrait()
            if (r2 == 0) goto L3f
            boolean r2 = r4.mIsFrontCamera
            if (r2 == 0) goto L3c
        L36:
            com.baidu.ar.arplay.core.pixel.PixelRotation r2 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateRightFlipHorizontal
        L38:
            r1.setPixelRotate(r2)
            goto L5d
        L3c:
            com.baidu.ar.arplay.core.pixel.PixelRotation r2 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateRight
            goto L38
        L3f:
            boolean r2 = r4.at
            if (r2 != 0) goto L5d
            int r2 = r4.as
            if (r2 == 0) goto L5a
            r3 = 90
            if (r2 == r3) goto L57
            r3 = 180(0xb4, float:2.52E-43)
            if (r2 == r3) goto L54
            r3 = 270(0x10e, float:3.78E-43)
            if (r2 == r3) goto L36
            goto L5d
        L54:
            com.baidu.ar.arplay.core.pixel.PixelRotation r2 = com.baidu.ar.arplay.core.pixel.PixelRotation.FlipHorizontal
            goto L38
        L57:
            com.baidu.ar.arplay.core.pixel.PixelRotation r2 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateRightFlipVertical
            goto L38
        L5a:
            com.baidu.ar.arplay.core.pixel.PixelRotation r2 = com.baidu.ar.arplay.core.pixel.PixelRotation.FlipVertical
            goto L38
        L5d:
            com.baidu.ar.bb r2 = r4.G
            r2.createPixelReader(r1, r0)
        L62:
            com.baidu.ar.dh r0 = r4.H
            if (r0 == 0) goto L69
            r0.a(r5, r6)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.d.a(com.baidu.ar.dj, com.baidu.ar.df):void");
    }

    public void b(boolean z) {
        this.mIsFrontCamera = z;
        for (dj djVar : this.ao) {
            if ((djVar instanceof di) && this.G != null) {
                PixelReadParams cT = ((di) djVar).cT();
                if (this.at && cT.getIsPortrait()) {
                    PixelRotation pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                    cT.setPixelRotate(pixelRotation);
                    this.G.updatePixelReader(cT, pixelRotation);
                }
            }
        }
    }

    public void a(fe feVar) {
        this.I = feVar;
    }

    public final void a(fi fiVar) {
        fe feVar = this.I;
        if (feVar != null) {
            feVar.stop(fiVar);
        }
    }

    public void a(fs fsVar) {
        this.F = fsVar;
    }

    public final void a(ft ftVar) {
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.c(ftVar);
        }
    }

    public final void a(LuaMsgListener luaMsgListener) {
        fs fsVar = this.F;
        if (fsVar == null || fsVar.ei() == null) {
            return;
        }
        this.F.ei().addLuaMsgListener(luaMsgListener);
    }

    public void a(JSONObject jSONObject) {
        this.am = jSONObject;
    }

    public final boolean a(fk fkVar, fi fiVar) {
        fe feVar = this.I;
        if (feVar != null) {
            return feVar.start(fkVar, fiVar);
        }
        return false;
    }

    public final boolean a(String str, df dfVar) {
        if (this.ac == null || TextUtils.isEmpty(str) || dfVar == null) {
            return false;
        }
        HashMap<String, df> hashMap = this.an;
        if (hashMap != null) {
            hashMap.remove(str);
        }
        return this.ac.a(str, dfVar);
    }
}
