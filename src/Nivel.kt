
class Nivel(
        val Name: String,
        val Indicator: String,
        val Color: String,
        val MapLocation: String,
        val Users: ArrayList<Users> = ArrayList(),
        val ParkingSpots: ArrayList<ParkingSpot> = ArrayList()

){
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
    fun mapLayout(readMap: ArrayList<String>):String{
        var finalString=""
        for(row in readMap.indices){
            for (column in readMap.get(0).indices){
               var toEvaluate=readMap.get(row)[column].toString()
                if (toEvaluate==" "){
                    finalString+=" "
                }
                else if (toEvaluate=="*"){
                    finalString+="*"
                }
                else if (toEvaluate.toIntOrNull()!= null){
                    var newParkingSpot = ParkingSpot(Name=toEvaluate)
                    ParkingSpots.add(newParkingSpot)
                    finalString+=newParkingSpot
                }
                else{
                    var anotherParkingSpot = ParkingSpot(Name = toEvaluate)
                    ParkingSpots.add(anotherParkingSpot)
                    finalString+=anotherParkingSpot
                }
            }
            finalString+="\n"
        }
        return finalString
    }

    override fun toString(): String {
        return """
            -Nivel:
                Name: $Name
                Indicator: $Indicator
                Color : $Color
                """.trimIndent()
    }
}