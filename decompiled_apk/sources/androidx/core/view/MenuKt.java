package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

@kotlin.jvm.internal.XX({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(@OXOo.OOXIXo Menu menu, @OXOo.OOXIXo MenuItem menuItem) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@OXOo.OOXIXo Menu menu, @OXOo.OOXIXo Oox.oOoXoXO<? super MenuItem, kotlin.oXIO0o0XI> oooxoxo) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            oooxoxo.invoke(menu.getItem(i));
        }
    }

    public static final void forEachIndexed(@OXOo.OOXIXo Menu menu, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super MenuItem, kotlin.oXIO0o0XI> x0xo0oo) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(i), menu.getItem(i));
        }
    }

    @OXOo.OOXIXo
    public static final MenuItem get(@OXOo.OOXIXo Menu menu, int i) {
        return menu.getItem(i);
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<MenuItem> getChildren(@OXOo.OOXIXo final Menu menu) {
        return new kotlin.sequences.ooOOo0oXI<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@OXOo.OOXIXo Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(@OXOo.OOXIXo Menu menu) {
        if (menu.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OXOo.OOXIXo Menu menu) {
        if (menu.size() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final Iterator<MenuItem> iterator(@OXOo.OOXIXo Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@OXOo.OOXIXo Menu menu, @OXOo.OOXIXo MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(@OXOo.OOXIXo Menu menu, int i) {
        kotlin.oXIO0o0XI oxio0o0xi;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            menu.removeItem(item.getItemId());
            oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        if (oxio0o0xi != null) {
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
