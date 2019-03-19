package net.android.diframeworks.view.kodein

import androidx.lifecycle.ViewModel
import net.android.diframeworks.util.logInfo

class KodeinVM : ViewModel() {
    init {
        logInfo("I am $this")
    }
}