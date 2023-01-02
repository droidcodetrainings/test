package pl.farmaprom.trainings.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestAdapter(
    private val data: List<RowData>,
    private val onButtonClick: (RowData) -> Unit
) : RecyclerView.Adapter<TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_row, parent, false)
        return TestViewHolder(view)
    }

    override fun getItemCount() = data.count()

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val currentData = data[position]
        holder.textView.text = "Text ${currentData.index}"
        holder.button.text = "Button ${currentData.index}"
        holder.button.setOnClickListener {
            onButtonClick.invoke(currentData)
        }
    }
}
