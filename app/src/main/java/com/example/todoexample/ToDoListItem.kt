package com.example.todoexample

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ToDoListItem(
    @PrimaryKey var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var date: Date = Date()
) : RealmObject() {
}