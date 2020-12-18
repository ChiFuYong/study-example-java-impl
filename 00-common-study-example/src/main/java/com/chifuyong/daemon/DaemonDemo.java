package com.chifuyong.daemon;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

/**
 * Test Daemon
 *
 * @date： 2020/4/17
 * @author: chify
 */
public class DaemonDemo implements Daemon {

    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {
        System.out.println("daemonContext = " + daemonContext);

    }

    @Override
    public void start() throws Exception {
        System.out.println("start....");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop....");
    }


    @Override
    public void destroy() {
        System.out.println("destory....");
    }
}
