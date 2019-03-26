package net.android.diframeworks.di.dagger.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class StringProviderModule {

    @Named("MainActivity")
    @Provides
    fun provideHelloMessage(): String = "Hey! I am injected with the help of factory!"
}