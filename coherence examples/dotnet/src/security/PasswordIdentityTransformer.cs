/*
* PasswordIdentityTransformer.cs
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
using System.Collections;
using System.Security;
using System.Security.Principal;
using Tangosol.Example.Security;
using Tangosol.Net;
using Tangosol.Net.Security;

namespace Tangosol.Examples.Security
{
    /// <summary>
    /// PasswordIdentityTransformer creates a security token that contains the
    /// required password and then adds a list of role names.
    /// </summary>
    public class PasswordIdentityTransformer : IIdentityTransformer
    {
        #region IIdentityTransformer interface

        /// <summary>
        /// Transforms identity <see cref="IIdentityTransformer.TransformIdentity"/>
        /// </summary>        
        public object TransformIdentity(IPrincipal principal, IService service)
        {
            // The IService is not needed so the service argument is being ignored.
            // It could be used, for example, if there were different token types
            // required per service.
            if (principal == null)
            {
                throw new SecurityException("Incomplete Principal");
            }
            
            ArrayList asRoleName = new ArrayList();

            asRoleName.Add(Environment.GetEnvironmentVariable("coherence.password")
                           ?? "secret-password");
            asRoleName.Add(principal.Identity.Name);

            if (principal.IsInRole(SecurityExampleHelper.ROLE_ADMIN))
            {
                asRoleName.Add(SecurityExampleHelper.ROLE_ADMIN);
            }
            if (principal.IsInRole(SecurityExampleHelper.ROLE_WRITER))
            {
                asRoleName.Add(SecurityExampleHelper.ROLE_WRITER);
            }
            if (principal.IsInRole(SecurityExampleHelper.ROLE_READER))
            {
                asRoleName.Add(SecurityExampleHelper.ROLE_READER);
            }
            // The token consists of the password plus the user name plus
            // role names as an array of pof-able types, in this case strings.
            return asRoleName.ToArray();
        }

        #endregion
    }
}
