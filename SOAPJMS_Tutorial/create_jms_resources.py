#
# create_jms_resources.py - this wsadmin script is used to create the JMS resources
#                           that are required for the SOAP/JMS tutorial.
#

# Create an SI Bus and return it to the caller.
def createSIBus (busName):
	bus = AdminTask.createSIBus(["-bus", busName])
	print "Created SI Bus " + bus
	
	cell=AdminConfig.showAttribute(AdminConfig.list("Cell"), "name")
	node=AdminConfig.showAttribute(AdminConfig.list("Node"), "name")
	server=AdminConfig.showAttribute(AdminConfig.list("Server"), "name")
	
	AdminTask.addSIBusMember(["-bus", busName, "-node", node, "-server", server])
	print "Added " + node + "/" + server + " to SI Bus"
	
	return bus
	
# Create an SI Bus destination and return it to the caller.
def createSIBDestination(siBus, sibDstName, sibDstType):
	cell=AdminConfig.showAttribute(AdminConfig.list("Cell"), "name")
	node=AdminConfig.showAttribute(AdminConfig.list("Node"), "name")
	server=AdminConfig.showAttribute(AdminConfig.list("Server"), "name")
	
	dest = AdminTask.createSIBDestination(["-bus", siBus, "-name", sibDstName, "-type", sibDstType, "-node", node, "-server", server])
	print "Created SI Bus Destination " + sibDstName + " on " + siBus
	return dest
	
# Create a JMS Connection Factory and return it to the caller.
def createJMSConnectionFactory (siBus, scope, jmsCFName, jmsCFJNDI, jmsCFType, desc):
	params=["-name", jmsCFName, "-jndiName", jmsCFJNDI, "-type", jmsCFType, "-busName", siBus, "-description", desc]
	cf=AdminTask.createSIBJMSConnectionFactory(scope, params)
	print "Created JMS ConnectionFactory " + jmsCFName + " on " + siBus
	return cf
	
# Create a Queue and return it to the caller
def createJMSQueue (scope, jmsQName, jmsQJNDI, desc, SIBQName):
	params = ["-name", jmsQName, "-jndiName", jmsQJNDI, "-description", desc, "-queueName", SIBQName]
	q=AdminTask.createSIBJMSQueue(scope, params)
	print "Created JMS Queue " + jmsQName + " on " + siBus
	return q

# Function to create a JMS Action Spec
#	
def createJMSActivationSpec(siBus, scope, specName, specJndiName, destJndi, destType, desc):
	params= ["-name", specName, "-jndiName", specJndiName, "-busName", siBus, "-destinationJndiName", destJndi, "-destinationType", destType, "-description", desc]
	jas = AdminTask.createSIBJMSActivationSpec(scope, params)
	print "Created JMS Activation Spec " + specName + " on " + siBus
	return jas
	
# Begin Setup JMS
print "Creating JMS resources required by the SOAP/JMS Tutorial"

cell=AdminConfig.showAttribute(AdminConfig.list("Cell"), "name")
node=AdminConfig.showAttribute(AdminConfig.list("Node"), "name")
siBus="SJT_Bus"
scope = AdminConfig.getid("/Node:" + node + "/")

# Create the SI Bus
createSIBus(siBus)

# Create the Queues, Connection Factory, and ActivationSpec
createJMSConnectionFactory(siBus, scope, "SJT_CF", "jms/SJT_CF", "Queue", "SOAP/JMS Tutorial Connection Factory")
createJMSConnectionFactory(siBus, scope, "WebServicesReplyQCF", "jms/WebServicesReplyQCF", "Queue", "Connection Factory used by Web Services MDB class")
createJMSQueue(scope, "SJT_Request_Q", "jms/SJT_Request_Q", "SOAP/JMS Tutorial Request Queue", "SJT_SIB_Request_Q")
createJMSQueue(scope, "SJT_Reply_Q", "jms/SJT_Reply_Q", "SOAP/JMS Tutorial Reply Queue", "SJT_SIB_Reply_Q")
createJMSActivationSpec(siBus, scope, "SJT_ActivationSpec", "eis/SJT_ActivationSpec", "jms/SJT_Request_Q", "javax.jms.Queue", "SOAP/JMS Tutorial Activation Spec")
createSIBDestination(siBus, "SJT_SIB_Request_Q", "Queue")
createSIBDestination(siBus, "SJT_SIB_Reply_Q", "Queue")

# Save configuration
print "Saving configuration..."
AdminConfig.save()

print "Finished..."
