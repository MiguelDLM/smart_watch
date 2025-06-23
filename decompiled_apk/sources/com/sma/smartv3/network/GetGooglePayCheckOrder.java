package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class GetGooglePayCheckOrder {

    @OOXIXo
    public static final String APPLICATION_NAME = "applicationName";

    @OOXIXo
    public static final GetGooglePayCheckOrder INSTANCE = new GetGooglePayCheckOrder();

    @OOXIXo
    public static final String ORDER_NUM = "orderNum";

    @OOXIXo
    public static final String PACKAGE_NAME = "packageName";

    @OOXIXo
    public static final String PRODUCT_IT = "productId";

    @OOXIXo
    public static final String PURCHASE_TOKEN = "purchaseToken";

    @OOXIXo
    public static final String URL = "/aliPay/google/checkOrder";

    private GetGooglePayCheckOrder() {
    }
}
