package ru.savchenko.andrey.realenglish.fragments.chat

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_chat.*
import ru.savchenko.andrey.realenglish.R
import ru.savchenko.andrey.realenglish.adapters.ChatAdapter
import ru.savchenko.andrey.realenglish.base.BaseFragment
import ru.savchenko.andrey.realenglish.entities.Message
import ru.savchenko.andrey.realenglish.interfaces.OnItemClickListener

class ChatFragment : BaseFragment(), OnItemClickListener, ChatView {
    @InjectPresenter lateinit var presenter:ChatPresenter
    override fun onItemClick(position: Int) {
        println(position)
    }

    lateinit var chatAdater: ChatAdapter
    lateinit var rvChat: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_chat, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initMessages()
        ibSendMessage.setOnClickListener({
            presenter.sendMessage(etTaskBody.text.toString())
        })
    }

    override fun messageSent() {
        etTaskBody.setText("")
        chatAdater.notifyDataSetChanged()
        rvChat.smoothScrollToPosition(chatAdater.itemCount)
    }

    override fun setMessages(messages: MutableList<Message>) {
        rvChat = view!!.findViewById(R.id.rvChat)
        chatAdater = ChatAdapter(messages)
        chatAdater.clickListener = this

        rvChat.layoutManager = LinearLayoutManager(activity)
        rvChat.adapter = chatAdater
    }
}