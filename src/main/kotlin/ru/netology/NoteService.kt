package ru.netology

class NoteService {

    private var notes = mutableListOf<Note>()
    private var deleteNotes = mutableListOf<Note>()
    private var currentId = 1
    private var comments = mutableListOf<Comment>()
    private var deleteComments = mutableListOf<Comment>()


    fun addNote(note: Note): Boolean {
        notes.plusAssign(note.copy(id = currentId++))
        notes.last()
        return true

    }

    fun addCommentNote(comment: Comment): Boolean {
        notes.forEach { currentNote ->
            if (currentNote.id == comment.noteId) {
                comments.plusAssign(comment)
                currentNote.comments += comment
                return true
            } else {
                println("Заметка не существует")
            }
        }
        return false
    }


    fun getComments(noteId: Int): List<Comment> {
        notes.forEach { note: Note ->
            if (noteId == note.id)
                println(note.comments)
            return note.comments
        }
        return emptyList()
    }


    fun updateNote(note: Note): Boolean {
        notes.forEachIndexed { index, currentNote ->
            if (currentNote.id == note.id) {
                notes[index] = note.copy()
                print(note.id)
                print(" ")
                println(note.title)
                return true
            }
        }
        return false
    }

    fun updateComment(comment: Comment): Boolean {
        notes.forEachIndexed { index, currentNote ->
            if (currentNote.id == comment.commentId) {
                comments[index] = comment.copy()
                println(comment.message)
                return true
            }
        }
        return false
    }


    fun getNoteUser(userId: Int): List<Note> {
        val userNotes = mutableListOf<Note>()
        notes.forEach { note: Note ->
            if (userId == note.userId)
                userNotes.add(note)
        }
        return userNotes
    }

    fun getNote(noteId: Int): List<Note> {
        val getNotes = mutableListOf<Note>()
        notes.forEach { note: Note ->
            if (noteId == note.userId)
                getNotes.plusAssign(note)
        }
        return getNotes
    }

    fun delNote(noteId: Int): Boolean {
        if (noteId < 0 || noteId > notes.size) {
            println("ID заметки не существует")
            return false
        }
        for (note in notes) {
            if (noteId == note.id) {
                deleteNotes.add(note)
                notes.remove(note)
                println("Заметка удалена")
                return true
            }
        }
        return false
    }

    fun delComment(comId: Int): Boolean {
        for (comment in comments)
            if (comId != comment.commentId) {
                println("ID комментария не существует")
                return false
            } else {
                for (comment in comments) {
                    if (comId == comment.commentId) {
                        deleteComments.add(comment)
                        comments.remove(comment)
                        println("Комментарий удален")
                        return true
                    }
                }
            }
        return false
    }

    fun recoverComment(comId: Int): Boolean {
        for (comment in deleteComments) {
            if (comId == comment.commentId) {
                comments.add(comment)
                deleteComments.remove(comment)
                println("Комментарий восстановлен")
                return true
            }
        }
        println("ID комментария не существует")
        return false
    }
}

