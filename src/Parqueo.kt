import javafx.scene.control.ProgressIndicator

class Parqueo(
        val Niveles: ArrayList<Nivel> = ArrayList()
){
    fun findNivelbyIndicator(indicator: String):Nivel?{
        val filteredNivel= Niveles.filter { it.Indicator==indicator }
        if (filteredNivel.count() > 0){
            return filteredNivel[0]
        }
        return null
    }
    fun findNivelbyName(name: String):Nivel?{
        val filteredNivel= Niveles.filter { it.Name==name }
        if (filteredNivel.count() > 0){
            return filteredNivel[0]
        }
        return null
    }
    fun findNivelbyColor(color: String):Nivel?{
        val filteredNivel= Niveles.filter { it.Color==color }
        if (filteredNivel.count() > 0){
            return filteredNivel[0]
        }
        return null
    }
    fun addNivel(nivel: Nivel): Boolean{
        if ( findNivelbyIndicator(nivel.Indicator)== null && findNivelbyName(nivel.Name)== null && findNivelbyColor(nivel.Color)== null ){
            Niveles.add(nivel)
            return true
        }
        return false
    }
    fun removeNivel(nivelIndicator: String): Boolean{
        var nivelToRemove= this.findNivelbyIndicator(nivelIndicator)
        if (nivelToRemove!= null){
            Niveles.remove(nivelToRemove)
            return true
        }
        return false
    }
    fun getNivelWithSpace(): ArrayList<Nivel>{
        var nivelesWithSpace= ArrayList<Nivel>()
        for (Nivel in Niveles){
            for (ParkingSpot in Nivel.ParkingSpots){
                if(!ParkingSpot.isOccupied){
                    nivelesWithSpace.add(Nivel)
                }
            }
        }
        return nivelesWithSpace
    }


}