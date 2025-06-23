package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.ooOOo0oXI;

@XX({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class MenuKt {
    public static final boolean contains(@OOXIXo Menu menu, @OOXIXo MenuItem menuItem) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (IIX0o.Oxx0IOOO(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@OOXIXo Menu menu, @OOXIXo oOoXoXO<? super MenuItem, oXIO0o0XI> oooxoxo) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            oooxoxo.invoke(menu.getItem(i));
        }
    }

    public static final void forEachIndexed(@OOXIXo Menu menu, @OOXIXo x0xO0oo<? super Integer, ? super MenuItem, oXIO0o0XI> x0xo0oo) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(i), menu.getItem(i));
        }
    }

    @OOXIXo
    public static final MenuItem get(@OOXIXo Menu menu, int i) {
        return menu.getItem(i);
    }

    @OOXIXo
    public static final ooOOo0oXI<MenuItem> getChildren(@OOXIXo Menu menu) {
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(@OOXIXo Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(@OOXIXo Menu menu) {
        if (menu.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OOXIXo Menu menu) {
        if (menu.size() != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final Iterator<MenuItem> iterator(@OOXIXo Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@OOXIXo Menu menu, @OOXIXo MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(@OOXIXo Menu menu, int i) {
        oXIO0o0XI oxio0o0xi;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            menu.removeItem(item.getItemId());
            oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        if (oxio0o0xi == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
