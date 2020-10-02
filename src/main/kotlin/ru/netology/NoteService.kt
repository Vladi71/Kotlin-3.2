package ru.netology

class NoteService {

    private var notes = mutableListOf<Note>()
    private var currentId = 1
    private var comments = mutableListOf<Comment>()


    fun addNote(note: Note) {
        notes.plusAssign(note.copy(id = currentId++))
        notes.last()

    }

    fun addCommentNote(comment: Comment) {
        notes.forEach { currentNote ->
            if (currentNote.id == comment.noteId) {
                comments.plusAssign(comment)
                currentNote.comments += comment

            }
        }
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
}

