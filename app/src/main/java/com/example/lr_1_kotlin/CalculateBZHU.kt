package com.example.lr_1_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class CalculateBZHU : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bzhu)
    }

    fun calculate(view: View) {
        val edit_age = findViewById<EditText>(R.id.editTextNumberAge)
        val edit_height = findViewById<EditText>(R.id.editTextNumberHeight)
        val edit_weight = findViewById<EditText>(R.id.editTextNumberWeight)
        val edit_gender = findViewById<Switch>(R.id.switchGender)
        val edit_sport = findViewById<CheckBox>(R.id.checkBoxSport)

        var age: Int = edit_age.text.toString().toInt()
        var height: Int = edit_height.text.toString().toInt()
        var weight: Int = edit_weight.text.toString().toInt()

        var gender: Boolean = edit_gender.text.toString().toBoolean()

        var sport: Boolean = edit_sport.text.toString().toBoolean()

        var calories: Double = 0.0

        if (gender) {
            calories = 10 * weight + 6.25 * height - 5 * age + 5

        }
        else if (!gender) {
            calories = 10 * weight + 6.25 * height - 5 * age - 161
        }

        if (sport) {
            calories *= 1.5
        } else {
            calories *= 1.2
        }

        var fats = calories * 0.3 / 9
        var carbohydrates = calories * 0.4 / 4
        var proteins = calories * 0.3 / 4

        //Toast.makeText(this, "Calories: $calories fats: $fats proteins: $proteins carbohydrates: $carbohydrates", Toast.LENGTH_LONG).show()


        var textCaloriesCalc = findViewById<TextView>(R.id.textCaloriesCalc)

        textCaloriesCalc.text = calories.toInt().toString()


        var textFatsCalc = findViewById<TextView>(R.id.textFatsCalc)
        textFatsCalc.setText(fats.toInt().toString())

        var textProteinsCalc = findViewById<TextView>(R.id.textProteinsCalc)
        textProteinsCalc.setText(proteins.toInt().toString())

        var textCarbohydratesCalc = findViewById<TextView>(R.id.textCarbohydratesCalc)
        textCarbohydratesCalc.setText(carbohydrates.toInt().toString())

    }

    fun back(view: View) {
        val main = Intent(this, MainActivity::class.java)
        startActivity(main)
    }
}
