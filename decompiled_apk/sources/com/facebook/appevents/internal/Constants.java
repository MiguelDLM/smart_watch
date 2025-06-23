package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;

/* loaded from: classes8.dex */
public final class Constants {

    @OOXIXo
    public static final String AA_TIME_SPENT_EVENT_NAME = "fb_aa_time_spent_on_view";

    @OOXIXo
    public static final String AA_TIME_SPENT_SCREEN_PARAMETER_NAME = "fb_aa_time_spent_view_name";

    @OOXIXo
    public static final String EVENT_NAME_EVENT_KEY = "_eventName";

    @OOXIXo
    public static final String EVENT_NAME_MD5_EVENT_KEY = "_eventName_md5";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_AVAILABILITY = "fb_product_availability";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_BRAND = "fb_product_brand";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_CONDITION = "fb_product_condition";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_DESCRIPTION = "fb_product_description";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_GTIN = "fb_product_gtin";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_IMAGE_LINK = "fb_product_image_link";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_ITEM_ID = "fb_product_item_id";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_LINK = "fb_product_link";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_MPN = "fb_product_mpn";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_PRICE_AMOUNT = "fb_product_price_amount";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_PRICE_CURRENCY = "fb_product_price_currency";

    @OOXIXo
    public static final String EVENT_PARAM_PRODUCT_TITLE = "fb_product_title";

    @OOXIXo
    public static final String IAP_FREE_TRIAL_PERIOD = "fb_free_trial_period";

    @OOXIXo
    public static final String IAP_INTRO_PRICE_AMOUNT_MICROS = "fb_intro_price_amount_micros";

    @OOXIXo
    public static final String IAP_INTRO_PRICE_CYCLES = "fb_intro_price_cycles";

    @OOXIXo
    public static final String IAP_PACKAGE_NAME = "fb_iap_package_name";

    @OOXIXo
    public static final String IAP_PRODUCT_DESCRIPTION = "fb_iap_product_description";

    @OOXIXo
    public static final String IAP_PRODUCT_ID = "fb_iap_product_id";

    @OOXIXo
    public static final String IAP_PRODUCT_TITLE = "fb_iap_product_title";

    @OOXIXo
    public static final String IAP_PRODUCT_TYPE = "fb_iap_product_type";

    @OOXIXo
    public static final String IAP_PURCHASE_TIME = "fb_iap_purchase_time";

    @OOXIXo
    public static final String IAP_PURCHASE_TOKEN = "fb_iap_purchase_token";

    @OOXIXo
    public static final String IAP_SUBSCRIPTION_AUTORENEWING = "fb_iap_subs_auto_renewing";

    @OOXIXo
    public static final String IAP_SUBSCRIPTION_PERIOD = "fb_iap_subs_period";

    @OOXIXo
    public static final Constants INSTANCE = new Constants();

    @OOXIXo
    public static final String LOG_TIME_APP_EVENT_KEY = "_logTime";

    private Constants() {
    }

    @x0XOIxOo
    public static final int getDefaultAppEventsSessionTimeoutInSeconds() {
        return 60;
    }
}
