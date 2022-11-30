package com.example.navigationcomponent

import java.io.Serializable

data class Card(
    var tvLife: String? = "No life",
    var tvName: String? = "No name",
    var image: Int? = R.drawable.ic_launcher_background
): java.io.Serializable