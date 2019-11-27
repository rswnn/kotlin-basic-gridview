package com.example.startup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_frame_work_details.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.framework_ticket.view.*
import kotlinx.android.synthetic.main.framework_ticket.view.ivFrameworkImage
import kotlinx.android.synthetic.main.framework_ticket.view.tvName

class MainActivity : AppCompatActivity() {
    var adapter: FrameWorkAdapter?=null
    val listOfFrameworks = ArrayList<Framework>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfFrameworks.add(Framework("Flutter", "hybrid App", R.mipmap.flutter))
        listOfFrameworks.add(Framework("React Native", "hybrid App", R.mipmap.react))
        listOfFrameworks.add(Framework("Angular", "web framework", R.mipmap.angular))
        listOfFrameworks.add(Framework("vue", "web framework", R.mipmap.vue))
        listOfFrameworks.add(Framework("Kotlin", "Native App", R.mipmap.kotlin))
        listOfFrameworks.add(Framework("Swift", "Native App", R.mipmap.swift))
        adapter = FrameWorkAdapter(this,listOfFrameworks)
        gvGridLIst.adapter = adapter
    }


    class FrameWorkAdapter: BaseAdapter {
        var listOfFramework = ArrayList<Framework>()
        var context:Context ?= null

        constructor(context: Context, listOfFrameWork: ArrayList<Framework>):super() {
            this.context = context
            this.listOfFramework = listOfFrameWork
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val framework = listOfFramework[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var frameworkView = inflator.inflate(R.layout.framework_ticket, null)
            frameworkView.ivFrameworkImage.setImageResource(framework.image!!)
            frameworkView.tvName.text = framework.name!!

            frameworkView.setOnClickListener {
                val intent = Intent(context, FrameWorkDetails::class.java)
                intent.putExtra("name", framework.name!!)
                intent.putExtra("desc", framework.desc!!)
                intent.putExtra("image", framework.image!!)
                context!!.startActivity(intent)
            }
//            frameworkView.tvDesc.text = framework.desc!!
            return frameworkView
        }

        override fun getItem(position: Int): Any {
            return listOfFramework[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFramework.size
        }

    }
}
