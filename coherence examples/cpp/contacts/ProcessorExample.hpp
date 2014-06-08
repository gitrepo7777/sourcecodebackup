/*
* ProcessorExample.hpp
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
#ifndef COH_EXAMPLES_PROCESSOREXAMPLE_HPP
#define COH_EXAMPLES_PROCESSOREXAMPLE_HPP

#include "coherence/lang.ns"
#include "coherence/net/NamedCache.hpp"

COH_OPEN_NAMESPACE2(coherence,examples)

using namespace coherence::lang;
using coherence::net::NamedCache;

/**
 * ProcessorExample demonstrates how to use a processor to modify data in the
 * cache. All Contacts who live in MA, will have their work address updated.
 *
 * @author ch  2009.04.07
 */
class ProcessorExample
    {
        // ---- Constructors   ---------------------------------------------------

    public:
        virtual ~ProcessorExample() {}


        // ----- ProcessorExample methods ----------------------------------------

    public:
        ProcessorExample() {}

        /**
         * Perform the example updates to contacts.
         *
         * @param hCache  the cache
         */
        virtual void execute(NamedCache::Handle hCache) const;
    };

COH_CLOSE_NAMESPACE2

#endif  // COH_EXAMPLES_PROCESSOREXAMPLE_HPP
