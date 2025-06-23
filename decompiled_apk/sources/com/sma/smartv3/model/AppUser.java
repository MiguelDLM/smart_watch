package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleUserProfile;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AppUser extends JsonFieldContainer {

    @OOXIXo
    private String avatarUrl;

    @OOXIXo
    private String birthday;

    @OOXIXo
    private String city;

    @OOXIXo
    private String country;

    @OOXIXo
    private String dbUrl;

    @OOXIXo
    private String email;

    @OOXIXo
    private String extraInfo;
    private int gender;
    private float height;

    @OOXIXo
    private String identity;
    private float latitude;
    private float longitude;

    @OOXIXo
    private String nickname;

    @OOXIXo
    private String osVersion;

    @OOXIXo
    private String phone;

    @OOXIXo
    private String phoneIdentity;

    @OOXIXo
    private String phoneModel;
    private int phoneOs;
    private int projectId;

    @OOXIXo
    private String receivePhone;
    private int server;

    @OOXIXo
    private String settings;

    @oOoXoXO
    private ThirdPlatform thirdPlatform;

    @OOXIXo
    private String token;
    private int unit;
    private float weight;

    public AppUser() {
        this(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
    }

    public final int component1() {
        return this.projectId;
    }

    public final float component10() {
        return this.height;
    }

    public final float component11() {
        return this.weight;
    }

    @OOXIXo
    public final String component12() {
        return this.identity;
    }

    @OOXIXo
    public final String component13() {
        return this.token;
    }

    @OOXIXo
    public final String component14() {
        return this.extraInfo;
    }

    @OOXIXo
    public final String component15() {
        return this.dbUrl;
    }

    @OOXIXo
    public final String component16() {
        return this.country;
    }

    @OOXIXo
    public final String component17() {
        return this.city;
    }

    public final float component18() {
        return this.longitude;
    }

    public final float component19() {
        return this.latitude;
    }

    @OOXIXo
    public final String component2() {
        return this.phone;
    }

    public final int component20() {
        return this.server;
    }

    public final int component21() {
        return this.phoneOs;
    }

    @OOXIXo
    public final String component22() {
        return this.osVersion;
    }

    @OOXIXo
    public final String component23() {
        return this.phoneModel;
    }

    @OOXIXo
    public final String component24() {
        return this.phoneIdentity;
    }

    @OOXIXo
    public final String component25() {
        return this.settings;
    }

    @oOoXoXO
    public final ThirdPlatform component26() {
        return this.thirdPlatform;
    }

    @OOXIXo
    public final String component3() {
        return this.email;
    }

    @OOXIXo
    public final String component4() {
        return this.receivePhone;
    }

    @OOXIXo
    public final String component5() {
        return this.nickname;
    }

    @OOXIXo
    public final String component6() {
        return this.avatarUrl;
    }

    @OOXIXo
    public final String component7() {
        return this.birthday;
    }

    public final int component8() {
        return this.gender;
    }

    public final int component9() {
        return this.unit;
    }

    @OOXIXo
    public final AppUser copy(int i, @OOXIXo String phone, @OOXIXo String email, @OOXIXo String receivePhone, @OOXIXo String nickname, @OOXIXo String avatarUrl, @OOXIXo String birthday, int i2, int i3, float f, float f2, @OOXIXo String identity, @OOXIXo String token, @OOXIXo String extraInfo, @OOXIXo String dbUrl, @OOXIXo String country, @OOXIXo String city, float f3, float f4, int i4, int i5, @OOXIXo String osVersion, @OOXIXo String phoneModel, @OOXIXo String phoneIdentity, @OOXIXo String settings, @oOoXoXO ThirdPlatform thirdPlatform) {
        IIX0o.x0xO0oo(phone, "phone");
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(receivePhone, "receivePhone");
        IIX0o.x0xO0oo(nickname, "nickname");
        IIX0o.x0xO0oo(avatarUrl, "avatarUrl");
        IIX0o.x0xO0oo(birthday, "birthday");
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(extraInfo, "extraInfo");
        IIX0o.x0xO0oo(dbUrl, "dbUrl");
        IIX0o.x0xO0oo(country, "country");
        IIX0o.x0xO0oo(city, "city");
        IIX0o.x0xO0oo(osVersion, "osVersion");
        IIX0o.x0xO0oo(phoneModel, "phoneModel");
        IIX0o.x0xO0oo(phoneIdentity, "phoneIdentity");
        IIX0o.x0xO0oo(settings, "settings");
        return new AppUser(i, phone, email, receivePhone, nickname, avatarUrl, birthday, i2, i3, f, f2, identity, token, extraInfo, dbUrl, country, city, f3, f4, i4, i5, osVersion, phoneModel, phoneIdentity, settings, thirdPlatform);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUser)) {
            return false;
        }
        AppUser appUser = (AppUser) obj;
        return this.projectId == appUser.projectId && IIX0o.Oxx0IOOO(this.phone, appUser.phone) && IIX0o.Oxx0IOOO(this.email, appUser.email) && IIX0o.Oxx0IOOO(this.receivePhone, appUser.receivePhone) && IIX0o.Oxx0IOOO(this.nickname, appUser.nickname) && IIX0o.Oxx0IOOO(this.avatarUrl, appUser.avatarUrl) && IIX0o.Oxx0IOOO(this.birthday, appUser.birthday) && this.gender == appUser.gender && this.unit == appUser.unit && Float.compare(this.height, appUser.height) == 0 && Float.compare(this.weight, appUser.weight) == 0 && IIX0o.Oxx0IOOO(this.identity, appUser.identity) && IIX0o.Oxx0IOOO(this.token, appUser.token) && IIX0o.Oxx0IOOO(this.extraInfo, appUser.extraInfo) && IIX0o.Oxx0IOOO(this.dbUrl, appUser.dbUrl) && IIX0o.Oxx0IOOO(this.country, appUser.country) && IIX0o.Oxx0IOOO(this.city, appUser.city) && Float.compare(this.longitude, appUser.longitude) == 0 && Float.compare(this.latitude, appUser.latitude) == 0 && this.server == appUser.server && this.phoneOs == appUser.phoneOs && IIX0o.Oxx0IOOO(this.osVersion, appUser.osVersion) && IIX0o.Oxx0IOOO(this.phoneModel, appUser.phoneModel) && IIX0o.Oxx0IOOO(this.phoneIdentity, appUser.phoneIdentity) && IIX0o.Oxx0IOOO(this.settings, appUser.settings) && IIX0o.Oxx0IOOO(this.thirdPlatform, appUser.thirdPlatform);
    }

    @OOXIXo
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @OOXIXo
    public final String getBirthday() {
        return this.birthday;
    }

    @OOXIXo
    public final BleUserProfile getBleUserProfile() {
        return new BleUserProfile(this.unit, this.gender, 0, this.height, this.weight, 4, null);
    }

    @OOXIXo
    public final String getCity() {
        return this.city;
    }

    @OOXIXo
    public final String getCountry() {
        return this.country;
    }

    @OOXIXo
    public final String getDbUrl() {
        return this.dbUrl;
    }

    @OOXIXo
    public final String getEmail() {
        return this.email;
    }

    @OOXIXo
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final int getGender() {
        return this.gender;
    }

    public final float getHeight() {
        return this.height;
    }

    @OOXIXo
    public final String getIdentity() {
        return this.identity;
    }

    public final float getLatitude() {
        return this.latitude;
    }

    public final float getLongitude() {
        return this.longitude;
    }

    @OOXIXo
    public final String getNickname() {
        return this.nickname;
    }

    @OOXIXo
    public final String getOsVersion() {
        return this.osVersion;
    }

    @OOXIXo
    public final String getPhone() {
        return this.phone;
    }

    @OOXIXo
    public final String getPhoneIdentity() {
        return this.phoneIdentity;
    }

    @OOXIXo
    public final String getPhoneModel() {
        return this.phoneModel;
    }

    public final int getPhoneOs() {
        return this.phoneOs;
    }

    public final int getProjectId() {
        return this.projectId;
    }

    @OOXIXo
    public final String getReceivePhone() {
        return this.receivePhone;
    }

    public final int getServer() {
        return this.server;
    }

    @OOXIXo
    public final String getSettings() {
        return this.settings;
    }

    @oOoXoXO
    public final ThirdPlatform getThirdPlatform() {
        return this.thirdPlatform;
    }

    @OOXIXo
    public final String getToken() {
        return this.token;
    }

    public final int getUnit() {
        return this.unit;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((((((((((((((((((((((((((((((((((this.projectId * 31) + this.phone.hashCode()) * 31) + this.email.hashCode()) * 31) + this.receivePhone.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.birthday.hashCode()) * 31) + this.gender) * 31) + this.unit) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.weight)) * 31) + this.identity.hashCode()) * 31) + this.token.hashCode()) * 31) + this.extraInfo.hashCode()) * 31) + this.dbUrl.hashCode()) * 31) + this.country.hashCode()) * 31) + this.city.hashCode()) * 31) + Float.floatToIntBits(this.longitude)) * 31) + Float.floatToIntBits(this.latitude)) * 31) + this.server) * 31) + this.phoneOs) * 31) + this.osVersion.hashCode()) * 31) + this.phoneModel.hashCode()) * 31) + this.phoneIdentity.hashCode()) * 31) + this.settings.hashCode()) * 31;
        ThirdPlatform thirdPlatform = this.thirdPlatform;
        if (thirdPlatform == null) {
            hashCode = 0;
        } else {
            hashCode = thirdPlatform.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setAvatarUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.avatarUrl = str;
    }

    public final void setBirthday(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.birthday = str;
    }

    public final void setCity(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.city = str;
    }

    public final void setCountry(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.country = str;
    }

    public final void setDbUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.dbUrl = str;
    }

    public final void setEmail(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.email = str;
    }

    public final void setExtraInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.extraInfo = str;
    }

    public final void setGender(int i) {
        this.gender = i;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final void setIdentity(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.identity = str;
    }

    public final void setLatitude(float f) {
        this.latitude = f;
    }

    public final void setLongitude(float f) {
        this.longitude = f;
    }

    public final void setNickname(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.nickname = str;
    }

    public final void setOsVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.osVersion = str;
    }

    public final void setPhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.phone = str;
    }

    public final void setPhoneIdentity(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.phoneIdentity = str;
    }

    public final void setPhoneModel(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.phoneModel = str;
    }

    public final void setPhoneOs(int i) {
        this.phoneOs = i;
    }

    public final void setProjectId(int i) {
        this.projectId = i;
    }

    public final void setReceivePhone(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.receivePhone = str;
    }

    public final void setServer(int i) {
        this.server = i;
    }

    public final void setSettings(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.settings = str;
    }

    public final void setThirdPlatform(@oOoXoXO ThirdPlatform thirdPlatform) {
        this.thirdPlatform = thirdPlatform;
    }

    public final void setToken(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.token = str;
    }

    public final void setUnit(int i) {
        this.unit = i;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    @OOXIXo
    public String toString() {
        return "AppUser(projectId=" + this.projectId + ", phone=" + this.phone + ", email=" + this.email + ", receivePhone=" + this.receivePhone + ", nickname=" + this.nickname + ", avatarUrl=" + this.avatarUrl + ", birthday=" + this.birthday + ", gender=" + this.gender + ", unit=" + this.unit + ", height=" + this.height + ", weight=" + this.weight + ", identity=" + this.identity + ", token=" + this.token + ", extraInfo=" + this.extraInfo + ", dbUrl=" + this.dbUrl + ", country=" + this.country + ", city=" + this.city + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", server=" + this.server + ", phoneOs=" + this.phoneOs + ", osVersion=" + this.osVersion + ", phoneModel=" + this.phoneModel + ", phoneIdentity=" + this.phoneIdentity + ", settings=" + this.settings + ", thirdPlatform=" + this.thirdPlatform + HexStringBuilder.COMMENT_END_CHAR;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AppUser(int r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, int r36, float r37, float r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, float r45, float r46, int r47, int r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, com.sma.smartv3.model.ThirdPlatform r53, int r54, kotlin.jvm.internal.IIXOooo r55) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.model.AppUser.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, float, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, float, float, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.sma.smartv3.model.ThirdPlatform, int, kotlin.jvm.internal.IIXOooo):void");
    }

    public AppUser(int i, @OOXIXo String phone, @OOXIXo String email, @OOXIXo String receivePhone, @OOXIXo String nickname, @OOXIXo String avatarUrl, @OOXIXo String birthday, int i2, int i3, float f, float f2, @OOXIXo String identity, @OOXIXo String token, @OOXIXo String extraInfo, @OOXIXo String dbUrl, @OOXIXo String country, @OOXIXo String city, float f3, float f4, int i4, int i5, @OOXIXo String osVersion, @OOXIXo String phoneModel, @OOXIXo String phoneIdentity, @OOXIXo String settings, @oOoXoXO ThirdPlatform thirdPlatform) {
        IIX0o.x0xO0oo(phone, "phone");
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(receivePhone, "receivePhone");
        IIX0o.x0xO0oo(nickname, "nickname");
        IIX0o.x0xO0oo(avatarUrl, "avatarUrl");
        IIX0o.x0xO0oo(birthday, "birthday");
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(extraInfo, "extraInfo");
        IIX0o.x0xO0oo(dbUrl, "dbUrl");
        IIX0o.x0xO0oo(country, "country");
        IIX0o.x0xO0oo(city, "city");
        IIX0o.x0xO0oo(osVersion, "osVersion");
        IIX0o.x0xO0oo(phoneModel, "phoneModel");
        IIX0o.x0xO0oo(phoneIdentity, "phoneIdentity");
        IIX0o.x0xO0oo(settings, "settings");
        this.projectId = i;
        this.phone = phone;
        this.email = email;
        this.receivePhone = receivePhone;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.birthday = birthday;
        this.gender = i2;
        this.unit = i3;
        this.height = f;
        this.weight = f2;
        this.identity = identity;
        this.token = token;
        this.extraInfo = extraInfo;
        this.dbUrl = dbUrl;
        this.country = country;
        this.city = city;
        this.longitude = f3;
        this.latitude = f4;
        this.server = i4;
        this.phoneOs = i5;
        this.osVersion = osVersion;
        this.phoneModel = phoneModel;
        this.phoneIdentity = phoneIdentity;
        this.settings = settings;
        this.thirdPlatform = thirdPlatform;
    }
}
