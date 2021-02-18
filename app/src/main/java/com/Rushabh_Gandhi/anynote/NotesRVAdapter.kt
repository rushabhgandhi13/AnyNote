package com.Rushabh_Gandhi.anynote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context :Context, private val listener:INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
val allNOtes = ArrayList<Notes>()
inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
val textView = itemView.findViewById<TextView>(R.id.text)
    val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)

}



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
val viewholder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
viewholder.deleteButton.setOnClickListener{
listener.onItemClicked(allNOtes[viewholder.adapterPosition])
}

        return viewholder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNOtes[position]
        holder.textView.text= currentNote.text
    }

    override fun getItemCount(): Int {
return allNOtes.size
    }


    fun updateList(newsList: List<Notes>){
        allNOtes.clear()
        allNOtes.addAll(newsList)

        notifyDataSetChanged()
    }
}

interface INotesRVAdapter{
    fun onItemClicked(note: Notes)
}