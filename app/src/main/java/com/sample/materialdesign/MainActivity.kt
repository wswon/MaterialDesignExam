package com.sample.materialdesign

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sample.materialdesign.collapsing_toolbar.CollapsingToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ll_btn_list.addBtn<CollapsingToolbarActivity>("Collapsing Toolbar")
    }

    private inline fun <reified T> ViewGroup.addBtn(btnName: String) {
        val button = Button(context).apply {
            text = btnName
            setOnClickListener {
                startActivity(Intent(this@MainActivity, T::class.java))
            }
        }
        addView(button)
    }

}
