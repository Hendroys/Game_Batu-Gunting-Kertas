package com.programmer.gamebatuguntingkertas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var input: ImageView? = null
    var output: ImageView? = null
    var batu: Button? = null
    var kertas: Button? = null
    var gunting: Button? = null
    var images = intArrayOf(
        R.mipmap.batu
        R.mipmap.kertas
        R.mipmap.gunting
    )

    var userinput = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById<View>(R.id.iv_input) as ImageView
        output = findViewById<View>(R.id.iv_output) as ImageView
        batu = findViewById<View>(R.id.btn_batu) as Button
        kertas = findViewById<View>(R.id.btn_kertas) as Button
        gunting = findViewById<View>(R.id.btn_gunting) as Button
        batu!!.setOnClickListener(this)
        kertas!!.setOnClickListener(this)
        gunting!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.btn_batu -> {
                userinput = 1
                input!!.setBackgroundResource(R.mipmap.batu)
                setOutput()
            }
            R.id.btn_kertas -> {
                userinput = 2
                input!!.setBackgroundResource(R.mipmap.kertas)
                setOutput()
            }
            R.id.btn_gunting -> {
                userinput = 3
                input!!.setBackgroundResource(R.mipmap.gunting)
                setOutput()
            }
        }
    }

    private fun setOutput() {
        val imageId = (Math.random() * images.size).toInt()
        output!!.setBackgroundResource(images[imageId])
        checkresult(imageId)
    }

    private fun checkresult(imageId: Int) {
        if (userinput == 1 && imageId == 0) {     //User choose Batu,Computer choose Batu
            showresult(2)
        } else if (userinput == 1 && imageId == 1) { //User choose Batu,Computer choose Kertas
            showresult(0)
        } else if (userinput == 1 && imageId == 2) { //User choose Batu,Computer choose Gunting
            showresult(1)
        } else if (userinput == 2 && imageId == 0) { //User choose Kertas,Computer choose Batu
            showresult(1)
        } else if (userinput == 2 && imageId == 1) { //User choose Kertas,Computer choose Kertas
            showresult(2)
        } else if (userinput == 2 && imageId == 2) { //User choose Kertas,Computer choose Gunting
            showresult(0)
        } else if (userinput == 3 && imageId == 0) { //User choose Gunting,Computer choose Batu
            showresult(0)
        } else if (userinput == 3 && imageId == 1) { //User choose Gunting,Computer choose Kertas
            showresult(1)
        } else if (userinput == 3 && imageId == 2) { //User choose Gunting,Computer choose Gunting
            showresult(2)
        }
    }

    private fun showresult(result: Int) {
        if (result == 0) {
            Toast.makeText(applicationContext, "Yah! Anda Kalah :(", Toast.LENGTH_SHORT).show()
        } else if (result == 1) Toast.makeText(
            applicationContext,
            "Anda Menang! Hore! :)",
            Toast.LENGTH_SHORT
        ).show() else Toast.makeText(
            applicationContext, "UPS! Ini Seri! :P", Toast.LENGTH_SHORT
        ).show()
    }
}