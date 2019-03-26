package net.android.diframeworks.di.dagger

import dagger.Component
import dagger.android.AndroidInjectionModule
import net.android.diframeworks.App
import net.android.diframeworks.di.appfactory.CustomComponentFactory
import net.android.diframeworks.di.dagger.modules.ActivityBuilder
import net.android.diframeworks.di.dagger.modules.DaggerVMBinder
import net.android.diframeworks.di.dagger.modules.StringProviderModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
//            ComponentFactoryModule::class,
        DaggerVMBinder::class,
        ActivityBuilder::class,
        StringProviderModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
    fun inject(app: CustomComponentFactory)
}