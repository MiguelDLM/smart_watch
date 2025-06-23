package androidx.core.animation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.animation.Animator;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,123:1\n91#1,14:124\n91#1,14:138\n91#1,14:152\n91#1,14:166\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n30#1:124,14\n41#1:138,14\n52#1:152,14\n62#1:166,14\n*E\n"})
/* loaded from: classes.dex */
public final class AnimatorKt {
    @OOXIXo
    public static final Animator.AnimatorListener addListener(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo3, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo4) {
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(oooxoxo4, oooxoxo, oooxoxo3, oooxoxo2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, oOoXoXO oooxoxo, oOoXoXO oooxoxo2, oOoXoXO oooxoxo3, oOoXoXO oooxoxo4, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = new oOoXoXO<Animator, oXIO0o0XI>() { // from class: androidx.core.animation.AnimatorKt$addListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo Animator animator2) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 2) != 0) {
            oooxoxo2 = new oOoXoXO<Animator, oXIO0o0XI>() { // from class: androidx.core.animation.AnimatorKt$addListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo Animator animator2) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 4) != 0) {
            oooxoxo3 = new oOoXoXO<Animator, oXIO0o0XI>() { // from class: androidx.core.animation.AnimatorKt$addListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo Animator animator2) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 8) != 0) {
            oooxoxo4 = new oOoXoXO<Animator, oXIO0o0XI>() { // from class: androidx.core.animation.AnimatorKt$addListener$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo Animator animator2) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(oooxoxo4, oooxoxo, oooxoxo3, oooxoxo2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @OOXIXo
    public static final Animator.AnimatorPauseListener addPauseListener(@OOXIXo Animator animator, @OOXIXo final oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, @OOXIXo final oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2) {
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$listener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@OOXIXo Animator animator2) {
                oooxoxo2.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@OOXIXo Animator animator2) {
                oooxoxo.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, oOoXoXO oooxoxo, oOoXoXO oooxoxo2, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = new oOoXoXO<Animator, oXIO0o0XI>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo Animator animator2) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 2) != 0) {
            oooxoxo2 = new oOoXoXO<Animator, oXIO0o0XI>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo Animator animator2) {
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return addPauseListener(animator, oooxoxo, oooxoxo2);
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnCancel(@OOXIXo Animator animator, @OOXIXo final oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@OOXIXo Animator animator2) {
                oOoXoXO.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@OOXIXo Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnEnd(@OOXIXo Animator animator, @OOXIXo final oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@OOXIXo Animator animator2) {
                oOoXoXO.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@OOXIXo Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @OOXIXo
    public static final Animator.AnimatorPauseListener doOnPause(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        return addPauseListener$default(animator, null, oooxoxo, 1, null);
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnRepeat(@OOXIXo Animator animator, @OOXIXo final oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@OOXIXo Animator animator2) {
                oOoXoXO.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@OOXIXo Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @OOXIXo
    public static final Animator.AnimatorPauseListener doOnResume(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        return addPauseListener$default(animator, oooxoxo, null, 2, null);
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnStart(@OOXIXo Animator animator, @OOXIXo final oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@OOXIXo Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@OOXIXo Animator animator2) {
                oOoXoXO.this.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
