package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for FloatProxy as outlined for the CQRS pattern, all write responsibilities
 * related to FloatProxy are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class FloatProxyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public FloatProxyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public FloatProxyAggregate(CreateFloatProxyCommand command) throws Exception {
    LOGGER.info("Handling command CreateFloatProxyCommand");
    CreateFloatProxyEvent event = new CreateFloatProxyEvent(command.getFloatProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateFloatProxyCommand command) throws Exception {
    LOGGER.info("handling command UpdateFloatProxyCommand");
    UpdateFloatProxyEvent event = new UpdateFloatProxyEvent(command.getFloatProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteFloatProxyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteFloatProxyCommand");
    apply(new DeleteFloatProxyEvent(command.getFloatProxyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateFloatProxyEvent event) {
    LOGGER.info("Event sourcing CreateFloatProxyEvent");
    this.floatProxyId = event.getFloatProxyId();
  }

  @EventSourcingHandler
  void on(UpdateFloatProxyEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID floatProxyId;

  private ActivePowerPerFrequency value = null;

  private static final Logger LOGGER = Logger.getLogger(FloatProxyAggregate.class.getName());
}
