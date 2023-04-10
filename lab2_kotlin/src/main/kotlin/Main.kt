import javax.naming.Name

var list = arrayListOf<String>()

fun main(args: Array<String>) {
    val oleg = Volleyball("Олежа", 19)
    oleg.info()
    oleg.playingByArms("+")
    val david = Basketball("Давид", "баскетбол")
    david.info()
    david.playingByArms("+")
    val egor = Football(16, "футболист")
    egor.info()
    val lev = Volleyball("Лева", 19)
    lev.info()

    fun WhoIsVolleyballPlayer(list:ArrayList<String>){
        for (n in list){
            println("$n - волейболист")
        }
    }

    WhoIsVolleyballPlayer(list)

}


abstract class Sportsman(Name:String, Age:Int){
    protected var name: String
    protected var age: Int
    //
    init{
        name = Name
        age = Age
    }


    abstract fun info()
}


class Volleyball(Name: String, Age: Int, KOS: String):Sportsman(Name, Age), MyInterface{
    private var KindOfSport: String
    override var byArms: String = ""

    init{
        KindOfSport = KOS
        list.add(name)
    }
    constructor(Name: String, Age: Int):this(Name, Age, "Undefined"){

    }

    override fun playingByArms(byArms: String) {
        if(byArms == "+"){
            println("$KindOfSport играет руками")
        }
        else{
            println("$KindOfSport играет ногами")
        }
    }

    override fun info() {
        println("Имя: $name, возраст: $age, спорт: $KindOfSport ")
    }
}

class Basketball(Name: String, Age: Int, KOS: String,):Sportsman(Name, Age), MyInterface{
    private var KindOfSport: String
    override var byArms: String = ""

    init{
        KindOfSport = KOS
    }
    constructor(Name: String, KOS: String):this(Name,0, KOS){

    }

    override fun playingByArms(byArms: String) {
        if(byArms == "+"){
            println("$KindOfSport играет руками")
        }
        else{
            println("$KindOfSport играет ногами")
        }
    }

    override fun info() {
        println("Имя: $name, возраст: $age, спорт: $KindOfSport ")
    }
}

class Football(Name: String, Age: Int, KOS: String):Sportsman(Name, Age){
    private var KindOfSport: String

    init{
        KindOfSport = KOS
    }
    constructor(Age:Int, KOS: String):this("Аноним", Age, KOS){

    }

    override fun info() {
        println("Имя: $name, возраст: $age, спорт: $KindOfSport ")
    }
}


interface MyInterface{
    var byArms: String

    fun playingByArms(byArms:String)
}


