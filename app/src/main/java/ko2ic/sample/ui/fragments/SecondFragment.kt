package ko2ic.sample.ui.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dagger.android.AndroidInjection
import ko2ic.sample.R
import ko2ic.sample.di.ActivityScope
import ko2ic.sample.ui.activities.SecondActivity
import ko2ic.sample.ui.activities.ThirdActivity
import ko2ic.sample.ui.viewmodels.SecondViewModel
import javax.inject.Inject

@ActivityScope
class SecondFragment @Inject constructor() : Fragment() {

    companion object {
        const val KEY_MESSAGE = "message"
    }

    @Inject
    lateinit var viewModel: SecondViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            AndroidInjection.inject(this)
            val activity = this.activity
            if (activity is SecondActivity) {
                activity.fragment = this
                activity.viewModel = this.viewModel
            }
        }
        val message = arguments?.getString(KEY_MESSAGE)
        viewModel.start("from fragment:message=${message}")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_second, container, false)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(ThirdActivity.intent(activity))
        }

        return view
    }
}
