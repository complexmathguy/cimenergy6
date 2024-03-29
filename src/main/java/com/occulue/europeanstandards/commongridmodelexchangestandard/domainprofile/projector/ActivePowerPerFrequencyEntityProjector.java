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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ActivePowerPerFrequency as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ActivePowerPerFrequencyAggregate
 *
 * @author your_name_here
 */
@Component("activePowerPerFrequency-entity-projector")
public class ActivePowerPerFrequencyEntityProjector {

  // core constructor
  public ActivePowerPerFrequencyEntityProjector(ActivePowerPerFrequencyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ActivePowerPerFrequency
   *
   * @param	entity ActivePowerPerFrequency
   */
  public ActivePowerPerFrequency create(ActivePowerPerFrequency entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ActivePowerPerFrequency
   *
   * @param	entity ActivePowerPerFrequency
   */
  public ActivePowerPerFrequency update(ActivePowerPerFrequency entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ActivePowerPerFrequency
   *
   * @param	id		UUID
   */
  public ActivePowerPerFrequency delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ActivePowerPerFrequency entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	ActivePowerPerFrequency
   */
  public ActivePowerPerFrequency assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    ActivePowerPerFrequency parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	ActivePowerPerFrequency
   */
  public ActivePowerPerFrequency unAssignValue(UUID parentId) {
    ActivePowerPerFrequency parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ActivePowerPerFrequency via an FindActivePowerPerFrequencyQuery
   *
   * @return query FindActivePowerPerFrequencyQuery
   */
  @SuppressWarnings("unused")
  public ActivePowerPerFrequency find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ActivePowerPerFrequency - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ActivePowerPerFrequencys
   *
   * @param query FindAllActivePowerPerFrequencyQuery
   * @return List<ActivePowerPerFrequency>
   */
  @SuppressWarnings("unused")
  public List<ActivePowerPerFrequency> findAll(FindAllActivePowerPerFrequencyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ActivePowerPerFrequency - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ActivePowerPerFrequencyRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  FloatProxyEntityProjector FloatProxyProjector;

  @Autowired
  @Qualifier(value = "externalNetworkInjection-entity-projector")
  ExternalNetworkInjectionEntityProjector ExternalNetworkInjectionProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerPerFrequencyEntityProjector.class.getName());
}
