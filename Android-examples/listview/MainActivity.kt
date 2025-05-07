class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.myListView)


        val items = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry")

        // Set up the adapter
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        listView.adapter = adapter

        // Item click listener
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            Toast.makeText(this, "Clicked: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}

