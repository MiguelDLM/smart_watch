package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class Profile implements Parcelable {

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<Profile> CREATOR;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String FIRST_NAME_KEY = "first_name";

    @OXOo.OOXIXo
    private static final String ID_KEY = "id";

    @OXOo.OOXIXo
    private static final String LAST_NAME_KEY = "last_name";

    @OXOo.OOXIXo
    private static final String LINK_URI_KEY = "link_uri";

    @OXOo.OOXIXo
    private static final String MIDDLE_NAME_KEY = "middle_name";

    @OXOo.OOXIXo
    private static final String NAME_KEY = "name";

    @OXOo.OOXIXo
    private static final String PICTURE_URI_KEY = "picture_uri";

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.oOoXoXO
    private final String firstName;

    @OXOo.oOoXoXO
    private final String id;

    @OXOo.oOoXoXO
    private final String lastName;

    @OXOo.oOoXoXO
    private final Uri linkUri;

    @OXOo.oOoXoXO
    private final String middleName;

    @OXOo.oOoXoXO
    private final String name;

    @OXOo.oOoXoXO
    private final Uri pictureUri;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        public final void fetchProfileForCurrentAccessToken() {
            AccessToken.Companion companion = AccessToken.Companion;
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            if (currentAccessToken == null) {
                return;
            }
            if (!companion.isCurrentAccessTokenActive()) {
                setCurrentProfile(null);
            } else {
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback() { // from class: com.facebook.Profile$Companion$fetchProfileForCurrentAccessToken$1
                    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                    public void onFailure(@OXOo.oOoXoXO FacebookException facebookException) {
                        String str;
                        str = Profile.TAG;
                        Log.e(str, IIX0o.XIxXXX0x0("Got unexpected exception: ", facebookException));
                    }

                    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                    public void onSuccess(@OXOo.oOoXoXO JSONObject jSONObject) {
                        String optString;
                        Uri uri;
                        String str;
                        Uri uri2 = null;
                        if (jSONObject == null) {
                            optString = null;
                        } else {
                            optString = jSONObject.optString("id");
                        }
                        if (optString == null) {
                            str = Profile.TAG;
                            Log.w(str, "No user ID returned on Me request");
                            return;
                        }
                        String optString2 = jSONObject.optString("link");
                        String optString3 = jSONObject.optString("profile_picture", null);
                        String optString4 = jSONObject.optString("first_name");
                        String optString5 = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
                        String optString6 = jSONObject.optString("last_name");
                        String optString7 = jSONObject.optString("name");
                        if (optString2 != null) {
                            uri = Uri.parse(optString2);
                        } else {
                            uri = null;
                        }
                        if (optString3 != null) {
                            uri2 = Uri.parse(optString3);
                        }
                        Profile.Companion.setCurrentProfile(new Profile(optString, optString4, optString5, optString6, optString7, uri, uri2));
                    }
                });
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final Profile getCurrentProfile() {
            return ProfileManager.Companion.getInstance().getCurrentProfile();
        }

        @XO0OX.x0XOIxOo
        public final void setCurrentProfile(@OXOo.oOoXoXO Profile profile) {
            ProfileManager.Companion.getInstance().setCurrentProfile(profile);
        }

        private Companion() {
        }
    }

    static {
        String simpleName = Profile.class.getSimpleName();
        IIX0o.oO(simpleName, "Profile::class.java.simpleName");
        TAG = simpleName;
        CREATOR = new Parcelable.Creator<Profile>() { // from class: com.facebook.Profile$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public Profile createFromParcel(@OXOo.OOXIXo Parcel source) {
                IIX0o.x0xO0oo(source, "source");
                return new Profile(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public Profile[] newArray(int i) {
                return new Profile[i];
            }
        };
    }

    public /* synthetic */ Profile(Parcel parcel, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(parcel);
    }

    @XO0OX.x0XOIxOo
    public static final void fetchProfileForCurrentAccessToken() {
        Companion.fetchProfileForCurrentAccessToken();
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Profile getCurrentProfile() {
        return Companion.getCurrentProfile();
    }

    @XO0OX.x0XOIxOo
    public static final void setCurrentProfile(@OXOo.oOoXoXO Profile profile) {
        Companion.setCurrentProfile(profile);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.id;
        if (((str5 == null && ((Profile) obj).id == null) || IIX0o.Oxx0IOOO(str5, ((Profile) obj).id)) && ((((str = this.firstName) == null && ((Profile) obj).firstName == null) || IIX0o.Oxx0IOOO(str, ((Profile) obj).firstName)) && ((((str2 = this.middleName) == null && ((Profile) obj).middleName == null) || IIX0o.Oxx0IOOO(str2, ((Profile) obj).middleName)) && ((((str3 = this.lastName) == null && ((Profile) obj).lastName == null) || IIX0o.Oxx0IOOO(str3, ((Profile) obj).lastName)) && ((((str4 = this.name) == null && ((Profile) obj).name == null) || IIX0o.Oxx0IOOO(str4, ((Profile) obj).name)) && ((((uri = this.linkUri) == null && ((Profile) obj).linkUri == null) || IIX0o.Oxx0IOOO(uri, ((Profile) obj).linkUri)) && (((uri2 = this.pictureUri) == null && ((Profile) obj).pictureUri == null) || IIX0o.Oxx0IOOO(uri2, ((Profile) obj).pictureUri)))))))) {
            return true;
        }
        return false;
    }

    @OXOo.oOoXoXO
    public final String getFirstName() {
        return this.firstName;
    }

    @OXOo.oOoXoXO
    public final String getId() {
        return this.id;
    }

    @OXOo.oOoXoXO
    public final String getLastName() {
        return this.lastName;
    }

    @OXOo.oOoXoXO
    public final Uri getLinkUri() {
        return this.linkUri;
    }

    @OXOo.oOoXoXO
    public final String getMiddleName() {
        return this.middleName;
    }

    @OXOo.oOoXoXO
    public final String getName() {
        return this.name;
    }

    @OXOo.oOoXoXO
    public final Uri getPictureUri() {
        return this.pictureUri;
    }

    @OXOo.OOXIXo
    public final Uri getProfilePictureUri(int i, int i2) {
        String str;
        Uri uri = this.pictureUri;
        if (uri != null) {
            return uri;
        }
        AccessToken.Companion companion = AccessToken.Companion;
        if (companion.isCurrentAccessTokenActive()) {
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            if (currentAccessToken == null) {
                str = null;
            } else {
                str = currentAccessToken.getToken();
            }
        } else {
            str = "";
        }
        return ImageRequest.Companion.getProfilePictureUri(this.id, i, i2, str);
    }

    public int hashCode() {
        int i;
        String str = this.id;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i2 = 527 + i;
        String str2 = this.firstName;
        if (str2 != null) {
            i2 = (i2 * 31) + str2.hashCode();
        }
        String str3 = this.middleName;
        if (str3 != null) {
            i2 = (i2 * 31) + str3.hashCode();
        }
        String str4 = this.lastName;
        if (str4 != null) {
            i2 = (i2 * 31) + str4.hashCode();
        }
        String str5 = this.name;
        if (str5 != null) {
            i2 = (i2 * 31) + str5.hashCode();
        }
        Uri uri = this.linkUri;
        if (uri != null) {
            i2 = (i2 * 31) + uri.hashCode();
        }
        Uri uri2 = this.pictureUri;
        if (uri2 != null) {
            return (i2 * 31) + uri2.hashCode();
        }
        return i2;
    }

    @OXOo.oOoXoXO
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put("middle_name", this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            Uri uri = this.linkUri;
            if (uri != null) {
                jSONObject.put(LINK_URI_KEY, uri.toString());
            }
            Uri uri2 = this.pictureUri;
            if (uri2 != null) {
                jSONObject.put(PICTURE_URI_KEY, uri2.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        String uri;
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.middleName);
        dest.writeString(this.lastName);
        dest.writeString(this.name);
        Uri uri2 = this.linkUri;
        String str = null;
        if (uri2 == null) {
            uri = null;
        } else {
            uri = uri2.toString();
        }
        dest.writeString(uri);
        Uri uri3 = this.pictureUri;
        if (uri3 != null) {
            str = uri3.toString();
        }
        dest.writeString(str);
    }

    @XO0OX.xoIox
    public Profile(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO Uri uri) {
        this(str, str2, str3, str4, str5, uri, null, 64, null);
    }

    public /* synthetic */ Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(str, str2, str3, str4, str5, uri, (i & 64) != 0 ? null : uri2);
    }

    @XO0OX.xoIox
    public Profile(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO Uri uri, @OXOo.oOoXoXO Uri uri2) {
        Validate validate = Validate.INSTANCE;
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        this.pictureUri = uri2;
    }

    public Profile(@OXOo.OOXIXo JSONObject jsonObject) {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        this.id = jsonObject.optString("id", null);
        this.firstName = jsonObject.optString(FIRST_NAME_KEY, null);
        this.middleName = jsonObject.optString("middle_name", null);
        this.lastName = jsonObject.optString(LAST_NAME_KEY, null);
        this.name = jsonObject.optString("name", null);
        String optString = jsonObject.optString(LINK_URI_KEY, null);
        this.linkUri = optString == null ? null : Uri.parse(optString);
        String optString2 = jsonObject.optString(PICTURE_URI_KEY, null);
        this.pictureUri = optString2 != null ? Uri.parse(optString2) : null;
    }

    private Profile(Parcel parcel) {
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        this.linkUri = readString == null ? null : Uri.parse(readString);
        String readString2 = parcel.readString();
        this.pictureUri = readString2 != null ? Uri.parse(readString2) : null;
    }
}
