# http-benchmark
benchmarking few java based web frameworks

# Frameworks and Benchmarks
The frameworks are arranged in the order of the best to worst in terms of average request latency(ms),
and the total number of requests served. The benchmark is done using the "wrk" tool.

## Load generation

The load generation setup is as follows:

    12 threads
    400 connections
    30s duration

    wrk -t12 -c400 -d30s http://192.168.56.101:8080/ping
    
## Benchmarks

1. Undertow:

       Thread Stats   Avg      Stdev     Max   +/- Stdev
         Latency    13.87ms   15.06ms 311.70ms   92.20%
         Req/Sec     1.63k     1.17k    4.41k    54.78%
       579742 requests in 30.09s, 71.32MB read
       Socket errors: connect 155, read 0, write 0, timeout 0
       Requests/sec:  19266.93
       Transfer/sec:      2.37MB
   

2. Vert.X

        Thread Stats   Avg      Stdev     Max   +/- Stdev
            Latency    25.28ms    8.40ms 236.80ms   84.20%
            Req/Sec   799.90    535.93     2.67k    53.64%
        286702 requests in 30.10s, 18.59MB read
        Socket errors: connect 155, read 0, write 0, timeout 0
        Requests/sec:   9524.69
        Transfer/sec:    632.50KB
   

3. Springboot with Undertow

       Thread Stats   Avg      Stdev     Max   +/- Stdev
           Latency    97.88ms   49.60ms 595.19ms   81.97%
           Req/Sec   252.10    141.59   660.00     61.27%
       74501 requests in 30.10s, 10.16MB read
       Socket errors: connect 155, read 0, write 0, timeout 0
       Requests/sec:   2474.98
       Transfer/sec:    345.63KB 
       

4. Springboot with Tomcat

       Thread Stats   Avg      Stdev     Max   +/- Stdev
           Latency   170.16ms  219.35ms   1.95s    86.14%
           Req/Sec   193.11     99.54   585.00     67.91%
       50592 requests in 30.11s, 5.65MB read
       Socket errors: connect 155, read 0, write 0, timeout 6
       Requests/sec:   1680.47
       Transfer/sec:    192.26KB
       
