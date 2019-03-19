package net.android.diframeworks.view.dagger

import androidx.lifecycle.ViewModel
import net.android.diframeworks.util.logInfo
import javax.inject.Inject

class DaggerVM @Inject constructor() : ViewModel() {
    init {
        logInfo("I am $this")
    }
}