package com.Rushabh_Gandhi.anynote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE )
    suspend fun insert(note:Notes)
    @Delete
    suspend fun delete(note: Notes)
    @Query("Select* from notes_table order by id")
    fun getAllNotes(): LiveData<List<Notes>>
}