package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.XX;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class GameRequestContent implements ShareModel {

    @oOoXoXO
    private final ActionType actionType;

    @oOoXoXO
    private final String cta;

    @oOoXoXO
    private final String data;

    @oOoXoXO
    private final Filters filters;

    @oOoXoXO
    private final String message;

    @oOoXoXO
    private final String objectId;

    @oOoXoXO
    private final List<String> recipients;

    @oOoXoXO
    private final List<String> suggestions;

    @oOoXoXO
    private final String title;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() { // from class: com.facebook.share.model.GameRequestContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public GameRequestContent createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new GameRequestContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    };

    /* loaded from: classes8.dex */
    public enum ActionType {
        SEND,
        ASKFOR,
        TURN,
        INVITE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ActionType[] valuesCustom() {
            ActionType[] valuesCustom = values();
            return (ActionType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Builder implements ShareModelBuilder<GameRequestContent, Builder> {

        @oOoXoXO
        private ActionType actionType;

        @oOoXoXO
        private String cta;

        @oOoXoXO
        private String data;

        @oOoXoXO
        private Filters filters;

        @oOoXoXO
        private String message;

        @oOoXoXO
        private String objectId;

        @oOoXoXO
        private List<String> recipients;

        @oOoXoXO
        private List<String> suggestions;

        @oOoXoXO
        private String title;

        @oOoXoXO
        public final ActionType getActionType$facebook_common_release() {
            return this.actionType;
        }

        @oOoXoXO
        public final String getCta$facebook_common_release() {
            return this.cta;
        }

        @oOoXoXO
        public final String getData$facebook_common_release() {
            return this.data;
        }

        @oOoXoXO
        public final Filters getFilters$facebook_common_release() {
            return this.filters;
        }

        @oOoXoXO
        public final String getMessage$facebook_common_release() {
            return this.message;
        }

        @oOoXoXO
        public final String getObjectId$facebook_common_release() {
            return this.objectId;
        }

        @oOoXoXO
        public final List<String> getRecipients$facebook_common_release() {
            return this.recipients;
        }

        @oOoXoXO
        public final List<String> getSuggestions$facebook_common_release() {
            return this.suggestions;
        }

        @oOoXoXO
        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        @OOXIXo
        public final Builder readFrom$facebook_common_release(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
        }

        @OOXIXo
        public final Builder setActionType(@oOoXoXO ActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public final void setActionType$facebook_common_release(@oOoXoXO ActionType actionType) {
            this.actionType = actionType;
        }

        @OOXIXo
        public final Builder setCta(@oOoXoXO String str) {
            this.cta = str;
            return this;
        }

        public final void setCta$facebook_common_release(@oOoXoXO String str) {
            this.cta = str;
        }

        @OOXIXo
        public final Builder setData(@oOoXoXO String str) {
            this.data = str;
            return this;
        }

        public final void setData$facebook_common_release(@oOoXoXO String str) {
            this.data = str;
        }

        @OOXIXo
        public final Builder setFilters(@oOoXoXO Filters filters) {
            this.filters = filters;
            return this;
        }

        public final void setFilters$facebook_common_release(@oOoXoXO Filters filters) {
            this.filters = filters;
        }

        @OOXIXo
        public final Builder setMessage(@oOoXoXO String str) {
            this.message = str;
            return this;
        }

        public final void setMessage$facebook_common_release(@oOoXoXO String str) {
            this.message = str;
        }

        @OOXIXo
        public final Builder setObjectId(@oOoXoXO String str) {
            this.objectId = str;
            return this;
        }

        public final void setObjectId$facebook_common_release(@oOoXoXO String str) {
            this.objectId = str;
        }

        @OOXIXo
        public final Builder setRecipients(@oOoXoXO List<String> list) {
            this.recipients = list;
            return this;
        }

        public final void setRecipients$facebook_common_release(@oOoXoXO List<String> list) {
            this.recipients = list;
        }

        @OOXIXo
        public final Builder setSuggestions(@oOoXoXO List<String> list) {
            this.suggestions = list;
            return this;
        }

        public final void setSuggestions$facebook_common_release(@oOoXoXO List<String> list) {
            this.suggestions = list;
        }

        @OOXIXo
        public final Builder setTitle(@oOoXoXO String str) {
            this.title = str;
            return this;
        }

        public final void setTitle$facebook_common_release(@oOoXoXO String str) {
            this.title = str;
        }

        @kotlin.OOXIXo(message = "Replaced by {@link #setRecipients(List)}")
        @OOXIXo
        public final Builder setTo(@oOoXoXO String str) {
            if (str != null) {
                this.recipients = CollectionsKt___CollectionsKt.oOo0o(StringsKt__StringsKt.Xxx0oXX(str, new char[]{','}, false, 0, 6, null));
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public GameRequestContent build() {
            return new GameRequestContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO GameRequestContent gameRequestContent) {
            return gameRequestContent == null ? this : setMessage(gameRequestContent.getMessage()).setCta(gameRequestContent.getCta()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public enum Filters {
        APP_USERS,
        APP_NON_USERS,
        EVERYBODY;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Filters[] valuesCustom() {
            Filters[] valuesCustom = values();
            return (Filters[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public /* synthetic */ GameRequestContent(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final ActionType getActionType() {
        return this.actionType;
    }

    @oOoXoXO
    public final String getCta() {
        return this.cta;
    }

    @oOoXoXO
    public final String getData() {
        return this.data;
    }

    @oOoXoXO
    public final Filters getFilters() {
        return this.filters;
    }

    @oOoXoXO
    public final String getMessage() {
        return this.message;
    }

    @oOoXoXO
    public final String getObjectId() {
        return this.objectId;
    }

    @oOoXoXO
    public final List<String> getRecipients() {
        return this.recipients;
    }

    @oOoXoXO
    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    @oOoXoXO
    public final String getTitle() {
        return this.title;
    }

    @kotlin.OOXIXo(message = "Replaced by [getRecipients()]", replaceWith = @XX(expression = "getRecipients", imports = {}))
    @oOoXoXO
    public final String getTo() {
        List<String> list = this.recipients;
        if (list != null) {
            return TextUtils.join(",", list);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeString(this.message);
        out.writeString(this.cta);
        out.writeStringList(this.recipients);
        out.writeString(this.title);
        out.writeString(this.data);
        out.writeSerializable(this.actionType);
        out.writeString(this.objectId);
        out.writeSerializable(this.filters);
        out.writeStringList(this.suggestions);
    }

    private GameRequestContent(Builder builder) {
        this.message = builder.getMessage$facebook_common_release();
        this.cta = builder.getCta$facebook_common_release();
        this.recipients = builder.getRecipients$facebook_common_release();
        this.title = builder.getTitle$facebook_common_release();
        this.data = builder.getData$facebook_common_release();
        this.actionType = builder.getActionType$facebook_common_release();
        this.objectId = builder.getObjectId$facebook_common_release();
        this.filters = builder.getFilters$facebook_common_release();
        this.suggestions = builder.getSuggestions$facebook_common_release();
    }

    public GameRequestContent(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        this.message = parcel.readString();
        this.cta = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
    }
}
