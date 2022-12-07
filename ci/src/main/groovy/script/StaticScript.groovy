package script

import groovy.transform.Field

class StaticScript {
    static def getStaticString() {
        return "test jenkins file is running"
    }

    String name = "test jenkins file is running"
}


