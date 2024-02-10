package com.clicker.aviatorclicker.game.data.source

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.clicker.aviatorclicker.game.data.model.BonusItems
import com.clicker.aviatorclicker.game.data.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class PreLoadDatabase: RoomDatabase.Callback() {

    private val dao: GameDao by inject(GameDao::class.java)
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        applicationScope.launch {
            BonusItems.values().forEach { item ->
                dao.insertBonus(Item(item.name, 0))
            }
        }
    }
}