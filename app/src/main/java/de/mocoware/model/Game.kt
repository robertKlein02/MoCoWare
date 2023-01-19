package de.mocoware.model

import android.app.appsearch.StorageInfo
import de.mocoware.model.minigames.MiniGame
import de.mocoware.model.minigames.TestMinigame

import kotlin.random.Random

enum class MiniGameEnum{
    TestMinigame
}

class Game (private val name: String, private val rounds: Int = 5){

    private var gameId = generateGameId()

    private val miniGames = mutableListOf<MiniGame>()

    var currentGame = 0

    init {
        addMinigames(rounds)
    }

    private fun generateGameId() : String{
        var newID = ""
        val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        repeat(4){
            newID += charPool[Random.nextInt(charPool.size)]
        }
        return newID
    }

    fun getID() : String{
        return gameId
    }

    fun getName() : String{
        return name
    }

    fun getCurrentGame() : MiniGame{
        return miniGames[currentGame]
    }

    fun nextGame(){
        currentGame++
    }

    fun addMinigames(amount: Int){
        miniGames.clear()
        val miniGameEnumValues = MiniGameEnum.values()
        val nextMinigame = miniGameEnumValues[Random.nextInt(MiniGameEnum.values().size)]
        repeat(amount){
            when(nextMinigame){
                MiniGameEnum.TestMinigame -> miniGames.add(TestMinigame())
            }
        }
    }

}