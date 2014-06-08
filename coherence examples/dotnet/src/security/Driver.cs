/*
* Driver.cs
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
using System.Collections.Generic;
using System.Text;
using Tangosol.Example.Security;

namespace Tangosol.Examples.Security
{
    /// <summary>
    /// Driver executes all the security examples.
    /// </summary>
    /// <remarks>
    /// Examples are invoked in this order:
    /// 1) Password enforcement
    /// 2) Cache access control
    /// 3) InvocationService access control
    /// </remarks>
    public static class Driver
    {
        #region Methods

        /// <summary>
        /// Execute all security examples.
        /// </summary>
        /// <param name="asArg"></param>
        public static void Main(string[] asArg)
        {
            Console.WriteLine("------security examples begin------");
            
            // Run password example
            PasswordExample.GetCache();

            // Run cache access control example
            AccessControlExample.AccessCache();

            // Run invocation service access control example
            AccessControlExample.AccessInvocationService();

            Console.WriteLine("------security examples completed------");
        }

        #endregion
    }
}
