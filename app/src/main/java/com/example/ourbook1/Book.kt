package com.example.ourbook1

import java.sql.Blob

data class Book(val id: Int, val name: String, val surename: String, val email: String,
                val address: String, val date: String, val hp: String, val image: ByteArray? = null)
