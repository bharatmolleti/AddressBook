package com.molleti.adressbook

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.molleti.adressbook.api.APIInterfaceImpl
import com.molleti.adressbook.api.RetrofitBuilder
import com.molleti.adressbook.viewmodel.PersonsViewModel
import com.molleti.adressbook.viewmodel.Status
import com.molleti.adressbook.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerAdapter = RecyclerAdapter(arrayListOf())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                APIInterfaceImpl(RetrofitBuilder.apiService)
            )
        )[PersonsViewModel::class.java]

        viewModel.getPeople().observe(this,
            Observer {
                when (it.status) {
                    Status.SUCESS -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        it.data?.let { people -> recyclerAdapter.addPeople(people) }
                        recyclerAdapter.notifyDataSetChanged()
                    }
                    Status.IN_PROGRESS -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                    Status.FAILED -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        )
    }
}
