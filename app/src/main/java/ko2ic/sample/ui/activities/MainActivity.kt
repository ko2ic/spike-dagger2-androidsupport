package ko2ic.sample.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import ko2ic.sample.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.second).setOnClickListener { _ ->
            startActivity(SecondActivity.intentClearTop(this, "message"))
        }
    }
}
