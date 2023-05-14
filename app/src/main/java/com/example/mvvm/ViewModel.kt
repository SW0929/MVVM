package com.example.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

class ViewModel {
    //MVP의 Interface를 만드는 것과 동일

    var toastMessage = MutableLiveData<Int>() //이 방법이 더 좋음
    var checkPasswordMessage = ObservableField<Boolean>(false)

    var model = Model()


    fun clickNumber(i: Int){
        //입력된 값 삽입
        //mutable 이기 때문에 value 사용
        toastMessage.value = 1
        model.inputPassword(i)

        if (model.password.size == 4 && model.checkPassword()){
            //4자리 이상 비밀번호가 1234
            //비밀번호가 맞을 경우 true
            //observale 이기 때문에 set 사용
            checkPasswordMessage.set(true)

        }
    }
}