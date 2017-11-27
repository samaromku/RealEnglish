package ru.savchenko.andrey.realenglish.fragments.chat

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_chat.*
import ru.savchenko.andrey.realenglish.R
import ru.savchenko.andrey.realenglish.adapters.ChatAdapter
import ru.savchenko.andrey.realenglish.base.BaseFragment
import ru.savchenko.andrey.realenglish.entities.Message
import ru.savchenko.andrey.realenglish.interfaces.OnItemClickListener

class ChatFragment : BaseFragment(), OnItemClickListener {
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
        val messages: MutableList<Message> = ArrayList<Message>()
        messages.add(Message(1, "Здравствуйте, как дела?", 1))
        messages.add(Message(2, "Здравствууйте, делаю домашнее задание)))", 2))
        messages.add(Message(3, "Придете к нам на вечер поэзии Шекспира?", 1))
        messages.add(Message(4, "Да, конечно, а во сколько он??", 2))
        messages.add(Message(5, "В 14.00! Будем ждать!", 1))
        rvChat = view!!.findViewById(R.id.rvChat)
        chatAdater = ChatAdapter(messages)
        chatAdater.clickListener = this

        rvChat.layoutManager = LinearLayoutManager(activity)
        rvChat.adapter = chatAdater
        ibSendMessage.setOnClickListener({
            if(!TextUtils.isEmpty(etTaskBody.text)) {
                messages.add(Message((Math.random() * 1000).toInt(),
                        etTaskBody.text.toString(),
                        1))
                etTaskBody.setText("")
                chatAdater.notifyItemInserted(messages.size)
                rvChat.smoothScrollToPosition(messages.size)
            }
        })
    }
}