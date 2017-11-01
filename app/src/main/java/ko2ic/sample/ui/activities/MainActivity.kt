package ko2ic.sample.ui.activities

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import ko2ic.sample.R
import ko2ic.sample.ui.fragments.MainFragment
import ko2ic.sample.ui.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasFragmentInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector() = androidInjector

    @Inject
    lateinit var fragment: MainFragment

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitAllowingStateLoss()

        viewModel.start("activity")
    }
}
