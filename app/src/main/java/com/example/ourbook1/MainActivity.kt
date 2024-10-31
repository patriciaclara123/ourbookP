package com.example.ourbook1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ourbook1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: BookDatabaseHelper
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        db = BookDatabaseHelper(this)
        booksAdapter = BooksAdapter(db.getAllBooks(), this)
        setContentView(binding.root)

        binding.booksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.booksRecyclerView.adapter = booksAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.aboutUsButton.setOnClickListener{
            val intent = Intent(this, AboutBookActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        booksAdapter.refreshData(db.getAllBooks())
    }
}