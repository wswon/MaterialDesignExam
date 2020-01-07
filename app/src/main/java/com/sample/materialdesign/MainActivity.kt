package com.sample.materialdesign

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val collapsingToolbarBtn = Button(this)
        collapsingToolbarBtn.text = "CollapsingToolbar"
        collapsingToolbarBtn.setOnClickListener {
            startActivity(Intent(this, CollapsingToolbarActivity::class.java))
        }
        ll_btn_list.addView(collapsingToolbarBtn)
    }
}
