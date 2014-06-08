/*
* BasicExample.hpp
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
#ifndef COH_EXAMPLES_BASICEXAMPLE_HPP
#define COH_EXAMPLES_BASICEXAMPLE_HPP

#include "coherence/lang.ns"
#include "coherence/net/NamedCache.hpp"

#include "Contacts.hpp"

COH_OPEN_NAMESPACE2(coherence,examples)

using namespace coherence::lang;
using coherence::net::NamedCache;

/**
* BasicExample shows basic cache operations like adding, getting and removing
* data.
*
* @author ch  2009.04.03
*/
class BasicExample
    {
        // ----- Constructors ----------------------------------------------------

    public:
        BasicExample() {}

        virtual ~BasicExample() {}


        // ----- BasicExample methods --------------------------------------------

    public:
        /**
        * Execute a cycle of basic operations.
        *
        * @param cache  target cache
        */
        virtual void execute(NamedCache::Handle hCache);

    protected:

        virtual Contact generateContact() const;
    };

COH_CLOSE_NAMESPACE2

#endif //COH_EXAMPLES_BASICEXAMPLE_HPP
