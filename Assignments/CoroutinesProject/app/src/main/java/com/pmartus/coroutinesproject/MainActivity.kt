package com.pmartus.coroutinesproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pmartus.coroutinesproject.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val myCoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter
    }

    fun generateOutput(view: View) {
        myCoroutineScope.launch(Dispatchers.Main) { randomWait() }
        Log.i("ZZZ", "generateOutput: ")
    }

    private suspend fun randomWait() {
        val wait = Random.nextInt(1, 10)*1000
        val name = binding.enterName.text.toString()
        Log.i("ZZZ", "RandomWait")
        delay(wait.toLong())
        viewModel.addOutput(name, wait)
        adapter?.notifyDataSetChanged()
    }
}