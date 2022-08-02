package com.doubleclick.sqlightkmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.doubleclick.sqlightkmm.Greeting
import android.widget.TextView
import android.widget.Toast
import com.doubleclick.databasekmm.android.PersonDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqlite()

    }

    fun sqlite() {
        val androidSqlDriver = AndroidSqliteDriver(
            schema = PersonDatabase.Schema,
            context = this,
            name = "person.db"
        )

        val queries = PersonDatabase(androidSqlDriver).personEntityQueries

        val itemsBefore = queries.gerAllPersoms().executeAsList()
        Log.e("ItemDatabase", "Items Before: $itemsBefore")

        for (i in 1..15) {
            queries.insertPersonById(
                id = i.toLong(),
                fName = "PersonName$i.",
                LName = "password123"
            )
        }

        val itemsAfter = queries.gerAllPersoms().executeAsList()
        Log.e("ItemDatabase", "Items After: $itemsAfter")

        text_view.setOnClickListener {
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
            queries.deleletAll();
            val itemsAfter = queries.gerAllPersoms().executeAsList()
            Log.e("ItemDatabaseDelete", "Items After: $itemsAfter")
        }
    }
}
