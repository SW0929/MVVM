package com.example.mvvm


//DataBase라 할 수도 있고 일종의 view 표시하는데 정보를 관리하는 클래스
class Model {
    var password : MutableList<Int> = mutableListOf()

    fun inputPassword(i : Int){
        if(password.size <= 4){
            password.add(i)
        }
    }
    fun checkPassword(): Boolean{
        var trueCount = 0

        //현재 비밀번호
        var savePassword = mutableListOf(1, 2, 3, 4)

        for(i in 0 until savePassword.size){
            if(savePassword[i] == password[i]){
                trueCount++
            }
        }

        return trueCount == 4
    }
}