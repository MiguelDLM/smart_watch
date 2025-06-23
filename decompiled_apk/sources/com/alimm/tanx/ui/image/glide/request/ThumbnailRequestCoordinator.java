package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private RequestCoordinator coordinator;
    private Request full;
    private Request thumb;

    public ThumbnailRequestCoordinator() {
        this(null);
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
            return false;
        }
        return true;
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
            return false;
        }
        return true;
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator != null && requestCoordinator.isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void begin() {
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (!this.full.isRunning()) {
            this.full.begin();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        if (parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        if (parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet())) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void clear() {
        this.thumb.clear();
        this.full.clear();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        if (!parentIsAnyResourceSet() && !isResourceSet()) {
            return false;
        }
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isComplete() {
        if (!this.full.isComplete() && !this.thumb.isComplete()) {
            return false;
        }
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isFailed() {
        return this.full.isFailed();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isPaused() {
        return this.full.isPaused();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isResourceSet() {
        if (!this.full.isResourceSet() && !this.thumb.isResourceSet()) {
            return false;
        }
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isRunning() {
        return this.full.isRunning();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        if (request.equals(this.thumb)) {
            return;
        }
        RequestCoordinator requestCoordinator = this.coordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
        if (!this.thumb.isComplete()) {
            this.thumb.clear();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void pause() {
        this.full.pause();
        this.thumb.pause();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }
}
