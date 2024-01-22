/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for SubGeographicalRegion related events. .
 *
 * @author your_name_here
 */
@Component("subGeographicalRegion-subscriber")
public class SubGeographicalRegionSubscriber extends BaseSubscriber {

  public SubGeographicalRegionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SubGeographicalRegion>, SubGeographicalRegion>
      subGeographicalRegionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSubGeographicalRegionQuery(),
        ResponseTypes.multipleInstancesOf(SubGeographicalRegion.class),
        ResponseTypes.instanceOf(SubGeographicalRegion.class));
  }

  public SubscriptionQueryResult<SubGeographicalRegion, SubGeographicalRegion>
      subGeographicalRegionSubscribe(@DestinationVariable UUID subGeographicalRegionId) {
    return queryGateway.subscriptionQuery(
        new FindSubGeographicalRegionQuery(
            new LoadSubGeographicalRegionFilter(subGeographicalRegionId)),
        ResponseTypes.instanceOf(SubGeographicalRegion.class),
        ResponseTypes.instanceOf(SubGeographicalRegion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
