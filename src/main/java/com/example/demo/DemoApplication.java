
package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    class HelloWorldController {

        @Value("${greeting:Hello}")
        private String greeting;

        @GetMapping("/hello/{name}")
        public String hello(@PathVariable String name) {
            return "Hello " + name + "!\n";
        }

        @GetMapping("/hostname")
        public String hostname() throws UnknownHostException {
            String hn = InetAddress.getLocalHost().getHostName();
            return greeting + " from " + hn + "\n";
        }
    }
}
