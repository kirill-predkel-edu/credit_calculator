package module

import groovy.transform.Field

@Field
test = "Secondfield"

    def callName(env) {
        helloworld()
        return env.toString()
    }

return this