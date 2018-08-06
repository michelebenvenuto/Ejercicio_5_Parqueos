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
            4)Salir
        """.trimIndent()
    val menu3="""
        Menu:
            1)Ingresar Placa
            2)Salir
        """.trimIndent()
    var wantsToContinue= true
    val myParqueo= Parqueo()
    do {
        if (menuToDisplay==0){
            println(menu1)
            print("Escoja una opcion del menu:")
            var opcion= readLine()!!.toIntOrNull()
            when(opcion){
                1-> menuToDisplay=1
                2->menuToDisplay=2
                3->wantsToContinue=false
                else-> println("Esta opcion no es parte del menu")
            }
        }
        if (menuToDisplay==1){
            println(menu2)
            print("Escoja una de las opciones del menu")
            var opcion= readLine()!!.toIntOrNull()
            when(opcion){
                1->{
                    println("Ingrese los siguientes daots del nivel:")
                    print("Nombre:")
                    var nombre= readLine()!!
                    print("Identificador:")
                    var identificador= readLine()!!
                    print("Color:")
                    var color= readLine()!!
                    print("Archivo de estructura:")
                    var archivo= readLine()!!
                    if (myParqueo.findNivelbyName(nombre)==null || myParqueo.findNivelbyIndicator(identificador)==null || myParqueo.findNivelbyColor(color)==null){
                        println("Ya existe un nivel con ese nombre, identficador, o color")
                    }else{
                        var newNivel= Nivel(nombre,identificador,color,MapLocation = archivo)
                        myParqueo.addNivel(newNivel)
                        println("El nivel se ha agregado con exito")
                    }
                }
                2->{
                    print("Ingrese el identificador del nivel que desea quitar:")
                    var toRemove= readLine()!!
                    if (myParqueo.findNivelbyIndicator(toRemove)==null){
                        println("No existe un nivel con ese identificador")
                    }else{
                        myParqueo.removeNivel(toRemove)
                        println("Se ha removido el nivel con identificador $toRemove con exito")
                    }
                }
                3->{
                    for (nivel in myParqueo.Niveles){
                        println(nivel)
                        println(nivel.mapString())
                    }
                }
                4->wantsToContinue=false
            }
        }
    }while (wantsToContinue)
}