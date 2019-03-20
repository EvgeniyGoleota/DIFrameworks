package net.android.diframeworks.view.dagger

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import net.android.diframeworks.R
import net.android.diframeworks.databinding.FragmentDaggerBinding
import net.android.diframeworks.view.BaseFragment
import java.lang.reflect.ParameterizedType
import javax.inject.Inject


class DaggerFragment : AbstractDaggerFragment<DaggerVM, FragmentDaggerBinding>() {

    override fun getLayout(): Int = R.layout.fragment_dagger

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        super.afterCreateView(view, savedInstanceState)
        vb = FragmentDaggerBinding.bind(view)
        vm
    }
}

abstract class AbstractDaggerFragment<VM : ViewModel, VB : ViewDataBinding> : BaseFragment<VM, VB>(),
    HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override lateinit var vm: VM

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @CallSuper
    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        vm = ViewModelProviders.of(this, viewModelFactory).get(getVMTypeClass())
    }

    @Suppress("UNCHECKED_CAST")
    private fun getVMTypeClass(): Class<VM> {
        try {
            val className = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0].toString()
            val clazz = Class.forName(className.replace("class ", ""))
            return clazz as Class<VM>
        } catch (e: Exception) {
            throw IllegalStateException(e.message)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }
}