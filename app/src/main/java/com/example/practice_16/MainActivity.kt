package com.example.practice_16

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practice_16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(CompFragment.newInstance(), R.id.FrameComp)
        openFrag(UserFragment.newInstance(), R.id.FrameUser)

        dataModel.messageFromCompFragment.observe(this) {
            val rbClick = it.toString().toBoolean()
            binding.btnStart.isEnabled = rbClick
        }

        binding.FrameComp.isVisible = true
        val btnCl = true

        binding.btnStart.setOnClickListener {
            binding.btnStart.isVisible = false
            binding.btnRestart.isVisible = true
            binding.txtCountComp.isVisible = true
            binding.txtCountUser.isVisible = true
            dataModel.messageForCompFragment.value = btnCl.toString()
            binding.FrameUser.isVisible = true
            binding.btnExit.isVisible = true

            dataModel.messageFromCompFragmentTrue.observe(this) {
                val trueCounterComp = it
                binding.txtCountComp.text = trueCounterComp
            }

            dataModel.messageFromUserFragmentTrue.observe(this) {
                val trueCounterUser = it
                binding.txtCountUser.text = trueCounterUser
            }
        }
        binding.btnRestart.setOnClickListener {
//            val intent = Intent(this, this::class.java)
//            startActivity(intent)
            (supportFragmentManager.findFragmentById(R.id.FrameComp) as? CompFragment)?.resetRadioButtons()
            binding.btnStart.isVisible = true
        }

        binding.btnExit.setOnClickListener {
            finish()
        }
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}