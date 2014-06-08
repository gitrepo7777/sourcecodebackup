/*
* PasswordExample.cs
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
using Tangosol.Net;

namespace Tangosol.Example.Security
{
    public class PasswordExample
    {
        #region Methods

        public static void GetCache()
        {
            Console.WriteLine("------password example begins------");

            IPrincipal principal        = SecurityExampleHelper.Login("BuckarooBanzai");
            IPrincipal principalCurrent = Thread.CurrentPrincipal;

            try
            {
                Thread.CurrentPrincipal = principal;
                CacheFactory.GetCache(SecurityExampleHelper.SECURITY_CACHE_NAME);
                Console.WriteLine("------password example succeeded------");
            }
            catch (Exception e)
            {
                // get exception if the password is invalid
                Console.WriteLine("Unable to connect to proxy");
                Console.WriteLine(e.StackTrace);
            }
            finally
            {
                Thread.CurrentPrincipal = principalCurrent;
            }
            Console.WriteLine("------password example completed------");
        }

        #endregion
    }
}
