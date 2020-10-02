package ru.netology

data class Note(
        var id: Int = -1,
        var userId: Int,
        val title: String,
        val text: String,
        var comments: List<Comment> = emptyList(),

        ) {
}