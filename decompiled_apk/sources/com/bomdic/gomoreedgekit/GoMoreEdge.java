package com.bomdic.gomoreedgekit;

import OXOo.OOXIXo;

/* loaded from: classes8.dex */
public final class GoMoreEdge {

    @OOXIXo
    public static final GoMoreEdge INSTANCE = new GoMoreEdge();

    private GoMoreEdge() {
    }

    public final void initialize() {
        System.loadLibrary("GoMoreEdgeKit");
    }
}
