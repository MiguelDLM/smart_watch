package com.sma.smartv3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.appcompat.widget.AppCompatImageView;
import com.sma.smartv3.R;
import java.math.BigDecimal;

/* loaded from: classes12.dex */
public class GifImageView extends AppCompatImageView {
    private static final int DEFAULT_DURATION = 1000;
    private int counts;
    private boolean endLastFrame;
    private volatile boolean hasStart;
    private long mMoviePauseTime;
    private long mMovieStart;
    private oIX0oI mOnPlayListener;
    private volatile boolean mPaused;
    private float mScale;
    private float mScaleH;
    private float mScaleW;
    private boolean mVisible;
    private Movie movie;
    private int movieDuration;
    private long offsetTime;

    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    float percent;
    private volatile boolean reverse;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void I0Io(boolean pauseSuccess);

        void II0xO0();

        void oIX0oI();

        void onPlayStart();

        void oxoX(@FloatRange(from = 0.0d, to = 1.0d) float percent);
    }

    public GifImageView(Context context) {
        this(context, null);
    }

    private void drawMovieFrame(Canvas canvas) {
        canvas.save();
        canvas.scale(1.0f / this.mScaleW, 1.0f / this.mScaleH);
        this.movie.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }

    private int getCurrentFrameTime() {
        if (this.movieDuration == 0) {
            return 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.offsetTime;
        long j = this.mMovieStart;
        int i = this.movieDuration;
        int i2 = (int) ((uptimeMillis - j) / i);
        int i3 = this.counts;
        if (i3 != -1 && i2 >= i3) {
            this.hasStart = false;
            oIX0oI oix0oi = this.mOnPlayListener;
            if (oix0oi != null) {
                oix0oi.oIX0oI();
            }
            if (!this.endLastFrame) {
                return 0;
            }
            return this.movieDuration;
        }
        float f = (float) ((uptimeMillis - j) % i);
        this.percent = f / i;
        if (this.mOnPlayListener != null && this.hasStart) {
            double doubleValue = new BigDecimal(this.percent).setScale(2, 4).doubleValue();
            if (doubleValue == 0.99d) {
                doubleValue = 1.0d;
            }
            this.mOnPlayListener.oxoX((float) doubleValue);
        }
        return (int) f;
    }

    private void invalidateView() {
        if (this.mVisible) {
            postInvalidateOnAnimation();
        }
    }

    private void reset() {
        this.reverse = false;
        this.mMovieStart = SystemClock.uptimeMillis();
        this.mPaused = false;
        this.hasStart = true;
        this.mMoviePauseTime = 0L;
        this.offsetTime = 0L;
    }

    private void setViewAttributes(Context context, AttributeSet attrs, int defStyle) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.GifImageView, defStyle, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        this.counts = obtainStyledAttributes.getInt(3, -1);
        this.endLastFrame = obtainStyledAttributes.getBoolean(1, false);
        if (resourceId > 0) {
            setGifResource(resourceId, (oIX0oI) null);
            if (z) {
                play(this.counts);
            }
        }
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    public int getDuration() {
        Movie movie = this.movie;
        if (movie != null) {
            return movie.duration();
        }
        return 0;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean isPlaying() {
        if (!this.mPaused && this.hasStart) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.movie != null) {
            if (!this.mPaused && this.hasStart) {
                if (this.reverse) {
                    this.movie.setTime(this.movieDuration - getCurrentFrameTime());
                } else {
                    this.movie.setTime(getCurrentFrameTime());
                }
                drawMovieFrame(canvas);
                invalidateView();
                return;
            }
            drawMovieFrame(canvas);
            return;
        }
        if (this.mOnPlayListener != null && this.hasStart) {
            this.hasStart = false;
            this.mOnPlayListener.oIX0oI();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        Movie movie = this.movie;
        if (movie != null) {
            int width = movie.width();
            int height = this.movie.height();
            if (mode == 1073741824) {
                this.mScaleW = width / size;
            }
            if (mode2 == 1073741824) {
                this.mScaleH = height / size2;
            }
            this.mScale = Math.max(this.mScaleW, this.mScaleH);
            if (mode != 1073741824) {
                size = width;
            }
            if (mode2 != 1073741824) {
                size2 = height;
            }
            setMeasuredDimension(size, size2);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        boolean z = true;
        if (screenState != 1) {
            z = false;
        }
        this.mVisible = z;
        invalidateView();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        boolean z;
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            z = true;
        } else {
            z = false;
        }
        this.mVisible = z;
        invalidateView();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        boolean z;
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            z = true;
        } else {
            z = false;
        }
        this.mVisible = z;
        invalidateView();
    }

    public void pause() {
        if (this.movie != null && !this.mPaused && this.hasStart) {
            this.mPaused = true;
            invalidate();
            this.mMoviePauseTime = SystemClock.uptimeMillis();
            oIX0oI oix0oi = this.mOnPlayListener;
            if (oix0oi != null) {
                oix0oi.I0Io(true);
                return;
            }
            return;
        }
        oIX0oI oix0oi2 = this.mOnPlayListener;
        if (oix0oi2 != null) {
            oix0oi2.I0Io(false);
        }
    }

    public void play(int counts) {
        this.counts = counts;
        reset();
        oIX0oI oix0oi = this.mOnPlayListener;
        if (oix0oi != null) {
            oix0oi.onPlayStart();
        }
        invalidate();
    }

    public void playOver() {
        if (this.movie != null) {
            play(-1);
        }
    }

    public void playReverse() {
        if (this.movie != null) {
            reset();
            this.reverse = true;
            oIX0oI oix0oi = this.mOnPlayListener;
            if (oix0oi != null) {
                oix0oi.onPlayStart();
            }
            invalidate();
        }
    }

    public void setGifResource(int movieResourceId, oIX0oI onPlayListener) {
        Bitmap decodeResource;
        if (onPlayListener != null) {
            this.mOnPlayListener = onPlayListener;
        }
        reset();
        Movie decodeStream = Movie.decodeStream(getResources().openRawResource(movieResourceId));
        this.movie = decodeStream;
        if (decodeStream == null && (decodeResource = BitmapFactory.decodeResource(getResources(), movieResourceId)) != null) {
            setImageBitmap(decodeResource);
        } else {
            this.movieDuration = this.movie.duration() == 0 ? 1000 : this.movie.duration();
            requestLayout();
        }
    }

    public void setOnPlayListener(oIX0oI onPlayListener) {
        this.mOnPlayListener = onPlayListener;
    }

    public void setPercent(float percent) {
        int i;
        Movie movie = this.movie;
        if (movie != null && (i = this.movieDuration) > 0) {
            this.percent = percent;
            movie.setTime((int) (i * percent));
            invalidateView();
            oIX0oI oix0oi = this.mOnPlayListener;
            if (oix0oi != null) {
                oix0oi.oxoX(percent);
            }
        }
    }

    public GifImageView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public GifImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mScaleW = 1.0f;
        this.mScaleH = 1.0f;
        this.mScale = 1.0f;
        this.counts = -1;
        this.reverse = false;
        this.mVisible = true;
        this.endLastFrame = false;
        setViewAttributes(context, attrs, defStyle);
    }

    public void play() {
        if (this.movie == null) {
            return;
        }
        if (this.hasStart) {
            if (!this.mPaused || this.mMoviePauseTime <= 0) {
                return;
            }
            this.mPaused = false;
            this.offsetTime = (this.offsetTime + SystemClock.uptimeMillis()) - this.mMoviePauseTime;
            invalidate();
            oIX0oI oix0oi = this.mOnPlayListener;
            if (oix0oi != null) {
                oix0oi.II0xO0();
                return;
            }
            return;
        }
        play(-1);
    }

    public void setGifResource(int movieResourceId) {
        setGifResource(movieResourceId, (oIX0oI) null);
    }

    public void setGifResource(final String path, oIX0oI onPlayListener) {
        Bitmap decodeFile;
        this.movie = Movie.decodeFile(path);
        this.mOnPlayListener = onPlayListener;
        reset();
        if (this.movie == null && (decodeFile = BitmapFactory.decodeFile(path)) != null) {
            setImageBitmap(decodeFile);
            return;
        }
        this.movieDuration = this.movie.duration() == 0 ? 1000 : this.movie.duration();
        requestLayout();
        oIX0oI oix0oi = this.mOnPlayListener;
        if (oix0oi != null) {
            oix0oi.onPlayStart();
        }
    }
}
