package ru.savchenko.andrey.realenglish.adapters

import android.view.View
import android.widget.TextView
import ru.savchenko.andrey.realenglish.R
import ru.savchenko.andrey.realenglish.base.BaseViewHolder
import ru.savchenko.andrey.realenglish.entities.Message
import ru.savchenko.andrey.realenglish.interfaces.OnItemClickListener
import java.text.SimpleDateFormat

/**
 * Created by savchenko on 27.11.17.
 */
class ChatHolder(itemView: View) : BaseViewHolder<Message>(itemView) {
    val tvChatItem:TextView
    val tvDate:TextView

    init {
        tvChatItem = itemView.findViewById(R.id.tvUserMessage)
        tvDate = itemView.findViewById(R.id.tvDate)
    }

    override fun bind(t: Message, clickListener: OnItemClickListener) {
        super.bind(t, clickListener)
        tvChatItem.setText(t.text)
        tvDate.setText(SimpleDateFormat("dd.MM.yyyy mm:hh").format(t.date))

    }
}