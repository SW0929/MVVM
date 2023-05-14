package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding

//Controller
class MainActivity : AppCompatActivity()  {

    lateinit var binding : ActivityMainBinding

    var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        //숫자가 선택되면 ViewModel의 ClickNuber 함수에서 데이터가 세팅되자마자 Toast메시지가 호출

        // 첫 번째: lifeCycle 액티비티에 따라서 메모리에서 지우거나 살려야 하기 때문에 this
        //Mutable을 사용하는 방법 추천
        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, "$it 번을 클릭했습니다.", Toast.LENGTH_SHORT).show()
        })

        //아래와 같은 방법은 그냥 이런게 있다 정도만
        //메인 액티비티가 사라져도 메모리에 남는 side effect가 발생하기 때문

        viewModel.checkPasswordMessage.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (viewModel.checkPasswordMessage.get() == true){
                    binding.messageSuccess.visibility = View.VISIBLE
                }else{
                    binding.messageSuccess.visibility = View.GONE
                }
            }

        })
    }

}
