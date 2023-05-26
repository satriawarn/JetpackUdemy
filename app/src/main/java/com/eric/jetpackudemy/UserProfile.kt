package com.eric.jetpackudemy

data class UserProfile constructor(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf(
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
    UserProfile("Erik Satriawan", true, R.drawable.unicorn),
    UserProfile("John Doe", false, R.drawable.ic_launcher_background),
)