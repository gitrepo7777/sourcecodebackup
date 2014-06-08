/*
* AccessControlExample.hpp
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
*/
#ifndef COH_EXAMPLES_ACCESSCONTROLEXAMPLE_HPP
#define COH_EXAMPLES_ACCESSCONTROLEXAMPLE_HPP

#include "coherence/lang.ns"

COH_OPEN_NAMESPACE2(coherence,examples)

using namespace coherence::lang;

/**
* This class demonstrates simplified role based access control.
* <p>
* The role policies are defined in SecurityExampleHelper. Enforcement
* is done by EntitledCacheService and EntitledNamedCache on the proxy.
*
* @author dag 2010.05.04
*/
class AccessControlExample
    {
    // ----- AccessControlExample methods -----------------------------------

    public:
        /**
        * Demonstrate role based access to the cache.
        */
        virtual void accessCache();

        /**
        * Demonstrate role based access to the invocation service.
        */
        virtual void accessInvocationService();

        virtual ~AccessControlExample() {}
    };

COH_CLOSE_NAMESPACE2

#endif //COH_EXAMPLES_ACCESSCONTROLEXAMPLE_HPP
