package com.facebook.share.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.huawei.openalliance.ad.constant.bf;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class ShareInternalUtility {

    @OOXIXo
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();

    @OOXIXo
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";

    @OOXIXo
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    private final AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.Companion.finishPendingCall(callIdFromIntent, i);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia<?, ?> shareMedia) {
        Uri uri;
        Bitmap bitmap;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.getBitmap();
            uri = sharePhoto.getImageUrl();
        } else if (shareMedia instanceof ShareVideo) {
            uri = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            uri = null;
            bitmap = null;
        }
        return getAttachment(uuid, uri, bitmap);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Bundle getBackgroundAssetMediaInfo(@oOoXoXO ShareStoryContent shareStoryContent, @OOXIXo UUID appCallId) {
        IIX0o.x0xO0oo(appCallId, "appCallId");
        Bundle bundle = null;
        if (shareStoryContent != null && shareStoryContent.getBackgroundAsset() != null) {
            ShareMedia<?, ?> backgroundAsset = shareStoryContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString("type", backgroundAsset.getMediaType().name());
            bundle.putString("uri", attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility utility = Utility.INSTANCE;
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(oI0IIXIo.OOXIXo(attachment));
        }
        return bundle;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(@OOXIXo String fullName) {
        String str;
        int i;
        IIX0o.x0xO0oo(fullName, "fullName");
        int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(fullName, ':', 0, false, 6, null);
        if (XxIIOXIXx2 != -1 && fullName.length() > (i = XxIIOXIXx2 + 1)) {
            str = fullName.substring(0, XxIIOXIXx2);
            IIX0o.oO(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            fullName = fullName.substring(i);
            IIX0o.oO(fullName, "(this as java.lang.String).substring(startIndex)");
        } else {
            str = null;
        }
        return new Pair<>(str, fullName);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final List<Bundle> getMediaInfos(@oOoXoXO ShareMediaContent shareMediaContent, @OOXIXo UUID appCallId) {
        List<ShareMedia<?, ?>> media;
        Bundle bundle;
        IIX0o.x0xO0oo(appCallId, "appCallId");
        if (shareMediaContent == null) {
            media = null;
        } else {
            media = shareMediaContent.getMedia();
        }
        if (media == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareMedia<?, ?> shareMedia : media) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString("uri", attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getNativeDialogCompletionGesture(@OOXIXo Bundle result) {
        IIX0o.x0xO0oo(result, "result");
        if (result.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return result.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return result.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final List<String> getPhotoUrls(@oOoXoXO SharePhotoContent sharePhotoContent, @OOXIXo UUID appCallId) {
        List<SharePhoto> photos;
        IIX0o.x0xO0oo(appCallId, "appCallId");
        if (sharePhotoContent == null) {
            photos = null;
        } else {
            photos = sharePhotoContent.getPhotos();
        }
        if (photos == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = photos.iterator();
        while (it.hasNext()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, (SharePhoto) it.next());
            if (attachment != null) {
                arrayList.add(attachment);
            }
        }
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((NativeAppCallAttachmentStore.Attachment) it2.next()).getAttachmentUrl());
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getShareDialogPostId(@OOXIXo Bundle result) {
        IIX0o.x0xO0oo(result, "result");
        if (result.containsKey(ShareConstants.RESULT_POST_ID)) {
            return result.getString(ShareConstants.RESULT_POST_ID);
        }
        if (result.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return result.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return result.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    @x0XOIxOo
    @OOXIXo
    public static final ResultProcessor getShareResultProcessor(@oOoXoXO final FacebookCallback<Sharer.Result> facebookCallback) {
        return new ResultProcessor(facebookCallback) { // from class: com.facebook.share.internal.ShareInternalUtility$getShareResultProcessor$1
            final /* synthetic */ FacebookCallback<Sharer.Result> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(facebookCallback);
                this.$callback = facebookCallback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onCancel(@OOXIXo AppCall appCall) {
                IIX0o.x0xO0oo(appCall, "appCall");
                ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onError(@OOXIXo AppCall appCall, @OOXIXo FacebookException error) {
                IIX0o.x0xO0oo(appCall, "appCall");
                IIX0o.x0xO0oo(error, "error");
                ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, error);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(@OOXIXo AppCall appCall, @oOoXoXO Bundle bundle) {
                IIX0o.x0xO0oo(appCall, "appCall");
                if (bundle != null) {
                    ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture != null && !OxI.oX0I0O("post", nativeDialogCompletionGesture, true)) {
                        if (OxI.oX0I0O("cancel", nativeDialogCompletionGesture, true)) {
                            ShareInternalUtility.invokeOnCancelCallback(this.$callback);
                            return;
                        } else {
                            ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                            return;
                        }
                    }
                    ShareInternalUtility.invokeOnSuccessCallback(this.$callback, ShareInternalUtility.getShareDialogPostId(bundle));
                }
            }
        };
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Bundle getStickerUrl(@oOoXoXO ShareStoryContent shareStoryContent, @OOXIXo UUID appCallId) {
        IIX0o.x0xO0oo(appCallId, "appCallId");
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(shareStoryContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareStoryContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uri", attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility utility = Utility.INSTANCE;
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(oI0IIXIo.OOXIXo(attachment));
        return bundle;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Bundle getTextureUrlBundle(@oOoXoXO ShareCameraEffectContent shareCameraEffectContent, @OOXIXo UUID appCallId) {
        CameraEffectTextures textures;
        IIX0o.x0xO0oo(appCallId, "appCallId");
        if (shareCameraEffectContent == null) {
            textures = null;
        } else {
            textures = shareCameraEffectContent.getTextures();
        }
        if (textures == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : textures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, textures.getTextureUri(str), textures.getTextureBitmap(str));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(str, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getUriExtension(@oOoXoXO Uri uri) {
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        IIX0o.oO(uri2, "uri.toString()");
        int XIxO2 = StringsKt__StringsKt.XIxO(uri2, '.', 0, false, 6, null);
        if (XIxO2 == -1) {
            return null;
        }
        String substring = uri2.substring(XIxO2);
        IIX0o.oO(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getVideoUrl(@oOoXoXO ShareVideoContent shareVideoContent, @OOXIXo UUID appCallId) {
        ShareVideo video;
        Uri localUrl;
        IIX0o.x0xO0oo(appCallId, "appCallId");
        if (shareVideoContent == null || (video = shareVideoContent.getVideo()) == null) {
            localUrl = null;
        } else {
            localUrl = video.getLocalUrl();
        }
        if (localUrl == null) {
            return null;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(appCallId, localUrl);
        NativeAppCallAttachmentStore.addAttachments(oI0IIXIo.OOXIXo(createAttachment));
        return createAttachment.getAttachmentUrl();
    }

    @x0XOIxOo
    public static final boolean handleActivityResult(int i, int i2, @oOoXoXO Intent intent, @oOoXoXO ResultProcessor resultProcessor) {
        FacebookException facebookException;
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(i, i2, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        Bundle bundle = null;
        if (intent != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            facebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        } else {
            facebookException = null;
        }
        if (facebookException != null) {
            if (facebookException instanceof FacebookOperationCanceledException) {
                resultProcessor.onCancel(appCallFromActivityResult);
            } else {
                resultProcessor.onError(appCallFromActivityResult, facebookException);
            }
        } else {
            if (intent != null) {
                NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
                bundle = NativeProtocol.getSuccessResultsFromIntent(intent);
            }
            resultProcessor.onSuccess(appCallFromActivityResult, bundle);
        }
        return true;
    }

    @x0XOIxOo
    public static final void invokeCallbackWithError(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @oOoXoXO String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    @x0XOIxOo
    public static final void invokeCallbackWithException(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @OOXIXo Exception exception) {
        IIX0o.x0xO0oo(exception, "exception");
        if (exception instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exception);
        } else {
            invokeCallbackWithError(facebookCallback, IIX0o.XIxXXX0x0("Error preparing share content: ", exception.getLocalizedMessage()));
        }
    }

    @x0XOIxOo
    public static final void invokeCallbackWithResults(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @oOoXoXO String str, @OOXIXo GraphResponse graphResponse) {
        IIX0o.x0xO0oo(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
    }

    @x0XOIxOo
    public static final void invokeOnCancelCallback(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    @x0XOIxOo
    public static final void invokeOnErrorCallback(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @oOoXoXO GraphResponse graphResponse, @oOoXoXO String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
    }

    @x0XOIxOo
    public static final void invokeOnSuccessCallback(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @oOoXoXO String str) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    private final void logShareResult(String str, String str2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    @x0XOIxOo
    @OOXIXo
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@oOoXoXO AccessToken accessToken, @oOoXoXO Bitmap bitmap, @oOoXoXO GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @x0XOIxOo
    public static final void registerSharerCallback(final int i, @oOoXoXO CallbackManager callbackManager, @oOoXoXO final FacebookCallback<Sharer.Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.oIX0oI
                @Override // com.facebook.internal.CallbackManagerImpl.Callback
                public final boolean onActivityResult(int i2, Intent intent) {
                    boolean m255registerSharerCallback$lambda1;
                    m255registerSharerCallback$lambda1 = ShareInternalUtility.m255registerSharerCallback$lambda1(i, facebookCallback, i2, intent);
                    return m255registerSharerCallback$lambda1;
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerSharerCallback$lambda-1, reason: not valid java name */
    public static final boolean m255registerSharerCallback$lambda1(int i, FacebookCallback facebookCallback, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, getShareResultProcessor(facebookCallback));
    }

    @x0XOIxOo
    public static final void registerStaticShareCallback(final int i) {
        CallbackManagerImpl.Companion.registerStaticCallback(i, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.II0xO0
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                boolean m256registerStaticShareCallback$lambda0;
                m256registerStaticShareCallback$lambda0 = ShareInternalUtility.m256registerStaticShareCallback$lambda0(i, i2, intent);
                return m256registerStaticShareCallback$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerStaticShareCallback$lambda-0, reason: not valid java name */
    public static final boolean m256registerStaticShareCallback$lambda0(int i, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, getShareResultProcessor(null));
    }

    @x0XOIxOo
    @OOXIXo
    public static final JSONArray removeNamespacesFromOGJsonArray(@OOXIXo JSONArray jsonArray, boolean z) throws JSONException {
        IIX0o.x0xO0oo(jsonArray, "jsonArray");
        JSONArray jSONArray = new JSONArray();
        int length = jsonArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object obj = jsonArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
                } else if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
                }
                jSONArray.put(obj);
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return jSONArray;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final JSONObject removeNamespacesFromOGJsonObject(@oOoXoXO JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            if (names == null) {
                return null;
            }
            int length = names.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String key = names.getString(i);
                    Object obj = jSONObject.get(key);
                    if (obj instanceof JSONObject) {
                        obj = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                    } else if (obj instanceof JSONArray) {
                        obj = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                    }
                    IIX0o.oO(key, "key");
                    Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(key);
                    String str = (String) fieldNameAndNamespaceFromFullName.first;
                    String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                    if (z) {
                        if (str != null && IIX0o.Oxx0IOOO(str, DeviceRequestsHelper.SDK_HEADER)) {
                            jSONObject2.put(key, obj);
                        } else {
                            if (str != null && !IIX0o.Oxx0IOOO(str, "og")) {
                                jSONObject3.put(str2, obj);
                            }
                            jSONObject2.put(str2, obj);
                        }
                    } else if (str != null && IIX0o.Oxx0IOOO(str, "fb")) {
                        jSONObject2.put(key, obj);
                    } else {
                        jSONObject2.put(str2, obj);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    @x0XOIxOo
    public static final void invokeOnErrorCallback(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @oOoXoXO String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(new FacebookException(str));
    }

    @x0XOIxOo
    @OOXIXo
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@oOoXoXO AccessToken accessToken, @oOoXoXO File file, @oOoXoXO GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), bf.Z);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @x0XOIxOo
    public static final void invokeOnErrorCallback(@oOoXoXO FacebookCallback<Sharer.Result> facebookCallback, @OOXIXo FacebookException ex) {
        IIX0o.x0xO0oo(ex, "ex");
        INSTANCE.logShareResult("error", ex.getMessage());
        if (facebookCallback == null) {
            return;
        }
        facebookCallback.onError(ex);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (uri == null) {
            return null;
        }
        NativeAppCallAttachmentStore nativeAppCallAttachmentStore2 = NativeAppCallAttachmentStore.INSTANCE;
        return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
    }

    @x0XOIxOo
    @OOXIXo
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@oOoXoXO AccessToken accessToken, @OOXIXo Uri imageUri, @oOoXoXO GraphRequest.Callback callback) throws FileNotFoundException {
        IIX0o.x0xO0oo(imageUri, "imageUri");
        String path = imageUri.getPath();
        Utility utility = Utility.INSTANCE;
        if (Utility.isFileUri(imageUri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        if (Utility.isContentUri(imageUri)) {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(imageUri, bf.Z);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }
}
