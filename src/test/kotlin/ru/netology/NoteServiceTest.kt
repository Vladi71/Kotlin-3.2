package ru.netology

import junit.framework.Assert.*
import org.junit.Test


class NoteServiceTest {


    @Test
    fun addNoteTrue() {
        val service = NoteService()

        val note = Note(
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        )
        val result = service.addNote(note)
        assertTrue(result)
    }
    @Test
    fun addNoteTrueFalse() {
        val service = NoteService()

        val note = Note(
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        )
        val result = !service.addNote(note)
        assertFalse(result)
    }

    @Test
    fun addCommentNoteTrue() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        val result = service.addCommentNote(Comment(
                noteId = 1,
                commentId = 1,
                message = "Первый коммент 1/1"))
        assertTrue(result)
    }

    @Test
    fun addCommentNoteFalse() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        val result = service.addCommentNote(Comment(
                noteId = 2,
                commentId = 1,
                message = "Первый коммент 1/1"))
        assertFalse(result)
    }


    @Test
    fun updateNoteTrue() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        val update = Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        )
        val result = service.updateNote(update)
        assertTrue(result)

    }

    @Test
    fun updateNoteFalse() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        val update = Note(
                id = 5,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        )
        val result = service.updateNote(update)
        assertFalse(result)

    }


    @Test
    fun updateCommentTrue() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        service.addCommentNote(Comment(
                commentId = 1,
                noteId = 1,
                message = "Создал коммент"
        ))
        val update = Comment(
                commentId = 1,
                noteId = 1,
                message = "Изменил коммент"
        )
        val result = service.updateComment(update)
        assertTrue(result)
    }
    @Test
    fun updateCommentFalse() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        service.addCommentNote(Comment(
                commentId = 1,
                noteId = 1,
                message = "Создал коммент"
        ))
        val update = Comment(
                commentId = 2,
                noteId = 1,
                message = "Изменил коммент"
        )
        val result = service.updateComment(update)
        assertFalse(result)
    }


    @Test
    fun delNoteTrue() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        val result = service.delNote(1)
        assertTrue(result)
    }

    @Test
    fun delNoteFalse() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        val result = service.delNote(2)
        assertFalse(result)
    }

    @Test
    fun delCommentTrue() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        service.addCommentNote(Comment(
                noteId = 1,
                commentId = 1,
                message = "Первый коммент 1/1"
        ))
        val result = service.delComment(1)
        assertTrue(result)
    }

    @Test
    fun delCommentFalse() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        service.addCommentNote(Comment(
                noteId = 1,
                commentId = 8,
                message = "Первый коммент 1/1"
        ))
        val result = service.delComment(1)
        assertFalse(result)
    }

    @Test
    fun recoverCommentTrue() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        service.addCommentNote(Comment(
                noteId = 1,
                commentId = 1,
                message = "Первый коммент 1/1"
        ))
        service.delComment(1)
        val result = service.recoverComment(1)
        assertTrue(result)

    }

    @Test
    fun recoverCommentFalse() {
        val service = NoteService()
        service.addNote(Note(
                id = 1,
                userId = 1,
                title = "Первая заметка",
                text = "Текст в первой заметке",
        ))
        service.addCommentNote(Comment(
                noteId = 1,
                commentId = 1,
                message = "Первый коммент 1/1"
        ))
        service.delComment(1)
        val result = service.recoverComment(2)
        assertFalse(result)

    }
}