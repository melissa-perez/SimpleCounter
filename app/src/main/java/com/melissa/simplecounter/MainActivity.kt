package com.melissa.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterBtn = findViewById<Button>(R.id.counterButton)
        val counterView = findViewById<TextView>(R.id.counter)
        val upgradeBtn = findViewById<Button>(R.id.upgradeCounterButton)

        counterBtn.setOnClickListener {
            counter++
            if (counter >= 100) {
                upgradeBtn.visibility = View.VISIBLE
            }
            counterView.text = counter.toString()
        }

        upgradeBtn.setOnClickListener{
            upgradeBtn.visibility = View.INVISIBLE
            counterBtn.text = getString(R.string.upgrade_button_text)
            Toast.makeText(it.context, "Unlocked +2 upgrade!", Toast.LENGTH_SHORT).show()
            counterBtn.setOnClickListener{
                counter += 2
                counterView.text = counter.toString()
            }
        }
    }
}