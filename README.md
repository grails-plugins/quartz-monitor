## Branches/Versions

| Branch | Grails Version |
|--------|----------------|
| 2.0.x  | 5              |
| 3.0.x  | 6              |
| 4.0.x  | 7              |

This is a Fork of [James Cookie](https://github.com/jamescookie/quartz-monitor) Grails Quatz Monitor plugin.

# Quartz Monitor Plugin for Grails
Allows you to view and administer all your Quartz jobs in one place.

## Prerequisites
This plugin requires the [Quartz](http://grails.org/plugin/quartz) and [Asset Pipeline](http://grails.org/plugin/asset-pipeline) plugins to run.

## Usage
Once you have the Quartz plugin installed and have created some jobs, then you will probably start wondering if they are all running as desired.
This is where you need the 'Quartz Monitor' plugin.
Simply install the plugin and go to the URL: http://localhost:8080/<yourapp>/quartz and you will find all a list of all the jobs you have scheduled to run.

## Enhanced Experience
To have the page keep you constantly up to date requires [jQuery](http://grails.org/plugin/jquery). It will still work without jQuery, but it won't look as good.

## Configuration
There are various configuration options, all start with `quartz.monitor`:

### layout
Allows you to change the sitemesh layout that page will use. Defaults to 'main'.

### showJobNames
If this is set to true, then the names of the job will be shown in the list.

### showTriggerNames
If this is set to true, then the names of the triggers will be shown in the list - useful if you have multiple triggers for the same job.

### showCountdown
Will add javascript to the page in order to show a countdown to when the job will fire next, unless this is set to 'false'.

### showTickingClock
Will add javascript to the page in order to show a clock with the current time, unless this is set to 'false'.

#### Examples 
Set config in application.yml similar to this.
```
quartz:
    monitor:
        showJobNames: false
        showTriggerNames: true
        showCountdown: true
        showTickingClock: true
        layout: main
      autoStartup: true
      waitForJobsToCompleteOnShutdown: true
      exposeSchedulerInRepository: false
      threadPool:
            class: 'org.quartz.simpl.SimpleThreadPool'
            threadCount: 3
            threadPriority: 5 
 ```
