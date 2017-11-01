package ko2ic.sample.domains

import android.util.Log
import javax.inject.Inject


class MainDomain @Inject constructor() {

    fun call() {
        Log.d(this::class.java.simpleName, "called domain ")
    }
}