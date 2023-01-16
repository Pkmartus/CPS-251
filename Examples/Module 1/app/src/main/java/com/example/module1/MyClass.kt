package com.example.module1
//small class illustrates the functions of companion objects and that all instances of the class have access to them
class MyClass {
    fun showCount() {
        println("Counter=$counter")
    }

    companion object {
        var counter = 1

        fun counterUp(){
            counter+=1
        }
    }
}

fun main(args:Array<String>){
    println(MyClass.counter)
    MyClass.counterUp()
    println(MyClass.counter)
    val instanceA = MyClass()
    instanceA.showCount()
}