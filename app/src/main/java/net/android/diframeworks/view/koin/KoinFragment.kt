package net.android.diframeworks.view.koin

import android.os.Bundle
import android.view.View
import net.android.diframeworks.R
import net.android.diframeworks.databinding.FragmentKoinBinding
import net.android.diframeworks.view.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class KoinFragment : BaseFragment<KoinVM, FragmentKoinBinding>() {
    override val vm: KoinVM by viewModel()

    override fun getLayout(): Int = R.layout.fragment_koin

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        vb = FragmentKoinBinding.bind(view)
        vm
    }
}