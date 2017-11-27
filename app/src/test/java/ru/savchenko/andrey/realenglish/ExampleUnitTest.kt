package ru.savchenko.andrey.realenglish

import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.Callable

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Observable.fromCallable({Throwable()})
                .subscribe({ text -> println(text) },
                        { error -> error.printStackTrace()})
    }
}
