package cubex.mahesh.tel_con_mar9am19

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tManager = getSystemService(Context.
            TELEPHONY_SERVICE) as TelephonyManager
        var cManager = getSystemService(Context.
                CONNECTIVITY_SERVICE) as ConnectivityManager

        var tempList = mutableListOf<String>()
        tempList.add("IMEI : "+tManager.imei)
        tempList.add("Sim Sno : "+tManager.simSerialNumber)
        tempList.add("Sim Operator : "+tManager.simOperatorName)
        tempList.add("Sim Country : "+tManager.simCountryIso)
        tempList.add("Phony Type : "+tManager.phoneType)
        if(cManager.activeNetwork != null)
            tempList.add("Mobile Data Enabled ")
        else
            tempList.add("Mobile Data Disabled ")

        var adapter = ArrayAdapter<String>(
            this@MainActivity,
            android.R.layout.simple_list_item_single_choice,
            tempList)
        lview.adapter = adapter
    }
}
