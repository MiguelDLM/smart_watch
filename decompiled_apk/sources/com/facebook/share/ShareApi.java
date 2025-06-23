package com.facebook.share;

import O0IoXXOx.XO;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bn;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode = "me";
    private String message;
    private final ShareContent shareContent;

    public ShareApi(final ShareContent shareContent) {
        this.shareContent = shareContent;
    }

    public static /* synthetic */ void access$000(ShareApi shareApi, ArrayList arrayList, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            shareApi.stageArrayList(arrayList, onMapValueCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    public static /* synthetic */ void access$100(ShareApi shareApi, SharePhoto sharePhoto, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            shareApi.stagePhoto(sharePhoto, onMapValueCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    private void addCommonParameters(final Bundle bundle, ShareContent shareContent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            List<String> peopleIds = shareContent.getPeopleIds();
            if (!Utility.isNullOrEmpty(peopleIds)) {
                bundle.putString(bn.l, TextUtils.join(", ", peopleIds));
            }
            if (!Utility.isNullOrEmpty(shareContent.getPlaceId())) {
                bundle.putString("place", shareContent.getPlaceId());
            }
            if (!Utility.isNullOrEmpty(shareContent.getPageId())) {
                bundle.putString("page", shareContent.getPageId());
            }
            if (!Utility.isNullOrEmpty(shareContent.getRef())) {
                bundle.putString(XO.f1159O0xOxO, shareContent.getRef());
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private String getGraphPath(final String pathAfterGraphNode) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return String.format(Locale.ROOT, GRAPH_PATH_FORMAT, URLEncoder.encode(getGraphNode(), "UTF-8"), pathAfterGraphNode);
        } catch (UnsupportedEncodingException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto photo, SharePhotoContent photoContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Bundle parameters = photo.getParameters();
            if (!parameters.containsKey("place") && !Utility.isNullOrEmpty(photoContent.getPlaceId())) {
                parameters.putString("place", photoContent.getPlaceId());
            }
            if (!parameters.containsKey(bn.l) && !Utility.isNullOrEmpty(photoContent.getPeopleIds())) {
                List<String> peopleIds = photoContent.getPeopleIds();
                if (!Utility.isNullOrEmpty(peopleIds)) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : peopleIds) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tag_uid", str);
                        jSONArray.put(jSONObject);
                    }
                    parameters.putString(bn.l, jSONArray.toString());
                }
            }
            if (!parameters.containsKey(XO.f1159O0xOxO) && !Utility.isNullOrEmpty(photoContent.getRef())) {
                parameters.putString(XO.f1159O0xOxO, photoContent.getRef());
            }
            return parameters;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private static void handleImagesOnAction(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            String string = parameters.getString("image");
            if (string != null) {
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                putImageInBundleWithArrayFormat(parameters, i, optJSONObject);
                            } else {
                                parameters.putString(String.format(Locale.ROOT, "image[%d][url]", Integer.valueOf(i)), jSONArray.getString(i));
                            }
                        }
                        parameters.remove("image");
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    putImageInBundleWithArrayFormat(parameters, 0, new JSONObject(string));
                    parameters.remove("image");
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    private static void putImageInBundleWithArrayFormat(Bundle parameters, int index, JSONObject image) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            Iterator<String> keys = image.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                parameters.putString(String.format(Locale.ROOT, "image[%d][%s]", Integer.valueOf(index), next), image.get(next).toString());
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    public static void share(final ShareContent shareContent, final FacebookCallback<Sharer.Result> callback) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            new ShareApi(shareContent).share(callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    private void shareLinkContent(final ShareLinkContent linkContent, final FacebookCallback<Sharer.Result> callback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.2
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse response) {
                    String optString;
                    JSONObject jSONObject = response.getJSONObject();
                    if (jSONObject == null) {
                        optString = null;
                    } else {
                        optString = jSONObject.optString("id");
                    }
                    ShareInternalUtility.invokeCallbackWithResults(callback, optString, response);
                }
            };
            Bundle bundle = new Bundle();
            addCommonParameters(bundle, linkContent);
            bundle.putString("message", getMessage());
            bundle.putString("link", Utility.getUriString(linkContent.getContentUrl()));
            bundle.putString(XO.f1159O0xOxO, linkContent.getRef());
            new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, callback2).executeAsync();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [T, java.lang.Integer] */
    private void sharePhotoContent(final SharePhotoContent photoContent, final FacebookCallback<Sharer.Result> callback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final Mutable mutable = new Mutable(0);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse response) {
                    JSONObject jSONObject = response.getJSONObject();
                    if (jSONObject != null) {
                        arrayList2.add(jSONObject);
                    }
                    if (response.getError() != null) {
                        arrayList3.add(response);
                    }
                    mutable.value = Integer.valueOf(((Integer) r0.value).intValue() - 1);
                    if (((Integer) mutable.value).intValue() == 0) {
                        if (!arrayList3.isEmpty()) {
                            ShareInternalUtility.invokeCallbackWithResults(callback, null, (GraphResponse) arrayList3.get(0));
                        } else if (!arrayList2.isEmpty()) {
                            ShareInternalUtility.invokeCallbackWithResults(callback, ((JSONObject) arrayList2.get(0)).optString("id"), response);
                        }
                    }
                }
            };
            try {
                for (SharePhoto sharePhoto : photoContent.getPhotos()) {
                    try {
                        Bundle sharePhotoCommonParameters = getSharePhotoCommonParameters(sharePhoto, photoContent);
                        Bitmap bitmap = sharePhoto.getBitmap();
                        Uri imageUrl = sharePhoto.getImageUrl();
                        String caption = sharePhoto.getCaption();
                        if (caption == null) {
                            caption = getMessage();
                        }
                        String str = caption;
                        if (bitmap != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), bitmap, str, sharePhotoCommonParameters, callback2));
                        } else if (imageUrl != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), imageUrl, str, sharePhotoCommonParameters, callback2));
                        }
                    } catch (JSONException e) {
                        ShareInternalUtility.invokeCallbackWithException(callback, e);
                        return;
                    }
                }
                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((GraphRequest) it.next()).executeAsync();
                }
            } catch (FileNotFoundException e2) {
                ShareInternalUtility.invokeCallbackWithException(callback, e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void shareVideoContent(final ShareVideoContent videoContent, final FacebookCallback<Sharer.Result> callback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                VideoUploader.uploadAsync(videoContent, getGraphNode(), callback);
            } catch (FileNotFoundException e) {
                ShareInternalUtility.invokeCallbackWithException(callback, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void stageArrayList(final ArrayList arrayList, final CollectionMapper.OnMapValueCompleteListener onArrayListStagedListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final JSONArray jSONArray = new JSONArray();
            stageCollectionValues(new CollectionMapper.Collection<Integer>() { // from class: com.facebook.share.ShareApi.3
                @Override // com.facebook.internal.CollectionMapper.Collection
                public Iterator<Integer> keyIterator() {
                    final int size = arrayList.size();
                    final Mutable mutable = new Mutable(0);
                    return new Iterator<Integer>() { // from class: com.facebook.share.ShareApi.3.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            if (((Integer) mutable.value).intValue() < size) {
                                return true;
                            }
                            return false;
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
                        @Override // java.util.Iterator
                        public Integer next() {
                            Mutable mutable2 = mutable;
                            T t = mutable2.value;
                            Integer num = (Integer) t;
                            mutable2.value = Integer.valueOf(((Integer) t).intValue() + 1);
                            return num;
                        }
                    };
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public Object get(Integer key) {
                    return arrayList.get(key.intValue());
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public void set(Integer key, Object value, CollectionMapper.OnErrorListener onErrorListener) {
                    try {
                        jSONArray.put(key.intValue(), value);
                    } catch (JSONException e) {
                        String localizedMessage = e.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "Error staging object.";
                        }
                        onErrorListener.onError(new FacebookException(localizedMessage));
                    }
                }
            }, new CollectionMapper.OnMapperCompleteListener() { // from class: com.facebook.share.ShareApi.4
                @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
                public void onComplete() {
                    onArrayListStagedListener.onComplete(jSONArray);
                }

                @Override // com.facebook.internal.CollectionMapper.OnErrorListener
                public void onError(FacebookException exception) {
                    onArrayListStagedListener.onError(exception);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private <T> void stageCollectionValues(final CollectionMapper.Collection<T> collection, final CollectionMapper.OnMapperCompleteListener onCollectionValuesStagedListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            CollectionMapper.iterate(collection, new CollectionMapper.ValueMapper() { // from class: com.facebook.share.ShareApi.5
                @Override // com.facebook.internal.CollectionMapper.ValueMapper
                public void mapValue(Object value, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
                    if (value instanceof ArrayList) {
                        ShareApi.access$000(ShareApi.this, (ArrayList) value, onMapValueCompleteListener);
                    } else if (value instanceof SharePhoto) {
                        ShareApi.access$100(ShareApi.this, (SharePhoto) value, onMapValueCompleteListener);
                    } else {
                        onMapValueCompleteListener.onComplete(value);
                    }
                }
            }, onCollectionValuesStagedListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void stagePhoto(final SharePhoto photo, final CollectionMapper.OnMapValueCompleteListener onPhotoStagedListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bitmap bitmap = photo.getBitmap();
            Uri imageUrl = photo.getImageUrl();
            if (bitmap == null && imageUrl == null) {
                onPhotoStagedListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
                return;
            }
            GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.6
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse response) {
                    FacebookRequestError error = response.getError();
                    String str = "Error staging photo.";
                    if (error != null) {
                        String errorMessage = error.getErrorMessage();
                        if (errorMessage != null) {
                            str = errorMessage;
                        }
                        onPhotoStagedListener.onError(new FacebookGraphResponseException(response, str));
                        return;
                    }
                    JSONObject jSONObject = response.getJSONObject();
                    if (jSONObject == null) {
                        onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                        return;
                    }
                    String optString = jSONObject.optString("uri");
                    if (optString == null) {
                        onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", optString);
                        jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, photo.getUserGenerated());
                        onPhotoStagedListener.onComplete(jSONObject2);
                    } catch (JSONException e) {
                        String localizedMessage = e.getLocalizedMessage();
                        if (localizedMessage != null) {
                            str = localizedMessage;
                        }
                        onPhotoStagedListener.onError(new FacebookException(str));
                    }
                }
            };
            if (bitmap != null) {
                ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, callback).executeAsync();
                return;
            }
            try {
                ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, callback).executeAsync();
            } catch (FileNotFoundException e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Error staging photo.";
                }
                onPhotoStagedListener.onError(new FacebookException(localizedMessage));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public boolean canShare() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (getShareContent() == null) {
                return false;
            }
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (!AccessToken.isCurrentAccessTokenActive()) {
                return false;
            }
            Set<String> permissions = currentAccessToken.getPermissions();
            if (permissions != null && permissions.contains("publish_actions")) {
                return true;
            }
            Log.w(TAG, "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public String getGraphNode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.graphNode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public String getMessage() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.message;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public ShareContent getShareContent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.shareContent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setGraphNode(final String graphNode) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.graphNode = graphNode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setMessage(final String message) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.message = message;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void share(FacebookCallback<Sharer.Result> callback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!canShare()) {
                ShareInternalUtility.invokeCallbackWithError(callback, "Insufficient permissions for sharing content via Api.");
                return;
            }
            ShareContent shareContent = getShareContent();
            try {
                ShareContentValidation.validateForApiShare(shareContent);
                if (shareContent instanceof ShareLinkContent) {
                    shareLinkContent((ShareLinkContent) shareContent, callback);
                } else if (shareContent instanceof SharePhotoContent) {
                    sharePhotoContent((SharePhotoContent) shareContent, callback);
                } else if (shareContent instanceof ShareVideoContent) {
                    shareVideoContent((ShareVideoContent) shareContent, callback);
                }
            } catch (FacebookException e) {
                ShareInternalUtility.invokeCallbackWithException(callback, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
