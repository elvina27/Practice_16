package com.example.practice_16

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {
    val  messageFromActivty: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
        //Получаю значение от рандома вызванного в MainActivity '5 6 3' и использую его в fragment_one
    }
    val  messageFromActivitySum: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
        //Получаю значение суммы рандома вызванного в MainActivity '14' и использую его в fragment_one - computer
    }
    val  messageFromActivityRandList: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
        //тоже самое что и для messageFromActivty только использую его для fragment_two - user
    }
    val  messageFromActivityRandListSum: MutableLiveData<String>  by lazy {
        MutableLiveData<String>()
        //тоже самое что и для messageFromActivitySum только использую его для fragment_two - user
    }
    val  messageCount: MutableLiveData<String>  by lazy {
        MutableLiveData<String>()
        //отправляю количество правильных ответов после выполнение основной
        // логики бота и получаю его в MainActivity и меняется значение текста в Activity_main
    }
    val  messageCountForComp: MutableLiveData<String>  by lazy {
        MutableLiveData<String>()
        //отправляю количество правильных ответов после выполнение основной логики для user
        // и получаю его в MainActivity и меняется значение текста в Activity_main
    }
    val  messageFromActivityResult: MutableLiveData<Int>  by lazy {
        MutableLiveData<Int>()
        //Отправляю результат проверки чисел на чётность или нечётность в OneFragment 1 или 2
    }
    val  messageFromActivityResultFromComp: MutableLiveData<Int>  by lazy {
        MutableLiveData<Int>()
        //Отправляю результат проверки чисел на чётность или нечётность в TwoFragment 1 или 2
    }
    val  BtnClickFragment: MutableLiveData<Boolean>  by lazy {
        MutableLiveData<Boolean>()
        //После нажания на кнопку Играть отправляю значение true после чего срабатывает
        // логика бота по завершению логики обратно возращаю значение на false
    }
    val  BtnCheckenabled: MutableLiveData<Boolean>  by lazy {
        MutableLiveData<Boolean>()
        //По нажатию на radiobutton чёт нечёт присваиваю значение true отправляю в MainActivity где делаю кнопку Start Кликабельной
    }
}

