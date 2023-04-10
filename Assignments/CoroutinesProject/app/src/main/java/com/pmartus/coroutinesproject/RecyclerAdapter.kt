package com.pmartus.coroutinesproject

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
            val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
            return ViewHolder(v)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.outputText.text = viewModel.outputs[position]
    }

    override fun getItemCount(): Int {
        return viewModel.outputs.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var outputText: TextView

        init {
            outputText = itemView.findViewById(R.id.outputText)

        }
    }
}