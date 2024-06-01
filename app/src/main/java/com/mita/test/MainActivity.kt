package com.mita.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mita.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        adapter = MyAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        val initialData = listOf(
            MyDataClass(1, "Item 1"),
            MyDataClass(2, "Item 2"),
            MyDataClass(3, "Item 3")
        )
        adapter.updateData(initialData)

        binding.buttonAdd.setOnClickListener {
            val newData = adapter.currentList.toMutableList()
            newData.add(MyDataClass(newData.size + 1, "New Item"))
            adapter.updateData(newData)
        }

        binding.buttonRemove.setOnClickListener {
            val newData = adapter.currentList.toMutableList()
            if (newData.isNotEmpty()) {
                newData.removeAt(newData.size - 1)
                adapter.updateData(newData)
            }
        }

        binding.buttonUpdate.setOnClickListener {
           val newData = adapter.currentList.map { if (it.id == 1) it.copy(name = "Updated Item 1") else it }
            adapter.updateData(newData)
        }
    }
}