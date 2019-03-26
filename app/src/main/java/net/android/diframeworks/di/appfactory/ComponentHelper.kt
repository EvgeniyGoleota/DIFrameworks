package net.android.diframeworks.di.appfactory

import javax.inject.Inject
import javax.inject.Provider

class ComponentHelper @Inject constructor(
    private val creators: Map<Class<out Any>, @JvmSuppressWildcards Provider<Any>>
) : InstanceComponentHelper {

    @Suppress("UNCHECKED_CAST")
    override fun <T> resolve(className: String): T? =
        creators
            .filter { it.key.name == className }
            .values
            .firstOrNull()
            ?.get() as? T
}

interface InstanceComponentHelper {
    fun <T> resolve(className: String): T?
}