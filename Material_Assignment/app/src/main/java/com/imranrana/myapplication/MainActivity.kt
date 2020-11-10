package com.imranrana.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.imranrana.myapplication.R.array.countries
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(Utils.imageUrl).placeholder(R.drawable.welcome).into(imgView)
        setAdapter()
    }


    private fun setAdapter(){
//        val list = resources.getStringArray(countries)
        val list = countryList()
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            list
        )
        listView_countries.adapter = arrayAdapter
    }

    private fun countryList(): Array<String>{
        return arrayOf(
            "Baden",
            "Bahamas",
            "The Bahrain",
            "Bangladesh",
            "Barbados",
            "Bavaria",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin (Dahomey)",
            "Madagascar",
                    "Malawi",
                    "Malaysia",
                    "Maldives",
                    "Mali",
                    "Malta",
                    "Marshall Islands",
                    "Mauritania",
                    "Mauritius",
                    "Mecklenburg-Schwerin",
                    "Mecklenburg-Strelitz"
        )
    }
}