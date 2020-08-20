package cl.desafiolatam.monstercreator.model

import androidx.lifecycle.LiveData
import cl.desafiolatam.monstercreator.model.db.MonsterDao

/**
 * Created by Cristian Vidal on 2019-09-26.
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class MonsterRepository(private val monsterDao: MonsterDao) {

    val allMonster: LiveData<List<Monster>> = monsterDao.getAllMonsters()

    suspend fun insertMonster(monsterItem: Monster){
        monsterDao.insertMonster(monsterItem)
    }

}