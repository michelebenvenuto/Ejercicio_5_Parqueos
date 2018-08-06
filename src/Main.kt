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
        }
    }while (wantsToContinue)
}