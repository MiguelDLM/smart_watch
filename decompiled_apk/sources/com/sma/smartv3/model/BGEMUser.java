package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMUser extends JsonFieldContainer {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private int age;

    @OOXIXo
    private String appUserId;

    @OOXIXo
    private String device_id;
    private boolean family_history;

    @OOXIXo
    private BGEMGender gender;

    @OOXIXo
    private String glicemiaUserId;
    private int height;
    private boolean high_cholesterol;
    private int weight;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BGEMUser of(@OOXIXo AppUser appUser) {
            BGEMGender bGEMGender;
            IIX0o.x0xO0oo(appUser, "appUser");
            int ageByBirth = WeightMeasureDataKt.getAgeByBirth(appUser.getBirthday());
            if (appUser.getGender() == 1) {
                bGEMGender = BGEMGender.M;
            } else {
                bGEMGender = BGEMGender.F;
            }
            return new BGEMUser(null, null, ageByBirth, bGEMGender, (int) appUser.getWeight(), (int) appUser.getHeight(), null, Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24364IO0XoXxO, false), false, 67, null);
        }

        private Companion() {
        }
    }

    public BGEMUser() {
        this(null, null, 0, null, 0, 0, null, false, false, 511, null);
    }

    @OOXIXo
    public final String component1() {
        return this.appUserId;
    }

    @OOXIXo
    public final String component2() {
        return this.glicemiaUserId;
    }

    public final int component3() {
        return this.age;
    }

    @OOXIXo
    public final BGEMGender component4() {
        return this.gender;
    }

    public final int component5() {
        return this.weight;
    }

    public final int component6() {
        return this.height;
    }

    @OOXIXo
    public final String component7() {
        return this.device_id;
    }

    public final boolean component8() {
        return this.family_history;
    }

    public final boolean component9() {
        return this.high_cholesterol;
    }

    @OOXIXo
    public final BGEMUser copy(@OOXIXo String appUserId, @OOXIXo String glicemiaUserId, int i, @OOXIXo BGEMGender gender, int i2, int i3, @OOXIXo String device_id, boolean z, boolean z2) {
        IIX0o.x0xO0oo(appUserId, "appUserId");
        IIX0o.x0xO0oo(glicemiaUserId, "glicemiaUserId");
        IIX0o.x0xO0oo(gender, "gender");
        IIX0o.x0xO0oo(device_id, "device_id");
        return new BGEMUser(appUserId, glicemiaUserId, i, gender, i2, i3, device_id, z, z2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMUser)) {
            return false;
        }
        BGEMUser bGEMUser = (BGEMUser) obj;
        return IIX0o.Oxx0IOOO(this.appUserId, bGEMUser.appUserId) && IIX0o.Oxx0IOOO(this.glicemiaUserId, bGEMUser.glicemiaUserId) && this.age == bGEMUser.age && this.gender == bGEMUser.gender && this.weight == bGEMUser.weight && this.height == bGEMUser.height && IIX0o.Oxx0IOOO(this.device_id, bGEMUser.device_id) && this.family_history == bGEMUser.family_history && this.high_cholesterol == bGEMUser.high_cholesterol;
    }

    public final int getAge() {
        return this.age;
    }

    @OOXIXo
    public final String getAppUserId() {
        return this.appUserId;
    }

    @OOXIXo
    public final String getDevice_id() {
        return this.device_id;
    }

    public final boolean getFamily_history() {
        return this.family_history;
    }

    @OOXIXo
    public final BGEMGender getGender() {
        return this.gender;
    }

    @OOXIXo
    public final String getGlicemiaUserId() {
        return this.glicemiaUserId;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean getHigh_cholesterol() {
        return this.high_cholesterol;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((((((((((this.appUserId.hashCode() * 31) + this.glicemiaUserId.hashCode()) * 31) + this.age) * 31) + this.gender.hashCode()) * 31) + this.weight) * 31) + this.height) * 31) + this.device_id.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.family_history)) * 31) + androidx.work.oIX0oI.oIX0oI(this.high_cholesterol);
    }

    public final void setAge(int i) {
        this.age = i;
    }

    public final void setAppUserId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.appUserId = str;
    }

    public final void setDevice_id(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.device_id = str;
    }

    public final void setFamily_history(boolean z) {
        this.family_history = z;
    }

    public final void setGender(@OOXIXo BGEMGender bGEMGender) {
        IIX0o.x0xO0oo(bGEMGender, "<set-?>");
        this.gender = bGEMGender;
    }

    public final void setGlicemiaUserId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.glicemiaUserId = str;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setHigh_cholesterol(boolean z) {
        this.high_cholesterol = z;
    }

    public final void setWeight(int i) {
        this.weight = i;
    }

    @OOXIXo
    public String toString() {
        return "BGEMUser(appUserId=" + this.appUserId + ", glicemiaUserId=" + this.glicemiaUserId + ", age=" + this.age + ", gender=" + this.gender + ", weight=" + this.weight + ", height=" + this.height + ", device_id=" + this.device_id + ", family_history=" + this.family_history + ", high_cholesterol=" + this.high_cholesterol + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BGEMUser(String str, String str2, int i, BGEMGender bGEMGender, int i2, int i3, String str3, boolean z, boolean z2, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? BGEMGender.M : bGEMGender, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) == 0 ? str3 : "", (i4 & 128) != 0 ? false : z, (i4 & 256) == 0 ? z2 : false);
    }

    public BGEMUser(@OOXIXo String appUserId, @OOXIXo String glicemiaUserId, int i, @OOXIXo BGEMGender gender, int i2, int i3, @OOXIXo String device_id, boolean z, boolean z2) {
        IIX0o.x0xO0oo(appUserId, "appUserId");
        IIX0o.x0xO0oo(glicemiaUserId, "glicemiaUserId");
        IIX0o.x0xO0oo(gender, "gender");
        IIX0o.x0xO0oo(device_id, "device_id");
        this.appUserId = appUserId;
        this.glicemiaUserId = glicemiaUserId;
        this.age = i;
        this.gender = gender;
        this.weight = i2;
        this.height = i3;
        this.device_id = device_id;
        this.family_history = z;
        this.high_cholesterol = z2;
    }
}
