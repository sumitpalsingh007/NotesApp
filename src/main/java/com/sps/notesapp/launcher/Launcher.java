package com.sps.notesapp.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * The annotation to convert your program into a spring boot application.
 */

@SpringBootApplication
@ComponentScan({ "com.sps.notesapp.controller", "com.sps.notesapp.service" })
public class Launcher {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        SpringApplication.run(Launcher.class, args);
    }
}
