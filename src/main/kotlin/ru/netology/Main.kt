package ru.netology


val noteService = NoteService()

fun main() {

    noteService.addNote(Note(
            userId = 1,
            title = "Первая заметка",
            text = "hahaha",

            ))
    noteService.addNote(Note(
            userId = 2,
            title = "Вторая заметка",
            text = "azaza",
    ))

    // noteService.notePrint()

    noteService.addCommentNote(Comment(
            noteId = 1,
            commentId = 1,
            message = "Первый коммент 1/1"
    ))
    noteService.addCommentNote(Comment(
            noteId = 1,
            commentId = 2,
            message = "Второй коммент 1/1"
    ))

    noteService.getComments(1)

    noteService.updateNote(Note(
            id = 2,
            userId = 1,
            title = "Изменил Заголовок заметки",
            text = "Изменил",
    ))
    noteService.updateComment(Comment(
            noteId = 1,
            commentId = 1,
            message = "Изменил перывый комментарий"
    ))

    noteService.getNoteUser(1)
    // noteService.getNote(1)

}