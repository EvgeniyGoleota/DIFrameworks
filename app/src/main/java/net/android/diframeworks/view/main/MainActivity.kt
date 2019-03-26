package net.android.diframeworks.view.main

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import net.android.diframeworks.R
import net.android.diframeworks.view.BaseActivity
import javax.inject.Inject

class MainActivity constructor(
    private val message: String
) : BaseActivity<Nothing>(), HasFragmentInjector, HasSupportFragmentInjector {

    init {
        Log.i("MainActivity", message)
    }

    @Inject
    protected lateinit var supportFragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>
    @Inject
    protected lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<Fragment>

    override val vm: Nothing
        get() = TODO("not implemented")

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun afterCreate() {
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return frameworkFragmentInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment> {
        return supportFragmentInjector
    }
}
