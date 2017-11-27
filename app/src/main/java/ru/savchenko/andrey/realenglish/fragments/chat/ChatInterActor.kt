package ru.savchenko.andrey.realenglish.fragments.chat

import android.text.TextUtils
import kotlinx.android.synthetic.main.fragment_chat.*
import ru.savchenko.andrey.realenglish.entities.Message


/**
 * Created by savchenko on 27.11.17.
 */
class ChatInterActor {
    private lateinit var currentMessages:MutableList<Message>


    fun getMessages():MutableList<Message>{
        currentMessages = mutableListOf<Message>(Message(1, "Здравствуйте, как дела?", 1),
                Message(2, "Здравствууйте, делаю домашнее задание)))", 2),
                Message(3, "Придете к нам на вечер поэзии Шекспира?", 1),
                Message(4, "Да, конечно, а во сколько он??", 2),
                Message(5, "В 14.00! Будем ждать!", 1))
        return currentMessages
    }

    fun sendMessage(message:String){
        if(!TextUtils.isEmpty(message)) {
            currentMessages.add(Message((Math.random() * 1000).toInt(),
                    message,
                    1))
        }
    }
}