package ko2ic.sample.ui.activities

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import ko2ic.sample.R
import ko2ic.sample.di.ActivityScope
import ko2ic.sample.ui.fragments.SecondFragment
import ko2ic.sample.ui.fragments.SecondFragment.Companion.KEY_MESSAGE
import ko2ic.sample.ui.viewmodels.SecondViewModel
import javax.inject.Inject

@ActivityScope
class SecondActivity : AppCompatActivity(), HasFragmentInjector {

    companion object {
        fun intentClearTop(context: Context, message: String) = Intent(context, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            putExtras(Bundle().apply {
                putString(KEY_MESSAGE, message)
            })
        }

        fun intentClearTask(context: Context, message: String) = Intent(context, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            putExtras(Bundle().apply {
                putString(KEY_MESSAGE, message)
            })
        }

    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector() = androidInjector

    @Inject
    lateinit var fragment: SecondFragment

    @Inject
    lateinit var viewModel: SecondViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        if (savedInstanceState == null) {
            fragment.arguments = intent.extras
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()

        }
        super.onCreate(savedInstanceState)

        // Using viewModel from here because of kill activity.
        viewModel.start("from activity")
        setContentView(R.layout.activity_second)
    }

    override fun onStart() {
        super.onStart()
        val message = intent.getStringExtra(KEY_MESSAGE)
        print(message)
    }

    override fun onRestart() {
        super.onRestart()
        val message = intent.getStringExtra(KEY_MESSAGE)
        print(message)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val message = intent.getStringExtra(KEY_MESSAGE)
        print(message)
    }
}
