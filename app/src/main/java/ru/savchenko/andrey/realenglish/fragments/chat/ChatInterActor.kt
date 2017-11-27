package ru.savchenko.andrey.realenglish.fragments.chat

import android.text.TextUtils
import io.reactivex.Observable
import io.reactivex.Single
import ru.savchenko.andrey.realenglish.entities.Message
import java.util.*


/**
 * Created by savchenko on 27.11.17.
 */
class ChatInterActor {
    private lateinit var currentMessages: MutableList<Message>


    fun getMessages(): Observable<MutableList<Message>> {
        currentMessages = mutableListOf<Message>(Message(1, "Здравствуйте, как дела?", 1, Date()),
                Message(2, "Здравствууйте, делаю домашнее задание)))", 2, Date()),
                Message(3, "Придете к нам на вечер поэзии Шекспира?", 1, Date()),
                Message(4, "Да, конечно, а во сколько он??", 2, Date()),
                Message(5, "В 14.00! Будем ждать!", 1, Date()))
        return Observable.just(currentMessages)
    }

    fun sendMessage(message: String): Single<Int> {
        return Single.fromCallable({
            if (!TextUtils.isEmpty(message)) {
                currentMessages.add(Message((Math.random() * 1000).toInt(),
                        message,
                        1,
                        Date()))
            }
            return@fromCallable currentMessages.size
        })
    }
}