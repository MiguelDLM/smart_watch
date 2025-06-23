package com.baidu.ar;

import com.baidu.ar.track2d.ITrack2DState;

/* loaded from: classes7.dex */
class jl implements ITrack2DState {
    boolean AA;
    boolean AE;
    boolean AF;
    ITrack2DState.DistanceState AG;

    @Override // com.baidu.ar.track2d.ITrack2DState
    public ITrack2DState.DistanceState distanceState() {
        return this.AG;
    }

    @Override // com.baidu.ar.track2d.ITrack2DState
    public boolean isModelAppear() {
        return this.AE;
    }

    @Override // com.baidu.ar.track2d.ITrack2DState
    public boolean isShowImmediately() {
        return this.AA;
    }

    @Override // com.baidu.ar.track2d.ITrack2DState
    public boolean isTrackFound() {
        return this.AF;
    }
}
