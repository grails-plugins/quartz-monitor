package grails.plugins.quartzmonitor

import grails.plugins.quartz.QuartzMonitorJobFactory

class QuartzMonitorGrailsPlugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "7.0.0-SNAPSHOT > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Quartz Monitor Grails Plugin" // Headline display name of the plugin
    def author = "Arjang Chinichian"
    def authorEmail = "arjangch@yahoo.com"
    def description = '''\
a copy of quartz-monitor but adapted to Grails 5.3.6
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/quartz-monitoring"

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GITHUB", url: "https://github.com/arjangch/quartz-monitor/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/arjangch/quartz-monitor" ]

    def loadAfter = ['quartz']

    Closure doWithSpring() {
        quartzJobFactory(QuartzMonitorJobFactory) {
            if (manager?.hasGrailsPlugin("hibernate") || manager?.hasGrailsPlugin("hibernate4")) {
                sessionFactory = ref("sessionFactory")
            }
            pluginManager = ref("pluginManager")
        }
    }



}
