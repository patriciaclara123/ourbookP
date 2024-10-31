package com.example.ourbook1

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ourbook1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var db: BookDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = BookDatabaseHelper(this)

        val bookId = intent.getIntExtra("book_id", -1)

        if (bookId != -1) {
            val book = db.getBookByID(bookId)

            binding.NamaDetail.text = book.name
            binding.aliasDetail.text = book.surename
            binding.emailDetail.text = book.email
            binding.alamatDetail.text = book.address
            binding.tglLahirDetail.text = book.date
            binding.telponDetail.text = book.hp

            if (book.image != null) {
                val bmp = BitmapFactory.decodeByteArray(book.image, 0, book.image.size)
                binding.FotoDetail.setImageBitmap(bmp)
            } else {
                binding.FotoDetail.setImageResource(R.drawable.baseline_person_24)
            }
        }

        binding.backDetail.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}