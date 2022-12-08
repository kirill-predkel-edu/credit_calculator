package module

import groovy.transform.Field

@Field
test = "Secondfield"

    def callName(env) {
        helloworld()
        return env.env.toString()
    }

return this