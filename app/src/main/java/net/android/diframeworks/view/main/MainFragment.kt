package net.android.diframeworks.view.main

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import net.android.diframeworks.R
import net.android.diframeworks.databinding.FragmentMainBinding
import net.android.diframeworks.view.dagger.AbstractDaggerFragment

class MainFragment : AbstractDaggerFragment<MainVM, FragmentMainBinding>() {

    override fun getLayout(): Int = R.layout.fragment_main

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        super.afterCreateView(view, savedInstanceState)
        vb = FragmentMainBinding.bind(view)
        vm

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