package net.android.diframeworks.di.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.android.diframeworks.view.main.MainActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainInjector(): MainActivity
}