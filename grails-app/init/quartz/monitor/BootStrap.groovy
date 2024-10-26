package quartz.monitor

class BootStrap {

    def init = { servletContext ->
        println "-----new plugin for grails 5 quartz monitor 1.4----------------------"
    }
    def destroy = {
    }
}
