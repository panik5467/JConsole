package com.cleantutorials.jconsole.jmx;


import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class RegisterMyMBean {
	public static void main(String[] args) throws MalformedObjectNameException,
			InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException {

		MBeanServer server = ManagementFactory.getPlatformMBeanServer(); // Get the MBean Server instance.

		ObjectName name = new ObjectName("JMXTutorialMBean:type=JMXTutorial"); // Create a unique Object Name.
		JMXTutorial tutorial = new JMXTutorial(); 

		server.registerMBean(tutorial, name); // Register the MBean with the MBean Server.
		try {
			Thread.sleep(360000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}