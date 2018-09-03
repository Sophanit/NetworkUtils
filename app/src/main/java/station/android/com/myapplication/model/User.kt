package station.android.com.myapplication.model

class User {
    var isParent: Boolean = false
    var name: String? = ""

    constructor()

    constructor(name: String) {
        this.name = name
    }

    fun toParent(): Boolean {
        isParent = true
        return isParent
    }
}