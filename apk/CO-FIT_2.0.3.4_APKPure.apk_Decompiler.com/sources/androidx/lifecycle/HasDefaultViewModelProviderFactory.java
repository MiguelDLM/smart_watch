package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

public interface HasDefaultViewModelProviderFactory {
    @OOXIXo
    CreationExtras getDefaultViewModelCreationExtras();

    @OOXIXo
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
