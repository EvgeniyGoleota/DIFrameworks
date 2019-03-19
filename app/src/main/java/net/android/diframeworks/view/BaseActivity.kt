package net.android.diframeworks.view

import android.os.Bundle
import androidx.lifecycle.ViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<VM : ViewModel> : DaggerAppCompatActivity() {

    protected abstract val vm: VM

    protected open fun afterCreate() {}
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        afterCreate()
    }
}