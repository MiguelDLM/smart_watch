package com.facebook.share.internal;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class WebDialogParameters {

    @OOXIXo
    public static final WebDialogParameters INSTANCE = new WebDialogParameters();

    private WebDialogParameters() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final Bundle create(@OOXIXo AppGroupCreationContent appGroupCreationContent) {
        String obj;
        IIX0o.x0xO0oo(appGroupCreationContent, "appGroupCreationContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        AppGroupCreationContent.AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        String str = null;
        if (appGroupPrivacy != null && (obj = appGroupPrivacy.toString()) != null) {
            Locale ENGLISH = Locale.ENGLISH;
            IIX0o.oO(ENGLISH, "ENGLISH");
            str = obj.toLowerCase(ENGLISH);
            IIX0o.oO(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, str);
        return bundle;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Bundle createBaseParameters(@OOXIXo ShareContent<?, ?> shareContent) {
        String hashtag;
        IIX0o.x0xO0oo(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag == null) {
            hashtag = null;
        } else {
            hashtag = shareHashtag.getHashtag();
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, hashtag);
        return bundle;
    }

    @x0XOIxOo
    @OOXIXo
    @SuppressLint({"DeprecatedMethod"})
    public static final Bundle createForFeed(@OOXIXo ShareLinkContent shareLinkContent) {
        IIX0o.x0xO0oo(shareLinkContent, "shareLinkContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        ShareHashtag shareHashtag = shareLinkContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Bundle create(@OOXIXo GameRequestContent gameRequestContent) {
        String obj;
        String lowerCase;
        String obj2;
        IIX0o.x0xO0oo(gameRequestContent, "gameRequestContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "message", gameRequestContent.getMessage());
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        GameRequestContent.ActionType actionType = gameRequestContent.getActionType();
        String str = null;
        if (actionType == null || (obj = actionType.toString()) == null) {
            lowerCase = null;
        } else {
            Locale ENGLISH = Locale.ENGLISH;
            IIX0o.oO(ENGLISH, "ENGLISH");
            lowerCase = obj.toLowerCase(ENGLISH);
            IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, lowerCase);
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        GameRequestContent.Filters filters = gameRequestContent.getFilters();
        if (filters != null && (obj2 = filters.toString()) != null) {
            Locale ENGLISH2 = Locale.ENGLISH;
            IIX0o.oO(ENGLISH2, "ENGLISH");
            str = obj2.toLowerCase(ENGLISH2);
            IIX0o.oO(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, "filters", str);
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        return bundle;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Bundle createForFeed(@OOXIXo ShareFeedContent shareFeedContent) {
        IIX0o.x0xO0oo(shareFeedContent, "shareFeedContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_CAPTION_PARAM, shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        return bundle;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Bundle create(@OOXIXo ShareLinkContent shareLinkContent) {
        IIX0o.x0xO0oo(shareLinkContent, "shareLinkContent");
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility utility = Utility.INSTANCE;
        Utility.putUri(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_HREF, shareLinkContent.getContentUrl());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        return createBaseParameters;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Bundle create(@OOXIXo SharePhotoContent sharePhotoContent) {
        IIX0o.x0xO0oo(sharePhotoContent, "sharePhotoContent");
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null) {
            photos = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<SharePhoto> list = photos;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((SharePhoto) it.next()).getImageUrl()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            createBaseParameters.putStringArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA, (String[]) array);
            return createBaseParameters;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
