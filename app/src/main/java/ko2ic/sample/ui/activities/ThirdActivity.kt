package ko2ic.sample.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import ko2ic.sample.R

class ThirdActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context) = Intent(context, ThirdActivity::class.java).apply {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        findViewById<Button>(R.id.clear_top).setOnClickListener {
            // case kill activity, onCreate [savedInstanceState != null , Previous message] -> onStart [Previous message] -> onNewIntent [clearTop]
            // case keep activity, onNewIntent [clearTop] -> onReStart [Previous message] -> onStart [Previous message]
            startActivity(SecondActivity.intentClearTop(this, "clearTop"))
            finish()
        }

        findViewById<Button>(R.id.clear_task).setOnClickListener {
            // case kill activity, onCreate [savedInstanceState == null , clearTask] -> onStart [clearTask]
            // case keep activity, onCreate [savedInstanceState == null , clearTask] -> onStart [clearTask]
            startActivity(SecondActivity.intentClearTask(this, "clearTask"))
            finish()
        }

    }
}
