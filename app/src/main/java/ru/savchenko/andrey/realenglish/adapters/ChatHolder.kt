package ru.savchenko.andrey.realenglish.adapters

import android.view.View
import android.widget.TextView
import ru.savchenko.andrey.realenglish.R
import ru.savchenko.andrey.realenglish.base.BaseViewHolder
import ru.savchenko.andrey.realenglish.entities.Message
import ru.savchenko.andrey.realenglish.interfaces.OnItemClickListener

/**
 * Created by savchenko on 27.11.17.
 */
class ChatHolder(itemView: View) : BaseViewHolder<Message>(itemView) {
    val tvChatItem:TextView

    init {
        tvChatItem = itemView.findViewById(R.id.tvUserMessage)
    }

    override fun bind(t: Message, clickListener: OnItemClickListener) {
        super.bind(t, clickListener)
        tvChatItem.setText(t.text)
    }
}