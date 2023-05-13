package com.example.practice_16

import android.annotation.SuppressLint
//import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.practice_16.databinding.FragmentUserBinding
import kotlin.random.Random
import com.example.practice_16.R
import kotlin.properties.Delegates

class UserFragment : Fragment() {

    lateinit var binding: FragmentUserBinding
    private  val dataModel: DataModel by activityViewModels()
    var randbut by Delegates.notNull<Int>()
    var randresult by Delegates.notNull<Int>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater)
        return binding.root
    }

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFromActivty.observe(activity as LifecycleOwner){
            binding.randvalue.text = it
        }
        dataModel.messageFromActivitySum.observe(activity as LifecycleOwner){
            binding.Sum.text = it
        }
        dataModel.messageFromActivityResult.observe(activity as LifecycleOwner){
            randresult = it // проверка результата на четность и нечетность и(присваиваю значение проверки к новой переменной)
        }
        dataModel.BtnClickFragment.observe(activity as LifecycleOwner){
            if(it == true){ //в мэйне 43 строчка
                randbut = (1..2).random()
                if (randbut == 1){
                    binding.imageView2.isVisible = true
                    binding.radioButton3.isChecked = true
                    binding.imageView3.isVisible = false
                    if(randresult == randbut){
                        binding.imageView2.setImageResource(R.drawable.img_true)
                        count++
                    }else{
                        binding.imageView2.setImageResource(R.drawable.img_false)
                    }
                }
                else{
                    binding.imageView3.isVisible = true
                    binding.radioButton4.isChecked = true
                    binding.imageView2.isVisible = false
                    if(randresult == randbut){
                        binding.imageView3.setImageResource(R.drawable.img_true)
                        count++
                    }else{
                        binding.imageView3.setImageResource(R.drawable.img_false)
                    }
                }
            }
            dataModel.messageCount.value = count.toString()
        }

    }

    companion object{
        @JvmStatic
        fun newInstance() = UserFragment()
    }
}