package ko2ic.sample.ui.fragments


import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ko2ic.sample.R
import ko2ic.sample.ui.viewmodels.MainViewModel
import javax.inject.Inject


class MainFragment @Inject constructor() : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel.start("fragment")
    }
}
