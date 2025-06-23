package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class GetAccountOrderList {

    @OOXIXo
    public static final String IDENTITY = "identity";

    @OOXIXo
    public static final GetAccountOrderList INSTANCE = new GetAccountOrderList();

    @OOXIXo
    public static final String ORDER_PAGE_NUM = "pageNum";

    @OOXIXo
    public static final String ORDER_TYPE = "orderType";

    @OOXIXo
    public static final String URL = "/order/select";

    private GetAccountOrderList() {
    }
}
