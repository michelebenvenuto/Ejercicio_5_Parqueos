import java.io.File
import java.io.InputStream

class Nivel(
        val Name: String,
        val Indicator: String,
        val Color: String,
        var Width: Int=0,
        var Height: Int=0,
        val MapLocation: String,
        val Users: ArrayList<Users> = ArrayList(),
        val ParkingSpots: ArrayList<ParkingSpot> = ArrayList(),
        val Walls: ArrayList<Wall> = ArrayList()

){
    fun getWallAt(X: Int,Y: Int):Wall?{
        for(wall in Walls){
            if (wall.X==X && wall.Y== Y){
                return wall
            }
        }
        return null
    }
    fun hasWallAt(X: Int, Y:Int): Boolean{
        for(wall in Walls){
            if(wall.X==X && wall.Y== Y){
                return true
            }
        }
        return false
    }
    fun getParkingSpotAt(X: Int,Y: Int):ParkingSpot?{
        for(ParkingSpot in ParkingSpots){
            if (ParkingSpot.X==X && ParkingSpot.Y== Y){
                return ParkingSpot
            }
        }
        return null
    }
    fun hasParkingSpotAt(X: Int, Y:Int): Boolean{
        for(ParkingSpot in ParkingSpots){
            if(ParkingSpot.X==X && ParkingSpot.Y== Y){
                return true
            }
        }
        return false
    }
    fun findUser(licensePlate: String): Users?{
        val filteredUser = Users.filter { it.licensePlate == licensePlate}
        if (filteredUser.count()> 0){
            return filteredUser[0]
        }
        return null
    }
    fun addUser(user: Users):Boolean{
        if(findUser(user.licensePlate)==null){
            Users.add(user)
            return true
        }
        return false
    }
    fun findParkingSpot(Name: String): ParkingSpot?{
        val filteredSpot = ParkingSpots.filter { it.Name == Name}
        if (filteredSpot.count()> 0){
            return filteredSpot[0]
        }
        return null
    }
    fun addParkingSpot(parkingSpot: ParkingSpot):Boolean{
        if(findUser(parkingSpot.Name)==null){
            ParkingSpots.add(parkingSpot)
            return true
        }
        return false
    }
    //preguntar si este metodo esta bien aqui
    fun createMap(readMap: ArrayList<String>): Boolean {
        var succes=true
        var verifyingString= ArrayList<String>()
        this.Height = readMap.size
        this.Width = readMap.get(0).length
        for (row in readMap.indices) {
            for (column in readMap.get(0).indices) {
                var toEvaluate = readMap.get(row)[column].toString()
                if (toEvaluate == "*") {
                    var newWall = Wall(column, row)
                    Walls.add(newWall)
                } else if (toEvaluate.toIntOrNull() != null) {
                    var newParkingSpot = ParkingSpot(Name = toEvaluate, X = column, Y = row)
                    ParkingSpots.add(newParkingSpot)
                    verifyingString.add(toEvaluate)
                } else if(toEvaluate!=" "){
                    var anotherParkingSpot = ParkingSpot(Name = toEvaluate, X = column, Y = row)
                    ParkingSpots.add(anotherParkingSpot)
                    verifyingString.add(toEvaluate)
                }
            }
            if (verifyingString.distinct().size< verifyingString.size){
                succes=false
            }
        }
        return succes
    }
    fun getMapFromLocation(location:String):ArrayList<String>{
        var mapArray= ArrayList<String>()
        val inputStream: InputStream = File(location).inputStream()
        val lineList= mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines-> lines.forEach { lineList.add(it) } }
        lineList.forEach{mapArray.add(it)}
        return mapArray
    }
    fun mapString():String{
        var stringToReturn=""
        for(row in 0..Height){
            for (Column in 0..Width){
                if(hasParkingSpotAt(Column,row)){
                    var parkingSpot= getParkingSpotAt(Column,row)
                    stringToReturn+=parkingSpot
                }
                else if (hasWallAt(Column,row)){
                    var wall= getWallAt(Column,row)
                    stringToReturn+=wall
                }
                else{
                    stringToReturn+=" "
                }
            }
            stringToReturn+="\n"
        }
        return stringToReturn
    }

    override fun toString(): String {
        return """
            Nivel:
                Name: $Name
                Indicator: $Indicator
                Color : $Color
                """.trimIndent()
    }
}