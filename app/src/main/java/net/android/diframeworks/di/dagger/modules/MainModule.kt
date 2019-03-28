package net.android.diframeworks.di.dagger.modules

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import net.android.diframeworks.di.dagger.keys.FragmentScope
import net.android.diframeworks.view.dagger.DaggerFragment
import net.android.diframeworks.view.main.MainFragment

@Module
abstract class MainModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragmentInjector(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DaggerFragmentModule::class])
    abstract fun contributeDaggerFragmentInjector(): DaggerFragment
}

@Module
class MainFragmentModule {

    @FragmentScope
    @Provides
    fun provideMainFragmentString() = MainFragmentObject("Hey there! I'm scoped by main fragment")
}

@Module
class DaggerFragmentModule {

    @FragmentScope
    @Provides
    fun provideDaggerFragmentString() = DaggerFragmentObject("Hey there! I'm scoped by dagger fragment")
}

class MainFragmentObject(val value: String)
class DaggerFragmentObject(val value: String)