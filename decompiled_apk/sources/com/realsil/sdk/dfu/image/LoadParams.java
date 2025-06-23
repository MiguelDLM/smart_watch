package com.realsil.sdk.dfu.image;

import android.content.Context;
import android.text.TextUtils;
import com.realsil.sdk.dfu.j.a;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class LoadParams {

    /* renamed from: a, reason: collision with root package name */
    public Context f19542a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public String h;
    public String i;
    public int j;
    public OtaDeviceInfo k;
    public boolean l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public int w;

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f19543a;
        public String c;
        public String d;
        public OtaDeviceInfo k;
        public int q;
        public int w;
        public int b = 0;
        public int e = 3;
        public int f = 0;
        public int g = 0;
        public int h = 0;
        public int i = 1;
        public int j = -1;
        public boolean l = false;
        public int m = 0;
        public boolean n = false;
        public boolean o = true;
        public boolean p = false;
        public boolean r = false;
        public boolean s = false;
        public int t = 15;
        public int u = 0;
        public boolean v = false;

        public final void a() {
            if (this.s) {
                this.o = false;
            }
            if (this.k.getRwsMode() == 2) {
                this.h = 4;
                if (this.k.getBudRole() == 1) {
                    this.i = 1;
                } else if (this.k.getBudRole() == 2) {
                    this.i = 0;
                }
            } else if (this.k.getRwsMode() == 1) {
                this.h = 4;
                if (this.k.getBudRole() == 1) {
                    this.i = 1;
                } else if (this.k.getBudRole() == 2) {
                    this.i = 0;
                }
                if (this.k.isBankEnabled()) {
                    this.h |= 2;
                } else {
                    this.h |= 3;
                }
            } else if (this.k.isBankEnabled()) {
                this.h = 2;
            } else {
                this.h = 3;
            }
            if (this.q == 19) {
                this.h |= 3;
                if (this.k.isBankEnabled()) {
                    this.t = this.k.getActiveBank();
                }
            }
        }

        public final void b() {
            if (this.s) {
                this.o = false;
            }
            OtaDeviceInfo otaDeviceInfo = this.k;
            if (otaDeviceInfo.specVersion >= 6) {
                this.v = true;
                if (otaDeviceInfo.getRwsMode() == 2) {
                    this.h = 4;
                    if (this.k.getBudRole() == 1) {
                        this.i = 1;
                    } else if (this.k.getBudRole() == 2) {
                        this.i = 0;
                    }
                } else if (this.k.getRwsMode() == 1) {
                    this.h = 4;
                    if (this.k.getBudRole() == 1) {
                        this.i = 1;
                    } else if (this.k.getBudRole() == 2) {
                        this.i = 0;
                    }
                    if (this.k.isBankEnabled()) {
                        this.h |= 2;
                    } else {
                        this.h |= 3;
                    }
                } else if (this.k.isBankEnabled()) {
                    this.h = 2;
                } else {
                    this.h = 3;
                }
                if (this.q == 19) {
                    this.h |= 3;
                    if (this.k.isBankEnabled()) {
                        this.t = this.k.getActiveBank();
                        return;
                    }
                    return;
                }
                return;
            }
            if (otaDeviceInfo.getRwsMode() == 2) {
                this.h = 4;
                if (this.k.getBudRole() == 1) {
                    this.i = 1;
                } else if (this.k.getBudRole() == 2) {
                    this.i = 0;
                }
            } else if (this.k.getRwsMode() == 1) {
                this.h = 4;
                if (this.k.getBudRole() == 1) {
                    this.i = 1;
                } else if (this.k.getBudRole() == 2) {
                    this.i = 0;
                }
                if (this.k.isBankEnabled()) {
                    this.h |= 2;
                } else {
                    this.h |= 3;
                }
            } else if (this.k.isBankEnabled()) {
                this.h = 2;
            } else {
                this.h = 3;
            }
            OtaDeviceInfo otaDeviceInfo2 = this.k;
            if (otaDeviceInfo2.specVersion >= 5 && this.q == 19) {
                this.h |= 3;
                if (otaDeviceInfo2.isBankEnabled()) {
                    this.t = this.k.getActiveBank();
                }
            }
        }

        public LoadParams build() {
            OtaDeviceInfo otaDeviceInfo = this.k;
            if (otaDeviceInfo != null) {
                this.e = otaDeviceInfo.icType;
                this.f = otaDeviceInfo.protocolType;
                this.g = otaDeviceInfo.specVersion;
                this.t = otaDeviceInfo.getUpdateBank();
                this.s = this.k.isBankEnabled();
                this.u = this.k.getImageHeaderOffset();
                OtaDeviceInfo otaDeviceInfo2 = this.k;
                int i = otaDeviceInfo2.protocolType;
                if (i == 16) {
                    a();
                } else if (i == 21) {
                    c();
                } else if (i == 17) {
                    b();
                } else {
                    int i2 = otaDeviceInfo2.icType;
                    if (i2 <= 3 && this.q == 0) {
                        this.s = false;
                    }
                    if (this.s) {
                        if (i2 != 5 && i2 != 9 && i2 != 12) {
                            this.h = 2;
                        } else {
                            this.h = 2;
                        }
                    } else {
                        this.h = 3;
                    }
                }
            } else {
                this.n = false;
                this.l = false;
                this.o = false;
                this.h = 3;
            }
            return new LoadParams(this.f19543a, this.e, this.f, this.g, this.h, this.b, this.c, this.d, this.j, this.s, this.t, this.k, this.l, this.m, this.n, this.o, this.p, this.i, this.q, this.r, this.u, this.v, this.w);
        }

        public final void c() {
            if (this.s) {
                this.o = false;
            }
            OtaDeviceInfo otaDeviceInfo = this.k;
            if (otaDeviceInfo.specVersion == 0) {
                this.l = false;
            }
            if (otaDeviceInfo.getRwsMode() == 2) {
                this.h = 4;
                if (this.k.getBudRole() == 1) {
                    this.i = 1;
                } else if (this.k.getBudRole() == 2) {
                    this.i = 0;
                }
            } else if (this.k.getRwsMode() == 1) {
                this.h = 4;
                if (this.k.getBudRole() == 1) {
                    this.i = 1;
                } else if (this.k.getBudRole() == 2) {
                    this.i = 0;
                }
                if (this.k.isBankEnabled()) {
                    this.h |= 2;
                } else {
                    this.h |= 3;
                }
            } else if (this.k.isBankEnabled()) {
                this.h = 2;
            } else {
                this.h = 3;
            }
            if (this.q == 19) {
                this.h |= 3;
                if (this.k.isBankEnabled()) {
                    this.t = this.k.getActiveBank();
                }
            }
        }

        public Builder dataImageValidateEnabled(boolean z) {
            this.r = z;
            return this;
        }

        public Builder fileLocation(int i) {
            this.b = i;
            return this;
        }

        public void preferredFileType(int i) {
            this.h = i;
        }

        public Builder preferredIcType(int i) {
            this.e = i;
            return this;
        }

        public Builder primaryBudRole(int i) {
            this.i = i;
            return this;
        }

        public Builder setFileIndicator(int i) {
            this.j = i;
            return this;
        }

        public Builder setFilePath(String str) {
            this.c = str;
            return this;
        }

        public Builder setFileSuffix(String str) {
            this.d = str;
            return this;
        }

        public Builder setIcCheckEnabled(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setIgnoreException(boolean z) {
            this.p = z;
            return this;
        }

        public Builder setOtaDeviceInfo(OtaDeviceInfo otaDeviceInfo) {
            this.k = otaDeviceInfo;
            return this;
        }

        public Builder setPreferredBudRole(int i) {
            this.i = i;
            return this;
        }

        public Builder setPreferredIcType(int i) {
            this.e = i;
            return this;
        }

        public Builder setPrimaryIcType(int i) {
            this.e = i;
            return this;
        }

        public Builder setSectionSizeCheckEnabled(boolean z) {
            this.o = z;
            return this;
        }

        public Builder setVersionCheckEnabled(boolean z) {
            return versionCheckEnabled(z);
        }

        public Builder setWorkMode(int i) {
            this.q = i;
            return this;
        }

        public Builder versionCheckEnabled(boolean z) {
            this.l = z;
            return this;
        }

        public Builder vpId(int i) {
            this.w = i;
            return this;
        }

        public Builder with(Context context) {
            this.f19543a = context;
            return this;
        }

        public Builder versionCheckEnabled(boolean z, int i) {
            this.l = z;
            this.m = i;
            return this;
        }
    }

    public Context a() {
        return this.f19542a;
    }

    public int b() {
        return this.j;
    }

    public int c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        if (TextUtils.isEmpty(this.i)) {
            return a.FILE_SUFFIX;
        }
        return this.i;
    }

    public int f() {
        return this.u;
    }

    public OtaDeviceInfo g() {
        return this.k;
    }

    public int h() {
        return this.f;
    }

    public int i() {
        return this.b;
    }

    public int j() {
        return this.c;
    }

    public int k() {
        return this.d;
    }

    public int l() {
        return this.t;
    }

    public int m() {
        return this.m;
    }

    public int n() {
        return this.w;
    }

    public int o() {
        return this.q;
    }

    public boolean p() {
        if ((this.e & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean q() {
        return this.r;
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.n;
    }

    public boolean t() {
        if ((this.e & 2) == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadParams{");
        sb.append(String.format("\n\ticType=0x%02X, protocolType=0x%04X, specVersion=0x%02X", Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)));
        sb.append(String.format("\n\tdualBank=%b, updateBank=0x%02X,singleVpPackAllowedAtDualBank=%b", Boolean.valueOf(this.s), Integer.valueOf(this.t), Boolean.valueOf(this.v)));
        sb.append(String.format("\n\tworkMode=0x%02X, preferredFileType=0x%02X, preferredBudRole=0x%02X", Integer.valueOf(this.q), Integer.valueOf(this.e), Integer.valueOf(this.f)));
        sb.append(String.format("\n\tlocation=0x%02X, indicator=0x%08X, path=%s", Integer.valueOf(this.g), Integer.valueOf(this.j), this.h));
        sb.append(String.format(Locale.US, "\n\tvalidate: versionCheck=%b(%d), icCheck=%b, sectionSizeCheck=%b,ignoreException=%b, dataImageValidate=%b", Boolean.valueOf(this.l), Integer.valueOf(this.m), Boolean.valueOf(this.n), Boolean.valueOf(this.o), Boolean.valueOf(this.p), Boolean.valueOf(this.r)));
        if (this.q == 24) {
            sb.append(String.format("\n\tvpId=0x%04X", Integer.valueOf(this.w)));
        }
        sb.append("\n}");
        return sb.toString();
    }

    public boolean u() {
        return this.o;
    }

    public boolean v() {
        if ((this.e & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean w() {
        return this.v;
    }

    public boolean x() {
        OtaDeviceInfo otaDeviceInfo = this.k;
        if (otaDeviceInfo == null || otaDeviceInfo.getUpdateMechanism() != 3) {
            return false;
        }
        return true;
    }

    public boolean y() {
        return this.l;
    }

    public LoadParams(Context context, int i, int i2, int i3, int i4, int i5, String str, String str2, int i6, boolean z, int i7, OtaDeviceInfo otaDeviceInfo, boolean z2, int i8, boolean z3, boolean z4, boolean z5, int i9, int i10, boolean z6, int i11, boolean z7, int i12) {
        this.f19542a = context;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.g = i5;
        this.h = str;
        this.i = str2;
        this.j = i6;
        this.s = z;
        this.t = i7;
        this.k = otaDeviceInfo;
        this.l = z2;
        this.m = i8;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        this.f = i9;
        this.q = i10;
        this.r = z6;
        this.u = i11;
        this.v = z7;
        this.w = i12;
    }
}
