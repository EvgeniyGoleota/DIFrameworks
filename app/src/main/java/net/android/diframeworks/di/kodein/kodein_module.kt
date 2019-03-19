package net.android.diframeworks.di.kodein

import androidx.lifecycle.ViewModelProvider
import net.android.diframeworks.di.kodein.factory.KodeinViewModelFactory
import net.android.diframeworks.util.bindViewModel
import net.android.diframeworks.view.kodein.KodeinVM
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val kodeinModule = Kodein.Module("ViewModel") {
    bind<ViewModelProvider.Factory>() with singleton {
        KodeinViewModelFactory(dkodein)
    }

    bindViewModel<KodeinVM>() with provider {
        KodeinVM()
    }
}