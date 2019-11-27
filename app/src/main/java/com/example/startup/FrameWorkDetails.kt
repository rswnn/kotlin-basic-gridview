package com.example.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_frame_work_details.*
import kotlinx.android.synthetic.main.activity_frame_work_details.ivFrameworkImage
import kotlinx.android.synthetic.main.activity_frame_work_details.tvName
import kotlinx.android.synthetic.main.framework_ticket.*

class FrameWorkDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_work_details)

        val bundle = intent.extras

        ivFrameworkImage.setImageResource(bundle!!.getInt("image"))
        tvName.text = bundle!!.getString("name")
        tvDesc.text = bundle!!.getString("desc")

    }
}
