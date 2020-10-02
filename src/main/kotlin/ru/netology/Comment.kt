package ru.netology



data class Comment(
        val noteId: Int,
        val commentId: Int,
        val message: String,
) {
    override fun toString(): String {
        return "Комментарий: $message\n"
    }
}