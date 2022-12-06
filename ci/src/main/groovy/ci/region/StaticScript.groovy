package ci.region

import groovy.transform.Field

static def getStaticString() {
    return "test jenkins file is running"
}

@Field
String name = "test jenkins file is running"

return this