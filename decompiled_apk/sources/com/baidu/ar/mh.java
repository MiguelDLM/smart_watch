package com.baidu.ar;

/* loaded from: classes7.dex */
public class mh implements mo {
    protected mf FC;
    protected mr FD;
    protected int Fr;
    protected boolean Fx;
    protected mn Fy;
    protected String tag;
    protected float[] Fz = new float[16];
    protected float[] FA = new float[16];
    protected float[] FB = new float[16];

    public mh(String str, int i) {
        this.Fr = i;
        this.tag = str;
    }

    public void a(mf mfVar) {
        this.FC = mfVar;
    }

    @Override // com.baidu.ar.mq
    public int ir() {
        return this.Fr;
    }

    @Override // com.baidu.ar.mo
    public boolean is() {
        return this.Fx;
    }

    @Override // com.baidu.ar.mo
    public float[] it() {
        mn mnVar = this.Fy;
        return mnVar != null ? mnVar.w(this.FB) : this.FB;
    }

    @Override // com.baidu.ar.mo
    public void p(float[] fArr) {
        if (this.Fy == null) {
            this.Fy = new mu();
        }
        this.Fy.b(nn.e(fArr, this.FB), nn.H(fArr).toArray(), nn.H(this.FB).toArray());
    }

    public void reset() {
        this.Fx = false;
    }

    public void a(mr mrVar) {
        this.FD = mrVar;
    }
}
