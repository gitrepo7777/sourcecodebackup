/*
* SecurityExampleHelper.hpp
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
#ifndef COH_EXAMPLES_SECURITYEXAMPLEHELPER_HPP
#define COH_EXAMPLES_SECURITYEXAMPLEHELPER_HPP

#include "coherence/lang.ns"
#include "coherence/security/auth/Subject.hpp"

COH_OPEN_NAMESPACE2(coherence,examples)

using namespace coherence::lang;

using coherence::security::auth::Subject;

/**
* This class provides helper methods for extremely simplified role based
* access control.
*
* @author dag 2010.05.03
*/
class SecurityExampleHelper
    {
    // ----- Constructors ---------------------------------------------------
    private:
        /**
        * Construct a SecurityExampleHelper
        */
        SecurityExampleHelper();


    // ----- SecurityExampleHelper methods ----------------------------------

    public:
        /**
        * Login the user.
        *
        * @param vsSubject  the user name
        *
        * @return the authenticated subject
        */
        static Subject::View login(String::View vsName);
    };

COH_CLOSE_NAMESPACE2

#endif //COH_EXAMPLES_SECURITYEXAMPLEHELPER_HPP
