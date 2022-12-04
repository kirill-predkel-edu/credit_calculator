package script

class FirstScript {
    def a() {
        return "first"
    }
}

class SecondScript {
    def a() {
        return "second"
    }
}

Object getProperty(String name){
    return this.getClass().getClassLoader().loadClass(name)
}

return this