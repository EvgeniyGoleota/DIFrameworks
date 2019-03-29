package net.android.diframeworks.view.koin

import android.os.Bundle
import android.view.View
import net.android.diframeworks.R
import net.android.diframeworks.databinding.FragmentKoinBinding
import net.android.diframeworks.di.koin.KoinScopedObject
import net.android.diframeworks.util.logInfo
import net.android.diframeworks.view.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.ext.android.bindScope
import org.koin.androidx.scope.ext.android.getOrCreateScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class KoinFragment : BaseFragment<KoinVM, FragmentKoinBinding>() {
    override val vm: KoinVM by viewModel()

    private val koinScopedObject1: KoinScopedObject by inject()
    private val koinScopedObject2: KoinScopedObject by inject()

    override fun getLayout(): Int = R.layout.fragment_koin

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        bindScope(getOrCreateScope("koinScopedObject"))
        vb = FragmentKoinBinding.bind(view)
        vm
        logInfo("koinScopedObject1: $koinScopedObject1")
        logInfo("koinScopedObject2: $koinScopedObject2")
    }
}