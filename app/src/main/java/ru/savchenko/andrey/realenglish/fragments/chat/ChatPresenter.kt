package ru.savchenko.andrey.realenglish.fragments.chat

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

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
        interActor.getMessages()
                .subscribe({ messages ->
                    viewState.setMessages(messages)
                })
    }

    fun sendMessage(message: String) {
        interActor.sendMessage(message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t ->
                    viewState.messageSent(t)
                })
    }
}