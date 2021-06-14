package com.example.intergers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvnumbers=findViewById<RecyclerView>(R.id.rvnumbers)
        rvnumbers.layoutManager=LinearLayoutManager(baseContext)
        var numbersAdapter=NumberRecylerViewAdapter(numbers(100))
        rvnumbers.adapter=numbersAdapter
    }
}
fun numbers(count:Int):List<BigInteger> {

    var num1 = BigInteger.ZERO
    var num2 = BigInteger.ONE
    var numList = MutableList<BigInteger>(count,{BigInteger.ZERO})
    numList[0] = num1
    numList[1] = num2
    for (i in 1..count) {
        var sum = num1 + num2
        num1 = num2
        num2 = sum
        numList[i - 1] = num1
    }
    return numList
}
