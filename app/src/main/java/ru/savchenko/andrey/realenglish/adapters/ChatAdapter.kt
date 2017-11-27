package ru.savchenko.andrey.realenglish.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.savchenko.andrey.realenglish.R
import ru.savchenko.andrey.realenglish.base.BaseAdapter
import ru.savchenko.andrey.realenglish.base.BaseViewHolder
import ru.savchenko.andrey.realenglish.entities.Message
import ru.savchenko.andrey.realenglish.interfaces.OnItemClickListener


/**
 * Created by savchenko on 27.11.17.
 */
class ChatAdapter(val messages:List<Message>)
    : BaseAdapter<Message>(messages) {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Message>? {
        if(viewType==1) {
            return ChatHolder(LayoutInflater
                    .from(parent?.context).inflate(R.layout.item_chat_right, parent, false))
        }else return ChatHolder(LayoutInflater
                .from(parent?.context).inflate(R.layout.item_chat_left, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        val message = messages.get(position)
        if(message.creatorId==1){
            return 1
        }else return 0
    }
}