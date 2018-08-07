fun main(args: Array<String>){
    var menuToDisplay=0
     val menu1= """
         Menu:
            1)Administrador
            2)Conductor
            3)Salir
         """.trimIndent()
    val menu2= """
        Menu:
            1)Crear un nivel
            2)Eliminar nivel
            3)Ver todos los niveles
            4)Salir (Regresa a menu principal)
        """.trimIndent()
    val menu3="""
        Menu:
            1)Ingresar Placa
            2)Salir (Regresa a menu principal)
        """.trimIndent()
    var wantsToContinue= true
    val myParqueo= Parqueo()
    do {
        if (menuToDisplay==0){
            println(menu1)
            print("Escoja una opcion del menu: ")
            var opcion= readLine()!!.toIntOrNull()
            when(opcion){
                1-> menuToDisplay=1
                2->menuToDisplay=2
                3->wantsToContinue=false
                else-> println("Esta opcion no es parte del menu") }
        }
        if (menuToDisplay==1){
            println(menu2)
            print("Escoja una de las opciones del menu")
            var opcion= readLine()!!.toIntOrNull()
            when(opcion){
                1->{
                    println("Ingrese los siguientes daots del nivel: ")
                    print("Nombre: ")
                    var nombre= readLine()!!
                    print("Identificador: ")
                    var identificador= readLine()!!
                    print("Color:")
                    var color= readLine()!!
                    print("Archivo de estructura: ")
                    var archivo= readLine()!!
                    if (myParqueo.findNivelbyName(nombre)!=null || myParqueo.findNivelbyIndicator(identificador)!=null || myParqueo.findNivelbyColor(color)!=null){
                        println("Ya existe un nivel con ese nombre, identficador, o color")
                    }
                    var newNivel= Nivel(nombre,identificador,color,MapLocation = archivo)
                    if(!newNivel.createMap(newNivel.getMapFromLocation(archivo))){
                        println("Este Mapa tiene parqueos con identificadores iguales, No se puede crear")
                    }
                    else{
                        myParqueo.addNivel(newNivel)
                        println("El nivel se ha agregado con exito")
                    }
                }
                2->{
                    print("Ingrese el identificador del nivel que desea quitar: ")
                    var toRemove= readLine()!!
                    if (myParqueo.findNivelbyIndicator(toRemove)==null){
                        println("No existe un nivel con ese identificador")
                    }else{
                        myParqueo.removeNivel(toRemove)
                        println("Se ha removido el nivel con identificador $toRemove con exito") }
                }
                3->{
                    if(myParqueo.Niveles.size==0){
                        println("El parqueo no tiene niveles")
                    }else{
                    for (nivel in myParqueo.Niveles){
                        println(nivel)
                        println(nivel.mapString()) }}
                }
                4->menuToDisplay=0
                else-> println("Esta opcion no esta en el menu") }
        }
        if (menuToDisplay==2){
            println(menu3)
            println("Escoga una de las opciones del menu:")
            var opcion = readLine()!!.toIntOrNull()
            when(opcion){
                1->{
                    print("Ingrese la placa de su vehículo: ")
                    var placa= readLine()!!
                    var NivelWithSpace=myParqueo.getNivelWithSpace()
                    if (myParqueo.findNivelThatContainsAUser(placa)!=null){
                        println(myParqueo.findNivelThatContainsAUser(placa))
                        println(myParqueo.findNivelThatContainsAUser(placa)!!.mapString())
                    }else{
                        for (nivel in NivelWithSpace){
                            println(nivel)
                        }
                        print("Escriba el indicador del nivel que quiera escoger: ")
                        var indicador= readLine()!!
                        var nivelToShow= myParqueo.findNivelbyIndicator(indicador)
                        if (nivelToShow==null){
                            println("El nivel con indicador $indicador no se puede escoger (no existe o esta lleno")
                        }else{
                            println(nivelToShow.mapString())
                            print("Escoga el parqueo que quiera escoger: ")
                            var pickedParkingSpot= readLine()!!
                            if (nivelToShow.findParkingSpot(pickedParkingSpot)==null){
                                println("Un parqueo con ese nombre no existe")
                            }else{
                                nivelToShow.addUser(Users(placa))
                                nivelToShow.findParkingSpot(pickedParkingSpot)!!.occupy()
                                println("El parqueo $pickedParkingSpot se ha ocupado")
                            }
                        }
                    }
                }
                2-> menuToDisplay=0
            }
        }
    }while (wantsToContinue)
}