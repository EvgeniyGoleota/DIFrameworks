package net.android.diframeworks.di.dagger.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.android.diframeworks.di.dagger.ViewModelFactory
import net.android.diframeworks.di.dagger.keys.ViewModelKey
import net.android.diframeworks.view.dagger.DaggerVM
import net.android.diframeworks.view.main.MainVM

@Module
abstract class DaggerVMBinder {

    @Binds
    @IntoMap
    @ViewModelKey(MainVM::class)
    abstract fun bindMainVM(vm: MainVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DaggerVM::class)
    abstract fun bindDaggerVM(vm: DaggerVM): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}