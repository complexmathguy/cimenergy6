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
 * Projector for RotationSpeed as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RotationSpeedAggregate
 *
 * @author your_name_here
 */
@Component("rotationSpeed-entity-projector")
public class RotationSpeedEntityProjector {

  // core constructor
  public RotationSpeedEntityProjector(RotationSpeedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RotationSpeed
   *
   * @param	entity RotationSpeed
   */
  public RotationSpeed create(RotationSpeed entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RotationSpeed
   *
   * @param	entity RotationSpeed
   */
  public RotationSpeed update(RotationSpeed entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RotationSpeed
   *
   * @param	id		UUID
   */
  public RotationSpeed delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RotationSpeed entity = repository.findById(id).get();

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
   * @return	RotationSpeed
   */
  public RotationSpeed assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    RotationSpeed parentEntity = repository.findById(parentId).get();
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
   * @return	RotationSpeed
   */
  public RotationSpeed unAssignValue(UUID parentId) {
    RotationSpeed parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the RotationSpeed via an FindRotationSpeedQuery
   *
   * @return query FindRotationSpeedQuery
   */
  @SuppressWarnings("unused")
  public RotationSpeed find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RotationSpeed - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RotationSpeeds
   *
   * @param query FindAllRotationSpeedQuery
   * @return List<RotationSpeed>
   */
  @SuppressWarnings("unused")
  public List<RotationSpeed> findAll(FindAllRotationSpeedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RotationSpeed - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RotationSpeedRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  FloatProxyEntityProjector FloatProxyProjector;

  @Autowired
  @Qualifier(value = "asynchronousMachine-entity-projector")
  AsynchronousMachineEntityProjector AsynchronousMachineProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RotationSpeedEntityProjector.class.getName());
}
