package com.example.practice_16

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.practice_16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    var n = 3 //(присвоили значение n = 3) (кол-во символов)
    lateinit var First: String
    lateinit var Second: String
    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(UserFragment.newInstance(), R.id.UserFrame)
        openFrag(CompFragment.newInstance(), R.id.CompFrame)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.Start.setOnClickListener{
            if (binding.Start.text == "Играть"){
                randStart()
                dataModel.messageFromActivty.value = First //присваиваю значения для игрока и отсылаю их в компфрагмент и там же использую
                dataModel.messageFromActivitySum.value = Second

                check()
                dataModel.messageFromActivityResult.value = result.toInt() //для игрока, и там используем(для проверки)

                randStart()
                dataModel.messageFromActivityRandList.value = First //для компа
                dataModel.messageFromActivityRandListSum.value = Second

                check()
                dataModel.messageFromActivityResultFromComp.value = result.toInt()

                dataModel.BtnClickFragment.value = true //логика бота(срабатывает единнжды)
                binding.Start.text = "Продолжить"
            }else{
                binding.Start.text = "Играть"
                dataModel.BtnClickFragment.value = false
            }

        }
        dataModel.messageCount.observe(this) {
            binding.txtUser.text = it //получаем значения от юезркфрагмент и компфрагмент
        }
        dataModel.messageCountForComp.observe(this) {
            binding.txtComp.text = it
        }
        dataModel.BtnCheckenabled.observe(this){
            if (it == true){
                binding.Start.isEnabled = true
            }
        }
    }
  /*  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return  true
    }*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finishAndRemoveTask()
        }
        return true
    }
    private fun check() { //проверка на четное и нечетное берем из рандсеконд
        if (Second.toInt() % 2 == 0){
            result = "1" //четное
        }else {
            result = "2" //нечетное
        }
    }
    private fun randStart(){
        var randomList: RandList = RandList()
        var listorsum = randomList.RandomListOrSum(n) //ввожу кол-во символов в класс RandList
        First = listorsum.first
        Second = listorsum.second.toString()
    }
    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}