package ru.savchenko.andrey.realenglish.fragments.chat

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

/**
 * Created by savchenko on 27.11.17.
 */
@InjectViewState
class ChatPresenter : MvpPresenter<ChatView>() {
    val interActor: ChatInterActor

    init {
        interActor = ChatInterActor()
    }

    fun initMessages() {
        viewState.setMessages(interActor.getMessages())
    }

    fun sendMessage(message:String){
        interActor.sendMessage(message)
        viewState.messageSent()
    }
}