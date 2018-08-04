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
        return true
    }
    fun removeNivel(nivel: Nivel): Boolean{
        if ( findNivelbyIndicator(nivel.Indicator)!= null ){
            Niveles.remove(nivel)
            return true
        }
        return true
    }


}