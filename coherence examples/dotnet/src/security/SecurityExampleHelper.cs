/*
* SecurityExampleHelper.cs
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
*/﻿using System.Collections.Generic;
using System.Security.Principal;

namespace Tangosol.Example.Security
{
    /// <summary>
    /// This class provides helper methods for extremely simplified role based
    /// access control.
    /// </summary>
    /// <author>dag  2010.03.17</author>
    public class SecurityExampleHelper
    {
        #region constructors

        static SecurityExampleHelper()
        {
            // User to role mapping
            s_mapUserToRole["BuckarooBanzai"] = ROLE_ADMIN;    
            s_mapUserToRole["JohnWhorfin"]    = ROLE_WRITER;
            s_mapUserToRole["JohnBigboote"]   = ROLE_READER;
        }
        
        #endregion
        
        #region SecurityExampleHelper implementation
      
        /// <summary>
        /// Login the user.
        /// </summary>
        /// <param name="sName">
        /// The user name.
        /// </param>
        /// <returns>
        /// The authenticated user.
        /// </returns>
        public static IPrincipal Login(string sName)
        {
            // For simplicity, just create a Principal. Normally, this would be
            // done using authentication.
            string sUserDN = "CN=" + sName + ",OU=Yoyodyne";

            return new GenericPrincipal(new GenericIdentity(sUserDN), 
                new string[] { s_mapUserToRole[sName] });
        }

        #endregion

        #region constants

        public const string ROLE_READER = "role_reader";

        public const string ROLE_WRITER = "role_writer";

        public const string ROLE_ADMIN  = "role_admin";

        /// <summary>
        /// The cache name for security examples.
        /// </summary>
        public const string SECURITY_CACHE_NAME = "security";

        /// <summary>
        /// The name of the InvocationService used by security examples.
        /// </summary>
        public const string INVOCATION_SERVICE_NAME = "InvocationService";

        #endregion

        #region Data members

        /// <summary>
        /// The dictionary keyed by user name with the value being the user's role.
        /// Represents which user is in which role.
        /// </summary>
        private static IDictionary<string,string> s_mapUserToRole = 
            new Dictionary<string, string>();

        #endregion
    }
}
