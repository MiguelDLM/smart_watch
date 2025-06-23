package com.facebook.share.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public class ShareDialog extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result> implements Sharer {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_REQUEST_CODE;

    @OOXIXo
    private static final String FEED_DIALOG = "feed";

    @OOXIXo
    private static final String TAG;

    @OOXIXo
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";

    @OOXIXo
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;

    @OOXIXo
    private final List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> orderedModeHandlers;
    private boolean shouldFailOnDataError;

    /* loaded from: classes8.dex */
    public final class CameraEffectHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {

        @OOXIXo
        private Object mode;
        final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CameraEffectHandler(ShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(@OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(@OOXIXo ShareContent<?, ?> content, boolean z) {
            IIX0o.x0xO0oo(content, "content");
            return (content instanceof ShareCameraEffectContent) && ShareDialog.Companion.canShowNative(content.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @oOoXoXO
        public AppCall createAppCall(@OOXIXo final ShareContent<?, ?> content) {
            IIX0o.x0xO0oo(content, "content");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForNativeShare(content);
            final AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            final boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature feature = ShareDialog.Companion.getFeature(content.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.ShareDialog$CameraEffectHandler$createAppCall$1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                @oOoXoXO
                public Bundle getLegacyParameters() {
                    LegacyNativeDialogParameters legacyNativeDialogParameters = LegacyNativeDialogParameters.INSTANCE;
                    return LegacyNativeDialogParameters.create(AppCall.this.getCallId(), content, shouldFailOnDataError);
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                @oOoXoXO
                public Bundle getParameters() {
                    NativeDialogParameters nativeDialogParameters = NativeDialogParameters.INSTANCE;
                    return NativeDialogParameters.create(AppCall.this.getCallId(), content, shouldFailOnDataError);
                }
            }, feature);
            return createBaseAppCall;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean canShowNative(Class<? extends ShareContent<?, ?>> cls) {
            DialogFeature feature = getFeature(cls);
            if (feature != null) {
                DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                if (DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean canShowWebCheck(ShareContent<?, ?> shareContent) {
            if (!canShowWebTypeCheck(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        private final boolean canShowWebTypeCheck(Class<? extends ShareContent<?, ?>> cls) {
            if (!ShareLinkContent.class.isAssignableFrom(cls) && (!SharePhotoContent.class.isAssignableFrom(cls) || !AccessToken.Companion.isCurrentAccessTokenActive())) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DialogFeature getFeature(Class<? extends ShareContent<?, ?>> cls) {
            if (ShareLinkContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.SHARE_DIALOG;
            }
            if (SharePhotoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.PHOTOS;
            }
            if (ShareVideoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.VIDEO;
            }
            if (ShareMediaContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.MULTIMEDIA;
            }
            if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
                return CameraEffectFeature.SHARE_CAMERA_EFFECT;
            }
            if (ShareStoryContent.class.isAssignableFrom(cls)) {
                return ShareStoryFeature.SHARE_STORY_ASSET;
            }
            return null;
        }

        @x0XOIxOo
        public boolean canShow(@OOXIXo Class<? extends ShareContent<?, ?>> contentType) {
            IIX0o.x0xO0oo(contentType, "contentType");
            if (!canShowWebTypeCheck(contentType) && !canShowNative(contentType)) {
                return false;
            }
            return true;
        }

        @x0XOIxOo
        public void show(@OOXIXo Activity activity, @OOXIXo ShareContent<?, ?> shareContent) {
            IIX0o.x0xO0oo(activity, "activity");
            IIX0o.x0xO0oo(shareContent, "shareContent");
            new ShareDialog(activity).show(shareContent);
        }

        private Companion() {
        }

        @x0XOIxOo
        public void show(@OOXIXo Fragment fragment, @OOXIXo ShareContent<?, ?> shareContent) {
            IIX0o.x0xO0oo(fragment, "fragment");
            IIX0o.x0xO0oo(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        @x0XOIxOo
        public void show(@OOXIXo android.app.Fragment fragment, @OOXIXo ShareContent<?, ?> shareContent) {
            IIX0o.x0xO0oo(fragment, "fragment");
            IIX0o.x0xO0oo(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        private final void show(FragmentWrapper fragmentWrapper, ShareContent<?, ?> shareContent) {
            new ShareDialog(fragmentWrapper, 0, 2, null).show(shareContent);
        }
    }

    /* loaded from: classes8.dex */
    public final class FeedHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {

        @OOXIXo
        private Object mode;
        final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedHandler(ShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = Mode.FEED;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(@OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(@OOXIXo ShareContent<?, ?> content, boolean z) {
            IIX0o.x0xO0oo(content, "content");
            return (content instanceof ShareLinkContent) || (content instanceof ShareFeedContent);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @oOoXoXO
        public AppCall createAppCall(@OOXIXo ShareContent<?, ?> content) {
            Bundle createForFeed;
            IIX0o.x0xO0oo(content, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), content, Mode.FEED);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            if (content instanceof ShareLinkContent) {
                ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
                ShareContentValidation.validateForWebShare(content);
                WebDialogParameters webDialogParameters = WebDialogParameters.INSTANCE;
                createForFeed = WebDialogParameters.createForFeed((ShareLinkContent) content);
            } else {
                if (!(content instanceof ShareFeedContent)) {
                    return null;
                }
                WebDialogParameters webDialogParameters2 = WebDialogParameters.INSTANCE;
                createForFeed = WebDialogParameters.createForFeed((ShareFeedContent) content);
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "feed", createForFeed);
            return createBaseAppCall;
        }
    }

    /* loaded from: classes8.dex */
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] valuesCustom = values();
            return (Mode[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public final class NativeHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {

        @OOXIXo
        private Object mode;
        final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeHandler(ShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(@OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.mode = obj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        
            if (com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES) != false) goto L25;
         */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean canShow(@OXOo.OOXIXo com.facebook.share.model.ShareContent<?, ?> r4, boolean r5) {
            /*
                r3 = this;
                java.lang.String r0 = "content"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                boolean r0 = r4 instanceof com.facebook.share.model.ShareCameraEffectContent
                r1 = 0
                if (r0 != 0) goto L55
                boolean r0 = r4 instanceof com.facebook.share.model.ShareStoryContent
                if (r0 == 0) goto Lf
                goto L55
            Lf:
                r0 = 1
                if (r5 != 0) goto L45
                com.facebook.share.model.ShareHashtag r5 = r4.getShareHashtag()
                if (r5 == 0) goto L21
                com.facebook.internal.DialogPresenter r5 = com.facebook.internal.DialogPresenter.INSTANCE
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.HASHTAG
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                goto L22
            L21:
                r5 = 1
            L22:
                boolean r2 = r4 instanceof com.facebook.share.model.ShareLinkContent
                if (r2 == 0) goto L46
                r2 = r4
                com.facebook.share.model.ShareLinkContent r2 = (com.facebook.share.model.ShareLinkContent) r2
                java.lang.String r2 = r2.getQuote()
                if (r2 == 0) goto L46
                int r2 = r2.length()
                if (r2 != 0) goto L36
                goto L46
            L36:
                if (r5 == 0) goto L43
                com.facebook.internal.DialogPresenter r5 = com.facebook.internal.DialogPresenter.INSTANCE
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                if (r5 == 0) goto L43
                goto L45
            L43:
                r5 = 0
                goto L46
            L45:
                r5 = 1
            L46:
                if (r5 == 0) goto L55
                com.facebook.share.widget.ShareDialog$Companion r5 = com.facebook.share.widget.ShareDialog.Companion
                java.lang.Class r4 = r4.getClass()
                boolean r4 = com.facebook.share.widget.ShareDialog.Companion.access$canShowNative(r5, r4)
                if (r4 == 0) goto L55
                r1 = 1
            L55:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.NativeHandler.canShow(com.facebook.share.model.ShareContent, boolean):boolean");
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @oOoXoXO
        public AppCall createAppCall(@OOXIXo final ShareContent<?, ?> content) {
            IIX0o.x0xO0oo(content, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), content, Mode.NATIVE);
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForNativeShare(content);
            final AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            final boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature feature = ShareDialog.Companion.getFeature(content.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.ShareDialog$NativeHandler$createAppCall$1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                @oOoXoXO
                public Bundle getLegacyParameters() {
                    LegacyNativeDialogParameters legacyNativeDialogParameters = LegacyNativeDialogParameters.INSTANCE;
                    return LegacyNativeDialogParameters.create(AppCall.this.getCallId(), content, shouldFailOnDataError);
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                @oOoXoXO
                public Bundle getParameters() {
                    NativeDialogParameters nativeDialogParameters = NativeDialogParameters.INSTANCE;
                    return NativeDialogParameters.create(AppCall.this.getCallId(), content, shouldFailOnDataError);
                }
            }, feature);
            return createBaseAppCall;
        }
    }

    /* loaded from: classes8.dex */
    public final class ShareStoryHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {

        @OOXIXo
        private Object mode;
        final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShareStoryHandler(ShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = Mode.NATIVE;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(@OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(@OOXIXo ShareContent<?, ?> content, boolean z) {
            IIX0o.x0xO0oo(content, "content");
            return (content instanceof ShareStoryContent) && ShareDialog.Companion.canShowNative(content.getClass());
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @oOoXoXO
        public AppCall createAppCall(@OOXIXo final ShareContent<?, ?> content) {
            IIX0o.x0xO0oo(content, "content");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForStoryShare(content);
            final AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            final boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature feature = ShareDialog.Companion.getFeature(content.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new DialogPresenter.ParameterProvider() { // from class: com.facebook.share.widget.ShareDialog$ShareStoryHandler$createAppCall$1
                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                @oOoXoXO
                public Bundle getLegacyParameters() {
                    LegacyNativeDialogParameters legacyNativeDialogParameters = LegacyNativeDialogParameters.INSTANCE;
                    return LegacyNativeDialogParameters.create(AppCall.this.getCallId(), content, shouldFailOnDataError);
                }

                @Override // com.facebook.internal.DialogPresenter.ParameterProvider
                @oOoXoXO
                public Bundle getParameters() {
                    NativeDialogParameters nativeDialogParameters = NativeDialogParameters.INSTANCE;
                    return NativeDialogParameters.create(AppCall.this.getCallId(), content, shouldFailOnDataError);
                }
            }, feature);
            return createBaseAppCall;
        }
    }

    /* loaded from: classes8.dex */
    public final class WebShareHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {

        @OOXIXo
        private Object mode;
        final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebShareHandler(ShareDialog this$0) {
            super(this$0);
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = Mode.WEB;
        }

        private final SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.Builder readFrom = new SharePhotoContent.Builder().readFrom(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = sharePhotoContent.getPhotos().size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    SharePhoto sharePhoto = sharePhotoContent.getPhotos().get(i);
                    Bitmap bitmap = sharePhoto.getBitmap();
                    if (bitmap != null) {
                        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
                        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                        sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap(null).build();
                        arrayList2.add(createAttachment);
                    }
                    arrayList.add(sharePhoto);
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            readFrom.setPhotos(arrayList);
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore2 = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            return readFrom.build();
        }

        private final String getActionName(ShareContent<?, ?> shareContent) {
            if (!(shareContent instanceof ShareLinkContent) && !(shareContent instanceof SharePhotoContent)) {
                return null;
            }
            return "share";
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @OOXIXo
        public Object getMode() {
            return this.mode;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public void setMode(@OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.mode = obj;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(@OOXIXo ShareContent<?, ?> content, boolean z) {
            IIX0o.x0xO0oo(content, "content");
            return ShareDialog.Companion.canShowWebCheck(content);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        @oOoXoXO
        public AppCall createAppCall(@OOXIXo ShareContent<?, ?> content) {
            Bundle create;
            IIX0o.x0xO0oo(content, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), content, Mode.WEB);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForWebShare(content);
            if (content instanceof ShareLinkContent) {
                WebDialogParameters webDialogParameters = WebDialogParameters.INSTANCE;
                create = WebDialogParameters.create((ShareLinkContent) content);
            } else {
                if (!(content instanceof SharePhotoContent)) {
                    return null;
                }
                SharePhotoContent createAndMapAttachments = createAndMapAttachments((SharePhotoContent) content, createBaseAppCall.getCallId());
                WebDialogParameters webDialogParameters2 = WebDialogParameters.INSTANCE;
                create = WebDialogParameters.create(createAndMapAttachments);
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(content), create);
            return createBaseAppCall;
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.valuesCustom().length];
            iArr[Mode.AUTOMATIC.ordinal()] = 1;
            iArr[Mode.WEB.ordinal()] = 2;
            iArr[Mode.NATIVE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String simpleName = ShareDialog.class.getSimpleName();
        IIX0o.oO(simpleName, "ShareDialog::class.java.simpleName");
        TAG = simpleName;
        DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo Activity activity) {
        this(activity, DEFAULT_REQUEST_CODE);
        IIX0o.x0xO0oo(activity, "activity");
    }

    @x0XOIxOo
    public static boolean canShow(@OOXIXo Class<? extends ShareContent<?, ?>> cls) {
        return Companion.canShow(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDialogShare(Context context, ShareContent<?, ?> shareContent, Mode mode) {
        String str;
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        String str2 = "unknown";
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    str = "unknown";
                } else {
                    str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
                }
            } else {
                str = "web";
            }
        } else {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
        }
        DialogFeature feature = Companion.getFeature(shareContent.getClass());
        if (feature == ShareDialogFeature.SHARE_DIALOG) {
            str2 = "status";
        } else if (feature == ShareDialogFeature.PHOTOS) {
            str2 = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
        } else if (feature == ShareDialogFeature.VIDEO) {
            str2 = "video";
        }
        InternalAppEventsLogger.Companion companion = InternalAppEventsLogger.Companion;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InternalAppEventsLogger createInstance = companion.createInstance(context, FacebookSdk.getApplicationId());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str2);
        createInstance.logEventImplicitly("fb_share_dialog_show", bundle);
    }

    @x0XOIxOo
    public static void show(@OOXIXo Activity activity, @OOXIXo ShareContent<?, ?> shareContent) {
        Companion.show(activity, shareContent);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    @OOXIXo
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), null, 2, null);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    @OOXIXo
    public List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        return this.orderedModeHandlers;
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(@OOXIXo CallbackManagerImpl callbackManager, @OOXIXo FacebookCallback<Sharer.Result> callback) {
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(callback, "callback");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, callback);
    }

    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public ShareDialog(int i) {
        super(i);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt__CollectionsKt.Oxx0xo(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    @x0XOIxOo
    public static void show(@OOXIXo android.app.Fragment fragment, @OOXIXo ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    public boolean canShow(@OOXIXo ShareContent<?, ?> content, @OOXIXo Mode mode) {
        IIX0o.x0xO0oo(content, "content");
        IIX0o.x0xO0oo(mode, "mode");
        Object obj = mode;
        if (mode == Mode.AUTOMATIC) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        return canShowImpl(content, obj);
    }

    @x0XOIxOo
    public static void show(@OOXIXo Fragment fragment, @OOXIXo ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    public void show(@OOXIXo ShareContent<?, ?> content, @OOXIXo Mode mode) {
        IIX0o.x0xO0oo(content, "content");
        IIX0o.x0xO0oo(mode, "mode");
        boolean z = mode == Mode.AUTOMATIC;
        this.isAutomaticMode = z;
        Object obj = mode;
        if (z) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        showImpl(content, obj);
    }

    public /* synthetic */ ShareDialog(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? DEFAULT_REQUEST_CODE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, null);
        IIX0o.x0xO0oo(fragment, "fragment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, null);
        IIX0o.x0xO0oo(fragment, "fragment");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo Activity activity, int i) {
        super(activity, i);
        IIX0o.x0xO0oo(activity, "activity");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt__CollectionsKt.Oxx0xo(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        IIX0o.x0xO0oo(fragment, "fragment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo android.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        IIX0o.x0xO0oo(fragment, "fragment");
    }

    public /* synthetic */ ShareDialog(FragmentWrapper fragmentWrapper, int i, int i2, IIXOooo iIXOooo) {
        this(fragmentWrapper, (i2 & 2) != 0 ? DEFAULT_REQUEST_CODE : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialog(@OOXIXo FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        IIX0o.x0xO0oo(fragmentWrapper, "fragmentWrapper");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt__CollectionsKt.Oxx0xo(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }
}
