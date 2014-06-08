/*
* ContactChangeListener.hpp
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
#ifndef COH_EXAMPLES_CONTACTCHANGELISTENER_HPP
#define COH_EXAMPLES_CONTACTCHANGELISTENER_HPP

#include "coherence/lang.ns"
#include "coherence/util/MapEvent.hpp"
#include "coherence/util/MapListener.hpp"

COH_OPEN_NAMESPACE2(coherence,examples)

using namespace coherence::lang;
using coherence::util::MapEvent;
using coherence::util::MapListener;

/**
* ContactChangeListener listens for changes to Contacts.
*
* @author ch  2009.04.07
*/
class ContactChangeListener
    : public class_spec<ContactChangeListener,
      extends <MapListener> >
    {
    // add support for auto-generated static create methods
    friend class factory<ContactChangeListener>;


    // ----- Constructors ----------------------------------------------------

    protected:
        ContactChangeListener() {}


    // ----- MapListener interface ------------------------------------------

    public:
        /**
        * {@inheritDoc}
        */
        void entryInserted(MapEvent::View vEvent);

        /**
        * {@inheritDoc}
        */
        void entryUpdated(MapEvent::View vEvent);

        /**
        * {@inheritDoc}
        */
        void entryDeleted(MapEvent::View vEvent);
    };

COH_CLOSE_NAMESPACE2

#endif //COH_EXAMPLES_CONTACTCHANGELISTENER_HPP
