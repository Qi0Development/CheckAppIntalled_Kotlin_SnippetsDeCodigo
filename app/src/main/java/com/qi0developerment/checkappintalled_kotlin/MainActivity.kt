package com.qi0developerment.checkappintalled_kotlin

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCheck.setOnClickListener {
            if (isPackageAvalile("com.google.android.apps.maps")){
                Toast.makeText(this@MainActivity, "App Instaled", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "App Missing", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun isPackageAvalile(packageName: String): Boolean {
        var avaliable = true

        try {
            packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException){
            avaliable = false
        }
        return avaliable
    }
}
