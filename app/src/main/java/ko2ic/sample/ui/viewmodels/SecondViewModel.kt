package ko2ic.sample.ui.viewmodels

import android.util.Log
import ko2ic.sample.di.ActivityScope
import ko2ic.sample.domains.MainDomain
import javax.inject.Inject

@ActivityScope
class SecondViewModel @Inject constructor() {

    @Inject
    lateinit var domain: MainDomain

    fun start(value: String) {
        Log.d(SecondViewModel::class.java.simpleName, "${this}:${value}")
        domain.call()
    }
}