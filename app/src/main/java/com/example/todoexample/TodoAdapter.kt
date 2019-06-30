package com.example.todoexample

import android.content.Context
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_list_item.view.*
import java.text.SimpleDateFormat

class ToDoAdapter(val items: MutableList<ToDoListItem>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    //Täyttää näkymät
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(from(context).inflate(R.layout.todo_list_item, parent, false))
    }

    //Palauttaa eläinten määrän
    override fun getItemCount(): Int {
        return items.size
    }

    //Bindaa jokaisen eläimen AllayListasta omaan näkymään
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTodoTitle.text = items[position].title
        holder.txtTodoDescription.text = items[position].description

        val formatted = SimpleDateFormat("dd.MM.yyyy HH:mm")

        holder.txtTodoDate.text = formatted.format(items[position].date)
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val txtTodoTitle = v.txt_todo_title
    val txtTodoDescription = v.txt_des
    val txtTodoDate = v.txt_date
}