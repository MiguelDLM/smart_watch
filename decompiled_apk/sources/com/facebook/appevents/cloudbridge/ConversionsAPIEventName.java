package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum ConversionsAPIEventName {
    UNLOCKED_ACHIEVEMENT("AchievementUnlocked"),
    ACTIVATED_APP("ActivateApp"),
    ADDED_PAYMENT_INFO("AddPaymentInfo"),
    ADDED_TO_CART("AddToCart"),
    ADDED_TO_WISHLIST("AddToWishlist"),
    COMPLETED_REGISTRATION("CompleteRegistration"),
    VIEWED_CONTENT("ViewContent"),
    INITIATED_CHECKOUT("InitiateCheckout"),
    ACHIEVED_LEVEL("LevelAchieved"),
    PURCHASED("Purchase"),
    RATED("Rate"),
    SEARCHED("Search"),
    SPENT_CREDITS("SpentCredits"),
    COMPLETED_TUTORIAL("TutorialCompletion");


    @OOXIXo
    private final String rawValue;

    ConversionsAPIEventName(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ConversionsAPIEventName[] valuesCustom() {
        ConversionsAPIEventName[] valuesCustom = values();
        return (ConversionsAPIEventName[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }
}
