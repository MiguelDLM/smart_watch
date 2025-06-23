package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R;

/* loaded from: classes8.dex */
public class ProfilePictureView extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = "ProfilePictureView";
    private Bitmap customizedDefaultProfilePicture;
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSizeType;
    private String profileId;
    private ProfileTracker profileTracker;
    private int queryHeight;
    private int queryWidth;

    /* loaded from: classes8.dex */
    public interface OnErrorListener {
        void onError(FacebookException error);
    }

    public ProfilePictureView(Context context) {
        super(context);
        this.queryHeight = 0;
        this.queryWidth = 0;
        this.isCropped = true;
        this.presetSizeType = -1;
        this.customizedDefaultProfilePicture = null;
        initialize(context);
    }

    private int getPresetSizeInPixels(boolean forcePreset) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            int i2 = this.presetSizeType;
            if (i2 != -4) {
                if (i2 != -3) {
                    if (i2 != -2) {
                        if (i2 != -1 || !forcePreset) {
                            return 0;
                        }
                        i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
                    } else {
                        i = R.dimen.com_facebook_profilepictureview_preset_size_small;
                    }
                } else {
                    i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
                }
            } else {
                i = R.dimen.com_facebook_profilepictureview_preset_size_large;
            }
            return getResources().getDimensionPixelSize(i);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    private void initialize(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            removeAllViews();
            this.image = new ImageView(context);
            this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            addView(this.image);
            this.profileTracker = new ProfileTracker() { // from class: com.facebook.login.widget.ProfilePictureView.1
                @Override // com.facebook.ProfileTracker
                public void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                    String str;
                    ProfilePictureView profilePictureView = ProfilePictureView.this;
                    if (currentProfile != null) {
                        str = currentProfile.getId();
                    } else {
                        str = null;
                    }
                    profilePictureView.setProfileId(str);
                    ProfilePictureView.this.refreshImage(true);
                }
            };
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void parseAttributes(AttributeSet attrs) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.com_facebook_profile_picture_view);
            setPresetSize(obtainStyledAttributes.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
            this.isCropped = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResponse(ImageResponse response) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (response.getRequest() == this.lastRequest) {
                this.lastRequest = null;
                Bitmap bitmap = response.getBitmap();
                Exception error = response.getError();
                if (error != null) {
                    OnErrorListener onErrorListener = this.onErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), error));
                        return;
                    }
                    Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                    return;
                }
                if (bitmap != null) {
                    setImageBitmap(bitmap);
                    if (response.isCachedRedirect()) {
                        sendImageRequest(false);
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(boolean force) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            boolean updateImageQueryParameters = updateImageQueryParameters();
            String str = this.profileId;
            if (str != null && str.length() != 0 && (this.queryWidth != 0 || this.queryHeight != 0)) {
                if (updateImageQueryParameters || force) {
                    sendImageRequest(true);
                    return;
                }
                return;
            }
            setBlankProfilePicture();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void sendImageRequest(boolean allowCachedResponse) {
        String str;
        Uri profilePictureUri;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (AccessToken.isCurrentAccessTokenActive()) {
                str = AccessToken.getCurrentAccessToken().getToken();
            } else {
                str = "";
            }
            Uri profilePictureUri2 = ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, str);
            Profile currentProfile = Profile.getCurrentProfile();
            if (AccessToken.isLoggedInWithInstagram() && currentProfile != null && (profilePictureUri = currentProfile.getProfilePictureUri(this.queryWidth, this.queryHeight)) != null) {
                profilePictureUri2 = profilePictureUri;
            }
            ImageRequest build = new ImageRequest.Builder(getContext(), profilePictureUri2).setAllowCachedRedirects(allowCachedResponse).setCallerTag(this).setCallback(new ImageRequest.Callback() { // from class: com.facebook.login.widget.ProfilePictureView.2
                @Override // com.facebook.internal.ImageRequest.Callback
                public void onCompleted(ImageResponse response) {
                    ProfilePictureView.this.processResponse(response);
                }
            }).build();
            ImageRequest imageRequest = this.lastRequest;
            if (imageRequest != null) {
                ImageDownloader.cancelRequest(imageRequest);
            }
            this.lastRequest = build;
            ImageDownloader.downloadAsync(build);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void setBlankProfilePicture() {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ImageRequest imageRequest = this.lastRequest;
            if (imageRequest != null) {
                ImageDownloader.cancelRequest(imageRequest);
            }
            if (this.customizedDefaultProfilePicture == null) {
                if (isCropped()) {
                    i = R.drawable.com_facebook_profile_picture_blank_square;
                } else {
                    i = R.drawable.com_facebook_profile_picture_blank_portrait;
                }
                setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
                return;
            }
            updateImageQueryParameters();
            setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void setImageBitmap(Bitmap imageBitmap) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ImageView imageView = this.image;
            if (imageView != null && imageBitmap != null) {
                this.imageContents = imageBitmap;
                imageView.setImageBitmap(imageBitmap);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private boolean updateImageQueryParameters() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int height = getHeight();
            int width = getWidth();
            boolean z = true;
            if (width >= 1 && height >= 1) {
                int presetSizeInPixels = getPresetSizeInPixels(false);
                if (presetSizeInPixels != 0) {
                    height = presetSizeInPixels;
                    width = height;
                }
                if (width <= height) {
                    if (isCropped()) {
                        height = width;
                    } else {
                        height = 0;
                    }
                } else if (isCropped()) {
                    width = height;
                } else {
                    width = 0;
                }
                if (width == this.queryWidth && height == this.queryHeight) {
                    z = false;
                }
                this.queryWidth = width;
                this.queryHeight = height;
                return z;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final boolean getShouldUpdateOnProfileChange() {
        return this.profileTracker.isTracking();
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        refreshImage(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
        boolean z2 = true;
        if (View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824 && layoutParams.height == -2) {
            size = getPresetSizeInPixels(true);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z = true;
        } else {
            z = false;
        }
        if (View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824 && layoutParams.width == -2) {
            size2 = getPresetSizeInPixels(true);
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        } else {
            z2 = z;
        }
        if (z2) {
            setMeasuredDimension(size2, size);
            measureChildren(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (state.getClass() != Bundle.class) {
            super.onRestoreInstanceState(state);
            return;
        }
        Bundle bundle = (Bundle) state;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        this.profileId = bundle.getString(PROFILE_ID_KEY);
        this.presetSizeType = bundle.getInt(PRESET_SIZE_KEY);
        this.isCropped = bundle.getBoolean(IS_CROPPED_KEY);
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSizeType);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        if (this.lastRequest != null) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(PENDING_REFRESH_KEY, z);
        return bundle;
    }

    public final void setCropped(boolean showCroppedVersion) {
        this.isCropped = showCroppedVersion;
        refreshImage(false);
    }

    public final void setDefaultProfilePicture(Bitmap inputBitmap) {
        this.customizedDefaultProfilePicture = inputBitmap;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public final void setPresetSize(int sizeType) {
        if (sizeType != -4 && sizeType != -3 && sizeType != -2 && sizeType != -1) {
            throw new IllegalArgumentException("Must use a predefined preset size");
        }
        this.presetSizeType = sizeType;
        requestLayout();
    }

    public final void setProfileId(@Nullable String profileId) {
        boolean z;
        if (!Utility.isNullOrEmpty(this.profileId) && this.profileId.equalsIgnoreCase(profileId)) {
            z = false;
        } else {
            setBlankProfilePicture();
            z = true;
        }
        this.profileId = profileId;
        refreshImage(z);
    }

    public final void setShouldUpdateOnProfileChange(boolean shouldUpdateOnProfileChange) {
        if (shouldUpdateOnProfileChange) {
            this.profileTracker.startTracking();
        } else {
            this.profileTracker.stopTracking();
        }
    }

    public ProfilePictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.queryHeight = 0;
        this.queryWidth = 0;
        this.isCropped = true;
        this.presetSizeType = -1;
        this.customizedDefaultProfilePicture = null;
        initialize(context);
        parseAttributes(attrs);
    }

    public ProfilePictureView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.queryHeight = 0;
        this.queryWidth = 0;
        this.isCropped = true;
        this.presetSizeType = -1;
        this.customizedDefaultProfilePicture = null;
        initialize(context);
        parseAttributes(attrs);
    }
}
