            Oracle Coherence .NET Examples
            =======================================================

Contents
========

    * Overview
    * Directory Structure
    * Build Instructions
    * Run Instructions
    * References

Overview
========

 This document describes the source and build system for the Oracle Coherence .NET examples.


Prerequisites
==================
  In order to build the examples, you must have Coherence version 3.6 or later for .NET and Visual Studio 2008
  or later or Visual Studio 2008 Express or later.

  To run the examples, you will need the Java version of Coherence 3.6 or later and a Java 
  development kit (JDK) 1.5 or greater. The Java version is required because the Coherence*Extend proxy and
  cache servers require Java. Also, the examples depend on Java example classes that must be built before running 
  the proxy and cache server. See the Java examples readme.txt for instructions on how to build and run. Note that 
  the Java run-proxy script must be executed; the Java run-cache-server is optional because the proxy is storage
  enabled.

Directory Structure
======================

  The directory structure described below is relative to ..\examples\

  dotnet\src

    All example source. The examples are in the Tangosol.Examples.<example name> namespace. The classes
    for objects stored in the cache are in the Tangosol.Examples.Pof namespace.
    
    The examples are in the Visual Studio 2008 examples solution. Each example has its own Visual Studio 2008 
    project in the src directory. For example, src contains projects for the contacts and security examples
    The coherence configuration files required by the example.

   src\pof\config
     The common coherence configuration files required by the examples.

   src\<example name>\config
     If an example has configuration that is required instead of the common configuration, it will 
     have its own directory. The security example uses configuration files from security\config.
    
  resource
    
    The data file used for the contacts LoaderExample: contacts.csv.

     
Build Instructions
==================
 
  Open the examples solution from the examples\dotnet\src\directory with Visual Studio.


  When installing Coherence 3.7 for the .NET Framework, the installer registers the coherence.dll library
  with the assembly registry.  When opening the Visual Studio Solutions file, the registered coherence.dll
  is discovered.  If another version of the library is desired the Coherence reference can be overridden when
  configuring the reference, be sure to set the "local copy" attribute to true.  This setting will copy and
  register the correct coherence.dll in the bin\debug directory.

  After the desired Coherence 3.6 for .NET is configured, in Visual Studio select Build->Build Solution from
  the menu, "Build Solution (F6)", etc to build the solution.

  The build for the contacts example will copy resource\contacts.csv to the build output directory
  (examples\dotnet\src\bin\Debug).


Run Instructions
=================

  Execute the run scripts. There are two parts to running the example.

  contacts example

      First, following the java readme.txt instructions, start a proxy server ("java/bin/run-proxy contacts")
      and zero or more cache servers.

      Second, from Visual Studio, start the contacts project without debugging or execute the contacts.exe produced
      from the build in a command shell. The Driver.Main method will run through the features of the example with
      the output going to the command window (stdout).

      Starting with Coherence 3.7 a new example of the new Query Language feature was integrated. This example 
      shows how configure and use a simple helper class "FilterFactory" using the Coherence InvocationService.

  security example

      First, following the java readme.txt instructions, start a proxy server ("java/bin/run-proxy security")
      and zero or more cache servers.

      Second, from Visual Studio, start the security project without debugging or execute the contacts.exe produced
      from the build in a command shell. The Driver.Main method will run through the features of the example with
      the output going to the command window (stdout).

References
==========

  Coherence:

  * Getting Started:
    http://www.oracle.com/technology/products/coherence/index.html


