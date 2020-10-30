package noseary.github.io.kotlinapp

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.system.measureTimeMillis

class KoroutineTest {

    @Test
    fun testCoroutine() {
        runBlocking {
            launch { // launch a new coroutine in the scope of runBlocking
                delay(1000L)
                println("World!")
            }
            println("Hello,")
        }
    }

    @Test
    fun testCoroutine2() = runBlocking(Dispatchers.IO) { // this: CoroutineScope
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")

        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        runBlocking { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scop2e is over") // This line is not printed until the nested launch completes
    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // pretend we are doing something useful here
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }


    @Test
    fun test3() = runBlocking {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            println("The answer is ${one + two}")
        }
        println("Completed in $time ms")
    }

    @Test
    fun test4() {
        runBlocking() {
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name} doing task 1")
            withContext(Dispatchers.IO) {
                delay(1000L)
                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name} calling API1")
            }
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name} doing task 2")
            withContext(Dispatchers.IO) {
                delay(1000L)
                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name} calling API2")
            }
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name} doing task 3")
        }
    }


}