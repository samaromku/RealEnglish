package ru.savchenko.andrey.realenglish.entities

import java.util.*

/**
 * Created by savchenko on 27.11.17.
 */
data class Message(val id: Int,
                   val text: String,
                   val creatorId: Int,
                   val date: Date)