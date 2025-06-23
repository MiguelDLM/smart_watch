package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class cw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f18368a;

    public cw(Context context) {
        this.f18368a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:7|(2:8|9)|(45:11|12|13|14|15|16|17|18|(1:20)|22|23|(1:25)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(3:55|(1:57)|58)|60|61|(1:63)|65|66|(1:68)|70)|94|95|17|18|(0)|22|23|(0)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(0)|60|61|(0)|65|66|(0)|70) */
    /* JADX WARN: Can't wrap try/catch for region: R(45:7|8|9|(45:11|12|13|14|15|16|17|18|(1:20)|22|23|(1:25)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(3:55|(1:57)|58)|60|61|(1:63)|65|66|(1:68)|70)|94|95|17|18|(0)|22|23|(0)|27|28|29|30|31|32|33|34|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52|53|(0)|60|61|(0)|65|66|(0)|70) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0334, code lost:
    
        r13 = "p";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0337, code lost:
    
        r13 = "p";
        r10 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x033c, code lost:
    
        r13 = "p";
        r10 = r18;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x028d, code lost:
    
        r17 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0343, code lost:
    
        r17 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0102 A[Catch: Exception -> 0x0129, TRY_LEAVE, TryCatch #3 {Exception -> 0x0129, blocks: (B:18:0x00f3, B:20:0x0102), top: B:17:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013d A[Catch: Exception -> 0x0200, TRY_LEAVE, TryCatch #8 {Exception -> 0x0200, blocks: (B:23:0x0129, B:25:0x013d), top: B:22:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03e1 A[Catch: Exception -> 0x0446, TryCatch #13 {Exception -> 0x0446, blocks: (B:53:0x03d2, B:55:0x03e1, B:57:0x040d, B:58:0x0443), top: B:52:0x03d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0457 A[Catch: Exception -> 0x0488, TRY_LEAVE, TryCatch #12 {Exception -> 0x0488, blocks: (B:61:0x0446, B:63:0x0457), top: B:60:0x0446 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0499 A[Catch: Exception -> 0x04dc, TRY_LEAVE, TryCatch #10 {Exception -> 0x04dc, blocks: (B:66:0x0488, B:68:0x0499), top: B:65:0x0488 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.kuaishou.weapon.p0.y b(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cw.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String a2 = new bn(this.f18368a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                y b = b(a2);
                if (b != null) {
                    df.a(this.f18368a).a(str, b);
                } else {
                    df.a(this.f18368a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = cu.f18366a + cu.d;
            String a2 = cv.a(this.f18368a);
            if (!TextUtils.isEmpty(a2)) {
                str = str + LocationInfo.NA + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject b = cv.b(this.f18368a);
            if (b != null) {
                jSONObject.put("data", new bn(this.f18368a).c(b.toString()));
            }
            l a3 = l.a(this.f18368a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cw.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cw.this.a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
