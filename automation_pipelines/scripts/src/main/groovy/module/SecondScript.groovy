package module

import groovy.transform.Field

@Field
test = "Secondfield"

    def a() {
        helloworld()
        return "second"
    }

return this