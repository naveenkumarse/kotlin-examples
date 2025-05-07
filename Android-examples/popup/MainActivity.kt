class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.showPopupBtn)

        button.setOnClickListener {
            val popup = PopupMenu(this, button)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu, popup.menu)

            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.item1 -> showToast("Option 1 selected")
                    R.id.item2 -> showToast("Option 2 selected")
                    R.id.item3 -> showToast("Option 3 selected")
                }
                true
            }

            popup.show()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
