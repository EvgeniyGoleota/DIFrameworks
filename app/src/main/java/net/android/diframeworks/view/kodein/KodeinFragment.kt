package net.android.diframeworks.view.kodein

import android.os.Bundle
import android.view.View
import net.android.diframeworks.R
import net.android.diframeworks.databinding.FragmentKodeinBinding
import net.android.diframeworks.util.kodeinViewModel
import net.android.diframeworks.view.BaseFragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class KodeinFragment : BaseFragment<KodeinVM, FragmentKodeinBinding>(), KodeinAware {

    override val kodein: Kodein by kodein()

    override val vm: KodeinVM by kodeinViewModel()

    override fun getLayout(): Int = R.layout.fragment_kodein

    override fun afterCreateView(view: View, savedInstanceState: Bundle?) {
        vb = FragmentKodeinBinding.bind(view)
        vm
    }
}