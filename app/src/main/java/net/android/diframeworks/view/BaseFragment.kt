package net.android.diframeworks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM : ViewModel, VB : ViewDataBinding> : Fragment() {

    protected lateinit var vb: VB
    protected abstract val vm: VM

    @LayoutRes
    protected abstract fun getLayout(): Int

    protected abstract fun afterCreateView(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)
        afterCreateView(view, savedInstanceState)
        return view
    }
}