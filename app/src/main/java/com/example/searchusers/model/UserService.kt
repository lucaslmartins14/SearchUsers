package com.example.searchusers.model

class UserService {

    fun searchByName(name: String) : ResultUser {
        val mUser = users.filter { it.name == name }
        return if (mUser.isNullOrEmpty())
            (ResultUser(null, false))
        else
            (ResultUser(mUser[0], true))
    }

    private val users = listOf(
        User("Lucas", "26", "M"),
        User("Sara", "21", "F"),
        User("Diego", "22", "M")
    )
}