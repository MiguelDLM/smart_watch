package com.facebook.share.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class ShareContentValidation {

    @OOXIXo
    public static final ShareContentValidation INSTANCE = new ShareContentValidation();

    @OOXIXo
    private static final Validator webShareValidator = new WebShareValidator();

    @OOXIXo
    private static final Validator defaultValidator = new Validator();

    @OOXIXo
    private static final Validator apiValidator = new ApiValidator();

    @OOXIXo
    private static final Validator storyValidator = new StoryShareValidator();

    /* loaded from: classes8.dex */
    public static final class ApiValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo SharePhoto photo) {
            IIX0o.x0xO0oo(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForApi(photo, this);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo ShareVideoContent videoContent) {
            IIX0o.x0xO0oo(videoContent, "videoContent");
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(videoContent.getPlaceId())) {
                if (Utility.isNullOrEmpty(videoContent.getPeopleIds())) {
                    if (!Utility.isNullOrEmpty(videoContent.getRef())) {
                        throw new FacebookException("Cannot share video content with referrer URL using the share api");
                    }
                    return;
                }
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            }
            throw new FacebookException("Cannot share video content with place IDs using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo ShareMediaContent mediaContent) {
            IIX0o.x0xO0oo(mediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo ShareLinkContent linkContent) {
            IIX0o.x0xO0oo(linkContent, "linkContent");
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(linkContent.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class StoryShareValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@oOoXoXO ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    /* loaded from: classes8.dex */
    public static class Validator {
        public void validate(@OOXIXo ShareLinkContent linkContent) {
            IIX0o.x0xO0oo(linkContent, "linkContent");
            ShareContentValidation.INSTANCE.validateLinkContent(linkContent, this);
        }

        public void validate(@OOXIXo SharePhotoContent photoContent) {
            IIX0o.x0xO0oo(photoContent, "photoContent");
            ShareContentValidation.INSTANCE.validatePhotoContent(photoContent, this);
        }

        public void validate(@OOXIXo ShareVideoContent videoContent) {
            IIX0o.x0xO0oo(videoContent, "videoContent");
            ShareContentValidation.INSTANCE.validateVideoContent(videoContent, this);
        }

        public void validate(@OOXIXo ShareMediaContent mediaContent) {
            IIX0o.x0xO0oo(mediaContent, "mediaContent");
            ShareContentValidation.INSTANCE.validateMediaContent(mediaContent, this);
        }

        public void validate(@OOXIXo ShareCameraEffectContent cameraEffectContent) {
            IIX0o.x0xO0oo(cameraEffectContent, "cameraEffectContent");
            ShareContentValidation.INSTANCE.validateCameraEffectContent(cameraEffectContent);
        }

        public void validate(@OOXIXo SharePhoto photo) {
            IIX0o.x0xO0oo(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForNativeDialog(photo, this);
        }

        public void validate(@oOoXoXO ShareVideo shareVideo) {
            ShareContentValidation.INSTANCE.validateVideo(shareVideo, this);
        }

        public void validate(@OOXIXo ShareMedia<?, ?> medium) {
            IIX0o.x0xO0oo(medium, "medium");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateMedium(medium, this);
        }

        public void validate(@oOoXoXO ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    /* loaded from: classes8.dex */
    public static final class WebShareValidator extends Validator {
        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo ShareVideoContent videoContent) {
            IIX0o.x0xO0oo(videoContent, "videoContent");
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo ShareMediaContent mediaContent) {
            IIX0o.x0xO0oo(mediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.Validator
        public void validate(@OOXIXo SharePhoto photo) {
            IIX0o.x0xO0oo(photo, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForWebDialog(photo, this);
        }
    }

    private ShareContentValidation() {
    }

    private final void validate(ShareContent<?, ?> shareContent, Validator validator) throws FacebookException {
        if (shareContent != null) {
            if (shareContent instanceof ShareLinkContent) {
                validator.validate((ShareLinkContent) shareContent);
                return;
            }
            if (shareContent instanceof SharePhotoContent) {
                validator.validate((SharePhotoContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareVideoContent) {
                validator.validate((ShareVideoContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareMediaContent) {
                validator.validate((ShareMediaContent) shareContent);
                return;
            } else if (shareContent instanceof ShareCameraEffectContent) {
                validator.validate((ShareCameraEffectContent) shareContent);
                return;
            } else {
                if (shareContent instanceof ShareStoryContent) {
                    validator.validate((ShareStoryContent) shareContent);
                    return;
                }
                return;
            }
        }
        throw new FacebookException("Must provide non-null content to share");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent) {
        String effectId = shareCameraEffectContent.getEffectId();
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(effectId)) {
        } else {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    @x0XOIxOo
    public static final void validateForApiShare(@oOoXoXO ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, apiValidator);
    }

    @x0XOIxOo
    public static final void validateForMessage(@oOoXoXO ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    @x0XOIxOo
    public static final void validateForNativeShare(@oOoXoXO ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    @x0XOIxOo
    public static final void validateForStoryShare(@oOoXoXO ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, storyValidator);
    }

    @x0XOIxOo
    public static final void validateForWebShare(@oOoXoXO ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, webShareValidator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        Uri contentUrl = shareLinkContent.getContentUrl();
        if (contentUrl != null) {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isWebUri(contentUrl)) {
                throw new FacebookException("Content Url must be an http:// or https:// url");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        List<ShareMedia<?, ?>> media = shareMediaContent.getMedia();
        if (media != null && !media.isEmpty()) {
            if (media.size() <= 6) {
                Iterator<ShareMedia<?, ?>> it = media.iterator();
                while (it.hasNext()) {
                    validator.validate(it.next());
                }
                return;
            } else {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.ROOT, "Cannot add more than %d media.", Arrays.copyOf(new Object[]{6}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                throw new FacebookException(format);
            }
        }
        throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
    }

    @x0XOIxOo
    public static final void validateMedium(@OOXIXo ShareMedia<?, ?> medium, @OOXIXo Validator validator) {
        IIX0o.x0xO0oo(medium, "medium");
        IIX0o.x0xO0oo(validator, "validator");
        if (medium instanceof SharePhoto) {
            validator.validate((SharePhoto) medium);
        } else {
            if (medium instanceof ShareVideo) {
                validator.validate((ShareVideo) medium);
                return;
            }
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{medium.getClass().getSimpleName()}, 1));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }
    }

    private final void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap bitmap = sharePhoto.getBitmap();
            Uri imageUrl = sharePhoto.getImageUrl();
            if (bitmap == null && imageUrl == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException("Cannot share a null SharePhoto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos != null && !photos.isEmpty()) {
            if (photos.size() <= 6) {
                Iterator<SharePhoto> it = photos.iterator();
                while (it.hasNext()) {
                    validator.validate(it.next());
                }
                return;
            } else {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(Locale.ROOT, "Cannot add more than %d photos.", Arrays.copyOf(new Object[]{6}, 1));
                IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
                throw new FacebookException(format);
            }
        }
        throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isWebUri(imageUrl)) {
                throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhotoForApi(sharePhoto, validator);
        if (sharePhoto.getBitmap() == null) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isWebUri(sharePhoto.getImageUrl())) {
                return;
            }
        }
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
    }

    private final void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton == null) {
            return;
        }
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
                return;
            }
            return;
        }
        throw new FacebookException("Must specify title for ShareMessengerActionButton");
    }

    private final void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getUrl() != null) {
        } else {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        if (shareStoryContent != null && (shareStoryContent.getBackgroundAsset() != null || shareStoryContent.getStickerAsset() != null)) {
            if (shareStoryContent.getBackgroundAsset() != null) {
                validator.validate(shareStoryContent.getBackgroundAsset());
            }
            if (shareStoryContent.getStickerAsset() != null) {
                validator.validate(shareStoryContent.getStickerAsset());
                return;
            }
            return;
        }
        throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateVideo(ShareVideo shareVideo, Validator validator) {
        if (shareVideo != null) {
            Uri localUrl = shareVideo.getLocalUrl();
            if (localUrl != null) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.isContentUri(localUrl) && !Utility.isFileUri(localUrl)) {
                    throw new FacebookException("ShareVideo must reference a video that is on the device");
                }
                return;
            }
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        throw new FacebookException("Cannot share a null ShareVideo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
    }
}
