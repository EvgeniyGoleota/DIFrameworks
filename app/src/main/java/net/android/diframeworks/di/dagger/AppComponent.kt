package net.android.diframeworks.di.dagger

import dagger.Component
import dagger.android.AndroidInjectionModule
import net.android.diframeworks.App
import javax.inject.Singleton
import net.android.diframeworks.di.dagger.modules.ActivityBuilder
import net.android.diframeworks.di.dagger.modules.DaggerVMBinder


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DaggerVMBinder::class,
        ActivityBuilder::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
}