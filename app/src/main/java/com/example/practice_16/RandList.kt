package com.example.practice_16

class RandList {
    private var list: MutableList<Int> = mutableListOf()
    fun RandomListOrSum(n : Int): Pair<String, Int>{
        var rnd = 0; //до сих пор пока у нас в листе меньше трех, у нас равндомятся числа от 1 до 6 и лобавляются элемент в лист
        while(list.size < n) {
            rnd = (1..6).random()
            list.add(rnd)
        }
        var str = "";//чтобы пробелы не считывались
        var sum = 0; //чтобы сумму получить
        for(c in list) {//само значение в самом листе (берем значение из лсита и присваиваемака в переменную с)
            str = str + "      $c" //значение, много прбелом, значение
            sum = sum + c //цикл, сумма - прогончик, добавляем, получаем
        }
        return Pair(str,sum)
    }
}
