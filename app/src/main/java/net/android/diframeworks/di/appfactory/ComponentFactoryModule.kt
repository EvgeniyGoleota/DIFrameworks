package net.android.diframeworks.di.appfactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.android.diframeworks.view.main.MainActivity


@Module
abstract class ComponentFactoryModule {

    @Binds
    @IntoMap
    @ComponentKey(MainActivity::class)
    abstract fun bindMainActivity(activity: MainActivity): Any

    @Binds
    abstract fun bindActivityComponentHelper(helper: ComponentHelper): InstanceComponentHelper
}