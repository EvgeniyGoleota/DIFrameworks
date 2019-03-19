package net.android.diframeworks.di.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.android.diframeworks.view.dagger.DaggerFragment
import net.android.diframeworks.view.main.MainFragment

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragmentInjector(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeDaggerFragmentInjector(): DaggerFragment
}