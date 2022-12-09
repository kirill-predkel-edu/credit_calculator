package module

import groovy.transform.Field

@Field
test = "{$DEFAULT_VERSION}"

    def callName(env) {
        helloworld()
        return env.params.toString()
    }

return this