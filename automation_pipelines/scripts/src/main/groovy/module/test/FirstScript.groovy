package module.test

class FirstScript implements Serializable {
    def scriptField

    FirstScript(def scriptField) {
        this.scriptField = scriptField.DEFAULT_VERSION
    }
    def a() {
        return scriptField
    }
}