/*
* AccessControlExample.cs
*
* Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.
*
* Oracle is a registered trademarks of Oracle Corporation and/or its
* affiliates.
*
* This software is the confidential and proprietary information of Oracle
* Corporation. You shall not disclose such confidential and proprietary
* information and shall use it only in accordance with the terms of the
* license agreement you entered into with Oracle.
*
* This notice may not be removed or altered.
*/﻿using System;
using System.Security.Principal;
using System.Threading;
using Tangosol.Examples.Pof;
using Tangosol.Net;

namespace Tangosol.Example.Security
{
    /// <summary>
    /// This class demonstrates simplified role based access control.
    /// </summary>
    /// <remarks>
    /// The role policies are defined in SecurityExampleHelper. Enforcmenent 
    /// is done by EntitledCacheService and EntitledNamedCache configured in
    /// the proxy.
    /// </remarks>
    public class AccessControlExample
    {
        #region Methods

        /// <summary>
        /// Demonstrate role based access to the cache.
        /// </summary>
        public static void AccessCache()
        {
            Console.WriteLine("------cache access control example begins------");
            Console.WriteLine();

            // Someone with writer role can write and read
            IPrincipal principal        = SecurityExampleHelper.Login("JohnWhorfin");
            IPrincipal principalCurrent = Thread.CurrentPrincipal;

            try
            {
                Thread.CurrentPrincipal = principal;
                INamedCache cache = CacheFactory.GetCache(
                    SecurityExampleHelper.SECURITY_CACHE_NAME);

                cache["myKey"] = "myValue";
                string sValue = (string) cache["myKey"];
                Console.WriteLine();
                Console.WriteLine("    Success: read and write allowed");
                Console.WriteLine();
            }
            catch (Exception e)
            {
                // get exception if not allowed to perform the operation
                Console.WriteLine(e.StackTrace);
            }
            finally
            {
                Thread.CurrentPrincipal = principalCurrent;
            }

            // Someone with reader role can read but not write
            principal = SecurityExampleHelper.Login("JohnBigboote");

            try
            {
                Thread.CurrentPrincipal = principal;
                INamedCache cache = CacheFactory.GetCache(
                    SecurityExampleHelper.SECURITY_CACHE_NAME);
                string sValue = (string) cache["myKey"];
                Console.WriteLine();
                Console.WriteLine("    Success: read allowed");
                Console.WriteLine();
                cache["anotherKey"] = "anotherValue";
            }
            catch (Exception)
            {
                // get exception if not allowed to perform the operation
                Console.WriteLine();
                Console.WriteLine("    Success: Correctly cannot write");
                Console.WriteLine();
            }
            finally
            {
                Thread.CurrentPrincipal = principalCurrent;
            }

            // Someone with writer role cannot call destroy
            principal = SecurityExampleHelper.Login("JohnWhorfin");

            try
            {
                Thread.CurrentPrincipal = principal;
                INamedCache cache = CacheFactory.GetCache(
                    SecurityExampleHelper.SECURITY_CACHE_NAME);
                cache.Destroy();
            }
            catch (Exception)
            {
                // get exception if not allowed to perform the operation
                Console.WriteLine();
                Console.WriteLine("    Success: Correctly cannot destroy the cache");
                Console.WriteLine();
            }
            finally
            {
                Thread.CurrentPrincipal = principalCurrent;
            }

            // Someone with admin role can call destroy
            principal = SecurityExampleHelper.Login("BuckarooBanzai");

            try
            {
                Thread.CurrentPrincipal = principal;
                INamedCache cache = CacheFactory.GetCache(
                    SecurityExampleHelper.SECURITY_CACHE_NAME);
                cache.Destroy();
                Console.WriteLine();
                Console.WriteLine("    Success: Correctly allowed to destroy the cache");
                Console.WriteLine();
            }
            catch (Exception e)
            {
                // get exception if not allowed to perform the operation
                Console.WriteLine(e.StackTrace);
            }
            finally
            {
                Thread.CurrentPrincipal = principalCurrent;
            }
            Console.WriteLine();
            Console.WriteLine("------cache access control example completed------");
            Console.WriteLine();
        }

        public static void AccessInvocationService()
        {
            Console.WriteLine("------InvocationService access control example " +
                "begins------");
            Console.WriteLine();

            // Someone with writer role can run invocables
            IPrincipal principal = SecurityExampleHelper.Login("JohnWhorfin");

            try
            {
                Thread.CurrentPrincipal = principal;
                IInvocationService service = (IInvocationService) 
                    CacheFactory.GetService(SecurityExampleHelper.INVOCATION_SERVICE_NAME);

                service.Query(new ExampleInvocable(), null);
                Console.WriteLine();
                Console.WriteLine("    Success: Correctly allowed to " +
                    "use the invocation service");
                Console.WriteLine();
            }
            catch (Exception e)
            {
                // get exception if not allowed to perform the operation
                Console.WriteLine(e.StackTrace);
            }

            // Someone with reader role cannot cannot run invocables
            principal = SecurityExampleHelper.Login("JohnBigboote");

            try
            {
                Thread.CurrentPrincipal = principal;
                IInvocationService service = (IInvocationService)
                    CacheFactory.GetService(SecurityExampleHelper.INVOCATION_SERVICE_NAME);

                service.Query(new ExampleInvocable(), null);
            }
            catch (Exception e)
            {
                // get exception if not allowed to perform the operation
                Console.WriteLine();
                Console.WriteLine("    Success: Correctly unable to " +
                    "use the invocation service");
                Console.WriteLine();
            }

            Console.WriteLine();
            Console.WriteLine("------InvocationService access control example " +
                "completed------");
        }

        #endregion
    }
}
