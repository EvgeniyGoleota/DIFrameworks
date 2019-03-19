package net.android.diframeworks.view.koin

import androidx.lifecycle.ViewModel
import net.android.diframeworks.util.logInfo

class KoinVM : ViewModel() {
    init {
        logInfo("I am $this")
    }
}