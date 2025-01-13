package com.example.spendwisely

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spendwisely.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Locale

public class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        setSupportActionBar(binding.Toolbar);
        supportActionBar?.title = "Transactions";

        binding.floatingActionButton2.setOnClickListener {
            AddTransactionFragment().show(supportFragmentManager, null)
        }

        binding.date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this)
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
               val selectedDate = Calendar.getInstance()
                selectedDate.set(year,month,dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())
                val finalDateFormat = dateFormat.format(selectedDate.time)
                binding.date.text = finalDateFormat.toString()
//                binding.date.text = dateFormat.toString()
            }
            datePickerDialog.show()

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    }