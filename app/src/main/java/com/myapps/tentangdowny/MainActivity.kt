package com.myapps.tentangdowny

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myapps.tentangdowny.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Downy Uwu_Uwu")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
        binding.doneButton.setOnClickListener{
            addNickname(it)


        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

//        nicknameView.text = editText.text // Ini memasukan Inputan dari Edit Text Ke NicknameView
//        editText.visibility = View.GONE // Ini Menghilangkan editText
//        view.visibility = View.GONE // Ini Menghilangkan Button
//        nicknameView.visibility = View.VISIBLE // Ini Menampilkan Isi Text Yang Telah di Inputkan


        // Hide the keyboards
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)


    }
}