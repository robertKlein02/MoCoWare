package de.mocoware.viewmodel

import androidx.lifecycle.ViewModel
import de.mocoware.model.Game
import de.mocoware.model.MiniGameTimer
import de.mocoware.view.navigation.NavMG


class GameViewModel : ViewModel(){

    var game = Game("Bla")

    var currentMG = game.getCurrentGame()

    var currentGameData = currentMG.gameData

//    val gameDataLive = MutableLiveData<GameData>()

    var routeToMG = currentMG.gameRoute

//    init {
//        gameDataLive.postValue(currentGameData)
//
//        setSpeed(0.0)
//        setTime(30)
//    }

//    fun updateGamedata(){
//        gameDataLive.postValue(currentGameData)
//    }

    fun finishGame(){

        miniGameTimer._time.postValue(10)
        miniGameTimer._isTimeUp.postValue(false)
        miniGameTimer.timer.cancel()

        val nextGame = game.nextGame()
        currentMG = game.getCurrentGame()
        currentGameData = currentMG.gameData
        if(nextGame){
            routeToMG = game.routeToNextMG()
        }else{
            routeToMG = NavMG.Lobby.route
        }
        println("                                                                    $routeToMG")

//        updateGamedata()
    }

    val miniGameTimer = MiniGameTimer()

//        fun setTime(int: Int){
//        _timer.postValue(int)
//
//    }




























//
//
//
//    inner class Receiver: BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            val speed = Objects.requireNonNull(intent.extras)?.getDouble("speed")
//
//            val axisX = Objects.requireNonNull(intent.extras)?.getFloat("axisX")
//            val axisY = Objects.requireNonNull(intent.extras)?.getFloat("axisY")
//            val axisZ = Objects.requireNonNull(intent.extras)?.getFloat("axisZ")
//
//            if (speed != null) {
//                setSpeed(speed)
//            }
//
//            if(axisX != null && axisY!=null && axisZ != null){
//                setAcc(axisX,axisY,axisY)
//
//            }
//        }
//    }
//
//
//    private val _speed : MutableLiveData<Double> = MutableLiveData<Double>()
//    var speed : LiveData<Double> = _speed
//
//    private val _accel: MutableLiveData<Array<Float>> = MutableLiveData<Array<Float>>()
//    var accel:LiveData<Array<Float>> = _accel
//
//////    private var game : Game = Game("anusBenus")
////    private val _game : MutableLiveData<Game> = MutableLiveData<Game>(game)
////    val liveGame : LiveData<Game> = _game
//
//    // Maximale beschleunigungswerte
//    var maxXwet=0.0f
//    var maxYwet=0.0f
//    var maxZwet=0.0f
//
////    init {
////        setSpeed(0.0)
////        setTime(30)
////    }
//
////    fun withGame(newGame: Game): GameViewModel{
////        setGame(newGame)
////        return this
////    }
//
////    fun setGame(newGame: Game){
////        game = newGame
////        _game.postValue(game)
////    }

//
//    fun setSpeed(double: Double){
//        _speed.postValue(double)
//    }
//
//    fun setAcc(floatX: Float,floatY: Float,floatZ: Float){
//
//        if (floatX>maxXwet) {
//            maxXwet=floatX
//            _accel.postValue(arrayOf(maxXwet,maxYwet,maxZwet))
//        }
//        if (floatY>maxYwet) {
//            maxYwet=floatY
//            _accel.postValue(arrayOf(maxXwet,maxYwet,maxZwet))
//        }
//        if (floatZ>maxZwet) {
//            maxZwet=floatZ
//            _accel.postValue(arrayOf(maxXwet,maxYwet,maxZwet))
//        }
//    }
//

//
//    fun getCurrentGameName(): String{
//        return GameConnection?.getCurrentGameName() ?: "NoCurrentGame"
//    }
//
//    fun getCurrentGameID(): String{
//        return GameConnection?.getCurrentGameID() ?: "NONE"
//    }
}

