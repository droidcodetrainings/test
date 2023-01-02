package pl.farmaprom.trainings.test

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TestViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textView: TextView
    val button: Button

    init {
        textView = view.findViewById(R.id.tvTest)
        button = view.findViewById(R.id.btnTest)
    }
}