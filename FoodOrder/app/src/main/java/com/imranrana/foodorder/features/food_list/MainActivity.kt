package com.imranrana.foodorder.features.food_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.imranrana.foodorder.R
import com.imranrana.foodorder.core.BaseActivity
import com.imranrana.foodorder.core.ItemClickListener
import com.imranrana.foodorder.model.Food
import com.imranrana.foodorder.model.FoodModelImpl
import com.imranrana.foodorder.model.FoodResponseCallBack
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    lateinit var foodModelImpl: FoodModelImpl
    override fun setLayoutId(): Int = R.layout.activity_main
    override val isHomeUpButtonEnable: Boolean get() = false
    override fun setToolbar(): Toolbar {
        toolbar.title = "Foods "
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        foodModelImpl = FoodModelImpl()

        foodModelImpl.getFoodList(object : FoodResponseCallBack{
            override fun success(list: MutableList<Food>) {
                progressBar.visibility = View.GONE
                showList(list)
            }

            override fun error(throwable: Throwable) {
                progressBar.visibility = View.GONE
            }
        })
    }

    fun showList(list: MutableList<Food>){
        val adapter = FoodAdapter(list, object : ItemClickListener {
            override fun itemClick(position: Int) {
                showToast(list[position].toString())
            }
        })
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}