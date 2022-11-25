package com.crazyfly;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NameService {

    private static final Logger LOG = Logger.getLogger(NameService.class);


    public void myName(){
        LOG.info("my name is NameService.");
    }

}
