package module

class FirstScript implements Serializable {
    def scriptField

    FirstScript(def scriptField) {
        this.scriptField = scriptField
    }
    def a() {
        return scriptField
    }
}