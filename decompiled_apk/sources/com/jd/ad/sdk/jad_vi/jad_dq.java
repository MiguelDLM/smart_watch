package com.jd.ad.sdk.jad_vi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.appevents.UserDataStore;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.logger.Logger;
import java.io.Serializable;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_dq implements Serializable {
    public int jad_al;
    public int jad_an;
    public String jad_bm;
    public int jad_bo;
    public int jad_cn;
    public String jad_cp;
    public int jad_do;
    public String jad_dq;
    public int jad_en;
    public String jad_ep;
    public String jad_er;
    public int jad_fo;
    public String jad_fq;
    public String jad_fs;
    public String jad_gj;
    public int jad_gp;
    public String jad_gr;
    public String jad_hk;
    public int jad_hq;
    public int jad_hs;
    public int jad_hu;
    public String jad_il;
    public int jad_ir;
    public int jad_it;
    public int jad_iv;
    public String jad_jm;
    public int jad_js;
    public int jad_jt;
    public int jad_ju;
    public String jad_jw;
    public int jad_kn;
    public int jad_kt;
    public int jad_kv;
    public int jad_kx;
    public String jad_lo;
    public int jad_lu;
    public int jad_lw;
    public String jad_ly;
    public int jad_mp;
    public int jad_mv;
    public int jad_mx;
    public String jad_mz;
    public String jad_na;
    public int jad_nq;
    public int jad_nw;
    public com.jd.ad.sdk.dl.model.jad_an jad_ny;
    public String jad_ob;
    public int jad_or;
    public int jad_ox;
    public int jad_oz;
    public int jad_pa;
    public String jad_pc;
    public int jad_ps;
    public int jad_py;
    public int jad_qb;
    public String jad_qd;
    public String jad_qt;
    public int jad_qz;
    public int jad_ra;
    public int jad_rc;
    public String jad_re;
    public int jad_ru;
    public String jad_sb;
    public String jad_sd;
    public jad_jw jad_sf;
    public int jad_sv;
    public String jad_tc;
    public int jad_te;
    public String jad_tg;
    public int jad_tw;
    public int jad_ud;
    public int jad_uf;
    public String jad_uh;
    public String jad_ve;
    public int jad_vg;
    public int jad_vi;
    public int jad_wf;
    public int jad_wh;
    public int jad_wj;
    public int jad_xg;
    public String jad_xi;
    public int jad_xk;
    public int jad_yh;
    public int jad_yj;
    public int jad_yl;
    public int jad_zi;
    public int jad_zk;
    public int jad_zm;

    public jad_dq(int i, String str) {
        this(i, new JSONObject(str));
    }

    public final void jad_an(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("tp");
            this.jad_bo = optInt;
            if (optInt == 1) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_zk = jSONObject.optInt("plwd");
                this.jad_al = jSONObject.optInt("plht");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_lu = jSONObject.optInt("tcbr");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt("srtp");
                this.jad_ps = jSONObject.optInt("ipl");
                this.jad_ru = jSONObject.optInt("toti");
            }
            if (this.jad_bo == 2) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_fo = jSONObject.optInt("sddu");
                this.jad_mv = jSONObject.optInt("alct");
                this.jad_nw = jSONObject.optInt("jdad");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_xg = jSONObject.optInt("msst");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt("srtp");
                this.jad_ps = jSONObject.optInt("ipl");
            }
            String str = "ipl";
            String str2 = "srtp";
            if (this.jad_bo == 3) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_er = jSONObject.optString("exid");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_mx = jSONObject.optInt("imm");
                this.jad_gp = jSONObject.optInt("sedu");
                this.jad_hq = jSONObject.optInt("dedu");
                this.jad_qz = jSONObject.optInt("sspt");
                this.jad_ra = jSONObject.optInt("scav");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt(str2);
                str2 = str2;
                this.jad_ps = jSONObject.optInt(str);
                str = str;
                this.jad_ny = new com.jd.ad.sdk.dl.model.jad_an(jSONObject.optJSONObject("cons"));
            }
            if (this.jad_bo == 4) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt("adt");
                this.jad_jw = jSONObject.optString("clid");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_kx = jSONObject.optInt("clf");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_en = jSONObject.optInt("dety");
                this.jad_ir = jSONObject.optInt("scdu");
                this.jad_js = jSONObject.optInt("dcdu");
                this.jad_kt = jSONObject.optInt("ecdu");
                this.jad_qz = jSONObject.optInt("sspt");
                this.jad_ra = jSONObject.optInt("scav");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_py = jSONObject.optInt("atst");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt(str2);
                this.jad_ps = jSONObject.optInt(str);
                this.jad_sv = jSONObject.optInt("vpst");
                this.jad_tw = jSONObject.optInt("vpdt");
            }
            if (this.jad_bo == 5) {
                this.jad_qb = jSONObject.optInt("extp");
                this.jad_rc = jSONObject.optInt("ercd");
                String optString = jSONObject.optString("erin");
                this.jad_sd = optString;
                if (!TextUtils.isEmpty(optString) && this.jad_an > 0 && !this.jad_sd.startsWith("###")) {
                    this.jad_sd = "###" + this.jad_an + "_" + this.jad_sd;
                }
                this.jad_bm = jSONObject.optString("rid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_pa = jSONObject.optInt("crt");
            }
            if (this.jad_bo == 6) {
                this.jad_xi = jSONObject.optString("iid");
                this.jad_yj = jSONObject.optInt("init");
                this.jad_oz = jSONObject.optInt("idu");
            }
            this.jad_ly = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_SL_TIME);
            this.jad_mz = jSONObject.optString(oO.f31192XO);
            this.jad_na = jSONObject.optString("osv");
            this.jad_ob = jSONObject.optString("did");
            this.jad_qd = jSONObject.optString("bi");
            this.jad_pc = jSONObject.optString(EngineImpl.KEY_OAID);
            this.jad_re = jSONObject.optString("sv");
            this.jad_sf = new jad_jw(jSONObject.optJSONObject("geo"));
            this.jad_te = jSONObject.optInt("swd");
            this.jad_uf = jSONObject.optInt("sht");
            this.jad_vg = jSONObject.optInt(UserDataStore.CITY);
            this.jad_tg = jSONObject.optString("mk");
            this.jad_uh = jSONObject.optString("md");
            this.jad_vi = jSONObject.optInt("svb");
            this.jad_wj = jSONObject.optInt("jdi");
            this.jad_xk = jSONObject.optInt("qqi");
            this.jad_yl = jSONObject.optInt("wci");
            this.jad_zm = jSONObject.optInt("tbi");
            this.jad_cn = jSONObject.optInt("tmi");
            this.jad_do = jSONObject.optInt("pddi");
            this.jad_ep = jSONObject.optString("tz");
            this.jad_fq = jSONObject.optString("an");
            this.jad_gr = jSONObject.optString("asv");
            this.jad_dq = jSONObject.optString(IAdInterListener.AdReqParam.APID);
            this.jad_hs = jSONObject.optInt("jbr");
            this.jad_it = jSONObject.optInt("af");
            this.jad_ju = jSONObject.optInt("atsv");
            this.jad_kv = jSONObject.optInt("ihrd");
            this.jad_sb = jSONObject.optString("pn");
            this.jad_tc = jSONObject.optString("sc");
            this.jad_ud = jSONObject.optInt("hos");
            this.jad_ve = jSONObject.optString("hosv");
            this.jad_gj = jSONObject.optString("sav");
            this.jad_hk = jSONObject.optString("mt");
            this.jad_il = jSONObject.optString("hwv");
            this.jad_jm = jSONObject.optString("ca");
            this.jad_kn = jSONObject.optInt("ppi");
            this.jad_lo = jSONObject.optString("cc");
            this.jad_mp = jSONObject.optInt("sof");
            this.jad_nq = jSONObject.optInt("sl");
            this.jad_or = jSONObject.optInt(UserDataStore.EMAIL);
            this.jad_qt = jSONObject.optString("soaid");
        } catch (Exception e) {
            Logger.w("parse event from json ", e.getMessage());
        }
    }

    @NonNull
    public String toString() {
        return jad_an().toString();
    }

    public jad_dq(int i, JSONObject jSONObject) {
        this.jad_pa = 0;
        if (jSONObject == null) {
            return;
        }
        this.jad_an = i;
        jad_an(jSONObject);
    }

    public JSONObject jad_an() {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject = new JSONObject();
        try {
            JsonUtils.put(jSONObject, "tp", Integer.valueOf(this.jad_bo));
            if (this.jad_bo == 1) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, "adt", Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "plwd", Integer.valueOf(this.jad_zk));
                JsonUtils.put(jSONObject, "plht", Integer.valueOf(this.jad_al));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "tcbr", Integer.valueOf(this.jad_lu));
                JsonUtils.put(jSONObject, "dstp", Integer.valueOf(this.jad_yh));
                JsonUtils.put(jSONObject, "srtp", Integer.valueOf(this.jad_zi));
                JsonUtils.put(jSONObject, "ipl", Integer.valueOf(this.jad_ps));
                JsonUtils.put(jSONObject, "toti", Integer.valueOf(this.jad_ru));
            }
            if (this.jad_bo == 2) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, "adt", Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "sddu", Integer.valueOf(this.jad_fo));
                JsonUtils.put(jSONObject, "alct", Integer.valueOf(this.jad_mv));
                JsonUtils.put(jSONObject, "jdad", Integer.valueOf(this.jad_nw));
                JsonUtils.put(jSONObject, "adat", Integer.valueOf(this.jad_ox));
                JsonUtils.put(jSONObject, "catp", Integer.valueOf(this.jad_wf));
                JsonUtils.put(jSONObject, "msst", Integer.valueOf(this.jad_xg));
                JsonUtils.put(jSONObject, "dstp", Integer.valueOf(this.jad_yh));
                JsonUtils.put(jSONObject, "srtp", Integer.valueOf(this.jad_zi));
                JsonUtils.put(jSONObject, "ipl", Integer.valueOf(this.jad_ps));
            }
            if (this.jad_bo == 3) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, "adt", Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "exid", this.jad_er);
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "imm", Integer.valueOf(this.jad_mx));
                JsonUtils.put(jSONObject, "sedu", Integer.valueOf(this.jad_gp));
                JsonUtils.put(jSONObject, "dedu", Integer.valueOf(this.jad_hq));
                JsonUtils.put(jSONObject, "sspt", Integer.valueOf(this.jad_qz));
                JsonUtils.put(jSONObject, "scav", Integer.valueOf(this.jad_ra));
                JsonUtils.put(jSONObject, "adat", Integer.valueOf(this.jad_ox));
                JsonUtils.put(jSONObject, "ipl", Integer.valueOf(this.jad_ps));
                JsonUtils.put(jSONObject, "cons", this.jad_ny.jad_an());
                JsonUtils.put(jSONObject, "catp", Integer.valueOf(this.jad_wf));
                str = "dstp";
                JsonUtils.put(jSONObject, str, Integer.valueOf(this.jad_yh));
                str2 = "ipl";
                str3 = "srtp";
                JsonUtils.put(jSONObject, str3, Integer.valueOf(this.jad_zi));
            } else {
                str = "dstp";
                str2 = "ipl";
                str3 = "srtp";
            }
            String str4 = str3;
            if (this.jad_bo == 4) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, "adt", Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "clid", this.jad_jw);
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "clf", Integer.valueOf(this.jad_kx));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "dety", Integer.valueOf(this.jad_en));
                JsonUtils.put(jSONObject, "scdu", Integer.valueOf(this.jad_ir));
                JsonUtils.put(jSONObject, "dcdu", Integer.valueOf(this.jad_js));
                JsonUtils.put(jSONObject, "ecdu", Integer.valueOf(this.jad_kt));
                JsonUtils.put(jSONObject, "sspt", Integer.valueOf(this.jad_qz));
                JsonUtils.put(jSONObject, "scav", Integer.valueOf(this.jad_ra));
                JsonUtils.put(jSONObject, "adat", Integer.valueOf(this.jad_ox));
                JsonUtils.put(jSONObject, "atst", Integer.valueOf(this.jad_py));
                JsonUtils.put(jSONObject, "catp", Integer.valueOf(this.jad_wf));
                JsonUtils.put(jSONObject, str, Integer.valueOf(this.jad_yh));
                JsonUtils.put(jSONObject, str4, Integer.valueOf(this.jad_zi));
                JsonUtils.put(jSONObject, str2, Integer.valueOf(this.jad_ps));
                JsonUtils.put(jSONObject, "vpst", Integer.valueOf(this.jad_sv));
                JsonUtils.put(jSONObject, "vpdt", Integer.valueOf(this.jad_tw));
            }
            if (this.jad_bo == 5) {
                JsonUtils.put(jSONObject, "extp", Integer.valueOf(this.jad_qb));
                JsonUtils.put(jSONObject, "ercd", Integer.valueOf(this.jad_rc));
                JsonUtils.put(jSONObject, "erin", this.jad_sd);
                JsonUtils.put(jSONObject, "rid", this.jad_bm);
                if (this.jad_qb == 3) {
                    JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                } else {
                    JsonUtils.put(jSONObject, "sen", 0);
                }
                JsonUtils.put(jSONObject, "crt", Integer.valueOf(this.jad_pa));
            }
            if (this.jad_bo == 6) {
                JsonUtils.put(jSONObject, "iid", this.jad_xi);
                JsonUtils.put(jSONObject, "init", Integer.valueOf(this.jad_yj));
                JsonUtils.put(jSONObject, "idu", Integer.valueOf(this.jad_oz));
            }
            JsonUtils.put(jSONObject, "sv", this.jad_re);
            JsonUtils.put(jSONObject, "bi", this.jad_qd);
            JsonUtils.put(jSONObject, EngineImpl.KEY_OAID, this.jad_pc);
            JsonUtils.put(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_TIME, this.jad_ly);
            JsonUtils.put(jSONObject, oO.f31192XO, this.jad_mz);
            JsonUtils.put(jSONObject, "osv", this.jad_na);
            JsonUtils.put(jSONObject, "did", this.jad_ob);
            jad_jw jad_jwVar = this.jad_sf;
            jad_jwVar.getClass();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JsonUtils.put(jSONObject2, "lon", jad_jwVar.jad_an);
                JsonUtils.put(jSONObject2, "lat", jad_jwVar.jad_bo);
            } catch (Exception unused) {
            }
            JsonUtils.put(jSONObject, "geo", jSONObject2);
            JsonUtils.put(jSONObject, "swd", Integer.valueOf(this.jad_te));
            JsonUtils.put(jSONObject, "sht", Integer.valueOf(this.jad_uf));
            JsonUtils.put(jSONObject, UserDataStore.CITY, Integer.valueOf(this.jad_vg));
            JsonUtils.put(jSONObject, "mk", this.jad_tg);
            JsonUtils.put(jSONObject, "md", this.jad_uh);
            JsonUtils.put(jSONObject, "svb", Integer.valueOf(this.jad_vi));
            JsonUtils.put(jSONObject, "jdi", Integer.valueOf(this.jad_wj));
            JsonUtils.put(jSONObject, "qqi", Integer.valueOf(this.jad_xk));
            JsonUtils.put(jSONObject, "wci", Integer.valueOf(this.jad_yl));
            JsonUtils.put(jSONObject, "tbi", Integer.valueOf(this.jad_zm));
            JsonUtils.put(jSONObject, "tmi", Integer.valueOf(this.jad_cn));
            JsonUtils.put(jSONObject, "pddi", Integer.valueOf(this.jad_do));
            JsonUtils.put(jSONObject, "tz", this.jad_ep);
            JsonUtils.put(jSONObject, "an", this.jad_fq);
            JsonUtils.put(jSONObject, "asv", this.jad_gr);
            JsonUtils.put(jSONObject, IAdInterListener.AdReqParam.APID, this.jad_dq);
            JsonUtils.put(jSONObject, "jbr", Integer.valueOf(this.jad_hs));
            JsonUtils.put(jSONObject, "af", Integer.valueOf(this.jad_it));
            JsonUtils.put(jSONObject, "atsv", Integer.valueOf(this.jad_ju));
            JsonUtils.put(jSONObject, "ihrd", Integer.valueOf(this.jad_kv));
            JsonUtils.put(jSONObject, "pn", this.jad_sb);
            JsonUtils.put(jSONObject, "sc", this.jad_tc);
            JsonUtils.put(jSONObject, "hos", Integer.valueOf(this.jad_ud));
            JsonUtils.put(jSONObject, "hosv", this.jad_ve);
            JsonUtils.put(jSONObject, "sav", this.jad_gj);
            JsonUtils.put(jSONObject, "mt", this.jad_hk);
            JsonUtils.put(jSONObject, "hwv", this.jad_il);
            JsonUtils.put(jSONObject, "ca", this.jad_jm);
            JsonUtils.put(jSONObject, "ppi", Integer.valueOf(this.jad_kn));
            JsonUtils.put(jSONObject, "cc", this.jad_lo);
            JsonUtils.put(jSONObject, "sof", Integer.valueOf(this.jad_mp));
            JsonUtils.put(jSONObject, "sl", Integer.valueOf(this.jad_nq));
            JsonUtils.put(jSONObject, UserDataStore.EMAIL, Integer.valueOf(this.jad_or));
            JsonUtils.put(jSONObject, "soaid", this.jad_qt);
        } catch (Exception e) {
            Logger.w("Event to json ", e.getMessage());
        }
        return jSONObject;
    }
}
