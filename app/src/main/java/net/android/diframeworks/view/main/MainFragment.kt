package net.android.diframeworks.view.main

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import net.android.diframeworks.R
import net.android.diframeworks.databinding.FragmentMainBinding
import net.android.diframeworks.di.dagger.modules.MainFragmentObject
import net.android.diframeworks.util.logInfo
import net.android.diframeworks.view.dagger.AbstractDaggerFragment
import javax.inject.Inject

class MainFragment : AbstractDaggerFragment<MainVM, FragmentMainBinding>() {

    @Inject
    lateinit var scopedObjToBeInjected1: MainFragmentObject
    @Inject
    lateinit var scopedObjToBeInjected2: MainFragmentObject

    override fun getLayout(): Int = R.layout.fragment_main

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        super.afterCreateView(view, savedInstanceState)
        vb = FragmentMainBinding.bind(view)
        logInfo("Injected: $scopedObjToBeInjected1")
        logInfo("Injected: $scopedObjToBeInjected2")

        vb.bKoin.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_koinFragment)
        }
        vb.bKodein.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_kodeinFragment)
        }
        vb.bDagger.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_daggerFragment)
        }
    }
}