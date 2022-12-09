package module.test

import groovy.transform.Field

@Field
test = "Secondfield"

    def callName(env) {
        helloworld()
        return env.params.toString()
    }

return this