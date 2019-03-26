package net.android.diframeworks.di.appfactory

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.AppComponentFactory
import net.android.diframeworks.App
import net.android.diframeworks.view.main.MainActivity
import javax.inject.Inject
import javax.inject.Named


@RequiresApi(Build.VERSION_CODES.P)
class CustomComponentFactory : AppComponentFactory() {

    @field:[Inject Named("MainActivity")]
    lateinit var mainActivityHelloMessage: String

    /*

    @field:[Inject]
    lateinit var injectHelper: InstanceComponentHelper

    */

    init {
        App.appComponentInstance.inject(this)
    }

    override fun instantiateActivityCompat(cl: ClassLoader, className: String, intent: Intent?): Activity {
        return when (className) {
            MainActivity::class.java.name -> MainActivity(mainActivityHelloMessage)
            else -> super.instantiateActivityCompat(cl, className, intent)
        }

        /*

        return injectHelper
            .resolve<Activity>(className)
            ?.apply { setIntent(intent) }
            ?: super.instantiateActivityCompat(cl, className, intent)

        */
    }

    override fun instantiateApplicationCompat(cl: ClassLoader, className: String): Application {
        return super.instantiateApplicationCompat(cl, className)
    }

    override fun instantiateProviderCompat(cl: ClassLoader, className: String): ContentProvider {
        return super.instantiateProviderCompat(cl, className)
    }

    override fun instantiateReceiverCompat(cl: ClassLoader, className: String, intent: Intent?): BroadcastReceiver {
        return super.instantiateReceiverCompat(cl, className, intent)
    }

    override fun instantiateServiceCompat(cl: ClassLoader, className: String, intent: Intent?): Service {
        return super.instantiateServiceCompat(cl, className, intent)
    }
}