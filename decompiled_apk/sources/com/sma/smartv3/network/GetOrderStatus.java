package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class GetOrderStatus {

    @OOXIXo
    public static final String IDENTITY = "identity";

    @OOXIXo
    public static final GetOrderStatus INSTANCE = new GetOrderStatus();

    @OOXIXo
    public static final String ORDER_NUM = "orderNum";

    @OOXIXo
    public static final String ORDER_TYPE = "orderType";

    @OOXIXo
    public static final String URL = "/order/selectByOrderNum";

    private GetOrderStatus() {
    }
}
