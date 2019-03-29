package net.android.diframeworks.di.koin

import net.android.diframeworks.view.koin.KoinVM
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val koinAppModule = module {
    viewModel { KoinVM() }
//    viewModel { MainVM() }
    scope("koinScopedObject") { KoinScopedObject() }
}

val koinModules = listOf(koinAppModule)

class KoinScopedObject