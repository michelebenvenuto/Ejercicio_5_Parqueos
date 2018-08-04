class Nivel(
        val Name: String,
        val Indicator: String,
        val Color: String,
        val MapLocation: String,
        val Height: Int,
        val Width: Int,
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
    fun showLocation(user: Users):String?{
        if (findUser(user.licensePlate)!= null){
            return user.currentNivel.toString()
        }
        return null
    }
    //preguntar si este metodo esta bien en esto
    fun mapLayout(readMap: ArrayList<String>):String{
        var finalString=""
        for(row in readMap.indices){
            for (column in readMap.get(0).indices){
               var toEvaluate=readMap.get(row)[column].toString()
                when(toEvaluate){
                    " "->finalString+=" "
                    "*"->finalString+="*"
                }
            }
            finalString+="\n"
        }
        return finalString
    }

    override fun toString(): String {
        return """
            Name: $Name
            Indicator: $Indicator
            Color : $Color
            """.trimIndent()
    }
}