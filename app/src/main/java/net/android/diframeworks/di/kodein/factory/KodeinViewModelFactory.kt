package net.android.diframeworks.di.kodein.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DKodein
import org.kodein.di.Kodein
import org.kodein.di.TT
import org.kodein.di.direct
import org.kodein.di.generic.instanceOrNull

class KodeinViewModelFactory(private val injector: DKodein) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return injector.instanceOrNull<ViewModel>(tag = modelClass.simpleName) as T?
                ?: modelClass.newInstance()
    }
}