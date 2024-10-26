package grails.plugins.quartzmonitor

import grails.plugins.quartz.QuartzMonitorJobFactory

class QuartzMonitorGrailsPlugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "5.3.6 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Quartz Monitoring" // Headline display name of the plugin
    def author = "Arjang Chinichian"
    def authorEmail = "arjangch@gmail.com"
    def description = '''\
a copy of quartz-monitor but adapted to Grails 5.3.6
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/quartz-monitoring"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GITHUB", url: "https://github.com/arjangch/quartz-monitor/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/arjangch/quartz-monitor" ]

    def loadAfter = ['quartz']

    Closure doWithSpring() {
//        {->
//            // TODO Implement runtime spring config (optional)
//        }
        quartzJobFactory(QuartzMonitorJobFactory) {
            if (manager?.hasGrailsPlugin("hibernate") || manager?.hasGrailsPlugin("hibernate4")) {
                sessionFactory = ref("sessionFactory")
            }
            pluginManager = ref("pluginManager")
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
