package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.<clinit>():void");
        }
    }

    public static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim = false;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mIsPop = z;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            boolean z;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            Fragment fragment = getOperation().getFragment();
            if (getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                z = true;
            } else {
                z = false;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, fragment, z, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    public static class SpecialEffectsInfo {
        @NonNull
        private final SpecialEffectsController.Operation mOperation;
        @NonNull
        private final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            if (from == finalState || (from != (state = SpecialEffectsController.Operation.State.VISIBLE) && finalState != state)) {
                return true;
            }
            return false;
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        int i;
        Context context;
        boolean z2;
        View view;
        boolean z3;
        final SpecialEffectsController.Operation operation;
        ViewGroup container = getContainer();
        Context context2 = container.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it = list.iterator();
        boolean z4 = false;
        while (true) {
            i = 2;
            if (!it.hasNext()) {
                break;
            }
            AnimationInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context2);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            if (operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z3) {
                                list3.remove(operation2);
                            }
                            View view2 = fragment.mView;
                            container.startViewTransition(view2);
                            AnonymousClass2 r20 = r0;
                            View view3 = view2;
                            final ViewGroup viewGroup = container;
                            final View view4 = view3;
                            SpecialEffectsController.Operation operation3 = operation2;
                            final boolean z5 = z3;
                            Animator animator2 = animator;
                            final SpecialEffectsController.Operation operation4 = operation3;
                            final Animator animator3 = animator2;
                            final AnimationInfo animationInfo = next;
                            AnonymousClass2 r0 = new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    viewGroup.endViewTransition(view4);
                                    if (z5) {
                                        operation4.getFinalState().applyState(view4);
                                    }
                                    animationInfo.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation4 + " has ended.");
                                    }
                                }
                            };
                            animator3.addListener(r0);
                            animator3.setTarget(view3);
                            animator3.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = operation3;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v(FragmentManager.TAG, sb.toString());
                            } else {
                                operation = operation3;
                            }
                            next.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() {
                                public void onCancel() {
                                    animator3.end();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has been canceled.");
                                    }
                                }
                            });
                            z4 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AnimationInfo animationInfo2 = (AnimationInfo) it2.next();
            SpecialEffectsController.Operation operation5 = animationInfo2.getOperation();
            Fragment fragment2 = operation5.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z4) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                View view5 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context2))).animation);
                if (operation5.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view5.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                    z2 = z4;
                    context = context2;
                    view = view5;
                } else {
                    container.startViewTransition(view5);
                    final SpecialEffectsController.Operation operation6 = operation5;
                    AnonymousClass4 r14 = r0;
                    final ViewGroup viewGroup2 = container;
                    z2 = z4;
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view5);
                    final View view6 = view5;
                    context = context2;
                    view = view5;
                    final AnimationInfo animationInfo3 = animationInfo2;
                    AnonymousClass4 r02 = new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            viewGroup2.post(new Runnable() {
                                public void run() {
                                    AnonymousClass4 r0 = AnonymousClass4.this;
                                    viewGroup2.endViewTransition(view6);
                                    animationInfo3.completeSpecialEffect();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation6 + " has ended.");
                            }
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation6 + " has reached onAnimationStart.");
                            }
                        }
                    };
                    endViewTransitionAnimation.setAnimationListener(r14);
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation5 + " has started.");
                    }
                }
                CancellationSignal signal = animationInfo2.getSignal();
                final View view7 = view;
                final ViewGroup viewGroup3 = container;
                final AnimationInfo animationInfo4 = animationInfo2;
                AnonymousClass5 r8 = r0;
                final SpecialEffectsController.Operation operation7 = operation5;
                AnonymousClass5 r03 = new CancellationSignal.OnCancelListener() {
                    public void onCancel() {
                        view7.clearAnimation();
                        viewGroup3.endViewTransition(view7);
                        animationInfo4.completeSpecialEffect();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animation from operation " + operation7 + " has been cancelled.");
                        }
                    }
                };
                signal.setOnCancelListener(r8);
                z4 = z2;
                context2 = context;
                i = 2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.view.View} */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x033a, code lost:
        r1 = (android.view.View) r13.get(r10.get(r0));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r34, @androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r35, boolean r36, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r37, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r38) {
        /*
            r33 = this;
            r6 = r33
            r7 = r36
            r8 = r37
            r9 = r38
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Iterator r0 = r34.iterator()
            r15 = 0
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r2 = r1.isVisibilityUnchanged()
            if (r2 == 0) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            androidx.fragment.app.FragmentTransitionImpl r2 = r1.getHandlingImpl()
            if (r15 != 0) goto L_0x002d
            r15 = r2
            goto L_0x0012
        L_0x002d:
            if (r2 == 0) goto L_0x0012
            if (r15 != r2) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r2.append(r3)
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r1.getOperation()
            androidx.fragment.app.Fragment r3 = r3.getFragment()
            r2.append(r3)
            java.lang.String r3 = " returned Transition "
            r2.append(r3)
            java.lang.Object r1 = r1.getTransition()
            r2.append(r1)
            java.lang.String r1 = " which uses a different Transition  type than other Fragments."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0062:
            if (r15 != 0) goto L_0x0082
            java.util.Iterator r0 = r34.iterator()
        L_0x0068:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            androidx.fragment.app.SpecialEffectsController$Operation r2 = r1.getOperation()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r10.put(r2, r3)
            r1.completeSpecialEffect()
            goto L_0x0068
        L_0x0081:
            return r10
        L_0x0082:
            android.view.View r14 = new android.view.View
            android.view.ViewGroup r0 = r33.getContainer()
            android.content.Context r0 = r0.getContext()
            r14.<init>(r0)
            android.graphics.Rect r13 = new android.graphics.Rect
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r20 = r34.iterator()
            r0 = 0
            r2 = 0
            r21 = 0
        L_0x00ab:
            boolean r1 = r20.hasNext()
            r22 = 2
            java.lang.String r3 = "FragmentManager"
            if (r1 == 0) goto L_0x03a5
            java.lang.Object r1 = r20.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r17 = r1.hasSharedElementTransition()
            if (r17 == 0) goto L_0x0388
            if (r8 == 0) goto L_0x0388
            if (r9 == 0) goto L_0x0388
            java.lang.Object r0 = r1.getSharedElementTransition()
            java.lang.Object r0 = r15.cloneTransition(r0)
            java.lang.Object r1 = r15.wrapTransitionInSet(r0)
            androidx.fragment.app.Fragment r0 = r38.getFragment()
            java.util.ArrayList r0 = r0.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r17 = r37.getFragment()
            java.util.ArrayList r11 = r17.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r17 = r37.getFragment()
            r18 = r1
            java.util.ArrayList r1 = r17.getSharedElementTargetNames()
            r17 = r2
            r24 = r10
            r2 = 0
        L_0x00f0:
            int r10 = r1.size()
            if (r2 >= r10) goto L_0x0111
            java.lang.Object r10 = r1.get(r2)
            int r10 = r0.indexOf(r10)
            r19 = r1
            r1 = -1
            if (r10 == r1) goto L_0x010c
            java.lang.Object r1 = r11.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r0.set(r10, r1)
        L_0x010c:
            int r2 = r2 + 1
            r1 = r19
            goto L_0x00f0
        L_0x0111:
            androidx.fragment.app.Fragment r1 = r38.getFragment()
            java.util.ArrayList r10 = r1.getSharedElementTargetNames()
            if (r7 != 0) goto L_0x012c
            androidx.fragment.app.Fragment r1 = r37.getFragment()
            androidx.core.app.SharedElementCallback r1 = r1.getExitTransitionCallback()
            androidx.fragment.app.Fragment r2 = r38.getFragment()
            androidx.core.app.SharedElementCallback r2 = r2.getEnterTransitionCallback()
            goto L_0x013c
        L_0x012c:
            androidx.fragment.app.Fragment r1 = r37.getFragment()
            androidx.core.app.SharedElementCallback r1 = r1.getEnterTransitionCallback()
            androidx.fragment.app.Fragment r2 = r38.getFragment()
            androidx.core.app.SharedElementCallback r2 = r2.getExitTransitionCallback()
        L_0x013c:
            int r11 = r0.size()
            r19 = r14
            r14 = 0
        L_0x0143:
            if (r14 >= r11) goto L_0x0163
            java.lang.Object r25 = r0.get(r14)
            r26 = r11
            r11 = r25
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r25 = r10.get(r14)
            r27 = r13
            r13 = r25
            java.lang.String r13 = (java.lang.String) r13
            r4.put(r11, r13)
            int r14 = r14 + 1
            r11 = r26
            r13 = r27
            goto L_0x0143
        L_0x0163:
            r27 = r13
            boolean r11 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r22)
            if (r11 == 0) goto L_0x01c5
            java.lang.String r11 = ">>> entering view names <<<"
            android.util.Log.v(r3, r11)
            java.util.Iterator r11 = r10.iterator()
        L_0x0174:
            boolean r13 = r11.hasNext()
            java.lang.String r14 = "Name: "
            if (r13 == 0) goto L_0x0199
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            r25 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r14)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            android.util.Log.v(r3, r11)
            r11 = r25
            goto L_0x0174
        L_0x0199:
            java.lang.String r11 = ">>> exiting view names <<<"
            android.util.Log.v(r3, r11)
            java.util.Iterator r11 = r0.iterator()
        L_0x01a2:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x01c5
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            r25 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r14)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            android.util.Log.v(r3, r11)
            r11 = r25
            goto L_0x01a2
        L_0x01c5:
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap
            r11.<init>()
            androidx.fragment.app.Fragment r13 = r37.getFragment()
            android.view.View r13 = r13.mView
            r6.findNamedViews(r11, r13)
            r11.retainAll(r0)
            if (r1 == 0) goto L_0x0232
            boolean r13 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r22)
            if (r13 == 0) goto L_0x01f2
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Executing exit callback for operation "
            r13.append(r14)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            android.util.Log.v(r3, r13)
        L_0x01f2:
            r1.onMapSharedElements(r0, r11)
            int r1 = r0.size()
            r13 = 1
            int r1 = r1 - r13
        L_0x01fb:
            if (r1 < 0) goto L_0x022f
            java.lang.Object r13 = r0.get(r1)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r11.get(r13)
            android.view.View r14 = (android.view.View) r14
            if (r14 != 0) goto L_0x0211
            r4.remove(r13)
            r25 = r0
            goto L_0x022a
        L_0x0211:
            r25 = r0
            java.lang.String r0 = androidx.core.view.ViewCompat.getTransitionName(r14)
            boolean r0 = r13.equals(r0)
            if (r0 != 0) goto L_0x022a
            java.lang.Object r0 = r4.remove(r13)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r13 = androidx.core.view.ViewCompat.getTransitionName(r14)
            r4.put(r13, r0)
        L_0x022a:
            int r1 = r1 + -1
            r0 = r25
            goto L_0x01fb
        L_0x022f:
            r25 = r0
            goto L_0x023b
        L_0x0232:
            r25 = r0
            java.util.Set r0 = r11.keySet()
            r4.retainAll(r0)
        L_0x023b:
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            androidx.fragment.app.Fragment r0 = r38.getFragment()
            android.view.View r0 = r0.mView
            r6.findNamedViews(r13, r0)
            r13.retainAll(r10)
            java.util.Collection r0 = r4.values()
            r13.retainAll(r0)
            if (r2 == 0) goto L_0x02ac
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r22)
            if (r0 == 0) goto L_0x026f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Executing enter callback for operation "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r3, r0)
        L_0x026f:
            r2.onMapSharedElements(r10, r13)
            int r0 = r10.size()
            r1 = 1
            int r0 = r0 - r1
        L_0x0278:
            if (r0 < 0) goto L_0x02af
            java.lang.Object r1 = r10.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r13.get(r1)
            android.view.View r2 = (android.view.View) r2
            if (r2 != 0) goto L_0x0292
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.findKeyForValue(r4, r1)
            if (r1 == 0) goto L_0x02a9
            r4.remove(r1)
            goto L_0x02a9
        L_0x0292:
            java.lang.String r3 = androidx.core.view.ViewCompat.getTransitionName(r2)
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x02a9
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.findKeyForValue(r4, r1)
            if (r1 == 0) goto L_0x02a9
            java.lang.String r2 = androidx.core.view.ViewCompat.getTransitionName(r2)
            r4.put(r1, r2)
        L_0x02a9:
            int r0 = r0 + -1
            goto L_0x0278
        L_0x02ac:
            androidx.fragment.app.FragmentTransition.retainValues(r4, r13)
        L_0x02af:
            java.util.Set r0 = r4.keySet()
            r6.retainMatchingViews(r11, r0)
            java.util.Collection r0 = r4.values()
            r6.retainMatchingViews(r13, r0)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x02dc
            r12.clear()
            r5.clear()
            r28 = r4
            r10 = r5
            r4 = r8
            r7 = r12
            r11 = r15
            r2 = r17
            r1 = r19
            r8 = r24
            r5 = r27
            r0 = 0
            r14 = 0
            r15 = r9
            goto L_0x0397
        L_0x02dc:
            androidx.fragment.app.Fragment r0 = r38.getFragment()
            androidx.fragment.app.Fragment r1 = r37.getFragment()
            r14 = 1
            androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(r0, r1, r7, r11, r14)
            android.view.ViewGroup r3 = r33.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$6 r2 = new androidx.fragment.app.DefaultSpecialEffectsController$6
            r1 = r25
            r0 = r2
            r14 = r18
            r1 = r33
            r7 = r2
            r26 = r17
            r2 = r38
            r9 = r3
            r3 = r37
            r28 = r4
            r4 = r36
            r8 = r5
            r5 = r13
            r0.<init>(r2, r3, r4, r5)
            androidx.core.view.OneShotPreDrawListener.add(r9, r7)
            java.util.Collection r0 = r11.values()
            r12.addAll(r0)
            boolean r0 = r25.isEmpty()
            if (r0 != 0) goto L_0x032a
            r1 = r25
            r0 = 0
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r11.get(r1)
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            r15.setEpicenter((java.lang.Object) r14, (android.view.View) r2)
            goto L_0x032d
        L_0x032a:
            r0 = 0
            r2 = r26
        L_0x032d:
            java.util.Collection r1 = r13.values()
            r8.addAll(r1)
            boolean r1 = r10.isEmpty()
            if (r1 != 0) goto L_0x035b
            java.lang.Object r1 = r10.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r13.get(r1)
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x035b
            android.view.ViewGroup r3 = r33.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$7 r4 = new androidx.fragment.app.DefaultSpecialEffectsController$7
            r5 = r27
            r4.<init>(r15, r1, r5)
            androidx.core.view.OneShotPreDrawListener.add(r3, r4)
            r1 = r19
            r21 = 1
            goto L_0x035f
        L_0x035b:
            r5 = r27
            r1 = r19
        L_0x035f:
            r15.setSharedElementTargets(r14, r1, r12)
            r16 = 0
            r17 = 0
            r3 = 0
            r4 = 0
            r7 = r12
            r12 = r15
            r13 = r14
            r9 = r14
            r14 = r3
            r11 = r15
            r15 = r4
            r18 = r9
            r19 = r8
            r12.scheduleRemoveTargets(r13, r14, r15, r16, r17, r18, r19)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4 = r37
            r10 = r8
            r8 = r24
            r8.put(r4, r3)
            r15 = r38
            r14 = 0
            r8.put(r15, r3)
            r0 = r9
            goto L_0x0397
        L_0x0388:
            r26 = r2
            r28 = r4
            r4 = r8
            r8 = r10
            r7 = r12
            r1 = r14
            r11 = r15
            r14 = 0
            r10 = r5
            r15 = r9
            r5 = r13
            r2 = r26
        L_0x0397:
            r14 = r1
            r13 = r5
            r12 = r7
            r5 = r10
            r9 = r15
            r7 = r36
            r10 = r8
            r15 = r11
            r8 = r4
            r4 = r28
            goto L_0x00ab
        L_0x03a5:
            r26 = r2
            r28 = r4
            r4 = r8
            r8 = r10
            r7 = r12
            r1 = r14
            r11 = r15
            r14 = 0
            r10 = r5
            r15 = r9
            r5 = r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r9 = r34.iterator()
            r12 = 0
            r13 = 0
        L_0x03bd:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x04f0
            java.lang.Object r16 = r9.next()
            r20 = r16
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r20 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r20
            boolean r16 = r20.isVisibilityUnchanged()
            if (r16 == 0) goto L_0x03e3
            androidx.fragment.app.SpecialEffectsController$Operation r14 = r20.getOperation()
            r36 = r9
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            r8.put(r14, r9)
            r20.completeSpecialEffect()
            r9 = r36
        L_0x03e1:
            r14 = 0
            goto L_0x03bd
        L_0x03e3:
            r36 = r9
            java.lang.Object r9 = r20.getTransition()
            java.lang.Object r9 = r11.cloneTransition(r9)
            androidx.fragment.app.SpecialEffectsController$Operation r14 = r20.getOperation()
            if (r0 == 0) goto L_0x03fa
            if (r14 == r4) goto L_0x03f7
            if (r14 != r15) goto L_0x03fa
        L_0x03f7:
            r17 = 1
            goto L_0x03fc
        L_0x03fa:
            r17 = 0
        L_0x03fc:
            if (r9 != 0) goto L_0x041c
            if (r17 != 0) goto L_0x0408
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            r8.put(r14, r9)
            r20.completeSpecialEffect()
        L_0x0408:
            r29 = r1
            r24 = r3
            r30 = r7
            r32 = r10
            r1 = r12
            r7 = r13
            r10 = r15
            r3 = r26
            r13 = 0
            r23 = 1
            r12 = r35
            goto L_0x04df
        L_0x041c:
            r24 = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r18 = r12
            androidx.fragment.app.Fragment r12 = r14.getFragment()
            android.view.View r12 = r12.mView
            r6.captureTransitioningViews(r3, r12)
            if (r17 == 0) goto L_0x0439
            if (r14 != r4) goto L_0x0436
            r3.removeAll(r7)
            goto L_0x0439
        L_0x0436:
            r3.removeAll(r10)
        L_0x0439:
            boolean r12 = r3.isEmpty()
            if (r12 == 0) goto L_0x0452
            r11.addTarget(r9, r1)
            r12 = r35
            r29 = r1
            r30 = r7
            r32 = r10
            r7 = r13
            r13 = r14
            r10 = r15
            r1 = r18
            r23 = 1
            goto L_0x04b1
        L_0x0452:
            r11.addTargets(r9, r3)
            r19 = 0
            r25 = 0
            r17 = 0
            r27 = 0
            r29 = r1
            r1 = r18
            r12 = r11
            r30 = r7
            r7 = r13
            r13 = r9
            r31 = r14
            r23 = 1
            r14 = r9
            r32 = r10
            r10 = r15
            r15 = r3
            r16 = r17
            r17 = r27
            r18 = r19
            r19 = r25
            r12.scheduleRemoveTargets(r13, r14, r15, r16, r17, r18, r19)
            androidx.fragment.app.SpecialEffectsController$Operation$State r12 = r31.getFinalState()
            androidx.fragment.app.SpecialEffectsController$Operation$State r13 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
            if (r12 != r13) goto L_0x04ad
            r12 = r35
            r13 = r31
            r12.remove(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r3)
            androidx.fragment.app.Fragment r15 = r13.getFragment()
            android.view.View r15 = r15.mView
            r14.remove(r15)
            androidx.fragment.app.Fragment r15 = r13.getFragment()
            android.view.View r15 = r15.mView
            r11.scheduleHideFragmentView(r9, r15, r14)
            android.view.ViewGroup r14 = r33.getContainer()
            androidx.fragment.app.DefaultSpecialEffectsController$8 r15 = new androidx.fragment.app.DefaultSpecialEffectsController$8
            r15.<init>(r3)
            androidx.core.view.OneShotPreDrawListener.add(r14, r15)
            goto L_0x04b1
        L_0x04ad:
            r12 = r35
            r13 = r31
        L_0x04b1:
            androidx.fragment.app.SpecialEffectsController$Operation$State r14 = r13.getFinalState()
            androidx.fragment.app.SpecialEffectsController$Operation$State r15 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r14 != r15) goto L_0x04c4
            r2.addAll(r3)
            if (r21 == 0) goto L_0x04c1
            r11.setEpicenter((java.lang.Object) r9, (android.graphics.Rect) r5)
        L_0x04c1:
            r3 = r26
            goto L_0x04c9
        L_0x04c4:
            r3 = r26
            r11.setEpicenter((java.lang.Object) r9, (android.view.View) r3)
        L_0x04c9:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r8.put(r13, r14)
            boolean r13 = r20.isOverlapAllowed()
            if (r13 == 0) goto L_0x04da
            r13 = 0
            java.lang.Object r7 = r11.mergeTransitionsTogether(r7, r9, r13)
            goto L_0x04df
        L_0x04da:
            r13 = 0
            java.lang.Object r1 = r11.mergeTransitionsTogether(r1, r9, r13)
        L_0x04df:
            r9 = r36
            r12 = r1
            r26 = r3
            r13 = r7
            r15 = r10
            r3 = r24
            r1 = r29
            r7 = r30
            r10 = r32
            goto L_0x03e1
        L_0x04f0:
            r24 = r3
            r30 = r7
            r32 = r10
            r1 = r12
            r7 = r13
            r10 = r15
            r23 = 1
            java.lang.Object r1 = r11.mergeTransitionsInSequence(r7, r1, r0)
            if (r1 != 0) goto L_0x0502
            return r8
        L_0x0502:
            java.util.Iterator r3 = r34.iterator()
        L_0x0506:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0584
            java.lang.Object r5 = r3.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5
            boolean r7 = r5.isVisibilityUnchanged()
            if (r7 == 0) goto L_0x0519
            goto L_0x0506
        L_0x0519:
            java.lang.Object r7 = r5.getTransition()
            androidx.fragment.app.SpecialEffectsController$Operation r9 = r5.getOperation()
            if (r0 == 0) goto L_0x0529
            if (r9 == r4) goto L_0x0527
            if (r9 != r10) goto L_0x0529
        L_0x0527:
            r12 = 1
            goto L_0x052a
        L_0x0529:
            r12 = 0
        L_0x052a:
            if (r7 != 0) goto L_0x0532
            if (r12 == 0) goto L_0x052f
            goto L_0x0532
        L_0x052f:
            r12 = r24
            goto L_0x0581
        L_0x0532:
            android.view.ViewGroup r7 = r33.getContainer()
            boolean r7 = androidx.core.view.ViewCompat.isLaidOut(r7)
            if (r7 != 0) goto L_0x056b
            boolean r7 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r22)
            if (r7 == 0) goto L_0x0565
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r12 = "SpecialEffectsController: Container "
            r7.append(r12)
            android.view.ViewGroup r12 = r33.getContainer()
            r7.append(r12)
            java.lang.String r12 = " has not been laid out. Completing operation "
            r7.append(r12)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r12 = r24
            android.util.Log.v(r12, r7)
            goto L_0x0567
        L_0x0565:
            r12 = r24
        L_0x0567:
            r5.completeSpecialEffect()
            goto L_0x0581
        L_0x056b:
            r12 = r24
            androidx.fragment.app.SpecialEffectsController$Operation r7 = r5.getOperation()
            androidx.fragment.app.Fragment r7 = r7.getFragment()
            androidx.core.os.CancellationSignal r13 = r5.getSignal()
            androidx.fragment.app.DefaultSpecialEffectsController$9 r14 = new androidx.fragment.app.DefaultSpecialEffectsController$9
            r14.<init>(r5, r9)
            r11.setListenerForTransitionEnd(r7, r1, r13, r14)
        L_0x0581:
            r24 = r12
            goto L_0x0506
        L_0x0584:
            r12 = r24
            android.view.ViewGroup r3 = r33.getContainer()
            boolean r3 = androidx.core.view.ViewCompat.isLaidOut(r3)
            if (r3 != 0) goto L_0x0591
            return r8
        L_0x0591:
            r3 = 4
            androidx.fragment.app.FragmentTransition.setViewVisibility(r2, r3)
            r3 = r32
            java.util.ArrayList r16 = r11.prepareSetNameOverridesReordered(r3)
            boolean r4 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r22)
            if (r4 == 0) goto L_0x060e
            java.lang.String r4 = ">>>>> Beginning transition <<<<<"
            android.util.Log.v(r12, r4)
            java.lang.String r4 = ">>>>> SharedElementFirstOutViews <<<<<"
            android.util.Log.v(r12, r4)
            java.util.Iterator r4 = r30.iterator()
        L_0x05af:
            boolean r5 = r4.hasNext()
            java.lang.String r7 = " Name: "
            java.lang.String r9 = "View: "
            if (r5 == 0) goto L_0x05dc
            java.lang.Object r5 = r4.next()
            android.view.View r5 = (android.view.View) r5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r5)
            r10.append(r7)
            java.lang.String r5 = androidx.core.view.ViewCompat.getTransitionName(r5)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            android.util.Log.v(r12, r5)
            goto L_0x05af
        L_0x05dc:
            java.lang.String r4 = ">>>>> SharedElementLastInViews <<<<<"
            android.util.Log.v(r12, r4)
            java.util.Iterator r4 = r3.iterator()
        L_0x05e5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x060e
            java.lang.Object r5 = r4.next()
            android.view.View r5 = (android.view.View) r5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r5)
            r10.append(r7)
            java.lang.String r5 = androidx.core.view.ViewCompat.getTransitionName(r5)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            android.util.Log.v(r12, r5)
            goto L_0x05e5
        L_0x060e:
            android.view.ViewGroup r4 = r33.getContainer()
            r11.beginDelayedTransition(r4, r1)
            android.view.ViewGroup r13 = r33.getContainer()
            r12 = r11
            r14 = r30
            r15 = r3
            r17 = r28
            r12.setNameOverridesReordered(r13, r14, r15, r16, r17)
            r1 = 0
            androidx.fragment.app.FragmentTransition.setViewVisibility(r2, r1)
            r1 = r30
            r11.swapSharedElementTargets(r0, r1, r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.startTransitions(java.util.List, java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    private void syncAnimations(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation next : list) {
            next.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            next.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            next.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            next.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        captureTransitioningViews(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation next : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(next.getFragment().mView);
            int i = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[next.getFinalState().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = next;
                }
            } else if (i == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = next;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList<>(list);
        syncAnimations(list);
        for (final SpecialEffectsController.Operation next2 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            next2.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(next2, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next2.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (next2 != operation) {
                    arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                    next2.addCompletionListener(new Runnable() {
                        public void run() {
                            if (arrayList3.contains(next2)) {
                                arrayList3.remove(next2);
                                DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                            }
                        }
                    });
                }
            } else if (next2 != operation2) {
                arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                next2.addCompletionListener(new Runnable() {
                    public void run() {
                        if (arrayList3.contains(next2)) {
                            arrayList3.remove(next2);
                            DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                        }
                    }
                });
            }
            z2 = true;
            arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
            next2.addCompletionListener(new Runnable() {
                public void run() {
                    if (arrayList3.contains(next2)) {
                        arrayList3.remove(next2);
                        DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        for (SpecialEffectsController.Operation applyContainerChanges : arrayList3) {
            applyContainerChanges(applyContainerChanges);
        }
        arrayList3.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        @Nullable
        private final Object mSharedElementTransition;
        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object obj;
            Object obj2;
            boolean z3;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    obj2 = operation.getFragment().getReenterTransition();
                } else {
                    obj2 = operation.getFragment().getEnterTransition();
                }
                this.mTransition = obj2;
                if (z) {
                    z3 = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    z3 = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = z3;
            } else {
                if (z) {
                    obj = operation.getFragment().getReturnTransition();
                } else {
                    obj = operation.getFragment().getExitTransition();
                }
                this.mTransition = obj;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            if (this.mSharedElementTransition != null) {
                return true;
            }
            return false;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
