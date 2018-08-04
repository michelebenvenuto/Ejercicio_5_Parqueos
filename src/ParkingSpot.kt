class ParkingSpot(
    val X: Int,
    val Y: Int,
    val Name: String,
    var isOccupied: Boolean= false
){
    fun occupy(){
        isOccupied= true
    }

    override fun toString(): String {
        var stringToReturn=""
        when(isOccupied){
            false-> stringToReturn= Name
            true-> stringToReturn= "@"
        }
        return stringToReturn
    }
}