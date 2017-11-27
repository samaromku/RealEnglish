package ru.savchenko.andrey.realenglish.fragments.chat

import com.arellomobile.mvp.MvpView
import ru.savchenko.andrey.realenglish.entities.Message

/**
 * Created by savchenko on 27.11.17.
 */
interface ChatView : MvpView{
    fun setMessages(messages:MutableList<Message>)
    fun messageSent(position:Int)
}