/*
* ObserverExample.hpp
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
#ifndef COH_EXAMPLES_OBSERVEREXAMPLE_HPP
#define COH_EXAMPLES_OBSERVEREXAMPLE_HPP

#include "coherence/net/NamedCache.hpp"

#include "ContactChangeListener.hpp"

COH_OPEN_NAMESPACE2(coherence,examples)

using coherence::net::NamedCache;

/**
 * ObserverExample demonstrates how to use a MapListener to monitor cache events.
 *
 * @author ch  20094.07
 */
class ObserverExample
    {
    // ----- Constructors   -----------------------------------------------

    public:
        virtual ~ObserverExample() {}


    // ----- ObserverExample methods --------------------------------------

    public:
        /**
        * Observe changes to the contacts.
        *
        * @param hCache  target cache
        */
        virtual void observe(NamedCache::Handle hCache);

        /**
        * Stop observing changes to the contacts.
        *
        * @param hCache  target cache
        */
        virtual void remove(NamedCache::Handle hCache);


        // -----data members    ------------------------------------------

    private:
        /**
        * The MapListener observing changes
        */
        ContactChangeListener::Handle m_hListener;
    };

COH_CLOSE_NAMESPACE2

#endif //COH_EXAMPLES_OBSERVEREXAMPLE_HPP
