package com.example.menucontextuel;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
lateinit var txt : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.txt)
        registerForContextMenu(txt)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.setHeaderTitle("Context Menu Header")
        menuInflater.inflate(R.menu.contextmenu, menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.search -> {
                txt.setText("search")
                Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.ch1 -> {
                txt.setText("ch1")
                Toast.makeText(this, "CH1 selected", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}