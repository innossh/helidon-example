# helidon-example

## Getting started

Build a docker image and run it with Docker Compose.

```console
$ ./gradlew build :helidon-example-metrics:assemble
$ docker build -t helidon-example-metrics metrics/build/libs
$ ./gradlew build :composeUp
```

Then you can show the greet response and metrics.

```console
$ curl -s 127.0.0.1:8080/greet
Hello World!
$ curl -s 127.0.0.1:8080/metrics
# TYPE base:classloader_total_loaded_class_count counter
# HELP base:classloader_total_loaded_class_count Displays the total number of classes that have been loaded since the Java virtual machine has started execution.
base:classloader_total_loaded_class_count 2778
# TYPE base:cpu_system_load_average gauge
# HELP base:cpu_system_load_average Displays the system load average for the last minute. The system load average is the sum of the number of runnable entities queued to the available processors and the number of runnable entities running on the available processors averaged over a period of time. The way in which the load average is calculated is operating system specific but is typically a damped timedependent average. If the load average is not available, a negative value is displayed. This attribute is designed to provide a hint about the system load and may be queried frequently. The load average may be unavailable on some platforms where it is expensive to implement this method.
...
```
