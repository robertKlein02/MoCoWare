package de.testjens.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class AvailableGame(val name: String, val gameID: String)

class GameList () {

    private val games = mutableListOf<Game>()

    fun addGame(newGame: Game){
        games.add(newGame)
    }

    fun getAvailableGames() : List<AvailableGame>{
        val list = mutableListOf<AvailableGame>()
        games.forEach{ each ->
            list.add(AvailableGame(each.name, each.getID()))
        }
        return list.toList()
    }
}