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

    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {
        System.out.println("daemonContext = " + daemonContext);

    }

    public void start() throws Exception {
        System.out.println("start....");
    }

    public void stop() throws Exception {
        System.out.println("stop....");
    }


    public void destroy() {
        System.out.println("destory....");
    }
}
