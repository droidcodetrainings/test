package pl.farmaprom.trainings.test

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.farmaprom.trainings.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button1.text = "new Button text"
        binding.someTextView.setTextColor(getColor(R.color.black))

        val data = mutableListOf<RowData>()

        for(i in 1..100000) {
            data.add(RowData(i))
        }

        val adapter = TestAdapter(data) {
            Toast.makeText(this, "clicked index ${it.index}", Toast.LENGTH_SHORT).show()
        }
        val list = findViewById<RecyclerView>(R.id.list)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

//        val parent = findViewById<LinearLayout>(R.id.parent_layout)
//
//        for(i in 1..100000) {
//            parent.addView(getRow(index = i))
//        }
//
//        val textView = findViewById<TextView>(R.id.some_text_view)
//        textView.setText("Text from code")
//        textView.setTextColor(getColor(R.color.black))
//
////        val textView = findViewById<TextView>(R.id.some_text_view)
//        val textView2 = parent.findViewById<TextView>(R.id.some_text_view)
//        val button = findViewById<Button>(R.id.button1)
//        button.setOnClickListener {
//            Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show()
//        }
    }

    private fun getRow(index: Int): LinearLayout {
        val row = LinearLayout(this)
        row.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        row.orientation = LinearLayout.HORIZONTAL

        row.addView(
            TextView(this).apply {
                text = "text $index"
            }
        )
        row.addView(
            Button(this).apply {
                text = "button $index"
            }
        )

        return row
    }
}
