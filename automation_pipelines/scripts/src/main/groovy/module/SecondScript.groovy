package module

import groovy.transform.Field

@Field
test = "Secondfield"

    def a() {
        latam.helloworld()
        return "second"
    }

return this