/*
* PasswordIdentityTransformer.hpp
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
#ifndef COH_EXAMPLES_PASSWORDIDENTITYTRANSFORMER_HPP
#define COH_EXAMPLES_PASSWORDIDENTITYTRANSFORMER_HPP

#include "coherence/lang.ns"

#include "coherence/net/Service.hpp"
#include "coherence/security/IdentityTransformer.hpp"
#include "coherence/security/auth/Subject.hpp"

COH_OPEN_NAMESPACE2(coherence,examples)

using coherence::net::Service;
using coherence::security::IdentityTransformer;
using coherence::security::auth::Subject;

/**
* PasswordIdentityTransformer creates a security token that contains the
* required password and then adds a list of Principal names.
*
* @author dag 2010.04.30
*/
class PasswordIdentityTransformer
    : public class_spec<PasswordIdentityTransformer,
        extends<Object>,
        implements<IdentityTransformer> >
    {
    friend class factory<PasswordIdentityTransformer>;

    // ----- IdentityTransformer interface ----------------------------------

    public:
        /**
        * {@inheritDoc}
        */
        virtual Object::View transformIdentity(Subject::View vSubject, Service::View vService) const;
    };

COH_CLOSE_NAMESPACE2

#endif //COH_EXAMPLES_PASSWORDIDENTITYTRANSFORMER_HPP
