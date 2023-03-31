package org.d3if0072.volumnbalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if0072.volumnbalok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            volumeBalok()
        }

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT) as String
            binding.tvResult.text = result
        }
    }

    fun volumeBalok() {
        val inputLength = binding.editLength.text.toString().trim()
        val inputWidth = binding.editWidth.text.toString().trim()
        val inputHeight = binding.editHeight.text.toString().trim()

        var isEmptyFields = false

        if (inputLength.isEmpty()){
            isEmptyFields = true
            binding.editLength.error = "Field Ini Tidak Boleh Kosong"
        }

        if (inputWidth.isEmpty()){
            isEmptyFields = true
            binding.editWidth.error = "Field Ini Tidak Boleh Kosong"
        }

        if (inputHeight.isEmpty()){
            isEmptyFields = true
            binding.editHeight.error = "Field Ini Tidak Boleh Kosong"
        }

        if(!isEmptyFields){
            val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
            binding.tvResult.text = volume.toString()
        }
    }

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

}