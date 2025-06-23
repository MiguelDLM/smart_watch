package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes10.dex */
public class aq {
    private static aq B = null;
    private static final String Code = "hiad_sp_properties_cache_sdk";
    private static final String I = "PropertiesCache";
    private static final String V = "cache_data";
    private static final byte[] Z = new byte[0];
    private SharedPreferences C;
    private a F;
    private final byte[] S = new byte[0];

    /* loaded from: classes10.dex */
    public static final class a implements Cloneable {

        @com.huawei.openalliance.ad.annotations.b
        String B;

        @com.huawei.openalliance.ad.annotations.b
        Integer C;

        @com.huawei.openalliance.ad.annotations.b
        String Code;

        @com.huawei.openalliance.ad.annotations.b
        String D;

        @com.huawei.openalliance.ad.annotations.b
        String F;

        @com.huawei.openalliance.ad.annotations.b
        String I;

        @com.huawei.openalliance.ad.annotations.b
        String L;

        @com.huawei.openalliance.ad.annotations.b
        Boolean S;

        @com.huawei.openalliance.ad.annotations.b
        Boolean V;

        @com.huawei.openalliance.ad.annotations.b
        Boolean Z;

        /* renamed from: a, reason: collision with root package name */
        @com.huawei.openalliance.ad.annotations.b
        Integer f17409a;

        @com.huawei.openalliance.ad.annotations.b
        Integer b;

        @com.huawei.openalliance.ad.annotations.b
        public a() {
        }

        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.Code = this.Code;
            aVar.V = this.V;
            aVar.I = this.I;
            aVar.Z = this.Z;
            aVar.B = this.B;
            aVar.C = this.C;
            aVar.S = this.S;
            aVar.F = this.F;
            aVar.D = this.D;
            aVar.L = this.L;
            aVar.f17409a = this.f17409a;
            aVar.b = this.b;
            return aVar;
        }
    }

    private aq(Context context) {
        this.C = context.getSharedPreferences(Code, 0);
    }

    private void d() {
        if (this.F == null) {
            a aVar = null;
            String string = this.C.getString(V, null);
            if (string != null && string.length() > 0) {
                aVar = (a) aa.V(string, a.class, new Class[0]);
            }
            if (aVar == null) {
                aVar = new a();
            }
            this.F = aVar;
        }
    }

    public Boolean B() {
        synchronized (this.S) {
            try {
                d();
                Boolean bool = this.F.Z;
                if (bool != null) {
                    return bool;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String C() {
        String str;
        synchronized (this.S) {
            d();
            str = this.F.B;
        }
        return str;
    }

    public String D() {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return "";
                }
                return aVar.F;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Boolean F() {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return null;
                }
                return aVar.S;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String I() {
        synchronized (this.S) {
            try {
                d();
                String str = this.F.I;
                if (str != null) {
                    return str;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String L() {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return null;
                }
                String str = aVar.D;
                if (str != null) {
                    return str;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Integer S() {
        synchronized (this.S) {
            try {
                d();
                Integer num = this.F.C;
                if (num != null) {
                    return num;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void V(Integer num) {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return;
                }
                aVar.b = num;
                Code(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String Z() {
        String str;
        synchronized (this.S) {
            d();
            str = this.F.Code;
        }
        return str;
    }

    public String a() {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return null;
                }
                String str = aVar.L;
                if (str != null) {
                    return str;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Integer b() {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return null;
                }
                return aVar.f17409a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Integer c() {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return null;
                }
                Integer num = aVar.b;
                if (num != null) {
                    return num;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static aq Code(Context context) {
        aq aqVar;
        synchronized (Z) {
            try {
                if (B == null) {
                    B = new aq(context);
                }
                aqVar = B;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aqVar;
    }

    public void B(boolean z) {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return;
                }
                aVar.L = String.valueOf(z);
                Code(this.F);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void I(String str) {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return;
                }
                aVar.F = str;
                Code(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void V(String str) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            aVar.B = str;
            Code(aVar);
        }
    }

    public void Z(boolean z) {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return;
                }
                aVar.D = String.valueOf(z);
                Code(this.F);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code() {
        synchronized (this.S) {
            d();
        }
    }

    public void I(boolean z) {
        synchronized (this.S) {
            d();
            this.F.Z = Boolean.valueOf(z);
            Code(this.F);
        }
    }

    public void V(boolean z) {
        synchronized (this.S) {
            d();
            this.F.Code = String.valueOf(z);
            Code(this.F);
        }
    }

    public void Code(int i) {
        synchronized (this.S) {
            d();
            this.F.C = Integer.valueOf(i);
            Code(this.F);
        }
    }

    public boolean V() {
        synchronized (this.S) {
            try {
                d();
                Boolean bool = this.F.V;
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        final a clone = aVar.clone();
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aq.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = aq.this.C.edit();
                edit.putString(aq.V, aa.V(clone));
                edit.apply();
            }
        });
    }

    public void Code(Boolean bool) {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return;
                }
                aVar.S = bool;
                Code(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(Integer num) {
        synchronized (this.S) {
            try {
                d();
                a aVar = this.F;
                if (aVar == null) {
                    return;
                }
                aVar.f17409a = num;
                Code(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(String str) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            aVar.I = str;
            Code(aVar);
        }
    }

    public void Code(boolean z) {
        synchronized (this.S) {
            d();
            this.F.V = Boolean.valueOf(z);
            Code(this.F);
        }
    }
}
