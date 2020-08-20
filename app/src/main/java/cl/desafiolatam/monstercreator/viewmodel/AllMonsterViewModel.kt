package cl.desafiolatam.monstercreator.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.monstercreator.model.Monster
import cl.desafiolatam.monstercreator.model.MonsterRepository
import cl.desafiolatam.monstercreator.model.db.MonsterRoomDataBase
import kotlinx.coroutines.launch

/**
 * Created by Cristian Vidal on 2019-10-02.
 */
class AllMonsterViewModel(application: Application): AndroidViewModel(application) {

    private var repository: MonsterRepository

    var allMonster: LiveData<List<Monster>>

    init {
        val instanceDao = MonsterRoomDataBase.getDatabase(application).monsterDao()

        repository = MonsterRepository(instanceDao)
        allMonster = repository.allMonster
    }

    fun insertMonsterItem(monsterItem: Monster) = viewModelScope.launch {
        repository.insertMonster(monsterItem)
    }
}