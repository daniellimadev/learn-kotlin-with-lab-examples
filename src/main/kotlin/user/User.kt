package user

data class User(var idUser: Int, var nameUser: String, var typeUser: String) { //User Class

    constructor() : this(0, "","") //Empty constructor of the class

    override fun toString(): String { //Customization of the instantiated User display
        return "ID: $idUser | NAME: $nameUser | TYPE: $typeUser"
    }

}