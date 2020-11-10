package com.imranrana.recyclerviewassignment.view.college_list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.imranrana.recyclerviewassignment.R
import com.imranrana.recyclerviewassignment.core.BaseActivity
import com.imranrana.recyclerviewassignment.core.ClickListener
import com.imranrana.recyclerviewassignment.model.College
import com.imranrana.recyclerviewassignment.model.CollegeCallBack
import com.imranrana.recyclerviewassignment.model.CollegeModelImpl
import com.imranrana.recyclerviewassignment.view.CollegeDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {
    private val collegeModelImpl= CollegeModelImpl();

    override val isHomeUpButtonEnabled: Boolean get() = false
    override fun setLayout(): Int = R.layout.activity_main
    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_homePage)
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        showList()
    }

    override fun onResume() {
        super.onResume()
        showList()
    }

    private fun showList(){
        collegeModelImpl.getList(object : CollegeCallBack{
            override fun success(collegeList: ArrayList<College>) {
                progress.visibility = View.GONE
                showCollegeList(collegeList)
            }

            override fun error(throwable: Throwable) {
                progress.visibility = View.GONE
                showCollegeList(collegeModelImpl.localStorageData())
            }
        })

    }

    fun showCollegeList(collegeList: ArrayList<College>){
        val adapter = CollegeAdapter(collegeList, object : ClickListener {
            override fun onItemClickListener(position: Int) {
                collegeDetailActivity(collegeList[position])
            }

            override fun onItemLongClickListener(position: Int) {}
        })
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun collegeDetailActivity(college: College){
        val intent = Intent(this@MainActivity,CollegeDetailsActivity::class.java)
        intent.putExtra("college",college)
        startActivity(intent)
    }
}