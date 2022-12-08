package module

import groovy.transform.Field

@Field
test = "Secondfield"

    def callName(modular) {
        helloworld()
        return modular.modular.name
    }

return this