package net.android.diframeworks

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import net.android.diframeworks.di.dagger.AppComponent
import net.android.diframeworks.di.dagger.DaggerAppComponent
import net.android.diframeworks.di.kodein.kodeinModule
import net.android.diframeworks.di.koin.koinModules
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.koin.android.ext.android.startKoin
import javax.inject.Inject


class App : Application(), KodeinAware, HasActivityInjector {

    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    @Inject
    lateinit var mAppcomponent: AppComponent

    override val kodein: Kodein by Kodein.lazy {
        import(kodeinModule)
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .build()
            .inject(this)

        // Koin init
        startKoin(this, koinModules)
    }
}