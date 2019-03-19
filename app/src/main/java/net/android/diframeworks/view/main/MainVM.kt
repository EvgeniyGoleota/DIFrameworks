package net.android.diframeworks.view.main

import androidx.lifecycle.ViewModel
import net.android.diframeworks.util.logInfo
import javax.inject.Inject

class MainVM @Inject constructor(): ViewModel() {
    init {
        logInfo("I am $this")
    }
}